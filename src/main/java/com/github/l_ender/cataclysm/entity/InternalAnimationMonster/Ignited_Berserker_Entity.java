package com.github.l_ender.cataclysm.entity.InternalAnimationMonster;

import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.l_ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import com.github.l_ender.cataclysm.world.data.CMWorldData;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
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
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import java.util.List;


public class Ignited_Berserker_Entity extends Internal_Animation_Monster {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState xslashAnimationState = new AnimationState();
    public AnimationState mixerstartAnimationState = new AnimationState();
    public AnimationState mixeridleAnimationState = new AnimationState();
    public AnimationState mixerfinishAnimationState = new AnimationState();
    public AnimationState sworddanceleftAnimationState = new AnimationState();
    public AnimationState sworddancerightAnimationState = new AnimationState();
    private int sword_dance_cooldown = 0;
    public static final int SWORD_DANCE_COOLDOWN = 40;

    private int spin_cooldown = 0;
    public static final int SPIN_COOLDOWN = 80;

    public Ignited_Berserker_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 20;
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
    }

    protected void initGoals() {
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(2, new InternalMoveGoal(this,false,1.0D));

        //x slash
        this.goalSelector.add(1, new InternalAttackGoal(this,0,1,0,50,15,3.6F){
            @Override
            public boolean canStart() {
                return super.canStart() && Ignited_Berserker_Entity.this.getRandom().nextFloat() * 100.0F < 12f;
            }

        });

        //sword dance left
        this.goalSelector.add(1, new InternalAttackGoal(this,0,5,0,50,50,4.5F) {
            @Override
            public boolean canStart() {
                return super.canStart() && Ignited_Berserker_Entity.this.getRandom().nextFloat() * 100.0F < 16f && Ignited_Berserker_Entity.this.sword_dance_cooldown <= 0;
            }
            @Override
            public void stop() {
                super.stop();
                Ignited_Berserker_Entity.this.sword_dance_cooldown = SWORD_DANCE_COOLDOWN;
            }

        });
        //sword dance right
        this.goalSelector.add(1, new InternalAttackGoal(this,0,6,0,55,55,4.5F){
            @Override
            public boolean canStart() {
                return super.canStart() && Ignited_Berserker_Entity.this.getRandom().nextFloat() * 100.0F < 16f && Ignited_Berserker_Entity.this.sword_dance_cooldown <= 0;
            }
            @Override
            public void stop() {
                super.stop();
                Ignited_Berserker_Entity.this.sword_dance_cooldown = SWORD_DANCE_COOLDOWN;
            }
        });

        //mixer start
        this.goalSelector.add(1, new InternalAttackGoal(this,0,2,3,30,25,8F){
            @Override
            public boolean canStart() {
                return super.canStart() && Ignited_Berserker_Entity.this.getRandom().nextFloat() * 100.0F < 12f && Ignited_Berserker_Entity.this.spin_cooldown <= 0;
            }

        });
        //mixer idle
        this.goalSelector.add(1, new InternalStateGoal(this,3,3,4,90,0, false));

        //mixer stop
        this.goalSelector.add(1, new InternalStateGoal(this,4,4,0,40,0){

            @Override
            public void stop() {
                super.stop();
                Ignited_Berserker_Entity.this.spin_cooldown = SPIN_COOLDOWN;
            }
        });


    }

    public static DefaultAttributeContainer.Builder ignited_berserker() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.32F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.5F)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 65)
                .add(EntityAttributes.GENERIC_ARMOR, 8)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.25F)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
    }

    protected int getNextAirUnderwater(int air) {
        return air;
    }

    


    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "x_slash" -> this.xslashAnimationState;
            case "mixer_start" -> this.mixerstartAnimationState;
            case "mixer_idle" -> this.mixeridleAnimationState;
            case "mixer_finish" -> this.mixerfinishAnimationState;
            case "idle" -> this.idleAnimationState;
            case "sword_dance_left" -> this.sworddanceleftAnimationState;
            case "sword_dance_right" -> this.sworddancerightAnimationState;
            default -> new AnimationState();
        };
    }

    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
    }

    public void onTrackedDataSet(TrackedData<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.xslashAnimationState.startIfNotRunning(this.age);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.mixerstartAnimationState.startIfNotRunning(this.age);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.mixeridleAnimationState.startIfNotRunning(this.age);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.mixerfinishAnimationState.startIfNotRunning(this.age);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.sworddanceleftAnimationState.startIfNotRunning(this.age);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.sworddancerightAnimationState.startIfNotRunning(this.age);
                    }
                }
        }

        super.onTrackedDataSet(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.xslashAnimationState.stop();
        this.mixerstartAnimationState.stop();
        this.mixeridleAnimationState.stop();
        this.mixerfinishAnimationState.stop();
        this.sworddanceleftAnimationState.stop();
        this.sworddancerightAnimationState.stop();
    }

    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    public void onDeath(DamageSource p_21014_) {
        super.onDeath(p_21014_);
        this.setAttackState(0);
    }

    public boolean canSpawn(WorldAccess worldIn, SpawnReason spawnReasonIn) {
        if (ModEntities.rollSpawn(1, this.getRandom(), spawnReasonIn) && worldIn instanceof ServerWorld serverLevel) {
            CMWorldData data = CMWorldData.get(serverLevel,World.NETHER);
            return data != null && data.isIgnisDefeatedOnce();
        }
        return false;

    }

    public int deathtimer(){
        return 20;
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
    }


    public void tick() {
        super.tick();
        if (!this.isOnGround() && this.getVelocity().y < 0.0D) {
            this.setVelocity(this.getVelocity().multiply(1.0D, 0.6D, 1.0D));
        }
        if (this.getWorld().isClient()) {
            this.idleAnimationState.setRunning(!this.limbAnimator.isLimbMoving() && this.getAttackState() == 0, this.age);
        }
        if (sword_dance_cooldown > 0) sword_dance_cooldown--;
        if (spin_cooldown > 0) spin_cooldown--;

        float dis = this.getWidth() * 0.75F;
        repelEntities(dis, this.getHeight(), dis, dis);

    }

    public void tickMovement() {
        super.tickMovement();
        float dis = this.getWidth();

        float f1 = (float) Math.cos(Math.toRadians(this.getYaw() + 90));
        float f2 = (float) Math.sin(Math.toRadians(this.getYaw() + 90));

        if(this.getAttackState() == 1) {
            if (this.attackTicks == 17) {
                this.playSound(ModSounds.SWING, 1F, 1.2f);
                AreaAttack(dis * 4.35f,dis * 4.35f,45,1.25F,60);
            }
            if (this.attackTicks == 35) {
                this.playSound(ModSounds.SWING, 1F, 1.2f);
                AreaAttack(dis * 3.6f,dis * 3.6f,200,1.25F,0);
            }
        }
        if(this.getAttackState() == 3) {
            if (this.age % 4 == 0) {
                for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(1.0D))) {
                    if (!isTeammate(entity) && !(entity instanceof Ignited_Berserker_Entity) && entity != this) {
                        boolean flag = entity.damage(this.getDamageSources().mobAttack(this), (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE));
                        if (flag) {
                            double d0 = entity.getX() - this.getX();
                            double d1 = entity.getZ() - this.getZ();
                            double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                            entity.addVelocity(d0 / d2 * 0.5D, 0.1D, d1 / d2 * 0.5D);
                        }
                    }
                }
            }
        }

        if(this.getAttackState() == 5) {
            if (this.attackTicks == 11 || this.attackTicks == 18 || this.attackTicks == 23 || this.attackTicks == 28  ) {
                this.addVelocity(f1 * 0.45, 0, f2 * 0.45);
            }
            if (this.attackTicks == 13) {
                this.playSound(ModSounds.SWING, 1F, 1.2f);
                AreaAttack(dis * 4.5f,dis * 4.5f,50,1,0);
            }
            if (this.attackTicks == 20) {
                this.playSound(ModSounds.SWING, 1F, 1.2f);
                AreaAttack(dis * 3.5f,dis * 3.5f,60,1,0);
            }
            if (this.attackTicks == 25) {
                this.playSound(ModSounds.SWING, 1F, 1.2f);
                AreaAttack(dis * 4.5f,dis * 4.5f,60,1,0);
            }
            if (this.attackTicks == 30) {
                this.playSound(ModSounds.SWING, 1F, 1.2f);
                AreaAttack(dis * 3.25f,dis * 3.25f,60,1,0);
            }
        }
        if(this.getAttackState() == 6) {
            if (this.attackTicks == 15 || this.attackTicks == 123 || this.attackTicks == 26 || this.attackTicks == 33) {
                this.addVelocity(f1 * 0.45, 0, f2 * 0.45);
            }
            if (this.attackTicks == 17) {
                this.playSound(ModSounds.SWING, 1F, 1.2f);
                AreaAttack(dis * 4.5f,dis * 4.5f,40,1,0);
            }
            if (this.attackTicks == 25) {
                this.playSound(ModSounds.SWING, 1F, 1.2f);
                AreaAttack(dis * 3.25f,dis * 3.25f,55,1,0);
            }
            if (this.attackTicks == 28) {
                this.playSound(ModSounds.SWING, 1F, 1.2f);
                AreaAttack(dis * 5f,dis * 5f,60,1,0);
            }
            if (this.attackTicks == 35) {
                this.playSound(ModSounds.SWING, 1F, 1.2f);
                AreaAttack(dis * 3.5f,dis * 3.5f,40,1,0);
            }
        }

    }


    private void AreaSwordAttack(float range, float height,float degree, float arc, float damage) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - degree) % 360);
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
                if (!isTeammate(entityHit) && entityHit != this) {
                    boolean flag = entityHit.damage(CMDamageTypes.causeSwordDanceDamage(this), (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage));
                    if (flag) {
                        StatusEffectInstance effectinstance1 = entityHit.getStatusEffect(ModEffect.EFFECTBLAZING_BRAND);
                        int i = 1;
                        if (effectinstance1 != null) {
                            i += effectinstance1.getAmplifier();
                            entityHit.removeStatusEffectInternal(ModEffect.EFFECTBLAZING_BRAND);
                        } else {
                            --i;
                        }
                        i = MathHelper.clamp(i, 0, 1);
                        StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 120, i, false, true, true);
                        entityHit.addStatusEffect(effectinstance);
                        this.heal(3 * (i + 1));
                    }
                }
            }
        }
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
                if (!isTeammate(entityHit) && !(entityHit instanceof Ignited_Berserker_Entity) && entityHit != this) {
                    DamageSource damagesource = CMDamageTypes.causeSwordDanceDamage(this);
                    boolean flag = entityHit.damage(damagesource, (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage));
                    if (entityHit.blockedByShield(damagesource) && entityHit instanceof PlayerEntity player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }


                    if (flag) {
                        StatusEffectInstance effectinstance1 = entityHit.getStatusEffect(ModEffect.EFFECTBLAZING_BRAND);
                        int i = 1;
                        if (effectinstance1 != null) {
                            i += effectinstance1.getAmplifier();
                            entityHit.removeStatusEffectInternal(ModEffect.EFFECTBLAZING_BRAND);
                        } else {
                            --i;
                        }
                        i = MathHelper.clamp(i, 0, 1);
                        StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 100, i, false, true, true);
                        entityHit.addStatusEffect(effectinstance);
                        this.heal(2F * (i + 1));
                    }
                }
            }
        }
    }

    public boolean isTeammate(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isTeammate(entityIn)) {
            return true;
        } else if (entityIn.getType().isIn(ModTag.TEAM_IGNIS)) {
            return this.getScoreboardTeam() == null && entityIn.getScoreboardTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.REVENANT_IDLE;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.REVENANT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.REVENANT_DEATH;
    }

    @Override
    protected BodyControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected EntityNavigation createNavigation(World worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    protected boolean canStartRiding(Entity p_31508_) {
        return false;
    }

}





