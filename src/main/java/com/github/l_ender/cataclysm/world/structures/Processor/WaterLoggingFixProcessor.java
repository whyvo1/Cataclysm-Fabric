package com.github.l_ender.cataclysm.world.structures.Processor;

import com.github.l_ender.cataclysm.init.ModStructureProcessor;
import com.mojang.serialization.Codec;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.Chunk;

public class WaterLoggingFixProcessor extends StructureProcessor {
    public static final Codec<WaterLoggingFixProcessor> CODEC = Codec.unit(WaterLoggingFixProcessor::new);

    @Override
    public StructureTemplate.StructureBlockInfo process(WorldView levelReader, BlockPos pos, BlockPos pos2, StructureTemplate.StructureBlockInfo infoIn1, StructureTemplate.StructureBlockInfo infoIn2, StructurePlacementData settings) {
        if(!infoIn2.state().getFluidState().isEmpty()) {
            if(levelReader instanceof ChunkRegion worldGenRegion && !worldGenRegion.getCenterPos().equals(new ChunkPos(infoIn2.pos()))) {
                return infoIn2;
            }

            Chunk chunk = levelReader.getChunk(infoIn2.pos());
            int minY = chunk.getBottomY();
            int maxY = chunk.getTopY();
            int currentY = infoIn2.pos().getY();
            if(currentY >= minY && currentY <= maxY) {
                ((WorldAccess) levelReader).scheduleBlockTick(infoIn2.pos(), infoIn2.state().getBlock(), 0);
            }
        }
        return infoIn2;
    }

    @Override
    public StructureProcessorType<?> getType() {
        return ModStructureProcessor.WATER_LOGGING_FIX_PROCESSOR;
    }
}
