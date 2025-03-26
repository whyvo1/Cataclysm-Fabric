package com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity;

import com.github.l_ender.cataclysm.client.gui.CustomBossBar;
import com.github.l_ender.cataclysm.client.gui.CustomBossBarStyles;
import com.github.l_ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AI.AdvancedHurtByTargetGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.IABoss_monster;
import com.github.l_ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.l_ender.cataclysm.entity.partentity.Cm_Part_Entity;
import com.github.l_ender.cataclysm.entity.partentity.Partable;
import com.github.l_ender.cataclysm.entity.projectile.Flame_Jet_Entity;
import com.github.l_ender.cataclysm.entity.projectile.Flare_Bomb_Entity;
import com.github.l_ender.cataclysm.entity.projectile.Lava_Bomb_Entity;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.CMMathUtil;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
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
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.EnumSet;
import java.util.List;


public class Netherite_Monstrosity_Entity extends IABoss_monster implements Partable {
    private final CustomBossBar bossInfo = new CustomBossBar(this.getDisplayName(), CustomBossBarStyles.NETHERITE_MONSTROSITY, false);
    public int frame;
    public float LayerBrightness, oLayerBrightness;
    public int LayerTicks;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState smashsAnimationState = new AnimationState();
    public AnimationState phaseAnimationState = new AnimationState();
    public AnimationState fireAnimationState = new AnimationState();
    public AnimationState drainAnimationState = new AnimationState();
    public AnimationState shouldercheckAnimationState = new AnimationState();
    public AnimationState overpowerAnimationState = new AnimationState();
    public AnimationState flareshotAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public final Netherite_Monstrosity_Part headPart;
    public final Netherite_Monstrosity_Part[] monstrosityParts;
    private static final TrackedData<Boolean> IS_BERSERK = DataTracker.registerData(Netherite_Monstrosity_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> IS_AWAKEN = DataTracker.registerData(Netherite_Monstrosity_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> MAGAZINE = DataTracker.registerData(Netherite_Monstrosity_Entity.class, TrackedDataHandlerRegistry.INTEGER);

    public boolean Blocking = CMConfig.NetheritemonstrosityBodyBloking;
    private int blockBreakCounter;
    public static final int NATURE_HEAL_COOLDOWN = 200;
    private int timeWithoutTarget;

    private int shoot_cooldown = 0;
    public static final int SHOOT_COOLDOWN = 240;
    private boolean onLava = false;
    private int check_cooldown = 0;
    public static final int CHECK_COOLDOWN = 80;

    private int overpower_cooldown = 0;
    public static final int OVERPOWER_COOLDOWN = 160;

    private int flare_shoot_cooldown = 0;
    public static final int FLARE_SHOOT_COOLDOWN = 120;

    public Netherite_Monstrosity_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 500;
        this.headPart = new Netherite_Monstrosity_Part(this, 1.6F, 2.5F);
        this.monstrosityParts = new Netherite_Monstrosity_Part[]{this.headPart};
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.LAVA, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0F);
        setConfigattribute(this, CMConfig.MonstrosityHealthMultiplier, CMConfig.MonstrosityDamageMultiplier);
    }



    protected void initGoals() {
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new AdvancedHurtByTargetGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, true));
        this.goalSelector.add(4, new InternalMoveGoal(this, false, 1.0D) {

            @Override
            public boolean canStart() {
                return super.canStart() && Netherite_Monstrosity_Entity.this.getAttackState() == 0;
            }
        });

        this.goalSelector.add(3, new InternalAttackGoal(this, 0, 3, 0, 58, 12, 6) {
            @Override
            public boolean canStart() {
                return super.canStart() && Netherite_Monstrosity_Entity.this.getRandom().nextFloat() * 100.0F < 32f;
            }
        });

        //sleep
        this.goalSelector.add(2, new InternalStateGoal(this, 1, 1, 2, 0, 0) {

            @Override
            public boolean canStart() {
                return super.canStart() && !Netherite_Monstrosity_Entity.this.getIsAwaken();
            }

            @Override
            public void tick() {
                entity.setVelocity(0, entity.getVelocity().y, 0);
            }

            @Override
            public void stop() {
                super.stop();
                Netherite_Monstrosity_Entity.this.setIsAwaken(true);
            }

        });

        //awake
        this.goalSelector.add(1, new InternalStateGoal(this, 2, 2, 0, 40, 0) {

            @Override
            public boolean canStart() {
                return super.canStart() && Netherite_Monstrosity_Entity.this.getIsAwaken();
            }

            @Override
            public void tick() {
                entity.setVelocity(0, entity.getVelocity().y, 0);
            }
        });
        this.goalSelector.add(0, new InternalAttackGoal(this, 1, 2, 0, 40, 0, 15) {

            @Override
            public boolean canStart() {
                LivingEntity target = entity.getTarget();
                return super.canStart() && target != null && this.entity.getVisibilityCache().canSee(target);
            }


            @Override
            public void start() {
                super.start();
                Netherite_Monstrosity_Entity.this.setIsAwaken(true);
            }
        });


        //change roar
        this.goalSelector.add(0, new MonstrosityPhaseChangeGoal(this, 0, 4, 0, 54));

        //shoot
        this.goalSelector.add(3, new Magmashoot(this, 0, 6, 0, 44, 20, 40F, 19, 16F));

        //flare shoot
        this.goalSelector.add(3, new Flareshoot(this, 0, 10, 0, 60, 35, 26F, 35, 18F));


        //drain
        this.goalSelector.add(3, new InternalAttackGoal(this, 0, 7, 0, 60, 25, 1) {

            @Override
            public boolean canStart() {
                LivingEntity target = entity.getTarget();
                return target != null && target.isAlive() && this.entity.getAttackState() == 0 && this.entity.isInLava() && Netherite_Monstrosity_Entity.this.getMagazine() >= CMConfig.Lavabombmagazine;
            }
        });
        //check
        this.goalSelector.add(3, new ShoulderCheck(this, 0, 8, 0, 70, 19, 16, 19, 49, 12));


        //overpower
        this.goalSelector.add(3, new InternalAttackGoal(this, 0, 9, 0, 75, 7, 10) {
            @Override
            public boolean canStart() {
                return super.canStart() && Netherite_Monstrosity_Entity.this.getRandom().nextFloat() * 100.0F < 40f && Netherite_Monstrosity_Entity.this.overpower_cooldown <= 0;
            }

            @Override
            public void stop() {
                super.stop();
                Netherite_Monstrosity_Entity.this.overpower_cooldown = OVERPOWER_COOLDOWN;
            }


        });

    }

    public static DefaultAttributeContainer.Builder netherite_monstrosity() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 50.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 25)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 600)
                .add(EntityAttributes.GENERIC_ARMOR, 12)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 5)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 4.5F)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
    }


    public boolean attackEntityFromPart(Netherite_Monstrosity_Part netherite_monstrosity_part, DamageSource source, float amount) {
        return this.damage(source, amount);
    }

    @Override
    public boolean damage(DamageSource source, float damage) {
        if (this.getAttackState() == 4 && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        double range = calculateRange(source);

        if (range > CMConfig.MonstrosityLongRangelimit * CMConfig.MonstrosityLongRangelimit && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        Entity entity = source.getSource();
        if (entity instanceof GolemEntity) {
            damage *= 0.5F;
        }

        boolean attack = super.damage(source, damage);

        if (attack && !this.getIsAwaken() && this.isAlive()) {
            this.setIsAwaken(true);
        }
        return attack;
    }

    public boolean hurtParts(Netherite_Monstrosity_Part part, DamageSource source, float damage) {
        if (part == this.headPart) {
            damage = Math.min(Float.MAX_VALUE, damage * 1.5F);
        }

        boolean attack = super.damage(source, damage);

        return attack;
    }


    protected int getNextAirUnderwater(int air) {
        return air;
    }

    public float DamageCap() {
        return (float) CMConfig.MonstrosityDamageCap;
    }

    public int DamageTime() {
        return CMConfig.MonstrosityDamageTime;
    }

    public boolean isCollidable() {
        return this.isAlive() && Blocking && this.getAttackState() != 8;
    }

    public boolean isPushable() {
        return false;
    }

    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "idle" -> this.idleAnimationState;
            case "sleep" -> this.sleepAnimationState;
            case "awake" -> this.awakeAnimationState;
            case "smash" -> this.smashsAnimationState;
            case "phase_two" -> this.phaseAnimationState;
            case "fire" -> this.fireAnimationState;
            case "death" -> this.deathAnimationState;
            case "drain" -> this.drainAnimationState;
            case "shoulder_check" -> this.shouldercheckAnimationState;
            case "overpower" -> this.overpowerAnimationState;
            case "flare_shot" -> this.flareshotAnimationState;
            default -> new AnimationState();
        };
    }

    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
        p_326229_.add(IS_BERSERK, false);
        p_326229_.add(IS_AWAKEN, false);
        p_326229_.add(MAGAZINE, 0);
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }


    public boolean canWalkOnFluid(FluidState p_230285_1_) {
        return p_230285_1_.isIn(FluidTags.LAVA);
    }

    public void setIsBerserk(boolean isBerserk) {
        this.dataTracker.set(IS_BERSERK, isBerserk);
    }

    public boolean getIsBerserk() {
        return this.dataTracker.get(IS_BERSERK);
    }

    public void setOnLava(boolean lava) {
        onLava = lava;
    }

    public boolean getOnLava() {
        return onLava;
    }

    public void setIsAwaken(boolean isAwaken) {
        this.dataTracker.set(IS_AWAKEN, isAwaken);
        this.bossInfo.setVisible(isAwaken);
        if (!isAwaken) {
            this.setAttackState(1);
        }
        this.setHomePos(this.getBlockPos());
    }

    public boolean getIsAwaken() {
        return this.dataTracker.get(IS_AWAKEN);
    }

    public void setMagazine(int isAwaken) {
        this.dataTracker.set(MAGAZINE, isAwaken);
    }

    public int getMagazine() {
        return this.dataTracker.get(MAGAZINE);
    }

    public void setCustomName(@Nullable Text name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
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
                        this.smashsAnimationState.startIfNotRunning(this.age);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.phaseAnimationState.startIfNotRunning(this.age);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfNotRunning(this.age);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.fireAnimationState.startIfNotRunning(this.age);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.drainAnimationState.startIfNotRunning(this.age);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.shouldercheckAnimationState.startIfNotRunning(this.age);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.overpowerAnimationState.startIfNotRunning(this.age);
                    }
                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.flareshotAnimationState.startIfNotRunning(this.age);
                    }
                }
        }

        super.onTrackedDataSet(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();
        this.awakeAnimationState.stop();
        this.smashsAnimationState.stop();
        this.phaseAnimationState.stop();
        this.deathAnimationState.stop();
        this.fireAnimationState.stop();
        this.drainAnimationState.stop();
        this.overpowerAnimationState.stop();
        this.shouldercheckAnimationState.stop();
        this.flareshotAnimationState.stop();
    }


    public void onDeath(DamageSource p_21014_) {
        super.onDeath(p_21014_);
        this.setAttackState(5);
    }

    public int deathtimer() {
        return 60;
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putBoolean("is_Berserk", getIsBerserk());
        compound.putBoolean("is_Awaken", getIsAwaken());
        compound.putInt("Magazine", getMagazine());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        setIsBerserk(compound.getBoolean("is_Berserk"));
        setIsAwaken(compound.getBoolean("is_Awaken"));
        setMagazine(compound.getInt("Magazine"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }


    private void floatStrider() {
        if (this.isInLava()) {
            ShapeContext lvt_1_1_ = ShapeContext.of(this);
            if (lvt_1_1_.isAbove(FluidBlock.COLLISION_SHAPE, this.getBlockPos().down(), true) && !this.getWorld().getFluidState(this.getBlockPos().up()).isIn(FluidTags.LAVA)) {
                this.setOnLava(true);
            }

        }

    }

    public boolean isTeammate(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isTeammate(entityIn)) {
            return true;
        } else if (entityIn.getType().isIn(ModTag.TEAM_MONSTROSITY)) {
            return this.getScoreboardTeam() == null && entityIn.getScoreboardTeam() == null;
        } else {
            return false;
        }
    }

    public void tick() {
        super.tick();

        this.floatStrider();
        if (this.getWorld().isClient()) {
            this.idleAnimationState.setRunning(this.getAttackState() == 0, this.age);
        }
        frame++;
        float moveX = (float) (getX() - prevX);
        float moveZ = (float) (getZ() - prevZ);
        float speed = MathHelper.sqrt(moveX * moveX + moveZ * moveZ);
        if (!this.isSilent() && frame % 25 == 1 && speed > 0.05 && this.getIsAwaken() && this.getAttackState() != 8) {
            playSound(ModSounds.MONSTROSITYSTEP, 1F, 1.0f);
            ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.08f, 0, 5);
        }
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
        BlockBreaking();
        if (this.blockBreakCounter > 0) this.blockBreakCounter--;
        if (shoot_cooldown > 0) shoot_cooldown--;
        if (overpower_cooldown > 0) overpower_cooldown--;
        if (check_cooldown > 0) check_cooldown--;
        if (flare_shoot_cooldown > 0) flare_shoot_cooldown--;
        LivingEntity target = this.getTarget();
        if (!this.getWorld().isClient) {
            if (timeWithoutTarget > 0) timeWithoutTarget--;
            if (target != null) {
                timeWithoutTarget = NATURE_HEAL_COOLDOWN;
            }

            if (timeWithoutTarget <= 0) {
                if (!isAiDisabled() && CMConfig.MonstrosityNatureHealing > 0) {
                    if (this.age % 20 == 0) {
                        this.heal((float) CMConfig.MonstrosityNatureHealing);
                    }
                }
            }
        }

        if (!isAiDisabled() && !getIsAwaken()) {
            if (this.age % 4 == 0) {
                this.heal((float) CMConfig.MonstrosityNatureHealing);
            }
        }


        setHeadPart();

        if (this.getWorld().isClient) {
            ++LayerTicks;
            this.LayerBrightness += (0.0F - this.LayerBrightness) * 0.8F;
        }

    }

    private void setHeadPart() {

        if (!this.isAiDisabled()) {


            float f17 = (bodyYaw) * ((float) Math.PI / 180F);
            float pitch = this.getPitch() * ((float) Math.PI / 180F);
            float f3 = MathHelper.sin(f17) * (1 - Math.abs(this.getPitch() / 90F));
            float f18 = MathHelper.cos(f17) * (1 - Math.abs(this.getPitch() / 90F));

            Vec3d[] avector3d = new Vec3d[this.monstrosityParts.length];
            for (int j = 0; j < this.monstrosityParts.length; ++j) {
                avector3d[j] = new Vec3d(this.monstrosityParts[j].getX(), this.monstrosityParts[j].getY(), this.monstrosityParts[j].getZ());
            }

            float headY = 0F;
            float headxz = 0F;
            if (this.getAttackState() == 3) {
                int end = 40;
                float f = 0F;
                if (this.attackTicks > end) {
                    f = CMMathUtil.cullAnimationTick(this.attackTicks, 1.2F, 1.0F, 13, end);
                } else {
                    f = CMMathUtil.cullAnimationTick(this.attackTicks, 2.0F, 1.0F, 13, end);
                }
                headxz = -1.6F * f;
                headY = -2.2F * f;
            }

            if (this.getAttackState() == 6) {
                float f = CMMathUtil.cullAnimationTick(this.attackTicks, 0.5F, 1.0F, 0, 40);
                headxz = 4 * f;
                headY = 1.2F * f;
            }

            if (this.getAttackState() == 8) {
                float f = CMMathUtil.cullAnimationTick(this.attackTicks, 2, 1.0F, 0, 30);
                headxz = -4 * f;
            }


            this.setPartPosition(this.headPart, f3 * -1.65F + f3 * headxz, pitch + 2.4F + headY, -f18 * -1.65F - f18 * headxz);

            for (int l = 0; l < this.monstrosityParts.length; ++l) {
                this.monstrosityParts[l].prevX = avector3d[l].x;
                this.monstrosityParts[l].prevY = avector3d[l].y;
                this.monstrosityParts[l].prevZ = avector3d[l].z;
                this.monstrosityParts[l].lastRenderX = avector3d[l].x;
                this.monstrosityParts[l].lastRenderY = avector3d[l].y;
                this.monstrosityParts[l].lastRenderZ = avector3d[l].z;
            }
        }

    }


    public void tickMovement() {
        super.tickMovement();
        if (this.getAttackState() == 2) {
            if (this.attackTicks == 2) {
                this.playSound(ModSounds.MONSTROSITYAWAKEN, 10, 1);
            }
        }


        if (this.getAttackState() == 3) {
            if (this.attackTicks == 19) {
                EarthQuake(6.25D);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 20, 0.3f, 0, 20);
                Makeparticle(4.75f, 2.5f);
                Makeparticle(4.75f, -2.5f);
            }
        }

        if (this.getAttackState() == 4) {
            if (this.attackTicks == 10) {
                this.playSound(ModSounds.MONSTROSITYGROWL, 3, 1);
            }
            if (this.attackTicks == 17) {
                berserkBlockBreaking(8, 8, 8);
                EarthQuake(6.25D);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 20, 0.3f, 0, 20);
                Makeparticle(4.4f, 2.0f);
                Makeparticle(4.4f, -2.0f);
            }
        }
        if (this.getAttackState() == 5) {
            if (this.attackTicks == 26) {
                this.playSound(ModSounds.MONSTROSITYLAND, 1, 1);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 20, 0.3f, 0, 20);
            }
        }
        if (this.getAttackState() == 6) {
            if (this.attackTicks == 19) {
                this.playSound(ModSounds.MONSTROSITYSHOOT, 3, 0.75f);
            }
        }

        if (this.getAttackState() == 7) {
            if (this.attackTicks == 24) {
                this.setMagazine(0);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 20, 0.3f, 0, 20);
                this.doAbsorptionEffects(4, 1, 4);
                this.playSound(SoundEvents.ITEM_BUCKET_FILL_LAVA, 6f, 0.5F);
                this.heal(15F * (float) CMConfig.MonstrosityHealingMultiplier);
            }
            if (this.attackTicks == 26) {
                this.doAbsorptionEffects(8, 2, 8);
                this.heal(15F * (float) CMConfig.MonstrosityHealingMultiplier);
            }
            if (this.attackTicks == 28) {
                this.doAbsorptionEffects(16, 4, 16);
                this.heal(15F * (float) CMConfig.MonstrosityHealingMultiplier);
            }
        }

        if (this.getAttackState() == 8) {
            if (this.attackTicks == 22
                    || this.attackTicks == 27
                    || this.attackTicks == 32
                    || this.attackTicks == 37
                    || this.attackTicks == 42
                    || this.attackTicks == 47) {
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 20, 0.15f, 0, 6);
                playSound(ModSounds.MONSTROSITYSTEP, 1F, 1.0f);
            }

            if (this.attackTicks > 19 && this.attackTicks < 49) {
                if (!this.getWorld().isClient) {
                    if(CMConfig.MonstrosityBlockBreaking) {
                        ChargeBlockBreaking();
                    }else{
                        if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                            ChargeBlockBreaking();
                        }
                    }
                }

                double yaw = Math.toRadians(this.getYaw() + 90);
                double xExpand = 2.0F * Math.cos(yaw);
                double zExpand = 2.0F * Math.sin(yaw);
                Box attackRange = this.getBoundingBox().expand(0.75D, 0.75D, 0.75D).stretch(xExpand, 0, zExpand);
                for (LivingEntity Lentity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, attackRange)) {
                    if (!isTeammate(Lentity) && !(Lentity instanceof Netherite_Monstrosity_Entity) && Lentity != this) {
                        boolean flag = Lentity.damage(this.getDamageSources().mobAttack(this), (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * 0.4F);
                        if (flag) {
                            double theta = (bodyYaw) * (Math.PI / 180);
                            theta += Math.PI / 2;
                            double vec = -2.5D;
                            double vecX = Math.cos(theta);
                            double vecZ = Math.sin(theta);

                            double d0 = Lentity.getX() - (this.getX() + vec * vecX);
                            double d1 = Lentity.getZ() - (this.getZ() + vec * vecZ);
                            double d2 = Math.max(d0 * d0 + d1 * d1, 0.05D);
                            double vel = 4.0D;
                            Lentity.addVelocity(d0 / d2 * vel, 0.3D, d1 / d2 * vel);
                            Lentity.addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTBONE_FRACTURE, 100));
                        }
                    }
                }

            }
        }

        if (this.getAttackState() == 9) {
            if (this.attackTicks == 9) {
                OverPowerKnockBack(7D);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 20, 0.3f, 0, 20);
                Makeparticle(-0.3f, 3.4f);
                Makeparticle(-0.3F, -3.4f);
                if(!this.getWorld().isClient) {
                    CircleFlameJet(-0.3f, 3.4f,this.getIsBerserk() ? 14 : 7,this.getIsBerserk() ? 8 : 4,3);
                    CircleFlameJet(-0.3F, -3.4f,this.getIsBerserk() ? 14 : 7,this.getIsBerserk() ? 8 : 4,3);
                }
                this.playSound(ModSounds.REMNANT_STOMP, 1, 0.7F);
            }
            if (this.attackTicks == 26) {
                this.playSound(ModSounds.MONSTROSITYGROWL, 3, 1);

            }

            for (int l = 31; l <= 41; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 27;
                    int d2 = l - 26;
                    float ds = (d + d2) / 2;
                    StompDamage(0.6f, d, 5, 1.05F, -2.0f, 0, 0, 0.7f);
                    StompDamage(0.6f, d2, 5, 1.05F, -2.0f, 0, 0, 0.7f);
                    Stompsound(ds, 0F);
                }
            }
        }

        if (this.getAttackState() == 10) {
            if (this.attackTicks == 35) {
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 15, 0.08f, 0, 10);
                this.playSound(ModSounds.MONSTROSITYSHOOT, 3, 0.75f);
            }
        }

    }


    private void CircleFlameJet(float vec, float math,int vertexrune, int rune,double time) {

        float f = MathHelper.cos(this.bodyYaw * ((float)Math.PI / 180F)) ;
        float f1 = MathHelper.sin(this.bodyYaw * ((float)Math.PI / 180F)) ;
        double theta = (bodyYaw) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);



        for (int i = 0; i < vertexrune; i++) {
            float throwAngle = i * MathHelper.PI / (vertexrune/2);
            for (int k = 0; k < rune; ++k) {
                double d2 = 1.1D * (double) (k + 1);
                int d3 = (int) (time * (k + 1));
                this.spawnJet(this.getX() + vec * vecX  + f * math + (double) MathHelper.cos(throwAngle) * 1.25D * d2, this.getZ() + vec * vecZ  + f1 * math + (double) MathHelper.sin(throwAngle) * 1.25D * d2, this.getY() -2, this.getY() + 2, throwAngle, d3);
            }

        }

    }


    private void spawnJet(double x, double z, double minY, double maxY, float rotation, int delay) {
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
        } while (blockpos.getY() >= MathHelper.floor(minY) - 1);

        if (flag) {
            this.getWorld().spawnEntity(new Flame_Jet_Entity(this.getWorld(), x, (double) blockpos.getY() + d0, z, rotation, delay, (float)CMConfig.FlameJetDamage,this));
        }
    }

    private void Stompsound(float distance,float math) {
        double theta = (bodyYaw) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float f = MathHelper.cos(this.bodyYaw * ((float) Math.PI / 180F));
        float f1 = MathHelper.sin(this.bodyYaw * ((float) Math.PI / 180F));
        this.getWorld().playSound(null, this.getX() + distance * vecX + f * math, this.getY(), this.getZ() + distance * vecZ + f1 * math, ModSounds.REMNANT_STOMP, this.getSoundCategory(), 0.6f, 1.0f);
    }

    private void StompDamage(float spreadarc, int distance, int height, float mxy, float vec,float math, int shieldbreakticks, float damage) {
        double perpFacing = this.bodyYaw * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        int hitY = MathHelper.floor(this.getBoundingBox().minY - 0.5);
        double spread = Math.PI * spreadarc;
        int arcLen = MathHelper.ceil(distance * spread);
        float f = MathHelper.cos(this.bodyYaw * ((float)Math.PI / 180F)) ;
        float f1 = MathHelper.sin(this.bodyYaw * ((float)Math.PI / 180F)) ;
        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = this.getX() + vx * distance + vec * Math.cos((bodyYaw + 90) * Math.PI / 180) + f * math;
            double pz = this.getZ() + vz * distance + vec * Math.sin((bodyYaw + 90) * Math.PI / 180  + f1 * math);
            float factor = 1 - distance / (float) 12;
            int hitX = MathHelper.floor(px);
            int hitZ = MathHelper.floor(pz);
            BlockPos pos = new BlockPos(hitX, hitY + height, hitZ);
            BlockState block = getWorld().getBlockState(pos);

            int maxDepth = 30;
            for (int depthCount = 0; depthCount < maxDepth; depthCount++) {
                if (block.getRenderType() == BlockRenderType.MODEL) {
                    break;
                }
                pos = pos.down();
                block = getWorld().getBlockState(pos);
            }

            if (block.getRenderType() != BlockRenderType.MODEL) {
                block = Blocks.AIR.getDefaultState();
            }
            spawnBlocks(hitX,hitY + height ,hitZ, (int) (this.getY() - height),block, px, pz, mxy, vx, vz, factor, shieldbreakticks, damage);

        }
    }



    private boolean notLavaCliff(double distance) {

        double theta = (bodyYaw) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);

        double px = this.getX() + vecX * distance;
        double pz = this.getZ() + vecZ * distance;


        double checkHeight = -2.5D;
        Vec3d forwardPosition = new Vec3d(
                px,
                this.getY() + checkHeight,
                pz
        );

        BlockState blockStateBelow = this.getWorld().getBlockState(BlockPos.ofFloored(forwardPosition));

        return !blockStateBelow.isAir();
    }



    private void spawnBlocks(int hitX, int hitY, int hitZ, int lowestYCheck,BlockState blockState,double px,double pz,float mxy,double vx,double vz,float factor, int shieldbreakticks,float damage) {
        BlockPos blockpos = new BlockPos(hitX, hitY, hitZ);
        BlockState block = getWorld().getBlockState(blockpos);
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

                break;
            }

            blockpos = blockpos.down();
        } while(blockpos.getY() >= MathHelper.floor(lowestYCheck) - 1);


        Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(getWorld(), hitX + 0.5D, (double)blockpos.getY() + d0 + 0.5D, hitZ + 0.5D, blockState, 10);

        double b0 = hitX - this.getX();
        double b1 = hitZ - this.getZ();
        double b2 = Math.max(b0 * b0 + b1 * b1, 0.001);
        fallingBlockEntity.addVelocity(b0 / b2 * 1.5d, 0.2D + getRandom().nextGaussian() * 0.04D, b1 / b2 * 1.5d);
        getWorld().spawnEntity(fallingBlockEntity);



        Box selection = new Box(px - 0.5, (double)blockpos.getY() + d0 -1, pz - 0.5, px + 0.5, (double)blockpos.getY() + d0 + mxy, pz + 0.5);
        List<LivingEntity> hit = getWorld().getNonSpectatingEntities(LivingEntity.class, selection);
        for (LivingEntity entity : hit) {
            if (!isTeammate(entity) && !(entity instanceof Netherite_Monstrosity_Entity) && entity != this) {
                DamageSource damagesource = this.getDamageSources().mobAttack(this);
                boolean flag = entity.damage(damagesource, (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage));
                if (entity.blockedByShield(damagesource) && entity instanceof PlayerEntity player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }

                if (flag) {
                    double magnitude = 10;
                    double x = vx * Math.max(factor, 0.2) * magnitude;
                    double y = 0;
                    if (entity.isOnGround()) {
                        y += 0.15;
                    }
                    double z = vz * Math.max(factor, 0.2) * magnitude;
                    entity.setVelocity(entity.getVelocity().add(x, y, z));
                }
            }
        }
    }

    private void doAbsorptionEffects(int x, int y, int z) {

        int MthX = MathHelper.floor(this.getX());
        int MthY = MathHelper.floor(this.getY());
        int MthZ = MathHelper.floor(this.getZ());

        for (int k2 = -x; k2 <= x; ++k2) {
            for (int l2 = -z; l2 <= z; ++l2) {
                for (int j = -y; j <= y; ++j) {
                    int i3 = MthX + k2;
                    int k = MthY + j;
                    int l = MthZ + l2;
                    BlockPos blockpos = new BlockPos(i3, k, l);
                    this.doAbsorptionEffect(blockpos);
                }
            }
        }
    }

    private void doAbsorptionEffect(BlockPos pos) {
        BlockState state = getWorld().getBlockState(pos);
        // if (state.getFluidState().isTagged(FluidTags.LAVA) && state.getFluidState().isSource()) {
        //      this.world.setBlockState(pos, Blocks.AIR.getDefaultState());
        //  }
        if (!this.getWorld().isClient) {
            if (state.isOf(Blocks.LAVA)) {
                this.getWorld().setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }
    }


    private void EarthQuake(double area) {
        this.playSound(ModSounds.EXPLOSION, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
        for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(area))) {
            if (!isTeammate(entity) && !(entity instanceof Netherite_Monstrosity_Entity) && entity != this) {
                DamageSource damagesource = this.getDamageSources().mobAttack(this);
                boolean flag = entity.damage(damagesource, (float) ((float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) + Math.min(this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE), entity.getMaxHealth() * CMConfig.MonstrositysHpdamage)));
                if (entity.blockedByShield(damagesource) && entity instanceof PlayerEntity player) {
                    disableShield(player, 120);
                }

                if (flag) {
                    launch(entity, 2D,0.6D);
                    if (getIsBerserk()) {
                        entity.setOnFireFor(6);
                    }
                }
            }
        }
    }

    private void OverPowerKnockBack(double area) {
        for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(area))) {
            if (!isTeammate(entity) && !(entity instanceof Netherite_Monstrosity_Entity) && entity != this) {
                launch(entity, 3D,0.35D);
            }
        }
    }


    private void Makeparticle(float vec, float math) {
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
                double extraX = 2F * MathHelper.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = 2F * MathHelper.cos(angle);
                int hitX = MathHelper.floor(getX() + vec * vecX+ extraX);
                int hitY = MathHelper.floor(getY());
                int hitZ = MathHelper.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = getWorld().getBlockState(hit.down());
                if (getIsBerserk()) {
                    this.getWorld().addParticle(ParticleTypes.FLAME, getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                } else {
                    if (block.getRenderType() != BlockRenderType.INVISIBLE) {
                        this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                    }
                }
            }
            if (getIsBerserk()) {
                this.getWorld().addParticle(new RingParticleOptions(0f, (float) Math.PI / 2f, 35, 204, 78, 5, 1f, 30f, false, 0), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
            }else{
                this.getWorld().addParticle(new RingParticleOptions(0f, (float) Math.PI / 2f, 35, 255, 255, 255, 1.0F, 30f, false, 0), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
            }
        }
    }


    private void launch(Entity e, double XZpower,double Ypower) {
        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        e.addVelocity(d0 / d2 * XZpower, Ypower, d1 / d2 * XZpower);
    }


    private void ChargeBlockBreaking(){
        boolean flag = false;
        Box aabb = this.getBoundingBox().expand(0.5D, 0.2D, 0.5D);
        for (BlockPos blockpos : BlockPos.iterate(MathHelper.floor(aabb.minX), MathHelper.floor(this.getY()), MathHelper.floor(aabb.minZ), MathHelper.floor(aabb.maxX), MathHelper.floor(aabb.maxY), MathHelper.floor(aabb.maxZ))) {
            BlockState blockstate = this.getWorld().getBlockState(blockpos);
            if (!blockstate.isAir() && !blockstate.isIn(ModTag.NETHERITE_MONSTROSITY_IMMUNE)) {
                if (random.nextInt(6) == 0 && !blockstate.hasBlockEntity()) {
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

    private void berserkBlockBreaking(int x, int y, int z) {
        int MthX = MathHelper.floor(this.getX());
        int MthY = MathHelper.floor(this.getY());
        int MthZ = MathHelper.floor(this.getZ());
        if (!this.getWorld().isClient) {
            if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                for (int k2 = -x; k2 <= x; ++k2) {
                    for (int l2 = -z; l2 <= z; ++l2) {
                        for (int j = 0; j <= y; ++j) {
                            int i3 = MthX + k2;
                            int k = MthY + j;
                            int l = MthZ + l2;
                            BlockPos blockpos = new BlockPos(i3, k, l);
                            BlockState block = getWorld().getBlockState(blockpos);
                            BlockEntity tileEntity = getWorld().getBlockEntity(blockpos);
                            if (!block.isAir() && !block.isIn(ModTag.NETHERITE_MONSTROSITY_IMMUNE)) {
                                if (tileEntity == null && random.nextInt(4) + 1 == 4) {
                                    this.getWorld().removeBlock(blockpos, true);
                                    Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(getWorld(), i3 + 0.5D, k + 0.5D, l + 0.5D, block,5);
                                    getWorld().setBlockState(blockpos, block.getFluidState().getBlockState(), 3);
                                    fallingBlockEntity.setVelocity(fallingBlockEntity.getVelocity().add(this.getPos().subtract(fallingBlockEntity.getPos()).multiply((-1.2D + random.nextDouble()) / 3, (-1.1D + random.nextDouble()) / 3, (-1.2D + random.nextDouble()) / 3)));
                                    getWorld().spawnEntity(fallingBlockEntity);
                                } else {
                                    getWorld().breakBlock(new BlockPos(i3, k, l), shouldDropItem(tileEntity));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void BlockBreaking() {
        if(!this.isAiDisabled()) {
            if (!this.getWorld().isClient && this.blockBreakCounter == 0) {
                if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                    for (int a = (int) Math.round(this.getBoundingBox().minX); a <= (int) Math.round(this.getBoundingBox().maxX); a++) {
                        for (int b = (int) Math.round(this.getBoundingBox().minY); (b <= (int) Math.round(this.getBoundingBox().maxY) + 1) && (b <= 127); b++) {
                            for (int c = (int) Math.round(this.getBoundingBox().minZ); c <= (int) Math.round(this.getBoundingBox().maxZ); c++) {
                                BlockPos blockpos = new BlockPos(a, b, c);
                                BlockState block = getWorld().getBlockState(blockpos);
                                BlockEntity tileEntity = getWorld().getBlockEntity(blockpos);
                                if (!block.isAir() && !block.isIn(ModTag.NETHERITE_MONSTROSITY_IMMUNE)) {
                                    boolean flag = getWorld().breakBlock(new BlockPos(a, b, c), shouldDropItem(tileEntity));
                                    if (flag) {
                                        blockBreakCounter = 10;
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }


    private Vec3d rotateOffsetVec(Vec3d offset, float xRot, float yRot) {
        return offset.rotateX(-xRot * ((float) Math.PI / 180F)).rotateY(-yRot * ((float) Math.PI / 180F));
    }

    private boolean shouldDropItem(BlockEntity tileEntity) {
        if (tileEntity == null) {
            return random.nextInt(3) + 1 == 3;
        }
        return true;
    }

    public boolean isBerserk() {
        return this.getHealth() <= this.getMaxHealth() * 0.4F;
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

    private void setPartPosition(Netherite_Monstrosity_Part part, double offsetX, double offsetY, double offsetZ) {
        part.setPos(this.getX() + offsetX * part.scale, this.getY() + offsetY * part.scale, this.getZ() + offsetZ * part.scale);
    }

    @Nullable
    @Override
    public Cm_Part_Entity<?>[] getParts() {
        return this.monstrosityParts;
    }

    @Override
    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        Cm_Part_Entity.assignPartIDs(this);
    }



    public void travel(Vec3d travelVector) {
        this.setMovementSpeed((float) this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED) * (isInLava() ? 0.2F : 1F));
        if (this.canMoveVoluntarily() && this.isInLava()) {
            this.updateVelocity(this.getMovementSpeed(), travelVector);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9D));
        } else {
            super.travel(travelVector);
        }
    }



    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.MONSTROSITYHURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.MONSTROSITYDEATH;
    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.MONSTROSITY_MUSIC;
    }

    @Override
    protected boolean canPlayMusic() {
        return super.canPlayMusic() && !isSleep();
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


    public boolean canImmediatelyDespawn(double p_21542_) {
        return false;
    }

    protected boolean isDisallowedInPeaceful() {
        return false;
    }

    protected boolean canStartRiding(Entity p_31508_) {
        return false;
    }


    static class MonstrosityPhaseChangeGoal extends Goal {
        protected final Netherite_Monstrosity_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;

        public MonstrosityPhaseChangeGoal(Netherite_Monstrosity_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick) {
            this.entity = entity;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
        }

        @Override
        public boolean canStart() {
            return !this.entity.getIsBerserk() && this.entity.getAttackState() == getattackstate && this.entity.isBerserk();
        }

        @Override
        public void start() {
            this.entity.setIsBerserk(true);
            if(getattackstate != attackstate) {
                this.entity.setAttackState(attackstate);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
        }

        @Override
        public boolean shouldContinue() {
            return attackMaxtick > 0 ? this.entity.attackTicks <= attackMaxtick : canStart();
        }


    }

    static class Magmashoot extends InternalAttackGoal {
        private final Netherite_Monstrosity_Entity entity;
        private final int attackshot;
        private final float random;


        public Magmashoot(Netherite_Monstrosity_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.random = random;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return super.canStart() && target != null && this.entity.distanceTo(target) >= 14F && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.getVisibilityCache().canSee(target) && this.entity.getMagazine() < CMConfig.Lavabombmagazine && this.entity.shoot_cooldown <= 0;
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.shoot_cooldown = SHOOT_COOLDOWN;
            this.entity.setMagazine(this.entity.getMagazine() + 1);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();
            int lavabombcount = CMConfig.Lavabombamount;

            if(target !=null) {
                if (this.entity.attackTicks == attackshot) {
                    for (int i = 0; i < lavabombcount; ++i) {
                        Lava_Bomb_Entity lava = new Lava_Bomb_Entity(ModEntities.LAVA_BOMB, this.entity.getWorld(), this.entity);
                        double d0 = target.getX() - this.entity.headPart.getX();
                        double d1 = target.getBoundingBox().minY + target.getHeight() / 3.0F - lava.getY();
                        double d2 = target.getZ() - this.entity.headPart.getZ();
                        double d3 = MathHelper.sqrt((float) (d0 * d0 + d2 * d2));
                        lava.setMaxLavaTime(CMConfig.LavabombDuration + this.entity.getRandom().nextInt(CMConfig.LavabombDurationRand));
                        lava.setVelocity(d0, d1 + d3 * 0.20000000298023224D, d2, 1.0F, 24 - this.entity.getWorld().getDifficulty().getId() * 4);
                        this.entity.getWorld().spawnEntity(lava);
                    }
                }
            }
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }
    }

    static class Flareshoot extends InternalAttackGoal {
        private final Netherite_Monstrosity_Entity entity;
        private final int attackshot;
        private final float random;


        public Flareshoot(Netherite_Monstrosity_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.random = random;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return super.canStart() && target != null && this.entity.distanceTo(target) >= 10F && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.getVisibilityCache().canSee(target) && this.entity.flare_shoot_cooldown <= 0;
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.flare_shoot_cooldown = FLARE_SHOOT_COOLDOWN;
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();
            int lavabombcount = 5;

            if(target !=null) {
                if (this.entity.attackTicks == attackshot) {
                    for (int i = 0; i < lavabombcount; ++i) {
                        float f = MathHelper.cos( this.entity.bodyYaw * ((float)Math.PI / 180F)) ;
                        float f1 = MathHelper.sin( this.entity.bodyYaw * ((float)Math.PI / 180F)) ;
                        double theta = (this.entity.bodyYaw) * (Math.PI / 180);
                        theta += Math.PI / 2;
                        double vecX = Math.cos(theta);
                        double vecZ = Math.sin(theta);
                        double vec = 2.2;
                        double math = 3.4D;
                        Flare_Bomb_Entity lava = new Flare_Bomb_Entity(ModEntities.FLARE_BOMB, this.entity.getWorld(), this.entity);
                        lava.setPos(this.entity.getX() + vec * vecX + f * math, this.entity.getBodyY(0.65), this.entity.getZ() + vec * vecZ + f1 * math);
                        double d0 = target.getX() - lava.getX() ;
                        double d1 = target.getBoundingBox().minY + target.getHeight() / 3.0F - lava.getY();
                        double d2 = target.getZ() - lava.getZ();
                        double d3 = MathHelper.sqrt((float) (d0 * d0 + d2 * d2));
                        this.entity.getWorld().spawnEntity(lava);
                    }
                }
            }
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }
    }

    static class ShoulderCheck extends InternalAttackGoal {
        private final Netherite_Monstrosity_Entity entity;
        private final int attackshot;
        private final int attackendshot;
        private final float random;


        public ShoulderCheck(Netherite_Monstrosity_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot,int attackendshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.attackendshot = attackendshot;
            this.random = random;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }
        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return super.canStart() && target != null && this.entity.distanceTo(target) >= 5.75F && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.getVisibilityCache().canSee(target) && this.entity.check_cooldown <= 0;
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.check_cooldown = CHECK_COOLDOWN;
        }

        @Override
        public void tick() {
            super.tick();

            if (this.entity.attackTicks > attackshot && this.entity.attackTicks < attackendshot) {
                if (this.entity.isOnGround() || this.entity.getOnLava()) {
                    if (this.entity.notLavaCliff(2)) {
                        Vec3d vector3d = entity.getVelocity();
                        float f = entity.getYaw() * ((float) Math.PI / 180F);
                        Vec3d vector3d1 = new Vec3d(-MathHelper.sin(f), entity.getVelocity().y, MathHelper.cos(f)).multiply(0.5D).add(vector3d.multiply(0.5D));
                        entity.setVelocity(vector3d1.x, entity.getVelocity().y, vector3d1.z);
                    }
                }
            }
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }
    }

}





