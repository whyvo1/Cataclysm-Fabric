package com.github.l_ender.cataclysm.entity.AI;

import com.github.l_ender.cataclysm.entity.etc.ISemiAquatic;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.MathHelper;

public class AnimalSwimMoveControllerSink extends MoveControl {
    private final PathAwareEntity entity;
    private float speedMulti;
    private float ySpeedMod = 1;
    private float yawLimit = 10.0F;

    public AnimalSwimMoveControllerSink(PathAwareEntity entity, float speedMulti, float ySpeedMod) {
        super(entity);
        this.entity = entity;
        this.speedMulti = speedMulti;
        this.ySpeedMod = ySpeedMod;
    }

    public AnimalSwimMoveControllerSink(PathAwareEntity entity, float speedMulti, float ySpeedMod, float yawLimit) {
        super(entity);
        this.entity = entity;
        this.speedMulti = speedMulti;
        this.ySpeedMod = ySpeedMod;
        this.yawLimit = yawLimit;
    }

    public void tick() {
        if (entity instanceof ISemiAquatic && ((ISemiAquatic) entity).shouldStopMoving()) {
            this.entity.setMovementSpeed(0.0F);
            return;
        }
        if (this.state == State.MOVE_TO && !this.entity.getNavigation().isIdle()) {
            double lvt_1_1_ = this.targetX - this.entity.getX();
            double lvt_3_1_ = this.targetY - this.entity.getY();
            double lvt_5_1_ = this.targetZ - this.entity.getZ();
            double lvt_7_1_ = lvt_1_1_ * lvt_1_1_ + lvt_3_1_ * lvt_3_1_ + lvt_5_1_ * lvt_5_1_;
            if (lvt_7_1_ < 2.500000277905201E-7D) {
                this.entity.setForwardSpeed(0.0F);
            } else {
                float lvt_9_1_ = (float) (MathHelper.atan2(lvt_5_1_, lvt_1_1_) * 57.2957763671875D) - 90.0F;
                this.entity.setYaw(this.wrapDegrees(this.entity.getYaw(), lvt_9_1_, yawLimit));
                this.entity.bodyYaw = this.entity.getYaw();
                this.entity.headYaw = this.entity.getYaw();
                float lvt_10_1_ = (float) (this.speed * speedMulti * 3 * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
                if (this.entity.isTouchingWater()) {
                    if(lvt_3_1_ > 0 && entity.horizontalCollision){
                        this.entity.setVelocity(this.entity.getVelocity().add(0.0D, 0.08F, 0.0D));
                    }else{
                        this.entity.setVelocity(this.entity.getVelocity().add(0.0D, (double) this.entity.getMovementSpeed() * lvt_3_1_ * 0.6D * ySpeedMod, 0.0D));
                    }
                    this.entity.setMovementSpeed(lvt_10_1_ * 0.02F);
                    float lvt_11_1_ = -((float) (MathHelper.atan2(lvt_3_1_, MathHelper.sqrt((float) (lvt_1_1_ * lvt_1_1_ + lvt_5_1_ * lvt_5_1_))) * 57.2957763671875D));
                    lvt_11_1_ = MathHelper.clamp(MathHelper.wrapDegrees(lvt_11_1_), -85.0F, 85.0F);
                    this.entity.setPitch(this.wrapDegrees(this.entity.getPitch(), lvt_11_1_, 5.0F));
                    float lvt_12_1_ = MathHelper.cos(this.entity.getPitch() * 0.017453292F);
                    float lvt_13_1_ = MathHelper.sin(this.entity.getPitch() * 0.017453292F);
                    this.entity.forwardSpeed = lvt_12_1_ * lvt_10_1_;
                    this.entity.upwardSpeed = -lvt_13_1_ * lvt_10_1_;
                } else {
                    this.entity.setMovementSpeed(lvt_10_1_ * 0.1F);
                }

            }
        } else {
            this.entity.setMovementSpeed(0.0F);
            this.entity.setSidewaysSpeed(0.0F);
            this.entity.setUpwardSpeed(0.0F);
            this.entity.setForwardSpeed(0.0F);
        }
    }
}
