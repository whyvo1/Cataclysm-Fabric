package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.entity.effect.Wither_Smoke_Effect_Entity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class Wither_Howitzer_Entity extends ThrownEntity {

    private static final TrackedData<Float> RADIUS = DataTracker.registerData(Wither_Howitzer_Entity.class, TrackedDataHandlerRegistry.FLOAT);

    public Wither_Howitzer_Entity(EntityType<Wither_Howitzer_Entity> type, World world) {
        super(type, world);
    }

    public Wither_Howitzer_Entity(EntityType<Wither_Howitzer_Entity> type, World world, LivingEntity thrower) {
        super(type, thrower, world);
    }

    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(RADIUS,0.5F);
    }


    public void setRadius(float p_19713_) {
        if (!this.getWorld().isClient) {
            this.getDataTracker().set(RADIUS, MathHelper.clamp(p_19713_, 0.0F, 32.0F));
        }
    }

    public float getRadius() {
        return this.getDataTracker().get(RADIUS);
    }

    protected void onEntityHit(EntityHitResult p_37626_) {
        super.onEntityHit(p_37626_);
        if (!this.getWorld().isClient) {
            Entity entity = p_37626_.getEntity();
            Entity entity1 = this.getOwner();
            boolean flag;
            if (entity1 instanceof LivingEntity livingentity) {
                flag = entity.damage(this.getDamageSources().mobProjectile(this, livingentity), (float) CMConfig.WitherHowizterdamage);
                if (flag) {
                    if (entity.isAlive()) {
                        this.applyDamageEffects(livingentity, entity);
                    } else {
                        if(entity1 instanceof The_Harbinger_Entity) {
                            livingentity.heal(5.0F * (float) CMConfig.HarbingerHealingMultiplier);
                        }else{
                            livingentity.heal(5.0F);
                        }
                    }
                }
            } else {
                flag = entity.damage(this.getDamageSources().magic(), 5.0F);
            }

            if (flag && entity instanceof LivingEntity) {
                int i = 10;
                if (this.getWorld().getDifficulty() == Difficulty.NORMAL) {
                    i = 20;
                } else if (this.getWorld().getDifficulty() == Difficulty.HARD) {
                    i = 30;
                }

                ((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20 * i, 1), this.getEffectCause());
            }

        }
    }

    protected void onCollision(HitResult p_37628_) {
        super.onCollision(p_37628_);
        if (!this.getWorld().isClient) {
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 2.0F, false, World.ExplosionSourceType.NONE);
            Wither_Smoke_Effect_Entity areaeffectcloud = new Wither_Smoke_Effect_Entity(this.getWorld(), this.getX(), this.getY(), this.getZ());
            areaeffectcloud.setRadius(this.getRadius());
            LivingEntity entity1 = (LivingEntity) this.getOwner();
            areaeffectcloud.setOwner(entity1);
            areaeffectcloud.setRadiusOnUse(-0.5F);
            areaeffectcloud.setWaitTime(10);
            areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
            areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());
            this.getWorld().spawnEntity(areaeffectcloud);
            ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 40, 0.05f, 0, 20);
            this.discard();
        }
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putFloat("radius", getRadius());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.setRadius(compound.getFloat("radius"));
    }


    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient) {
            Vec3d vec3 = this.getVelocity();
            getWorld().addParticle(ParticleTypes.FLAME, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0, 0, 0);
            getWorld().addParticle(ParticleTypes.SMOKE, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0, 0, 0);
        }

    }


    @Override
    protected float getGravity() {
        return 0.03F;
    }

//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }
}
