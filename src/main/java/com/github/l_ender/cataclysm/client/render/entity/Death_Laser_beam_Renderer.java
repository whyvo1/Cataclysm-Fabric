package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.client.render.etc.LightningBoltData;
import com.github.l_ender.cataclysm.client.render.etc.LightningRender;
import com.github.l_ender.cataclysm.entity.projectile.Death_Laser_Beam_Entity;
import com.github.l_ender.cataclysm.util.CMMathUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.Perspective;
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
import net.minecraft.util.math.Vec3d;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector4f;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Environment(EnvType.CLIENT)
public class Death_Laser_beam_Renderer extends EntityRenderer<Death_Laser_Beam_Entity> {
    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/entity/harbinger/death_laser_beam.png");
    private static final float TEXTURE_WIDTH = 256;
    private static final float TEXTURE_HEIGHT = 32;
    private static final float START_RADIUS = 0.75f;
    private static final float BEAM_RADIUS = 0.75F;
    private boolean clearerView = false;
    private Map<UUID, LightningRender> lightningRenderMap = new HashMap<>();

    public Death_Laser_beam_Renderer(EntityRendererFactory.Context mgr) {
        super(mgr);
    }

    @Override
    public Identifier getTexture(Death_Laser_Beam_Entity entity) {
        return TEXTURE;
    }

    @Override
    public void render(Death_Laser_Beam_Entity solarBeam, float entityYaw, float delta, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
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
        renderLighting(delta,matrixStackIn,solarBeam,bufferIn);
    }

    private void renderFlatQuad(int frame, MatrixStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        float minU = 0 + 16F / TEXTURE_WIDTH * frame;
        float minV = 0;
        float maxU = minU + 16F / TEXTURE_WIDTH;
        float maxV = minV + 16F / TEXTURE_HEIGHT;
        MatrixStack.Entry matrixstack$entry = matrixStackIn.peek();
        Matrix4f matrix4f = matrixstack$entry.getPositionMatrix();
        Matrix3f matrix3f = matrixstack$entry.getNormalMatrix();
        drawVertex(matrix4f, matrix3f, builder, -START_RADIUS, -START_RADIUS, 0, minU, minV, 1, packedLightIn);
        drawVertex(matrix4f, matrix3f, builder, -START_RADIUS, START_RADIUS, 0, minU, maxV, 1, packedLightIn);
        drawVertex(matrix4f, matrix3f, builder, START_RADIUS, START_RADIUS, 0, maxU, maxV, 1, packedLightIn);
        drawVertex(matrix4f, matrix3f, builder, START_RADIUS, -START_RADIUS, 0, maxU, minV, 1, packedLightIn);
    }

    private void renderStart(int frame, MatrixStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        if (clearerView) {
            return;
        }
        matrixStackIn.push();
        Quaternionf quat = this.dispatcher.getRotation();
        matrixStackIn.multiply(quat);
        renderFlatQuad(frame, matrixStackIn, builder, packedLightIn);
        matrixStackIn.pop();
    }

    private void renderLighting(float frame, MatrixStack poseStack,Death_Laser_Beam_Entity entity, VertexConsumerProvider buffer) {
        double x = MathHelper.lerp(frame, entity.lastRenderX, entity.getX());
        double y = MathHelper.lerp(frame, entity.lastRenderY, entity.getY());
        double z = MathHelper.lerp(frame, entity.lastRenderZ, entity.getZ());


        float f1 = 0.0F;

        if (entity.age > 20) {
            poseStack.push();

            poseStack.translate(-x, -y, -z);
            LightningBoltData.BoltRenderInfo RedboltData = new LightningBoltData.BoltRenderInfo(0.5F, 0.15F, 0.25F, 0.25F, new Vector4f((float) 255 / 255, (float) 26 / 255, (float) 0 / 255, 0.9F), 0.86F);
            LightningBoltData bolt1 = new LightningBoltData(RedboltData, new Vec3d(x, y, z), new Vec3d(entity.collidePosX, entity.collidePosY, entity.collidePosZ), 5)
                    .size(0.1f)
                    .lifespan(1)
                    .spawn(LightningBoltData.SpawnFunction.NO_DELAY)
                    .fade(LightningBoltData.FadeFunction.NONE);

            LightningBoltData.BoltRenderInfo YellowboltData = new LightningBoltData.BoltRenderInfo(0.5F, 0.1F, 0.25F, 0.15F, new Vector4f((float) 249 / 255, (float) 194 / 255, (float) 43 / 255, 0.7F), 0.86F);
            LightningBoltData bolt2 = new LightningBoltData(YellowboltData, new Vec3d(x, y, z), new Vec3d(entity.collidePosX, entity.collidePosY, entity.collidePosZ), 5)
                    .size(0.07f)
                    .lifespan(1)
                    .spawn(LightningBoltData.SpawnFunction.NO_DELAY)
                    .fade(LightningBoltData.FadeFunction.NONE);

            LightningRender lightningRender = getLightingRender(entity.getUuid());
            if (!MinecraftClient.getInstance().isPaused()) {
                lightningRender.update(entity, bolt1, frame);
                lightningRender.update(entity, bolt2, frame);
            }
            lightningRender.render(frame, poseStack, buffer);

            poseStack.pop();

        }
        if (entity.isRemoved() && lightningRenderMap.containsKey(entity.getUuid())) {
            lightningRenderMap.remove(entity.getUuid());
        }
    }

    private LightningRender getLightingRender(UUID uuid) {
        if (lightningRenderMap.get(uuid) == null) {
            lightningRenderMap.put(uuid, new LightningRender());
        }
        return lightningRenderMap.get(uuid);
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
        sideQuat.mul(CMMathUtil.quatFromRotationXYZ(90, 0, 0, true));
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
        matrixStackIn.multiply(CMMathUtil.quatFromRotationXYZ(90, 0, 0, true));
        matrixStackIn.multiply(CMMathUtil.quatFromRotationXYZ(0, 0, yaw - 90f, true));
        matrixStackIn.multiply(CMMathUtil.quatFromRotationXYZ(-pitch, 0, 0, true));
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
