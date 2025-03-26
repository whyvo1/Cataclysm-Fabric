package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.github.l_ender.cataclysm.client.particle.LightningParticle;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.jetbrains.annotations.Nullable;
import java.util.UUID;

public class Abyss_Mine_Entity extends Entity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    private int lifeTicks= 800;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;
    private static final TrackedData<Boolean> ACTIVATE = DataTracker.registerData(Abyss_Mine_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public float activateProgress;
    public float prevactivateProgress;
    public int time;

    public Abyss_Mine_Entity(EntityType<? extends Abyss_Mine_Entity> p_i50170_1_, World p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }

    public Abyss_Mine_Entity(World worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_ ,LivingEntity casterIn) {
        this(ModEntities.ABYSS_MINE, worldIn);
        this.warmupDelayTicks = p_i47276_9_;

        this.setCaster(casterIn);
        this.setYaw(p_i47276_8_ * (180F / (float)Math.PI));
        this.setPosition(x, y, z);
    }

    protected void initDataTracker() {
        this.dataTracker.startTracking(ACTIVATE, Boolean.FALSE);
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

    }

    protected void writeCustomDataToNbt(NbtCompound compound) {
        compound.putInt("Warmup", this.warmupDelayTicks);
        if (this.casterUuid != null) {
            compound.putUuid("Owner", this.casterUuid);
        }

    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        super.tick();
        ++time;
        prevactivateProgress = activateProgress;

        if (isActivate() && this.activateProgress > 0F) {
            this.activateProgress--;
        }

        if (this.getWorld().isClient) {
            if (this.clientSideAttackStarted) {
                --this.lifeTicks;
                if (!isActivate() && this.activateProgress < 10F) {
                    this.activateProgress++;
                }
                for(int i = 0; i < 2; ++i) {
                    double d0 = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getWidth() * 0.5D;
                    double d1 = this.getY() + this.getHeight() * 1/2;
                    double d2 = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getWidth() * 0.5D;
                    double d3 = (this.random.nextGaussian() * 0.3D);
                    double d4 = (this.random.nextGaussian() * 0.3D);
                    double d5 = (this.random.nextGaussian() * 0.3D);
                    this.getWorld().addParticle(new LightningParticle.OrbData(102, 26, 204), d0, d1, d2, d3, d4, d5);
                }

                if (this.lifeTicks == 14) {
                    this.setActivate(true);
                }
            }
        } else if (--this.warmupDelayTicks < 0) {
            if (this.warmupDelayTicks == -10) {
                if(isActivate()) {
                    this.setActivate(false);
                }
            }
            if (this.warmupDelayTicks < -20) {
                for(LivingEntity livingentity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(0.2D, 0.0D, 0.2D))) {
                    this.explode(livingentity);
                }
            }


            if (!this.sentSpikeEvent) {
                this.getWorld().sendEntityStatus(this, (byte)4);
                this.clientSideAttackStarted = true;
                this.sentSpikeEvent = true;
            }

            if (--this.lifeTicks < 0) {
                this.discard();
            }
        }

    }

    public boolean isActivate() {
        return this.dataTracker.get(ACTIVATE);
    }

    public void setActivate(boolean Activate) {
        this.dataTracker.set(ACTIVATE, Activate);
    }

    protected void explode(LivingEntity livingentity) {
        LivingEntity Caster = this.getCaster();
        if(livingentity.isAlive()) {
            if (Caster != null) {
                if (!Caster.isTeammate(livingentity) && livingentity != Caster && livingentity.isAlive()) {
                    this.getWorld().createExplosion(Caster, this.getX(), this.getBodyY(0.0625D), this.getZ(), 1.0f, World.ExplosionSourceType.NONE);
                    livingentity.addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTABYSSAL_FEAR, 200, 0));
                    this.remove(RemovalReason.DISCARDED);
                }
            } else {
                this.getWorld().createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 1.0f, World.ExplosionSourceType.NONE);
                livingentity.addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTABYSSAL_FEAR, 200, 0));
                this.remove(RemovalReason.DISCARDED);
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
        }

    }

    public float getBrightnessAtEyes() {
        return 1.0F;
    }



//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }
}
