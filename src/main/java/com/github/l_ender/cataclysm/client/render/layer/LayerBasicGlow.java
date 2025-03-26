package com.github.l_ender.cataclysm.client.render.layer;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

public class LayerBasicGlow<T extends LivingEntity> extends FeatureRenderer<T, EntityModel<T>> {
    private final Identifier texture;
    private final RenderLayer renderType;

    public LayerBasicGlow(FeatureRendererContext<T, EntityModel<T>> renderer, Identifier texture) {
        super(renderer);
        this.texture = texture;
        this.renderType = RenderLayer.getEyes(texture);
    }

    public boolean shouldCombineTextures() {
        return true;
    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(renderType);
        this.getContextModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

    }

}
