package com.github.l_ender.cataclysm.client.model.entity;
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.l_ender.cataclysm.client.animation.Maledictus_Animation;
import com.github.l_ender.cataclysm.client.animation.Maledictus_Attack_Animation;
import com.github.l_ender.cataclysm.client.animation.Maledictus_Grab_Attack_Animation;
import com.github.l_ender.cataclysm.client.animation.Maledictus_Halberd_Animation;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class Maledictus_Model extends SinglePartEntityModel<Maledictus_Entity> {
	private final ModelPart root;
	private final ModelPart roots;
	private final ModelPart berserker;
	private final ModelPart legs;
	private final ModelPart right_leg;
	private final ModelPart cube_r1;
	private final ModelPart right_front_leg;
	private final ModelPart cube_r2;
	private final ModelPart left_leg;
	private final ModelPart cube_r3;
	private final ModelPart left_front_leg;
	private final ModelPart cube_r4;
	private final ModelPart pelvis;
	private final ModelPart front_cloth1;
	private final ModelPart front_cloth2;
	private final ModelPart body;
	private final ModelPart right_shoulder;
	private final ModelPart cube_r5;
	private final ModelPart cube_r6;
	private final ModelPart right_arm;
	private final ModelPart right_front_arm;
	private final ModelPart bow;
	private final ModelPart cube_r7;
	private final ModelPart cube_r8;
	private final ModelPart cube_r9;
	private final ModelPart bow_string;
	private final ModelPart string1;
	private final ModelPart string2;
	private final ModelPart right_mace;
	private final ModelPart cube_r10;
	private final ModelPart cube_r11;
	private final ModelPart cube_r12;
	private final ModelPart halberd;
	private final ModelPart cube_r13;
	private final ModelPart halberd2;
	private final ModelPart cube_r14;
	private final ModelPart cube_r15;
	private final ModelPart bone;
	private final ModelPart right_particle;
	private final ModelPart left_shoulder;
	private final ModelPart cube_r16;
	private final ModelPart cube_r17;
	private final ModelPart left_arm;
	private final ModelPart left_front_arm;
	private final ModelPart left_mace;
	private final ModelPart cube_r18;
	private final ModelPart cube_r19;
	private final ModelPart cube_r20;
	private final ModelPart left_particle;
	private final ModelPart head;
	private final ModelPart right_horn;
	private final ModelPart cube_r21;
	private final ModelPart left_horn;
	private final ModelPart cube_r22;
	private final ModelPart left_wing;
	private final ModelPart left_wing2;
	private final ModelPart right_wing;
	private final ModelPart right_wing2;

	public Maledictus_Model(ModelPart root) {
		this.root = root;
		this.roots = this.root.getChild("roots");
		this.berserker = this.roots.getChild("berserker");
		this.legs = this.berserker.getChild("legs");
		this.right_leg = this.legs.getChild("right_leg");
		this.cube_r1 = this.right_leg.getChild("cube_r1");
		this.right_front_leg = this.right_leg.getChild("right_front_leg");
		this.cube_r2 = this.right_front_leg.getChild("cube_r2");
		this.left_leg = this.legs.getChild("left_leg");
		this.cube_r3 = this.left_leg.getChild("cube_r3");
		this.left_front_leg = this.left_leg.getChild("left_front_leg");
		this.cube_r4 = this.left_front_leg.getChild("cube_r4");
		this.pelvis = this.berserker.getChild("pelvis");
		this.front_cloth1 = this.pelvis.getChild("front_cloth1");
		this.front_cloth2 = this.front_cloth1.getChild("front_cloth2");
		this.body = this.pelvis.getChild("body");
		this.right_shoulder = this.body.getChild("right_shoulder");
		this.cube_r5 = this.right_shoulder.getChild("cube_r5");
		this.cube_r6 = this.right_shoulder.getChild("cube_r6");
		this.right_arm = this.right_shoulder.getChild("right_arm");
		this.right_front_arm = this.right_arm.getChild("right_front_arm");
		this.bow = this.right_front_arm.getChild("bow");
		this.cube_r7 = this.bow.getChild("cube_r7");
		this.cube_r8 = this.bow.getChild("cube_r8");
		this.cube_r9 = this.bow.getChild("cube_r9");
		this.bow_string = this.bow.getChild("bow_string");
		this.string1 = this.bow_string.getChild("string1");
		this.string2 = this.bow_string.getChild("string2");
		this.right_mace = this.right_front_arm.getChild("right_mace");
		this.cube_r10 = this.right_mace.getChild("cube_r10");
		this.cube_r11 = this.right_mace.getChild("cube_r11");
		this.cube_r12 = this.right_mace.getChild("cube_r12");
		this.halberd = this.right_front_arm.getChild("halberd");
		this.cube_r13 = this.halberd.getChild("cube_r13");
		this.halberd2 = this.halberd.getChild("halberd2");
		this.cube_r14 = this.halberd2.getChild("cube_r14");
		this.cube_r15 = this.halberd2.getChild("cube_r15");
		this.bone = this.halberd.getChild("bone");
		this.right_particle = this.right_front_arm.getChild("right_particle");
		this.left_shoulder = this.body.getChild("left_shoulder");
		this.cube_r16 = this.left_shoulder.getChild("cube_r16");
		this.cube_r17 = this.left_shoulder.getChild("cube_r17");
		this.left_arm = this.left_shoulder.getChild("left_arm");
		this.left_front_arm = this.left_arm.getChild("left_front_arm");
		this.left_mace = this.left_front_arm.getChild("left_mace");
		this.cube_r18 = this.left_mace.getChild("cube_r18");
		this.cube_r19 = this.left_mace.getChild("cube_r19");
		this.cube_r20 = this.left_mace.getChild("cube_r20");
		this.left_particle = this.left_front_arm.getChild("left_particle");
		this.head = this.body.getChild("head");
		this.right_horn = this.head.getChild("right_horn");
		this.cube_r21 = this.right_horn.getChild("cube_r21");
		this.left_horn = this.head.getChild("left_horn");
		this.cube_r22 = this.left_horn.getChild("cube_r22");
		this.left_wing = this.body.getChild("left_wing");
		this.left_wing2 = this.left_wing.getChild("left_wing2");
		this.right_wing = this.body.getChild("right_wing");
		this.right_wing2 = this.right_wing.getChild("right_wing2");
	}

	public static TexturedModelData createBodyLayer() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData roots = partdefinition.addChild("roots", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData berserker = roots.addChild("berserker", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -24.0F, -3.0F));

		ModelPartData legs = berserker.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 1.0F, 0.0F));

		ModelPartData right_leg = legs.addChild("right_leg", ModelPartBuilder.create().uv(95, 68).cuboid(-4.0F, -0.0428F, -1.3474F, 6.0F, 12.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, 0.0F, 0.0097F, 0.218F, 0.0447F));

		ModelPartData cube_r1 = right_leg.addChild("cube_r1", ModelPartBuilder.create().uv(74, 148).cuboid(-8.0F, -16.0F, -1.5F, 6.0F, 11.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.5557F, 14.9936F, -0.8474F, 0.0F, 0.0F, 0.1309F));

		ModelPartData right_front_leg = right_leg.addChild("right_front_leg", ModelPartBuilder.create().uv(95, 97).cuboid(-4.1F, 0.9829F, -1.2611F, 5.0F, 12.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 9.9572F, 0.6526F));

		ModelPartData cube_r2 = right_front_leg.addChild("cube_r2", ModelPartBuilder.create().uv(101, 155).cuboid(-5.0F, 1.0F, -3.0F, 6.0F, 9.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0171F, -2.2611F, 0.5672F, 0.0F, 0.0F));

		ModelPartData left_leg = legs.addChild("left_leg", ModelPartBuilder.create().uv(41, 41).cuboid(-2.0F, -0.0428F, -1.3474F, 6.0F, 12.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.0F, 0.0F, 0.0097F, -0.218F, -0.0447F));

		ModelPartData cube_r3 = left_leg.addChild("cube_r3", ModelPartBuilder.create().uv(0, 147).cuboid(2.0F, -16.0F, -1.5F, 6.0F, 11.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-0.5557F, 14.9936F, -0.8474F, 0.0F, 0.0F, -0.1309F));

		ModelPartData left_front_leg = left_leg.addChild("left_front_leg", ModelPartBuilder.create().uv(0, 41).cuboid(-0.9F, 0.9829F, -1.2611F, 5.0F, 12.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 9.9572F, 0.6526F));

		ModelPartData cube_r4 = left_front_leg.addChild("cube_r4", ModelPartBuilder.create().uv(100, 126).cuboid(-1.0F, 1.0F, -3.0F, 6.0F, 9.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0171F, -2.2611F, 0.5672F, 0.0F, 0.0F));

		ModelPartData pelvis = berserker.addChild("pelvis", ModelPartBuilder.create().uv(146, 34).cuboid(-6.0F, -3.0F, -2.0F, 12.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, 0.0F));

		ModelPartData front_cloth1 = pelvis.addChild("front_cloth1", ModelPartBuilder.create().uv(119, 68).cuboid(-4.0F, 0.0F, 0.0F, 8.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, -1.6F, -0.1309F, 0.0F, 0.0F));

		ModelPartData front_cloth2 = front_cloth1.addChild("front_cloth2", ModelPartBuilder.create().uv(22, 127).cuboid(-4.0F, 0.0F, 0.0F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 9.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		ModelPartData body = pelvis.addChild("body", ModelPartBuilder.create().uv(119, 139).cuboid(-5.5F, -15.6F, -6.6743F, 11.0F, 13.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.6F, 3.6F));

		ModelPartData right_shoulder = body.addChild("right_shoulder", ModelPartBuilder.create(), ModelTransform.of(-6.7084F, -16.0F, -1.0743F, 0.132F, 0.1298F, 0.1917F));

		ModelPartData cube_r5 = right_shoulder.addChild("cube_r5", ModelPartBuilder.create().uv(143, 86).cuboid(-8.0F, -15.0F, 0.0F, 11.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(7.7209F, 5.9143F, -4.5994F, 0.0F, 0.0F, -1.2217F));

		ModelPartData cube_r6 = right_shoulder.addChild("cube_r6", ModelPartBuilder.create().uv(148, 63).cuboid(-16.0F, -12.0F, 0.0F, 10.0F, 4.0F, 6.0F, new Dilation(0.5F)), ModelTransform.of(7.7209F, 10.9143F, -4.5994F, 0.0F, 0.0F, 0.1309F));

		ModelPartData right_arm = right_shoulder.addChild("right_arm", ModelPartBuilder.create().uv(22, 163).cuboid(-3.0F, -3.0F, -2.5F, 5.0F, 10.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.3791F, 1.9143F, -1.5994F));

		ModelPartData right_front_arm = right_arm.addChild("right_front_arm", ModelPartBuilder.create().uv(162, 99).cuboid(-3.0F, 0.0F, -3.5F, 5.0F, 10.0F, 5.0F, new Dilation(0.0F))
		.uv(52, 154).cuboid(-4.0F, -3.0F, -3.5F, 5.0F, 10.0F, 5.0F, new Dilation(0.1F))
		.uv(151, 155).mirrored().cuboid(-3.0F, 0.0F, -3.5F, 5.0F, 10.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.025F, 7.0F, 1.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData bow = right_front_arm.addChild("bow", ModelPartBuilder.create().uv(119, 37).cuboid(-1.0F, -1.0F, -11.945F, 2.0F, 3.0F, 22.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.0F, 2.0F, -6.945F, 0.0F, 8.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.9401F, 9.0F, 0.0F));

		ModelPartData cube_r7 = bow.addChild("cube_r7", ModelPartBuilder.create().uv(119, 63).cuboid(-2.5F, 6.0F, -25.0F, 5.0F, 4.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 5.0065F, -0.5672F, 0.0F, 0.0F));

		ModelPartData cube_r8 = bow.addChild("cube_r8", ModelPartBuilder.create().uv(95, 97).cuboid(0.5F, 3.0F, -29.9F, 0.0F, 5.0F, 23.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.7688F, 2.6724F, -0.5672F, 0.0F, 0.0F));

		ModelPartData cube_r9 = bow.addChild("cube_r9", ModelPartBuilder.create().uv(95, 68).cuboid(0.0F, 4.0F, 9.0F, 0.0F, 5.0F, 23.0F, new Dilation(0.0F))
		.uv(124, 116).cuboid(-1.5F, 6.0F, 7.0F, 3.0F, 4.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -6.945F, 0.5672F, 0.0F, 0.0F));

		ModelPartData bow_string = bow.addChild("bow_string", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, -9.5F, 0.0F));

		ModelPartData string1 = bow_string.addChild("string1", ModelPartBuilder.create().uv(22, 128).cuboid(-1.001F, -0.1325F, -0.0242F, 1.0F, 0.0F, 19.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

		ModelPartData string2 = bow_string.addChild("string2", ModelPartBuilder.create().uv(0, 127).cuboid(-0.001F, -0.1325F, -18.9758F, 1.0F, 0.0F, 19.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 0.0F, -1.0485F));

		ModelPartData right_mace = right_front_arm.addChild("right_mace", ModelPartBuilder.create().uv(76, 126).mirrored().cuboid(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 19.0F, new Dilation(0.0F)).mirrored(false)
		.uv(26, 0).mirrored().cuboid(-1.5F, -1.5F, -27.0F, 3.0F, 3.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 41).mirrored().cuboid(0.5188F, 0.001F, -35.0F, 9.0F, 0.0F, 22.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 41).mirrored().cuboid(0.5188F, 0.001F, -35.0F, 9.0F, 0.0F, 22.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.0F, 8.0F, -1.0F));

		ModelPartData cube_r10 = right_mace.addChild("cube_r10", ModelPartBuilder.create().uv(0, 41).mirrored().cuboid(0.525F, 0.0F, -15.0F, 9.0F, 0.0F, 22.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.0062F, 0.001F, -20.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData cube_r11 = right_mace.addChild("cube_r11", ModelPartBuilder.create().uv(0, 41).mirrored().cuboid(0.525F, 0.0F, -15.0F, 9.0F, 0.0F, 22.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.0062F, 0.001F, -20.0F, 0.0F, 0.0F, 3.1416F));

		ModelPartData cube_r12 = right_mace.addChild("cube_r12", ModelPartBuilder.create().uv(0, 41).mirrored().cuboid(0.525F, 0.0F, -15.0F, 9.0F, 0.0F, 22.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.0062F, 0.001F, -20.0F, 0.0F, 0.0F, -1.5708F));

		ModelPartData halberd = right_front_arm.addChild("halberd", ModelPartBuilder.create().uv(0, 0).cuboid(-0.9901F, -1.2083F, -32.3333F, 2.0F, 2.0F, 65.0F, new Dilation(0.0F))
		.uv(26, 0).cuboid(-0.4901F, -0.7083F, -37.3333F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F))
		.uv(46, 131).cuboid(0.0099F, -2.7083F, -53.3333F, 0.0F, 5.0F, 17.0F, new Dilation(0.0F))
		.uv(64, 127).cuboid(-1.4901F, -1.7083F, -31.3333F, 3.0F, 3.0F, 12.0F, new Dilation(0.0F))
		.uv(10, 21).cuboid(2.0099F, -0.7083F, -16.8333F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(18, 21).cuboid(-0.4901F, -4.2083F, -16.8333F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(13, 0).cuboid(-1.9901F, -2.2083F, -17.3333F, 4.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(15, 21).cuboid(-0.4901F, 1.7917F, -16.8333F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(10, 21).mirrored().cuboid(-4.1089F, -0.7083F, -16.8333F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 0).cuboid(0.0099F, 1.2917F, -37.3333F, 0.0F, 15.0F, 25.0F, new Dilation(0.0F))
		.uv(123, 86).cuboid(0.0099F, -11.7083F, -33.3333F, 0.0F, 10.0F, 19.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.3911F, 8.2083F, -0.6667F));

		ModelPartData cube_r13 = halberd.addChild("cube_r13", ModelPartBuilder.create().uv(46, 131).cuboid(0.0F, -2.5F, -8.5F, 0.0F, 5.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(0.0099F, -0.2083F, -42.8333F, 0.0F, 0.0F, -1.5708F));

		ModelPartData halberd2 = halberd.addChild("halberd2", ModelPartBuilder.create().uv(0, 21).cuboid(1.5238F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(13, 6).cuboid(-1.4762F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 21).mirrored().cuboid(-3.595F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.0139F, -0.2083F, -33.8333F, 0.0F, 0.0F, -0.7854F));

		ModelPartData cube_r14 = halberd2.addChild("cube_r14", ModelPartBuilder.create().uv(5, 21).cuboid(1.5F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0238F, 5.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		ModelPartData cube_r15 = halberd2.addChild("cube_r15", ModelPartBuilder.create().uv(0, 21).cuboid(1.5F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0238F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		ModelPartData bone = halberd.addChild("bone", ModelPartBuilder.create(), ModelTransform.of(-0.0139F, -0.2083F, -16.8333F, 0.0F, 0.0F, 0.7854F));

		ModelPartData right_particle = right_front_arm.addChild("right_particle", ModelPartBuilder.create(), ModelTransform.pivot(-0.828F, 5.3443F, -1.302F));

		ModelPartData left_shoulder = body.addChild("left_shoulder", ModelPartBuilder.create(), ModelTransform.of(6.7084F, -16.0F, -2.0743F, 0.132F, -0.1298F, -0.1917F));

		ModelPartData cube_r16 = left_shoulder.addChild("cube_r16", ModelPartBuilder.create().uv(143, 86).mirrored().cuboid(-3.0F, -15.0F, 0.0F, 11.0F, 6.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-7.7209F, 5.9143F, -3.5994F, 0.0F, 0.0F, 1.2217F));

		ModelPartData cube_r17 = left_shoulder.addChild("cube_r17", ModelPartBuilder.create().uv(146, 44).cuboid(6.0F, -12.0F, 0.0F, 10.0F, 4.0F, 6.0F, new Dilation(0.5F)), ModelTransform.of(-7.7209F, 10.9143F, -3.5994F, 0.0F, 0.0F, -0.1309F));

		ModelPartData left_arm = left_shoulder.addChild("left_arm", ModelPartBuilder.create().uv(124, 160).cuboid(-2.0F, -3.0F, -2.5F, 5.0F, 10.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(2.3791F, 1.9143F, -0.5994F));

		ModelPartData left_front_arm = left_arm.addChild("left_front_arm", ModelPartBuilder.create().uv(151, 155).cuboid(-2.0F, 0.0F, -3.5F, 5.0F, 10.0F, 5.0F, new Dilation(0.0F))
		.uv(52, 154).mirrored().cuboid(-1.0F, -3.0F, -3.5F, 5.0F, 10.0F, 5.0F, new Dilation(0.1F)).mirrored(false), ModelTransform.of(0.025F, 7.0F, 1.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData left_mace = left_front_arm.addChild("left_mace", ModelPartBuilder.create().uv(76, 126).cuboid(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 19.0F, new Dilation(0.0F))
		.uv(26, 0).cuboid(-1.5F, -1.5F, -27.0F, 3.0F, 3.0F, 16.0F, new Dilation(0.0F))
		.uv(0, 41).cuboid(-9.5188F, 0.001F, -35.0F, 9.0F, 0.0F, 22.0F, new Dilation(0.0F))
		.uv(0, 41).cuboid(-9.5188F, 0.001F, -35.0F, 9.0F, 0.0F, 22.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 8.0F, -1.0F));

		ModelPartData cube_r18 = left_mace.addChild("cube_r18", ModelPartBuilder.create().uv(0, 41).cuboid(-9.525F, 0.0F, -15.0F, 9.0F, 0.0F, 22.0F, new Dilation(0.0F)), ModelTransform.of(0.0062F, 0.001F, -20.0F, 0.0F, 0.0F, -1.5708F));

		ModelPartData cube_r19 = left_mace.addChild("cube_r19", ModelPartBuilder.create().uv(0, 41).cuboid(-9.525F, 0.0F, -15.0F, 9.0F, 0.0F, 22.0F, new Dilation(0.0F)), ModelTransform.of(0.0062F, 0.001F, -20.0F, 0.0F, 0.0F, -3.1416F));

		ModelPartData cube_r20 = left_mace.addChild("cube_r20", ModelPartBuilder.create().uv(0, 41).cuboid(-9.525F, 0.0F, -15.0F, 9.0F, 0.0F, 22.0F, new Dilation(0.0F)), ModelTransform.of(0.0062F, 0.001F, -20.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData left_particle = left_front_arm.addChild("left_particle", ModelPartBuilder.create(), ModelTransform.pivot(0.4468F, 5.3443F, -1.302F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(141, 17).cuboid(-4.0F, -8.0F, -3.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
		.uv(141, 0).cuboid(-4.0F, -8.0F, -3.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F))
		.uv(149, 116).cuboid(-6.5F, -5.5F, -4.0F, 4.0F, 6.0F, 8.0F, new Dilation(0.0F))
		.uv(27, 148).cuboid(2.5F, -5.5F, -4.0F, 4.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -16.6F, -4.0F, 0.1309F, 0.0F, 0.0F));

		ModelPartData right_horn = head.addChild("right_horn", ModelPartBuilder.create(), ModelTransform.of(-6.2F, -10.0F, 0.0F, -0.2618F, 0.0F, -0.6545F));

		ModelPartData cube_r21 = right_horn.addChild("cube_r21", ModelPartBuilder.create().uv(148, 74).cuboid(-7.811F, -23.4301F, 0.1321F, 12.0F, 6.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-9.811F, -17.4301F, 0.1321F, 5.0F, 10.0F, 0.0F, new Dilation(0.0F))
		.uv(156, 139).cuboid(-4.811F, -21.4301F, -1.3679F, 11.0F, 4.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 127).cuboid(-4.811F, -17.4301F, -1.8679F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 12.0F, 2.0F, 0.1309F, 0.0F, -0.3054F));

		ModelPartData left_horn = head.addChild("left_horn", ModelPartBuilder.create(), ModelTransform.of(6.2F, -10.0F, 0.0F, -0.2618F, 0.0F, 0.6545F));

		ModelPartData cube_r22 = left_horn.addChild("cube_r22", ModelPartBuilder.create().uv(148, 74).mirrored().cuboid(-4.189F, -23.4301F, 0.1321F, 12.0F, 6.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 0).mirrored().cuboid(4.811F, -17.4301F, 0.1321F, 5.0F, 10.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
		.uv(156, 139).mirrored().cuboid(-6.189F, -21.4301F, -1.3679F, 11.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 127).mirrored().cuboid(0.811F, -17.4301F, -1.8679F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-5.0F, 12.0F, 2.0F, 0.1309F, 0.0F, 0.3054F));

		ModelPartData left_wing = body.addChild("left_wing", ModelPartBuilder.create().uv(70, 0).cuboid(-35.0F, -30.0F, 0.0F, 35.0F, 58.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -10.0F, 1.0F, -0.0181F, 0.3923F, -0.0472F));

		ModelPartData left_wing2 = left_wing.addChild("left_wing2", ModelPartBuilder.create().uv(0, 68).cuboid(-47.0F, -38.0F, 0.0F, 47.0F, 58.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-35.0F, 8.0F, 0.0F));

		ModelPartData right_wing = body.addChild("right_wing", ModelPartBuilder.create().uv(70, 0).mirrored().cuboid(0.0F, -38.0F, 0.0F, 35.0F, 58.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.0F, -2.0F, 1.0F, -0.0181F, -0.3923F, 0.0472F));

		ModelPartData right_wing2 = right_wing.addChild("right_wing2", ModelPartBuilder.create().uv(0, 68).mirrored().cuboid(0.0F, -38.0F, 0.0F, 47.0F, 58.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(35.0F, 0.0F, 0.0F));

		return TexturedModelData.of(meshdefinition, 256, 256);
	}

	@Override
	public void setAngles(Maledictus_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.animateHeadLookTarget(netHeadYaw, headPitch);

		this.updateAnimation(entity.getAnimationState("idle"), Maledictus_Animation.IDLE, ageInTicks, 0.75F);
		this.updateAnimation(entity.getAnimationState("swing"), Maledictus_Animation.SWING, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("shoot"), Maledictus_Animation.SHOOT, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("flying_shoot"), Maledictus_Animation.FLYING_SHOOT, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("fall_loop"), Maledictus_Animation.FALL_LOOP, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("fall_end"), Maledictus_Animation.FALL_END, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("mass_effect"), Maledictus_Animation.MASS_EFFECT, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("flying_smash_1"), Maledictus_Animation.FLYING_SMASH_1, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("flying_smash_2"), Maledictus_Animation.FLYING_SMASH_2, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("flying_halberd_smash_1"), Maledictus_Halberd_Animation.FLYING_HALBERD_SMASH_1, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("flying_halberd_smash_2"), Maledictus_Halberd_Animation.FLYING_HALBERD_SMASH_2, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("death"), Maledictus_Animation.DEATH, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("back_step"), Maledictus_Animation.CHARGE_BACKSTEP, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("back_step_dash"), Maledictus_Halberd_Animation.DASH1, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("radagon"), Maledictus_Halberd_Animation.RADAGON, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("halberd_swing"), Maledictus_Halberd_Animation.HALBERD_SLASH, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("dash"), Maledictus_Halberd_Animation.DASH1, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("back_step_dash_no_back_step"), Maledictus_Halberd_Animation.DASH1_NO_BACK_STEP, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("dash_no_back_step"), Maledictus_Halberd_Animation.DASH1_NO_BACK_STEP, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("dash2"), Maledictus_Halberd_Animation.DASH2, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("dash2_no_back_step"), Maledictus_Halberd_Animation.DASH2_NO_BACK_STEP, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("dash3"), Maledictus_Halberd_Animation.DASH3, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("spin_slashes"), Maledictus_Attack_Animation.SPIN_SLASHES, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("combo_first"), Maledictus_Attack_Animation.COMBO_FIRST, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("combo_first_end"), Maledictus_Attack_Animation.COMBO_FIRST_END, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("combo_second"), Maledictus_Attack_Animation.COMBO_SECOND, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("uppercut_right"), Maledictus_Attack_Animation.UPPERCUT_RIGHT, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("uppercut_left"), Maledictus_Attack_Animation.UPPERCUT_LEFT, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("grab_start"), Maledictus_Grab_Attack_Animation.GRAB_START, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("grab_loop"), Maledictus_Grab_Attack_Animation.GRAB_LOOP, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("grab_fail"), Maledictus_Grab_Attack_Animation.GRAB_FAIL, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("grab_success"), Maledictus_Grab_Attack_Animation.GRAB_SUCCESS_FLY, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("grab_success_loop"), Maledictus_Grab_Attack_Animation.GRAB_DIVE_LOOP, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("grab_success_end"), Maledictus_Grab_Attack_Animation.GRAB_LAND, ageInTicks, 1.0F);

		if(entity.getAttackState() != 10 && entity.getAttackState() != 11 && entity.getAttackState() != 12 && entity.getAttackState() != 13 && entity.getAttackState() != 14 && entity.getAttackState() != 18 && entity.getAttackState() != 29 && entity.getAttackState() != 33 && entity.getAttackState() != 32 && entity.getAttackState() != 31)  {
			this.animateMovement(Maledictus_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 4.0F);
		}

		right_mace.visible = entity.getWeapon() == 0;
		left_mace.visible = entity.getWeapon() == 0;
		bow.visible = entity.getWeapon() == 1;
		halberd.visible = entity.getWeapon() == 2;
	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.pitch += xRot * ((float) Math.PI / 180F);
		this.head.yaw += yRot * ((float) Math.PI / 180F);
	}

	public ModelPart getPart() {
		return this.root;
	}


	public void translateToHand(MatrixStack matrixStack,boolean right) {
		this.root.rotate(matrixStack);
		this.roots.rotate(matrixStack);
		this.berserker.rotate(matrixStack);
		this.pelvis.rotate(matrixStack);
		this.body.rotate(matrixStack);
		if(right) {
			this.right_shoulder.rotate(matrixStack);
			this.right_arm.rotate(matrixStack);
			this.right_front_arm.rotate(matrixStack);
			this.right_particle.rotate(matrixStack);
		}else{
			this.left_shoulder.rotate(matrixStack);
			this.left_arm.rotate(matrixStack);
			this.left_front_arm.rotate(matrixStack);
			this.left_particle.rotate(matrixStack);
		}
	}


}