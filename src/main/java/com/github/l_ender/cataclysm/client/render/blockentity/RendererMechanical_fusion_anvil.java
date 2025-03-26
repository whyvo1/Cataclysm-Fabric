package com.github.l_ender.cataclysm.client.render.blockentity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.blocks.Mechanical_fusion_Anvil;
import com.github.l_ender.cataclysm.client.model.block.Mechanical_Anvil_Model;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory.Context;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import com.github.l_ender.cataclysm.blockentities.Mechanical_fusion_Anvil_Block_Entity;

public class RendererMechanical_fusion_anvil<T extends Mechanical_fusion_Anvil_Block_Entity> implements BlockEntityRenderer<T> {

    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/block/mechanical_fusion_anvil.png");
    private static final Mechanical_Anvil_Model MODEL = new Mechanical_Anvil_Model();

    public RendererMechanical_fusion_anvil(Context rendererDispatcherIn) {
    }

    @Override
    public void render(T tileEntityIn, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();
        Direction dir = tileEntityIn.getCachedState().get(Mechanical_fusion_Anvil.FACING);
        if(dir == Direction.NORTH){
            matrixStackIn.translate(0.5, 1.5F, 0.5F);
        }else if(dir == Direction.EAST){
            matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        }else if(dir == Direction.SOUTH){
            matrixStackIn.translate(0.5, 1.5F, 0.5F);
        }else if(dir == Direction.WEST){
            matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        }
        matrixStackIn.multiply(dir.getOpposite().getRotationQuaternion());
        matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
        matrixStackIn.push();
        MODEL.animate(tileEntityIn, partialTicks);
        MODEL.render(matrixStackIn, bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(TEXTURE)), combinedLightIn, combinedOverlayIn);
        matrixStackIn.pop();
        matrixStackIn.pop();
    }

}


