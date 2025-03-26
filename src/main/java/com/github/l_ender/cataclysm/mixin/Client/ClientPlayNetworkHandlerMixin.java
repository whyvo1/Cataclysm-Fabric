package com.github.l_ender.cataclysm.mixin.Client;

import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Tongue_Entity;
import com.github.l_ender.cataclysm.entity.etc.IHoldEntity;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.s2c.play.EntityPassengersSetS2CPacket;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {


    @Inject(method = "onEntityPassengersSet", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;setOverlayMessage(Lnet/minecraft/text/Text;Z)V", shift = At.Shift.AFTER))
    public void injectOnEntityPassengersSet(EntityPassengersSetS2CPacket packet, CallbackInfo ci, @Local(ordinal = 0) Entity entity) {
        if(entity instanceof The_Leviathan_Tongue_Entity || entity instanceof IHoldEntity) {
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.translatable("entity.cataclysm.you_cant_escape"), false);
        }
    }
}
