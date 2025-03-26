package com.github.l_ender.cataclysm.entity.effect;


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
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;


public class Wall_Watcher_Entity extends Entity {
    static final TrackedData<Integer> TIMER = DataTracker.registerData(Wall_Watcher_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    int effectiveChargeTime;
    double knockbackSpeedIndex;
    float damagePerEffectiveCharge;
    double dx;
    double dz;
    LivingEntity source;
    List<YUnchangedLivingEntity> watchedEntities;


    public Wall_Watcher_Entity(EntityType<? extends Wall_Watcher_Entity> entityTypeIn, World level) {
        super(entityTypeIn, level);
    }

    public Wall_Watcher_Entity(World level, BlockPos pos, int timer, int effectiveChargeTime, double knockbackSpeedIndex, float damagePerEffectiveCharge, double dx, double dz, LivingEntity source) {
        super(ModEntities.WALL_WATCHER, level);
        setPosition(pos.getX(), pos.getY(), pos.getZ());
        dataTracker.set(TIMER, timer);
        this.effectiveChargeTime = effectiveChargeTime;
        this.knockbackSpeedIndex = knockbackSpeedIndex;
        this.damagePerEffectiveCharge = damagePerEffectiveCharge;
        this.dx = dx;
        this.dz = dz;
        this.source = source;
        watchedEntities = new ArrayList<>();
    }

    public void watch(LivingEntity livingEntity) {
        if (livingEntity != null) {
            watchedEntities.add(new YUnchangedLivingEntity(livingEntity));
        }
    }

    public void removeFromWatchList(YUnchangedLivingEntity yUnchangedLivingEntity) {
        if (yUnchangedLivingEntity != null) {
            watchedEntities.remove(yUnchangedLivingEntity);
        }
    }


    @Override
    public void tick() {
        super.tick();
        if (!getWorld().isClient()) {
            int temp = dataTracker.get(TIMER);
            if (watchedEntities != null && source != null) {
                if (!watchedEntities.isEmpty()) {
                    List<YUnchangedLivingEntity> entitiesRemoveFromWatchList = new ArrayList<>();
                    for (YUnchangedLivingEntity entity : watchedEntities) {
                        if (entity.livingEntity.horizontalCollision) {
                            if (!entity.livingEntity.isTeammate(source)) {
                                entity.livingEntity.timeUntilRegen = 0;
                                float realDamageApplied = damagePerEffectiveCharge * effectiveChargeTime + 1;
                                boolean flag = entity.livingEntity.damage(this.getDamageSources().mobProjectile(this, source), realDamageApplied);
                                if (flag) {
                                    entity.livingEntity.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.3F, 1);
                                    entity.livingEntity.addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTSTUN, 50));
                                }
                            }

                            entitiesRemoveFromWatchList.add(entity);
                        } else {
                            entity.setMotion(dx * knockbackSpeedIndex, dz * knockbackSpeedIndex);
                        }
                    }
                    for (YUnchangedLivingEntity remove : entitiesRemoveFromWatchList) {
                        removeFromWatchList(remove);
                    }
                    if (temp - 1 == 0) {
                        watchedEntities.clear();
                        remove(RemovalReason.DISCARDED);
                    } else dataTracker.set(TIMER, temp - 1);
                } else {
                    if (temp - 1 == 0) remove(RemovalReason.DISCARDED);
                    else dataTracker.set(TIMER, temp - 1);
                }
            } else {
                remove(RemovalReason.DISCARDED);
            }
        }
    }

    @Override
    public boolean hasNoGravity() {
        return true;
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound p_20052_) {
        source = null;
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound p_20139_) {

    }


    @Override
    protected void initDataTracker() {
        dataTracker.startTracking(TIMER, 0);
    }


//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }

    public static class YUnchangedLivingEntity {
        LivingEntity livingEntity;
        double Y;

        public YUnchangedLivingEntity(LivingEntity livingEntity) {
            this.livingEntity = livingEntity;
            Y = livingEntity.getY();
        }

        void setMotion(double X, double Z) {
            livingEntity.setVelocity(X, 0, Z);
            livingEntity.setPosition(livingEntity.getX(), Y, livingEntity.getZ());
            livingEntity.velocityModified = true;
        }

    }
}
