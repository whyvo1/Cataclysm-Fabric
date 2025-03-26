package com.github.l_ender.cataclysm.client.particle;

import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

import java.util.Arrays;

import static net.minecraft.client.render.OverlayTexture.DEFAULT_UV;

public abstract class AbstractTrailParticle extends Particle {

    private Vec3d[] trailPositions = new Vec3d[64];
    private int trailPointer = -1;

    public float r;
    public float g;
    public float b;

    protected float trailA = 1.0F;

    public AbstractTrailParticle(ClientWorld world, double x, double y, double z, double xd, double yd, double zd,float r, float g, float b) {
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
            Arrays.fill(trailPositions, currentPosition);
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
            int light = getBrightness(partialTick);
            float zRot = getTrailRot(camera);
            Vec3d topAngleVec = new Vec3d(0, getTrailHeight() / 2F, 0).rotateZ(zRot);
            Vec3d bottomAngleVec = new Vec3d(0, -getTrailHeight() / 2F, 0).rotateZ(zRot);

            Vec3d drawFrom = new Vec3d(x, y, z);
            MatrixStack.Entry posestack$pose = posestack.peek();
            Matrix4f matrix4f = posestack$pose.getPositionMatrix();
            Matrix3f matrix3f = posestack$pose.getNormalMatrix();
            for (int samples = 0; samples < sampleCount(); samples++) {
                Vec3d sample = getTrailPosition(samples * sampleStep(), partialTick);
                float u1 = samples / (float) sampleCount();
                float u2 = (samples + 1) / (float) sampleCount();

                addVertex(vertexconsumer, matrix4f,matrix3f, drawFrom, bottomAngleVec, u1, 1F, light);
                addVertex(vertexconsumer, matrix4f,matrix3f, sample, bottomAngleVec, u2, 1F, light);
                addVertex(vertexconsumer, matrix4f,matrix3f, sample, topAngleVec, u2, 0F, light);
                addVertex(vertexconsumer, matrix4f,matrix3f, drawFrom, topAngleVec, u1, 0F, light);

                drawFrom = sample;
            }
            posestack.pop();
            // multibuffersource$buffersource.endBatch();
        }
    }

    private void addVertex(VertexConsumer consumer, Matrix4f matrix, Matrix3f matrix3f, Vec3d pos, Vec3d offset, float u, float v, int light) {
        consumer.vertex(matrix,
                        (float) (pos.x + offset.x),
                        (float) (pos.y + offset.y),
                        (float) (pos.z + offset.z))
                .color(r, g, b, trailA)
                .texture(u, v)
                .overlay(DEFAULT_UV)
                .light(light)
                .normal(matrix3f,0.0F, 1.0F, 0.0F)
                .next();
    }

    protected VertexConsumer getVetrexConsumer(VertexConsumerProvider.Immediate multibuffersource$buffersource) {
        return multibuffersource$buffersource.getBuffer(CMRenderTypes.NEW_TRAIL_EFFECT.apply(getTrailTexture()));
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

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.CUSTOM;
    }
}