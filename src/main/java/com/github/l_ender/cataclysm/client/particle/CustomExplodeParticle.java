package com.github.l_ender.cataclysm.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.ColorHelper;

public class CustomExplodeParticle extends SpriteBillboardParticle {


    private final SpriteProvider sprites;
    private boolean hasFadeColor = false;
    private float fadeR;
    private float fadeG;
    private float fadeB;

    protected CustomExplodeParticle(ClientWorld world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteProvider sprites, boolean shortLifespan, int color1) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed);
        this.velocityX = xSpeed;
        this.velocityY = ySpeed;
        this.velocityZ = zSpeed;
        this.setBoundingBoxSpacing(0.5F, 0.5F);
        this.scale = (shortLifespan ? 1 : 0.8F) + world.random.nextFloat() * 0.3F;
        this.maxAge = shortLifespan ? 5 + world.random.nextInt(3) : 15 + world.random.nextInt(10);
        this.velocityMultiplier = 0.96F;
        float randCol = world.random.nextFloat() * 0.05F;
        this.sprites = sprites;
        this.setColor(Math.min(ColorHelper.Argb.getRed(color1) / 255F + randCol, 1), Math.min(1F, ColorHelper.Argb.getGreen(color1) / 255F + randCol), Math.min(1F, ColorHelper.Argb.getBlue(color1) / 255F + randCol));
    }

    public void setFadeColor(int i) {
        hasFadeColor = true;
        this.fadeR = (float) ((i & 16711680) >> 16) / 255.0F;
        this.fadeG = (float) ((i & '\uff00') >> 8) / 255.0F;
        this.fadeB = (float) ((i & 255)) / 255.0F;
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        this.setSpriteForAge(this.sprites);
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            if (hasFadeColor) {
                this.red += (fadeR - this.red) * 0.2F;
                this.green += (fadeG - this.green) * 0.2F;
                this.blue += (fadeB - this.blue) * 0.2F;
            } else {
                this.red = this.red * 0.95F;
                this.green = this.green * 0.95F;
                this.blue = this.blue * 0.95F;
            }
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            this.velocityX *= this.velocityMultiplier;
            this.velocityY *= this.velocityMultiplier;
            this.velocityZ *= this.velocityMultiplier;
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_LIT;
    }

    public float getSize(float scaleFactor) {
        return super.getSize(scaleFactor);
    }

    public int getBrightness(float partialTicks) {
        return 240;
    }


    public static class FlareFactory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteSet;

        public FlareFactory(SpriteProvider spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(DefaultParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            CustomExplodeParticle particle = new CustomExplodeParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, spriteSet, false, 0Xffffff);
            particle.setSpriteForAge(spriteSet);
            particle.scale(1.0F + worldIn.random.nextFloat() * 0.9F);
            particle.setFadeColor(0Xc35f03);
            return particle;
        }
    }

}
