package com.github.l_ender.cataclysm.entity.Pet.AI;

import com.github.l_ender.cataclysm.entity.etc.IFollower;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.passive.TameableEntity;

public class TameableAIFollowOwner extends FollowOwnerGoal {

    private final IFollower follower;
    private final TameableEntity tameable;

    public TameableAIFollowOwner(TameableEntity tameable, double speed, float minDist, float maxDist, boolean teleportToLeaves) {
        super(tameable, speed, minDist, maxDist, teleportToLeaves);
        this.follower = (IFollower)tameable;
        this.tameable = tameable;
    }

    public boolean canStart(){
        return super.canStart() && follower.shouldFollow() && !isInCombat();
    }

    public boolean shouldContinue(){
        return super.shouldContinue() && follower.shouldFollow() && !isInCombat();
    }

    private boolean isInCombat() {
        Entity owner = tameable.getOwner();
        if(owner != null){
            return tameable.distanceTo(owner) < 30 && tameable.getTarget() != null && tameable.getTarget().isAlive();
        }
        return false;
    }
}
