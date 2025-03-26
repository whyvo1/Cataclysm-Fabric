package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Wither_Missile_Entity extends ProjectileEntity {
    public double accelerationPower;
    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Wither_Missile_Entity.class, TrackedDataHandlerRegistry.FLOAT);


    public Wither_Missile_Entity(EntityType<? extends Wither_Missile_Entity> type, World level) {
        super(type, level);
        this.accelerationPower = 0.1;
    }

    public Wither_Missile_Entity(EntityType<? extends Wither_Missile_Entity> type, double getX, double gety, double getz, Vec3d vec3, World level) {
        this(type, level);
        this.refreshPositionAndAngles(getX, gety, getz, this.getYaw(), this.getPitch());
        this.refreshPosition();
        this.assignDirectionalMovement(vec3, this.accelerationPower);

    }

    public Wither_Missile_Entity(LivingEntity p_36827_, Vec3d vec3, World p_36831_,float damage) {
        this(ModEntities.WITHER_MISSILE, p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), vec3, p_36831_);
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.setRotation(p_36827_.getYaw(), p_36827_.getPitch());
    }

    public Wither_Missile_Entity(EntityType<? extends Wither_Missile_Entity> type,LivingEntity p_36827_, double getX, double gety, double getz, Vec3d vec3,float damage, World level) {
        this(type, level);
        this.refreshPositionAndAngles(getX, gety, getz, this.getYaw(), this.getPitch());
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.refreshPosition();
        this.assignDirectionalMovement(vec3, this.accelerationPower);

    }


    protected void initDataTracker(DataTracker.Builder p_326229_) {
        p_326229_.add(DAMAGE,0f);
    }


    public float getDamage() {
        return dataTracker.get(DAMAGE);
    }

    public void setDamage(float damage) {
        dataTracker.set(DAMAGE, damage);
    }


    public boolean shouldRender(double p_36837_) {
        double d0 = this.getBoundingBox().getAverageSideLength() * 4.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return p_36837_ < d0 * d0;
    }

    protected RaycastContext.ShapeType getClipType() {
        return RaycastContext.ShapeType.COLLIDER;
    }

    public void tick() {
        Entity entity = this.getOwner();
        if (this.getWorld().isClient || (entity == null || !entity.isRemoved()) && this.getWorld().isChunkLoaded(this.getBlockPos())) {
            super.tick();

            HitResult hitresult = ProjectileUtil.getCollision(this, this::canHit, this.getClipType());
            if (hitresult.getType() != HitResult.Type.MISS) {
                this.hitOrDeflect(hitresult);
            }

            this.checkBlockCollision();
            Vec3d vec3 = this.getVelocity();
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;
            ProjectileUtil.setRotationFromVelocity(this, 0.2F);
            float f = this.getInertia();
            if (this.isTouchingWater()) {
                for(int i = 0; i < 4; ++i) {
                    float f1 = 0.25F;
                    this.getWorld().addParticle(ParticleTypes.BUBBLE, d0 - vec3.x * 0.25D, d1 - vec3.y * 0.25D, d2 - vec3.z * 0.25D, vec3.x, vec3.y, vec3.z);
                }
                f = 0.8F;
            }else{
                this.getWorld().addParticle(ParticleTypes.FLAME, this.getX() - vec3.x, this.getY() - vec3.y + 0.35D, this.getZ() - vec3.z, 0.0D, 0.0D, 0.0D);
            }
            this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX() - vec3.x, this.getY() - vec3.y + 0.35D, this.getZ() - vec3.z, 0.0D, 0.0D, 0.0D);
            this.setVelocity(vec3.add(vec3.normalize().multiply(this.accelerationPower)).multiply(f));
            this.setPosition(d0, d1, d2);
        } else {
            this.discard();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult p_37626_) {
        super.onEntityHit(p_37626_);
        if (this.getWorld() instanceof ServerWorld serverlevel) {
            Entity entity = p_37626_.getEntity();
            boolean flag;
            if (this.getOwner() instanceof LivingEntity livingentity) {
                DamageSource damagesource = this.getDamageSources().mobProjectile(this, livingentity);
                flag = entity.damage(damagesource, this.getDamage());
                if (flag) {
                    if (entity.isAlive()) {
                        EnchantmentHelper.onTargetDamaged(serverlevel, entity, damagesource);
                    } else {
                        livingentity.heal(5.0F);
                        if(livingentity instanceof The_Harbinger_Entity) {
                            livingentity.heal(5.0F * (float) CMConfig.HarbingerHealingMultiplier);
                        }else{
                            livingentity.heal(5.0F);
                        }
                    }
                }
            } else {
                flag = entity.damage(this.getDamageSources().magic(), 5.0F);
            }

            if (flag && entity instanceof LivingEntity livingentity1) {
                int i = 0;
                if (this.getWorld().getDifficulty() == Difficulty.NORMAL) {
                    i = 10;
                } else if (this.getWorld().getDifficulty() == Difficulty.HARD) {
                    i = 15;
                }

                if (i > 0) {
                    livingentity1.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20 * i, 1), this.getEffectCause());
                }
            }
        }
    }


    protected void onCollision(HitResult p_37628_) {
        super.onCollision(p_37628_);
        if (!this.getWorld().isClient) {
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 1.0F, false, World.ExplosionSourceType.NONE);
            this.discard();
        }

    }

    protected boolean canHit(Entity p_36842_) {
        return super.canHit(p_36842_) && !p_36842_.noClip;
    }


    protected float getInertia() {
        return 1.0F;
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putDouble("acceleration_power", this.accelerationPower);
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        if (compound.contains("acceleration_power", 6)) {
            this.accelerationPower = compound.getDouble("acceleration_power");
        }

    }


    public boolean canHit() {
        return false;
    }

    public float getTargetingMargin() {
        return 1.0F;
    }

    public boolean damage(DamageSource p_37616_, float p_37617_) {
        return false;
    }

    public float getBrightnessAtEyes() {
        return 1.0F;
    }

    public Packet<ClientPlayPacketListener> createSpawnPacket(EntityTrackerEntry p_entity) {
        Entity entity = this.getOwner();
        int i = entity == null ? 0 : entity.getId();
        Vec3d vec3 = p_entity.getPos();
        return new EntitySpawnS2CPacket(this.getId(), this.getUuid(), vec3.getX(), vec3.getY(), vec3.getZ(), p_entity.getPitch(), p_entity.getYaw(), this.getType(), i, p_entity.getVelocity(), 0.0F);
    }


    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        Vec3d vec3 = new Vec3d(packet.getVelocityX(), packet.getVelocityY(), packet.getVelocityZ());
        this.setVelocity(vec3);

    }

    private void assignDirectionalMovement(Vec3d movement, double accelerationPower) {
        this.setVelocity(movement.normalize().multiply(accelerationPower));
        this.velocityDirty = true;
    }

    protected void onDeflected(@Nullable Entity entity, boolean deflectedByPlayer) {
        super.onDeflected(entity, deflectedByPlayer);
        if (deflectedByPlayer) {
            this.accelerationPower = 0.1;
        } else {
            this.accelerationPower *= 0.5F;
        }

    }
}


