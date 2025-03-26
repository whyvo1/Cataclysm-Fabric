package com.github.l_ender.cataclysm.structures.jisaw;

import com.mojang.serialization.MapCodec;
import java.util.Collections;
import java.util.List;
import net.minecraft.structure.StructureLiquidSettings;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePoolElementType;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;

public class FallbackPoolElement extends StructurePoolElement {
    public static final MapCodec<FallbackPoolElement> CODEC = MapCodec.unit(() -> {
        return FallbackPoolElement.INSTANCE;
    });
    public static final FallbackPoolElement INSTANCE = new FallbackPoolElement();

    private FallbackPoolElement() {
        super(StructurePool.Projection.TERRAIN_MATCHING);
    }

    public Vec3i getStart(StructureTemplateManager p_210191_, BlockRotation p_210192_) {
        return Vec3i.ZERO;
    }

    public List<StructureTemplate.StructureBlockInfo> getStructureBlockInfos(StructureTemplateManager p_210198_, BlockPos p_210199_, BlockRotation p_210200_, Random p_210201_) {
        return Collections.emptyList();
    }

    public BlockBox getBoundingBox(StructureTemplateManager p_210194_, BlockPos p_210195_, BlockRotation p_210196_) {
        throw new IllegalStateException("Invalid call to MowzieFallbackElement.getBoundingBox, filter me!");
    }

    public boolean generate(StructureTemplateManager p_227336_, StructureWorldAccess p_227337_, StructureAccessor p_227338_, ChunkGenerator p_227339_, BlockPos p_227340_, BlockPos p_227341_, BlockRotation p_227342_, BlockBox p_227343_, Random p_227344_, StructureLiquidSettings p_352159_, boolean p_227345_) {
        return true;
    }


    public StructurePoolElementType<?> getType() {
        return StructurePoolElementType.EMPTY_POOL_ELEMENT;
    }

    public String toString() {
        return "Fallback";
    }
}
