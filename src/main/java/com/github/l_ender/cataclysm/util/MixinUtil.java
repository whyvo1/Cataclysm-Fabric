package com.github.l_ender.cataclysm.util;

import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.structure.Structure;

/**
 * Util methods taken from vanilla, with slight tweaks to prevent log spam.
 */
public class MixinUtil {
    public static StructureStart getStructureAt(StructureAccessor structureManager, BlockPos pos, Structure structure) {
        for (StructureStart structurestart : startsForStructure(structureManager, ChunkSectionPos.from(pos), structure)) {
            if (structurestart.getBoundingBox().contains(pos)) {
                return structurestart;
            }
        }

        return StructureStart.DEFAULT;
    }

    private static List<StructureStart> startsForStructure(StructureAccessor structureManager, ChunkSectionPos sectionPos, Structure structure) {
        LongSet longset = structureManager.world.getChunk(sectionPos.getSectionX(), sectionPos.getSectionZ(), ChunkStatus.STRUCTURE_REFERENCES).getStructureReferences(structure);
        ImmutableList.Builder<StructureStart> builder = ImmutableList.builder();
        fillStartsForStructure(structureManager, structure, longset, builder::add);
        return builder.build();
    }

    private static void fillStartsForStructure(StructureAccessor structureManager, Structure structure, LongSet longSet, Consumer<StructureStart> consumer) {
        for (long i : longSet) {
            ChunkSectionPos sectionpos = ChunkSectionPos.from(new ChunkPos(i), structureManager.world.getBottomSectionCoord());
            Optional<Chunk> structureAccess = getChunk((ChunkRegion)structureManager.world, sectionpos.getSectionX(), sectionpos.getSectionZ());
            if (structureAccess.isPresent()) {
                StructureStart structurestart = structureManager.getStructureStart(sectionpos, structure, structureAccess.get());
                if (structurestart != null && structurestart.hasChildren()) {
                    consumer.accept(structurestart);
                }
            }
        }
    }

    private static Optional<Chunk> getChunk(ChunkRegion worldGenRegion, int chunkX, int chunkZ) {
        if (worldGenRegion.isChunkLoaded(chunkX, chunkZ)) {
            int i = chunkX - worldGenRegion.lowerCorner.x;
            int j = chunkZ - worldGenRegion.lowerCorner.z;
            Chunk chunkAccess = worldGenRegion.chunks.get(i + j * worldGenRegion.width);
            if (chunkAccess.getStatus().isAtLeast(ChunkStatus.STRUCTURE_STARTS)) {
                return Optional.of(chunkAccess);
            }
        }

        return Optional.empty();
    }
}
