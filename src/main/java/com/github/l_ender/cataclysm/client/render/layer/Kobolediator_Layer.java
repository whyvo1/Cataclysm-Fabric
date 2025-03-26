package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.client.model.entity.Kobolediator_Model;
import com.github.l_ender.cataclysm.client.render.entity.Kobolediator_Renderer;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Kobolediator_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Kobolediator_Layer extends FeatureRenderer<Kobolediator_Entity, Kobolediator_Model> {
    private static final Identifier LAYER_TEXTURES = new Identifier("cataclysm:textures/entity/koboleton/kobolediator_layer.png");

    public Kobolediator_Layer(Kobolediator_Renderer renderIn) {
        super(renderIn);

    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Kobolediator_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.getAttackState() != 1 && entity.isAlive()) {
            RenderLayer eyes = RenderLayer.getEyes(LAYER_TEXTURES);
            VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
            this.getContextModel().render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}


