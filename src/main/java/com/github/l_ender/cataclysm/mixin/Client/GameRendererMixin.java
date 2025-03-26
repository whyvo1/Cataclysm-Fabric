package com.github.l_ender.cataclysm.mixin.Client;

import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.init.ModEffect;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Shadow @Final
    MinecraftClient client;

    @Shadow @Final private Camera camera;

    @Inject(method = "renderWorld", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/Camera;update(Lnet/minecraft/world/BlockView;Lnet/minecraft/entity/Entity;ZZF)V", shift = At.Shift.AFTER))
    public void injectRenderWorld(float tickDelta, long limitTime, MatrixStack matrices, CallbackInfo ci) {
        PlayerEntity player = client.player;
        if(player == null) {
            return;
        }
        this.shakeForShakeEntity(player, tickDelta, player.age + tickDelta, matrices, camera);
        this.shakeForEffectStun(player, tickDelta, player.age + tickDelta, matrices, camera);

    }

    @Unique
    private void shakeForShakeEntity(PlayerEntity player, float tickDelta, float ticksExistedDelta, MatrixStack matrices, Camera camera) {
        float shakeAmplitude = 0;
        boolean hasShakeEntity = false;
        for (ScreenShake_Entity ScreenShake : player.getWorld().getNonSpectatingEntities(ScreenShake_Entity.class, player.getBoundingBox().expand(20, 20, 20))) {
            if (ScreenShake.distanceTo(player) < ScreenShake.getRadius()) {
                shakeAmplitude += ScreenShake.getShakeAmount(player, tickDelta);
                hasShakeEntity = true;
                if(shakeAmplitude >= 1.0f) {
                    shakeAmplitude = 1.0f;
                    break;
                }
            }
        }
        if(!hasShakeEntity) {
            return;
        }

//        event.setPitch((float) (event.getPitch() + shakeAmplitude * Math.cos(ticksExistedDelta * 3 + 2) * 25));
//        event.setYaw((float) (event.getYaw() + shakeAmplitude * Math.cos(ticksExistedDelta * 5 + 1) * 25));
//        event.setRoll((float) (event.getRoll() + shakeAmplitude * Math.cos(ticksExistedDelta * 4) * 25));
        camera.pitch = (float) (camera.getPitch() + shakeAmplitude * Math.cos(ticksExistedDelta * 3 + 2) * 25);
        camera.yaw = (float) (camera.getYaw() + shakeAmplitude * Math.cos(ticksExistedDelta * 5 + 1) * 25);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float) (shakeAmplitude * Math.cos(ticksExistedDelta * 4) * 25)));
    }

    @Unique
    private void shakeForEffectStun(PlayerEntity player, float tickDelta, float ticksExistedDelta, MatrixStack matrices, Camera camera) {
        if(player.hasStatusEffect(ModEffect.EFFECTSTUN)) {
            StatusEffectInstance effect = player.getStatusEffect(ModEffect.EFFECTSTUN);
            float shakeAmplitude = ((1 + effect.getAmplifier()) * 0.01F);
//            event.setPitch((float) (event.getPitch() + shakeAmplitude * Math.cos(ticksExistedDelta * 3 + 2) * 25));
//            event.setYaw((float) (event.getYaw() + shakeAmplitude * Math.cos(ticksExistedDelta * 5 + 1) * 25));
//            event.setRoll((float) (event.getRoll() + shakeAmplitude * Math.cos(ticksExistedDelta * 4) * 25));
            camera.pitch = (float) (camera.getPitch() + shakeAmplitude * Math.cos(ticksExistedDelta * 3 + 2) * 25);
            camera.yaw = (float) (camera.getYaw() + shakeAmplitude * Math.cos(ticksExistedDelta * 5 + 1) * 25);
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float) (shakeAmplitude * Math.cos(ticksExistedDelta * 4) * 25)));
        }
    }
}
