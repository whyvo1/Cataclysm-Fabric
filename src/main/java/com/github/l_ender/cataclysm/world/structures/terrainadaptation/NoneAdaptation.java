package com.github.l_ender.cataclysm.world.structures.terrainadaptation;

import com.mojang.serialization.Codec;

public class NoneAdaptation extends EnhancedTerrainAdaptation {
    public static final EnhancedTerrainAdaptation NONE = new NoneAdaptation();
    private static final NoneAdaptation INSTANCE = new NoneAdaptation();
    public static final Codec<NoneAdaptation> CODEC = Codec.unit(() -> INSTANCE);

    public NoneAdaptation() {
        super(0, 0, false, false);
    }

    @Override
    public EnhancedTerrainAdaptationType<?> type() {
        return EnhancedTerrainAdaptationType.NONE;
    }

    @Override
    public double computeDensityFactor(int xDistance, int yDistance, int zDistance, int yDistanceToBeardBase) {
        return 0;
    }
}
