package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Deepling_Warlock_Model;
import com.github.l_ender.cataclysm.client.render.layer.AbstractDeepling_Layer;
import com.github.l_ender.cataclysm.client.render.layer.LayerDeepling_WarlockItem;
import com.github.l_ender.cataclysm.entity.Deepling.Deepling_Warlock_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Deepling_Warlock_Renderer extends MobEntityRenderer<Deepling_Warlock_Entity, Deepling_Warlock_Model> {

    private static final Identifier DEEPLING_TEXTURES = Cataclysm.modIdentifier("textures/entity/deepling/deepling_warlock.png");
    private static final Identifier DEEPLING_LAYER_TEXTURES  = Cataclysm.modIdentifier("textures/entity/deepling/deepling_warlock_layer.png");

    public Deepling_Warlock_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Deepling_Warlock_Model(), 0.7F);
        this.addFeature(new AbstractDeepling_Layer(this,DEEPLING_LAYER_TEXTURES));
        this.addFeature(new LayerDeepling_WarlockItem(this, renderManagerIn.getHeldItemRenderer()));

    }
    @Override
    public Identifier getTexture(Deepling_Warlock_Entity entity) {
        return DEEPLING_TEXTURES;
    }

    @Override
    protected void scale(Deepling_Warlock_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }

}