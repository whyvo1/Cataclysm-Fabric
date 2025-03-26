package com.github.l_ender.cataclysm.world.structures.Pieces;

import com.github.l_ender.cataclysm.structures.jisaw.JigsawManager;
import java.util.Optional;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.structure.Structure;

public class CataclysmJigsawManager {

    public static Optional<Structure.StructurePosition> assembleJigsawStructure(
            Structure.Context generationContext,
            RegistryEntry<StructurePool> startPool,
            Optional<Identifier> startJigsawNameOptional,
            int maxDepth,
            BlockPos startPos,
            boolean useExpansionHack,
            Optional<Heightmap.Type> projectStartToHeightmap,
            int maxDistanceFromCenter,
            Optional<Integer> maxY,
            Optional<Integer> minY
    ) {
        return JigsawManager.assembleJigsawStructure(generationContext, startPool, startJigsawNameOptional, maxDepth,
                startPos, useExpansionHack, projectStartToHeightmap, maxDistanceFromCenter, maxY, minY);
    }
}
