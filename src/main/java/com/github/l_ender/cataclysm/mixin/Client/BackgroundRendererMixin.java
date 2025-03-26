package com.github.l_ender.cataclysm.mixin.Client;

import com.github.l_ender.cataclysm.init.ModItems;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.CameraSubmersionType;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BackgroundRenderer.class)
public class BackgroundRendererMixin {

    @Inject(method = "applyFog", at = @At("RETURN"))
    private static void injectApplyFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        if(fogType == BackgroundRenderer.FogType.FOG_TERRAIN) {
            PlayerEntity player = MinecraftClient.getInstance().player;
            if(player != null &&
                    MinecraftClient.getInstance().player.getInventory().getArmorStack(3).isOf(ModItems.IGNITIUM_HELMET) &&
                    camera.getSubmersionType() == CameraSubmersionType.LAVA) {
                RenderSystem.setShaderFogStart(-8.0F);
                RenderSystem.setShaderFogEnd(50.0F);
            }

        }
    }
}
