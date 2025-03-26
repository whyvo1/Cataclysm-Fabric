package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.model.entity.Maledictus_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.client.render.layer.MaledictusRiderLayer;
import com.github.l_ender.cataclysm.client.render.layer.Maledictus_Cicle_Layer;
import com.github.l_ender.cataclysm.client.render.layer.Maledictus_Layer;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class Maledictus_Renderer extends MobEntityRenderer<Maledictus_Entity, Maledictus_Model> {

    private static final Identifier MALEDICTUS_TEXTURES = Cataclysm.modIdentifier("textures/entity/maledictus/maledictus_ghost.png");

    public Maledictus_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Maledictus_Model(renderManagerIn.getPart(CMModelLayers.MALEDICTUS_MODEL)), 0.75F);
        this.addFeature(new Maledictus_Layer(this));
        this.addFeature(new Maledictus_Cicle_Layer(this, renderManagerIn));
        this.addFeature(new MaledictusRiderLayer(this));
    }
    @Override
    public Identifier getTexture(Maledictus_Entity entity) {
        return MALEDICTUS_TEXTURES;
    }

    @Override
    protected float getLyingAngle(Maledictus_Entity entity) {
        return 0;
    }


    public void render(Maledictus_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
//        if (net.neoforged.neoforge.common.NeoForge.EVENT_BUS.post(new net.neoforged.neoforge.client.event.RenderLivingEvent.Pre<Maledictus_Entity, Maledictus_Model>(entityIn, this, partialTicks, matrixStackIn,  bufferIn, packedLightIn)).isCanceled()) return;
        matrixStackIn.push();
        this.model.handSwingProgress = this.getHandSwingProgress(entityIn, partialTicks);
        boolean shouldSit = entityIn.hasVehicle();
        this.model.riding = shouldSit;
        this.model.child = entityIn.isBaby();
        float f = MathHelper.lerpAngleDegrees(partialTicks, entityIn.prevBodyYaw, entityIn.bodyYaw);
        float f1 = MathHelper.lerpAngleDegrees(partialTicks, entityIn.prevHeadYaw, entityIn.headYaw);
        float f2 = f1 - f;
        if (shouldSit && entityIn.getVehicle() instanceof LivingEntity livingentity) {
            f = MathHelper.lerpAngleDegrees(partialTicks, livingentity.prevBodyYaw, livingentity.bodyYaw);
            f2 = f1 - f;
            float f7 = MathHelper.wrapDegrees(f2);
            if (f7 < -85.0F) {
                f7 = -85.0F;
            }

            if (f7 >= 85.0F) {
                f7 = 85.0F;
            }

            f = f1 - f7;
            if (f7 * f7 > 2500.0F) {
                f += f7 * 0.2F;
            }

            f2 = f1 - f;
        }

        float f6 = MathHelper.lerp(partialTicks, entityIn.prevPitch, entityIn.getPitch());
        if (shouldFlipUpsideDown(entityIn)) {
            f6 *= -1.0F;
            f2 *= -1.0F;
        }

        f2 = MathHelper.wrapDegrees(f2);
        if (entityIn.isInPose(EntityPose.SLEEPING)) {
            Direction direction = entityIn.getSleepingDirection();
            if (direction != null) {
                float f3 = entityIn.getEyeHeight(EntityPose.STANDING) - 0.1F;
                matrixStackIn.translate((float)(-direction.getOffsetX()) * f3, 0.0F, (float)(-direction.getOffsetZ()) * f3);
            }
        }

        float f8 = entityIn.getScale();
        matrixStackIn.scale(f8, f8, f8);
        float f9 = this.getAnimationProgress(entityIn, partialTicks);
        this.setupTransforms(entityIn, matrixStackIn, f9, f, partialTicks, f8);
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        this.scale(entityIn, matrixStackIn, partialTicks);
        matrixStackIn.translate(0.0F, -1.501F, 0.0F);
        float f4 = 0.0F;
        float f5 = 0.0F;
        if (!shouldSit && entityIn.isAlive()) {
            f4 = entityIn.limbAnimator.getSpeed(partialTicks);
            f5 = entityIn.limbAnimator.getPos(partialTicks);
            if (entityIn.isBaby()) {
                f5 *= 3.0F;
            }

            if (f4 > 1.0F) {
                f4 = 1.0F;
            }
        }

        this.model.animateModel(entityIn, f5, f4, partialTicks);
        this.model.setAngles(entityIn, f5, f4, f9, f2, f6);
        MinecraftClient minecraft = MinecraftClient.getInstance();
        boolean flag = this.isVisible(entityIn);
        boolean flag1 = !flag && !entityIn.isInvisibleTo(minecraft.player);
        boolean flag2 = minecraft.hasOutline(entityIn);
        RenderLayer rendertype = this.getRenderType(entityIn, flag, flag1, flag2);
        if (rendertype != null) {
            VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getGhost(getTexture(entityIn)));
            float hide = (entityIn.getHealth() / entityIn.getMaxHealth()) - 0.4F;
            float alpha = (1F - hide) * 0.6F;
            boolean hurt = Math.max(entityIn.hurtTime, entityIn.deathTime) > 0;
            int i = ColorHelper.Argb.getArgb((int) (alpha * 255),  hurt ? 102 : 255, hurt ? 204 : 255,  hurt ? 178 : 255);

          //  this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, LivingEntityRenderer.getOverlayCoords(entityIn, this.getWhiteOverlayProgress(entityIn, partialTicks)),i);

            int i1 = getOverlay(entityIn, this.getAnimationCounter(entityIn, partialTicks));
            this.model.render(matrixStackIn, vertexconsumer, packedLightIn, i1, i);

        }

        if (!entityIn.isSpectator()) {
            for (FeatureRenderer<Maledictus_Entity, Maledictus_Model> renderlayer : this.features) {
                renderlayer.render(matrixStackIn, bufferIn, packedLightIn, entityIn, f5, f4, partialTicks, f9, f2, f6);
            }
        }

        matrixStackIn.pop();
       // super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
//        net.neoforged.neoforge.common.NeoForge.EVENT_BUS.post(new net.neoforged.neoforge.client.event.RenderLivingEvent.Post<Maledictus_Entity, Maledictus_Model>(entityIn, this, partialTicks, matrixStackIn, bufferIn, packedLightIn));
    }
    

    private void renderMaledictusModel(MatrixStack matrixStackIn, VertexConsumerProvider source, RenderLayer defRenderType, float partialTicks, int packedLightIn,  float alphaIn, Maledictus_Entity entityIn) {
        boolean hurt = Math.max(entityIn.hurtTime, entityIn.deathTime) > 0;
        int i = ColorHelper.Argb.getArgb(MathHelper.floor(alphaIn), (int) (hurt ? 0.4F : 1.0F * 255), (int) (hurt ? 0.8F : 1.0F * 255), (int) (hurt ? 0.7F : 1.0F *255));
        this.model.render(matrixStackIn, source.getBuffer(defRenderType), packedLightIn, LivingEntityRenderer.getOverlay(entityIn, this.getAnimationCounter(entityIn, partialTicks)),i);
    }


    @Nullable
    protected RenderLayer getRenderType(Maledictus_Entity maledictus, boolean normal, boolean invis, boolean outline) {
        Identifier resourcelocation = this.getTexture(maledictus);
        return outline ? RenderLayer.getOutline(resourcelocation) : CMRenderTypes.getGhost(resourcelocation);
    }

    @Override
    protected void scale(Maledictus_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }
}

