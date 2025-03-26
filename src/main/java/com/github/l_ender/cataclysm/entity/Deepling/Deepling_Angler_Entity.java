package com.github.l_ender.cataclysm.entity.Deepling;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import net.minecraft.block.BlockState;
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
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundEvent;
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

public class Deepling_Angler_Entity extends AbstractDeepling {
    boolean searchingForLand;
    public static final Animation DEEPLING_MELEE = Animation.create(20);
    public static final Animation DEEPLING_HUG = Animation.create(20);
    private static final EntityDimensions SWIMMING_SIZE = EntityDimensions.fixed(1.225f, 0.65F);
    private int hugcooldown = 100;
    public static final int HUG_COOLDOWN = 100;


    public Deepling_Angler_Entity(EntityType entity, World world) {
        super(entity, world);
        this.moveControl = new DeeplingMoveControl(this,2.0f);
        switchNavigator(false);
        this.experiencePoints = 8;

    }

    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(5, new DeeplingGoToBeachGoal(this, 1.0D));
        this.goalSelector.add(6, new DeeplingSwimUpGoal(this, 1.0D, this.getWorld().getSeaLevel()));
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
        this.goalSelector.add(3, new AnimationMeleeAttackGoal(this, 1.0f, false));
    }

    public static DefaultAttributeContainer.Builder deepling() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.27F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.25);
    }


    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
    }

    protected EntityNavigation createNavigation(World worldIn) {
        return new SwimNavigation(this, worldIn);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);

    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
    }
    protected void initEquipment(Random p_219154_, LocalDifficulty p_219155_) {
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.FISHING_ROD));
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
        return ModEntities.rollSpawn(CMConfig.DeeplingAnglerSpawnRolls, this.getRandom(), spawnReasonIn);
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess p_34088_, LocalDifficulty p_34089_, SpawnReason p_34090_, @Nullable EntityData p_34091_) {
        EntityData spawngroupdata = super.initialize(p_34088_, p_34089_, p_34090_, p_34091_);
        Random randomsource = p_34088_.getRandom();
        this.initEquipment(randomsource, p_34089_);
        Lionfish_Entity drowned = ModEntities.LIONFISH.create(getWorld());
        drowned.initialize(p_34088_, p_34089_, p_34090_, p_34091_);
        drowned.copyPositionAndRotation(this);
        drowned.attachLeash(this, true);
        p_34088_.spawnEntity(drowned);
        return spawngroupdata;
    }
    public boolean canSpawn(WorldView p_32829_) {
        return p_32829_.doesNotIntersectEntities(this);
    }

    public static boolean candeeplingSpawn(EntityType<? extends Deepling_Angler_Entity> guardian, WorldAccess level, SpawnReason spawnType, BlockPos pos, Random random) {
        return level.getDifficulty() != Difficulty.PEACEFUL && (SpawnReason.isAnySpawner(spawnType) || level.getFluidState(pos).isIn(FluidTags.WATER));
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, DEEPLING_MELEE,DEEPLING_HUG};
    }


    @Override
    public void tick() {
        super.tick();
        LivingEntity target = this.getTarget();
        if (hugcooldown > 0) {
            hugcooldown--;
        }

        if(this.isAlive()) {
            if (this.getAnimation() == DEEPLING_MELEE) {
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
            if (this.getAnimation() == DEEPLING_HUG) {
                if (this.getAnimationTick() == 9) {
                    this.playSound(ModSounds.DEEPLING_SWING, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
                    if (target != null) {
                        if (this.distanceTo(target) < 3.0F) {
                            float damage = (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                            boolean flag = target.damage(getDamageSources().mobAttack(this), damage);
                            if(flag){
                                target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60, 1), this);
                            }
                        }
                    }
                }
            }

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

    public EntityDimensions getSwimmingSize() {
        return SWIMMING_SIZE;
    }

    public Box getSwimmingBox() {
        return new Box(this.getX()- 1.225f, this.getY(), this.getZ() -1.225f,  this.getX() + 1.225f, this.getY()+ 0.65f, this.getZ() + 1.225f);
    }

    public Box getNormalBox() {
        return new Box(this.getX()- 0.65f, this.getY(), this.getZ() -0.65f,  this.getX() + 0.65f, this.getY()+ 2.45f, this.getZ() + 0.65f);
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
        private final Deepling_Angler_Entity drowned;

        public DeeplingGoToBeachGoal(Deepling_Angler_Entity p_32409_, double p_32410_) {
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
            super.start();
        }

        public void stop() {
            super.stop();
        }
    }

    static class DeeplingSwimUpGoal extends Goal {
        private final Deepling_Angler_Entity drowned;
        private final double speedModifier;
        private final int seaLevel;
        private boolean stuck;

        public DeeplingSwimUpGoal(Deepling_Angler_Entity p_32440_, double p_32441_, int p_32442_) {
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

    static class AnimationMeleeAttackGoal extends MeleeAttackGoal {
        protected final Deepling_Angler_Entity mob;


        public AnimationMeleeAttackGoal(Deepling_Angler_Entity p_25552_, double p_25553_, boolean p_25554_) {
            super(p_25552_,p_25553_,p_25554_);
            this.mob = p_25552_;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }


        protected void attack(LivingEntity p_25557_) {
            if (this.canAttack(p_25557_)) {
                if( this.mob.hugcooldown <= 0){
                    this.mob.setAnimation(DEEPLING_HUG);
                    this.mob.hugcooldown = HUG_COOLDOWN;
                }else{
                    this.mob.setAnimation(DEEPLING_MELEE);
                }
            }

        }
    }

    static class DeeplingMoveControl extends MoveControl {
        private final Deepling_Angler_Entity drowned;
        private final float speedMulti;

        public DeeplingMoveControl(Deepling_Angler_Entity p_32433_, float speedMulti) {
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
