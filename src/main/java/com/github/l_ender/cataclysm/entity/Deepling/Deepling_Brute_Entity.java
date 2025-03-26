package com.github.l_ender.cataclysm.entity.Deepling;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.projectile.ThrownCoral_Bardiche_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.NoPenaltyTargeting;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveToTargetPosGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;
import java.util.EnumSet;
import java.util.List;

public class Deepling_Brute_Entity extends AbstractDeepling {
    boolean searchingForLand;
    public static final Animation DEEPLING_BRUTE_TRIDENT_THROW = Animation.create(45);
    public static final Animation DEEPLING_BRUTE_MELEE = Animation.create(20);
    private int SpinAttackTicks;
    private static final TrackedData<Boolean> SPINATTACK = DataTracker.registerData(Deepling_Brute_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final EntityDimensions SWIMMING_SIZE = EntityDimensions.fixed(1.3f, 0.7F);
    public Deepling_Brute_Entity(EntityType entity, World world) {
        super(entity, world);
        this.moveControl = new DeeplingMoveControl(this,2.0f);
        switchNavigator(false);
        this.experiencePoints = 15;
      
    }

    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(2, new DeeplingBruteTridentShoot(this, 1.0D, 15.0F));
        this.goalSelector.add(5, new DeeplingGoToBeachGoal(this, 1.0D));
        this.goalSelector.add(6, new DeeplingSwimUpGoal(this, 1.0D, this.getWorld().getSeaLevel()));
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
        this.goalSelector.add(3, new AnimationMeleeAttackGoal(this, 1.1f, false));
    }

    public static DefaultAttributeContainer.Builder deeplingbrute() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.29F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 60)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20)
                .add(EntityAttributes.GENERIC_ARMOR, 8)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.35);
    }


    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
        p_326229_.add(SPINATTACK, false);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putInt("Moisture", this.getMoistness());

    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.setMoistness(compound.getInt("Moisture"));

    }

    protected void initEquipment(Random p_219154_, LocalDifficulty p_219155_) {
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.CORAL_BARDICHE));
    }


    protected SoundEvent getAmbientSound() {
        return ModSounds.DEEPLING_IDLE;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.DEEPLING_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.DEEPLING_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(ModSounds.DEEPLING_IDLE, 0.15F, 0.6F);
    }

    public boolean canSpawn(WorldAccess worldIn, SpawnReason spawnReasonIn) {
        return ModEntities.rollSpawn(CMConfig.DeeplingBruteSpawnRolls, this.getRandom(), spawnReasonIn);
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess p_34088_, LocalDifficulty p_34089_, SpawnReason p_34090_, @Nullable EntityData p_34091_) {
        EntityData spawngroupdata = super.initialize(p_34088_, p_34089_, p_34090_, p_34091_);
        Random randomsource = p_34088_.getRandom();
        this.initEquipment(randomsource, p_34089_);
        return spawngroupdata;
    }
    public boolean canSpawn(WorldView p_32829_) {
        return p_32829_.doesNotIntersectEntities(this);
    }


    public static boolean candeeplingSpawn(EntityType<? extends Deepling_Brute_Entity> guardian, WorldAccess level, SpawnReason spawnType, BlockPos pos, Random random) {
        return level.getDifficulty() != Difficulty.PEACEFUL && (SpawnReason.isAnySpawner(spawnType) || level.getFluidState(pos).isIn(FluidTags.WATER));
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, DEEPLING_BRUTE_TRIDENT_THROW, DEEPLING_BRUTE_MELEE};
    }


    public boolean getSpinAttack() {
        return this.dataTracker.get(SPINATTACK);
    }

    public void setSpinAttack(boolean p_211137_1_) {
        this.dataTracker.set(SPINATTACK, p_211137_1_);
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity target = this.getTarget();
        if(this.isAlive()) {
            if (this.getAnimation() == DEEPLING_BRUTE_TRIDENT_THROW) {
                if (target != null) {
                    if (this.getAnimationTick() == 11) {
                        if(this.isTouchingWaterOrRain() && !this.hasVehicle()) {
                            double f1 = target.getX() - this.getX();
                            double f2 = target.getY() - this.getY();
                            double f3 = target.getZ() - this.getZ();
                            double f4 = MathHelper.sqrt((float) (f1 * f1 + f2 * f2 + f3 * f3));
                            float f5 = 2.0F;
                            f1 *= f5 / f4;
                            f2 *= f5 / f4;
                            f3 *= f5 / f4;
                            this.addVelocity(f1, f2, f3);
                            this.startAutoSpinAttack(20);
                            if (this.isOnGround()) {
                                this.move(MovementType.SELF, new Vec3d(0.0D, 1.1999999F, 0.0D));
                            }
                            this.playSound( SoundEvents.ITEM_TRIDENT_RIPTIDE_3.value(),1.0F, 1.0F);
                        }else{
                            ThrownCoral_Bardiche_Entity throwntrident = new ThrownCoral_Bardiche_Entity(this.getWorld(), this, new ItemStack(ModItems.CORAL_BARDICHE));
                            double p0 = target.getX() - this.getX();
                            double p1 = target.getBodyY(0.3333333333333333D) - throwntrident.getY();
                            double p2 = target.getZ() - this.getZ();
                            double p3 = Math.sqrt(p0 * p0 + p2 * p2);
                            throwntrident.setVelocity(p0, p1 + p3 * (double) 0.2F, p2, 1.6F, (float) (14 - this.getWorld().getDifficulty().getId() * 4));
                            this.playSound(SoundEvents.ENTITY_DROWNED_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
                            this.getWorld().spawnEntity(throwntrident);
                        }
                    }
                }
            }
            if (this.getAnimation() == DEEPLING_BRUTE_MELEE) {
                if (this.getAnimationTick() == 5) {
                    this.playSound(ModSounds.DEEPLING_SWING, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
                    if (target != null) {
                        if (this.distanceTo(target) < 3.0F) {
                            float damage = (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                            target.damage(getDamageSources().mobAttack(this), damage);
                        }
                    }
                }
            }
        }
        Box aabb = this.getBoundingBox();
        if (this.SpinAttackTicks > 0) {
            --this.SpinAttackTicks;
            this.tickRiptide(aabb, this.getBoundingBox());
        }

    }


    public void startAutoSpinAttack(int p_204080_) {
        this.SpinAttackTicks = p_204080_;
        if (!this.getWorld().isClient) {
            this.setSpinAttack(true);
        }

    }

    protected void tickRiptide(Box p_21072_, Box p_21073_) {
        Box aabb = p_21072_.union(p_21073_);
        List<Entity> list = this.getWorld().getOtherEntities(this, aabb);
        if (!list.isEmpty()) {
            for (Entity entity : list) {
                if (entity instanceof LivingEntity) {
                    entity.damage(getDamageSources().mobAttack(this), (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE));
                    this.SpinAttackTicks = 0;
                    this.setVelocity(this.getVelocity().multiply(-0.2D));
                    break;
                }
            }
        } else if (this.horizontalCollision) {
            this.SpinAttackTicks = 0;
        }

        if (!this.getWorld().isClient && this.SpinAttackTicks <= 0) {
            this.setSpinAttack(false);
        }

    }


    boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        } else {
            LivingEntity livingentity = this.getTarget();
            return livingentity != null && livingentity.isTouchingWater();
        }
    }

    public Box getSwimmingBox() {
        return new Box(this.getX()- 1.3f, this.getY(), this.getZ() -1.3f,  this.getX() + 1.3f, this.getY()+ 0.7f, this.getZ() + 1.3f);
    }

    public Box getNormalBox() {
        return new Box(this.getX()- 0.7f, this.getY(), this.getZ() - 0.7f,  this.getX() + 0.7f, this.getY()+ 2.6f, this.getZ() + 0.7f);
    }

    public EntityDimensions getSwimmingSize() {
        return SWIMMING_SIZE;
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

    @Override
    protected Box getAttackBox() {
        Box aabb = super.getAttackBox();
        return aabb.contract(0.05, 0.0, 0.05);
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

    static class DeeplingGoToBeachGoal extends MoveToTargetPosGoal {
        private final Deepling_Brute_Entity drowned;

        public DeeplingGoToBeachGoal(Deepling_Brute_Entity p_32409_, double p_32410_) {
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
            return p_32413_.isAir(blockpos) && p_32413_.isAir(blockpos.up()) ? p_32413_.getBlockState(p_32414_).hasSolidTopSurface(p_32413_, p_32414_, this.drowned) : false;
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

    static class DeeplingSwimUpGoal extends Goal {
        private final Deepling_Brute_Entity drowned;
        private final double speedModifier;
        private final int seaLevel;
        private boolean stuck;

        public DeeplingSwimUpGoal(Deepling_Brute_Entity p_32440_, double p_32441_, int p_32442_) {
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

    static class DeeplingBruteTridentShoot extends Goal {
        private final Deepling_Brute_Entity mob;
        private final double moveSpeedAmp;
        private int attackCooldown;
        private final float maxAttackDistance;
        private int attackTime = -1;
        private int seeTime;
        private boolean strafingClockwise;
        private boolean strafingBackwards;
        private int strafingTime = -1;


        public DeeplingBruteTridentShoot(Deepling_Brute_Entity mob, double moveSpeedAmpIn, float maxAttackDistanceIn) {
            this.mob = mob;
            this.moveSpeedAmp = moveSpeedAmpIn;
            this.maxAttackDistance = maxAttackDistanceIn * maxAttackDistanceIn;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }

        public boolean canStart() {
            LivingEntity livingentity = this.mob.getTarget();
            return livingentity != null && livingentity.isAlive() && this.mob.getMainHandStack().isOf(ModItems.CORAL_BARDICHE) && this.mob.squaredDistanceTo(livingentity) >= 36.0D;
        }


        public boolean shouldContinue() {
            return (this.canStart() || !this.mob.getNavigation().isIdle()) ;
        }

        public void start() {
            super.start();
            this.mob.setAttacking(true);
            this.mob.setCurrentHand(Hand.MAIN_HAND);
        }


        public void stop() {
            super.stop();
            this.mob.setAttacking(false);
            this.seeTime = 0;
            this.attackTime = -1;
            this.mob.clearActiveItem();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            LivingEntity livingentity = this.mob.getTarget();

            if (livingentity != null) {
                double d0 = this.mob.squaredDistanceTo(livingentity.getX(), livingentity.getY(), livingentity.getZ());
                boolean flag = this.mob.canSee(livingentity);
                boolean flag1 = this.seeTime > 0;
                if (flag != flag1) {
                    this.seeTime = 0;
                }

                if (flag) {
                    ++this.seeTime;
                } else {
                    --this.seeTime;
                }

                if (!(d0 > (double)this.maxAttackDistance) && this.seeTime >= 20) {
                    this.mob.getNavigation().stop();
                    ++this.strafingTime;
                } else {
                    this.mob.getNavigation().startMovingTo(livingentity, this.moveSpeedAmp);
                    this.strafingTime = -1;
                }

                if (this.strafingTime >= 20) {
                    if ((double)this.mob.getRandom().nextFloat() < 0.3D) {
                        this.strafingClockwise = !this.strafingClockwise;
                    }

                    if ((double)this.mob.getRandom().nextFloat() < 0.3D) {
                        this.strafingBackwards = !this.strafingBackwards;
                    }

                    this.strafingTime = 0;
                }

                if (this.strafingTime > -1) {
                    if (d0 > (double)(this.maxAttackDistance * 0.75F)) {
                        this.strafingBackwards = false;
                    } else if (d0 < (double)(this.maxAttackDistance * 0.25F)) {
                        this.strafingBackwards = true;
                    }

                    this.mob.getMoveControl().strafeTo(this.strafingBackwards ? -0.5F : 0.5F, this.strafingClockwise ? 0.5F : -0.5F);
                    this.mob.lookAtEntity(livingentity, 30.0F, 30.0F);
                } else {
                    this.mob.getLookControl().lookAt(livingentity, 30.0F, 30.0F);
                }
                if (!flag && this.seeTime < -60) {
                    this.mob.clearActiveItem();
                } else if (flag) {
                    if(mob.getAnimation() != DEEPLING_BRUTE_TRIDENT_THROW){
                        mob.setAnimation(DEEPLING_BRUTE_TRIDENT_THROW);
                        this.attackTime = this.attackCooldown;



                    }
                }
            }
        }
    }

    static class AnimationMeleeAttackGoal extends MeleeAttackGoal {
        protected final Deepling_Brute_Entity mob;


        public AnimationMeleeAttackGoal(Deepling_Brute_Entity p_25552_, double p_25553_, boolean p_25554_) {
            super(p_25552_,p_25553_,p_25554_);
            this.mob = p_25552_;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }


        protected void attack(LivingEntity p_25557_) {
            if (this.canAttack(p_25557_)) {
                if (this.mob.getAnimation() == NO_ANIMATION) {
                    this.mob.setAnimation(DEEPLING_BRUTE_MELEE);
                }
            }
        }
    }

    static class DeeplingMoveControl extends MoveControl {
        private final Deepling_Brute_Entity drowned;
        private final float speedMulti;

        public DeeplingMoveControl(Deepling_Brute_Entity p_32433_, float speedMulti) {
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
