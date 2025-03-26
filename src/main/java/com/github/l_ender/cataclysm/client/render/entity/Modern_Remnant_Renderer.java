package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Modern_Remnant_Model;
import com.github.l_ender.cataclysm.entity.Pet.Modern_Remnant_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Modern_Remnant_Renderer extends MobEntityRenderer<Modern_Remnant_Entity, Modern_Remnant_Model> {

    private static final Identifier MODERN_REMNANT_TEXTURES = Cataclysm.modIdentifier("textures/entity/ancient_remnant/modern_remnant.png");

    public Modern_Remnant_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Modern_Remnant_Model(), 0.25F);
    }
    @Override
    public Identifier getTexture(Modern_Remnant_Entity entity) {
        return MODERN_REMNANT_TEXTURES;
    }

    @Override
    protected void scale(Modern_Remnant_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1F, 1F, 1F);
    }

}

