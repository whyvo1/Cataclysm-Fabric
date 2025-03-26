package com.github.l_ender.cataclysm.client.model.entity;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.l_ender.cataclysm.client.animation.Prowler_Animation;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.The_Prowler_Entity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.util.math.MathHelper;

public class The_Prowler_Model extends SinglePartEntityModel<The_Prowler_Entity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart root;
	private final ModelPart roots;
	private final ModelPart upperbody;
	private final ModelPart chestplate;
	private final ModelPart eye_blow;
	private final ModelPart chestplate2;
	private final ModelPart rocket_luncher;
	private final ModelPart missile;
	private final ModelPart missile2;
	private final ModelPart missile3;
	private final ModelPart right_arm;
	private final ModelPart right_arm_joint;
	private final ModelPart sholder_pad;
	private final ModelPart sholder_pad2;
	private final ModelPart right_arm2;
	private final ModelPart right_joint;
	private final ModelPart chainsaw;
	private final ModelPart saw;
	private final ModelPart blade5;
	private final ModelPart blade6;
	private final ModelPart blade7;
	private final ModelPart blade8;
	private final ModelPart blade;
	private final ModelPart blade2;
	private final ModelPart blade3;
	private final ModelPart blade4;
	private final ModelPart pelvis;
	private final ModelPart catapiller;
	private final ModelPart catapiller2;
	private final ModelPart pipe2;
	private final ModelPart pipe;

	public The_Prowler_Model(ModelPart root) {
		this.root = root;
		this.roots = this.root.getChild("roots");
		this.upperbody = this.roots.getChild("upperbody");
		this.chestplate = this.upperbody.getChild("chestplate");
		this.eye_blow = this.chestplate.getChild("eye_blow");
		this.chestplate2 = this.chestplate.getChild("chestplate2");
		this.rocket_luncher = this.upperbody.getChild("rocket_luncher");
		this.missile = this.rocket_luncher.getChild("missile");
		this.missile2 = this.rocket_luncher.getChild("missile2");
		this.missile3 = this.rocket_luncher.getChild("missile3");
		this.right_arm = this.upperbody.getChild("right_arm");
		this.right_arm_joint = this.right_arm.getChild("right_arm_joint");
		this.sholder_pad = this.right_arm_joint.getChild("sholder_pad");
		this.sholder_pad2 = this.sholder_pad.getChild("sholder_pad2");
		this.right_arm2 = this.right_arm_joint.getChild("right_arm2");
		this.right_joint = this.right_arm2.getChild("right_joint");
		this.chainsaw = this.right_joint.getChild("chainsaw");
		this.saw = this.chainsaw.getChild("saw");
		this.blade5 = this.saw.getChild("blade5");
		this.blade6 = this.saw.getChild("blade6");
		this.blade7 = this.saw.getChild("blade7");
		this.blade8 = this.saw.getChild("blade8");
		this.blade = this.saw.getChild("blade");
		this.blade2 = this.saw.getChild("blade2");
		this.blade3 = this.saw.getChild("blade3");
		this.blade4 = this.saw.getChild("blade4");
		this.pelvis = this.roots.getChild("pelvis");
		this.catapiller = this.pelvis.getChild("catapiller");
		this.catapiller2 = this.pelvis.getChild("catapiller2");
		this.pipe2 = this.pelvis.getChild("pipe2");
		this.pipe = this.pelvis.getChild("pipe");
	}

	public static TexturedModelData createBodyLayer() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData roots = partdefinition.addChild("roots", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData upperbody = roots.addChild("upperbody", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -23.5F, 0.0F));

		ModelPartData chestplate = upperbody.addChild("chestplate", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -13.0F, -3.0F, 14.0F, 13.0F, 21.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5F, -7.0F));

		ModelPartData eye_blow = chestplate.addChild("eye_blow", ModelPartBuilder.create().uv(2, 172).cuboid(-4.0F, -2.0F, 0.0F, 8.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.0F, -3.25F));

		ModelPartData chestplate2 = chestplate.addChild("chestplate2", ModelPartBuilder.create().uv(114, 110).cuboid(-10.0F, -40.0F, 0.0F, 6.0F, 13.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 25.0F, 0.0F));

		ModelPartData rocket_luncher = upperbody.addChild("rocket_luncher", ModelPartBuilder.create().uv(48, 45).cuboid(6.0F, -17.0F, -11.0F, 6.0F, 20.0F, 16.0F, new Dilation(0.0F))
		.uv(0, 61).cuboid(6.0F, -17.0F, -12.0F, 6.0F, 13.0F, 17.0F, new Dilation(0.3F))
		.uv(37, 41).cuboid(0.0F, -2.0F, 5.0F, 10.0F, 0.0F, 7.0F, new Dilation(0.0F))
		.uv(0, 34).cuboid(9.0F, -13.0F, 5.0F, 0.0F, 12.0F, 7.0F, new Dilation(0.0F))
		.uv(14, 50).cuboid(8.0F, -3.0F, 5.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(14, 47).cuboid(2.0F, -3.0F, 7.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(14, 44).cuboid(8.0F, -13.0F, 5.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 118).cuboid(0.0F, -8.0F, -8.0F, 6.0F, 13.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(7.0F, -6.5F, 1.0F));

		ModelPartData missile = rocket_luncher.addChild("missile", ModelPartBuilder.create().uv(76, 2).cuboid(-1.0F, -1.0F, -5.9F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F))
		.uv(44, 30).cuboid(0.0F, -3.0F, -0.9F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 2).cuboid(0.0F, 1.0F, -0.9F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(14, 41).cuboid(-1.0F, -1.0F, -3.9F, 2.0F, 2.0F, 1.0F, new Dilation(0.1F))
		.uv(7, 16).cuboid(-1.0F, -1.0F, 2.1F, 2.0F, 2.0F, 1.0F, new Dilation(0.1F)), ModelTransform.pivot(9.0F, -14.0F, -7.6F));

		ModelPartData missile2 = rocket_luncher.addChild("missile2", ModelPartBuilder.create().uv(76, 2).cuboid(-1.0F, -1.0F, -5.9F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F))
		.uv(44, 30).cuboid(0.0F, -3.0F, -0.9F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 2).cuboid(0.0F, 1.0F, -0.9F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(14, 41).cuboid(-1.0F, -1.0F, -3.9F, 2.0F, 2.0F, 1.0F, new Dilation(0.1F))
		.uv(7, 16).cuboid(-1.0F, -1.0F, 2.1F, 2.0F, 2.0F, 1.0F, new Dilation(0.1F)), ModelTransform.pivot(9.0F, -7.0F, -7.6F));

		ModelPartData missile3 = rocket_luncher.addChild("missile3", ModelPartBuilder.create().uv(76, 2).cuboid(-1.0F, -1.0F, -5.9F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F))
		.uv(44, 30).cuboid(0.0F, -3.0F, -0.9F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 2).cuboid(0.0F, 1.0F, -0.9F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(14, 41).cuboid(-1.0F, -1.0F, -3.9F, 2.0F, 2.0F, 1.0F, new Dilation(0.1F))
		.uv(7, 16).cuboid(-1.0F, -1.0F, 2.1F, 2.0F, 2.0F, 1.0F, new Dilation(0.1F)), ModelTransform.pivot(9.0F, 0.0F, -7.6F));

		ModelPartData right_arm = upperbody.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-13.0F, -13.5F, 1.0F));

		ModelPartData right_arm_joint = right_arm.addChild("right_arm_joint", ModelPartBuilder.create().uv(67, 125).cuboid(-11.0F, -6.0F, -5.0F, 11.0F, 16.0F, 10.0F, new Dilation(0.0F))
		.uv(44, 48).cuboid(-5.0F, 5.0F, -7.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-5.0F, 5.0F, 5.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData sholder_pad = right_arm_joint.addChild("sholder_pad", ModelPartBuilder.create().uv(0, 151).cuboid(-4.0F, -2.5F, -6.0F, 8.0F, 5.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, 4.5F, 0.0F, 0.0F, 0.0F, 0.3054F));

		ModelPartData sholder_pad2 = sholder_pad.addChild("sholder_pad2", ModelPartBuilder.create().uv(0, 151).cuboid(-4.0F, -2.5F, -6.0F, 8.0F, 5.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 5.0F, 0.0F));

		ModelPartData right_arm2 = right_arm_joint.addChild("right_arm2", ModelPartBuilder.create().uv(96, 63).cuboid(-3.0F, -8.0F, -3.0F, 6.0F, 16.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 91).cuboid(-3.0F, -8.0F, 1.0F, 6.0F, 16.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, 7.0F, 0.0F));

		ModelPartData right_joint = right_arm2.addChild("right_joint", ModelPartBuilder.create().uv(76, 41).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 70).cuboid(-4.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(62, 104).cuboid(-2.0F, -3.0F, -3.0F, 4.0F, 6.0F, 6.0F, new Dilation(0.3F))
		.uv(49, 0).cuboid(3.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 11.0F, 0.0F));

		ModelPartData chainsaw = right_joint.addChild("chainsaw", ModelPartBuilder.create().uv(93, 78).cuboid(-3.0F, -3.0F, -21.0F, 2.0F, 6.0F, 21.0F, new Dilation(0.0F))
		.uv(0, 91).cuboid(1.0F, -3.0F, -21.0F, 2.0F, 6.0F, 21.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -3.0F));

		ModelPartData saw = chainsaw.addChild("saw", ModelPartBuilder.create().uv(74, 63).cuboid(-1.0714F, -9.0F, -9.0F, 2.0F, 18.0F, 18.0F, new Dilation(0.0F))
		.uv(0, 25).cuboid(-0.0714F, -16.0F, -4.5F, 0.0F, 7.0F, 9.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-0.0714F, 9.0F, -4.5F, 0.0F, 7.0F, 9.0F, new Dilation(0.0F))
		.uv(0, 54).cuboid(-0.0714F, -4.5F, -16.0F, 0.0F, 9.0F, 7.0F, new Dilation(0.0F))
		.uv(49, 4).cuboid(-0.0714F, -4.5F, 9.0F, 0.0F, 9.0F, 7.0F, new Dilation(0.0F))
		.uv(64, 41).cuboid(-4.0714F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(44, 36).cuboid(1.9286F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0714F, 0.0F, -18.0F));

		ModelPartData blade5 = saw.addChild("blade5", ModelPartBuilder.create().uv(0, 0).cuboid(-0.8214F, 8.0F, -9.0F, 0.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData blade6 = saw.addChild("blade6", ModelPartBuilder.create().uv(0, 0).cuboid(0.6786F, 8.0F, 0.0F, 0.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		ModelPartData blade7 = saw.addChild("blade7", ModelPartBuilder.create().uv(49, 4).cuboid(-0.8214F, 0.0F, 8.0F, 0.0F, 9.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData blade8 = saw.addChild("blade8", ModelPartBuilder.create().uv(49, 4).cuboid(0.6786F, -9.0F, 8.0F, 0.0F, 9.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 1.0F, 0.1309F, 0.0F, 0.0F));

		ModelPartData blade = saw.addChild("blade", ModelPartBuilder.create().uv(0, 25).cuboid(-0.8214F, -15.0F, 0.0F, 0.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData blade2 = saw.addChild("blade2", ModelPartBuilder.create().uv(0, 25).cuboid(0.6786F, -15.0F, -9.0F, 0.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		ModelPartData blade3 = saw.addChild("blade3", ModelPartBuilder.create().uv(0, 54).cuboid(-0.8214F, -9.0F, -15.0F, 0.0F, 9.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData blade4 = saw.addChild("blade4", ModelPartBuilder.create().uv(0, 54).cuboid(0.6786F, 0.0F, -15.0F, 0.0F, 9.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -1.0F, 0.1309F, 0.0F, 0.0F));

		ModelPartData pelvis = roots.addChild("pelvis", ModelPartBuilder.create().uv(0, 34).cuboid(-6.0F, 12.0F, -11.0F, 12.0F, 7.0F, 20.0F, new Dilation(0.0F))
		.uv(34, 138).cuboid(-3.0F, -4.0F, -4.0F, 6.0F, 16.0F, 8.0F, new Dilation(0.0F))
		.uv(49, 0).cuboid(-4.0F, 7.0F, -5.0F, 8.0F, 1.0F, 10.0F, new Dilation(0.0F))
		.uv(98, 0).cuboid(-5.0F, -1.0F, -7.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F))
		.uv(66, 81).cuboid(3.0F, -1.0F, -7.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F))
		.uv(37, 61).cuboid(2.0F, -1.0F, 4.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F))
		.uv(29, 61).cuboid(-4.0F, -1.0F, 4.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F))
		.uv(54, 18).cuboid(-6.0F, 2.0F, -9.0F, 12.0F, 7.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -23.0F, 1.0F));

		ModelPartData catapiller = pelvis.addChild("catapiller", ModelPartBuilder.create().uv(31, 104).cuboid(-9.0F, -4.0F, -14.5F, 8.0F, 12.0F, 15.0F, new Dilation(0.0F))
		.uv(92, 41).cuboid(-10.0F, -5.0F, -15.5F, 10.0F, 5.0F, 17.0F, new Dilation(0.0F))
		.uv(129, 35).cuboid(-9.0F, 0.0F, 0.5F, 8.0F, 8.0F, 12.0F, new Dilation(0.0F))
		.uv(118, 63).cuboid(-10.0F, -1.0F, -1.5F, 10.0F, 4.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, 15.0F, -0.5F));

		ModelPartData catapiller2 = pelvis.addChild("catapiller2", ModelPartBuilder.create().uv(94, 0).cuboid(1.0F, -4.0F, -14.5F, 8.0F, 12.0F, 15.0F, new Dilation(0.0F))
		.uv(29, 82).cuboid(0.0F, -5.0F, -15.5F, 10.0F, 5.0F, 17.0F, new Dilation(0.0F))
		.uv(77, 105).cuboid(0.0F, -1.0F, -2.5F, 10.0F, 4.0F, 16.0F, new Dilation(0.0F))
		.uv(128, 15).cuboid(1.0F, 0.0F, 0.5F, 8.0F, 8.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, 15.0F, -0.5F));

		ModelPartData pipe2 = pelvis.addChild("pipe2", ModelPartBuilder.create().uv(56, 48).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(8, 2).cuboid(-1.0F, -3.0F, 1.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 16).cuboid(-1.0F, -3.0F, 2.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.3F)), ModelTransform.of(5.0F, 11.0F, 8.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData pipe = pelvis.addChild("pipe", ModelPartBuilder.create().uv(75, 0).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(63, 11).cuboid(-1.0F, -3.0F, 1.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(10, 16).cuboid(-1.0F, -3.0F, 2.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.3F)), ModelTransform.of(-5.0F, 11.0F, 8.0F, -0.1745F, 0.0F, 0.0F));

		return TexturedModelData.of(meshdefinition, 256, 256);
	}

	@Override
	public void setAngles(The_Prowler_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.upperbody.yaw += netHeadYaw * 0.6F * MathHelper.RADIANS_PER_DEGREE;
		float sawspeed = entity.getAttackState() == 3 ? 0F : 0.5f;
		this.updateAnimation(entity.getAnimationState("death"), Prowler_Animation.DEATH, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("idle"), Prowler_Animation.IDLE, ageInTicks, 1.0f);
		this.updateAnimation(entity.getAnimationState("spin"), Prowler_Animation.SPIN, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("melee"), Prowler_Animation.MELEE, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("strong_attack"), Prowler_Animation.STRONG_ATTACK, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("stun"), Prowler_Animation.STUN, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("laser"), Prowler_Animation.LASER, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("pierce"), Prowler_Animation.PIERCE, ageInTicks, 1.0F);
		saw.pitch -= ageInTicks * sawspeed;
	}

	public ModelPart getPart() {
		return this.root;
	}

}