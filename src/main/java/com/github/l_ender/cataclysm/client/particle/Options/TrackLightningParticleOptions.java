package com.github.l_ender.cataclysm.client.particle.Options;

import com.github.l_ender.cataclysm.init.ModParticle;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import org.jetbrains.annotations.NotNull;

public record TrackLightningParticleOptions(int r, int g, int b) implements ParticleEffect {
    //For networking. Encoder/Decoder functions very intuitive
    public static PacketCodec<? super ByteBuf, TrackLightningParticleOptions> STREAM_CODEC = PacketCodec.ofStatic(
            (buf, option) -> {
                buf.writeFloat(option.r);
                buf.writeFloat(option.g);
                buf.writeFloat(option.b);
            },
            (buf) -> {
                return new TrackLightningParticleOptions(buf.readInt(), buf.readInt(), buf.readInt());
            }
    );

    //For command only?
    public static MapCodec<TrackLightningParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.INT.fieldOf("r").forGetter(p -> p.r),
                    Codec.INT.fieldOf("g").forGetter(p -> p.g),
                    Codec.INT.fieldOf("b").forGetter(p -> p.b)
            ).apply(object, TrackLightningParticleOptions::new
            ));

    public @NotNull ParticleType<TrackLightningParticleOptions> getType() {
        return ModParticle.TRACK_LIGHTNING;
    }
}
