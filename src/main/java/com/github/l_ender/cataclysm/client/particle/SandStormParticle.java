package com.github.l_ender.cataclysm.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class SandStormParticle extends SpriteBillboardParticle {


    protected SandStormParticle(ClientWorld level, double xCoord, double yCoord, double zCoord, SpriteProvider spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);
        this.velocityX += xd;
        this.velocityY += yd;
        this.velocityZ += zd;
        this.scale *= 2.5F;
        this.maxAge = (int)(Math.random() * 2.0D) + 60;
        this.setSpriteForAge(spriteSet);
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    public float getSize(float p_107608_) {
        float f = 1.0F - ((float)this.age + p_107608_) / ((float)this.maxAge * 1.5F);
        return this.scale * f;
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            float f = (float)this.age / (float)this.maxAge;
            this.x += this.velocityX * (double)f;
            this.y += this.velocityY * (double)f;
            this.z += this.velocityZ * (double)f;
            this.setPos(this.x, this.y, this.z); // FORGE: update the particle's bounding box
        }
    }


    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld level, double x, double y, double z, double dx, double dy, double dz) {
            return new SandStormParticle(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }
}