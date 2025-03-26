package com.github.l_ender.cataclysm.entity.AnimationMonster.AI;

import com.github.l_ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;
import java.util.EnumSet;
import net.minecraft.entity.LivingEntity;

public class AttackAnimationGoal2<T extends LLibrary_Monster & IAnimatedEntity> extends SimpleAnimationGoal<T> {
    private final int look1;
    private final int look2;
    public AttackAnimationGoal2(T entity, Animation animation, int look1, int look2) {
        super(entity, animation);
        this.look1 = look1;
        this.look2 = look2;
        this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
    }
    public void tick() {
        LivingEntity target = entity.getTarget();
        if (entity.getAnimationTick() < look1 && target != null || entity.getAnimationTick() > look2 && target != null) {
            entity.getLookControl().lookAt(target, 30.0F, 30.0F);
            entity.lookAtEntity(target, 30.0F, 30.0F);
        } else {
            entity.setYaw(entity.prevYaw);
        }
        entity.setVelocity(0, entity.getVelocity().y, 0);
    }

}
