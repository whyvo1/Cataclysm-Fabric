package com.github.l_ender.cataclysm.init;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.blocks.*;
import com.github.l_ender.cataclysm.blocks.FacingBlock;
import com.github.l_ender.cataclysm.items.BlockItemCMRender;
import com.github.l_ender.cataclysm.items.CMBlockItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Rarity;

import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final Block WITHERITE_BLOCK = registerBlock("witherite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.BLACK)
                    .strength(50f, 1200f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERITE)));

    public static final Block ENDERRITE_BLOCK = registerBlock("enderite_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.BLACK)
                    .strength(50f, 1200f)
                    .sounds(BlockSoundGroup.NETHERITE)));

    public static final Block IGNITIUM_BLOCK = registerBlock("ignitium_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.BLACK)
                    .strength(50f, 1200f)
                    .sounds(BlockSoundGroup.NETHERITE).luminance((state) -> 15)));

    public static final Block ANCIENT_METAL_BLOCK = registerBlock("ancient_metal_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.YELLOW)
                    .strength(25f, 600f)
                    .sounds(BlockSoundGroup.METAL)));

    public static final Block CURSIUM_BLOCK = registerBlock("cursium_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.LIME)
                    .strength(50f, 1200f)
                    .sounds(BlockSoundGroup.METAL)));

    public static final Block POLISHED_END_STONE = registerBlock("polished_end_stone",
            new Block(FabricBlockSettings.copyOf(Blocks.END_STONE)));


    public static final Block POLISHED_END_STONE_SLAB = registerBlock("polished_end_stone_slab",
            new SlabBlock(FabricBlockSettings.copyOf(POLISHED_END_STONE)));

    public static final Block POLISHED_END_STONE_STAIRS = registerBlock("polished_end_stone_stairs",
            new StairsBlock(POLISHED_END_STONE.getDefaultState(), FabricBlockSettings.copyOf(POLISHED_END_STONE)));


    public static final Block CHISELED_END_STONE_BRICKS = registerBlock("chiseled_end_stone_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.END_STONE_BRICKS)));

    public static final Block VOID_INFUSED_END_STONE_BRICKS = registerBlock("void_infused_end_stone_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.END_STONE_BRICKS)
                    .luminance((state) -> 7)));

    public static final Block VOID_STONE = registerBlock("void_stone",
            new Block(FabricBlockSettings.create().mapColor(MapColor.PURPLE)
                    .requiresTool()
                    .strength(50f, 1200f)
                    .luminance((state) -> 7)));

    public static final Block VOID_CRYSTAL = registerBlock("void_crystal",
            new Block(FabricBlockSettings.create().mapColor(MapColor.PURPLE)
                    .sounds(BlockSoundGroup.GLASS)
                    .requiresTool()
                    .strength(50f, 1200f)
                    .luminance((state) -> 7)));

    public static final Block VOID_LANTERN_BLOCK = registerBlock("void_lantern_block" ,
            new Block(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE)
            .sounds(BlockSoundGroup.GLASS)
            .requiresTool()
            .strength(50f, 1200f)
            .luminance((state) -> 15)));

    public static final Block END_STONE_PILLAR = registerBlock("end_stone_pillar",
            new PillarBlock(FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW)
                    .requiresTool()
                    .strength(3f, 9f)));


    public static final Block CHISELED_PURPUR_BLOCK = registerBlock("chiseled_purpur_block",
            new Block(FabricBlockSettings.copyOf(Blocks.PURPUR_BLOCK)));

    public static final Block OBSIDIAN_BRICKS = registerBlock("obsidian_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)));

    public static final Block POLISHED_OBSIDIAN = registerBlock("polished_obsidian",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)));

    public static final Block CHISELED_OBSIDIAN_BRICKS = registerBlock("chiseled_obsidian_bricks",
            new Block(FabricBlockSettings.copyOf(OBSIDIAN_BRICKS)));

    public static final Block OBSIDIAN_BRICK_SLAB = registerBlock("obsidian_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(OBSIDIAN_BRICKS)));

    public static final Block OBSIDIAN_BRICK_STAIRS = registerBlock("obsidian_brick_stairs",
            new StairsBlock(OBSIDIAN_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(OBSIDIAN_BRICKS)));

    public static final Block OBSIDIAN_BRICK_WALL = registerBlock("obsidian_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(OBSIDIAN_BRICKS)));

    public static final Block PURPUR_WALL = registerBlock("purpur_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.PURPUR_BLOCK)));

    public static final Block PURPUR_VOID_RUNE_TRAP_BLOCK = registerBlock("purpur_void_rune_trap_block",
            new PurpurVoidRuneTrapBlock(FabricBlockSettings.copyOf(Blocks.PURPUR_BLOCK).ticksRandomly().luminance(getLightValueLit(7))));

    public static final Block END_STONE_TELEPORT_TRAP_BRICKS = registerBlock("end_stone_teleport_trap_bricks",
            new EndStoneTeleportTrapBricks(FabricBlockSettings.copyOf(Blocks.END_STONE_BRICKS).ticksRandomly().luminance(getLightValueLit(7))));

    public static final Block OBSIDIAN_EXPLOSION_TRAP_BRICKS = registerBlock("obsidian_explosion_trap_bricks",
            new ObsidianExplosionTrapBricks(FabricBlockSettings.copyOf(OBSIDIAN_BRICKS).ticksRandomly().luminance(getLightValueLit(7))));

    public static final Block SANDSTONE_POISON_DART_TRAP = registerBlock("sandstone_poison_dart_trap",
            new Sandstone_Poison_Dart_Trap((FabricBlockSettings.create()
                    .mapColor(MapColor.PALE_YELLOW)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool().strength(0.8F))));

    public static final Block SANDSTONE_IGNITE_TRAP = registerBlock("sandstone_ignite_trap",
            new Sandstone_Ignite_Trap(FabricBlockSettings.create()
                    .mapColor(MapColor.PALE_YELLOW)
                    .ticksRandomly()
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(0.8F)));

    public static final Block SANDSTONE_FALLING_TRAP = registerBlock("sandstone_falling_trap",
            new Sandstone_Falling_Trap(FabricBlockSettings.create()
                    .mapColor(MapColor.PALE_YELLOW)
                    .ticksRandomly()
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(0.8F)));

    public static final Block ALTAR_OF_FIRE = registerBlockAndItem("altar_of_fire",
            new Altar_Of_Fire_Block(), new Item.Settings().rarity(Rarity.EPIC).fireproof(), true);

    public static final Block ALTAR_OF_VOID = registerBlockAndItem("altar_of_void",
            new Altar_Of_Void_Block(), new Item.Settings().rarity(Rarity.EPIC).fireproof(), true);

    public static final Block ALTAR_OF_AMETHYST = registerBlockAndItem("altar_of_amethyst",
            new Altar_Of_Amethyst_Block(), new Item.Settings().rarity(Rarity.EPIC).fireproof(), true);

    public static final Block ALTAR_OF_ABYSS = registerBlockAndItem("altar_of_abyss",
            new Altar_Of_Abyss_Block(), new Item.Settings().rarity(Rarity.EPIC).fireproof(), true);

    public static final Block CURSED_TOMBSTONE = registerBlockAndItem("cursed_tombstone",
            new Cursed_Tombstone_Block(), new Item.Settings().rarity(Rarity.EPIC).fireproof(), true);

    public static final Block DUNGEON_BLOCK = registerBlock("dungeon_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).strength(-1.0F, 3600000.0F).dropsNothing()));

    public static final Block EMP = registerBlockAndItem("emp",
            new EMP_Block(), new Item.Settings().rarity(Rarity.EPIC), true);

    public static final Block MECHANICAL_FUSION_ANVIL = registerBlockAndItem("mechanical_fusion_anvil",
            new Mechanical_fusion_Anvil(), new Item.Settings().rarity(Rarity.EPIC).fireproof(), true);

    public static final Block DOOR_OF_SEAL = registerBlockAndItem("door_of_seal",
            new Door_of_Seal_Block(), new Item.Settings().rarity(Rarity.EPIC), true);

    public static final Block DOOR_OF_SEAL_PART = registerBlock("door_of_seal_part", 
            new Door_of_Seal_Block.Door_Of_Seal_Part_Block(FabricBlockSettings.copyOf(ModBlocks.DOOR_OF_SEAL)));

    public static final Block KOBOLEDIATOR_SKULL = registerBlock("kobolediator_skull", new Cataclysm_Skull_Block(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, FabricBlockSettings.create().strength(1.0F).pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block KOBOLEDIATOR_WALL_SKULL = registerBlock("kobolediator_wall_skull", new Wall_Cataclysm_Skull_Block(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, FabricBlockSettings.create().strength(1.0F).dropsLike(KOBOLEDIATOR_SKULL).pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block APTRGANGR_HEAD = registerBlock("aptrgangr_head", new Cataclysm_Skull_Block(Cataclysm_Skull_Block.Types.APTRGANGR, FabricBlockSettings.create().strength(1.0F).pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block APTRGANGR_WALL_HEAD = registerBlock("aptrgangr_wall_head", new Wall_Cataclysm_Skull_Block(Cataclysm_Skull_Block.Types.APTRGANGR, FabricBlockSettings.create().strength(1.0F).dropsLike(APTRGANGR_HEAD).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block DRAUGR_HEAD = registerBlock("draugr_head", new Cataclysm_Skull_Block(Cataclysm_Skull_Block.Types.DRAUGR, FabricBlockSettings.create().strength(1.0F).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block DRAUGR_WALL_HEAD = registerBlock("draugr_wall_head", new Wall_Cataclysm_Skull_Block(Cataclysm_Skull_Block.Types.DRAUGR, FabricBlockSettings.create().strength(1.0F).dropsLike(APTRGANGR_HEAD).pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block ABYSSAL_EGG = registerBlockAndItem("abyssal_egg",
            new Abyssal_Egg_Block(), new Item.Settings().rarity(Rarity.EPIC).fireproof(), true);

    public static final Block CHORUS_STEM = registerBlock("chorus_stem",
            new PillarBlock(FabricBlockSettings.create().mapColor(MapColor.PURPLE)
                    .strength(2.0F, 3.0F)
                    .instrument(Instrument.BASS)
                    .sounds(BlockSoundGroup.WOOD)));


    public static final Block CHORUS_PLANKS = registerBlock("chorus_planks",
            new Block(FabricBlockSettings.create().mapColor(MapColor.PURPLE)
                    .strength(2.0F, 3.0F)
                    .instrument(Instrument.BASS)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block CHORUS_SLAB = registerBlock("chorus_slab",
            new SlabBlock(FabricBlockSettings.copyOf(CHORUS_PLANKS)));

    public static final Block CHORUS_STAIRS = registerBlock("chorus_stairs",
            new StairsBlock(CHORUS_PLANKS.getDefaultState(),FabricBlockSettings.copyOf(CHORUS_PLANKS)));
    
    public static final Block CHORUS_FENCE = registerBlock("chorus_fence",
            new FenceBlock(FabricBlockSettings.copyOf(CHORUS_PLANKS)));

    public static final Block PRISMARINE_BRICK_FENCE = registerBlock("prismarine_brick_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_BRICKS)));

    public static final Block QUARTZ_BRICK_WALL = registerBlock("quartz_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.QUARTZ_BRICKS)));

    public static final Block PRISMARINE_BRICK_WALL = registerBlock("prismarine_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.PRISMARINE_BRICKS)));

    public static final Block STONE_PILLAR = registerBlock("stone_pillar",
            new PillarBlock(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY)
                    .requiresTool()
                    .strength(1.5F, 6.0F)));

    public static final Block CHISELED_STONE_BRICK_PILLAR = registerBlock("chiseled_stone_brick_pillar",
            new PillarBlock(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY)
                    .requiresTool()
                    .strength(1.5F, 6.0F)));

    public static final Block STONE_TILES = registerBlock("stone_tiles",
            new Block(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY)
                    .requiresTool()
                    .strength(1.5F, 6.0F)));

    public static final Block FROSTED_STONE_BRICKS = registerBlock("frosted_stone_bricks",
            new Block(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY)
                    .requiresTool()
                    .strength(1.5F, 6.0F)));

    public static final Block FROSTED_STONE_BRICK_SLAB = registerBlock("frosted_stone_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(FROSTED_STONE_BRICKS)));

    public static final Block FROSTED_STONE_BRICK_STAIRS = registerBlock("frosted_stone_brick_stairs",
            new StairsBlock(FROSTED_STONE_BRICKS.getDefaultState(),FabricBlockSettings.copyOf(FROSTED_STONE_BRICKS)));

    public static final Block FROSTED_STONE_BRICK_WALL = registerBlock("frosted_stone_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(FROSTED_STONE_BRICKS)));

    public static final Block BLACK_STEEL_BLOCK = registerBlock("black_steel_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.BLACK)
                    .strength(25f, 600f)
                    .sounds(BlockSoundGroup.METAL)));

    public static final Block BLACK_STEEL_FENCE = registerBlock("black_steel_fence",
            new FenceBlock(FabricBlockSettings.copyOf(BLACK_STEEL_BLOCK)));

    public static final Block BLACK_STEEL_WALL = registerBlock("black_steel_wall",
            new WallBlock(FabricBlockSettings.copyOf(BLACK_STEEL_BLOCK)));

    public static final Block STONE_TILE_SLAB = registerBlock("stone_tile_slab",
            new SlabBlock(FabricBlockSettings.copyOf(STONE_TILES)));

    public static final Block STONE_TILE_STAIRS = registerBlock("stone_tile_stairs",
            new StairsBlock(STONE_TILES.getDefaultState(),FabricBlockSettings.copyOf(STONE_TILES)));

    public static final Block STONE_TILE_WALL = registerBlock("stone_tile_wall",
            new WallBlock(FabricBlockSettings.copyOf(STONE_TILES)));

    public static final Block POLISHED_SANDSTONE = registerBlock("polished_sandstone",
            new Block(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));

    public static final Block BLACKSTONE_PILLAR = registerBlock("blackstone_pillar",
            new PillarBlock(FabricBlockSettings.create().mapColor(MapColor.BLACK)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(1.5F, 6.0F)));

    public static final Block AZURE_SEASTONE = registerBlock("azure_seastone",
            new Block(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)));

    public static final Block AZURE_SEASTONE_SLAB = registerBlock("azure_seastone_slab",
            new SlabBlock(FabricBlockSettings.copyOf(AZURE_SEASTONE)));

    public static final Block AZURE_SEASTONE_STAIRS = registerBlock("azure_seastone_stairs",
            new StairsBlock(AZURE_SEASTONE.getDefaultState(),FabricBlockSettings.copyOf(AZURE_SEASTONE)));

    public static final Block AZURE_SEASTONE_WALL = registerBlock("azure_seastone_wall",
            new WallBlock(FabricBlockSettings.copyOf(AZURE_SEASTONE)));

    public static final Block AZURE_SEASTONE_FENCE = registerBlock("azure_seastone_fence",
            new FenceBlock(FabricBlockSettings.copyOf(AZURE_SEASTONE)));

    public static final Block AZURE_SEASTONE_TILES = registerBlock("azure_seastone_tiles",
            new FacingBlock(FabricBlockSettings.copyOf(AZURE_SEASTONE)));

    public static final Block CHISELED_AZURE_SEASTONE = registerBlock("chiseled_azure_seastone",
            new FacingBlock(FabricBlockSettings.copyOf(AZURE_SEASTONE)));

    public static final Block AZURE_SEASTONE_BRICKS = registerBlock("azure_seastone_bricks",
            new Block(FabricBlockSettings.copyOf(AZURE_SEASTONE)));

    public static final Block AZURE_SEASTONE_BRICK_SLAB = registerBlock("azure_seastone_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(AZURE_SEASTONE_BRICKS)));

    public static final Block AZURE_SEASTONE_BRICK_STAIRS = registerBlock("azure_seastone_brick_stairs",
            new StairsBlock(AZURE_SEASTONE_BRICKS.getDefaultState(),FabricBlockSettings.copyOf(AZURE_SEASTONE_BRICKS)));

    public static final Block AZURE_SEASTONE_BRICK_WALL = registerBlock("azure_seastone_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(AZURE_SEASTONE_BRICKS)));

    public static final Block POLISHED_AZURE_SEASTONE = registerBlock("polished_azure_seastone",
            new Block(FabricBlockSettings.copyOf(AZURE_SEASTONE)));

    public static final Block POLISHED_AZURE_SEASTONE_SLAB = registerBlock("polished_azure_seastone_slab",
            new SlabBlock(FabricBlockSettings.copyOf(POLISHED_AZURE_SEASTONE)));

    public static final Block POLISHED_AZURE_SEASTONE_STAIRS = registerBlock("polished_azure_seastone_stairs",
            new StairsBlock(POLISHED_AZURE_SEASTONE.getDefaultState(),FabricBlockSettings.copyOf(POLISHED_AZURE_SEASTONE)));

    public static final Block POLISHED_AZURE_SEASTONE_WALL = registerBlock("polished_azure_seastone_wall",
            new WallBlock(FabricBlockSettings.copyOf(AZURE_SEASTONE)));

    public static final Block AZURE_SEASTONE_PILLAR = registerBlock("azure_seastone_pillar",
            new PillarBlock(FabricBlockSettings.copyOf(AZURE_SEASTONE)));

    public static final Block AZURE_SEASTONE_PILLAR_WALL = registerBlock("azure_seastone_pillar_wall",
            new WallBlock(FabricBlockSettings.copyOf(AZURE_SEASTONE)));

    public static final Block CHISELED_AZURE_SEASTONE_PILLAR = registerBlock("chiseled_azure_seastone_pillar",
            new FacingPillarBlock(FabricBlockSettings.copyOf(AZURE_SEASTONE)));

    public static final Block CHISELED_AZURE_SEASTONE_PILLAR_WALL = registerBlock("chiseled_azure_seastone_pillar_wall",
            new WallBlock(FabricBlockSettings.copyOf(AZURE_SEASTONE)));

    public static final Block POINTED_ICICLE = registerBlock("pointed_icicle",
            new PointedIcicleBlock(FabricBlockSettings.create()
                    .mapColor(MapColor.PALE_PURPLE)
                    .solid()
                    .instrument(Instrument.CHIME)
                    .nonOpaque()
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GLASS)
                    .strength(0.5F)
                    .dynamicBounds()
                    .offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> state.get(Properties.LIT) ? lightValue : 0;
    }

    public static final Block MELTING_NETHERRACK = registerBlock("melting_netherrack" ,
            new MeltingNetherrack(FabricBlockSettings.create().mapColor(MapColor.DARK_RED).ticksRandomly()
                    .luminance((state) -> 3)));

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, Cataclysm.modIdentifier(name), block);
    }

    private static Block registerBlockAndItem(String name, Block block, Item.Settings blockItemProps, boolean specialRender) {
        Block block1 = registerBlock(name, block);
        Registry.register(Registries.ITEM, Cataclysm.modIdentifier(name), specialRender ?  new BlockItemCMRender(block1, blockItemProps) :  new CMBlockItem(block1, blockItemProps));
        return block1;
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering blocks for " + Cataclysm.MOD_ID);
    }
}
