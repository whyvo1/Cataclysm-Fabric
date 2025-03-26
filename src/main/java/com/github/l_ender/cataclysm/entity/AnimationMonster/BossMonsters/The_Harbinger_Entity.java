package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.l_ender.cataclysm.client.gui.CustomBossBar;
import com.github.l_ender.cataclysm.client.gui.CustomBossBarStyles;
import com.github.l_ender.cataclysm.client.particle.LightningParticle;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AI.AdvancedHurtByTargetGoal;
import com.github.l_ender.cataclysm.entity.AnimationMonster.AI.AttackAniamtionGoal3;
import com.github.l_ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.l_ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.l_ender.cataclysm.entity.projectile.*;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.AnimationHandler;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.entity.feature.SkinOverlayOwner;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.FlyGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;


public class The_Harbinger_Entity extends LLibrary_Boss_Monster implements RangedAttackMob, SkinOverlayOwner {
    public static final Animation DEATHLASER_ANIMATION = Animation.create(124);
    public static final Animation CHARGE_ANIMATION = Animation.create(45);
    public static final Animation DEATH_ANIMATION = Animation.create(144);
    public static final Animation LAUNCH_ANIAMATION = Animation.create(59);
    public static final Animation MISSILE_FIRE_ANIAMATION = Animation.create(118);
    public static final Animation MISSILE_FIRE_FAST_ANIAMATION = Animation.create(96);
    public static final Animation STUN_ANIAMATION = Animation.create(105);
    public static final int SKILL_COOLDOWN = 240;
    private static final TrackedData<Integer> FIRST_HEAD_TARGET = DataTracker.registerData(The_Harbinger_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> SECOND_HEAD_TARGET = DataTracker.registerData(The_Harbinger_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> THIRD_HEAD_TARGET = DataTracker.registerData(The_Harbinger_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> OVERLOAD = DataTracker.registerData(The_Harbinger_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final List<TrackedData<Integer>> HEAD_TARGETS = ImmutableList.of(FIRST_HEAD_TARGET, SECOND_HEAD_TARGET, THIRD_HEAD_TARGET);
    private static final TrackedData<Boolean> LASER_MODE = DataTracker.registerData(The_Harbinger_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> ISCHARGE = DataTracker.registerData(The_Harbinger_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> IS_ACT = DataTracker.registerData(The_Harbinger_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final int MODE_CHANGE_COOLDOWN = 300;
    private final float[] xRotHeads = new float[2];
    private final float[] yRotHeads = new float[2];
    private final float[] xRotOHeads = new float[2];
    private final float[] yRotOHeads = new float[2];
    private final int[] nextHeadUpdate = new int[2];
    private final int[] idleHeadUpdates = new int[2];
    public float Laser_Mode_Progress;
    public float prev_Laser_Mode_Progress;
    public float deactivateProgress;
    public float prevdeactivateProgress;
    private int destroyBlocksTick;
    private int blockBreakCounter;
    private final CustomBossBar bossEvent = new CustomBossBar(this.getDisplayName(), CustomBossBarStyles.HARBINGER, true);

    private int mode_change_cooldown = 0;
    private int skill_cooldown = 160;

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> p_31504_.isMobOrPlayer() && !(p_31504_.getType().isIn(ModTag.TEAM_THE_HARBINGER));
    private static final TargetPredicate TARGETING_CONDITIONS = TargetPredicate.createAttackable().setBaseMaxDistance(20.0D).setPredicate(LIVING_ENTITY_SELECTOR);


    public The_Harbinger_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 300;
        this.moveControl = new FlightMoveControl(this, 10, false);
        setConfigattribute(this, CMConfig.HarbingerHealthMultiplier, CMConfig.HarbingerDamageMultiplier);
    }

    protected EntityNavigation createNavigation(World p_186262_) {
        BirdNavigation flyingpathnavigation = new BirdNavigation(this, p_186262_);
        flyingpathnavigation.setCanPathThroughDoors(false);
        flyingpathnavigation.setCanSwim(true);
        flyingpathnavigation.setCanEnterOpenDoors(true);
        return flyingpathnavigation;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{
                NO_ANIMATION, DEATHLASER_ANIMATION, CHARGE_ANIMATION, DEATH_ANIMATION, LAUNCH_ANIAMATION, MISSILE_FIRE_ANIAMATION, STUN_ANIAMATION, MISSILE_FIRE_FAST_ANIAMATION};
    }

    protected void initGoals() {
        this.goalSelector.add(0, new AwakenGoal());
        this.goalSelector.add(1, new DeathLaserGoal(this, DEATHLASER_ANIMATION));
        this.goalSelector.add(1, new ChargeGoal(this, CHARGE_ANIMATION));
        this.goalSelector.add(1, new LaunchGoal(this, LAUNCH_ANIAMATION));
        this.goalSelector.add(1, new MissileLaunchGoal(this, MISSILE_FIRE_ANIAMATION));
        this.goalSelector.add(1, new MissileLaunchGoal2(this, MISSILE_FIRE_FAST_ANIAMATION));
        this.goalSelector.add(1, new AttackAniamtionGoal3<>(this, STUN_ANIAMATION));
        this.goalSelector.add(2, new ProjectileAttackGoal(this, 1.0D, 40, 20.0F));
        this.goalSelector.add(5, new FlyGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.targetSelector.add(1, new AdvancedHurtByTargetGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
    }

    public static DefaultAttributeContainer.Builder harbinger() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 390.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 9F)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6F)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 40.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5D)
                .add(EntityAttributes.GENERIC_ARMOR, 12.0D);
    }


    protected int getNextAirUnderwater(int air) {
        return air;
    }


    public boolean handleFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }


    @Override
    public ItemEntity dropStack(ItemStack stack) {
        ItemEntity itementity = this.dropStack(stack, 0.0f);
        if (itementity != null) {
            itementity.setGlowing(true);
            itementity.setCovetedItem();
        }
        return itementity;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(LASER_MODE, false);
        this.dataTracker.startTracking(ISCHARGE, false);
        this.dataTracker.startTracking(IS_ACT, true);
        this.dataTracker.startTracking(FIRST_HEAD_TARGET, 0);
        this.dataTracker.startTracking(SECOND_HEAD_TARGET, 0);
        this.dataTracker.startTracking(THIRD_HEAD_TARGET, 0);
        this.dataTracker.startTracking(OVERLOAD, 0);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putBoolean("Is_Act", this.getIsAct());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.setIsAct(compound.getBoolean("Is_Act"));
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }

    public boolean damage(DamageSource source, float damage) {
        Entity entity1 = source.getAttacker();
        if (entity1 instanceof The_Harbinger_Entity) {
            return false;
        } else {
            for (int i = 0; i < this.idleHeadUpdates.length; ++i) {
                this.idleHeadUpdates[i] += 3;
            }
            double range = calculateRange(source);
            if (range > CMConfig.HarbingerLongRangelimit * CMConfig.HarbingerLongRangelimit && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                return false;
            }

            if (this.destroyBlocksTick <= 0) {
                this.destroyBlocksTick = 20;
            }

            if (this.getAnimation() != STUN_ANIAMATION && this.getAnimation() != DEATHLASER_ANIMATION) {
                if (source.isOf(CMDamageTypes.EMP)) {
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, STUN_ANIAMATION);
                }
            }
            if (this.shouldRenderOverlay()) {
                Entity entity = source.getSource();
                if (entity instanceof PersistentProjectileEntity) {
                    return false;
                }
            }

            if (this.deactivateProgress > 0) {
                if (!source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                    return false;
                }
            }

            return super.damage(source, damage);
        }
    }

    
    public float DamageCap() {
        return (float) CMConfig.HarbingerDamageCap;
    }

    public int DamageTime() {
        return CMConfig.HarbingerDamageTime;
    }

    public boolean canTakeDamage() {
        return this.getIsAct() && super.canTakeDamage();
    }

    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossEvent.addPlayer(player);
    }

    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossEvent.removePlayer(player);
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

    public void tickMovement() {
        Vec3d vec3 = this.getVelocity().multiply(1.0D, 0.6D, 1.0D);
        this.bossEvent.setPercent(this.getHealth() / this.getMaxHealth());
        prev_Laser_Mode_Progress = Laser_Mode_Progress;
        if (this.getIsLaserMode() && Laser_Mode_Progress < 30f) {
            Laser_Mode_Progress++;
        }
        if (!this.getIsLaserMode() && Laser_Mode_Progress > 0F) {
            Laser_Mode_Progress--;
        }
        prevdeactivateProgress = deactivateProgress;
        if (!this.getIsAct() && deactivateProgress < 40F) {
            deactivateProgress = 40;
        }
        if (this.getIsAct() && deactivateProgress > 0F) {
            deactivateProgress--;
        }
        if (this.getIsAct()) {
            if (skill_cooldown > 0) skill_cooldown--;
        }


        Entity entity = this.getWorld().getEntityById(this.getAlternativeTarget(0));
        if (!this.getWorld().isClient && this.getAlternativeTarget(0) > 0 && this.isAlive() && !this.getIsCharge() && this.getAnimation() != STUN_ANIAMATION) {
            if (entity != null) {
                double d0 = vec3.y;
                double l0 = (this.getAnimation() == MISSILE_FIRE_FAST_ANIAMATION || this.getAnimation() == MISSILE_FIRE_ANIAMATION || this.getAnimation() == LAUNCH_ANIAMATION) ? 1.0D : 2.25d;
                if (this.getY() < entity.getY() + l0) {
                    d0 = Math.max(0.0D, d0);
                    d0 += 0.3D - d0 * (double) 0.6F;
                }
                vec3 = new Vec3d(vec3.x, d0, vec3.z);
                Vec3d vec31 = new Vec3d(entity.getX() - this.getX(), 0.0D, entity.getZ() - this.getZ());
                if (vec31.horizontalLengthSquared() > 25.0D && !(this.getAnimation() == DEATHLASER_ANIMATION && this.getAnimationTick() > 13 || this.getAnimation() == MISSILE_FIRE_ANIAMATION || this.getAnimation() == MISSILE_FIRE_FAST_ANIAMATION)) {
                    Vec3d vec32 = vec31.normalize();
                    vec3 = vec3.add(vec32.x * 0.3D - vec3.x * 0.6D, 0.0D, vec32.z * 0.3D - vec3.z * 0.6D);
                }

            }
        }

        LivingEntity target = this.getTarget();
        if (this.getIsAct()) {
            if (this.isAlive() && this.deactivateProgress == 0) {
                if (target != null && target.isAlive() && skill_cooldown <= 0 && (Laser_Mode_Progress == 30 || Laser_Mode_Progress == 0)) {
                    if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.getOverload() >= 3 && this.getRandom().nextFloat() * 100.0F < 3f) {
                        skill_cooldown = SKILL_COOLDOWN;
                        this.setAnimation(DEATHLASER_ANIMATION);
                    } else if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.getOverload() < 3 && this.squaredDistanceTo(target) < 64 && (this.getRandom().nextFloat() * 100.0F < 4f && this.canSee(target) || this.getRandom().nextFloat() * 100.0F < 20f && !this.canSee(target))) {
                        skill_cooldown = SKILL_COOLDOWN;
                        this.setAnimation(CHARGE_ANIMATION);
                    } else if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.getOverload() < 3 && this.getRandom().nextFloat() * 100.0F < 3f && Laser_Mode_Progress == 0) {
                        skill_cooldown = SKILL_COOLDOWN;
                        this.setAnimation(LAUNCH_ANIAMATION);
                    } else if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.getOverload() < 3 && this.getRandom().nextFloat() * 100.0F < 1.5f) {
                        skill_cooldown = SKILL_COOLDOWN;
                        Animation missile = this.shouldRenderOverlay() ? MISSILE_FIRE_FAST_ANIAMATION : MISSILE_FIRE_ANIAMATION;
                        this.setAnimation(missile);
                    }
                }
            }
        }
        this.setVelocity(vec3);
        if (vec3.horizontalLengthSquared() > 0.05D) {
            this.setYaw((float) MathHelper.atan2(vec3.z, vec3.x) * (180F / (float) Math.PI) - 90.0F);
        }

        super.tickMovement();
        for (int i = 0; i < 2; ++i) {
            this.yRotOHeads[i] = this.yRotHeads[i];
            this.xRotOHeads[i] = this.xRotHeads[i];
        }


        if ((this.getAnimation() != CHARGE_ANIMATION) && getIsCharge()) {
            setIsCharge(false);
        }
        //setInvulnerable(!getIsAct());
        if (this.getAnimation() == STUN_ANIAMATION) {
            if (this.getAnimationTick() == 15) {
                this.getWorld().playSoundFromEntity(null, this, ModSounds.HARBINGER_STUN, SoundCategory.HOSTILE, 4F, getWorld().random.nextFloat() * 0.2F + 1.0F);
            }
        }
        if (this.getAnimation() == DEATHLASER_ANIMATION) {
            if (this.getAnimationTick() == 33) {
                this.getWorld().playSoundFromEntity(null, this, ModSounds.DEATH_LASER, SoundCategory.HOSTILE, 4.0f, 0.75f);
            }
        }

        if (this.getAnimation() == CHARGE_ANIMATION) {
            if (this.getAnimationTick() == 24) {
                this.getWorld().playSoundFromEntity(null, this, ModSounds.HARBINGER_CHARGE, SoundCategory.HOSTILE, 4.0f, 0.65f);
            }
        }
        if (this.getAnimation() == MISSILE_FIRE_ANIAMATION || this.getAnimation() == MISSILE_FIRE_FAST_ANIAMATION) {
            if (this.getAnimationTick() == 24) {
                this.getWorld().playSoundFromEntity(null, this, ModSounds.HARBINGER_PREPARE, SoundCategory.HOSTILE, 4.0f, 1.0f);
            }
        }


        for (int j = 0; j < 2; ++j) {
            int k = this.getAlternativeTarget(j + 1);
            Entity entity1 = null;
            if (k > 0) {
                entity1 = this.getWorld().getEntityById(k);
            }

            if (entity1 != null) {
                double d9 = this.getHeadX(j + 1);
                double d1 = this.getHeadY(j + 1);
                double d3 = this.getHeadZ(j + 1);
                double d4 = entity1.getX() - d9;
                double d5 = entity1.getEyeY() - d1;
                double d6 = entity1.getZ() - d3;
                double d7 = Math.sqrt(d4 * d4 + d6 * d6);
                float f = (float) (MathHelper.atan2(d6, d4) * (double) (180F / (float) Math.PI)) - 90.0F;
                float f1 = (float) (-(MathHelper.atan2(d5, d7) * (double) (180F / (float) Math.PI)));
                this.xRotHeads[j] = this.m_31442_(this.xRotHeads[j], f1, 40.0F);
                this.yRotHeads[j] = this.m_31442_(this.yRotHeads[j], f, 10.0F);
            } else {
                this.yRotHeads[j] = this.m_31442_(this.yRotHeads[j], this.bodyYaw, 10.0F);
            }
        }
        if (this.getWorld().isClient) {
            if (this.getIsAct()) {
                double d0 = (random.nextFloat() - 0.5F) + this.getVelocity().x;
                double d1 = (random.nextFloat() - 0.5F) + this.getVelocity().y;
                double d2 = (random.nextFloat() - 0.5F) + this.getVelocity().z;
                double dist = 1F + random.nextFloat() * 0.2F;
                double d3 = d0 * dist;
                double d4 = d1 * dist;
                double d5 = d2 * dist;
                this.getWorld().addParticle(new LightningParticle.OrbData(255, 51,  0), this.getX() + d0, this.getY() + 2, this.getZ() + d2, d3, d4, d5);

                if (entity != null && this.getAnimation() != MISSILE_FIRE_ANIAMATION) {
                    float f = MathHelper.cos((bodyYaw) * ((float) Math.PI / 180F));
                    float f1 = MathHelper.sin((bodyYaw) * ((float) Math.PI / 180F));
                    double theta = (bodyYaw) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    double vec = -1.75D;
                    double math = 1.35;
                    for (int i1 = 0; i1 < 10; i1++) {
                        float angle = (0.01745329251F * this.bodyYaw) + i1;
                        double extraX = 0.2F * MathHelper.sin((float) (Math.PI + angle));
                        double extraY = 2.75F;
                        double extraZ = 0.2F * MathHelper.cos(angle);
                        this.getWorld().addParticle(ParticleTypes.FLAME, getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, 0, -0.07, 0);
                        this.getWorld().addParticle(ParticleTypes.FLAME, getX() + vec * vecX + extraX + f * -math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * -math, 0, -0.07, 0);
                    }
                    for (int i1 = 0; i1 < 5; i1++) {
                        float angle = (0.01745329251F * this.bodyYaw) + i1;
                        double extraX = 0.2F * MathHelper.sin((float) (Math.PI + angle));
                        double extraY = 2.75F;
                        double extraZ = 0.2F * MathHelper.cos(angle);
                        this.getWorld().addParticle(ParticleTypes.SMOKE, getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, 0, -0.07, 0);
                        this.getWorld().addParticle(ParticleTypes.SMOKE, getX() + vec * vecX + extraX + f * -math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * -math, 0, -0.07, 0);
                    }
                }
                if (this.getAnimation() == STUN_ANIAMATION)
                    for (int i = 0; i < 2; ++i) {
                        this.getWorld().addParticle(ParticleTypes.LARGE_SMOKE, this.getParticleX(1.5D), this.getRandomBodyY(), this.getParticleZ(1.5D), 0.0D, 0.0D, 0.0D);
                    }
            }
        }

    }


    private void blockbreak() {
        if (getIsCharge()) {
            if (!this.getWorld().isClient) {
                if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                    boolean flag = false;
                    Box aabb = this.getBoundingBox().expand(1.5D, 0.2D, 1.5D);
                    for (BlockPos blockpos : BlockPos.iterate(MathHelper.floor(aabb.minX), MathHelper.floor(aabb.minY), MathHelper.floor(aabb.minZ), MathHelper.floor(aabb.maxX), MathHelper.floor(aabb.maxY), MathHelper.floor(aabb.maxZ))) {
                        BlockState blockstate = this.getWorld().getBlockState(blockpos);
                        if (!blockstate.isAir() && !blockstate.isIn(ModTag.HARBINGER_IMMUNE)) {
                            if (random.nextInt(3) == 0 && !blockstate.hasBlockEntity()) {
                                Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(getWorld(), blockpos.getX() + 0.5D, blockpos.getY() + 0.5D, blockpos.getZ() + 0.5D, blockstate, 20);
                                flag = this.getWorld().breakBlock(blockpos, false, this) || flag;
                                fallingBlockEntity.setVelocity(fallingBlockEntity.getVelocity().add(this.getPos().subtract(fallingBlockEntity.getPos()).multiply((-1.2D + random.nextDouble()) / 3, 0.2D + getRandom().nextGaussian() * 0.15D, (-1.2D + random.nextDouble()) / 3)));
                                getWorld().spawnEntity(fallingBlockEntity);
                            } else {
                                flag = this.getWorld().breakBlock(blockpos, false, this) || flag;
                            }
                        }


                    }
                    if (flag) {
                        this.getWorld().syncWorldEvent(null, 1022, this.getBlockPos(), 0);

                    }
                }
            }
            if (this.age % 4 == 0) {
                for (LivingEntity Lentity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(1.5D))) {
                    if (!isTeammate(Lentity) && !(Lentity instanceof The_Harbinger_Entity) && Lentity != this) {
                        boolean flag = Lentity.damage(this.getDamageSources().mobAttack(this), (float) ((float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) + this.random.nextInt(5) + Math.min(this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE), Lentity.getMaxHealth() * CMConfig.HarbingerChargeHpDamage)));
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
    }


    private void destoryblock2() {
        if (this.blockBreakCounter > 0) {
            --this.blockBreakCounter;
            return;
        }
        boolean flag = false;
        if (this.getAnimation() == NO_ANIMATION) {
            if (!getIsCharge()) {
                if (!getWorld().isClient && this.blockBreakCounter == 0 &&this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                    Box aabb = this.getBoundingBox().expand(0.2D);
                    for (BlockPos pos : BlockPos.iterate(MathHelper.floor(aabb.minX), MathHelper.floor(aabb.minY), MathHelper.floor(aabb.minZ), MathHelper.floor(aabb.maxX), MathHelper.floor(aabb.maxY), MathHelper.floor(aabb.maxZ))) {
                        BlockState blockstate = getWorld().getBlockState(pos);
                        if (!blockstate.isAir() && !blockstate.isIn(ModTag.HARBINGER_IMMUNE)) {
                            if (random.nextInt(5) == 0 && !blockstate.hasBlockEntity()) {
                                Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(getWorld(), pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, blockstate, 20);
                                flag = this.getWorld().breakBlock(pos, false, this) || flag;
                                fallingBlockEntity.setVelocity(fallingBlockEntity.getVelocity().add(this.getPos().subtract(fallingBlockEntity.getPos()).multiply((-1.2D + random.nextDouble()) / 3, 0.2D + getRandom().nextGaussian() * 0.15D, (-1.2D + random.nextDouble()) / 3)));
                                getWorld().spawnEntity(fallingBlockEntity);
                            } else {
                                flag = this.getWorld().breakBlock(pos, false, this) || flag;
                                this.setVelocity(this.getVelocity().multiply(0.6F, 1, 0.6F));
                            }
                        }
                    }
                }
            }
        }
        if (flag) {
            blockBreakCounter = 20;
            this.getWorld().syncWorldEvent(null, 1022, this.getBlockPos(), 0);
        }
    }

    private void destroyBlock(){
        if(this.getAnimation() != STUN_ANIAMATION) {
            if (!this.getWorld().isClient){
                if (this.destroyBlocksTick > 0) {
                    --this.destroyBlocksTick;
                    if (this.destroyBlocksTick == 0 && this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                        int j1 = MathHelper.floor(this.getY());
                        int i2 = MathHelper.floor(this.getX());
                        int j2 = MathHelper.floor(this.getZ());
                        boolean flag = false;

                        for (int j = -1; j <= 1; ++j) {
                            for (int k2 = -1; k2 <= 1; ++k2) {
                                for (int k = 0; k <= 3; ++k) {
                                    int l2 = i2 + j;
                                    int l = j1 + k;
                                    int i1 = j2 + k2;
                                    BlockPos blockpos = new BlockPos(l2, l, i1);
                                    BlockState blockstate = this.getWorld().getBlockState(blockpos);
                                    if (!blockstate.isAir() && !blockstate.isIn(ModTag.HARBINGER_IMMUNE)) {
                                        if (random.nextInt(5) == 0 && !blockstate.hasBlockEntity()) {
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

                        if (flag) {
                            this.getWorld().syncWorldEvent(null, 1022, this.getBlockPos(), 0);
                        }
                    }
                }
            }
        }
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        Item item = itemstack.getItem();
        if (item == Items.NETHER_STAR && !this.getIsAct()) {
            if (!player.isCreative()) {
                itemstack.decrement(1);
            }
            this.setIsAct(true);
            return ActionResult.SUCCESS;
        }
        return super.interactMob(player, hand);
    }

    protected void mobTick() {
        if (this.getIsAct()) {
            if (this.deactivateProgress > 0) {
                float k1 = deactivateProgress - 1;
                if (k1 <= 0) {
                    if (!this.isSilent()) {
                        this.getWorld().syncGlobalEvent(1023, this.getBlockPos(), 0);
                    }
                }
            }else{
                super.mobTick();
                for (int i = 1; i < 3; ++i) {
                    if (this.age >= this.nextHeadUpdate[i - 1]) {
                        this.nextHeadUpdate[i - 1] = this.age + 10 + this.random.nextInt(10);
                        int l1 = this.getAlternativeTarget(i);
                        if (l1 > 0) {
                            LivingEntity livingentity = (LivingEntity) this.getWorld().getEntityById(l1);
                            if (livingentity != null && this.canTarget(livingentity) && !(this.squaredDistanceTo(livingentity) > 1600.0D) && this.canSee(livingentity) && (Laser_Mode_Progress == 30 || Laser_Mode_Progress == 0) && this.getAnimation() == NO_ANIMATION) {
                                this.performRangedAttack(i + 1, livingentity);
                                int f = this.getIsLaserMode() ? 15 + this.random.nextInt(5) : 30 + this.random.nextInt(20);
                                this.nextHeadUpdate[i - 1] = this.age + f;
                                this.idleHeadUpdates[i - 1] = 0;
                            } else {
                                this.setAlternativeTarget(i, 0);
                            }
                        } else {
                            List<LivingEntity> list = this.getWorld().getTargets(LivingEntity.class, TARGETING_CONDITIONS, this, this.getBoundingBox().expand(20.0D, 8.0D, 20.0D));
                            if (!list.isEmpty()) {
                                LivingEntity livingentity1 = list.get(this.random.nextInt(list.size()));
                                this.setAlternativeTarget(i, livingentity1.getId());
                            }
                        }
                    }
                }
                blockbreak();
                destroyBlock();
                if (this.getTarget() != null) {
                    destoryblock2();
                }

                if (mode_change_cooldown < MODE_CHANGE_COOLDOWN) {
                    mode_change_cooldown++;
                } else if (this.getAnimation() == NO_ANIMATION) {
                    this.setIsLaserMode(!this.getIsLaserMode());
                    this.playSound(ModSounds.HARBINGER_MODE_CHANGE, 3.0f, 1.0f);
                    mode_change_cooldown = this.random.nextInt(50);
                }

                if (this.getTarget() != null) {
                    this.setAlternativeTarget(0, this.getTarget().getId());
                } else {
                    this.setAlternativeTarget(0, 0);
                }
                if (this.age % 20 == 0) {
                    this.heal((float) CMConfig.HarbingerHealingMultiplier);
                }
            }
        }else{
            if (this.age % 20 == 0) {
                this.heal(50 * (float) CMConfig.HarbingerHealthMultiplier);
            }
        }
    }

    protected SoundEvent getAmbientSound() {
        return this.getIsAct() ? ModSounds.HARBINGER_IDLE : super.getAmbientSound();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.HARBINGER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.HARBINGER_HURT;
    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.HARBINGER_MUSIC;
    }

    @Override
    protected boolean canPlayMusic() {
        return super.canPlayMusic() && getIsAct();
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();
        this.move(MovementType.SELF, new Vec3d(0.0D, 0.15F, 0.0D));
        this.setYaw(this.prevYaw);
        this.bodyYaw = this.getYaw();
        this.headYaw = this.getYaw();
        if (this.deathTime == 123) {
            if(!getWorld().isClient){
                this.getWorld().createExplosion(this, this.getX(), this.getEyeY(), this.getZ(), 7.0F, false, World.ExplosionSourceType.MOB);
            }
        }

    }


    private double getHeadX(int head) {
        if (head <= 0) {
            return this.getX();
        } else {
            float f = (this.bodyYaw + (float)(180 * (head - 1))) * ((float)Math.PI / 180F);
            float f1 = MathHelper.cos(f);
            double f2 = this.getIsLaserMode() ? 1.65D : 1.5D;
            return this.getX() + (double)f1 * f2;
        }
    }

    private double getHeadY(int head) {
        return head <= 0 ? this.getY() + 3.0D : this.getY() + 2.6D;
    }

    private double getHeadZ(int head) {
        if (head <= 0) {
            return this.getZ();
        } else {
            float f = (this.bodyYaw + (float)(180 * (head - 1))) * ((float)Math.PI / 180F);
            float f1 = MathHelper.sin(f);
            double f2 = this.getIsLaserMode() ? 1.65D : 1.5D;
            return this.getZ() + (double)f1 * f2;
        }
    }

    private float m_31442_(float p_31443_, float p_31444_, float p_31445_) {
        float f = MathHelper.wrapDegrees(p_31444_ - p_31443_);
        if (f > p_31445_) {
            f = p_31445_;
        }

        if (f < -p_31445_) {
            f = -p_31445_;
        }

        return p_31443_ + f;
    }

    private void performRangedAttack(int head, LivingEntity target) {
        this.performRangedAttack(head, target.getX(), target.getY() + (double)target.getStandingEyeHeight() * 0.5D, target.getZ());
    }

    private void performRangedAttack(int head, double targetX, double targetY, double targetZ) {
        double d0 = this.getHeadX(head);
        double d1 = this.getHeadY(head);
        double d2 = this.getHeadZ(head);
        double d3 = targetX - d0;
        double d4 = targetY - d1;
        double d5 = targetZ - d2;
        if(this.getIsLaserMode()) {
            if (!this.isSilent()) {
                this.playSound(ModSounds.HARBINGER_LASER,1,1.0F);
            }
            Laser_Beam_Entity laser = new Laser_Beam_Entity(this, d3,d4,d5,this.getWorld(),(float) CMConfig.HarbingerLaserdamage);
            Vec3d vec3 = new Vec3d(d3, d4, d5);
            float yRot = (float) (MathHelper.atan2(vec3.z, vec3.x) * (180F / Math.PI)) + 90F;
            float xRot = (float) -(MathHelper.atan2(vec3.y, Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * (180F / Math.PI));

            laser.setYaw(yRot);
            laser.setPitch(xRot);
            laser.setPos(d0, d1, d2);

            this.getWorld().spawnEntity(laser);
        }else{
            if (!this.isSilent()) {
                this.playSound(ModSounds.ROCKET_LAUNCH,1,0.8F);
            }
            Wither_Missile_Entity witherskull = new Wither_Missile_Entity(this, d3, d4, d5, this.getWorld(),(float) CMConfig.HarbingerWitherMissiledamage);
            witherskull.setPos(d0, d1, d2);
            this.getWorld().spawnEntity(witherskull);
        }
    }

    public void attack(LivingEntity p_31468_, float p_31469_) {
        this.performRangedAttack(0, p_31468_);
    }

    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    public float getHeadYRot(int head) {
        return this.yRotHeads[head];
    }

    public float getHeadXRot(int head) {
        return this.xRotHeads[head];
    }

    public int getAlternativeTarget(int head) {
        return this.dataTracker.get(HEAD_TARGETS.get(head));
    }

    public void setAlternativeTarget(int targetOffset, int newId) {
        this.dataTracker.set(HEAD_TARGETS.get(targetOffset), newId);
    }


    public void setIsLaserMode(boolean isLaserMode) {
        this.dataTracker.set(LASER_MODE, isLaserMode);
    }

    public boolean getIsLaserMode() {
        return this.dataTracker.get(LASER_MODE);
    }

    public void setIsAct(boolean isAct) {
        this.dataTracker.set(IS_ACT, isAct);
        this.bossEvent.setVisible(isAct);
        this.setHomePos(this.getBlockPos());
    }

    public boolean getIsAct() {
        return this.dataTracker.get(IS_ACT);
    }

    public void setIsCharge(boolean isCharge) {
        this.dataTracker.set(ISCHARGE, isCharge);
    }

    public boolean getIsCharge() {
        return this.dataTracker.get(ISCHARGE);
    }

    public void setOverload(int Overload) {
        this.dataTracker.set(OVERLOAD, Overload);
    }

    public int getOverload() {
        return this.dataTracker.get(OVERLOAD);
    }


    public boolean shouldRenderOverlay() {
        return this.getHealth() <= this.getMaxHealth() / 2.0F;
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    public boolean canUsePortals() {
        return false;
    }

    @Nullable
    public Animation getDeathAnimation()
    {
        return DEATH_ANIMATION;
    }

    public boolean canHaveStatusEffect(StatusEffectInstance p_31495_) {
        return p_31495_.getEffectType() != StatusEffects.SLOWNESS
                && p_31495_.getEffectType() != StatusEffects.POISON
                && p_31495_.getEffectType() != StatusEffects.WITHER
                && p_31495_.getEffectType() != StatusEffects.WEAKNESS
                && p_31495_.getEffectType() != StatusEffects.LEVITATION
                && super.canHaveStatusEffect(p_31495_);
    }


    public BossBar.Color bossBarColor() {
        return BossBar.Color.PURPLE;
    }


    static class DeathLaserGoal extends SimpleAnimationGoal<The_Harbinger_Entity> {

        public DeathLaserGoal(The_Harbinger_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            super.start();
            entity.getWorld().playSoundFromEntity(null, entity, ModSounds.HARBINGER_DEATHLASER_PREPARE, SoundCategory.HOSTILE, 8.0f, 1.2f);
            entity.setOverload(0);
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            entity.setVelocity(0, entity.getVelocity().y, 0);
            if (entity.getAnimationTick() == 18 && !entity.getWorld().isClient) {
                //Death_Laser_Beam_Entity DeathBeam = new Death_Laser_Beam_Entity(ModEntities.DEATH_LASER_BEAM, entity.level(), entity, entity.getX() + radius1 * Math.sin(-entity.getYRot() * Math.PI / 180), entity.getY() + 2.9, entity.getZ() + radius1 * Math.cos(-entity.getYRot() * Math.PI / 180), (float) ((entity.yHeadRot + 90) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180), 20);
                Death_Laser_Beam_Entity DeathBeam = new Death_Laser_Beam_Entity(ModEntities.DEATH_LASER_BEAM, entity.getWorld(), entity, entity.getX(), entity.getY() + 2.9, entity.getZ(), (float) ((entity.headYaw + 90) * Math.PI / 180), (float) (-entity.getPitch() * Math.PI / 180), 60,(float) CMConfig.DeathLaserdamage,(float) CMConfig.DeathLaserHpdamage);
                if(entity.shouldRenderOverlay()){
                    DeathBeam.setFire(true);
                }
                entity.getWorld().spawnEntity(DeathBeam);
            }

            if (entity.getAnimationTick() >= 35) {
                if (target != null) {
                    entity.getLookControl().lookAt(target.getX(), target.getY() + target.getHeight() / 2, target.getZ(), 6, 90);
                    entity.lookAtEntity(target, 30, 30);
                }
            }
        }
    }

    static class ChargeGoal extends SimpleAnimationGoal<The_Harbinger_Entity> {

        public ChargeGoal(The_Harbinger_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            super.start();
            entity.setOverload(entity.getOverload() + 1);
            entity.getWorld().playSoundFromEntity(null, entity, ModSounds.HARBINGER_CHARGE_PREPARE, SoundCategory.HOSTILE, 4.0f, 1.0f);
        }

        public void tick() {
            LivingEntity target = entity.getTarget();


            if (entity.getAnimationTick() == 24) {
                entity.setIsCharge(true);

            }
            if (entity.getAnimationTick() == 36) {
                entity.setIsCharge(false);
            }

            if (target != null) {
                if (entity.getAnimationTick() < 24) {
                    entity.lookAtEntity(target, 30, 30);
                    entity.getLookControl().lookAt(target, 30, 30);
                }
                if (entity.getAnimationTick() == 24) {
                    //  Vec3 vec3 = (new Vec3(target.getX() - entity.getX(), target.getY() - entity.getY(), target.getZ() - entity.getZ()));
                    // entity.setDeltaMovement(vec3.x * 0.8,vec3.y * 1.0, vec3.z * 0.8);
                    //entity.setDeltaMovement(entity.getDeltaMovement().add(vec3.x * 0.8D, 0.9D, vec3.z * 0.8D));
                    Vec3d rot = target.getPos().subtract(0.0, 2.0, 0.0).add(entity.getPos().multiply(-1.0, -1.0, -1.0)).normalize();
                    entity.setVelocity(rot.multiply(4.0, 5.0, 4.0));
                }
                if (entity.getAnimationTick() == 45) {
                    AnimationHandler.INSTANCE.sendAnimationMessage(entity, CHARGE_ANIMATION);
                }
            }

        }

        public void stop() {
            super.stop();
            LivingEntity target = entity.getTarget();
            if(entity.getOverload() < 3 && entity.shouldRenderOverlay() && target !=null && entity.random.nextInt(2) == 0){
                AnimationHandler.INSTANCE.sendAnimationMessage(entity, CHARGE_ANIMATION);
            }
        }

    }


    static class LaunchGoal extends SimpleAnimationGoal<The_Harbinger_Entity> {

        public LaunchGoal(The_Harbinger_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            super.start();
            entity.setOverload(entity.getOverload() + 1);
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                if (entity.getAnimationTick() == 13) {
                    this.launch(2, target);
                }

                if (entity.getAnimationTick() == 19) {
                    this.launch(1, target);
                }
            }


        }


        private void launch(int head, LivingEntity p_31459_) {
            this.launch(head, p_31459_.getX(), p_31459_.getY() + (double)p_31459_.getStandingEyeHeight() * 0.5D, p_31459_.getZ());
        }


        private void launch(int head, double p_31450_, double p_31451_, double p_31452_) {
            if (!entity.isSilent()) {
                entity.playSound(ModSounds.ROCKET_LAUNCH,1,1.0F);
            }
            double d0 = entity.getHeadX(head);
            double d1 = entity.getHeadY(head);
            double d2 = entity.getHeadZ(head);
            double d3 = p_31450_ - d0;
            double d4 = p_31451_ - d1;
            double d5 = p_31452_ - d2;
            double d6 = MathHelper.sqrt((float) (d3 * d3 + d5 * d5));

            int b = entity.shouldRenderOverlay() ? 7 : 5;
            for (int i = 0; i < b; ++i) {
                Wither_Howitzer_Entity lava = new Wither_Howitzer_Entity(ModEntities.WITHER_HOWITZER, entity.getWorld(), entity);
                lava.setPos(d0, d1, d2);
                lava.setRadius(3.0F);
                lava.setVelocity(d3, d4 + d6 * 6F, d5, 0.6F, 60);
                entity.getWorld().spawnEntity(lava);
            }
        }
    }


    static class MissileLaunchGoal extends SimpleAnimationGoal<The_Harbinger_Entity> {

        public MissileLaunchGoal(The_Harbinger_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            super.start();
            entity.setOverload(entity.getOverload() + 1);
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.lookAtEntity(target, 30, 30);
                entity.getLookControl().lookAt(target, 30, 30);
                if (entity.getAnimationTick() == 80 || entity.getAnimationTick() == 84  || entity.getAnimationTick() == 88) {
                    this.mlaunch(2, target);
                }
                if (entity.getAnimationTick() == 98 || entity.getAnimationTick() == 102 || entity.getAnimationTick() == 106) {
                    this.mlaunch(1, target);
                }


            }
        }

        private void mlaunch(int head, LivingEntity target) {
            if (!entity.isSilent()) {
                entity.playSound(ModSounds.ROCKET_LAUNCH,1,1.0F);
            }
            double d0 = this.getLauncherX(head);
            double d1 = this.getLauncherY(head);
            double d2 = this.getLauncherZ(head);

            Wither_Homing_Missile_Entity laserBeam = new Wither_Homing_Missile_Entity(entity.getWorld(),entity,target);
            laserBeam.setPos(d0, d1, d2);
            entity.getWorld().spawnEntity(laserBeam);
        }


        private double getLauncherX(int head) {
            if (head <= 0) {
                return entity.getX();
            } else {
                double theta = (entity.bodyYaw) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                float f = (entity.bodyYaw + (float)(180 * (head - 1))) * ((float)Math.PI / 180F);
                float f1 = MathHelper.cos(f);
                return entity.getX() + (double)f1 * 1.25D + vecX * 1.35D;
            }
        }

        private double getLauncherY(int head) {
            return head <= 0 ? entity.getY() + 3.0D : entity.getY() + 3.8D;
        }

        private double getLauncherZ(int head) {
            if (head <= 0) {
                return entity.getZ();
            } else {
                double theta = (entity.bodyYaw) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecZ = Math.sin(theta);
                float f = (entity.bodyYaw + (float)(180 * (head - 1))) * ((float)Math.PI / 180F);
                float f1 = MathHelper.sin(f);
                return entity.getZ() + (double)f1 * 1.25D + vecZ * 1.35D;
            }
        }



    }

    class AwakenGoal extends Goal {

        public AwakenGoal() {
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
        }

        public boolean canStart() {
            return deactivateProgress > 0F;
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            The_Harbinger_Entity.this.setVelocity(0, The_Harbinger_Entity.this.getVelocity().y, 0);
        }
    }

    static class MissileLaunchGoal2 extends SimpleAnimationGoal<The_Harbinger_Entity> {

        public MissileLaunchGoal2(The_Harbinger_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            super.start();
            entity.setOverload(entity.getOverload() + 1);
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.lookAtEntity(target, 30, 30);
                entity.getLookControl().lookAt(target, 30, 30);
                if (entity.getAnimationTick() == 71 || entity.getAnimationTick() == 75 || entity.getAnimationTick() == 79) {
                    this.mlaunch(2, target);
                    this.mlaunch(1, target);
                }
            }
        }

        private void mlaunch(int head, LivingEntity target) {
            if (!entity.isSilent()) {
                entity.playSound(ModSounds.ROCKET_LAUNCH,1,1.0F);
            }
            double d0 = this.getLauncherX(head);
            double d1 = this.getLauncherY(head);
            double d2 = this.getLauncherZ(head);

            Wither_Homing_Missile_Entity laserBeam = new Wither_Homing_Missile_Entity(entity.getWorld(), entity, target);
            laserBeam.setPos(d0, d1, d2);
            entity.getWorld().spawnEntity(laserBeam);
        }


        private double getLauncherX(int head) {
            if (head <= 0) {
                return entity.getX();
            } else {
                double theta = (entity.bodyYaw) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                float f = (entity.bodyYaw + (float) (180 * (head - 1))) * ((float) Math.PI / 180F);
                float f1 = MathHelper.cos(f);
                return entity.getX() + (double) f1 * 1.25D + vecX * 1.35D;
            }
        }

        private double getLauncherY(int head) {
            return head <= 0 ? entity.getY() + 3.0D : entity.getY() + 3.8D;
        }

        private double getLauncherZ(int head) {
            if (head <= 0) {
                return entity.getZ();
            } else {
                double theta = (entity.bodyYaw) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecZ = Math.sin(theta);
                float f = (entity.bodyYaw + (float) (180 * (head - 1))) * ((float) Math.PI / 180F);
                float f1 = MathHelper.sin(f);
                return entity.getZ() + (double) f1 * 1.25D + vecZ * 1.35D;
            }
        }
    }
}





