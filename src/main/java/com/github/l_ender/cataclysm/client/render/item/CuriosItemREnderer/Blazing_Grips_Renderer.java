package com.github.l_ender.cataclysm.client.render.item.CuriosItemREnderer;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.model.item.CuriosModel.Blazing_Grips_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.client.render.RenderUtils;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;

import org.jetbrains.annotations.Nullable;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;

public class Blazing_Grips_Renderer implements TrinketRenderer {
    private final Blazing_Grips_Model model;
    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/curiositem/blazing_grips.png");
    private static final Identifier TEXTURE_LAYER = Cataclysm.modIdentifier("textures/curiositem/blazing_grips_layer.png");
    private final Blazing_Grips_Model slimModel;

    public Blazing_Grips_Renderer() {
        this.model = new Blazing_Grips_Model(RenderUtils.getModelPartFromLayer(CMModelLayers.BLAZING_GRIPS_MODEL));
        this.slimModel  = new Blazing_Grips_Model(RenderUtils.getModelPartFromLayer(CMModelLayers.BLAZING_GRIPS_SLIM_MODEL));
    }

    @Nullable
    public static Blazing_Grips_Renderer getGloveRenderer(ItemStack stack) {
        if (!stack.isEmpty()) {
            return TrinketRendererRegistry.getRenderer(stack.getItem())
                    .filter(Blazing_Grips_Renderer.class::isInstance)
                    .map(Blazing_Grips_Renderer.class::cast)
                    .orElse(null);
        }
        return null;
    }

    protected Blazing_Grips_Model getModel(boolean hasSlimArms) {
        return hasSlimArms ? slimModel : model;
    }

    protected static boolean hasSlimArms(Entity entity) {
        return entity instanceof AbstractClientPlayerEntity player && player.getModel().equals("slim");
    }



    public Identifier getCuriosTexture() {
        return TEXTURE;
    }

    @Override
    public void render(ItemStack stack,
                       SlotReference slotReference,
                       EntityModel<? extends LivingEntity> contextModel,
                       MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers,
                       int light,
                       LivingEntity entity,
                       float limbAngle,
                       float limbDistance,
                       float tickDelta,
                       float animationProgress,
                       float headYaw,
                       float headPitch) {
        boolean hasSlimArms = hasSlimArms(entity);
        Blazing_Grips_Model model = getModel(hasSlimArms);
        Hand hand = slotReference.index() % 2 == 0 ? Hand.MAIN_HAND : Hand.OFF_HAND;
        Arm handSide = hand == Hand.MAIN_HAND ? entity.getMainArm() : entity.getMainArm().getOpposite();

        model.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
        model.animateModel(entity, limbAngle, limbDistance, tickDelta);
        TrinketRenderer.followBodyRotations(entity, model);

        renderArm(model, matrices, vertexConsumers, handSide, light, stack.hasGlint());
    }

//    @Override
//    public <T extends LivingEntity, M extends EntityModel<T>> void render(
//            ItemStack stack,
//            SlotContext slotContext,
//            MatrixStack poseStack,
//            FeatureRendererContext<T, M> renderLayerParent,
//            VertexConsumerProvider multiBufferSource,
//            int light,
//            float limbSwing,
//            float limbSwingAmount,
//            float partialTicks,
//            float ageInTicks,
//            float netHeadYaw,
//            float headPitch
//    ) {
//        boolean hasSlimArms = hasSlimArms(slotContext.entity());
//        Blazing_Grips_Model model = getModel(hasSlimArms);
//        Hand hand = slotContext.index() % 2 == 0 ? Hand.MAIN_HAND : Hand.OFF_HAND;
//        Arm handSide = hand == Hand.MAIN_HAND ? slotContext.entity().getMainArm() : slotContext.entity().getMainArm().getOpposite();
//
//        model.setAngles(slotContext.entity(), limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
//        model.animateModel(slotContext.entity(), limbSwing, limbSwingAmount, partialTicks);
//        ICurioRenderer.followBodyRotations(slotContext.entity(), model);
//
//        renderArm(model, poseStack, multiBufferSource, handSide, light, stack.hasGlint());
//    }

    protected void renderArm(Blazing_Grips_Model model, MatrixStack matrixStack, VertexConsumerProvider buffer, Arm handSide, int light, boolean hasFoil) {
        RenderLayer renderType = model.getLayer(getCuriosTexture());
        VertexConsumer vertexBuilder = ItemRenderer.getItemGlintConsumer(buffer, renderType, false, hasFoil);
        model.renderArm(handSide, matrixStack, vertexBuilder, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        VertexConsumer builder = ItemRenderer.getItemGlintConsumer(buffer, CMRenderTypes.CMEyes(TEXTURE_LAYER), false, hasFoil);
        model.renderArm(handSide, matrixStack, builder, LightmapTextureManager.pack(15, 15), OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
    }

    public final void renderFirstPersonArm(MatrixStack matrixStack, VertexConsumerProvider buffer, int light, AbstractClientPlayerEntity player, Arm side, boolean hasFoil) {
        if (!player.isSpectator()) {
            boolean hasSlimArms = hasSlimArms(player);
            Blazing_Grips_Model model = getModel(hasSlimArms);

            ModelPart arm = side == Arm.LEFT ? model.leftArm : model.rightArm;

            model.setVisible(false);
            arm.visible = true;

            model.sneaking = false;
            model.handSwingProgress = model.leaningPitch = 0;
            model.setAngles(player, 0, 0, 0, 0, 0);
            arm.pitch = 0;

            renderFirstPersonArm(model, arm, matrixStack, buffer, light, hasFoil);
        }
    }

    protected void renderFirstPersonArm(Blazing_Grips_Model model, ModelPart arm, MatrixStack matrixStack, VertexConsumerProvider buffer, int light,  boolean hasFoil) {
        RenderLayer renderType = model.getLayer(getCuriosTexture());
        VertexConsumer builder = ItemRenderer.getItemGlintConsumer(buffer, renderType, false, hasFoil);
        arm.render(matrixStack, builder, light, OverlayTexture.DEFAULT_UV);
        VertexConsumer builder2 = ItemRenderer.getItemGlintConsumer(buffer, CMRenderTypes.CMEyes(TEXTURE_LAYER), false, hasFoil);
        arm.render(matrixStack, builder2, LightmapTextureManager.pack(15, 15), OverlayTexture.DEFAULT_UV);
    }


}
