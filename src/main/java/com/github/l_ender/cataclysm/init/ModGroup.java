package com.github.l_ender.cataclysm.init;

import com.github.l_ender.cataclysm.Cataclysm;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class ModGroup {


//    public static final DeferredRegister<ItemGroup> DEF_REG = DeferredRegister.create(RegistryKeys.ITEM_GROUP, Cataclysm.MODID);


    public static final ItemGroup ITEM = registerItemGroup("item", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup." + Cataclysm.MOD_ID + ".item"))
            .icon(() -> new ItemStack(ModItems.THE_INCINERATOR))
            .entries((enabledFeatures, entries) -> {
                entries.add(ModItems.WITHERITE_INGOT);
                entries.add(ModItems.ANCIENT_METAL_INGOT);
                entries.add(ModItems.ANCIENT_METAL_NUGGET);
                entries.add(ModItems.BLACK_STEEL_INGOT);
                entries.add(ModItems.BLACK_STEEL_NUGGET);
                entries.add(ModItems.IGNITIUM_INGOT);
                entries.add(ModItems.CURSIUM_INGOT);
                entries.add(ModItems.IGNITIUM_UPGARDE_SMITHING_TEMPLATE);
                entries.add(ModItems.CURSIUM_UPGARDE_SMITHING_TEMPLATE);
                entries.add(ModItems.MONSTROUS_HORN);
                entries.add(ModItems.LAVA_POWER_CELL);
                entries.add(ModItems.BURNING_ASHES);
                entries.add(ModItems.DYING_EMBER);
                entries.add(ModItems.KOBOLETON_BONE);
                entries.add(ModItems.VOID_JAW);
                entries.add(ModItems.CRYSTALLIZED_CORAL_FRAGMENTS);
                entries.add(ModItems.CRYSTALLIZED_CORAL);
                entries.add(ModItems.CORAL_CHUNK);
                entries.add(ModItems.ABYSSAL_SACRIFICE);
                entries.add(ModItems.NECKLACE_OF_THE_DESERT);

                entries.add(ModItems.CORAL_SPEAR);
                entries.add(ModItems.CORAL_BARDICHE);
                entries.add(ModItems.ATHAME);
                entries.add(ModItems.KHOPESH);
                entries.add(ModItems.BLACK_STEEL_SWORD);
                entries.add(ModItems.BLACK_STEEL_SHOVEL);
                entries.add(ModItems.BLACK_STEEL_PICKAXE);
                entries.add(ModItems.BLACK_STEEL_AXE);
                entries.add(ModItems.BLACK_STEEL_HOE);
                entries.add(ModItems.BLACK_STEEL_TARGE);
                entries.add(ModItems.BULWARK_OF_THE_FLAME);
                entries.add(ModItems.GAUNTLET_OF_GUARD);
                entries.add(ModItems.GAUNTLET_OF_BULWARK);
                entries.add(ModItems.GAUNTLET_OF_MAELSTROM);
                entries.add(ModItems.THE_INCINERATOR);
                entries.add(ModItems.BLAZING_GRIPS);
                entries.add(ModItems.CURSED_BOW);
                entries.add(ModItems.WRATH_OF_THE_DESERT);
                entries.add(ModItems.SOUL_RENDER);
                entries.add(ModItems.THE_ANNIHILATOR);
                entries.add(ModItems.THE_IMMOLATOR);
                entries.add(ModItems.MEAT_SHREDDER);
                entries.add(ModItems.LASER_GATLING);
                entries.add(ModItems.WITHER_ASSULT_SHOULDER_WEAPON);
                entries.add(ModItems.VOID_ASSULT_SHOULDER_WEAPON);
                entries.add(ModItems.VOID_FORGE);
                entries.add(ModItems.TIDAL_CLAWS);
                entries.add(ModItems.INFERNAL_FORGE);
                entries.add(ModItems.SANDSTORM_IN_A_BOTTLE);
                entries.add(ModItems.ANCIENT_SPEAR);
                entries.add(ModItems.STICKY_GLOVES);
                entries.add(ModItems.VOID_CORE);
                entries.add(ModItems.VOID_SCATTER_ARROW);
                entries.add(ModItems.REMNANT_SKULL);
                entries.add(ModItems.NETHERITE_EFFIGY);
                entries.add(ModItems.BONE_REPTILE_HELMET);
                entries.add(ModItems.BONE_REPTILE_CHESTPLATE);
                entries.add(ModItems.IGNITIUM_HELMET);
                entries.add(ModItems.IGNITIUM_ELYTRA_CHESTPLATE);
                entries.add(ModItems.IGNITIUM_CHESTPLATE);
                entries.add(ModItems.IGNITIUM_LEGGINGS);
                entries.add(ModItems.IGNITIUM_BOOTS);
                entries.add(ModItems.CURSIUM_HELMET);
                entries.add(ModItems.CURSIUM_CHESTPLATE);
                entries.add(ModItems.CURSIUM_LEGGINGS);
                entries.add(ModItems.CURSIUM_BOOTS);
                entries.add(ModItems.MONSTROUS_HELM);
                entries.add(ModItems.BLOOM_STONE_PAULDRONS);
                entries.add(ModItems.MECH_EYE);
                entries.add(ModItems.FLAME_EYE);
                entries.add(ModItems.VOID_EYE);
                entries.add(ModItems.MONSTROUS_EYE);
                entries.add(ModItems.ABYSS_EYE);
                entries.add(ModItems.DESERT_EYE);
                entries.add(ModItems.CURSED_EYE);
                entries.add(ModItems.THE_BABY_LEVIATHAN_BUCKET);
                entries.add(ModItems.MODERN_REMNANT_BUCKET);
                entries.add(ModItems.NETHERITE_MINISTROSITY_BUCKET);

                entries.add(ModItems.MUSIC_DISC_NETHERITE_MONSTROSITY);
                entries.add(ModItems.MUSIC_DISC_ENDER_GUARDIAN);
                entries.add(ModItems.MUSIC_DISC_IGNIS);
                entries.add(ModItems.MUSIC_DISC_THE_HARBINGER);
                entries.add(ModItems.MUSIC_DISC_THE_LEVIATHAN);
                entries.add(ModItems.MUSIC_DISC_ANCIENT_REMNANT);
                entries.add(ModItems.MUSIC_DISC_MALEDICTUS);

                entries.add(ModItems.LIONFISH);
                entries.add(ModItems.AMETHYST_CRAB_MEAT);
                entries.add(ModItems.BLESSED_AMETHYST_CRAB_MEAT);
                entries.add(ModItems.AMETHYST_CRAB_SHELL);

                entries.add(ModItems.ENDER_GUARDIAN_SPAWN_EGG);
                entries.add(ModItems.ENDER_GOLEM_SPAWN_EGG);
                entries.add(ModItems.ENDERMAPTERA_SPAWN_EGG);
                entries.add(ModItems.NETHERITE_MONSTROSITY_SPAWN_EGG);
                entries.add(ModItems.NETHERITE_MINISTROSITY_SPAWN_EGG);
                entries.add(ModItems.IGNIS_SPAWN_EGG);
                entries.add(ModItems.IGNITED_REVENANT_SPAWN_EGG);
                entries.add(ModItems.IGNITED_BERSERKER_SPAWN_EGG);
                entries.add(ModItems.THE_HARBINGER_SPAWN_EGG);
                entries.add(ModItems.THE_PROWLER_SPAWN_EGG);
                entries.add(ModItems.THE_WATCHER_SPAWN_EGG);
                entries.add(ModItems.THE_LEVIATHAN_SPAWN_EGG);
                entries.add(ModItems.THE_BABY_LEVIATHAN_SPAWN_EGG);
                entries.add(ModItems.CORALSSUS_SPAWN_EGG);
                entries.add(ModItems.CORAL_GOLEM_SPAWN_EGG);
                entries.add(ModItems.DEEPLING_BRUTE_SPAWN_EGG);
                entries.add(ModItems.DEEPLING_WARLOCK_SPAWN_EGG);
                entries.add(ModItems.DEEPLING_PRIEST_SPAWN_EGG);
                entries.add(ModItems.DEEPLING_ANGLER_SPAWN_EGG);
                entries.add(ModItems.DEEPLING_SPAWN_EGG);
                entries.add(ModItems.LIONFISH_SPAWN_EGG);
                entries.add(ModItems.AMETHYST_CRAB_SPAWN_EGG);
                entries.add(ModItems.ANCIENT_REMNANT_SPAWN_EGG);
                entries.add(ModItems.MODERN_REMNANT_SPAWN_EGG);
                entries.add(ModItems.KOBOLEDIATOR_SPAWN_EGG);
                entries.add(ModItems.WADJET_SPAWN_EGG);
                entries.add(ModItems.KOBOLETON_SPAWN_EGG);
                entries.add(ModItems.MALEDICTUS_SPAWN_EGG);
                entries.add(ModItems.APTRGANGR_SPAWN_EGG);
                entries.add(ModItems.ELITE_DRAUGR_SPAWN_EGG);
                entries.add(ModItems.ROYAL_DRAUGR_SPAWN_EGG);
                entries.add(ModItems.DRAUGR_SPAWN_EGG);
            })
//            .withTabsBefore(ItemGroups.SPAWN_EGGS)
            .build());


    public static final ItemGroup BLOCK = registerItemGroup("cataclysm_block", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup." + Cataclysm.MOD_ID + ".block"))
            .icon(() -> new ItemStack(ModItems.VOID_STONE))
            .entries((enabledFeatures, entries) -> {
                entries.add(ModItems.ENDERITE_BLOCK);
                entries.add(ModItems.WITHERITE_BLCOK);
                entries.add(ModItems.IGNITIUM_BLOCK);
                entries.add(ModItems.ANCIENT_METAL_BLOCK);
                entries.add(ModItems.CURSIUM_BLOCK);
                entries.add(ModItems.DUNGEON_BLOCK);
                entries.add(ModItems.POLISHED_SANDSTONE);
                entries.add(ModItems.POLISHED_END_STONE);
                entries.add(ModItems.POLISHED_END_STONE_SLAB);
                entries.add(ModItems.POLISHED_END_STONE_STAIRS);
                entries.add(ModItems.CHISELED_END_STONE_BRICKS);
                entries.add(ModItems.END_STONE_PILLAR);
                entries.add(ModItems.VOID_INFUSED_END_STONE_BRICKS);
                entries.add(ModItems.VOID_STONE);
                entries.add(ModItems.VOID_CRYSTAL);
                entries.add(ModItems.VOID_LANTERN_BLOCK);
                entries.add(ModItems.OBSIDIAN_BRICKS);
                entries.add(ModItems.OBSIDIAN_BRICK_SLAB);
                entries.add(ModItems.OBSIDIAN_BRICK_STAIRS);
                entries.add(ModItems.OBSIDIAN_BRICK_WALL);
                entries.add(ModItems.POLISHED_OBSIDIAN);
                entries.add(ModItems.CHISELED_OBSIDIAN_BRICKS);

                entries.add(ModItems.CHISELED_PURPUR_BLOCK);
                entries.add(ModItems.PURPUR_WALL);
                entries.add(ModItems.PURPUR_VOID_RUNE_TRAP_BLOCK);
                entries.add(ModItems.END_STONE_TELEPORT_TRAP_BRICKS);
                entries.add(ModItems.OBSIDIAN_EXPLOSION_TRAP_BRICKS);
                entries.add(ModItems.SANDSTONE_POISON_DART_TRAP);
                entries.add(ModItems.SANDSTONE_IGNITE_TRAP);
                entries.add(ModItems.SANDSTONE_FALLING_TRAP);
                entries.add(ModItems.CHORUS_STEM);
                entries.add(ModItems.CHORUS_PLANKS);
                entries.add(ModItems.CHORUS_SLAB);
                entries.add(ModItems.CHORUS_STAIRS);
                entries.add(ModItems.CHORUS_FENCE);
                entries.add(ModItems.PRISMARINE_BRICK_FENCE);
                entries.add(ModItems.QUARTZ_BRICK_WALL);
                entries.add(ModItems.PRISMARINE_BRICK_WALL);
                entries.add(ModItems.STONE_PILLAR);
                entries.add(ModItems.CHISELED_STONE_BRICK_PILLAR);
                entries.add(ModItems.STONE_TILES);
                entries.add(ModItems.STONE_TILE_SLAB);
                entries.add(ModItems.STONE_TILE_STAIRS);
                entries.add(ModItems.STONE_TILE_WALL);
                entries.add(ModItems.BLACKSTONE_PILLAR);
                entries.add(ModItems.AZURE_SEASTONE);
                entries.add(ModItems.AZURE_SEASTONE_SLAB);
                entries.add(ModItems.AZURE_SEASTONE_STAIRS);
                entries.add(ModItems.AZURE_SEASTONE_WALL);
                entries.add(ModItems.AZURE_SEASTONE_FENCE);
                entries.add(ModItems.AZURE_SEASTONE_TILES);
                entries.add(ModItems.CHISELED_AZURE_SEASTONE);
                entries.add(ModItems.AZURE_SEASTONE_BRICKS);
                entries.add(ModItems.AZURE_SEASTONE_BRICK_SLAB);
                entries.add(ModItems.AZURE_SEASTONE_BRICK_STAIRS);
                entries.add(ModItems.AZURE_SEASTONE_BRICK_WALL);
                entries.add(ModItems.POLISHED_AZURE_SEASTONE);
                entries.add(ModItems.POLISHED_AZURE_SEASTONE_SLAB);
                entries.add(ModItems.POLISHED_AZURE_SEASTONE_STAIRS);
                entries.add(ModItems.POLISHED_AZURE_SEASTONE_WALL);
                entries.add(ModItems.AZURE_SEASTONE_PILLAR);
                entries.add(ModItems.AZURE_SEASTONE_PILLAR_WALL);
                entries.add(ModItems.CHISELED_AZURE_SEASTONE_PILLAR);
                entries.add(ModItems.CHISELED_AZURE_SEASTONE_PILLAR_WALL);
                entries.add(ModItems.FROSTED_STONE_BRICKS);
                entries.add(ModItems.FROSTED_STONE_BRICK_SLAB);
                entries.add(ModItems.FROSTED_STONE_BRICK_STAIRS);
                entries.add(ModItems.FROSTED_STONE_BRICK_WALL);
                entries.add(ModItems.BLACK_STEEL_BLOCK);
                entries.add(ModItems.BLACK_STEEL_FENCE);
                entries.add(ModItems.BLACK_STEEL_WALL);
                entries.add(ModItems.POINTED_ICICLE);
                entries.add(ModBlocks.ALTAR_OF_FIRE.asItem());
                entries.add(ModBlocks.ALTAR_OF_VOID.asItem());
                entries.add(ModBlocks.ALTAR_OF_AMETHYST.asItem());
                entries.add(ModBlocks.ALTAR_OF_ABYSS.asItem());
                entries.add(ModBlocks.CURSED_TOMBSTONE.asItem());
                entries.add(ModBlocks.EMP.asItem());
                entries.add(ModBlocks.MECHANICAL_FUSION_ANVIL.asItem());
                entries.add(ModBlocks.DOOR_OF_SEAL.asItem());
                entries.add(ModBlocks.ABYSSAL_EGG.asItem());
                entries.add(ModItems.APTRGANGR_HEAD);
                entries.add(ModItems.DRAUGR_HEAD);
                entries.add(ModItems.KOBOLEDIATOR_SKULL);
            })
//            .withTabsBefore(ITEM.getKey())
            .build());

    private static ItemGroup registerItemGroup(String name, ItemGroup itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, Cataclysm.modIdentifier(name), itemGroup);
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering item groups for " + Cataclysm.MOD_ID);
    }

}

