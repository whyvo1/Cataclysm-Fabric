package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Lionfish_Model;
import com.github.l_ender.cataclysm.client.render.layer.LionFish_Layer;
import com.github.l_ender.cataclysm.entity.Deepling.Lionfish_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Lionfish_Renderer extends MobEntityRenderer<Lionfish_Entity, Lionfish_Model> {

    private static final Identifier LIONFISH_TEXTURES = Cataclysm.modIdentifier("textures/entity/deepling/lionfish.png");

    public Lionfish_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Lionfish_Model(), 0.4F);
        this.addFeature(new LionFish_Layer(this));

    }
    @Override
    public Identifier getTexture(Lionfish_Entity entity) {
        return LIONFISH_TEXTURES;
    }

    @Override
    protected void scale(Lionfish_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }


}