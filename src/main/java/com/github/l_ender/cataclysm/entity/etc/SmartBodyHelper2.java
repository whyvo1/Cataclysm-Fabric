package com.github.l_ender.cataclysm.entity.etc;

import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.MathHelper;

public class SmartBodyHelper2 extends BodyControl {
    private final MobEntity mob;
    private static final float MAX_ROTATE = 75;
    private int rotationTickCounter;
    private static final int HISTORY_SIZE = 10;
    private float prevRenderYawHead;
    private final double[] histPosX = new double[HISTORY_SIZE];

    private final double[] histPosZ = new double[HISTORY_SIZE];

    public SmartBodyHelper2(MobEntity mob) {
        super(mob);
        this.mob = mob;
    }

    @Override
    public void tick() {
        for (int i = histPosX.length - 1; i > 0; i--) {
            histPosX[i] = histPosX[i - 1];
            histPosZ[i] = histPosZ[i - 1];
        }

        if (this.hasMoved()) {
            this.mob.bodyYaw = this.mob.getYaw();
            this.func_220664_c();
            this.prevRenderYawHead = this.mob.headYaw;
            this.rotationTickCounter = 0;
        } else {
            if (this.noMobPassengers()) {
                if (Math.abs(this.mob.headYaw - this.prevRenderYawHead) > 15.0F) {
                    this.rotationTickCounter = 0;
                    this.prevRenderYawHead = this.mob.headYaw;
                    this.func_220663_b();
                } else {
                    float limit = MAX_ROTATE;
                    ++this.rotationTickCounter;
                    final int speed = 10;
                    if (this.rotationTickCounter > speed) {
                        limit = Math.max(1 - (rotationTickCounter - speed) / (float) speed, 0) * MAX_ROTATE;
                    }

                    mob.bodyYaw = approach(mob.headYaw, mob.bodyYaw, limit);// https://gist.github.com/TheGreyGhost/b5ea2acd1c651a2d6350#file-gistfile1-txt-L60
                }
            }
        }
    }

    private void func_220663_b() {
        this.mob.bodyYaw = MathHelper.clampAngle(this.mob.bodyYaw, this.mob.headYaw, (float)this.mob.getMaxHeadRotation());
    }

    private void func_220664_c() {
        this.mob.headYaw = MathHelper.clampAngle(this.mob.headYaw, this.mob.bodyYaw, (float)this.mob.getMaxHeadRotation());
    }

    private boolean noMobPassengers() {
        return this.mob.getPassengerList().isEmpty() || !(this.mob.getPassengerList().getFirst() instanceof MobEntity);
    }

    private boolean hasMoved() {
        double d0 = this.mob.getX() - this.mob.prevX;
        double d1 = this.mob.getZ() - this.mob.prevZ;
        return d0 * d0 + d1 * d1 > (double)2.5000003E-7F;
    }

    public static float approach(float target, float current, float limit) {
        float delta = MathHelper.wrapDegrees(current - target);
        if (delta < -limit) {
            delta = -limit;
        } else if (delta >= limit) {
            delta = limit;
        }
        return target + delta * 0.55F;
    }
}
