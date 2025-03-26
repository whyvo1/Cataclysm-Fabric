package com.github.l_ender.cataclysm.entity.Pet.AI;

import com.github.l_ender.cataclysm.entity.Pet.AnimationPet;
import com.github.l_ender.cataclysm.entity.etc.IFollower;
import java.util.EnumSet;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.LandPathNodeMaker;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class TameableAIFollowOwnerWater extends Goal {
    private final AnimationPet tameable;
    private final WorldView world;
    private final double followSpeed;
    private final float maxDist;
    private final float minDist;
    private final boolean teleportToLeaves;
    private LivingEntity owner;
    private int timeToRecalcPath;
    private float oldWaterCost;

    public TameableAIFollowOwnerWater(AnimationPet tamed, double speed, float minDist, float maxDist, boolean leaves) {
        this.tameable = tamed;
        this.world = tamed.getWorld();
        this.followSpeed = speed;
        this.minDist = minDist;
        this.maxDist = maxDist;
        this.teleportToLeaves = leaves;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    public boolean canStart() {
        LivingEntity lvt_1_1_ = this.tameable.getOwner();
        if (lvt_1_1_ == null) {
            return false;
        } else if (lvt_1_1_.isSpectator()) {
            return false;
        } else if (!this.tameable.shouldFollow() || isInCombat()) {
            return false;
        } else if (this.tameable.squaredDistanceTo(lvt_1_1_) < (double) (this.minDist * this.minDist)) {
            return false;
        } else if (this.tameable.getTarget() != null && this.tameable.getTarget().isAlive()) {
            return false;
        } else {
            this.owner = lvt_1_1_;
            return true;
        }
    }

    public boolean shouldContinue() {
        if (this.tameable.getNavigation().isIdle() || isInCombat()) {
            return false;
        } else if (!this.tameable.shouldFollow()) {
            return false;
        } else if (this.tameable.getTarget() != null && this.tameable.getTarget().isAlive()) {
            return false;
        } else {
            return this.tameable.squaredDistanceTo(this.owner) > (double) (this.maxDist * this.maxDist);
        }
    }

    private boolean isInCombat() {
        Entity owner = tameable.getOwner();
        if(owner != null){
            return tameable.distanceTo(owner) < 30 && tameable.getTarget() != null && tameable.getTarget().isAlive();
        }
        return false;
    }

    public void start() {
        this.timeToRecalcPath = 0;
        this.oldWaterCost = this.tameable.getPathfindingPenalty(PathNodeType.WATER);
        this.tameable.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
    }

    public void stop() {
        this.owner = null;
        this.tameable.getNavigation().stop();
        this.tameable.setPathfindingPenalty(PathNodeType.WATER, this.oldWaterCost);
    }

    public void tick() {

        this.tameable.getLookControl().lookAt(this.owner, 10.0F, (float) this.tameable.getMaxLookPitchChange());
        if (--this.timeToRecalcPath <= 0) {
            this.timeToRecalcPath = 10;
            if (!this.tameable.isLeashed() && !this.tameable.hasVehicle()) {
                if (this.tameable.squaredDistanceTo(this.owner) >= 144.0D) {
                    this.tryToTeleportNearEntity();
                } else {
                    this.tameable.getNavigation().startMovingTo(this.owner, this.followSpeed);
                }

            }
        }
    }

    private void tryToTeleportNearEntity() {
        BlockPos lvt_1_1_ = this.owner.getBlockPos();

        for (int lvt_2_1_ = 0; lvt_2_1_ < 10; ++lvt_2_1_) {
            int lvt_3_1_ = this.getRandomNumber(-3, 3);
            int lvt_4_1_ = this.getRandomNumber(-1, 1);
            int lvt_5_1_ = this.getRandomNumber(-3, 3);
            boolean lvt_6_1_ = this.tryToTeleportToLocation(lvt_1_1_.getX() + lvt_3_1_, lvt_1_1_.getY() + lvt_4_1_, lvt_1_1_.getZ() + lvt_5_1_);
            if (lvt_6_1_) {
                return;
            }
        }

    }

    private boolean tryToTeleportToLocation(int p_226328_1_, int p_226328_2_, int p_226328_3_) {
        if (Math.abs((double) p_226328_1_ - this.owner.getX()) < 2.0D && Math.abs((double) p_226328_3_ - this.owner.getZ()) < 2.0D) {
            return false;
        } else if (!this.isTeleportFriendlyBlock(new BlockPos(p_226328_1_, p_226328_2_, p_226328_3_))) {
            return false;
        } else {
            this.tameable.refreshPositionAndAngles((double) p_226328_1_ + 0.5D, p_226328_2_, (double) p_226328_3_ + 0.5D, this.tameable.getYaw(), this.tameable.getPitch());
            this.tameable.getNavigation().stop();
            return true;
        }
    }

    private boolean isTeleportFriendlyBlock(BlockPos pos) {
        PathNodeType blockPathType = LandPathNodeMaker.getLandNodeType(this.world, pos.mutableCopy());
        if (world.getFluidState(pos).isIn(FluidTags.WATER) || !world.getFluidState(pos).isIn(FluidTags.WATER) && world.getFluidState(pos.down()).isIn(FluidTags.WATER)) {
            return true;
        }
        if (blockPathType != PathNodeType.WALKABLE || avoidsLand()) {
            return false;
        } else {
            BlockState lvt_3_1_ = this.world.getBlockState(pos.down());
            if (!this.teleportToLeaves && lvt_3_1_.getBlock() instanceof LeavesBlock) {
                return false;
            } else {
                BlockPos lvt_4_1_ = pos.subtract(this.tameable.getBlockPos());
                return this.world.isSpaceEmpty(this.tameable, this.tameable.getBoundingBox().offset(lvt_4_1_));
            }
        }
    }

    public boolean avoidsLand() {
        return false;
    }

    private int getRandomNumber(int p_226327_1_, int p_226327_2_) {
        return this.tameable.getRandom().nextInt(p_226327_2_ - p_226327_1_ + 1) + p_226327_1_;
    }
}
