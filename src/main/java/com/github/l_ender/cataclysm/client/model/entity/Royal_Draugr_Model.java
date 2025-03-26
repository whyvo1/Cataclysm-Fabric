package com.github.l_ender.cataclysm.client.model.entity;


import com.github.l_ender.cataclysm.client.animation.Draugar_Animation;

import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar.Royal_Draugr_Entity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;

public class Royal_Draugr_Model extends SinglePartEntityModel<Royal_Draugr_Entity> implements ModelWithArms {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor

	private final ModelPart everything;
	private final ModelPart root;
	private final ModelPart right_leg;
	private final ModelPart left_leg;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart left_arm_r1;
	private final ModelPart left_arm_r2;
	private final ModelPart right_arm;
	private final ModelPart right_arm_r1;
	private final ModelPart head;
	private final ModelPart maw;
	private final ModelPart body_r1;

	public Royal_Draugr_Model(ModelPart root) {
		this.everything = root;
		this.root = this.everything.getChild("root");
		this.right_leg = this.root.getChild("right_leg");
		this.left_leg = this.root.getChild("left_leg");
		this.body = this.root.getChild("body");
		this.left_arm = this.body.getChild("left_arm");
		this.left_arm_r1 = this.left_arm.getChild("left_arm_r1");
		this.left_arm_r2 = this.left_arm.getChild("left_arm_r2");
		this.right_arm = this.body.getChild("right_arm");
		this.right_arm_r1 = this.right_arm.getChild("right_arm_r1");
		this.head = this.body.getChild("head");
		this.maw = this.head.getChild("maw");
		this.body_r1 = this.maw.getChild("body_r1");
	}

	public static TexturedModelData createBodyLayer() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData root = partdefinition.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData right_leg = root.addChild("right_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F))
		.uv(84, 0).cuboid(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new Dilation(0.2F)), ModelTransform.pivot(-2.0F, -12.0F, 0.1F));

		ModelPartData left_leg = root.addChild("left_leg", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
		.uv(76, 0).mirrored().cuboid(-1.0F, 0.0F, -1.1F, 2.0F, 12.0F, 2.0F, new Dilation(0.2F)).mirrored(false), ModelTransform.pivot(2.0F, -12.0F, 0.1F));

		ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F))
		.uv(52, 0).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.2F))
		.uv(104, 26).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.4F))
		.uv(32, 36).cuboid(-4.0F, -3.0F, -2.0F, 8.0F, 11.0F, 4.0F, new Dilation(0.5F)), ModelTransform.of(0.0F, -12.0F, 0.0F, 0.0873F, 0.0F, 0.0436F));

		ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create().uv(40, 16).mirrored().cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
		.uv(76, 0).mirrored().cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.2F)).mirrored(false)
		.uv(0, 48).mirrored().cuboid(-1.0F, 3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.5F)).mirrored(false)
		.uv(118, 42).mirrored().cuboid(0.0F, 2.0F, -1.5F, 2.0F, 7.0F, 3.0F, new Dilation(0.2F)).mirrored(false)
		.uv(40, 16).mirrored().cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(5.0F, -9.0F, 0.0F, -0.0873F, 0.0F, -0.0873F));

		ModelPartData left_arm_r1 = left_arm.addChild("left_arm_r1", ModelPartBuilder.create().uv(58, 17).mirrored().cuboid(-1.0F, -2.0F, -3.5F, 0.0F, 6.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.9763F, -0.7164F, 0.0F, 0.0F, 0.0F, -0.2182F));

		ModelPartData left_arm_r2 = left_arm.addChild("left_arm_r2", ModelPartBuilder.create().uv(48, 23).mirrored().cuboid(-1.0F, -2.0F, -1.5F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.0F, -0.5F, 0.0F, 0.0F, 0.0F, -0.2182F));

		ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create().uv(40, 16).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.0F))
		.uv(84, 0).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new Dilation(0.2F))
		.uv(0, 48).cuboid(-1.0F, 2.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.5F)), ModelTransform.of(-5.0F, -8.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData right_arm_r1 = right_arm.addChild("right_arm_r1", ModelPartBuilder.create().uv(104, 52).cuboid(-3.0F, -4.0F, -2.5F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -0.5F, -0.5F, 0.0F, 0.0F, 0.2182F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
		.uv(92, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.2F))
		.uv(0, 32).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F))
		.uv(58, 36).cuboid(0.0F, -16.0F, 0.0F, 10.0F, 11.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 55).mirrored().cuboid(-10.0F, -13.0F, 0.0F, 6.0F, 8.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -12.0F, -1.0F, 0.1309F, 0.0F, 0.1745F));

		ModelPartData maw = head.addChild("maw", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.5F, -1.0F, 0.346F, -0.0636F, -0.1737F));

		ModelPartData body_r1 = maw.addChild("body_r1", ModelPartBuilder.create().uv(32, 6).cuboid(-3.0F, 0.0F, -4.0F, 6.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));


		return TexturedModelData.of(meshdefinition, 128, 64);
	}

	@Override
	public void setAngles(Royal_Draugr_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateHeadLookTarget(netHeadYaw, headPitch);
		this.animateMovement(Draugar_Animation.WALK, limbSwing, limbSwingAmount, 2.0F, 2.0F);
		this.updateAnimation(entity.getAnimationState("idle"), Draugar_Animation.IDLE, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("attack"), Draugar_Animation.ATTACK, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("attack2"), Draugar_Animation.ATTACK2, ageInTicks, 1.0F);

		boolean flag2 = entity.getMainArm() == Arm.RIGHT;
		if (entity.isUsingItem()) {
			boolean flag3 = entity.getActiveHand() == Hand.MAIN_HAND;
			if (flag3 == flag2) {
				this.right_arm.pitch= this.right_arm.pitch * 0.5F - 0.9424779F;
				this.right_arm.yaw = (-(float)Math.PI / 6F);
			} else {
				this.left_arm.pitch = this.left_arm.pitch * 0.5F - 0.9424779F;
				this.left_arm.yaw = ((float)Math.PI / 6F);
			}
		}
	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.pitch = xRot * ((float) Math.PI / 180F);
		this.head.yaw = yRot * ((float) Math.PI / 180F);
	}

	public void setArmAngle(Arm arm, MatrixStack poseStack) {
		root.rotate(poseStack);
		body.rotate(poseStack);
		if (arm == Arm.RIGHT) {
			right_arm.rotate(poseStack);
			poseStack.translate(0.0F, 0.0F, 0.0F);
		} else {
			left_arm.rotate(poseStack);
			poseStack.translate(0.0F, 0.0F, 0.0F);
		}
	}


	public ModelPart getPart() {
		return this.root;
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}