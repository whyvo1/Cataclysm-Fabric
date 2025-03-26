package com.github.l_ender.cataclysm.client.particle;

import com.github.l_ender.cataclysm.client.render.etc.LightningBoltData;
import com.github.l_ender.cataclysm.client.render.etc.LightningRender;
import com.github.l_ender.cataclysm.init.ModParticle;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.Vector4f;

import java.util.Locale;

public class TrackLightningParticle extends Particle {
    private int r ;
    private int g ;
    private int b ;
    private LightningRender lightningRender = new LightningRender();

    public TrackLightningParticle(ClientWorld world, double x, double y, double z, double xd, double yd, double zd, int r, int g, int b) {
        super(world, x, y, z);
        this.setBoundingBoxSpacing(6.0F, 6.0F);
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
        this.g = g;
        this.b = b;
        Vec3d lightningTo = new Vec3d(xd - x, yd - y, zd - z);
        this.maxAge = 5;
        int sections = 1 + (int) (9 * lightningTo.length());
        LightningBoltData.BoltRenderInfo boltData = new LightningBoltData.BoltRenderInfo(0.5F, 0.1F, 0.5F, 0.85F, new Vector4f((float) r /255, (float) g /255, (float) b /255, 0.8F), 0.1F);
        LightningBoltData bolt = new LightningBoltData(boltData, Vec3d.ZERO, lightningTo, sections)
                .size(0.1F + random.nextFloat() * 0.1F)
                .lifespan(this.maxAge)
                .spawn(LightningBoltData.SpawnFunction.CONSECUTIVE);
        lightningRender.update(this, bolt, 1.0F);
    }

    public boolean shouldCull() {
        return false;
    }


    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        this.velocityX = 0;
        this.velocityY = 0;
        this.velocityZ = 0;
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            this.velocityY -= this.gravityStrength;
        }
    }


    public void buildGeometry(VertexConsumer consumer, Camera camera, float partialTick) {
        VertexConsumerProvider.Immediate multibuffersource$buffersource = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
        Vec3d cameraPos = camera.getPos();
        float x = (float) (MathHelper.lerp(partialTick, this.prevPosX, this.x));
        float y = (float) (MathHelper.lerp(partialTick, this.prevPosY, this.y));
        float z = (float) (MathHelper.lerp(partialTick, this.prevPosZ, this.z));
        MatrixStack posestack = new MatrixStack();
        posestack.push();
        posestack.translate(-cameraPos.x, -cameraPos.y, -cameraPos.z);
        posestack.translate(x, y, z);
        lightningRender.render(partialTick, posestack, multibuffersource$buffersource);
        multibuffersource$buffersource.draw();
        posestack.pop();
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.CUSTOM;
    }

    @Environment(EnvType.CLIENT)
    public static final class OrbFactory implements ParticleFactory<TrackLightningParticle.OrbData> {

        @Override
        public Particle createParticle(TrackLightningParticle.OrbData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            TrackLightningParticle particle;
            particle = new TrackLightningParticle(worldIn, x, y, z, (float)xSpeed, (float)ySpeed, (float)zSpeed, typeIn.getR(), typeIn.getG(), typeIn.getB());

            return particle;
        }
    }

    public static class OrbData implements ParticleEffect {
        public static final Factory<TrackLightningParticle.OrbData> DESERIALIZER = new Factory<>() {
            public TrackLightningParticle.OrbData read(ParticleType<TrackLightningParticle.OrbData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                int r = reader.readInt();
                reader.expect(' ');
                int g = reader.readInt();
                reader.expect(' ');
                int b = reader.readInt();
                return new TrackLightningParticle.OrbData(r, g, b);
            }

            public TrackLightningParticle.OrbData read(ParticleType<TrackLightningParticle.OrbData> particleTypeIn, PacketByteBuf buffer) {
                return new TrackLightningParticle.OrbData(buffer.readInt(), buffer.readInt(), buffer.readInt());
            }
        };

        private final int r;
        private final int g;
        private final int b;



        public OrbData(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;


        }

        @Override
        public void write(PacketByteBuf buffer) {
            buffer.writeInt(this.r);
            buffer.writeInt(this.g);
            buffer.writeInt(this.b);
        }

        @Override
        public String asString() {
            return String.format(Locale.ROOT, "%s %d %d %d", Registries.PARTICLE_TYPE.getId(this.getType()),
                    this.r, this.g, this.b);
        }

        @Override
        public ParticleType<TrackLightningParticle.OrbData> getType() {
            return ModParticle.TRACK_LIGHTNING;
        }

        @Environment(EnvType.CLIENT)
        public int getR() {
            return this.r;
        }

        @Environment(EnvType.CLIENT)
        public int getG() {
            return this.g;
        }

        @Environment(EnvType.CLIENT)
        public int getB() {
            return this.b;
        }


        public static Codec<TrackLightningParticle.OrbData> CODEC(ParticleType<TrackLightningParticle.OrbData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                            Codec.INT.fieldOf("r").forGetter(TrackLightningParticle.OrbData::getR),
                            Codec.INT.fieldOf("g").forGetter(TrackLightningParticle.OrbData::getG),
                            Codec.INT.fieldOf("b").forGetter(TrackLightningParticle.OrbData::getB)
                    ).apply(codecBuilder, TrackLightningParticle.OrbData::new)
            );
        }
    }
}
