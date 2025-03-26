package com.github.l_ender.cataclysm.entity.AnimationMonster.AI;

import com.github.l_ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;
import net.minecraft.entity.LivingEntity;

public class ChargeAttackAnimationGoal<T extends LLibrary_Monster & IAnimatedEntity> extends SimpleAnimationGoal<T> {
    private final int look1;
    private final int look2;
    private final int charge;
    private final float motionx;
    private final float motionz;

    public ChargeAttackAnimationGoal(T entity, Animation animation, int look1, int look2, int charge, float motionx, float motionz) {
        super(entity, animation);
        this.look1 = look1;
        this.look2 = look2;
        this.charge = charge;
        this.motionx = motionx;
        this.motionz = motionz;
    }
    public void tick() {
        LivingEntity target = entity.getTarget();
        if (entity.getAnimationTick() < look1 && target != null || entity.getAnimationTick() > look2 && target != null) {
            entity.getLookControl().lookAt(target, 30.0F, 30.0F);
        } else {
            entity.setYaw(entity.prevYaw);
        }
        if (entity.getAnimationTick() == charge && target != null){
            entity.setVelocity((target.getX() - entity.getX()) * motionx, 0, (target.getZ() - entity.getZ()) * motionz);
        }
    }

}
