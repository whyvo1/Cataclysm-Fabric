package com.github.l_ender.cataclysm.entity.InternalAnimationMonster;


import com.github.l_ender.cataclysm.entity.etc.Animation_Monsters;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.Monster;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Internal_Animation_Monster extends Animation_Monsters implements Monster {

    public static final TrackedData<Integer> ATTACK_STATE = DataTracker.registerData(Internal_Animation_Monster.class, TrackedDataHandlerRegistry.INTEGER);

    public int attackTicks;

    public Internal_Animation_Monster(EntityType entity, World world) {
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



    @Override
    protected void updatePostDeath() {
        onDeathUpdate(this.deathtimer());
    }

    public int deathtimer(){
        return 20;
    }

    // TODO: Copied from parent classes
    @Override
    public void pushAwayFrom(Entity entityIn) {
        if (!this.isSleeping()) {
            if (!this.isConnectedThroughVehicle(entityIn)) {
                if (!entityIn.noClip && !this.noClip) {
                    double d0 = entityIn.getX() - this.getX();
                    double d1 = entityIn.getZ() - this.getZ();
                    double d2 = MathHelper.absMax(d0, d1);
                    if (d2 >= (double)0.01F) {
                        d2 = MathHelper.sqrt((float) d2);
                        d0 = d0 / d2;
                        d1 = d1 / d2;
                        double d3 = 1.0D / d2;
                        if (d3 > 1.0D) {
                            d3 = 1.0D;
                        }

                        d0 = d0 * d3;
                        d1 = d1 * d3;
                        d0 = d0 * (double)0.05F;
                        d1 = d1 * (double)0.05F;
                        // d0 = d0 * (double)(1.0F - this.entityCollisionReduction);
                        // d1 = d1 * (double)(1.0F - this.entityCollisionReduction);
                        if (!this.hasPassengers()) {
                            if (canBePushedByEntity(entityIn)) {
                                this.addVelocity(-d0, 0.0D, -d1);
                            }
                        }

                        if (!entityIn.hasPassengers()) {
                            entityIn.addVelocity(d0, 0.0D, d1);
                        }
                    }

                }
            }
        }
    }

}
