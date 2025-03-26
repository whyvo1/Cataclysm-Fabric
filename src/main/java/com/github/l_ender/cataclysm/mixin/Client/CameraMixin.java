package com.github.l_ender.cataclysm.mixin.Client;

import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.init.ModEffect;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.BlockView;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public class CameraMixin {

    @Shadow private float pitch;

    @Shadow private float yaw;

    @Unique
    private float roll;

    @Shadow @Final private Quaternionf rotation;

    @Shadow @Final private static Vector3f HORIZONTAL;

    @Shadow @Final private static Vector3f VERTICAL;

    @Shadow @Final private static Vector3f DIAGONAL;

    @Shadow @Final private Vector3f horizontalPlane;

    @Shadow @Final private Vector3f verticalPlane;

    @Shadow @Final private Vector3f diagonalPlane;

    @Inject(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/Camera;setRotation(FF)V", ordinal = 0, shift = At.Shift.AFTER))
    private void injectUpdate0(BlockView area, Entity focusedEntity, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo ci) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        if(player == null) {
            return;
        }
        this.roll = 0.0F;
        this.shakeForShakeEntity(player, tickDelta, player.age + tickDelta);
        this.shakeForEffectStun(player, player.age + tickDelta);
    }

    @Unique
    private void shakeForShakeEntity(Entity entity, float tickDelta, float ticksExistedDelta) {
        float shakeAmplitude = 0.0F;
        if(!(entity instanceof LivingEntity living)) {
            return;
        }
        boolean hasShakeEntity = false;
        for (ScreenShake_Entity ScreenShake : living.getWorld().getNonSpectatingEntities(ScreenShake_Entity.class, living.getBoundingBox().expand(20, 20, 20))) {
            if (ScreenShake.distanceTo(living) < ScreenShake.getRadius()) {
                shakeAmplitude += ScreenShake.getShakeAmount(living, tickDelta);
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
        this.doShake(shakeAmplitude, ticksExistedDelta);
    }

    @Unique
    private void shakeForEffectStun(Entity entity, float ticksExistedDelta) {
        if(entity instanceof LivingEntity living && living.hasStatusEffect(ModEffect.EFFECTSTUN)) {
            StatusEffectInstance effect = living.getStatusEffect(ModEffect.EFFECTSTUN);
            float shakeAmplitude = (1 + effect.getAmplifier()) * 0.01F;
            this.doShake(shakeAmplitude, ticksExistedDelta);
        }
    }

    @Unique
    private void doShake(float amplitude, float ticksExistedDelta) {
        this.setRotation(
                (float) (yaw + amplitude * Math.cos(ticksExistedDelta * 5 + 1) * 25),
                (float) (pitch + amplitude * Math.cos(ticksExistedDelta * 3 + 2) * 25),
                (float) (roll + amplitude * Math.cos(ticksExistedDelta * 4) * 25)
        );
    }

    @Unique
    private void setRotation(float yaw, float pitch, float roll) {
        this.pitch = pitch;
        this.yaw = yaw;
        this.roll = roll;
        this.rotation.rotationYXZ((float) Math.PI - yaw * (float) (Math.PI / 180.0), -pitch * (float) (Math.PI / 180.0), -roll * (float) (Math.PI / 180.0));
        HORIZONTAL.rotate(this.rotation, this.horizontalPlane);
        VERTICAL.rotate(this.rotation, this.verticalPlane);
        DIAGONAL.rotate(this.rotation, this.diagonalPlane);
    }

    @Inject(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/Camera;setRotation(FF)V", ordinal = 1))
    private void injectUpdate1(BlockView area, Entity focusedEntity, boolean thirdPerson, boolean inverseView, float tickDelta, CallbackInfo ci) {
        this.setRoll(-this.roll);
    }

    @Unique
    private void setRoll(float roll) {
        this.roll = roll;
        this.rotation.rotationZ(-roll * (float) (Math.PI / 180.0));
        HORIZONTAL.rotate(this.rotation, this.horizontalPlane);
        VERTICAL.rotate(this.rotation, this.verticalPlane);
        DIAGONAL.rotate(this.rotation, this.diagonalPlane);
    }
}
