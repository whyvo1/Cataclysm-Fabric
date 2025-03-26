package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.entity.projectile.Blazing_Bone_Entity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Blazing_Bone_Renderer extends EntityRenderer<Blazing_Bone_Entity> {

    public Blazing_Bone_Renderer(EntityRendererFactory.Context manager) {
        super(manager);
    }

    @Override
    public void render(Blazing_Bone_Entity entity, float yaw, float partialTicks, MatrixStack stack, VertexConsumerProvider buffer, int light) {
        stack.push();
        float spin = (entity.age + partialTicks) * 30F;
        // size up
        stack.scale(1.25F, 1.25F, 1.25F);

        stack.push();
        stack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(yaw + 90));
        stack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(spin));
        stack.translate(0f, 0f, 0);

        MinecraftClient.getInstance().getItemRenderer().renderItem(entity.getStack(), ModelTransformationMode.GROUND, light, OverlayTexture.DEFAULT_UV, stack, buffer, entity.getWorld(), entity.getId());
        stack.pop();
        stack.pop();
    }


    @Override
    public Identifier getTexture(Blazing_Bone_Entity entity) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
    }
}
