package com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar;

import com.github.l_ender.cataclysm.blocks.PointedIcicleBlock;
import com.github.l_ender.cataclysm.client.particle.RingParticle;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AI.EntityAINearestTarget3D;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.entity.etc.IHoldEntity;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.l_ender.cataclysm.entity.projectile.*;
import com.github.l_ender.cataclysm.init.*;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import com.github.l_ender.cataclysm.util.Utilities;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.LandingBlock;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Dismounting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.OverlayMessageS2CPacket;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;


public class Aptrgangr_Entity extends Internal_Animation_Monster implements IHoldEntity {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState swingrightAnimationState = new AnimationState();
    public AnimationState smashAnimationState = new AnimationState();
    public AnimationState chargestartAnimationState = new AnimationState();
    public AnimationState chargeAnimationState = new AnimationState();
    public AnimationState chargeendAnimationState = new AnimationState();
    public AnimationState chargehitAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    private int earthquake_cooldown = 0;
    public static final int EARTHQUAKE_COOLDOWN = 80;
    private boolean chubu = false;
    private int charge_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 160;
    public static final int NATURE_HEAL_COOLDOWN = 60;
    private int timeWithoutTarget;
    public Aptrgangr_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 35;
        this.setStepHeight(1.25F);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
        setConfigattribute(this, CMConfig.AptrgangrHealthMultiplier, CMConfig.AptrgangrDamageMultiplier);
    }

    protected void initGoals() {
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new EntityAINearestTarget3D<>(this, PlayerEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, SnowGolemEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, false));
        this.goalSelector.add(4, new InternalMoveGoal(this,false,1.0D));
        this.goalSelector.add(3, new InternalAttackGoal(this,0,1,0,40,15,4.5F){
            @Override
            public boolean canStart() {
                return super.canStart() && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0F < 22f;
            }
        });


        this.goalSelector.add(3, new InternalAttackGoal(this,0,2,0,40,10,6){
            @Override
            public boolean canStart() {
                return super.canStart() && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0F < 16f && Aptrgangr_Entity.this.earthquake_cooldown <= 0;
            }
            @Override
            public void stop() {
                super.stop();
                Aptrgangr_Entity.this.earthquake_cooldown = EARTHQUAKE_COOLDOWN;
            }
        });

        this.goalSelector.add(3, new InternalAttackGoal(this,0,2,0,40,10,12){
            @Override
            public boolean canStart() {
                LivingEntity target = entity.getTarget();
               return super.canStart() && target !=null && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0F < 22f && this.entity.distanceTo(target) > 6 && Aptrgangr_Entity.this.earthquake_cooldown <= 0;
            }
            @Override
            public void stop() {
                super.stop();
                Aptrgangr_Entity.this.earthquake_cooldown = EARTHQUAKE_COOLDOWN;
            }
        });


        //chargePrepare
        this.goalSelector.add(3, new InternalAttackGoal(this,0,3,4,24,24,15) {
            @Override
            public boolean canStart() {
                return super.canStart() && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0F < 8f && Aptrgangr_Entity.this.charge_cooldown <= 0;
            }
        });

        this.goalSelector.add(2, new InternalStateGoal(this,4,4,5,40,0){
            @Override
            public void tick() {
                if(this.entity.isOnGround()){
                    Vec3d vector3d = entity.getVelocity();
                    float f = entity.getYaw() * ((float)Math.PI / 180F);
                    Vec3d vector3d1 = new Vec3d(-MathHelper.sin(f), entity.getVelocity().y, MathHelper.cos(f)).multiply(1.0D).add(vector3d.multiply(0.5D));
                    entity.setVelocity(vector3d1.x, entity.getVelocity().y, vector3d1.z);
                }
            }
            @Override
            public boolean shouldContinue() {
                return super.shouldContinue() && !chubu;
            }
            @Override
            public void stop() {
                if(chubu) {
                    entity.setAttackState(6);
                    chubu = false;
                }else{
                    super.stop();
                }
            }
        });
        this.goalSelector.add(1, new InternalStateGoal(this,5,5,0,23,0) {
            @Override
            public void stop() {
                super.stop();
                Aptrgangr_Entity.this.charge_cooldown = CHARGE_COOLDOWN;
            }
        });
        this.goalSelector.add(0, new InternalStateGoal(this,6,6,0,18,0) {
            @Override
            public void stop() {
                super.stop();
                Aptrgangr_Entity.this.charge_cooldown = CHARGE_COOLDOWN;
            }
        });
    }

    public static DefaultAttributeContainer.Builder aptrgangr() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 18)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 160)
                .add(EntityAttributes.GENERIC_ARMOR, 10)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
    }

    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
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
        if(!this.getPassengerList().isEmpty() && this.getAttackState() == 4 && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }

        return super.damage(source, damage);
    }

    protected int getNextAirUnderwater(int air) {
        return air;
    }


    public boolean handleFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "swing_right" -> this.swingrightAnimationState;
            case "smash" -> this.smashAnimationState;
            case "idle" -> this.idleAnimationState;
            case "charge_start" -> this.chargestartAnimationState;
            case "charge" -> this.chargeAnimationState;
            case "charge_end" -> this.chargeendAnimationState;
            case "charge_hit" -> this.chargehitAnimationState;
            case "death" -> this.deathAnimationState;
            default -> new AnimationState();
        };
//        if (input == "swing_right") {
//            return this.swingrightAnimationState;
//        } else if (input == "smash") {
//            return this.smashAnimationState;
//        } else if (input == "idle") {
//                return this.idleAnimationState;
//        } else if (input == "charge_start") {
//            return this.chargestartAnimationState;
//        } else if (input == "charge") {
//            return this.chargeAnimationState;
//        } else if (input == "charge_end") {
//            return this.chargeendAnimationState;
//        } else if (input == "charge_hit") {
//            return this.chargehitAnimationState;
//        } else if (input == "death") {
//            return this.deathAnimationState;
//        }else {
//            return new AnimationState();
//        }
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    public void onTrackedDataSet(TrackedData<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.swingrightAnimationState.startIfNotRunning(this.age);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.smashAnimationState.startIfNotRunning(this.age);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.chargestartAnimationState.startIfNotRunning(this.age);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.chargeAnimationState.startIfNotRunning(this.age);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.chargeendAnimationState.startIfNotRunning(this.age);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.chargehitAnimationState.startIfNotRunning(this.age);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfNotRunning(this.age);
                    }
                }
        }

        super.onTrackedDataSet(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.swingrightAnimationState.stop();
        this.smashAnimationState.stop();
        this.chargestartAnimationState.stop();
        this.chargeAnimationState.stop();
        this.chargeendAnimationState.stop();
        this.chargehitAnimationState.stop();
        this.deathAnimationState.stop();
    }



    public void onDeath(DamageSource p_21014_) {
        super.onDeath(p_21014_);
        this.setAttackState(7);
    }


    protected void dropEquipment(DamageSource p_33574_, int p_33575_, boolean p_33576_) {
        super.dropEquipment(p_33574_, p_33575_, p_33576_);
        Entity entity = p_33574_.getAttacker();
        if (entity instanceof CreeperEntity creeper) {
            if (creeper.shouldDropHead()) {
                creeper.onHeadDropped();
                this.dropItem(ModItems.APTRGANGR_HEAD);
            }
        }

    }

    public int deathtimer(){
        return 60;
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
    }


    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.idleAnimationState.setRunning(!this.limbAnimator.isLimbMoving() && this.getAttackState() == 0, this.age);
        }else{
            if (timeWithoutTarget > 0) timeWithoutTarget--;
            LivingEntity target = this.getTarget();
            if (target != null) {
                timeWithoutTarget = NATURE_HEAL_COOLDOWN;
            }

            if (timeWithoutTarget <= 0) {
                if (!isAiDisabled() ) {
                    if (this.age % 20 == 0) {
                        this.heal(this.getMaxHealth()/ 10);
                    }
                }
            }
        }

        if (earthquake_cooldown > 0) earthquake_cooldown--;
        if (charge_cooldown > 0) charge_cooldown--;

        if (!this.getPassengerList().isEmpty() && this.getPassengerList().get(0).isSneaking() && this.getAttackState() == 4) {
            this.getPassengerList().get(0).setSneaking(false);
        }

    }

    public void tickMovement() {
        super.tickMovement();
        if(this.getAttackState() == 1) {
            if (this.attackTicks == 15) {
                this.playSound(ModSounds.STRONGSWING, 1.0F, 0.7f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.06f, 0, 20);
                AreaAttack(5.75f, 5.75f, 120, 1, 120,true);
            }
        }
        if(this.getAttackState() == 2) {
            if (this.attackTicks == 11) {
                this.playSound(ModSounds.STRONGSWING, 1.0F, 0.7f);
            }
            if (this.attackTicks == 15) {
                AreaAttack(6.5f, 6.5f, 60, 1, 120,false);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.15f, 0, 20);
                this.playSound(SoundEvents.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, 1.0F, 0.8f);
                Makeparticle(0.6f, 5.0f, 0f);

                double theta = (bodyYaw) * (Math.PI / 180);

                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int numberOfSkulls = 5;
                float angleStep = 30.0f;

                for (int i = 0; i < numberOfSkulls; i++) {
                    float angle = bodyYaw + (i - (numberOfSkulls / 2)) * angleStep;

                    float rad = (float) Math.toRadians(angle);
                    double dx = -Math.sin(rad);
                    double dz = Math.cos(rad);
                    Axe_Blade_Entity witherskull = new Axe_Blade_Entity(this, dx, 0, dz, this.getWorld(),(float) CMConfig.AptrgangrAxeBladeDamage,angle);
                    double spawnX = this.getX() + vecX * 5;
                    double spawnY = this.getBodyY(0.15D);
                    double spawnZ = this.getZ() + vecZ * 5;
                    witherskull.setPosition(spawnX, spawnY, spawnZ);
                    this.getWorld().spawnEntity(witherskull);

                }
            }
        }
        if(this.getAttackState() == 4) {
            ChargeGrab(0.0D,0.0D,0.5, 0.1F, 0, true);
            if (this.horizontalCollision) {
                chubu = true;
                if (!this.getWorld().isClient) {
                    Icicle_Crash();
                }
            }
            if (this.getWorld().isClient) {
                double x = this.getX();
                double y = this.getY() + this.getHeight() / 2;
                double z = this.getZ();
                float yaw = (float) Math.toRadians(-this.getYaw());
                float yaw2 = (float) Math.toRadians(-this.getYaw() + 180);
                float pitch = (float) Math.toRadians(-this.getPitch());
                this.getWorld().addParticle(new RingParticle.RingData(yaw, pitch, 40, 0.337f, 0.925f, 0.8f, 1.0f, 50f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), x, y, z, 0, 0, 0);
                this.getWorld().addParticle(new RingParticle.RingData(yaw2, pitch, 40, 0.337f, 0.925f, 0.8f, 1.0f, 50f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), x, y, z, 0, 0, 0);

            }
        }

        if(this.getAttackState() == 5) {
            if (this.attackTicks == 4) {
                this.playSound(ModSounds.STRONGSWING, 1.0F, 0.7f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.06f, 0, 20);
                UpperAreaAttack(6.5f, 6.5f, 60, 1, 120,true);
            }
        }

        if(this.getAttackState() == 6) {
            if (this.attackTicks == 1) {
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.1f, 0, 20);
                this.playSound(SoundEvents.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, 1.0F, 0.9f);
            }
        }

    }

    private void Makeparticle(float size,float vec, float math) {
        if (this.getWorld().isClient) {
            float f = MathHelper.cos(this.bodyYaw * ((float) Math.PI / 180F));
            float f1 = MathHelper.sin(this.bodyYaw * ((float) Math.PI / 180F));
            double theta = (bodyYaw) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.bodyYaw) + i1;
                double extraX = size * MathHelper.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = size * MathHelper.cos(angle);
                int hitX = MathHelper.floor(getX() + vec * vecX + extraX);
                int hitY = MathHelper.floor(getY());
                int hitZ = MathHelper.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = this.getWorld().getBlockState(hit.down());
                if (block.getRenderType() != BlockRenderType.INVISIBLE) {
                    this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }
            }
            this.getWorld().addParticle(new RingParticle.RingData(0f, (float)Math.PI/2f, 30, 1.0f, 1.0F,  1.0F, 1.0f, 20f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);

        }
    }

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks,boolean knockback) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);
            float entityAttackingAngle = this.bodyYaw % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }
            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isTeammate(entityHit) && !(entityHit instanceof Aptrgangr_Entity) && entityHit != this) {
                    DamageSource damagesource = this.getDamageSources().mobAttack(this);
                    boolean hurt =  entityHit.damage(damagesource, (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage));
                    if (entityHit.blockedByShield(damagesource) && entityHit instanceof PlayerEntity player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }
                    double d0 = entityHit.getX() - this.getX();
                    double d1 = entityHit.getZ() - this.getZ();
                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                    if (hurt && knockback) {
                        entityHit.addVelocity(d0 / d2 * 2.75D, 0.15D, d1 / d2 * 2.75D);
                    }

                }
            }
        }
    }

    private void UpperAreaAttack(float range, float height, float arc, float damage, int shieldbreakticks,boolean knockback) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);
            float entityAttackingAngle = this.bodyYaw % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }
            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isTeammate(entityHit) && !(entityHit instanceof Aptrgangr_Entity) && entityHit != this) {
                    DamageSource damagesource = this.getDamageSources().mobAttack(this);
                    boolean hurt =  entityHit.damage(damagesource, (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage));
                    if (entityHit.blockedByShield(damagesource) && entityHit instanceof PlayerEntity player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }
                    double d0 = entityHit.getX() - this.getX();
                    double d1 = entityHit.getZ() - this.getZ();
                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                    if (hurt && knockback) {
                        entityHit.setVelocity(entityHit.getVelocity().add(0.0D, (double)0.4F * 2, 0.0D));
                    }

                }
            }
        }
    }


    private void ChargeGrab(double inflateXZ,double inflateY,  double range, float damage, int shieldbreakticks, boolean maledictio) {
        double yaw = Math.toRadians(this.getYaw() + 90);
        double xExpand = range * Math.cos(yaw);
        double zExpand = range * Math.sin(yaw);
        Box attackRange = this.getBoundingBox().expand(inflateXZ,inflateY,inflateXZ).stretch(xExpand, 0, zExpand);
        for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, attackRange)) {
            if (!isTeammate(entity) && entity != this) {
                if(this.getPassengerList().isEmpty()) {
                    DamageSource damagesource = maledictio ? CMDamageTypes.causeMaledictioDamage(this) : this.getDamageSources().mobAttack(this);
                    boolean flag = entity.damage(damagesource, damage);
                    if (entity.blockedByShield(damagesource) && entity instanceof PlayerEntity player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }
                    if (flag) {
                        if (!entity.getType().isIn(ModTag.IGNIS_CANT_POKE) && entity.isAlive()) {
                            if (entity.isSneaking()) {
                                entity.setSneaking(false);
                            }
                            if (!this.getWorld().isClient) {
                                entity.startRiding(this, true);
                                Utilities.trySendOverlayMessage(entity, Text.translatable("entity.cataclysm.you_cant_escape"));
                            }
                        }

                    }
                }

            }
        }
    }


    private void Icicle_Crash() {

        if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            BlockPos ceil = this.getBlockPos().add(0, 5, 0);
            while ((!getWorld().getBlockState(ceil).isSolid() || getWorld().getBlockState(ceil).getBlock() == ModBlocks.POINTED_ICICLE) && ceil.getY() < getWorld().getTopY()) {
                ceil = ceil.up();
            }
            final int i = 8;
            final int j = 8;
            final int k = 8;

            for (BlockPos blockpos1 : BlockPos.iterate(ceil.add(-i, -j, -k), ceil.add(i, j, k))) {
                if (getWorld().getBlockState(blockpos1).getBlock() instanceof LandingBlock) {
                    if (isHangingIcicle(blockpos1)) {
                        while (isHangingIcicle(blockpos1.up()) && blockpos1.getY() < getWorld().getTopY()) {
                            blockpos1 = blockpos1.up();
                        }
                        if (isHangingIcicle(blockpos1)) {
                            Vec3d vec3 = Vec3d.ofBottomCenter(blockpos1);
                            FallingBlockEntity.spawnFromBlock(getWorld(), BlockPos.ofFloored(vec3.x, vec3.y, vec3.z), getWorld().getBlockState(blockpos1));
                        }
                    } else {
                        this.getWorld().scheduleBlockTick(blockpos1, getWorld().getBlockState(blockpos1).getBlock(), 2);
                    }
                }
            }
        }

    }

    private boolean isHangingIcicle(BlockPos pos) {
        return getWorld().getBlockState(pos).getBlock() instanceof PointedIcicleBlock && getWorld().getBlockState(pos).get(PointedIcicleBlock.TIP_DIRECTION) == Direction.DOWN;
    }



    public void travel(Vec3d travelVector) {
        super.travel(travelVector);
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

//    @Override
//    public boolean canRiderInteract() {
//        return true;
//    }

    public void updatePassengerPosition(Entity passenger, Entity.PositionUpdater moveFunc) {
        double theta = (bodyYaw) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        double px = this.getX() + 0.7F * vecX;
        double pz = this.getZ() + 0.7F * vecZ;

        double y = this.getY() + passenger.getHeightOffset() + 0.6D;
        if (hasPassenger(passenger)) {
            if(this.getAttackState() == 6){
                if(this.attackTicks == 1) {
                    if(passenger instanceof LivingEntity living){
                        DamageSource damagesource =  CMDamageTypes.causeMaledictioDamage(this) ;
                        boolean flag = living.damage(damagesource, (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * 1.5F));
                        if(flag){
                            this.playSound(SoundEvents.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, 1.0F, 0.9f);
                        }
                    }
                    passenger.stopRiding();
                }
            }else if(this.getAttackState() == 5){
                if(this.attackTicks == 1) {
                    passenger.stopRiding();
                }
            }else if (this.getAttackState() != 4){
                passenger.stopRiding();
            }
            moveFunc.accept(passenger, px, y, pz);
        }
    }


    public Vec3d updatePassengerForDismount(LivingEntity p_29487_) {
        Direction direction = this.getMovementDirection();
        if (direction.getAxis() == Direction.Axis.Y) {
            return super.updatePassengerForDismount(p_29487_);
        } else {
            int[][] aint = Dismounting.getDismountOffsets(direction);
            BlockPos blockpos = this.getBlockPos();
            BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();

            for(EntityPose pose : p_29487_.getPoses()) {
                Box aabb = p_29487_.getBoundingBox(pose);

                for(int[] aint1 : aint) {
                    blockpos$mutableblockpos.set(blockpos.getX() + aint1[0], blockpos.getY(), blockpos.getZ() + aint1[1]);
                    double d0 = this.getWorld().getDismountHeight(blockpos$mutableblockpos);
                    if (Dismounting.canDismountInBlock(d0)) {
                        Vec3d vec3 = Vec3d.ofCenter(blockpos$mutableblockpos, d0);
                        if (Dismounting.canPlaceEntityAt(this.getWorld(), p_29487_, aabb.offset(vec3))) {
                            p_29487_.setPose(pose);
                            return vec3;
                        }
                    }
                }
            }

            return super.updatePassengerForDismount(p_29487_);
        }
    }

    public boolean shouldRiderSit() {
        return false;
    }

    public boolean isTeammate(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isTeammate(entityIn)) {
            return true;
        } else if (entityIn.getType().isIn(ModTag.TEAM_MALEDICTUS)) {
            return this.getScoreboardTeam() == null && entityIn.getScoreboardTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.APTRGANGR_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.APTRGANGR_DEATH;
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.APTRGANGR_IDLE;
    }

    @Override
    protected BodyControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected EntityNavigation createNavigation(World worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    public boolean canHaveStatusEffect(StatusEffectInstance p_34192_) {
        return p_34192_.getEffectType() != ModEffect.EFFECTSTUN && p_34192_.getEffectType() != ModEffect.EFFECTABYSSAL_CURSE && super.canHaveStatusEffect(p_34192_);
    }


    public boolean canImmediatelyDespawn(double p_21542_) {
        return false;
    }

    protected boolean isDisallowedInPeaceful() {
        return false;
    }

    protected boolean canStartRiding(Entity p_31508_) {
        return false;
    }

}





