package com.github.l_ender.cataclysm.client.render.blockentity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.blocks.EMP_Block;
import com.github.l_ender.cataclysm.client.model.block.EMP_Model;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory.Context;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import com.github.l_ender.cataclysm.blockentities.EMP_Block_Entity;

public class RendererEMP<T extends EMP_Block_Entity> implements BlockEntityRenderer<T> {

    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/block/emp.png");
    private static final EMP_Model MODEL_EMP = new EMP_Model();

    public RendererEMP(Context rendererDispatcherIn) {
    }

    @Override
    public void render(T tileEntityIn, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();
        Direction dir = tileEntityIn.getCachedState().get(EMP_Block.TIP_DIRECTION);
        if(dir == Direction.UP){
            matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        }else {
            matrixStackIn.translate(0.5F, -0.5F, 0.5F);
        }
        matrixStackIn.multiply(dir.getOpposite().getRotationQuaternion());
        matrixStackIn.push();
        matrixStackIn.translate(0, 0.15F, 0.0F);
        matrixStackIn.scale(0.9f,0.9f,0.9f);
        MODEL_EMP.animate(tileEntityIn, partialTicks);
        MODEL_EMP.render(matrixStackIn, bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(TEXTURE)), combinedLightIn, combinedOverlayIn, 1, 1F, 1, 1);
        matrixStackIn.pop();
        matrixStackIn.pop();
    }

}


