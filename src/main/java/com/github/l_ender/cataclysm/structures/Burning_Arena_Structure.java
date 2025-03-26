package com.github.l_ender.cataclysm.structures;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModStructures;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Blocks;
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
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;
import java.util.Map;
import java.util.Optional;

public class Burning_Arena_Structure extends Structure {

    public static final MapCodec<Burning_Arena_Structure> CODEC = createCodec(Burning_Arena_Structure::new);

    private static final Identifier ARENA1 = Cataclysm.modIdentifier("burning_arena1");
    private static final Identifier ARENA2 = Cataclysm.modIdentifier("burning_arena2");
    private static final Identifier ARENA3 = Cataclysm.modIdentifier("burning_arena3");
    private static final Identifier ARENA4 = Cataclysm.modIdentifier("burning_arena4");
    private static final Identifier ARENA5 = Cataclysm.modIdentifier("burning_arena5");
    private static final Identifier ARENA6 = Cataclysm.modIdentifier("burning_arena6");
    private static final Identifier ARENA7 = Cataclysm.modIdentifier("burning_arena7");
    private static final Identifier ARENA8 = Cataclysm.modIdentifier("burning_arena8");

    private static final Map<Identifier, BlockPos> OFFSET = ImmutableMap.<Identifier, BlockPos>builder()
            .put(ARENA1, new BlockPos(0, 1, 0))
            .put(ARENA2, new BlockPos(0, 1, 0))
            .put(ARENA3, new BlockPos(0, 1, 0))
            .put(ARENA4, new BlockPos(0, 1, 0))
            .put(ARENA5, new BlockPos(0, 1, 0))
            .put(ARENA6, new BlockPos(0, 1, 0))
            .put(ARENA7, new BlockPos(0, 1, 0))
            .put(ARENA8, new BlockPos(0, 1, 0))
            .build();


    /*
     * Begins assembling your structure and where the pieces needs to go.
     */
    public static void start(StructureTemplateManager templateManager, BlockPos pos, BlockRotation rotation, StructurePiecesHolder pieceList, Random random) {
        int x = pos.getX();
        int z = pos.getZ();

        BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA1, blockpos, rotation));

        rotationOffSet = new BlockPos(0, 0, 38).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA2, blockpos, rotation));

        rotationOffSet = new BlockPos(47, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA3, blockpos, rotation));

        rotationOffSet = new BlockPos(47, 0, 38).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA4, blockpos, rotation));

        rotationOffSet = new BlockPos(0, 48, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA5, blockpos, rotation));

        rotationOffSet = new BlockPos(0, 48, 38).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA6, blockpos, rotation));

        rotationOffSet = new BlockPos(47, 48, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA7, blockpos, rotation));

        rotationOffSet = new BlockPos(47, 48, 38).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA8, blockpos, rotation));
    }

    public Burning_Arena_Structure(Config p_227593_) {
        super(p_227593_);
    }
    
    public Optional<StructurePosition> getStructurePosition(Context p_228964_) {
        int i = p_228964_.chunkPos().x >> 16;
        int j = p_228964_.chunkPos().z >> 16;
        BlockPos blockpos = new BlockPos(p_228964_.chunkPos().getStartX(), 21, p_228964_.chunkPos().getStartZ());
        ChunkRandom worldgenrandom = new ChunkRandom(new CheckedRandom(0L));
        worldgenrandom.setSeed((long) (i ^ j << 9) ^ p_228964_.seed());
        worldgenrandom.nextInt();
        return Optional.of(new StructurePosition(blockpos, (p_228526_) -> {
            generatePieces(p_228526_, p_228964_);
        }));
    }

    private static void generatePieces(StructurePiecesCollector p_197233_, Context p_197234_) {
        BlockPos blockpos = new BlockPos(p_197234_.chunkPos().getStartX(), 21, p_197234_.chunkPos().getStartZ());
        BlockRotation rotation = BlockRotation.random(p_197234_.random());
        Burning_Arena_Structure.start(p_197234_.structureTemplateManager(), blockpos, rotation, p_197233_, p_197234_.random());
    }

    @Override
    public StructureType<?> getType() {
        return ModStructures.BURNING_ARENA;
    }

    @Override
    public GenerationStep.Feature getFeatureGenerationStep() {
        return GenerationStep.Feature.SURFACE_STRUCTURES;
    }

    public static class Piece extends SimpleStructurePiece {

        public Piece(StructureTemplateManager templateManagerIn, Identifier resourceLocationIn, BlockPos pos, BlockRotation rotation) {
            super(ModStructures.BAP, 0, templateManagerIn, resourceLocationIn, resourceLocationIn.toString(), makeSettings(rotation), makePosition(resourceLocationIn, pos));
        }

        public Piece(StructureTemplateManager templateManagerIn, NbtCompound tagCompound) {
            super(ModStructures.BAP, tagCompound, templateManagerIn, (p_162451_) -> {
                return makeSettings(BlockRotation.valueOf(tagCompound.getString("Rot")));
            });

        }

        public Piece(StructureContext context, NbtCompound tag) {
            this(context.structureTemplateManager(), tag);
        }

        private static StructurePlacementData makeSettings(BlockRotation p_163156_) {
            BlockIgnoreStructureProcessor blockignoreprocessor = BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS;

            StructurePlacementData structureplacesettings = (new StructurePlacementData()).setRotation(p_163156_).setMirror(BlockMirror.NONE)
                    .addProcessor(blockignoreprocessor)
                    .addProcessor(new ProtectedBlocksStructureProcessor(BlockTags.FEATURES_CANNOT_REPLACE));


            return structureplacesettings;
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
            if ("revenant".equals(function)) {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                Ignited_Revenant_Entity revenant = ModEntities.IGNITED_REVENANT.create(worldIn.toServerWorld());
                revenant.refreshPositionAndAngles(pos, 180.0F, 180.0F);
                worldIn.spawnEntity(revenant);
            }
        }
    }
}
