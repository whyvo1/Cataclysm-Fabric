package com.github.l_ender.cataclysm.entity.Deepling;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.world.data.CMWorldData;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import org.jetbrains.annotations.Nullable;
import java.util.EnumSet;

public class Deepling_Priest_Entity extends AbstractDeepling {
    boolean searchingForLand;
    public static final Animation DEEPLING_MELEE = Animation.create(20);
    public static final Animation DEEPLING_BLIND = Animation.create(57);

    private int lightcooldown = 200;
    public static final int LIGHT_COOLDOWN = 200;
    private static final EntityDimensions SWIMMING_SIZE = new EntityDimensions(1.15f, 0.6F, false);

    public Deepling_Priest_Entity(EntityType entity, World world) {
        super(entity, world);
        switchNavigator(false);
        this.experiencePoints = 10;

    }

    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(2, new DeeplingLightGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
        this.goalSelector.add(3, new AnimationMeleeAttackGoal(this, 1.0f, false));
    }

    public static DefaultAttributeContainer.Builder deeplingpriest() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.27F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 45)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.25);
    }


    protected void initDataTracker() {
        super.initDataTracker();
    }

    protected EntityNavigation createNavigation(World worldIn) {
        return new SwimNavigation(this, worldIn);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);

    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
    }

    protected void initEquipment(Random p_219154_, LocalDifficulty p_219155_) {
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModItems.ATHAME));
        this.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0.0F);
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.DEEPLING_IDLE;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.DEEPLING_HURT;
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.DEEPLING_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(ModSounds.DEEPLING_IDLE, 0.15F, 0.6F);
    }

    public boolean canSpawn(WorldAccess worldIn, SpawnReason spawnReasonIn) {
        if (ModEntities.rollSpawn(CMConfig.DeeplingPriestSpawnRolls, this.getRandom(), spawnReasonIn) && worldIn instanceof ServerWorld serverLevel ) {
            CMWorldData data = CMWorldData.get(serverLevel,World.OVERWORLD);
            return data != null && data.isLeviathanDefeatedOnce();
        }
        return false;

    }

    @Nullable
    public EntityData initialize(ServerWorldAccess p_34088_, LocalDifficulty p_34089_, SpawnReason p_34090_, @Nullable EntityData p_34091_, @Nullable NbtCompound p_34092_) {
        EntityData spawngroupdata = super.initialize(p_34088_, p_34089_, p_34090_, p_34091_, p_34092_);
        Random randomsource = p_34088_.getRandom();
        this.initEquipment(randomsource, p_34089_);
        return spawngroupdata;
    }

    public boolean canSpawn(WorldView p_32829_) {
        return p_32829_.doesNotIntersectEntities(this);
    }


    public static boolean candeeplingSpawn(EntityType<Deepling_Priest_Entity> p_223364_0_, WorldAccess p_223364_1_, SpawnReason reason, BlockPos p_223364_3_, Random p_223364_4_) {
        return p_223364_1_.getDifficulty() != Difficulty.PEACEFUL && (reason == SpawnReason.SPAWNER || p_223364_1_.getFluidState(p_223364_3_).isIn(FluidTags.WATER));
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, DEEPLING_MELEE,DEEPLING_BLIND};
    }

    private boolean isEntityLookingAt(LivingEntity looker, LivingEntity seen, double degree) {
        degree *= 1 + (looker.distanceTo(seen) * 0.1);
        Vec3d Vector3d = looker.getRotationVec(1.0F).normalize();
        Vec3d Vector3d1 = new Vec3d(seen.getX() - looker.getX(), seen.getBoundingBox().minY + (double) seen.getStandingEyeHeight() - (looker.getY() + (double) looker.getStandingEyeHeight()), seen.getZ() - looker.getZ());
        double d0 = Vector3d1.length();
        Vector3d1 = Vector3d1.normalize();
        double d1 = Vector3d.dotProduct(Vector3d1);
        return d1 > 1.0D - degree / d0 && (looker.canSee(seen));
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity target = this.getTarget();
        if (lightcooldown > 0) {
            lightcooldown--;
        }
        if(this.isAlive()) {
            if (this.getAnimation() == DEEPLING_MELEE) {
                if (this.getAnimationTick() == 5) {
                    this.playSound(ModSounds.DEEPLING_SWING, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
                    if (target != null) {
                        if (this.distanceTo(target) < 3.0F) {
                            float damage = (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                            target.damage(getDamageSources().mobAttack(this), damage);
                        }
                    }
                }
            }
            if (this.getAnimation() == DEEPLING_BLIND) {
                if (this.getAnimationTick() == 18){
                    this.playSound(ModSounds.DEEPLING_LIGHT, 0.2F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
                }
                if (this.getAnimationTick() >18 && this.getAnimationTick() <47) {
                    for (LivingEntity entity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(7.0D))) {
                        if (!isTeammate(entity) && entity != this && isEntityLookingAt(entity, this, 0.6)) {
                            boolean flag = entity.damage(getDamageSources().indirectMagic(this,this), (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * 0.7F);

                            if(flag){
                                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 80));
                            }
                        }
                    }


                }
            }

        }
    }

    protected float getActiveEyeHeight(EntityPose poseIn, EntityDimensions sizeIn) {
        return sizeIn.height * 0.9F;
    }

    boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        } else {
            LivingEntity livingentity = this.getTarget();
            return livingentity != null && livingentity.isTouchingWater();
        }
    }

    public EntityDimensions getSwimmingSize() {
        return SWIMMING_SIZE;
    }

    public void travel(Vec3d p_32394_) {
        if (this.canMoveVoluntarily() && this.isTouchingWater() && this.wantsToSwim()) {
            this.updateVelocity(0.01F, p_32394_);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9D));
        } else {
            super.travel(p_32394_);
        }

    }

    static class DeeplingLightGoal extends Goal {
        private final Deepling_Priest_Entity angler;

        public DeeplingLightGoal(Deepling_Priest_Entity angler) {
            this.angler = angler;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }

        public boolean canStart() {
            LivingEntity target = this.angler.getTarget();
            return this.angler.lightcooldown <= 0 && this.angler.getAnimation() == NO_ANIMATION && target != null && this.angler.squaredDistanceTo(target) <= 64.0D && target.isAlive() && this.angler.getRandom().nextFloat() * 100.0F < 12f;
        }

        public void start() {
            super.start();
            this.angler.setAnimation(DEEPLING_BLIND);
            this.angler.lightcooldown = LIGHT_COOLDOWN;
            this.angler.navigation.stop();
        }

        public void stop() {
            super.stop();
        }
    }

    static class AnimationMeleeAttackGoal extends MeleeAttackGoal {
        protected final Deepling_Priest_Entity mob;


        public AnimationMeleeAttackGoal(Deepling_Priest_Entity p_25552_, double p_25553_, boolean p_25554_) {
            super(p_25552_,p_25553_,p_25554_);
            this.mob = p_25552_;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }


        protected void attack(LivingEntity p_25557_, double p_25558_) {
            double d0 = this.getSquaredMaxAttackDistance(p_25557_);
            if (p_25558_ <= d0 && this.mob.getAnimation() == NO_ANIMATION) {
                this.mob.setAnimation(DEEPLING_MELEE);
            }

        }
    }

}
