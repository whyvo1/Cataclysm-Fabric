package com.github.l_ender.cataclysm.entity.AnimationMonster.AI;

import com.github.l_ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;
import java.util.EnumSet;
import net.minecraft.entity.LivingEntity;

public class AttackAnimationGoal1<T extends LLibrary_Monster & IAnimatedEntity> extends SimpleAnimationGoal<T> {
    private final int look1;
    private final boolean see;
    public AttackAnimationGoal1(T entity, Animation animation, int look1, boolean see) {
        super(entity, animation);
        this.look1 = look1;
        this.see = see;
        this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
    }
    public void tick() {
        LivingEntity target = entity.getTarget();
        if(see) {
            if (entity.getAnimationTick() < look1 && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.lookAtEntity(target, 30.0F, 30.0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }
        }else{
            if (entity.getAnimationTick() > look1 && target != null) {
                entity.getLookControl().lookAt(target, 30.0F, 30.0F);
                entity.lookAtEntity(target, 30.0F, 30.0F);
            } else {
                entity.setYaw(entity.prevYaw);
            }
        }
        entity.setVelocity(0, entity.getVelocity().y, 0);
    }
}
