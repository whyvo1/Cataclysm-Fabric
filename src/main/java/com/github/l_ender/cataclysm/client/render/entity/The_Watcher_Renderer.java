package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.The_Watcher_Model;
import com.github.l_ender.cataclysm.client.render.layer.LayerGenericGlowing;
import com.github.l_ender.cataclysm.entity.AnimationMonster.The_Watcher_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class The_Watcher_Renderer extends MobEntityRenderer<The_Watcher_Entity, The_Watcher_Model> {

    private static final Identifier WATCHER_TEXTURES = Cataclysm.modIdentifier("textures/entity/factory/the_watcher.png");
    private static final Identifier WATCHER_LAYER_TEXTURES = Cataclysm.modIdentifier("textures/entity/factory/the_watcher_layer.png");

    public The_Watcher_Renderer(Context renderManagerIn) {
        super(renderManagerIn, new The_Watcher_Model(), 0.7F);
        this.addFeature(new LayerGenericGlowing(this, WATCHER_LAYER_TEXTURES));

    }
    @Override
    public Identifier getTexture(The_Watcher_Entity entity) {
        return WATCHER_TEXTURES;
    }

    @Override
    protected void scale(The_Watcher_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }
}