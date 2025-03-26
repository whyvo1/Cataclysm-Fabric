package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Dimensional_Rift_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@Environment(EnvType.CLIENT)
public class Dimensional_Rift_Renderer extends EntityRenderer<Dimensional_Rift_Entity> {
    private static final Identifier TEXTURE_IDLE_1 = Cataclysm.modIdentifier("textures/entity/leviathan/dimensional_rift/dimensional_rift_idle1.png");
    private static final Identifier TEXTURE_IDLE_2 = Cataclysm.modIdentifier("textures/entity/leviathan/dimensional_rift/dimensional_rift_idle2.png");
    private static final Identifier TEXTURE_IDLE_3 = Cataclysm.modIdentifier("textures/entity/leviathan/dimensional_rift/dimensional_rift_idle3.png");
    private static final Identifier TEXTURE_IDLE_4 = Cataclysm.modIdentifier("textures/entity/leviathan/dimensional_rift/dimensional_rift_idle4.png");

    private static final Identifier TEXTURE_GROW_1 = Cataclysm.modIdentifier("textures/entity/leviathan/dimensional_rift/dimensional_rift_grow_0.png");
    private static final Identifier TEXTURE_GROW_2 = Cataclysm.modIdentifier("textures/entity/leviathan/dimensional_rift/dimensional_rift_grow_1.png");
    private static final Identifier TEXTURE_GROW_3 = Cataclysm.modIdentifier("textures/entity/leviathan/dimensional_rift/dimensional_rift_grow_2.png");
    private static final Identifier TEXTURE_GROW_4 = Cataclysm.modIdentifier("textures/entity/leviathan/dimensional_rift/dimensional_rift_grow_3.png");



    public Dimensional_Rift_Renderer(EntityRendererFactory.Context mgr) {
        super(mgr);

    }

    public void render(Dimensional_Rift_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        matrixStackIn.push();
        Identifier tex = entityIn.getStage() <1 ? TEXTURE_GROW_1 : entityIn.getStage() < 2 ? TEXTURE_GROW_2 : entityIn.getStage() < 3 ? TEXTURE_GROW_3 : entityIn.getStage() < 4 ? TEXTURE_GROW_4 : this.getIdleTexture(entityIn.age % 9);

        matrixStackIn.multiply(this.dispatcher.getRotation());
        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
        matrixStackIn.scale(7, 7, 7);
        MatrixStack.Entry posestack$pose = matrixStackIn.peek();
        Matrix4f matrix4f = posestack$pose.getPositionMatrix();
        Matrix3f matrix3f = posestack$pose.getNormalMatrix();
        VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getfullBright(tex));
        vertex(vertexconsumer, matrix4f, matrix3f, packedLightIn, 0.0F, 0, 0, 1);
        vertex(vertexconsumer, matrix4f, matrix3f, packedLightIn, 1.0F, 0, 1, 1);
        vertex(vertexconsumer, matrix4f, matrix3f, packedLightIn, 1.0F, 1, 1, 0);
        vertex(vertexconsumer, matrix4f, matrix3f, packedLightIn, 0.0F, 1, 0, 0);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    private static void vertex(VertexConsumer p_114090_, Matrix4f p_114091_, Matrix3f p_114092_, int p_114093_, float p_114094_, int p_114095_, int p_114096_, int p_114097_) {
        p_114090_.vertex(p_114091_, p_114094_ - 0.5F, (float)p_114095_ - 0.25F, 0.0F).color(255, 255, 255, 255).texture((float)p_114096_, (float)p_114097_).overlay(OverlayTexture.DEFAULT_UV).light(p_114093_).normal(p_114092_, 0.0F, 1.0F, 0.0F).next();
    }

    @Override
    public Identifier getTexture(Dimensional_Rift_Entity entity) {
        return TEXTURE_IDLE_1;
    }

    public Identifier getIdleTexture(int age) {
        if (age < 3) {
            return TEXTURE_IDLE_1;
        } else if (age < 6) {
            return TEXTURE_IDLE_2;
        } else if (age < 10) {
            return TEXTURE_IDLE_3;
        } else {
            return TEXTURE_IDLE_4;
        }
    }
}
