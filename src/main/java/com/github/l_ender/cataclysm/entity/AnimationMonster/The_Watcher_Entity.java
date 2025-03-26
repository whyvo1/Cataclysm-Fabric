package com.github.l_ender.cataclysm.entity.AnimationMonster;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.l_ender.cataclysm.entity.projectile.Laser_Beam_Entity;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.AnimationHandler;
import java.util.EnumSet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
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
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class The_Watcher_Entity extends LLibrary_Monster {

    public static final Animation WATCHER_BITE = Animation.create(22);
    public static final Animation WATCHER_SHOT = Animation.create(55);
    public static final Animation WATCHER_EXTRA_SHOT = Animation.create(17);

    public The_Watcher_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 8;
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, WATCHER_BITE,WATCHER_EXTRA_SHOT,WATCHER_SHOT};
    }

    protected void initGoals() {
        this.goalSelector.add(2, new WatcherMoveGoal(this, false,1.0D));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(0, new ShotPrepare(this,WATCHER_SHOT));
        this.goalSelector.add(0, new Shot(this,WATCHER_EXTRA_SHOT));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));

    }

    public static DefaultAttributeContainer.Builder the_watcher() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 25)
                .add(EntityAttributes.GENERIC_ARMOR, 5)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.25)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5);
    }


    @Override
    public boolean damage(DamageSource source, float damage) {

        if (source.isOf(CMDamageTypes.EMP)) {
            super.damage(source, 1000);
            return true;
        }

        return super.damage(source, damage);
    }

    protected int getNextAirUnderwater(int air) {
        return air;
    }




    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
    }


    public void tick() {
        super.tick();

        setYaw(bodyYaw);
        LivingEntity target = this.getTarget();
        if (this.getAnimation() == WATCHER_BITE) {
            if (this.getAnimationTick() == 13) {
                if (target != null) {
                    if (distanceTo(target) < 3 && this.canSee(target)) {
                        float damage = (float) ((int) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE));
                        target.damage(this.getDamageSources().mobAttack(this), damage);
                    }
                }
            }
        }
        if (this.getAnimation() == WATCHER_EXTRA_SHOT) {
            if (this.getAnimationTick() == 9) {
                if (!this.isSilent()) {
                    this.playSound(ModSounds.HARBINGER_LASER,1,1.0F);
                }
                if (target != null && target.isAlive()) {
                    double d0 = this.getX();
                    double d1 = this.getY() + this.getHeight() * 1 / 2;
                    double d2 = this.getZ();
                    double d3 = target.getX() - d0;
                    double d4 = target.getY() + target.getHeight() * 1 / 2 - d1;
                    double d5 = target.getZ() - d2;
                    Vec3d vec3 = new Vec3d(d3, d4, d5);
                    Laser_Beam_Entity laserBeam = new Laser_Beam_Entity(this, vec3.normalize(),this.getWorld(),(float) CMConfig.HarbingerLaserdamage);
                    float yRot = (float) (MathHelper.atan2(vec3.z, vec3.x) * (180F / Math.PI)) + 90F;



                    float xRot = (float) -(MathHelper.atan2(vec3.y, Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * (180F / Math.PI));

                    laserBeam.setYaw(yRot);
                    laserBeam.setPitch(xRot);
                    laserBeam.setPos(d0, d1, d2);
                    this.getWorld().spawnEntity(laserBeam);
                }
            }

        }
    }


    public boolean isTeammate(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isTeammate(entityIn)) {
            return true;
        } else if (entityIn.getType().isIn(ModTag.TEAM_THE_HARBINGER)) {
            return this.getScoreboardTeam() == null && entityIn.getScoreboardTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.WATCHER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.WATCHER_DEATH;
    }


    static class ShotPrepare extends SimpleAnimationGoal<The_Watcher_Entity> {


        public ShotPrepare(The_Watcher_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));

        }

        public void start() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 30);
            }
            super.start();
        }

        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 30);
            }
            super.stop();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 30);
                if(entity.getAnimationTick() == 45){
                    AnimationHandler.INSTANCE.sendAnimationMessage(entity, WATCHER_EXTRA_SHOT);
                }
            }
        }
    }


    static class Shot extends SimpleAnimationGoal<The_Watcher_Entity> {

        public Shot(The_Watcher_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));

        }

        public void start() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 90);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < 7 && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }
            if(target != null){
                if(entity.getAnimationTick() == 11) {
                    if (this.entity.getRandom().nextFloat() * 100.0F < 60f) {
                        AnimationHandler.INSTANCE.sendAnimationMessage(entity, WATCHER_EXTRA_SHOT);
                    }
                }
            }
        }
    }

    static class WatcherMoveGoal extends Goal {
        private final The_Watcher_Entity watcher;
        private final boolean followingTargetEvenIfNotSeen;
        private Path path;
        private int delayCounter;
        protected final double moveSpeed;


        public WatcherMoveGoal(The_Watcher_Entity boss, boolean followingTargetEvenIfNotSeen, double moveSpeed) {
            this.watcher = boss;
            this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
            this.moveSpeed = moveSpeed;
            this.setControls(EnumSet.of(Control.LOOK, Control.MOVE));
        }


        public boolean canStart() {
            LivingEntity target = this.watcher.getTarget();
            return target != null && target.isAlive();
        }


        public void stop() {
            watcher.getNavigation().stop();
            LivingEntity livingentity = this.watcher.getTarget();
            if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(livingentity)) {
                this.watcher.setTarget(null);
            }
            this.watcher.setAttacking(false);
            this.watcher.getNavigation().stop();
        }

        public boolean shouldContinue() {
            LivingEntity target = this.watcher.getTarget();
            if (target == null) {
                return false;
            } else if (!target.isAlive()) {
                return false;
            } else if (!this.followingTargetEvenIfNotSeen) {
                return !this.watcher.getNavigation().isIdle();
            } else if (!this.watcher.isInWalkTargetRange(target.getBlockPos())) {
                return false;
            } else {
                return !(target instanceof PlayerEntity) || !target.isSpectator() && !((PlayerEntity) target).isCreative();
            }
        }

        public void start() {
            this.watcher.getNavigation().startMovingAlong(this.path, this.moveSpeed);
            this.watcher.setAttacking(true);
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = this.watcher.getTarget();
            if (target != null) {
                watcher.getLookControl().lookAt(target, 30.0F, 30.0F);
                double distSq = this.watcher.squaredDistanceTo(target.getX(), target.getBoundingBox().minY, target.getZ());
                if (--this.delayCounter <= 0) {
                    this.delayCounter = 4 + this.watcher.getRandom().nextInt(7);
                    if (distSq > Math.pow(this.watcher.getAttributeInstance(EntityAttributes.GENERIC_FOLLOW_RANGE).getValue(), 2.0D)) {
                        if (!this.watcher.isNavigating()) {
                            if (!this.watcher.getNavigation().startMovingTo(target, 1.0D)) {
                                this.delayCounter += 5;
                            }
                        }
                    } else {
                        this.watcher.getNavigation().startMovingTo(target, this.moveSpeed);
                    }
                }
                if (target.isAlive()) {
                    if (this.watcher.getAnimation() == NO_ANIMATION) {
                        if (this.watcher.distanceTo(target) < 1.5F) {
                            this.watcher.setAnimation(WATCHER_BITE);
                        } else if (this.watcher.getRandom().nextFloat() * 100.0F < 24f && this.watcher.distanceTo(target) >= 6D) {
                            this.watcher.setAnimation(WATCHER_SHOT);
                        }
                    }
                }
            }
        }
    }
}





