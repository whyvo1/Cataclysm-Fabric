package com.github.l_ender.cataclysm.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class Phantom_Wing_FlameParticle extends AbstractSlowingParticle {
    private final SpriteProvider sprites;
    protected boolean isGlowing;

    Phantom_Wing_FlameParticle(ClientWorld p_107717_, double p_107718_, double p_107719_, double p_107720_, double p_107721_, double p_107722_, double p_107723_, SpriteProvider p_107724_) {
        super(p_107717_, p_107718_, p_107719_, p_107720_, p_107721_, p_107722_, p_107723_);
        this.sprites = p_107724_;
        this.scale(1.5F);
        this.setSpriteForAge(p_107724_);
    }

    public int getBrightness(float p_234080_) {
        return this.isGlowing ? 240 : super.getBrightness(p_234080_);
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public void tick() {
        super.tick();
        this.setSpriteForAge(this.sprites);
    }

    @Environment(EnvType.CLIENT)
    public static class EmissiveProvider implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprite;

        public EmissiveProvider(SpriteProvider p_234083_) {
            this.sprite = p_234083_;
        }

        public Particle createParticle(DefaultParticleType p_234094_, ClientWorld p_234095_, double p_234096_, double p_234097_, double p_234098_, double p_234099_, double p_234100_, double p_234101_) {
            Phantom_Wing_FlameParticle Phantom_Wing_FlameParticle = new Phantom_Wing_FlameParticle(p_234095_, p_234096_, p_234097_, p_234098_, p_234099_, p_234100_, p_234101_, this.sprite);
            Phantom_Wing_FlameParticle.setAlpha(1.0F);
            Phantom_Wing_FlameParticle.isGlowing = true;
            return Phantom_Wing_FlameParticle;
        }
    }

    @Environment(EnvType.CLIENT)
    public static class Provider implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprite;

        public Provider(SpriteProvider p_107739_) {
            this.sprite = p_107739_;
        }

        public Particle createParticle(DefaultParticleType p_107750_, ClientWorld p_107751_, double p_107752_, double p_107753_, double p_107754_, double p_107755_, double p_107756_, double p_107757_) {
            Phantom_Wing_FlameParticle Phantom_Wing_FlameParticle = new Phantom_Wing_FlameParticle(p_107751_, p_107752_, p_107753_, p_107754_, p_107755_, p_107756_, p_107757_, this.sprite);
            Phantom_Wing_FlameParticle.setAlpha(1.0F);
            return Phantom_Wing_FlameParticle;
        }
    }
}
