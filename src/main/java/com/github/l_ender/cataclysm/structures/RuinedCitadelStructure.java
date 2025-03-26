package com.github.l_ender.cataclysm.structures;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Golem_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModStructures;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ShulkerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.SimpleStructurePiece;
import net.minecraft.structure.StructureContext;
import net.minecraft.structure.StructurePiecesCollector;
import net.minecraft.structure.StructurePiecesHolder;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.structure.processor.ProtectedBlocksStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.CheckedRandom;
import net.minecraft.util.math.random.ChunkRandom;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;
import java.util.Map;
import java.util.Optional;

public class RuinedCitadelStructure extends Structure {

    public static final Codec<RuinedCitadelStructure> CODEC = createCodec(RuinedCitadelStructure::new);

    private static final Identifier CITADEL1 = Cataclysm.modIdentifier("ruined_citadel1");
    private static final Identifier CITADEL2 = Cataclysm.modIdentifier("ruined_citadel2");
    private static final Identifier CITADEL3 = Cataclysm.modIdentifier("ruined_citadel3");
    private static final Identifier CITADEL4 = Cataclysm.modIdentifier("ruined_citadel4");
    private static final Identifier CITADEL5 = Cataclysm.modIdentifier("ruined_citadel5");
    private static final Identifier CITADEL6 = Cataclysm.modIdentifier("ruined_citadel6");
    private static final Identifier CITADEL7 = Cataclysm.modIdentifier("ruined_citadel7");
    private static final Identifier CITADEL8 = Cataclysm.modIdentifier("ruined_citadel8");
    private static final Identifier CITADEL9 = Cataclysm.modIdentifier("ruined_citadel9");
    private static final Identifier CITADEL10 = Cataclysm.modIdentifier("ruined_citadel10");
    private static final Identifier CITADEL11 = Cataclysm.modIdentifier("ruined_citadel11");
    private static final Identifier CITADEL12 = Cataclysm.modIdentifier("ruined_citadel12");
    private static final Identifier CITADEL13 = Cataclysm.modIdentifier("ruined_citadel13");
    private static final Identifier CITADEL14 = Cataclysm.modIdentifier("ruined_citadel14");
    private static final Identifier CITADEL15 = Cataclysm.modIdentifier("ruined_citadel15");
    private static final Identifier CITADEL16 = Cataclysm.modIdentifier("ruined_citadel16");
    private static final Identifier CITADEL17 = Cataclysm.modIdentifier("ruined_citadel17");
    private static final Identifier CITADEL18 = Cataclysm.modIdentifier("ruined_citadel18");


    private static final Map<Identifier, BlockPos> OFFSET = ImmutableMap.<Identifier, BlockPos>builder()
            .put(CITADEL1, new BlockPos(0, 1, 0))
            .put(CITADEL2, new BlockPos(0, 1, 0))
            .put(CITADEL3, new BlockPos(0, 1, 0))
            .put(CITADEL4, new BlockPos(0, 1, 0))
            .put(CITADEL5, new BlockPos(0, 1, 0))
            .put(CITADEL6, new BlockPos(0, 1, 0))
            .put(CITADEL7, new BlockPos(0, 1, 0))
            .put(CITADEL8, new BlockPos(0, 1, 0))
            .put(CITADEL9, new BlockPos(0, 1, 0))
            .put(CITADEL10, new BlockPos(0, 1, 0))
            .put(CITADEL11, new BlockPos(0, 1, 0))
            .put(CITADEL12, new BlockPos(0, 1, 0))
            .put(CITADEL13, new BlockPos(0, 1, 0))
            .put(CITADEL14, new BlockPos(0, 1, 0))
            .put(CITADEL15, new BlockPos(0, 1, 0))
            .put(CITADEL16, new BlockPos(0, 1, 0))
            .put(CITADEL17, new BlockPos(0, 1, 0))
            .put(CITADEL18, new BlockPos(0, 1, 0))
            .build();

    /*
     * Begins assembling your structure and where the pieces needs to go.
     */
    public static void start(StructureTemplateManager templateManager, BlockPos pos, BlockRotation rotation, StructurePiecesHolder pieceList, Random random) {
        int x = pos.getX();
        int z = pos.getZ();


        BlockPos rotationOffSet = new BlockPos(0, -45, 0).rotate(rotation);
        BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL5, blockpos, rotation));

        rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL14, blockpos, rotation));


        rotationOffSet = new BlockPos(0, -45, 37).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL6, blockpos, rotation));

        rotationOffSet = new BlockPos(0, 0, 37).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL15, blockpos, rotation));


        rotationOffSet = new BlockPos(0, -45, -37).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL4, blockpos, rotation));

        rotationOffSet = new BlockPos(0, 0, -37).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL13, blockpos, rotation));


        rotationOffSet = new BlockPos(-36, -45, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL2, blockpos, rotation));

        rotationOffSet = new BlockPos(-36, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL11, blockpos, rotation));


        rotationOffSet = new BlockPos(36, -45, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL8, blockpos, rotation));

        rotationOffSet = new BlockPos(36, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL17, blockpos, rotation));


        rotationOffSet = new BlockPos(-36, -45, -37).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL1, blockpos, rotation));

        rotationOffSet = new BlockPos(-36, 0, -37).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL10, blockpos, rotation));


        rotationOffSet = new BlockPos(-36, -45, 37).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL3, blockpos, rotation));

        rotationOffSet = new BlockPos(-36, 0, 37).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL12, blockpos, rotation));


        rotationOffSet = new BlockPos(36, -45, 37).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL9, blockpos, rotation));

        rotationOffSet = new BlockPos(36, 0, 37).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL18, blockpos, rotation));


        rotationOffSet = new BlockPos(36, -45, -37).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL7, blockpos, rotation));

        rotationOffSet = new BlockPos(36, 0, -37).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITADEL16, blockpos, rotation));


    }


    public RuinedCitadelStructure(Config p_227593_) {
        super(p_227593_);
    }

    public Optional<StructurePosition> getStructurePosition(Context p_228964_) {
        int i = p_228964_.chunkPos().x >> 16;
        int j = p_228964_.chunkPos().z >> 16;

        ChunkRandom worldgenrandom = new ChunkRandom(new CheckedRandom(0L));
        worldgenrandom.setSeed((long) (i ^ j << 9) ^ p_228964_.seed());
        worldgenrandom.nextInt();
        return getStructurePosition(p_228964_, Heightmap.Type.WORLD_SURFACE_WG, (p_228967_) -> generatePieces(p_228967_, p_228964_));
    }

    private static void generatePieces(StructurePiecesCollector p_197233_, Context p_197234_) {
        BlockPos blockpos = new BlockPos(p_197234_.chunkPos().getStartX(), 53, p_197234_.chunkPos().getStartZ());
        BlockRotation rotation = BlockRotation.random(p_197234_.random());
        RuinedCitadelStructure.start(p_197234_.structureTemplateManager(), blockpos, rotation, p_197233_, p_197234_.random());
    }

    @Override
    public StructureType<?> getType() {
        return ModStructures.RUINED_CITADEL;
    }

    @Override
    public GenerationStep.Feature getFeatureGenerationStep() {
        return GenerationStep.Feature.SURFACE_STRUCTURES;
    }

    public static class Piece extends SimpleStructurePiece {

        public Piece(StructureTemplateManager templateManagerIn, Identifier resourceLocationIn, BlockPos pos, BlockRotation rotation) {
            super(ModStructures.RCP, 0, templateManagerIn, resourceLocationIn, resourceLocationIn.toString(), makeSettings(rotation), makePosition(resourceLocationIn, pos));
        }

        public Piece(StructureTemplateManager templateManagerIn, NbtCompound tagCompound) {
            super(ModStructures.RCP, tagCompound, templateManagerIn, (p_162451_) -> makeSettings(BlockRotation.valueOf(tagCompound.getString("Rot"))));

        }

        public Piece(StructureContext context, NbtCompound tag) {
            this(context.structureTemplateManager(), tag);
        }

        private static StructurePlacementData makeSettings(BlockRotation p_163156_) {
            BlockIgnoreStructureProcessor blockignoreprocessor = BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS;


            return (new StructurePlacementData()).setRotation(p_163156_).setMirror(BlockMirror.NONE)
                    .addProcessor(blockignoreprocessor)
                    .addProcessor(new ProtectedBlocksStructureProcessor(BlockTags.FEATURES_CANNOT_REPLACE));
        }

        private static BlockPos makePosition(Identifier p_162453_, BlockPos p_162454_) {
            return p_162454_.add(OFFSET.get(p_162453_));
        }

        protected void writeNbt(StructureContext p_162444_, NbtCompound tagCompound) {
            super.writeNbt(p_162444_, tagCompound);
            tagCompound.putString("Rot", this.placementData.getRotation().name());
        }

        @Override
        protected void handleMetadata(String function, BlockPos pos, ServerWorldAccess worldIn, Random rand, BlockBox sbb) {
            if (sbb.contains(pos) && World.isValid(pos)) {
                if (function.startsWith("sentry")) {
                    worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                    ShulkerEntity shulker = EntityType.SHULKER.create(worldIn.toServerWorld());
                    if(shulker != null) {
                        shulker.setPosition((double) pos.getX() + 0.5D, pos.getY(), (double) pos.getZ() + 0.5D);
                        worldIn.spawnEntity(shulker);
                    }
                } else if (function.startsWith("mimic")) {
                    worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                    ShulkerEntity Silentshulkerentity = EntityType.SHULKER.create(worldIn.toServerWorld());
                    if(Silentshulkerentity != null) {
                        Silentshulkerentity.setPosition((double) pos.getX() + 0.5D, pos.getY(), (double) pos.getZ() + 0.5D);
                        Silentshulkerentity.setSilent(true);
                        worldIn.spawnEntity(Silentshulkerentity);
                    }
                } else if ("golem".equals(function)) {
                    Ender_Golem_Entity golem = ModEntities.ENDER_GOLEM.create(worldIn.toServerWorld());
                    worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                    golem.refreshPositionAndAngles(pos, 180.0F, 180.0F);
                    worldIn.spawnEntity(golem);
                }
            }
        }
    }
}