package com.github.l_ender.cataclysm.client.render.item;


import com.github.l_ender.cataclysm.client.render.CMItemstackRenderer;
import com.github.l_ender.cataclysm.init.ModBlocks;
import com.github.l_ender.cataclysm.init.ModItems;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.item.ItemConvertible;

public class CMItemRenderProperties {
    public static void registerItemRenderers() {
        registerDefault(ModItems.BULWARK_OF_THE_FLAME);
        registerDefault(ModItems.BLACK_STEEL_TARGE);
        registerDefault(ModItems.GAUNTLET_OF_GUARD);
        registerDefault(ModItems.GAUNTLET_OF_BULWARK);
        registerDefault(ModItems.GAUNTLET_OF_MAELSTROM);
        registerDefault(ModItems.THE_INCINERATOR);
        registerDefault(ModItems.WITHER_ASSULT_SHOULDER_WEAPON);
        registerDefault(ModItems.VOID_ASSULT_SHOULDER_WEAPON);
        registerDefault(ModItems.CORAL_SPEAR);
        registerDefault(ModItems.CORAL_BARDICHE);
        registerDefault(ModItems.VOID_FORGE);
        registerDefault(ModItems.TIDAL_CLAWS);
        registerDefault(ModItems.MEAT_SHREDDER);
        registerDefault(ModItems.LASER_GATLING);
        registerDefault(ModItems.ANCIENT_SPEAR);
        registerDefault(ModItems.CURSED_BOW);
        registerDefault(ModItems.WRATH_OF_THE_DESERT);
        registerDefault(ModItems.SOUL_RENDER);
        registerDefault(ModItems.THE_ANNIHILATOR);
        registerDefault(ModItems.THE_IMMOLATOR);
        registerDefault(ModBlocks.ALTAR_OF_FIRE);
        registerDefault(ModBlocks.ALTAR_OF_VOID);
        registerDefault(ModBlocks.ALTAR_OF_AMETHYST);
        registerDefault(ModBlocks.ALTAR_OF_ABYSS);
        registerDefault(ModBlocks.EMP);
        registerDefault(ModBlocks.MECHANICAL_FUSION_ANVIL);
        registerDefault(ModBlocks.ABYSSAL_EGG);
    }

    private static void registerDefault(ItemConvertible item) {
        BuiltinItemRendererRegistry.INSTANCE.register(item, new CMItemstackRenderer());
    }

}
