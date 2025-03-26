package com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar;

import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar.Goals.Royal_DraugrAttackGoal;
import com.github.l_ender.cataclysm.entity.etc.IShieldEntity;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class Royal_Draugr_Entity extends HostileEntity implements IShieldEntity {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();
    public AnimationState attack2AnimationState = new AnimationState();
    private int shieldCooldownTime = 0;


    public Royal_Draugr_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 7;
    }

    protected void initGoals() {
        this.goalSelector.add(1, new Royal_DraugrAttackGoal(this, 1.0D, true));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, SnowGolemEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, false));
    }

    public static DefaultAttributeContainer.Builder royal_draugr() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.27F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30)
                .add(EntityAttributes.GENERIC_ARMOR, 5)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.1);
    }

    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }


    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "attack" -> this.attackAnimationState;
            case "attack2" -> this.attack2AnimationState;
            case "idle" -> this.idleAnimationState;
            default -> new AnimationState();
        };
//        if (input == "attack") {
//            return this.attackAnimationState;
//        } else if (input == "attack2") {
//            return this.attack2AnimationState;
//        } else if (input == "idle") {
//            return this.idleAnimationState;
//        }else {
//            return new AnimationState();
//        }
    }


    @Override
    public boolean damage(DamageSource source, float damage) {
        Entity entity = source.getSource();
        if (damage > 0.0F && canBlockDamageSource(source)) {
            this.damageShield(damage);
            if (!source.isIn(DamageTypeTags.IS_PROJECTILE)) {
                if (entity instanceof LivingEntity) {
                    this.takeShieldHit((LivingEntity) entity);
                }
            }
            this.playSound(SoundEvents.ITEM_SHIELD_BLOCK, 1.0F, 0.8F + this.getWorld().random.nextFloat() * 0.4F);
            return false;
        }
        return super.damage(source, damage);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Override
    public int getShieldCooldownTime() {
        return this.shieldCooldownTime;
    }

    @Override
    public void setShieldCooldownTime(int shieldCooldownTime) {
        this.shieldCooldownTime = shieldCooldownTime;
    }

    @Override
    public boolean isShieldDisabled() {
        return this.shieldCooldownTime > 0;
    }

    @Override
    public void disableShield(boolean guaranteeDisable) {
        float f = 0.25F + (float) EnchantmentHelper.getEfficiency(this) * 0.05F;
        if (guaranteeDisable) {
            f += 0.75F;
        }
        if (this.random.nextFloat() < f) {
            this.shieldCooldownTime = 100;
            this.clearActiveItem();
            this.getWorld().sendEntityStatus(this, (byte) 30);
            this.playSound(SoundEvents.ITEM_SHIELD_BREAK, 0.8F, 0.8F + this.getWorld().random.nextFloat() * 0.4F);
        }
    }

    public void damageShield(float p_36383_) {
        if (this.activeItemStack.isIn(ConventionalItemTags.SHIELDS)) {
            if (p_36383_ >= 3.0F) {
                int i = 1 + MathHelper.floor(p_36383_);
                Hand interactionhand = this.getActiveHand();
                this.activeItemStack.damage(i, this, (p_219739_) -> p_219739_.sendToolBreakStatus(interactionhand));
                if (this.activeItemStack.isEmpty()) {
                    this.clearActiveItem();
                    if (interactionhand == Hand.MAIN_HAND) {
                        this.equipStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                    } else {
                        this.equipStack(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                    }

                    this.activeItemStack = ItemStack.EMPTY;
                    this.playSound(SoundEvents.ITEM_SHIELD_BREAK, 0.8F, 0.8F + this.getWorld().random.nextFloat() * 0.4F);
                }
            }

        }
    }

    public boolean isBlocking() {
        return false;
    }

    protected void takeShieldHit(LivingEntity p_36295_) {
        super.takeShieldHit(p_36295_);
        if (p_36295_.disablesShield()) {
            this.disableShield(true);
        }

    }

    public boolean isDraugrBlocking() {
        if (this.isUsingItem() && !this.activeItemStack.isEmpty()) {
            Item item = this.activeItemStack.getItem();
            if (!(this.activeItemStack.isIn(ConventionalItemTags.SHIELDS))) {
                return false;
            } else {
                return item.getMaxUseTime(this.activeItemStack) - this.itemUseTimeLeft >= 5;
            }
        } else {
            return false;
        }
    }

    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        Entity entity = damageSourceIn.getSource();
        boolean flag = false;
        if (entity instanceof PersistentProjectileEntity abstractarrow) {
            if (abstractarrow.getPierceLevel() > 0) {
                flag = true;
            }
        }
        if (!damageSourceIn.isIn(DamageTypeTags.BYPASSES_SHIELD) && this.isDraugrBlocking() && !flag) {
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
        if(this.isDraugrBlocking()){
            this.clearActiveItem();
            this.setShieldCooldownTime(30);
        }
        return super.tryAttack(p_219472_);
    }

    protected void dropEquipment(DamageSource p_33574_, int p_33575_, boolean p_33576_) {
        super.dropEquipment(p_33574_, p_33575_, p_33576_);
        Entity entity = p_33574_.getAttacker();
        if (entity instanceof CreeperEntity creeper) {
            if (creeper.shouldDropHead()) {
                creeper.onHeadDropped();
                this.dropItem(ModItems.DRAUGR_HEAD);
            }
        }

    }

    @Nullable
    public EntityData initialize(ServerWorldAccess p_34088_, LocalDifficulty p_34089_, SpawnReason p_34090_, @Nullable EntityData p_34091_, @Nullable NbtCompound p_34092_) {
        EntityData spawngroupdata = super.initialize(p_34088_, p_34089_, p_34090_, p_34091_, p_34092_);
        Random randomsource = p_34088_.getRandom();
        this.initEquipment(randomsource, p_34089_);
        this.updateEnchantments(randomsource, p_34089_);
        this.equipStack(EquipmentSlot.OFFHAND, this.createSpawnShiled());
        return spawngroupdata;
    }

    protected void initEquipment(Random p_219059_, LocalDifficulty p_219060_) {
        this.equipStack(EquipmentSlot.MAINHAND, this.createSpawnWeapon());
    }

    private ItemStack createSpawnWeapon() {
        return this.random.nextBoolean() ? new ItemStack(ModItems.BLACK_STEEL_AXE) : new ItemStack(ModItems.BLACK_STEEL_SWORD);
    }

    private ItemStack createSpawnShiled() {
        return new ItemStack(ModItems.BLACK_STEEL_TARGE);
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
        if (this.shieldCooldownTime > 0) {
            --this.shieldCooldownTime;
        }
    }

    public void tickMovement() {
        super.tickMovement();

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

    @Override
    public void takeKnockback(double strength, double x, double z) {
        if(this.isDraugrBlocking()) {
            return;
        }
        super.takeKnockback(strength, x, z);
    }
}





