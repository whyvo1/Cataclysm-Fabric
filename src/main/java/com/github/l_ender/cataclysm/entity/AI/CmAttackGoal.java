package com.github.l_ender.cataclysm.entity.AI;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;

public class CmAttackGoal extends MeleeAttackGoal {
    private LivingEntity target;
    private int delayCounter;
    protected final double moveSpeed;



    public CmAttackGoal(PathAwareEntity creatureEntity, double moveSpeed) {
        super(creatureEntity, moveSpeed, true);
        this.moveSpeed = moveSpeed;
    }

    @Override
    public boolean canStart() {
        this.target = this.mob.getTarget();
        return this.target != null && target.isAlive();
    }

    @Override
    public void stop() {
        this.mob.getNavigation().stop();
        if (this.mob.getTarget() == null) {
            this.mob.setAttacking(false);
            this.mob.getNavigation().stop();
        }
    }


    @Override
    public void tick() {
        LivingEntity target = this.mob.getTarget();
        if (target == null) {
            return;
        }
        this.mob.getLookControl().lookAt(target, 30.0F, 30.0F);
        double distSq = this.mob.squaredDistanceTo(target.getX(), target.getBoundingBox().minY, target.getZ());
        if (--this.delayCounter <= 0) {
            this.delayCounter = 4 + this.mob.getRandom().nextInt(7);
            if (distSq > Math.pow(this.mob.getAttributeInstance(EntityAttributes.GENERIC_FOLLOW_RANGE).getValue(), 2.0D)) {
                if (!this.mob.isNavigating()) {
                    if (!this.mob.getNavigation().startMovingTo(target, 1.0D)) {
                        this.delayCounter += 5;
                    }
                }
            } else {
                this.mob.getNavigation().startMovingTo(target, this.moveSpeed);
            }
        }
    }
}

