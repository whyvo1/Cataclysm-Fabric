package com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar;

import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Arm;
import net.minecraft.util.math.Box;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class Draugr_Entity extends HostileEntity {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();
    public AnimationState attack2AnimationState = new AnimationState();

    public Draugr_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 5;
    }

    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0F, true));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, SnowGolemEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, false));
    }

    public static DefaultAttributeContainer.Builder draugr() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 28)
                .add(EntityAttributes.GENERIC_ARMOR, 3)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.05);
    }


    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "attack" -> this.attackAnimationState;
            case "attack2" -> this.attack2AnimationState;
            case "idle" -> this.idleAnimationState;
            default -> new AnimationState();
        };
    }

    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
    }



    public void stopAllAnimationStates() {
        this.attackAnimationState.stop();
        this.attack2AnimationState.stop();
    }

    public Arm getMainArm() {
        return Arm.LEFT;
    }

    public void handleStatus(byte p_219360_) {
        if (p_219360_ == 4) {
            if(random.nextBoolean()) {
                this.attackAnimationState.start(this.age);
            }else{
                this.attack2AnimationState.start(this.age);
            }
        } else {
            super.handleStatus(p_219360_);
        }
    }

    public boolean tryAttack(Entity p_219472_) {
        this.getWorld().sendEntityStatus(this, (byte)4);
        return super.tryAttack(p_219472_);
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess p_34088_, LocalDifficulty p_34089_, SpawnReason p_34090_, @Nullable EntityData p_34091_) {
        EntityData spawngroupdata = super.initialize(p_34088_, p_34089_, p_34090_, p_34091_);
        this.equipStack(EquipmentSlot.MAINHAND, this.createSpawnWeapon());
        return spawngroupdata;
    }


    private ItemStack createSpawnWeapon() {
        return this.random.nextBoolean() ? new ItemStack(ModItems.BLACK_STEEL_AXE) : new ItemStack(ModItems.BLACK_STEEL_SWORD);
    }


    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
    }

    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            this.idleAnimationState.setRunning(true, this.age);
        }
    }

    public void tickMovement() {
        super.tickMovement();

    }

    @Override
    protected void dropEquipment(ServerWorld p_348503_, DamageSource p_34697_, boolean p_34699_) {
        super.dropEquipment(p_348503_, p_34697_, p_34699_);
        if (p_34697_.getAttacker() instanceof CreeperEntity creeper && creeper.shouldDropHead()) {
            ItemStack itemstack = new ItemStack(ModItems.DRAUGR_HEAD);
            creeper.onHeadDropped();
            this.dropStack(itemstack);
        }

    }



    public boolean isTeammate(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isTeammate(entityIn)) {
            return true;
        } else if (entityIn.getType().isIn(ModTag.TEAM_MALEDICTUS)) {
            return this.getScoreboardTeam() == null && entityIn.getScoreboardTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.DRAUGR_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.DRAUGR_DEATH;
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.DRAUGR_IDLE;
    }

    protected Box getAttackBox() {
        Box aabb = super.getAttackBox();
        return aabb.contract(0.05, 0.0F, 0.05);
    }

}





