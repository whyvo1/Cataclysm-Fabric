package com.github.l_ender.cataclysm.mixin.Client;


import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.tag.FluidTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderLayers.class)
public class RenderLayersMixin {


    @Inject(at = @At("TAIL"), cancellable = true,
            method = "getFluidLayer")
    private static void lionfish_getFluidRenderLayer(FluidState fluidState, CallbackInfoReturnable<RenderLayer> cir) {
//        EventGetFluidRenderType event = new EventGetFluidRenderType(fluidState, cir.getReturnValue());
//        MinecraftForge.EVENT_BUS.post(event);
//        if(event.getResult() == Event.Result.ALLOW){
//            cir.setReturnValue(event.getRenderType());
//        }
        PlayerEntity player = MinecraftClient.getInstance().player;
        if(player == null) {
            return;
        }
        if (player.getInventory().getArmorStack(3).isOf(ModItems.IGNITIUM_HELMET) && fluidState.isIn(FluidTags.LAVA)) {
            cir.setReturnValue(RenderLayer.getTranslucent());
        }
    }
}
