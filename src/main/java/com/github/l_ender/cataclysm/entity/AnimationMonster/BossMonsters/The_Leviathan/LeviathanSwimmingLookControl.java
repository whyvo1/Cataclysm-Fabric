package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan;

import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.MathHelper;

public class LeviathanSwimmingLookControl extends LookControl {
    private final int maxYRotFromCenter;
    private static final int HEAD_TILT_X = 10;
    private static final int HEAD_TILT_Y = 20;

    public LeviathanSwimmingLookControl(MobEntity p_148061_, int p_148062_) {
        super(p_148061_);
        this.maxYRotFromCenter = p_148062_;
    }

    public void tick() {
        if (this.lookAtTimer > 0) {
            --this.lookAtTimer;
            this.getTargetYaw().ifPresent((p_181130_) -> {
                this.entity.headYaw = this.changeAngle(this.entity.headYaw, p_181130_, this.maxYawChange);
            });
            this.getTargetPitch().ifPresent((p_181128_) -> {
                this.entity.setPitch(this.changeAngle(this.entity.getPitch(), p_181128_, this.maxPitchChange));
            });
        } else {
            this.entity.headYaw = this.changeAngle(this.entity.headYaw, this.entity.bodyYaw, 10.0F);
        }

        float f = MathHelper.wrapDegrees(this.entity.headYaw - this.entity.bodyYaw);
        if (f < (float)(-this.maxYRotFromCenter)) {
            this.entity.bodyYaw -= 4.0F;
        } else if (f > (float)this.maxYRotFromCenter) {
            this.entity.bodyYaw += 4.0F;
        }

    }
}
