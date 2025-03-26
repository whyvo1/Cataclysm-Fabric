package com.github.l_ender.cataclysm.entity.InternalAnimationMonster;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.entity.projectile.Death_Laser_Beam_Entity;
import com.github.l_ender.cataclysm.entity.projectile.Wither_Homing_Missile_Entity;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
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
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import java.util.EnumSet;
import java.util.List;


public class The_Prowler_Entity extends Internal_Animation_Monster {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState stunAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState laserAnimationState = new AnimationState();
    public AnimationState spinAnimationState = new AnimationState();
    public AnimationState meleeAnimationState = new AnimationState();
    public AnimationState strongAttackAnimationState = new AnimationState();
    public AnimationState pierceAnimationState = new AnimationState();
    public static final int SPIN_COOLDOWN = 80;
    public static final int LASER_COOLDOWN = 200;
    private int spin_cooldown = 0;
    private int laser_cooldown = 100;
    public static final int NATURE_HEAL_COOLDOWN = 60;
    private int timeWithoutTarget;
    public The_Prowler_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 20;
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
        setConfigattribute(this, CMConfig.ProwlerHealthMultiplier, CMConfig.ProwlerDamageMultiplier);
    }

    protected void initGoals() {
        this.goalSelector.add(2, new InternalMoveGoal(this, false, 1.0D));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));

        this.goalSelector.add(0, new InternalStateGoal(this, 1, 1, 0, 60, 0));

        //laser
        this.goalSelector.add(1, new Lasershoot(this, 0, 2, 0, 90, 20, 8F, 20, 100F));
        //spin
        this.goalSelector.add(1, new InternalAttackGoal(this,0,4,0,50,22,4.75F){
            @Override
            public boolean canStart() {
                return super.canStart() && this.entity.getRandom().nextFloat() * 100.0F < 26 && The_Prowler_Entity.this.spin_cooldown <= 0;

            }

            @Override
            public void stop() {
                super.stop();
                The_Prowler_Entity.this.spin_cooldown = SPIN_COOLDOWN;
            }
        });

        //melee
        this.goalSelector.add(1, new InternalAttackGoal(this,0,5,0,50,38,5F){
            @Override
            public boolean canStart() {
                return super.canStart() && this.entity.getRandom().nextFloat() * 100.0F < 20 ;
            }
        });
        //strong
        this.goalSelector.add(1, new InternalAttackGoal(this,0,6,0,55,45,6F){
            @Override
            public boolean canStart() {
                LivingEntity target = entity.getTarget();
                return super.canStart() && this.entity.getRandom().nextFloat() * 100.0F < 20 && target !=null && this.entity.distanceTo(target) >= 2.75D;


            }
        });
        //pierce
        this.goalSelector.add(1, new InternalAttackGoal(this,0,7,0,80,38,4.25F){
            @Override
            public boolean canStart() {
                LivingEntity target = entity.getTarget();
                return super.canStart() && this.entity.getRandom().nextFloat() * 100.0F < 24 && target !=null;


            }
        });
    }

    public static DefaultAttributeContainer.Builder the_prowler() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 14)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 160)
                .add(EntityAttributes.GENERIC_ARMOR, 10)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.5F)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.95);
    }


    @Override
    public boolean damage(DamageSource source, float damage) {
        if (source.isOf(CMDamageTypes.EMP) && this.getAttackState() != 1) {
            this.setAttackState(1);
        }
        double range = calculateRange(source);
        if (range > CMConfig.ProwlerLongRangelimit * CMConfig.ProwlerLongRangelimit) {
            return false;
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

    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "stun" -> this.stunAnimationState;
            case "laser" -> this.laserAnimationState;
            case "death" -> this.deathAnimationState;
            case "spin" -> this.spinAnimationState;
            case "idle" -> this.idleAnimationState;
            case "melee" -> this.meleeAnimationState;
            case "strong_attack" -> this.strongAttackAnimationState;
            case "pierce" -> this.pierceAnimationState;
            default -> new AnimationState();
        };
    }

    public void onTrackedDataSet(TrackedData<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.stunAnimationState.startIfNotRunning(this.age);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.laserAnimationState.startIfNotRunning(this.age);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfNotRunning(this.age);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.spinAnimationState.startIfNotRunning(this.age);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.meleeAnimationState.startIfNotRunning(this.age);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.strongAttackAnimationState.startIfNotRunning(this.age);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.pierceAnimationState.startIfNotRunning(this.age);
                    }
                }
        }
        super.onTrackedDataSet(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.laserAnimationState.stop();
        this.stunAnimationState.stop();
        this.spinAnimationState.stop();
        this.meleeAnimationState.stop();
        this.strongAttackAnimationState.stop();
        this.deathAnimationState.stop();
        this.pierceAnimationState.stop();
    }


    public void onDeath(DamageSource p_21014_) {
        super.onDeath(p_21014_);
        this.setAttackState(3);
    }

    public int deathtimer() {
        return 40;
    }


    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.idleAnimationState.setRunning(this.getAttackState() != 1, this.age);
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
        if (laser_cooldown > 0) laser_cooldown--;
        if (spin_cooldown > 0) spin_cooldown--;

    }

    public void tickMovement() {
        super.tickMovement();
        LivingEntity target = this.getTarget();
        if (this.getAttackState() == 2) {
            if (this.attackTicks == 38) {
                this.getWorld().playSoundFromEntity(null, this, ModSounds.DEATH_LASER, SoundCategory.HOSTILE, 1.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 20, 0.2f, 0, 10);
            }
        }


        if (this.getAttackState() == 1) {
            if (this.getWorld().isClient) {
                for (int i = 0; i < 2; ++i) {
                    this.getWorld().addParticle(ParticleTypes.LARGE_SMOKE, this.getParticleX(0.5D), this.getRandomBodyY(), this.getParticleZ(0.5D), 0.0D, 0.0D, 0.0D);
                }
            }
        }
        if (this.getAttackState() == 4) {
            if (this.attackTicks == 23 || this.attackTicks == 32) {
                AreaAttack(6.0f, 6.0F, 180, 1.0F);
                this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.PROWLER_SAW_SPIN_ATTACK, SoundCategory.HOSTILE, 1.5f, 1F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            }
            if (this.attackTicks == 23) {
                this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.PROWLER_SAW_SPIN_ATTACK, SoundCategory.HOSTILE, 1.5f, 1F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            }
        }

        if (this.getAttackState() == 5) {
            if (this.attackTicks == 27){
                this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.PROWLER_SAW_SPIN_ATTACK, SoundCategory.HOSTILE, 1.5f, 1F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            }
            if (this.attackTicks == 20 || this.attackTicks == 26 || this.attackTicks == 32 || this.attackTicks == 38 || this.attackTicks == 44) {
                AreaAttack(5.4f, 5.5F, 110, 0.5F);

            }
        }
        float f1 = (float) Math.cos(Math.toRadians(this.getYaw() + 90));
        float f2 = (float) Math.sin(Math.toRadians(this.getYaw() + 90));
        if (this.getAttackState() == 6) {
            if (this.attackTicks == 18) {
                this.addVelocity(f1 * 1.5, 0, f2 * 1.5);
            }
            if (this.attackTicks == 17){
                this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.PROWLER_SAW_SPIN_ATTACK, SoundCategory.HOSTILE, 1.5f, 1F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            }
            if (this.attackTicks ==25) {
                AreaAttack(5.5f, 5.5f, 70, 1.5F);

            }
        }
        if (this.getAttackState() == 7) {
            if(target !=null) {
                if (this.attackTicks == 12) {
                    Missilelaunch(2.0f, 0.5F, target);
                }
                if (this.attackTicks == 15) {
                    Missilelaunch(2.3f, 0.5F, target);
                }
                if (this.attackTicks == 18) {
                    Missilelaunch(2.6f, 0.5F, target);
                }
            }
            if (this.attackTicks == 18) {
                this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.PROWLER_SAW_ATTACK, SoundCategory.HOSTILE, 1.5f, 1F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            }
            if (this.attackTicks == 25 || this.attackTicks == 32 || this.attackTicks == 40) {
                AreaAttack(5.5F, 5.5F, 60, 0.5F);


            }

            if (this.attackTicks == 64) {
                AreaAttack(5.5F, 5.5F, 140, 1.0F);

            }
        }
    }

    private void AreaAttack(float range, float height, float arc, float damage) {
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
                if (!isTeammate(entityHit) && !(entityHit instanceof The_Prowler_Entity) && entityHit != this) {
                    entityHit.damage(CMDamageTypes.causeShredderDamage(this), (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage));

                }
            }
        }
    }


    private void Missilelaunch(float y, float math, LivingEntity target) {
        if (!this.isSilent()) {
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.ROCKET_LAUNCH, SoundCategory.HOSTILE, 1.5f, 1F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        }
        float f = MathHelper.cos(this.bodyYaw * ((float)Math.PI / 180F)) ;
        float f1 = MathHelper.sin(this.bodyYaw * ((float)Math.PI / 180F)) ;

        double theta = (bodyYaw) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);


        double d0 = this.getX() + 0.5f * vecX + f * math;
        double d1 = this.getY() + y;
        double d2 = this.getZ() + 0.5f * vecZ + f1 * math;



        Wither_Homing_Missile_Entity laserBeam = new Wither_Homing_Missile_Entity(this.getWorld(),this,target);
        laserBeam.setPos(d0, d1, d2);
        this.getWorld().spawnEntity(laserBeam);
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
        return ModSounds.PROWLER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.PROWLER_DEATH;
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.PROWLER_IDLE;
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

    @Override
    protected BodyControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected EntityNavigation createNavigation(World worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    static class Lasershoot extends InternalAttackGoal {
        private final The_Prowler_Entity entity;
        private final int attackshot;
        private final float random;


        public Lasershoot(The_Prowler_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.random = random;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return super.canStart() && target != null && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.getVisibilityCache().canSee(target) && this.entity.laser_cooldown <= 0;
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            entity.laser_cooldown = LASER_COOLDOWN;
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();
            if (this.entity.attackTicks == attackshot) {
                Death_Laser_Beam_Entity DeathBeam = new Death_Laser_Beam_Entity(ModEntities.DEATH_LASER_BEAM, entity.getWorld(), entity, entity.getX(), entity.getY() + 1.8, entity.getZ(), (float) ((entity.headYaw + 90) * Math.PI / 180), (float) (-entity.getPitch() * Math.PI / 180), 28,(float) CMConfig.DeathLaserdamage,(float) CMConfig.DeathLaserHpdamage);
                entity.getWorld().spawnEntity(DeathBeam);
            }
            if (this.entity.attackTicks >= attackshot) {
                if (target != null) {
                    entity.getLookControl().lookAt(target.getX(), target.getY() + target.getHeight() / 2, target.getZ(), 2, 90);
                }
            }
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }
    }

}





