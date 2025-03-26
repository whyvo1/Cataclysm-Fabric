package com.github.l_ender.cataclysm.entity.AnimationMonster.AI;

import com.github.l_ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.l_ender.lionfishapi.server.animation.Animation;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;
import java.util.EnumSet;
import net.minecraft.entity.ai.goal.Goal;

public abstract class AnimationGoal<T extends LLibrary_Monster & IAnimatedEntity> extends Goal {
    protected final T entity;

    protected AnimationGoal(T entity) {
        this(entity, true);
    }

    protected AnimationGoal(T entity, boolean interruptsAI) {
        this.entity = entity;
        if (interruptsAI) this.setControls(EnumSet.of(Control.MOVE,Control.LOOK,Control.JUMP));
    }

    @Override
    public boolean canStart() {
        return this.test(this.entity.getAnimation());
    }

    @Override
    public boolean shouldRunEveryTick() {
        return true;
    }

    //@Override
    //public boolean canContinueToUse() {
    //    return this.test(this.entity.getAnimation()) && this.entity.getAnimationTick() < this.entity.getAnimation().getDuration();
    //}

    protected abstract boolean test(Animation animation);
}