package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Wadjet_Model;
import com.github.l_ender.cataclysm.client.render.layer.Wadjet_Layer;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Wadjet_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Wadjet_Renderer extends MobEntityRenderer<Wadjet_Entity, Wadjet_Model> {

    private static final Identifier KOBOLEDIATOR_TEXTURES = Cataclysm.modIdentifier("textures/entity/koboleton/wadjet.png");

    public Wadjet_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Wadjet_Model(), 0.75F);
        this.addFeature(new Wadjet_Layer(this));
    }
    @Override
    public Identifier getTexture(Wadjet_Entity entity) {
        return KOBOLEDIATOR_TEXTURES;
    }

    @Override
    protected float getLyingAngle(Wadjet_Entity entity) {
        return 0;
    }

    @Override
    protected void scale(Wadjet_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }
}

