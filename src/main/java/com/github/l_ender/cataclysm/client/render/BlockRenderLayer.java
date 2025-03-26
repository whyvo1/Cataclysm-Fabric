package com.github.l_ender.cataclysm.client.render;

import com.github.l_ender.cataclysm.init.ModBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class BlockRenderLayer {
    public static void putAllLayers() {
        BlockRenderLayerMap map = BlockRenderLayerMap.INSTANCE;
        RenderLayer cutout = RenderLayer.getCutout();
        RenderLayer translucent = RenderLayer.getTranslucent();
        map.putBlock(ModBlocks.ABYSSAL_EGG, translucent);
        map.putBlock(ModBlocks.ALTAR_OF_ABYSS, translucent);
        map.putBlock(ModBlocks.ALTAR_OF_AMETHYST, translucent);
        map.putBlock(ModBlocks.ALTAR_OF_FIRE, translucent);
        map.putBlock(ModBlocks.ALTAR_OF_VOID, translucent);
        map.putBlock(ModBlocks.CURSED_TOMBSTONE, translucent);
        map.putBlock(ModBlocks.DOOR_OF_SEAL, translucent);
        map.putBlock(ModBlocks.DOOR_OF_SEAL_PART, translucent);
        map.putBlock(ModBlocks.EMP, translucent);
        map.putBlock(ModBlocks.MECHANICAL_FUSION_ANVIL, translucent);
        map.putBlock(ModBlocks.POINTED_ICICLE, cutout);
    }
}
