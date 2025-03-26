package com.github.l_ender.cataclysm.world.structures.terrainadaptation;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.dynamic.Codecs;

public class CustomAdaptation extends EnhancedTerrainAdaptation {
    public static final Codec<CustomAdaptation> CODEC = RecordCodecBuilder.create((builder) -> builder
            .group(
                    Codec.BOOL.optionalFieldOf("carves", true).forGetter(EnhancedTerrainAdaptation::carves),
                    Codec.BOOL.optionalFieldOf("beards", true).forGetter(EnhancedTerrainAdaptation::beards),
                    Codecs.NONNEGATIVE_INT.fieldOf("kernel_size").forGetter(EnhancedTerrainAdaptation::getKernelSize),
                    Codecs.NONNEGATIVE_INT.fieldOf("kernel_distance").forGetter(EnhancedTerrainAdaptation::getKernelDistance))
            .apply(builder, CustomAdaptation::new));

    CustomAdaptation(boolean doCarving, boolean doBearding, int kernelSize, int kernelDistance) {
        super(kernelSize, kernelDistance, doCarving, doBearding);
    }

    @Override
    public EnhancedTerrainAdaptationType<?> type() {
        return EnhancedTerrainAdaptationType.CUSTOM;
    }
}
