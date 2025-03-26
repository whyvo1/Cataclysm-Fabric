package com.github.l_ender.cataclysm.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class FlameJetParticle extends SpriteBillboardParticle {

    private final SpriteProvider sprites;

    protected FlameJetParticle(ClientWorld world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteProvider spriteSet) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed);
        this.sprites = spriteSet;
        this.setSpriteForAge(this.sprites);
        this.velocityX = xSpeed;
        this.velocityY = ySpeed;
        this.velocityZ = zSpeed;
        this.scale = 2F;
        this.maxAge = 10;
        this.setBoundingBoxSpacing(3.0F, 3.0F);
    }

    public void tick() {
        this.setSpriteForAge(this.sprites);
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;

        if (this.age++ >= this.maxAge) {
            this.markDead();
        }

    }

    @Override
    public void buildGeometry(VertexConsumer buffer, Camera camera, float partialTicks) {
        Vec3d vec3 = camera.getPos();
        float f = (float)(MathHelper.lerp(partialTicks, this.prevPosX, this.x) - vec3.getX());
        float f1 = (float)(MathHelper.lerp(partialTicks, this.prevPosY, this.y) - vec3.getY());
        float f2 = (float)(MathHelper.lerp(partialTicks, this.prevPosZ, this.z) - vec3.getZ());
        Quaternionf quaternionf = new Quaternionf();
        quaternionf.rotateY((float) Math.toRadians(-camera.getYaw()));

        Vector3f[] avector3f = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};
        float f3 = this.getSize(partialTicks);

        for(int i = 0; i < 4; ++i) {
            Vector3f vector3f = avector3f[i];
            vector3f.rotate(quaternionf);
            vector3f.mul(f3);
            vector3f.add(f, f1, f2);
        }

        float f6 = this.getMinU();
        float f7 = this.getMaxU();
        float f4 = this.getMinV();
        float f5 = this.getMaxV();
        int j = this.getBrightness(partialTicks);
        buffer.vertex(avector3f[0].x(), avector3f[0].y(), avector3f[0].z()).texture(f7, f5).color(this.red, this.green, this.blue, this.alpha).light(j);
        buffer.vertex(avector3f[1].x(), avector3f[1].y(), avector3f[1].z()).texture(f7, f4).color(this.red, this.green, this.blue, this.alpha).light(j);
        buffer.vertex(avector3f[2].x(), avector3f[2].y(), avector3f[2].z()).texture(f6, f4).color(this.red, this.green, this.blue, this.alpha).light(j);
        buffer.vertex(avector3f[3].x(), avector3f[3].y(), avector3f[3].z()).texture(f6, f5).color(this.red, this.green, this.blue, this.alpha).light(j);


    }


    public int getBrightness(float p_106821_) {
        float f = ((float)this.age + p_106821_) / (float)this.maxAge;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        int i = super.getBrightness(p_106821_);
        int j = i & 255;
        int k = i >> 16 & 255;
        j += (int)(f * 15.0F * 16.0F);
        if (j > 240) {
            j = 240;
        }

        return 240;
    }


    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteSet;

        public Factory(SpriteProvider spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            FlameJetParticle particle = new FlameJetParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, spriteSet);
            return particle;
        }
    }
}