package com.github.l_ender.cataclysm.entity.Pet;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.Pet.AI.TameableAIFollowOwner;
import com.github.l_ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.AnimationHandler;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Bucketable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.goal.AttackWithOwnerGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.TrackOwnerAttackerGoal;
import net.minecraft.entity.ai.goal.UntamedActiveTargetGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.EnumSet;
import java.util.Optional;

public class Modern_Remnant_Entity extends LLibraryAnimationPet implements Bucketable {
    private static final TrackedData<Boolean> FROM_BUCKET = DataTracker.registerData(Modern_Remnant_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public float sitProgress;
    public float prevSitProgress;
    private AttackMode mode = AttackMode.CIRCLE;
    public static final Animation MODERN_REMNANT_BITE = Animation.create(11);

    public Modern_Remnant_Entity(EntityType type, World world) {
        super(type, world);
        this.experiencePoints = 0;
        setConfigattribute(this, CMConfig.ModernRemnantHealthMultiplier, CMConfig.ModernRemnantDamageMultiplier);
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.REMNANT_IDLE;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.REMNANT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.MODERN_REMNANT_DEATH;
    }

    @Override
    public float getSoundPitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 2.0F;
    }

    public static DefaultAttributeContainer.Builder modernremnant() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 150.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5D)
                .add(EntityAttributes.GENERIC_ARMOR, 5D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0D)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4F);
    }

    protected int getNextAirUnderwater(int air) {
        return air;
    }




    protected void initGoals() {
        this.goalSelector.add(0, new SitGoal(this));
        this.goalSelector.add(3, new ModernRemnantAIMelee(this));
        this.goalSelector.add(6, new TameableAIFollowOwner(this, 1.3D, 6.0F, 2.0F, true));
        this.goalSelector.add(6, new TemptGoal(this, 1.0D, Ingredient.ofItems(Items.SNIFFER_EGG), false));
        this.goalSelector.add(7, new WanderAroundGoal(this, 1.0D, 60));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(4, new RevengeGoal(this));
        this.targetSelector.add(5, new UntamedActiveTargetGoal<>(this, LivingEntity.class, false,  ModEntities.buildPredicateFromTag(ModTag.MODERN_REMNANT_TARGET)));


    }


    public void travel(Vec3d vec3d) {
        if (this.isSitting()) {
            if (this.getNavigation().getCurrentPath() != null) {
                this.getNavigation().stop();
            }
            vec3d = Vec3d.ZERO;
        }
        super.travel(vec3d);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.isOf(DamageTypes.IN_WALL) || source.isOf(DamageTypes.FALLING_BLOCK) || super.isInvulnerableTo(source);
    }


    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
        p_326229_.add(FROM_BUCKET, false);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putBoolean("FromBucket", this.isFromBucket());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.setFromBucket(compound.getBoolean("FromBucket"));
    }

    @Override
    public boolean isBreedingItem(ItemStack p_27600_) {
        return p_27600_.isIn(ModTag.BONE_ITEM);
    }

    @Override
    public boolean isFromBucket() {
        return this.dataTracker.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean sit) {
        this.dataTracker.set(FROM_BUCKET, sit);
    }

    @Override
    public void copyDataToStack(@NotNull ItemStack bucket) {
        NbtComponent.set(DataComponentTypes.BUCKET_ENTITY_DATA, bucket, this::writeCustomDataToNbt);
        Bucketable.copyDataToStack(this, bucket);


    }

    @Override
    public void copyDataFromNbt(NbtCompound p_148832_) {
        readCustomDataFromNbt(p_148832_);
        Bucketable.copyDataFromNbt(this, p_148832_);

    }

    @Override
    @NotNull
    public ItemStack getBucketItem() {
        ItemStack stack = new ItemStack(ModItems.MODERN_REMNANT_BUCKET);
        return stack;
    }

    @Override
    public SoundEvent getBucketFillSound() {
        return ModSounds.MODERN_REMNANT_FILL_BUCKET;
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        Item item = itemstack.getItem();
        ActionResult type = super.interactMob(player, hand);
        if (!isTamed() && item == Items.SNIFFER_EGG) {
            this.eat(player, hand, itemstack);
            this.emitGameEvent(GameEvent.EAT);
//            if (!net.neoforged.neoforge.event.EventHooks.onAnimalTame(this, player)) {
            this.setOwner(player);
            this.getWorld().sendEntityStatus(this, (byte) 7);
//            } else {
//                this.getWorld().sendEntityStatus(this, (byte) 6);
//            }
            return ActionResult.SUCCESS;
        }
        if (isTamed() && this.isBreedingItem(itemstack)) {
            if (this.getHealth() < this.getMaxHealth()) {
                this.eat(player, hand, itemstack);
                this.emitGameEvent(GameEvent.EAT);
                this.heal(5);
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;

        }

        if (isTamed()) {
            Optional<ActionResult> result = emptybucketMobPickup(player, hand, this);
            if (result.isPresent()) {
                return result.get();
            }
        }

        ActionResult interactionresult = itemstack.useOnEntity(player, this, hand);
        if (interactionresult != ActionResult.SUCCESS && type != ActionResult.SUCCESS && isTamed() && isOwner(player)) {
            if (!player.isSneaking()) {
                this.setCommand(this.getCommand() + 1);
                if (this.getCommand() == 3) {
                    this.setCommand(0);
                }
                player.sendMessage(Text.translatable("entity.cataclysm.all.command_" + this.getCommand(), this.getName()), true);
                boolean sit = this.getCommand() == 2;
                if (sit) {
                    this.setSitting(true);
                    return ActionResult.SUCCESS;
                } else {
                    this.setSitting(false);
                    return ActionResult.SUCCESS;
                }
            }
        }
        return type;
    }

    private static <T extends LivingEntity & Bucketable> Optional<ActionResult> emptybucketMobPickup(PlayerEntity p_148829_, Hand p_148830_, T p_148831_) {
        ItemStack itemstack = p_148829_.getStackInHand(p_148830_);
        if (itemstack.getItem() == Items.BUCKET && p_148831_.isAlive()) {
            p_148831_.playSound(p_148831_.getBucketFillSound(), 1.0F, 1.0F);
            ItemStack itemstack1 = p_148831_.getBucketItem();
            p_148831_.copyDataToStack(itemstack1);
            ItemStack itemstack2 = ItemUsage.exchangeStack(itemstack, p_148829_, itemstack1, false);
            p_148829_.setStackInHand(p_148830_, itemstack2);
            World level = p_148831_.getWorld();
            if (!level.isClient) {
                Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity)p_148829_, itemstack1);
            }

            p_148831_.discard();
            return Optional.of(ActionResult.success(level.isClient));
        } else {
            return Optional.empty();
        }
    }

    public void tickMovement() {
        super.tickMovement();
        if (this.isSitting() && this.getNavigation().isIdle()) {
            this.getNavigation().stop();
        }
        this.prevSitProgress = sitProgress;
        if (this.isSitting() && sitProgress < 10) {
            this.sitProgress ++;
        }
        if (!this.isSitting() && sitProgress > 0) {
            this.sitProgress --;
        }

        if (this.getAnimation() == MODERN_REMNANT_BITE) {
            if (this.getAnimationTick() == 3) {
                this.playSound(ModSounds.MODERN_REMNANT_BITE, 0.5f, 2.0f);
            }
        }

        AnimationHandler.INSTANCE.updateAnimations(this);
    }

    @Override
    protected BodyControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    public boolean isTeammate(Entity entityIn) {
        if (this.isTamed()) {
            LivingEntity livingentity = this.getOwner();
            if (entityIn == livingentity) {
                return true;
            }
            if (entityIn instanceof TameableEntity) {
                return ((TameableEntity) entityIn).isOwner(livingentity);
            }
            if (livingentity != null) {
                return livingentity.isTeammate(entityIn);
            }
        }

        return super.isTeammate(entityIn);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld serverWorld, PassiveEntity ageableEntity) {
        return null;
    }

    @Override
    public boolean shouldFollow() {
        return this.getCommand() == 1;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION,MODERN_REMNANT_BITE};
    }

    private enum AttackMode {
        CIRCLE,
        MELEE
    }
    class ModernRemnantAIMelee extends Goal {
        private final Modern_Remnant_Entity mob;
        private LivingEntity target;
        private int circlingTime = 0;
        private int maxcirclingTime = 0;
        private float circleDistance = 13;
        private boolean clockwise = false;
        private float MeleeModeTime = 0;
        private static final int MELEE_MODE_TIME = 120;


        public ModernRemnantAIMelee(Modern_Remnant_Entity mob) {
            this.mob = mob;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }

        public boolean canStart() {
            this.target = this.mob.getTarget();
            return this.target != null && target.isAlive();
        }

        public boolean shouldContinue() {
            this.target = this.mob.getTarget();
            return this.target != null;
        }

        public void start() {
            this.mob.mode = AttackMode.CIRCLE;
            circlingTime = 0;
            maxcirclingTime = 120 + this.mob.random.nextInt(40);
            circleDistance = 8 + this.mob.random.nextInt(4);
            clockwise = this.mob.random.nextBoolean();
            MeleeModeTime = 0;
            this.mob.setAttacking(true);
        }

        public void stop() {
            this.mob.mode = AttackMode.CIRCLE;
            circlingTime = 0;
            maxcirclingTime = 120 + this.mob.random.nextInt(40);
            circleDistance = 8 + this.mob.random.nextInt(4);
            clockwise = this.mob.random.nextBoolean();
            this.target = this.mob.getTarget();
            if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(target)) {
                this.mob.setTarget(null);
            }
            MeleeModeTime = 0;
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
                    if (circlingTime >= maxcirclingTime) {
                        this.mob.mode = AttackMode.MELEE;
                    }
                    if (target.distanceTo(this.mob) < 5) {
                        this.mob.mode = AttackMode.MELEE;
                    }
                } else if (this.mob.mode == AttackMode.MELEE) {
                    MeleeModeTime++;
                    this.mob.getNavigation().startMovingTo(target, 1.0D);
                    this.mob.getLookControl().lookAt(target, 30, 30);
                    if(MeleeModeTime >= MELEE_MODE_TIME) {
                        start();
                    }else if (this.mob.squaredDistanceTo(target) <= 4D && this.mob.getAnimation() == NO_ANIMATION) {
                        this.mob.setAnimation(MODERN_REMNANT_BITE);
                    }
                }

                if (this.mob.getAnimation() == MODERN_REMNANT_BITE) {
                    if (this.mob.getAnimationTick() == 5) {
                        if (this.mob.distanceTo(target) < this.mob.getWidth() * 2.5F * this.mob.getWidth() * 2.5F + target.getWidth()) {
                            float damage = (float) this.mob.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                            target.damage(getDamageSources().mobAttack(this.mob), damage);
                        }
                    }
                }

            }

        }
    }

}
