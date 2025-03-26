package com.github.l_ender.cataclysm.client.model.entity;

import com.github.l_ender.cataclysm.client.animation.Kobolediator_Animation;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Kobolediator_Entity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class Kobolediator_Model extends SinglePartEntityModel<Kobolediator_Entity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart root;
	private final ModelPart everything;
	private final ModelPart mid_root;
	private final ModelPart pelvis;
	private final ModelPart lower_body;
	private final ModelPart body;
	private final ModelPart right_shoulder;
	private final ModelPart right_arm;
	private final ModelPart right_front_arm;
	private final ModelPart golden_greatsword;
	private final ModelPart left_shoulder;
	private final ModelPart left_arm;
	private final ModelPart left_front_arm;
	private final ModelPart head;
	private final ModelPart head_cube1;
	private final ModelPart head_cube2;
	private final ModelPart head_cube3;
	private final ModelPart head_cube4;
	private final ModelPart right_horn;
	private final ModelPart left_horn;
	private final ModelPart jaw;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart legs;
	private final ModelPart right_leg;
	private final ModelPart right_front_leg;
	private final ModelPart left_leg;
	private final ModelPart left_front_leg;

	public Kobolediator_Model(ModelPart root) {
		this.root = root;
		this.everything = this.root.getChild("everything");
		this.mid_root = this.everything.getChild("mid_root");
		this.pelvis = this.mid_root.getChild("pelvis");
		this.lower_body = this.pelvis.getChild("lower_body");
		this.body = this.lower_body.getChild("body");
		this.right_shoulder = this.body.getChild("right_shoulder");
		this.right_arm = this.right_shoulder.getChild("right_arm");
		this.right_front_arm = this.right_arm.getChild("right_front_arm");
		this.golden_greatsword = this.right_front_arm.getChild("golden_greatsword");
		this.left_shoulder = this.body.getChild("left_shoulder");
		this.left_arm = this.left_shoulder.getChild("left_arm");
		this.left_front_arm = this.left_arm.getChild("left_front_arm");
		this.head = this.body.getChild("head");
		this.head_cube1 = this.head.getChild("head_cube1");
		this.head_cube2 = this.head.getChild("head_cube2");
		this.head_cube3 = this.head.getChild("head_cube3");
		this.head_cube4 = this.head.getChild("head_cube4");
		this.right_horn = this.head.getChild("right_horn");
		this.left_horn = this.head.getChild("left_horn");
		this.jaw = this.head.getChild("jaw");
		this.tail1 = this.pelvis.getChild("tail1");
		this.tail2 = this.tail1.getChild("tail2");
		this.legs = this.mid_root.getChild("legs");
		this.right_leg = this.legs.getChild("right_leg");
		this.right_front_leg = this.right_leg.getChild("right_front_leg");
		this.left_leg = this.legs.getChild("left_leg");
		this.left_front_leg = this.left_leg.getChild("left_front_leg");
	}

	public static TexturedModelData createBodyLayer() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData everything = partdefinition.addChild("everything", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 25.0F, -1.0F));

		ModelPartData mid_root = everything.addChild("mid_root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData pelvis = mid_root.addChild("pelvis", ModelPartBuilder.create().uv(94, 72).cuboid(-9.0F, -3.0F, -6.0513F, 18.0F, 6.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -22.0F, 0.0F, 0.1745F, 0.1309F, 0.0F));

		ModelPartData lower_body = pelvis.addChild("lower_body", ModelPartBuilder.create().uv(86, 0).cuboid(-6.2168F, -14.0F, -15.0F, 14.0F, 14.0F, 15.0F, new Dilation(0.0F))
		.uv(56, 146).cuboid(-2.2168F, -14.0F, -3.0F, 6.0F, 14.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.7832F, 0.0F, 8.9487F));

		ModelPartData body = lower_body.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-12.2168F, -21.0F, -19.0F, 24.0F, 21.0F, 19.0F, new Dilation(0.0F))
		.uv(126, 130).cuboid(-3.2168F, -21.0F, -3.0F, 6.0F, 21.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 40).cuboid(-10.2168F, -21.0F, -21.0F, 4.0F, 16.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(5.7832F, -21.0F, -21.0F, 4.0F, 16.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 40).cuboid(-13.2168F, -21.0F, -19.0F, 26.0F, 7.0F, 19.0F, new Dilation(0.5F)), ModelTransform.of(1.0F, -14.0F, 0.0F, 0.1372F, -0.3027F, -0.0411F));

		ModelPartData right_shoulder = body.addChild("right_shoulder", ModelPartBuilder.create().uv(0, 66).cuboid(-16.0F, -4.0F, -9.0F, 17.0F, 15.0F, 19.0F, new Dilation(0.0F)), ModelTransform.of(-13.0F, -20.0F, -8.0F, -0.6109F, 0.2618F, 0.2182F));

		ModelPartData right_arm = right_shoulder.addChild("right_arm", ModelPartBuilder.create().uv(94, 124).cuboid(-5.0F, -1.0F, -4.0F, 8.0F, 14.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 9.0F, 2.0F, -0.4904F, 0.0334F, 0.0769F));

		ModelPartData right_front_arm = right_arm.addChild("right_front_arm", ModelPartBuilder.create().uv(0, 100).cuboid(-6.025F, 0.0F, -6.5F, 9.0F, 22.0F, 9.0F, new Dilation(0.0F))
		.uv(94, 93).cuboid(-8.025F, 2.0F, -8.5F, 8.0F, 18.0F, 13.0F, new Dilation(0.0F))
		.uv(67, 0).cuboid(1.0F, 16.0F, -1.5F, 4.0F, 7.0F, 0.0F, new Dilation(0.0F))
		.uv(53, 69).cuboid(1.0F, 17.0F, 1.5F, 4.0F, 6.0F, 0.0F, new Dilation(0.0F))
		.uv(53, 69).cuboid(1.0F, 17.0F, -4.5F, 4.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 13.0F, 2.0F, -1.5708F, 0.0F, 0.0F));

		ModelPartData golden_greatsword = right_front_arm.addChild("golden_greatsword", ModelPartBuilder.create().uv(80, 146).cuboid(-2.2168F, -12.0F, -2.1F, 4.0F, 21.0F, 4.0F, new Dilation(0.0F))
		.uv(72, 72).cuboid(-1.7168F, -78.0F, -4.1F, 3.0F, 66.0F, 8.0F, new Dilation(0.0F))
		.uv(71, 40).cuboid(-2.2168F, -12.0F, 1.9F, 4.0F, 5.0F, 5.0F, new Dilation(0.0F))
		.uv(0, 66).cuboid(-2.2168F, -12.0F, -7.1F, 4.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 18.9F, 1.0F, 1.3963F, 0.0F, 0.0F));

		ModelPartData left_shoulder = body.addChild("left_shoulder", ModelPartBuilder.create().uv(0, 66).mirrored().cuboid(-1.0F, -4.0F, -9.0F, 17.0F, 15.0F, 19.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(12.5663F, -20.0F, -8.0F, 0.0436F, -0.0873F, -0.1309F));

		ModelPartData left_arm = left_shoulder.addChild("left_arm", ModelPartBuilder.create().uv(94, 124).mirrored().cuboid(-3.0F, -1.0F, -4.0F, 8.0F, 14.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(5.0F, 9.0F, 2.0F, 0.0873F, 0.0F, 0.0F));

		ModelPartData left_front_arm = left_arm.addChild("left_front_arm", ModelPartBuilder.create().uv(0, 100).mirrored().cuboid(-2.975F, 0.0F, -6.5F, 9.0F, 22.0F, 9.0F, new Dilation(0.0F)).mirrored(false)
		.uv(94, 93).mirrored().cuboid(0.025F, 2.0F, -8.5F, 8.0F, 18.0F, 13.0F, new Dilation(0.0F)).mirrored(false)
		.uv(53, 69).mirrored().cuboid(-5.0F, 17.0F, -4.5F, 4.0F, 6.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
		.uv(67, 0).mirrored().cuboid(-5.0F, 16.0F, -1.5F, 4.0F, 7.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
		.uv(53, 69).mirrored().cuboid(-5.0F, 17.0F, 1.5F, 4.0F, 6.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 13.0F, 2.0F, -0.829F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(24, 119).cuboid(-4.2168F, -3.0F, -10.0F, 10.0F, 7.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -30.0F, -9.0F, 0.0F, 0.1309F, 0.0F));

		ModelPartData head_cube1 = head.addChild("head_cube1", ModelPartBuilder.create().uv(36, 100).cuboid(0.8F, -5.0F, -8.0F, 6.0F, 6.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(1.5663F, -2.0F, -2.0F, 0.1616F, 0.1866F, -0.0568F));

		ModelPartData head_cube2 = head.addChild("head_cube2", ModelPartBuilder.create().uv(62, 38).cuboid(1.0F, -6.0F, -12.0F, 6.0F, 6.0F, 28.0F, new Dilation(0.0F)), ModelTransform.of(-3.2168F, -3.0F, -2.0F, 0.48F, 0.0F, 0.0F));

		ModelPartData head_cube3 = head.addChild("head_cube3", ModelPartBuilder.create().uv(125, 113).cuboid(-6.8F, -5.0F, -8.0F, 6.0F, 6.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, -2.0F, 0.1616F, -0.1866F, 0.0568F));

		ModelPartData head_cube4 = head.addChild("head_cube4", ModelPartBuilder.create().uv(102, 49).cuboid(-3.0F, -34.0F, -23.0F, 9.0F, 7.0F, 10.0F, new Dilation(-0.01F)), ModelTransform.of(-0.7168F, 30.0F, 5.0F, 0.0436F, 0.0F, 0.0F));

		ModelPartData right_horn = head.addChild("right_horn", ModelPartBuilder.create().uv(148, 105).cuboid(-9.2168F, -9.0F, 4.0513F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F))
		.uv(148, 40).cuboid(-9.2168F, -9.0F, -1.9487F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
		.uv(129, 0).cuboid(-9.2168F, -3.0F, -1.9487F, 12.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -5.0F, -3.0F));

		ModelPartData left_horn = head.addChild("left_horn", ModelPartBuilder.create().uv(148, 52).cuboid(4.2168F, -9.0F, 4.0513F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F))
		.uv(96, 146).cuboid(3.2168F, -9.0F, -1.9487F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
		.uv(123, 93).cuboid(-2.7832F, -3.0F, -1.9487F, 12.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(3.5663F, -5.0F, -3.0F));

		ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create().uv(102, 29).cuboid(-2.7168F, -4.0F, -12.0F, 7.0F, 4.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.0F, -6.0F, 0.1309F, 0.0F, 0.0F));

		ModelPartData tail1 = pelvis.addChild("tail1", ModelPartBuilder.create().uv(130, 54).cuboid(-1.5F, -2.0F, -1.0F, 3.0F, 4.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.1231F, 11.3724F, -0.3927F, 0.0F, 0.0F));

		ModelPartData tail2 = tail1.addChild("tail2", ModelPartBuilder.create().uv(67, 0).cuboid(-2.0F, -1.1888F, -1.1585F, 2.0F, 3.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -0.5F, 10.0F, 0.4799F, 0.0F, 0.0F));

		ModelPartData legs = mid_root.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -22.0F, 0.0F));

		ModelPartData right_leg = legs.addChild("right_leg", ModelPartBuilder.create().uv(145, 70).cuboid(-3.2168F, -2.0F, -3.0F, 7.0F, 10.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-6.7832F, 4.0F, 0.9487F, -0.1295F, 0.5275F, 0.3306F));

		ModelPartData right_front_leg = right_leg.addChild("right_front_leg", ModelPartBuilder.create().uv(137, 22).cuboid(-2.2168F, 0.0F, -1.0F, 7.0F, 11.0F, 7.0F, new Dilation(0.0F))
		.uv(53, 62).cuboid(-1.2168F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F))
		.uv(53, 62).cuboid(3.7832F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F))
		.uv(53, 62).cuboid(1.2832F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.975F, 8.0F, -2.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData left_leg = legs.addChild("left_leg", ModelPartBuilder.create().uv(28, 138).cuboid(-3.7832F, -2.0F, -3.0F, 7.0F, 10.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(6.7832F, 3.0F, 0.9487F, -0.1295F, -0.5275F, -0.3306F));

		ModelPartData left_front_leg = left_leg.addChild("left_front_leg", ModelPartBuilder.create().uv(0, 131).cuboid(-4.7832F, 0.0F, -1.0F, 7.0F, 11.0F, 7.0F, new Dilation(0.0F))
		.uv(53, 62).mirrored().cuboid(1.2168F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
		.uv(53, 62).mirrored().cuboid(-1.2832F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
		.uv(53, 62).mirrored().cuboid(-3.7832F, 8.0F, -5.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.975F, 8.0F, -2.0F, 0.3927F, 0.0F, 0.0F));

		return TexturedModelData.of(meshdefinition, 256, 256);
	}

	@Override
	public void setAngles(Kobolediator_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		if(entity.getAttackState() != 6 && !entity.isSleep()) {
			this.animateMovement(Kobolediator_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 4.0F);
		}
		this.updateAnimation(entity.getAnimationState("idle"), Kobolediator_Animation.IDLE, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("sleep"), Kobolediator_Animation.SLEEP, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("awake"), Kobolediator_Animation.AWAKE, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("sword1"), Kobolediator_Animation.SWORD1, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("sword2"), Kobolediator_Animation.SWORD2, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("charge"), Kobolediator_Animation.CHARGE, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("charge_prepare"), Kobolediator_Animation.CHARGE_PREPARE, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("charge_end"), Kobolediator_Animation.CHARGE_END, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("death"), Kobolediator_Animation.DEATH, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("block"), Kobolediator_Animation.BLOCK, ageInTicks, 1.0F);
	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.pitch += xRot * ((float) Math.PI / 180F);
		this.head.yaw = yRot * ((float) Math.PI / 180F);
	}

	public ModelPart getPart() {
		return this.root;
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}