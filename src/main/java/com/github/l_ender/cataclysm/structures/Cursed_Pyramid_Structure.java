package com.github.l_ender.cataclysm.structures;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.entity.AnimationMonster.Koboleton_Entity;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Kobolediator_Entity;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Wadjet_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModStructures;
import com.github.l_ender.cataclysm.world.structures.Processor.WaterLoggingFixProcessor;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.SimpleStructurePiece;
import net.minecraft.structure.StructureContext;
import net.minecraft.structure.StructurePiecesCollector;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.structure.processor.ProtectedBlocksStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.noise.NoiseConfig;
import net.minecraft.world.gen.structure.StructureType;
import java.util.Map;

public class Cursed_Pyramid_Structure extends CataclysmStructure {

    public static final Codec<Cursed_Pyramid_Structure> CODEC = createCodec(Cursed_Pyramid_Structure::new);

    private static final Identifier LOWER1 = Cataclysm.modIdentifier("cursed_pyramid_lower1");
    private static final Identifier LOWER2 = Cataclysm.modIdentifier("cursed_pyramid_lower2");
    private static final Identifier LOWER3 = Cataclysm.modIdentifier("cursed_pyramid_lower3");
    private static final Identifier LOWER4 = Cataclysm.modIdentifier("cursed_pyramid_lower4");
    private static final Identifier UPPER1 = Cataclysm.modIdentifier("cursed_pyramid_upper1");
    private static final Identifier UPPER2 = Cataclysm.modIdentifier("cursed_pyramid_upper2");
    private static final Identifier UPPER3 = Cataclysm.modIdentifier("cursed_pyramid_upper3");
    private static final Identifier UPPER4 = Cataclysm.modIdentifier("cursed_pyramid_upper4");
    private static final Identifier OBELISK1 = Cataclysm.modIdentifier("cursed_pyramid_obelisk1");
    private static final Identifier OBELISK2 = Cataclysm.modIdentifier("cursed_pyramid_obelisk2");

    private static final Map<Identifier, BlockPos> OFFSET = ImmutableMap.<Identifier, BlockPos>builder()
            .put(LOWER1, new BlockPos(0, 1, 0))
            .put(LOWER2, new BlockPos(0, 1, 0))
            .put(LOWER3, new BlockPos(0, 1, 0))
            .put(LOWER4, new BlockPos(0, 1, 0))
            .put(UPPER1, new BlockPos(0, 1, 0))
            .put(UPPER2, new BlockPos(0, 1, 0))
            .put(UPPER3, new BlockPos(0, 1, 0))
            .put(UPPER4, new BlockPos(0, 1, 0))
            .put(OBELISK1, new BlockPos(0, 1, 0))
            .put(OBELISK2, new BlockPos(0, 1, 0))
            .build();


    /*
     * Begins assembling your structure and where the pieces needs to go.
     */

    public Cursed_Pyramid_Structure(Config p_227593_) {
        super(p_227593_);
    }


    private static BlockPos posToSurface(ChunkGenerator generator, BlockPos pos, HeightLimitView heightAccessor, NoiseConfig state) {
        int surfaceY = generator.getHeight(pos.getX(), pos.getZ(), Heightmap.Type.WORLD_SURFACE_WG, heightAccessor, state);
        return new BlockPos(pos.getX(), surfaceY - 1, pos.getZ());
    }

    @Override
    public void generatePieces(StructurePiecesCollector builder, Context context) {
        StructureTemplateManager templateManager = context.structureTemplateManager();
        BlockRotation rotation = BlockRotation.values()[context.random().nextInt(BlockRotation.values().length)];
        int x = (context.chunkPos().x << 4) + 7;
        int z = (context.chunkPos().z << 4) + 7;
        BlockPos centerPos = new BlockPos(x, 1, z);

        ChunkGenerator generator = context.chunkGenerator();
        HeightLimitView heightLimitView = context.world();

        int surfaceY = generator.getHeight(centerPos.getX(), centerPos.getZ(), Heightmap.Type.WORLD_SURFACE_WG, heightLimitView, context.noiseConfig());
        int oceanFloorY = generator.getHeight(centerPos.getX(), centerPos.getZ(), Heightmap.Type.OCEAN_FLOOR_WG, heightLimitView, context.noiseConfig());
        if (oceanFloorY < surfaceY) return;

        BlockPos spawncenterPos = posToSurface(generator, centerPos, heightLimitView, context.noiseConfig());

        BlockPos obelisk1Offset = spawncenterPos.add(new BlockPos(20, -4, 94).rotate(rotation));
        BlockPos obelisk2Offset = spawncenterPos.add(new BlockPos(45, -4, 94).rotate(rotation));

        BlockPos lower1Offset = spawncenterPos.add(0, -39, 0);
        BlockPos lower2Offset = spawncenterPos.add(new BlockPos(0, -39, 47).rotate(rotation));
        BlockPos lower3Offset = spawncenterPos.add(new BlockPos(47, -39, 0).rotate(rotation));
        BlockPos lower4Offset = spawncenterPos.add(new BlockPos(47, -39, 47).rotate(rotation));

        BlockPos upper1Offset = spawncenterPos.add(0, 9, 0);
        BlockPos upper2Offset = spawncenterPos.add(new BlockPos(0, 9, 47).rotate(rotation));
        BlockPos upper3Offset = spawncenterPos.add(new BlockPos(47, 9, 0).rotate(rotation));
        BlockPos upper4Offset = spawncenterPos.add(new BlockPos(47, 9, 47).rotate(rotation));

        builder.addPiece(new Piece(templateManager, LOWER1, lower1Offset, rotation));
        builder.addPiece(new Piece(templateManager, LOWER2, lower2Offset, rotation));
        builder.addPiece(new Piece(templateManager, LOWER3, lower3Offset, rotation));
        builder.addPiece(new Piece(templateManager, LOWER4, lower4Offset, rotation));

        builder.addPiece(new Piece(templateManager, UPPER1, upper1Offset, rotation));
        builder.addPiece(new Piece(templateManager, UPPER2, upper2Offset, rotation));
        builder.addPiece(new Piece(templateManager, UPPER3, upper3Offset, rotation));
        builder.addPiece(new Piece(templateManager, UPPER4, upper4Offset, rotation));

        builder.addPiece(new Piece(templateManager, OBELISK1, obelisk1Offset, rotation));
        builder.addPiece(new Piece(templateManager, OBELISK2, obelisk2Offset, rotation));
    }


    @Override
    public StructureType<?> getType() {
        return ModStructures.CURSED_PYRAMID;
    }

    @Override
    public GenerationStep.Feature getFeatureGenerationStep() {
        return GenerationStep.Feature.SURFACE_STRUCTURES;
    }

    public static class Piece extends SimpleStructurePiece {

        public Piece(StructureTemplateManager templateManagerIn, Identifier resourceLocationIn, BlockPos pos, BlockRotation rotation) {
            super(ModStructures.CPD, 0, templateManagerIn, resourceLocationIn, resourceLocationIn.toString(), makeSettings(rotation), makecenterPos(resourceLocationIn, pos));
        }

        public Piece(StructureTemplateManager templateManagerIn, NbtCompound tagCompound) {
            super(ModStructures.CPD, tagCompound, templateManagerIn, (p_162451_) -> makeSettings(BlockRotation.valueOf(tagCompound.getString("Rot"))));

        }

        public Piece(StructureContext context, NbtCompound tag) {
            this(context.structureTemplateManager(), tag);
        }

        private static StructurePlacementData makeSettings(BlockRotation p_163156_) {
            BlockIgnoreStructureProcessor blockignoreprocessor = BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS;


            return (new StructurePlacementData()).setRotation(p_163156_).setMirror(BlockMirror.NONE)
                    .addProcessor(blockignoreprocessor)
                    .addProcessor(new WaterLoggingFixProcessor())
                    .addProcessor(new ProtectedBlocksStructureProcessor(BlockTags.FEATURES_CANNOT_REPLACE));
        }

        private static BlockPos makecenterPos(Identifier p_162453_, BlockPos p_162454_) {
            return p_162454_.add(OFFSET.get(p_162453_));
        }

        protected void writeNbt(StructureContext p_162444_, NbtCompound tagCompound) {
            super.writeNbt(p_162444_, tagCompound);
            tagCompound.putString("Rot", this.placementData.getRotation().name());
        }


        @Override
        protected void handleMetadata(String function, BlockPos pos, ServerWorldAccess worldIn, Random rand, BlockBox sbb) {
            switch (function) {
                case "necklace" -> {
                    worldIn.setBlockState(pos, Blocks.SUSPICIOUS_SAND.getDefaultState(), 2);
                    worldIn.getBlockEntity(pos, BlockEntityType.BRUSHABLE_BLOCK).ifPresent((blockEntity) -> {
                        Identifier lootTableLocation = Cataclysm.modIdentifier("archaeology/cursed_pyramid_necklace");
                        blockEntity.setLootTable(lootTableLocation, pos.asLong());
                    });
                }
                case "sus" -> {
                    worldIn.setBlockState(pos, Blocks.SUSPICIOUS_SAND.getDefaultState(), 2);
                    worldIn.getBlockEntity(pos, BlockEntityType.BRUSHABLE_BLOCK).ifPresent((blockEntity) -> {
                        Identifier lootTableLocation = Cataclysm.modIdentifier("archaeology/cursed_pyramid");
                        blockEntity.setLootTable(lootTableLocation, pos.asLong());
                    });
                }
                case "koboleton" -> {
                    Koboleton_Entity koboleton = ModEntities.KOBOLETON.create(worldIn.toServerWorld());
                    if (koboleton != null) {
                        koboleton.setPersistent();
                        koboleton.refreshPositionAndAngles(pos, 0.0F, 0.0F);
                        koboleton.initialize(worldIn, worldIn.getLocalDifficulty(koboleton.getBlockPos()), SpawnReason.STRUCTURE, null, null);
                        worldIn.spawnEntityAndPassengers(koboleton);
                        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                    }
                }
                case "wadjet" -> {
                    Wadjet_Entity wadjet = ModEntities.WADJET.create(worldIn.toServerWorld());
                    if (wadjet != null) {
                        wadjet.setPersistent();
                        wadjet.refreshPositionAndAngles(pos, 0.0F, 0.0F);
                        wadjet.initialize(worldIn, worldIn.getLocalDifficulty(wadjet.getBlockPos()), SpawnReason.STRUCTURE, null, null);
                        worldIn.spawnEntityAndPassengers(wadjet);
                        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                    }
                }
                case "kobolediator" -> {
                    Kobolediator_Entity kobolediator = ModEntities.KOBOLEDIATOR.create(worldIn.toServerWorld());
                    if (kobolediator != null) {
                        kobolediator.setPersistent();
                        kobolediator.refreshPositionAndAngles(pos, 0.0F, 0.0F);
                        kobolediator.setSleep(true);
                        kobolediator.initialize(worldIn, worldIn.getLocalDifficulty(kobolediator.getBlockPos()), SpawnReason.STRUCTURE, null, null);
                        worldIn.spawnEntityAndPassengers(kobolediator);
                        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                    }
                }
                case "remnant" -> {
                    Ancient_Remnant_Entity remnant = ModEntities.ANCIENT_REMNANT.create(worldIn.toServerWorld());
                    if (remnant != null) {
                        remnant.setNecklace(false);
                        remnant.setPersistent();
                        remnant.refreshPositionAndAngles(pos, 0.0F, 0.0F);
                        remnant.initialize(worldIn, worldIn.getLocalDifficulty(remnant.getBlockPos()), SpawnReason.STRUCTURE, null, null);
                        worldIn.spawnEntityAndPassengers(remnant);
                        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                    }
                }
            }
        }
    }
}
