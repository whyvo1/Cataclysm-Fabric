package com.github.l_ender.cataclysm.mixin.Client;

import com.github.l_ender.cataclysm.init.ModEffect;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.Input;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

    @Shadow @Final protected MinecraftClient client;

    @Shadow public Input input;

    @Inject(method = "tickMovement", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/input/Input;tick(ZF)V"))
    public void injectTickMovement(CallbackInfo ci) {
        PlayerEntity player = client.player;
        if(player != null && player.hasStatusEffect(ModEffect.EFFECTCURSE_OF_DESERT)) {
            if (MinecraftClient.getInstance().options.backKey.isPressed()) {
                input.movementForward += 2F;
            }
            if (MinecraftClient.getInstance().options.leftKey.isPressed()) {
                input.movementSideways -= 2F;
            }
            if (MinecraftClient.getInstance().options.rightKey.isPressed()) {
                input.movementSideways += 2F;
            }
            if (MinecraftClient.getInstance().options.forwardKey.isPressed()) {
                input.movementForward -= 2F;
            }
        }
    }
}
