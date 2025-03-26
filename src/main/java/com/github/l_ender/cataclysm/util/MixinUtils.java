package com.github.l_ender.cataclysm.util;

import it.unimi.dsi.fastutil.longs.LongSet;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.structure.Structure;

public class MixinUtils {
    /**
     * Checks if the provided position is inside a structure that is tagged with the provided tag.
     * Thanks to TelepathicGrunt for the original implementation!
     *
     * @param worldGenRegion  the WorldGenRegion
     * @param pos             the position to check
     * @param structureTagKey the tag to check for
     * @return true if the provided position is inside a structure that is tagged with the provided tag
     */
    public static boolean isPositionInTaggedStructure(ChunkRegion worldGenRegion, BlockPos pos, TagKey<Structure> structureTagKey) {
        Registry<Structure> structureRegistry = worldGenRegion.getRegistryManager().get(RegistryKeys.STRUCTURE);
        ChunkSectionPos sectionPos = ChunkSectionPos.from(pos);

        // Ensure chunk has generated structure references
        Chunk chunkAccess = worldGenRegion.getChunk(sectionPos.getSectionX(), sectionPos.getSectionZ(), ChunkStatus.STRUCTURE_REFERENCES);
        if (!chunkAccess.getMaxStatus().isAtLeast(ChunkStatus.STRUCTURE_REFERENCES)) return false;

        // Check all structures in chunk, and return true if any match the provided tag
        Map<Structure, LongSet> allReferencesInChunk = chunkAccess.getStructureReferences();
        for (Map.Entry<Structure, LongSet> entry : allReferencesInChunk.entrySet()) {
            Structure structure = entry.getKey();
            LongSet references = entry.getValue();

            Optional<RegistryKey<Structure>> structureKey = structureRegistry.getKey(structure);
            boolean isTaggedStructure = structureKey.isPresent() && structureRegistry.entryOf(structureKey.get()).isIn(structureTagKey);

            if (isTaggedStructure) {
                if (isAnyReferenceValidStartForStructure(worldGenRegion, structure, references, structureStart -> structureStart.getBoundingBox().contains(pos))) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Checks if any of the references contain a valid structure start for the provided structure.
     * Each valid structure start must also pass the provided filter.
     * Based on vanilla's {@link StructureAccessor#acceptStructureStarts}.
     *
     * @param worldGenRegion the WorldGenRegion
     * @param structure      the structure to check for
     * @param references     the references to check
     * @param filter         an additional filter to apply to each structure start
     * @return true if any of the references contain a valid structure start for the provided structure
     */
    private static boolean isAnyReferenceValidStartForStructure(ChunkRegion worldGenRegion, Structure structure, LongSet references, Predicate<StructureStart> filter) {
        StructureAccessor structureManager = worldGenRegion.toServerWorld().getStructureAccessor();

        for (long reference : references) {
            ChunkSectionPos structureStartSectionPos = ChunkSectionPos.from(new ChunkPos(reference), worldGenRegion.getBottomSectionCoord());
            if (!worldGenRegion.isChunkLoaded(structureStartSectionPos.getSectionX(), structureStartSectionPos.getSectionZ())) {
                continue;
            }

            Chunk structureStartChunkAccess = worldGenRegion.getChunk(structureStartSectionPos.getSectionX(), structureStartSectionPos.getSectionZ(), ChunkStatus.STRUCTURE_STARTS);

            StructureStart structureStart = structureManager.getStructureStart(structureStartSectionPos, structure, structureStartChunkAccess);
            if (structureStart != null && structureStart.hasChildren() && filter.test(structureStart)) {
                return true;
            }
        }

        return false;
    }
}