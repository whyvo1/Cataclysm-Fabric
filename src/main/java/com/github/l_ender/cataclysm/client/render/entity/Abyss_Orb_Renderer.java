package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Orb_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@Environment(EnvType.CLIENT)
public class Abyss_Orb_Renderer extends EntityRenderer<Abyss_Orb_Entity> {
    private static final Identifier TEXTURE_LOCATION = Cataclysm.modIdentifier("textures/entity/leviathan/abyss_orb.png");
    private static final RenderLayer RENDER_TYPE = RenderLayer.getEntityCutoutNoCull(TEXTURE_LOCATION);

    public Abyss_Orb_Renderer(EntityRendererFactory.Context p_173962_) {
        super(p_173962_);
    }

    protected int getBlockLight(Abyss_Orb_Entity p_114087_, BlockPos p_114088_) {
        return 15;
    }

    public void render(Abyss_Orb_Entity p_114080_, float p_114081_, float p_114082_, MatrixStack p_114083_, VertexConsumerProvider p_114084_, int p_114085_) {
        p_114083_.push();
        p_114083_.scale(1.0F, 1.0F, 1.0F);
        p_114083_.multiply(this.dispatcher.getRotation());
        p_114083_.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
        MatrixStack.Entry posestack$pose = p_114083_.peek();
        Matrix4f matrix4f = posestack$pose.getPositionMatrix();
        Matrix3f matrix3f = posestack$pose.getNormalMatrix();
        VertexConsumer vertexconsumer = p_114084_.getBuffer(RENDER_TYPE);
        vertex(vertexconsumer, matrix4f, matrix3f, p_114085_, 0.0F, 0, 0, 1);
        vertex(vertexconsumer, matrix4f, matrix3f, p_114085_, 1.0F, 0, 1, 1);
        vertex(vertexconsumer, matrix4f, matrix3f, p_114085_, 1.0F, 1, 1, 0);
        vertex(vertexconsumer, matrix4f, matrix3f, p_114085_, 0.0F, 1, 0, 0);
        p_114083_.pop();
        super.render(p_114080_, p_114081_, p_114082_, p_114083_, p_114084_, p_114085_);
    }

    private static void vertex(VertexConsumer p_114090_, Matrix4f p_114091_, Matrix3f p_114092_, int p_114093_, float p_114094_, int p_114095_, int p_114096_, int p_114097_) {
        p_114090_.vertex(p_114091_, p_114094_ - 0.5F, (float)p_114095_ - 0.25F, 0.0F).color(255, 255, 255, 255).texture((float)p_114096_, (float)p_114097_).overlay(OverlayTexture.DEFAULT_UV).light(p_114093_).normal(p_114092_, 0.0F, 1.0F, 0.0F).next();
    }

    public Identifier getTexture(Abyss_Orb_Entity p_114078_) {
        return TEXTURE_LOCATION;
    }
}
