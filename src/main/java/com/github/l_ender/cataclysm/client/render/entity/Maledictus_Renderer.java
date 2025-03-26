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
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
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
//        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Pre<Maledictus_Entity, Maledictus_Model>(entityIn, this, partialTicks, matrixStackIn, bufferIn, packedLightIn)))
//            return;
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
            float f3 = MathHelper.wrapDegrees(f2);
            if (f3 < -85.0F) {
                f3 = -85.0F;
            }

            if (f3 >= 85.0F) {
                f3 = 85.0F;
            }

            f = f1 - f3;
            if (f3 * f3 > 2500.0F) {
                f += f3 * 0.2F;
            }

            f2 = f1 - f;
        }

        float f6 = MathHelper.lerp(partialTicks, entityIn.prevPitch, entityIn.getPitch());
        if (entityIn.getPose() == EntityPose.SLEEPING) {
            Direction direction = entityIn.getSleepingDirection();
            if (direction != null) {
                float f4 = entityIn.getEyeHeight(EntityPose.STANDING) - 0.1F;
                matrixStackIn.translate((float) (-direction.getOffsetX()) * f4, 0.0D, (float) (-direction.getOffsetZ()) * f4);
            }
        }

        float f7 = this.getAnimationProgress(entityIn, partialTicks);
        this.setupTransforms(entityIn, matrixStackIn, f7, f, partialTicks);
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        this.scale(entityIn, matrixStackIn, partialTicks);
        matrixStackIn.translate(0.0D, -1.501F, 0.0D);
        float f8 = 0.0F;
        float f5 = 0.0F;
        if (!shouldSit && entityIn.isAlive()) {
            f8 = entityIn.limbAnimator.getSpeed(partialTicks);
            f5 = entityIn.limbAnimator.getPos(partialTicks);
            if (entityIn.isBaby()) {
                f5 *= 3.0F;
            }

            if (f8 > 1.0F) {
                f8 = 1.0F;
            }
        }
        this.model.animateModel(entityIn, f5, f8, partialTicks);
        this.model.setAngles(entityIn, f5, f8, f7, f2, f6);
        MinecraftClient minecraft = MinecraftClient.getInstance();
        boolean flag = this.isVisible(entityIn);
        boolean flag1 = !flag && !entityIn.isInvisibleTo(minecraft.player);
        boolean flag2 = minecraft.hasOutline(entityIn);
        RenderLayer rendertype = this.getRenderType(entityIn, flag, flag1, flag2);
        if (rendertype != null) {
            float hide = (entityIn.getHealth() / entityIn.getMaxHealth()) - 0.4F;
            float alpha = (1F - hide) * 0.6F;
            int i = getOverlay(entityIn, this.getAnimationCounter(entityIn, partialTicks));
            this.renderMaledictusModel(matrixStackIn, bufferIn, rendertype, partialTicks, packedLightIn, flag1 ? 0.15F : MathHelper.clamp(alpha, 0, 1), entityIn);
        }
        if (!entityIn.isSpectator()) {
            for (FeatureRenderer layerrenderer : this.features) {
                layerrenderer.render(matrixStackIn, bufferIn, packedLightIn, entityIn, f5, f8, partialTicks, f7, f2, f6);
            }
        }

        matrixStackIn.pop();
//        RenderNameTagEvent renderNameplateEvent = new RenderNameTagEvent(entityIn, entityIn.getDisplayName(), this, matrixStackIn, bufferIn, packedLightIn, partialTicks);
//        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(renderNameplateEvent);
//        if (renderNameplateEvent.getResult() != net.minecraftforge.eventbus.api.Event.Result.DENY && (renderNameplateEvent.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW || this.hasLabel(entityIn))) {
//            this.renderLabelIfPresent(entityIn, renderNameplateEvent.getContent(), matrixStackIn, bufferIn, packedLightIn);
//        }
//        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Post<Maledictus_Entity, Maledictus_Model>(entityIn, this, partialTicks, matrixStackIn, bufferIn, packedLightIn));

    }



    private void renderMaledictusModel(MatrixStack matrixStackIn, VertexConsumerProvider source, RenderLayer defRenderType, float partialTicks, int packedLightIn, float alphaIn, Maledictus_Entity entityIn) {
        boolean hurt = Math.max(entityIn.hurtTime, entityIn.deathTime) > 0;
        this.model.render(matrixStackIn, source.getBuffer(defRenderType), packedLightIn, LivingEntityRenderer.getOverlay(entityIn, this.getAnimationCounter(entityIn, partialTicks)), hurt ? 0.4F : 1.0F, hurt ? 0.8F : 1.0F, hurt ? 0.7F : 1.0F, alphaIn);
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

