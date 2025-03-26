package com.github.l_ender.cataclysm.client.particle;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class Shock_WaveParticle extends Particle {
    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/particle/em_pulse.png");
    private float size;
    private float prevSize;
    private float prevAlpha;
    private float alphaDecrease;


    private Shock_WaveParticle(ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z);
        this.setBoundingBoxSpacing(1, 0.1F);
        this.alpha = 1F;
        this.gravityStrength = 0.0F;
        this.velocityX = motionX;
        this.velocityY = motionY;
        this.velocityZ = motionZ;
        this.maxAge = 40 ;
        this.alphaDecrease = 1F / Math.max(this.maxAge, 1F);
        this.size = 0.1F;
    }

    public void tick(){
        super.tick();
        this.prevSize = size;
        this.prevAlpha = alpha;
        this.size += 0.4F;
        this.velocityX *= 0.1D;
        this.velocityY *= 0.8D;
        this.velocityZ *= 0.1D;
        if(this.alpha > 0.0F){
            this.alpha = Math.max(this.alpha - alphaDecrease, 0.0F);
        }
        this.setBoundingBoxSpacing(1 + size, 0.1F);
    }
    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float partialTick) {
        Vec3d vec3 = camera.getPos();
        float f = (float)(MathHelper.lerp(partialTick, this.prevPosX, this.x) - vec3.getX());
        float f1 = (float)(MathHelper.lerp(partialTick, this.prevPosY, this.y) - vec3.getY());
        float f2 = (float)(MathHelper.lerp(partialTick, this.prevPosZ, this.z) - vec3.getZ());
        Quaternionf quaternion = RotationAxis.POSITIVE_X.rotationDegrees(90F);
        VertexConsumerProvider.Immediate multibuffersource$buffersource = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
        VertexConsumer portalStatic = multibuffersource$buffersource.getBuffer(CMRenderTypes.getShockWave());
        MatrixStack posestack = new MatrixStack();
        MatrixStack.Entry posestack$pose = posestack.peek();
        Vector3f[] avector3f = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};
        float f4 = prevSize + partialTick * (size - prevSize);
        float alphaLerp = prevAlpha + partialTick * (alpha - prevAlpha);
        for(int i = 0; i < 4; ++i) {
            Vector3f vector3f = avector3f[i];
            vector3f.rotate(quaternion);
            vector3f.mul(f4);
            vector3f.add(f, f1, f2);
        }
        float f7 = 0;
        float f8 = 1;
        float f5 = 0;
        float f6 = 1;
        int j = 240;
        portalStatic.vertex(avector3f[0].x(), avector3f[0].y(), avector3f[0].z()).color(this.red, this.green, this.blue, alphaLerp).texture(f8, f6).overlay(OverlayTexture.DEFAULT_UV).light(j).normal(posestack$pose, 0.0F, -1.0F, 0.0F);
        portalStatic.vertex(avector3f[1].x(), avector3f[1].y(), avector3f[1].z()).color(this.red, this.green, this.blue, alphaLerp).texture(f8, f5).overlay(OverlayTexture.DEFAULT_UV).light(j).normal(posestack$pose, 0.0F, -1.0F, 0.0F);
        portalStatic.vertex(avector3f[2].x(), avector3f[2].y(), avector3f[2].z()).color(this.red, this.green, this.blue, alphaLerp).texture(f7, f5).overlay(OverlayTexture.DEFAULT_UV).light(j).normal(posestack$pose, 0.0F, -1.0F, 0.0F);
        portalStatic.vertex(avector3f[3].x(), avector3f[3].y(), avector3f[3].z()).color(this.red, this.green, this.blue, alphaLerp).texture(f7, f6).overlay(OverlayTexture.DEFAULT_UV).light(j).normal(posestack$pose, 0.0F, -1.0F, 0.0F);

        multibuffersource$buffersource.draw();
    }
    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.CUSTOM;
    }

    
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        public Particle createParticle(SimpleParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new Shock_WaveParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
        }
    }
}
