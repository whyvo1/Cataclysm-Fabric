package com.github.l_ender.cataclysm.entity.AnimationMonster;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.projectile.Poison_Dart_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.AnimationHandler;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;


import org.jetbrains.annotations.Nullable;
import java.util.EnumSet;
import java.util.Optional;


public class Koboleton_Entity extends Animation_Monster {

    public static final Animation COBOLETON_ATTACK = Animation.create(19);

    public float angryProgress;
    public float prevangryProgress;

    public Koboleton_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 8;
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, COBOLETON_ATTACK};
    }

    protected void initGoals() {
        this.goalSelector.add(2, new AnimationMeleeAttackGoal(this,1.0D,false));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D, 80));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
    }

    public static DefaultAttributeContainer.Builder koboleton() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 15.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 25)
                .add(EntityAttributes.GENERIC_ARMOR, 0)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.25F)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.25);
    }


    @Override
    public boolean damage(DamageSource source, float damage) {
        Entity entity = source.getSource();
        if (entity instanceof Poison_Dart_Entity) {
            return false;
        }
        return super.damage(source, damage);
    }



    protected int getNextAirUnderwater(int air) {
        return air;
    }




    protected SoundEvent getAmbientSound() {
        return ModSounds.KOBOLETON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.KOBOLETON_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.KOBOLETON_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(ModSounds.KOBOLETON_STEP, 0.15F, 0.6F);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
    }


    protected void initEquipment(Random p_219154_, LocalDifficulty p_219155_) {
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.KHOPESH));
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess p_34088_, LocalDifficulty p_34089_, SpawnReason p_34090_, @Nullable EntityData p_34091_) {
        EntityData spawngroupdata = super.initialize(p_34088_, p_34089_, p_34090_, p_34091_);
        Random randomsource = p_34088_.getRandom();
        this.initEquipment(randomsource, p_34089_);
        return spawngroupdata;
    }


    public void tick() {
        super.tick();
        AnimationHandler.INSTANCE.updateAnimations(this);
        prevangryProgress = angryProgress;
        if (this.isAttacking() && angryProgress < 10F) {
            angryProgress++;
        }
        if (!this.isAttacking() && angryProgress > 0F) {
            angryProgress--;
        }
        LivingEntity target = this.getTarget();
        if(this.isAlive()) {
            if (this.getAnimation() == COBOLETON_ATTACK) {
                if (this.getAnimationTick() == 11) {
                    this.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
                    if (target != null) {
                        if (this.distanceTo(target) < this.getWidth() * 2.5F * this.getWidth() * 2.5F + target.getWidth()) {
                            float damage = (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                            target.damage(getDamageSources().mobAttack(this), damage);

                            ItemStack offhand = target.getOffHandStack();
                            ItemStack mainhand = target.getMainHandStack();
//                            Optional<SlotResult> slot = CuriosApi.getCuriosHelper().findFirstCurio(target, stack -> stack.is(ModItems.STICKY_GLOVES.get()));
                            Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(target);
                            boolean bl = component.isPresent() && component.get().isEquipped(ModItems.STICKY_GLOVES);
                            if(this.random.nextFloat() * 100.0F <= CMConfig.CauseKoboletontoDropItemInHandPercent) {
                                if (bl) {
                                    if (!offhand.isEmpty()) {
                                        if (!offhand.isIn(ModTag.STICKY_ITEM)) {
                                            int i = offhand.getCount();
                                            this.koboletonstealdrop(offhand.copyWithCount(1), target);
                                            target.equipStack(EquipmentSlot.OFFHAND, offhand.split(i - 1));
                                        }
                                    } else {
                                        if (!mainhand.isEmpty()) {
                                            if (!mainhand.isIn(ModTag.STICKY_ITEM)) {
                                                int i = mainhand.getCount();
                                                this.koboletonstealdrop(mainhand.copyWithCount(1), target);
                                                target.equipStack(EquipmentSlot.MAINHAND, mainhand.split(i - 1));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private ItemEntity koboletonstealdrop(ItemStack p_36179_, LivingEntity target) {
        if (p_36179_.isEmpty()) {
            return null;
        } else if (this.getWorld().isClient) {
            return null;
        } else {
            double d0 = target.getEyeY() - (double)0.3F;
            ItemEntity itementity = new ItemEntity(target.getWorld(), target.getX(), d0, target.getZ(), p_36179_);
            itementity.setToDefaultPickupDelay();
            itementity.setCovetedItem();
            float f8 = MathHelper.sin(target.getPitch() * ((float)Math.PI / 180F));
            float f2 = MathHelper.cos(target.getPitch() * ((float)Math.PI / 180F));
            float f3 = MathHelper.sin(target.getYaw() * ((float)Math.PI / 180F));
            float f4 = MathHelper.cos(target.getYaw() * ((float)Math.PI / 180F));
            float f5 = target.getRandom().nextFloat() * ((float)Math.PI * 2F);
            float f6 = 0.02F * target.getRandom().nextFloat();
            itementity.setVelocity((double)(-f3 * f2 * 0.3F) + Math.cos(f5) * (double)f6, -f8 * 0.3F + 0.1F + (target.getRandom().nextFloat() - target.getRandom().nextFloat()) * 0.1F, (double)(f4 * f2 * 0.3F) + Math.sin(f5) * (double)f6);
            this.getWorld().spawnEntity(itementity);
            return itementity;
        }

    }

    public boolean canSpawn(WorldAccess worldIn, SpawnReason spawnReasonIn) {
        return ModEntities.rollSpawn(CMConfig.KoboletonSpawnRolls, this.getRandom(), spawnReasonIn);
    }

    public static boolean checkKoboletonSpawnRules(EntityType<Koboleton_Entity> husk, ServerWorldAccess level, SpawnReason spawnType, BlockPos pos, Random random) {
        return canSpawnInDark(husk, level, spawnType, pos, random) && (SpawnReason.isAnySpawner(spawnType) || level.isSkyVisible(pos));
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


    static class AnimationMeleeAttackGoal extends MeleeAttackGoal {
        protected final Koboleton_Entity mob;


        public AnimationMeleeAttackGoal(Koboleton_Entity p_25552_, double p_25553_, boolean p_25554_) {
            super(p_25552_,p_25553_,p_25554_);
            this.mob = p_25552_;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }


        protected double getAttackReachSqr(LivingEntity p_25556_) {
            return this.mob.getWidth() * 2.5F * this.mob.getWidth() * 2.5F + p_25556_.getWidth();
        }


        protected void attack(LivingEntity p_25557_) {
            if (this.canAttack(p_25557_)) {
                if (this.mob.getAnimation() == NO_ANIMATION) {
                    this.mob.setAnimation(COBOLETON_ATTACK);
                }
            }

        }
    }
}





