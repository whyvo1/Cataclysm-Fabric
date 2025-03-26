package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.jetbrains.annotations.Nullable;
import java.util.EnumSet;

public class Nameless_Sorcerer_Entity extends IllagerEntity implements IAnimatedEntity {
    private static final TrackedData<Byte> SPELL = DataTracker.registerData(Nameless_Sorcerer_Entity.class, TrackedDataHandlerRegistry.BYTE);
    protected int spellTicks;
    private SpellType activeSpell = SpellType.NONE;
    private static final TrackedData<Boolean> IS_ILLUSION = DataTracker.registerData(Nameless_Sorcerer_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private int animationTick;
    private Animation currentAnimation;

    public Nameless_Sorcerer_Entity(EntityType entity, World world) {
        super(entity, world);
        this.experiencePoints = 300;
    }

    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new CastingSpellGoal());
        this.goalSelector.add(2, new FleeEntityGoal<>(this, PlayerEntity.class, 8.0F, 0.6D, 1.0D));
        this.goalSelector.add(5, new AttackSpellGoal());
        this.goalSelector.add(6, new TeleportSpellGoal());
        this.goalSelector.add(7, new IllusionSpellGoal());
        this.goalSelector.add(8, new WanderAroundGoal(this, 0.6D));
        this.goalSelector.add(9, new LookAtEntityGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 8.0F));
        this.targetSelector.add(1, (new RevengeGoal(this, RaiderEntity.class)).setGroupRevenge());
        this.targetSelector.add(2, (new ActiveTargetGoal<>(this, PlayerEntity.class, true)).setMaxTimeWithoutVisibility(300));
        this.targetSelector.add(3, (new ActiveTargetGoal<>(this, MerchantEntity.class, false)).setMaxTimeWithoutVisibility(300));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, false));
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION};
    }

    @Override
    public int getAnimationTick() {
        return animationTick;
    }


    @Override
    public void setAnimationTick(int tick) {
        animationTick = tick;
    }

    @Override
    public Animation getAnimation() {
        return currentAnimation;
    }


    @Override
    public void setAnimation(Animation animation) {
        currentAnimation = animation;
    }

    public static DefaultAttributeContainer.Builder nameless_sorcerer() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 24.0D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 50.0D);
    }

    protected boolean canStartRiding(Entity p_31508_) {
        return false;
    }

    public boolean canLead() {
        return false;
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(SPELL, (byte)0);
        this.dataTracker.startTracking(IS_ILLUSION, false);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.spellTicks = compound.getInt("SpellTicks");
        this.setIsIllusion(compound.getBoolean("is_Illusion"));
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putInt("SpellTicks", this.spellTicks);
        compound.putBoolean("is_Illusion", getIsIllusion());
    }

    public boolean isTeammate(Entity p_32665_) {
        if (p_32665_ == null) {
            return false;
        } else if (p_32665_ == this) {
            return true;
        } else if (super.isTeammate(p_32665_)) {
            return true;
        } else if (p_32665_ instanceof VexEntity) {
            return this.isTeammate(((VexEntity)p_32665_).getOwner());
        } else if (p_32665_ instanceof LivingEntity && ((LivingEntity)p_32665_).getGroup() == EntityGroup.ILLAGER) {
            return this.getScoreboardTeam() == null && p_32665_.getScoreboardTeam() == null;
        } else {
            return false;
        }
    }

    public void setIsIllusion(boolean isIllusion) {
        this.dataTracker.set(IS_ILLUSION, isIllusion);
    }

    public boolean getIsIllusion() {
        return this.dataTracker.get(IS_ILLUSION);
    }


    @Environment(EnvType.CLIENT)
    public State getState() {
        if (this.isSpellcasting()) {
            return State.SPELLCASTING;
        } else {
            return this.isCelebrating() ? State.CELEBRATING : State.CROSSED;
        }
    }

    @Override
    public boolean damage(DamageSource source, float damage) {
        if (this.getIsIllusion()) {
            this.playSound(SoundEvents.ENTITY_ILLUSIONER_CAST_SPELL, 1.0f ,0.9f);
            for(int i = 0; i < 20; ++i) {
                double d0 = this.random.nextGaussian() * 0.02D;
                double d1 = this.random.nextGaussian() * 0.02D;
                double d2 = this.random.nextGaussian() * 0.02D;
                this.getWorld().addParticle(ParticleTypes.POOF, this.getParticleX(1.0D), this.getRandomBodyY(), this.getParticleZ(1.0D), d0, d1, d2);
            }
            this.remove(RemovalReason.KILLED);
            return false;
        }
        return super.damage(source, damage);
    }


    public boolean isSpellcasting() {
        if (this.getWorld().isClient) {
            return this.dataTracker.get(SPELL) > 0;
        } else {
            return this.spellTicks > 0;
        }
    }

    public void setSpellType(SpellType spellType) {
        this.activeSpell = spellType;
        this.dataTracker.set(SPELL, (byte)spellType.id);
    }

    protected SpellType getSpellType() {
        return !this.getWorld().isClient ? this.activeSpell : SpellType.getFromId(this.dataTracker.get(SPELL));
    }

    protected void mobTick() {
        super.mobTick();
        if (this.spellTicks > 0) {
            --this.spellTicks;
        }

    }


    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_EVOKER_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_EVOKER_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_EVOKER_HURT;
    }

    public void addBonusForWave(int p_32632_, boolean p_32633_) {
    }

    public SoundEvent getCelebratingSound() {
        return SoundEvents.ENTITY_EVOKER_CELEBRATE;
    }

    protected SoundEvent getSpellSound() {
        return SoundEvents.ENTITY_EVOKER_CAST_SPELL;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        super.tick();
        if (this.getWorld().isClient && this.isSpellcasting()) {
            SpellType Nameless_Sorcerer_Entity$spelltype = this.getSpellType();
            double d0 = getRandom().nextGaussian() * 0.07D;
            double d1 = getRandom().nextGaussian() * 0.07D;
            double d2 = getRandom().nextGaussian() * 0.07D;
            float f = this.bodyYaw * ((float) Math.PI / 180F) + MathHelper.cos((float) this.age * 0.6662F) * 0.25F;
            float f1 = MathHelper.cos(f);
            float f2 = MathHelper.sin(f);
            if (Nameless_Sorcerer_Entity$spelltype == SpellType.TELEPORTSPELL) {
                this.getWorld().addParticle(ParticleTypes.PORTAL, this.getX() + (double) f1 * 0.6D, this.getY() + 1.8D, this.getZ() + (double) f2 * 0.6D, d0, d1, d2);
                this.getWorld().addParticle(ParticleTypes.PORTAL, this.getX() - (double) f1 * 0.6D, this.getY() + 1.8D, this.getZ() - (double) f2 * 0.6D, d0, d1, d2);
            }
            if (Nameless_Sorcerer_Entity$spelltype == SpellType.FANGS) {
                this.getWorld().addParticle(ParticleTypes.CRIT, this.getX() + (double) f1 * 0.6D, this.getY() + 1.8D, this.getZ() + (double) f2 * 0.6D, d0, d1, d2);
                this.getWorld().addParticle(ParticleTypes.CRIT, this.getX() - (double) f1 * 0.6D, this.getY() + 1.8D, this.getZ() - (double) f2 * 0.6D, d0, d1, d2);
            }

            if (Nameless_Sorcerer_Entity$spelltype == SpellType.ILLUSION) {
                this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX() + (double) f1 * 0.6D, this.getY() + 1.8D, this.getZ() + (double) f2 * 0.6D, d0, d1, d2);
                this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX() - (double) f1 * 0.6D, this.getY() + 1.8D, this.getZ() - (double) f2 * 0.6D, d0, d1, d2);
            }
        }

    }

    protected int getSpellTicks() {
        return this.spellTicks;
    }


    public class CastingASpellGoal extends Goal {
        public CastingASpellGoal() {
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canStart() {
            return Nameless_Sorcerer_Entity.this.getSpellTicks() > 0;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void start() {
            super.start();
            Nameless_Sorcerer_Entity.this.navigation.stop();
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void stop() {
            super.stop();
            Nameless_Sorcerer_Entity.this.setSpellType(SpellType.NONE);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            if (Nameless_Sorcerer_Entity.this.getTarget() != null) {
                Nameless_Sorcerer_Entity.this.getLookControl().lookAt(Nameless_Sorcerer_Entity.this.getTarget(), (float)Nameless_Sorcerer_Entity.this.getMaxHeadRotation(), (float)Nameless_Sorcerer_Entity.this.getMaxLookPitchChange());
            }

        }
    }

    public enum SpellType {
        NONE(0),
        TELEPORTSPELL(1),
        FANGS(2),
        WOLOLO(3),
        ILLUSION(4);

        private final int id;


        SpellType(int idIn) {
            this.id = idIn;

        }

        public static SpellType getFromId(int idIn) {
            for(SpellType Nameless_Sorcerer_Entity$spelltype : values()) {
                if (idIn == Nameless_Sorcerer_Entity$spelltype.id) {
                    return Nameless_Sorcerer_Entity$spelltype;
                }
            }

            return NONE;
        }
    }

    public abstract class UseSpellGoal extends Goal {
        protected int spellWarmup;
        protected int spellCooldown;

        protected UseSpellGoal() {
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canStart() {
            LivingEntity livingentity = Nameless_Sorcerer_Entity.this.getTarget();
            if (livingentity != null && livingentity.isAlive()) {
                if (Nameless_Sorcerer_Entity.this.isSpellcasting()) {
                    return false;
                } else {
                    return Nameless_Sorcerer_Entity.this.age >= this.spellCooldown;
                }
            } else {
                return false;
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinue() {
            LivingEntity livingentity = Nameless_Sorcerer_Entity.this.getTarget();
            return livingentity != null && livingentity.isAlive() && this.spellWarmup > 0;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void start() {
            this.spellWarmup = this.getCastWarmupTime();
            Nameless_Sorcerer_Entity.this.spellTicks = this.getCastingTime();
            this.spellCooldown = Nameless_Sorcerer_Entity.this.age + this.getCastingInterval();
            SoundEvent soundevent = this.getSpellPrepareSound();
            if (soundevent != null) {
                Nameless_Sorcerer_Entity.this.playSound(soundevent, 1.0F, 1.0F);
            }

            Nameless_Sorcerer_Entity.this.setSpellType(this.getSpellType());
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            --this.spellWarmup;
            if (this.spellWarmup == 0) {
                this.castSpell();
                Nameless_Sorcerer_Entity.this.playSound(Nameless_Sorcerer_Entity.this.getSpellSound(), 1.0F, 1.0F);
            }

        }

        protected abstract void castSpell();

        protected int getCastWarmupTime() {
            return 20;
        }

        protected abstract int getCastingTime();

        protected abstract int getCastingInterval();

        @Nullable
        protected abstract SoundEvent getSpellPrepareSound();

        protected abstract SpellType getSpellType();
    }

    class AttackSpellGoal extends UseSpellGoal {
        private AttackSpellGoal() {
        }

        protected int getCastingTime() {
            return 20;
        }

        protected int getCastingInterval() {
            return 45;
        }

        protected void castSpell() {
            LivingEntity target = Nameless_Sorcerer_Entity.this.getTarget();
            double d0 = Math.min(target.getY(), Nameless_Sorcerer_Entity.this.getY());
            double d1 = Math.max(target.getY(), Nameless_Sorcerer_Entity.this.getY()) + 1.0D;
            float f = (float) MathHelper.atan2(target.getZ() - Nameless_Sorcerer_Entity.this.getZ(), target.getX() - Nameless_Sorcerer_Entity.this.getX());
            if (Nameless_Sorcerer_Entity.this.squaredDistanceTo(target) < 12.0D) {
                for(int i = 0; i < 5; ++i) {
                    float f1 = f + (float)i * (float)Math.PI * 0.4F;
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double)MathHelper.cos(f1) * 1.5D, Nameless_Sorcerer_Entity.this.getZ() + (double)MathHelper.sin(f1) * 1.5D, d0, d1, f1, 0);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double)MathHelper.cos(f1) * 1.5D, Nameless_Sorcerer_Entity.this.getZ() + (double)MathHelper.sin(f1) * 1.5D, d0, d1, f1, 40);
                }

                for(int k = 0; k < 8; ++k) {
                    float f2 = f + (float)k * (float)Math.PI * 2.0F / 8.0F + ((float) Math.PI * 2F / 5F);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double)MathHelper.cos(f2) * 2.5D, Nameless_Sorcerer_Entity.this.getZ() + (double)MathHelper.sin(f2) * 2.5D, d0, d1, f2, 3);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double)MathHelper.cos(f2) * 2.5D, Nameless_Sorcerer_Entity.this.getZ() + (double)MathHelper.sin(f2) * 2.5D, d0, d1, f2, 37);
                }
                for (int k = 0; k < 13; ++k) {
                    float f3 = f + (float) k * (float) Math.PI * 2.0F / 13.0F + ((float) Math.PI * 2F / 10F);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double) MathHelper.cos(f3) * 3.5D, Nameless_Sorcerer_Entity.this.getZ() + (double) MathHelper.sin(f3) * 3.5D, d0, d1, f3, 10);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double) MathHelper.cos(f3) * 3.5D, Nameless_Sorcerer_Entity.this.getZ() + (double) MathHelper.sin(f3) * 3.5D, d0, d1, f3, 30);
                }
                for (int k = 0; k < 16; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 16.0F + ((float) Math.PI * 2F / 20F);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double) MathHelper.cos(f4) * 4.5D, Nameless_Sorcerer_Entity.this.getZ() + (double) MathHelper.sin(f4) * 4.5D, d0, d1, f4, 15);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double) MathHelper.cos(f4) * 4.5D, Nameless_Sorcerer_Entity.this.getZ() + (double) MathHelper.sin(f4) * 4.5D, d0, d1, f4, 25);
                }
                for (int k = 0; k < 19; ++k) {
                    float f5 = f + (float) k * (float) Math.PI * 2.0F / 19.0F + ((float) Math.PI * 2F / 40F);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double) MathHelper.cos(f5) * 5.5D, Nameless_Sorcerer_Entity.this.getZ() + (double) MathHelper.sin(f5) * 5.5D, d0, d1, f5, 20);
                }

            } else {
                for(int l = 0; l < 16; ++l) {
                    double d2 = 1.25D * (double)(l + 1);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double)MathHelper.cos(f) * d2, Nameless_Sorcerer_Entity.this.getZ() + (double)MathHelper.sin(f) * d2, d0, d1, f, l);
                }
            }
        }

        private void spawnFangs(double p_190876_1_, double p_190876_3_, double p_190876_5_, double p_190876_7_, float p_190876_9_, int p_190876_10_) {
            BlockPos blockpos = BlockPos.ofFloored(p_190876_1_, p_190876_7_, p_190876_3_);
            boolean flag = false;
            double d0 = 0.0D;

            do {
                BlockPos blockpos1 = blockpos.down();
                BlockState blockstate = Nameless_Sorcerer_Entity.this.getWorld().getBlockState(blockpos1);
                if (blockstate.isSideSolidFullSquare(Nameless_Sorcerer_Entity.this.getWorld(), blockpos1, Direction.UP)) {
                    if (!Nameless_Sorcerer_Entity.this.getWorld().isAir(blockpos)) {
                        BlockState blockstate1 = Nameless_Sorcerer_Entity.this.getWorld().getBlockState(blockpos);
                        VoxelShape voxelshape = blockstate1.getCollisionShape(Nameless_Sorcerer_Entity.this.getWorld(), blockpos);
                        if (!voxelshape.isEmpty()) {
                            d0 = voxelshape.getMax(Direction.Axis.Y);
                        }
                    }

                    flag = true;
                    break;
                }

                blockpos = blockpos.down();
            } while(blockpos.getY() >= MathHelper.floor(p_190876_5_) - 1);

            if (flag) {
                Nameless_Sorcerer_Entity.this.getWorld().spawnEntity(new EvokerFangsEntity(Nameless_Sorcerer_Entity.this.getWorld(), p_190876_1_, (double)blockpos.getY() + d0, p_190876_3_, p_190876_9_, p_190876_10_, Nameless_Sorcerer_Entity.this));
            }

        }

        protected SoundEvent getSpellPrepareSound() {
            return SoundEvents.ENTITY_EVOKER_PREPARE_ATTACK;
        }

        protected SpellType getSpellType() {
            return SpellType.FANGS;
        }
    }

    class CastingSpellGoal extends CastingASpellGoal {
        private CastingSpellGoal() {
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            if (Nameless_Sorcerer_Entity.this.getTarget() != null) {
                Nameless_Sorcerer_Entity.this.getLookControl().lookAt(Nameless_Sorcerer_Entity.this.getTarget(), (float) Nameless_Sorcerer_Entity.this.getMaxHeadRotation(), (float) Nameless_Sorcerer_Entity.this.getMaxLookPitchChange());
            }
        }
    }

    class TeleportSpellGoal extends UseSpellGoal {

        private TeleportSpellGoal()
        {
            super();
        }

        public boolean canStart() {
            LivingEntity livingentity = Nameless_Sorcerer_Entity.this.getTarget();
            if (livingentity != null && livingentity.isAlive()) {
                if (Nameless_Sorcerer_Entity.this.getIsIllusion()) {
                    return false;
                }
                if (Nameless_Sorcerer_Entity.this.distanceTo(livingentity) < 6F){
                    return false;
                }
                if (Nameless_Sorcerer_Entity.this.isSpellcasting()) {
                    return false;
                } else {
                    return Nameless_Sorcerer_Entity.this.age >= this.spellCooldown;
                }
            } else {
                return false;
            }
        }

        @Override
        protected int getCastingTime()
        {
            return 60;
        }

        @Override
        protected int getCastingInterval()
        {
            return 300;
        }

        @Override
        protected void castSpell() {

            LivingEntity target = Nameless_Sorcerer_Entity.this.getTarget();

            this.teleportEntity(target);


        }

        public void teleportEntity(LivingEntity target) {
            if (target.hasVehicle()) {
                target.stopRiding();
            }

            double d0 = target.getX();
            double d1 = target.getY();
            double d2 = target.getZ();


            double d3 = Nameless_Sorcerer_Entity.this.getX();
            double d4 = Nameless_Sorcerer_Entity.this.getY();
            double d5 = Nameless_Sorcerer_Entity.this.getZ();
            target.requestTeleport(d3, d4, d5);
            target.playSound(SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, 1.0F, 1.0F);
            target.prevYaw = Nameless_Sorcerer_Entity.this.getYaw();
            target.prevPitch = Nameless_Sorcerer_Entity.this.getPitch();

            Nameless_Sorcerer_Entity.this.requestTeleport(d0, d1, d2);
            Nameless_Sorcerer_Entity.this.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
            Nameless_Sorcerer_Entity.this.prevYaw = target.getYaw();
            Nameless_Sorcerer_Entity.this.prevPitch = target.getPitch();
            //yaw =y
            //pitch = x
        }


        protected SoundEvent getSpellPrepareSound() {
            return SoundEvents.ENTITY_ILLUSIONER_PREPARE_MIRROR;
        }

        @Override
        protected SpellType getSpellType()
        {
            return SpellType.TELEPORTSPELL;
        }
    }

    class IllusionSpellGoal extends UseSpellGoal {

        private IllusionSpellGoal() {
            super();
        }

        public boolean canStart() {
            LivingEntity livingentity = Nameless_Sorcerer_Entity.this.getTarget();
            if (livingentity != null && livingentity.isAlive()) {
                if (Nameless_Sorcerer_Entity.this.getIsIllusion()) {
                    return false;
                }
                if (Nameless_Sorcerer_Entity.this.isSpellcasting()) {
                    return false;
                } else {
                    return Nameless_Sorcerer_Entity.this.age >= this.spellCooldown;
                }
            } else {
                return false;
            }
        }

        @Override
        protected int getCastingTime()
        {
            return 80;
        }

        @Override
        protected int getCastingInterval()
        {
            return 300;
        }

        @Override
        protected void castSpell() {
            ServerWorld serverLevel = (ServerWorld)Nameless_Sorcerer_Entity.this.getWorld();

            for (int i = 0; i < 2; ++i) {
                LivingEntity target = Nameless_Sorcerer_Entity.this.getTarget();
                BlockPos blockpos = Nameless_Sorcerer_Entity.this.getBlockPos().add(-2 + Nameless_Sorcerer_Entity.this.random.nextInt(5), 0, -2 + Nameless_Sorcerer_Entity.this.random.nextInt(5));
                Nameless_Sorcerer_Entity illusion = ModEntities.NAMELESS_SORCERER.create(Nameless_Sorcerer_Entity.this.getWorld());
                illusion.refreshPositionAndAngles(blockpos, 0.0F, 0.0F);
                if(target != null ) {
                    illusion.setTarget(target);
                }
                illusion.initialize(serverLevel, Nameless_Sorcerer_Entity.this.getWorld().getLocalDifficulty(blockpos), SpawnReason.MOB_SUMMONED, null, null);
                illusion.setIsIllusion(true);
                serverLevel.spawnEntityAndPassengers(illusion);

            }
        }


        protected SoundEvent getSpellPrepareSound() {
            return SoundEvents.ENTITY_EVOKER_PREPARE_WOLOLO;
        }

        @Override
        protected SpellType getSpellType()
        {
            return SpellType.ILLUSION;
        }
    }


}

