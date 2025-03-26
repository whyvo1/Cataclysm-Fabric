package com.github.l_ender.cataclysm.entity.InternalAnimationMonster;

import com.github.l_ender.cataclysm.client.particle.RingParticle;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.l_ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.entity.projectile.Poison_Dart_Entity;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
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
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.GameRules;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;


public class Kobolediator_Entity extends Internal_Animation_Monster {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState sword1AnimationState = new AnimationState();
    public AnimationState sword2AnimationState = new AnimationState();
    public AnimationState chargeprepareAnimationState = new AnimationState();
    public AnimationState chargeAnimationState = new AnimationState();
    public AnimationState chargeendAnimationState = new AnimationState();
    public AnimationState blockAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    private int earthquake_cooldown = 0;
    public static final int EARTHQUAKE_COOLDOWN = 80;

    private int charge_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 160;

    public Kobolediator_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 35;
        this.setStepHeight(1.25F);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
        setConfigattribute(this, CMConfig.KobolediatorHealthMultiplier, CMConfig.KobolediatorDamageMultiplier);
    }

    protected void initGoals() {
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(2, new InternalMoveGoal(this,false,1.0D));


        this.goalSelector.add(1, new InternalAttackGoal(this,0,3,0,50,15,12){
            @Override
            public boolean canStart() {
                return super.canStart() && Kobolediator_Entity.this.getRandom().nextFloat() * 100.0F < 16f && Kobolediator_Entity.this.earthquake_cooldown <= 0;
            }
            @Override
            public void stop() {
                super.stop();
                Kobolediator_Entity.this.earthquake_cooldown = EARTHQUAKE_COOLDOWN;
            }
        });
        this.goalSelector.add(1, new InternalAttackGoal(this,0,4,0,100,64,8));

        //chargePrepare
        this.goalSelector.add(1, new InternalAttackGoal(this,0,5,6,40,30,15) {
            @Override
            public boolean canStart() {
                return super.canStart() && Kobolediator_Entity.this.getRandom().nextFloat() * 100.0F < 9f && Kobolediator_Entity.this.charge_cooldown <= 0;
            }
        });

        this.goalSelector.add(1, new InternalStateGoal(this,6,6,7,30,0){
            @Override
            public void tick() {
                if(this.entity.isOnGround()){
                    Vec3d vector3d = entity.getVelocity();
                    float f = entity.getYaw() * ((float)Math.PI / 180F);
                    Vec3d vector3d1 = new Vec3d(-MathHelper.sin(f), entity.getVelocity().y, MathHelper.cos(f)).multiply(0.7D).add(vector3d.multiply(0.5D));
                    entity.setVelocity(vector3d1.x, entity.getVelocity().y, vector3d1.z);
                }
            }
        });
        this.goalSelector.add(0, new InternalAttackGoal(this,6,7,0,40,40,5) {

            @Override
            public void stop() {
                super.stop();
                Kobolediator_Entity.this.charge_cooldown = CHARGE_COOLDOWN;
            }
        });
        this.goalSelector.add(0, new InternalStateGoal(this,7,7,0,40,40) {
            @Override
            public void stop() {
                super.stop();
                Kobolediator_Entity.this.charge_cooldown = CHARGE_COOLDOWN;
            }
        });
        this.goalSelector.add(1, new InternalStateGoal(this,1,1,0,0,0){
            @Override
            public void tick() {
                entity.setVelocity(0, entity.getVelocity().y, 0);
            }
        });

        this.goalSelector.add(0, new InternalAttackGoal(this,1,2,0,70,0,18));
        this.goalSelector.add(0, new InternalStateGoal(this,9,9,0,18,0,false));
    }

    public static DefaultAttributeContainer.Builder kobolediator() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 14)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 180)
                .add(EntityAttributes.GENERIC_ARMOR, 10)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
    }

    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }

    @Override
    public boolean damage(DamageSource source, float damage) {
        Entity entity = source.getSource();
        if (entity instanceof Poison_Dart_Entity) {
            return false;
        }
        if (this.canBlockDamageSource(source)) {
            if(entity instanceof PersistentProjectileEntity) {
                float f = 170.0F + this.random.nextFloat() * 80.0F;
                entity.setVelocity(entity.getVelocity().multiply(1.5));
                entity.setYaw(entity.getYaw() + f);
                entity.velocityModified = true;
            }
            if(this.getAttackState() == 0) {
                this.setAttackState(9);
                this.playSound(SoundEvents.BLOCK_ANVIL_LAND, 1.0F, 2);
            }
            return false;
        }
        if (this.isSleep() && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        return super.damage(source, damage);
    }

    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        boolean flag = false;
        if (!this.isAiDisabled() && damageSourceIn.isIn(DamageTypeTags.IS_PROJECTILE) && !flag && (this.getAttackState() == 0 || this.getAttackState() == 9)) {
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

    protected int getNextAirUnderwater(int air) {
        return air;
    }


    public boolean handleFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "sleep" -> this.sleepAnimationState;
            case "awake" -> this.awakeAnimationState;
            case "sword1" -> this.sword1AnimationState;
            case "sword2" -> this.sword2AnimationState;
            case "idle" -> this.idleAnimationState;
            case "charge_prepare" -> this.chargeprepareAnimationState;
            case "charge" -> this.chargeAnimationState;
            case "charge_end" -> this.chargeendAnimationState;
            case "death" -> this.deathAnimationState;
            case "block" -> this.blockAnimationState;
            default -> new AnimationState();
        };
//        if (input == "sleep") {
//            return this.sleepAnimationState;
//        } else if (input == "awake") {
//            return this.awakeAnimationState;
//        } else if (input == "sword1") {
//            return this.sword1AnimationState;
//        } else if (input == "sword2") {
//            return this.sword2AnimationState;
//        } else if (input == "idle") {
//                return this.idleAnimationState;
//        } else if (input == "charge_prepare") {
//            return this.chargeprepareAnimationState;
//        } else if (input == "charge") {
//            return this.chargeAnimationState;
//        } else if (input == "charge_end") {
//            return this.chargeendAnimationState;
//        } else if (input == "death") {
//            return this.deathAnimationState;
//        } else if (input == "block") {
//            return this.blockAnimationState;
//        }else {
//            return new AnimationState();
//        }
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }

    public boolean canTakeDamage() {
        return !this.isSleep() && super.canTakeDamage();
    }

    public EntityData initialize(ServerWorldAccess p_29678_, LocalDifficulty p_29679_, SpawnReason p_29680_, @Nullable EntityData p_29681_, @Nullable NbtCompound p_29682_) {
        this.setSleep(true);
        return super.initialize(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }

    public void onTrackedDataSet(TrackedData<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.sleepAnimationState.startIfNotRunning(this.age);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.awakeAnimationState.startIfNotRunning(this.age);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.sword1AnimationState.startIfNotRunning(this.age);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.sword2AnimationState.startIfNotRunning(this.age);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.chargeprepareAnimationState.startIfNotRunning(this.age);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.chargeAnimationState.startIfNotRunning(this.age);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.chargeendAnimationState.startIfNotRunning(this.age);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfNotRunning(this.age);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.blockAnimationState.startIfNotRunning(this.age);
                    }
                }
        }

        super.onTrackedDataSet(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();
        this.awakeAnimationState.stop();
        this.sword1AnimationState.stop();
        this.sword2AnimationState.stop();
        this.chargeprepareAnimationState.stop();
        this.chargeAnimationState.stop();
        this.blockAnimationState.stop();
        this.chargeendAnimationState.stop();
        this.deathAnimationState.stop();
    }



    public void onDeath(DamageSource p_21014_) {
        super.onDeath(p_21014_);
        this.setAttackState(8);
    }

    public int deathtimer(){
        return 60;
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putBoolean("is_Sleep", isSleep());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        setSleep(compound.getBoolean("is_Sleep"));
    }


    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.idleAnimationState.setRunning(!this.limbAnimator.isLimbMoving() && this.getAttackState() == 0, this.age);
        }
        if (earthquake_cooldown > 0) earthquake_cooldown--;
        if (charge_cooldown > 0) charge_cooldown--;

    }

    public void tickMovement() {
        super.tickMovement();
        if(this.getAttackState() == 2) {
            if (this.attackTicks == 12) {
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.06f, 0, 20);
            }
        }

        if(this.getAttackState() == 3) {
            if (this.attackTicks == 20) {
                AreaAttack(10.0f,6.0F,60,1,120);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.1f, 0, 20);
                Makeparticle(0.5f, 9.0f, 1.2f);
            }
            for (int l = 19; l <= 28; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 17;
                    int d2 = l - 16;
                    float ds = (d + d2) / 2;
                   StompDamage(0.25f, d, 5,1.05F, 2.0f, -0.2f, 0, 1.0f);
                   StompDamage(0.25f, d2, 5,1.05F, 2.0f, -0.2f, 0, 1.0f);
                   Stompsound(ds,-0.2F);
                }
            }
        }

        if(this.getAttackState() == 4) {
            if (this.attackTicks == 18) {
                AreaAttack(9.0f,6.0F,270,1,0);
                this.playSound(ModSounds.STRONGSWING, 1F, 1.0f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.05f, 0, 10);
            }
            if (this.attackTicks == 36) {
                AreaAttack(9.0f,6.0F,270,1,0);
                this.playSound(ModSounds.STRONGSWING, 1F, 1.0f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.05f, 0, 10);
            }
            if (this.attackTicks == 65) {
                AreaAttack(10.0f,6.0F,45,1.25F,120);
                this.playSound(ModSounds.REMNANT_STOMP, 1F, 1.0f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.1f, 0, 20);
                Makeparticle(0.5f, 9.0f, 1.8f);
            }
        }
        if(this.getAttackState() == 6) {
            if (!this.getWorld().isClient) {
                if(CMConfig.KobolediatorBlockBreaking) {
                    ChargeBlockBreaking();
                }else{
                    if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                        ChargeBlockBreaking();
                    }
                }
            }
            if (this.age % 4 == 0) {
                for (LivingEntity Lentity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(0.5D))) {
                    if (!isTeammate(Lentity) && !(Lentity instanceof Kobolediator_Entity) && Lentity != this) {
                        boolean flag = Lentity.damage(this.getDamageSources().mobAttack(this), (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * 0.4F);
                        if (flag) {
                            if (Lentity.isOnGround()) {
                                double d0 = Lentity.getX() - this.getX();
                                double d1 = Lentity.getZ() - this.getZ();
                                double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                                float f = 1.5F;
                                Lentity.addVelocity(d0 / d2 * f, 0.5F, d1 / d2 * f);
                            }
                        }
                    }
                }
            }
        }
        if(this.getAttackState() == 7) {
            if (this.attackTicks == 5) {
                AreaAttack(9.0f,6.0F,200,1.25F,120);
                this.playSound(ModSounds.STRONGSWING, 1F, 1.0f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.05f, 0, 10);
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

    private void ChargeBlockBreaking(){
        boolean flag = false;
        Box aabb = this.getBoundingBox().expand(0.5D, 0.2D, 0.5D);
        for (BlockPos blockpos : BlockPos.iterate(MathHelper.floor(aabb.minX), MathHelper.floor(this.getY()), MathHelper.floor(aabb.minZ), MathHelper.floor(aabb.maxX), MathHelper.floor(aabb.maxY), MathHelper.floor(aabb.maxZ))) {
            BlockState blockstate = this.getWorld().getBlockState(blockpos);
            if (!blockstate.isAir() && !blockstate.isIn(ModTag.REMNANT_IMMUNE)) {
                if (random.nextInt(6) == 0 && !blockstate.hasBlockEntity()) {
                    Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(getWorld(), blockpos.getX() + 0.5D, blockpos.getY() + 0.5D, blockpos.getZ() + 0.5D, blockstate, 20);
                    flag = this.getWorld().breakBlock(blockpos, false, this) || flag;
                    fallingBlockEntity.setVelocity(fallingBlockEntity.getVelocity().add(this.getPos().subtract(fallingBlockEntity.getPos()).multiply((-1.2D + random.nextDouble()) / 3, 0.2D + getRandom().nextGaussian() * 0.15D, (-1.2D + random.nextDouble()) / 3)));
                    getWorld().spawnEntity(fallingBlockEntity);
                } else {
                    flag = this.getWorld().breakBlock(blockpos, false, this) || flag;
                }
            }
        }
    }


    private void Stompsound(float distance,float math) {
        double theta = (bodyYaw) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float f = MathHelper.cos(this.bodyYaw * ((float) Math.PI / 180F));
        float f1 = MathHelper.sin(this.bodyYaw * ((float) Math.PI / 180F));
        this.getWorld().playSound(null, this.getX() + distance * vecX + f * math, this.getY(), this.getZ() + distance * vecZ + f1 * math, ModSounds.REMNANT_STOMP, this.getSoundCategory(), 0.6f, 1.0f);
    }

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks) {
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
                if (!isTeammate(entityHit) && !(entityHit instanceof Kobolediator_Entity) && entityHit != this) {
                    DamageSource damagesource = this.getDamageSources().mobAttack(this);
                    entityHit.damage(damagesource, (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage));
                    if (entityHit.blockedByShield(damagesource) && entityHit instanceof PlayerEntity player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }

                }
            }
        }
    }

    private void StompDamage(float spreadarc, int distance, int height, float mxy, float vec,float math, int shieldbreakticks, float damage) {
        double perpFacing = this.bodyYaw * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        int hitY = MathHelper.floor(this.getBoundingBox().minY - 0.5);
        double spread = Math.PI * spreadarc;
        int arcLen = MathHelper.ceil(distance * spread);
        float f = MathHelper.cos(this.bodyYaw * ((float)Math.PI / 180F)) ;
        float f1 = MathHelper.sin(this.bodyYaw * ((float)Math.PI / 180F)) ;
        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = this.getX() + vx * distance + vec * Math.cos((bodyYaw + 90) * Math.PI / 180) + f * math;
            double pz = this.getZ() + vz * distance + vec * Math.sin((bodyYaw + 90) * Math.PI / 180  + f1 * math);
            float factor = 1 - distance / (float) 12;
            int hitX = MathHelper.floor(px);
            int hitZ = MathHelper.floor(pz);
            BlockPos pos = new BlockPos(hitX, hitY + height, hitZ);
            BlockState block = getWorld().getBlockState(pos);

            int maxDepth = 30;
            for (int depthCount = 0; depthCount < maxDepth; depthCount++) {
                if (block.getRenderType() == BlockRenderType.MODEL) {
                    break;
                }
                pos = pos.down();
                block = getWorld().getBlockState(pos);
            }

            if (block.getRenderType() != BlockRenderType.MODEL) {
                block = Blocks.AIR.getDefaultState();
            }
            spawnBlocks(hitX,hitY + height ,hitZ, (int) (this.getY() - height),block, px, pz, mxy, vx, vz, factor, shieldbreakticks, damage);

        }
    }


    private void spawnBlocks(int hitX, int hitY, int hitZ, int lowestYCheck,BlockState blockState,double px,double pz,float mxy,double vx,double vz,float factor, int shieldbreakticks,float damage) {
        BlockPos blockpos = new BlockPos(hitX, hitY, hitZ);
        BlockState block = getWorld().getBlockState(blockpos);
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.down();
            BlockState blockstate = this.getWorld().getBlockState(blockpos1);
            if (blockstate.isSideSolidFullSquare(this.getWorld(), blockpos1, Direction.UP)) {
                if (!this.getWorld().isAir(blockpos)) {
                    BlockState blockstate1 = this.getWorld().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.getWorld(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.getMax(Direction.Axis.Y);
                    }
                }

                break;
            }

            blockpos = blockpos.down();
        } while(blockpos.getY() >= MathHelper.floor(lowestYCheck) - 1);


        Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(getWorld(), hitX + 0.5D, (double)blockpos.getY() + d0 + 0.5D, hitZ + 0.5D, blockState, 10);
        fallingBlockEntity.addVelocity(0, 0.2D + getRandom().nextGaussian() * 0.04D, 0);
        getWorld().spawnEntity(fallingBlockEntity);



        Box selection = new Box(px - 0.5, (double)blockpos.getY() + d0 -1, pz - 0.5, px + 0.5, (double)blockpos.getY() + d0 + mxy, pz + 0.5);
        List<LivingEntity> hit = getWorld().getNonSpectatingEntities(LivingEntity.class, selection);
        for (LivingEntity entity : hit) {
            if (!isTeammate(entity) && !(entity instanceof Kobolediator_Entity) && entity != this) {
                DamageSource damagesource = this.getDamageSources().mobAttack(this);
                boolean flag = entity.damage(damagesource, (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage));
                if (entity.blockedByShield(damagesource) && entity instanceof PlayerEntity player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }

                if (flag) {
                    double magnitude = -4;
                    double x = vx * (1 - factor) * magnitude;
                    double y = 0;
                    if (entity.isOnGround()) {
                        y += 0.15;
                    }
                    double z = vz * (1 - factor) * magnitude;
                    entity.setVelocity(entity.getVelocity().add(x, y, z));
                }
            }
        }
    }

    public boolean isTeammate(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isTeammate(entityIn)) {
            return true;
        } else if (entityIn.getType().isIn(ModTag.TEAM_ANCIENT_REMNANT)) {
            return this.getScoreboardTeam() == null && entityIn.getScoreboardTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.KOBOLEDIATOR_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.KOBOLEDIATOR_DEATH;
    }

    protected SoundEvent getAmbientSound() {
        return this.isSleep() ? super.getAmbientSound() : ModSounds.KOBOLEDIATOR_AMBIENT;
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





