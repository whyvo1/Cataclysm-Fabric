package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Portal_Abyss_Blast_Entity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

@Environment(EnvType.CLIENT)
public class Portal_Abyss_Blast_Renderer extends EntityRenderer<Portal_Abyss_Blast_Entity> {
    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/entity/abyss_laser_beam.png");
    private static final float TEXTURE_WIDTH = 256;
    private static final float TEXTURE_HEIGHT = 32;
    private static final float START_RADIUS = 2.0F;
    private static final float END_RADIUS = 2.0F;
    private static final float BEAM_RADIUS = 2.0F;
    private boolean clearerView = false;

    public Portal_Abyss_Blast_Renderer(EntityRendererFactory.Context mgr) {
        super(mgr);
    }

    @Override
    public Identifier getTexture(Portal_Abyss_Blast_Entity entity) {
        return TEXTURE;
    }


    public boolean shouldRender(Portal_Abyss_Blast_Entity solarBeam, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }

    @Override
    public void render(Portal_Abyss_Blast_Entity solarBeam, float entityYaw, float delta, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        clearerView = solarBeam.caster instanceof PlayerEntity && MinecraftClient.getInstance().player == solarBeam.caster && MinecraftClient.getInstance().options.getPerspective() == Perspective.FIRST_PERSON;

        double collidePosX = solarBeam.prevCollidePosX + (solarBeam.collidePosX - solarBeam.prevCollidePosX) * delta;
        double collidePosY = solarBeam.prevCollidePosY + (solarBeam.collidePosY - solarBeam.prevCollidePosY) * delta;
        double collidePosZ = solarBeam.prevCollidePosZ + (solarBeam.collidePosZ - solarBeam.prevCollidePosZ) * delta;
        double posX = solarBeam.prevX + (solarBeam.getX() - solarBeam.prevX) * delta;
        double posY = solarBeam.prevY + (solarBeam.getY() - solarBeam.prevY) * delta;
        double posZ = solarBeam.prevZ + (solarBeam.getZ() - solarBeam.prevZ) * delta;
        float yaw = solarBeam.prevYaw + (solarBeam.renderYaw - solarBeam.prevYaw) * delta;
        float pitch = solarBeam.prevPitch + (solarBeam.renderPitch - solarBeam.prevPitch) * delta;

        float length = (float) Math.sqrt(Math.pow(collidePosX - posX, 2) + Math.pow(collidePosY - posY, 2) + Math.pow(collidePosZ - posZ, 2));
        int frame = MathHelper.floor((solarBeam.appear.getTimer() - 1 + delta) * 2);
        if (frame < 0) {
            frame = 6;
        }
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getGlowingEffect(getTexture(solarBeam)));

        renderBeam(length, 180f / (float) Math.PI * yaw, 180f / (float) Math.PI * pitch, frame, matrixStackIn, ivertexbuilder, packedLightIn);

        matrixStackIn.push();
        matrixStackIn.translate(collidePosX - posX, collidePosY - posY, collidePosZ - posZ);
        renderEnd(frame, solarBeam.blockSide, matrixStackIn, ivertexbuilder, packedLightIn);
        matrixStackIn.pop();
    }

    private void renderFlatQuad(int frame, MatrixStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        float minU = 0 + 16F / TEXTURE_WIDTH * frame;
        float minV = 0;
        float maxU = minU + 16F / TEXTURE_WIDTH;
        float maxV = minV + 16F / TEXTURE_HEIGHT;
        MatrixStack.Entry matrixstack$entry = matrixStackIn.peek();
        Matrix4f matrix4f = matrixstack$entry.getPositionMatrix();
        Matrix3f matrix3f = matrixstack$entry.getNormalMatrix();
        drawVertex(matrix4f, matrix3f, builder, -START_RADIUS, -END_RADIUS, 0, minU, minV, 1, packedLightIn);
        drawVertex(matrix4f, matrix3f, builder, -START_RADIUS, END_RADIUS, 0, minU, maxV, 1, packedLightIn);
        drawVertex(matrix4f, matrix3f, builder, START_RADIUS, END_RADIUS, 0, maxU, maxV, 1, packedLightIn);
        drawVertex(matrix4f, matrix3f, builder, START_RADIUS, -END_RADIUS, 0, maxU, minV, 1, packedLightIn);
    }

    private void renderEnd(int frame, Direction side, MatrixStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        matrixStackIn.push();
        Quaternionf quat = this.dispatcher.getRotation();
        matrixStackIn.multiply(quat);
        renderFlatQuad(frame, matrixStackIn, builder, packedLightIn);
        matrixStackIn.pop();
        if (side == null) {
            return;
        }
        matrixStackIn.push();
        Quaternionf sideQuat = side.getRotationQuaternion();
        sideQuat.mul((new Quaternionf()).rotationX(90 * ((float)Math.PI / 180F)));
        matrixStackIn.multiply(sideQuat);
        matrixStackIn.translate(0, 0, -0.01f);
        renderFlatQuad(frame, matrixStackIn, builder, packedLightIn);
        matrixStackIn.pop();
    }

    private void drawBeam(float length, int frame, MatrixStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        float minU = 0;
        float minV = 16 / TEXTURE_HEIGHT + 1 / TEXTURE_HEIGHT * frame;
        float maxU = minU + 20 / TEXTURE_WIDTH;
        float maxV = minV + 1 / TEXTURE_HEIGHT;
        MatrixStack.Entry matrixstack$entry = matrixStackIn.peek();
        Matrix4f matrix4f = matrixstack$entry.getPositionMatrix();
        Matrix3f matrix3f = matrixstack$entry.getNormalMatrix();
        float offset = clearerView ? -1 : 0;
        drawVertex(matrix4f, matrix3f, builder, -BEAM_RADIUS, offset, 0, minU, minV, 1, packedLightIn);
        drawVertex(matrix4f, matrix3f, builder, -BEAM_RADIUS, length, 0, minU, maxV, 1, packedLightIn);
        drawVertex(matrix4f, matrix3f, builder, BEAM_RADIUS, length, 0, maxU, maxV, 1, packedLightIn);
        drawVertex(matrix4f, matrix3f, builder, BEAM_RADIUS, offset, 0, maxU, minV, 1, packedLightIn);
    }

    private void renderBeam(float length, float yaw, float pitch, int frame, MatrixStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.multiply((new Quaternionf()).rotationX(90 * ((float)Math.PI / 180F)));
        matrixStackIn.multiply((new Quaternionf()).rotationZ((yaw - 90f) * ((float)Math.PI / 180F) ));
        matrixStackIn.multiply((new Quaternionf()).rotationX(-pitch * ((float)Math.PI / 180F)));
        matrixStackIn.push();
        if (!clearerView) {
            matrixStackIn.multiply((new Quaternionf()).rotationY((MinecraftClient.getInstance().gameRenderer.getCamera().getPitch() + 90)));
        }
        drawBeam(length, frame, matrixStackIn, builder, packedLightIn);
        matrixStackIn.pop();

        if (!clearerView) {
            matrixStackIn.push();
            matrixStackIn.multiply((new Quaternionf()).rotationY((-MinecraftClient.getInstance().gameRenderer.getCamera().getPitch() - 90) * ((float)Math.PI / 180F)));
            drawBeam(length, frame, matrixStackIn, builder, packedLightIn);
            matrixStackIn.pop();
        }
        matrixStackIn.pop();
    }

    public void drawVertex(Matrix4f matrix, Matrix3f normals, VertexConsumer vertexBuilder, float offsetX, float offsetY, float offsetZ, float textureX, float textureY, float alpha, int packedLightIn) {
        vertexBuilder
                .vertex(matrix, offsetX, offsetY, offsetZ)
                .color(1, 1, 1, 1 * alpha)
                .texture(textureX, textureY).overlay(OverlayTexture.DEFAULT_UV)
                .light(packedLightIn)
                .normal(normals, 0.0F, 1.0F, 0.0F)
                .next();
    }
}
