package com.github.l_ender.cataclysm.init;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.world.feature.EndIceSpikeFeature;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class Modfeatures {

//    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Cataclysm.MODID);

    public static final Feature<DefaultFeatureConfig> END_ICE_SPIKE_FEATURE = registerPlacedFeature("end_ice_spike_feature", new EndIceSpikeFeature(DefaultFeatureConfig.CODEC));

    private static <T extends FeatureConfig> Feature<T> registerPlacedFeature(String name, Feature<T> feature) {
        return Registry.register(Registries.FEATURE, Cataclysm.modIdentifier(name), feature);
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering features for " + Cataclysm.MOD_ID);
    }
}
