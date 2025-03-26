package com.github.l_ender.cataclysm.entity.etc;

import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.MathHelper;

public class AquaticMoveController extends MoveControl {
    private final PathAwareEntity entity;
    private final float speedMulti;
    private float yawLimit = 3.0F;

    public AquaticMoveController(PathAwareEntity entity, float speedMulti) {
        super(entity);
        this.entity = entity;
        this.speedMulti = speedMulti;
    }

    public AquaticMoveController(PathAwareEntity entity, float speedMulti, float yawLimit) {
        super(entity);
        this.entity = entity;
        this.yawLimit = yawLimit;
        this.speedMulti = speedMulti;
    }

    public void tick() {
        if (this.entity.isTouchingWater()) {
            this.entity.setVelocity(this.entity.getVelocity().add(0.0D, 0.005D, 0.0D));
        }
        if (entity instanceof ISemiAquatic && ((ISemiAquatic) entity).shouldStopMoving()) {
            this.entity.setMovementSpeed(0.0F);
            return;
        }
        if (this.state == State.MOVE_TO && !this.entity.getNavigation().isIdle()) {
            double d0 = this.targetX - this.entity.getX();
            double d1 = this.targetY - this.entity.getY();
            double d2 = this.targetZ - this.entity.getZ();
            double d3 = MathHelper.sqrt((float) (d0 * d0 + d1 * d1 + d2 * d2));
            double d4 = MathHelper.sqrt((float) (d0 * d0 + d2 * d2));
            d1 /= d3;
            float f = (float) (MathHelper.atan2(d2, d0) * 57.2957763671875D) - 90.0F;

            this.entity.setYaw(this.wrapDegrees(this.entity.getYaw(), f, yawLimit));
            this.entity.bodyYaw = this.entity.getYaw();


            float f1 = (float) (this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED) * speedMulti);
            this.entity.setMovementSpeed(f1 * 0.4F);
            this.entity.setVelocity(this.entity.getVelocity().add(0.0D, (double) this.entity.getMovementSpeed() * d1 * 0.6D, 0.0D));
        } else {
            this.entity.setMovementSpeed(0.0F);
        }
    }
}
