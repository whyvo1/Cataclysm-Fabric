package com.github.l_ender.cataclysm.client.model.armor;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;

public class ignitium_Elytra_chestplate_Model extends BipedEntityModel<LivingEntity> {
    private final ModelPart rightWing;
    private final ModelPart leftWing;

    public ignitium_Elytra_chestplate_Model(ModelPart part) {
        super(part);
        this.leftWing = part.getChild("body").getChild("left_wing");
        this.rightWing = part.getChild("body").getChild("right_wing");
    }

    public static TexturedModelData createArmorLayer(Dilation deformation) {
        ModelData meshdefinition = BipedEntityModel.getModelData(deformation, 0.0F);
        ModelPartData partdefinition = meshdefinition.getRoot();
        ModelPartData body = meshdefinition.getRoot().getChild("body");
        ModelPartData rightArm = partdefinition.getChild("right_arm");
        ModelPartData leftArm = partdefinition.getChild("left_arm");
        body.addChild("left_wing", ModelPartBuilder.create()
                        .uv(0, 65)
                        .mirrored()
                        .cuboid(-11.0F, 0.0F, 1.5F, 11.0F, 23.0F, 2.0F,  new Dilation(0.0F)),
                ModelTransform.of(6.0F, 0.0F, 1.5F, 0.2617994F, 0.0F, -0.2617994F));
        body.addChild("right_wing", ModelPartBuilder.create()
                        .uv(0, 65)
                        .cuboid(0.0F, 0.0F, 1.5F, 11.0F, 23.0F, 2.0F, new Dilation(0.0F)),
                ModelTransform.of(-5.0F, 0.0F, 1.5F, 0.2617994F, 0.0F, 0.2617994F));
        body.addChild("outer_body", ModelPartBuilder.create()
                .uv(30, 47)
                .cuboid(-4.5F, 1.0F, -2.5F, 9.0F, 12.0F, 5.0F,
                        new Dilation(0.4F)), ModelTransform
                .pivot(0.0F, -1.0F, 0.0F));

        body.addChild("inner_body", ModelPartBuilder.create()
                .uv(0, 51)
                .cuboid(-4.0F, -6.0F, -2.0F, 8.0F, 9.0F, 4.0F,
                        new Dilation(0.5F)), ModelTransform
                .pivot(0.0F, 11.0F, 0.0F));

        ModelPartData left_shoulderpad = leftArm.addChild("left_shoulderpad", ModelPartBuilder.create()
                .uv(30, 33)
                .cuboid(-6.0F, -7.0F, -3.0F, 5.0F, 7.0F, 6.0F,
                        new Dilation(0.3F)), ModelTransform
                .pivot(5.0F, 4.0F, 0.0F));

        ModelPartData left_spike = left_shoulderpad.addChild("left_spike", ModelPartBuilder.create()
                .uv(21, 43)
                .cuboid(-1.0F, -3.5F, 0.0F, 4.0F, 7.0F, 0.0F,
                        new Dilation(0.0F)), ModelTransform
                .of(-1.0F, -8.5F, 0.0F, 0.0F, 0.0F, 0.6109F));

        left_spike.addChild("left_side_spike", ModelPartBuilder.create()
                .uv(30, 47)
                .cuboid(0.5F, -3.5F, -0.5F, 2.0F, 4.0F, 0.0F,
                        new Dilation(0.0F)), ModelTransform
                .of(2.5F, 3.0F, 0.5F, 0.0F, 0.0F, 0.829F));

        ModelPartData right_shoulderpad = rightArm.addChild("right_shoulderpad", ModelPartBuilder.create()
                .uv(30, 33)
                .mirrored()
                .cuboid(0.0F, -7.0F, -3.0F, 5.0F, 7.0F, 6.0F,
                        new Dilation(0.3F)).mirrored(false), ModelTransform
                .pivot(-4.0F, 4.0F, 0.0F));

        ModelPartData right_spike = right_shoulderpad.addChild("right_spike", ModelPartBuilder.create()
                .uv(21, 43)
                .mirrored()
                .cuboid(-3.0F, -3.5F, 0.0F, 4.0F, 7.0F, 0.0F,
                        new Dilation(0.0F)).mirrored(false), ModelTransform
                .of(0.0F, -8.5F, 0.0F, 0.0F, 0.0F, -0.6109F));

        right_spike.addChild("right_side_spike", ModelPartBuilder.create()
                .uv(30, 47)
                .mirrored()
                .cuboid(-2.5F, -3.5F, -0.5F, 2.0F, 4.0F, 0.0F,
                        new Dilation(0.0F)).mirrored(false), ModelTransform
                .of(-2.5F, 3.0F, 0.5F, 0.0F, 0.0F, -0.829F));

        return TexturedModelData.of(meshdefinition, 128, 128);
    }

    public ignitium_Elytra_chestplate_Model withAnimations(LivingEntity entity){
        float partialTick = MinecraftClient.getInstance().getTickDelta();
        float limbSwingAmount = entity.limbAnimator.getSpeed(partialTick);
        float limbSwing = entity.limbAnimator.getPos() + partialTick;
        setAngles(entity, limbSwing, limbSwingAmount, entity.age + partialTick, 0, 0);
        return this;
    }

    public void setAngles(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 0.2617994F;
        float f1 = -0.2617994F;
        float f2 = 0.0F;
        float f3 = 0.0F;
        if (entityIn.isFallFlying()) {
            float f4 = 1.0F;
            Vec3d vector3d = entityIn.getVelocity();
            if (vector3d.y < 0.0D) {
                Vec3d vector3d1 = vector3d.normalize();
                f4 = 1.0F - (float)Math.pow(-vector3d1.y, 1.5D);
            }

            f = f4 * 0.34906584F + (1.0F - f4) * f;
            f1 = f4 * (-(float)Math.PI / 2F) + (1.0F - f4) * f1;
        } else if (entityIn.isInSneakingPose()) {
            f = 0.6981317F;
            f1 = (-(float)Math.PI / 4F);
            f2 = -1.0F;
            f3 = 0.08726646F;
        }

        this.leftWing.pivotX = 5.0F;
        this.leftWing.pivotY = f2;
        if (entityIn instanceof AbstractClientPlayerEntity) {
            AbstractClientPlayerEntity abstractclientplayerentity = (AbstractClientPlayerEntity)entityIn;
            abstractclientplayerentity.elytraPitch = (float)((double)abstractclientplayerentity.elytraPitch + (double)(f - abstractclientplayerentity.elytraPitch) * 0.1D);
            abstractclientplayerentity.elytraYaw = (float)((double)abstractclientplayerentity.elytraYaw + (double)(f3 - abstractclientplayerentity.elytraYaw) * 0.1D);
            abstractclientplayerentity.elytraRoll = (float)((double)abstractclientplayerentity.elytraRoll + (double)(f1 - abstractclientplayerentity.elytraRoll) * 0.1D);
            this.leftWing.pitch = abstractclientplayerentity.elytraPitch;
            this.leftWing.yaw = abstractclientplayerentity.elytraYaw;
            this.leftWing.roll = abstractclientplayerentity.elytraRoll;
        } else {
            this.leftWing.pitch = f;
            this.leftWing.roll = f1;
            this.leftWing.yaw = f3;
        }

        this.rightWing.pivotX = -this.leftWing.pivotX;
        this.rightWing.yaw = -this.leftWing.yaw;
        this.rightWing.pivotY = this.leftWing.pivotY;
        this.rightWing.pitch = this.leftWing.pitch;
        this.rightWing.roll = -this.leftWing.roll;
    }
}
