package com.github.l_ender.cataclysm.client.particle;

import com.github.l_ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.l_ender.cataclysm.util.CMMathUtil;
import net.minecraft.client.particle.*;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.Quaternionf;
import org.joml.Vector3f;

/**
 * Created by BobMowzie on 6/2/2017.
 */
public class RingParticle extends SpriteBillboardParticle {
    public int r, g, b;
    public float opacity;
    public boolean facesCamera;
    public float yaw, pitch;
    public float size;
    private final SpriteProvider sprites;
    public int behavior;

    public enum EnumRingBehavior {
        SHRINK,
        GROW,
        CONSTANT,
        GROW_THEN_SHRINK
    }

    public RingParticle(ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ, float yaw, float pitch, int duration, int r, int g, int b, float opacity, float size, boolean facesCamera, int behavior, SpriteProvider sprites) {
        super(world, x, y, z);
        this.sprites = sprites;
        setBoundingBoxSpacing(1, 1);
        this.setSpriteForAge(this.sprites);
        this.size = size * 0.1f;
        maxAge = duration;
        alpha = 1;
        this.r = r;
        this.g = g;
        this.b = b;
        this.opacity = opacity;
        this.yaw = yaw;
        this.pitch = pitch;
        this.facesCamera = facesCamera;
        this.velocityX = motionX;
        this.velocityY = motionY;
        this.velocityZ = motionZ;
        this.behavior = behavior;
    }

    @Override
    public int getBrightness(float delta) {
        return 240 | super.getBrightness(delta) & 0xFF0000;
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteForAge(this.sprites);
        if (age >= maxAge) {
            markDead();
        }
        age++;
    }

    @Override
    public void buildGeometry(VertexConsumer buffer, Camera renderInfo, float partialTicks) {
        float var = (age + partialTicks)/maxAge;
        if (behavior == 0) {
            scale = size * var;
        }
        else if (behavior == 1) {
            scale = size * (1 - var);
        }
        else if (behavior == 2) {
            scale = (float) (size * (1 - var - Math.pow(2000, -var)));
        }
        else {
            scale = size;
        }
        alpha = opacity * 0.95f * (1 - (age + partialTicks)/maxAge) + 0.05f;
        red = r;
        green = g;
        blue = b;

        Vec3d Vector3d = renderInfo.getPos();
        float f = (float)(MathHelper.lerp(partialTicks, this.prevPosX, this.x) - Vector3d.getX());
        float f1 = (float)(MathHelper.lerp(partialTicks, this.prevPosY, this.y) - Vector3d.getY());
        float f2 = (float)(MathHelper.lerp(partialTicks, this.prevPosZ, this.z) - Vector3d.getZ());
        Quaternionf quaternionf = new Quaternionf(0.0F, 0.0F, 0.0F, 1.0F);
        if (facesCamera) {
            if (this.angle == 0.0F) {
                quaternionf = renderInfo.getRotation();
            } else {
                quaternionf = new Quaternionf(renderInfo.getRotation());
                float f3 = MathHelper.lerp(partialTicks, this.prevAngle, this.angle);
                quaternionf.mul(RotationAxis.POSITIVE_Z.rotation(f3));
            }
        }
        else {
            Quaternionf quatX = CMMathUtil.quatFromRotationXYZ(pitch, 0, 0, false);
            Quaternionf quatY = CMMathUtil.quatFromRotationXYZ(0, yaw, 0, false);
            quaternionf.mul(quatY);
            quaternionf.mul(quatX);
        }

        Vector3f vector3f1 = new Vector3f(-1.0F, -1.0F, 0.0F);
        quaternionf.transform(vector3f1);
        Vector3f[] avector3f = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};
        float f4 = this.getSize(partialTicks);

        for(int i = 0; i < 4; ++i) {
            Vector3f vector3f = avector3f[i];
            quaternionf.transform(vector3f);
            vector3f.mul(f4);
            vector3f.add(f, f1, f2);
        }

        float f7 = this.getMinU();
        float f8 = this.getMaxU();
        float f5 = this.getMinV();
        float f6 = this.getMaxV();
        int j = this.getBrightness(partialTicks);
        buffer.vertex(avector3f[0].x(), avector3f[0].y(), avector3f[0].z()).texture(f8, f6).color(this.red/255F, this.green/255F, this.blue/255F, this.alpha).light(j);
        buffer.vertex(avector3f[1].x(), avector3f[1].y(), avector3f[1].z()).texture(f8, f5).color(this.red/255F, this.green/255F, this.blue/255F, this.alpha).light(j);
        buffer.vertex(avector3f[2].x(), avector3f[2].y(), avector3f[2].z()).texture(f7, f5).color(this.red/255F, this.green/255F, this.blue/255F, this.alpha).light(j);
        buffer.vertex(avector3f[3].x(), avector3f[3].y(), avector3f[3].z()).texture(f7, f6).color(this.red/255F, this.green/255F, this.blue/255F, this.alpha).light(j);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }


    @Environment(EnvType.CLIENT)
    public static class RingFactory implements ParticleFactory<RingParticleOptions> {
        private final SpriteProvider spriteSet;

        public RingFactory(SpriteProvider sprite) {
            this.spriteSet = sprite;
        }

        public Particle createParticle(RingParticleOptions typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            RingParticle particle = new RingParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, typeIn.yaw(), typeIn.pitch(), typeIn.duration(), typeIn.r(), typeIn.g(), typeIn.b(), typeIn.a(), typeIn.scale(), typeIn.facesCamera(), typeIn.behavior(),spriteSet);
            return particle;
        }
    }

}
