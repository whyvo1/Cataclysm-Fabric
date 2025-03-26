package com.github.l_ender.cataclysm.entity.AnimationMonster.AI;

import com.github.l_ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;
import java.util.EnumSet;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

public class PredictiveChargeAttackAnimationGoal<T extends LLibrary_Monster & IAnimatedEntity> extends SimpleAnimationGoal<T> {

    protected LivingEntity target;
    private final int look1;
    private final int look2;

    private final float sensing;
    private final int charge;
    private final float motionx;
    private final float motionz;


    public double prevX;
    public double prevZ;
    private int newX;
    private int newZ;

    public PredictiveChargeAttackAnimationGoal(T entity, Animation animation, int look1, int look2, float sensing, int charge, float motionx, float motionz) {
        super(entity, animation);
        this.look1 = look1;
        this.look2 = look2;
        this.sensing = sensing;
        this.charge = charge;
        this.motionx = motionx;
        this.motionz = motionz;
        this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
    }

    @Override
    public void start() {
        super.start();
        target = entity.getTarget();
        if (target != null) {
            prevX = target.getX();
            prevZ = target.getZ();
        }
    }

    public void tick() {
        if (entity.getAnimationTick() < look1 && target != null || entity.getAnimationTick() > look2 && target != null) {
            entity.getLookControl().lookAt(target, 30.0F, 30.0F);
            entity.setYaw(entity.bodyYaw);
        } else {
            entity.setYaw(entity.prevYaw);
        }
        if (entity.getAnimationTick() == (charge -1) && target != null) {
            double x = target.getX();
            double z = target.getZ();
            double vx = (x - prevX) / charge;
            double vz = (z - prevZ) / charge;
            newX = MathHelper.floor(x + vx * sensing);
            newZ = MathHelper.floor(z + vz * sensing);
        }

        if (entity.getAnimationTick() == charge && target != null){
            entity.setVelocity((newX - entity.getX()) * motionx, 0, (newZ - entity.getZ()) * motionz);

        }
    }

}
