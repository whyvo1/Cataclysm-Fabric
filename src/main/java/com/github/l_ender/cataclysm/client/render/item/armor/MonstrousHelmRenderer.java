package com.github.l_ender.cataclysm.client.render.item.armor;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.armor.MonstrousHelm_Model;
import com.github.l_ender.cataclysm.client.render.item.CustomArmorRenderProperties;
import net.minecraft.util.Identifier;

public class MonstrousHelmRenderer extends ModArmorRenderer<MonstrousHelm_Model> {
    public static final MonstrousHelmRenderer INSTANCE = new MonstrousHelmRenderer();

    private final static Identifier TEXTURE = Cataclysm.modIdentifier("textures/armor/monstrous_helm.png");

    @Override
    public MonstrousHelm_Model getArmorModel() {
        return CustomArmorRenderProperties.MONSTROUS_HELM_MODEL;
    }

    @Override
    public Identifier getTexture() {
        return TEXTURE;
    }
}
