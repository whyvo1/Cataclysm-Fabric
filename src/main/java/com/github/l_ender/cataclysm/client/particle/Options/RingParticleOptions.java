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

public record RingParticleOptions(float yaw, float pitch, int duration, int r, int g, int b, float a, float scale, boolean facesCamera, int behavior) implements ParticleEffect {

    //For networking. Encoder/Decoder functions very intuitive
    public static PacketCodec<? super ByteBuf, RingParticleOptions> STREAM_CODEC = PacketCodec.ofStatic(
            (buf, option) -> {
                buf.writeFloat(option.yaw);
                buf.writeFloat(option.pitch);
                buf.writeInt(option.duration);
                buf.writeInt(option.r);
                buf.writeInt(option.g);
                buf.writeInt(option.b);
                buf.writeFloat(option.a);
                buf.writeFloat(option.scale);
                buf.writeBoolean(option.facesCamera);
                buf.writeInt(option.behavior);
            },
            (buf) -> {
                return new RingParticleOptions(buf.readFloat(), buf.readFloat(),buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readFloat(), buf.readFloat() ,buf.readBoolean() ,buf.readInt());
            }
    );

    //For command only?
    public static MapCodec<RingParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.FLOAT.fieldOf("yaw").forGetter(p -> p.yaw),
                    Codec.FLOAT.fieldOf("pitch").forGetter(p -> p.pitch),
                    Codec.INT.fieldOf("duration").forGetter(p -> p.duration),
                    Codec.INT.fieldOf("r").forGetter(p -> p.r),
                    Codec.INT.fieldOf("g").forGetter(p -> p.g),
                    Codec.INT.fieldOf("b").forGetter(p -> p.b),
                    Codec.FLOAT.fieldOf("a").forGetter(p -> p.a),
                    Codec.FLOAT.fieldOf("scale").forGetter(p -> p.scale),
                    Codec.BOOL.fieldOf("facescamera").forGetter(p -> p.facesCamera),
                    Codec.INT.fieldOf("behavior").forGetter(p -> p.behavior)
            ).apply(object, RingParticleOptions::new
            ));

    public @NotNull ParticleType<RingParticleOptions> getType() {
        return ModParticle.RING;
    }
}
