package com.github.l_ender.cataclysm.capabilities;

import com.github.l_ender.cataclysm.entity.effect.Wall_Watcher_Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;

import java.util.List;

public class ChargeCapability extends Capability<LivingEntity>{
//    public static Identifier ID = Cataclysm.modIdentifier("charge_cap");

    private boolean charge;
    public int Timer;
    public int effectiveChargeTime;
    public float dx;
    public float dz;
    public float damagePerEffectiveCharge;
    public float knockbackSpeedIndex;

//    public static String NAME = "charge";

    public LivingEntity owner;

    public ChargeCapability(CapabilityType<ChargeCapability, LivingEntity> type, LivingEntity owner) {
        super(type);
        this.owner = owner;
    }

    @Override
    public void tick() {
        if(isCharge()) {
            if (!owner.getWorld().isClient()) {
                int temp = getTimer();
                setTimer(temp - 1);
                //Deal with rocket punch is valid
                if (temp > 0) {
                    //Slightly enlarge player's hitbox
                    Box collideBox = owner.getBoundingBox().expand(0.75f, 0.75f, 0.75f);

                    //Collision Detection
                    List<LivingEntity> checks = owner.getWorld().getNonSpectatingEntities(LivingEntity.class, collideBox);
                    checks.remove(owner);

                    //If any mob is detected
                    if (!checks.isEmpty()) {
                        // spawn an watchEntity to simulate rocket punch effect
                        Wall_Watcher_Entity watchEntity = new Wall_Watcher_Entity(owner.getWorld(), owner.getBlockPos(), temp, effectiveChargeTime,
                                knockbackSpeedIndex, damagePerEffectiveCharge, dx, dz,
                                owner);

                        List<LivingEntity> impact = owner.getWorld().getNonSpectatingEntities(LivingEntity.class, owner.getBoundingBox().expand(3.5f, 0.75f, 3.5f));
                        impact.remove(owner);

                        for (LivingEntity target : impact) {
                            // Deal damage
                            if (!target.isTeammate(owner)) {
                                boolean flag = target.damage(owner.getDamageSources().mobProjectile(owner, owner), damagePerEffectiveCharge * effectiveChargeTime);
                                watchEntity.watch(target);
                                if (flag) {
                                    target.playSound(SoundEvents.BLOCK_ANVIL_LAND, 1.5f, 0.8F);
                                }

                            }
                        }
                        owner.getWorld().spawnEntity(watchEntity);

                        // Player stop moving and clear pocket punch status
                        owner.setVelocity(0, 0, 0);
                        owner.velocityModified = true;
                        setCharge(false);
                    }
                }
                if (owner.horizontalCollision || temp == 0) {
                    setCharge(false);
                }
            }
        }
    }


    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public boolean isCharge() {
        return this.charge;
    }

    public void setdamagePerEffectiveCharge(float damage) {
        this.damagePerEffectiveCharge = damage;
    }

    public float getdamagePerEffectiveCharge() {
        return this.damagePerEffectiveCharge;
    }

    public void setknockbackSpeedIndex(float knockback) {
        this.knockbackSpeedIndex = knockback;
    }

    public float getknockbackSpeedIndex() {
        return knockbackSpeedIndex;
    }

    public void seteffectiveChargeTime(int chargetime) {
        this.effectiveChargeTime = chargetime;
    }

    public int geteffectiveChargeTime() {
        return this.effectiveChargeTime;
    }

    public void setdx(float dx) {
        this.dx = dx;
    }

    public float getdx() {
        return this.dx ;
    }

    public void setdZ(float dz) {
        this.dz = dz;
    }

    public float getdZ() {
        return this.dz ;
    }

    public void setTimer(int timer) {
        this.Timer = timer;
    }

    public int getTimer() {
        return Timer;
    }

    @Override
    public NbtCompound serializeNBT() {
        NbtCompound tag = new NbtCompound();
        tag.putBoolean("isCharge", this.isCharge());
        tag.putInt("ChargeTime", this.geteffectiveChargeTime());
        tag.putFloat("ChargeDamage", this.getdamagePerEffectiveCharge());
        tag.putFloat("KnockbackSpeed", this.getknockbackSpeedIndex());
        tag.putFloat("dx", this.getdx());
        tag.putFloat("dz", this.getdZ());
        tag.putInt("timer", this.getTimer());
        return tag;
    }

    @Override
    public void deserializeNBT(NbtCompound nbt) {
        this.setCharge(nbt.getBoolean("isCharge"));
        this.seteffectiveChargeTime(nbt.getInt("ChargeTime"));
        this.setdamagePerEffectiveCharge(nbt.getFloat("ChargeDamage"));
        this.setknockbackSpeedIndex(nbt.getFloat("KnockbackSpeed"));
        this.setdx(nbt.getFloat("dx"));
        this.setdZ(nbt.getFloat("dz"));
        this.setTimer(nbt.getInt("timer"));
    }

    @Override
    public String getName() {
        return "cataclysm:charge_cap";
    }

    //    public interface IChargeCapability extends INBTSerializable<NbtCompound> {
//
//        void tick(LivingEntity entity);
//
//        void setCharge(boolean getCharge);
//
//        boolean isCharge();
//
//        void setTimer(int timer);
//
//        int getTimer();
//
//        void setdamagePerEffectiveCharge(float damage);
//
//        float getdamagePerEffectiveCharge();
//
//        void setknockbackSpeedIndex(float knockback);
//
//        float getknockbackSpeedIndex();
//
//        void seteffectiveChargeTime(int chargetime);
//
//        int geteffectiveChargeTime();
//
//        void setdx(float dx);
//
//        float getdx();
//
//        void setdZ(float dz);
//
//        float getdZ();
//
//    }
//
//    public static class ChargeCapabilityImp extends Capability<LivingEntity> {
//
//
//
//        public static class ChargeProvider implements ICapabilityProvider, ICapabilitySerializable<NbtCompound> {
//            private final LazyOptional<IChargeCapability> instance = LazyOptional.of(ChargeCapabilityImp::new);
//
//            @Override
//            public NbtCompound serializeNBT() {
//                return instance.orElseThrow(NullPointerException::new).serializeNBT();
//            }
//
//            @Override
//            public void deserializeNBT(NbtCompound nbt) {
//                instance.orElseThrow(NullPointerException::new).deserializeNBT(nbt);
//            }
//
//            @NotNull
//            @Override
//            public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, Direction side) {
//                return ModCapabilities.CHARGE_CAPABILITY.orEmpty(cap, instance.cast());
//            }
//        }
//    }
}
