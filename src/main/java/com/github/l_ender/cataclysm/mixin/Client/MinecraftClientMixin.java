package com.github.l_ender.cataclysm.mixin.Client;

import com.github.l_ender.cataclysm.event.AttackCallback;
import com.github.l_ender.cataclysm.message.MessageAttackMiss;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.HitResult;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Shadow @Nullable public ClientPlayerEntity player;

    @Shadow @Nullable public ClientWorld world;

    @Shadow @Nullable public HitResult crosshairTarget;

    @Inject(method = "doAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/hit/HitResult;getType()Lnet/minecraft/util/hit/HitResult$Type;", shift = At.Shift.AFTER), cancellable = true)
    public void injectDoAttack(CallbackInfoReturnable<Boolean> cir) {
        HitResult.Type type = crosshairTarget.getType();
        ActionResult result = AttackCallback.EVENT.invoker().interact(player, world, type);
        switch (result) {
            case SUCCESS: {
                new MessageAttackMiss(type).sendToServer();
                break;
            }
            case CONSUME: {
                new MessageAttackMiss(type).sendToServer();
                cir.setReturnValue(cir.getReturnValue());
                break;
            }
            case FAIL: {
                cir.setReturnValue(cir.getReturnValue());
                break;
            }
        }
    }

    @Inject(method = "handleBlockBreaking", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerInteractionManager;updateBlockBreakingProgress(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/Direction;)Z"), cancellable = true)
    public void injectHandleBlockBreaking(boolean breaking, CallbackInfo ci) {
        ActionResult result = AttackCallback.EVENT.invoker().interact(player, world, HitResult.Type.BLOCK);
        switch (result) {
            case SUCCESS: {
                new MessageAttackMiss(HitResult.Type.BLOCK).sendToServer();
                break;
            }
            case CONSUME: {
                new MessageAttackMiss(HitResult.Type.BLOCK).sendToServer();
                ci.cancel();
                break;
            }
            case FAIL: {
                ci.cancel();
                break;
            }
        }
    }


}
