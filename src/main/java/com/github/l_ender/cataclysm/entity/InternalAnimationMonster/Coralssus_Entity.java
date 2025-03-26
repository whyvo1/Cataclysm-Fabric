package com.github.l_ender.cataclysm.entity.InternalAnimationMonster;

import com.github.l_ender.cataclysm.client.particle.RingParticle;
import com.github.l_ender.cataclysm.entity.AI.MobAIFindWater;
import com.github.l_ender.cataclysm.entity.AI.MobAILeaveWater;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.l_ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.entity.etc.*;
import com.github.l_ender.cataclysm.entity.etc.path.GroundPathNavigatorWide;
import com.github.l_ender.cataclysm.entity.etc.path.SemiAquaticPathNavigator;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.VariantHolder;
import net.minecraft.entity.ai.NoPenaltyTargeting;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Formatting;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.EnumSet;
import java.util.function.IntFunction;


public class Coralssus_Entity extends Internal_Animation_Monster implements VariantHolder<Coralssus_Entity.Variant>, ISemiAquatic {
    private static final TrackedData<Integer> MOISTNESS = DataTracker.registerData(Coralssus_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    public static final TrackedData<Integer> VARIANT = DataTracker.registerData(Coralssus_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    public static final TrackedData<Boolean> RIGHT = DataTracker.registerData(Coralssus_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> CORALSSUS_SWIM = DataTracker.registerData(Coralssus_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState angryAnimationState = new AnimationState();
    public AnimationState nantaAnimationState = new AnimationState();
    public AnimationState rightfistAnimationState = new AnimationState();
    public AnimationState leftfistAnimationState = new AnimationState();
    public AnimationState jumpingprepareAnimationState = new AnimationState();
    public AnimationState jumpingAnimationState = new AnimationState();
    public AnimationState jumpingendAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    private int nanta_cooldown = 0;
    public static final int NANTA_COOLDOWN = 160;
    private int moistureAttackTime = 0;
    private int jump_cooldown = 0;
    public static final int JUMP_COOLDOWN = 160;
    private boolean isLandNavigator;
    boolean searchingForLand;


    public Coralssus_Entity(EntityType<Coralssus_Entity> entity, World world) {
        super(entity, world);
        this.experiencePoints = 35;
        this.setStepHeight(1.25F);
        this.moveControl = new CoralssusMoveControl(this,2.5f);
        switchNavigator(false);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
    }

    protected void initGoals() {
        this.goalSelector.add(6, new CoralssusswimUpGoal(this, 1.0D, this.getWorld().getSeaLevel()));
        this.goalSelector.add(4, new MobAIFindWater(this,1.0D));
        this.goalSelector.add(4, new MobAILeaveWater(this));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(2, new InternalMoveGoal(this,false,1.0D));

        //angry
        this.goalSelector.add(1, new InternalAttackGoal(this,0,1,2,40,17,6){
            @Override
            public boolean canStart() {
                return super.canStart() && Coralssus_Entity.this.getRandom().nextFloat() * 100.0F < 16f && Coralssus_Entity.this.nanta_cooldown <= 0 && !Coralssus_Entity.this.getSwim();
            }
            @Override
            public void start() {
                super.start();
                Coralssus_Entity.this.playSound(ModSounds.CORALSSUS_ROAR, 1.0f, 1F + Coralssus_Entity.this.getRandom().nextFloat() * 0.1F);
            }
        });

        //nanta
        this.goalSelector.add(1, new InternalStateGoal(this,2,2,0,60,60){
            @Override
            public void stop() {
                super.stop();
                Coralssus_Entity.this.nanta_cooldown = NANTA_COOLDOWN;
            }
        });

        //right fist
        this.goalSelector.add(1, new InternalAttackGoal(this,0,3,0,30,8,4.5F){
            @Override
            public boolean canStart() {
                return super.canStart() && Coralssus_Entity.this.getIsRight();
            }

            @Override
            public void stop() {
                super.stop();
                Coralssus_Entity.this.setRight(!Coralssus_Entity.this.getIsRight());
            }
        });
        //left fist
        this.goalSelector.add(1, new InternalAttackGoal(this,0,4,0,30,8,4.5F){

            @Override
            public boolean canStart() {
                return super.canStart() && !Coralssus_Entity.this.getIsRight();
            }

            @Override
            public void stop() {
                super.stop();
                Coralssus_Entity.this.setRight(!Coralssus_Entity.this.getIsRight());
            }
        });
        //jump
        this.goalSelector.add(1, new Coralssus_JumpPrepareAttackGoal(this, 0,5, 6, 20, 10, 6.5F, 10f, 16F){

            @Override
            public boolean canStart() {
                return super.canStart() && !Coralssus_Entity.this.getSwim();
            }
        });

        //jump idle
        this.goalSelector.add(1, new InternalStateGoal(this, 6,6,7, 100, 100));

        //jump End
        this.goalSelector.add(0, new InternalStateGoal(this, 7, 7, 0, 20, 0){
            @Override
            public void stop() {
                super.stop();
                Coralssus_Entity.this.jump_cooldown = JUMP_COOLDOWN;
            }
        });
    }

    public static DefaultAttributeContainer.Builder coralssus() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 160)
                .add(EntityAttributes.GENERIC_ARMOR, 5)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
    }

    public EntityGroup getGroup() {
        return EntityGroup.AQUATIC;
    }

    protected int getNextAirUnderwater(int air) {
        return air;
    }

    public boolean handleFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "nanta" -> this.nantaAnimationState;
            case "angry" -> this.angryAnimationState;
            case "right_fist" -> this.rightfistAnimationState;
            case "left_fist" -> this.leftfistAnimationState;
            case "idle" -> this.idleAnimationState;
            case "jumping_prepare" -> this.jumpingprepareAnimationState;
            case "jumping" -> this.jumpingAnimationState;
            case "jumping_end" -> this.jumpingendAnimationState;
            case "death" -> this.deathAnimationState;
            default ->  new AnimationState();
        };
//        if (input == "nanta") {
//            return this.nantaAnimationState;
//        } else if (input == "angry") {
//            return this.angryAnimationState;
//        } else if (input == "right_fist") {
//            return this.rightfistAnimationState;
//        } else if (input == "left_fist") {
//            return this.leftfistAnimationState;
//        } else if (input == "idle") {
//                return this.idleAnimationState;
//        } else if (input == "jumping_prepare") {
//            return this.jumpingprepareAnimationState;
//        } else if (input == "jumping") {
//            return this.jumpingAnimationState;
//        } else if (input == "jumping_end") {
//            return this.jumpingendAnimationState;
//        } else if (input == "death") {
//            return this.deathAnimationState;
//        }else {
//            return new AnimationState();
//        }
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(MOISTNESS, 40000);
        this.dataTracker.startTracking(VARIANT, Coralssus_Entity.Variant.FIRE.id);
        this.dataTracker.startTracking(RIGHT, false);
        this.dataTracker.startTracking(CORALSSUS_SWIM, false);
    }

    public boolean isSponge() {
        String s = Formatting.strip(this.getName().getString());
        return s != null && (s.toLowerCase().contains("squarepants")) && this.getVariant() == Variant.HORN;
    }

    public EntityData initialize(ServerWorldAccess p_29678_, LocalDifficulty p_29679_, SpawnReason p_29680_, @Nullable EntityData p_29681_, @Nullable NbtCompound p_29682_) {
        this.setVariant(Variant.byId(random.nextInt(3)));
        return super.initialize(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }

    public void onTrackedDataSet(TrackedData<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.angryAnimationState.startIfNotRunning(this.age);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.nantaAnimationState.startIfNotRunning(this.age);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.rightfistAnimationState.startIfNotRunning(this.age);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.leftfistAnimationState.startIfNotRunning(this.age);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.jumpingprepareAnimationState.startIfNotRunning(this.age);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.jumpingAnimationState.startIfNotRunning(this.age);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.jumpingendAnimationState.startIfNotRunning(this.age);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfNotRunning(this.age);
                    }
                }
        }
        super.onTrackedDataSet(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.angryAnimationState.stop();
        this.nantaAnimationState.stop();
        this.rightfistAnimationState.stop();
        this.leftfistAnimationState.stop();
        this.jumpingprepareAnimationState.stop();
        this.jumpingAnimationState.stop();
        this.jumpingendAnimationState.stop();
        this.deathAnimationState.stop();
    }



    public void onDeath(DamageSource p_21014_) {
        super.onDeath(p_21014_);
        this.setAttackState(8);
    }

    public int deathtimer(){
        return 30;
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putInt("Variant", this.getVariant().id);
        compound.putInt("Moisture", this.getMoistness());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.setVariant(Coralssus_Entity.Variant.byId(compound.getInt("Variant")));
        this.setMoistness(compound.getInt("Moisture"));
    }

    public int getMoistness() {
        return this.dataTracker.get(MOISTNESS);
    }

    public void setMoistness(int p_211137_1_) {
        this.dataTracker.set(MOISTNESS, p_211137_1_);
    }

    public Coralssus_Entity.Variant getVariant() {
        return Coralssus_Entity.Variant.byId(this.dataTracker.get(VARIANT));
    }

    public void setVariant(Coralssus_Entity.Variant p_262578_) {
        this.dataTracker.set(VARIANT, p_262578_.id);
    }


    public void setRight(boolean right) {
        this.dataTracker.set(RIGHT, right);
    }

    public boolean getIsRight() {
        return this.dataTracker.get(RIGHT);
    }


    boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        } else {
            LivingEntity livingentity = this.getTarget();
            return livingentity != null && livingentity.isTouchingWater();
        }
    }

    public void travel(Vec3d p_32394_) {
        if (this.canMoveVoluntarily() && this.isTouchingWater() && this.wantsToSwim()) {
            this.updateVelocity(0.01F, p_32394_);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9D));
        } else {
            super.travel(p_32394_);
        }

    }

    public void tick() {
        super.tick();
        if (isTouchingWater() && this.isLandNavigator) {
            switchNavigator(false);
        }
        if (!isTouchingWater() && !this.isLandNavigator) {
            switchNavigator(true);
        }

        if (this.isAiDisabled()) {
            this.setAir(this.getMaxAir());
        } else {
            if (this.isWet()) {
                this.setMoistness(6000);
            } else {
                int dry = this.getWorld().isDay() ? 2 : 1;
                this.setMoistness(this.getMoistness() - dry);
                if (this.getMoistness() <= 0 && moistureAttackTime-- <= 0) {
                    this.damage(getDamageSources().dryOut(), random.nextInt(2) == 0 ? 1.0F : 0F);
                    moistureAttackTime = 20;
                }
            }
        }

        boolean flag1 = this.canInFluidType(this.getWorld().getFluidState(this.getBlockPos()));

        if(flag1){
            if(this.getWorld().isSpaceEmpty(this, this.getBoundingBox())) {
                if (!this.getSwim()) {
                    setSwim(true);
                }
            }
        }else{
            if(this.getWorld().isSpaceEmpty(this, this.getBoundingBox())) {
                if (this.getSwim()) {
                    setSwim(false);
                }
            }
        }

        if (this.getWorld().isClient()) {
            this.idleAnimationState.setRunning(!this.limbAnimator.isLimbMoving() && this.getAttackState() == 0, this.age);
        }
        if (nanta_cooldown > 0) nanta_cooldown--;
        if (jump_cooldown > 0) jump_cooldown--;
    }

    public void tickMovement() {
        super.tickMovement();

        float f1 = (float) Math.cos(Math.toRadians(this.getYaw() + 90));
        float f2 = (float) Math.sin(Math.toRadians(this.getYaw() + 90));
        if(this.getAttackState() == 2) {
            if (this.attackTicks == 6
                    || this.attackTicks == 16
                    || this.attackTicks == 26
                    || this.attackTicks == 36
                    || this.attackTicks == 46) {
                this.addVelocity(f1 * 0.5, 0, f2 * 0.5);
            }
            if (this.attackTicks == 5
                    || this.attackTicks == 30) {
                EarthQuake(3.5f,2,60);
                Makeparticle(0.5f, 3.15f, 0.2f);
            }
            if (this.attackTicks == 17) {
                EarthQuake(3.5f,2,60);
                Makeparticle(0.5f, 3.15f, -0.2f);
            }
            if (this.attackTicks == 42) {
                EarthQuake(3.5f,2,60);
                Makeparticle(0.5f, 3.15f, -0.2f);
                BlockBreaking();
            }

        }
        if(this.getAttackState() == 3) {
            if (this.attackTicks == 12) {
                EarthQuake(3.5f,2,0);
                Makeparticle(0.5f, 2.8f, 0.2f);
            }
        }
        if(this.getAttackState() == 4) {
            if (this.attackTicks == 12) {
                EarthQuake(3.5f,2,0);
                Makeparticle(0.5f,2.8f,-0.2f);
            }
        }
        if(this.getAttackState()== 6){
            if (this.isOnGround() || !this.getBlockStateAtPos().getFluidState().isEmpty()) {
                this.setAttackState(7);
            }
        }
        if(this.getAttackState()== 7){
            if (this.attackTicks == 3) {
                EarthQuake(4.5f,5,120);
                Makeparticle(0.5f,3.1f,-0.4f);
                Makeparticle(0.5f, 3.1f, 0.4f);
            }
        }


    }

    private void EarthQuake(float grow, int damage, int shieldbreakticks) {
        ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 10, 0.15f, 0, 20);
        this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
        for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(grow))) {
            if (!isTeammate(entity) && !(entity instanceof Coralssus_Entity) && entity != this) {
                launch(entity, true);
                DamageSource damagesource = this.getDamageSources().mobAttack(this);
                entity.damage(damagesource, (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) + this.random.nextInt(damage));
                if (entity.blockedByShield(damagesource) && entity instanceof PlayerEntity player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }
            }
        }
    }

    private void BlockBreaking() {
        boolean flag = false;
        if (!this.getWorld().isClient) {
            if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                Box aabb = this.getBoundingBox().expand(1.5D, 1.5D, 1.5D);
                for (BlockPos blockpos : BlockPos.iterate(MathHelper.floor(aabb.minX), MathHelper.floor(this.getY()), MathHelper.floor(aabb.minZ), MathHelper.floor(aabb.maxX), MathHelper.floor(aabb.maxY), MathHelper.floor(aabb.maxZ))) {
                    BlockState blockstate = this.getWorld().getBlockState(blockpos);
                    if (!blockstate.isAir() && blockstate.isIn(ModTag.CORALSSUS_BREAK)) {
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
        }
    }

    private void launch(LivingEntity e, boolean huge) {

        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        float f = huge ? 2F : 0.5F;
        e.addVelocity(d0 / d2 * f, huge ? 0.5D : 0.2F, d1 / d2 * f);
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

    protected void updatePassengerPosition(Entity p_289537_, Entity.PositionUpdater p_289541_) {
        super.updatePassengerPosition(p_289537_, p_289541_);
        float f = 0.5F;
        Vec3d vec3 = (new Vec3d(0.0D, 0.0D, f)).rotateY(-this.bodyYaw * ((float)Math.PI / 180F));
        p_289541_.accept(p_289537_, this.getX() + vec3.x, this.getBodyY(0.75D) + p_289537_.getHeightOffset() + 0.0D, this.getZ() + vec3.z);
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

    public boolean isTeammate(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isTeammate(entityIn)) {
            return true;
        } else if (entityIn.getType().isIn(ModTag.TEAM_THE_LEVIATHAN)) {
            return this.getScoreboardTeam() == null && entityIn.getScoreboardTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.CORALSSUS_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.CORALSSUS_DEATH;
    }

    protected SoundEvent getAmbientSound() {
        return  ModSounds.CORALSSUS_AMBIENT;
    }


    private boolean canInFluidType(FluidState fluid) {
        return fluid.isOf(Fluids.WATER);
    }

    public boolean isInSwimmingPose() {
        return this.getSwim();
    }

    public void switchNavigator(boolean onLand) {
        if (onLand) {
            this.navigation = new GroundPathNavigatorWide(this, getWorld());
            this.isLandNavigator = true;
        } else {
            this.navigation = new SemiAquaticPathNavigator(this, getWorld());
            this.isLandNavigator = false;
        }
    }

    public boolean getSwim() {
        return this.dataTracker.get(CORALSSUS_SWIM);
    }

    public void setSwim(boolean swim) {
        this.dataTracker.set(CORALSSUS_SWIM, swim);
    }


    public boolean isPushedByFluids() {
        return !this.isSwimming();
    }

    public boolean canBreatheInWater() {
        return true;
    }

    @Override
    public boolean shouldEnterWater() {
        return getMoistness() < 300;
    }

    @Override
    public boolean shouldLeaveWater() {
        return this.getTarget() != null && !this.getTarget().isTouchingWater();
    }

    @Override
    public boolean shouldStopMoving() {
        return false;
    }

    @Override
    public int getWaterSearchRange() {
        return 32;

    }

    @Override
    protected BodyControl createBodyControl() {
        return new SmartBodyHelper2(this);
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

    protected boolean closeToNextPos() {
        Path path = this.getNavigation().getCurrentPath();
        if (path != null) {
            BlockPos blockpos = path.getTarget();
            if (blockpos != null) {
                double d0 = this.squaredDistanceTo(blockpos.getX(), blockpos.getY(), blockpos.getZ());
                if (d0 < 4.0D) {
                    return true;
                }
            }
        }
        return false;
    }


    public void setSearchingForLand(boolean p_32399_) {
        this.searchingForLand = p_32399_;
    }

    public enum Variant implements StringIdentifiable {
        FIRE(0, "fire"),
        HORN(1, "horn"),
        TUBE(2, "tube");

        private static final IntFunction<Coralssus_Entity.Variant> BY_ID = ValueLists.createIdToValueFunction(Coralssus_Entity.Variant::id, values(), FIRE);
        public static final Codec<Coralssus_Entity.Variant> CODEC = StringIdentifiable.createCodec(Coralssus_Entity.Variant::values);
        final int id;
        private final String name;

        Variant(int p_262657_, String p_262679_) {
            this.id = p_262657_;
            this.name = p_262679_;
        }

        public String asString() {
            return this.name;
        }

        public int id() {
            return this.id;
        }

        public static Coralssus_Entity.Variant byId(int p_262665_) {
            return BY_ID.apply(p_262665_);
        }
    }


    class Coralssus_JumpPrepareAttackGoal extends InternalAttackGoal {
        private final float attackminrange;
        private final float random;

        public Coralssus_JumpPrepareAttackGoal(Coralssus_Entity entity, int attackstate, int attackendstate,int animationendstate,int attackMaxtick,int attackseetick,float attackminrange,float attackrange,float random) {
            super(entity,attackstate,attackendstate,animationendstate,attackMaxtick,attackseetick,attackrange);
            this.attackminrange = attackminrange;
            this.random = random;
            this.setControls(EnumSet.of(Control.MOVE,Control.LOOK,Control.JUMP));
        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return super.canStart() && target != null && this.entity.distanceTo(target) > attackminrange && this.entity.getRandom().nextFloat() * 100.0F < random && Coralssus_Entity.this.jump_cooldown <= 0;
        }
        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (this.entity.attackTicks == 13) {
                if (target != null) {
                    this.entity.getLookControl().lookAt(target, 60.0F, 30.0F);
                    Vec3d vec3 = (new Vec3d(target.getX() - this.entity.getX(), target.getY() - this.entity.getY(), target.getZ() - this.entity.getZ())).normalize();
                    this.entity.setVelocity(this.entity.getVelocity().add(vec3.x * 0.8D, 1.0D, vec3.z * 0.8D));
                }else{
                    this.entity.setVelocity(this.entity.getVelocity().add(0.0F, 1.0D, 0.0F));
                }
            }
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }
    }

    static class CoralssusswimUpGoal extends Goal {
        private final Coralssus_Entity drowned;
        private final double speedModifier;
        private final int seaLevel;
        private boolean stuck;

        public CoralssusswimUpGoal(Coralssus_Entity p_32440_, double p_32441_, int p_32442_) {
            this.drowned = p_32440_;
            this.speedModifier = p_32441_;
            this.seaLevel = p_32442_;
        }

        public boolean canStart() {
            return (this.drowned.getWorld().isRaining() || this.drowned.isTouchingWater())&& this.drowned.getY() < (double)(this.seaLevel - 2);
        }

        public boolean shouldContinue() {
            return this.canStart() && !this.stuck;
        }

        public void tick() {
            if (this.drowned.getY() < (double)(this.seaLevel - 1) && (this.drowned.getNavigation().isIdle() || this.drowned.closeToNextPos())) {
                Vec3d vec3 = NoPenaltyTargeting.findTo(this.drowned, 4, 8, new Vec3d(this.drowned.getX(), this.seaLevel - 1, this.drowned.getZ()), (float)Math.PI / 2F);
                if (vec3 == null) {
                    this.stuck = true;
                    return;
                }

                this.drowned.getNavigation().startMovingTo(vec3.x, vec3.y, vec3.z, this.speedModifier);
            }

        }

        public void start() {
            this.drowned.setSearchingForLand(true);
            this.stuck = false;
        }

        public void stop() {
            this.drowned.setSearchingForLand(false);
        }
    }


    static class CoralssusMoveControl extends MoveControl {
        private final Coralssus_Entity drowned;
        private final float speedMulti;

        public CoralssusMoveControl(Coralssus_Entity p_32433_, float speedMulti) {
            super(p_32433_);
            this.drowned = p_32433_;
            this.speedMulti = speedMulti;
        }

        public void tick() {
            LivingEntity livingentity = this.drowned.getTarget();
            if (this.drowned.wantsToSwim() && this.drowned.isTouchingWater()) {
                if (livingentity != null && livingentity.getY() > this.drowned.getY() || this.drowned.searchingForLand) {
                    this.drowned.setVelocity(this.drowned.getVelocity().add(0.0D, 0.002D, 0.0D));
                }

                if (this.state != State.MOVE_TO || this.drowned.getNavigation().isIdle()) {
                    this.drowned.setMovementSpeed(0.0F);
                    return;
                }

                double d0 = this.targetX - this.drowned.getX();
                double d1 = this.targetY - this.drowned.getY();
                double d2 = this.targetZ - this.drowned.getZ();
                double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                d1 /= d3;
                float f = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
                this.drowned.setYaw(this.wrapDegrees(this.drowned.getYaw(), f, 90.0F));
                this.drowned.bodyYaw = this.drowned.getYaw();
                float f1 = (float)(this.speed * speedMulti * this.drowned.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
                float f2 = MathHelper.lerp(0.125F, this.drowned.getMovementSpeed(), f1);
                this.drowned.setMovementSpeed(f2);
                this.drowned.setVelocity(this.drowned.getVelocity().add((double)f2 * d0 * 0.005D, (double)f2 * d1 * 0.1D, (double)f2 * d2 * 0.005D));
            } else {
                if (!this.drowned.isOnGround()) {
                    this.drowned.setVelocity(this.drowned.getVelocity().add(0.0D, -0.008D, 0.0D));
                }

                super.tick();
            }

        }
    }
}





