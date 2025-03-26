package com.github.l_ender.cataclysm.client.render.etc;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;

public class CurioHeadRenderer implements TrinketRenderer {

//    @Override
//    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, MatrixStack matrixStack, FeatureRendererContext<T, M> renderLayerParent, VertexConsumerProvider renderTypeBuffer, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
//        if (renderLayerParent.getModel() instanceof ModelWithHead headModel) {
//            matrixStack.push();
//            headModel.getHead().rotate(matrixStack);
//            matrixStack.translate(0.0D, -0.25D, 0.0D);
//            matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
//            matrixStack.scale(0.625F, -0.625F, -0.625F);
//            HeldItemRenderer renderer = new HeldItemRenderer(MinecraftClient.getInstance(), MinecraftClient.getInstance().getEntityRenderDispatcher(), MinecraftClient.getInstance().getItemRenderer());
//            renderer.renderItem(slotContext.entity(), stack, ModelTransformationMode.HEAD, false, matrixStack, renderTypeBuffer, light);
//            matrixStack.pop();
//        }
//    }

    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (contextModel instanceof ModelWithHead headModel) {
            matrices.push();
            headModel.getHead().rotate(matrices);
            matrices.translate(0.0D, -0.25D, 0.0D);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
            matrices.scale(0.625F, -0.625F, -0.625F);
            HeldItemRenderer renderer = new HeldItemRenderer(MinecraftClient.getInstance(), MinecraftClient.getInstance().getEntityRenderDispatcher(), MinecraftClient.getInstance().getItemRenderer());
            renderer.renderItem(entity, stack, ModelTransformationMode.HEAD, false, matrices, vertexConsumers, light);
            matrices.pop();
        }
    }

}
