package com.github.l_ender.cataclysm.client.model.entity;
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.github.l_ender.cataclysm.client.animation.Aptrgangr_Animation;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class Aptrgangr_Model extends SinglePartEntityModel<Aptrgangr_Entity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart root;
	private final ModelPart roots;
	private final ModelPart l_leg;
	private final ModelPart l_leg_armor;
	private final ModelPart left_leg_r1;
	private final ModelPart left_leg_r2;
	private final ModelPart r_leg;
	private final ModelPart r_leg_armor;
	private final ModelPart right_leg_r1;
	private final ModelPart right_leg_r2;
	private final ModelPart body;
	private final ModelPart chest;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart helmet;
	private final ModelPart head_r1;
	private final ModelPart head_r2;
	private final ModelPart head_r3;
	private final ModelPart head_r4;
	private final ModelPart head_r5;
	private final ModelPart head_r6;
	private final ModelPart jaw;
	private final ModelPart head_r7;
	private final ModelPart chestplate;
	private final ModelPart body_r1;
	private final ModelPart body_r2;
	private final ModelPart body_r3;
	private final ModelPart body_r4;
	private final ModelPart body_r5;
	private final ModelPart body_r6;
	private final ModelPart body_r7;
	private final ModelPart l_arm;
	private final ModelPart l_arm_armor;
	private final ModelPart right_arm_r1;
	private final ModelPart right_arm_r2;
	private final ModelPart right_arm_r3;
	private final ModelPart right_arm_r4;
	private final ModelPart right_arm_r5;
	private final ModelPart right_arm_r6;
	private final ModelPart arrow;
	private final ModelPart arrow2;
	private final ModelPart left_arm2;
	private final ModelPart l_arm_cloth;
	private final ModelPart hold;
	private final ModelPart r_arm;
	private final ModelPart right_arm2;
	private final ModelPart r_arm_cloth;
	private final ModelPart axe;
	private final ModelPart cube_r1;
	private final ModelPart cube_r2;
	private final ModelPart axe_head;
	private final ModelPart cube_r3;
	private final ModelPart cube_r4;
	private final ModelPart cube_r5;
	private final ModelPart cube_r6;
	private final ModelPart cube_r7;
	private final ModelPart cube_r8;
	private final ModelPart emblem3;
	private final ModelPart right_arm_r7;
	private final ModelPart emblem4;
	private final ModelPart r_arm_armor;
	private final ModelPart left_arm_r1;
	private final ModelPart left_arm_r2;
	private final ModelPart left_arm_r3;
	private final ModelPart left_arm_r4;
	private final ModelPart left_arm_r5;
	private final ModelPart left_arm_r6;
	private final ModelPart belt;
	private final ModelPart body_r8;
	private final ModelPart emblem2;
	private final ModelPart emblem;
	private final ModelPart cloth2;
	private final ModelPart cloth;

	public Aptrgangr_Model(ModelPart root) {
		this.root = root;
		this.roots = this.root.getChild("roots");
		this.l_leg = this.roots.getChild("l_leg");
		this.l_leg_armor = this.l_leg.getChild("l_leg_armor");
		this.left_leg_r1 = this.l_leg_armor.getChild("left_leg_r1");
		this.left_leg_r2 = this.l_leg_armor.getChild("left_leg_r2");
		this.r_leg = this.roots.getChild("r_leg");
		this.r_leg_armor = this.r_leg.getChild("r_leg_armor");
		this.right_leg_r1 = this.r_leg_armor.getChild("right_leg_r1");
		this.right_leg_r2 = this.r_leg_armor.getChild("right_leg_r2");
		this.body = this.roots.getChild("body");
		this.chest = this.body.getChild("chest");
		this.neck = this.chest.getChild("neck");
		this.head = this.neck.getChild("head");
		this.helmet = this.head.getChild("helmet");
		this.head_r1 = this.helmet.getChild("head_r1");
		this.head_r2 = this.helmet.getChild("head_r2");
		this.head_r3 = this.helmet.getChild("head_r3");
		this.head_r4 = this.helmet.getChild("head_r4");
		this.head_r5 = this.helmet.getChild("head_r5");
		this.head_r6 = this.helmet.getChild("head_r6");
		this.jaw = this.head.getChild("jaw");
		this.head_r7 = this.jaw.getChild("head_r7");
		this.chestplate = this.chest.getChild("chestplate");
		this.body_r1 = this.chestplate.getChild("body_r1");
		this.body_r2 = this.chestplate.getChild("body_r2");
		this.body_r3 = this.chestplate.getChild("body_r3");
		this.body_r4 = this.chestplate.getChild("body_r4");
		this.body_r5 = this.chestplate.getChild("body_r5");
		this.body_r6 = this.chestplate.getChild("body_r6");
		this.body_r7 = this.chestplate.getChild("body_r7");
		this.l_arm = this.chest.getChild("l_arm");
		this.l_arm_armor = this.l_arm.getChild("l_arm_armor");
		this.right_arm_r1 = this.l_arm_armor.getChild("right_arm_r1");
		this.right_arm_r2 = this.l_arm_armor.getChild("right_arm_r2");
		this.right_arm_r3 = this.l_arm_armor.getChild("right_arm_r3");
		this.right_arm_r4 = this.l_arm_armor.getChild("right_arm_r4");
		this.right_arm_r5 = this.l_arm_armor.getChild("right_arm_r5");
		this.right_arm_r6 = this.l_arm_armor.getChild("right_arm_r6");
		this.arrow = this.l_arm_armor.getChild("arrow");
		this.arrow2 = this.l_arm_armor.getChild("arrow2");
		this.left_arm2 = this.l_arm.getChild("left_arm2");
		this.l_arm_cloth = this.left_arm2.getChild("l_arm_cloth");
		this.hold = this.l_arm_cloth.getChild("hold");
		this.r_arm = this.chest.getChild("r_arm");
		this.right_arm2 = this.r_arm.getChild("right_arm2");
		this.r_arm_cloth = this.right_arm2.getChild("r_arm_cloth");
		this.axe = this.right_arm2.getChild("axe");
		this.cube_r1 = this.axe.getChild("cube_r1");
		this.cube_r2 = this.axe.getChild("cube_r2");
		this.axe_head = this.axe.getChild("axe_head");
		this.cube_r3 = this.axe_head.getChild("cube_r3");
		this.cube_r4 = this.axe_head.getChild("cube_r4");
		this.cube_r5 = this.axe_head.getChild("cube_r5");
		this.cube_r6 = this.axe_head.getChild("cube_r6");
		this.cube_r7 = this.axe_head.getChild("cube_r7");
		this.cube_r8 = this.axe_head.getChild("cube_r8");
		this.emblem3 = this.axe_head.getChild("emblem3");
		this.right_arm_r7 = this.emblem3.getChild("right_arm_r7");
		this.emblem4 = this.axe_head.getChild("emblem4");
		this.r_arm_armor = this.r_arm.getChild("r_arm_armor");
		this.left_arm_r1 = this.r_arm_armor.getChild("left_arm_r1");
		this.left_arm_r2 = this.r_arm_armor.getChild("left_arm_r2");
		this.left_arm_r3 = this.r_arm_armor.getChild("left_arm_r3");
		this.left_arm_r4 = this.r_arm_armor.getChild("left_arm_r4");
		this.left_arm_r5 = this.r_arm_armor.getChild("left_arm_r5");
		this.left_arm_r6 = this.r_arm_armor.getChild("left_arm_r6");
		this.belt = this.body.getChild("belt");
		this.body_r8 = this.belt.getChild("body_r8");
		this.emblem2 = this.belt.getChild("emblem2");
		this.emblem = this.belt.getChild("emblem");
		this.cloth2 = this.belt.getChild("cloth2");
		this.cloth = this.belt.getChild("cloth");
	}

	public static TexturedModelData createBodyLayer() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData roots = partdefinition.addChild("roots", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData l_leg = roots.addChild("l_leg", ModelPartBuilder.create().uv(0, 69).cuboid(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -13.0F, 0.0F));

		ModelPartData l_leg_armor = l_leg.addChild("l_leg_armor", ModelPartBuilder.create().uv(39, 91).cuboid(-3.5F, -1.0F, -3.0F, 6.0F, 4.0F, 5.0F, new Dilation(0.4F))
		.uv(0, 90).cuboid(-3.5F, 7.0F, -3.0F, 6.0F, 4.0F, 5.0F, new Dilation(0.4F))
		.uv(0, 109).cuboid(-0.5F, 3.0F, -6.5F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 141).mirrored().cuboid(-4.5F, 11.0F, -4.0F, 8.0F, 2.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData left_leg_r1 = l_leg_armor.addChild("left_leg_r1", ModelPartBuilder.create().uv(0, 105).cuboid(-1.0F, -1.0F, -1.5F, 6.0F, 6.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 99).cuboid(-2.0F, -2.0F, -1.9F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 6.0F, -2.6F, 0.0F, 0.0F, 0.7854F));

		ModelPartData left_leg_r2 = l_leg_armor.addChild("left_leg_r2", ModelPartBuilder.create().uv(0, 128).cuboid(-0.5F, -0.5F, -3.0F, 1.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -1.5F, -0.5F, 0.0F, 0.0F, -0.0873F));

		ModelPartData r_leg = roots.addChild("r_leg", ModelPartBuilder.create().uv(22, 72).cuboid(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -13.0F, 0.0F));

		ModelPartData r_leg_armor = r_leg.addChild("r_leg_armor", ModelPartBuilder.create().uv(90, 71).cuboid(-3.0F, -1.0F, 2.0F, 6.0F, 4.0F, 5.0F, new Dilation(0.4F))
		.uv(88, 62).cuboid(-3.0F, 7.0F, 2.0F, 6.0F, 4.0F, 5.0F, new Dilation(0.4F))
		.uv(0, 141).cuboid(-4.0F, 11.0F, 1.0F, 8.0F, 2.0F, 7.0F, new Dilation(0.0F))
		.uv(0, 109).mirrored().cuboid(0.0F, 3.0F, -1.5F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-0.5F, -2.0F, -5.0F));

		ModelPartData right_leg_r1 = r_leg_armor.addChild("right_leg_r1", ModelPartBuilder.create().uv(0, 105).mirrored().cuboid(-5.0F, -1.0F, -1.5F, 6.0F, 6.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 99).mirrored().cuboid(-2.0F, -2.0F, -1.9F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 6.0F, 2.4F, 0.0F, 0.0F, -0.7854F));

		ModelPartData right_leg_r2 = r_leg_armor.addChild("right_leg_r2", ModelPartBuilder.create().uv(0, 128).mirrored().cuboid(-0.5F, -0.5F, -3.0F, 1.0F, 7.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.5F, -1.5F, 4.5F, 0.0F, 0.0F, 0.0873F));

		ModelPartData body = roots.addChild("body", ModelPartBuilder.create().uv(32, 60).cuboid(-5.5F, -6.0F, -3.0F, 11.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -16.0F, 0.0F));

		ModelPartData chest = body.addChild("chest", ModelPartBuilder.create().uv(0, 0).cuboid(-9.0F, -14.0F, -6.0F, 18.0F, 14.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		ModelPartData neck = chest.addChild("neck", ModelPartBuilder.create().uv(80, 165).cuboid(-2.5F, -4.0F, -2.55F, 5.0F, 4.0F, 5.0F, new Dilation(0.0F))
		.uv(80, 165).cuboid(-2.5F, 0.0F, -2.55F, 5.0F, 4.0F, 5.0F, new Dilation(0.0F))
		.uv(100, 168).cuboid(0.0F, -4.0F, 2.45F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -14.0F, -2.45F, 0.4363F, 0.0F, 0.0F));

		ModelPartData head = neck.addChild("head", ModelPartBuilder.create().uv(0, 111).cuboid(-4.0F, -7.0F, -5.5F, 8.0F, 9.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0F, -0.55F, -0.3927F, 0.0F, 0.0F));

		ModelPartData helmet = head.addChild("helmet", ModelPartBuilder.create().uv(32, 113).cuboid(-4.0F, -2.0F, -3.5F, 8.0F, 6.0F, 8.0F, new Dilation(0.5F))
		.uv(102, 110).cuboid(-1.5F, -2.8F, -4.3F, 3.0F, 8.0F, 10.0F, new Dilation(0.0F))
		.uv(64, 120).mirrored().cuboid(-5.5F, -2.0F, -1.5F, 1.0F, 4.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
		.uv(116, 20).cuboid(-10.5F, -3.5F, 0.5F, 5.0F, 5.0F, 0.0F, new Dilation(0.0F))
		.uv(64, 120).cuboid(4.5F, -2.0F, -1.5F, 1.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(116, 0).cuboid(4.5F, -9.5F, 0.5F, 6.0F, 11.0F, 0.0F, new Dilation(0.0F))
		.uv(88, 98).cuboid(-5.0F, 3.2F, -4.3F, 10.0F, 2.0F, 10.0F, new Dilation(0.001F))
		.uv(62, 91).cuboid(-4.0F, 5.0F, -3.5F, 8.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, -2.0F));

		ModelPartData head_r1 = helmet.addChild("head_r1", ModelPartBuilder.create().uv(28, 104).mirrored().cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.4F, 3.5F, -3.8F, 0.0F, 0.0F, -0.7854F));

		ModelPartData head_r2 = helmet.addChild("head_r2", ModelPartBuilder.create().uv(42, 111).mirrored().cuboid(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(44, 106).mirrored().cuboid(0.0F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(43, 109).mirrored().cuboid(-1.0F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(29, 115).mirrored().cuboid(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.4F, 3.5F, -4.1F, 0.0F, 0.0F, -0.2618F));

		ModelPartData head_r3 = helmet.addChild("head_r3", ModelPartBuilder.create().uv(43, 108).cuboid(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 104).cuboid(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.4F, 3.5F, -4.1F, 0.0F, 0.0F, 0.2618F));

		ModelPartData head_r4 = helmet.addChild("head_r4", ModelPartBuilder.create().uv(25, 108).mirrored().cuboid(-0.5F, -1.5F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 4.8F, -4.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData head_r5 = helmet.addChild("head_r5", ModelPartBuilder.create().uv(31, 108).mirrored().cuboid(-0.5F, -1.5F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 6.2F, -4.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData head_r6 = helmet.addChild("head_r6", ModelPartBuilder.create().uv(30, 111).mirrored().cuboid(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.7F, -3.9F, 0.0F, 0.0F, -0.7854F));

		ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create().uv(34, 26).cuboid(-3.0F, 0.0F, -2.5F, 6.0F, 8.0F, 3.0F, new Dilation(0.0F))
		.uv(48, 0).cuboid(3.0F, 3.0F, 0.0F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
		.uv(48, 5).cuboid(3.0F, -2.0F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F))
		.uv(48, 5).mirrored().cuboid(-5.0F, -2.0F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
		.uv(48, 0).mirrored().cuboid(-9.0F, 3.0F, 0.0F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
		.uv(84, 1).cuboid(3.0F, 8.0F, -2.5F, 5.0F, 4.0F, 3.0F, new Dilation(0.0F))
		.uv(84, 1).mirrored().cuboid(-8.0F, 8.0F, -2.5F, 5.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
		.uv(52, 33).cuboid(-3.0F, 0.0F, 0.5F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, -3.0F));

		ModelPartData head_r7 = jaw.addChild("head_r7", ModelPartBuilder.create().uv(92, 12).cuboid(-3.0F, 0.0F, 0.0F, 6.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 8.0F, -2.5F, -0.3491F, 0.0F, 0.0F));

		ModelPartData chestplate = chest.addChild("chestplate", ModelPartBuilder.create().uv(0, 150).cuboid(-6.0F, -3.0F, -9.0F, 12.0F, 7.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 159).cuboid(-4.0F, 4.0F, -9.0F, 8.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 180).cuboid(-9.0F, 3.0F, -7.0F, 18.0F, 2.0F, 12.0F, new Dilation(0.2F))
		.uv(68, 174).cuboid(-5.0F, -5.0F, -7.0F, 10.0F, 6.0F, 12.0F, new Dilation(0.1F))
		.uv(0, 165).cuboid(-6.0F, -3.0F, -9.0F, 12.0F, 7.0F, 2.0F, new Dilation(-0.1F))
		.uv(0, 174).cuboid(-4.0F, 4.0F, -9.0F, 8.0F, 4.0F, 2.0F, new Dilation(-0.1F)), ModelTransform.pivot(0.0F, -9.0F, 1.0F));

		ModelPartData body_r1 = chestplate.addChild("body_r1", ModelPartBuilder.create().uv(48, 182).cuboid(-4.0F, -4.0F, -1.0F, 8.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 6.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData body_r2 = chestplate.addChild("body_r2", ModelPartBuilder.create().uv(0, 188).cuboid(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(6.5F, 4.0F, -7.3F, 0.0F, 0.2618F, 0.1309F));

		ModelPartData body_r3 = chestplate.addChild("body_r3", ModelPartBuilder.create().uv(0, 188).mirrored().cuboid(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-6.5F, 4.0F, -7.3F, 0.0F, -0.2618F, -0.1309F));

		ModelPartData body_r4 = chestplate.addChild("body_r4", ModelPartBuilder.create().uv(0, 188).mirrored().cuboid(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-6.5F, -3.0F, -7.3F, 0.0F, -0.2618F, 0.5236F));

		ModelPartData body_r5 = chestplate.addChild("body_r5", ModelPartBuilder.create().uv(0, 194).mirrored().cuboid(-0.5F, -1.0F, -6.0F, 9.0F, 2.0F, 12.0F, new Dilation(0.1F)).mirrored(false), ModelTransform.of(-9.0F, -4.5F, -1.0F, 0.0F, 0.0F, 0.5236F));

		ModelPartData body_r6 = chestplate.addChild("body_r6", ModelPartBuilder.create().uv(0, 188).cuboid(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(6.5F, -3.0F, -7.3F, 0.0F, 0.2618F, -0.5236F));

		ModelPartData body_r7 = chestplate.addChild("body_r7", ModelPartBuilder.create().uv(0, 194).cuboid(-8.5F, -1.0F, -6.0F, 9.0F, 2.0F, 12.0F, new Dilation(0.1F)), ModelTransform.of(9.0F, -4.5F, -1.0F, 0.0F, 0.0F, -0.5236F));

		ModelPartData l_arm = chest.addChild("l_arm", ModelPartBuilder.create().uv(0, 49).cuboid(-3.0F, -2.5F, -4.0F, 8.0F, 12.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(12.0F, -12.5F, 0.0F, 0.0F, 0.0F, -0.0873F));

		ModelPartData l_arm_armor = l_arm.addChild("l_arm_armor", ModelPartBuilder.create().uv(112, 56).mirrored().cuboid(-4.5086F, -5.3695F, -7.0F, 2.0F, 10.0F, 14.0F, new Dilation(0.0F)).mirrored(false)
		.uv(130, 66).mirrored().cuboid(-4.5086F, 4.6305F, -7.0F, 12.0F, 2.0F, 14.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 26).mirrored().cuboid(-4.5086F, -4.3695F, -6.0F, 11.0F, 11.0F, 12.0F, new Dilation(0.0F)).mirrored(false)
		.uv(138, 36).mirrored().cuboid(6.4914F, -3.3695F, -3.0F, 2.0F, 6.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
		.uv(106, 36).mirrored().cuboid(-1.5086F, -4.3695F, -6.0F, 8.0F, 8.0F, 12.0F, new Dilation(0.2F)).mirrored(false)
		.uv(154, 40).mirrored().cuboid(0.4914F, -3.3695F, -7.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
		.uv(166, 38).mirrored().cuboid(2.4914F, -4.3695F, -11.0F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
		.uv(162, 46).mirrored().cuboid(1.4914F, -1.3695F, -11.0F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
		.uv(142, 55).mirrored().cuboid(8.4914F, -0.3695F, -2.0F, 6.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
		.uv(146, 49).mirrored().cuboid(8.4914F, -4.3695F, 0.0F, 6.0F, 6.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		ModelPartData right_arm_r1 = l_arm_armor.addChild("right_arm_r1", ModelPartBuilder.create().uv(168, 68).mirrored().cuboid(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, new Dilation(-0.1F)).mirrored(false)
		.uv(168, 74).mirrored().cuboid(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(182, 75).mirrored().cuboid(-6.5F, -0.5F, 0.5F, 7.0F, 7.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.0086F, 5.1305F, -8.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData right_arm_r2 = l_arm_armor.addChild("right_arm_r2", ModelPartBuilder.create().uv(130, 82).mirrored().cuboid(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.4914F, 6.6305F, 6.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData right_arm_r3 = l_arm_armor.addChild("right_arm_r3", ModelPartBuilder.create().uv(130, 82).mirrored().cuboid(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.4914F, 6.6305F, -6.0F, -0.3491F, 0.0F, 0.0F));

		ModelPartData right_arm_r4 = l_arm_armor.addChild("right_arm_r4", ModelPartBuilder.create().uv(154, 68).mirrored().cuboid(0.0F, 0.0F, -7.0F, 0.0F, 4.0F, 14.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(6.4914F, 6.6305F, 0.0F, 0.0F, 0.0F, -0.3491F));

		ModelPartData right_arm_r5 = l_arm_armor.addChild("right_arm_r5", ModelPartBuilder.create().uv(162, 46).mirrored().cuboid(-1.0F, 0.0F, -2.0F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
		.uv(166, 38).mirrored().cuboid(0.0F, -3.0F, -2.0F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.4914F, -1.3695F, 9.0F, 0.0F, -3.1416F, 0.0F));

		ModelPartData right_arm_r6 = l_arm_armor.addChild("right_arm_r6", ModelPartBuilder.create().uv(154, 40).mirrored().cuboid(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.4914F, -1.3695F, 6.0F, 0.0F, -3.1416F, 0.0F));

		ModelPartData arrow = l_arm_armor.addChild("arrow", ModelPartBuilder.create().uv(128, 100).cuboid(-8.0F, -2.5F, 0.0F, 16.0F, 5.0F, 0.0F, new Dilation(0.0F))
		.uv(128, 100).cuboid(-7.0F, -2.5F, -2.5F, 0.0F, 5.0F, 5.0F, new Dilation(0.0F))
		.uv(123, 100).cuboid(-8.0F, 0.0F, -2.5F, 16.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -3.0F, -5.0F, 0.0F, -0.4363F, 1.7453F));

		ModelPartData arrow2 = l_arm_armor.addChild("arrow2", ModelPartBuilder.create().uv(128, 100).cuboid(-8.0F, -2.5F, 0.0F, 16.0F, 5.0F, 0.0F, new Dilation(0.0F))
		.uv(128, 100).cuboid(-7.0F, -2.5F, -2.5F, 0.0F, 5.0F, 5.0F, new Dilation(0.0F))
		.uv(123, 100).cuboid(-8.0F, 0.0F, -2.5F, 16.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(2.5F, -6.0F, 1.0F, 0.0385F, 0.2148F, 1.924F));

		ModelPartData left_arm2 = l_arm.addChild("left_arm2", ModelPartBuilder.create().uv(70, 75).cuboid(-3.0F, 0.0F, -3.0F, 7.0F, 10.0F, 6.0F, new Dilation(0.0F))
		.uv(80, 49).cuboid(-4.0F, 10.0F, -3.0F, 7.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 9.5F, 0.0F));

		ModelPartData l_arm_cloth = left_arm2.addChild("l_arm_cloth", ModelPartBuilder.create().uv(88, 31).cuboid(-3.5F, -4.25F, -3.0F, 7.0F, 5.0F, 6.0F, new Dilation(0.5F))
		.uv(109, 129).mirrored().cuboid(-4.5F, 0.75F, -4.0F, 9.0F, 2.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.5F, 7.25F, 0.0F));

		ModelPartData hold = l_arm_cloth.addChild("hold", ModelPartBuilder.create(), ModelTransform.pivot(10.5F, -2.0F, 2.0F));

		ModelPartData r_arm = chest.addChild("r_arm", ModelPartBuilder.create().uv(60, 0).cuboid(-5.0F, -2.5F, -4.0F, 8.0F, 12.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, -12.5F, 0.0F, -1.044F, 0.2117F, 0.25F));

		ModelPartData right_arm2 = r_arm.addChild("right_arm2", ModelPartBuilder.create().uv(44, 75).cuboid(-4.0F, 0.0F, -3.0F, 7.0F, 10.0F, 6.0F, new Dilation(0.0F))
		.uv(68, 36).cuboid(-3.0F, 10.0F, -3.0F, 7.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 9.5F, 0.0F, -1.9635F, 0.0F, 0.0F));

		ModelPartData r_arm_cloth = right_arm2.addChild("r_arm_cloth", ModelPartBuilder.create().uv(84, 20).cuboid(-3.5F, -4.25F, -3.0F, 7.0F, 5.0F, 6.0F, new Dilation(0.5F))
		.uv(109, 129).cuboid(-4.5F, 0.75F, -4.0F, 9.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 7.25F, 0.0F));

		ModelPartData axe = right_arm2.addChild("axe", ModelPartBuilder.create().uv(3, 205).cuboid(-1.5F, -1.5F, -32.0F, 3.0F, 3.0F, 48.0F, new Dilation(0.0F))
		.uv(56, 241).cuboid(-3.5F, 0.0F, -31.0F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F))
		.uv(3, 205).cuboid(-1.5F, -1.5F, -32.0F, 3.0F, 3.0F, 48.0F, new Dilation(0.0F))
		.uv(26, 241).cuboid(-1.5F, -1.5F, -25.0F, 3.0F, 3.0F, 9.0F, new Dilation(0.2F))
		.uv(26, 241).cuboid(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 9.0F, new Dilation(0.2F))
		.uv(25, 245).cuboid(-1.5F, -1.5F, -18.0F, 3.0F, 3.0F, 2.0F, new Dilation(0.4F))
		.uv(25, 245).cuboid(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 2.0F, new Dilation(0.4F))
		.uv(25, 245).cuboid(-1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 2.0F, new Dilation(0.4F))
		.uv(57, 245).cuboid(-2.5F, -2.5F, -28.0F, 5.0F, 5.0F, 3.0F, new Dilation(0.0F))
		.uv(57, 245).cuboid(-2.5F, -2.5F, 15.0F, 5.0F, 5.0F, 3.0F, new Dilation(0.0F))
		.uv(60, 228).cuboid(-3.5F, 0.0F, 17.0F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F))
		.uv(64, 228).cuboid(1.4F, 0.0F, 17.0F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F))
		.uv(60, 231).cuboid(-0.1F, 1.5F, 17.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(60, 233).cuboid(-0.1F, -3.5F, 17.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(60, 241).cuboid(1.5F, 0.0F, -31.0F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, 13.5F, 0.0F));

		ModelPartData cube_r1 = axe.addChild("cube_r1", ModelPartBuilder.create().uv(60, 241).cuboid(1.5F, 0.0F, -2.0F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F))
		.uv(56, 241).cuboid(-3.5F, 0.0F, -2.0F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -29.0F, 0.0F, 0.0F, -1.5708F));

		ModelPartData cube_r2 = axe.addChild("cube_r2", ModelPartBuilder.create().uv(68, 231).cuboid(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 20.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData axe_head = axe.addChild("axe_head", ModelPartBuilder.create().uv(111, 249).cuboid(-1.5F, -1.5F, -14.0F, 3.0F, 3.0F, 4.0F, new Dilation(0.2F))
		.uv(68, 231).cuboid(-1.5F, -1.5F, -13.8F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F))
		.uv(122, 203).cuboid(-0.5F, 7.4F, -8.8F, 1.0F, 10.0F, 9.0F, new Dilation(-0.001F))
		.uv(0, 236).cuboid(-1.5F, -5.5F, -5.8F, 3.0F, 11.0F, 6.0F, new Dilation(0.3F))
		.uv(97, 232).cuboid(-1.5F, -7.5F, -9.6F, 3.0F, 15.0F, 6.0F, new Dilation(0.2F))
		.uv(73, 229).cuboid(-1.5F, -7.5F, -8.8F, 3.0F, 15.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -32.2F));

		ModelPartData cube_r3 = axe_head.addChild("cube_r3", ModelPartBuilder.create().uv(81, 211).cuboid(-0.5F, -3.5F, -5.5F, 1.0F, 9.0F, 9.0F, new Dilation(0.01F)), ModelTransform.of(0.0F, -10.5F, -4.3F, 0.48F, 0.0F, 0.0F));

		ModelPartData cube_r4 = axe_head.addChild("cube_r4", ModelPartBuilder.create().uv(156, 198).cuboid(0.5F, -18.5F, -7.0F, 0.0F, 33.0F, 14.0F, new Dilation(0.001F)), ModelTransform.of(-0.5F, 19.1267F, -0.0182F, -1.0036F, 0.0F, 0.0F));

		ModelPartData cube_r5 = axe_head.addChild("cube_r5", ModelPartBuilder.create().uv(142, 206).cuboid(-0.5F, -13.5F, -1.0F, 1.0F, 16.0F, 6.0F, new Dilation(0.001F))
		.uv(104, 208).cuboid(-0.5F, 2.5F, -9.0F, 1.0F, 6.0F, 14.0F, new Dilation(0.001F)), ModelTransform.of(0.0F, 14.0647F, -3.2431F, -1.0036F, 0.0F, 0.0F));

		ModelPartData cube_r6 = axe_head.addChild("cube_r6", ModelPartBuilder.create().uv(109, 214).cuboid(0.5F, 2.5F, -9.0F, 0.0F, 6.0F, 14.0F, new Dilation(0.001F)), ModelTransform.of(-0.5F, 17.2895F, -8.3051F, -1.0036F, 0.0F, 0.0F));

		ModelPartData cube_r7 = axe_head.addChild("cube_r7", ModelPartBuilder.create().uv(64, 228).cuboid(0.0F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -15.8F, 0.0F, 0.0F, 2.3562F));

		ModelPartData cube_r8 = axe_head.addChild("cube_r8", ModelPartBuilder.create().uv(64, 228).cuboid(0.0F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -15.8F, 0.0F, 0.0F, 0.7854F));

		ModelPartData emblem3 = axe_head.addChild("emblem3", ModelPartBuilder.create().uv(168, 74).cuboid(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(168, 68).cuboid(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(-2.0F, 0.0F, -5.3F, 1.5708F, -0.7854F, 1.5708F));

		ModelPartData right_arm_r7 = emblem3.addChild("right_arm_r7", ModelPartBuilder.create().uv(169, 204).mirrored().cuboid(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.5F, 0.5F, -0.5F, 0.0F, 0.0F, -1.5708F));

		ModelPartData emblem4 = axe_head.addChild("emblem4", ModelPartBuilder.create().uv(168, 74).mirrored().cuboid(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(169, 204).mirrored().cuboid(-4.5F, -3.5F, -0.5F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
		.uv(168, 68).mirrored().cuboid(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new Dilation(-0.1F)).mirrored(false), ModelTransform.of(2.0F, 0.0F, -5.3F, 1.5708F, 0.7854F, -1.5708F));

		ModelPartData r_arm_armor = r_arm.addChild("r_arm_armor", ModelPartBuilder.create().uv(112, 56).cuboid(2.5086F, -5.3695F, -7.0F, 2.0F, 10.0F, 14.0F, new Dilation(0.0F))
		.uv(130, 86).cuboid(2.5086F, -3.3695F, -7.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.1F))
		.uv(130, 66).cuboid(-7.4914F, 4.6305F, -7.0F, 12.0F, 2.0F, 14.0F, new Dilation(0.0F))
		.uv(0, 26).cuboid(-6.4914F, -4.3695F, -6.0F, 11.0F, 11.0F, 12.0F, new Dilation(0.0F))
		.uv(138, 36).cuboid(-8.4914F, -3.3695F, -3.0F, 2.0F, 6.0F, 6.0F, new Dilation(0.0F))
		.uv(106, 36).cuboid(-6.4914F, -4.3695F, -6.0F, 8.0F, 8.0F, 12.0F, new Dilation(0.2F))
		.uv(154, 40).cuboid(-4.4914F, -3.3695F, -7.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(166, 38).cuboid(-2.4914F, -4.3695F, -11.0F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(162, 46).cuboid(-3.4914F, -1.3695F, -11.0F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F))
		.uv(142, 55).cuboid(-14.4914F, -0.3695F, -2.0F, 6.0F, 0.0F, 4.0F, new Dilation(0.0F))
		.uv(146, 49).cuboid(-14.4914F, -4.3695F, 0.0F, 6.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		ModelPartData left_arm_r1 = r_arm_armor.addChild("left_arm_r1", ModelPartBuilder.create().uv(168, 68).cuboid(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, new Dilation(-0.1F))
		.uv(168, 74).cuboid(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(182, 75).cuboid(-0.5F, -0.5F, 0.5F, 7.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.0086F, 5.1305F, -8.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData left_arm_r2 = r_arm_armor.addChild("left_arm_r2", ModelPartBuilder.create().uv(130, 82).cuboid(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.4914F, 6.6305F, 6.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData left_arm_r3 = r_arm_armor.addChild("left_arm_r3", ModelPartBuilder.create().uv(130, 82).cuboid(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.4914F, 6.6305F, -6.0F, -0.3491F, 0.0F, 0.0F));

		ModelPartData left_arm_r4 = r_arm_armor.addChild("left_arm_r4", ModelPartBuilder.create().uv(154, 68).cuboid(0.0F, 0.0F, -7.0F, 0.0F, 4.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(-6.4914F, 6.6305F, 0.0F, 0.0F, 0.0F, 0.3491F));

		ModelPartData left_arm_r5 = r_arm_armor.addChild("left_arm_r5", ModelPartBuilder.create().uv(162, 46).cuboid(-1.0F, 0.0F, -2.0F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F))
		.uv(166, 38).cuboid(0.0F, -3.0F, -2.0F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-2.4914F, -1.3695F, 9.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData left_arm_r6 = r_arm_armor.addChild("left_arm_r6", ModelPartBuilder.create().uv(154, 40).cuboid(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.4914F, -1.3695F, 6.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData belt = body.addChild("belt", ModelPartBuilder.create().uv(95, 131).cuboid(3.5F, -19.0F, -4.0F, 3.0F, 5.0F, 8.0F, new Dilation(0.0F))
		.uv(100, 144).cuboid(6.5F, -17.0F, -2.0F, 3.0F, 0.0F, 3.0F, new Dilation(0.0F))
		.uv(100, 144).mirrored().cuboid(-9.5F, -17.0F, -2.0F, 3.0F, 0.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
		.uv(95, 131).mirrored().cuboid(-6.5F, -19.0F, -4.0F, 3.0F, 5.0F, 8.0F, new Dilation(0.0F)).mirrored(false)
		.uv(60, 66).cuboid(-5.5F, -17.0F, -3.0F, 11.0F, 3.0F, 6.0F, new Dilation(0.5F))
		.uv(157, 86).cuboid(-5.5F, -19.0F, -3.0F, 11.0F, 3.0F, 6.0F, new Dilation(0.3F)), ModelTransform.pivot(0.0F, 14.0F, 0.0F));

		ModelPartData body_r8 = belt.addChild("body_r8", ModelPartBuilder.create().uv(100, 144).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 0.0F, 3.0F, new Dilation(0.0F))
		.uv(100, 144).mirrored().cuboid(-17.5F, 0.0F, -1.5F, 3.0F, 0.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(8.0F, -17.0F, -0.5F, -1.5708F, 0.0F, 0.0F));

		ModelPartData emblem2 = belt.addChild("emblem2", ModelPartBuilder.create().uv(168, 74).cuboid(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(168, 68).cuboid(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -15.5F, 3.5F, 3.1416F, 0.0F, 2.3562F));

		ModelPartData emblem = belt.addChild("emblem", ModelPartBuilder.create().uv(168, 74).cuboid(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(168, 68).cuboid(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -15.5F, -3.5F, 0.0F, 0.0F, 0.7854F));

		ModelPartData cloth2 = belt.addChild("cloth2", ModelPartBuilder.create().uv(46, 127).cuboid(-4.5F, 0.0F, 0.0F, 9.0F, 12.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -13.5F, 3.5F));

		ModelPartData cloth = belt.addChild("cloth", ModelPartBuilder.create().uv(46, 127).cuboid(-4.5F, 0.0F, 0.0F, 9.0F, 12.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -13.5F, -3.5F));

		return TexturedModelData.of(meshdefinition, 256, 256);
	}
	@Override
	public void setAngles(Aptrgangr_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		if(entity.getAttackState() != 4) {
			this.animateMovement(Aptrgangr_Animation.WALK, limbSwing, limbSwingAmount, 2.5F, 4.0F);
		}
		this.updateAnimation(entity.getAnimationState("idle"), Aptrgangr_Animation.IDLE, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("swing_right"), Aptrgangr_Animation.SWING_RIGHT, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("smash"), Aptrgangr_Animation.SMASH, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("charge_start"), Aptrgangr_Animation.RUSH_START, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("charge"), Aptrgangr_Animation.RUSHING, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("charge_end"), Aptrgangr_Animation.RUSH_END, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("charge_hit"), Aptrgangr_Animation.RUSH_HIT, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("death"), Aptrgangr_Animation.DEATH, ageInTicks, 1.0F);
	}



	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.pitch += xRot * ((float) Math.PI / 180F);
		this.head.yaw += yRot * ((float) Math.PI / 180F);
	}

	public void translateToHand(MatrixStack matrixStack) {
		this.root.rotate(matrixStack);
		this.roots.rotate(matrixStack);
		this.body.rotate(matrixStack);
		this.chest.rotate(matrixStack);
		this.l_arm.rotate(matrixStack);
		this.left_arm2.rotate(matrixStack);
		this.l_arm_cloth.rotate(matrixStack);
		this.hold.rotate(matrixStack);
	}



	public ModelPart getPart() {
		return this.root;
	}

}