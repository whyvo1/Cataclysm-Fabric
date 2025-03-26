package com.github.l_ender.cataclysm.entity.Pet;


import com.github.l_ender.cataclysm.entity.etc.IFollower;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;

import java.util.UUID;

public class AnimationPet extends TameableEntity implements IFollower {
    private static final TrackedData<Boolean> SITTING = DataTracker.registerData(AnimationPet.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final TrackedData<Integer> COMMAND = DataTracker.registerData(AnimationPet.class, TrackedDataHandlerRegistry.INTEGER);

    public AnimationPet(EntityType entity, World world) {
        super(entity, world);

    }



    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(COMMAND, 0);
        this.dataTracker.startTracking(SITTING, Boolean.FALSE);
    }

    public int getCommand() {
        return this.dataTracker.get(COMMAND);
    }

    public void setCommand(int command) {
        this.dataTracker.set(COMMAND, command);
    }

    public boolean isSitting() {
        return this.dataTracker.get(SITTING);
    }

    public void setSitting(boolean sit) {
        this.dataTracker.set(SITTING, sit);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putBoolean("CmPetSitting", this.isSitting());
        compound.putInt("Command", this.getCommand());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.setSitting(compound.getBoolean("CmPetSitting"));
        this.setCommand(compound.getInt("Command"));
    }

    public static void setConfigattribute(LivingEntity entity, double hpconfig, double dmgconfig) {
        EntityAttributeInstance maxHealthAttr = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (maxHealthAttr != null) {
            double difference = maxHealthAttr.getBaseValue() * hpconfig - maxHealthAttr.getBaseValue();
            maxHealthAttr.addTemporaryModifier(new EntityAttributeModifier(UUID.fromString("36b1441b-4dd7-4ba3-90a0-0618bb37dede"), "Health config multiplier", difference, EntityAttributeModifier.Operation.ADDITION));
            entity.setHealth(entity.getMaxHealth());
        }
        EntityAttributeInstance attackDamageAttr = entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (attackDamageAttr != null) {
            double difference = attackDamageAttr.getBaseValue() * dmgconfig - attackDamageAttr.getBaseValue();
            attackDamageAttr.addTemporaryModifier(new EntityAttributeModifier(UUID.fromString("6920e51b-c80a-4482-831c-f630a35fa2d7"), "Attack config multiplier", difference, EntityAttributeModifier.Operation.ADDITION));

        }
    }

    public boolean canImmediatelyDespawn(double p_21542_) {
        return false;
    }



    public void circleEntity(LivingEntity target, float radius, float speed, boolean direction, int circleFrame, float offset, float moveSpeedMultiplier) {
        int directionInt = direction ? 1 : -1;
        double t = directionInt * circleFrame * 0.5 * speed / radius + offset;
        Vec3d movePos = target.getPos().add(radius * Math.cos(t), 0, radius * Math.sin(t));
        this.getNavigation().startMovingTo(movePos.x, movePos.y, movePos.z, speed * moveSpeedMultiplier);
    }

    @Override
    public boolean shouldFollow() {
        return false;
    }

    @Override
    public PassiveEntity createChild(ServerWorld p_146743_, PassiveEntity p_146744_) {
        return null;
    }

    @Override
    public EntityView method_48926() {
        return this.getWorld();
    }
}
