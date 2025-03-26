package com.github.l_ender.cataclysm.client.model.block;

import net.minecraft.client.model.Model;
import net.minecraft.client.render.RenderLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public abstract class Cataclysm_Skull_Model_Base extends Model {


    public Cataclysm_Skull_Model_Base() {
        super(RenderLayer::getEntityTranslucent);
    }

    public abstract void setAngles(float p_170950_, float p_170951_, float p_170952_);
}
