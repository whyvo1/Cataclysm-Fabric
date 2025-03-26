package com.github.l_ender.cataclysm.client.model.entity;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.l_ender.cataclysm.client.animation.Elite_Draugr_Animation;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar.Elite_Draugr_Entity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;

public class Elite_Draugr_Model extends SinglePartEntityModel<Elite_Draugr_Entity> implements ModelWithArms {

	private final ModelPart everything;
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart front_cloth1;
	private final ModelPart front_cloth2;
	private final ModelPart back_cloth1;
	private final ModelPart back_cloth2;
	private final ModelPart waist;
	private final ModelPart chest;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart maw;
	private final ModelPart l_arm;
	private final ModelPart cube_r1;
	private final ModelPart l_arm2;
	private final ModelPart r_arm;
	private final ModelPart cube_r2;
	private final ModelPart r_arm2;
	private final ModelPart right_leg;
	private final ModelPart left_leg;


	public Elite_Draugr_Model(ModelPart root) {
		this.everything = root;
		this.root = this.everything.getChild("root");
		this.body = this.root.getChild("body");
		this.front_cloth1 = this.body.getChild("front_cloth1");
		this.front_cloth2 = this.front_cloth1.getChild("front_cloth2");
		this.back_cloth1 = this.body.getChild("back_cloth1");
		this.back_cloth2 = this.back_cloth1.getChild("back_cloth2");
		this.waist = this.body.getChild("waist");
		this.chest = this.waist.getChild("chest");
		this.neck = this.chest.getChild("neck");
		this.head = this.neck.getChild("head");
		this.maw = this.head.getChild("maw");
		this.l_arm = this.chest.getChild("l_arm");
		this.cube_r1 = this.l_arm.getChild("cube_r1");
		this.l_arm2 = this.l_arm.getChild("l_arm2");
		this.r_arm = this.chest.getChild("r_arm");
		this.cube_r2 = this.r_arm.getChild("cube_r2");
		this.r_arm2 = this.r_arm.getChild("r_arm2");
		this.right_leg = this.root.getChild("right_leg");
		this.left_leg = this.root.getChild("left_leg");

	}

	public static TexturedModelData createBodyLayer() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData root = partdefinition.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(52, 0).cuboid(-5.0F, -4.0F, -2.0F, 10.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData front_cloth1 = body.addChild("front_cloth1", ModelPartBuilder.create().uv(60, 8).cuboid(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -2.0F, -0.0436F, 0.0F, 0.0F));

		ModelPartData front_cloth2 = front_cloth1.addChild("front_cloth2", ModelPartBuilder.create().uv(56, 44).cuboid(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		ModelPartData back_cloth1 = body.addChild("back_cloth1", ModelPartBuilder.create().uv(38, 16).cuboid(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 2.0F, 0.0873F, 0.0F, 0.0F));

		ModelPartData back_cloth2 = back_cloth1.addChild("back_cloth2", ModelPartBuilder.create().uv(0, 18).cuboid(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.0F, 0.0F));

		ModelPartData waist = body.addChild("waist", ModelPartBuilder.create().uv(80, 50).cuboid(-1.5F, -8.0F, -1.0F, 3.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, 1.0F));

		ModelPartData chest = waist.addChild("chest", ModelPartBuilder.create().uv(80, 60).cuboid(-1.5F, -8.0F, -1.0F, 3.0F, 8.0F, 2.0F, new Dilation(0.0F))
		.uv(32, 50).cuboid(-6.0F, -8.0F, -4.0F, 12.0F, 10.0F, 4.0F, new Dilation(0.0F))
		.uv(96, 0).cuboid(-6.0F, -8.0F, -4.0F, 12.0F, 10.0F, 4.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

		ModelPartData neck = chest.addChild("neck", ModelPartBuilder.create().uv(16, 18).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

		ModelPartData head = neck.addChild("head", ModelPartBuilder.create().uv(0, 48).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
		.uv(96, 112).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.1F))
		.uv(0, 64).cuboid(-11.0F, -15.0F, 0.0F, 9.0F, 11.0F, 0.0F, new Dilation(0.0F))
		.uv(80, 0).cuboid(4.0F, -12.0F, 0.0F, 6.0F, 8.0F, 0.0F, new Dilation(0.0F))
		.uv(28, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.4F)), ModelTransform.pivot(0.0F, -2.0F, -1.0F));

		ModelPartData maw = head.addChild("maw", ModelPartBuilder.create().uv(60, 60).cuboid(-3.0F, -2.5F, -2.0F, 6.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.5F, -3.0F, 0.2102F, 0.0504F, -0.3014F));

		ModelPartData l_arm = chest.addChild("l_arm", ModelPartBuilder.create().uv(72, 32).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F))
		.uv(26, 76).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.3F)), ModelTransform.pivot(7.0F, -6.0F, -1.0F));

		ModelPartData cube_r1 = l_arm.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -2.0F, -2.5F, 6.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -2.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		ModelPartData l_arm2 = l_arm.addChild("l_arm2", ModelPartBuilder.create().uv(52, 69).cuboid(-2.0F, 2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.2F))
		.uv(68, 69).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData r_arm = chest.addChild("r_arm", ModelPartBuilder.create().uv(72, 20).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F))
		.uv(64, 50).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.3F)), ModelTransform.pivot(-7.0F, -6.0F, -1.0F));

		ModelPartData cube_r2 = r_arm.addChild("cube_r2", ModelPartBuilder.create().uv(0, 12).cuboid(-4.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(17, 11).cuboid(-5.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(17, 9).cuboid(0.0F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 9).cuboid(-2.0F, -4.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-4.0F, -5.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 9).cuboid(-3.0F, -2.0F, -2.5F, 6.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -2.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		ModelPartData r_arm2 = r_arm.addChild("r_arm2", ModelPartBuilder.create().uv(68, 69).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.0F))
		.uv(36, 64).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData right_leg = root.addChild("right_leg", ModelPartBuilder.create().uv(56, 28).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -12.0F, 0.0F));

		ModelPartData left_leg = root.addChild("left_leg", ModelPartBuilder.create().uv(56, 12).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -12.0F, 0.0F));

		return TexturedModelData.of(meshdefinition, 128, 128);
	}

	@Override
	public void setAngles(Elite_Draugr_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.animateHeadLookTarget(netHeadYaw, headPitch);

		this.animateMovement(Elite_Draugr_Animation.WALK, limbSwing, limbSwingAmount, 2.0F, 2.0F);
		this.updateAnimation(entity.getAnimationState("idle"), Elite_Draugr_Animation.IDLE, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("re_load"), Elite_Draugr_Animation.RE_LOAD, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("shoot"), Elite_Draugr_Animation.SHOOT, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("shoot2"), Elite_Draugr_Animation.SHOOT2, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("swing"), Elite_Draugr_Animation.SWING, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("attack"), Elite_Draugr_Animation.ATTACK, ageInTicks, 1.5F);
		this.updateAnimation(entity.getAnimationState("attack2"), Elite_Draugr_Animation.ATTACK2, ageInTicks, 1.5F);
	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.pitch = xRot * ((float) Math.PI / 180F);
		this.head.yaw = yRot * ((float) Math.PI / 180F);
	}

	@Override
	public void setArmAngle(Arm arm, MatrixStack poseStack) {
		root.rotate(poseStack);
		body.rotate(poseStack);
		waist.rotate(poseStack);
		chest.rotate(poseStack);
		if (arm == Arm.RIGHT) {
			r_arm.rotate(poseStack);
			r_arm2.rotate(poseStack);
			poseStack.translate(0.0F, 0.0F, 0.0F);
		} else {
			l_arm.rotate(poseStack);
			l_arm2.rotate(poseStack);
			poseStack.translate(0.0F, 0.0F, 0.0F);
		}
	}

	public ModelPart getPart() {
		return this.root;
	}

}