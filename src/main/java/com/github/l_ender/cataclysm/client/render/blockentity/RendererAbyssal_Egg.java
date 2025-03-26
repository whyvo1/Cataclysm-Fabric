package com.github.l_ender.cataclysm.client.render.blockentity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.blockentities.Abyssal_Egg_Block_Entity;
import com.github.l_ender.cataclysm.client.model.block.Abyssal_Egg_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory.Context;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RendererAbyssal_Egg implements BlockEntityRenderer<Abyssal_Egg_Block_Entity> {

    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/block/abyssal_egg.png");
    private static final Identifier LAYER_TEXTURE = Cataclysm.modIdentifier("textures/block/abyssal_egg_layer.png");
    private static final Abyssal_Egg_Model MODEL = new Abyssal_Egg_Model();

    public RendererAbyssal_Egg(Context rendererDispatcherIn) {
    }

    @Override
    public void render(Abyssal_Egg_Block_Entity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();
        matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        matrixStackIn.scale(1.0F, -1.0F, -1.0F);
        MODEL.animate(tileEntityIn, partialTicks);
        MODEL.render(matrixStackIn, bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(TEXTURE)), combinedLightIn, combinedOverlayIn, 1, 1F, 1, 1);
        MODEL.render(matrixStackIn, bufferIn.getBuffer(CMRenderTypes.getghost(LAYER_TEXTURE)), combinedLightIn, combinedOverlayIn, 1, 1F, 1, 1);
        matrixStackIn.pop();
    }


}


