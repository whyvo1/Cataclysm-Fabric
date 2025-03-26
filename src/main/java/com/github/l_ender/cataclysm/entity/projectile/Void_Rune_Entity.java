package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.jetbrains.annotations.Nullable;
import java.util.UUID;

public class Void_Rune_Entity extends Entity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    private int lifeTicks = 34;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;
    private static final TrackedData<Boolean> ACTIVATE = DataTracker.registerData(Void_Rune_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Void_Rune_Entity.class, TrackedDataHandlerRegistry.FLOAT);

    public float activateProgress;
    public float prevactivateProgress;

    public Void_Rune_Entity(EntityType<? extends Void_Rune_Entity> p_i50170_1_, World p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }


    public Void_Rune_Entity(World worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_,float damage, LivingEntity casterIn) {
        this(ModEntities.VOID_RUNE, worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.setDamage(damage);
        this.setYaw(p_i47276_8_ * (180F / (float)Math.PI));
        this.setPosition(x, y, z);
    }

    protected void initDataTracker() {
        this.dataTracker.startTracking(ACTIVATE, Boolean.FALSE);
        this.dataTracker.startTracking(DAMAGE, 0F);
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
        this.setDamage(compound.getFloat("damage"));
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
                if (this.lifeTicks == 33) {
                    for(int i = 0; i < 80; ++i) {
                        BlockState block = getWorld().getBlockState(getBlockPos().down());
                        double d0 = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getWidth() * 0.5D;
                        double d1 = this.getY() + 0.03D;
                        double d2 = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getWidth() * 0.5D;
                        double d3 = (this.random.nextGaussian() * 0.07D);
                        double d4 = (this.random.nextGaussian() * 0.07D);
                        double d5 = (this.random.nextGaussian() * 0.07D);
                        if (block.getRenderType() != BlockRenderType.INVISIBLE) {
                            this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, block), d0, d1, d2, d3, d4, d5);
                        }
                    }
                }

                if (this.lifeTicks == 14) {
                    this.setActivate(true);
                    for(int i = 0; i < 12; ++i) {
                        double d0 = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * (double)this.getWidth() * 0.5D;
                        double d1 = this.getY() + 0.05D + this.random.nextDouble();
                        double d2 = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * (double)this.getWidth() * 0.5D;
                        double d3 = (this.random.nextDouble() * 2.0D - 1.0D) * 0.3D;
                        double d4 = 0.3D + this.random.nextDouble() * 0.3D;
                        double d5 = (this.random.nextDouble() * 2.0D - 1.0D) * 0.3D;
                        this.getWorld().addParticle(ParticleTypes.REVERSE_PORTAL, d0, d1, d2, d3, d4, d5);
                    }
                }
            }
        } else if (--this.warmupDelayTicks < 0) {
            if (this.warmupDelayTicks == -10) {
                if(isActivate()) {
                    this.setActivate(false);
                }
            }
            if (this.warmupDelayTicks < -10 && this.warmupDelayTicks > -30) {
                for(LivingEntity livingentity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand(0.2D, 0.0D, 0.2D))) {
                    this.damage(livingentity);
                }
            }


            if (!this.sentSpikeEvent) {
                this.getWorld().sendEntityStatus(this, (byte)4);
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

    private void damage(LivingEntity Hitentity) {
        LivingEntity livingentity = this.getCaster();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != livingentity) {
            if (this.age % 5 == 0) {
                if (livingentity == null) {
                    Hitentity.damage(this.getDamageSources().magic(), this.getDamage());
                } else {
                    if (livingentity.isTeammate(Hitentity)) {
                        return;
                    }
                    Hitentity.damage(this.getDamageSources().indirectMagic(this, livingentity), this.getDamage());
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
                this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), ModSounds.VOID_RUNE_RISING, this.getSoundCategory(), 0.5F, this.random.nextFloat() * 0.2F + 0.85F, false);
            }
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
