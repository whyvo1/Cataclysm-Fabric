package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Koboleton_Model;
import com.github.l_ender.cataclysm.client.render.layer.LayerGenericGlowing;
import com.github.l_ender.cataclysm.client.render.layer.LayerKoboletonItem;
import com.github.l_ender.cataclysm.entity.AnimationMonster.Koboleton_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Koboleton_Renderer extends MobEntityRenderer<Koboleton_Entity, Koboleton_Model> {

    private static final Identifier KOBOLETON_TEXTURES = Cataclysm.modIdentifier("textures/entity/koboleton/koboleton.png");
    private static final Identifier KOBOLETON_LAYER_TEXTURES = Cataclysm.modIdentifier("textures/entity/koboleton/koboleton_layer.png");

    public Koboleton_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Koboleton_Model(), 0.5F);
        this.addFeature(new LayerKoboletonItem(this, renderManagerIn.getHeldItemRenderer()));
        this.addFeature(new LayerGenericGlowing(this, KOBOLETON_LAYER_TEXTURES));

    }
    @Override
    public Identifier getTexture(Koboleton_Entity entity) {
        return KOBOLETON_TEXTURES;
    }

    @Override
    protected void scale(Koboleton_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }
}

