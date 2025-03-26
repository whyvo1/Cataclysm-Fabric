package com.github.l_ender.cataclysm.world.structures.placements;

import com.github.l_ender.cataclysm.init.ModStructurePlacementType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Optional;
import net.minecraft.registry.RegistryCodecs;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.structure.StructureSet;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.CheckedRandom;
import net.minecraft.util.math.random.ChunkRandom;
import net.minecraft.world.gen.chunk.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.gen.chunk.placement.SpreadType;
import net.minecraft.world.gen.chunk.placement.StructurePlacement;
import net.minecraft.world.gen.chunk.placement.StructurePlacementCalculator;
import net.minecraft.world.gen.chunk.placement.StructurePlacementType;

public class CataclysmRandomSpread extends RandomSpreadStructurePlacement {
    public static final MapCodec<CataclysmRandomSpread> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
            Vec3i.createOffsetCodec(16).optionalFieldOf("locate_offset", Vec3i.ZERO).forGetter(CataclysmRandomSpread::getLocateOffset),
            StructurePlacement.FrequencyReductionMethod.CODEC.optionalFieldOf("frequency_reduction_method", StructurePlacement.FrequencyReductionMethod.DEFAULT).forGetter(CataclysmRandomSpread::getFrequencyReductionMethod),
            Codec.floatRange(0.0F, 1.0F).optionalFieldOf("frequency", 1.0F).forGetter(CataclysmRandomSpread::getFrequency),
            Codecs.NONNEGATIVE_INT.fieldOf("salt").forGetter(CataclysmRandomSpread::getSalt),
            StructurePlacement.ExclusionZone.CODEC.optionalFieldOf("exclusion_zone").forGetter(CataclysmRandomSpread::getExclusionZone),
            SuperExclusionZone.CODEC.optionalFieldOf("super_exclusion_zone").forGetter(CataclysmRandomSpread::superExclusionZone),
            Codec.intRange(0, Integer.MAX_VALUE).fieldOf("spacing").forGetter(CataclysmRandomSpread::getSpacing),
            Codec.intRange(0, Integer.MAX_VALUE).fieldOf("separation").forGetter(CataclysmRandomSpread::getSeparation),
            SpreadType.CODEC.optionalFieldOf("spread_type", SpreadType.LINEAR).forGetter(CataclysmRandomSpread::getSpreadType),
            Codec.intRange(0, Integer.MAX_VALUE).optionalFieldOf("min_distance_from_world_origin").forGetter(CataclysmRandomSpread::minDistanceFromWorldOrigin)
    ).apply(instance, instance.stable(CataclysmRandomSpread::new)));

    private final int spacing;
    private final int separation;
    private final SpreadType spreadType;
    private final Optional<Integer> minDistanceFromWorldOrigin;
    private final Optional<SuperExclusionZone> superExclusionZone;

    public CataclysmRandomSpread(Vec3i locationOffset,
                                StructurePlacement.FrequencyReductionMethod frequencyReductionMethod,
                                float frequency,
                                int salt,
                                Optional<ExclusionZone> exclusionZone,
                                Optional<SuperExclusionZone> superExclusionZone,
                                int spacing,
                                int separation,
                                SpreadType spreadType,
                                Optional<Integer> minDistanceFromWorldOrigin
    ) {
        super(locationOffset, frequencyReductionMethod, frequency, salt, exclusionZone, spacing, separation, spreadType);
        this.spacing = spacing;
        this.separation = separation;
        this.spreadType = spreadType;
        this.minDistanceFromWorldOrigin = minDistanceFromWorldOrigin;
        this.superExclusionZone = superExclusionZone;

        if (spacing <= separation) {
            throw new RuntimeException("""
                Repurposed Structures: Spacing cannot be less or equal to separation.
                Please correct this error as there's no way to spawn this structure properly
                    Spacing: %s
                    Separation: %s.
            """.formatted(spacing, separation));
        }
    }

    @Override
    public int getSpacing() {
        return this.spacing;
    }

    @Override
    public int getSeparation() {
        return this.separation;
    }

    @Override
    public SpreadType getSpreadType() {
        return this.spreadType;
    }

    public Optional<Integer> minDistanceFromWorldOrigin() {
        return this.minDistanceFromWorldOrigin;
    }

    public Optional<SuperExclusionZone> superExclusionZone() {
        return this.superExclusionZone;
    }

    @Override
    public boolean shouldGenerate(StructurePlacementCalculator chunkGeneratorStructureState, int i, int j) {
        if (!super.shouldGenerate(chunkGeneratorStructureState, i, j)) {
            return false;
        }
        else {
            return this.superExclusionZone.isEmpty() || !this.superExclusionZone.get().isPlacementForbidden(chunkGeneratorStructureState, i, j);
        }
    }

    @Override
    public ChunkPos getStartChunk(long seed, int x, int z) {
        int regionX = Math.floorDiv(x, this.spacing);
        int regionZ = Math.floorDiv(z, this.spacing);
        ChunkRandom worldgenrandom = new ChunkRandom(new CheckedRandom(0L));
        worldgenrandom.setRegionSeed(seed, regionX, regionZ, this.getSalt());
        int diff = this.spacing - this.separation;
        int offsetX = this.spreadType.get(worldgenrandom, diff);
        int offsetZ = this.spreadType.get(worldgenrandom, diff);
        return new ChunkPos(regionX * this.spacing + offsetX, regionZ * this.spacing + offsetZ);
    }

    @Override
    protected boolean isStartChunk(StructurePlacementCalculator chunkGeneratorStructureState, int x, int z) {
        if (minDistanceFromWorldOrigin.isPresent()) {
            long xBlockPos = x * 16L;
            long zBlockPos = z * 16L;
            if ((xBlockPos * xBlockPos) + (zBlockPos * zBlockPos) <
                    (((long) minDistanceFromWorldOrigin.get()) * minDistanceFromWorldOrigin.get()))
            {
                return false;
            }
        }

        ChunkPos chunkpos = this.getStartChunk(chunkGeneratorStructureState.getStructureSeed(), x, z);
        return chunkpos.x == x && chunkpos.z == z;
    }

    @Override
    public StructurePlacementType<?> getType() {
        return ModStructurePlacementType.ADVANCED_RANDOM_SPREAD;
    }

    public record SuperExclusionZone(RegistryEntryList<StructureSet> otherSet, int chunkCount, Optional<Integer> allowedChunkCount) {
        public static final Codec<CataclysmRandomSpread.SuperExclusionZone> CODEC = RecordCodecBuilder.create(builder -> builder.group(
                RegistryCodecs.entryList(RegistryKeys.STRUCTURE_SET, StructureSet.CODEC).fieldOf("other_set").forGetter(CataclysmRandomSpread.SuperExclusionZone::otherSet),
                Codec.intRange(1, Integer.MAX_VALUE).fieldOf("chunk_count").forGetter(CataclysmRandomSpread.SuperExclusionZone::chunkCount),
                Codec.intRange(1, Integer.MAX_VALUE).optionalFieldOf("allowed_chunk_count").forGetter(CataclysmRandomSpread.SuperExclusionZone::allowedChunkCount)
        ).apply(builder, CataclysmRandomSpread.SuperExclusionZone::new));

        boolean isPlacementForbidden(StructurePlacementCalculator chunkGeneratorStructureState, int l, int j) {
            for (RegistryEntry<StructureSet> holder : this.otherSet) {
                if (chunkGeneratorStructureState.canGenerate(holder, l, j, this.chunkCount)) {
                    return true;
                }
            }

            if (this.allowedChunkCount.isPresent() && this.allowedChunkCount.get() > this.chunkCount) {
                boolean isAnyInRange = false;
                for (RegistryEntry<StructureSet> holder : this.otherSet) {
                    if (chunkGeneratorStructureState.canGenerate(holder, l, j, this.allowedChunkCount.get())) {
                        isAnyInRange = true;
                    }
                }
                if (!isAnyInRange) {
                    return false;
                }
            }

            return false;
        }
    }
}