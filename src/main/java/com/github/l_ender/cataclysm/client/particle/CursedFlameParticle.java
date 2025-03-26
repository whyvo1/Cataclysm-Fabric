package com.github.l_ender.cataclysm.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.MathHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class CursedFlameParticle extends AbstractSlowingParticle {
    CursedFlameParticle(ClientWorld p_106800_, double p_106801_, double p_106802_, double p_106803_, double p_106804_, double p_106805_, double p_106806_) {
        super(p_106800_, p_106801_, p_106802_, p_106803_, p_106804_, p_106805_, p_106806_);
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    public void move(double p_106817_, double p_106818_, double p_106819_) {
        this.setBoundingBox(this.getBoundingBox().offset(p_106817_, p_106818_, p_106819_));
        this.repositionFromBoundingBox();
    }

    public float getSize(float p_106824_) {
        float f = ((float)this.age + p_106824_) / (float)this.maxAge;
        return this.scale * (1.0F - f * f * 0.5F);
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

        return j | k << 16;
    }

    @Environment(EnvType.CLIENT)
    public static class Provider implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprite;

        public Provider(SpriteProvider p_106827_) {
            this.sprite = p_106827_;
        }

        public Particle createParticle(DefaultParticleType p_106838_, ClientWorld p_106839_, double p_106840_, double p_106841_, double p_106842_, double p_106843_, double p_106844_, double p_106845_) {
            CursedFlameParticle flameparticle = new CursedFlameParticle(p_106839_, p_106840_, p_106841_, p_106842_, p_106843_, p_106844_, p_106845_);
            flameparticle.setSprite(this.sprite);
            return flameparticle;
        }
    }

    @Environment(EnvType.CLIENT)
    public static class SmallFlameProvider implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprite;

        public SmallFlameProvider(SpriteProvider p_172113_) {
            this.sprite = p_172113_;
        }

        public Particle createParticle(DefaultParticleType p_172124_, ClientWorld p_172125_, double p_172126_, double p_172127_, double p_172128_, double p_172129_, double p_172130_, double p_172131_) {
            CursedFlameParticle flameparticle = new CursedFlameParticle(p_172125_, p_172126_, p_172127_, p_172128_, p_172129_, p_172130_, p_172131_);
            flameparticle.setSprite(this.sprite);
            flameparticle.scale(0.5F);
            return flameparticle;
        }
    }
}
