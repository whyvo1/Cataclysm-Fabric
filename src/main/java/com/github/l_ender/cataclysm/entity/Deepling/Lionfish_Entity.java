package com.github.l_ender.cataclysm.entity.Deepling;

import com.github.l_ender.cataclysm.entity.AI.AnimalAIRandomSwimming;
import com.github.l_ender.cataclysm.entity.AI.EntityAINearestTarget3D;
import com.github.l_ender.cataclysm.entity.etc.AquaticMoveController;
import com.github.l_ender.cataclysm.entity.etc.path.SemiAquaticPathNavigator;
import com.github.l_ender.cataclysm.entity.projectile.Lionfish_Spike_Entity;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.AnimationHandler;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveIntoWaterGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.EnumSet;

public class Lionfish_Entity extends HostileEntity implements IAnimatedEntity {

    public static final Animation LIONFISH_BITE = Animation.create(19);
    private int animationTick;
    private Animation currentAnimation;
    public float prevOnLandProgress;
    public float onLandProgress;
    public float LayerBrightness, oLayerBrightness;
    public int LayerTicks;

    public Lionfish_Entity(EntityType<? extends HostileEntity> monster, World level) {
        super(monster, level);
        this.experiencePoints = 5;
        this.moveControl = new AquaticMoveController(this, 1.0F, 15F);
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER_BORDER, 0.0F);
    }

    protected EntityNavigation createNavigation(World worldIn) {
        return new SemiAquaticPathNavigator(this, worldIn);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PUFFER_FISH_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PUFFER_FISH_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource p_29628_) {
        return SoundEvents.ENTITY_PUFFER_FISH_HURT;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_PUFFER_FISH_FLOP;
    }

    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_FISH_SWIM;
    }

    protected void initGoals() {
        this.goalSelector.add(1, new MoveIntoWaterGoal(this));
        this.goalSelector.add(2, new AnimationMeleeAttackGoal(this, 1.0f, false));
        this.goalSelector.add(3, new AnimalAIRandomSwimming(this, 1F, 12, 5));
        this.targetSelector.add(1, new RevengeGoal(this, AbstractDeepling.class, Lionfish_Entity.class));
        this.targetSelector.add(2, new EntityAINearestTarget3D<>(this, PlayerEntity.class, true));

    }

    protected void initDataTracker() {
        super.initDataTracker();
    }

    public static DefaultAttributeContainer.Builder lionfish() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 12.0D);
    }

    public EntityGroup getGroup() {
        return EntityGroup.AQUATIC;
    }

    protected float getActiveEyeHeight(EntityPose poseIn, EntityDimensions sizeIn) {
        return sizeIn.height * 0.45F;
    }

    public boolean damage(DamageSource p_32820_, float p_32821_) {
        if (this.getWorld().isClient) {
            return false;
        } else {
            if (!p_32820_.isIn(DamageTypeTags.AVOIDS_GUARDIAN_THORNS) && !p_32820_.isOf(DamageTypes.THORNS)) {
                Entity entity = p_32820_.getSource();
                if (entity instanceof LivingEntity livingentity) {
                    if (livingentity.damage(getDamageSources().thorns(this), 1.0F)) {
                        livingentity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 40, 0), this);
                    }
                }

            }

            return super.damage(p_32820_, p_32821_);
        }
    }

    public void tick(){
        super.tick();
        this.prevOnLandProgress = onLandProgress;
        if (!this.isTouchingWater() && onLandProgress < 5F) {
            onLandProgress++;
        }
        if (this.isTouchingWater() && onLandProgress > 0F) {
            onLandProgress--;
        }

        if (!this.isTouchingWater() && this.isOnGround() && this.verticalCollision) {
            this.setVelocity(this.getVelocity().add((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F, 0.4F, (this.random.nextFloat() * 2.0F - 1.0F) * 0.05F));
            this.setOnGround(false);
            this.velocityDirty = true;
            this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getSoundPitch());
        }
        AnimationHandler.INSTANCE.updateAnimations(this);

        if (this.getWorld().isClient){
            ++LayerTicks;
            this.LayerBrightness += (0.0F - this.LayerBrightness) * 0.8F;
        }
        if(this.isAlive()) {
            LivingEntity target = this.getTarget();
            if (this.getAnimation() == LIONFISH_BITE) {
                if (this.getAnimationTick() == 7) {
                    this.playSound(SoundEvents.ENTITY_PHANTOM_BITE, 0.4F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
                    if (target != null) {
                        float damage = (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                        target.damage(getDamageSources().mobAttack(this), damage);
                    }
                }
            }
        }
    }

    protected void handleAirSupply(int p_30344_) {
        if (this.isAlive() && !this.isInsideWaterOrBubbleColumn()) {
            this.setAir(p_30344_ - 1);
            if (this.getAir() == -20) {
                this.setAir(0);
                this.damage(getDamageSources().drown(), 0.01F);
            }
        } else {
            this.setAir(1000);
        }

    }

    public void baseTick() {
        int i = this.getAir();
        super.baseTick();
        this.handleAirSupply(i);
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

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        int shardCount = 6 + random.nextInt(2);
        if (!this.getWorld().isClient) {
            for (int i = 0; i < shardCount; i++) {
                float f = ((i + 1) / (float) shardCount) * 360F;
                Lionfish_Spike_Entity shard = new Lionfish_Spike_Entity(this.getWorld(), this);
                shard.setVelocity(this.random.nextFloat() * 0.4F * 2.0F - 0.4F, this.random.nextFloat() * 0.25F + 0.1F,this.random.nextFloat() * 0.4F * 2.0F - 0.4F, 0.35F, 1F);
                getWorld().spawnEntity(shard);
            }
        }

    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
    }

    public boolean isPushedByFluids() {
        return false;
    }

    public boolean canSpawn(WorldView worldIn) {
        return worldIn.doesNotIntersectEntities(this);
    }

    public void travel(Vec3d travelVector) {
        if (this.canMoveVoluntarily() && this.isTouchingWater()) {
            this.updateVelocity(this.getMovementSpeed(), travelVector);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9D));
            if (this.getTarget() == null) {
                this.setVelocity(this.getVelocity().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(travelVector);
        }
    }

    public boolean canImmediatelyDespawn(double p_219457_) {
        return !this.isLeashedToAngler();
    }

    private boolean isLeashedToAngler() {
        return this.getHoldingEntity() instanceof Deepling_Angler_Entity;
    }

    public boolean canBreatheInWater() {
        return true;
    }

    @Override
    public int getAnimationTick() {
        return animationTick;
    }

    @Override
    public void setAnimationTick(int i) {
        animationTick = i;
    }

    @Override
    public Animation getAnimation() {
        return currentAnimation;
    }

    @Override
    public void setAnimation(Animation animation) {
        currentAnimation = animation;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{LIONFISH_BITE,NO_ANIMATION};
    }

    static class AnimationMeleeAttackGoal extends MeleeAttackGoal {
        protected final Lionfish_Entity mob;

        public AnimationMeleeAttackGoal(Lionfish_Entity p_25552_, double p_25553_, boolean p_25554_) {
            super(p_25552_,p_25553_,p_25554_);
            this.mob = p_25552_;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }


        protected void attack(LivingEntity p_25557_, double p_25558_) {
            double d0 = this.getSquaredMaxAttackDistance(p_25557_);
            if (p_25558_ <= d0 && this.mob.getAnimation() == NO_ANIMATION) {
                this.mob.setAnimation(LIONFISH_BITE);
            }
        }
    }
}
