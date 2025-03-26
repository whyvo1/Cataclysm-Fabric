package com.github.l_ender.cataclysm.client.render.entity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class RendererNull extends EntityRenderer<Entity> {
    public RendererNull(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public Identifier getTexture(Entity entity) {
        return null;
    }

    @Override
    public void render(Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {

    }
}
