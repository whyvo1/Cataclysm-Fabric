package com.github.l_ender.cataclysm.entity.AnimationMonster.AI;

import com.github.l_ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;

import java.util.EnumSet;

public class AttackAniamtionGoal3<T extends LLibrary_Monster & IAnimatedEntity> extends SimpleAnimationGoal<T> {
    public AttackAniamtionGoal3(T entity, Animation animation) {
        super(entity, animation);
        this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
    }

    public void tick() {
        entity.setVelocity(0, entity.getVelocity().y, 0);
    }
}
