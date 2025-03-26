package com.github.l_ender.cataclysm.entity.etc.path;

import java.util.Objects;
import net.minecraft.entity.ai.pathing.LandPathNodeMaker;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.ai.pathing.PathNodeNavigator;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CMPathNavigateGround extends MobNavigation {
    public CMPathNavigateGround(MobEntity mob, World world) {
        super(mob, world);
    }

    @Override
    protected PathNodeNavigator createPathNodeNavigator(int maxVisitedNodes) {
        this.nodeMaker = new LandPathNodeMaker();
        this.nodeMaker.setCanEnterOpenDoors(true);
        return new CMPathFinder(this.nodeMaker, maxVisitedNodes);
    }

    @Override
    protected void continueFollowingPath() {
        Path path = Objects.requireNonNull(this.currentPath);
        Vec3d entityPos = this.getPos();
        int pathLength = path.getLength();
        for (int i = path.getCurrentNodeIndex(); i < path.getLength(); i++) {
            if (path.getNode(i).y != Math.floor(entityPos.y)) {
                pathLength = i;
                break;
            }
        }
        final Vec3d base = entityPos.add(-this.entity.getWidth() * 0.5F, 0.0F, -this.entity.getWidth() * 0.5F);
        final Vec3d max = base.add(this.entity.getWidth(), this.entity.getHeight(), this.entity.getWidth());
        if (this.tryShortcut(path, new Vec3d(this.entity.getX(), this.entity.getY(), this.entity.getZ()), pathLength, base, max)) {
            if (this.isAt(path, 0.5F) || this.atElevationChange(path) && this.isAt(path, this.entity.getWidth() * 0.5F)) {
                path.setCurrentNodeIndex(path.getCurrentNodeIndex() + 1);
            }
        }
        this.checkTimeouts(entityPos);
    }

    private boolean isAt(Path path, float threshold) {
        final Vec3d pathPos = path.getNodePosition(this.entity);
        return MathHelper.abs((float) (this.entity.getX() - pathPos.x)) < threshold &&
                MathHelper.abs((float) (this.entity.getZ() - pathPos.z)) < threshold &&
                Math.abs(this.entity.getY() - pathPos.y) < 1.0D;
    }

    private boolean atElevationChange(Path path) {
        final int curr = path.getCurrentNodeIndex();
        final int end = Math.min(path.getLength(), curr + MathHelper.ceil(this.entity.getWidth() * 0.5F) + 1);
        final int currY = path.getNode(curr).y;
        for (int i = curr + 1; i < end; i++) {
            if (path.getNode(i).y != currY) {
                return true;
            }
        }
        return false;
    }

    private boolean tryShortcut(Path path, Vec3d entityPos, int pathLength, Vec3d base, Vec3d max) {
        for (int i = pathLength; --i > path.getCurrentNodeIndex(); ) {
            final Vec3d vec = path.getNodePosition(this.entity, i).subtract(entityPos);
            if (this.sweep(vec, base, max)) {
                path.setCurrentNodeIndex(i);
                return false;
            }
        }
        return true;
    }

    static final float EPSILON = 1.0E-8F;

    // Based off of https://github.com/andyhall/voxel-aabb-sweep/blob/d3ef85b19c10e4c9d2395c186f9661b052c50dc7/index.js
    private boolean sweep(Vec3d vec, Vec3d base, Vec3d max) {
        float t = 0.0F;
        float max_t = (float) vec.length();
        if (max_t < EPSILON) return true;
        final float[] tr = new float[3];
        final int[] ldi = new int[3];
        final int[] tri = new int[3];
        final int[] step = new int[3];
        final float[] tDelta = new float[3];
        final float[] tNext = new float[3];
        final float[] normed = new float[3];
        for (int i = 0; i < 3; i++) {
            float value = element(vec, i);
            boolean dir = value >= 0.0F;
            step[i] = dir ? 1 : -1;
            float lead = element(dir ? max : base, i);
            tr[i] = element(dir ? base : max, i);
            ldi[i] = leadEdgeToInt(lead, step[i]);
            tri[i] = trailEdgeToInt(tr[i], step[i]);
            normed[i] = value / max_t;
            tDelta[i] = MathHelper.abs(max_t / value);
            float dist = dir ? (ldi[i] + 1 - lead) : (lead - ldi[i]);
            tNext[i] = tDelta[i] < Float.POSITIVE_INFINITY ? tDelta[i] * dist : Float.POSITIVE_INFINITY;
        }
        /*final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        do {
            // stepForward
            int axis = (tNext[0] < tNext[1]) ?
                    ((tNext[0] < tNext[2]) ? 0 : 2) :
                    ((tNext[1] < tNext[2]) ? 1 : 2);
            float dt = tNext[axis] - t;
            t = tNext[axis];
            ldi[axis] += step[axis];
            tNext[axis] += tDelta[axis];
            for (int i = 0; i < 3; i++) {
                tr[i] += dt * normed[i];
                tri[i] = trailEdgeToInt(tr[i], step[i]);
            }
            // checkCollision
            int stepx = step[0];
            int x0 = (axis == 0) ? ldi[0] : tri[0];
            int x1 = ldi[0] + stepx;
            int stepy = step[1];
            int y0 = (axis == 1) ? ldi[1] : tri[1];
            int y1 = ldi[1] + stepy;
            int stepz = step[2];
            int z0 = (axis == 2) ? ldi[2] : tri[2];
            int z1 = ldi[2] + stepz;
            for (int x = x0; x != x1; x += stepx) {
                for (int z = z0; z != z1; z += stepz) {
                    for (int y = y0; y != y1; y += stepy) {
                        BlockState block = this.level.getBlockState(pos.set(x, y, z));
                        if (!block.isPathfindable(this.level, pos, PathComputationType.LAND)) return false;
                    }
                    PathType below = this.nodeEvaluator.getBlockPathType(this.level, x, y0 - 1, z, this.mob, 1, 1, 1, true, true);
                    if (below == PathType.OPEN) return false;
                    PathType in = this.nodeEvaluator.getBlockPathType(this.level, x, y0, z, this.mob, 1, y1 - y0, 1, true, true);
                    float priority = this.mob.getPathfindingMalus(in);
                    if (priority < 0.0F || priority >= 8.0F) return false;
                   // if (in == PathType.DAMAGE_FIRE || in == PathType.DANGER_FIRE || in == PathType.DAMAGE_OTHER) return false;
                }
            }
        } while (t <= max_t);
         *****/
        return true;
    }


    protected boolean canWalkOnPath(PathNodeType p_26467_) {
        if (p_26467_ == PathNodeType.WATER) {
            return false;
        } else if (p_26467_ == PathNodeType.LAVA) {
            return false;
        } else {
            return p_26467_ != PathNodeType.OPEN;
        }
    }

    static int leadEdgeToInt(float coord, int step) {
        return MathHelper.floor(coord - step * EPSILON);
    }

    static int trailEdgeToInt(float coord, int step) {
        return MathHelper.floor(coord + step * EPSILON);
    }

    static float element(Vec3d v, int i) {
        switch (i) {
            case 0: return (float) v.x;
            case 1: return (float) v.y;
            case 2: return (float) v.z;
            default: return 0.0F;
        }
    }
}
