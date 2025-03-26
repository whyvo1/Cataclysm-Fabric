package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.github.l_ender.cataclysm.entity.partentity.Cm_Part_Entity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.event.GameEvent;

public class The_Leviathan_Part extends Cm_Part_Entity<The_Leviathan_Entity> {

    private final EntityDimensions size;
    public float scale = 1;

    public The_Leviathan_Part(The_Leviathan_Entity parent, float sizeX, float sizeY) {
        super(parent);
        this.size = EntityDimensions.changing(sizeX, sizeY);
        this.calculateDimensions();
    }

    public The_Leviathan_Part(The_Leviathan_Entity entityCachalotWhale, float sizeX, float sizeY, EntityDimensions size) {
        super(entityCachalotWhale);
        this.size = size;
    }

    @Override
    protected void initDataTracker() {
    }

    @Override
    public void onTrackedDataSet(TrackedData<?> accessor) {

    }

    public EntityGroup getMobType() {
        return EntityGroup.AQUATIC;
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
        boolean flag = this.getParent() != null && this.getParent().attackEntityFromPart(this, source, amount);
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



    public Packet<ClientPlayPacketListener> getAddEntityPacket() {
        throw new UnsupportedOperationException();
    }

    @Override
    public EntityDimensions getDimensions(EntityPose poseIn) {
        return this.size;
    }

}
