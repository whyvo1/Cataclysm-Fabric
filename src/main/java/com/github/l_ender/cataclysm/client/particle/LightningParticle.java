package com.github.l_ender.cataclysm.client.particle;

import com.github.l_ender.cataclysm.client.particle.Options.LightningParticleOptions;
import com.github.l_ender.cataclysm.client.render.etc.LightningBoltData;
import com.github.l_ender.cataclysm.client.render.etc.LightningRender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.Vector4f;

import java.util.Random;

public class LightningParticle extends Particle {


    private double toX;
    private double toY;
    private double toZ;
    private LightningRender lightningRender = new LightningRender();

    public LightningParticle(ClientWorld world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int r, int g, int b) {
        super(world, x, y, z);
        this.setBoundingBoxSpacing(1, 1);
        this.gravityStrength = 0.0F;
        this.maxAge = 5 + new Random().nextInt(3);
        this.toX = xSpeed;
        this.toY = ySpeed;
        this.toZ = zSpeed;
        this.red = r;
        this.green = g;
        this.blue =  b;

    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.CUSTOM;
    }

    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float partialTick) {
        Vec3d vec3 = camera.getPos();
        MatrixStack posestack = new MatrixStack();
        VertexConsumerProvider.Immediate multibuffersource$buffersource = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
        float f = (float)(MathHelper.lerp(partialTick, this.prevPosX, this.x) - vec3.getX());
        float f1 = (float)(MathHelper.lerp(partialTick, this.prevPosY, this.y) - vec3.getY());
        float f2 = (float)(MathHelper.lerp(partialTick, this.prevPosZ, this.z) - vec3.getZ());
        float lerpAge = this.age + partialTick;
        float ageProgress = lerpAge / (float) this.maxAge;
        float scale = 1.85F;
        posestack.push();
        posestack.translate(f, f1, f2);
        posestack.scale(scale, scale, scale);
        LightningBoltData.BoltRenderInfo lightningBoltData = new LightningBoltData.BoltRenderInfo(0.5F, 0.1F, 0.5F, 0.85F, new Vector4f(red /255, green /255, blue /255, (1.0F - ageProgress) * 0.8F), 0.1F);
        LightningBoltData bolt = new LightningBoltData(lightningBoltData, Vec3d.ZERO, new Vec3d(toX, toY, toZ), 4)
                .size(0.05F)
                .lifespan(this.maxAge)
                .spawn(LightningBoltData.SpawnFunction.CONSECUTIVE);
        lightningRender.update(this, bolt, partialTick);
        lightningRender.render(partialTick, posestack, multibuffersource$buffersource);

        multibuffersource$buffersource.draw();
        posestack.pop();
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<LightningParticleOptions> {

        @Override
        public Particle createParticle(LightningParticleOptions data, ClientWorld level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            LightningParticle particle;
            particle = new LightningParticle(level, x, y, z,xSpeed,ySpeed,zSpeed, data.r(),data.g(),data.b());
            return particle;
        }

    }
}
