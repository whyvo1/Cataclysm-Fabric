package com.github.l_ender.cataclysm.client.particle;

import com.github.l_ender.cataclysm.client.particle.Options.TrackLightningParticleOptions;
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
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.Vector4f;


public class TrackLightningParticle extends Particle {

    private LightningRender lightningRender = new LightningRender();

    public TrackLightningParticle(ClientWorld world, double x, double y, double z, double xd, double yd, double zd, int r, int g, int b) {
        super(world, x, y, z);
        this.setBoundingBoxSpacing(6.0F, 6.0F);
        this.x = x;
        this.y = y;
        this.z = z;
        this.red = r;
        this.green = g;
        this.blue =  b;
        Vec3d lightningTo = new Vec3d(xd - x, yd - y, zd - z);
        this.maxAge = 5;
        int sections = 1 + (int) (9 * lightningTo.length());
        LightningBoltData.BoltRenderInfo boltData = new LightningBoltData.BoltRenderInfo(0.5F, 0.1F, 0.5F, 0.85F, new Vector4f(red /255, green /255, blue /255, 0.8F), 0.1F);   LightningBoltData bolt = new LightningBoltData(boltData, Vec3d.ZERO, lightningTo, sections)
                .size(0.1F + random.nextFloat() * 0.1F)
                .lifespan(this.maxAge)
                .spawn(LightningBoltData.SpawnFunction.CONSECUTIVE);
        lightningRender.update(this, bolt, 1.0F);
    }

    public Box getRenderBoundingBox(float partialTicks) {
        return getBoundingBox().expand(0.0);
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        this.velocityX = 0;
        this.velocityY = 0;
        this.velocityZ = 0;
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            this.velocityY -= this.gravityStrength;
        }
    }


    public void buildGeometry(VertexConsumer consumer, Camera camera, float partialTick) {
        VertexConsumerProvider.Immediate multibuffersource$buffersource = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
        Vec3d cameraPos = camera.getPos();
        float x = (float) (MathHelper.lerp(partialTick, this.prevPosX, this.x));
        float y = (float) (MathHelper.lerp(partialTick, this.prevPosY, this.y));
        float z = (float) (MathHelper.lerp(partialTick, this.prevPosZ, this.z));
        MatrixStack posestack = new MatrixStack();
        posestack.push();
        posestack.translate(-cameraPos.x, -cameraPos.y, -cameraPos.z);
        posestack.translate(x, y, z);
        lightningRender.render(partialTick, posestack, multibuffersource$buffersource);
        multibuffersource$buffersource.draw();
        posestack.pop();
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.CUSTOM;
    }


    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<TrackLightningParticleOptions> {

        @Override
        public Particle createParticle(TrackLightningParticleOptions data, ClientWorld level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            TrackLightningParticle particle;
            particle = new TrackLightningParticle(level, x, y, z, xSpeed,ySpeed,zSpeed, data.r(), data.g(),data.b());
            return particle;
        }

    }

}
