package com.github.l_ender.cataclysm.init;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.particle.*;
import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModParticle {
//    public static final DeferredRegister<ParticleType<?>> PARTICLE = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Cataclysm.MODID);

    public static final DefaultParticleType SOUL_LAVA = registerParticleType("soul_lava", FabricParticleTypes.simple(false));

    public static final DefaultParticleType SANDSTORM = registerParticleType("sandstorm", FabricParticleTypes.simple(false));

    public static final ParticleType<LightningParticle.OrbData> LIGHTNING = registerParticleType("lightning", new ParticleType<>(false, LightningParticle.OrbData.DESERIALIZER) {
        @Override
        public Codec<LightningParticle.OrbData> getCodec() {
            return LightningParticle.OrbData.CODEC(LIGHTNING);
        }
    });

    public static final ParticleType<StormParticle.OrbData> STORM = registerParticleType("storm", new ParticleType<>(false, StormParticle.OrbData.DESERIALIZER) {
        @Override
        public Codec<StormParticle.OrbData> getCodec() {
            return StormParticle.OrbData.CODEC(STORM);
        }
    });

    public static final ParticleType<LightTrailParticle.OrbData> LIGHT_TRAIL = registerParticleType("light_trail", new ParticleType<>(false, LightTrailParticle.OrbData.DESERIALIZER) {
        @Override
        public Codec<LightTrailParticle.OrbData> getCodec() {
            return LightTrailParticle.OrbData.CODEC(LIGHT_TRAIL);
        }
    });

    public static final ParticleType<TrackLightningParticle.OrbData> TRACK_LIGHTNING = registerParticleType("track_lightning", new ParticleType<>(false, TrackLightningParticle.OrbData.DESERIALIZER) {
        @Override
        public Codec<TrackLightningParticle.OrbData> getCodec() {
            return TrackLightningParticle.OrbData.CODEC(TRACK_LIGHTNING);
        }
    });
    public static final ParticleType<RingParticle.RingData> RING = registerParticleType("ring_0", new ParticleType<>(false, RingParticle.RingData.DESERIALIZER) {
        @Override
        public Codec<RingParticle.RingData> getCodec() {
            return RingParticle.RingData.CODEC(RING);
        }
    });

    public static final DefaultParticleType CURSED_FLAME = registerParticleType("cursed_flame", FabricParticleTypes.simple(false));

    public static final DefaultParticleType SMALL_CURSED_FLAME = registerParticleType("small_cursed_flame", FabricParticleTypes.simple(false));

    public static final DefaultParticleType PHANTOM_WING_FLAME = registerParticleType("phantom_wing_flame", FabricParticleTypes.simple(false));

    public static final DefaultParticleType EM_PULSE = registerParticleType("em_pulse", FabricParticleTypes.simple(false));

    public static final DefaultParticleType SHOCK_WAVE = registerParticleType("shock_wave", FabricParticleTypes.simple(false));

    public static final DefaultParticleType TRAP_FLAME = registerParticleType("trap_flame", FabricParticleTypes.simple(false));


    public static final DefaultParticleType FLAME_JET = registerParticleType("flame_jet", FabricParticleTypes.simple(false));

    public static final DefaultParticleType FLARE_EXPLODE = registerParticleType("flare_explode", FabricParticleTypes.simple(false));

    private static <T extends ParticleType<?>> T registerParticleType(String id, T particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Cataclysm.modIdentifier(id), particleType);
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering particles for " + Cataclysm.MOD_ID);
    }

}
