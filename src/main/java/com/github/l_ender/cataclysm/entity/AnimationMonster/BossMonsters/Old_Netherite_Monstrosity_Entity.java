package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.l_ender.cataclysm.client.gui.CustomBossBar;
import com.github.l_ender.cataclysm.client.gui.CustomBossBarStyles;
import com.github.l_ender.cataclysm.client.particle.RingParticle;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AnimationMonster.AI.AnimationGoal;
import com.github.l_ender.cataclysm.entity.AnimationMonster.AI.AttackMoveGoal;
import com.github.l_ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.l_ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.entity.partentity.Cm_Part_Entity;
import com.github.l_ender.cataclysm.entity.partentity.Old_Netherite_Monstrosity_Part;
import com.github.l_ender.cataclysm.entity.partentity.Partable;
import com.github.l_ender.cataclysm.entity.projectile.Lava_Bomb_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import net.minecraft.world.GameRules;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
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
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import java.util.EnumSet;

public class Old_Netherite_Monstrosity_Entity extends LLibrary_Boss_Monster implements Monster, Partable {

   // private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(false);
    private final CustomBossBar bossInfo = new CustomBossBar(this.getDisplayName(), CustomBossBarStyles.NETHERITE_MONSTROSITY, false);
    public int frame;
    public static final Animation MONSTROSITY_EARTHQUAKE = Animation.create(75);
    public static final Animation MONSTROSITY_CHARGE = Animation.create(82);
    public static final Animation MONSTROSITY_ERUPTIONATTACK = Animation.create(55);
    public static final Animation MONSTROSITY_EARTHQUAKE2 = Animation.create(65);
    public static final Animation MONSTROSITY_EARTHQUAKE3 = Animation.create(70);
    public static final Animation MONSTROSITY_BERSERK = Animation.create(80);
    public static final Animation MONSTROSITY_DEATH = Animation.create(185);
    public final Old_Netherite_Monstrosity_Part headPart;
    public final Old_Netherite_Monstrosity_Part[] monstrosityParts;
    private static final TrackedData<Boolean> IS_BERSERK = DataTracker.registerData(Old_Netherite_Monstrosity_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> IS_AWAKEN = DataTracker.registerData(Old_Netherite_Monstrosity_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private int lavabombmagazine = CMConfig.Lavabombmagazine;
    public boolean Blocking = CMConfig.NetheritemonstrosityBodyBloking;
    public float deactivateProgress;
    private int blockBreakCounter;
    public float prevdeactivateProgress;
    public static final int NATURE_HEAL_COOLDOWN = 200;
    private int timeWithoutTarget;

    public Old_Netherite_Monstrosity_Entity(EntityType<? extends Old_Netherite_Monstrosity_Entity> entity, World world) {
        super(entity, world);
        this.experiencePoints = 300;
        this.setStepHeight(1.75F);
        this.headPart = new Old_Netherite_Monstrosity_Part(this, 1.6F, 2.5F);
        this.monstrosityParts = new Old_Netherite_Monstrosity_Part[]{this.headPart};
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.LAVA, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0F);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, 0.0F);
        setConfigattribute(this, CMConfig.MonstrosityHealthMultiplier, CMConfig.MonstrosityDamageMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{MONSTROSITY_BERSERK, MONSTROSITY_EARTHQUAKE, MONSTROSITY_CHARGE, MONSTROSITY_EARTHQUAKE2, MONSTROSITY_EARTHQUAKE3, MONSTROSITY_ERUPTIONATTACK, MONSTROSITY_DEATH};
    }

    protected void initGoals() {
        this.goalSelector.add(0, new BerserkGoal(this,MONSTROSITY_BERSERK));
        this.goalSelector.add(0, new AwakenGoal());
        this.goalSelector.add(1, new HealGoal(this, MONSTROSITY_CHARGE));
        this.goalSelector.add(1, new ShootGoal(this, MONSTROSITY_ERUPTIONATTACK));
        this.goalSelector.add(1, new EarthQuakeGoal(this));
        this.goalSelector.add(2, new AttackMoveGoal(this, true,1.0D));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, true));

    }

    public static DefaultAttributeContainer.Builder netherite_monstrosity() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 50.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 21)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 500)
                .add(EntityAttributes.GENERIC_ARMOR, 10)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(IS_BERSERK, false);
        this.dataTracker.startTracking(IS_AWAKEN, false);
    }

    private static Animation getRandomAttack(Random rand) {
        return switch (rand.nextInt(3)) {
            case 0 -> MONSTROSITY_EARTHQUAKE;
            case 1 -> MONSTROSITY_EARTHQUAKE2;
            case 2 -> MONSTROSITY_EARTHQUAKE3;
            default -> MONSTROSITY_EARTHQUAKE;
        };
    }

    public boolean canWalkOnFluid(FluidState p_230285_1_) {
        return p_230285_1_.isIn(FluidTags.LAVA);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putBoolean("is_Berserk", getIsBerserk());
        compound.putBoolean("is_Awaken", getIsAwaken());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        setIsBerserk(compound.getBoolean("is_Berserk"));
        setIsAwaken(compound.getBoolean("is_Awaken"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    public void setIsBerserk(boolean isBerserk) {
        this.dataTracker.set(IS_BERSERK, isBerserk);
    }

    public boolean getIsBerserk() {
        return this.dataTracker.get(IS_BERSERK);
    }

    public void setIsAwaken(boolean isAwaken) {
        this.dataTracker.set(IS_AWAKEN, isAwaken);
    }

    public boolean getIsAwaken() {
        return this.dataTracker.get(IS_AWAKEN);
    }

    public void setCustomName(@Nullable Text name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    protected int getNextAirUnderwater(int air) {
        return air;
    }

    public boolean attackEntityFromPart(Old_Netherite_Monstrosity_Part oldNetherite_monstrosity_part, DamageSource source, float amount) {
        return this.damage(source, amount);
    }

    @Override
    public boolean damage(DamageSource source, float damage) {
        if (this.getAnimation() == MONSTROSITY_BERSERK && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
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

        if(attack &&!this.getIsAwaken() ){
            this.setIsAwaken(true);
        }
        return attack;
    }

    
    public float DamageCap() {
        return (float) CMConfig.MonstrosityDamageCap;
    }

    public boolean isCollidable() {
        return this.isAlive() && Blocking;
    }

    public boolean isPushable() {
        return false;
    }

    public boolean handleFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

    private void floatStrider() {
        if (this.isInLava()) {
            ShapeContext lvt_1_1_ = ShapeContext.of(this);
            if (lvt_1_1_.isAbove(FluidBlock.COLLISION_SHAPE, this.getBlockPos().down(), true) && !this.getWorld().getFluidState(this.getBlockPos().up()).isIn(FluidTags.LAVA)) {
                this.setOnGround(true);
            } else {
                this.setVelocity(this.getVelocity().multiply(0.5D).add(0.0D, random.nextFloat() * 0.5, 0.0D));
            }
        }

    }

    public void tick() {
        super.tick();
        this.floatStrider();

        frame++;
        float moveX = (float) (getX() - prevX);
        float moveZ = (float) (getZ() - prevZ);
        float speed = MathHelper.sqrt(moveX * moveX + moveZ * moveZ);
        if (!this.isSilent() && frame % 25 == 1 && speed > 0.05 && this.getIsAwaken()) {
            playSound(ModSounds.MONSTROSITYSTEP, 1F, 1.0f);
        }
        this.bossInfo.setVisible(this.getIsAwaken());
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
        BlockBreaking();
        prevdeactivateProgress = deactivateProgress;
        if (!this.getIsAwaken() && deactivateProgress < 40F) {
            deactivateProgress = 40;
        }
        if (this.getIsAwaken() && deactivateProgress > 0F) {
            deactivateProgress--;
            if(deactivateProgress == 20 && this.getHealth() > 0){
                this.playSound(ModSounds.MONSTROSITYAWAKEN, 10, 1);
            }
        }
        LivingEntity target = this.getTarget();
        if (!this.getWorld().isClient) {
            if (timeWithoutTarget > 0) timeWithoutTarget--;
            if (target != null) {
                timeWithoutTarget = NATURE_HEAL_COOLDOWN;
            }

            if (this.getAnimation() == NO_ANIMATION && timeWithoutTarget <= 0) {
                if (!isAiDisabled() && CMConfig.MonstrosityNatureHealing > 0) {
                    if (this.age % 20 == 0) {
                        this.heal((float) CMConfig.MonstrosityNatureHealing);
                    }
                }
            }
        }
        
        if (this.getAnimation() == MONSTROSITY_EARTHQUAKE && this.getAnimationTick() == 34
                || this.getAnimation() == MONSTROSITY_EARTHQUAKE2 && this.getAnimationTick() == 24
                || this.getAnimation() == MONSTROSITY_EARTHQUAKE3 && this.getAnimationTick() == 29 ){
            EarthQuake();
            ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 20, 0.3f, 0, 20);
            Makeparticle(4.75f,2.5f);
            Makeparticle(4.75f,-2.5f);
        }

        if(deactivateProgress == 0 && this.isAlive()) {
            if(!isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.isBerserk() && !this.getIsBerserk()){
                this.setAnimation(MONSTROSITY_BERSERK);
            }else if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && target != null && target.isAlive()) {
                if (this.isInLava() && this.lavabombmagazine == 0) {
                    this.setAnimation(MONSTROSITY_CHARGE);
                }
                else if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) >= 18F && this.distanceTo(target) < 40F && this.lavabombmagazine > 0 && this.random.nextInt(48) == 0 || this.distanceTo(target) > 4.75F && random.nextFloat() * 100.0F < 0.3F && this.distanceTo(target) < 18F && this.lavabombmagazine > 0) {
                    this.setAnimation(MONSTROSITY_ERUPTIONATTACK);

                }
                else if (!isAiDisabled() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) < 6) {
                    Animation animation = getRandomAttack(random);
                    if (this.isBerserk()) {
                        this.setAnimation(MONSTROSITY_EARTHQUAKE2);
                    } else {
                        this.setAnimation(animation);
                    }
                }
            }
        }

        if (this.getAnimation() == MONSTROSITY_CHARGE) {
            if (this.getAnimationTick() == 34) {
                this.lavabombmagazine = CMConfig.Lavabombmagazine;
                this.doAbsorptionEffects(4,1,4);
                this.playSound(SoundEvents.ITEM_BUCKET_FILL_LAVA, 6f, 0.5F);
                this.heal(15F * (float) CMConfig.MonstrosityHealingMultiplier);
            }
            if (this.getAnimationTick() == 44) {
                this.doAbsorptionEffects(8,2,8);
                this.playSound(SoundEvents.ITEM_BUCKET_FILL_LAVA, 6f, 0.5F);
                this.heal(15F * (float) CMConfig.MonstrosityHealingMultiplier );
            }
            if (this.getAnimationTick() == 54) {
                this.doAbsorptionEffects(16, 4, 16);
                this.playSound(SoundEvents.ITEM_BUCKET_FILL_LAVA, 6f, 0.5F);
                this.heal(15F * (float) CMConfig.MonstrosityHealingMultiplier);

            }
        }
        if (this.getAnimation() == MONSTROSITY_BERSERK) {
            Old_Netherite_Monstrosity_Entity.this.setIsBerserk(true);
            if (this.getAnimationTick() == 20) {
                this.playSound(ModSounds.MONSTROSITYGROWL, 3, 1);
            }
            if (this.getAnimationTick() == 29) {
                berserkBlockBreaking(8,8,8);
                EarthQuake();
                ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 20, 0.3f, 0, 20);
                Makeparticle(4.0f,3.5f);
                Makeparticle(4.0f,-3.5f);
            }
        }
        if (!getWorld().isClient) {
            if (!this.getIsAwaken() && target != null) {
                this.setIsAwaken(true);
            }
        }

        if (!this.isAiDisabled()) {
            float f17 = this.getYaw() * ((float) Math.PI / 180F);
            float pitch = this.getPitch() * ((float) Math.PI / 180F);
            float f3 = MathHelper.sin(f17) * (1 - Math.abs(this.getPitch() / 90F));
            float f18 = MathHelper.cos(f17) * (1 - Math.abs(this.getPitch() / 90F));

            Vec3d[] avector3d = new Vec3d[this.monstrosityParts.length];
            for (int j = 0; j < this.monstrosityParts.length; ++j) {
                avector3d[j] = new Vec3d(this.monstrosityParts[j].getX(), this.monstrosityParts[j].getY(), this.monstrosityParts[j].getZ());
            }
            this.setPartPosition(this.headPart, f3 * -1.65F, pitch + 3F, -f18 * -1.65F);

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

    public boolean isTeammate(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isTeammate(entityIn)) {
            return true;
        } else if (entityIn instanceof Old_Netherite_Monstrosity_Entity) {
            return this.getScoreboardTeam() == null && entityIn.getScoreboardTeam() == null;
        } else {
            return false;
        }
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();
        setVelocity(0, Old_Netherite_Monstrosity_Entity.this.getVelocity().y, 0);
        if (this.deathTime == 68) {
            this.playSound(ModSounds.MONSTROSITYLAND, 1, 1);
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

    private void EarthQuake() {
        this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
        for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(7.0D))) {
            if (!isTeammate(entity) && !(entity instanceof Old_Netherite_Monstrosity_Entity) && entity != this) {
                DamageSource damagesource = this.getDamageSources().mobAttack(this);
                boolean flag = entity.damage(damagesource, (float) ((float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) + Math.min(this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE), entity.getMaxHealth() * CMConfig.MonstrositysHpdamage)));
                if (entity.blockedByShield(damagesource) && entity instanceof PlayerEntity player) {
                    disableShield(player, 120);
                }

                if (flag) {
                    launch(entity, true);
                    if (getIsBerserk()) {
                        entity.setOnFireFor(6);
                    }
                }
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
                this.getWorld().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 35, 0.8f, 0.305f, 0.02f, 1f, 30f, false, RingParticle.EnumRingBehavior.GROW), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
            }else{
                this.getWorld().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 35, 1f, 1f, 1f, 1f, 30f, false, RingParticle.EnumRingBehavior.GROW), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
            }
        }
    }


    private void launch(Entity e, boolean huge) {
        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        float f = huge ? 2F : 0.5F;
        e.addVelocity(d0 / d2 * f, huge ? 0.75D : 0.2F, d1 / d2 * f);
    }


    private void berserkBlockBreaking(int x, int y, int z) {
        int MthX = MathHelper.floor(this.getX());
        int MthY = MathHelper.floor(this.getY());
        int MthZ = MathHelper.floor(this.getZ());
        if (!this.getWorld().isClient) {
            if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                for (int k2 = -x; k2 <= x; ++k2) {
                    for (int l2 = -z; l2 <= z; ++l2) {
                        for (int j = 0; j <= y; ++j) {
                            int i3 = MthX + k2;
                            int k = MthY + j;
                            int l = MthZ + l2;
                            BlockPos blockpos = new BlockPos(i3, k, l);
                            BlockState block = getWorld().getBlockState(blockpos);
                            BlockEntity tileEntity = getWorld().getBlockEntity(blockpos);
                            if (block != Blocks.AIR.getDefaultState() && !block.isIn(ModTag.NETHERITE_MONSTROSITY_IMMUNE)) {
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
        if (this.blockBreakCounter > 0) {
            --this.blockBreakCounter;
            return;
        }
        if(!this.isAiDisabled()) {
            if (!this.getWorld().isClient && this.blockBreakCounter == 0) {
                if (this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                    for (int a = (int) Math.round(this.getBoundingBox().minX); a <= (int) Math.round(this.getBoundingBox().maxX); a++) {
                        for (int b = (int) Math.round(this.getBoundingBox().minY); (b <= (int) Math.round(this.getBoundingBox().maxY) + 1) && (b <= 127); b++) {
                            for (int c = (int) Math.round(this.getBoundingBox().minZ); c <= (int) Math.round(this.getBoundingBox().maxZ); c++) {
                                BlockPos blockpos = new BlockPos(a, b, c);
                                BlockState block = getWorld().getBlockState(blockpos);
                                BlockEntity tileEntity = getWorld().getBlockEntity(blockpos);
                                if (block != Blocks.AIR.getDefaultState() && block.isIn(ModTag.NETHERITE_MONSTROSITY_BREAK)) {
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

    private boolean shouldDropItem(BlockEntity tileEntity) {
        if (tileEntity == null) {
            return random.nextInt(3) + 1 == 3;
        }
        return true;
    }

    public boolean isBerserk() {
        return this.getHealth() <= this.getMaxHealth() / 3.0F;
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

    private void setPartPosition(Old_Netherite_Monstrosity_Part part, double offsetX, double offsetY, double offsetZ) {
        part.setPos(this.getX() + offsetX * part.scale, this.getY() + offsetY * part.scale, this.getZ() + offsetZ * part.scale);
    }

//    @Override
//    public boolean isMultipartEntity() {
//        return true;
//    }

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
        return super.canPlayMusic() && getIsAwaken();
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


    @Nullable
    public Animation getDeathAnimation()
    {
        return MONSTROSITY_DEATH;
    }


    class EarthQuakeGoal extends AnimationGoal<Old_Netherite_Monstrosity_Entity> {

        public EarthQuakeGoal(Old_Netherite_Monstrosity_Entity entity) {
            super(entity);
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == MONSTROSITY_EARTHQUAKE
                    || animation == MONSTROSITY_EARTHQUAKE2
                    || animation == MONSTROSITY_EARTHQUAKE3;
        }

        public void tick() {
            LivingEntity target = Old_Netherite_Monstrosity_Entity.this.getTarget();
            Old_Netherite_Monstrosity_Entity.this.setVelocity(0, Old_Netherite_Monstrosity_Entity.this.getVelocity().y, 0);
                //I wanted to clear this code, but I didn't because I was too lazy.
            if (Old_Netherite_Monstrosity_Entity.this.getAnimation() == MONSTROSITY_EARTHQUAKE) {
                if (Old_Netherite_Monstrosity_Entity.this.getAnimationTick() < 34 && target !=null || Old_Netherite_Monstrosity_Entity.this.getAnimationTick() > 54 && target !=null) {
                    Old_Netherite_Monstrosity_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                    entity.lookAtEntity(target, 30, 30);
                } else {
                    Old_Netherite_Monstrosity_Entity.this.setYaw(Old_Netherite_Monstrosity_Entity.this.prevYaw);
                  //  Netherite_Monstrosity_Entity.this.yBodyRot = Netherite_Monstrosity_Entity.this.yBodyRotO;
                }

            }
            if (Old_Netherite_Monstrosity_Entity.this.getAnimation() == MONSTROSITY_EARTHQUAKE2) {
                if (Old_Netherite_Monstrosity_Entity.this.getAnimationTick() < 24  && target !=null || Old_Netherite_Monstrosity_Entity.this.getAnimationTick() > 44  && target !=null) {
                    Old_Netherite_Monstrosity_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                    entity.lookAtEntity(target, 30, 30);
                } else {
                    Old_Netherite_Monstrosity_Entity.this.setYaw(Old_Netherite_Monstrosity_Entity.this.prevYaw);
                    //Netherite_Monstrosity_Entity.this.yBodyRot = Netherite_Monstrosity_Entity.this.yBodyRotO;
                }

            }

            if (Old_Netherite_Monstrosity_Entity.this.getAnimation() == MONSTROSITY_EARTHQUAKE3) {
                if (Old_Netherite_Monstrosity_Entity.this.getAnimationTick() < 29 && target !=null || Old_Netherite_Monstrosity_Entity.this.getAnimationTick() > 49 && target !=null) {
                    Old_Netherite_Monstrosity_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                    entity.lookAtEntity(target, 30, 30);
                } else {
                    Old_Netherite_Monstrosity_Entity.this.setYaw(Old_Netherite_Monstrosity_Entity.this.prevYaw);
                    //Netherite_Monstrosity_Entity.this.yBodyRot = Netherite_Monstrosity_Entity.this.yBodyRotO;
                }
            }
        }
    }



    class ShootGoal extends SimpleAnimationGoal<Old_Netherite_Monstrosity_Entity> {

        public ShootGoal(Old_Netherite_Monstrosity_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
        }

        public void tick() {
            LivingEntity target = Old_Netherite_Monstrosity_Entity.this.getTarget();
            Old_Netherite_Monstrosity_Entity.this.setVelocity(0, Old_Netherite_Monstrosity_Entity.this.getVelocity().y, 0);
            int lavabombcount = CMConfig.Lavabombamount;


            if(target !=null) {
                Old_Netherite_Monstrosity_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.lookAtEntity(target, 30, 30);
                if (Old_Netherite_Monstrosity_Entity.this.getAnimationTick() == 30) {
                    Old_Netherite_Monstrosity_Entity.this.playSound(ModSounds.MONSTROSITYSHOOT, 3, 0.75f);
                    Old_Netherite_Monstrosity_Entity.this.lavabombmagazine--;
                    for (int i = 0; i < lavabombcount; ++i) {
                        Lava_Bomb_Entity lava = new Lava_Bomb_Entity(ModEntities.LAVA_BOMB, Old_Netherite_Monstrosity_Entity.this.getWorld(), Old_Netherite_Monstrosity_Entity.this);
                        double d0 = target.getX() - Old_Netherite_Monstrosity_Entity.this.headPart.getX();
                        double d1 = target.getBoundingBox().minY + target.getHeight() / 3.0F - lava.getY();
                        double d2 = target.getZ() - Old_Netherite_Monstrosity_Entity.this.headPart.getZ();
                        double d3 = MathHelper.sqrt((float) (d0 * d0 + d2 * d2));
                        lava.setVelocity(d0, d1 + d3 * 0.20000000298023224D, d2, 1.0F, 24 - Old_Netherite_Monstrosity_Entity.this.getWorld().getDifficulty().getId() * 4);
                        Old_Netherite_Monstrosity_Entity.this.getWorld().spawnEntity(lava);
                    }
                }
            }
        }
    }

    class BerserkGoal extends SimpleAnimationGoal<Old_Netherite_Monstrosity_Entity> {

        public BerserkGoal(Old_Netherite_Monstrosity_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
        }

        public void tick() {
            Old_Netherite_Monstrosity_Entity.this.setVelocity(0, Old_Netherite_Monstrosity_Entity.this.getVelocity().y, 0);
            LivingEntity target = Old_Netherite_Monstrosity_Entity.this.getTarget();
            if (target!= null) {
                Old_Netherite_Monstrosity_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.lookAtEntity(target, 30, 30);
            }
        }
    }

    class HealGoal extends SimpleAnimationGoal<Old_Netherite_Monstrosity_Entity> {

        public HealGoal(Old_Netherite_Monstrosity_Entity entity, Animation animation) {
            super(entity, animation);
            this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
        }

        public void tick() {
            LivingEntity target = Old_Netherite_Monstrosity_Entity.this.getTarget();
            Old_Netherite_Monstrosity_Entity.this.setVelocity(0, Old_Netherite_Monstrosity_Entity.this.getVelocity().y, 0);
            if (Old_Netherite_Monstrosity_Entity.this.getAnimation() == MONSTROSITY_CHARGE && target!=null){
                if (Old_Netherite_Monstrosity_Entity.this.getAnimationTick() < 34 || Old_Netherite_Monstrosity_Entity.this.getAnimationTick() > 72) {
                    Old_Netherite_Monstrosity_Entity.this.getLookControl().lookAt(target, 30.0F, 30.0F);
                    entity.lookAtEntity(target, 30, 30);
                } else {
                    Old_Netherite_Monstrosity_Entity.this.setYaw(Old_Netherite_Monstrosity_Entity.this.prevYaw);
                  //  Netherite_Monstrosity_Entity.this.yBodyRot = Netherite_Monstrosity_Entity.this.yBodyRotO;
                }
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
            Old_Netherite_Monstrosity_Entity.this.setVelocity(0, Old_Netherite_Monstrosity_Entity.this.getVelocity().y, 0);
        }
    }

}





