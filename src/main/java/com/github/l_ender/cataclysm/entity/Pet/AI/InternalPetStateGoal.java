package com.github.l_ender.cataclysm.entity.Pet.AI;

import com.github.l_ender.cataclysm.entity.Pet.InternalAnimationPet;
import java.util.EnumSet;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;

public class InternalPetStateGoal extends Goal {
    protected final InternalAnimationPet entity;
    private final int getattackstate;
    private final int attackstate;
    protected final int attackendstate;
    private final int attackfinaltick;
    protected final int attackseetick;

    public InternalPetStateGoal(InternalAnimationPet entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick) {
        this.entity = entity;
        this.setControls(EnumSet.of(Control.MOVE,Control.LOOK,Control.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackfinaltick = attackfinaltick;
        this.attackseetick = attackseetick;
    }

    public InternalPetStateGoal(InternalAnimationPet entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick, boolean interruptsAI) {
        this.entity = entity;
        if (interruptsAI) this.setControls(EnumSet.of(Control.MOVE,Control.LOOK,Control.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackfinaltick = attackfinaltick;
        this.attackseetick = attackseetick;
    }

    public InternalPetStateGoal(InternalAnimationPet entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick, EnumSet<Control> interruptFlagTypes) {
        this.entity = entity;
        setControls(interruptFlagTypes);
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackfinaltick = attackfinaltick;
        this.attackseetick = attackseetick;
    }

    @Override
    public boolean canStart() {
        return this.entity.getAttackState() == getattackstate;
    }

    @Override
    public void start() {
        if(getattackstate != attackstate) {
            this.entity.setAttackState(attackstate);
        }
    }

    @Override
    public void stop() {
        this.entity.setAttackState(attackendstate);
    }

    @Override
    public boolean shouldContinue() {
        return attackfinaltick > 0 ? this.entity.attackTicks <= attackfinaltick && this.entity.getAttackState() == attackstate : canStart();
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
        return true;
    }

    //@Override
    //public boolean canContinueToUse() {
    //    return this.test(this.entity.getAnimation()) && this.entity.getAnimationTick() < this.entity.getAnimation().getDuration();
    //}

}