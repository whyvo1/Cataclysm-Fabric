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

public record LightTrailParticleOptions(float r, float g, float b, float width, float height, int entityid)  implements ParticleEffect {

    //For networking. Encoder/Decoder functions very intuitive
    public static PacketCodec<? super ByteBuf, LightTrailParticleOptions> STREAM_CODEC = PacketCodec.ofStatic(
            (buf, option) -> {
                buf.writeFloat(option.r);
                buf.writeFloat(option.g);
                buf.writeFloat(option.b);
                buf.writeFloat(option.width);
                buf.writeFloat(option.height);
                buf.writeInt(option.entityid);
            },
            (buf) -> {
                return new LightTrailParticleOptions(buf.readInt(), buf.readInt(), buf.readInt(),buf.readFloat(), buf.readFloat(),buf.readInt());
            }
    );



    //For command only?
    public static MapCodec<LightTrailParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.FLOAT.fieldOf("r").forGetter(p -> p.r),
                    Codec.FLOAT.fieldOf("g").forGetter(p -> p.g),
                    Codec.FLOAT.fieldOf("b").forGetter(p -> p.b),
                    Codec.FLOAT.fieldOf("width").forGetter(p -> p.width),
                    Codec.FLOAT.fieldOf("height").forGetter(p -> p.height),
                    Codec.INT.fieldOf("entityid").forGetter(p -> p.entityid)
            ).apply(object, LightTrailParticleOptions::new
            ));

    public @NotNull ParticleType<LightTrailParticleOptions> getType() {
        return ModParticle.LIGHT_TRAIL;
    }
}
