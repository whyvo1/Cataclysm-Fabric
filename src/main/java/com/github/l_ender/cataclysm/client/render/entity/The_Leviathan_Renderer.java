package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.The_Leviathan_Model;
import com.github.l_ender.cataclysm.client.model.entity.The_Leviathan_Tongue_Model;
import com.github.l_ender.cataclysm.client.model.entity.The_Leviathan_Tongue_End_Model;
import com.github.l_ender.cataclysm.client.render.RenderUtils;
import com.github.l_ender.cataclysm.client.render.layer.LayerBasicGlow;
import com.github.l_ender.cataclysm.client.render.layer.The_Leviathan_Layer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Part;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class The_Leviathan_Renderer extends MobEntityRenderer<The_Leviathan_Entity, The_Leviathan_Model> {

    private static final Identifier LEVIATHAN_TEXTURES = Cataclysm.modIdentifier("textures/entity/leviathan/the_leviathan.png");
    private static final Identifier BURNING_LEVIATHAN_TEXTURES = Cataclysm.modIdentifier("textures/entity/leviathan/the_burning_leviathan.png");
    private static final Identifier LEVIATHAN_TEXTURE_EYES = Cataclysm.modIdentifier("textures/entity/leviathan/the_leviathan_eye.png");
    private final Random rnd = Random.create();
    private static final The_Leviathan_Tongue_Model TONGUE_MODEL = new The_Leviathan_Tongue_Model();
    private static final The_Leviathan_Tongue_End_Model TONGUE_END_MODEL = new The_Leviathan_Tongue_End_Model();

    public The_Leviathan_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new The_Leviathan_Model(), 1.5F);
        this.addFeature(new The_Leviathan_Layer(this));
        this.addFeature(new LayerBasicGlow(this, LEVIATHAN_TEXTURE_EYES));
    }

    @Override
    public Identifier getTexture(The_Leviathan_Entity entity) {
        return  entity.getMeltDown() ? BURNING_LEVIATHAN_TEXTURES : LEVIATHAN_TEXTURES;
    }


    public boolean shouldRender(The_Leviathan_Entity livingentity, Frustum camera, double camX, double camY, double camZ) {
        if (super.shouldRender(livingentity, camera, camX, camY, camZ)) {
            return true;
        } else {
            for(The_Leviathan_Part part : livingentity.leviathanParts){
                if(camera.isVisible(part.getBoundingBox())){
                    return true;
                }
            }
            Entity weapon = livingentity.getTongue();
            if (weapon != null) {
                Vec3d vec3 = livingentity.getPos();
                Vec3d vec31 = weapon.getPos();
                return camera.isVisible(new Box(vec31.x, vec31.y, vec31.z, vec3.x, vec3.y, vec3.z));
            }
            return false;
        }
    }


    public Vec3d getRenderOffset(The_Leviathan_Entity entity, float partialTicks) {
        if (entity.getAnimation() == The_Leviathan_Entity.LEVIATHAN_ABYSS_BLAST && entity.getAnimationTick() <= 66) {
            double d0 = 0.01D;
            return new Vec3d(this.rnd.nextGaussian() * d0, 0.0D, this.rnd.nextGaussian() * d0);
        } else {
            return super.getPositionOffset(entity, partialTicks);
        }
    }

    @Override
    public void render(The_Leviathan_Entity entity, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        super.render(entity, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        if (entity.getAnimation() == The_Leviathan_Entity.LEVIATHAN_TAIL_WHIPS) {
            Vec3d bladePos = RenderUtils.matrixStackFromCitadelModel(entity, entityYaw, model.Tail_Particle);
            entity.setSocketPosArray(0, bladePos);
        }
        double x = MathHelper.lerp(partialTicks, entity.lastRenderX, entity.getX());
        double y = MathHelper.lerp(partialTicks, entity.lastRenderY, entity.getY());
        double z = MathHelper.lerp(partialTicks, entity.lastRenderZ, entity.getZ());
        float yaw = entity.prevBodyYaw + (entity.bodyYaw - entity.prevBodyYaw) * partialTicks;
        Entity weapon = entity.getTongue();
        if (weapon != null && entity.isAlive() && weapon.isAlive()) {
            matrixStackIn.push();
            matrixStackIn.translate(-x, -y, -z);
            Vec3d headModelPos = getModel().translateToTongue(new Vec3d(0, 0.0F, 0), yaw).multiply(0.2);
            Vec3d fromVec = entity.getTonguePosition().add(headModelPos);
            Vec3d toVec = weapon.getLerpedPos(partialTicks);

            int segmentCount = 0;
            Vec3d currentNeckButt = fromVec;
            VertexConsumer neckConsumer;

            neckConsumer = bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(LEVIATHAN_TEXTURES));


            double remainingDistance = toVec.distanceTo(fromVec);
            while (segmentCount < 128 && remainingDistance > 0) {
                remainingDistance = Math.min(fromVec.distanceTo(toVec), 0.5F);
                Vec3d linearVec = toVec.subtract(currentNeckButt);
                Vec3d powVec = new Vec3d(modifyVecAngle(linearVec.x), modifyVecAngle(linearVec.y), modifyVecAngle(linearVec.z));
                Vec3d smoothedVec = powVec;
                Vec3d next = smoothedVec.normalize().multiply(remainingDistance).add(currentNeckButt);
                int neckLight = getLightColor(entity, toVec.add(currentNeckButt).add(x, y, z));
                renderNeckCube(currentNeckButt, next, matrixStackIn, neckConsumer, neckLight, OverlayTexture.DEFAULT_UV, 0);
                currentNeckButt = next;
                segmentCount++;
            }

            VertexConsumer clawConsumer;

            clawConsumer = bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(LEVIATHAN_TEXTURES));

            matrixStackIn.push();
            matrixStackIn.translate(toVec.x, toVec.y, toVec.z);
            matrixStackIn.translate(0, -0.5F, 0);
            float rotY = (float) (MathHelper.atan2(toVec.x, toVec.z) * (double) (180F / (float) Math.PI));
            float rotX = (float) (-(MathHelper.atan2(toVec.y, toVec.horizontalLength()) * (double) (180F / (float) Math.PI)));
            TONGUE_END_MODEL.setAttributes(rotX, rotY);
            TONGUE_END_MODEL.render(matrixStackIn, clawConsumer, getLightColor(entity, toVec.add(x, y, z)), OverlayTexture.DEFAULT_UV, 1, 1F, 1, 1F);
            matrixStackIn.pop();
            matrixStackIn.pop();
        }
    }


    private double modifyVecAngle(double dimension) {
        float abs = (float) Math.abs(dimension);
        return Math.signum(dimension) * MathHelper.clamp(Math.pow(abs, 0.7), 0.005 * abs, abs);
    }


    public static void renderNeckCube(Vec3d from, Vec3d to, MatrixStack matrixStackIn, VertexConsumer buffer, int packedLightIn, int overlayCoords, float additionalYaw) {
        Vec3d sub = from.subtract(to);
        double d = sub.horizontalLength();
        float rotY = (float) (MathHelper.atan2(sub.x, sub.z) * (double) (180F / (float) Math.PI));
        float rotX = (float) (-(MathHelper.atan2(sub.y, d) * (double) (180F / (float) Math.PI))) - 90.0F;
        matrixStackIn.push();
        matrixStackIn.translate(from.x, from.y, from.z);
        matrixStackIn.translate(0, -0.5F, 0);
        TONGUE_MODEL.setAttributes((float) sub.length(), rotX, rotY, additionalYaw);
        TONGUE_MODEL.render(matrixStackIn, buffer, packedLightIn, overlayCoords, 1, 1F, 1, 1);
        matrixStackIn.pop();
    }

    private int getLightColor(Entity head, Vec3d vec3) {
        BlockPos blockpos = BlockPos.ofFloored(vec3);
        if(head.getWorld().isChunkLoaded(blockpos)){
            int i = WorldRenderer.getLightmapCoordinates(head.getWorld(), blockpos);
            int j = WorldRenderer.getLightmapCoordinates(head.getWorld(), blockpos.up());
            int k = i & 255;
            int l = j & 255;
            int i1 = i >> 16 & 255;
            int j1 = j >> 16 & 255;
            return (k > l ? k : l) | (i1 > j1 ? i1 : j1) << 16;
        }else{
            return 0;
        }
    }

    @Override
    protected void scale(The_Leviathan_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.75F, 1.75F, 1.75F);
    }

    @Override
    protected float getLyingAngle(The_Leviathan_Entity entity) {
        return 0;
    }

}

