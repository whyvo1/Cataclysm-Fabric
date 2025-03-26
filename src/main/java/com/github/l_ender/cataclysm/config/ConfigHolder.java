package com.github.l_ender.cataclysm.config;


import com.github.l_ender.cataclysm.Cataclysm;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

public final class ConfigHolder {

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final CommonConfig COMMON;

    static {
        {
            final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
            COMMON = specPair.getLeft();
            COMMON_SPEC = specPair.getRight();
        }
    }

    public static void registerConfigs() {
        ForgeConfigRegistry.INSTANCE.register(Cataclysm.MOD_ID, ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC);
    }
}