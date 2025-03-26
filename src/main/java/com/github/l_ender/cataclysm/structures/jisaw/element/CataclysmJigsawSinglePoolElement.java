package com.github.l_ender.cataclysm.structures.jisaw.element;

import com.github.l_ender.cataclysm.init.ModJigsaw;
import com.github.l_ender.cataclysm.structures.jisaw.condition.StructureCondition;
import com.github.l_ender.cataclysm.world.structures.modifier.StructureModifier;
import com.github.l_ender.cataclysm.world.structures.terrainadaptation.EnhancedTerrainAdaptation;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Either;
import com.mojang.serialization.*;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.StructureBlockMode;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.StructureLiquidSettings;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.structure.pool.SinglePoolElement;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElementType;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.structure.processor.JigsawReplacementStructureProcessor;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.annotation.MethodsReturnNonnullByDefault;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Custom {@link SinglePoolElement} with support for many additional settings.
 */
@MethodsReturnNonnullByDefault
public class CataclysmJigsawSinglePoolElement extends CataclysmJigsawPoolElement {
    private static final Codec<Either<Identifier, StructureTemplate>> TEMPLATE_CODEC = Codec.of(CataclysmJigsawSinglePoolElement::encodeTemplate, Identifier.CODEC.map(Either::left));
    public static final MapCodec<CataclysmJigsawSinglePoolElement> CODEC = RecordCodecBuilder.mapCodec((builder) -> builder
            .group(
                    templateCodec(),
                    processorsCodec(),
                    projectionGetter(),
                    overrideLiquidSettingsCodec(),
                    nameCodec(),
                    maxCountCodec(),
                    minRequiredDepthCodec(),
                    maxPossibleDepthCodec(),
                    isPriorityCodec(),
                    ignoreBoundsCodec(),
                    conditionCodec(),
                    enhancedTerrainAdaptationCodec(),
                    Identifier.CODEC.optionalFieldOf("deadend_pool").forGetter(element -> element.deadendPool),
                    StructureModifier.CODEC.listOf().optionalFieldOf("modifiers", new ArrayList<>()).forGetter(element -> element.modifiers)
            ).apply(builder, CataclysmJigsawSinglePoolElement::new));

    public final Either<Identifier, StructureTemplate> template;

    public final RegistryEntry<StructureProcessorList> processors;

    public final Optional<StructureLiquidSettings> overrideLiquidSettings;

    /**
     * Whether this piece should apply dead end adjustments.
     * If enabled, this piece has the possibility of being converted into one of its deadend pool pieces under certain conditions:
     * <ul>
     *     <li>This piece has one or more jigsaw blocks in addition to the one required to connect to its parent piece.</li>
     *     <li>This piece is not able to generate any other pieces from itself, including encased pieces.
     *     This could be due to either overlap with other pieces or reaching the max depth.</li>
     * </ul>
     * If both of these conditions are met, then a piece marked for deadend adjustments will be replaced with
     * an appropriate piece from its deadend pool instead.
     * <br />
     * <p>
     * <b>Note that at least one of the deadend pool elements MUST be a "true" terminator, i.e. have NO jigsaw pieces
     * except the one required for connection to its parent piece.</b> If all of your fallback pieces have more than one
     * jigsaw block, your structure's generation may get stuck in an infinite loop!
     * </p>
     */
    public final Optional<Identifier> deadendPool;

    /**
     * Post-placement modifiers.
     * These are modifications run on a piece after the entire structure's layout has been generated,
     * allowing for last-second conditional changes.
     */
    public final List<StructureModifier> modifiers;

    public CataclysmJigsawSinglePoolElement(
            Either<Identifier, StructureTemplate> template,
            RegistryEntry<StructureProcessorList> processors,
            StructurePool.Projection projection,
            Optional<StructureLiquidSettings> overrideLiquidSettings,
            Optional<String> name,
            Optional<Integer> maxCount,
            Optional<Integer> minRequiredDepth,
            Optional<Integer> maxPossibleDepth,
            boolean isPriority,
            boolean ignoreBounds,
            StructureCondition condition,
            Optional<EnhancedTerrainAdaptation> enhancedTerrainAdaptation,
            Optional<Identifier> deadendPool,
            List<StructureModifier> modifiers
    ) {
        super(projection, name, maxCount, minRequiredDepth, maxPossibleDepth, isPriority, ignoreBounds, condition, enhancedTerrainAdaptation);
        this.template = template;
        this.processors = processors;
        this.overrideLiquidSettings = overrideLiquidSettings;
        this.deadendPool = deadendPool;
        this.modifiers = modifiers;
    }

    @Override
    public Vec3i getStart(StructureTemplateManager structureTemplateManager, BlockRotation rotation) {
        StructureTemplate structureTemplate = this.getTemplate(structureTemplateManager);
        return structureTemplate.getRotatedSize(rotation);
    }

    @Override
    public List<StructureTemplate.StructureBlockInfo> getStructureBlockInfos(
            StructureTemplateManager structureTemplateManager,
            BlockPos blockPos,
            BlockRotation rotation,
            Random randomSource
    ) {
        StructureTemplate structureTemplate = this.getTemplate(structureTemplateManager);
        ObjectArrayList<StructureTemplate.StructureBlockInfo> jigsawBlocks = structureTemplate.getInfosForBlock(blockPos, (new StructurePlacementData()).setRotation(rotation), Blocks.JIGSAW, true);
        Util.shuffle(jigsawBlocks, randomSource);
        return jigsawBlocks;
    }

    @Override
    public BlockBox getBoundingBox(StructureTemplateManager structureTemplateManager, BlockPos blockPos, BlockRotation rotation) {
        StructureTemplate structureTemplate = this.getTemplate(structureTemplateManager);
        return structureTemplate.calculateBoundingBox((new StructurePlacementData()).setRotation(rotation), blockPos);
    }

    @Override
    public boolean generate(StructureTemplateManager structureTemplateManager,
                         StructureWorldAccess worldGenLevel,
                         StructureAccessor structureManager,
                         ChunkGenerator chunkGenerator,
                         BlockPos pos,
                         BlockPos pivotPos,
                         BlockRotation rotation,
                         BlockBox boundingBox,
                         Random randomSource,
                         StructureLiquidSettings liquidSettings,
                         boolean replaceJigsaws
    ) {
        StructureTemplate structureTemplate = this.getTemplate(structureTemplateManager);
        StructurePlacementData structurePlaceSettings = this.getSettings(rotation, boundingBox, liquidSettings, replaceJigsaws);
        if (!structureTemplate.place(worldGenLevel, pos, pivotPos, structurePlaceSettings, randomSource, 18)) {
            return false;
        } else {
            for (StructureTemplate.StructureBlockInfo structureBlockInfo : StructureTemplate.process(worldGenLevel, pos, pivotPos, structurePlaceSettings, this.getDataMarkers(structureTemplateManager, pos, rotation, false))) {
                this.method_16756(worldGenLevel, structureBlockInfo, pos, rotation, randomSource, boundingBox);
            }

            return true;
        }
    }

    public Optional<Identifier> getDeadendPool() {
        return this.deadendPool;
    }

    public boolean hasModifiers() {
        return !this.modifiers.isEmpty();
    }

    public StructureTemplate getTemplate(StructureTemplateManager structureTemplateManager) {
        return this.template.map(structureTemplateManager::getTemplateOrBlank, Function.identity());
    }

    public StructurePoolElementType<?> getType() {
        return ModJigsaw.CATACLYSM_ELEMENT;
    }

    public String toString() {
        return String.format("YungJigsawSingle[%s][%s][%s][%s]",
                this.name.orElse("<unnamed>"),
                this.template,
                this.maxCount.isPresent() ? maxCount.get() : "no max count",
                this.isPriority);
    }

    private StructurePlacementData getSettings(BlockRotation rotation, BlockBox boundingBox, StructureLiquidSettings liquidSettings, boolean replaceJigsaws) {
        StructurePlacementData structurePlaceSettings = new StructurePlacementData();
        structurePlaceSettings.setBoundingBox(boundingBox);
        structurePlaceSettings.setRotation(rotation);
        structurePlaceSettings.setUpdateNeighbors(true);
        structurePlaceSettings.setIgnoreEntities(false);
        structurePlaceSettings.addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS);
        structurePlaceSettings.setInitializeMobs(true);
        structurePlaceSettings.setLiquidSettings(this.overrideLiquidSettings.orElse(liquidSettings));
        if (!replaceJigsaws) {
            structurePlaceSettings.addProcessor(JigsawReplacementStructureProcessor.INSTANCE);
        }

        this.processors.value().getList().forEach(structurePlaceSettings::addProcessor);
        this.getProjection().getProcessors().forEach(structurePlaceSettings::addProcessor);
        return structurePlaceSettings;
    }

    private List<StructureTemplate.StructureBlockInfo> getDataMarkers(StructureTemplateManager structureTemplateManager, BlockPos blockPos, BlockRotation rotation, boolean isPositionLocal) {
        StructureTemplate structureTemplate = this.getTemplate(structureTemplateManager);
        List<StructureTemplate.StructureBlockInfo> structureBlocks = structureTemplate.getInfosForBlock(blockPos, (new StructurePlacementData()).setRotation(rotation), Blocks.STRUCTURE_BLOCK, isPositionLocal);
        List<StructureTemplate.StructureBlockInfo> dataBlocks = Lists.newArrayList();

        for (StructureTemplate.StructureBlockInfo block : structureBlocks) {
            StructureBlockMode structureMode = StructureBlockMode.valueOf(block.nbt().getString("mode"));
            if (structureMode == StructureBlockMode.DATA) {
                dataBlocks.add(block);
            }
        }

        return dataBlocks;
    }

    public static <E extends CataclysmJigsawSinglePoolElement> RecordCodecBuilder<E, RegistryEntry<StructureProcessorList>> processorsCodec() {
        return StructureProcessorType.REGISTRY_CODEC.fieldOf("processors").forGetter(element -> element.processors);
    }

    public static <E extends CataclysmJigsawSinglePoolElement> RecordCodecBuilder<E, Either<Identifier, StructureTemplate>> templateCodec() {
        return TEMPLATE_CODEC.fieldOf("location").forGetter(element -> element.template);
    }

    public static <E extends CataclysmJigsawSinglePoolElement> RecordCodecBuilder<E, Optional<StructureLiquidSettings>> overrideLiquidSettingsCodec() {
        return StructureLiquidSettings.codec.optionalFieldOf("override_liquid_settings").forGetter(element -> element.overrideLiquidSettings);
    }

    private static <T> DataResult<T> encodeTemplate(Either<Identifier, StructureTemplate> either, DynamicOps<T> ops, T template) {
        Optional<Identifier> optional = either.left();
        return optional.isEmpty() ? DataResult.error(() -> "Can not serialize a runtime pool element") : Identifier.CODEC.encode(optional.get(), ops, template);
    }
}
