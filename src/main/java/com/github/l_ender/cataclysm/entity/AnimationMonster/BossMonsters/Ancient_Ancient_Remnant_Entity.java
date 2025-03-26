package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.l_ender.cataclysm.client.gui.CustomBossBar;
import com.github.l_ender.cataclysm.client.gui.CustomBossBarStyles;
import com.github.l_ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.l_ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.l_ender.cataclysm.entity.effect.Sandstorm_Entity;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.l_ender.cataclysm.entity.projectile.Ancient_Desert_Stele_Entity;
import com.github.l_ender.cataclysm.entity.projectile.EarthQuake_Entity;
import com.github.l_ender.cataclysm.init.*;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.AnimationHandler;
import com.github.l_ender.lionfishapi.server.animation.LegSolver;
import net.minecraft.world.GameRules;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
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
import net.minecraft.world.World;
import java.util.EnumSet;
import java.util.List;


public class Ancient_Ancient_Remnant_Entity extends LLibrary_Boss_Monster {

    public static final Animation REMNANT_BITE1 = Animation.create(61);
    public static final Animation REMNANT_BITE2 = Animation.create(67);
    public static final Animation REMNANT_CHARGE_PREPARE = Animation.create(125);
    public static final Animation REMNANT_TAIL_ATTACK1 = Animation.create(57);
    public static final Animation REMNANT_TAIL_ATTACK2 = Animation.create(55);
    public static final Animation REMNANT_LEFT_STOMP = Animation.create(47);
    public static final Animation REMNANT_RIGHT_STOMP = Animation.create(47);
    public static final Animation REMNANT_LEFT_STOMP_EXTRA = Animation.create(38);
    public static final Animation REMNANT_RIGHT_STOMP_EXTRA = Animation.create(38);
    public static final Animation REMNANT_ROAR = Animation.create(70);
    public static final Animation REMNANT_ROAR2 = Animation.create(100);
    public static final Animation REMNANT_PHASE_ROAR = Animation.create(100);
    public static final Animation REMNANT_TAIL_THREE = Animation.create(104);
    public static final Animation REMNANT_DEATH = Animation.create(158);
    private static final TrackedData<Boolean> CHARGE = DataTracker.registerData(Ancient_Ancient_Remnant_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> IS_ACT = DataTracker.registerData(Ancient_Ancient_Remnant_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> POWER = DataTracker.registerData(Ancient_Ancient_Remnant_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public final LegSolver legSolver = new LegSolver(new LegSolver.Leg(0F, 0.75F, 4.0F, false), new LegSolver.Leg(0F, -0.75F, 4.0F, false));
    private AttackMode mode = AttackMode.CIRCLE;
    public float chargeProgress;
    public float prevchargeProgress;
    public float activeProgress;
    public float prevactiveProgress;
    private int hunting_cooldown = 160;
    private int charge_cooldown = 0;
    private int roar_cooldown = 0;
    private int roar2_cooldown = 0;
    private int earthquake_cooldown = 0;
    private int stomp_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 250;
    public static final int ROAR_COOLDOWN = 500;
    public static final int ROAR2_COOLDOWN = 200;
    public static final int EARTHQUAKE_COOLDOWN = 160;
    public static final int STOMP_COOLDOWN = 200;
    private final CustomBossBar bossEvent = new CustomBossBar(this.getDisplayName(), CustomBossBarStyles.ANCIENT_REMNANT, false);
    public static final int NATURE_HEAL_COOLDOWN = 200;
    private int timeWithoutTarget;
    public int frame;
    public static final int MINE_COOLDOWN = 100;
    public Ancient_Ancient_Remnant_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 500;
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
        setConfigattribute(this, CMConfig.AncientRemnantHealthMultiplier, CMConfig.AncientRemnantDamageMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{
                NO_ANIMATION,
                REMNANT_BITE1,
                REMNANT_CHARGE_PREPARE,
                REMNANT_BITE2,
                REMNANT_TAIL_ATTACK1,
                REMNANT_TAIL_ATTACK2,
                REMNANT_LEFT_STOMP,
                REMNANT_RIGHT_STOMP,
                REMNANT_ROAR,
                REMNANT_TAIL_THREE,
                REMNANT_ROAR2,REMNANT_LEFT_STOMP_EXTRA,REMNANT_RIGHT_STOMP_EXTRA,REMNANT_PHASE_ROAR,REMNANT_DEATH};
    }

    protected void initGoals() {
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(3, new RemnantAttackGoal(this));
        this.goalSelector.add(0, new AwakenGoal());
        this.goalSelector.add(1, new RemnantChargeAttackGoal(this, REMNANT_CHARGE_PREPARE));
        this.goalSelector.add(1, new RemnantAnimationAttackGoal(this, REMNANT_BITE1,29));
        this.goalSelector.add(1, new RemnantAnimationAttackGoal(this, REMNANT_BITE2,25));
        this.goalSelector.add(1, new RemnantAnimationAttackGoal(this, REMNANT_LEFT_STOMP,24));
        this.goalSelector.add(1, new RemnantAnimationAttackGoal(this, REMNANT_RIGHT_STOMP,24));
        this.goalSelector.add(1, new RemnantAnimationAttackGoal(this, REMNANT_LEFT_STOMP_EXTRA,19));
        this.goalSelector.add(1, new RemnantAnimationAttackGoal(this, REMNANT_RIGHT_STOMP_EXTRA,19));
        this.goalSelector.add(1, new RemnantAnimationAttackGoal(this, REMNANT_TAIL_ATTACK1,13));
        this.goalSelector.add(1, new RemnantAnimationAttackGoal(this, REMNANT_TAIL_ATTACK2,11));
        this.goalSelector.add(1, new RemnantAnimationAttackGoal(this, REMNANT_ROAR,11));
        this.goalSelector.add(1, new RemnantAnimationAttackGoal(this, REMNANT_TAIL_THREE,20));
        this.goalSelector.add(1, new RemnantSteleAttackGoal(this, REMNANT_ROAR2,29));
        this.goalSelector.add(1, new RemnantAnimationAttackGoal(this, REMNANT_PHASE_ROAR,29));
        this.goalSelector.add(1, new SimpleAnimationGoal<>(this, REMNANT_DEATH));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, LivingEntity.class, 120, true, true, ModEntities.buildPredicateFromTag(ModTag.ANCIENT_REMNANT_TARGET)));
    }

    public static DefaultAttributeContainer.Builder ancient_remnant() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 70.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.33F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 25)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 400)
                .add(EntityAttributes.GENERIC_ARMOR, 10)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.5F)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
    }

    protected int getNextAirUnderwater(int air) {
        return air;
    }




    public boolean canTakeDamage() {
        return this.getIsAct() && super.canTakeDamage();
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
        if (this.getAnimation() == REMNANT_PHASE_ROAR && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (range > CMConfig.AncientRemnantLongRangelimit * CMConfig.AncientRemnantLongRangelimit && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        Entity entity = source.getSource();
        if (entity instanceof PersistentProjectileEntity) {
            return false;
        }
        if (this.activeProgress > 0) {
            if (!source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                return false;
            }
        }

        return super.damage(source, damage);
    }

    
    public float DamageCap() {
        return (float) CMConfig.AncientRemnantDamageCap;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
        p_326229_.add(CHARGE, false);
        p_326229_.add(IS_ACT, true);
        p_326229_.add(POWER, false);
    }

    public void setIsAct(boolean isAct) {
        this.dataTracker.set(IS_ACT, isAct);
    }

    public boolean getIsAct() {
        return this.dataTracker.get(IS_ACT);
    }

    public void setCustomName(@Nullable Text name) {
        super.setCustomName(name);
        this.bossEvent.setName(this.getDisplayName());
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

    public void setIsCharge(boolean isAnger) {
        this.dataTracker.set(CHARGE, isAnger);
    }

    public boolean getIsCharge() {
        return this.dataTracker.get(CHARGE);
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

    public void tick() {
        super.tick();
       // setYRot(yBodyRot);
        prevchargeProgress = chargeProgress;
        prevactiveProgress = activeProgress;
        this.bossEvent.setPercent(this.getHealth() / this.getMaxHealth());
        if (this.getIsCharge() && chargeProgress < 3F) {
            chargeProgress++;
        }
        if (!this.getIsCharge() && chargeProgress > 0F) {
            chargeProgress--;
        }
        if (!this.getIsAct() && activeProgress < 20F) {
            activeProgress++;
        }
        if (this.getIsAct() && activeProgress > 0F) {
            activeProgress--;
        }

        this.legSolver.update(this, this.bodyYaw, this.getScale() );

        if (hunting_cooldown > 0) {
            hunting_cooldown--;
        }

        if (charge_cooldown > 0) charge_cooldown--;
        if (roar_cooldown > 0) roar_cooldown--;
        if (roar2_cooldown > 0) roar2_cooldown--;
        if (earthquake_cooldown > 0) earthquake_cooldown--;
        if (stomp_cooldown > 0) stomp_cooldown--;
        LivingEntity target = this.getTarget();
        if (!this.getWorld().isClient) {
            if (timeWithoutTarget > 0) timeWithoutTarget--;
            if (target != null) {
                timeWithoutTarget = NATURE_HEAL_COOLDOWN;
            }

            if (this.getAnimation() == NO_ANIMATION && timeWithoutTarget <= 0) {
                if (!isAiDisabled() && CMConfig.AncientRemnantNatureHealing > 0) {
                    if (this.age % 20 == 0) {
                        this.heal((float) CMConfig.AncientRemnantNatureHealing);
                    }
                }
            }
        }

        if(this.getIsPower()) {
            if (this.age % 20 == 0) {
                this.heal(2.0F);
            }
        }
        floatRemnant();
        Charge();
        frame++;
        float moveX = (float) (getX() - prevX);
        float moveZ = (float) (getZ() - prevZ);
        float speed = MathHelper.sqrt(moveX * moveX + moveZ * moveZ);
        if (!this.isSilent() && frame % 8 == 1 && speed > 0.05 && this.getIsCharge() && this.isOnGround()) {
            this.playSound(ModSounds.REMNANT_CHARGE_STEP, 1F, 1.0f);
            ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
        }

       if(this.isAlive() && this.getIsAct()) {
           if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.isPower() && !this.getIsPower()) {
               this.setAnimation(REMNANT_PHASE_ROAR);
           }
       }

       // if (!this.isSilent() && frame % 16 == 1 && speed > 0.05 && !this.getIsCharge()) {
       //     this.playSound(ModSounds.REMNANT_CHARGE_STEP, 1F, 1.0f);
        //    ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.02f, 0, 10);
       // }
    }

    public boolean isPower() {
        return this.getHealth() <= this.getMaxHealth() / 2.0F;
    }

    private void Charge() {
        if (getIsCharge()) {
            if (!this.getWorld().isClient) {
                if(CMConfig.AncientRemnantBlockBreaking) {
                    ChargeBlockBreaking();
                }else{
                    if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                        ChargeBlockBreaking();
                    }
                }

            }
            if (this.age % 4 == 0) {
                for (LivingEntity Lentity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(1.5D))) {
                    if (!isTeammate(Lentity) && !(Lentity instanceof Ancient_Ancient_Remnant_Entity) && Lentity != this) {
                        boolean flag = Lentity.damage(this.getDamageSources().mobAttack(this), (float) ((float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * 1.5f + Math.min(this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * 1.5f, Lentity.getMaxHealth() * CMConfig.RemnantChargeHpDamage)));
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


    private void ChargeBlockBreaking(){
        boolean flag = false;
        Box aabb = this.getBoundingBox().expand(0.5D, 0.2D, 0.5D);
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

        if(this.getAnimation() == REMNANT_BITE1){
            if(this.getAnimationTick() == 5){
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_BITE, SoundCategory.HOSTILE, 1.0f, 1.0f);
            }
            if(this.getAnimationTick() == 28){
                AreaAttack(8,8,70,1.35f,(float) CMConfig.RemnantHpDamage,160,0);
            }
        }

        if(this.getAnimation() == REMNANT_BITE2){
            if(this.getAnimationTick() == 1){
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_BITE, SoundCategory.HOSTILE, 1.0f, 1.0f);
            }
            if(this.getAnimationTick() == 24){
                AreaAttack(8,8,70,1.35f,(float) CMConfig.RemnantHpDamage,160,0);
            }
        }


        if(this.getAnimation() == REMNANT_TAIL_ATTACK1){
            if(this.getAnimationTick() == 3) {
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_TAIL_SWING, SoundCategory.HOSTILE, 2.0f, 1.0f);
            }
            if(this.getAnimationTick() == 16){
                TailAreaAttack(8,8,1.05F,120,1.0f,(float) CMConfig.RemnantHpDamage,200,100);
            }
        }

        if(this.getAnimation() == REMNANT_TAIL_ATTACK2){
            if(this.getAnimationTick() == 1) {
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_TAIL_SWING, SoundCategory.HOSTILE, 2.0f, 1.0f);
            }
            if(this.getAnimationTick() == 14){
                TailAreaAttack(8,8,1.05F,120,1.0f,(float) CMConfig.RemnantHpDamage,200,100);
            }
        }

        if(this.getAnimation() == REMNANT_CHARGE_PREPARE){
            if(this.getAnimationTick() == 1){
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_CHARGE_PREPARE, SoundCategory.HOSTILE, 3.0f, 1.0f);
            }

            if(this.getAnimationTick() == 15){
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                StompParticle(-0.1f,-0.75f);
            }

            if(this.getAnimationTick() == 41){
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                StompParticle(-0.1f,0.75f);
            }

            if(this.getAnimationTick() == 62){
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_CHARGE_ROAR, SoundCategory.HOSTILE, 3.0f, 1.0f);
            }
            if(this.getAnimationTick() == 132) {
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_BREATHING, SoundCategory.HOSTILE, 1.0f, 1.0f);
            }
        }

        if(this.getAnimation() == REMNANT_ROAR){
            if(this.getAnimationTick() == 14){
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_ROAR, SoundCategory.HOSTILE, 3.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 60);
            }
            if(this.getAnimationTick() == 55) {
                for (int i = 0; i < 4; i++) {
                    float angle = i * MathHelper.PI / 2F;
                    double sx = this.getX() + (MathHelper.cos(angle) * 8);
                    double sy = this.getY();
                    double sz = this.getZ() + (MathHelper.sin(angle) * 8);

                    if (!getWorld().isClient()) {
                        Sandstorm_Entity projectile = new Sandstorm_Entity(this.getWorld(), sx, sy, sz, 300, angle, this);
                        this.getWorld().spawnEntity(projectile);
                    }
                }
            }
        }
        if(this.getAnimation() == REMNANT_ROAR2){
            if(this.getAnimationTick() == 23){
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 60);
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_ROAR, SoundCategory.HOSTILE, 3.0f, 1.0f);
            }
        }

        if(this.getAnimation() == REMNANT_PHASE_ROAR){
            if(this.getAnimationTick() == 23){
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 60);
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_ROAR, SoundCategory.HOSTILE, 3.0f, 1.0f);
                setIsPower(true);
            }
        }

        if(this.getAnimation() == REMNANT_TAIL_THREE){
            if(this.getAnimationTick() == 1) {
                this.getWorld().playSoundFromEntity(null, this, ModSounds.REMNANT_TAIL_SLAM, SoundCategory.HOSTILE, 1.0f, 1.0f);
            }
            if(this.getAnimationTick() == 37) {
                AreaAttack(10,10,50,1.0f,(float) CMConfig.RemnantHpDamage,160,0);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                EarthQuakeSummon(5.5f, 20 + random.nextInt(10), -0.75f);
            }
            if(this.getAnimationTick() == 55) {
                AreaAttack(10,10,50,1.0f,(float) CMConfig.RemnantHpDamage,160,0);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                EarthQuakeSummon(5.5f, 20 + random.nextInt(10), -0.75f);
            }
            if(this.getAnimationTick() == 73) {
                AreaAttack(10,10,50,1.0f,(float) CMConfig.RemnantHpDamage,160,0);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                EarthQuakeSummon(5.5f, 20 + random.nextInt(10), -0.75f);
            }

        }
        if(this.getAnimation() == REMNANT_LEFT_STOMP){
            if(this.getAnimationTick() == 28) {
                StompParticle(0.9f,1.3f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP, 1F, 1.0f);
                if(this.getIsPower()){
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, REMNANT_LEFT_STOMP_EXTRA);
                }
            }

            for (int l = 28; l <= 45; l = l + 2) {
                if (this.getAnimationTick() == l) {
                    int d = l - 26;
                    int d2 = l - 25;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, 1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, 1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,1.3f);
                }
            }
        }
        if(this.getAnimation() == REMNANT_LEFT_STOMP_EXTRA){
            for (int l = 2; l <= 19; l = l + 2) {
                if (this.getAnimationTick() == l) {
                    int d2 = l + 1;
                    float ds = (float) (l + d2) / 2;
                    StompDamage(0.4f, l, 6,0.9F, 0, 1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, 1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,1.3f);
                }
            }
            if(this.getAnimationTick() == 19) {
                StompParticle(0.9f, 1.3f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP, 1F, 1.0f);
            }
            for (int l = 19; l <= 36; l = l + 2) {
                if (this.getAnimationTick() == l) {
                    int d = l - 17;
                    int d2 = l - 16;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, 1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, 1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,1.3f);
                }
            }
        }

        if(this.getAnimation() == REMNANT_RIGHT_STOMP){
            if(this.getAnimationTick() == 28) {
                StompParticle(0.9f,-1.3f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP, 1F, 1.0f);
                if(this.getIsPower()){
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, REMNANT_RIGHT_STOMP_EXTRA);
                }
            }
            for (int l = 28; l <= 45; l = l + 2) {
                if (this.getAnimationTick() == l) {
                    int d = l - 26;
                    int d2 = l - 25;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, -1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, -1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,-1.3f);
                }
            }
        }
        if(this.getAnimation() == REMNANT_RIGHT_STOMP_EXTRA){
            for (int l = 2; l <= 19; l = l + 2) {
                if (this.getAnimationTick() == l) {
                    int d2 = l + 1;
                    float ds = (float) (l + d2) / 2;
                    StompDamage(0.4f, l, 6,0.9F, 0, -1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, -1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,-1.3f);
                }
            }
            if(this.getAnimationTick() == 19) {
                StompParticle(0.9f, -1.3f);
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP, 1F, 1.0f);
            }
            for (int l = 19; l <= 36; l = l + 2) {
                if (this.getAnimationTick() == l) {
                    int d = l - 17;
                    int d2 = l - 16;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, -1.3f,80, 1.0f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, -1.3f,80, 1.0f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,-1.3f);
                }
            }
        }
        if(this.getAnimation() == REMNANT_DEATH){
            if(this.getAnimationTick() == 52 || this.getAnimationTick() == 62 || this.getAnimationTick() == 77) {
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 30, 0.05f, 0, 8);
            }
        }
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        if (itemstack.isOf(ModItems.NECKLACE_OF_THE_DESERT) && !this.getIsAct()) {
            if (!player.isCreative()) {
                itemstack.decrement(1);
            }
            this.setIsAct(true);
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
                if (!isTeammate(entityHit) && !(entityHit instanceof Ancient_Ancient_Remnant_Entity) && entityHit != this) {
                    DamageSource damagesource = this.getDamageSources().mobAttack(this);
                    boolean flag = entityHit.damage(damagesource, (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage + Math.min(this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage, entityHit.getMaxHealth() * hpdamage) ));
                    if (entityHit.blockedByShield(damagesource) && entityHit instanceof PlayerEntity player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }


                    if (flag) {
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
                if (!isTeammate(entityHit) && !(entityHit instanceof Ancient_Ancient_Remnant_Entity) && entityHit != this) {
                    DamageSource damagesource = this.getDamageSources().mobAttack(this);
                    boolean flag = entityHit.damage(damagesource, (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage + Math.min(this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage, entityHit.getMaxHealth() * hpdamage) ));
                    if (entityHit.blockedByShield(damagesource) && entityHit instanceof PlayerEntity player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }


                    if (flag) {
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
        List<LivingEntity> hit = getWorld().getNonSpectatingEntities(LivingEntity.class, selection);
        for (LivingEntity entity : hit) {
            if (!isTeammate(entity) && !(entity instanceof Ancient_Ancient_Remnant_Entity) && entity != this) {
                DamageSource damagesource = this.getDamageSources().mobAttack(this);
                boolean flag = entity.damage(damagesource, (float) (this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * damage + entity.getMaxHealth() * hpdamage));
                if (entity.blockedByShield(damagesource) && entity instanceof PlayerEntity player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }
                if (flag) {
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
                double extraY = 0.3F;
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
            this.getWorld().addParticle(new RingParticleOptions(0f, (float) Math.PI / 2f, 20, 255, 255, 255, 1f, 25f, false, 2), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);

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
            peq.setPosition(this.getX() + vec * vecX + f * math, this.getY(), getZ() + vec * vecZ + f1 * math);
            this.getWorld().spawnEntity(peq);

        }
    }


    protected SoundEvent getAmbientSound() {
        return this.getIsAct() ? ModSounds.REMNANT_IDLE : super.getAmbientSound();
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
        return super.canPlayMusic() && getIsAct();
    }

    @Nullable
    public Animation getDeathAnimation()
    {
        return REMNANT_DEATH;
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();

    }

    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossEvent.addPlayer(player);
    }

    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossEvent.removePlayer(player);
    }

    @Override
    protected BodyControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected EntityNavigation createNavigation(World worldIn) {
        return new CMPathNavigateGround(this, worldIn);
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

    class AwakenGoal extends Goal {

        public AwakenGoal() {
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
        }

        public boolean canStart() {
            return activeProgress > 0F;
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            Ancient_Ancient_Remnant_Entity.this.setVelocity(0, Ancient_Ancient_Remnant_Entity.this.getVelocity().y, 0);
        }
    }

    static class RemnantChargeAttackGoal extends SimpleAnimationGoal<Ancient_Ancient_Remnant_Entity> {

        public RemnantChargeAttackGoal(Ancient_Ancient_Remnant_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAtEntity(target, 30.0F, 30.0F);
                entity.getLookControl().lookAt(target, 30, 30);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            entity.hunting_cooldown = MINE_COOLDOWN;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAtEntity(target, 30.0F, 30.0F);
                entity.getLookControl().lookAt(target, 30, 30);
            }
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if(this.entity.getAnimationTick() < 62 && target !=null){
                this.entity.lookAtEntity(target, 30.0F, 30.0F);
                this.entity.getLookControl().lookAt(target, 30f, 30f);
            }else{
                entity.setYaw(entity.prevYaw);
            }
            if(this.entity.getAnimationTick() < 122 && this.entity.getAnimationTick() > 62 && this.entity.isOnGround()){
                Vec3d vector3d = entity.getVelocity();
                float f = entity.getYaw() * ((float)Math.PI / 180F);
                Vec3d vector3d1 = new Vec3d(-MathHelper.sin(f), entity.getVelocity().y, MathHelper.cos(f)).multiply(1.0D).add(vector3d.multiply(0.5D));
                entity.setVelocity(vector3d1.x, entity.getVelocity().y, vector3d1.z);
            }


            if(this.entity.getAnimationTick() == 62){
                this.entity.setIsCharge(true);
            }

            if(this.entity.getAnimationTick() == 122){
                this.entity.setIsCharge(false);
            }

        }
    }


    static class RemnantAnimationAttackGoal extends SimpleAnimationGoal<Ancient_Ancient_Remnant_Entity> {
        private final int look;

        public RemnantAnimationAttackGoal(Ancient_Ancient_Remnant_Entity entity, Animation animation, int look) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
            this.look =look;
        }

        public void start() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAtEntity(target, 30.0F, 30.0F);
                entity.getLookControl().lookAt(target, 30, 30);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if(this.entity.getAnimationTick() < look && target !=null){
                this.entity.lookAtEntity(target, 30.0F, 30.0F);
                this.entity.getLookControl().lookAt(target, 30f, 30f);
            }else{
                entity.setYaw(entity.prevYaw);
            }
        }
    }

    static class RemnantSteleAttackGoal extends SimpleAnimationGoal<Ancient_Ancient_Remnant_Entity> {
        private final int look;

        public RemnantSteleAttackGoal(Ancient_Ancient_Remnant_Entity entity, Animation animation, int look) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
            this.look =look;
        }

        public void start() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().lookAt(target, 30, 30);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if(this.entity.getAnimationTick() < look && target !=null){
                this.entity.getLookControl().lookAt(target, 30f, 30f);
            }else{
                entity.setYaw(entity.prevYaw);
            }
            if(this.entity.getAnimationTick() == look && target !=null) {
                double d1 = target.getY();
                float f = (float) MathHelper.atan2(target.getZ() - this.entity.getZ(), target.getX() - this.entity.getX());
                int l;
                for (int k = 0; k < 10; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 10.0F + ((float) Math.PI * 2F / 15F);
                    this.spawnSpikeLine(this.entity.getX() + (double) MathHelper.cos(f4) * 4.5D, this.entity.getZ() + (double) MathHelper.sin(f4) * 4.5D, d1, f4, 10);
                }

                for (int k = 0; k < 12; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 12.0F + ((float) Math.PI * 2F / 20f);
                    this.spawnSpikeLine(this.entity.getX() + (double) MathHelper.cos(f4) * 7.5D, this.entity.getZ() + (double) MathHelper.sin(f4) * 7.5D, d1, f4, 15);
                }

                for (int k = 0; k < 14; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 17.0F + ((float) Math.PI * 2F / 30F);
                    this.spawnSpikeLine(this.entity.getX() + (double) MathHelper.cos(f4) * 10.5D, this.entity.getZ() + (double) MathHelper.sin(f4) * 10.5D, d1, f4, 20);
                }

                for (int k = 0; k < 16; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 16.0F + ((float) Math.PI * 2F / 40f);
                    this.spawnSpikeLine(this.entity.getX() + (double) MathHelper.cos(f4) * 13.5D, this.entity.getZ() + (double) MathHelper.sin(f4) * 13.5D, d1, f4, 25);
                }

                for (int k = 0; k < 18; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 18.0F + ((float) Math.PI * 2F / 60f);
                    this.spawnSpikeLine(this.entity.getX() + (double) MathHelper.cos(f4) * 16.5D, this.entity.getZ() + (double) MathHelper.sin(f4) * 16.5D, d1, f4, 30);
                }

                for (int k = 0; k < 20; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 20.0F + ((float) Math.PI * 2F / 80f);
                    this.spawnSpikeLine(this.entity.getX() + (double) MathHelper.cos(f4) * 19.5D, this.entity.getZ() + (double) MathHelper.sin(f4) * 19.5D, d1, f4, 35);
                }

                for (int k = 0; k < 22; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 22 + ((float) Math.PI * 2F / 120f);
                    this.spawnSpikeLine(this.entity.getX() + (double) MathHelper.cos(f4) * 22.5D, this.entity.getZ() + (double) MathHelper.sin(f4) * 22.5D, d1, f4, 40);
                }


                for (l = 0; l < 16; ++l) {
                    double d2 = 1.25 * (double) (l + 1);
                    int j = (int) ( 5 + 1.5f * l);
                    this.spawnSpikeLine(this.entity.getX() + (double) MathHelper.cos(f) * d2, this.entity.getZ() + (double) MathHelper.sin(f) * d2, d1, f, j);
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



    class RemnantAttackGoal extends Goal {
        private final Ancient_Ancient_Remnant_Entity mob;
        private LivingEntity target;
        private int circlingTime = 0;
        private final float huntingTime = 0;
        private float circleDistance = 9;
        private boolean clockwise = false;

        public RemnantAttackGoal(Ancient_Ancient_Remnant_Entity mob) {
            this.mob = mob;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }

        public boolean canStart() {
            this.target = this.mob.getTarget();
            return this.target != null && target.isAlive() && this.mob.getAnimation() == NO_ANIMATION;
        }

        public boolean shouldContinue() {
            this.target = this.mob.getTarget();
            return this.target != null;
        }

        public void start() {
            this.mob.mode = AttackMode.CIRCLE;
            circlingTime = 0;
            circleDistance = 18 + this.mob.random.nextInt(10);
            clockwise = this.mob.random.nextBoolean();
            this.mob.setAttacking(true);
        }

        public void stop() {
            this.mob.mode = AttackMode.CIRCLE;
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
                if (this.mob.mode == AttackMode.CIRCLE) {
                    circlingTime++;
                    circleEntity(target, circleDistance, 1.0f, clockwise, circlingTime, 0, 1);
                    if (huntingTime >= this.mob.hunting_cooldown) {
                        this.mob.mode = AttackMode.MELEE;
                    }else{
                        if(this.mob.distanceTo(target) < 4D){
                            this.mob.mode = AttackMode.MELEE;
                        }
                    }
                } else if (this.mob.mode == AttackMode.MELEE) {
                    this.mob.getNavigation().startMovingTo(target, 1.0D);
                    this.mob.getLookControl().lookAt(target, 30, 30);
                    if (this.mob.roar2_cooldown <= 0 && this.mob.getRandom().nextFloat() * 100.0F < 12f && target.getY() >= this.mob.getY() + 8
                    ||this.mob.roar2_cooldown <= 0 && this.mob.getRandom().nextFloat() * 100.0F < 3f && this.mob.distanceTo(target) > 12.0D) {
                        this.mob.setAnimation(REMNANT_ROAR2);
                        this.mob.roar2_cooldown = ROAR2_COOLDOWN;
                    }else if (this.mob.roar_cooldown <= 0 && this.mob.getRandom().nextFloat() * 100.0F < 3f) {
                        this.mob.setAnimation(REMNANT_ROAR);
                        this.mob.roar_cooldown = ROAR_COOLDOWN;
                    }else if (this.mob.earthquake_cooldown <= 0 && this.mob.getRandom().nextFloat() * 100.0F < 7f && this.mob.distanceTo(target) < 12.0D && target.isOnGround()) {
                        this.mob.setAnimation(REMNANT_TAIL_THREE);
                        this.mob.earthquake_cooldown = EARTHQUAKE_COOLDOWN;
                    }else if (this.mob.charge_cooldown <= 0 && this.mob.getRandom().nextFloat() * 100.0F < 9f && this.mob.distanceTo(target) > 7.0D && this.mob.distanceTo(target) < 20D && target.getY() <= this.mob.getY() + 1) {
                        if (this.mob.random.nextBoolean()) {
                            this.mob.setAnimation(REMNANT_RIGHT_STOMP);
                        } else {
                            this.mob.setAnimation(REMNANT_LEFT_STOMP);
                        }
                    }else if (this.mob.charge_cooldown <= 0 && this.mob.getRandom().nextFloat() * 100.0F < 3f && this.mob.distanceTo(target) > 12.0D) {
                        this.mob.setAnimation(REMNANT_CHARGE_PREPARE);
                        this.mob.charge_cooldown = CHARGE_COOLDOWN;
                    }else if (this.mob.charge_cooldown <= 0 && this.mob.getRandom().nextFloat() * 100.0F < 9f && this.mob.distanceTo(target) > 7.0D && this.mob.distanceTo(target) < 20D && target.getY() <= this.mob.getY() + 4.5F) {
                        if (this.mob.random.nextBoolean()) {
                            this.mob.setAnimation(REMNANT_RIGHT_STOMP);
                        } else {
                            this.mob.setAnimation(REMNANT_LEFT_STOMP);
                        }
                        this.mob.stomp_cooldown = STOMP_COOLDOWN;
                    }else if(this.mob.getRandom().nextFloat() * 100.0F < 10f && this.mob.distanceTo(target) < 7.0D && target.getY() < this.mob.getY() + 1) {
                            this.mob.setAnimation(REMNANT_TAIL_ATTACK1);
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 10f && this.mob.distanceTo(target) < 6.0D) {
                        if (this.mob.random.nextBoolean()) {
                            this.mob.setAnimation(REMNANT_BITE1);
                        } else {
                            this.mob.setAnimation(REMNANT_BITE2);
                        }

                    }
                }
            }
        }
    }
}





