package com.github.l_ender.cataclysm.entity.AI;

import com.github.l_ender.cataclysm.entity.etc.ISemiAquatic;
import java.util.EnumSet;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class MobAIFindWater extends Goal {
    private final PathAwareEntity creature;
    private BlockPos targetPos;
    private final double speed;
    private final int executionChance = 10;

    public MobAIFindWater(PathAwareEntity creature,double speed) {
        this.creature = creature;
        this.speed = speed;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    public boolean canStart() {
        if (this.creature.isOnGround() && !this.creature.getWorld().getFluidState(this.creature.getBlockPos()).isIn(FluidTags.WATER)) {
            if (this.creature instanceof ISemiAquatic && ((ISemiAquatic) this.creature).shouldEnterWater() && this.creature.getRandom().nextInt(executionChance) == 0) {
                targetPos = generateTarget();
                return targetPos != null;
            }
        }
        return false;
    }

    public void start() {
        if (targetPos != null) {
            this.creature.getNavigation().startMovingTo(targetPos.getX(), targetPos.getY(), targetPos.getZ(), speed);
        }
    }

    public void tick() {
        if (targetPos != null) {
            this.creature.getNavigation().startMovingTo(targetPos.getX(), targetPos.getY(), targetPos.getZ(), speed);
        }
    }

    public boolean shouldContinue() {
        if (this.creature instanceof ISemiAquatic && !((ISemiAquatic) this.creature).shouldEnterWater()) {
            this.creature.getNavigation().stop();
            return false;
        }
        return !this.creature.getNavigation().isIdle() && targetPos != null && !this.creature.getWorld().getFluidState(this.creature.getBlockPos()).isIn(FluidTags.WATER);
    }

    public BlockPos generateTarget() {
        BlockPos blockpos = null;
        final Random random = this.creature.getRandom();
        final int range = this.creature instanceof ISemiAquatic ? ((ISemiAquatic) this.creature).getWaterSearchRange() : 14;
        for(int i = 0; i < 15; i++) {
            BlockPos blockPos = this.creature.getBlockPos().add(random.nextInt(range) - range/2, 3, random.nextInt(range) - range/2);
            while (this.creature.getWorld().isAir(blockPos) && blockPos.getY() > 1) {
                blockPos = blockPos.down();
            }

            if (this.creature.getWorld().getFluidState(blockPos).isIn(FluidTags.WATER)) {
                blockpos = blockPos;
            }
        }
        return blockpos;
    }
}
