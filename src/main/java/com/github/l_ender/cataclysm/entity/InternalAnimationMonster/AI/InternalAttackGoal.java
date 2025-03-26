package com.github.l_ender.cataclysm.entity.InternalAnimationMonster.AI;

import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import java.util.EnumSet;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;

public class InternalAttackGoal extends Goal {
    protected final Internal_Animation_Monster entity;
    private final int getattackstate;
    private final int attackstate;
    private final int attackendstate;
    private final int attackMaxtick;
    private final int attackseetick;
    private final float attackrange;

    public InternalAttackGoal(Internal_Animation_Monster entity, int getattackstate, int attackstate, int attackendstate,int attackMaxtick,int attackseetick,float attackrange) {
        this.entity = entity;
        this.setControls(EnumSet.of(Control.MOVE,Control.LOOK,Control.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }

    public InternalAttackGoal(Internal_Animation_Monster entity, int getattackstate, int attackstate, int attackendstate,int attackMaxtick,int attackseetick,float attackrange, EnumSet<Control> interruptFlagTypes) {
        this.entity = entity;
        setControls(interruptFlagTypes);
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }


    @Override
    public boolean canStart() {
        LivingEntity target = entity.getTarget();
        return target != null && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate;
    }


    @Override
    public void start() {
        this.entity.setAttackState(attackstate);
    }

    @Override
    public void stop() {
        this.entity.setAttackState(attackendstate);
    }

    @Override
    public boolean shouldContinue() {
        return  this.entity.getAttackState() == attackstate && this.entity.attackTicks <= attackMaxtick;
    }


    public void tick() {
        LivingEntity target = entity.getTarget();
        if (entity.attackTicks < attackseetick && target != null) {
            entity.getLookControl().lookAt(target, 30.0F, 30.0F);
            entity.lookAtEntity(target, 30.0F, 30.0F);
        } else {
            entity.setYaw(entity.prevYaw);
        }
    }

    @Override
    public boolean shouldRunEveryTick() {
        return false;
    }

    //@Override
    //public boolean canContinueToUse() {
    //    return this.test(this.entity.getAnimation()) && this.entity.getAnimationTick() < this.entity.getAnimation().getDuration();
    //}

}