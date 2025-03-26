package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.client.render.etc.LightningBoltData;
import com.github.l_ender.cataclysm.client.render.etc.LightningRender;
import com.github.l_ender.cataclysm.entity.effect.Boltstrike_Entity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.Vector4f;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Environment(EnvType.CLIENT)
public class Boltstrike_Renderer extends EntityRenderer<Boltstrike_Entity> {
    private Map<UUID, LightningRender> lightningRenderMap = new HashMap<>();
    private static final int MAX_HEIGHT = 15;
    private static final double START_MIN_RADIUS = 0.7D;
    private static final double START_MAX_RADIUS = 1.2D;
    private static final double END_MIN_RADIUS = 0.1D;
    private static final double END_MAX_RADIUS = 0.5D;

    public Boltstrike_Renderer(EntityRendererFactory.Context p_174286_) {
        super(p_174286_);
    }


    public void render(Boltstrike_Entity entity, float p_115267_, float partialTicks, MatrixStack poseStack, VertexConsumerProvider p_115270_, int p_115271_) {
        double x = MathHelper.lerp(partialTicks, entity.lastRenderX, entity.getX());
        double y = MathHelper.lerp(partialTicks, entity.lastRenderY, entity.getY());
        double z = MathHelper.lerp(partialTicks, entity.lastRenderZ, entity.getZ());

        int r = entity.getR();
        int g = entity.getG();
        int b = entity.getB();

        float f = entity.getAnimationProgress(partialTicks);
        float f1 = 0.0F;
        if (f != 0.0F) {
            f1 = f;

            poseStack.push();

            poseStack.translate(-x, -y, -z);
            LightningBoltData.BoltRenderInfo boltData = new LightningBoltData.BoltRenderInfo(0.2f, 0.7f, 0.25F, 0.15F, new Vector4f((float) r / 255, (float) g / 255, (float) b / 255, 0.7F), 0.92F);
            LightningBoltData bolt1 = new LightningBoltData(boltData, entity.getAnglePosition(partialTicks,MAX_HEIGHT,START_MAX_RADIUS,START_MIN_RADIUS), entity.getAnglePosition(partialTicks,0,END_MAX_RADIUS,END_MIN_RADIUS), 4)
                    .size(f1)
                    .lifespan(1)
                    .spawn(LightningBoltData.SpawnFunction.NO_DELAY)
                    .fade(LightningBoltData.FadeFunction.NONE);
            LightningRender lightningRender = getLightingRender(entity.getUuid());
            if (!MinecraftClient.getInstance().isPaused()) {
                lightningRender.update(entity, bolt1, partialTicks);
            }
            lightningRender.render(partialTicks, poseStack, p_115270_);

            poseStack.pop();
        }
        if (entity.isRemoved() && lightningRenderMap.containsKey(entity.getUuid())) {
            lightningRenderMap.remove(entity.getUuid());
        }
    }

    private LightningRender getLightingRender(UUID uuid) {
        if (lightningRenderMap.get(uuid) == null) {
            lightningRenderMap.put(uuid, new LightningRender());
        }
        return lightningRenderMap.get(uuid);
    }


    public Identifier getTexture(Boltstrike_Entity p_115264_) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;

    }
}
