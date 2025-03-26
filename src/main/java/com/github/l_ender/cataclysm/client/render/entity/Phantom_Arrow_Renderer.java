package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.entity.projectile.Phantom_Arrow_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class Phantom_Arrow_Renderer extends EntityRenderer<Phantom_Arrow_Entity> {

    private static final Identifier TEXTURE_RED = Cataclysm.modIdentifier("textures/entity/maledictus/phantom_arrow.png");
    private static final RenderLayer RENDER_TYPE_RED = CMRenderTypes.getGhost(TEXTURE_RED);

    public Phantom_Arrow_Renderer(EntityRendererFactory.Context mgr) {
        super(mgr);
    }

    @Override
    public void render(Phantom_Arrow_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevYaw, entityIn.getYaw()) - 90.0F));
        matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevPitch, entityIn.getPitch())));
        float f1 = 0.15625F;
        float f2 = 0.3125F;
        float f9 = (float)entityIn.shake - partialTicks;
        if (f9 > 0.0F) {
            float f10 = -MathHelper.sin(f9 * 3.0F) * f9;
            matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f10));
        }

        matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(45.0F));
        matrixStackIn.scale(0.075F, 0.075F, 0.075F);
        matrixStackIn.translate(-4.0F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = bufferIn.getBuffer(RENDER_TYPE_RED);
        MatrixStack.Entry posestack$pose = matrixStackIn.peek();

        float hide = ((float) entityIn.getTransparency() / 200);
        float alpha = (1F - hide);
        int light = (int) (255 * MathHelper.clamp(alpha, 0, 1));

        this.vertex(posestack$pose, vertexconsumer, -7, -2, -2, light,0.0F, 0.15625F, -1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, -2, 2, light,0.15625F, 0.15625F, -1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, 2, 2, light,0.15625F, 0.3125F, -1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, 2, -2, light,0.0F, 0.3125F, -1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, 2, -2, light,0.0F, 0.15625F, 1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, 2, 2, light,0.15625F, 0.15625F, 1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, -2, 2, light,0.15625F, 0.3125F, 1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, -2, -2, light,0.0F, 0.3125F, 1, 0, 0, packedLightIn);

        for(int j = 0; j < 4; ++j) {
            matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
            this.vertex(posestack$pose, vertexconsumer, -8, -2, 0, light,0.0F, 0.0F, 0, 1, 0, packedLightIn);
            this.vertex(posestack$pose, vertexconsumer, 8, -2, 0, light,0.65F, 0.0F, 0, 1, 0, packedLightIn);
            this.vertex(posestack$pose, vertexconsumer, 8, 2, 0, light,0.65F, 0.15625F, 0, 1, 0, packedLightIn);
            this.vertex(posestack$pose, vertexconsumer, -8, 2, 0, light,0.0F, 0.15625F, 0, 1, 0, packedLightIn);
        }



        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public void vertex(MatrixStack.Entry p_324380_, VertexConsumer p_253902_, int p_254058_, int p_254338_, int p_254196_,int light, float p_254003_, float p_254165_, int p_253982_, int p_254037_, int p_254038_, int p_254271_) {
        p_253902_.vertex(p_324380_, (float)p_254058_, (float)p_254338_, (float)p_254196_).color(255, 255, 255, light).texture(p_254003_, p_254165_).overlay(OverlayTexture.DEFAULT_UV).light(p_254271_).normal(p_324380_, (float)p_253982_, (float)p_254038_, (float)p_254037_);
    }


    @Override
    public Identifier getTexture(Phantom_Arrow_Entity entity) {
        return TEXTURE_RED;
    }
}
