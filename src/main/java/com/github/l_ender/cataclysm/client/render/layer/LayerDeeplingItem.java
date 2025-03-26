package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.client.model.entity.Deepling_Model;
import com.github.l_ender.cataclysm.entity.Deepling.Deepling_Entity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;

public class LayerDeeplingItem extends FeatureRenderer<Deepling_Entity, Deepling_Model> {
    private final HeldItemRenderer itemInHandRenderer;

    public  LayerDeeplingItem(FeatureRendererContext p_234846_, HeldItemRenderer p_234847_) {
        super(p_234846_);
        this.itemInHandRenderer = p_234847_;
    }

    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Deepling_Entity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack itemstack = entitylivingbaseIn.getEquippedStack(EquipmentSlot.MAINHAND);
        matrixStackIn.push();
        boolean left = entitylivingbaseIn.isLeftHanded();
        matrixStackIn.push();
        translateToHand(matrixStackIn, left);
        matrixStackIn.translate(0F, 1.4225F, -0.1F);
        matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90F));
        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180F));
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
        HeldItemRenderer renderer = MinecraftClient.getInstance().getEntityRenderDispatcher().getHeldItemRenderer();
        renderer.renderItem(entitylivingbaseIn, itemstack, ModelTransformationMode.THIRD_PERSON_RIGHT_HAND, false, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.pop();
        matrixStackIn.pop();

    }

    protected void translateToHand(MatrixStack matrixStack, boolean left) {
        this.getContextModel().root.translateAndRotate(matrixStack);
        this.getContextModel().body.translateAndRotate(matrixStack);
        if(left){
            this.getContextModel().left_arm.translateAndRotate(matrixStack);
        }else{
            this.getContextModel().right_arm.translateAndRotate(matrixStack);
        }
    }
}
