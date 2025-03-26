package com.github.l_ender.cataclysm.util;


import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3i;

public class BoxOctree {
    private static final int subdivideThreshold = 10;
    private static final int maximumDepth = 3;

    private final Box boundary;
    private final Vec3i size;
    private final int depth;
    private final List<Box> innerBoxes = new ArrayList<>();
    private final List<BoxOctree> childrenOctants = new ArrayList<>();

    public BoxOctree(Box axisAlignedBB) {
        this(axisAlignedBB, 0);
    }

    private BoxOctree(Box axisAlignedBB, int parentDepth) {
        boundary = axisAlignedBB.offset(0, 0, 0); // deep copy
        size = new Vec3i((int) boundary.getXLength(),(int) boundary.getYLength(),(int) boundary.getZLength());
        depth = parentDepth + 1;
    }

    private void subdivide() {
        if (!childrenOctants.isEmpty()) {
            throw new UnsupportedOperationException("YUNG's API - Tried to subdivide when there are already children octants.");
        }

        int halfXSize = size.getX() / 2;
        int halfYSize = size.getY() / 2;
        int halfZSize = size.getZ() / 2;

        childrenOctants.add(new BoxOctree(new Box(
                boundary.minX, boundary.minY, boundary.minZ,
                boundary.minX + halfXSize, boundary.minY + halfYSize, boundary.minZ + halfZSize),
                depth));

        childrenOctants.add(new BoxOctree(new Box(
                boundary.minX + halfXSize, boundary.minY, boundary.minZ,
                boundary.maxX, boundary.minY + halfYSize, boundary.minZ + halfZSize),
                depth));

        childrenOctants.add(new BoxOctree(new Box(
                boundary.minX, boundary.minY + halfYSize, boundary.minZ,
                boundary.minX + halfXSize, boundary.maxY, boundary.minZ + halfZSize),
                depth));

        childrenOctants.add(new BoxOctree(new Box(
                boundary.minX, boundary.minY, boundary.minZ + halfZSize,
                boundary.minX + halfXSize, boundary.minY + halfYSize, boundary.maxZ),
                depth));

        childrenOctants.add(new BoxOctree(new Box(
                boundary.minX + halfXSize, boundary.minY + halfYSize, boundary.minZ,
                boundary.maxX, boundary.maxY, boundary.minZ + halfZSize),
                depth));

        childrenOctants.add(new BoxOctree(new Box(
                boundary.minX, boundary.minY + halfYSize, boundary.minZ + halfZSize,
                boundary.minX + halfXSize, boundary.maxY, boundary.maxZ),
                depth));

        childrenOctants.add(new BoxOctree(new Box(
                boundary.minX + halfXSize, boundary.minY, boundary.minZ + halfZSize,
                boundary.maxX, boundary.minY + halfYSize, boundary.maxZ),
                depth));

        childrenOctants.add(new BoxOctree(new Box(
                boundary.minX + halfXSize, boundary.minY + halfYSize, boundary.minZ + halfZSize,
                boundary.maxX, boundary.maxY, boundary.maxZ),
                depth));

        for (Box parentInnerBox : innerBoxes) {
            for (BoxOctree octree : childrenOctants) {
                if (octree.boundaryIntersectsFuzzy(parentInnerBox)) {
                    octree.addBox(parentInnerBox);
                }
            }
        }

        innerBoxes.clear();
    }

    public void addBox(Box axisAlignedBB) {
        if (depth < maximumDepth && innerBoxes.size() > subdivideThreshold) {
            subdivide();
        }

        if (!childrenOctants.isEmpty()) {
            for (BoxOctree octree : childrenOctants) {
                if (octree.boundaryIntersectsFuzzy(axisAlignedBB)) {
                    octree.addBox(axisAlignedBB);
                }
            }
        } else {
            // Prevent re-adding the same box if it already exists
            for (Box parentInnerBox : innerBoxes) {
                if (parentInnerBox.equals(axisAlignedBB)) {
                    return;
                }
            }

            innerBoxes.add(axisAlignedBB);
        }
    }

    public void removeBox(Box axisAlignedBB) {
        if (!childrenOctants.isEmpty()) {
            for (BoxOctree octree : childrenOctants) {
                if (octree.boundaryIntersectsFuzzy(axisAlignedBB)) {
                    octree.removeBox(axisAlignedBB);
                }
            }
        } else {
            for (Box innerBox : innerBoxes) {
                if (innerBox.equals(axisAlignedBB)) {
                    innerBoxes.remove(innerBox);
                    return;
                }
            }
        }
    }

    public boolean boundaryIntersectsFuzzy(Box axisAlignedBB) {
        return boundary.expand(axisAlignedBB.getAverageSideLength() / 2).intersects(axisAlignedBB);
    }

    public boolean boundaryContains(Box axisAlignedBB) {
        return boundary.contains(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ) &&
                boundary.contains(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
    }

    public boolean intersectsAnyBox(Box axisAlignedBB) {
        if (!childrenOctants.isEmpty()) {
            for (BoxOctree octree : childrenOctants) {
                if (octree.intersectsAnyBox(axisAlignedBB)) {
                    return true;
                }
            }
        } else {
            for (Box innerBox : innerBoxes) {
                if (innerBox.intersects(axisAlignedBB)) {
                    return true;
                }
            }
        }

        return false;
    }
}
