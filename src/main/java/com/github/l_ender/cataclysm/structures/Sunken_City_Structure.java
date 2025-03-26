package com.github.l_ender.cataclysm.structures;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModStructures;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.world.structures.Processor.WaterLoggingFixProcessor;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.entry.RegistryEntry;
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
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Sunken_City_Structure extends Structure {

    public static final Codec<Sunken_City_Structure> CODEC = createCodec(Sunken_City_Structure::new);

    private static final Identifier CITY_MID = Cataclysm.modIdentifier("sunken_city_mid");
    private static final Identifier CITY_LOWER = Cataclysm.modIdentifier("sunken_city_lower");
    private static final Identifier CITY_UPPER = Cataclysm.modIdentifier("sunken_city_upper");

    private static final Identifier CITY_MID_EAST = Cataclysm.modIdentifier("sunken_city_mid_east");
    private static final Identifier CITY_MID_NORTH = Cataclysm.modIdentifier("sunken_city_mid_north");
    private static final Identifier CITY_MID_SOUTH = Cataclysm.modIdentifier("sunken_city_mid_south");
    private static final Identifier CITY_MID_WEST = Cataclysm.modIdentifier("sunken_city_mid_west");

    private static final Identifier CITY_MID_NORTHEAST = Cataclysm.modIdentifier("sunken_city_mid_northeast");
    private static final Identifier CITY_MID_NORTHWEST = Cataclysm.modIdentifier("sunken_city_mid_northwest");
    private static final Identifier CITY_MID_SOUTHEAST = Cataclysm.modIdentifier("sunken_city_mid_southeast");
    private static final Identifier CITY_MID_SOUTHWEST = Cataclysm.modIdentifier("sunken_city_mid_southwest");

    private static final Identifier CITY_LOWER_EAST = Cataclysm.modIdentifier("sunken_city_lower_east");
    private static final Identifier CITY_LOWER_NORTH = Cataclysm.modIdentifier("sunken_city_lower_north");
    private static final Identifier CITY_LOWER_SOUTH = Cataclysm.modIdentifier("sunken_city_lower_south");
    private static final Identifier CITY_LOWER_WEST = Cataclysm.modIdentifier("sunken_city_lower_west");

    private static final Identifier CITY_LOWER_NORTHEAST = Cataclysm.modIdentifier("sunken_city_lower_northeast");
    private static final Identifier CITY_LOWER_NORTHWEST = Cataclysm.modIdentifier("sunken_city_lower_northwest");
    private static final Identifier CITY_LOWER_SOUTHEAST = Cataclysm.modIdentifier("sunken_city_lower_southeast");
    private static final Identifier CITY_LOWER_SOUTHWEST = Cataclysm.modIdentifier("sunken_city_lower_southwest");

    private static final Identifier CITY_UPPER_TREASURE = Cataclysm.modIdentifier("sunken_city_upper_treasureroom");
    private static final Identifier CITY_LOWER_TREASURE = Cataclysm.modIdentifier("sunken_city_lower_treasureroom");

    private static final Identifier CITY_ENTRANCE1 = Cataclysm.modIdentifier("sunken_city_entrance1");
    private static final Identifier CITY_ENTRANCE2 = Cataclysm.modIdentifier("sunken_city_entrance2");
    private static final Identifier CITY_ENTRANCE3 = Cataclysm.modIdentifier("sunken_city_entrance3");
    private static final Identifier CITY_ENTRANCE4 = Cataclysm.modIdentifier("sunken_city_entrance4");


    private static final Identifier CITY_TEMPLE1 = Cataclysm.modIdentifier("sunken_city_temple1");
    private static final Identifier CITY_TEMPLE2 = Cataclysm.modIdentifier("sunken_city_temple2");

    private static final Identifier CITY_UPPER_PRISON = Cataclysm.modIdentifier("sunken_city_upper_prison");
    private static final Identifier CITY_UPPERSIDE_PRISON = Cataclysm.modIdentifier("sunken_city_upperside_prison");
    private static final Identifier CITY_LOWER_PRISON = Cataclysm.modIdentifier("sunken_city_lower_prison");
    private static final Identifier CITY_LOWERSIDE_PRISON = Cataclysm.modIdentifier("sunken_city_lowerside_prison");

    private static final Identifier CITY_MID_NORTH_SIDE = Cataclysm.modIdentifier("sunken_city_mid_north_side");

    private static final Map<Identifier, BlockPos> OFFSET = ImmutableMap.<Identifier, BlockPos>builder()
            .put(CITY_MID, new BlockPos(0, 1, 0))
            .put(CITY_LOWER, new BlockPos(0, 1, 0))
            .put(CITY_UPPER, new BlockPos(0, 1, 0))
            .put(CITY_MID_EAST, new BlockPos(0, 1, 0))
            .put(CITY_MID_NORTH, new BlockPos(0, 1, 0))
            .put(CITY_MID_SOUTH, new BlockPos(0, 1, 0))
            .put(CITY_MID_WEST, new BlockPos(0, 1, 0))

            .put(CITY_MID_NORTHEAST, new BlockPos(0, 1, 0))
            .put(CITY_MID_NORTHWEST, new BlockPos(0, 1, 0))
            .put(CITY_MID_SOUTHEAST, new BlockPos(0, 1, 0))
            .put(CITY_MID_SOUTHWEST, new BlockPos(0, 1, 0))

            .put(CITY_LOWER_EAST, new BlockPos(0, 1, 0))
            .put(CITY_LOWER_NORTH, new BlockPos(0, 1, 0))
            .put(CITY_LOWER_SOUTH, new BlockPos(0, 1, 0))
            .put(CITY_LOWER_WEST, new BlockPos(0, 1, 0))

            .put(CITY_LOWER_NORTHEAST, new BlockPos(0, 1, 0))
            .put(CITY_LOWER_NORTHWEST, new BlockPos(0, 1, 0))
            .put(CITY_LOWER_SOUTHEAST, new BlockPos(0, 1, 0))
            .put(CITY_LOWER_SOUTHWEST, new BlockPos(0, 1, 0))

            .put(CITY_UPPER_TREASURE, new BlockPos(0, 1, 0))
            .put(CITY_LOWER_TREASURE, new BlockPos(0, 1, 0))

            .put(CITY_ENTRANCE1, new BlockPos(0, 1, 0))
            .put(CITY_ENTRANCE2, new BlockPos(0, 1, 0))
            .put(CITY_ENTRANCE3, new BlockPos(0, 1, 0))
            .put(CITY_ENTRANCE4, new BlockPos(0, 1, 0))


            .put(CITY_TEMPLE1, new BlockPos(0, 1, 0))
            .put(CITY_TEMPLE2, new BlockPos(0, 1, 0))

            .put(CITY_UPPER_PRISON, new BlockPos(0, 1, 0))
            .put(CITY_UPPERSIDE_PRISON, new BlockPos(0, 1, 0))
            .put(CITY_LOWER_PRISON, new BlockPos(0, 1, 0))
            .put(CITY_LOWERSIDE_PRISON, new BlockPos(0, 1, 0))

            .put(CITY_MID_NORTH_SIDE, new BlockPos(0, 1, 0))

            .build();


    /*
     * Begins assembling your structure and where the pieces needs to go.
     */
    public static void start(StructureTemplateManager templateManager, BlockPos pos, BlockRotation rotation, StructurePiecesHolder pieceList, Random random) {
        int x = pos.getX();
        int z = pos.getZ();

        BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_MID, blockpos, rotation));
        rotationOffSet = new BlockPos(0, 48, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_UPPER, blockpos, rotation));
        rotationOffSet = new BlockPos(0, -38, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_LOWER, blockpos, rotation));

        rotationOffSet = new BlockPos(47, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_MID_EAST, blockpos, rotation));
        rotationOffSet = new BlockPos(0, 0, -47).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_MID_NORTH, blockpos, rotation));
        rotationOffSet = new BlockPos(0, 0, 47).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_MID_SOUTH, blockpos, rotation));
        rotationOffSet = new BlockPos(-47, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_MID_WEST, blockpos, rotation));

        rotationOffSet = new BlockPos(47, 0, -12).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_MID_NORTHEAST, blockpos, rotation));
        rotationOffSet = new BlockPos(-47, 0, -47).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_MID_NORTHWEST, blockpos, rotation));
        rotationOffSet = new BlockPos(47, 0, 47).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_MID_SOUTHEAST, blockpos, rotation));
        rotationOffSet = new BlockPos(-47, 0, 47).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_MID_SOUTHWEST, blockpos, rotation));


        rotationOffSet = new BlockPos(47, -38, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_LOWER_EAST, blockpos, rotation));
        rotationOffSet = new BlockPos(0, -38, -47).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_LOWER_NORTH, blockpos, rotation));
        rotationOffSet = new BlockPos(0, -38, 47).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_LOWER_SOUTH, blockpos, rotation));
        rotationOffSet = new BlockPos(-47, -38, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_LOWER_WEST, blockpos, rotation));


        rotationOffSet = new BlockPos(47, -38, -9).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_LOWER_NORTHEAST, blockpos, rotation));
        rotationOffSet = new BlockPos(-47, -38, -47).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_LOWER_NORTHWEST, blockpos, rotation));
        rotationOffSet = new BlockPos(47, -38, 47).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_LOWER_SOUTHEAST, blockpos, rotation));
        rotationOffSet = new BlockPos(-47, -38, 47).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_LOWER_SOUTHWEST, blockpos, rotation));


        rotationOffSet = new BlockPos(-105, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_ENTRANCE1, blockpos, rotation));
        rotationOffSet = new BlockPos(-94, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_ENTRANCE2, blockpos, rotation));
        rotationOffSet = new BlockPos(-105, -38, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_ENTRANCE3, blockpos, rotation));
        rotationOffSet = new BlockPos(-94, -38, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_ENTRANCE4, blockpos, rotation));

        rotationOffSet = new BlockPos(-94, 0, 47).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_UPPER_PRISON, blockpos, rotation));
        rotationOffSet = new BlockPos(-94, -38, 47).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_LOWER_PRISON, blockpos, rotation));
        rotationOffSet = new BlockPos(-52, 0, 94).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_UPPERSIDE_PRISON, blockpos, rotation));
        rotationOffSet = new BlockPos(-52, -38, 94).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_LOWERSIDE_PRISON, blockpos, rotation));

        rotationOffSet = new BlockPos(-94, 0, -47).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_UPPER_TREASURE, blockpos, rotation));
        rotationOffSet = new BlockPos(-94, -38, -47).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_LOWER_TREASURE, blockpos, rotation));


        rotationOffSet = new BlockPos(94, -38, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_TEMPLE1, blockpos, rotation));
        rotationOffSet = new BlockPos(94, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_TEMPLE2, blockpos, rotation));


        rotationOffSet = new BlockPos(0, 0, -50).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, CITY_MID_NORTH_SIDE, blockpos, rotation));

    }

    public Sunken_City_Structure(Config p_227593_) {
        super(p_227593_);
    }

    public Optional<StructurePosition> getStructurePosition(Structure.Context p_228964_) {
        int i = p_228964_.chunkPos().getOffsetX(9);
        int j = p_228964_.chunkPos().getOffsetZ(9);
        for (RegistryEntry<Biome> holder : p_228964_.biomeSource().getBiomesInArea(i, p_228964_.chunkGenerator().getSeaLevel(), j, 29, p_228964_.noiseConfig().getMultiNoiseSampler())) {
            if (!holder.isIn(ModTag.REQUIRED_SUNKEN_CITY_SURROUNDING)) {
                return Optional.empty();
            }
        }
        return getStructurePosition(p_228964_, Heightmap.Type.OCEAN_FLOOR_WG, (p_228967_) -> generatePieces(p_228967_, p_228964_));
    }

    private static void generatePieces(StructurePiecesCollector p_197233_, Context p_197234_) {
        int i = p_197234_.chunkPos().getStartX();
        int j = p_197234_.chunkPos().getStartZ();
        BlockPos blockpos = new BlockPos(i, 19, j);
        BlockRotation rotation = BlockRotation.random(p_197234_.random());
        Sunken_City_Structure.start(p_197234_.structureTemplateManager(), blockpos, rotation, p_197233_, p_197234_.random());
    }

    @Override
    public StructureType<?> getType() {
        return ModStructures.SUNKEN_CITY;
    }

    @Override
    public GenerationStep.Feature getFeatureGenerationStep() {
        return GenerationStep.Feature.SURFACE_STRUCTURES;
    }

    public static class Piece extends SimpleStructurePiece {

        public Piece(StructureTemplateManager templateManagerIn, Identifier resourceLocationIn, BlockPos pos, BlockRotation rotation) {
            super(ModStructures.SCP, 0, templateManagerIn, resourceLocationIn, resourceLocationIn.toString(), makeSettings(rotation), makePosition(resourceLocationIn, pos));
        }

        public Piece(StructureTemplateManager templateManagerIn, NbtCompound tagCompound) {
            super(ModStructures.SCP, tagCompound, templateManagerIn, (p_162451_) -> makeSettings(BlockRotation.valueOf(tagCompound.getString("Rot"))));

        }

        public Piece(StructureContext context, NbtCompound tag) {
            this(context.structureTemplateManager(), tag);
        }

        private static StructurePlacementData makeSettings(BlockRotation p_163156_) {
            BlockIgnoreStructureProcessor blockignoreprocessor = BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS;


            return (new StructurePlacementData()).setRotation(p_163156_).setMirror(BlockMirror.NONE)
                    .addProcessor(blockignoreprocessor)
                    .addProcessor(new WaterLoggingFixProcessor())
                    .addProcessor(new ProtectedBlocksStructureProcessor(ModTag.SUNKEN_CITY_MATERIAL));
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
            List<MobEntity> list = new ArrayList<>();
            switch (function) {
                case "deepling_brute":
                    list.add(ModEntities.DEEPLING_BRUTE.create(worldIn.toServerWorld()));
                    break;
                case "deepling_angler":
                    list.add(ModEntities.DEEPLING_ANGLER.create(worldIn.toServerWorld()));
                    break;
                case "deepling":
                    list.add(ModEntities.DEEPLING.create(worldIn.toServerWorld()));
                    break;
                case "sus":
                    list.add(ModEntities.CORALSSUS.create(worldIn.toServerWorld()));
                    break;
                case "deepling_priest":
                    if(rand.nextBoolean()) {
                        list.add(ModEntities.DEEPLING_PRIEST.create(worldIn.toServerWorld()));
                    }else{
                        list.add(ModEntities.DEEPLING_WARLOCK.create(worldIn.toServerWorld()));
                    }
                    break;
                default:
                    return;
            }

            for(MobEntity mob : list) {
                mob.setPersistent();
                mob.refreshPositionAndAngles(pos, 0.0F, 0.0F);
                mob.initialize(worldIn, worldIn.getLocalDifficulty(mob.getBlockPos()), SpawnReason.STRUCTURE, null, null);
                worldIn.spawnEntityAndPassengers(mob);
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
            }
        }
    }
}
