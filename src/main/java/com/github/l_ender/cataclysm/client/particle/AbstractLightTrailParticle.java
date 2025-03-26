package com.github.l_ender.cataclysm.client.particle;

import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;


public abstract class AbstractLightTrailParticle extends Particle {

    private Vec3d[] trailPositions = new Vec3d[64];
    private int trailPointer = -1;

    public float r;
    public float g;
    public float b;

    protected float trailA = 0.4F;

    public AbstractLightTrailParticle(ClientWorld world, double x, double y, double z, double xd, double yd, double zd, float r, float g, float b) {
        super(world, x, y, z);
        this.velocityX = xd;
        this.velocityY = yd;
        this.velocityZ = zd;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void tick() {
        tickTrail();
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        this.velocityX *= 0.99;
        this.velocityY *= 0.99;
        this.velocityZ *= 0.99;
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            this.velocityY -= this.gravityStrength;
        }
    }

    public void tickTrail() {

        Vec3d currentPosition = new Vec3d(this.x, this.y, this.z);
        if (trailPointer == -1) {
            for (int i = 0; i < trailPositions.length; i++) {
                trailPositions[i] = currentPosition;
            }
        }
        if (++this.trailPointer == this.trailPositions.length) {
            this.trailPointer = 0;
        }
        this.trailPositions[this.trailPointer] = currentPosition;
    }


    public void buildGeometry(VertexConsumer consumer, Camera camera, float partialTick) {
        if (trailPointer > -1) {
            VertexConsumerProvider.Immediate multibuffersource$buffersource = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
            VertexConsumer vertexconsumer = getVetrexConsumer(multibuffersource$buffersource);
            Vec3d cameraPos = camera.getPos();
            float x = (float) (MathHelper.lerp(partialTick, this.prevPosX, this.x));
            float y = (float) (MathHelper.lerp(partialTick, this.prevPosY, this.y));
            float z = (float) (MathHelper.lerp(partialTick, this.prevPosZ, this.z));

            MatrixStack posestack = new MatrixStack();
            posestack.push();
            posestack.translate(-cameraPos.x, -cameraPos.y, -cameraPos.z);
            int samples = 0;
            Vec3d drawFrom = new Vec3d(x, y, z);
            float zRot = getTrailRot(camera);
            Vec3d topAngleVec = new Vec3d(0, getTrailHeight() / 2F, 0).rotateZ(zRot);
            Vec3d bottomAngleVec = new Vec3d(0, getTrailHeight() / -2F, 0).rotateZ(zRot);
            int j = getBrightness(partialTick);
            while (samples < sampleCount()) {
                Vec3d sample = getTrailPosition(samples * sampleStep(), partialTick);
                float u1 = samples / (float) sampleCount();
                float u2 = u1 + 1 / (float) sampleCount();

                Vec3d draw1 = drawFrom;
                Vec3d draw2 = sample;
                MatrixStack.Entry posestack$pose = posestack.peek();
                Matrix4f matrix4f = posestack$pose.getPositionMatrix();
                vertexconsumer.vertex(matrix4f,(float) draw1.x + (float) bottomAngleVec.x, (float) draw1.y + (float) bottomAngleVec.y, (float) draw1.z + (float) bottomAngleVec.z).color(r, g, b, trailA).texture(u1, 1F).overlay(OverlayTexture.DEFAULT_UV).light(j).normal(posestack$pose, 0.0F, 1.0F, 0.0F);
                vertexconsumer.vertex(matrix4f,(float) draw2.x + (float) bottomAngleVec.x, (float) draw2.y + (float) bottomAngleVec.y, (float) draw2.z + (float) bottomAngleVec.z).color(r, g, b, trailA).texture(u2, 1F).overlay(OverlayTexture.DEFAULT_UV).light(j).normal(posestack$pose, 0.0F, 1.0F, 0.0F);
                vertexconsumer.vertex(matrix4f,(float) draw2.x + (float) topAngleVec.x, (float) draw2.y + (float) topAngleVec.y, (float) draw2.z + (float) topAngleVec.z).color(r, g, b, trailA).texture(u2, 0).overlay(OverlayTexture.DEFAULT_UV).light(j).normal(posestack$pose, 0.0F, 1.0F, 0.0F);
                vertexconsumer.vertex(matrix4f,(float) draw1.x + (float) topAngleVec.x, (float) draw1.y + (float) topAngleVec.y, (float) draw1.z + (float) topAngleVec.z).color(r, g, b, trailA).texture(u1, 0).overlay(OverlayTexture.DEFAULT_UV).light(j).normal(posestack$pose, 0.0F, 1.0F, 0.0F);
                samples++;
                drawFrom = sample;
            }
            multibuffersource$buffersource.draw();
            posestack.pop();
        }
    }

    protected VertexConsumer getVetrexConsumer(VertexConsumerProvider.Immediate multibuffersource$buffersource) {
        return multibuffersource$buffersource.getBuffer(CMRenderTypes.LIGHT_TRAIL_EFFECT.apply(getTrailTexture()));
    }

    public float getTrailRot(Camera camera) {
        return -0.017453292F * camera.getPitch();
    }

    public abstract float getTrailHeight();

    public abstract Identifier getTrailTexture();

    public int sampleCount() {
        return 20;
    }

    public int sampleStep() {
        return 1;
    }


    public Vec3d getTrailPosition(int pointer, float partialTick) {
        if (this.dead) {
            partialTick = 1.0F;
        }
        int i = this.trailPointer - pointer & 63;
        int j = this.trailPointer - pointer - 1 & 63;
        Vec3d d0 = this.trailPositions[j];
        Vec3d d1 = this.trailPositions[i].subtract(d0);
        return d0.add(d1.multiply(partialTick));
    }

    public int getBrightness(float f) {
        return 240;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.CUSTOM;
    }
}