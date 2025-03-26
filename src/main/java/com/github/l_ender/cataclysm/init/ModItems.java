package com.github.l_ender.cataclysm.init;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.entity.projectile.Void_Scatter_Arrow_Entity;
import com.github.l_ender.cataclysm.items.*;
import com.github.l_ender.cataclysm.items.CuriosItem.Blazing_Grips;
import com.github.l_ender.cataclysm.items.CuriosItem.Sticky_Gloves;
import com.github.l_ender.cataclysm.items.Dungeon_Eye.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

public class ModItems {

//    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
//            Cataclysm.MODID);

    public static final Item ENDERITE_BLOCK = registerItem("enderite_block",
            new BlockItem(ModBlocks.ENDERRITE_BLOCK, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item WITHERITE_BLCOK = registerItem("witherite_block",
            new BlockItem(ModBlocks.WITHERITE_BLOCK, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item IGNITIUM_BLOCK = registerItem("ignitium_block",
            new BlockItem(ModBlocks.IGNITIUM_BLOCK, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item ANCIENT_METAL_BLOCK = registerItem("ancient_metal_block",
            new BlockItem(ModBlocks.ANCIENT_METAL_BLOCK, new FabricItemSettings().fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item CURSIUM_BLOCK = registerItem("cursium_block",
            new BlockItem(ModBlocks.CURSIUM_BLOCK, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item DUNGEON_BLOCK = registerItem("dungeon_block",
            new BlockItem(ModBlocks.DUNGEON_BLOCK, new FabricItemSettings()));

    public static final Item POLISHED_SANDSTONE = registerItem("polished_sandstone",
            new BlockItem(ModBlocks.POLISHED_SANDSTONE, new FabricItemSettings()));

    public static final Item POLISHED_END_STONE = registerItem("polished_end_stone",
            new BlockItem(ModBlocks.POLISHED_END_STONE, new FabricItemSettings()));

    public static final Item POLISHED_END_STONE_SLAB = registerItem("polished_end_stone_slab",
            new BlockItem(ModBlocks.POLISHED_END_STONE_SLAB, new FabricItemSettings()));

    public static final Item POLISHED_END_STONE_STAIRS = registerItem("polished_end_stone_stairs",
            new BlockItem(ModBlocks.POLISHED_END_STONE_STAIRS, new FabricItemSettings()));

    public static final Item CHISELED_END_STONE_BRICKS = registerItem("chiseled_end_stone_bricks",
            new BlockItem(ModBlocks.CHISELED_END_STONE_BRICKS, new FabricItemSettings()));

    public static final Item END_STONE_PILLAR = registerItem("end_stone_pillar",
            new BlockItem(ModBlocks.END_STONE_PILLAR, new FabricItemSettings()));

    public static final Item VOID_INFUSED_END_STONE_BRICKS = registerItem("void_infused_end_stone_bricks",
            new BlockItem(ModBlocks.VOID_INFUSED_END_STONE_BRICKS, new FabricItemSettings()));

    public static final Item VOID_STONE = registerItem("void_stone",
            new BlockItem(ModBlocks.VOID_STONE, new FabricItemSettings().fireproof()));

    public static final Item VOID_CRYSTAL = registerItem("void_crystal",
            new BlockItem(ModBlocks.VOID_CRYSTAL, new FabricItemSettings()));

    public static final Item VOID_LANTERN_BLOCK = registerItem("void_lantern_block",
            new BlockItem(ModBlocks.VOID_LANTERN_BLOCK, new FabricItemSettings().fireproof()));

    public static final Item OBSIDIAN_BRICKS = registerItem("obsidian_bricks",
            new BlockItem(ModBlocks.OBSIDIAN_BRICKS, new FabricItemSettings()));

    public static final Item POLISHED_OBSIDIAN = registerItem("polished_obsidian",
            new BlockItem(ModBlocks.POLISHED_OBSIDIAN, new FabricItemSettings()));

    public static final Item CHISELED_OBSIDIAN_BRICKS = registerItem("chiseled_obsidian_bricks",
            new BlockItem(ModBlocks.CHISELED_OBSIDIAN_BRICKS, new FabricItemSettings()));

    public static final Item OBSIDIAN_BRICK_SLAB = registerItem("obsidian_brick_slab",
            new BlockItem(ModBlocks.OBSIDIAN_BRICK_SLAB, new FabricItemSettings()));

    public static final Item OBSIDIAN_BRICK_STAIRS = registerItem("obsidian_brick_stairs",
            new BlockItem(ModBlocks.OBSIDIAN_BRICK_STAIRS, new FabricItemSettings()));

    public static final Item OBSIDIAN_BRICK_WALL = registerItem("obsidian_brick_wall",
            new BlockItem(ModBlocks.OBSIDIAN_BRICK_WALL, new FabricItemSettings()));

    public static final Item CHISELED_PURPUR_BLOCK = registerItem("chiseled_purpur_block",
            new BlockItem(ModBlocks.CHISELED_PURPUR_BLOCK, new FabricItemSettings()));

    public static final Item PURPUR_WALL = registerItem("purpur_wall",
            new BlockItem(ModBlocks.PURPUR_WALL, new FabricItemSettings()));

    public static final Item PURPUR_VOID_RUNE_TRAP_BLOCK = registerItem("purpur_void_rune_trap_block",
            new BlockItem(ModBlocks.PURPUR_VOID_RUNE_TRAP_BLOCK, new FabricItemSettings()));

    public static final Item END_STONE_TELEPORT_TRAP_BRICKS = registerItem("end_stone_teleport_trap_bricks",
            new BlockItem(ModBlocks.END_STONE_TELEPORT_TRAP_BRICKS, new FabricItemSettings()));

    public static final Item OBSIDIAN_EXPLOSION_TRAP_BRICKS = registerItem("obsidian_explosion_trap_bricks",
            new BlockItem(ModBlocks.OBSIDIAN_EXPLOSION_TRAP_BRICKS, new FabricItemSettings()));

    public static final Item SANDSTONE_POISON_DART_TRAP = registerItem("sandstone_poison_dart_trap",
            new BlockItem(ModBlocks.SANDSTONE_POISON_DART_TRAP, new FabricItemSettings()));

    public static final Item SANDSTONE_IGNITE_TRAP = registerItem("sandstone_ignite_trap",
            new BlockItem(ModBlocks.SANDSTONE_IGNITE_TRAP, new FabricItemSettings()));

    public static final Item SANDSTONE_FALLING_TRAP = registerItem("sandstone_falling_trap",
            new BlockItem(ModBlocks.SANDSTONE_FALLING_TRAP, new FabricItemSettings()));

    public static final Item CHORUS_STEM = registerItem("chorus_stem",
            new BlockItem(ModBlocks.CHORUS_STEM, new FabricItemSettings()));

    public static final Item CHORUS_PLANKS = registerItem("chorus_planks",
            new BlockItem(ModBlocks.CHORUS_PLANKS, new FabricItemSettings()));

    public static final Item CHORUS_SLAB = registerItem("chorus_slab",
            new BlockItem(ModBlocks.CHORUS_SLAB, new FabricItemSettings()));

    public static final Item CHORUS_STAIRS = registerItem("chorus_stairs",
            new BlockItem(ModBlocks.CHORUS_STAIRS, new FabricItemSettings()));

    public static final Item CHORUS_FENCE = registerItem("chorus_fence",
            new BlockItem(ModBlocks.CHORUS_FENCE, new FabricItemSettings()));

    public static final Item PRISMARINE_BRICK_FENCE = registerItem("prismarine_brick_fence",
            new BlockItem(ModBlocks.PRISMARINE_BRICK_FENCE, new FabricItemSettings()));

    public static final Item QUARTZ_BRICK_WALL = registerItem("quartz_brick_wall",
            new BlockItem(ModBlocks.QUARTZ_BRICK_WALL, new FabricItemSettings()));

    public static final Item PRISMARINE_BRICK_WALL = registerItem("prismarine_brick_wall",
            new BlockItem(ModBlocks.PRISMARINE_BRICK_WALL, new FabricItemSettings()));

    public static final Item STONE_PILLAR = registerItem("stone_pillar",
            new BlockItem(ModBlocks.STONE_PILLAR, new FabricItemSettings()));

    public static final Item CHISELED_STONE_BRICK_PILLAR = registerItem("chiseled_stone_brick_pillar",
            new BlockItem(ModBlocks.CHISELED_STONE_BRICK_PILLAR, new FabricItemSettings()));

    public static final Item STONE_TILES = registerItem("stone_tiles",
            new BlockItem(ModBlocks.STONE_TILES, new FabricItemSettings()));

    public static final Item STONE_TILE_SLAB = registerItem("stone_tile_slab",
            new BlockItem(ModBlocks.STONE_TILE_SLAB, new FabricItemSettings()));

    public static final Item STONE_TILE_STAIRS = registerItem("stone_tile_stairs",
            new BlockItem(ModBlocks.STONE_TILE_STAIRS, new FabricItemSettings()));

    public static final Item STONE_TILE_WALL = registerItem("stone_tile_wall",
            new BlockItem(ModBlocks.STONE_TILE_WALL, new FabricItemSettings()));

    public static final Item BLACKSTONE_PILLAR = registerItem("blackstone_pillar",
            new BlockItem(ModBlocks.BLACKSTONE_PILLAR, new FabricItemSettings()));

    public static final Item AZURE_SEASTONE = registerItem("azure_seastone",
            new BlockItem(ModBlocks.AZURE_SEASTONE, new FabricItemSettings()));

    public static final Item AZURE_SEASTONE_SLAB = registerItem("azure_seastone_slab",
            new BlockItem(ModBlocks.AZURE_SEASTONE_SLAB, new FabricItemSettings()));

    public static final Item AZURE_SEASTONE_STAIRS = registerItem("azure_seastone_stairs",
            new BlockItem(ModBlocks.AZURE_SEASTONE_STAIRS, new FabricItemSettings()));

    public static final Item AZURE_SEASTONE_WALL = registerItem("azure_seastone_wall",
            new BlockItem(ModBlocks.AZURE_SEASTONE_WALL, new FabricItemSettings()));

    public static final Item AZURE_SEASTONE_FENCE = registerItem("azure_seastone_fence",
            new BlockItem(ModBlocks.AZURE_SEASTONE_FENCE, new FabricItemSettings()));

    public static final Item AZURE_SEASTONE_TILES = registerItem("azure_seastone_tiles",
            new BlockItem(ModBlocks.AZURE_SEASTONE_TILES, new FabricItemSettings()));

    public static final Item CHISELED_AZURE_SEASTONE = registerItem("chiseled_azure_seastone",
            new BlockItem(ModBlocks.CHISELED_AZURE_SEASTONE, new FabricItemSettings()));

    public static final Item AZURE_SEASTONE_BRICKS = registerItem("azure_seastone_bricks",
            new BlockItem(ModBlocks.AZURE_SEASTONE_BRICKS, new FabricItemSettings()));

    public static final Item AZURE_SEASTONE_BRICK_SLAB = registerItem("azure_seastone_brick_slab",
            new BlockItem(ModBlocks.AZURE_SEASTONE_BRICK_SLAB, new FabricItemSettings()));

    public static final Item AZURE_SEASTONE_BRICK_STAIRS = registerItem("azure_seastone_brick_stairs",
            new BlockItem(ModBlocks.AZURE_SEASTONE_BRICK_STAIRS, new FabricItemSettings()));

    public static final Item AZURE_SEASTONE_BRICK_WALL = registerItem("azure_seastone_brick_wall",
            new BlockItem(ModBlocks.AZURE_SEASTONE_BRICK_WALL, new FabricItemSettings()));

    public static final Item POLISHED_AZURE_SEASTONE = registerItem("polished_azure_seastone",
            new BlockItem(ModBlocks.POLISHED_AZURE_SEASTONE, new FabricItemSettings()));

    public static final Item POLISHED_AZURE_SEASTONE_SLAB = registerItem("polished_azure_seastone_slab",
            new BlockItem(ModBlocks.POLISHED_AZURE_SEASTONE_SLAB, new FabricItemSettings()));

    public static final Item POLISHED_AZURE_SEASTONE_STAIRS = registerItem("polished_azure_seastone_stairs",
            new BlockItem(ModBlocks.POLISHED_AZURE_SEASTONE_STAIRS, new FabricItemSettings()));

    public static final Item POLISHED_AZURE_SEASTONE_WALL = registerItem("polished_azure_seastone_wall",
            new BlockItem(ModBlocks.POLISHED_AZURE_SEASTONE_WALL, new FabricItemSettings()));

    public static final Item AZURE_SEASTONE_PILLAR = registerItem("azure_seastone_pillar",
            new BlockItem(ModBlocks.AZURE_SEASTONE_PILLAR, new FabricItemSettings()));

    public static final Item AZURE_SEASTONE_PILLAR_WALL = registerItem("azure_seastone_pillar_wall",
            new BlockItem(ModBlocks.AZURE_SEASTONE_PILLAR_WALL, new FabricItemSettings()));

    public static final Item CHISELED_AZURE_SEASTONE_PILLAR = registerItem("chiseled_azure_seastone_pillar",
            new BlockItem(ModBlocks.CHISELED_AZURE_SEASTONE_PILLAR, new FabricItemSettings()));

    public static final Item CHISELED_AZURE_SEASTONE_PILLAR_WALL = registerItem("chiseled_azure_seastone_pillar_wall",
            new BlockItem(ModBlocks.CHISELED_AZURE_SEASTONE_PILLAR_WALL, new FabricItemSettings()));

    public static final Item FROSTED_STONE_BRICKS = registerItem("frosted_stone_bricks",
            new BlockItem(ModBlocks.FROSTED_STONE_BRICKS, new FabricItemSettings()));

    public static final Item FROSTED_STONE_BRICK_SLAB = registerItem("frosted_stone_brick_slab",
            new BlockItem(ModBlocks.FROSTED_STONE_BRICK_SLAB, new FabricItemSettings()));

    public static final Item FROSTED_STONE_BRICK_STAIRS = registerItem("frosted_stone_brick_stairs",
            new BlockItem(ModBlocks.FROSTED_STONE_BRICK_STAIRS, new FabricItemSettings()));

    public static final Item FROSTED_STONE_BRICK_WALL = registerItem("frosted_stone_brick_wall",
            new BlockItem(ModBlocks.FROSTED_STONE_BRICK_WALL, new FabricItemSettings()));

    public static final Item BLACK_STEEL_BLOCK = registerItem("black_steel_block",
            new BlockItem(ModBlocks.BLACK_STEEL_BLOCK, new FabricItemSettings()));

    public static final Item BLACK_STEEL_FENCE = registerItem("black_steel_fence",
            new BlockItem(ModBlocks.BLACK_STEEL_FENCE, new FabricItemSettings()));

    public static final Item BLACK_STEEL_WALL = registerItem("black_steel_wall",
            new BlockItem(ModBlocks.BLACK_STEEL_WALL, new FabricItemSettings()));


    public static final Item POINTED_ICICLE = registerItem("pointed_icicle",
            new BlockItem(ModBlocks.POINTED_ICICLE, new FabricItemSettings()));

    public static final Item WITHERITE_INGOT = registerItem("witherite_ingot",
            new Item(new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item ENDERITE_INGOT = registerItem("enderite_ingot",
            new ItemInventoryOnly(new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item ANCIENT_METAL_INGOT = registerItem("ancient_metal_ingot",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));

    public static final Item ANCIENT_METAL_NUGGET = registerItem("ancient_metal_nugget",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));


    public static final Item BLACK_STEEL_INGOT = registerItem("black_steel_ingot",
            new Item(new FabricItemSettings()));

    public static final Item BLACK_STEEL_NUGGET = registerItem("black_steel_nugget",
            new Item(new FabricItemSettings()));


    public static final Item IGNITIUM_INGOT = registerItem("ignitium_ingot",
            new Item(new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item CURSIUM_INGOT = registerItem("cursium_ingot",
            new Item(new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item IGNITIUM_UPGARDE_SMITHING_TEMPLATE = registerItem("ignitium_upgrade_smithing_template",
            ModTemplate.createignitiumUpgradeTemplate());

    public static final Item CURSIUM_UPGARDE_SMITHING_TEMPLATE = registerItem("cursium_upgrade_smithing_template",
            ModTemplate.createcursiumUpgradeTemplate());

    public static final Item CHAIN_OF_SOUL_BINDING = registerItem("chain_of_soul_binding",
            new ItemInventoryOnly(new FabricItemSettings()));

    public static final Item CORAL_SPEAR = registerItem("coral_spear",
            new Coral_Spear((new FabricItemSettings()).maxDamage(110)));

    public static final Item CORAL_BARDICHE = registerItem("coral_bardiche",
            new Coral_Bardiche((new FabricItemSettings()).maxDamage(160)));

    public static final Item ATHAME = registerItem("athame",
            new Athame((new FabricItemSettings()).maxDamage(250)));

    public static final Item KHOPESH = registerItem("khopesh",
            new Khopesh(Tooltier.ANCIENT_METAL, new FabricItemSettings()));

    public static final Item BLACK_STEEL_SWORD = registerItem("black_steel_sword",
            new SwordItem(Tooltier.BLACK_STEEL, 3, -2.4F, new FabricItemSettings()));

    public static final Item BLACK_STEEL_SHOVEL = registerItem("black_steel_shovel",
            new ShovelItem(Tooltier.BLACK_STEEL, 1.5F, -3.0F, new FabricItemSettings()));

    public static final Item BLACK_STEEL_PICKAXE = registerItem("black_steel_pickaxe",
            new PickaxeItem(Tooltier.BLACK_STEEL, 1, -2.8F, new FabricItemSettings()));

    public static final Item BLACK_STEEL_AXE = registerItem("black_steel_axe",
            new AxeItem(Tooltier.BLACK_STEEL, 6.0F, -3.1F, new FabricItemSettings()));


    public static final Item BLACK_STEEL_HOE = registerItem("black_steel_hoe",
            new HoeItem(Tooltier.BLACK_STEEL, -2, -1.0F, new FabricItemSettings()));

    public static final Item BLACK_STEEL_TARGE = registerItem("black_steel_targe",
            new Black_Steel_Targe(new FabricItemSettings().maxDamage(840)));

    public static final Item BULWARK_OF_THE_FLAME = registerItem("bulwark_of_the_flame",
            new Bulwark_of_the_flame(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    public static final Item GAUNTLET_OF_GUARD = registerItem("gauntlet_of_guard",
            new Gauntlet_of_Guard(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    public static final Item GAUNTLET_OF_BULWARK = registerItem("gauntlet_of_bulwark",
            new Gauntlet_of_Bulwark(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    public static final Item GAUNTLET_OF_MAELSTROM = registerItem("gauntlet_of_maelstrom",
            new Gauntlet_of_Maelstrom(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));


    public static final Item THE_INCINERATOR = registerItem("the_incinerator",
            new The_Incinerator(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    public static final Item BLAZING_GRIPS = registerItem("blazing_grips",
            new Blazing_Grips(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    public static final Item CURSED_BOW = registerItem("cursed_bow",
            new Cursed_bow(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    public static final Item WRATH_OF_THE_DESERT = registerItem("wrath_of_the_desert",
            new Wrath_of_the_desert(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    public static final Item SOUL_RENDER = registerItem("soul_render",
            new Soul_Render(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.EPIC)));

    public static final Item THE_ANNIHILATOR = registerItem("the_annihilator",
            new The_Annihilator(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.EPIC)));

    public static final Item THE_IMMOLATOR = registerItem("the_immolator",
            new The_Immolator(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.EPIC)));

    public static final Item MEAT_SHREDDER = registerItem("meat_shredder",
            new Meat_Shredder(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.EPIC)));

    public static final Item LASER_GATLING = registerItem("laser_gatling",
            new Laser_Gatling(new FabricItemSettings().maxCount(1).fireproof().maxDamage(50).rarity(Rarity.EPIC)));

    public static final Item WITHER_ASSULT_SHOULDER_WEAPON = registerItem("wither_assault_shoulder_weapon",
            new Wither_Assault_SHoulder_Weapon(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    public static final Item VOID_ASSULT_SHOULDER_WEAPON = registerItem("void_assault_shoulder_weapon",
            new Void_Assault_SHoulder_Weapon(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    public static final Item VOID_FORGE = registerItem("void_forge",
            new void_forge(Tooltier.MONSTROSITY, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item TIDAL_CLAWS = registerItem("tidal_claws",
            new Tidal_Claws(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    public static final Item FINAL_FRACTAL = registerItem("final_fractal",
            new final_fractal(ModItemTier.TOOL_WITHERITE, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item ZWEIENDER = registerItem("zweiender",
            new zweiender(ModItemTier.TOOL_ENDERITE, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item INFERNAL_FORGE = registerItem("infernal_forge",
            new infernal_forge(Tooltier.MONSTROSITY, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item SANDSTORM_IN_A_BOTTLE = registerItem("sandstorm_in_a_bottle",
            new Sandstorm_In_A_Bottle(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    public static final Item ANCIENT_SPEAR = registerItem("ancient_spear",
            new Ancient_Spear(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof().maxDamage(1800)));

    public static final Item STICKY_GLOVES = registerItem("sticky_gloves",
            new Sticky_Gloves(new FabricItemSettings().maxCount(1)));

    public static final Item REMNANT_SKULL = registerItem("remnant_skull",
            new Remnant_Skull(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    public static final Item NETHERITE_EFFIGY = registerItem("netherite_effigy",
            new Netherite_Effigy(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    public static final Item VOID_SCATTER_ARROW = registerItem("void_scatter_arrow",
            new Void_Scatter_Arrow_Item(new FabricItemSettings().fireproof()));

    public static final Item VOID_SHARD = registerItem("void_shard",
            new ItemInventoryOnly(new FabricItemSettings().fireproof()));

    public static final Item BLAZING_BONE = registerItem("blazing_bone",
            new ItemInventoryOnly(new FabricItemSettings().fireproof()));

    public static final Item KOBOLETON_BONE = registerItem("koboleton_bone",
            new Item(new FabricItemSettings()));

    public static final Item VOID_JAW = registerItem("void_jaw",
            new Item(new FabricItemSettings().fireproof()));

    public static final Item VOID_CORE = registerItem("void_core",
            new void_core(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item CRYSTALLIZED_CORAL_FRAGMENTS = registerItem("crystallized_coral_fragments",
            new Item(new FabricItemSettings()));

    public static final Item CRYSTALLIZED_CORAL = registerItem("crystallized_coral",
            new Item(new FabricItemSettings()));

    public static final Item CORAL_CHUNK = registerItem("coral_chunk",
            new Item(new FabricItemSettings()));

    public static final Item ABYSSAL_SACRIFICE = registerItem("abyssal_sacrifice",
            new Item(new FabricItemSettings().fireproof().rarity(Rarity.RARE)));

    public static final Item NECKLACE_OF_THE_DESERT = registerItem("necklace_of_the_desert",
            new Necklace_Of_The_Desert(new FabricItemSettings().fireproof().rarity(Rarity.RARE)));

    public static final Item APTRGANGR_HEAD = registerItem("aptrgangr_head",
            new CataclysmSkullItem(ModBlocks.APTRGANGR_HEAD, ModBlocks.APTRGANGR_WALL_HEAD, (new FabricItemSettings()).rarity(Rarity.UNCOMMON)));

    public static final Item DRAUGR_HEAD = registerItem("draugr_head",
            new CataclysmSkullItem(ModBlocks.DRAUGR_HEAD, ModBlocks.DRAUGR_WALL_HEAD, (new FabricItemSettings()).rarity(Rarity.UNCOMMON)));


    public static final Item KOBOLEDIATOR_SKULL = registerItem("kobolediator_skull",
            new CataclysmSkullItem(ModBlocks.KOBOLEDIATOR_SKULL, ModBlocks.KOBOLEDIATOR_WALL_SKULL, (new FabricItemSettings()).rarity(Rarity.UNCOMMON)));

    public static final Item BONE_REPTILE_HELMET = registerItem("bone_reptile_helmet",
            new Bone_Reptile_Armor(Armortier.BONE_REPTILE, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item BONE_REPTILE_CHESTPLATE = registerItem("bone_reptile_chestplate",
            new Bone_Reptile_Armor(Armortier.BONE_REPTILE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final Item IGNITIUM_HELMET = registerItem("ignitium_helmet",
            new Ignitium_Armor(Armortier.IGNITIUM, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item IGNITIUM_CHESTPLATE = registerItem("ignitium_chestplate",
            new Ignitium_Armor(Armortier.IGNITIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item IGNITIUM_ELYTRA_CHESTPLATE = registerItem("ignitium_elytra_chestplate",
            new Ignitium_Elytra_ChestPlate(new FabricItemSettings().fireproof().rarity(Rarity.EPIC), Armortier.IGNITIUM));

    public static final Item IGNITIUM_LEGGINGS = registerItem("ignitium_leggings",
            new Ignitium_Armor(Armortier.IGNITIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item IGNITIUM_BOOTS = registerItem("ignitium_boots",
            new Ignitium_Armor(Armortier.IGNITIUM, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item CURSIUM_HELMET = registerItem("cursium_helmet",
            new Cursium_Armor(Armortier.CURSIUM, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item CURSIUM_CHESTPLATE = registerItem("cursium_chestplate",
            new Cursium_Armor(Armortier.CURSIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item CURSIUM_LEGGINGS = registerItem("cursium_leggings",
            new Cursium_Armor(Armortier.CURSIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item CURSIUM_BOOTS = registerItem("cursium_boots",
            new Cursium_Armor(Armortier.CURSIUM, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item MONSTROUS_HORN = registerItem("monstrous_horn",
            new Item(new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item LAVA_POWER_CELL = registerItem("lava_power_cell",
            new Item(new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item MONSTROUS_HELM = registerItem("monstrous_helm",
            new Monstrous_Helm(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    public static final Item BLOOM_STONE_PAULDRONS = registerItem("bloom_stone_pauldrons",
            new Bloom_Stone_Pauldrons(Armortier.CRAB, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item BURNING_ASHES = registerItem("burning_ashes",
            new Item(new FabricItemSettings().fireproof().rarity(Rarity.RARE)));

    public static final Item DYING_EMBER = registerItem("dying_ember",
            new Item(new FabricItemSettings().fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item MUSIC_DISC_NETHERITE_MONSTROSITY = registerItem("music_disc_netherite_monstrosity",
            new MusicDiscItem(14, ModSounds.MONSTROSITY_MUSIC,new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof(), 289 * 20));

    public static final Item MUSIC_DISC_ENDER_GUARDIAN = registerItem("music_disc_ender_guardian",
            new MusicDiscItem(14, ModSounds.ENDERGUARDIAN_MUSIC,new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof(), 196 * 20));

    public static final Item MUSIC_DISC_IGNIS = registerItem("music_disc_ignis",
            new MusicDiscItem(14, ModSounds.IGNIS_MUSIC,new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof(), 153 * 20));

    public static final Item MUSIC_DISC_THE_HARBINGER = registerItem("music_disc_the_harbinger",
            new MusicDiscItem(14, ModSounds.HARBINGER_MUSIC,new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof(), 189 * 20));

    public static final Item MUSIC_DISC_THE_LEVIATHAN = registerItem("music_disc_the_leviathan",
            new MusicDiscItem(14, ModSounds.LEVIATHAN_MUSIC,new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof(), 291 * 20));

    public static final Item MUSIC_DISC_ANCIENT_REMNANT = registerItem("music_disc_ancient_remnant",
            new MusicDiscItem(14, ModSounds.REMNANT_MUSIC,new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof(), 212 * 20));

    public static final Item MUSIC_DISC_MALEDICTUS = registerItem("music_disc_maledictus",
            new MusicDiscItem(14, ModSounds.MALEDICTUS_MUSIC_DISC,new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof(), 201 * 20));


    public static final Item MECH_EYE = registerItem("mech_eye",
            new DungeonEyeItem(ModTag.EYE_OF_MECH_LOCATED, new int[]{255, 51, 0}, new FabricItemSettings().fireproof()));

    public static final Item FLAME_EYE = registerItem("flame_eye",
            new DungeonEyeItem(ModTag.EYE_OF_FLAME_LOCATED, new int[]{252, 149, 0}, new FabricItemSettings().fireproof()));

    public static final Item VOID_EYE = registerItem("void_eye",
            new DungeonEyeItem(ModTag.EYE_OF_RUINED_LOCATED, new int[]{255, 51, 0}, new FabricItemSettings().fireproof()));

    public static final Item MONSTROUS_EYE = registerItem("monstrous_eye",
            new DungeonEyeItem(ModTag.EYE_OF_MONSTROUS_LOCATED, new int[]{90, 87, 90}, new FabricItemSettings().fireproof()));

    public static final Item ABYSS_EYE = registerItem("abyss_eye",
            new DungeonEyeItem(ModTag.EYE_OF_ABYSS_LOCATED, new int[]{33, 22, 43}, new FabricItemSettings().fireproof()));

    public static final Item DESERT_EYE = registerItem("desert_eye",
            new DungeonEyeItem(ModTag.EYE_OF_DESERT_LOCATED, new int[]{247, 168, 64}, new FabricItemSettings().fireproof()));

    public static final Item CURSED_EYE = registerItem("cursed_eye",
            new DungeonEyeItem(ModTag.EYE_OF_CURSE_LOCATED, new int[]{26, 107, 89}, new FabricItemSettings().fireproof()));

    public static final Item LIONFISH = registerItem("lionfish",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 300, 0), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 1.0F)
                    .build())));

    public static final Item AMETHYST_CRAB_MEAT = registerItem("amethyst_crab_meat",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(1.2F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1.0F).build())));


    public static final Item BLESSED_AMETHYST_CRAB_MEAT = registerItem("blessed_amethyst_crab_meat",
            new Blessed_Amethyst_Crab_Meat(new FabricItemSettings().rarity(Rarity.EPIC).food(new FoodComponent.Builder().hunger(6).saturationModifier(1.2F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0), 1.0F)
                    .statusEffect(new StatusEffectInstance(ModEffect.EFFECTBLESSING_OF_AMETHYST, 1800, 0), 1.0F)
                    .alwaysEdible()
                    .build())));

    public static final Item AMETHYST_CRAB_SHELL = registerItem("amethyst_crab_shell",
            new Item(new FabricItemSettings()));

    public static final Item LIONFISH_SPIKE = registerItem("lionfish_spike",
            new ItemInventoryOnly(new FabricItemSettings()));

    public static final Item THE_BABY_LEVIATHAN_BUCKET = registerItem("the_baby_leviathan_bucket",
            new EntityBucketItem(ModEntities.THE_BABY_LEVIATHAN, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new FabricItemSettings().fireproof()));

    public static final Item MODERN_REMNANT_BUCKET = registerItem("modern_remnant_bucket",
            new ModernRemantBucket(ModEntities.MODERN_REMNANT, Fluids.EMPTY, new FabricItemSettings().fireproof()));

    public static final Item NETHERITE_MINISTROSITY_BUCKET = registerItem("netherite_ministrosity_bucket",
            new ModernRemantBucket(ModEntities.NETHERITE_MINISTROSITY, Fluids.EMPTY, new FabricItemSettings().fireproof()));

    public static final Item ENDER_GOLEM_SPAWN_EGG = registerItem("ender_golem_spawn_egg",
            new SpawnEggItem(ModEntities.ENDER_GOLEM, 0x2a1a42, 0xa153fe, new FabricItemSettings()));

    public static final Item NETHERITE_MONSTROSITY_SPAWN_EGG = registerItem("netherite_monstrosity_spawn_egg",
            new SpawnEggItem(ModEntities.NETHERITE_MONSTROSITY, 0x4d494d, 0xf48522, new FabricItemSettings()));

    public static final Item NETHERITE_MINISTROSITY_SPAWN_EGG = registerItem("netherite_ministrosity_spawn_egg",
            new SpawnEggItem(ModEntities.NETHERITE_MINISTROSITY, 0x6b686b, 0xc25f01, new FabricItemSettings()));

    public static final Item NAMELESS_SORCERER_SPAWN_EGG = registerItem("nameless_sorcerer_spawn_egg",
            new SpawnEggItem(ModEntities.NAMELESS_SORCERER, 9804699, 0xB92424, new FabricItemSettings()));

    public static final Item ENDER_GUARDIAN_SPAWN_EGG = registerItem("ender_guardian_spawn_egg",
            new SpawnEggItem(ModEntities.ENDER_GUARDIAN, 0x2a1a42, 9725844, new FabricItemSettings()));

    public static final Item ENDERMAPTERA_SPAWN_EGG = registerItem("endermaptera_spawn_egg",
            new SpawnEggItem(ModEntities.ENDERMAPTERA, 0x2a1a42, 7237230, new FabricItemSettings()));

    public static final Item IGNIS_SPAWN_EGG = registerItem("ignis_spawn_egg",
            new SpawnEggItem(ModEntities.IGNIS, 16167425, 16579584, new FabricItemSettings()));

    public static final Item IGNITED_REVENANT_SPAWN_EGG = registerItem("ignited_revenant_spawn_egg",
            new SpawnEggItem(ModEntities.IGNITED_REVENANT, 4672845, 16579584, new FabricItemSettings()));

    public static final Item IGNITED_BERSERKER_SPAWN_EGG = registerItem("ignited_berserker_spawn_egg",
            new SpawnEggItem(ModEntities.IGNITED_BERSERKER, 4672845, 16579584, new FabricItemSettings()));

    public static final Item THE_WATCHER_SPAWN_EGG = registerItem("the_watcher_spawn_egg",
            new SpawnEggItem(ModEntities.THE_WATCHER, 0x737c8b, 0xe83b3b, new FabricItemSettings()));

    public static final Item THE_PROWLER_SPAWN_EGG = registerItem("the_prowler_spawn_egg",
            new SpawnEggItem(ModEntities.THE_PROWLER, 0x1e2021, 0x682e22, new FabricItemSettings()));

    public static final Item THE_HARBINGER_SPAWN_EGG = registerItem("the_harbinger_spawn_egg",
            new SpawnEggItem(ModEntities.THE_HARBINGER, 0x1e2021, 0xae2334, new FabricItemSettings()));

    public static final Item THE_LEVIATHAN_SPAWN_EGG = registerItem("the_leviathan_spawn_egg",
            new SpawnEggItem(ModEntities.THE_LEVIATHAN, 0x150e1b, 0x6500ff, new FabricItemSettings()));

    public static final Item THE_BABY_LEVIATHAN_SPAWN_EGG = registerItem("the_baby_leviathan_spawn_egg",
            new SpawnEggItem(ModEntities.THE_BABY_LEVIATHAN, 0x322141, 0x8a3eff, new FabricItemSettings()));

    public static final Item DEEPLING_SPAWN_EGG = registerItem("deepling_spawn_egg",
            new SpawnEggItem(ModEntities.DEEPLING, 0x182a3c, 0xbaedf4, new FabricItemSettings()));

    public static final Item DEEPLING_BRUTE_SPAWN_EGG = registerItem("deepling_brute_spawn_egg",
            new SpawnEggItem(ModEntities.DEEPLING_BRUTE, 0x182a3c, 0x6500ff, new FabricItemSettings()));

    public static final Item DEEPLING_ANGLER_SPAWN_EGG = registerItem("deepling_angler_spawn_egg",
            new SpawnEggItem(ModEntities.DEEPLING_ANGLER, 0x182a3c, 0x98d8e2, new FabricItemSettings()));

    public static final Item DEEPLING_PRIEST_SPAWN_EGG = registerItem("deepling_priest_spawn_egg",
            new SpawnEggItem(ModEntities.DEEPLING_PRIEST, 0x182a3c, 0x082054, new FabricItemSettings()));

    public static final Item DEEPLING_WARLOCK_SPAWN_EGG = registerItem("deepling_warlock_spawn_egg",
            new SpawnEggItem(ModEntities.DEEPLING_WARLOCK, 0x182a3c, 0xd66a98, new FabricItemSettings()));

    public static final Item LIONFISH_SPAWN_EGG = registerItem("lionfish_spawn_egg",
            new SpawnEggItem(ModEntities.LIONFISH, 0x98d8e2, 0x182a3c, new FabricItemSettings()));

    public static final Item CORAL_GOLEM_SPAWN_EGG = registerItem("coral_golem_spawn_egg",
            new SpawnEggItem(ModEntities.CORAL_GOLEM, 0x2143a4, 0xa4222f, new FabricItemSettings()));

    public static final Item CORALSSUS_SPAWN_EGG = registerItem("coralssus_spawn_egg",
            new SpawnEggItem(ModEntities.CORALSSUS, 0x3f6ce5, 0xedec4c, new FabricItemSettings()));

    public static final Item AMETHYST_CRAB_SPAWN_EGG = registerItem("amethyst_crab_spawn_egg",
            new SpawnEggItem(ModEntities.AMETHYST_CRAB, 0x646464, 0x7a5bb5, new FabricItemSettings()));

    public static final Item KOBOLETON_SPAWN_EGG = registerItem("koboleton_spawn_egg",
            new SpawnEggItem(ModEntities.KOBOLETON, 0xb7b196, 0xe18103, new FabricItemSettings()));

    public static final Item KOBOLEDIATOR_SPAWN_EGG = registerItem("kobolediator_spawn_egg",
            new SpawnEggItem(ModEntities.KOBOLEDIATOR, 0xb7b196, 0x945b31, new FabricItemSettings()));

    public static final Item WADJET_SPAWN_EGG = registerItem("wadjet_spawn_egg",
            new SpawnEggItem(ModEntities.WADJET, 0xb7b196, 0xdbb86a, new FabricItemSettings()));

    public static final Item ANCIENT_REMNANT_SPAWN_EGG = registerItem("ancient_remnant_spawn_egg",
            new SpawnEggItem(ModEntities.ANCIENT_REMNANT, 0xb7b196, 0x682e22, new FabricItemSettings()));

    public static final Item MODERN_REMNANT_SPAWN_EGG = registerItem("modern_remnant_spawn_egg",
            new SpawnEggItem(ModEntities.MODERN_REMNANT, 0xb7b196, 0xdbcca7, new FabricItemSettings()));

    public static final Item MALEDICTUS_SPAWN_EGG = registerItem("maledictus_spawn_egg",
            new SpawnEggItem(ModEntities.MALEDICTUS,0x39d2b2, 0x945b31, new FabricItemSettings()));

    public static final Item APTRGANGR_SPAWN_EGG = registerItem("aptrgangr_spawn_egg",
            new SpawnEggItem(ModEntities.APTRGANGR,0x392116, 0xe8e7e4, new FabricItemSettings()));

    public static final Item ELITE_DRAUGR_SPAWN_EGG = registerItem("elite_draugr_spawn_egg",
            new SpawnEggItem(ModEntities.ELITE_DRAUGR,0x392116, 0x442318, new FabricItemSettings()));

    public static final Item ROYAL_DRAUGR_SPAWN_EGG = registerItem("royal_draugr_spawn_egg",
            new SpawnEggItem(ModEntities.ROYAL_DRAUGR,0x392116, 0x945b31, new FabricItemSettings()));

    public static final Item DRAUGR_SPAWN_EGG = registerItem("draugr_spawn_egg",
            new SpawnEggItem(ModEntities.DRAUGR,0x392116, 0x2b2825, new FabricItemSettings()));

    public static void initDispenser(){
        DispenserBlock.registerBehavior(VOID_SCATTER_ARROW, new ProjectileDispenserBehavior() {
            /**
             * Return the projectile entity spawned by this dispense behavior.
             */
            protected ProjectileEntity createProjectile(World worldIn, Position position, ItemStack stackIn) {
                return new Void_Scatter_Arrow_Entity(ModEntities.VOID_SCATTER_ARROW, position.getX(), position.getY(), position.getZ(), worldIn);
            }
        });
        DispenserBehavior dispenseItemBehavior = new ItemDispenserBehavior() {
            private final ItemDispenserBehavior defaultDispenseItemBehavior = new ItemDispenserBehavior();

            public ItemStack dispenseSilently(BlockPointer blockSource, ItemStack itemStack) {
                FluidModificationItem dispensibleContainerItem = (FluidModificationItem) itemStack.getItem();
                BlockPos blockPos = blockSource.getPos().offset(blockSource.getBlockState().get(DispenserBlock.FACING));
                World level = blockSource.getWorld();
                if (dispensibleContainerItem.placeFluid(null, level, blockPos, null)) {
                    dispensibleContainerItem.onEmptied(null, level, itemStack, blockPos);
                    return new ItemStack(Items.BUCKET);
                } else {
                    return this.defaultDispenseItemBehavior.dispense(blockSource, itemStack);
                }
            }
        };
        DispenserBlock.registerBehavior(THE_BABY_LEVIATHAN_BUCKET, dispenseItemBehavior);
        DispenserBlock.registerBehavior(MODERN_REMNANT_BUCKET, dispenseItemBehavior);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Cataclysm.modIdentifier(name), item);
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering items for " + Cataclysm.MOD_ID);
    }
}


