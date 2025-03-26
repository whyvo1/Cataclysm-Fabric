package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.entity.projectile.Poison_Dart_Entity;
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
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@Environment(EnvType.CLIENT)
public class Poison_Dart_Renderer extends EntityRenderer<Poison_Dart_Entity> {
    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/entity/poison_dart.png");

    public Poison_Dart_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public Identifier getTexture(Poison_Dart_Entity entity) {
        return TEXTURE;
    }



    public void render(Poison_Dart_Entity p_113839_, float p_113840_, float p_113841_, MatrixStack p_113842_, VertexConsumerProvider p_113843_, int p_113844_) {
        p_113842_.push();
        p_113842_.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(p_113841_, p_113839_.prevYaw, p_113839_.getYaw()) - 90.0F));
        p_113842_.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(p_113841_, p_113839_.prevPitch, p_113839_.getPitch())));
        int i = 0;
        float f = 0.0F;
        float f1 = 0.5F;
        float f2 = 0.0F;
        float f3 = 0.15625F;
        float f4 = 0.0F;
        float f5 = 0.15625F;
        float f6 = 0.15625F;
        float f7 = 0.3125F;
        float f8 = 0.05625F;
        float f9 = (float)p_113839_.shake - p_113841_;
        if (f9 > 0.0F) {
            float f10 = -MathHelper.sin(f9 * 3.0F) * f9;
            p_113842_.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f10));
        }

        p_113842_.multiply(RotationAxis.POSITIVE_X.rotationDegrees(45.0F));
        p_113842_.scale(0.05625F, 0.05625F, 0.05625F);
        p_113842_.translate(-1.0F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = p_113843_.getBuffer(RenderLayer.getEntityCutout(this.getTexture(p_113839_)));
        MatrixStack.Entry posestack$pose = p_113842_.peek();
        Matrix4f matrix4f = posestack$pose.getPositionMatrix();
        Matrix3f matrix3f = posestack$pose.getNormalMatrix();
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, -2, -2, 0.0F, 0.15625F, -1, 0, 0, p_113844_);
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, -2, 2, 0.15625F, 0.15625F, -1, 0, 0, p_113844_);
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, 2, 2, 0.15625F, 0.3125F, -1, 0, 0, p_113844_);
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, 2, -2, 0.0F, 0.3125F, -1, 0, 0, p_113844_);
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, 2, -2, 0.0F, 0.15625F, 1, 0, 0, p_113844_);
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, 2, 2, 0.15625F, 0.15625F, 1, 0, 0, p_113844_);
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, -2, 2, 0.15625F, 0.3125F, 1, 0, 0, p_113844_);
        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, -2, -2, 0.0F, 0.3125F, 1, 0, 0, p_113844_);

        for(int j = 0; j < 4; ++j) {
            p_113842_.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
            this.vertex(matrix4f, matrix3f, vertexconsumer, -8, -2, 0, 0.0F, 0.0F, 0, 1, 0, p_113844_);
            this.vertex(matrix4f, matrix3f, vertexconsumer, 8, -2, 0, 0.5F, 0.0F, 0, 1, 0, p_113844_);
            this.vertex(matrix4f, matrix3f, vertexconsumer, 8, 2, 0, 0.5F, 0.15625F, 0, 1, 0, p_113844_);
            this.vertex(matrix4f, matrix3f, vertexconsumer, -8, 2, 0, 0.0F, 0.15625F, 0, 1, 0, p_113844_);
        }

        p_113842_.pop();
        super.render(p_113839_, p_113840_, p_113841_, p_113842_, p_113843_, p_113844_);
    }

    public void vertex(Matrix4f p_254392_, Matrix3f p_254011_, VertexConsumer p_253902_, int p_254058_, int p_254338_, int p_254196_, float p_254003_, float p_254165_, int p_253982_, int p_254037_, int p_254038_, int p_254271_) {
        p_253902_.vertex(p_254392_, (float)p_254058_, (float)p_254338_, (float)p_254196_).color(255, 255, 255, 255).texture(p_254003_, p_254165_).overlay(OverlayTexture.DEFAULT_UV).light(p_254271_).normal(p_254011_, (float)p_253982_, (float)p_254038_, (float)p_254037_).next();
    }
}
