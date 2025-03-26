package com.github.l_ender.cataclysm.client.particle;

import com.github.l_ender.cataclysm.client.particle.Options.SparkTrailParticleOptions;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;


public class SparkParticle extends SpriteBillboardParticle {

    protected SparkParticle(ClientWorld level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        this.gravityStrength = 0.95F;
        this.velocityMultiplier = 0.999F;
        this.velocityX += xSpeed;
        this.velocityY += ySpeed;
        this.velocityZ += zSpeed;
        this.velocityY = this.random.nextFloat() * 0.4F + 0.05F;
        this.scale *= this.random.nextFloat() * 2.0F + 0.2F;
        this.maxAge = 6 + level.random.nextInt(3);
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
                //this.level.addParticle(ParticleTypes.SMOKE, this.x, this.y, this.z, this.xd, this.yd, this.zd);

                this.world.addParticle(new SparkTrailParticleOptions(255, 106,  0), this.x, this.y, this.z, this.velocityX, this.velocityY, this.velocityZ);

            }
            if (this.onGround) {
                this.markDead();
            }
        }

    }


    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider sprite;

        public Factory(SpriteProvider p_107092_) {
            this.sprite = p_107092_;
        }

        public Particle createParticle(SimpleParticleType p_107103_, ClientWorld p_107104_, double p_107105_, double p_107106_, double p_107107_, double p_107108_, double p_107109_, double p_107110_) {
            SparkParticle lavaparticle = new SparkParticle(p_107104_, p_107105_, p_107106_, p_107107_, p_107108_, p_107109_, p_107110_);
            lavaparticle.setSprite(this.sprite);
            return lavaparticle;
        }
    }
}