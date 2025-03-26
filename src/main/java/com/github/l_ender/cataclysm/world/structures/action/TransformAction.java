package com.github.l_ender.cataclysm.world.structures.action;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.structures.jisaw.PieceEntry;
import com.github.l_ender.cataclysm.structures.jisaw.context.StructureContext;
import com.github.l_ender.cataclysm.structures.jisaw.element.CataclysmJigsawSinglePoolElement;
import com.mojang.datafixers.util.Either;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.Codec;
import java.util.List;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureLiquidSettings;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.structure.pool.SinglePoolElement;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.CheckedRandom;
import net.minecraft.util.math.random.ChunkRandom;

/**
 * Transforms target piece(s) into specified piece.
 */
public class TransformAction extends StructureAction {
    /**
     * Helper codec for a single template. Taken from {@link SinglePoolElement}.
     */
    private static final Codec<Either<Identifier, StructureTemplate>> TEMPLATE_CODEC =
            Codec.of(TransformAction::encodeTemplate, Identifier.CODEC.map(Either::left));

    public static final MapCodec<TransformAction> CODEC = RecordCodecBuilder.mapCodec((builder) -> builder
            .group(
                    TEMPLATE_CODEC.listOf().fieldOf("output").forGetter(action -> action.output),
                    Codec.INT.optionalFieldOf("x_offset", 0).forGetter(action -> action.xOffset),
                    Codec.INT.optionalFieldOf("y_offset", 0).forGetter(action -> action.yOffset),
                    Codec.INT.optionalFieldOf("z_offset", 0).forGetter(action -> action.zOffset))
            .apply(builder, TransformAction::new));

    /**
     * Method for encoding a single template, taken from {@link SinglePoolElement}.
     * Shouldn't actually be necessary since we are only ever decoding.
     */
    private static <T> DataResult<T> encodeTemplate(Either<Identifier, StructureTemplate> either, DynamicOps<T> ops, T data) {
        return either.left().isEmpty()
                ? DataResult.error(() -> "yungsapi - Cannot serialize a runtime pool element")
                : Identifier.CODEC.encode(either.left().get(), ops, data);
    }

    private final List<Either<Identifier, StructureTemplate>> output;

    private final int xOffset;

    private final int yOffset;

    private final int zOffset;

    public TransformAction(List<Either<Identifier, StructureTemplate>> output,
                           int xOffset,
                           int yOffset,
                           int zOffset) {
        this.output = output;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.zOffset = zOffset;
    }

    @Override
    public StructureActionType<?> type() {
        return StructureActionType.TRANSFORM;
    }


    @Override
    public void apply(StructureContext ctx, PieceEntry targetPieceEntry) {
        // Extract args from context
        StructureTemplateManager templateManager = ctx.structureTemplateManager();

        // Abort if missing any args
        if (templateManager == null) {
            Cataclysm.LOGGER.error("Missing required field 'structureTemplateManager' for transform action!");
            return;
        }

        // Transform piece, copying over most other data
        CataclysmJigsawSinglePoolElement old = (CataclysmJigsawSinglePoolElement) targetPieceEntry.getPiece().getPoolElement();
        ChunkRandom rand = new ChunkRandom(new CheckedRandom(0));
        rand.setDecoratorSeed(targetPieceEntry.getPiece().getPos().getX(),
                targetPieceEntry.getPiece().getPos().getY(),
                targetPieceEntry.getPiece().getPos().getX());

        // Randomly choose output piece
        Either<Identifier, StructureTemplate> newTemplate = this.output.get(rand.nextInt(this.output.size()));
        StructurePoolElement newElement = new CataclysmJigsawSinglePoolElement(newTemplate, old.processors,
                old.getProjection(), old.overrideLiquidSettings, old.name, old.maxCount, old.minRequiredDepth, old.maxPossibleDepth,
                old.isPriority, old.ignoreBounds, old.condition, old.enhancedTerrainAdaptation,
                old.deadendPool, old.modifiers);

        // New piece position
        BlockPos offset = new BlockPos(this.xOffset, this.yOffset, this.zOffset);
        offset = offset.rotate(targetPieceEntry.getPiece().getRotation());
        BlockPos newPos = targetPieceEntry.getPiece().getPos().add(offset);

        // New piece bounding box
        BlockBox newBoundingBox = newElement.getBoundingBox(templateManager, newPos, targetPieceEntry.getPiece().getRotation());
        Box newAabb = Box.from(newBoundingBox);
        targetPieceEntry.getBoxOctree().getValue().removeBox(targetPieceEntry.getPieceAabb());
        targetPieceEntry.getBoxOctree().getValue().addBox(newAabb);

        PoolStructurePiece newPiece = new PoolStructurePiece(
                templateManager,
                newElement,
                newPos,
                targetPieceEntry.getPiece().getGroundLevelDelta(),
                targetPieceEntry.getPiece().getRotation(),
                newBoundingBox,
                old.overrideLiquidSettings.orElse(StructureLiquidSettings.APPLY_WATERLOGGING)
        );

        targetPieceEntry.setPiece(newPiece);
    }
}
