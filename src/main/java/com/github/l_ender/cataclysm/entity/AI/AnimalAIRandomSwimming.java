package com.github.l_ender.cataclysm.entity.AI;

import org.jetbrains.annotations.Nullable;
import net.minecraft.entity.ai.NoPenaltyTargeting;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class AnimalAIRandomSwimming extends WanderAroundGoal {
    private int xzSpread;
    private boolean submerged;
    private int ySpread = 3;

    public AnimalAIRandomSwimming(PathAwareEntity creature, double speed, int chance, int xzSpread) {
        super(creature, speed, chance, false);
        this.xzSpread = xzSpread;
        this.submerged = false;
    }

    public AnimalAIRandomSwimming(PathAwareEntity creature, double speed, int chance, int xzSpread, boolean submerged) {
        super(creature, speed, chance, false);
        this.xzSpread = xzSpread;
        this.submerged = submerged;
    }

    public AnimalAIRandomSwimming(PathAwareEntity creature, double speed, int chance, int xzSpread, int ySpread, boolean submerged) {
        super(creature, speed, chance, false);
        this.xzSpread = xzSpread;
        this.ySpread = ySpread;
        this.submerged = submerged;
    }

    public boolean canStart() {
        if (this.mob.hasPassengers()|| mob.getTarget() != null || !this.mob.isTouchingWater() && !this.mob.isInLava()) {
            return false;
        } else {
            if (!this.ignoringChance) {
                if (this.mob.getRandom().nextInt(this.chance) != 0) {
                    return false;
                }
            }
            Vec3d vector3d = this.getWanderTarget();
            if (vector3d == null) {
                return false;
            } else {
                this.targetX = vector3d.x;
                this.targetY = vector3d.y;
                this.targetZ = vector3d.z;
                this.ignoringChance = false;
                return true;
            }
        }
    }

    @Nullable
    protected Vec3d getWanderTarget() {
        if(this.mob.hasPositionTarget() && this.mob.squaredDistanceTo(Vec3d.ofCenter(this.mob.getPositionTarget())) > this.mob.getPositionTargetRange() * this.mob.getPositionTargetRange()){
            return NoPenaltyTargeting.findTo(this.mob, xzSpread, 3, Vec3d.ofBottomCenter(this.mob.getPositionTarget()), 3);
        }
        if(this.mob.getRandom().nextFloat() < 0.3F){
            Vec3d vector3d = findSurfaceTarget(this.mob, xzSpread, ySpread * 2);
            if(vector3d != null){
                return vector3d;
            }
        }
        Vec3d vector3d = NoPenaltyTargeting.find(this.mob, xzSpread, ySpread);

        for(int i = 0; vector3d != null && !this.mob.getWorld().getBlockState(BlockPos.ofFloored(vector3d)).canPathfindThrough(this.mob.getWorld(), BlockPos.ofFloored(vector3d), NavigationType.WATER) && i++ < 15; vector3d = NoPenaltyTargeting.find(this.mob, 10, ySpread)) {
        }
        return vector3d;
    }

    private boolean canJumpTo(BlockPos pos, int dx, int dz, int scale) {
        BlockPos blockpos = pos.add(dx * scale, 0, dz * scale);
        return this.mob.getWorld().getFluidState(blockpos).isIn(FluidTags.LAVA) || this.mob.getWorld().getFluidState(blockpos).isIn(FluidTags.WATER) && !this.mob.getWorld().getBlockState(blockpos).blocksMovement();
    }

    private boolean isAirAbove(BlockPos pos, int dx, int dz, int scale) {
        return this.mob.getWorld().getBlockState(pos.add(dx * scale, 1, dz * scale)).isAir() && this.mob.getWorld().getBlockState(pos.add(dx * scale, 2, dz * scale)).isAir();
    }

    private Vec3d findSurfaceTarget(PathAwareEntity creature, int i, int i1) {
        BlockPos upPos = creature.getBlockPos();
        while(creature.getWorld().getFluidState(upPos).isIn(FluidTags.WATER) || creature.getWorld().getFluidState(upPos).isIn(FluidTags.LAVA)){
            upPos = upPos.up();
        }
        if(isAirAbove(upPos.down(), 0, 0, 0) && canJumpTo(upPos.down(), 0, 0, 0)){
            return new Vec3d(upPos.getX() + 0.5F, upPos.getY() - 1F, upPos.getZ() + 0.5F);
        }
        return null;
    }
}
