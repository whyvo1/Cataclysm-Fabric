package com.github.l_ender.cataclysm.mixin.Client;

import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Function;

@Mixin(BipedEntityModel.class)
public abstract class HumanoidModelMixin extends Model {

    @Unique
    private BipedEntityModel<?> self = (BipedEntityModel<?>)((Model)this);

    public HumanoidModelMixin(Function<Identifier, RenderLayer> p_103110_) {
        super(p_103110_);
    }

    @Inject(at = @At("HEAD"), method = "positionRightArm")
    private void custom_poseRightArm(LivingEntity entity, CallbackInfo ci) {
//        EventPosePlayerHand event = new EventPosePlayerHand(entity, (BipedEntityModel) ((Model) this), false);
//        NeoForge.EVENT_BUS.post(event);
//        if (event.getResult() == EventPosePlayerHand.Result.ALLOW) {
//            ci.cancel();
//        }
        this.handleArmAngles(entity);
    }


    @Inject(at = @At("HEAD"), method = "positionLeftArm")
    private void custom_poseLeftArm(LivingEntity entity, CallbackInfo ci) {
//        EventPosePlayerHand event = new EventPosePlayerHand(entity, (BipedEntityModel) ((Model) this), true);
//        NeoForge.EVENT_BUS.post(event);
//        if (event.getResult() == EventPosePlayerHand.Result.ALLOW) {
//            ci.cancel();
//        }
        this.handleArmAngles(entity);
    }

    @Unique
    private void handleArmAngles(LivingEntity entity) {
        if (entity.getStackInHand(Hand.OFF_HAND).isOf(ModItems.THE_ANNIHILATOR) && entity.getStackInHand(Hand.MAIN_HAND).isOf(ModItems.THE_ANNIHILATOR) && entity.isUsingItem()){
            if (entity.getMainArm() == Arm.LEFT) {
                self.rightArm.pitch = self.rightArm.pitch * 0.5F - MathHelper.PI;
                self.rightArm.yaw = 0.0F;
            } else {
                self.leftArm.pitch = self.leftArm.pitch * 0.5F - MathHelper.PI;
                self.leftArm.yaw = 0.0F;
            }
        }
        if (entity.getStackInHand(Hand.OFF_HAND).isOf(ModItems.THE_IMMOLATOR) && entity.getStackInHand(Hand.MAIN_HAND).isOf(ModItems.THE_IMMOLATOR) && entity.isUsingItem()){
            if (entity.getMainArm() == Arm.LEFT) {
                self.rightArm.pitch = self.rightArm.pitch * 0.5F - MathHelper.PI;
                self.rightArm.yaw = 0.0F;
            } else {
                self.leftArm.pitch = self.leftArm.pitch * 0.5F - MathHelper.PI;
                self.leftArm.yaw = 0.0F;
            }
        }
    }
}
