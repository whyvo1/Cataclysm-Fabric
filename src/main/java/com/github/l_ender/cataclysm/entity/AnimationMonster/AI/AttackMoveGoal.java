package com.github.l_ender.cataclysm.entity.AnimationMonster.AI;



import com.github.l_ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;
import java.util.EnumSet;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.entity.EntityPredicates;

public class AttackMoveGoal extends Goal {
    private final LLibrary_Monster Boss_monster;
    private final boolean followingTargetEvenIfNotSeen;
    private Path path;
    private int delayCounter;
    protected final double moveSpeed;


    public AttackMoveGoal(LLibrary_Monster boss, boolean followingTargetEvenIfNotSeen, double moveSpeed) {
        this.Boss_monster = boss;
        this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
        this.moveSpeed = moveSpeed;
        this.setControls(EnumSet.of(Control.LOOK, Control.MOVE));
    }


    public boolean canStart() {
        LivingEntity target = this.Boss_monster.getTarget();
        return target != null && target.isAlive() && this.Boss_monster.getAnimation() == IAnimatedEntity.NO_ANIMATION;
    }


    public void stop() {
        this.Boss_monster.getNavigation().stop();
        LivingEntity livingentity = this.Boss_monster.getTarget();
        if (!EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(livingentity)) {
            this.Boss_monster.setTarget(null);
        }
        this.Boss_monster.setAttacking(false);
        this.Boss_monster.getNavigation().stop();
    }

    public boolean shouldContinue() {
        LivingEntity target = this.Boss_monster.getTarget();
        if (target == null) {
            return false;
        } else if (!target.isAlive()) {
            return false;
        } else if (!this.followingTargetEvenIfNotSeen) {
            return !this.Boss_monster.getNavigation().isIdle();
        } else if (!this.Boss_monster.isInWalkTargetRange(target.getBlockPos())) {
            return false;
        } else {
            return !(target instanceof PlayerEntity) || !target.isSpectator() && !((PlayerEntity)target).isCreative();
        }
    }

    public void start() {
        this.Boss_monster.getNavigation().startMovingAlong(this.path, this.moveSpeed);
        this.Boss_monster.setAttacking(true);
    }

    public boolean shouldRunEveryTick() {
        return true;
    }

    public void tick() {
        LivingEntity target = this.Boss_monster.getTarget();
        if(target != null){
            this.Boss_monster.getLookControl().lookAt(target, 30.0F, 30.0F);
            double distSq = this.Boss_monster.squaredDistanceTo(target.getX(), target.getBoundingBox().minY, target.getZ());
            if (--this.delayCounter <= 0) {
                this.delayCounter = 4 + this.Boss_monster.getRandom().nextInt(7);
                if (distSq > Math.pow(this.Boss_monster.getAttributeInstance(EntityAttributes.GENERIC_FOLLOW_RANGE).getValue(), 2.0D)) {
                    if (!this.Boss_monster.isNavigating()) {
                        if (!this.Boss_monster.getNavigation().startMovingTo(target, 1.0D)) {
                            this.delayCounter += 5;
                        }
                    }
                } else {
                this.Boss_monster.getNavigation().startMovingTo(target, this.moveSpeed);
                }
            }
        }
    }
}
