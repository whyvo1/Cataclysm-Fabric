package com.github.l_ender.cataclysm.entity.Pet;


import com.github.l_ender.cataclysm.entity.etc.IFollower;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.world.World;

public class InternalAnimationPet extends AnimationPet implements IFollower {
    public static final TrackedData<Integer> ATTACK_STATE = DataTracker.registerData(InternalAnimationPet.class, TrackedDataHandlerRegistry.INTEGER);

    public int attackTicks;

    public InternalAnimationPet(EntityType entity, World world) {
        super(entity, world);

    }


    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
        p_326229_.add(ATTACK_STATE, 0);
    }

    public int getAttackState() {
        return this.dataTracker.get(ATTACK_STATE);
    }

    public void setAttackState(int input) {
        this.attackTicks = 0;
        this.dataTracker.set(ATTACK_STATE, input);
        this.getWorld().sendEntityStatus(this, (byte) -input);
    }

    @Override
    public void handleStatus(byte id) {
        if (id <= 0) {
            this.attackTicks = 0;
        }else {
            super.handleStatus(id);
        }
    }

    public void tick() {
        super.tick();

        if (this.getAttackState() > 0) {
            ++this.attackTicks;
        }

    }

}
