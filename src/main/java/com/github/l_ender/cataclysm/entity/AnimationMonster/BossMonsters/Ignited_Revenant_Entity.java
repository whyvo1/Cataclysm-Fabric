package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AnimationMonster.AI.AttackMoveGoal;
import com.github.l_ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.l_ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.entity.projectile.Ashen_Breath_Entity;
import com.github.l_ender.cataclysm.entity.projectile.Blazing_Bone_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import java.util.EnumSet;


public class Ignited_Revenant_Entity extends LLibrary_Boss_Monster {

    public static final Animation ASH_BREATH_ATTACK = Animation.create(53);
    public static final Animation BONE_STORM_ATTACK = Animation.create(49);
    public static final int BREATH_COOLDOWN = 200;
    public static final int STORM_COOLDOWN = 200;
    private float allowedHeightOffset = 0.5F;
    private int nextHeightOffsetChangeTick;
    private static final TrackedData<Boolean> ANGER = DataTracker.registerData(Ignited_Revenant_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> SHIELD_DURABILITY = DataTracker.registerData(Ignited_Revenant_Entity.class, TrackedDataHandlerRegistry.INTEGER);

    public float angerProgress;
    public float prevangerProgress;
    private int breath_cooldown = 0;
    private int storm_cooldown = 0;


    public Ignited_Revenant_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 25;
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
        setConfigattribute(this, CMConfig.RevenantHealthMultiplier, CMConfig.RevenantDamageMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{
                NO_ANIMATION,
                ASH_BREATH_ATTACK,
                BONE_STORM_ATTACK};
    }

    protected void initGoals() {
        this.goalSelector.add(2, new Ignited_Revenant_Goal());
        this.goalSelector.add(0, new BoneStormGoal(this, BONE_STORM_ATTACK));
        this.goalSelector.add(0, new ShootGoal(this, ASH_BREATH_ATTACK));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder ignited_revenant() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 80)
                .add(EntityAttributes.GENERIC_ARMOR, 12)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.5F)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
    }

    protected int getNextAirUnderwater(int air) {
        return air;
    }






    @Override
    public ItemEntity dropStack(ItemStack stack) {
        ItemEntity itementity = this.dropStack(stack,0.0f);
        if (itementity != null) {
            itementity.setGlowing(true);
            itementity.setCovetedItem();
        }
        return itementity;
    }


    @Override
    public boolean damage(DamageSource source, float damage) {
        Entity entity = source.getSource();
        if (!this.getWorld().isClient) {
            if(this.getIsAnger()) {
                if (entity instanceof LivingEntity living) {
                    // Shield disabling on critical axe hit
                    ItemStack itemstack = living.getMainHandStack();

                    if (itemstack.getItem() instanceof AxeItem) {
                        double itemDamage = this.getApproximateAttackDamageWithItem(living,itemstack) + 1;
                        if (damage >= itemDamage + (itemDamage / 2)) {
                            if (this.getShieldDurability() < 4) {
                                this.playSound(SoundEvents.ENTITY_WITHER_BREAK_BLOCK, 1.0F, 1.5F);
                                this.setShieldDurability(this.getShieldDurability() + 1);
                                return false;
                            }
                        }
                    }
                }
            }
        }
        if (damage > 0.0F && canBlockDamageSource(source)) {
            this.damageShield(damage);
            if (!source.isIn(DamageTypeTags.IS_PROJECTILE)) {
                if (entity instanceof LivingEntity) {
                    this.takeShieldHit((LivingEntity) entity);
                }
            }
            this.playSound(SoundEvents.BLOCK_ANVIL_PLACE, 0.3F, 0.5F);
            return false;
        }
        return super.damage(source, damage);
    }


    private double getApproximateAttackDamageWithItem(LivingEntity living, ItemStack p_330413_) {
        AttributeModifiersComponent itemattributemodifiers = p_330413_.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT);
//
//        // Neo: Respect gameplay modifiers
//        itemattributemodifiers = p_330413_.getD;

        return itemattributemodifiers.applyOperations(p_330413_.getDamage(), EquipmentSlot.MAINHAND);
    }


    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        Entity entity = damageSourceIn.getSource();
        boolean flag = false;
        if (entity instanceof PersistentProjectileEntity) {
           PersistentProjectileEntity abstractarrowentity = (PersistentProjectileEntity) entity;
           if (abstractarrowentity.getPierceLevel() > 0) {
               flag = true;
          }
        }
        if (!damageSourceIn.isIn(DamageTypeTags.BYPASSES_SHIELD)&& !flag && this.getIsAnger() && this.getShieldDurability() < 4) {
            Vec3d vector3d2 = damageSourceIn.getPosition();
            if (vector3d2 != null) {
                Vec3d vector3d = this.getRotationVec(1.0F);
                Vec3d vector3d1 = vector3d2.relativize(this.getPos()).normalize();
                vector3d1 = new Vec3d(vector3d1.x, 0.0D, vector3d1.z);
                return vector3d1.dotProduct(vector3d) < 0.0D;
            }
        }
        return false;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
        p_326229_.add(ANGER, false);
        p_326229_.add(SHIELD_DURABILITY, 0);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
    }

    public void setIsAnger(boolean isAnger) {
        this.dataTracker.set(ANGER, isAnger);
    }

    public boolean getIsAnger() {
        return this.dataTracker.get(ANGER);
    }

    public void setShieldDurability(int ShieldDurability) {
        this.dataTracker.set(SHIELD_DURABILITY, ShieldDurability);
    }

    public int getShieldDurability() {
        return this.dataTracker.get(SHIELD_DURABILITY);
    }

    public void tick() {
        super.tick();
       // setYRot(yBodyRot);
        LivingEntity target = this.getTarget();
        if (!this.isOnGround() && this.getVelocity().y < 0.0D) {
            this.setVelocity(this.getVelocity().multiply(1.0D, 0.6D, 1.0D));
        }
        prevangerProgress = angerProgress;
        if (this.getIsAnger() && angerProgress < 5F) {
            angerProgress++;
        }
        if (!this.getIsAnger() && angerProgress > 0F) {
            angerProgress--;
        }
        if (breath_cooldown > 0) breath_cooldown--;
        if (storm_cooldown > 0) storm_cooldown--;
        if (this.isAlive()) {
            if (target != null && target.isAlive()) {
                if (breath_cooldown <= 0 && !isAiDisabled() && this.getAnimation() == NO_ANIMATION && (this.random.nextInt(35) == 0 && this.distanceTo(target) < 4.5F) && this.getShieldDurability() < 4) {
                    breath_cooldown = BREATH_COOLDOWN;
                    this.setAnimation(ASH_BREATH_ATTACK);
                } else if (storm_cooldown <= 0 && this.distanceTo(target) < 6 && !isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.random.nextInt(15) == 0) {
                    storm_cooldown = STORM_COOLDOWN;
                    this.setAnimation(BONE_STORM_ATTACK);
                }else if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && (this.random.nextInt(12) == 0 && this.distanceTo(target) < 4.5F) && this.getShieldDurability() > 3) {
                    this.setAnimation(ASH_BREATH_ATTACK);
                }
            }
            if(this.getAnimation() == NO_ANIMATION && this.getIsAnger() && this.getShieldDurability() < 4){
                if(this.age % (6 + this.getShieldDurability() * 2) == 0){
                    for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(1.25D))) {
                        if (!isTeammate(entity) && !(entity instanceof Ignited_Revenant_Entity) && entity != this) {
                            boolean flag = entity.damage(this.getDamageSources().mobAttack(this), (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE));
                            if (flag) {
                                double d0 = entity.getX() - this.getX();
                                double d1 = entity.getZ() - this.getZ();
                                double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                                entity.addVelocity(d0 / d2 * 1.5D, 0.2D, d1 / d2 * 1.5D);
                            }
                        }
                    }
                }
            }
        }

    }

    public boolean isTeammate(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isTeammate(entityIn)) {
            return true;
        } else if (entityIn.getType().isIn(ModTag.TEAM_IGNIS)) {
            return this.getScoreboardTeam() == null && entityIn.getScoreboardTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.REVENANT_IDLE;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.REVENANT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.REVENANT_DEATH;
    }


    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();

    }


    @Override
    protected BodyControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected EntityNavigation createNavigation(World worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    class Ignited_Revenant_Goal extends AttackMoveGoal {

        public Ignited_Revenant_Goal() {
            super(Ignited_Revenant_Entity.this, true, 1.1);
        }

        @Override
        public void start() {
            super.start();
            Ignited_Revenant_Entity.this.setIsAnger(true);

        }

        @Override
        public void stop() {
            super.stop();
            Ignited_Revenant_Entity.this.setIsAnger(false);
        }
    }

    class ShootGoal extends SimpleAnimationGoal<Ignited_Revenant_Entity> {

        public ShootGoal(Ignited_Revenant_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
        }

        @Override
        public void start() {
            super.start();
            Ignited_Revenant_Entity.this.setIsAnger(true);

        }

        @Override
        public void stop() {
            super.stop();
            Ignited_Revenant_Entity.this.setIsAnger(false);
        }

        public void tick() {
            LivingEntity target = Ignited_Revenant_Entity.this.getTarget();

            if (target != null) {
                if (Ignited_Revenant_Entity.this.getAnimationTick() < 27) {
                    Ignited_Revenant_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                }else{
                    Ignited_Revenant_Entity.this.getLookControl().lookAt(target, 3.0F, 30.0F);
                }
            }

            if (Ignited_Revenant_Entity.this.getAnimationTick() == 21) {
                Ignited_Revenant_Entity.this.playSound(ModSounds.REVENANT_BREATH, 1.0f, 1.0f);

            }

            Vec3d mouthPos = new Vec3d(0, 2.3, 0);
            mouthPos = mouthPos.rotateY((float) Math.toRadians(-getYaw() - 90));
            mouthPos = mouthPos.add(getPos());
            mouthPos = mouthPos.add(new Vec3d(0, 0, 0).rotateX((float) Math.toRadians(-getPitch())).rotateY((float) Math.toRadians(-headYaw)));
            Ashen_Breath_Entity breath = new Ashen_Breath_Entity(ModEntities.ASHEN_BREATH, Ignited_Revenant_Entity.this.getWorld(), (float) CMConfig.Ashenbreathdamage,Ignited_Revenant_Entity.this);
            if (Ignited_Revenant_Entity.this.getAnimationTick() == 27) {
                breath.updatePositionAndAngles(mouthPos.x, mouthPos.y, mouthPos.z, Ignited_Revenant_Entity.this.headYaw, Ignited_Revenant_Entity.this.getPitch());
                Ignited_Revenant_Entity.this.getWorld().spawnEntity(breath);
            }
        }
    }

    class BoneStormGoal extends SimpleAnimationGoal<Ignited_Revenant_Entity> {

        public BoneStormGoal(Ignited_Revenant_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
        }

        public void tick() {
            LivingEntity target = entity.getTarget();

            if (target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
            }
            if (entity.getAnimationTick() == 5) {
                switch (random.nextInt(3)) {
                    case 0 -> launchbone1();
                    case 1 -> launchbone2();
                    case 2 -> launchbone3();
                    default -> {
                    }
                }

            }
            if(entity.getAnimationTick() == 10){
                    switch (random.nextInt(3)) {
                        case 0 -> launchbone1();
                        case 1 -> launchbone2();
                        case 2 -> launchbone3();
                        default -> {
                        }
                    }
                }
            if(entity.getAnimationTick() == 15){
                switch (random.nextInt(3)) {
                    case 0 -> launchbone1();
                    case 1 -> launchbone2();
                    case 2 -> launchbone3();
                    default -> {
                    }
                }
            }
            if(entity.getAnimationTick() == 20){
                switch (random.nextInt(3)) {
                    case 0 -> launchbone1();
                    case 1 -> launchbone2();
                    case 2 -> launchbone3();
                    default -> {
                    }
                }
            }
            --entity.nextHeightOffsetChangeTick;
            if (entity.nextHeightOffsetChangeTick <= 0) {
                entity.nextHeightOffsetChangeTick = 100;
                entity.allowedHeightOffset = (float)entity.random.nextTriangular(0.5D, 6.891D);
            }

            if (target != null && target.getEyeY() > entity.getEyeY() + (double)entity.allowedHeightOffset && entity.canTarget(target)) {
                Vec3d vec3 = entity.getVelocity();
                entity.setVelocity(entity.getVelocity().add(0.0D, ((double)0.3F - vec3.y) * (double)0.3F, 0.0D));
                entity.velocityDirty = true;
            }

        }
    }

    private void launchbone1() {
        this.playSound(SoundEvents.ENTITY_DROWNED_SHOOT, 1F, 0.75f);
        for (int i = 0; i < 8; i++) {
            float yawRadians = (float) (Math.toRadians(90 + this.getYaw()));
            float throwAngle = yawRadians + i * MathHelper.PI / 4F;

            double sx = this.getX() + (MathHelper.cos(throwAngle) * 1);
            double sy = this.getY() + (this.getHeight() * 0.62D);
            double sz = this.getZ() + (MathHelper.sin(throwAngle) * 1);

            double vx = MathHelper.cos(throwAngle);
            double vy = 0;
            double vz = MathHelper.sin(throwAngle);

            Blazing_Bone_Entity projectile = new Blazing_Bone_Entity(this.getWorld(), (float) CMConfig.BlazingBonedamage,this);

            projectile.refreshPositionAndAngles(sx, sy, sz, i * 45F, this.getPitch());
            float speed = 0.5F;
            projectile.setVelocity(vx, vy, vz, speed, 1.0F);
            this.getWorld().spawnEntity(projectile);
        }

    }

    private void launchbone2() {
        this.playSound(SoundEvents.ENTITY_DROWNED_SHOOT, 1F, 0.75f);
        for (int i = 0; i < 6; i++) {
            float yawRadians = (float) (Math.toRadians(90 + this.getYaw()));
            float throwAngle = yawRadians +  i * MathHelper.PI / 3F;

            double sx = this.getX() + (MathHelper.cos(throwAngle) * 1);
            double sy = this.getY() + (this.getHeight() * 0.62D);
            double sz = this.getZ() + (MathHelper.sin(throwAngle) * 1);

            double vx = MathHelper.cos(throwAngle);
            double vy = 0;
            double vz = MathHelper.sin(throwAngle);

            Blazing_Bone_Entity projectile = new Blazing_Bone_Entity(this.getWorld(), (float) CMConfig.BlazingBonedamage,this);

            projectile.refreshPositionAndAngles(sx, sy, sz, i * 60F, this.getPitch());
            float speed = 0.6F;
            projectile.setVelocity(vx, vy, vz, speed, 1.0F);
            this.getWorld().spawnEntity(projectile);
        }

    }

    private void launchbone3() {
        this.playSound(SoundEvents.ENTITY_DROWNED_SHOOT, 1F, 0.75f);
        for (int i = 0; i < 10; i++) {
            float yawRadians = (float) (Math.toRadians(90 + this.getYaw()));
            float throwAngle = yawRadians + i * MathHelper.PI / 5F;

            double sx = this.getX() + (MathHelper.cos(throwAngle) * 1);
            double sy = this.getY() + (this.getHeight() * 0.62D);
            double sz = this.getZ() + (MathHelper.sin(throwAngle) * 1);

            double vx = MathHelper.cos(throwAngle);
            double vy = 0;
            double vz = MathHelper.sin(throwAngle);

            Blazing_Bone_Entity projectile = new Blazing_Bone_Entity(this.getWorld(), (float) CMConfig.BlazingBonedamage,this);

            projectile.refreshPositionAndAngles(sx, sy, sz, i * 36F, this.getPitch());
            float speed = 0.4F;
            projectile.setVelocity(vx, vy, vz, speed, 1.0F);
            this.getWorld().spawnEntity(projectile);
        }

    }


}





