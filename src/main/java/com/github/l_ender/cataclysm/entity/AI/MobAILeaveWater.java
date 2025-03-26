package com.github.l_ender.cataclysm.entity.AI;

import com.github.l_ender.cataclysm.entity.etc.ISemiAquatic;
import java.util.EnumSet;
import net.minecraft.entity.ai.FuzzyTargeting;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class MobAILeaveWater extends Goal {
    private final PathAwareEntity creature;
    private BlockPos targetPos;
    private final int executionChance = 30;

    public MobAILeaveWater(PathAwareEntity creature) {
        this.creature = creature;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    public boolean canStart() {
        if (this.creature.getWorld().getFluidState(this.creature.getBlockPos()).isIn(FluidTags.WATER) && (this.creature.getTarget() != null || this.creature.getRandom().nextInt(executionChance) == 0)) {
            if (this.creature instanceof ISemiAquatic && ((ISemiAquatic) this.creature).shouldLeaveWater()) {
                targetPos = generateTarget();
                return targetPos != null;
            }
        }
        return false;
    }

    public void start() {
        if (targetPos != null) {
            this.creature.getNavigation().startMovingTo(targetPos.getX(), targetPos.getY(), targetPos.getZ(), 1D);
        }
    }

    public void tick() {
        if (targetPos != null) {
            this.creature.getNavigation().startMovingTo(targetPos.getX(), targetPos.getY(), targetPos.getZ(), 1D);
        }
        if (this.creature.horizontalCollision && this.creature.isTouchingWater()) {
            final float f1 = creature.getYaw() * (float) Math.PI / 180.0F;
            creature.setVelocity(creature.getVelocity().add(-MathHelper.sin(f1) * 0.2F, 0.1D, MathHelper.cos(f1) * 0.2F));

        }
    }

    public boolean shouldContinue() {
        if (this.creature instanceof ISemiAquatic && !((ISemiAquatic) this.creature).shouldLeaveWater()) {
            this.creature.getNavigation().stop();
            return false;
        }
        return !this.creature.getNavigation().isIdle() && targetPos != null && !this.creature.getWorld().getFluidState(targetPos).isIn(FluidTags.WATER);
    }

    public BlockPos generateTarget() {
        Vec3d vector3d = FuzzyTargeting.find(this.creature, 23, 7);
        int tries = 0;
        while(vector3d != null && tries < 8) {
            boolean waterDetected = false;
            for(BlockPos blockpos1 : BlockPos.iterate(MathHelper.floor(vector3d.x - 2.0D), MathHelper.floor(vector3d.y - 1.0D), MathHelper.floor(vector3d.z - 2.0D), MathHelper.floor(vector3d.x + 2.0D), MathHelper.floor(vector3d.y), MathHelper.floor(vector3d.z + 2.0D))) {
                if (this.creature.getWorld().getFluidState(blockpos1).isIn(FluidTags.WATER)) {
                    waterDetected = true;
                    break;
                }
            }
            if (waterDetected) {
                vector3d = FuzzyTargeting.find(this.creature, 23, 7);
            } else {
                return BlockPos.ofFloored(vector3d);
            }
            tries++;
        }
        return null;
    }
}
