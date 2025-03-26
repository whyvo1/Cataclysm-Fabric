package com.github.l_ender.cataclysm.entity.InternalAnimationMonster;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.l_ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.entity.projectile.*;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.lionfishapi.client.model.tools.DynamicChain;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
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
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.jetbrains.annotations.Nullable;
import java.util.EnumSet;
import java.util.List;


public class Wadjet_Entity extends Internal_Animation_Monster {
    @Environment(EnvType.CLIENT)
    public DynamicChain dc;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState stabnswingAnimationState = new AnimationState();
    public AnimationState doublswingAnimationState = new AnimationState();
    public AnimationState spearchargeAnimationState = new AnimationState();
    public AnimationState magicAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState blockAnimationState = new AnimationState();
    public static final TrackedData<Boolean> STAB = DataTracker.registerData(Wadjet_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private float prevAttackProgress;
    private float AttackProgress;

    private int charge_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 160;
    private int magic_cooldown = 0;
    public static final int MAGIC_COOLDOWN = 160;

    public Wadjet_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 35;
        if (world.isClient) {
            dc = new DynamicChain(this);
        }
        this.setStepHeight(1.25F);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
        setConfigattribute(this, CMConfig.WadjetHealthMultiplier, CMConfig.WadjetDamageMultiplier);
    }

    protected void initGoals() {
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(2, new InternalMoveGoal(this, false, 1.0D));
        this.goalSelector.add(1, new ChargeAttackGoal(this,0,3,0,45,15,20,5.5F,16));
        this.goalSelector.add(1, new MagicAttackGoal(this,0,4,0,35,15,3.5F,12));
        this.goalSelector.add(1, new InternalAttackGoal(this,0,5,0,60,60,5){
            @Override
            public boolean canStart() {
                return super.canStart() && Wadjet_Entity.this.getStab();
            }

            @Override
            public void stop() {
                super.stop();
                Wadjet_Entity.this.setStab(Wadjet_Entity.this.random.nextBoolean());
            }
        });

        this.goalSelector.add(1, new InternalAttackGoal(this,0,6,0,55,55,5){
            @Override
            public boolean canStart() {
                return super.canStart() && !Wadjet_Entity.this.getStab();
            }

            @Override
            public void stop() {
                super.stop();
                Wadjet_Entity.this.setStab(Wadjet_Entity.this.random.nextBoolean());
            }
        });
        this.goalSelector.add(1, new InternalStateGoal(this,1,1,0,0,0){
            @Override
            public void tick() {
                entity.setVelocity(0, entity.getVelocity().y, 0);
            }
        });

        this.goalSelector.add(0, new InternalAttackGoal(this,1,2,0,70,0,18));
        this.goalSelector.add(0, new InternalStateGoal(this,8,8,0,20,0,false));
    }

    public static DefaultAttributeContainer.Builder wadjet() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 11)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 150)
                .add(EntityAttributes.GENERIC_ARMOR, 5)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.7);
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
        if (this.isSleep() && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (this.canBlockDamageSource(source)) {
            if(entity instanceof PersistentProjectileEntity) {
                float f = 170.0F + this.random.nextFloat() * 80.0F;
                entity.setVelocity(entity.getVelocity().multiply(1.0));
                entity.setYaw(entity.getYaw() + f);
                entity.velocityModified = true;
            }
            if(this.getAttackState() == 0) {
                this.playSound(SoundEvents.BLOCK_ANVIL_LAND, 1.0F, 2);
                this.setAttackState(8);
            }
            return false;
        }
        return super.damage(source, damage);
    }


    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        boolean flag = false;
        if (!this.isAiDisabled() && damageSourceIn.isIn(DamageTypeTags.IS_PROJECTILE) && !flag && (this.getAttackState() == 0 || this.getAttackState() == 8)) {
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
            case "charge" -> this.spearchargeAnimationState;
            case "magic" -> this.magicAnimationState;
            case "stabnswing" -> this.stabnswingAnimationState;
            case "doubleswing" -> this.doublswingAnimationState;
            case "idle" -> this.idleAnimationState;
            case "death" -> this.deathAnimationState;
            case "block" -> this.blockAnimationState;
            default -> new AnimationState();
        };
//        if (input == "sleep") {
//            return this.sleepAnimationState;
//        } else if (input == "awake") {
//            return this.awakeAnimationState;
//        } else if (input == "charge") {
//            return this.spearchargeAnimationState;
//        } else if (input == "magic") {
//            return this.magicAnimationState;
//        } else if (input == "stabnswing") {
//            return this.stabnswingAnimationState;
//        } else if (input == "doubleswing") {
//            return this.doublswingAnimationState;
//        } else if (input == "idle") {
//            return this.idleAnimationState;
//        } else if (input == "death") {
//            return this.deathAnimationState;
//        } else if (input == "block") {
//            return this.blockAnimationState;
//        } else {
//            return new AnimationState();
//        }
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(STAB, false);
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }

    public void setStab(boolean stab) {
        this.dataTracker.set(STAB, stab);
    }

    public boolean getStab() {
        return this.dataTracker.get(STAB);
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
                        this.spearchargeAnimationState.startIfNotRunning(this.age);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.magicAnimationState.startIfNotRunning(this.age);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.stabnswingAnimationState.startIfNotRunning(this.age);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.doublswingAnimationState.startIfNotRunning(this.age);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfNotRunning(this.age);
                    }
                    case 8 -> {
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
        this.blockAnimationState.stop();
        this.spearchargeAnimationState.stop();
        this.magicAnimationState.stop();
        this.stabnswingAnimationState.stop();
        this.doublswingAnimationState.stop();
        this.deathAnimationState.stop();
    }


    public void onDeath(DamageSource p_21014_) {
        super.onDeath(p_21014_);
        this.setAttackState(7);
    }

    public int deathtimer() {
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
        prevAttackProgress = AttackProgress;
        if (isAttacking() && AttackProgress < 10F) {
            AttackProgress++;
        }
        if (!isAttacking() && AttackProgress > 0F) {
            AttackProgress--;
        }
        if (charge_cooldown > 0) charge_cooldown--;
        if (magic_cooldown > 0) magic_cooldown--;
    }

    public void tickMovement() {
        super.tickMovement();
        if(this.getAttackState() == 3) {
            if (this.attackTicks == 18) {
                this.playSound(ModSounds.IGNIS_POKE, 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks == 20) {
                AreaAttack(9.0f,6.0F,45,1,90,false);
            }
        }
        if(this.getAttackState() == 4) {
            if (this.attackTicks == 15) {
                this.playSound(SoundEvents.ENTITY_EVOKER_PREPARE_ATTACK, 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
            }
        }
        if(this.getAttackState() == 5) {
            if (this.attackTicks == 14) {
                this.playSound(ModSounds.IGNIS_POKE, 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(8.0f,6.0F,45,1,90,false);
            }
            if (this.attackTicks == 37) {
                this.playSound(ModSounds.SWING, 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.0f,4.0F,220,1,70,true);
            }
        }

        if(this.getAttackState() == 6) {
            if (this.attackTicks == 14) {
                this.playSound(ModSounds.SWING, 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.0f,4.0F,220,1,60,true);
            }
            if (this.attackTicks == 28) {
                this.playSound(ModSounds.SWING, 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.0f,4.0F,220,1,60,true);
            }
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
                if (!isTeammate(entityHit) && !(entityHit instanceof Wadjet_Entity) && entityHit != this) {
                    DamageSource damagesource = this.getDamageSources().mobAttack(this);
                    boolean hurt = entityHit.damage(damagesource, (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage));
                    if (entityHit.blockedByShield(damagesource) && entityHit instanceof PlayerEntity player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }

                    double d0 = entityHit.getX() - this.getX();
                    double d1 = entityHit.getZ() - this.getZ();
                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                    if (hurt && knockback) {
                        entityHit.addVelocity(d0 / d2 * 2.25D, 0.15D, d1 / d2 * 2.25D);
                    }
                }
            }
        }
    }

    public float getAttackProgress(float partialTicks) {
        return (prevAttackProgress + (AttackProgress - prevAttackProgress) * partialTicks);
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
        return ModSounds.WADJET_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.WADJET_DEATH;
    }

    protected SoundEvent getAmbientSound() {
        return this.isSleep() ? super.getAmbientSound() : ModSounds.WADJET_AMBIENT;
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

    static class ChargeAttackGoal extends Goal {
        protected final Wadjet_Entity entity;

        private final int getAttackState;

        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final int attackshottick;
        private final float attackminrange;
        private final float attackrange;

        public ChargeAttackGoal(Wadjet_Entity entity,int getAttackState, int attackstate, int attackendstate,int attackMaxtick,int attackseetick,int attackshottick,float attackminrange,float attackrange) {
            this.entity = entity;
            this.setControls(EnumSet.of(Control.MOVE,Control.LOOK,Control.JUMP));
            this.getAttackState = getAttackState;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackshottick = attackshottick;
            this.attackminrange = attackminrange;
            this.attackrange = attackrange;
        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return target != null && this.entity.distanceTo(target) > attackminrange && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getAttackState && this.entity.getRandom().nextFloat() * 100.0F < 16f && this.entity.charge_cooldown <= 0;
        }

        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            this.entity.charge_cooldown = CHARGE_COOLDOWN;
        }

        @Override
        public boolean shouldContinue() {
            return this.entity.attackTicks < attackMaxtick;
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.setYaw(entity.bodyYaw);
            } else {
                entity.setYaw(entity.prevYaw);
            }
            if (entity.attackTicks == attackseetick) {
                float f1 = (float) Math.cos(Math.toRadians(entity.getYaw() + 90));
                float f2 = (float) Math.sin(Math.toRadians(entity.getYaw() + 90));
                if(target != null) {
                    float r = entity.distanceTo(target);
                    r = MathHelper.clamp(r, 0, 4);
                    entity.addVelocity(f1 * 0.3 * r, 0, f2 * 0.3 * r);
                }else{
                    entity.addVelocity(f1 * 2.0, 0, f2 * 2.0);
                }
            }
            if (entity.attackTicks == attackshottick) {
                if (target != null) {
                    double d1 = 5.0D;
                    Vec3d vec3 = entity.getRotationVec(1.0F);
                    double d2 = target.getX() - (entity.getX() + vec3.x * d1);
                    double d3 = target.getBodyY(0.5D) - entity.getBodyY(0.15D);
                    double d4 = target.getZ() - (entity.getZ() + vec3.z * d1);
                    Sandstorm_Projectile largefireball = new Sandstorm_Projectile(entity, d2, d3, d4, entity.getWorld(),6);
                    largefireball.setState(1);
                    largefireball.setPosition(entity.getX() + vec3.x * d1, entity.getBodyY(0.15D), largefireball.getZ() + vec3.z * d1);
                    entity.getWorld().spawnEntity(largefireball);
                }
            }
        }
    }

    static class MagicAttackGoal extends Goal {
        protected final Wadjet_Entity entity;
        private final int getAttackState;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackminrange;
        private final float attackrange;

        public MagicAttackGoal(Wadjet_Entity entity,int getAttackState, int attackstate, int attackendstate,int attackMaxtick,int attackseetick,float attackminrange,float attackrange) {
            this.entity = entity;
            this.setControls(EnumSet.of(Control.MOVE,Control.LOOK,Control.JUMP));
            this.getAttackState = getAttackState;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackminrange = attackminrange;
            this.attackrange = attackrange;
        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return target != null && this.entity.distanceTo(target) > attackminrange && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getAttackState && this.entity.getRandom().nextFloat() * 100.0F < 24f && this.entity.magic_cooldown <= 0;
        }

        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            this.entity.attackCooldown = 0;
            this.entity.magic_cooldown = MAGIC_COOLDOWN;
        }

        @Override
        public boolean shouldContinue() {
            return this.entity.attackTicks < attackMaxtick;
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                if (entity.attackTicks == attackseetick) {
                    double d1 = target.getY();
                    float f = (float) MathHelper.atan2(target.getZ() - this.entity.getZ(), target.getX() - this.entity.getX());

                    for(int k = 0; k < 8; ++k) {
                        float f2 = f + (float)k * (float)Math.PI * 2.0F / 8.0F + ((float) Math.PI * 2F / 5F);
                        this.spawnSpikeLine(this.entity.getX() + (double)MathHelper.cos(f2) * 4.5D, this.entity.getZ() + (double)MathHelper.sin(f2) * 4.5D, d1, f2, 3);
                    }
                    for (int k = 0; k < 13; ++k) {
                        float f3 = f + (float) k * (float) Math.PI * 2.0F / 13.0F + ((float) Math.PI * 2F / 10F);
                        this.spawnSpikeLine(this.entity.getX() + (double)MathHelper.cos(f3) * 6.5D, this.entity.getZ() + (double)MathHelper.sin(f3) * 6.5D, d1, f3, 10);
                    }
                    for (int k = 0; k < 16; ++k) {
                        float f4 = f + (float) k * (float) Math.PI * 2.0F / 16.0F + ((float) Math.PI * 2F / 20F);
                        this.spawnSpikeLine(this.entity.getX() + (double)MathHelper.cos(f4) * 8.5D, this.entity.getZ() + (double)MathHelper.sin(f4) * 8.5D, d1, f4, 15);
                    }
                    for (int k = 0; k < 19; ++k) {
                        float f5 = f + (float) k * (float) Math.PI * 2.0F / 19.0F + ((float) Math.PI * 2F / 40F);
                        this.spawnSpikeLine(this.entity.getX() + (double)MathHelper.cos(f5) * 10.5D, this.entity.getZ() + (double)MathHelper.sin(f5) * 10.5D, d1, f5, 20);
                    }
                    for (int k = 0; k < 24; ++k) {
                        float f6 = f + (float) k * (float) Math.PI * 2.0F / 24.0F + ((float) Math.PI * 2F / 80F);
                        this.spawnSpikeLine(this.entity.getX() + (double)MathHelper.cos(f6) * 12.5D, this.entity.getZ() + (double)MathHelper.sin(f6) * 12.5D, d1, f6, 30);
                    }
                }
            }

        }

        private void spawnSpikeLine(double posX, double posZ, double posY, float rotation, int delay) {
            BlockPos blockpos = BlockPos.ofFloored(posX, posY, posZ);
            double d0 = 0.0D;
            do {
                BlockPos blockpos1 = blockpos.up();
                BlockState blockstate = entity.getWorld().getBlockState(blockpos1);
                if (blockstate.isSideSolidFullSquare(entity.getWorld(), blockpos1, Direction.DOWN)) {
                    if (!entity.getWorld().isAir(blockpos)) {
                        BlockState blockstate1 = entity.getWorld().getBlockState(blockpos);
                        VoxelShape voxelshape = blockstate1.getCollisionShape(entity.getWorld(), blockpos);
                        if (!voxelshape.isEmpty()) {
                            d0 = voxelshape.getMax(Direction.Axis.Y);
                        }
                    }

                    break;
                }

                blockpos = blockpos.up();
            } while (blockpos.getY() < Math.min(entity.getWorld().getTopY(), entity.getBlockY() + 12));
            this.entity.getWorld().spawnEntity(new Ancient_Desert_Stele_Entity(this.entity.getWorld(), posX, (double)blockpos.getY() + d0 -3, posZ, rotation, delay,(float) CMConfig.AncientDesertSteledamage, this.entity));

        }

    }


}





