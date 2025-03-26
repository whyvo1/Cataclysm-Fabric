package com.github.l_ender.cataclysm.client.render.blockentity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.blockentities.AltarOfAbyss_Block_Entity;
import com.github.l_ender.cataclysm.blocks.Altar_Of_Abyss_Block;
import com.github.l_ender.cataclysm.client.model.block.Altar_of_Abyss_Model;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory.Context;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;

public class RendererAltar_of_Abyss<T extends AltarOfAbyss_Block_Entity> implements BlockEntityRenderer<T> {

    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/block/altar_of_abyss.png");
    private static final Altar_of_Abyss_Model MODEL = new Altar_of_Abyss_Model();

    public RendererAltar_of_Abyss(Context rendererDispatcherIn) {
    }

    @Override
    public void render(T tileEntityIn, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();
        Direction dir = tileEntityIn.getCachedState().get(Altar_Of_Abyss_Block.FACING);
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
        renderItem(tileEntityIn, partialTicks,matrixStackIn,bufferIn,combinedLightIn);
    }

    public void renderItem(T tileEntityIn, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int combinedLightIn) {
        ItemStack stack = tileEntityIn.getItem(0);
        float f2 = (float) tileEntityIn.tickCount + partialTicks;
        if (!stack.isEmpty()) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.9F, 0.5F);

            matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f2));
            BakedModel ibakedmodel = MinecraftClient.getInstance().getItemRenderer().getModel(stack, tileEntityIn.getWorld(), null, 0);
            boolean flag = ibakedmodel.hasDepth();
            if (!flag) {
                matrixStackIn.translate(0.0F, 0.0F, 0.0F);
            }
            MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformationMode.GROUND, false, matrixStackIn, bufferIn, combinedLightIn, OverlayTexture.DEFAULT_UV, ibakedmodel);
            matrixStackIn.pop();
        }
    }

}


