package com.github.l_ender.cataclysm.client.render.blockentity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.block.Altar_of_Void_Model;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory.Context;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import com.github.l_ender.cataclysm.blockentities.AltarOfVoid_Block_Entity;

public class RendererAltar_of_Void<T extends AltarOfVoid_Block_Entity> implements BlockEntityRenderer<T> {

    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/block/altar_of_void.png");
    private static final Altar_of_Void_Model MODEL = new Altar_of_Void_Model();

    public RendererAltar_of_Void(Context rendererDispatcherIn) {
    }

    @Override
    public void render(T tileEntityIn, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();
        matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        matrixStackIn.scale(1.0F, -1.0F, -1.0F);
        MODEL.render(matrixStackIn, bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(TEXTURE)), combinedLightIn, combinedOverlayIn);
        matrixStackIn.pop();
    }

}


