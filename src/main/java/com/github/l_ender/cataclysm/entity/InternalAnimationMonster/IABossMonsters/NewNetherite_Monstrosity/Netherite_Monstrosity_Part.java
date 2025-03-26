package com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity;

import com.github.l_ender.cataclysm.entity.partentity.Cm_Part_Entity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.event.GameEvent;

public class Netherite_Monstrosity_Part extends Cm_Part_Entity<Netherite_Monstrosity_Entity> {

    private final EntityDimensions size;
    public float scale = 1;

    public Netherite_Monstrosity_Part(Netherite_Monstrosity_Entity parent, float sizeX, float sizeY) {
        super(parent);
        this.size = EntityDimensions.changing(sizeX, sizeY);
        this.calculateDimensions();
    }

//    public Netherite_Monstrosity_Part(Netherite_Monstrosity_Entity nm, float sizeX, float sizeY, EntityDimensions size) {
//        super(nm);
//        this.size = size;
//    }

    @Override
    protected void initDataTracker() {
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
        boolean flag = this.getParent() != null && this.getParent().attackEntityFromPart(this, source, amount * 1.5F);
        if (flag) {
            this.emitGameEvent(GameEvent.ENTITY_DAMAGE);
        }
        return flag;
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
    public boolean canUsePortals() {
        return false;
    }

//    public Packet<ClientPlayPacketListener> getAddEntityPacket() {
//        throw new UnsupportedOperationException();
//    }

    @Override
    public EntityDimensions getDimensions(EntityPose poseIn) {
        return this.size;
    }

}
