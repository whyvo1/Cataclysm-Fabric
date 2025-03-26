package com.github.l_ender.cataclysm.client.render.item.armor;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.armor.Cursium_Armor_Model;
import com.github.l_ender.cataclysm.client.render.item.CustomArmorRenderProperties;
import net.minecraft.util.Identifier;

public class CursiumArmorLegsRenderer extends ModArmorRenderer<Cursium_Armor_Model> {
    public static final CursiumArmorLegsRenderer INSTANCE = new CursiumArmorLegsRenderer();

    private final static Identifier TEXTURE = Cataclysm.modIdentifier("textures/armor/cursium_armor_legs.png");

    @Override
    public Cursium_Armor_Model getArmorModel() {
        return CustomArmorRenderProperties.CURSIUM_ARMOR_MODEL;
    }

    @Override
    public Identifier getTexture() {
        return TEXTURE;
    }
}
