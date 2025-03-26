package com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar;

import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar.Goals.Elite_DraugrAttackGoal;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.Utilities;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.CrossbowUser;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Arm;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.EnumSet;


public class Elite_Draugr_Entity extends Internal_Animation_Monster implements CrossbowUser {
    private static final TrackedData<Boolean> IS_CHARGING_CROSSBOW = DataTracker.registerData(Elite_Draugr_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState ReloadAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();
    public AnimationState attack2AnimationState = new AnimationState();
    public AnimationState swingAnimationState = new AnimationState();
    public AnimationState Shoot1AnimationState = new AnimationState();
    public AnimationState Shoot2AnimationState = new AnimationState();

    public Elite_Draugr_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 5;
    }

    protected void initGoals() {
       this.goalSelector.add(1, new CrossBowReloadGoal(this,0,1,1,30,15,12F));
        this.goalSelector.add(0, new ReloadedGoal(this,1,0,20,20F));
        this.goalSelector.add(0, new CrossBowShootGoal(this,0,4,0,23,15,12F));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(4, new Elite_DraugrAttackGoal(this, 1.0D, 12F,true));

        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, SnowGolemEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, false));
    }

    public static DefaultAttributeContainer.Builder elite_draugr() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 30.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.27F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 32)
                .add(EntityAttributes.GENERIC_ARMOR, 3)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.1);
    }

    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }


    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "attack" -> this.attackAnimationState;
            case "attack2" -> this.attack2AnimationState;
            case "re_load" -> this.ReloadAnimationState;
            case "idle" -> this.idleAnimationState;
            case "swing" -> this.swingAnimationState;
            case "shoot" -> this.Shoot1AnimationState;
            case "shoot2" -> this.Shoot2AnimationState;
            default -> new AnimationState();
        };
//        if (input == "attack") {
//            return this.attackAnimationState;
//        } else if (input == "attack2") {
//            return this.attack2AnimationState;
//        } else if (input == "re_load") {
//            return this.ReloadAnimationState;
//        } else if (input == "idle") {
//            return this.idleAnimationState;
//        } else if (input == "swing") {
//            return this.swingAnimationState;
//        } else if (input == "shoot") {
//            return this.Shoot1AnimationState;
//        } else if (input == "shoot2") {
//            return this.Shoot2AnimationState;
//        }else {
//            return new AnimationState();
//        }
    }

    public void onTrackedDataSet(TrackedData<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.ReloadAnimationState.startIfNotRunning(this.age);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.Shoot1AnimationState.startIfNotRunning(this.age);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.swingAnimationState.startIfNotRunning(this.age);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.Shoot2AnimationState.startIfNotRunning(this.age);
                    }
                }
        }

        super.onTrackedDataSet(p_21104_);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(IS_CHARGING_CROSSBOW, false);
    }



    public void stopAllAnimationStates() {
        this.attackAnimationState.stop();
        this.attack2AnimationState.stop();
        this.ReloadAnimationState.stop();
        this.swingAnimationState.stop();
        this.Shoot1AnimationState.stop();
        this.Shoot2AnimationState.stop();
    }

    public Arm getMainArm() {
        return Arm.LEFT;
    }

    public void handleStatus(byte p_219360_) {
        if (p_219360_ == 4) {
            if (random.nextBoolean()) {
                this.attackAnimationState.start(this.age);
            } else {
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
    public EntityData initialize(ServerWorldAccess p_34088_, LocalDifficulty p_34089_, SpawnReason p_34090_, @Nullable EntityData p_34091_, @Nullable NbtCompound p_34092_) {
        EntityData spawngroupdata = super.initialize(p_34088_, p_34089_, p_34090_, p_34091_, p_34092_);
        this.equipStack(EquipmentSlot.MAINHAND, this.createSpawnWeapon());
        return spawngroupdata;
    }


    private ItemStack createSpawnWeapon() {
        return  new ItemStack(Items.CROSSBOW);
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


    public boolean isChargingCrossbow() {
        return this.dataTracker.get(IS_CHARGING_CROSSBOW);
    }

    public void setCharging(boolean p_33302_) {
        this.dataTracker.set(IS_CHARGING_CROSSBOW, p_33302_);
    }


    @Override
    public void shoot(LivingEntity p_32328_, ItemStack p_32329_, ProjectileEntity p_32330_, float p_32331_) {
        this.shoot(this, p_32328_, p_32330_, p_32331_, 1.6F);
    }

    @Override
    public void postShoot() {
        this.despawnCounter = 0;
    }

    @Override
    public void attack(LivingEntity p_33317_, float p_33318_) {
        this.shoot(this, 1.6F);
    }


    private enum CrossbowState {
        UNCHARGED,
        CHARGING,
        CHARGED,
        READY_TO_ATTACK
    }


    static class CrossBowReloadGoal extends Goal {
        protected final Elite_Draugr_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;
        private CrossbowState crossbowState = CrossbowState.UNCHARGED;


        public CrossBowReloadGoal(Elite_Draugr_Entity entity, int getattackstate, int attackstate, int attackendstate,int attackMaxtick,int attackseetick,float attackrange) {
            this.entity = entity;
            this.setControls(EnumSet.of(Control.MOVE,Control.LOOK,Control.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return target != null && this.entity.getRandom().nextFloat() * 100.0F < 22f && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && isHoldingCrossbow() && !this.entity.isChargingCrossbow();
        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
        }

        @Override
        public boolean shouldContinue() {
            return this.entity.getAttackState() == attackstate && this.entity.attackTicks <= attackMaxtick;
        }

        private boolean isHoldingCrossbow() {
            return this.entity.isHolding(is -> is.getItem() instanceof CrossbowItem);
        }


        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.lookAtEntity(target, 30.0F, 30.0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }
            if (entity.attackTicks == 5) {
                this.entity.setCurrentHand(Utilities.getHandPossiblyHolding(this.entity, item -> item instanceof CrossbowItem));

            }
            int i = this.entity.getItemUseTime();
            ItemStack itemstack = this.entity.getActiveItem();
            if (i >= CrossbowItem.getPullTime(itemstack)) {
                this.entity.stopUsingItem();
                this.entity.setCharging(true);
            }

        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }

    }

    static class ReloadedGoal extends Goal {
        protected final Elite_Draugr_Entity entity;
        private final int getattackstate;
        private final int attackendstate;
        private final int attackseetick;
        private final float attackrange;

        public ReloadedGoal(Elite_Draugr_Entity entity, int getattackstate, int attackendstate,int attackseetick,float attackrange) {
            this.entity = entity;
            this.setControls(EnumSet.of(Control.MOVE,Control.LOOK,Control.JUMP));
            this.getattackstate = getattackstate;
            this.attackendstate = attackendstate;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && isHoldingCrossbow() && this.entity.isChargingCrossbow();
        }


        @Override
        public void start() {
            LivingEntity livingentity = this.entity.getTarget();
            boolean flag = true;
            if (livingentity != null) {
                float f = livingentity.getWidth();
                float dis = f * 2.5F * f * 2.5F + livingentity.getWidth();
                double d0 = this.entity.getSquaredDistanceToAttackPosOf(livingentity);
                if (d0 <= dis ) {
                    flag = false;
                }
            }
            if (flag) {
                this.entity.setAttackState(2);
            }else{
                this.entity.setAttackState(3);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
        }

        @Override
        public boolean shouldContinue() {
            return (this.entity.getAttackState() == 2 || this.entity.getAttackState() == 3 ) && this.entity.attackTicks <= 30;
        }

        private boolean isHoldingCrossbow() {
            return this.entity.isHolding(is -> is.getItem() instanceof CrossbowItem);
        }


        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.lookAtEntity(target, 30.0F, 30.0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }
           if(this.entity.getAttackState() == 2) {
               if(target != null && entity.attackTicks == 10) {
                   this.entity.attack(target, 1.0F);
                   ItemStack itemstack1 = this.entity.getStackInHand(Utilities.getHandPossiblyHolding(this.entity, item -> item instanceof CrossbowItem));
                   CrossbowItem.setCharged(itemstack1, false);
                   this.entity.setCharging(false);
               }
           }


            if(this.entity.getAttackState() == 3) {
                if (target != null && entity.attackTicks == 11) {
                    DamageSource damagesource = this.entity.getDamageSources().mobAttack(this.entity);
                    target.damage(damagesource, (float) (this.entity.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)));

                }
            }
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }

        protected double getAttackReachSqr(LivingEntity p_25556_) {
            float f = p_25556_.getWidth();
            return f * 2.5F * f * 2.5F + p_25556_.getWidth();
        }

    }

    static class CrossBowShootGoal extends Goal {
        protected final Elite_Draugr_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;


        public CrossBowShootGoal(Elite_Draugr_Entity entity, int getattackstate, int attackstate, int attackendstate,int attackMaxtick,int attackseetick,float attackrange) {
            this.entity = entity;
            this.setControls(EnumSet.of(Control.MOVE,Control.LOOK,Control.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
        }

        @Override
        public boolean canStart() {
            LivingEntity target = entity.getTarget();
            return target != null && this.entity.getRandom().nextFloat() * 100.0F < 22f  && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && isHoldingCrossbow() && this.entity.isChargingCrossbow();
        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
        }

        @Override
        public boolean shouldContinue() {
            return this.entity.getAttackState() == attackstate && this.entity.attackTicks <= attackMaxtick;
        }

        private boolean isHoldingCrossbow() {
            return this.entity.isHolding(is -> is.getItem() instanceof CrossbowItem);
        }


        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.lookAtEntity(target, 30.0F, 30.0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }
            if(target != null && entity.attackTicks == 11) {
                this.entity.attack(target, 1.0F);
                ItemStack itemstack1 = this.entity.getStackInHand(Utilities.getHandPossiblyHolding(this.entity, item -> item instanceof CrossbowItem));
                CrossbowItem.setCharged(itemstack1, false);
                this.entity.setCharging(false);
            }
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }
    }
    
}





