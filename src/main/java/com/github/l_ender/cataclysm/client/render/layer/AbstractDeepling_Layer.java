package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.entity.Deepling.AbstractDeepling;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class AbstractDeepling_Layer<T extends AbstractDeepling> extends FeatureRenderer<T, EntityModel<T>> {
    private final Identifier texture;
    private final RenderLayer renderType;

    public AbstractDeepling_Layer(FeatureRendererContext<T, EntityModel<T>> renderer, Identifier texture) {
        super(renderer);
        this.texture = texture;
        this.renderType = CMRenderTypes.CMEyes(texture);
    }


    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        VertexConsumer VertexConsumer = bufferIn.getBuffer(renderType);

        float strength = 0.5F + MathHelper.clamp(((float) Math.cos((entitylivingbaseIn.LayerTicks + partialTicks) * 0.1F)) - 0.5F, -0.5F, 0.5F);

        strength += MathHelper.lerp(partialTicks, entitylivingbaseIn.oLayerBrightness, entitylivingbaseIn.LayerBrightness) * 1 * MathHelper.PI;
        strength = MathHelper.clamp(strength, 0.1f, 1);

        this.getContextModel().render(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.DEFAULT_UV, strength, strength, strength, 1.0F);

    }

}
