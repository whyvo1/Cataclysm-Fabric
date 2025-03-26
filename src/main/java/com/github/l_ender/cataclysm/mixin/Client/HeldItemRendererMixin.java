package com.github.l_ender.cataclysm.mixin.Client;

import com.github.l_ender.cataclysm.client.render.item.CuriosItemREnderer.Blazing_Grips_Renderer;
import com.github.l_ender.cataclysm.client.render.item.CuriosItemREnderer.RendererSticky_Gloves;
import dev.emi.trinkets.api.TrinketInventory;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(HeldItemRenderer.class)
public class HeldItemRendererMixin {

    @Inject(method = "renderFirstPersonItem", at = @At("RETURN"))
    public void injectRenderFirstPersonItem(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
//        Hand hand = event.getArm() == event.getPlayer().getMainArm() ? Hand.MAIN_HAND : Hand.OFF_HAND;
        Arm arm = hand == Hand.MAIN_HAND ? Arm.RIGHT : Arm.LEFT;
        TrinketsApi.getTrinketComponent(player).ifPresent(comp -> {
            for (Map<String, TrinketInventory> group : comp.getInventory().values()) {
                for (TrinketInventory inv : group.values()) {
                    for (int i = hand == Hand.MAIN_HAND ? 0 : 1; i < inv.size(); i += 2) {
                        ItemStack stack = inv.getStack(i);
                        Blazing_Grips_Renderer gripsrenderer = Blazing_Grips_Renderer.getGloveRenderer(stack);
                        if (gripsrenderer != null) {
                            gripsrenderer.renderFirstPersonArm(matrices, vertexConsumers, light, player, arm, stack.hasGlint());
                        }
                        RendererSticky_Gloves stickyrenderer = RendererSticky_Gloves.getGloveRenderer(stack);
                        if (stickyrenderer != null) {
                            stickyrenderer.renderFirstPersonArm(matrices, vertexConsumers, light, player, arm, stack.hasGlint());
                        }
                    }
                }
            }
        });
//        CuriosApi.getCuriosHelper().getCuriosHandler(event.getPlayer()).ifPresent(handler -> {
//            ICurioStacksHandler stacksHandler = handler.getCurios().get(SlotTypePreset.HANDS.getIdentifier());
//            if (stacksHandler != null) {
//                IDynamicStackHandler stacks = stacksHandler.getStacks();
//                IDynamicStackHandler cosmeticStacks = stacksHandler.getCosmeticStacks();
//
//                for (int slot = hand == InteractionHand.MAIN_HAND ? 0 : 1; slot < stacks.getSlots(); slot += 2) {
//                    ItemStack stack = cosmeticStacks.getStackInSlot(slot);
//                    if (stack.isEmpty() && stacksHandler.getRenders().get(slot)) {
//                        stack = stacks.getStackInSlot(slot);
//                    }
//
//                    Blazing_Grips_Renderer gripsrenderer = Blazing_Grips_Renderer.getGloveRenderer(stack);
//                    if (gripsrenderer != null) {
//                        gripsrenderer.renderFirstPersonArm(event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight(), event.getPlayer(), event.getArm(), stack.hasFoil());
//                    }
//                    RendererSticky_Gloves stickyrenderer = RendererSticky_Gloves.getGloveRenderer(stack);
//                    if (stickyrenderer != null) {
//                        stickyrenderer.renderFirstPersonArm(event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight(), event.getPlayer(), event.getArm(), stack.hasFoil());
//                    }
//                }
//            }
//        });
    }
}
