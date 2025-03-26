package com.github.l_ender.cataclysm.client.render.item.armor;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.armor.Bloom_Stone_Pauldrons_Model;
import com.github.l_ender.cataclysm.client.render.item.CustomArmorRenderProperties;
import net.minecraft.util.Identifier;

public class BloomStonePauldronsRenderer extends ModArmorRenderer<Bloom_Stone_Pauldrons_Model> {
    public static final BloomStonePauldronsRenderer INSTANCE = new BloomStonePauldronsRenderer();

    private final static Identifier TEXTURE = Cataclysm.modIdentifier("textures/armor/bloom_stone_pauldrons.png");

    @Override
    public Bloom_Stone_Pauldrons_Model getArmorModel() {
        return CustomArmorRenderProperties.BLOOM_STONE_PAULDRONS_MODEL;
    }

    @Override
    public Identifier getTexture() {
        return TEXTURE;
    }
}
