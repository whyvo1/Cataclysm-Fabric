package com.github.l_ender.cataclysm.entity.etc;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.TameableEntity;

public interface IFollower {
    boolean shouldFollow();

    default void followEntity(TameableEntity tameable, LivingEntity owner, double followSpeed){
        tameable.navigation.startMovingTo(owner, followSpeed);
    }
}
