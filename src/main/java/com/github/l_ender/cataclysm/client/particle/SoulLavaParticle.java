package com.github.l_ender.cataclysm.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;


public class SoulLavaParticle extends SpriteBillboardParticle {
    SoulLavaParticle(ClientWorld p_107074_, double p_107075_, double p_107076_, double p_107077_) {
        super(p_107074_, p_107075_, p_107076_, p_107077_, 0.0D, 0.0D, 0.0D);
        this.gravityStrength = 0.75F;
        this.velocityMultiplier = 0.999F;
        this.velocityX *= 0.8F;
        this.velocityY *= 0.8F;
        this.velocityZ *= 0.8F;
        this.velocityY = this.random.nextFloat() * 0.4F + 0.05F;
        this.scale *= this.random.nextFloat() * 2.0F + 0.2F;
        this.maxAge = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    public int getBrightness(float p_107086_) {
        int i = super.getBrightness(p_107086_);
        int j = 240;
        int k = i >> 16 & 255;
        return 240 | k << 16;
    }

    public float getSize(float p_107089_) {
        float f = ((float)this.age + p_107089_) / (float)this.maxAge;
        return this.scale * (1.0F - f * f);
    }

    public void tick() {
        super.tick();
        if (!this.dead) {
            float f = (float)this.age / (float)this.maxAge;
            if (this.random.nextFloat() > f) {
                this.world.addParticle(ParticleTypes.SMOKE, this.x, this.y, this.z, this.velocityX, this.velocityY, this.velocityZ);
            }
        }

    }


    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider sprite;

        public Factory(SpriteProvider p_107092_) {
            this.sprite = p_107092_;
        }

        public Particle createParticle(SimpleParticleType p_107103_, ClientWorld p_107104_, double p_107105_, double p_107106_, double p_107107_, double p_107108_, double p_107109_, double p_107110_) {
            SoulLavaParticle lavaparticle = new SoulLavaParticle(p_107104_, p_107105_, p_107106_, p_107107_);
            lavaparticle.setSprite(this.sprite);
            return lavaparticle;
        }
    }
}