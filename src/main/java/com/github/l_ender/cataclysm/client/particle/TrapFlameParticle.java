package com.github.l_ender.cataclysm.client.particle;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;


public class TrapFlameParticle extends SpriteBillboardParticle {

    private final SpriteProvider sprites;

    private float prevAlpha = 0.0F;


    protected TrapFlameParticle(ClientWorld world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteProvider spriteSet) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed);
        this.sprites = spriteSet;
        this.setSpriteForAge(this.sprites);
        this.velocityX = xSpeed;
        this.velocityY = ySpeed;
        this.velocityZ = zSpeed;
        this.scale = 0.4F + world.random.nextFloat() * 0.25F;
        this.maxAge = 10 + world.random.nextInt(20);
        this.velocityMultiplier = 0.99F;
    }

    public void tick() {
        this.setSpriteForAge(this.sprites);
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        float ageProgress = this.age / (float) maxAge;
        float f = ageProgress - 0.5F;
        float scale = 1.0F + ageProgress * 0.5F;
        float f1 = 1.0F - f * 2F;
        if (ageProgress > 0.5F) {
            prevAlpha = alpha;
            this.setAlpha(prevAlpha + (f1 - prevAlpha) * MinecraftClient.getInstance().getRenderTickCounter().getTickDelta(false));
        }
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            this.scale(scale);
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            this.velocityX *= this.velocityMultiplier;
            this.velocityY *= this.velocityMultiplier;
            this.velocityZ *= this.velocityMultiplier;
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public int getBrightness(float partialTicks) {
        return 240;
    }

    public Particle scale(float p_107683_) {
        this.scale = p_107683_;
        return this;
    }


    
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteSet;

        public Factory(SpriteProvider spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            TrapFlameParticle particle = new TrapFlameParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, spriteSet);
            return particle;
        }
    }

}