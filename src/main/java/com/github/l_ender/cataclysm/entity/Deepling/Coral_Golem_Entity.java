package com.github.l_ender.cataclysm.entity.Deepling;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AI.CmAttackGoal;
import com.github.l_ender.cataclysm.entity.AI.MobAIFindWater;
import com.github.l_ender.cataclysm.entity.AI.MobAILeaveWater;
import com.github.l_ender.cataclysm.entity.AnimationMonster.AI.AttackAnimationGoal1;
import com.github.l_ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.l_ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.entity.etc.*;
import com.github.l_ender.cataclysm.entity.etc.path.GroundPathNavigatorWide;
import com.github.l_ender.cataclysm.entity.etc.path.SemiAquaticPathNavigator;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.world.data.CMWorldData;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.AnimationHandler;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.NoPenaltyTargeting;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MoveToTargetPosGoal;
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
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;


import org.jetbrains.annotations.Nullable;
import java.util.EnumSet;


public class Coral_Golem_Entity extends LLibrary_Monster implements ISemiAquatic {
    private boolean isLandNavigator;
    boolean searchingForLand;
    public static final Animation CORAL_GOLEM_LEAP = Animation.create(100);
    public static final Animation CORAL_GOLEM_SMASH = Animation.create(23);
    public static final Animation CORAL_GOLEM_LEFT_SMASH = Animation.create(36);
    public static final Animation CORAL_GOLEM_RIGHT_SMASH = Animation.create(36);
    public static final int LEAP_ATTACK_COOLDOWN = 160;
    private int leap_attack_cooldown = 0;

    private static final TrackedData<Boolean> GOLEMSWIM = DataTracker.registerData(Coral_Golem_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);


    public Coral_Golem_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 15;
        this.moveControl = new GolemMoveControl(this,2.0f);
        switchNavigator(false);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION,CORAL_GOLEM_SMASH,CORAL_GOLEM_LEFT_SMASH,CORAL_GOLEM_RIGHT_SMASH,CORAL_GOLEM_LEAP};
    }

    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(5, new GolemGoToBeachGoal(this, 1.0D));
        this.goalSelector.add(6, new GolemSwimUpGoal(this, 1.0D, this.getWorld().getSeaLevel()));
        this.goalSelector.add(4, new MobAIFindWater(this,1.0D));
        this.goalSelector.add(4, new MobAILeaveWater(this));
        this.goalSelector.add(0, new AttackAnimationGoal1<>(this, CORAL_GOLEM_LEFT_SMASH, 16, true));
        this.goalSelector.add(0, new AttackAnimationGoal1<>(this, CORAL_GOLEM_RIGHT_SMASH, 16, true));
        this.goalSelector.add(0, new Leap(this, CORAL_GOLEM_LEAP));
        this.goalSelector.add(0, new SimpleAnimationGoal<>(this, CORAL_GOLEM_SMASH));
        this.goalSelector.add(2, new CmAttackGoal(this, 1.0D));
        this.goalSelector.add(7, new WanderAroundGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder coralgolem() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 11)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 110)
                .add(EntityAttributes.GENERIC_ARMOR, 5)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.5)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.8);
    }





    @Override
    public boolean damage(DamageSource source, float damage) {
        return super.damage(source, damage);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
        p_326229_.add(GOLEMSWIM, false);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);


    }
    @Override
    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);

    }

    public boolean canSpawn(WorldAccess worldIn, SpawnReason spawnReasonIn) {
        if (ModEntities.rollSpawn(CMConfig.CoralgolemSpawnRolls, this.getRandom(), spawnReasonIn) && worldIn instanceof ServerWorld serverLevel && super.canSpawn(worldIn, spawnReasonIn)) {
            CMWorldData data = CMWorldData.get(serverLevel,World.OVERWORLD);
            return data != null && data.isLeviathanDefeatedOnce();
        }
        return false;
    }

    public boolean canSpawn(WorldView p_32829_) {
        return p_32829_.doesNotIntersectEntities(this);
    }

    public static boolean cangolemSpawn(EntityType<? extends Coral_Golem_Entity> guardian, WorldAccess level, SpawnReason spawnType, BlockPos pos, Random random) {
        return level.getDifficulty() != Difficulty.PEACEFUL && (SpawnReason.isAnySpawner(spawnType) || level.getFluidState(pos).isIn(FluidTags.WATER));
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

        boolean flag1 = this.canInFluidType(this.getWorld().getFluidState(new BlockPos(this.getBlockPos())));

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


        if (leap_attack_cooldown > 0) leap_attack_cooldown--;
        LivingEntity target = this.getTarget();
        if (this.isAlive()) {
            if (target != null && target.isAlive()) {
                if (!this.getSwim() &&leap_attack_cooldown <= 0 && !isAiDisabled() && this.getAnimation() == NO_ANIMATION && target.isOnGround() && (this.random.nextInt(25) == 0 && this.distanceTo(target) <= 15)) {
                    leap_attack_cooldown = LEAP_ATTACK_COOLDOWN;
                    this.setAnimation(CORAL_GOLEM_LEAP);
                }else if (this.distanceTo(target) < 3.75f && !isAiDisabled() && this.getAnimation() == NO_ANIMATION) {
                    Animation animation = getRandomAttack(random);
                    this.setAnimation(animation);
                }
            }
        }
    }

    public void tickMovement() {
        super.tickMovement();
        if (this.getAnimation() == CORAL_GOLEM_RIGHT_SMASH) {
            if (this.getAnimationTick() == 16) {
                EarthQuake(3.0f,2);
                Makeparticle(2.0f,-0.5f);
            }
        }
        if(this.getAnimation() == CORAL_GOLEM_LEFT_SMASH){
            if (this.getAnimationTick() == 16) {
                EarthQuake(3.0f,2);
                Makeparticle(2.0f,0.5f);
            }
        }
        if(this.getAnimation() == CORAL_GOLEM_SMASH){
            if (this.getAnimationTick() == 2) {
                EarthQuake(4.0f,4);
                Makeparticle(2.25f,1.25f);
                Makeparticle(2.25f,-1.25f);
            }
        }

    }


    private void Makeparticle(float vec, float math) {
        if (this.getWorld().isClient) {
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float f = MathHelper.cos(this.bodyYaw * ((float) Math.PI / 180F));
                float f1 = MathHelper.sin(this.bodyYaw * ((float) Math.PI / 180F));
                float angle = (0.01745329251F * this.bodyYaw) + i1;
                double extraX = 0.75F * MathHelper.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = 0.75F * MathHelper.cos(angle);
                double theta = (bodyYaw) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int hitX = MathHelper.floor(getX() + vec * vecX + extraX);
                int hitY = MathHelper.floor(getY());
                int hitZ = MathHelper.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = getWorld().getBlockState(hit.down());
                if (block.getRenderType() != BlockRenderType.INVISIBLE) {
                    this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }
            }
        }
    }


    protected void updatePassengerPosition(Entity p_289537_, PositionUpdater p_289541_) {
        super.updatePassengerPosition(p_289537_, p_289541_);
        float radius = 0.5F;
        float angle = (0.01745329251F * this.bodyYaw);
        double extraX = radius * MathHelper.sin((float) (Math.PI + angle));
        double extraZ = radius * MathHelper.cos(angle);


        Vec3d vec3 = this.getPassengerRidingPos(p_289537_);
        Vec3d vec31 = p_289537_.getVehicleAttachmentPos(this);

        double px = vec3.x - vec31.x + extraX;
        double pz = vec3.z - vec31.z + extraZ;

        p_289541_.accept(p_289537_, px, this.getBodyY(0.65D), pz);
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }


    private void EarthQuake(float grow, int damage) {
        ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 10, 0.15f, 0, 20);
        this.playSound(ModSounds.EXPLOSION, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
        for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(grow))) {
            if (!isTeammate(entity) && !(entity instanceof Coral_Golem_Entity) && entity != this) {
                entity.damage(this.getDamageSources().mobAttack(this), (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) + this.random.nextInt(damage));
                launch(entity, true);

            }
        }
    }


    private static Animation getRandomAttack(Random rand) {
        return switch (rand.nextInt(2)) {
            case 0 -> CORAL_GOLEM_RIGHT_SMASH;
            case 1 -> CORAL_GOLEM_LEFT_SMASH;
            default -> CORAL_GOLEM_RIGHT_SMASH;
        };
    }



    private void launch(LivingEntity e, boolean huge) {

        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        float f = huge ? 2F : 0.5F;
        e.addVelocity(d0 / d2 * f, huge ? 0.5D : 0.2F, d1 / d2 * f);
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



    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_IRON_GOLEM_STEP, 1.0F, 1.0F);
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.CORAL_GOLEM_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.CORAL_GOLEM_DEATH;
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
        return this.dataTracker.get(GOLEMSWIM);
    }

    public void setSwim(boolean swim) {
        this.dataTracker.set(GOLEMSWIM, swim);
    }


    
        


    public boolean isPushedByFluids() {
        return !this.isSwimming();
    }



    @Override
    public boolean shouldEnterWater() {
        return false;
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

    static class GolemGoToBeachGoal extends MoveToTargetPosGoal {
        private final Coral_Golem_Entity drowned;

        public GolemGoToBeachGoal(Coral_Golem_Entity p_32409_, double p_32410_) {
            super(p_32409_, p_32410_, 8, 2);
            this.drowned = p_32409_;
        }

        public boolean canStart() {
            return super.canStart() && this.drowned.getWorld().isRaining() && this.drowned.isTouchingWater() && this.drowned.getY() >= (double)(this.drowned.getWorld().getSeaLevel() - 3);
        }

        public boolean shouldContinue() {
            return super.shouldContinue();
        }

        protected boolean isTargetPos(WorldView p_32413_, BlockPos p_32414_) {
            BlockPos blockpos = p_32414_.up();
            return p_32413_.isAir(blockpos) && p_32413_.isAir(blockpos.up()) && p_32413_.getBlockState(p_32414_).hasSolidTopSurface(p_32413_, p_32414_, this.drowned);
        }

        public void start() {
            this.drowned.setSearchingForLand(false);
            // this.drowned.switchNavigator(true);
            super.start();
        }

        public void stop() {
            super.stop();
        }
    }

    static class GolemSwimUpGoal extends Goal {
        private final Coral_Golem_Entity drowned;
        private final double speedModifier;
        private final int seaLevel;
        private boolean stuck;

        public GolemSwimUpGoal(Coral_Golem_Entity p_32440_, double p_32441_, int p_32442_) {
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

    static class Leap extends SimpleAnimationGoal<Coral_Golem_Entity> {
        private final Coral_Golem_Entity drowned;

        public Leap(Coral_Golem_Entity entity, Animation animation) {
            super(entity, animation);
            this.drowned = entity;
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
        }

        public void tick() {
            LivingEntity target = this.drowned.getTarget();
            if (target != null) {
                this.drowned.lookAtEntity(target, 30.0F, 30.0F);
                this.drowned.getLookControl().lookAt(target, 30.0F, 30.0F);
                if(this.drowned.getAnimationTick() == 22) {
                    double d0 = target.getX() - this.drowned.getX();
                    double d1 = target.getY() - this.drowned.getY();
                    double d2 = target.getZ() - this.drowned.getZ();
                    this.drowned.setVelocity(d0 * 0.15D, 0.75 + MathHelper.clamp(d1 * 0.05D, 0, 10), d2 * 0.15D);
                }
            }else{
                if(this.drowned.getAnimationTick() == 22) {
                    this.drowned.setVelocity(0, 0.75, 0);
                }
            }

            if (this.drowned.getAnimationTick() > 22 && this.drowned.isOnGround()) {
                AnimationHandler.INSTANCE.sendAnimationMessage(this.drowned, CORAL_GOLEM_SMASH);
            }

        }
    }

    static class GolemMoveControl extends MoveControl {
        private final Coral_Golem_Entity drowned;
        private final float speedMulti;

        public GolemMoveControl(Coral_Golem_Entity p_32433_, float speedMulti) {
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





