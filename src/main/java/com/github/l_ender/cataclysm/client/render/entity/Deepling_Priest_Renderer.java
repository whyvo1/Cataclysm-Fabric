package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Deepling_Priest_Model;
import com.github.l_ender.cataclysm.client.render.layer.AbstractDeepling_Layer;
import com.github.l_ender.cataclysm.client.render.layer.LayerDeepling_PriestItem;
import com.github.l_ender.cataclysm.client.render.layer.LayerDeepling_Priest_Light;
import com.github.l_ender.cataclysm.entity.Deepling.Deepling_Priest_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Deepling_Priest_Renderer extends MobEntityRenderer<Deepling_Priest_Entity, Deepling_Priest_Model> {

    private static final Identifier DEEPLING_TEXTURES = Cataclysm.modIdentifier("textures/entity/deepling/deepling_priest.png");
    private static final Identifier DEEPLING_LAYER_TEXTURES  = Cataclysm.modIdentifier("textures/entity/deepling/deepling_priest_layer.png");

    public Deepling_Priest_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Deepling_Priest_Model(), 0.7F);
        this.addFeature(new AbstractDeepling_Layer(this,DEEPLING_LAYER_TEXTURES));
        this.addFeature(new LayerDeepling_PriestItem(this, renderManagerIn.getHeldItemRenderer()));
        this.addFeature(new LayerDeepling_Priest_Light(this));

    }
    @Override
    public Identifier getTexture(Deepling_Priest_Entity entity) {
        return DEEPLING_TEXTURES;
    }

    @Override
    protected void scale(Deepling_Priest_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }

}