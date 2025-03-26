package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.client.model.entity.Deepling_Priest_Model;
import com.github.l_ender.cataclysm.entity.Deepling.Deepling_Priest_Entity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.random.Random;
import org.joml.Matrix4f;

public class LayerDeepling_Priest_Light extends FeatureRenderer<Deepling_Priest_Entity, Deepling_Priest_Model> {
    private static final float HALF_SQRT_3 = (float)(Math.sqrt(3.0D) / 2.0D);

    public LayerDeepling_Priest_Light(FeatureRendererContext p_234846_) {
        super(p_234846_);
    }

    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Deepling_Priest_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        matrixStackIn.push();
        if (entity.getAnimation() == Deepling_Priest_Entity.DEEPLING_BLIND && entity.getAnimationTick() >18 && entity.getAnimationTick() <47) {
            float f5 = ((float)entity.getAnimationTick() + partialTicks) / 144;
            float f7 = Math.min(f5 > 0.8F ? (f5 - 0.8F) / 0.2F : 0.0F, 1.0F);
            Random randomsource = Random.create(432L);
            VertexConsumer vertexconsumer2 = bufferIn.getBuffer(RenderLayer.getLightning());
            matrixStackIn.push();
            translateToLight(matrixStackIn);

            for(int i = 0; (float)i < 4; ++i) {
                matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(randomsource.nextFloat() * 360.0F));
                matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(randomsource.nextFloat() * 360.0F));
                matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(randomsource.nextFloat() * 360.0F));
                matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(randomsource.nextFloat() * 360.0F));
                matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(randomsource.nextFloat() * 360.0F));
                matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(randomsource.nextFloat() * 360.0F + f5 * 90.0F));
                float f3 = 2.75F;
                float f4 = 2.75F;
                Matrix4f matrix4f = matrixStackIn.peek().getPositionMatrix();
                int j = (int)(255.0F * (1.0F - f7));
                vertex01(vertexconsumer2, matrix4f, j);
                vertex2(vertexconsumer2, matrix4f, f3, f4);
                vertex3(vertexconsumer2, matrix4f, f3, f4);
                vertex01(vertexconsumer2, matrix4f, j);
                vertex3(vertexconsumer2, matrix4f, f3, f4);
                vertex4(vertexconsumer2, matrix4f, f3, f4);
                vertex01(vertexconsumer2, matrix4f, j);
                vertex4(vertexconsumer2, matrix4f, f3, f4);
                vertex2(vertexconsumer2, matrix4f, f3, f4);
            }

            matrixStackIn.pop();
        }

        matrixStackIn.pop();

    }

    private static void vertex01(VertexConsumer p_114220_, Matrix4f p_114221_, int p_114222_) {
        p_114220_.vertex(p_114221_, 0.0F, 0.0F, 0.0F).color(51, 255, 255, p_114222_);
    }

    private static void vertex2(VertexConsumer p_114215_, Matrix4f p_114216_, float p_114217_, float p_114218_) {
        p_114215_.vertex(p_114216_, -HALF_SQRT_3 * p_114218_, p_114217_, -0.5F * p_114218_).color(51, 255, 255, 0);
    }

    private static void vertex3(VertexConsumer p_114224_, Matrix4f p_114225_, float p_114226_, float p_114227_) {
        p_114224_.vertex(p_114225_, HALF_SQRT_3 * p_114227_, p_114226_, -0.5F * p_114227_).color(51, 255, 255, 0);
    }

    private static void vertex4(VertexConsumer p_114229_, Matrix4f p_114230_, float p_114231_, float p_114232_) {
        p_114229_.vertex(p_114230_, 0.0F, p_114231_, 1.0F * p_114232_).color(51, 255, 255, 0);
    }

    private void translateToLight(MatrixStack matrixStack) {
        this.getContextModel().root.translateAndRotate(matrixStack);
        this.getContextModel().body.translateAndRotate(matrixStack);
        this.getContextModel().head.translateAndRotate(matrixStack);
        this.getContextModel().head2.translateAndRotate(matrixStack);
        this.getContextModel().fin.translateAndRotate(matrixStack);
        this.getContextModel().light.translateAndRotate(matrixStack);
    }

}
