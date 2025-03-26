package com.github.l_ender.cataclysm.entity.AI;

import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.mob.PathAwareEntity;

public class AdvancedHurtByTargetGoal extends RevengeGoal {
    private int forcedAggroTime;
    private float intensity;

    public AdvancedHurtByTargetGoal(PathAwareEntity mob, Class<?>... ToIgnoreDamage) {
        super(mob, ToIgnoreDamage);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.lastAttackedTime != this.mob.getLastAttackedTime()) {
            this.lastAttackedTime = this.mob.getLastAttackedTime();
            if (mob.getLastAttacker() != target) {
                forcedAggroTime -= 20;
            } else {
                forcedAggroTime += (int) (20 * intensity);
                intensity *= 0.8f;
            }
        }
    }

    @Override
    public void start() {
        super.start();
        this.forcedAggroTime = 40 + this.mob.getRandom().nextInt(140);
        intensity = 1f;
    }

    @Override
    public boolean shouldContinue() {
        return --forcedAggroTime > 0 && super.shouldContinue();
    }
}