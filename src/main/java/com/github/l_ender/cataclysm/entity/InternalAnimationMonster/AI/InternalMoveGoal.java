package com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI;

import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import java.util.EnumSet;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.entity.EntityPredicates;

public class InternalMoveGoal extends Goal {
    private final Internal_Animation_Monster monster;
    private final boolean followingTargetEvenIfNotSeen;
    private Path path;
    private int delayCounter;
    protected final double moveSpeed;


    public InternalMoveGoal(Internal_Animation_Monster boss, boolean followingTargetEvenIfNotSeen, double moveSpeed) {
        this.monster = boss;
        this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
        this.moveSpeed = moveSpeed;
        this.setControls(EnumSet.of(Control.LOOK, Control.MOVE));
    }


    public boolean canStart() {
        LivingEntity target = this.monster.getTarget();
        return target != null && target.isAlive();
    }


    public void stop() {
        monster.getNavigation().stop();
        LivingEntity livingentity = this.monster.getTarget();
        if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(livingentity)) {
            this.monster.setTarget(null);
        }
        this.monster.setAttacking(false);
    }

    public boolean shouldContinue() {
        LivingEntity target = this.monster.getTarget();
        if (target == null) {
            return false;
        } else if (!target.isAlive()) {
            return false;
        } else if (!this.followingTargetEvenIfNotSeen) {
            return !this.monster.getNavigation().isIdle();
        } else if (!this.monster.isInWalkTargetRange(target.getBlockPos())) {
            return false;
        } else {
            return !(target instanceof PlayerEntity) || !target.isSpectator() && !((PlayerEntity) target).isCreative();
        }
    }

    public void start() {
        this.monster.getNavigation().startMovingAlong(this.path, this.moveSpeed);
        this.monster.setAttacking(true);
    }

    public boolean shouldRunEveryTick() {
        return true;
    }

    public void tick() {
        LivingEntity target = this.monster.getTarget();
        if (target != null) {
            monster.getLookControl().lookAt(target, 30.0F, 30.0F);
            double distSq = this.monster.squaredDistanceTo(target.getX(), target.getBoundingBox().minY, target.getZ());
            if (--this.delayCounter <= 0) {
                this.delayCounter = 4 + this.monster.getRandom().nextInt(7);
                if (distSq > Math.pow(this.monster.getAttributeInstance(EntityAttributes.GENERIC_FOLLOW_RANGE).getValue(), 2.0D)) {
                    if (!this.monster.isNavigating()) {
                        if (!this.monster.getNavigation().startMovingTo(target, 1.0D)) {
                            this.delayCounter += 5;
                        }
                    }
                } else {
                    this.monster.getNavigation().startMovingTo(target, this.moveSpeed);
                }
            }
        }
    }
}
