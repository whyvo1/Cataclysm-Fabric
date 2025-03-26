package com.github.l_ender.cataclysm.entity.Pet;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AI.EntityAINearestTarget3D;
import com.github.l_ender.cataclysm.entity.AI.MobAIFindWater;
import com.github.l_ender.cataclysm.entity.AI.MobAILeaveWater;
import com.github.l_ender.cataclysm.entity.AI.SemiAquaticAIRandomSwimming;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Blast_Entity;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Portal_Abyss_Blast_Entity;
import com.github.l_ender.cataclysm.entity.Pet.AI.PetSimpleAnimationGoal;
import com.github.l_ender.cataclysm.entity.Pet.AI.TameableAIFollowOwnerWater;
import com.github.l_ender.cataclysm.entity.etc.path.GroundPathNavigatorWide;
import com.github.l_ender.cataclysm.entity.etc.ISemiAquatic;
import com.github.l_ender.cataclysm.entity.etc.path.SemiAquaticPathNavigator;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.entity.projectile.Mini_Abyss_Blast_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.AnimationHandler;
import net.minecraft.entity.Bucketable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.AttackWithOwnerGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.TrackOwnerAttackerGoal;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

public class The_Baby_Leviathan_Entity extends LLibraryAnimationPet implements ISemiAquatic, Bucketable {
    private static final TrackedData<Boolean> FROM_BUCKET = DataTracker.registerData(The_Baby_Leviathan_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public static final Animation BABY_LEVIATHAN_BITE = Animation.create(14);
    public static final Animation BABY_LEVIATHAN_ABYSS_BLAST = Animation.create(157);
    public float sitProgress;
    public float prevSitProgress;
    public float SwimProgress;
    public float prevSwimProgress;
    private int fishFeedings;
    private boolean isLandNavigator;
    private AttackMode mode = AttackMode.CIRCLE;
    private int blast_cooldown = 0;
    public static final int BLAST_HUNTING_COOLDOWN = 100;
    public double endPosX, endPosY, endPosZ;
    public double collidePosX, collidePosY, collidePosZ;

    public The_Baby_Leviathan_Entity(EntityType type, World world) {
        super(type, world);
        this.experiencePoints = 0;
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER_BORDER, 0.0F);
        switchNavigator(false);
        setConfigattribute(this, CMConfig.BabyLeviathanHealthMultiplier, CMConfig.BabyLeviathanDamageMultiplier);
        this.setStepHeight(1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.LEVIATHAN_IDLE;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.LEVIATHAN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.LEVIATHAN_DEFEAT;
    }

    @Override
    public float getSoundPitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 2.0F;
    }

    public boolean damage(DamageSource source, float amount) {
        Entity entity = source.getSource();
        if (entity instanceof Mini_Abyss_Blast_Entity || entity instanceof Abyss_Blast_Entity || entity instanceof Portal_Abyss_Blast_Entity) {
            return false;
        }
        return super.damage(source, amount);
    }


    public static DefaultAttributeContainer.Builder babyleviathan() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 120.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5D)
                .add(EntityAttributes.GENERIC_ARMOR, 5D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2F);
    }

    public EntityGroup getGroup() {
        return EntityGroup.AQUATIC;
    }

    protected void initGoals() {
        this.goalSelector.add(1, new SitGoal(this));
        this.goalSelector.add(2, new TameableAIFollowOwnerWater(this, 1.3D, 4.0F, 2.0F, true));
        this.goalSelector.add(3, new BabyLeviathanAttackGoal(this));
        this.goalSelector.add(0, new BabyLeviathanBiteAttackGoal(this, BABY_LEVIATHAN_BITE));
        this.goalSelector.add(0, new BabyLeviathanBlastAttackGoal(this, BABY_LEVIATHAN_ABYSS_BLAST));
        this.goalSelector.add(4, new MobAIFindWater(this, 1.0f));
        this.goalSelector.add(4, new MobAILeaveWater(this));
        this.goalSelector.add(6, new TemptGoal(this, 1.0D, Ingredient.ofItems(Items.TROPICAL_FISH), false));
        this.goalSelector.add(7, new SemiAquaticAIRandomSwimming(this, 1.0D, 30));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, new EntityAINearestTarget3D(this, LivingEntity.class, 120, false, true, ModEntities.buildPredicateFromTag(ModTag.BABY_LEVIATHAN_TARGET)) {
            public boolean canStart() {
                return The_Baby_Leviathan_Entity.this.getCommand() != 2 && !The_Baby_Leviathan_Entity.this.isSitting() && super.canStart();
            }
        });
        this.targetSelector.add(4, new RevengeGoal(this));
    }

    private void switchNavigator(boolean onLand) {
        if (onLand) {
            this.moveControl = new MoveControl(this);
            this.navigation = new GroundPathNavigatorWide(this, getWorld());
            this.isLandNavigator = true;
        } else {
            this.moveControl = new BabyLeviathanMoveController(this, 3F, 1F, 10f);
            this.navigation = new SemiAquaticPathNavigator(this, getWorld());
            this.isLandNavigator = false;
        }
    }

    public void travel(Vec3d travelVector) {
        if (this.isSitting()) {
            if (this.getNavigation().getCurrentPath() != null) {
                this.getNavigation().stop();
            }
            travelVector = Vec3d.ZERO;
            super.travel(travelVector);
            return;
        }
        if (this.canMoveVoluntarily() && this.isTouchingWater()) {
            this.updateVelocity(this.getMovementSpeed(), travelVector);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9D));
            if (this.getTarget() == null && this.getAnimation() == NO_ANIMATION) {
                this.setVelocity(this.getVelocity().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(travelVector);
        }
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.isOf(DamageTypes.IN_WALL) || source.isOf(DamageTypes.FALLING_BLOCK) || super.isInvulnerableTo(source);
    }

    public boolean canBreatheInWater() {
        return true;
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(FROM_BUCKET, false);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putBoolean("FromBucket", this.isFromBucket());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.setFromBucket(compound.getBoolean("FromBucket"));
    }

    @Override
    public boolean isFromBucket() {
        return this.dataTracker.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean sit) {
        this.dataTracker.set(FROM_BUCKET, sit);
    }

    @Override
    public void copyDataToStack(@NotNull ItemStack bucket) {
        NbtCompound platTag = new NbtCompound();
        this.writeCustomDataToNbt(platTag);
        NbtCompound compound = bucket.getOrCreateNbt();
        Bucketable.copyDataToStack(this, bucket);
        compound.put("BabyLeviathanData", platTag);

    }

    @Override
    public void copyDataFromNbt(NbtCompound p_148832_) {
        Bucketable.copyDataFromNbt(this, p_148832_);
        if (p_148832_.contains("BabyLeviathanData")) {
            this.readCustomDataFromNbt(p_148832_.getCompound("BabyLeviathanData"));
        }
    }

    @Override
    @NotNull
    public ItemStack getBucketItem() {
        return new ItemStack(ModItems.THE_BABY_LEVIATHAN_BUCKET);
    }

    @Override
    public SoundEvent getBucketFillSound() {
        return SoundEvents.ITEM_BUCKET_FILL_FISH;
    }


    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        Item item = itemstack.getItem();
        ActionResult type = super.interactMob(player, hand);
        if (!isTamed() && item == Items.TROPICAL_FISH) {
            this.eat(player, hand, itemstack);
            this.emitGameEvent(GameEvent.EAT);
            fishFeedings++;
            if ((fishFeedings > 10 && getRandom().nextInt(6) == 0 || fishFeedings > 30)) {
                this.setOwner(player);
                this.getWorld().sendEntityStatus(this, (byte) 7);
            } else {
                this.getWorld().sendEntityStatus(this, (byte) 6);
            }
            return ActionResult.SUCCESS;
        }
        if (isTamed() && itemstack.isIn(ItemTags.FISHES)) {
            if (this.getHealth() < this.getMaxHealth()) {
                this.eat(player, hand, itemstack);
                this.emitGameEvent(GameEvent.EAT);
                this.heal(5);
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;

        }
        if (isTamed()) {
            Optional<ActionResult> result = Bucketable.tryBucket(player, hand, this);
            if (result.isPresent()) {
                return result.get();
            }
        }
        ActionResult interactionresult = itemstack.useOnEntity(player, this, hand);
        if (interactionresult != ActionResult.SUCCESS && type != ActionResult.SUCCESS && isTamed() && isOwner(player)) {
            if (!player.isSneaking()) {
                this.setCommand(this.getCommand() + 1);
                if (this.getCommand() == 3) {
                    this.setCommand(0);
                }
                player.sendMessage(Text.translatable("entity.cataclysm.all.command_" + this.getCommand(), this.getName()), true);
                boolean sit = this.getCommand() == 2;
                if (sit) {
                    this.setSitting(true);
                    return ActionResult.SUCCESS;
                } else {
                    this.setSitting(false);
                    return ActionResult.SUCCESS;
                }
            }
        }
        return type;
    }

    public void tickMovement() {
        super.tickMovement();
        if (this.isSitting() && this.getNavigation().isIdle()) {
            this.getNavigation().stop();
        }
        boolean swim = this.isTouchingWater();
        this.prevSwimProgress = SwimProgress;
        this.prevSitProgress = sitProgress;
        if(SwimProgress < 5F && swim){
            SwimProgress++;
        }
        if(SwimProgress > 0 && !swim){
            SwimProgress--;
        }
        if (this.isSitting() && sitProgress < 5) {
            this.sitProgress ++;
        }
        if (!this.isSitting() && sitProgress > 0) {
            this.sitProgress --;
        }

        if (this.isTouchingWater() && this.isLandNavigator) {
            switchNavigator(false);
        }
        if (!this.isTouchingWater() && !this.isLandNavigator) {
            switchNavigator(true);
        }

        if (blast_cooldown > 0) {
            blast_cooldown--;
        }

        AnimationHandler.INSTANCE.updateAnimations(this);
        if (this.getAnimation() == BABY_LEVIATHAN_BITE) {
            if (this.getAnimationTick() == 7) {
                this.playSound(ModSounds.LEVIATHAN_BITE, 0.5f, 2.0f);
            }
            if (this.getAnimationTick() == 9) {
                biteattack(1.5f, 0.5, 0.5, 0.5);
            }
        }
    }

    private void biteattack(float radius, double inflateX, double inflateY, double inflateZ) {
        double renderYaw = (this.headYaw + 90) * Math.PI / 180.0d;
        double renderPitch = (float) (-this.getPitch() * Math.PI / 180.0d);

        endPosX = getX() + radius * Math.cos(renderYaw) * Math.cos(renderPitch);
        endPosZ = getZ() + radius * Math.sin(renderYaw) * Math.cos(renderPitch);
        endPosY = getY() + radius * Math.sin(renderPitch);
        if (!getWorld().isClient) {
            List<LivingEntity> hit = raytraceEntities(getWorld(), inflateX, inflateY, inflateZ, new Vec3d(getX(), getY(), getZ()), new Vec3d(endPosX, endPosY, endPosZ)).entities;
            for (LivingEntity target : hit) {
                if (!isTeammate(target) && !(target instanceof The_Baby_Leviathan_Entity) && target != this) {
                    target.damage(getDamageSources().mobAttack(this), (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE));
                }
            }
        }
    }

    private BiteHitResult raytraceEntities(World world, double inflateX, double inflateY, double inflateZ, Vec3d from, Vec3d to) {
        BiteHitResult result = new BiteHitResult();
        collidePosX = endPosX;
        collidePosY = endPosY;
        collidePosZ = endPosZ;

        List<LivingEntity> entities = world.getNonSpectatingEntities(LivingEntity.class, new Box(Math.min(getX(), collidePosX), Math.min(getY(), collidePosY), Math.min(getZ(), collidePosZ), Math.max(getX(), collidePosX), Math.max(getY(), collidePosY), Math.max(getZ(), collidePosZ)).expand(inflateX, inflateY, inflateZ));
        for (LivingEntity entity : entities) {
            float pad = 2.5f;
            Box aabb = entity.getBoundingBox().expand(pad, pad, pad);
            Optional<Vec3d> hit = aabb.raycast(from, to);
            if (aabb.contains(from)) {
                result.addEntityHit(entity);
            } else if (hit.isPresent()) {
                result.addEntityHit(entity);
            }
        }
        return result;
    }

    public static class BiteHitResult {
        private final List<LivingEntity> entities = new ArrayList<>();


        public void addEntityHit(LivingEntity entity) {
            entities.add(entity);
        }
    }

    @Override
    protected BodyControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    public boolean isTeammate(Entity entityIn) {
        if (this.isTamed()) {
            LivingEntity livingentity = this.getOwner();
            if (entityIn == livingentity) {
                return true;
            }
            if (entityIn instanceof TameableEntity) {
                return ((TameableEntity) entityIn).isOwner(livingentity);
            }
            if (livingentity != null) {
                return livingentity.isTeammate(entityIn);
            }
        }

        return super.isTeammate(entityIn);
    }


    public boolean isPushedByFluids() {
        return false;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld serverWorld, PassiveEntity ageableEntity) {
        return null;
    }

    @Override
    public boolean shouldEnterWater() {
        return !this.isSitting();
    }

    @Override
    public boolean shouldLeaveWater() {
        return false;
    }

    @Override
    public boolean shouldStopMoving() {
        return isSitting();
    }

    @Override
    public int getWaterSearchRange() {
        return 32;
    }

    @Override
    public boolean shouldFollow() {
        return this.getCommand() == 1;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, BABY_LEVIATHAN_ABYSS_BLAST, BABY_LEVIATHAN_BITE};
    }

    private enum AttackMode {
        CIRCLE,
        MELEE,
        RANGE
    }


    static class BabyLeviathanBiteAttackGoal extends PetSimpleAnimationGoal<The_Baby_Leviathan_Entity> {

        public BabyLeviathanBiteAttackGoal(The_Baby_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < 9 && target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
        }

        public void stop() {
            super.stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 30);
            }

        }
    }

    static class BabyLeviathanBlastAttackGoal extends PetSimpleAnimationGoal<The_Baby_Leviathan_Entity> {

        public BabyLeviathanBlastAttackGoal(The_Baby_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.getWorld().playSoundFromEntity(null, entity, ModSounds.ABYSS_BLAST, SoundCategory.NEUTRAL, 1.0f, 2.0f);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
                entity.lookAtEntity(target, 30, 90);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            entity.blast_cooldown = BLAST_HUNTING_COOLDOWN;
        }

        public void tick() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
                entity.lookAtEntity(target, 30, 90);
            }
            float dir = 90.0f;
            if (this.entity.getAnimationTick() == 37) {
                if (!entity.getWorld().isClient) {
                    Mini_Abyss_Blast_Entity DeathBeam = new Mini_Abyss_Blast_Entity(ModEntities.MINI_ABYSS_BLAST, entity.getWorld(), entity, entity.getX(), entity.getY(), entity.getZ(), (float) ((entity.headYaw + dir) * Math.PI / 180), (float) (-entity.getPitch() * Math.PI / 180), 80, dir);
                    entity.getWorld().spawnEntity(DeathBeam);
                }
            }
        }
    }

    class BabyLeviathanAttackGoal extends Goal {
        private final The_Baby_Leviathan_Entity mob;
        private LivingEntity target;
        private int circlingTime = 0;
        private float circleDistance = 4;
        private boolean clockwise = false;
        private float MeleeModeTime = 0;
        private static final int MELEE_MODE_TIME = 100;


        public BabyLeviathanAttackGoal(The_Baby_Leviathan_Entity mob) {
            this.mob = mob;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }

        public boolean canStart() {
            this.target = this.mob.getTarget();
            return this.target != null && target.isAlive() && this.mob.getAnimation() == NO_ANIMATION;
        }

        public boolean shouldContinue() {
            this.target = this.mob.getTarget();
            return this.target != null;
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void start() {
            this.mob.mode = The_Baby_Leviathan_Entity.AttackMode.CIRCLE;
            circlingTime = 0;
            MeleeModeTime = 0;
            circleDistance = 8 + this.mob.random.nextInt(2);
            clockwise = this.mob.random.nextBoolean();
            this.mob.setAttacking(true);
        }

        public void stop() {
            this.mob.mode = The_Baby_Leviathan_Entity.AttackMode.CIRCLE;
            circlingTime = 0;
            MeleeModeTime = 0;
            circleDistance = 8 + this.mob.random.nextInt(2);
            clockwise = this.mob.random.nextBoolean();
            this.target = this.mob.getTarget();
            if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(target)) {
                this.mob.setTarget(null);
            }

            this.mob.getNavigation().stop();
            if (this.mob.getTarget() == null) {
                this.mob.setAttacking(false);
                this.mob.getNavigation().stop();
            }
        }


        public void tick() {
            LivingEntity target = this.mob.getTarget();
            if (target != null) {
                if (this.mob.mode == The_Baby_Leviathan_Entity.AttackMode.CIRCLE) {
                    circlingTime++;
                    circleEntity(target, circleDistance, 1.0f, clockwise, circlingTime, 0, 1);
                    if (0 >= this.mob.blast_cooldown) {
                        this.mob.mode = The_Baby_Leviathan_Entity.AttackMode.RANGE;
                    } else {
                        this.mob.mode = The_Baby_Leviathan_Entity.AttackMode.MELEE;
                    }
                } else if (this.mob.mode == The_Baby_Leviathan_Entity.AttackMode.RANGE) {
                    if (this.mob.getRandom().nextFloat() * 100.0F < 3f) {
                        this.mob.setAnimation(BABY_LEVIATHAN_ABYSS_BLAST);
                    }
                } else if (this.mob.mode == The_Baby_Leviathan_Entity.AttackMode.MELEE) {
                    MeleeModeTime++;
                    this.mob.getNavigation().startMovingTo(target, 1.0D);
                    this.mob.getLookControl().lookAt(target, 30, 90);
                    if(MeleeModeTime >= MELEE_MODE_TIME) {
                        this.mob.mode = The_Baby_Leviathan_Entity.AttackMode.RANGE;
                    }else if (this.mob.squaredDistanceTo(target) <= 4D) {
                        this.mob.setAnimation(BABY_LEVIATHAN_BITE);
                    }
                }

            }
        }
    }
    static class BabyLeviathanMoveController extends MoveControl {
        private final The_Baby_Leviathan_Entity entity;
        private final float speedMulti;
        private final float ySpeedMod;
        private final float yawLimit;
        private  int stillTicks = 0;
        public BabyLeviathanMoveController(The_Baby_Leviathan_Entity entity, float speedMulti, float ySpeedMod, float yawLimit) {
            super(entity);
            this.entity = entity;
            this.speedMulti = speedMulti;
            this.ySpeedMod = ySpeedMod;
            this.yawLimit = yawLimit;
        }

        public void tick() {
            if (this.entity.isTouchingWater() && this.entity.getAnimation() == NO_ANIMATION) {
                if (Math.abs(this.entity.prevX - this.entity.getX()) < 0.01F && Math.abs(this.entity.prevY - this.entity.getY()) < 0.01F && Math.abs(this.entity.prevZ - this.entity.getZ()) < 0.01F) {
                    stillTicks++;
                } else {
                    stillTicks = 0;
                }
                if (stillTicks > 40){
                    this.entity.setVelocity(this.entity.getVelocity().add(0.0D, -0.005D, 0.0D));
                }
            }
            if (entity.shouldStopMoving()) {
                this.entity.setMovementSpeed(0.0F);
                return;
            }
            if (this.state == State.MOVE_TO && !this.entity.getNavigation().isIdle()) {
                double lvt_1_1_ = this.targetX - this.entity.getX();
                double lvt_3_1_ = this.targetY - this.entity.getY();
                double lvt_5_1_ = this.targetZ - this.entity.getZ();
                double lvt_7_1_ = lvt_1_1_ * lvt_1_1_ + lvt_3_1_ * lvt_3_1_ + lvt_5_1_ * lvt_5_1_;
                if (lvt_7_1_ < 2.500000277905201E-7D) {
                    this.entity.setForwardSpeed(0.0F);
                } else {
                    float lvt_9_1_ = (float) (MathHelper.atan2(lvt_5_1_, lvt_1_1_) * 57.2957763671875D) - 90.0F;
                    this.entity.setYaw(this.wrapDegrees(this.entity.getYaw(), lvt_9_1_, yawLimit));
                    this.entity.bodyYaw = this.entity.getYaw();
                    this.entity.headYaw = this.entity.getYaw();
                    float lvt_10_1_ = (float) (this.speed * speedMulti * 3 * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
                    if (this.entity.isTouchingWater()) {
                        if(lvt_3_1_ > 0 && entity.horizontalCollision){
                            this.entity.setVelocity(this.entity.getVelocity().add(0.0D, 0.08F, 0.0D));
                        }else{
                            this.entity.setVelocity(this.entity.getVelocity().add(0.0D, (double) this.entity.getMovementSpeed() * lvt_3_1_ * 0.6D * ySpeedMod, 0.0D));
                        }
                        this.entity.setMovementSpeed(lvt_10_1_ * 0.02F);
                        float lvt_11_1_ = -((float) (MathHelper.atan2(lvt_3_1_, MathHelper.sqrt((float) (lvt_1_1_ * lvt_1_1_ + lvt_5_1_ * lvt_5_1_))) * 57.2957763671875D));
                        lvt_11_1_ = MathHelper.clamp(MathHelper.wrapDegrees(lvt_11_1_), -85.0F, 85.0F);
                        this.entity.setPitch(this.wrapDegrees(this.entity.getPitch(), lvt_11_1_, 5.0F));
                        float lvt_12_1_ = MathHelper.cos(this.entity.getPitch() * 0.017453292F);
                        float lvt_13_1_ = MathHelper.sin(this.entity.getPitch() * 0.017453292F);
                        this.entity.forwardSpeed = lvt_12_1_ * lvt_10_1_;
                        this.entity.upwardSpeed = -lvt_13_1_ * lvt_10_1_;
                    } else {
                        this.entity.setMovementSpeed(lvt_10_1_ * 0.1F);
                    }

                }
            } else {
                this.entity.setMovementSpeed(0.0F);
                this.entity.setSidewaysSpeed(0.0F);
                this.entity.setUpwardSpeed(0.0F);
                this.entity.setForwardSpeed(0.0F);
            }
        }
    }
}
