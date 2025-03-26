package com.github.l_ender.cataclysm.world.structures.terrainadaptation;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.dynamic.Codecs;

public class CustomAdaptation extends EnhancedTerrainAdaptation {
    public static final MapCodec<CustomAdaptation> CODEC = RecordCodecBuilder.mapCodec((builder) -> builder
            .group(
                    Codecs.NONNEGATIVE_INT.fieldOf("kernel_size").forGetter(EnhancedTerrainAdaptation::getKernelSize),
                    Codecs.NONNEGATIVE_INT.fieldOf("kernel_distance").forGetter(EnhancedTerrainAdaptation::getKernelDistance),
                    TerrainAction.CODEC.fieldOf("top").forGetter(EnhancedTerrainAdaptation::topAction),
                    TerrainAction.CODEC.fieldOf("bottom").forGetter(EnhancedTerrainAdaptation::bottomAction),
                    Codec.DOUBLE.optionalFieldOf("bottom_offset", 0.0).forGetter(EnhancedTerrainAdaptation::getBottomOffset),
                    EnhancedTerrainAdaptation.Padding.CODEC.optionalFieldOf("padding", EnhancedTerrainAdaptation.Padding.ZERO).forGetter(EnhancedTerrainAdaptation::getPadding))
            .apply(builder, CustomAdaptation::new));

    CustomAdaptation(int kernelSize, int kernelDistance, TerrainAction topAction, TerrainAction bottomAction, double bottomOffset, Padding padding) {
        super(kernelSize, kernelDistance, topAction, bottomAction, bottomOffset, padding);
    }

    @Override
    public EnhancedTerrainAdaptationType<?> type() {
        return EnhancedTerrainAdaptationType.CUSTOM;
    }
}
