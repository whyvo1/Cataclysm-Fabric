package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModParticle;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.jetbrains.annotations.Nullable;
import java.util.UUID;

public class Phantom_Halberd_Entity extends Entity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    public int lifeTicks;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;
    private static final TrackedData<Integer> STATE = DataTracker.registerData(Phantom_Halberd_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Phantom_Halberd_Entity.class, TrackedDataHandlerRegistry.FLOAT);

    public AnimationState OneAnimationState = new AnimationState();
    public AnimationState TwospawnAnimationState = new AnimationState();

    public AnimationState ThreespawnAnimationState = new AnimationState();

    public AnimationState FourspawnAnimationState = new AnimationState();

    public Phantom_Halberd_Entity(EntityType<? extends Phantom_Halberd_Entity> p_i50170_1_, World p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }


    public Phantom_Halberd_Entity(World worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, LivingEntity casterIn,float damage) {
        this(ModEntities.PHANTOM_HALBERD, worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.setYaw(p_i47276_8_ * (180F / (float)Math.PI));
        this.setDamage(damage);
        this.setPosition(x, y, z);
    }


    protected void initDataTracker() {
        this.dataTracker.startTracking(STATE,0);
        this.dataTracker.startTracking(DAMAGE,0f);
    }

    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "one" -> this.OneAnimationState;
            case "two" -> this.TwospawnAnimationState;
            case "three" -> this.ThreespawnAnimationState;
            case "four" -> this.FourspawnAnimationState;
            default -> new AnimationState();
        };
//        if (input == "one") {
//            return this.OneAnimationState;
//        } else if (input == "two") {
//            return this.TwospawnAnimationState;
//        } else if (input == "three") {
//            return this.ThreespawnAnimationState;
//        } else if (input == "four") {
//            return this.FourspawnAnimationState;
//        }else {
//            return new AnimationState();
//        }
    }

    public void onTrackedDataSet(TrackedData<?> p_21104_) {
        if (STATE.equals(p_21104_)) {
            if (this.getWorld().isClient)
                switch (this.getState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        stopAllAnimationStates();
                        this.OneAnimationState.startIfNotRunning(this.age);
                    }
                    case 2 -> {
                        stopAllAnimationStates();
                        this.TwospawnAnimationState.startIfNotRunning(this.age);
                    }
                    case 3 -> {
                        stopAllAnimationStates();
                        this.ThreespawnAnimationState.startIfNotRunning(this.age);
                    }
                    case 4 -> {
                        stopAllAnimationStates();
                        this.FourspawnAnimationState.startIfNotRunning(this.age);
                    }

                }
        }

        super.onTrackedDataSet(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.OneAnimationState.stop();
        this.TwospawnAnimationState.stop();
        this.ThreespawnAnimationState.stop();
        this.FourspawnAnimationState.stop();

    }

    public int getState() {
        return dataTracker.get(STATE);
    }

    public void setState(int state) {
        dataTracker.set(STATE, state);
    }


    public float getDamage() {
        return dataTracker.get(DAMAGE);
    }

    public void setDamage(float damage) {
        dataTracker.set(DAMAGE, damage);
    }

    public void setCaster(@Nullable LivingEntity p_190549_1_) {
        this.caster = p_190549_1_;
        this.casterUuid = p_190549_1_ == null ? null : p_190549_1_.getUuid();
    }

    @Nullable
    public LivingEntity getCaster() {
        if (this.caster == null && this.casterUuid != null && this.getWorld() instanceof ServerWorld) {
            Entity entity = ((ServerWorld)this.getWorld()).getEntity(this.casterUuid);
            if (entity instanceof LivingEntity) {
                this.caster = (LivingEntity)entity;
            }
        }

        return this.caster;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readCustomDataFromNbt(NbtCompound compound) {
        this.warmupDelayTicks = compound.getInt("Warmup");
        if (compound.containsUuid("Owner")) {
            this.casterUuid = compound.getUuid("Owner");
        }
        this.setDamage(compound.getFloat("Damage"));

    }

    protected void writeCustomDataToNbt(NbtCompound compound) {
        compound.putInt("Warmup", this.warmupDelayTicks);
        if (this.casterUuid != null) {
            compound.putUuid("Owner", this.casterUuid);
        }
        compound.putFloat("damage", this.getDamage());
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        super.tick();

        if (this.getWorld().isClient) {
            if (this.clientSideAttackStarted) {
                ++this.lifeTicks;
                if (this.lifeTicks < 70 && this.lifeTicks > 22) {
                    if(this.age % 6 == 0) {
                        double d0 = this.getX();
                        double d1 = this.getY() + 0.5D + this.random.nextDouble();
                        double d2 = this.getZ();
                        double d3 = (this.random.nextDouble() * 2.0D - 1.0D) * 0.15D;
                        double d4 = 0.15D + this.random.nextDouble() * 0.15D;
                        double d5 = (this.random.nextDouble() * 2.0D - 1.0D) * 0.15D;
                        this.getWorld().addParticle(ModParticle.CURSED_FLAME, d0, d1 + 0.35D, d2, d3, d4, d5);

                    }
                }

            }
        } else if (--this.warmupDelayTicks < 0) {
            if (this.warmupDelayTicks == -10) {
                if(getState() == 0) {
                    this.setState(1 + random.nextInt(3));
                }
            }
            if (this.warmupDelayTicks < -12 && this.warmupDelayTicks > -34) {
                for(LivingEntity livingentity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox())) {
                    this.damage(livingentity);
                }
            }


            if (!this.sentSpikeEvent) {
                this.getWorld().sendEntityStatus(this, (byte)4);
                this.sentSpikeEvent = true;
            }

            if (++this.lifeTicks > 70) {
                this.discard();
            }
        }

    }


    protected void damage(LivingEntity Hitentity) {
        LivingEntity livingentity = this.getCaster();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != livingentity) {
            if (this.age % 5 == 0) {
                if (livingentity == null) {
                    Hitentity.damage(this.getDamageSources().magic(), getDamage());
                } else {
                    if (livingentity.isTeammate(Hitentity)) {
                        return;
                    }
                    Hitentity.damage(CMDamageTypes.causeMaledictioMagicaeDamage(this,livingentity), getDamage());
                }
            }
        }
    }


    /**
     * Handler for
     */
    @Environment(EnvType.CLIENT)
    public void handleStatus(byte id) {
        super.handleStatus(id);
        if (id == 4) {
            this.clientSideAttackStarted = true;
            if (!this.isSilent()) {
                this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), ModSounds.PHANTOM_SPEAR, this.getSoundCategory(), 0.3F, this.random.nextFloat() * 0.2F + 0.85F, false);
            }
        }

    }


    public float getAnimationProgress(float p_36937_) {
        if (!this.clientSideAttackStarted) {
            return 0.0F;
        } else {
            int i = this.lifeTicks - 2;
            return i <= 0 ? 1.0F : 1.0F - ((float)i - p_36937_) / 20.0F;
        }
    }

//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }
}
