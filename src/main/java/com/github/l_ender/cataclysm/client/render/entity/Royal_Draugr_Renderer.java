package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.model.entity.Royal_Draugr_Model;
import com.github.l_ender.cataclysm.client.render.layer.LayerGenericGlowing;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar.Royal_Draugr_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class Royal_Draugr_Renderer extends MobEntityRenderer<Royal_Draugr_Entity, Royal_Draugr_Model> {
    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/entity/draugar/royal_draugr.png");
    private static final Identifier LAYER = Cataclysm.modIdentifier("textures/entity/draugar/draugr_layer.png");

    public Royal_Draugr_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Royal_Draugr_Model(renderManagerIn.getPart(CMModelLayers.ROYAL_DRAUGR_MODEL)), 0.5F);
        this.addFeature(new LayerGenericGlowing(this, LAYER));
        this.addFeature(new HeldItemFeatureRenderer<>(this, renderManagerIn.getHeldItemRenderer()));
    }

    protected void scale(Royal_Draugr_Entity p_114907_, MatrixStack p_114908_, float p_114909_) {
        float f = 1.0625F;
        p_114908_.scale(f, f, f);
        super.scale(p_114907_, p_114908_, p_114909_);
    }

    public Identifier getTexture(Royal_Draugr_Entity entity) {
        return TEXTURE;
    }

}


