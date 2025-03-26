package com.github.l_ender.cataclysm.client.particle;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.particle.Options.LightTrailParticleOptions;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

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
        float fade = 1F - age / (float) maxAge;
        this.trailA = 1F * fade;
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
    public static class Factory implements ParticleFactory<LightTrailParticleOptions> {

        @Override
        public Particle createParticle(LightTrailParticleOptions data, ClientWorld level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {

            LightTrailParticle particle;
            particle = new LightTrailParticle(level, x, y, z, data.r(),data.g(),data.b(), data.width(), data.height(),data.entityid());
            return particle;
        }
    }
}
