package com.github.l_ender.cataclysm.entity.etc.path;

import net.minecraft.entity.ai.pathing.AmphibiousPathNodeMaker;
import net.minecraft.entity.ai.pathing.PathNodeNavigator;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class SemiAquaticPathNavigator extends SwimNavigation {

    public SemiAquaticPathNavigator(MobEntity entitylivingIn, World worldIn) {
        super(entitylivingIn, worldIn);
    }

    protected PathNodeNavigator createPathNodeNavigator(int p_179679_1_) {
        this.nodeMaker = new AmphibiousPathNodeMaker(true);
        return new PathNodeNavigator(this.nodeMaker, p_179679_1_);
    }

    protected boolean isAtValidPosition() {
        return true;
    }

    protected Vec3d getPos() {
        return new Vec3d(this.entity.getX(), this.entity.getBodyY(0.5D), this.entity.getZ());
    }

    protected double adjustTargetY(Vec3d p_186136_) {
        return p_186136_.y;
    }

    protected boolean canMoveDirectly(Vec3d posVec31, Vec3d posVec32, int sizeX, int sizeY, int sizeZ) {
        Vec3d vector3d = new Vec3d(posVec32.x, posVec32.y + (double)this.entity.getHeight() * 0.5D, posVec32.z);
        return this.world.raycast(new RaycastContext(posVec31, vector3d, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, this.entity)).getType() == HitResult.Type.MISS;
    }

    public boolean isValidPosition(BlockPos pos) {
        return  !this.world.getBlockState(pos.down()).isAir();
    }

    public void setCanSwim(boolean canSwim) {
    }
}
