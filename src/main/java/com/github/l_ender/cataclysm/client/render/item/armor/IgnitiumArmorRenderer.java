package com.github.l_ender.cataclysm.client.render.item.armor;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.armor.Ignitium_Armor_Model;
import com.github.l_ender.cataclysm.client.render.item.CustomArmorRenderProperties;
import net.minecraft.util.Identifier;

public class IgnitiumArmorRenderer extends ModArmorRenderer<Ignitium_Armor_Model> {
    public static final IgnitiumArmorRenderer INSTANCE = new IgnitiumArmorRenderer();

    private final static Identifier TEXTURE = Cataclysm.modIdentifier("textures/armor/ignitium_armor.png");

    @Override
    public Ignitium_Armor_Model getArmorModel() {
        return CustomArmorRenderProperties.IGNITIUM_ARMOR_MODEL;
    }

    @Override
    public Identifier getTexture() {
        return TEXTURE;
    }
}
