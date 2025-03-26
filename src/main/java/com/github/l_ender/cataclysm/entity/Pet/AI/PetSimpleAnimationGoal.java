package com.github.l_ender.cataclysm.entity.Pet.AI;

import com.github.l_ender.cataclysm.entity.Pet.AnimationPet;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;

import java.util.EnumSet;

public class PetSimpleAnimationGoal<T extends AnimationPet & IAnimatedEntity> extends PetAnimationGoal<T> {

    private final Animation animation;

    public PetSimpleAnimationGoal(T entity, Animation animation) {
        super(entity);
        this.animation = animation;
        this.setControls(EnumSet.of(Control.MOVE, Control.JUMP, Control.LOOK));
    }

    @Override
    protected boolean test(Animation animation) {
        return animation == this.animation;
    }


}