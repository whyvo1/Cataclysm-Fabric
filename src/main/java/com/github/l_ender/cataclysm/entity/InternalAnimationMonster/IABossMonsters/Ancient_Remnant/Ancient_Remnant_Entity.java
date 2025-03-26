package com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant;

import com.github.l_ender.cataclysm.client.gui.CustomBossBar;
import com.github.l_ender.cataclysm.client.gui.CustomBossBarStyles;
import com.github.l_ender.cataclysm.client.particle.RingParticle;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AI.AdvancedHurtByTargetGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.IABoss_monster;
import com.github.l_ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.l_ender.cataclysm.entity.effect.Sandstorm_Entity;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.l_ender.cataclysm.entity.projectile.Ancient_Desert_Stele_Entity;
import com.github.l_ender.cataclysm.entity.projectile.EarthQuake_Entity;
import com.github.l_ender.cataclysm.init.*;
import com.github.l_ender.lionfishapi.server.animation.LegSolver;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
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
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.GameRules;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.EnumSet;
import java.util.List;


public class Ancient_Remnant_Entity extends IABoss_monster {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sandstormroarAnimationState = new AnimationState();
    public AnimationState phaseroarAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakenAnimationState = new AnimationState();
    public AnimationState threetailhitAnimationState = new AnimationState();
    public AnimationState rightstompAnimationState = new AnimationState();
    public AnimationState leftstompAnimationState = new AnimationState();
    public AnimationState rightDoubleStompAnimationState = new AnimationState();
    public AnimationState leftDoubleStompAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState rightbiteAnimationState = new AnimationState();
    public AnimationState chargeprepareAnimationState = new AnimationState();
    public AnimationState chargeAnimationState = new AnimationState();
    public AnimationState chargestunAnimationState = new AnimationState();
    public AnimationState groundtailAnimationState = new AnimationState();
    public AnimationState tailswingAnimationState = new AnimationState();
    public AnimationState monolithAnimationState = new AnimationState();
    private static final TrackedData<Integer> RAGE = DataTracker.registerData(Ancient_Remnant_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Boolean> NECKLACE = DataTracker.registerData(Ancient_Remnant_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> POWER = DataTracker.registerData(Ancient_Remnant_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final LegSolver legSolver = new LegSolver(new LegSolver.Leg(0F, 0.75F, 4.0F, false), new LegSolver.Leg(0F, -0.75F, 4.0F, false));
    private Ancient_Remnant_Entity.AttackMode mode = Ancient_Remnant_Entity.AttackMode.CIRCLE;
    private int hunting_cooldown = 160;
    private int roar_cooldown = 0;
    private int monoltih_cooldown = 0;
    private int earthquake_cooldown = 0;
    private int stomp_cooldown = 0;
    private boolean hit = false;
    public static final int ROAR_COOLDOWN = 500;
    public static final int MONOLITH2_COOLDOWN = 200;
    public static final int EARTHQUAKE_COOLDOWN = 160;
    public static final int STOMP_COOLDOWN = 110;
    private final CustomBossBar bossEvent = new CustomBossBar(this.getDisplayName(), CustomBossBarStyles.ANCIENT_REMNANT, false);
    private final CustomBossBar bossEvent2 = new CustomBossBar(Text.empty(), CustomBossBarStyles.ANCIENT_REMNANT_RAGE, false);
    public static final int NATURE_HEAL_COOLDOWN = 200;
    private int timeWithoutTarget;
    public int frame;

    
    public Ancient_Remnant_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 500;
        this.setStepHeight(1.5F);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
        setConfigattribute(this, CMConfig.AncientRemnantHealthMultiplier, CMConfig.AncientRemnantDamageMultiplier);
    }

    protected void initGoals() {
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new AdvancedHurtByTargetGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, LivingEntity.class, 120, true, true, ModEntities.buildPredicateFromTag(ModTag.ANCIENT_REMNANT_TARGET)));
        this.targetSelector.add(2, new RevengeGoal(this));
        this.goalSelector.add(4, new RemnantAttackModeGoal(this));
        //right bite
        this.goalSelector.add(3, new RemnantAttackGoal(this, 0, 4, 0, 70, 29, 6, 10));

        //sleep
        this.goalSelector.add(1, new InternalStateGoal(this,1,1,0,0,0){
            @Override
            public void tick() {
                entity.setVelocity(0, entity.getVelocity().y, 0);
            }
        });

        //awaken
        this.goalSelector.add(0, new RemnantAwakenGoal(this,1,2,0,80));
        //change roar
        this.goalSelector.add(0, new RemnantPhaseChangeGoal(this,0,7,0,60));


        //stomp
        this.goalSelector.add(3, new RemnantStompGoal(this,0, 8,9, 13, 14,0,50,66, 26, 20, 36));

        //sandstorm_roar
        this.goalSelector.add(3, new RemnantStormAttackGoal(this,0, 6, 0, 60, 11, 32D, 18){
            @Override
            public boolean canStart() {
                LivingEntity target = entity.getTarget();
                return super.canStart() && target !=null  && this.entity.roar_cooldown <= 0;
            }
            @Override
            public void stop() {
                super.stop();
                this.entity.roar_cooldown = ROAR_COOLDOWN;
            }

        });

        //monolith
        this.goalSelector.add(3, new RemnantMonolithAttackGoal(this,0, 17, 0, 70, 20));

        //charge_prepare
        this.goalSelector.add(3, new RemnantChargeGoal(this,0, 10, 11, 70, 66, 32D, 60));

        //charge
        this.goalSelector.add(2, new InternalStateGoal(this,11,11,12,60,0){
            @Override
            public void tick() {
                if(this.entity.isOnGround()){
                    Vec3d vector3d = entity.getVelocity();
                    float f = entity.getYaw() * ((float)Math.PI / 180F);
                    Vec3d vector3d1 = new Vec3d(-MathHelper.sin(f), entity.getVelocity().y, MathHelper.cos(f)).multiply(1.0D).add(vector3d.multiply(0.5D));
                    entity.setVelocity(vector3d1.x, entity.getVelocity().y, vector3d1.z);
                }
            }
        });

        //charge stun
        this.goalSelector.add(1, new InternalStateGoal(this,12,12,0,120,0));

        //ground_tail
        this.goalSelector.add(1, new RemnantAttackGoal(this,0, 15, 0, 110, 85, 12, 10){
            @Override
            public boolean canStart() {
                LivingEntity target = entity.getTarget();
                return super.canStart() && target !=null && target.isOnGround() && this.entity.earthquake_cooldown <= 0;
            }
            @Override
            public void stop() {
                super.stop();
                this.entity.earthquake_cooldown = EARTHQUAKE_COOLDOWN;
            }
        });

        //tail_swing
        this.goalSelector.add(1, new RemnantAttackGoal(this,0, 16, 0, 58, 13, 7.5D, 10){
            @Override
            public boolean canStart() {
                LivingEntity target = entity.getTarget();
                return super.canStart() && target !=null && target.getY() < this.entity.getY() + 1.0D;
            }
        });

    }

    protected EntityNavigation createNavigation(World worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    public static DefaultAttributeContainer.Builder maledictus() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 70.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.33F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 25)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 450)
                .add(EntityAttributes.GENERIC_ARMOR, 12)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 4)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
    }


    protected int getNextAirUnderwater(int air) {
        return air;
    }

    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }

    public boolean handleFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }


    public boolean canTakeDamage() {
        return !this.isSleep() && super.canTakeDamage();
    }

    public EntityData initialize(ServerWorldAccess p_29678_, LocalDifficulty p_29679_, SpawnReason p_29680_, @Nullable EntityData p_29681_, @Nullable NbtCompound p_29682_) {
        return super.initialize(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }

    @Override
    public ItemEntity dropStack(ItemStack stack) {
        ItemEntity itementity = this.dropStack(stack,0.0f);
        if (itementity != null) {
            itementity.setGlowing(true);
            itementity.setCovetedItem();
        }
        return itementity;
    }


    @Override
    public boolean damage(DamageSource source, float damage) {
        double range = calculateRange(source);
        if (this.getAttackState() == 7 && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (range > CMConfig.AncientRemnantLongRangelimit * CMConfig.AncientRemnantLongRangelimit && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        Entity entity = source.getSource();
        if (this.getAttackState() != 12){
            if (entity instanceof PersistentProjectileEntity) {
                return false;
            }
        }
        if (this.isSleep()) {
            if (!source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                return false;
            }
        }

        return super.damage(source, damage);
    }


    
    public float DamageCap() {
        return (float) CMConfig.AncientRemnantDamageCap;
    }

    public int DamageTime() {
        return CMConfig.AncientRemnantDamageTime;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(RAGE, 0);
        this.dataTracker.startTracking(NECKLACE, true);
        this.dataTracker.startTracking(POWER, false);
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }

    public void setNecklace(boolean necklace) {
        this.dataTracker.set(NECKLACE, necklace);
        this.bossEvent.setVisible(necklace);
        this.bossEvent2.setVisible(necklace);
        this.setHomePos(this.getBlockPos());
        if(!necklace){
            this.setAttackState(1);
        }
    }

    public boolean getNecklace() {
        return this.dataTracker.get(NECKLACE);
    }

    public void setCustomName(@Nullable Text name) {
        super.setCustomName(name);
        this.bossEvent.setName(this.getDisplayName());
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putBoolean("has_necklace", this.getNecklace());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.setNecklace(compound.getBoolean("has_necklace"));
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }

    public void setRage(int isAnger) {
        this.dataTracker.set(RAGE, isAnger);
    }

    public int getRage() {
        return this.dataTracker.get(RAGE);
    }

    public void setIsPower(boolean isPower) {
        this.dataTracker.set(POWER, isPower);
    }

    public boolean getIsPower() {
        return this.dataTracker.get(POWER);
    }

    public boolean canWalkOnFluid(FluidState p_204067_) {
        return p_204067_.isIn(FluidTags.WATER);
    }

    @Override
    public boolean isPushedByFluids() {
        return false;
    }

    private void floatRemnant() {
        if (this.isTouchingWater()) {
            ShapeContext collisioncontext = ShapeContext.of(this);
            if (collisioncontext.isAbove(FluidBlock.COLLISION_SHAPE, this.getBlockPos(), true) && !this.getWorld().getFluidState(this.getBlockPos().up()).isIn(FluidTags.WATER)) {
                this.setOnGround(true);
            } else {
                this.setVelocity(this.getVelocity().multiply(0.5D).add(0.0D, 0.05D, 0.0D));
            }
        }

    }

    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "idle" -> this.idleAnimationState;
            case "sleep" -> this.sleepAnimationState;
            case "awaken" -> this.awakenAnimationState;
            case "death" -> this.deathAnimationState;
            case "three_tail_hit" -> this.threetailhitAnimationState;
            case "right_bite" -> this.rightbiteAnimationState;
            case "sandstorm_roar" -> this.sandstormroarAnimationState;
            case "charge" -> this.chargeAnimationState;
            case "charge_prepare" -> this.chargeprepareAnimationState;
            case "phase_roar" -> this.phaseroarAnimationState;
            case "right_stomp" -> this.rightstompAnimationState;
            case "left_stomp" -> this.leftstompAnimationState;
            case "charge_stun" -> this.chargestunAnimationState;
            case "right_double_stomp" -> this.rightDoubleStompAnimationState;
            case "left_double_stomp" -> this.leftDoubleStompAnimationState;
            case "ground_tail" -> this.groundtailAnimationState;
            case "tail_swing" -> this.tailswingAnimationState;
            case "monolith" -> this.monolithAnimationState;
            default -> new AnimationState();
        };
//        if (input == "idle") {
//            return this.idleAnimationState;
//        } else if (input == "sleep") {
//            return this.sleepAnimationState;
//        } else if (input == "awaken") {
//            return this.awakenAnimationState;
//        } else if (input == "death") {
//            return this.deathAnimationState;
//        } else if (input == "three_tail_hit") {
//            return this.threetailhitAnimationState;
//        } else if (input == "right_bite") {
//            return this.rightbiteAnimationState;
//        } else if (input == "sandstorm_roar") {
//            return this.sandstormroarAnimationState;
//        } else if (input == "charge") {
//            return this.chargeAnimationState;
//        } else if (input == "charge_prepare") {
//            return this.chargeprepareAnimationState;
//        } else if (input == "phase_roar") {
//            return this.phaseroarAnimationState;
//        } else if (input == "right_stomp") {
//            return this.rightstompAnimationState;
//        } else if (input == "left_stomp") {
//            return this.leftstompAnimationState;
//        } else if (input == "charge_stun") {
//            return this.chargestunAnimationState;
//        } else if (input == "right_double_stomp") {
//            return this.rightDoubleStompAnimationState;
//        } else if (input == "left_double_stomp") {
//            return this.leftDoubleStompAnimationState;
//        } else if (input == "ground_tail") {
//            return this.groundtailAnimationState;
//        } else if (input == "tail_swing") {
//            return this.tailswingAnimationState;
//        } else if (input == "monolith") {
//            return this.monolithAnimationState;
//        } else {
//            return new AnimationState();
//        }
    }


    public void travel(Vec3d travelVector) {
        super.travel(travelVector);
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
                        this.awakenAnimationState.startIfNotRunning(this.age);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfNotRunning(this.age);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.rightbiteAnimationState.startIfNotRunning(this.age);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.threetailhitAnimationState.startIfNotRunning(this.age);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.sandstormroarAnimationState.startIfNotRunning(this.age);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.phaseroarAnimationState.startIfNotRunning(this.age);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.rightstompAnimationState.startIfNotRunning(this.age);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.leftstompAnimationState.startIfNotRunning(this.age);
                    }

                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.chargeprepareAnimationState.startIfNotRunning(this.age);
                    }
                    case 11 -> {
                        this.stopAllAnimationStates();
                        this.chargeAnimationState.startIfNotRunning(this.age);
                    }
                    case 12 -> {
                        this.stopAllAnimationStates();
                        this.chargestunAnimationState.startIfNotRunning(this.age);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.rightDoubleStompAnimationState.startIfNotRunning(this.age);
                    }
                    case 14 -> {
                        this.stopAllAnimationStates();
                        this.leftDoubleStompAnimationState.startIfNotRunning(this.age);
                    }
                    case 15 -> {
                        this.stopAllAnimationStates();
                        this.groundtailAnimationState.startIfNotRunning(this.age);
                    }
                    case 16 -> {
                        this.stopAllAnimationStates();
                        this.tailswingAnimationState.startIfNotRunning(this.age);
                    }
                    case 17 -> {
                        this.stopAllAnimationStates();
                        this.monolithAnimationState.startIfNotRunning(this.age);
                    }
                }
        }

        super.onTrackedDataSet(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.deathAnimationState.stop();
        this.sleepAnimationState.stop();
        this.awakenAnimationState.stop();
        this.rightbiteAnimationState.stop();
        this.threetailhitAnimationState.stop();
        this.sandstormroarAnimationState.stop();
        this.chargeAnimationState.stop();
        this.chargestunAnimationState.stop();
        this.phaseroarAnimationState.stop();
        this.rightstompAnimationState.stop();
        this.leftstompAnimationState.stop();
        this.chargeprepareAnimationState.stop();
        this.rightDoubleStompAnimationState.stop();
        this.leftDoubleStompAnimationState.stop();
        this.groundtailAnimationState.stop();
        this.monolithAnimationState.stop();
        this.tailswingAnimationState.stop();
    }

    public void onDeath(DamageSource p_21014_) {
        super.onDeath(p_21014_);
        this.setAttackState(3);
    }

    public int deathtimer() {
        return 70;
    }
    
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.idleAnimationState.setRunning(getAttackState() != 3, this.age);
        }
        this.bossEvent.setPercent(this.getHealth() / this.getMaxHealth());
        this.bossEvent2.setPercent((float) this.getRage() / 5);
        this.legSolver.update(this, this.bodyYaw, this.getScaleFactor());


        if (hunting_cooldown > 0) hunting_cooldown--;

        if (roar_cooldown > 0) roar_cooldown--;
        if (monoltih_cooldown > 0) monoltih_cooldown--;
        if (earthquake_cooldown > 0) earthquake_cooldown--;
        if (stomp_cooldown > 0) stomp_cooldown--;
        LivingEntity target = this.getTarget();
        if (!this.getWorld().isClient) {
            if (timeWithoutTarget > 0) timeWithoutTarget--;
            if (target != null) {
                timeWithoutTarget = NATURE_HEAL_COOLDOWN;
            }

            if (this.getAttackState() == 0 && timeWithoutTarget <= 0) {
                if (!isAiDisabled() && CMConfig.AncientRemnantNatureHealing > 0) {
                    if (this.age % 20 == 0) {
                        this.heal((float) CMConfig.AncientRemnantNatureHealing);
                    }
                }
            }
        }
        if (!this.getWorld().isClient) {
            if(CMConfig.AncientRemnantBlockBreaking) {
                ChargeBlockBreaking(0.5D);
            }else{
                if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                    ChargeBlockBreaking(0.5D);
                }
            }
        }
        if(this.getIsPower()) {
            if (this.age % 20 == 0) {
                this.heal(1.0F);
            }
        }
        floatRemnant();
        frame++;
        float moveX = (float) (getX() - prevX);
        float moveZ = (float) (getZ() - prevZ);
        float speed = MathHelper.sqrt(moveX * moveX + moveZ * moveZ);
        if (!this.isSilent() && frame % 8 == 1 && speed > 0.05 && this.getAttackState() == 11 && this.isOnGround()) {
            this.playSound(ModSounds.REMNANT_CHARGE_STEP, 1F, 1.0f);
            ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
        }

    }


    public boolean isPower() {
        return this.getHealth() <= this.getMaxHealth() / 2.0F;
    }

    private void Charge() {
        if (!this.getWorld().isClient) {
            if(CMConfig.AncientRemnantBlockBreaking) {
                ChargeBlockBreaking(1.5D);
            }else{
                if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                    ChargeBlockBreaking(1.5D);
                }
            }
        }
        if (this.age % 4 == 0) {
            for (LivingEntity Lentity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox())) {
                if (!isTeammate(Lentity) && !(Lentity instanceof Ancient_Remnant_Entity) && Lentity != this) {
                    boolean flag = Lentity.damage(this.getDamageSources().mobAttack(this), (float) ((float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * 2.0f + Math.min(this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * 2.0f, Lentity.getMaxHealth() * CMConfig.RemnantChargeHpDamage)));
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

    private void ChargeBlockBreaking(double inflate){
        boolean flag = false;
        Box aabb = this.getBoundingBox().expand(inflate, 0.2D, inflate);
        for (BlockPos blockpos : BlockPos.iterate(MathHelper.floor(aabb.minX), MathHelper.floor(this.getY()), MathHelper.floor(aabb.minZ), MathHelper.floor(aabb.maxX), MathHelper.floor(aabb.maxY), MathHelper.floor(aabb.maxZ))) {
            BlockState blockstate = this.getWorld().getBlockState(blockpos);
            if (!blockstate.isAir() && !blockstate.isIn(ModTag.REMNANT_IMMUNE)) {
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

    public void tickMovement() {
        super.tickMovement();

        if(this.getAttackState() == 4) {
            if(this.attackTicks == 8){
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_BITE, SoundCategory.HOSTILE, 1.0f, 1.0f);
            }
            if(this.attackTicks == 31){
                AreaAttack(7,7,70,1.35f,(float) CMConfig.RemnantHpDamage,160,0);
            }
        }

        if(this.getAttackState() == 6) {
            if(this.attackTicks == 14){
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_ROAR, SoundCategory.HOSTILE, 3.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 60);
            }
            if(this.attackTicks == 55) {
                for (int i = 0; i < 3; i++) {
                    float angle = i * MathHelper.PI / 1.5F;
                    double sx = this.getX() + (MathHelper.cos(angle) * 8);
                    double sy = this.getY();
                    double sz = this.getZ() + (MathHelper.sin(angle) * 8);
                    Sandstorm_Entity projectile = new Sandstorm_Entity(this.getWorld(), sx,sy,sz,300,angle,this.getUuid());
                    this.getWorld().spawnEntity(projectile);
                }
            }
        }

        if(this.getAttackState() == 7) {
            if (this.attackTicks == 14) {
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.15f, 0, 80);
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_ROAR, SoundCategory.HOSTILE, 3.0f, 1.0f);
                setIsPower(true);
            }
        }

        if(this.getAttackState() == 8){
            if(this.attackTicks == 28) {
                StompParticle(0.9f,1.4f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP, 1F, 1.0f);
            }

            for (int l = 28; l <= 45; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 26;
                    int d2 = l - 25;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, 1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, 1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,1.4f);
                }
            }
        }
        if(this.getAttackState() == 9){
            if(this.attackTicks == 28) {
                StompParticle(0.9f,-1.4f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP, 1F, 1.0f);
            }
            for (int l = 28; l <= 45; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 26;
                    int d2 = l - 25;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, -1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, -1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,-1.4f);
                }
            }
        }

        if(this.getAttackState() == 10){
            if(this.attackTicks == 1){
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_CHARGE_PREPARE, SoundCategory.HOSTILE, 3.0f, 1.0f);
            }

            if(this.attackTicks == 14){
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                StompParticle(-0.1f,-0.75f);
            }

            if(this.attackTicks == 43){
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                StompParticle(-0.1f,0.75f);
            }

            if(this.attackTicks == 66){
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_CHARGE_ROAR, SoundCategory.HOSTILE, 3.0f, 1.0f);
            }
        }

        if(this.getAttackState() == 11) {
            Charge();
            if (this.horizontalCollision) {
                this.setAttackState(12);
            }
        }
        if(this.getAttackState() == 12) {
            if(this.attackTicks == 1){
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.25f, 0, 60);
            }
            if(this.attackTicks == 1 || this.attackTicks == 3  || this.attackTicks == 5 ){
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_CHARGE_STEP, SoundCategory.HOSTILE, 3.0f, 1.0f);
            }
        }

        if(this.getAttackState() == 13) {
            if(this.attackTicks == 28) {
                StompParticle(0.9f,1.4f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP, 1F, 1.0f);
            }

            for (int l = 28; l <= 45; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 26;
                    int d2 = l - 25;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, 1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, 1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,1.4f);
                }
            }

            if(this.attackTicks == 50) {
                StompParticle(0.9f,1.4f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP, 1F, 1.0f);
            }

            for (int l = 50; l <= 67; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 48;
                    int d2 = l - 47;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, 1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, 1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,1.4f);
                }
            }
        }

        if(this.getAttackState() == 14) {
            if(this.attackTicks == 28) {
                StompParticle(0.9f,-1.4f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP, 1F, 1.0f);
            }
            for (int l = 28; l <= 45; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 26;
                    int d2 = l - 25;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, -1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, -1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,-1.4f);
                }
            }
            if(this.attackTicks == 50) {
                StompParticle(0.9f,-1.4f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP, 1F, 1.0f);
            }
            for (int l = 50; l <= 67; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 48;
                    int d2 = l - 47;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, -1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, -1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,-1.4f);
                }
            }
        }
        if(this.getAttackState() == 15) {
            if(this.attackTicks == 1) {
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_TAIL_SLAM_1, SoundCategory.HOSTILE, 1.0f, 1.0f);
            }
            if(this.attackTicks == 26) {
                AreaAttack(10,10,70,1.0f,(float) CMConfig.RemnantHpDamage,160,0);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                EarthQuakeSummon(5.5f, 22 + random.nextInt(8), 0.8f);
                StompParticle(5.5f,0.8f);
            }
            if(this.attackTicks == 55) {
                AreaAttack(10,10,70,1.0f,(float) CMConfig.RemnantHpDamage,160,0);
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_TAIL_SLAM_2, SoundCategory.HOSTILE, 1.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                EarthQuakeSummon(5.25f, 22 + random.nextInt(8), 1.5f);
                StompParticle(5.25f,1.5f);
            }
            if(this.attackTicks == 85) {
                AreaAttack(10,10,70,1.0f,(float) CMConfig.RemnantHpDamage,160,0);
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_TAIL_SLAM_3, SoundCategory.HOSTILE, 1.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                EarthQuakeSummon(5.5f, 22 + random.nextInt(8), 0.8f);
                StompParticle(5.5f,0.8f);
            }

        }

        if(this.getAttackState() == 16) {
            if(this.attackTicks == 12) {
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_TAIL_SWING, SoundCategory.HOSTILE, 2.0f, 1.0f);
            }
            if(this.attackTicks == 25){
                TailAreaAttack(8,8,1.05F,120,1.0f,(float) CMConfig.RemnantHpDamage,200,100);
            }
        }
        if(this.getAttackState() == 17) {
            if(this.attackTicks == 16) {
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.15f, 0, 80);
               this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_ROAR, SoundCategory.HOSTILE, 3.0f, 1.1f);
            }
        }
    }


    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        Item item = itemstack.getItem();
        if (item == ModItems.NECKLACE_OF_THE_DESERT && !this.getNecklace()) {
            if (!player.isCreative()) {
                itemstack.decrement(1);
            }
            this.setNecklace(true);
            return ActionResult.SUCCESS;
        }
        return super.interactMob(player, hand);
    }

    private void AreaAttack(float range, float height, float arc, float damage, float hpdamage, int shieldbreakticks, int stunticks) {
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
                if (!isTeammate(entityHit) && !(entityHit instanceof Ancient_Remnant_Entity) && entityHit != this) {
                    DamageSource damagesource = this.getDamageSources().mobAttack(this);
                    boolean flag = entityHit.damage(damagesource, (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage + Math.min(this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage, entityHit.getMaxHealth() * hpdamage) ));
                    if (entityHit.blockedByShield(damagesource) && entityHit instanceof PlayerEntity player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }


                    if (flag) {
                        hit = true;
                        if (stunticks > 0) {
                            entityHit.addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTSTUN, stunticks));
                        }
                    }

                }
            }
        }
    }


    private void TailAreaAttack(float range, float height, float height2 , float arc, float damage, float hpdamage, int shieldbreakticks, int stunticks) {
        List<LivingEntity> entitiesHit = this.getTailEntityLivingBaseNearby(range, height,height2, range, range);
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
                if (!isTeammate(entityHit) && !(entityHit instanceof Ancient_Remnant_Entity) && entityHit != this) {
                    DamageSource damagesource = this.getDamageSources().mobAttack(this);
                    boolean flag = entityHit.damage(damagesource, (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage + Math.min(this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage, entityHit.getMaxHealth() * hpdamage) ));
                    if (entityHit.blockedByShield(damagesource) && entityHit instanceof PlayerEntity player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }

                    if (flag) {
                        hit = true;
                        if (stunticks > 0) {
                            entityHit.addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTSTUN, stunticks));
                        }
                        double d0 = entityHit.getX() - this.getX();
                        double d1 = entityHit.getZ() - this.getZ();
                        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                        entityHit.addVelocity(d0 / d2 * 4.0D, 0.2D, d1 / d2 * 4.0D);
                    }

                }
            }
        }
    }

    private void StompDamage(float spreadarc, int distance, int height, float mxy, float vec,float math, int shieldbreakticks, float damage, float hpdamage, float airborne) {
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
            double pz = this.getZ() + vz * distance + vec * Math.sin((bodyYaw + 90) * Math.PI / 180) + f1 * math;
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
            spawnBlocks(hitX,hitY + height ,hitZ, (int) (this.getY() - height),block, px, pz, mxy, vx, vz, factor, shieldbreakticks, damage, hpdamage);

        }
    }


    private void spawnBlocks(int hitX, int hitY, int hitZ, int lowestYCheck,BlockState blockState,double px,double pz,float mxy,double vx,double vz,float factor, int shieldbreakticks,float damage, float hpdamage) {
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
        fallingBlockEntity.addVelocity(0, 0.2D + getRandom().nextGaussian() * 0.04D, 0);
        getWorld().spawnEntity(fallingBlockEntity);



        Box selection = new Box(px - 0.5, (double)blockpos.getY() + d0 -1, pz - 0.5, px + 0.5, (double)blockpos.getY() + d0 + mxy, pz + 0.5);
        List<LivingEntity> hitbox = getWorld().getNonSpectatingEntities(LivingEntity.class, selection);
        for (LivingEntity entity : hitbox) {
            if (!isTeammate(entity) && !(entity instanceof Ancient_Remnant_Entity) && entity != this) {
                DamageSource damagesource = this.getDamageSources().mobAttack(this);
                boolean flag = entity.damage(damagesource, (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage + entity.getMaxHealth() * hpdamage));
                if (entity.blockedByShield(damagesource) && entity instanceof PlayerEntity player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }
                if (flag) {
                    hit = true;
                    double magnitude = -4;
                    double x = vx * (1 - factor) * magnitude;
                    double y = 0;
                    if (entity.isOnGround()) {
                        y += 0.15;
                    }
                    double z = vz * (1 - factor) * magnitude;
                    entity.setVelocity(entity.getVelocity().add(x, y, z));
                }
            }
        }
    }


    private void Stompsound(float distance,float math) {
        double theta = (bodyYaw) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float f = MathHelper.cos(this.bodyYaw * ((float)Math.PI / 180F)) ;
        float f1 = MathHelper.sin(this.bodyYaw * ((float)Math.PI / 180F)) ;
        this.getWorld().playSound(this.getX() + distance * vecX + f * math, this.getY(), this.getZ() + distance * vecZ + f1 * math, ModSounds.REMNANT_SHOCKWAVE, this.getSoundCategory(), 1.5f, 0.8F + this.getRandom().nextFloat() * 0.1F, false);
    }

    public  List<LivingEntity> getTailEntityLivingBaseNearby(double distanceX, double distanceMinY, double distanceMaxY,double distanceZ, double radius) {
        return getTailEntitiesNearby(LivingEntity.class, distanceX, distanceMinY,distanceMaxY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getTailEntitiesNearby(Class<T> entityClass, double dX, double dY, double pY,double dZ, double r) {
        return getWorld().getEntitiesByClass(entityClass, new Box(this.getX() - dX, this.getY() - dY, this.getZ() - dZ, this.getX() + dX, this.getY() + pY, this.getZ() + dZ), e -> e != this && distanceTo(e) <= r + e.getWidth() / 2f && e.getY() <= getY() + dY);
    }

    private void StompParticle(float vec, float math) {
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
                double extraX = 0.5 * MathHelper.sin((float) (Math.PI + angle));
                double extraY = 0.1F;
                double extraZ = 0.5 * MathHelper.cos(angle);
                int hitX = MathHelper.floor(getX() + vec * vecX+ extraX);
                int hitY = MathHelper.floor(getY());
                int hitZ = MathHelper.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = getWorld().getBlockState(hit.down());
                if (block.getRenderType() != BlockRenderType.INVISIBLE) {
                    this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }
            }
            this.getWorld().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 20, 1f, 1f, 1f, 1f, 25f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);

        }
    }


    private void EarthQuakeSummon(float vec, int quake,float math) {
        float f = MathHelper.cos(this.bodyYaw * ((float)Math.PI / 180F)) ;
        float f1 = MathHelper.sin(this.bodyYaw * ((float)Math.PI / 180F)) ;
        double theta = (bodyYaw) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float angle = 360.0F / quake;
        for (int i = 0; i < quake; i++) {
            EarthQuake_Entity peq = new EarthQuake_Entity(this.getWorld(), this);
            peq.setDamage((float) CMConfig.AncientRemnantEarthQuakeDamage);
            peq.setVelocity(this, 0, angle * i, 0.0F, 0.45F, 0.0F);
            peq.setPosition(this.getX() + vec * vecX + f * math, this.getY() + 0.3D, getZ() + vec * vecZ + f1 * math);
            this.getWorld().spawnEntity(peq);

        }
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



    protected SoundEvent getAmbientSound() {
        return !this.isSleep() ? ModSounds.REMNANT_IDLE : super.getAmbientSound();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.REMNANT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.REMNANT_DEATH;
    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.REMNANT_MUSIC;
    }

    @Override
    protected boolean canPlayMusic() {
        return super.canPlayMusic() && !isSleep();
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();

    }

    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossEvent.addPlayer(player);
        this.bossEvent2.addPlayer(player);
    }

    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossEvent.removePlayer(player);
        this.bossEvent2.removePlayer(player);
    }

    @Override
    protected BodyControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }


    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }


    private enum AttackMode {
        CIRCLE,
        MELEE
    }

    static class RemnantStompGoal extends Goal {
        protected final Ancient_Remnant_Entity entity;
        private final int getattackstate;
        private final int attackstate1;
        private final int attackstate2;
        private final int attackstate3;
        private final int attackstate4;
        private final int attackendstate;
        private final int attackMaxtick1;
        private final int attackMaxtick2;
        private final int attackseetick;
        private final double attackrange;
        private final float random;


        public RemnantStompGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate1, int attackstate2, int attackstate3, int attackstate4, int attackendstate, int attackMaxtick1, int attackMaxtick2, int attackseetick, double attackrange, float random) {
            this.entity = entity;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate1 = attackstate1;
            this.attackstate2 = attackstate2;
            this.attackstate3 = attackstate3;
            this.attackstate4 = attackstate4;
            this.attackendstate = attackendstate;
            this.attackMaxtick1 = attackMaxtick1;
            this.attackMaxtick2 = attackMaxtick2;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.random = random;

        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return target != null && this.entity.stomp_cooldown <= 0 && target.isAlive() && this.entity.distanceTo(target) < attackrange
                    && this.entity.getAttackState() == getattackstate && this.entity.getRandom().nextFloat() * 100.0F < random
                    && this.entity.mode == Ancient_Remnant_Entity.AttackMode.MELEE
                    && target.getY() <= this.entity.getY() + 4.5F && this.entity.distanceTo(target) > 5.5D ;
        }


        @Override
        public void start() {
            if(this.entity.getIsPower()) {
                if (this.entity.random.nextBoolean()) {
                    this.entity.setAttackState(attackstate3);
                } else {
                    this.entity.setAttackState(attackstate4);
                }
            }else {
                if (this.entity.random.nextBoolean()) {
                    this.entity.setAttackState(attackstate1);
                }else{
                    this.entity.setAttackState(attackstate2);
                }
            }
            this.entity.hit = false;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAtEntity(target, 30.0F, 30.0F);
                entity.getLookControl().lookAt(target, 30, 30);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            this.entity.stomp_cooldown = STOMP_COOLDOWN;
            if(this.entity.hit) {
                if (this.entity.getRage() > 0) {
                    this.entity.setRage(this.entity.getRage() - 1);
                    this.entity.hit = false;
                }
            }else{
                if (this.entity.getRage() < 5) {
                    this.entity.setRage(this.entity.getRage() + 1);
                    this.entity.hit = false;
                }
            }
        }

        @Override
        public boolean shouldContinue() {
            if (this.entity.getAttackState() == attackstate1 || this.entity.getAttackState() == attackstate2){
                return this.entity.attackTicks <= attackMaxtick1;
            }else if (this.entity.getAttackState() == attackstate3 || this.entity.getAttackState() == attackstate4){
                return this.entity.attackTicks <= attackMaxtick2;
            }
            return false;
        }
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.lookAtEntity(target, 30.0F, 30.0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }
        }
    }

    static class RemnantAwakenGoal extends Goal {
        protected final Ancient_Remnant_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;

        public RemnantAwakenGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick) {
            this.entity = entity;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;


        }

        @Override
        public boolean canStart() {
            return this.entity.getNecklace() && this.entity.getAttackState() == getattackstate;
        }

        @Override
        public void start() {
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

        public boolean shouldRunEveryTick() {
            return false;
        }
    }

    static class RemnantPhaseChangeGoal extends Goal {
        protected final Ancient_Remnant_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;

        public RemnantPhaseChangeGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick) {
            this.entity = entity;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
        }

        @Override
        public boolean canStart() {
            return !this.entity.getIsPower() && this.entity.getAttackState() == getattackstate && this.entity.isPower();
        }

        @Override
        public void start() {
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

        public boolean shouldRunEveryTick() {
            return false;
        }
    }

    static class RemnantStormAttackGoal extends Goal {
        protected final Ancient_Remnant_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final double attackrange;
        private final float random;


        public RemnantStormAttackGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, double attackrange, float random) {
            this.entity = entity;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.random = random;

        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.mode == Ancient_Remnant_Entity.AttackMode.MELEE;
        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
            this.entity.hit = false;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAtEntity(target, 30.0F, 30.0F);
                entity.getLookControl().lookAt(target, 30, 30);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
        }

        @Override
        public boolean shouldContinue() {
            return this.entity.attackTicks <= attackMaxtick && this.entity.getAttackState() == attackstate;
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.lookAtEntity(target, 30.0F, 30.0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }
        }
    }

    static class RemnantMonolithAttackGoal extends Goal {
        protected final Ancient_Remnant_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;


        public RemnantMonolithAttackGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick) {
            this.entity = entity;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;

        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();

            return target !=null && target.isAlive() && (this.entity.monoltih_cooldown <= 0 && this.entity.getRandom().nextFloat() * 100.0F < 12f && target.getY() >= this.entity.getY() + 8
                    ||this.entity.monoltih_cooldown <= 0 && this.entity.getRandom().nextFloat() * 100.0F < 12f && this.entity.distanceTo(target) > 12.0D ||this.entity.monoltih_cooldown <= 0 && this.entity.getRandom().nextFloat() * 100.0F < 12f && this.entity.distanceTo(target) < 10.0D) && this.entity.getAttackState() == getattackstate && this.entity.mode == Ancient_Remnant_Entity.AttackMode.MELEE;

        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
            this.entity.hit = false;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAtEntity(target, 30.0F, 30.0F);
                entity.getLookControl().lookAt(target, 30, 30);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            this.entity.monoltih_cooldown = MONOLITH2_COOLDOWN;
        }

        @Override
        public boolean shouldContinue() {
            return this.entity.attackTicks <= attackMaxtick && this.entity.getAttackState() == attackstate;
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }
            if(this.entity.attackTicks == attackseetick && target !=null) {
                double d1 = target.getY();
                float f = (float) MathHelper.atan2(target.getZ() - this.entity.getZ(), target.getX() - this.entity.getX());
                int l;


                StrikeWindmillMonolith(8, 16, 2.0, 0.75, 0.6, d1,1);


                for (l = 0; l < 16; ++l) {
                    double d2 = 1.25 * (double) (l + 1);
                    int j = (int) ( 5 + 1.5f * l);
                    this.spawnSpikeLine(this.entity.getX() + (double) MathHelper.cos(f) * d2, this.entity.getZ() + (double) MathHelper.sin(f) * d2, d1, f, j);
                }
            }

        }

        private void StrikeWindmillMonolith(int numberOfBranches, int particlesPerBranch, double initialRadius, double radiusIncrement, double curveFactor,double spawnY, int delay) {
            float angleIncrement = (float) (2 * Math.PI / numberOfBranches);
            for (int branch = 0; branch < numberOfBranches; ++branch) {
                float baseAngle = angleIncrement * branch;

                for (int i = 0; i < particlesPerBranch; ++i) {
                    double currentRadius = initialRadius + i * radiusIncrement;
                    float currentAngle = (float) (baseAngle + i * angleIncrement / initialRadius + (float) (i * curveFactor));

                    double xOffset = currentRadius * Math.cos(currentAngle);
                    double zOffset = currentRadius * Math.sin(currentAngle);

                    double spawnX = this.entity.getX() + xOffset;
                    double spawnZ = this.entity.getZ() + zOffset;
                    int d3 = delay * (i + 1);
                    this.spawnSpikeLine(spawnX, spawnZ, spawnY,  currentAngle, d3);
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
            } while (blockpos.getY() < Math.min(entity.getWorld().getTopY(), entity.getBlockY() + 20));
            this.entity.getWorld().spawnEntity(new Ancient_Desert_Stele_Entity(this.entity.getWorld(), posX, (double)blockpos.getY() + d0 -3, posZ, rotation, delay,(float) CMConfig.AncientDesertSteledamage, this.entity));

        }
    }

    static class RemnantAttackGoal extends Goal {
        protected final Ancient_Remnant_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final double attackrange;
        private final float random;


        public RemnantAttackGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, double attackrange, float random) {
            this.entity = entity;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.random = random;

        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.mode == Ancient_Remnant_Entity.AttackMode.MELEE;
        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
            this.entity.hit = false;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAtEntity(target, 30.0F, 30.0F);
                entity.getLookControl().lookAt(target, 30, 30);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            if(this.entity.hit) {
                if (this.entity.getRage() > 0) {
                    this.entity.setRage(this.entity.getRage() - 1);
                    this.entity.hit = false;
                }
            }else{
                if (this.entity.getRage() < 5) {
                    this.entity.setRage(this.entity.getRage() + 1);
                    this.entity.hit = false;
                }
            }
        }

        @Override
        public boolean shouldContinue() {
            return this.entity.attackTicks <= attackMaxtick && this.entity.getAttackState() == attackstate;
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.lookAtEntity(target, 30.0F, 30.0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }
        }
    }

    static class RemnantChargeGoal extends Goal {
        protected final Ancient_Remnant_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final double attackrange;
        private final float random;


        public RemnantChargeGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, double attackrange, float random) {
            this.entity = entity;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.random = random;

        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && this.entity.getRage() >= 5 && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.mode == Ancient_Remnant_Entity.AttackMode.MELEE;
        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
            entity.setRage(0);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAtEntity(target, 30.0F, 30.0F);
                entity.getLookControl().lookAt(target, 30, 30);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            if(this.entity.hit) {
                if (this.entity.getRage() > 0) {
                    this.entity.setRage(this.entity.getRage() - 1);
                    this.entity.hit = false;
                }
            }else{
                if (this.entity.getRage() < 5) {
                    this.entity.setRage(this.entity.getRage() + 1);
                }
            }
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        @Override
        public boolean shouldContinue() {
            return this.entity.attackTicks <= attackMaxtick && this.entity.getAttackState() == attackstate;
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.lookAtEntity(target, 30.0F, 30.0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }
        }
    }

    class RemnantAttackModeGoal extends Goal {
        private final Ancient_Remnant_Entity mob;
        private LivingEntity target;
        private int circlingTime = 0;
        private final float huntingTime = 0;
        private float circleDistance = 9;
        private boolean clockwise = false;

        public RemnantAttackModeGoal(Ancient_Remnant_Entity mob) {
            this.mob = mob;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }

        public boolean canStart() {
            this.target = this.mob.getTarget();
            return this.target != null && target.isAlive() && this.mob.getAttackState() == 0;
        }

        public boolean shouldContinue() {
            this.target = this.mob.getTarget();
            return this.target != null;
        }

        public void start() {
            this.mob.mode = Ancient_Remnant_Entity.AttackMode.CIRCLE;
            circlingTime = 0;
            circleDistance = 18 + this.mob.random.nextInt(10);
            clockwise = this.mob.random.nextBoolean();
            this.mob.setAttacking(true);
        }

        public void stop() {
            this.mob.mode = Ancient_Remnant_Entity.AttackMode.CIRCLE;
            circlingTime = 0;
            circleDistance = 18 + this.mob.random.nextInt(10);
            clockwise = this.mob.random.nextBoolean();
            this.target = this.mob.getTarget();
            if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(target)) {
                this.mob.setTarget(null);
            }

            this.mob.getNavigation().stop();
            if (this.mob.getTarget() == null) {
                this.mob.setAttacking(false);
                this.mob.getNavigation().stop();
            }
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = this.mob.getTarget();
            if (target != null) {
                if (this.mob.mode == Ancient_Remnant_Entity.AttackMode.CIRCLE) {
                    circlingTime++;
                    circleEntity(target, circleDistance, 1.0f, clockwise, circlingTime, 0, 1);
                    if (huntingTime >= this.mob.hunting_cooldown) {
                        this.mob.mode = Ancient_Remnant_Entity.AttackMode.MELEE;
                    }else{
                        if(this.mob.distanceTo(target) < 4D){
                            this.mob.mode = Ancient_Remnant_Entity.AttackMode.MELEE;
                        }
                    }
                } else if (this.mob.mode == Ancient_Remnant_Entity.AttackMode.MELEE) {
                    this.mob.getNavigation().startMovingTo(target, 1.0D);
                    this.mob.getLookControl().lookAt(target, 30, 30);
                }
            }
        }
    }
}





