package com.github.l_ender.cataclysm.client.model.entity;// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.l_ender.cataclysm.client.animation.Ignited_Berserker_Animation;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Ignited_Berserker_Entity;
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

public class Ignited_Berserker_Model<T extends Ignited_Berserker_Entity> extends SinglePartEntityModel<T> {

	private final ModelPart root;

	private final ModelPart everything;
	private final ModelPart mid_root;
	private final ModelPart rod;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart right_shoulder;
	private final ModelPart left_shoulder;
	private final ModelPart edges;
	private final ModelPart right_f_blade;
	private final ModelPart right_b_blade;
	private final ModelPart left_b_blade;
	private final ModelPart left_f_blade;

	public Ignited_Berserker_Model(ModelPart root) {
		this.root = root;
		this.everything = root.getChild("everything");
		this.mid_root = this.everything.getChild("mid_root");
		this.rod = this.mid_root.getChild("rod");
		this.body = this.rod.getChild("body");
		this.head = this.body.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.right_shoulder = this.body.getChild("right_shoulder");
		this.left_shoulder = this.body.getChild("left_shoulder");
		this.edges = this.body.getChild("edges");
		this.right_f_blade = this.edges.getChild("right_f_blade");
		this.right_b_blade = this.edges.getChild("right_b_blade");
		this.left_b_blade = this.edges.getChild("left_b_blade");
		this.left_f_blade = this.edges.getChild("left_f_blade");
	}

	public static TexturedModelData createBodyLayer() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData everything = partdefinition.addChild("everything", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData mid_root = everything.addChild("mid_root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rod = mid_root.addChild("rod", ModelPartBuilder.create(), ModelTransform.of(0.0F, -16.0F, -0.5F, 0.0873F, 0.0F, 0.0F));

		ModelPartData guard1 = rod.addChild("guard1", ModelPartBuilder.create().uv(13, 40).cuboid(-1.5F, -9.0F, -1.5F, 3.0F, 19.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.5F, 0.0F, -0.7854F, 0.0F));

		ModelPartData body = rod.addChild("body", ModelPartBuilder.create().uv(0, 17).cuboid(-4.0F, -5.0F, -3.5F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, 2.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, -1.5F));

		ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create().uv(46, 47).cuboid(-3.0F, 0.0F, -4.0F, 6.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

		ModelPartData right_shoulder = body.addChild("right_shoulder", ModelPartBuilder.create().uv(51, 31).cuboid(-3.0F, -2.0F, -1.0F, 4.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, -2.0F, 0.0F, 0.0F, -0.1309F));

		ModelPartData left_shoulder = body.addChild("left_shoulder", ModelPartBuilder.create().uv(51, 24).cuboid(-1.0F, -2.0F, -1.0F, 4.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -4.0F, -2.0F, 0.0F, 0.0F, 0.1309F));

		ModelPartData edges = body.addChild("edges", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 5.0F, -1.5F));

		ModelPartData right_f_blade = edges.addChild("right_f_blade", ModelPartBuilder.create().uv(26, 57).cuboid(-0.9899F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F))
				.uv(38, 26).cuboid(-2.5F, -25.25F, -0.5F, 5.0F, 24.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-11.0F, -2.0F, -11.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData guard2 = right_f_blade.addChild("guard2", ModelPartBuilder.create().uv(18, 64).cuboid(-2.4F, 3.0F, -0.5F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 60).cuboid(-3.4F, 4.0F, -0.5F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.9899F, -4.0F, -0.5F, 0.0F, 0.0F, -0.7854F));

		ModelPartData guard3 = right_f_blade.addChild("guard3", ModelPartBuilder.create().uv(60, 38).cuboid(0.4F, 4.0F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(64, 22).cuboid(0.4F, 3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(64, 63).cuboid(-1.6F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData guard4 = right_f_blade.addChild("guard4", ModelPartBuilder.create().uv(50, 64).cuboid(-0.4F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData guard5 = right_f_blade.addChild("guard5", ModelPartBuilder.create().uv(51, 16).cuboid(0.4F, -1.0F, -1.5F, 4.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData right_b_blade = edges.addChild("right_b_blade", ModelPartBuilder.create().uv(48, 55).cuboid(-0.9899F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F))
				.uv(38, 0).cuboid(-2.5F, -25.25F, -0.5F, 5.0F, 24.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-11.0F, -2.0F, 11.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData guard6 = right_b_blade.addChild("guard6", ModelPartBuilder.create().uv(64, 6).cuboid(-2.4F, 3.0F, -1.5F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(57, 55).cuboid(-3.4F, 4.0F, -1.5F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.9899F, -4.0F, 0.5F, 0.0F, 0.0F, -0.7854F));

		ModelPartData guard7 = right_b_blade.addChild("guard7", ModelPartBuilder.create().uv(57, 59).cuboid(0.4F, 4.0F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(64, 14).cuboid(0.4F, 3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(64, 46).cuboid(-1.6F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData guard8 = right_b_blade.addChild("guard8", ModelPartBuilder.create().uv(45, 64).cuboid(-0.4F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData guard9 = right_b_blade.addChild("guard9", ModelPartBuilder.create().uv(51, 8).cuboid(0.4F, -1.0F, -1.5F, 4.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData left_b_blade = edges.addChild("left_b_blade", ModelPartBuilder.create().uv(39, 55).cuboid(-1.0101F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 34).cuboid(-2.5F, -25.25F, -0.5F, 5.0F, 24.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(11.0F, -2.0F, 11.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData guard10 = left_b_blade.addChild("guard10", ModelPartBuilder.create().uv(55, 63).cuboid(0.4F, 3.0F, -1.5F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(13, 34).cuboid(0.4F, 4.0F, -1.5F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.9899F, -4.0F, 0.5F, 0.0F, 0.0F, 0.7854F));

		ModelPartData guard11 = left_b_blade.addChild("guard11", ModelPartBuilder.create().uv(26, 43).cuboid(-3.4F, 4.0F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 64).cuboid(-2.4F, 3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(40, 64).cuboid(-0.4F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData guard12 = left_b_blade.addChild("guard12", ModelPartBuilder.create().uv(35, 64).cuboid(-1.6F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData guard13 = left_b_blade.addChild("guard13", ModelPartBuilder.create().uv(51, 0).cuboid(-4.4F, -1.0F, -1.5F, 4.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData left_f_blade = edges.addChild("left_f_blade", ModelPartBuilder.create().uv(51, 38).cuboid(-1.0101F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F))
				.uv(25, 17).cuboid(-2.5F, -25.25F, -0.5F, 5.0F, 24.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(11.0F, -2.0F, -11.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData guard14 = left_f_blade.addChild("guard14", ModelPartBuilder.create().uv(60, 42).cuboid(0.4F, 3.0F, -0.5F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(25, 0).cuboid(0.4F, 4.0F, -0.5F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.9899F, -4.0F, -0.5F, 0.0F, 0.0F, 0.7854F));

		ModelPartData guard15 = left_f_blade.addChild("guard15", ModelPartBuilder.create().uv(25, 4).cuboid(-3.4F, 4.0F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(9, 63).cuboid(-2.4F, 3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(33, 8).cuboid(-0.4F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData guard16 = left_f_blade.addChild("guard16", ModelPartBuilder.create().uv(0, 0).cuboid(-1.6F, -1.0F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData guard17 = left_f_blade.addChild("guard17", ModelPartBuilder.create().uv(26, 49).cuboid(-4.4F, -1.0F, -1.5F, 4.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.9899F, -4.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		return TexturedModelData.of(meshdefinition, 128, 128);
	}

	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateHeadLookTarget(netHeadYaw, headPitch);
		if(entity.getAttackState() == 0) {
			this.animateMovement(Ignited_Berserker_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 2.0F);
			edges.yaw -= ageInTicks * 0.1F;
		}

		this.updateAnimation(entity.getAnimationState("idle"), Ignited_Berserker_Animation.IDLE, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("x_slash"), Ignited_Berserker_Animation.X_SLASH, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("mixer_start"), Ignited_Berserker_Animation.MIXER_START, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("mixer_idle"), Ignited_Berserker_Animation.MIXER_IDLE, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("mixer_finish"), Ignited_Berserker_Animation.MIXER_FINISH, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("sword_dance_left"), Ignited_Berserker_Animation.SWORD_DANCE_LEFT, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("sword_dance_right"), Ignited_Berserker_Animation.SWORD_DANCE_RIGHT, ageInTicks, 1.0F);

	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.pitch = xRot * ((float) Math.PI / 180F);
		this.head.yaw = yRot * ((float) Math.PI / 180F);
	}

	public ModelPart getPart() {
		return this.root;
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, alpha);
	}
}