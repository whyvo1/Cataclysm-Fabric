package com.github.l_ender.cataclysm.client.model.entity;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.l_ender.cataclysm.client.animation.Netherite_Ministrosity_Animation;
import com.github.l_ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;

public class Netherite_Ministrosity_Model extends SinglePartEntityModel<Netherite_Ministrosity_Entity> {

	private final ModelPart root;
	private final ModelPart roots;
	private final ModelPart mid_root;
	private final ModelPart legs;
	private final ModelPart body;
	private final ModelPart jaw;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	public Netherite_Ministrosity_Model(ModelPart root) {
		this.root = root;
		this.roots = this.root.getChild("roots");
		this.mid_root = this.roots.getChild("mid_root");
		this.legs = this.mid_root.getChild("legs");
		this.body = this.legs.getChild("body");
		this.jaw = this.body.getChild("jaw");
		this.right_arm = this.body.getChild("right_arm");
		this.left_arm = this.body.getChild("left_arm");
		this.right_leg = this.legs.getChild("right_leg");
		this.left_leg = this.legs.getChild("left_leg");
	}

	public static TexturedModelData createBodyLayer() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData roots = partdefinition.addChild("roots", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData mid_root = roots.addChild("mid_root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData legs = mid_root.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -4.0F, 0.0F));

		ModelPartData body = legs.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -5.0F, -3.5F, 7.0F, 5.0F, 7.0F, new Dilation(0.0F))
				.uv(1, 28).cuboid(-3.5F, -6.0F, -3.5F, 7.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData jaw = body.addChild("jaw", ModelPartBuilder.create().uv(0, 14).cuboid(-3.5F, -6.0F, -7.0F, 7.0F, 5.0F, 7.0F, new Dilation(0.0F))
				.uv(44, 16).cuboid(-1.0F, -3.0F, -7.1F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
				.uv(30, 10).cuboid(-6.5F, -6.0F, -3.5F, 13.0F, 5.0F, 0.0F, new Dilation(0.0F))
				.uv(29, 0).cuboid(-3.5F, -1.0F, -7.0F, 7.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, 3.5F));

		ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create().uv(29, 16).cuboid(-4.5F, -1.0F, -2.0F, 5.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(30, 34).cuboid(-5.5F, -1.0F, -2.0F, 1.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.7418F));

		ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create().uv(29, 25).cuboid(-0.5F, -1.0F, -2.0F, 5.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(41, 34).cuboid(4.5F, -1.0F, -2.0F, 1.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		ModelPartData right_leg = legs.addChild("right_leg", ModelPartBuilder.create().uv(0, 36).cuboid(-1.475F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 0.0F, 0.0F));

		ModelPartData left_leg = legs.addChild("left_leg", ModelPartBuilder.create().uv(15, 37).cuboid(-1.525F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 0.0F, 0.0F));

		return TexturedModelData.of(meshdefinition, 64, 64);
	}

	@Override
	public void setAngles(Netherite_Ministrosity_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		this.updateAnimation(entity.getAnimationState("idle"), Netherite_Ministrosity_Animation.IDLE, ageInTicks, 1.0F);
		this.animateMovement(Netherite_Ministrosity_Animation.WALK, limbSwing, limbSwingAmount, 2.0F, 2.0F);
		this.updateAnimation(entity.getAnimationState("sleep"), Netherite_Ministrosity_Animation.SLEEP, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("operation"), Netherite_Ministrosity_Animation.OPERATION, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("chest_open"), Netherite_Ministrosity_Animation.CHEST_OPEN, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("chest_loop"), Netherite_Ministrosity_Animation.CHEST_LOOP, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("chest_close"), Netherite_Ministrosity_Animation.CHEST_CLOSE, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("sit_start"), Netherite_Ministrosity_Animation.SIT, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("sit_end"), Netherite_Ministrosity_Animation.SIT_END, ageInTicks, 1.0F);
	}


	private void animateHeadLookTarget(float yRot, float xRot) {
		//this.mid_root.xRot = xRot * ((float) Math.PI / 180F);
		this.roots.yaw = yRot * ((float) Math.PI / 180F);
	}


	public ModelPart getPart() {
		return this.root;
	}

}