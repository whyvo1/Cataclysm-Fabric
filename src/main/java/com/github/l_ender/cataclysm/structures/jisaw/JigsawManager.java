package com.github.l_ender.cataclysm.structures.jisaw;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.structures.jisaw.assembler.JigsawStructureAssembler;
import com.github.l_ender.cataclysm.structures.jisaw.context.StructureContext;
import com.github.l_ender.cataclysm.structures.jisaw.element.CataclysmJigsawPoolElement;
import com.github.l_ender.cataclysm.util.BoxOctree;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureLiquidSettings;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.structure.pool.EmptyPoolElement;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.ChunkRandom;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.structure.DimensionPadding;
import net.minecraft.world.gen.structure.Structure;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Optional;

public class JigsawManager {
    public static Optional<Structure.StructurePosition> assembleJigsawStructure(
            Structure.Context generationContext,
            RegistryEntry<StructurePool> startPool,
            Optional<Identifier> startJigsawNameOptional,
            int maxDepth,
            BlockPos locatePos, // The original starting position of the structure, also where /locate points to
            boolean useExpansionHack, // Used to be doBoundaryAdjustments
            Optional<Heightmap.Type> projectStartToHeightmap,
            int maxDistanceFromCenter, // Used to be structureBoundingBoxRadius
            Optional<Integer> maxY,
            Optional<Integer> minY,
            DimensionPadding dimensionPadding,
            StructureLiquidSettings liquidSettings

    ) {
        // Extract data from context
        DynamicRegistryManager registryAccess = generationContext.dynamicRegistryManager();
        Registry<StructurePool> registry = registryAccess.get(RegistryKeys.TEMPLATE_POOL);
        ChunkGenerator chunkGenerator = generationContext.chunkGenerator();
        StructureTemplateManager structureManager = generationContext.structureTemplateManager();
        HeightLimitView levelHeightAccessor = generationContext.world();
        ChunkRandom worldgenRandom = generationContext.random();

        // Grab a random starting piece from the start pool
        Optional<PoolStructurePiece> startPieceOptional = getStartPiece(startPool, startJigsawNameOptional, locatePos, liquidSettings, generationContext);
        if (startPieceOptional.isEmpty()) {
            return Optional.empty();
        }
        PoolStructurePiece startPiece = startPieceOptional.get();

        // Offset vector from the /locate position to the piece's starting position.
        // This will be a zero vector if no start jigsaw name was specified.
        Vec3i startingPosOffset = locatePos.subtract(startPiece.getPos());

        // Grab some data regarding starting piece's bounding box & position
        BlockBox pieceBoundingBox = startPiece.getBoundingBox();
        int bbCenterX = (pieceBoundingBox.getMaxX() + pieceBoundingBox.getMinX()) / 2;
        int bbCenterZ = (pieceBoundingBox.getMaxZ() + pieceBoundingBox.getMinZ()) / 2;
        // Note that the bbCenterY does not actually refer to the center of the piece, unlike the bbCenterX/Z variables.
        // If a heightmap is used, the bbCenterY will be the y-value of the /locate position (anchor pos) after adjusting for the heightmap.
        // Otherwise, the bbCenterY is simply the starting position's y-value. I'm not sure why it uses that position and not the /locate position,
        // but that's vanilla behavior. It almost certainly won't make a difference anyway, as structures are basically never that tall.
        int bbCenterY = projectStartToHeightmap
                .map(types -> locatePos.getY() + chunkGenerator.getHeightOnGround(bbCenterX, bbCenterZ, types, levelHeightAccessor, generationContext.noiseConfig()))
                .orElseGet(() -> startPiece.getPos().getY());
        int adjustedPieceCenterY = bbCenterY + startingPosOffset.getY();

        // Move the starting piece to account for any y-level change due to heightmap and/or groundLevelDelta
        int yAdjustment = pieceBoundingBox.getMinY() + startPiece.getGroundLevelDelta();
        startPiece.translate(0, bbCenterY - yAdjustment, 0);

        // Establish max bounds of entire structure.
        // Make sure the supplied distance is large enough to cover the size of your entire structure.
        Box aABB = new Box(
                bbCenterX - maxDistanceFromCenter, adjustedPieceCenterY - maxDistanceFromCenter, bbCenterZ - maxDistanceFromCenter,
                bbCenterX + maxDistanceFromCenter + 1, adjustedPieceCenterY + maxDistanceFromCenter + 1, bbCenterZ + maxDistanceFromCenter + 1);
        BoxOctree maxStructureBounds = new BoxOctree(aABB); // The maximum boundary of the entire structure
        maxStructureBounds.addBox(Box.from(pieceBoundingBox)); // Add start piece to our structure's bounds

        return Optional.of(new Structure.StructurePosition(
                new BlockPos(bbCenterX, adjustedPieceCenterY, bbCenterZ),
                (structurePiecesBuilder) -> {
                    if (maxDepth <= 0) { // Realistically this should never be true. Why make a jigsaw config with a non-positive size?
                        return;
                    }

                    // Create assembler + initial entry
                    JigsawStructureAssembler assembler = new JigsawStructureAssembler(new JigsawStructureAssembler.Settings()
                            .poolRegistry(registry)
                            .maxDepth(maxDepth)
                            .chunkGenerator(chunkGenerator)
                            .structureTemplateManager(structureManager)
                            .randomState(generationContext.noiseConfig())
                            .biomeSource(generationContext.biomeSource())
                            .rand(worldgenRandom)
                            .maxY(maxY)
                            .minY(minY)
                            .useExpansionHack(useExpansionHack)
                            .levelHeightAccessor(levelHeightAccessor)
                            .dimensionPadding(dimensionPadding)
                            .liquidSettings(liquidSettings));

                    // Add the start piece to the assembler & assemble the structure
                    assembler.assembleStructure(startPiece, maxStructureBounds);
                    assembler.addAllPiecesToStructureBuilder(structurePiecesBuilder);
                }));
    }

    /**
     * Returns a piece from the provided pool to be used as the starting piece for a structure.
     * Pieces are chosen randomly, but some conditions as well as the isPriority flag are respected.
     * <p>
     * Note that only some conditions are supported. Conditions checking for things like piece position or orientation
     * should not be used, as instead those checks can be performed on the structure's placement itself.
     */
    private static Optional<PoolStructurePiece> getStartPiece(
            RegistryEntry<StructurePool> startPoolHolder,
            Optional<Identifier> startJigsawNameOptional,
            BlockPos locatePos,
            StructureLiquidSettings liquidSettings,
            Structure.Context generationContext
    ) {
        StructureTemplateManager structureTemplateManager = generationContext.structureTemplateManager();
        Random rand = generationContext.random();

        StructurePool startPool = startPoolHolder.value();
        ObjectArrayList<Pair<StructurePoolElement, Integer>> candidatePoolElements = new ObjectArrayList<>(startPool.elementCounts);

        // Shuffle our candidate pool elements
        Util.shuffle(candidatePoolElements, rand);

        // Get a random orientation for starting piece
        BlockRotation rotation = BlockRotation.random(rand);

        // Sum of weights in all pieces in the pool.
        // When choosing a piece, we will remove its weight from this sum.
        int totalWeightSum = candidatePoolElements.stream().mapToInt(Pair::getSecond).reduce(0, Integer::sum);

        while (!candidatePoolElements.isEmpty() && totalWeightSum > 0) {
            Pair<StructurePoolElement, Integer> chosenPoolElementPair = null;

            // First, check for any priority pieces
            for (Pair<StructurePoolElement, Integer> candidatePiecePair : candidatePoolElements) {
                StructurePoolElement candidatePiece = candidatePiecePair.getFirst();
                if (candidatePiece instanceof CataclysmJigsawPoolElement yungElement && yungElement.isPriorityPiece()) {
                    chosenPoolElementPair = candidatePiecePair;
                    break;
                }
            }

            // Randomly choose piece if priority piece wasn't selected
            if (chosenPoolElementPair == null) {
                // Random weight used to choose random piece from the pool of candidates
                int chosenWeight = rand.nextInt(totalWeightSum) + 1;

                // Randomly choose a candidate piece
                for (Pair<StructurePoolElement, Integer> candidate : candidatePoolElements) {
                    chosenWeight -= candidate.getSecond();
                    if (chosenWeight <= 0) {
                        chosenPoolElementPair = candidate;
                        break;
                    }
                }
            }

            // Extract data from the chosen piece pair.
            StructurePoolElement chosenPoolElement = chosenPoolElementPair.getFirst();
            int chosenPieceWeight = chosenPoolElementPair.getSecond();

            if (chosenPoolElement == EmptyPoolElement.INSTANCE) {
                return Optional.empty();
            }

            BlockPos anchorPos;
            if (startJigsawNameOptional.isPresent()) {
                Identifier name = startJigsawNameOptional.get();
                Optional<BlockPos> optional = getPosOfJigsawBlockWithName(chosenPoolElement, name, locatePos, rotation, structureTemplateManager, rand);
                if (optional.isEmpty()) {
                    Cataclysm.LOGGER.error("No starting jigsaw with Name {} found in start pool {}", name, startPoolHolder.getKey()
                            .map(pool -> pool.getValue().toString())
                            .orElse("<unregistered>"));
                    return Optional.empty();
                }

                anchorPos = optional.get();
            } else {
                anchorPos = locatePos;
            }

            // We adjust the starting position such that, if a named start jigsaw is being used (i.e. an anchor),
            // then the anchor's position will be located at the original starting position.
            Vec3i startingPosOffset = anchorPos.subtract(locatePos);
            BlockPos adjustedStartPos = locatePos.subtract(startingPosOffset);

            // Validate conditions for this piece, if applicable
            if (chosenPoolElement instanceof CataclysmJigsawPoolElement yungElement) {
                StructureContext ctx = new StructureContext.Builder()
                        .structureTemplateManager(structureTemplateManager)
                        .pos(adjustedStartPos)
                        .rotation(rotation)
                        .depth(0)
                        .random(rand)
                        .randomState(generationContext.noiseConfig())
                        .biomeSource(generationContext.biomeSource())
                        .build();
                if (!yungElement.passesConditions(ctx)) {
                    totalWeightSum -= chosenPieceWeight;
                    candidatePoolElements.remove(chosenPoolElementPair);
                    continue; // Abort this piece if it doesn't pass conditions check
                }
            }

            // Instantiate piece
            return Optional.of(new PoolStructurePiece(
                    structureTemplateManager,
                    chosenPoolElement,
                    adjustedStartPos,
                    chosenPoolElement.getGroundLevelDelta(),
                    rotation,
                    chosenPoolElement.getBoundingBox(structureTemplateManager, adjustedStartPos, rotation),
                    liquidSettings
            ));
        }
        return Optional.empty();
    }
    /**
     * Returns a jigsaw block with the specified name in the StructurePoolElement.
     * If no such jigsaw block is found, returns an empty Optional.
     * <p>
     * This is used for starting pieces, when you want /locate to point to a position other than the
     * corner of the start piece, such as the center of ancient cities.
     */
    private static Optional<BlockPos> getPosOfJigsawBlockWithName(
            StructurePoolElement structurePoolElement,
            Identifier name,
            BlockPos startPos,
            BlockRotation rotation,
            StructureTemplateManager structureTemplateManager,
            Random rand
    ) {
        // Wrap in try-catch because for some reason, getShuffledJigsawBlocks rarely throws a ConcurrentModificationException.
        // We'd rather just ignore the anchor jigsaw block than crash the game.
        try {
            List<StructureTemplate.StructureBlockInfo> shuffledJigsawBlocks = structurePoolElement.getStructureBlockInfos(structureTemplateManager, startPos, rotation, rand);
            for (StructureTemplate.StructureBlockInfo jigsawBlockInfo : shuffledJigsawBlocks) {
                Identifier jigsawBlockName = Identifier.tryParse(jigsawBlockInfo.nbt().getString("name"));
                if (name.equals(jigsawBlockName)) {
                    return Optional.of(jigsawBlockInfo.pos());
                }
            }
        } catch (ConcurrentModificationException e) {
            Cataclysm.LOGGER.error("Encountered unexpected ConcurrentModException while trying to get jigsaw block with name {} from structure pool element {}", name, structurePoolElement);
            Cataclysm.LOGGER.error("Ignoring - the structure will still generate, but /locate will not point to the structure's anchor block.");
            return Optional.empty();
        }

        return Optional.empty();
    }
}
