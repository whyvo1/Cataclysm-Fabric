package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.model.entity.Kobolediator_Model;
import com.github.l_ender.cataclysm.client.render.layer.Kobolediator_Layer;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Kobolediator_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Kobolediator_Renderer extends MobEntityRenderer<Kobolediator_Entity, Kobolediator_Model> {
    private static final Identifier KOBOLEDIATOR_TEXTURES = Cataclysm.modIdentifier("textures/entity/koboleton/kobolediator.png");

    public Kobolediator_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Kobolediator_Model(renderManagerIn.getPart(CMModelLayers.KOBOLEDIATOR_MODEL)), 1.25F);
        this.addFeature(new Kobolediator_Layer(this));

    }
    @Override
    public Identifier getTexture(Kobolediator_Entity entity) {
        return KOBOLEDIATOR_TEXTURES;
    }

    @Override
    protected float getLyingAngle(Kobolediator_Entity entity) {
        return 0;
    }

    @Override
    protected void scale(Kobolediator_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }
}

