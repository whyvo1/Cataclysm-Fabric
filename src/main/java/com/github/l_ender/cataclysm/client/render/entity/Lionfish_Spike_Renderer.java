package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.entity.projectile.Lionfish_Spike_Entity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Lionfish_Spike_Renderer extends EntityRenderer<Lionfish_Spike_Entity> {

    public Lionfish_Spike_Renderer(EntityRendererFactory.Context manager) {
        super(manager);
    }

    @Override
    public void render(Lionfish_Spike_Entity entity, float yaw, float partialTicks, MatrixStack stack, VertexConsumerProvider buffer, int light) {
        stack.push();
        stack.push();
        stack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(partialTicks, entity.prevYaw, entity.getYaw()) - 90.0F));
        stack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(partialTicks, entity.prevPitch, entity.getPitch())));
        stack.translate(0f, 0f, 0);
        MinecraftClient.getInstance().getItemRenderer().renderItem(entity.getStack(), ModelTransformationMode.GROUND, light, OverlayTexture.DEFAULT_UV, stack, buffer, entity.getWorld(), entity.getId());
        stack.pop();
        stack.pop();
    }


    @Override
    public Identifier getTexture(Lionfish_Spike_Entity entity) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
    }
}
