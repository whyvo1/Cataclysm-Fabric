package com.github.l_ender.cataclysm.init;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.blockentities.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;


public class ModTileentites {

    public static final BlockEntityType<ObsidianExplosionTrapBricks_Block_Entity> OBSIDIAN_EXPLOSION_TRAP_BRICKS = registerBlockEntity("obsidian_explosion_trap_bricks",
            BlockEntityType.Builder.create(ObsidianExplosionTrapBricks_Block_Entity::new, ModBlocks.OBSIDIAN_EXPLOSION_TRAP_BRICKS).build(null));

    public static final BlockEntityType<SandstoneIgniteTrap_Block_Entity> SANDSTONE_IGNITE_TRAP = registerBlockEntity("sadsotne_ignite_trap",
            BlockEntityType.Builder.create(SandstoneIgniteTrap_Block_Entity::new, ModBlocks.SANDSTONE_IGNITE_TRAP).build(null));

    public static final BlockEntityType<AltarOfVoid_Block_Entity> ALTAR_OF_VOID = registerBlockEntity("altar_of_void",
            BlockEntityType.Builder.create(AltarOfVoid_Block_Entity::new, ModBlocks.ALTAR_OF_VOID).build(null));

    public static final BlockEntityType<AltarOfFire_Block_Entity> ALTAR_OF_FIRE = registerBlockEntity("altar_of_fire",
            BlockEntityType.Builder.create(AltarOfFire_Block_Entity::new, ModBlocks.ALTAR_OF_FIRE).build(null));

    public static final BlockEntityType<AltarOfAmethyst_Block_Entity> ALTAR_OF_AMETHYST = registerBlockEntity("altar_of_amethyst",
            BlockEntityType.Builder.create(AltarOfAmethyst_Block_Entity::new, ModBlocks.ALTAR_OF_AMETHYST).build(null));

    public static final BlockEntityType<AltarOfAbyss_Block_Entity> ALTAR_OF_ABYSS = registerBlockEntity("altar_of_abyss",
            BlockEntityType.Builder.create(AltarOfAbyss_Block_Entity::new, ModBlocks.ALTAR_OF_ABYSS).build(null));

    public static final BlockEntityType<Cursed_tombstone_Entity> CURSED_TOMBSTONE = registerBlockEntity("cursed_tombstone",
            BlockEntityType.Builder.create(Cursed_tombstone_Entity::new, ModBlocks.CURSED_TOMBSTONE).build(null));

    public static final BlockEntityType<Abyssal_Egg_Block_Entity> ABYSSAL_EGG = registerBlockEntity("abyssal_egg",
            BlockEntityType.Builder.create(Abyssal_Egg_Block_Entity::new, ModBlocks.ABYSSAL_EGG).build(null));

    public static final BlockEntityType<EMP_Block_Entity> EMP = registerBlockEntity("emp",
            BlockEntityType.Builder.create(EMP_Block_Entity::new, ModBlocks.EMP).build(null));

    public static final BlockEntityType<Cataclysm_Skull_BlockEntity> CATACLYSM_SKULL = registerBlockEntity("cataclysm_skull",
            BlockEntityType.Builder.create(Cataclysm_Skull_BlockEntity::new, ModBlocks.KOBOLEDIATOR_SKULL, ModBlocks.KOBOLEDIATOR_WALL_SKULL,ModBlocks.APTRGANGR_HEAD, ModBlocks.APTRGANGR_WALL_HEAD,ModBlocks.DRAUGR_HEAD, ModBlocks.DRAUGR_WALL_HEAD).build(null));

    public static final BlockEntityType<Mechanical_fusion_Anvil_Block_Entity> MECHANICAL_FUSION_ANVIL = registerBlockEntity("mechanical_fusion_anvil",
            BlockEntityType.Builder.create(Mechanical_fusion_Anvil_Block_Entity::new, ModBlocks.MECHANICAL_FUSION_ANVIL).build(null));


    public static final BlockEntityType<Door_Of_Seal_BlockEntity> DOOR_OF_SEAL = registerBlockEntity("door_of_seal",
            BlockEntityType.Builder.create(Door_Of_Seal_BlockEntity::new, ModBlocks.DOOR_OF_SEAL).build(null));

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, BlockEntityType<T> blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Cataclysm.modIdentifier(name), blockEntityType);
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering block entities for " + Cataclysm.MOD_ID);
    }
}
