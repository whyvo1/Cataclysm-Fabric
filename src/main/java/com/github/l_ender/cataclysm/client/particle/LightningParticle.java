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
import java.util.Random;

public class LightningParticle extends Particle {


    private int r ;
    private int g ;
    private int b ;
    private float toX;
    private float toY;
    private float toZ;
    private LightningRender lightningRender = new LightningRender();

    public LightningParticle(ClientWorld world, double x, double y, double z, float xSpeed, float ySpeed, float zSpeed, int r, int g, int b) {
        super(world, x, y, z);
        this.setBoundingBoxSpacing(1, 1);
        this.gravityStrength = 0.0F;
        this.maxAge = 5 + new Random().nextInt(3);
        this.toX = xSpeed;
        this.toY = ySpeed;
        this.toZ = zSpeed;
        this.r = r;
        this.g = g;
        this.b = b;

    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.CUSTOM;
    }

    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float partialTick) {
        Vec3d vec3 = camera.getPos();
        MatrixStack posestack = new MatrixStack();
        VertexConsumerProvider.Immediate multibuffersource$buffersource = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
        float f = (float)(MathHelper.lerp(partialTick, this.prevPosX, this.x) - vec3.getX());
        float f1 = (float)(MathHelper.lerp(partialTick, this.prevPosY, this.y) - vec3.getY());
        float f2 = (float)(MathHelper.lerp(partialTick, this.prevPosZ, this.z) - vec3.getZ());
        float lerpAge = this.age + partialTick;
        float ageProgress = lerpAge / (float) this.maxAge;
        float scale = 1.85F;
        posestack.push();
        posestack.translate(f, f1, f2);
        posestack.scale(scale, scale, scale);
        LightningBoltData.BoltRenderInfo lightningBoltData = new LightningBoltData.BoltRenderInfo(0.5F, 0.1F, 0.5F, 0.85F, new Vector4f((float) r /255, (float) g /255, (float) b /255, (1.0F - ageProgress) * 0.8F), 0.1F);
        LightningBoltData bolt = new LightningBoltData(lightningBoltData, Vec3d.ZERO, new Vec3d(toX, toY, toZ), 4)
                .size(0.05F)
                .lifespan(this.maxAge)
                .spawn(LightningBoltData.SpawnFunction.CONSECUTIVE);
        lightningRender.update(this, bolt, partialTick);
        lightningRender.render(partialTick, posestack, multibuffersource$buffersource);

        multibuffersource$buffersource.draw();
        posestack.pop();
    }



    @Environment(EnvType.CLIENT)
    public static final class OrbFactory implements ParticleFactory<OrbData> {

        @Override
        public Particle createParticle(OrbData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            LightningParticle particle;
            particle = new LightningParticle(worldIn, x, y, z, (float)xSpeed, (float)ySpeed, (float)zSpeed, typeIn.getR(), typeIn.getG(), typeIn.getB());

            return particle;
        }
    }

    public static class OrbData implements ParticleEffect {
        public static final Factory<OrbData> DESERIALIZER = new Factory<>() {
            public OrbData read(ParticleType<OrbData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                int r = reader.readInt();
                reader.expect(' ');
                int g = reader.readInt();
                reader.expect(' ');
                int b = reader.readInt();
                return new OrbData(r, g, b);
            }

            public OrbData read(ParticleType<OrbData> particleTypeIn, PacketByteBuf buffer) {
                return new OrbData(buffer.readInt(), buffer.readInt(), buffer.readInt());
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
        public ParticleType<OrbData> getType() {
            return ModParticle.LIGHTNING;
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


        public static Codec<OrbData> CODEC(ParticleType<OrbData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                    Codec.INT.fieldOf("r").forGetter(OrbData::getR),
                    Codec.INT.fieldOf("g").forGetter(OrbData::getG),
                    Codec.INT.fieldOf("b").forGetter(OrbData::getB)
                    ).apply(codecBuilder, OrbData::new)
            );
        }
    }
}
