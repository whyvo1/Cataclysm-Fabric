package com.github.l_ender.cataclysm.client.render.item.armor;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.armor.Bone_Reptile_Armor_Model;
import com.github.l_ender.cataclysm.client.render.item.CustomArmorRenderProperties;
import net.minecraft.util.Identifier;

public class BoneReptileArmorRenderer extends ModArmorRenderer<Bone_Reptile_Armor_Model> {
    public static final BoneReptileArmorRenderer INSTANCE = new BoneReptileArmorRenderer();

    private final static Identifier TEXTURE = Cataclysm.modIdentifier("textures/armor/bone_reptile_armor.png");

    @Override
    public Bone_Reptile_Armor_Model getArmorModel() {
        return CustomArmorRenderProperties.BONE_REPTILE_ARMOR_MODEL;
    }

    @Override
    public Identifier getTexture() {
        return TEXTURE;
    }
}
