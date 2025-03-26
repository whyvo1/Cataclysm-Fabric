package com.github.l_ender.cataclysm.entity.AnimationMonster.AI;

import com.github.l_ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;

import java.util.EnumSet;

public class SimpleAnimationGoal<T extends LLibrary_Monster & IAnimatedEntity> extends AnimationGoal<T> {

    private final Animation animation;

    public SimpleAnimationGoal(T entity, Animation animation) {
        super(entity);
        this.animation = animation;
        this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
    }

    @Override
    protected boolean test(Animation animation) {
        return animation == this.animation;
    }


}