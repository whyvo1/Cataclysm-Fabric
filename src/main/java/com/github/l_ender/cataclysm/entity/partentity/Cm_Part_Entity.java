package com.github.l_ender.cataclysm.entity.partentity;

import com.github.l_ender.cataclysm.message.MessageCMMultipart;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.Objects;

public abstract class Cm_Part_Entity<T extends Entity & Partable> extends Entity {

    private final T parent;

    protected EntityDimensions realSize = EntityDimensions.fixed(1F, 1F);

    protected int newPosRotationIncrements;
    protected double interpTargetX;
    protected double interpTargetY;
    protected double interpTargetZ;
    protected double interpTargetYaw;
    protected double interpTargetPitch;
    public float renderYawOffset;
    public float prevRenderYawOffset;

    public int deathTime;
    public int hurtTime;
    private EntityDimensions dimensions;
    public Cm_Part_Entity(T parent) {
        super(parent.getType(), parent.getWorld());
        this.parent = parent;
    }

    public T getParent() {
        return this.parent;
    }

    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements) {
        this.interpTargetX = x;
        this.interpTargetY = y;
        this.interpTargetZ = z;
        this.interpTargetYaw = yaw;
        this.interpTargetPitch = pitch;
        this.newPosRotationIncrements = posRotationIncrements;
    }

    @Override
    public void tick() {
        updateLastPos();
        super.tick();
        if (this.newPosRotationIncrements > 0) {
            double d0 = this.getX() + (this.interpTargetX - this.getX()) / (double) this.newPosRotationIncrements;
            double d2 = this.getY() + (this.interpTargetY - this.getY()) / (double) this.newPosRotationIncrements;
            double d4 = this.getZ() + (this.interpTargetZ - this.getZ()) / (double) this.newPosRotationIncrements;
            double d6 = MathHelper.wrapDegrees(this.interpTargetYaw - (double) this.getYaw());
            this.setYaw((float) ((double) this.getYaw() + d6 / (double) this.newPosRotationIncrements));
            this.setPitch((float) ((double) this.getPitch() + (this.interpTargetPitch - (double) this.getPitch()) / (double) this.newPosRotationIncrements));
            --this.newPosRotationIncrements;
            this.setPos(d0, d2, d4);
            this.setRotation(this.getYaw(), this.getPitch());
        }

        while (getYaw() - this.prevYaw < -180F) this.prevYaw -= 360F;
        while (getYaw() - this.prevYaw >= 180F) this.prevYaw += 360F;

        while (this.renderYawOffset - this.prevRenderYawOffset < -180F) this.prevRenderYawOffset -= 360F;
        while (this.renderYawOffset - this.prevRenderYawOffset >= 180F) this.prevRenderYawOffset += 360F;

        while (getPitch() - this.prevPitch < -180F) this.prevPitch -= 360F;
        while (getPitch() - this.prevPitch >= 180F) this.prevPitch += 360F;
    }

    public final void updateLastPos() {
        this.refreshPositionAfterTeleport(this.getX(), this.getY(), this.getZ());
        this.prevYaw = this.getYaw();
        this.prevPitch = this.getPitch();
        this.age++;
    }

    protected void setSize(EntityDimensions size) {
        this.realSize = size;
        this.calculateDimensions();
    }

    @Override
    public boolean isGlowing() {
        return this.parent.isGlowing();
    }

    @Override
    public boolean isInvisible() {
        return this.parent.isInvisible();
    }

    @Override
    public EntityDimensions getDimensions(EntityPose pose) {
        return this.realSize;
    }

    @Override
    public boolean canHit() {
        return true;
    }

    @Override
    public void setId(int id) {
        super.setId(id + 1);
    }

    public MessageCMMultipart.PartDataHolder writeData() {
        return new MessageCMMultipart.PartDataHolder(
                this.getX(),
                this.getY(),
                this.getZ(),
                this.getYaw(),
                this.getPitch(),
                this.dimensions.width(),
                this.dimensions.height(),
                this.dimensions.fixed(),
                getDataTracker().getDirtyEntries());

    }

    public void readData(MessageCMMultipart.PartDataHolder data) {
        Vec3d vec = new Vec3d(data.x(), data.y(), data.z());
        this.setPositionAndRotationDirect(vec.getX(), vec.getY(), vec.getZ(), data.yRot(), data.xRot(), 3);
        final float w = data.width();
        final float h = data.height();
        this.setSize(data.fixed() ? EntityDimensions.fixed(w, h) : EntityDimensions.changing(w, h));
        if (data.data() != null)
            getDataTracker().writeUpdatedEntries(data.data());
        this.calculateDimensions();
    }

    public static void assignPartIDs(Entity parent) {
        Cm_Part_Entity<?>[] parts = ((Partable) parent).getParts();
        for (int i = 0, partsLength = Objects.requireNonNull(parts).length; i < partsLength; i++) {
            Cm_Part_Entity<?> part = parts[i];
            part.setId(parent.getId() + i);
        }
    }
}