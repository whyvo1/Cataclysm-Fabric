package com.github.l_ender.cataclysm.config;

import com.github.l_ender.cataclysm.Cataclysm;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public final class ConfigHolder {

    public static final ModConfigSpec COMMON_SPEC;
    public static final CommonConfig COMMON;

    static {
        {
            final Pair<CommonConfig, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(CommonConfig::new);
            COMMON = specPair.getLeft();
            COMMON_SPEC = specPair.getRight();
        }
    }

    public static void registerConfigs() {
        NeoForgeConfigRegistry.INSTANCE.register(Cataclysm.MOD_ID, ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC);
    }
}