package com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity;

import com.github.l_ender.cataclysm.entity.partentity.Cm_Part_Entity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.nbt.NbtCompound;

public class Netherite_Monstrosity_Part extends Cm_Part_Entity<Netherite_Monstrosity_Entity> {
    public final Netherite_Monstrosity_Entity parentMob;
    private final EntityDimensions size;
    public float scale = 1;

    public Netherite_Monstrosity_Part(Netherite_Monstrosity_Entity parent, float sizeX, float sizeY) {
        super(parent);
        this.size = EntityDimensions.changing(sizeX, sizeY);
        this.parentMob = parent;
        this.calculateDimensions();
    }



    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
    }

    @Override
    public void onTrackedDataSet(TrackedData<?> accessor) {

    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean isPickable() {
        return this.getParent().isAlive();
    }

    @Override
    protected void setSize(EntityDimensions size) {
        super.setSize(size);
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        return !this.isInvulnerableTo(source) && this.parentMob.hurtParts(this, source, amount);
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound compound) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound compound) {

    }

    @Override
    public boolean isPartOf(Entity entity) {
        return this == entity || this.getParent() == entity;
    }

    @Override
    protected void setRotation(float yaw, float pitch) {
        this.setYaw(yaw % 360.0F);
        this.setPitch(pitch % 360.0F);
    }

    @Override
    protected boolean canStartRiding(Entity entityIn) {
        return false;
    }

    @Override
    public boolean canUsePortals(boolean p_352936_) {
        return false;
    }


    @Override
    public EntityDimensions getDimensions(EntityPose poseIn) {
        return this.size;
    }

}
