package com.github.l_ender.cataclysm.init;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.particle.Options.*;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModParticle {

    public static final SimpleParticleType SPARK = registerParticleType("spark", FabricParticleTypes.simple(false));


    public static final SimpleParticleType SOUL_LAVA = registerParticleType("soul_lava", FabricParticleTypes.simple(false));

    public static final SimpleParticleType SANDSTORM = registerParticleType("sandstorm", FabricParticleTypes.simple(false));

    public static final ParticleType<LightningParticleOptions> LIGHTNING = registerParticleType("lightning", new ParticleType<>(false)  {
        @Override
        public MapCodec<LightningParticleOptions> getCodec() {
            return LightningParticleOptions.MAP_CODEC;
        }
        public PacketCodec<? super RegistryByteBuf, LightningParticleOptions> getPacketCodec() {
            return LightningParticleOptions.STREAM_CODEC;
        }
    });

    public static final ParticleType<SparkTrailParticleOptions> SPARK_TRAIL = registerParticleType("spark_trail", new ParticleType<>(false)  {
        @Override
        public MapCodec<SparkTrailParticleOptions> getCodec() {
            return SparkTrailParticleOptions.MAP_CODEC;
        }
        public PacketCodec<? super RegistryByteBuf, SparkTrailParticleOptions> getPacketCodec() {
            return SparkTrailParticleOptions.STREAM_CODEC;
        }
    });


    public static final ParticleType<StormParticleOptions> STORM = registerParticleType("storm", new ParticleType<>(false) {
        @Override
        public MapCodec<StormParticleOptions> getCodec() {
            return StormParticleOptions.MAP_CODEC;
        }
        public PacketCodec<? super RegistryByteBuf, StormParticleOptions> getPacketCodec() {
            return StormParticleOptions.STREAM_CODEC;
        }
    });


    public static final ParticleType<LightTrailParticleOptions> LIGHT_TRAIL = registerParticleType("light_trail", new ParticleType<>(false) {
        @Override
        public MapCodec<LightTrailParticleOptions> getCodec() {
            return LightTrailParticleOptions.MAP_CODEC;
        }
        public PacketCodec<? super RegistryByteBuf, LightTrailParticleOptions> getPacketCodec() {
            return LightTrailParticleOptions.STREAM_CODEC;
        }
    });


    public static final ParticleType<TrackLightningParticleOptions> TRACK_LIGHTNING = registerParticleType("track_lightning", new ParticleType<>(false)  {
        @Override
        public MapCodec<TrackLightningParticleOptions> getCodec() {
            return TrackLightningParticleOptions.MAP_CODEC;
        }
        public PacketCodec<? super RegistryByteBuf, TrackLightningParticleOptions> getPacketCodec() {
            return TrackLightningParticleOptions.STREAM_CODEC;
        }
    });

    public static final ParticleType<RingParticleOptions> RING = registerParticleType("ring_0", new ParticleType<>(false)  {
        @Override
        public MapCodec<RingParticleOptions> getCodec() {
            return RingParticleOptions.MAP_CODEC;
        }
        public PacketCodec<? super RegistryByteBuf, RingParticleOptions> getPacketCodec() {
            return RingParticleOptions.STREAM_CODEC;
        }
    });




    public static final SimpleParticleType CURSED_FLAME = registerParticleType("cursed_flame", FabricParticleTypes.simple(false));

    public static final SimpleParticleType SMALL_CURSED_FLAME = registerParticleType("small_cursed_flame", FabricParticleTypes.simple(false));

    public static final SimpleParticleType PHANTOM_WING_FLAME = registerParticleType("phantom_wing_flame", FabricParticleTypes.simple(false));

    public static final SimpleParticleType EM_PULSE = registerParticleType("em_pulse", FabricParticleTypes.simple(false));

    public static final SimpleParticleType SHOCK_WAVE = registerParticleType("shock_wave", FabricParticleTypes.simple(false));

    public static final SimpleParticleType TRAP_FLAME = registerParticleType("trap_flame", FabricParticleTypes.simple(false));


    public static final SimpleParticleType FLAME_JET = registerParticleType("flame_jet", FabricParticleTypes.simple(false));

    public static final SimpleParticleType FLARE_EXPLODE = registerParticleType("flare_explode", FabricParticleTypes.simple(false));

    private static <T extends ParticleType<?>> T registerParticleType(String id, T particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Cataclysm.modIdentifier(id), particleType);
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering particles for " + Cataclysm.MOD_ID);
    }
}
