package com.github.l_ender.cataclysm.entity.effect;


import com.github.l_ender.cataclysm.init.ModEffect;
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
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.UUID;

public class Flame_Strike_Entity extends Entity {
    private static final TrackedData<Float> DATA_RADIUS = DataTracker.registerData(Flame_Strike_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Boolean> DATA_WAITING = DataTracker.registerData(Flame_Strike_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> DATA_SEE = DataTracker.registerData(Flame_Strike_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> SOUL = DataTracker.registerData(Flame_Strike_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Flame_Strike_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Float> HPDAMAGE = DataTracker.registerData(Flame_Strike_Entity.class, TrackedDataHandlerRegistry.FLOAT);

    private static final float MAX_RADIUS = 32.0F;
    private int duration = 600;
    private int waitTime;
    private int warmupDelayTicks;
    @Nullable
    private LivingEntity owner;
    @Nullable
    private UUID ownerUUID;

    public Flame_Strike_Entity(EntityType<? extends Flame_Strike_Entity> p_19704_, World p_19705_) {
        super(p_19704_, p_19705_);
        this.noClip = true;
        this.setRadius(3.0F);
    }

    public Flame_Strike_Entity(World level, double x, double y, double z, float p_i47276_8_, int duration, int wait,int delay, float radius, float damage, float Hpdamage, boolean soul, LivingEntity casterIn) {
        this(ModEntities.FLAME_STRIKE, level);
        this.setOwner(casterIn);
        this.setDuration(duration);
        this.waitTime = wait;
        this.warmupDelayTicks = delay;
        this.setRadius(radius);
        this.setDamage(damage);
        this.setHpDamage(Hpdamage);
        this.setSoul(soul);
        this.setYaw(p_i47276_8_ * (180F / (float)Math.PI));
        this.setPosition(x, y, z);
    }

    protected void initDataTracker(DataTracker.Builder p_326229_) {
        p_326229_.add(DATA_RADIUS, 0.5F);
        p_326229_.add(DAMAGE, 0F);
        p_326229_.add(HPDAMAGE, 0F);
        p_326229_.add(DATA_WAITING, true);
        p_326229_.add(DATA_SEE, false);
        p_326229_.add(SOUL, false);
    }

    public void setRadius(float p_19713_) {
        if (!this.getWorld().isClient) {
            this.getDataTracker().set(DATA_RADIUS, MathHelper.clamp(p_19713_, 0.0F, 32.0F));
        }

    }

    public float getDamage() {
        return dataTracker.get(DAMAGE);
    }

    public void setDamage(float damage) {
        dataTracker.set(DAMAGE, damage);
    }

    public float getHpDamage() {
        return dataTracker.get(HPDAMAGE);
    }

    public void setHpDamage(float damage) {
        dataTracker.set(HPDAMAGE, damage);
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


    protected void setSee(boolean p_19731_) {
        this.getDataTracker().set(DATA_SEE, p_19731_);
    }

    public boolean isSee() {
        return this.getDataTracker().get(DATA_SEE);
    }

    public void setSoul(boolean Soul) {
        this.getDataTracker().set(SOUL, Soul);
    }

    public boolean isSoul() {
        return this.getDataTracker().get(SOUL);
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
            ParticleEffect particleoptions = this.isSoul() ? ParticleTypes.SOUL_FIRE_FLAME : ParticleTypes.FLAME ;
            float f1 = flag ? 0.2F : f;
            double spread = Math.PI * 2 ;
            int arcLen = MathHelper.ceil(this.getRadius() * spread);

            if(!flag) {
                if (this.age % 2 == 0) {
                    for (int j = 0; j < arcLen; ++j) {
                        float f2 = this.random.nextFloat() * ((float) Math.PI * 2F);
                        double d0 = this.getX() + (double) (MathHelper.cos(f2) * f1) * 0.9;
                        double d2 = this.getY();
                        double d4 = this.getZ() + (double) (MathHelper.sin(f2) * f1) * 0.9;
                        this.getWorld().addParticle(particleoptions, d0, d2, d4, random.nextGaussian() * 0.07D, 0.125D * this.getRadius() + 0.4D, random.nextGaussian() * 0.07D);
                    }
                }
                if (this.random.nextInt(24) == 0) {
                    this.getWorld().playSound(this.getX() + 0.5D, this.getY() + 0.5D, this.getZ() + 0.5D, SoundEvents.ENTITY_BLAZE_BURN, this.getSoundCategory(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
                }
            }
        } else {
            if (this.age >= this.waitTime + this.duration + this.warmupDelayTicks) {
                if(this.getRadius() > 0 ){
                    this.setRadius(getRadius() - 0.1F);
                }else{
                    if(!this.isSoul()) {
                        int explosionradius = this.owner instanceof PlayerEntity ? 1 : 2;
                        this.getWorld().createExplosion(this.owner, this.getX(), this.getY(), this.getZ(), explosionradius, World.ExplosionSourceType.NONE);
                    }
                    this.discard();
                }
            }


            if (this.age >= this.warmupDelayTicks) {
                this.setSee(true);
            }


            boolean flag1 = this.age < this.waitTime + this.warmupDelayTicks;
            if (flag != flag1) {
                this.setWaiting(flag1);
            }

            if (flag1) {
                return;
            }

        }

        if(!flag) {
            if (this.age % 5 == 0) {
                for (LivingEntity livingentity : this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox())) {
                    this.damage(livingentity);
                }
            }
        }
    }

    protected void damage(LivingEntity Hitentity) {
        LivingEntity caster = this.getOwner();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != caster) {
            if (this.age % 2 == 0) {
                if (caster == null) {
                    boolean flag = Hitentity.damage(this.getDamageSources().magic(), this.getDamage() + Hitentity.getMaxHealth() * 0.01f * this.getHpDamage());
                    if (flag) {
                        StatusEffectInstance effectinstance1 = Hitentity.getStatusEffect(ModEffect.EFFECTBLAZING_BRAND);
                        int i = 1;
                        if (effectinstance1 != null) {
                            i += effectinstance1.getAmplifier();
                            Hitentity.removeStatusEffectInternal(ModEffect.EFFECTBLAZING_BRAND);
                        } else {
                            --i;
                        }

                        i = MathHelper.clamp(i, 0, 4);
                        StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 200, i, false, false, true);
                        Hitentity.addStatusEffect(effectinstance);
                    }
                } else {
                    if (caster.isTeammate(Hitentity)) {
                        return;
                    }
                    boolean flag = Hitentity.damage(this.getDamageSources().indirectMagic(this, caster), this.getDamage() + Hitentity.getMaxHealth() * 0.01f * this.getHpDamage());
                    if (flag) {
                        StatusEffectInstance effectinstance1 = Hitentity.getStatusEffect(ModEffect.EFFECTBLAZING_BRAND);
                        int i = 1;
                        if (effectinstance1 != null) {
                            i += effectinstance1.getAmplifier();
                            Hitentity.removeStatusEffectInternal(ModEffect.EFFECTBLAZING_BRAND);
                        } else {
                            --i;
                        }

                        i = MathHelper.clamp(i, 0, 4);
                        StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 200, i, false, false, true);
                        Hitentity.addStatusEffect(effectinstance);

                    }
                }
            }
        }
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
        this.warmupDelayTicks = p_19727_.getInt("Delay");
        this.setRadius(p_19727_.getFloat("Radius"));
        if (p_19727_.containsUuid("Owner")) {
            this.ownerUUID = p_19727_.getUuid("Owner");
        }
        setSoul(p_19727_.getBoolean("is_soul"));
        this.setDamage(p_19727_.getFloat("damage"));
        this.setHpDamage(p_19727_.getFloat("Hpdamage"));
    }

    protected void writeCustomDataToNbt(NbtCompound p_19737_) {
        p_19737_.putInt("Age", this.age);
        p_19737_.putInt("Duration", this.duration);
        p_19737_.putInt("WaitTime", this.waitTime);
        p_19737_.putInt("Delay", this.warmupDelayTicks);
        p_19737_.putFloat("Radius", this.getRadius());
        if (this.ownerUUID != null) {
            p_19737_.putUuid("Owner", this.ownerUUID);
        }
        p_19737_.putBoolean("is_soul", isSoul());
        p_19737_.putFloat("damage", this.getDamage());
        p_19737_.putFloat("Hpdamage", this.getHpDamage());

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

    public Packet<ClientPlayPacketListener> createSpawnPacket(EntityTrackerEntry entity) {
        return new EntitySpawnS2CPacket(this,entity);
    }

    public EntityDimensions getDimensions(EntityPose p_19721_) {
        return EntityDimensions.changing(this.getRadius() * 1.8F, this.getRadius() * 3.0F);
    }
}

