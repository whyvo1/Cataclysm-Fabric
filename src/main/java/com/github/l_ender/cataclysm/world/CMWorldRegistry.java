package com.github.l_ender.cataclysm.world;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModTag;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.BiomeKeys;

//@Mod.EventBusSubscriber(modid = Cataclysm.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CMWorldRegistry {

    public static void addBiomeSpawns() {
        if (CMConfig.DeeplingSpawnWeight > 0) {
            BiomeModifications.addSpawn(context -> context.hasTag(ModTag.SPAWNS_DEEPLINGS), SpawnGroup.MONSTER, ModEntities.DEEPLING, CMConfig.DeeplingSpawnWeight, 1, 1);
//            builder.getMobSpawnSettings().getSpawner(SpawnGroup.MONSTER).add(new SpawnSettings.SpawnEntry(ModEntities.DEEPLING, CMConfig.DeeplingSpawnWeight, 1, 1));
        }
        if (CMConfig.DeeplingAnglerSpawnWeight > 0) {
            BiomeModifications.addSpawn(context -> context.hasTag(ModTag.SPAWNS_DEEPLINGS), SpawnGroup.MONSTER, ModEntities.DEEPLING_ANGLER, CMConfig.DeeplingAnglerSpawnWeight, 1, 1);
//            builder.getMobSpawnSettings().getSpawner(SpawnGroup.MONSTER).add(new SpawnSettings.SpawnEntry(ModEntities.DEEPLING_ANGLER, CMConfig.DeeplingAnglerSpawnWeight, 1, 1));
        }
        if (CMConfig.DeeplingBruteSpawnWeight > 0) {
            BiomeModifications.addSpawn(context -> context.hasTag(ModTag.SPAWNS_DEEPLINGS), SpawnGroup.MONSTER, ModEntities.DEEPLING_BRUTE, CMConfig.DeeplingBruteSpawnWeight, 1, 1);
//            builder.getMobSpawnSettings().getSpawner(SpawnGroup.MONSTER).add(new SpawnSettings.SpawnEntry(ModEntities.DEEPLING_BRUTE, CMConfig.DeeplingBruteSpawnWeight, 1, 1));
        }

        if (CMConfig.DeeplingPriestSpawnWeight > 0) {
            BiomeModifications.addSpawn(context -> context.hasTag(ModTag.SPAWNS_DEEPLINGS), SpawnGroup.MONSTER, ModEntities.DEEPLING_PRIEST, CMConfig.DeeplingPriestSpawnWeight, 1, 1);
//            builder.getMobSpawnSettings().getSpawner(SpawnGroup.MONSTER).add(new SpawnSettings.SpawnEntry(ModEntities.DEEPLING_PRIEST, CMConfig.DeeplingPriestSpawnWeight, 1, 1));
        }

        if (CMConfig.DeeplingWarlockSpawnWeight > 0) {
            BiomeModifications.addSpawn(context -> context.hasTag(ModTag.SPAWNS_DEEPLINGS), SpawnGroup.MONSTER, ModEntities.DEEPLING_WARLOCK, CMConfig.DeeplingWarlockSpawnWeight, 1, 1);
//            builder.getMobSpawnSettings().getSpawner(SpawnGroup.MONSTER).add(new SpawnSettings.SpawnEntry(ModEntities.DEEPLING_WARLOCK, CMConfig.DeeplingWarlockSpawnWeight, 1, 1));
        }

        if (CMConfig.CoralgolemSpawnWeight > 0) {
            BiomeModifications.addSpawn(context -> context.hasTag(ModTag.SPAWNS_DEEPLINGS), SpawnGroup.MONSTER, ModEntities.CORAL_GOLEM, CMConfig.CoralgolemSpawnWeight, 1, 1);
//            builder.getMobSpawnSettings().getSpawner(SpawnGroup.MONSTER).add(new SpawnSettings.SpawnEntry(ModEntities.CORAL_GOLEM, CMConfig.CoralgolemSpawnWeight, 1, 1));
        }

        if (CMConfig.AmethystCrabSpawnWeight > 0) {
            BiomeModifications.addSpawn(context -> context.hasTag(ModTag.SPAWNS_AMETHYST_CRAB), SpawnGroup.MONSTER, ModEntities.AMETHYST_CRAB, CMConfig.AmethystCrabSpawnWeight, 1, 1);
//            builder.getMobSpawnSettings().getSpawner(SpawnGroup.MONSTER).add(new SpawnSettings.SpawnEntry(ModEntities.AMETHYST_CRAB, CMConfig.AmethystCrabSpawnWeight, 1, 1));
        }

        if (CMConfig.KoboletonSpawnWeight > 0) {
            BiomeModifications.addSpawn(context -> context.hasTag(ModTag.SPAWNS_KOBOLETON), SpawnGroup.MONSTER, ModEntities.KOBOLETON, CMConfig.KoboletonSpawnWeight, 2, 3);
//            builder.getMobSpawnSettings().getSpawner(SpawnGroup.MONSTER).add(new SpawnSettings.SpawnEntry(ModEntities.KOBOLETON, CMConfig.KoboletonSpawnWeight, 2, 3));
        }

        if(CMConfig.IgnitedBerserkerSpawnWeight > 0) {
            BiomeModifications.addSpawn(context -> context.hasTag(ModTag.BERSERKER_SPAWN_BIOME), SpawnGroup.MONSTER, ModEntities.IGNITED_BERSERKER, CMConfig.IgnitedBerserkerSpawnWeight, 1, 1);
        }

    }

    public static void modifyStructure() {
//        if (structure.isIn(ModTag.BERSERKER_SPAWN) && CMConfig.IgnitedBerserkerSpawnWeight > 0) {
//            BiomeModifications.addSpawn((context) -> {
//                Optional<RegistryKey<Structure>> key = context.getStructureKey();
//                return testBiome(BiomeConfig.koboleton, context.getBiomeRegistryEntry());
//            }, SpawnGroup.MONSTER, ModEntities.KOBOLETON, CMConfig.KoboletonSpawnWeight, 2, 3);
//            builder.getStructureSettings().getOrAddSpawnOverrides(SpawnGroup.MONSTER).addSpawn(new SpawnSettings.SpawnEntry(ModEntities.IGNITED_BERSERKER.get(), CMConfig.IgnitedBerserkerSpawnWeight, 1, 1));
//        }
    }

}
