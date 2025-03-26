package com.github.l_ender.cataclysm.client.render.item.CuriosItemREnderer;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.model.item.CuriosModel.Sandstorm_In_A_BottleModel;
import com.github.l_ender.cataclysm.client.render.RenderUtils;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class RendererSandstorm_In_A_Bottle implements TrinketRenderer {
    private final Sandstorm_In_A_BottleModel model;
    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/curiositem/sandstorm_in_a_bottle.png");

    public RendererSandstorm_In_A_Bottle() {
        this.model = new Sandstorm_In_A_BottleModel(RenderUtils.getModelPartFromLayer(CMModelLayers.SANDSTORM_IN_A_BOTTLE_MODEL));
    }


    public Identifier getCuriosTexture() {
        return TEXTURE;
    }

//    @Override
//    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, MatrixStack poseStack, FeatureRendererContext<T, M> renderLayerParent, VertexConsumerProvider buffer, int packedLight, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
//        ICurioRenderer.followBodyRotations(slotContext.entity(), this.model);
//        VertexConsumer consumer = ItemRenderer.getArmorGlintConsumer(buffer, RenderLayer.getArmorCutoutNoCull(getCuriosTexture()), false, stack.hasGlint());
//        this.model.render(poseStack, consumer, packedLight, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
//    }

    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        TrinketRenderer.followBodyRotations(entity, this.model);
        VertexConsumer consumer = ItemRenderer.getArmorGlintConsumer(vertexConsumers, RenderLayer.getArmorCutoutNoCull(getCuriosTexture()), false, stack.hasGlint());
        this.model.render(matrices, consumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

    }
}
