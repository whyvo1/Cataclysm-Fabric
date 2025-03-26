package com.github.l_ender.cataclysm.structures.jisaw;

import com.github.l_ender.cataclysm.init.ModStructures;
import com.github.l_ender.cataclysm.world.structures.terrainadaptation.EnhancedTerrainAdaptation;
import com.github.l_ender.cataclysm.world.structures.terrainadaptation.EnhancedTerrainAdaptationType;
import com.github.l_ender.cataclysm.world.structures.terrainadaptation.NoneAdaptation;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.StructureLiquidSettings;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.HeightContext;
import net.minecraft.world.gen.StructureTerrainAdaptation;
import net.minecraft.world.gen.heightprovider.HeightProvider;
import net.minecraft.world.gen.structure.DimensionPadding;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;

/**
 * Enhanced jigsaw structure that uses the {@link CataclysmJigsawManager} to assemble jigsaw structures.
 */
public class CataclysmJigsawStructure extends Structure {
    public static final int MAX_TOTAL_STRUCTURE_RADIUS = 128;
    public static final MapCodec<CataclysmJigsawStructure> CODEC = RecordCodecBuilder.<CataclysmJigsawStructure>mapCodec(builder -> builder
                    .group(
                            configCodecBuilder(builder),
                            StructurePool.REGISTRY_CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                            Identifier.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName),
                            Codec.intRange(0, 128).fieldOf("size").forGetter(structure -> structure.maxDepth),
                            HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight),
                            IntProvider.createValidatingCodec(0, 15).optionalFieldOf("x_offset_in_chunk", ConstantIntProvider.create(0)).forGetter(structure -> structure.xOffsetInChunk),
                            IntProvider.createValidatingCodec(0, 15).optionalFieldOf("z_offset_in_chunk", ConstantIntProvider.create(0)).forGetter(structure -> structure.zOffsetInChunk),
                            Codec.BOOL.optionalFieldOf("use_expansion_hack", false).forGetter(structure -> structure.useExpansionHack),
                            Heightmap.Type.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(structure -> structure.projectStartToHeightmap),
                            Codec.intRange(1, MAX_TOTAL_STRUCTURE_RADIUS).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter),
                            Codec.INT.optionalFieldOf("max_y").forGetter(structure -> structure.maxY),
                            Codec.INT.optionalFieldOf("min_y").forGetter(structure -> structure.minY),
                            EnhancedTerrainAdaptationType.ADAPTATION_CODEC.optionalFieldOf("enhanced_terrain_adaptation", NoneAdaptation.NONE).forGetter(structure -> structure.enhancedTerrainAdaptation),
                            DimensionPadding.CODEC.optionalFieldOf("dimension_padding", DimensionPadding.NONE).forGetter(structure -> structure.dimensionPadding),
                            StructureLiquidSettings.codec.optionalFieldOf("liquid_settings", StructureLiquidSettings.APPLY_WATERLOGGING).forGetter(structure -> structure.liquidSettings))
                    .apply(builder, CataclysmJigsawStructure::new))
            .validate(CataclysmJigsawStructure::validateRange);

    /**
     * The template pool to use for the starting piece.
     */
    public final RegistryEntry<StructurePool> startPool;

    /**
     * An optional resource location specifying the Name field of a jigsaw block in the starting pool.
     * If specified, the position of a matching jigsaw block will be used as the structure's starting position
     * when generating the structure. This will become the target position of the /locate command.
     */
    private final Optional<Identifier> startJigsawName;

    /**
     * The max depth, in Jigsaw pieces, the structure can generate before stopping.
     */
    public final int maxDepth;

    /**
     * Specifies the heights at which the structure can start generating.
     */
    public final HeightProvider startHeight;

    /**
     * The x offset, in blocks, from the chunk's starting corner position to the starting position of the structure.
     */
    public final IntProvider xOffsetInChunk;

    /**
     * The z offset, in blocks, from the chunk's starting corner position to the starting position of the structure.
     */
    public final IntProvider zOffsetInChunk;

    /**
     * Whether boundary adjustments should be performed on this structure.
     * In vanilla, only villages and pillager outposts have this enabled.
     * I recommend avoiding this, as it can cause weird issues if you don't know what you're doing.
     */
    public final boolean useExpansionHack;

    /**
     * Heightmap to use for determining starting y-position. If provided, the startPos
     * y-coordinate acts as an offset to this heightmap; otherwise, the startPos
     * y-coordinate is an absolute world coordinate.
     */
    public final Optional<Heightmap.Type> projectStartToHeightmap;

    /**
     * The radius of the maximum bounding box for the structure. Typical is 80,
     * but can be increased if your structure is particularly large.
     */
    public final int maxDistanceFromCenter;

    /**
     * Optional integer for specifying the max possible y-value of the structure.
     * If provided, no pieces of the structure will generate above this value.
     * If not provided, no max y-value will be enforced.
     * This is useful for structures that should only generate underground, for example.
     * Note that this is not the same as the max height of the structure.
     * The max height of the structure is determined by the max height of the pieces in the structure's pool,
     * and the ways in which they can be placed.
     */
    public final Optional<Integer> maxY;

    /**
     * Optional integer for specifying the min possible y-value of the structure.
     * If provided, no pieces of the structure will generate below this value.
     * If not provided, no min y-value will be enforced.
     */
    public final Optional<Integer> minY;

    /**
     * The enhanced terrain adaptation to use for this structure.
     * This allows structures to guarantee that terrain is generated in a certain way around them.
     * For example, ancient cities use this to ensure there is natural terrain below the city, and
     * air carved out above the city's ground level.
     * See {@link EnhancedTerrainAdaptation} and {@link EnhancedTerrainAdaptationType} for more information.
     */
    public final EnhancedTerrainAdaptation enhancedTerrainAdaptation;

    /**
     * Dimension padding for the structure. Same as vanilla.
     * Usually not necessary since we have the maxY and minY fields.
     */
    private final DimensionPadding dimensionPadding;

    /**
     * Liquid settings for the structure. Same as vanilla.
     * Can be overridden on a piece-by-piece basis.
     */
    private final StructureLiquidSettings liquidSettings;

    public CataclysmJigsawStructure(
            Config structureSettings,
            RegistryEntry<StructurePool> startPool,
            Optional<Identifier> startJigsawName,
            int maxDepth,
            HeightProvider startHeight,
            IntProvider xOffsetInChunk,
            IntProvider zOffsetInChunk,
            boolean useExpansionHack,
            Optional<Heightmap.Type> projectStartToHeightmap,
            int maxBlockDistanceFromCenter,
            Optional<Integer> maxY,
            Optional<Integer> minY,
            EnhancedTerrainAdaptation enhancedTerrainAdaptation,
            DimensionPadding dimensionPadding,
            StructureLiquidSettings liquidSettings
    ) {
        super(structureSettings);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.maxDepth = maxDepth;
        this.startHeight = startHeight;
        this.xOffsetInChunk = xOffsetInChunk;
        this.zOffsetInChunk = zOffsetInChunk;
        this.useExpansionHack = useExpansionHack;
        this.projectStartToHeightmap = projectStartToHeightmap;
        this.maxDistanceFromCenter = maxBlockDistanceFromCenter;
        this.maxY = maxY;
        this.minY = minY;
        this.enhancedTerrainAdaptation = enhancedTerrainAdaptation;
        this.dimensionPadding = dimensionPadding;
        this.liquidSettings = liquidSettings;
    }

    private static DataResult<CataclysmJigsawStructure> validateRange(CataclysmJigsawStructure structure) {
        if (structure.getTerrainAdaptation() != StructureTerrainAdaptation.NONE && structure.enhancedTerrainAdaptation != NoneAdaptation.NONE) {
            return DataResult.error(() -> "YUNG Structure cannot use both vanilla terrain_adaptation and enhanced_terrain_adaptation");
        }

        // Vanilla boundary check
        int vanillaEdgeBuffer = switch (structure.getTerrainAdaptation()) {
            case NONE -> 0;
            case BURY, BEARD_THIN, BEARD_BOX, ENCAPSULATE -> 12;
        };
        if (structure.maxDistanceFromCenter + vanillaEdgeBuffer > 128) {
            return DataResult.error(() -> "YUNG Structure's max_distance_from_center must not exceed 116 when using vanilla terrain_adaptation");
        }

        // Enhanced boundary check.
        // Note that it's still possible to have structure overflow issues if one of the structure's pieces has its own
        // enhanced_terrain_adaptation with an even bigger kernel radius than that of the rest of the structure!
        int enhancedEdgeBuffer = structure.enhancedTerrainAdaptation.getKernelRadius();
        if (structure.maxDistanceFromCenter + enhancedEdgeBuffer > 128) {
            return DataResult.error(() -> "YUNG Structure's max_distance_from_center + kernel radius (equal to half the enhanced_terrain_adaptation's kernel size) must not exceed 128");
        }

        return DataResult.success(structure);
    }

    @Override
    public @NotNull Optional<StructurePosition> getStructurePosition(Context context) {
        ChunkPos chunkPos = context.chunkPos();
        Random randomSource = context.random();
        int xOffset = this.xOffsetInChunk.get(randomSource);
        int zOffset = this.zOffsetInChunk.get(randomSource);
        int startY = this.startHeight.get(context.random(), new HeightContext(context.chunkGenerator(), context.world()));
        BlockPos startPos = new BlockPos(chunkPos.getOffsetX(xOffset), startY, chunkPos.getOffsetZ(zOffset));
        return CataclysmJigsawManager.assembleJigsawStructure(
                context,
                this.startPool,
                this.startJigsawName,
                this.maxDepth,
                startPos,
                this.useExpansionHack,
                this.projectStartToHeightmap,
                this.maxDistanceFromCenter,
                this.maxY,
                this.minY,
                this.dimensionPadding,
                this.liquidSettings
        );
    }

    @Override
    public @NotNull BlockBox expandBoxIfShouldAdaptNoise(@NotNull BlockBox boundingBox) {
        return super.expandBoxIfShouldAdaptNoise(boundingBox)
                .expand(this.enhancedTerrainAdaptation.getKernelRadius());
    }
    
    @Override
    public @NotNull StructureType<?> getType() {
        return ModStructures.CATACLYSM_JIGSAW;
    }
}
