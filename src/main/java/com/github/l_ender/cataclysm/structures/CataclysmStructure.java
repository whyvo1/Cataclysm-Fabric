package com.github.l_ender.cataclysm.structures;

import java.util.Optional;
import java.util.Set;
import net.minecraft.block.BlockState;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.StructurePiecesCollector;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.structure.Structure;

public abstract class CataclysmStructure extends Structure {
    private Set<RegistryEntry<Biome>> allowedBiomes;
    private boolean doCheckHeight;
    private boolean doAvoidWater;
    private boolean doAvoidStructures;

    public CataclysmStructure(Config settings, Set<RegistryEntry<Biome>> allowedBiomes, boolean doCheckHeight, boolean doAvoidWater, boolean doAvoidStructures) {
        super(settings);
        this.allowedBiomes = allowedBiomes;
        this.doCheckHeight = doCheckHeight;
        this.doAvoidWater = doAvoidWater;
        this.doAvoidStructures = doAvoidStructures;
    }

    public CataclysmStructure(Config settings, Set<RegistryEntry<Biome>> allowedBiomes) {
        this(settings, allowedBiomes, true, true, true);
    }

    public CataclysmStructure(Config settings) {
        super(settings);
    }
    
    @Override
    public Optional<StructurePosition> getStructurePosition(Context context) {
    	if(this.checkLocation(context)) {
    		return getStructurePosition(context, Heightmap.Type.WORLD_SURFACE_WG, (builder) -> {
    			this.generatePieces(builder, context);
    		});
    	}
    	return Optional.empty();
    }
    
    public void generatePieces(StructurePiecesCollector builder, Context context) {
    	
    }
    
    public boolean checkLocation(Context context) {
    	return this.checkLocation(context, allowedBiomes, doCheckHeight, doAvoidWater, doAvoidStructures);
    }

    protected boolean checkLocation(Context context, Set<RegistryEntry<Biome>> allowedBiomes, boolean checkHeight, boolean avoidWater, boolean avoidStructures) {
        ChunkPos chunkPos = context.chunkPos();
        BlockPos centerOfChunk = new BlockPos((chunkPos.x << 4) + 7, 0, (chunkPos.z << 4) + 7);

//        int i = chunkPos.getMiddleBlockX();
//        int j = chunkPos.getMiddleBlockZ();
//        int k = context.chunkGenerator().getFirstOccupiedHeight(i, j, Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor(), context.randomState());
//        Holder<Biome> biome = context.chunkGenerator().getBiomeSource().getNoiseBiome(QuartPos.fromBlock(i), QuartPos.fromBlock(k), QuartPos.fromBlock(j), context.randomState().sampler());
//        if (!allowedBiomes.contains(biome)) {
//            return false;
//        }
//
//        if (checkHeight) {
//        	double minHeight = config.heightMin.get();
//            double maxHeight = config.heightMax.get();
//            int landHeight = getLowestY(context, 16, 16);
//            if (minHeight != -65 && landHeight < minHeight) return false;
//            if (maxHeight != -65 && landHeight > maxHeight) return false;
//        }

        if (avoidWater) {
            ChunkGenerator chunkGenerator = context.chunkGenerator();
            HeightLimitView heightLimitView = context.world();
            int centerHeight = chunkGenerator.getHeight(centerOfChunk.getX(), centerOfChunk.getZ(), Heightmap.Type.WORLD_SURFACE_WG, heightLimitView, context.noiseConfig());
            VerticalBlockSample columnOfBlocks = chunkGenerator.getColumnSample(centerOfChunk.getX(), centerOfChunk.getZ(), heightLimitView, context.noiseConfig());
            BlockState topBlock = columnOfBlocks.getState(centerHeight);
            if (!topBlock.getFluidState().isEmpty()) return false;
        }

        return true;
    }

    @Override
    public GenerationStep.Feature getFeatureGenerationStep() {
        return GenerationStep.Feature.SURFACE_STRUCTURES;
    }

}
