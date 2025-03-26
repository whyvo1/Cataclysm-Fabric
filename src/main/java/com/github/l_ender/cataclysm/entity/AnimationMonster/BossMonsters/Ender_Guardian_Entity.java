package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.l_ender.cataclysm.client.gui.CustomBossBar;
import com.github.l_ender.cataclysm.client.gui.CustomBossBarStyles;
import com.github.l_ender.cataclysm.client.particle.RingParticle;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AI.AdvancedHurtByTargetGoal;
import com.github.l_ender.cataclysm.entity.AnimationMonster.AI.*;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.entity.effect.Void_Vortex_Entity;
import com.github.l_ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.entity.projectile.Ender_Guardian_Bullet_Entity;
import com.github.l_ender.cataclysm.entity.projectile.Void_Rune_Entity;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.AnimationHandler;
import net.minecraft.world.GameRules;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ShulkerBulletEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

import static java.lang.Math.*;

public class Ender_Guardian_Entity extends LLibrary_Boss_Monster {

    private final CustomBossBar bossInfo = new CustomBossBar(this.getDisplayName(), CustomBossBarStyles.ENDER_GUARDIAN, false);
    private static final TrackedData<Boolean> IS_HELMETLESS = DataTracker.registerData(Ender_Guardian_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> USED_MASS_DESTRUCTION = DataTracker.registerData(Ender_Guardian_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Optional<BlockPos>> TELEPORT_POS = DataTracker.registerData(Ender_Guardian_Entity.class, TrackedDataHandlerRegistry.OPTIONAL_BLOCK_POS);
    public static final Animation GUARDIAN_RIGHT_STRONG_ATTACK = Animation.create(60);
    public static final Animation GUARDIAN_LEFT_STRONG_ATTACK = Animation.create(60);
    public static final Animation GUARDIAN_RIGHT_ATTACK = Animation.create(40);
    public static final Animation GUARDIAN_LEFT_ATTACK = Animation.create(40);
    public static final Animation GUARDIAN_BURST_ATTACK = Animation.create(53);
    public static final Animation GUARDIAN_UPPERCUT_AND_BULLET = Animation.create(100);
    public static final Animation GUARDIAN_RAGE_UPPERCUT = Animation.create(120);
    public static final Animation GUARDIAN_STOMP = Animation.create(48);
    public static final Animation GUARDIAN_RAGE_STOMP = Animation.create(83);
    public static final Animation GUARDIAN_MASS_DESTRUCTION = Animation.create(75);
    public static final Animation GUARDIAN_FALLEN = Animation.create(196);
    public static final Animation GUARDIAN_HUG_ME = Animation.create(76);
    public static final Animation GUARDIAN_AIR_STRIKE1 = Animation.create(123);
    public static final Animation GUARDIAN_AIR_STRIKE2 = Animation.create(39);
    public static final Animation GUARDIAN_RIGHT_SWING = Animation.create(42);
    public static final Animation GUARDIAN_LEFT_SWING = Animation.create(42);
    public static final Animation GUARDIAN_BLACKHOLE = Animation.create(62);
    public static final Animation GUARDIAN_ROCKETPUNCH = Animation.create(58);
    public static final int STOMP_COOLDOWN = 400;
    public static final int UPPERCUT_COOLDOWN = 200;
    public static final int TELEPORT_COOLDOWN = 280;
    public static final int TELEPORT_SMASH_COOLDOWN = 600;
    public static final int VORTEX_COOLDOWN = 280;
    public static final int NATURE_HEAL_COOLDOWN = 200;
    public boolean Breaking = CMConfig.EnderguardianBlockBreaking;

    private int timeWithoutTarget;
    private int stomp_cooldown = 0;
    private int teleport_cooldown = 0;
    private int teleport_smash_cooldown = 0;
    private int uppercut_cooldown = 0;
    private int vortexcooldown = 0;

    public Ender_Guardian_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 300;
        this.setStepHeight(1.75F);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0F);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, 0.0F);
        setConfigattribute(this, CMConfig.EnderguardianHealthMultiplier, CMConfig.EnderguardianDamageMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{
                NO_ANIMATION,
                GUARDIAN_RIGHT_STRONG_ATTACK,
                GUARDIAN_LEFT_STRONG_ATTACK,
                GUARDIAN_BURST_ATTACK,
                GUARDIAN_UPPERCUT_AND_BULLET,
                GUARDIAN_STOMP,
                GUARDIAN_RIGHT_ATTACK,
                GUARDIAN_LEFT_ATTACK,
                GUARDIAN_MASS_DESTRUCTION,
                GUARDIAN_RAGE_STOMP,
                GUARDIAN_RAGE_UPPERCUT,
                GUARDIAN_FALLEN,
                GUARDIAN_HUG_ME,
                GUARDIAN_AIR_STRIKE1,
                GUARDIAN_AIR_STRIKE2,
                GUARDIAN_LEFT_SWING,
                GUARDIAN_RIGHT_SWING,
                GUARDIAN_BLACKHOLE,
                GUARDIAN_ROCKETPUNCH};
    }

    protected void initGoals() {
        this.goalSelector.add(2, new AttackMoveGoal(this,true,1.0));
        this.goalSelector.add(1, new PunchAttackGoal(this));
        this.goalSelector.add(1, new AttackAnimationGoal2<>(this, GUARDIAN_MASS_DESTRUCTION, 39, 50){
            @Override
            public void start() {
                super.start();
                entity.setUsedMassDestruction(true);
            }
        });
        this.goalSelector.add(1, new AttackAnimationGoal2<>(this, GUARDIAN_BURST_ATTACK, 27, 47));
        this.goalSelector.add(1, new VoidVortexGoal(this, GUARDIAN_BLACKHOLE));
        this.goalSelector.add(1, new RocketPunchGoal(this, GUARDIAN_ROCKETPUNCH));
        this.goalSelector.add(1, new SimpleAnimationGoal<>(this, GUARDIAN_AIR_STRIKE2));
        this.goalSelector.add(1, new AttackAnimationGoal1<>(this, GUARDIAN_RIGHT_SWING, 26, true));
        this.goalSelector.add(1, new AttackAnimationGoal1<>(this, GUARDIAN_LEFT_SWING, 26, true));
        this.goalSelector.add(1, new HugmeGoal(this, GUARDIAN_HUG_ME,30,20));
        this.goalSelector.add(1, new TeleportStrikeGoal(this, GUARDIAN_AIR_STRIKE1));
        this.goalSelector.add(1, new StompAttackGoal(this));
        this.goalSelector.add(1, new UppercutAndBulletGoal(this,GUARDIAN_UPPERCUT_AND_BULLET));
        this.goalSelector.add(1, new RageUppercut(this,GUARDIAN_RAGE_UPPERCUT));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new AdvancedHurtByTargetGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));

    }

    public static DefaultAttributeContainer.Builder ender_guardian() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 50.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.27F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 16)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 333)
                .add(EntityAttributes.GENERIC_ARMOR, 20)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(IS_HELMETLESS, false);
        this.dataTracker.startTracking(TELEPORT_POS, Optional.empty());
        this.dataTracker.startTracking(USED_MASS_DESTRUCTION, false);
    }

    private static Animation getRandomAttack(Random rand) {
        return switch (rand.nextInt(4)) {
            case 0 -> GUARDIAN_RIGHT_STRONG_ATTACK;
            case 1 -> GUARDIAN_LEFT_STRONG_ATTACK;
            case 2 -> GUARDIAN_RIGHT_ATTACK;
            case 3 -> GUARDIAN_LEFT_ATTACK;
            default -> GUARDIAN_RIGHT_STRONG_ATTACK;
        };
    }


    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        Optional<BlockPos> restPos = getTeleportPos();
        if (restPos.isPresent()) {
            compound.put("TeleportPos", NbtHelper.fromBlockPos(getTeleportPos().get()));
        }

        compound.putBoolean("is_Helmetless", getIsHelmetless());
        compound.putBoolean("used_mass_destruction", getUsedMassDestruction());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        if (compound.contains("TeleportPos")) {
            setTeleportPos(NbtHelper.toBlockPos(compound.getCompound("TeleportPos")));
        }
        setIsHelmetless(compound.getBoolean("is_Helmetless"));
        setUsedMassDestruction(compound.getBoolean("used_mass_destruction"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    public void setIsHelmetless(boolean isHelmetless) {
        if (isHelmetless) {
            this.getAttributeInstance(EntityAttributes.GENERIC_ARMOR).setBaseValue(15F);
            this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.29F);
        }else{
            this.getAttributeInstance(EntityAttributes.GENERIC_ARMOR).setBaseValue(20F);
            this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.27F);
        }
        this.dataTracker.set(IS_HELMETLESS, isHelmetless);
    }

    public boolean getIsHelmetless() {
        return this.dataTracker.get(IS_HELMETLESS);

    }

    public void setUsedMassDestruction(boolean usedMassDestruction) {
        this.dataTracker.set(USED_MASS_DESTRUCTION, usedMassDestruction);
    }

    public boolean getUsedMassDestruction() {
        return this.dataTracker.get(USED_MASS_DESTRUCTION);
    }

    public void setTeleportPos(BlockPos p_30220_) {
        this.dataTracker.set(TELEPORT_POS, Optional.of(p_30220_));
    }

    public Optional<BlockPos> getTeleportPos() {
        return this.dataTracker.get(TELEPORT_POS);
    }


    public void setCustomName(@Nullable Text name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    protected int getNextAirUnderwater(int air) {
        return air;
    }

    @Override
    public boolean damage(DamageSource source, float damage) {
        if (this.getAnimation() == GUARDIAN_MASS_DESTRUCTION && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        double range = calculateRange(source);

        if (range > CMConfig.EnderguardianLongRangelimit * CMConfig.EnderguardianLongRangelimit && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        Entity entity = source.getSource();
        if (!this.getIsHelmetless()) {
            if (entity instanceof PersistentProjectileEntity) {
                return false;
            }
        }
        if (entity instanceof ShulkerBulletEntity || entity instanceof Ender_Guardian_Bullet_Entity) {
            return false;
        }
        if (entity instanceof GolemEntity) {
            damage *= 0.5;
        }

        boolean attack = super.damage(source, damage);
        if(attack) {
            if (this.getIsHelmetless()) {
                this.playSound(SoundEvents.ENTITY_SHULKER_HURT, 1.0f, 0.8f);
            }
        }
        return attack;
    }

    
    public float DamageCap() {
        return (float) CMConfig.EnderguardianDamageCap;
    }

    public int DamageTime() {
        return CMConfig.EnderguardianDamageTime;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.isOf(DamageTypes.IN_WALL)  || super.isInvulnerableTo(source);
    }

    public boolean handleFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }


    public void tick() {
        super.tick();
        //prevgetYRot() = getYRot();
        repelEntities(1.8F, 4.0f, 1.8F, 1.8F);
        float ch = this.getHealth();
        float mh = this.getMaxHealth();
        this.bossInfo.setPercent(ch / mh);

        LivingEntity target = this.getTarget();
        if (!this.getWorld().isClient) {
            if (timeWithoutTarget > 0) timeWithoutTarget--;
            if (target != null) {
                timeWithoutTarget = NATURE_HEAL_COOLDOWN;
            }

            if (this.getAnimation() == NO_ANIMATION && timeWithoutTarget <= 0) {
                if (!isAiDisabled() && CMConfig.EnderguardianNatureHealing > 0) {
                    if (this.age % 20 == 0) {
                        this.heal((float) CMConfig.EnderguardianNatureHealing);
                    }
                }
            }
        }
        Animation animation = getRandomAttack(random);
        Animation animation2 = this.getIsHelmetless() ? GUARDIAN_RAGE_UPPERCUT : GUARDIAN_UPPERCUT_AND_BULLET;
        if (this.isAlive()) {
            if (!this.getIsHelmetless() && this.isHelmetless()) {
                this.setIsHelmetless(true);
                BrokenHelmet();
            }
            if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && !this.getUsedMassDestruction() && this.isHelmetless()) {
                this.setAnimation(GUARDIAN_MASS_DESTRUCTION);
            }
            else if (target != null && target.isAlive()) {
                if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.squaredDistanceTo(target) >= 256 && this.squaredDistanceTo(target) <= 1024.0D && target.isOnGround() && this.getIsHelmetless() && this.getRandom().nextFloat() * 100.0F < 20f  && teleport_smash_cooldown <= 0) {
                    teleport_smash_cooldown = TELEPORT_SMASH_COOLDOWN;
                    this.setAnimation(GUARDIAN_AIR_STRIKE1);
                }else if (vortexcooldown <= 0 && !isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.squaredDistanceTo(target) <= 1024.0D && (this.squaredDistanceTo(target) >= 35.0D &&this.getRandom().nextFloat() * 100.0F < 2f || this.getRandom().nextFloat() * 100.0F < 60f && this.getY() + 3 <= target.getY())) {
                    vortexcooldown = VORTEX_COOLDOWN;
                    this.setAnimation(GUARDIAN_BLACKHOLE);
                } else if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) >= 4.3 && this.distanceTo(target) <= 16D && target.isOnGround() && this.getRandom().nextFloat() * 100.0F < 4f && teleport_cooldown <= 0) {
                    teleport_cooldown = TELEPORT_COOLDOWN;
                    this.setAnimation(GUARDIAN_HUG_ME);
                } else if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) < 4.3 && target.isOnGround() && this.getRandom().nextFloat() * 100.0F < 0.7f && teleport_cooldown <= 0) {
                    teleport_cooldown = TELEPORT_COOLDOWN;
                    this.setAnimation(GUARDIAN_HUG_ME);
                } else if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) < 2.75F) {
                    if (this.random.nextInt(6) == 0) {
                        this.setAnimation(GUARDIAN_BURST_ATTACK);
                    } else {
                        this.setAnimation(animation);
                    }
                } else if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) > 2.75F && this.distanceTo(target) < 4.3F && (target.hasStatusEffect(StatusEffects.LEVITATION) || target.hasStatusEffect(ModEffect.EFFECTSTUN))) {
                    uppercut_cooldown = UPPERCUT_COOLDOWN;
                    this.setAnimation(animation2);
                } else if (stomp_cooldown <= 0 && !isAiDisabled() && this.getAnimation() == NO_ANIMATION && target.isOnGround() && (this.distanceTo(target) > 6F && this.distanceTo(target) < 13F && this.getRandom().nextFloat() * 100.0F < 10f || this.distanceTo(target) > 2.75F && this.distanceTo(target) < 4.3F && this.getRandom().nextFloat() * 100.0F < 2f)) {
                    stomp_cooldown = STOMP_COOLDOWN;
                    Animation animation3 = this.getIsHelmetless() ? GUARDIAN_RAGE_STOMP : GUARDIAN_STOMP;
                    this.setAnimation(animation3);
                } else if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) > 2.75F && this.distanceTo(target) < 4.3F) {
                    if (this.random.nextInt(4) == 0) {
                        uppercut_cooldown = UPPERCUT_COOLDOWN;
                        this.setAnimation(animation2);
                    } else {
                        this.setAnimation(animation);
                    }
                }
            }
        }


        if (stomp_cooldown > 0) stomp_cooldown--;
        if (teleport_cooldown > 0) teleport_cooldown--;
        if (teleport_smash_cooldown > 0) teleport_smash_cooldown--;
        if (uppercut_cooldown > 0) uppercut_cooldown--;
        if (vortexcooldown > 0) vortexcooldown--;
    }

    public void tickMovement() {
        super.tickMovement();
        if (this.getAnimation() == GUARDIAN_LEFT_STRONG_ATTACK) {
            if (this.getAnimationTick() < 2) {
                GravityPullparticle();
            }
            if (this.getAnimationTick() < 29) {
                GravityPull();
            }
            if (this.getAnimationTick() == 34) {
                this.playSound(ModSounds.ENDER_GUARDIAN_FIST, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(5.15f,5,70,1.0f,(float) CMConfig.EnderguardianGravityPunchHpdamage,100,0,0,false);
                Attackparticle(2.2f,0);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 20, 0.2f, 0, 10);
            }

        }
        if (this.getAnimation() == GUARDIAN_RIGHT_STRONG_ATTACK) {
            if (this.getAnimationTick() < 2) {
                GravityPullparticle();
            }
            if (this.getAnimationTick() < 24) {
                GravityPull();
            }
            if (this.getAnimationTick() == 29) {
                AreaAttack(5.15f,5,70,1.0f,(float) CMConfig.EnderguardianGravityPunchHpdamage,100,0,0,false);
                this.playSound(ModSounds.ENDER_GUARDIAN_FIST, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                Attackparticle(2.2f,0);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 20, 0.2f, 0, 10);
            }

        }

        if (this.getAnimation() == GUARDIAN_RIGHT_ATTACK) {
            if (this.getAnimationTick() == 22) {
                AreaAttack(5.85f,5,80,1, 0,80,0,0,false);
                this.playSound(ModSounds.ENDER_GUARDIAN_FIST, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                Attackparticle(2.75f,0.5f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.1f, 0, 10);
            }
        }

        if (this.getAnimation() == GUARDIAN_LEFT_ATTACK) {
            if (this.getAnimationTick() == 19) {
                AreaAttack(5.85f,5,80,1,0,80,0,0,false);
                this.playSound(ModSounds.ENDER_GUARDIAN_FIST, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                Attackparticle(2.75f,-0.5f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.1f, 0, 10);
            }
        }

        if (this.getAnimation() == GUARDIAN_BURST_ATTACK) {
            if (this.getAnimationTick() == 15) {
                Burstparticle();
            }
            if (this.getAnimationTick() == 27) {
                this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(7.5f,6,100,1,(float) CMConfig.EnderguardianKnockbackHpdamage,0,0,0,true);
            }
        }
        if (this.getAnimation() == GUARDIAN_UPPERCUT_AND_BULLET || this.getAnimation() == GUARDIAN_RAGE_UPPERCUT) {
            if (this.getAnimationTick() == 27) {
                this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.25f,7,60,1.4f,(float) CMConfig.EnderguardianUppercutHpdamage,150,60,0.5F,false);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.3f, 0, 10);
            }
        }
        if (this.getAnimation() == GUARDIAN_STOMP) {
            if (this.getAnimationTick() == 32) {
                StompAttack();
                Attackparticle(0.4f,0.8f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 10, 0.1f, 0, 5);
            }
        }
        if (this.getAnimation() == GUARDIAN_RAGE_STOMP) {
            if (this.getAnimationTick() == 32 || this.getAnimationTick() == 53 || this.getAnimationTick() == 62) {
                StompAttack();
                Attackparticle(0.4f,0.8f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 10, 0.1f, 0, 5);
            }
        }
        if (this.getAnimation() == GUARDIAN_RAGE_UPPERCUT) {
            if (this.getAnimationTick() == 84) {
                RageAttack();
                AreaAttack(5.5f,5,120,1.2f,(float) CMConfig.EnderguardianAreaAttackHpdamage,100,0,0.0F,false);

                this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.2f, 0, 10);
            }
        }

        if (this.getAnimation() == GUARDIAN_MASS_DESTRUCTION) {
            if (this.getAnimationTick() == 39) {
                Attackparticle(2.75f,2.25f);
                Attackparticle(2.75f,-2.25f);
                this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                MassDestruction(5.0f, 1.1f,150);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.3f, 0, 10);
                if (!this.getWorld().isClient) {
                    if (Breaking) {
                        BlockBreaking(CMConfig.EnderguardianBlockBreakingX, CMConfig.EnderguardianBlockBreakingY, CMConfig.EnderguardianBlockBreakingZ);
                    } else {
                        if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                            BlockBreaking(CMConfig.EnderguardianBlockBreakingX, CMConfig.EnderguardianBlockBreakingY, CMConfig.EnderguardianBlockBreakingZ);
                        }
                    }
                }
            }
        }

        if (this.getAnimation() == GUARDIAN_HUG_ME) {
            if (this.getAnimationTick() == 15) {
                Teleportparticle();
            }

            if (this.getAnimationTick() == 38) {
                AreaAttack(6.0f,6.0f,120,1.0f,(float) CMConfig.EnderguardianTeleportAttackHpdamage,80,60,0.6F,false);
                this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.2f, 0, 10);

            }
        }

        if (this.getAnimation() == GUARDIAN_AIR_STRIKE1) {
            if (this.getAnimationTick() == 20) {
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 20, 0.15f, 0, 20);
                this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
            }

            if (this.getAnimationTick() == 40) {
                this.playSound(SoundEvents.ENTITY_SHULKER_TELEPORT, 1.0F, 1.0F);
            }
        }


        if (this.getAnimation() == GUARDIAN_AIR_STRIKE2) {
            if (this.getAnimationTick() == 3) {
                MassDestruction(3.0F,1.5F,200);
                this.playSound(ModSounds.ENDER_GUARDIAN_FIST, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                Attackparticle(2.5f,1.25f);
                Attackparticle(2.5f,-0.5f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 20, 0.3f, 0, 20);
                switch (random.nextInt(3)) {
                    case 0 -> StrikeRune(8,0.5);
                    case 1 -> StrikeRune(10,0.75);
                    case 2 -> StrikeRune(12,1);
                    default -> {
                    }
                }
            }
        }

        if (this.getAnimation() == GUARDIAN_RIGHT_SWING || this.getAnimation() == GUARDIAN_LEFT_SWING) {
            if (this.getAnimationTick() == 24) {
                this.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 2.0f, 0.5F);
                AreaAttack(4.25f,4.25f,80,1.0f, 0,40,40,0.0F,true);
            }
        }
        if (this.getAnimation() == GUARDIAN_BLACKHOLE) {
            if (this.getAnimationTick() == 26) {
                this.playSound(ModSounds.ENDER_GUARDIAN_FIST, 0.3f, 1F + this.getRandom().nextFloat() * 0.1F);
                Attackparticle(1.0f,0.2f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 10, 0.1f, 0, 5);
            }
        }
        if (this.getAnimation() == GUARDIAN_ROCKETPUNCH) {
            if (this.getAnimationTick() == 24) {
                this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.getAnimationTick() == 28) {
                AreaAttack(7f,7f,120,1.25f, (float) CMConfig.EnderguardianRocketPunchHpdamage,200,0,0.0F,true);
            }
        }


    }


    private void StrikeRune(int rune, double time) {
        for (int i = 0; i < rune; i++) {
            float throwAngle = i * MathHelper.PI / (rune/2);
            for (int k = 0; k < 8; ++k) {
                double d2 = 1.15D * (double) (k + 1);
                int d3 = (int) (time * (k + 1));
                this.spawnFangs(this.getX() + (double) MathHelper.cos(throwAngle) * 1.25D * d2, this.getZ() + (double) MathHelper.sin(throwAngle) * 1.25D * d2, this.getY(), this.getY() + 2, throwAngle, d3);
            }

        }
    }


    public boolean isHelmetless() {
        return this.getHealth() <= this.getMaxHealth() / 2.0F;
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();
        setVelocity(0, Ender_Guardian_Entity.this.getVelocity().y, 0);
        if (this.deathTime == 50) {
            this.playSound(ModSounds.MONSTROSITYLAND, 1, 1);
        }
        if (this.deathTime == 100) {
            this.playSound(SoundEvents.ENTITY_SHULKER_TELEPORT, 1, 1);
        }

    }

    @Nullable
    public Animation getDeathAnimation()
    {
        return GUARDIAN_FALLEN;
    }


    private void AreaAttack(float range, float height, float arc, float damage, float hpdamage, int shieldbreakticks, int stunticks, float airborne, boolean knockback) {
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
                if (!(entityHit instanceof Ender_Guardian_Entity)) {
                    DamageSource damagesource = this.getDamageSources().mobAttack(this);
                    boolean flag = entityHit.damage(damagesource, (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage + Math.min(this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage, entityHit.getMaxHealth() * hpdamage) ));
                    if (entityHit.blockedByShield(damagesource) && entityHit instanceof PlayerEntity player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }

                    if (airborne > 0) {
                        entityHit.setVelocity(entityHit.getVelocity().add(0.0D, airborne, 0.0D));

                    }
                    if (flag) {
                        if (stunticks > 0) {
                            entityHit.addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTSTUN, stunticks));
                        }
                    }

                    if(knockback){
                        launch(entityHit);
                    }
                }
            }
        }
    }


    private void MassDestruction(float grow, float damage, int ticks) {
        for (LivingEntity entityHit : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(grow))) {
            if (!isTeammate(entityHit) && !(entityHit instanceof Ender_Guardian_Entity) && entityHit != this) {
                DamageSource damagesource = this.getDamageSources().mobAttack(this);
                entityHit.damage(damagesource, (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage);
                if (entityHit.blockedByShield(damagesource) && entityHit instanceof PlayerEntity player && ticks > 0) {
                    disableShield(player, ticks);
                }

                launch(entityHit);
            }
        }
    }

    private void BlockBreaking(int x, int y, int z) {
        int MthX = MathHelper.floor(this.getX());
        int MthY = MathHelper.floor(this.getY());
        int MthZ = MathHelper.floor(this.getZ());
        boolean flag = false;
        for (int k2 = -x; k2 <= x; ++k2) {
            for (int l2 = -z; l2 <= z; ++l2) {
                for (int j = -y; j <= -1; ++j) {
                    int i3 = MthX + k2;
                    int k = MthY + j;
                    int l = MthZ + l2;
                    BlockPos blockpos = new BlockPos(i3, k, l);
                    BlockState block = this.getWorld().getBlockState(blockpos);
                    if (block != Blocks.AIR.getDefaultState() && block.isIn(ModTag.ENDER_GUARDIAN_CAN_DESTROY)) {
                        flag = this.getWorld().breakBlock(blockpos, false, this) || flag;
                    }
                }
            }
        }
    }


    private void Burstparticle() {
        if (this.getWorld().isClient) {
            double d0 = this.getX();
            double d1 = this.getY() + 2.0;
            double d2 = this.getZ();
            int size = (int) 5f;
            for (int i = -size; i <= size; ++i) {
                for (int j = -size; j <= size; ++j) {
                    for (int k = -size; k <= size; ++k) {
                        double d3 = (double) j + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                        double d4 = (double) i + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                        double d5 = (double) k + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                        double d6 = (double) MathHelper.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + this.random.nextGaussian() * 0.05D;
                        this.getWorld().addParticle(ParticleTypes.REVERSE_PORTAL, d0, d1, d2, d3 / d6, d4 / d6, d5 / d6);
                        if (i != -size && i != size && j != -size && j != size) {
                            k += size * 2 - 1;
                        }
                    }
                }
            }
        }
    }

    private void Teleportparticle() {
        if (this.getWorld().isClient) {
            if (getTeleportPos().isPresent()) {
                double d0 = this.getTeleportPos().get().getX();
                double d1 = this.getY();
                double d2 = this.getTeleportPos().get().getZ();
                if (this.getWorld().isClient) {
                    for (int i1 = 0; i1 < 40 + random.nextInt(12); i1++) {
                        double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                        float angle = (0.01745329251F * this.bodyYaw) + i1;
                        double extraX = 2F * MathHelper.sin((float) (Math.PI + angle));
                        double extraY = 0.3F;
                        double extraZ = 2F * MathHelper.cos(angle);
                        this.getWorld().addParticle(ParticleTypes.END_ROD, d0 + extraX, d1 + extraY, d2 + extraZ, 0, DeltaMovementY, 0);
                    }
                }
            }
        }
    }


    private void launch(Entity entityHit) {
        double d0 = entityHit.getX() - this.getX();
        double d1 = entityHit.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        entityHit.addVelocity(d0 / d2 * 4.0D, 0.2D, d1 / d2 * 4.0D);
    }

    private void GravityPull() {
        List<LivingEntity> entities = getEntityLivingBaseNearby(12, 12, 12, 12);
        for (LivingEntity inRange : entities) {
            if (inRange instanceof PlayerEntity && ((PlayerEntity) inRange).getAbilities().invulnerable) continue;
            if (isTeammate(inRange)) continue;
            float angle = (0.01745329251F * this.bodyYaw);
            double extraX = MathHelper.sin((float) (Math.PI + angle));
            double extraZ = MathHelper.cos(angle);
            double theta = (bodyYaw) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            Vec3d diff = inRange.getPos().subtract(getPos().add(2.0 * vecX + extraX * 0.25, 0, 2.0 * vecZ + extraZ * 0.25));
            diff = diff.normalize().multiply(0.085);
            inRange.setVelocity(inRange.getVelocity().subtract(diff));

        }
    }

    private void GravityPullparticle() {
        if (this.getWorld().isClient) {
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                float angle = (0.01745329251F * this.bodyYaw) + i1;
                double extraX = MathHelper.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = MathHelper.cos(angle);
                double theta = (bodyYaw) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                this.getWorld().addParticle(ParticleTypes.PORTAL, getX() + 2.2 * vecX + extraX * 0.75, this.getY() + extraY, getZ() + 2.2 * vecZ + extraZ * 0.75, (this.random.nextDouble() - 0.5D) * 12.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 12.0D);
            }
        }
    }

    private void Attackparticle(float vec, float math) {
        if (this.getWorld().isClient) {
            float f = MathHelper.cos(this.bodyYaw * ((float)Math.PI / 180F)) ;
            float f1 = MathHelper.sin(this.bodyYaw * ((float)Math.PI / 180F)) ;
            double theta = (bodyYaw) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.bodyYaw) + i1;
                double extraX = 1.2 * MathHelper.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = 1.2 * MathHelper.cos(angle);
                int hitX = MathHelper.floor(getX() + vec * vecX+ extraX);
                int hitY = MathHelper.floor(getY());
                int hitZ = MathHelper.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = getWorld().getBlockState(hit.down());
                if (block.getRenderType() != BlockRenderType.INVISIBLE) {
                    this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }

            }
            this.getWorld().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 25, 1f, 1f, 1f, 1f, 25f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), getX() + vec * vecX + f * math, getY() + 0.3f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
        }
    }

    private void StompAttack() {
        this.playSound(ModSounds.ENDER_GUARDIAN_FIST, 0.3f, 1F + this.getRandom().nextFloat() * 0.1F);
        LivingEntity target = this.getTarget();
        if (target != null) {
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 1.0D;
            float f = (float) MathHelper.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());

            float angle2 = (0.01745329251F * this.bodyYaw);

            for (int k = 0; k < 6; ++k) {
                float f2 = angle2 + (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 5F);
                this.spawnFangs(this.getX() + (double) MathHelper.cos(f2) * 2.5D, this.getZ() + (double) MathHelper.sin(f2) * 2.5D, d0, d1, f2, 3);
            }
            for (int k = 0; k < 11; ++k) {
                float f3 = angle2 + (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                this.spawnFangs(this.getX() + (double) MathHelper.cos(f3) * 3.5D, this.getZ() + (double) MathHelper.sin(f3) * 3.5D, d0, d1, f3, 10);
            }
            for (int k = 0; k < 14; ++k) {
                float f4 = angle2 + (float) k * (float) Math.PI * 2.0F / 14.0F + ((float) Math.PI * 2F / 20F);
                this.spawnFangs(this.getX() + (double) MathHelper.cos(f4) * 4.5D, this.getZ() + (double) MathHelper.sin(f4) * 4.5D, d0, d1, f4, 15);
            }

            float[] all = { f - 0.4f, f, f + 0.4f };


            float[] all2 = { f - 0.1f, f + 0.1f };

            switch (random.nextInt(3)) {
                case 0:
                    for (float angle : all) {
                        for (int l = 0; l < 13; ++l) {
                            double d2 = 1.25D * (double) (l + 1);
                            int j = (int) (0.75f * l);
                            this.spawnFangs(this.getX() + (double) MathHelper.cos(angle) * d2, this.getZ() + (double) MathHelper.sin(angle) * d2, d0, d1, angle, j);
                        }
                    }
                    break;
                case 1:
                    for (float angle : all2) {
                        for (int l = 0; l < 13; ++l) {
                            double d2 = 1.25D * (double) (l + 1);
                            int j = (int) (0.25f * l);
                            this.spawnFangs(this.getX() + (double) MathHelper.cos(angle) * d2, this.getZ() + (double) MathHelper.sin(angle) * d2, d0, d1, angle, j);
                        }
                    }
                    break;
                case 2:
                    for (int l = 0; l < 13; ++l) {
                        double d2 = 1.25D * (double) (l + 1);
                        int j = (int) (0.5f * l);
                        this.spawnFangs(this.getX() + (double) MathHelper.cos(f) * d2, this.getZ() + (double) MathHelper.sin(f) * d2, d0, d1, f, j);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void RageAttack() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 1.0D;

            float f = (float) MathHelper.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());

            float[] all = { f - 0.3f,f - 0.6f,f - 0.9f, f, f + 0.3f, f + 0.6f, f + 0.9f };

            for (float angle : all) {
                for (int l = 0; l < 10; ++l) {
                    double d2 = 1.25D * (double) (l + 1);
                    int j = (int) (0.75f * l);
                    this.spawnFangs(this.getX() + (double) MathHelper.cos(angle) * d2, this.getZ() + (double) MathHelper.sin(angle) * d2, d0, d1, angle, j);
                }
            }
        }
    }


    private void spawnFangs(double x, double z, double minY, double maxY, float rotation, int delay) {
        BlockPos blockpos = BlockPos.ofFloored(x, maxY, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.down();
            BlockState blockstate = this.getWorld().getBlockState(blockpos1);
            if (blockstate.isSideSolidFullSquare(this.getWorld(), blockpos1, Direction.UP)) {
                if (!this.getWorld().isAir(blockpos)) {
                    BlockState blockstate1 = this.getWorld().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.getWorld(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.getMax(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.down();
        } while(blockpos.getY() >= MathHelper.floor(minY) - 1);

        if (flag) {
            this.getWorld().spawnEntity(new Void_Rune_Entity(this.getWorld(), x, (double)blockpos.getY() + d0, z, rotation, delay,(float) CMConfig.Voidrunedamage, this));
        }
    }

    private void spawnVortex(double x, double z, double minY, double maxY, float rotation) {
        BlockPos blockpos =  BlockPos.ofFloored(x, maxY, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.down();
            BlockState blockstate = this.getWorld().getBlockState(blockpos1);
            if (blockstate.isSideSolidFullSquare(this.getWorld(), blockpos1, Direction.UP)) {
                if (!this.getWorld().isAir(blockpos)) {
                    BlockState blockstate1 = this.getWorld().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.getWorld(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.getMax(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.down();
        } while(blockpos.getY() >= MathHelper.floor(minY) - 1);

        if (flag) {
            this.getWorld().spawnEntity(new Void_Vortex_Entity(this.getWorld(), x, (double)blockpos.getY() + d0, z, rotation, this,300));
        }
    }

    private void BrokenHelmet() {
        if (!this.getWorld().isClient) {
            double xx = MathHelper.cos(this.getYaw() % 360.0F / 180.0F * 3.1415927F) * 0.75F;
            double zz = MathHelper.sin(this.getYaw() % 360.0F / 180.0F * 3.1415927F) * 0.75F;
            this.getWorld().createExplosion(this, this.getX() + xx, this.getY() + (double) this.getStandingEyeHeight(), getZ() + zz, 2.0F, World.ExplosionSourceType.NONE);
        }
    }

    private void Bulletpattern() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            BlockPos tgt = target.getBlockPos();
            double tx = tgt.getX();
            double tz = tgt.getZ();
            double ty = target.getY() + 0.1;
            if (this.getAnimationTick() == 54) {
                if (!target.isOnGround() && !target.isTouchingWater() && !this.getWorld().getBlockState(tgt.down()).blocksMovement())
                    ty -= 1;
                {
                    BlockPos Pos = this.getBlockPos();
                    double sx = Pos.getX();
                    double sz = Pos.getZ();
                    Direction dir = Direction.getFacing(tx - sx, 0, tz - sz);
                    double cx = dir.getOffsetX();
                    double cz = dir.getOffsetZ();
                    double offsetangle = toRadians(6.0);

                    for (int i = -4; i <= 4; i++) {
                        double angle = (i - (4 / 2)) * offsetangle;
                        double x = cx * cos(angle) + cz * sin(angle);
                        double z = -cx * sin(angle) + cz * cos(angle);
                        Ender_Guardian_Bullet_Entity bullet = new Ender_Guardian_Bullet_Entity(getWorld(), this, x, this.getY() + 2, z);
                        bullet.setOwner(this);
                        bullet.setPosition(getX(), getY() - 2 + random.nextDouble() * 4, getZ());
                        bullet.setUp(30, cx, 0, cz, tx - 7 * cx + i * cz, ty, tz - 7 * cz + i * cx);
                       this.getWorld().spawnEntity(bullet);
                    }
                }
            }
        }
    }


//    private boolean teleport(double p_32544_, double p_32545_, double p_32546_) {
//        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable(p_32544_, p_32545_, p_32546_);
//
//        while(blockpos$mutableblockpos.getY() > this.getWorld().getBottomY() && !this.getWorld().getBlockState(blockpos$mutableblockpos).blocksMovement()) {
//            blockpos$mutableblockpos.move(Direction.DOWN);
//        }
//
//        BlockState blockstate = this.getWorld().getBlockState(blockpos$mutableblockpos);
//        boolean flag = blockstate.blocksMovement();
//        if (flag) {
//            net.minecraftforge.event.entity.EntityTeleportEvent.EnderEntity event = net.minecraftforge.event.ForgeEventFactory.onEnderTeleport(this, p_32544_, p_32545_, p_32546_);
//            if (event.isCanceled()) return false;
//            Vec3d vec3 = this.getPos();
//            boolean flag2 = this.ProperTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
//            if (flag2) {
//                this.getWorld().emitGameEvent(GameEvent.TELEPORT, vec3, GameEvent.Emitter.of(this));
//                if (!this.isSilent()) {
//                    this.playSound(SoundEvents.ENTITY_SHULKER_TELEPORT, 1.0F, 1.0F);
//                }
//            }
//            return flag2;
//        } else {
//            return false;
//        }
//    }


    public boolean ProperTeleport(double p_20985_, double p_20986_, double p_20987_, boolean p_20988_) {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        double d3 = p_20986_;
        boolean flag = false;
        BlockPos blockpos = BlockPos.ofFloored(p_20985_, p_20986_, p_20987_);
        World level = this.getWorld();
        if (level.isChunkLoaded(blockpos)) {
            boolean flag1 = false;

            while(!flag1 && blockpos.getY() > level.getBottomY()) {
                BlockPos blockpos1 = blockpos.down();
                BlockState blockstate = level.getBlockState(blockpos1);
                if (blockstate.blocksMovement()) {
                    flag1 = true;
                } else {
                    --d3;
                    blockpos = blockpos1;
                }
            }

            if (flag1) {
                this.requestTeleport(p_20985_, d3, p_20987_);
                if (level.isSpaceEmpty(this) && !level.containsFluid(this.getBoundingBox())) {
                    flag = true;
                }
            }
        }

        if (!flag) {
            this.requestTeleport(d0, d1, d2);
            return false;
        } else {
            if (p_20988_) {
                level.sendEntityStatus(this, (byte)46);
            }
            this.getNavigation().stop();

            return true;
        }
    }


    @Override
    public boolean isPushedByFluids() {
        return false;
    }

    @Override
    public ItemEntity dropStack(ItemStack stack) {
        ItemEntity itementity = this.dropStack(stack,0.0f);
        if (itementity != null) {
            itementity.setVelocity(itementity.getVelocity().multiply(0.0, 3.5, 0.0));
            itementity.setGlowing(true);
            itementity.setCovetedItem();
        }
        return itementity;
    }

    public boolean isTeammate(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isTeammate(entityIn)) {
            return true;
        } else if (entityIn.getType().isIn(ModTag.TEAM_ENDER_GUARDIAN)) {
            return this.getScoreboardTeam() == null && entityIn.getScoreboardTeam() == null;
        } else {
            return false;
        }
    }

    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.ENDERGUARDIANHURT;
    }

    protected SoundEvent getAmbientSound() {
        return this.getIsHelmetless() ? SoundEvents.ENTITY_SHULKER_AMBIENT : super.getAmbientSound();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.ENDERGUARDIANDEATH;

    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.ENDERGUARDIAN_MUSIC;
    }

    @Override
    protected boolean canPlayMusic() {
        return super.canPlayMusic();
    }

    @Override
    protected BodyControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected EntityNavigation createNavigation(World worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }


    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossInfo.addPlayer(player);
    }

    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossInfo.removePlayer(player);
    }

    class PunchAttackGoal extends AnimationGoal<Ender_Guardian_Entity> {

        public PunchAttackGoal(Ender_Guardian_Entity entity) {
            super(entity);
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == GUARDIAN_LEFT_ATTACK
                    || animation == GUARDIAN_RIGHT_ATTACK
                    || animation == GUARDIAN_LEFT_STRONG_ATTACK
                    || animation == GUARDIAN_RIGHT_STRONG_ATTACK;
        }

        public void tick() {
            Ender_Guardian_Entity.this.setVelocity(0, Ender_Guardian_Entity.this.getVelocity().y, 0);
            LivingEntity target = Ender_Guardian_Entity.this.getTarget();
            if (Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_LEFT_ATTACK) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 17 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 27 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                    entity.lookAtEntity(target, 30.0F, 30.0F);
                } else {
                    Ender_Guardian_Entity.this.setYaw(Ender_Guardian_Entity.this.prevYaw);
                   // Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
                }
                if (Ender_Guardian_Entity.this.getAnimationTick() == 24 && target != null && Ender_Guardian_Entity.this.random.nextInt(2) == 0 && Ender_Guardian_Entity.this.distanceTo(target) <= 4) {
                    AnimationHandler.INSTANCE.sendAnimationMessage(Ender_Guardian_Entity.this, GUARDIAN_LEFT_SWING);
               }
            }
            if (Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_RIGHT_ATTACK) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 22 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 32 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                    entity.lookAtEntity(target, 30.0F, 30.0F);
                } else {
                    Ender_Guardian_Entity.this.setYaw(Ender_Guardian_Entity.this.prevYaw);
                  //  Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
                }
                if (Ender_Guardian_Entity.this.getAnimationTick() == 26 && target != null && Ender_Guardian_Entity.this.random.nextInt(2) == 0 && Ender_Guardian_Entity.this.distanceTo(target) <= 4) {
                   AnimationHandler.INSTANCE.sendAnimationMessage(Ender_Guardian_Entity.this, GUARDIAN_RIGHT_SWING);
//
                }
            }
            if (Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_LEFT_STRONG_ATTACK) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 34 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 44 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                    entity.lookAtEntity(target, 30.0F, 30.0F);
                } else {
                    Ender_Guardian_Entity.this.setYaw(Ender_Guardian_Entity.this.prevYaw);
                 //   Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
                }
            }
            if (Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_RIGHT_STRONG_ATTACK) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 29 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 39 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                    entity.lookAtEntity(target, 30.0F, 30.0F);
                } else {
                    Ender_Guardian_Entity.this.setYaw(Ender_Guardian_Entity.this.prevYaw);
                  //  Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
                }
            }
        }
    }

    class StompAttackGoal extends AnimationGoal<Ender_Guardian_Entity> {

        public StompAttackGoal(Ender_Guardian_Entity entity) {
            super(entity);
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == GUARDIAN_STOMP
                    || animation == GUARDIAN_RAGE_STOMP;
        }

        public void tick() {
            Ender_Guardian_Entity.this.setVelocity(0, Ender_Guardian_Entity.this.getVelocity().y, 0);
            LivingEntity target = Ender_Guardian_Entity.this.getTarget();
            if(Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_STOMP) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 32 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 42 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                    entity.lookAtEntity(target, 30.0F, 30.0F);
                } else {
                    Ender_Guardian_Entity.this.setYaw(Ender_Guardian_Entity.this.prevYaw);
                   // Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
                }
            }
            if(Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_RAGE_STOMP) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 32 && target != null
                        || Ender_Guardian_Entity.this.getAnimationTick() > 42 && Ender_Guardian_Entity.this.getAnimationTick() < 53 && target != null
                        || Ender_Guardian_Entity.this.getAnimationTick() > 58 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                    entity.lookAtEntity(target, 30.0F, 30.0F);
                } else {
                    Ender_Guardian_Entity.this.setYaw(Ender_Guardian_Entity.this.prevYaw);
                   // Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
                }
            }
        }
    }


    class UppercutAndBulletGoal extends SimpleAnimationGoal<Ender_Guardian_Entity> {

        public UppercutAndBulletGoal(Ender_Guardian_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
        }

        public void tick() {
            LivingEntity target = Ender_Guardian_Entity.this.getTarget();
            if (Ender_Guardian_Entity.this.getAnimationTick() < 29 && target != null
                    || Ender_Guardian_Entity.this.getAnimationTick() > 54 && target !=null) {
                Ender_Guardian_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                setYaw(bodyYaw);
            } else {
                Ender_Guardian_Entity.this.setYaw(Ender_Guardian_Entity.this.prevYaw);
              //  Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
            }
            if (Ender_Guardian_Entity.this.getAnimationTick() == 26) {
                float f1 = (float) Math.cos(Math.toRadians(Ender_Guardian_Entity.this.getYaw() + 90));
                float f2 = (float) Math.sin(Math.toRadians(Ender_Guardian_Entity.this.getYaw() + 90));
                if(target != null) {
                    float r = Ender_Guardian_Entity.this.distanceTo(target);
                    r = MathHelper.clamp(r, 0, 7);
                    Ender_Guardian_Entity.this.addVelocity(f1 * 0.3 * r, 0, f2 * 0.3 * r);
                }else{
                    Ender_Guardian_Entity.this.addVelocity(f1 * 2.0, 0, f2 * 2.0);
                }
            }
            if(Ender_Guardian_Entity.this.getAnimationTick() > 32 || Ender_Guardian_Entity.this.getAnimationTick() < 26){
                Ender_Guardian_Entity.this.setVelocity(0, Ender_Guardian_Entity.this.getVelocity().y, 0);
            }

            Bulletpattern();

        }
    }

    class RageUppercut extends SimpleAnimationGoal<Ender_Guardian_Entity> {

        public RageUppercut(Ender_Guardian_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
        }

        public void tick() {
            LivingEntity target = Ender_Guardian_Entity.this.getTarget();
            if (Ender_Guardian_Entity.this.getAnimationTick() < 29 && target != null
                    || Ender_Guardian_Entity.this.getAnimationTick() > 54 && Ender_Guardian_Entity.this.getAnimationTick() < 84 && target != null
                    ||Ender_Guardian_Entity.this.getAnimationTick() > 104 && target !=null) {
                Ender_Guardian_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                setYaw(bodyYaw);
            } else {
                Ender_Guardian_Entity.this.setYaw(Ender_Guardian_Entity.this.prevYaw);
                //  Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
            }
            if (Ender_Guardian_Entity.this.getAnimationTick() == 26) {
                float f1 = (float) Math.cos(Math.toRadians(Ender_Guardian_Entity.this.getYaw() + 90));
                float f2 = (float) Math.sin(Math.toRadians(Ender_Guardian_Entity.this.getYaw() + 90));
                if(target != null) {
                    float r = Ender_Guardian_Entity.this.distanceTo(target);
                    r = MathHelper.clamp(r, 0, 7);
                    Ender_Guardian_Entity.this.addVelocity(f1 * 0.3 * r, 0, f2 * 0.3 * r);
                }else{
                    Ender_Guardian_Entity.this.addVelocity(f1 * 2.0, 0, f2 * 2.0);
                }
            }
            if(Ender_Guardian_Entity.this.getAnimationTick() > 32 || Ender_Guardian_Entity.this.getAnimationTick() < 26){
                Ender_Guardian_Entity.this.setVelocity(0, Ender_Guardian_Entity.this.getVelocity().y, 0);
            }

            Bulletpattern();

        }
    }


    static class TeleportStrikeGoal extends SimpleAnimationGoal<Ender_Guardian_Entity> {

        public TeleportStrikeGoal(Ender_Guardian_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if(entity.getAnimationTick() < 40) {
                entity.setVelocity(0, entity.getVelocity().y, 0);
            }
            if (target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.lookAtEntity(target, 30.0F, 30.0F);
                if(entity.getAnimationTick() == 40){
                    float y = entity.getIsHelmetless() ? 8.0f : 4.0f;
                    entity.requestTeleport(target.getX(), target.getY() + y, target.getZ());
                }
            }


            if (entity.getAnimationTick() > 48 && entity.isOnGround()) {
                AnimationHandler.INSTANCE.sendAnimationMessage(entity, GUARDIAN_AIR_STRIKE2);
            }

        }
    }


    class HugmeGoal extends SimpleAnimationGoal<Ender_Guardian_Entity> {

        private final float sensing;
        private final int teleport;
        public  double prevX;
        public double prevZ;
        private int newX;
        private int newZ;

        public HugmeGoal(Ender_Guardian_Entity entity, Animation animation, float sensing, int teleport) {
            super(entity, animation);
            this.sensing = sensing;
            this.teleport = teleport;
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
        }



        @Override
        public void start() {
            super.start();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                prevX = target.getX();
                prevZ = target.getZ();
            }
        }


        public void tick() {
            LivingEntity target = entity.getTarget();
            if (Ender_Guardian_Entity.this.getAnimationTick() < 40 && target != null) {
                Ender_Guardian_Entity.this.lookAtEntity(target, 30.0F, 30.0F);
                Ender_Guardian_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
            }else {
                Ender_Guardian_Entity.this.setYaw(Ender_Guardian_Entity.this.prevYaw);
                //  Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
            }
            if (entity.getAnimationTick() == (teleport - 6) && target != null) {
                double x = target.getX();
                double z = target.getZ();
                double vx = (x - prevX) / teleport;
                double vz = (z - prevZ) / teleport;
                newX = MathHelper.floor(x + vx * sensing);
                newZ = MathHelper.floor(z + vz * sensing);
                entity.setTeleportPos(BlockPos.ofFloored(newX, target.getY(), newZ));
            }

            if (entity.getAnimationTick() == teleport && target != null) {
                if (entity.getTeleportPos().isPresent()) {
                    entity.teleport(entity.getTeleportPos().get().getX(), target.getY(), entity.getTeleportPos().get().getZ());
                }
            }
        }
    }

    static class VoidVortexGoal extends SimpleAnimationGoal<Ender_Guardian_Entity> {


        public VoidVortexGoal(Ender_Guardian_Entity entity, Animation animation) {
            super(entity, animation);

            this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.JUMP, Goal.Control.LOOK));
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < 26 && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.lookAtEntity(target, 30.0F, 30.0F);

            }else {
                entity.setYaw(entity.prevYaw);
                //  Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
            }

            if (entity.getAnimationTick() == 26 && target != null){
                double tx = target.getX();
                double ty = target.getY();
                double tz = target.getZ();
                double minY = Math.min(ty, entity.getY());
                double maxY = Math.max(ty, entity.getY()) + 1;
                float angle = (float) MathHelper.atan2(tz - entity.getZ(), tx - entity.getX());
                entity.spawnVortex(tx, tz, minY, maxY, angle);
            }

            if (entity.getAnimationTick() == 37 && target != null && entity.squaredDistanceTo(target) >= 25.0D){
                AnimationHandler.INSTANCE.sendAnimationMessage(entity, GUARDIAN_ROCKETPUNCH);
            }
        }
    }


    static class RocketPunchGoal extends SimpleAnimationGoal<Ender_Guardian_Entity> {


        public RocketPunchGoal(Ender_Guardian_Entity entity, Animation animation) {
            super(entity, animation);

            this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.JUMP, Goal.Control.LOOK));
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < 24 && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.lookAtEntity(target, 30.0F, 30.0F);
            }else {
                entity.setYaw(entity.prevYaw);
                //  Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
            }

            if (entity.getAnimationTick() == 24 && target != null){
                entity.setVelocity((target.getX() - entity.getX()) * 0.3f, 0, (target.getZ() - entity.getZ()) * 0.3f);

            }


        }
    }

}





