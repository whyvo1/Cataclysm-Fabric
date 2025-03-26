package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Tidal_Tentacle_Model;
import com.github.l_ender.cataclysm.client.model.entity.Tidal_Tentacle_Claws_Model;
import com.github.l_ender.cataclysm.entity.projectile.Tidal_Tentacle_Entity;
import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class Tidal_Tentacle_Renderer extends EntityRenderer<Tidal_Tentacle_Entity> {

    private static final Identifier CLAW_TEXTURE = Cataclysm.modIdentifier("textures/entity/tidal_tentacle_claws.png");

    private static final Identifier TENTACLE_TEXTURE = Cataclysm.modIdentifier("textures/entity/tidal_tentacle.png");

    private static final Tidal_Tentacle_Claws_Model CLAW_MODEL = new Tidal_Tentacle_Claws_Model();
    private static final Tidal_Tentacle_Model TONGUE_MODEL = new Tidal_Tentacle_Model();
    public static final int MAX_NECK_SEGMENTS = 128;
    public Tidal_Tentacle_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public boolean shouldRender(Tidal_Tentacle_Entity entity, Frustum frustum, double x, double y, double z) {
        Entity next = entity.getFromEntity();
        return next != null && frustum.isVisible(entity.getBoundingBox().union(next.getBoundingBox())) || super.shouldRender(entity, frustum, x, y, z);
    }

    @Override
    public void render(Tidal_Tentacle_Entity entity, float yaw, float partialTicks, MatrixStack poseStack, VertexConsumerProvider buffer, int light) {
        super.render(entity, yaw, partialTicks, poseStack, buffer, light);
        poseStack.push();
        Entity fromEntity = entity.getFromEntity();
        float x = (float)MathHelper.lerp(partialTicks, entity.prevX, entity.getX());
        float y = (float)MathHelper.lerp(partialTicks, entity.prevY, entity.getY());
        float z = (float)MathHelper.lerp(partialTicks, entity.prevZ, entity.getZ());

        if (fromEntity != null) {
            float progress = (entity.prevProgress + (entity.getProgress() - entity.prevProgress) * partialTicks) / Tidal_Tentacle_Entity.MAX_EXTEND_TIME;
            Vec3d distVec = getPositionOfPriorMob(entity, fromEntity, partialTicks).subtract(x, y, z);
            Vec3d to = distVec.multiply(1F - progress);
            Vec3d from = distVec;
            int segmentCount = 0;
            Vec3d currentNeckButt = from;
            VertexConsumer neckConsumer = buffer.getBuffer(RenderLayer.getEntityCutoutNoCull(TENTACLE_TEXTURE));
            double remainingDistance = to.distanceTo(from);
            while (segmentCount < MAX_NECK_SEGMENTS && remainingDistance > 0) {
                remainingDistance = Math.min(from.distanceTo(to), 0.5F);
                Vec3d linearVec = to.subtract(currentNeckButt);
                Vec3d powVec = new Vec3d(modifyVecAngle(linearVec.x), modifyVecAngle(linearVec.y), modifyVecAngle(linearVec.z));
                Vec3d smoothedVec = powVec;
                Vec3d next = smoothedVec.normalize().multiply(remainingDistance).add(currentNeckButt);
                int neckLight = getLightColor(entity, to.add(currentNeckButt).add(x, y, z));
                renderNeckCube(currentNeckButt, next, poseStack, neckConsumer, neckLight, OverlayTexture.DEFAULT_UV, 0);
                currentNeckButt = next;
                segmentCount++;
            }
            VertexConsumer clawConsumer  = buffer.getBuffer(RenderLayer.getEntityCutoutNoCull(CLAW_TEXTURE));
            if(entity.hasClaw() || entity.isRetracting()){
                poseStack.push();
                poseStack.translate(to.x, to.y, to.z);
                float rotY = (float) (MathHelper.atan2(to.x, to.z) * (double) (180F / (float) Math.PI));
                float rotX = (float) (-(MathHelper.atan2(to.y, to.horizontalLength()) * (double) (180F / (float) Math.PI)));
                CLAW_MODEL.setAttributes(rotX, rotY);
                CLAW_MODEL.render(poseStack, clawConsumer, getLightColor(entity, to.add(x, y, z)), OverlayTexture.DEFAULT_UV);
                poseStack.pop();
            }
        }
        poseStack.pop();
    }

    public static void renderNeckCube(Vec3d from, Vec3d to, MatrixStack poseStack, VertexConsumer buffer, int packedLightIn, int overlayCoords, float additionalYaw) {
        Vec3d sub = from.subtract(to);
        double d = sub.horizontalLength();
        float rotY = (float) (MathHelper.atan2(sub.x, sub.z) * (double) (180F / (float) Math.PI));
        float rotX = (float) (-(MathHelper.atan2(sub.y, d) * (double) (180F / (float) Math.PI))) - 90.0F;
        poseStack.push();
        poseStack.translate(from.x, from.y, from.z);
        TONGUE_MODEL.setAttributes((float) sub.length(), rotX, rotY, additionalYaw);
        TONGUE_MODEL.render(poseStack, buffer, packedLightIn, overlayCoords);
        poseStack.pop();
    }

    private Vec3d getPositionOfPriorMob(Tidal_Tentacle_Entity segment, Entity mob, float partialTicks){
        double d4 = MathHelper.lerp(partialTicks, mob.prevX, mob.getX());
        double d5 = MathHelper.lerp(partialTicks, mob.prevY, mob.getY());
        double d6 = MathHelper.lerp(partialTicks, mob.prevZ, mob.getZ());
        float f3 = 0;
        if(mob instanceof PlayerEntity && segment.isCreator(mob)){
            PlayerEntity player = (PlayerEntity) mob;
            float f = player.getHandSwingProgress(partialTicks);
            float f1 = MathHelper.sin(MathHelper.sqrt(f) * (float) Math.PI);
            float f2 = MathHelper.lerp(partialTicks, player.prevBodyYaw, player.bodyYaw) * ((float) Math.PI / 180F);
            int i = player.getMainArm() == Arm.RIGHT ? 1 : -1;

            ItemStack itemstack = player.getMainHandStack();
            if (!itemstack.isOf(ModItems.TIDAL_CLAWS)) {
                i = -i;
            }
            double d0 = MathHelper.sin(f2);
            double d1 = MathHelper.cos(f2);
            double d2 = (double) i * 0.35D;
            if ((this.dispatcher.gameOptions == null || this.dispatcher.gameOptions.getPerspective().isFirstPerson()) && player == MinecraftClient.getInstance().player) {
                double d7 = 960.0D / (double) this.dispatcher.gameOptions.getFov().getValue();
                Vec3d vec3 = this.dispatcher.camera.getProjection().getPosition((float) i * 0.6F, -1);
                vec3 = vec3.multiply(d7);
                vec3 = vec3.rotateY(f1 * 0.25F);
                vec3 = vec3.rotateX(-f1 * 0.35F);
                d4 = MathHelper.lerp(partialTicks, player.prevX, player.getX()) + vec3.x;
                d5 = MathHelper.lerp(partialTicks, player.prevY, player.getY()) + vec3.y;
                d6 = MathHelper.lerp(partialTicks, player.prevZ, player.getZ()) + vec3.z;
                f3 = player.getStandingEyeHeight() * 0.5F;
            } else {
                d4 = MathHelper.lerp(partialTicks, player.prevX, player.getX()) - d1 * d2 - d0 * 0.2D;
                d5 = player.prevY + (double) player.getStandingEyeHeight() + (player.getY() - player.prevY) * (double) partialTicks - 1D;
                d6 = MathHelper.lerp(partialTicks, player.prevZ, player.getZ()) - d0 * d2 + d1 * 0.2D;
                f3 = (player.isInSneakingPose() ? -0.1875F : 0.0F) - player.getStandingEyeHeight() * 0.4F;
            }
        }

        return new Vec3d(d4, d5 + f3, d6);
    }

    private double modifyVecAngle(double dimension) {
        float abs = (float) Math.abs(dimension);
        return Math.signum(dimension) * MathHelper.clamp(Math.pow(abs, 0.1), 0.05 * abs, abs);
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
    public Identifier getTexture(Tidal_Tentacle_Entity entity) {
        return CLAW_TEXTURE;
    }

}