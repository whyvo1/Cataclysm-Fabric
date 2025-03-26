package com.github.l_ender.cataclysm.client.particle;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.init.ModParticle;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.Locale;

public class LightTrailParticle extends AbstractLightTrailParticle {
    private static final Identifier TRAIL_TEXTURE = Cataclysm.modIdentifier("textures/particle/storm.png");

    private final int EntityId;
    private final float width;
    private final float height;
    private final float initialYRot;
    private final float rotateByAge;

    public LightTrailParticle(ClientWorld world, double x, double y, double z, float r, float g, float b, float width, float height, int EntityId) {
        super(world, x, y, z, 0, 0, 0,r,g,b);
        this.EntityId = EntityId;
        this.gravityStrength = 0;
        this.maxAge = 20 + this.random.nextInt(20);
        initialYRot = random.nextFloat() * 360F;
        rotateByAge = (10 + random.nextFloat() * 10F) * (random.nextBoolean() ? -1F : 1F);
        this.width = width;
        this.height = height;
        Vec3d vec3 = getOrbitPosition();
        this.x = this.prevPosX = vec3.x;
        this.y = this.prevPosY = vec3.y;
        this.z = this.prevPosZ = vec3.z;
        this.velocityX = 0;
        this.velocityY = 0;
        this.velocityZ = 0;
    }

    public Vec3d getEntityPosition(){
        Entity from = this.getFromEntity();
        if(from != null){
            return from.getPos();
        }
        return new Vec3d(this.x, this.y, this.z);
    }


    public Entity getFromEntity() {
        return EntityId == -1 ? null : world.getEntityById(EntityId);
    }

    public Vec3d getOrbitPosition(){
        Vec3d dinoPos = getEntityPosition();
        Vec3d vec3 = new Vec3d(0, height, width).rotateY((float)Math.toRadians(initialYRot + rotateByAge * age));
        return dinoPos.add(vec3);
    }

    public void tick() {
        super.tick();
        this.trailA = 1F - age / (float) maxAge;
        Vec3d vec3 = getOrbitPosition();
        this.x = vec3.x;
        this.y = vec3.y;
        this.z = vec3.z;

        Entity from = this.getFromEntity();
        if(from == null){
            markDead();
        }

    }

    public int sampleCount() {
        return 4;
    }

    public int sampleStep() {
        return 1;
    }

    @Override
    public float getTrailHeight() {
        return 0.5F;
    }

    public int getBrightness(float f) {
        return 240;
    }

    @Override
    public Identifier getTrailTexture() {
        return TRAIL_TEXTURE;
    }

    @Environment(EnvType.CLIENT)
    public static final class OrbFactory implements ParticleFactory<LightTrailParticle.OrbData> {

        @Override
        public Particle createParticle(LightTrailParticle.OrbData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            LightTrailParticle particle;
            particle = new LightTrailParticle(worldIn, x, y, z, typeIn.getR(), typeIn.getG(), typeIn.getB(), typeIn.getWidth(), typeIn.getHeight(),typeIn.getentityid());

            return particle;
        }
    }


    public static class OrbData implements ParticleEffect {
        public static final Factory<LightTrailParticle.OrbData> DESERIALIZER = new Factory<>() {
            public LightTrailParticle.OrbData read(ParticleType<LightTrailParticle.OrbData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                float r = reader.readFloat();
                reader.expect(' ');
                float g = reader.readFloat();
                reader.expect(' ');
                float b = reader.readFloat();
                reader.expect(' ');
                float width = reader.readFloat();
                reader.expect(' ');
                float height = reader.readFloat();
                reader.expect(' ');
                int EntityId = reader.readInt();
                return new LightTrailParticle.OrbData(r, g, b, width, height, EntityId);
            }

            public LightTrailParticle.OrbData read(ParticleType<LightTrailParticle.OrbData> particleTypeIn, PacketByteBuf buffer) {
                return new LightTrailParticle.OrbData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readInt());
            }
        };

        private final float r;
        private final float g;
        private final float b;
        private final float width;
        private final float height;
        private final int entityid;

        public OrbData(float r, float g, float b,float width, float height, int entityid) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.width = width;
            this.height = height;
            this.entityid = entityid;
        }

        @Override
        public void write(PacketByteBuf buffer) {
            buffer.writeFloat(this.r);
            buffer.writeFloat(this.g);
            buffer.writeFloat(this.b);
            buffer.writeFloat(this.width);
            buffer.writeFloat(this.height);
            buffer.writeInt(this.entityid);
        }

        @Override
        public String asString() {
            return String.format(Locale.ROOT, "%s %.2f %.2f %.2f %.2f %.2f %d", Registries.PARTICLE_TYPE.getId(this.getType()),
                    this.r, this.g, this.b,this.width,this.height,this.entityid);
        }

        @Override
        public ParticleType<LightTrailParticle.OrbData> getType() {
            return ModParticle.LIGHT_TRAIL;
        }

        @Environment(EnvType.CLIENT)
        public float getR() {
            return this.r;
        }

        @Environment(EnvType.CLIENT)
        public float getG() {
            return this.g;
        }

        @Environment(EnvType.CLIENT)
        public float getB() {
            return this.b;
        }

        @Environment(EnvType.CLIENT)
        public float getWidth() {
            return this.width;
        }

        @Environment(EnvType.CLIENT)
        public float getHeight() {
            return this.height;
        }

        @Environment(EnvType.CLIENT)
        public int getentityid() {
            return this.entityid;
        }

        public static Codec<LightTrailParticle.OrbData> CODEC(ParticleType<LightTrailParticle.OrbData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                    Codec.FLOAT.fieldOf("r").forGetter(LightTrailParticle.OrbData::getR),
                    Codec.FLOAT.fieldOf("g").forGetter(LightTrailParticle.OrbData::getG),
                    Codec.FLOAT.fieldOf("b").forGetter(LightTrailParticle.OrbData::getB),
                    Codec.FLOAT.fieldOf("width").forGetter(LightTrailParticle.OrbData::getWidth),
                    Codec.FLOAT.fieldOf("height").forGetter(LightTrailParticle.OrbData::getHeight),
                    Codec.INT.fieldOf("entityid").forGetter(LightTrailParticle.OrbData::getentityid)
                    ).apply(codecBuilder, LightTrailParticle.OrbData::new)
            );
        }
    }

}
