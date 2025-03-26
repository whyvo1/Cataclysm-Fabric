package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Deepling_Model;
import com.github.l_ender.cataclysm.client.render.layer.AbstractDeepling_Layer;
import com.github.l_ender.cataclysm.client.render.layer.LayerDeeplingItem;
import com.github.l_ender.cataclysm.entity.Deepling.Deepling_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Deepling_Renderer extends MobEntityRenderer<Deepling_Entity, Deepling_Model> {

    private static final Identifier SSAPBUG_TEXTURES = Cataclysm.modIdentifier("textures/entity/deepling/deepling_1.png");
    private static final Identifier DEEPLING_LAYER_TEXTURES  = Cataclysm.modIdentifier("textures/entity/deepling/deepling_layer.png");
    public Deepling_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Deepling_Model(), 0.7F);
        this.addFeature(new AbstractDeepling_Layer(this,DEEPLING_LAYER_TEXTURES));
        this.addFeature(new LayerDeeplingItem(this, renderManagerIn.getHeldItemRenderer()));

    }
    @Override
    public Identifier getTexture(Deepling_Entity entity) {
        return SSAPBUG_TEXTURES;
    }

    @Override
    protected void scale(Deepling_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }


}