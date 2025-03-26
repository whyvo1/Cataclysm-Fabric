package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModParticle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.jetbrains.annotations.Nullable;
import java.util.UUID;

public class Flame_Jet_Entity extends Entity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    private int lifeTicks = 22;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;

    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Flame_Jet_Entity.class, TrackedDataHandlerRegistry.FLOAT);

    public Flame_Jet_Entity(EntityType<? extends Flame_Jet_Entity> p_i50170_1_, World p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }


    public Flame_Jet_Entity(World worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, float damage, LivingEntity casterIn) {
        this(ModEntities.FLAME_JET, worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.setDamage(damage);
        this.setYaw(p_i47276_8_ * (180F / (float)Math.PI));
        this.setPosition(x, y, z);
    }

    protected void initDataTracker() {
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

    public void tick() {
        super.tick();

        if (this.getWorld().isClient) {
            if (this.clientSideAttackStarted) {
                --this.lifeTicks;
                if (this.lifeTicks == 14) {
                    double d0 = this.getX();
                    double d1 = this.getY() + 2.0D;
                    double d2 = this.getZ();
                    this.getWorld().addImportantParticle(ModParticle.FLAME_JET, d0, d1, d2, 0, 0, 0);

                }

            }
        } else if (--this.warmupDelayTicks < 0) {
            if (this.warmupDelayTicks == -8) {
                Box aabb = this.getBoundingBox().expand(0.1D);
                Box selection = new Box(aabb.minX, this.getY() - 0.1D, aabb.minZ, aabb.maxX, this.getY() + 3.5D, aabb.maxZ);
                for(LivingEntity livingentity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, selection)) {
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


    private void damage(LivingEntity Hitentity) {
        LivingEntity livingentity = this.getCaster();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != livingentity) {
            if (livingentity == null) {
                Hitentity.damage(this.getDamageSources().magic(), getDamage());
            } else {
                if (livingentity.isTeammate(Hitentity)) {
                    return;
                }
                if(Hitentity.damage(this.getDamageSources().mobProjectile(this,livingentity), getDamage())){
                    Hitentity.setOnFireFor(5);
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
                this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_BLAZE_SHOOT, this.getSoundCategory(), 0.3F, 1.25F, false);
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
