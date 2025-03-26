package com.github.l_ender.cataclysm.entity.effect;

import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.UUID;

public class Wither_Smoke_Effect_Entity extends Entity {
    private static final TrackedData<Float> DATA_RADIUS = DataTracker.registerData(Wither_Smoke_Effect_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Boolean> DATA_WAITING = DataTracker.registerData(Wither_Smoke_Effect_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final float MAX_RADIUS = 32.0F;
    private int duration = 600;
    private int waitTime = 20;
    private int durationOnUse;
    private float radiusOnUse;
    private float radiusPerTick;
    @Nullable
    private LivingEntity owner;
    @Nullable
    private UUID ownerUUID;

    public Wither_Smoke_Effect_Entity(EntityType<? extends Wither_Smoke_Effect_Entity> p_19704_, World p_19705_) {
        super(p_19704_, p_19705_);
        this.noClip = true;
        this.setRadius(3.0F);
    }

    public Wither_Smoke_Effect_Entity(World p_19707_, double p_19708_, double p_19709_, double p_19710_) {
        this(ModEntities.WITHER_SMOKE_EFFECT, p_19707_);
        this.setPosition(p_19708_, p_19709_, p_19710_);
    }

    protected void initDataTracker() {
        this.getDataTracker().startTracking(DATA_RADIUS, 0.5F);
        this.getDataTracker().startTracking(DATA_WAITING, false);
    }

    public void setRadius(float p_19713_) {
        if (!this.getWorld().isClient) {
            this.getDataTracker().set(DATA_RADIUS, MathHelper.clamp(p_19713_, 0.0F, 32.0F));
        }

    }

    public void calculateDimensions() {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        super.calculateDimensions();
        this.setPosition(d0, d1, d2);
    }

    public float getRadius() {
        return this.getDataTracker().get(DATA_RADIUS);
    }


    protected void setWaiting(boolean p_19731_) {
        this.getDataTracker().set(DATA_WAITING, p_19731_);
    }

    public boolean isWaiting() {
        return this.getDataTracker().get(DATA_WAITING);
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int p_19735_) {
        this.duration = p_19735_;
    }

    public void tick() {
        super.tick();
        boolean flag = this.isWaiting();
        float f = this.getRadius();
        if (this.getWorld().isClient) {
            if (flag && this.random.nextBoolean()) {
                return;
            }

            int i;
            float f1;
            if (flag) {
                i = 2;
                f1 = 0.2F;
            } else {
                i = MathHelper.ceil((float)Math.PI * f * f);
                f1 = f;
            }

            for(int j = 0; j < 10 + random.nextInt(2); ++j) {
                float f2 = this.random.nextFloat() * ((float)Math.PI * 2F);
                float f3 = MathHelper.sqrt(this.random.nextFloat()) * f1;
                double d0 = this.getX() + (double)(MathHelper.cos(f2) * f3);
                double d2 = this.getY();
                double d4 = this.getZ() + (double)(MathHelper.sin(f2) * f3);

                this.getWorld().addImportantParticle(ParticleTypes.SMOKE, d0, d2, d4, 0.0D, this.random.nextGaussian() * 0.07D, 0.0D);
            }
        } else {
            if (this.age >= this.waitTime + this.duration) {
                this.discard();
                return;
            }

            boolean flag1 = this.age < this.waitTime;
            if (flag != flag1) {
                this.setWaiting(flag1);
            }

            if (flag1) {
                return;
            }

            if (this.radiusPerTick != 0.0F) {
                f += this.radiusPerTick;
                if (f < 0.5F) {
                    this.discard();
                    return;
                }

                this.setRadius(f);
            }

            if (this.age % 5 == 0) {
                for(LivingEntity livingentity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox())) {
                    this.damage(livingentity);
                }
            }
        }
    }

    private void damage(LivingEntity Hitentity) {
        LivingEntity caster = this.getOwner();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != caster) {
            if (this.age % 5 == 0) {
                if (caster == null) {
                    boolean flag = Hitentity.damage(this.getDamageSources().wither(), 3);
                    if(flag){
                        StatusEffectInstance effectinstance = new StatusEffectInstance(StatusEffects.WITHER, 160, 0, false, false, true);
                        Hitentity.addStatusEffect(effectinstance);
                    }
                } else {
                    if (caster.isTeammate(Hitentity)) {
                        return;
                    }
                    boolean flag = Hitentity.damage(this.getDamageSources().indirectMagic(this, caster), 3);
                    if(flag){
                       StatusEffectInstance effectinstance = new StatusEffectInstance(StatusEffects.WITHER, 160, 0, false, false, true);
                       Hitentity.addStatusEffect(effectinstance);
                    }
                }
            }
        }
    }

    public float getRadiusOnUse() {
        return this.radiusOnUse;
    }

    public void setRadiusOnUse(float p_19733_) {
        this.radiusOnUse = p_19733_;
    }

    public float getRadiusPerTick() {
        return this.radiusPerTick;
    }

    public void setRadiusPerTick(float p_19739_) {
        this.radiusPerTick = p_19739_;
    }

    public int getDurationOnUse() {
        return this.durationOnUse;
    }

    public void setDurationOnUse(int p_146786_) {
        this.durationOnUse = p_146786_;
    }

    public int getWaitTime() {
        return this.waitTime;
    }

    public void setWaitTime(int p_19741_) {
        this.waitTime = p_19741_;
    }

    public void setOwner(@Nullable LivingEntity p_19719_) {
        this.owner = p_19719_;
        this.ownerUUID = p_19719_ == null ? null : p_19719_.getUuid();
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.owner == null && this.ownerUUID != null && this.getWorld() instanceof ServerWorld) {
            Entity entity = ((ServerWorld)this.getWorld()).getEntity(this.ownerUUID);
            if (entity instanceof LivingEntity) {
                this.owner = (LivingEntity)entity;
            }
        }

        return this.owner;
    }

    protected void readCustomDataFromNbt(NbtCompound p_19727_) {
        this.age = p_19727_.getInt("Age");
        this.duration = p_19727_.getInt("Duration");
        this.waitTime = p_19727_.getInt("WaitTime");
        this.durationOnUse = p_19727_.getInt("DurationOnUse");
        this.radiusOnUse = p_19727_.getFloat("RadiusOnUse");
        this.radiusPerTick = p_19727_.getFloat("RadiusPerTick");
        this.setRadius(p_19727_.getFloat("Radius"));
        if (p_19727_.containsUuid("Owner")) {
            this.ownerUUID = p_19727_.getUuid("Owner");
        }

    }

    protected void writeCustomDataToNbt(NbtCompound p_19737_) {
        p_19737_.putInt("Age", this.age);
        p_19737_.putInt("Duration", this.duration);
        p_19737_.putInt("WaitTime", this.waitTime);
        p_19737_.putInt("DurationOnUse", this.durationOnUse);
        p_19737_.putFloat("RadiusOnUse", this.radiusOnUse);
        p_19737_.putFloat("RadiusPerTick", this.radiusPerTick);
        p_19737_.putFloat("Radius", this.getRadius());

    }

    public void onTrackedDataSet(TrackedData<?> p_19729_) {
        if (DATA_RADIUS.equals(p_19729_)) {
            this.calculateDimensions();
        }
        super.onTrackedDataSet(p_19729_);
    }


    public PistonBehavior getPistonBehavior() {
        return PistonBehavior.IGNORE;
    }

    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    public EntityDimensions getDimensions(EntityPose p_19721_) {
        return EntityDimensions.changing(this.getRadius() * 2.0F, 0.5F);
    }
}
