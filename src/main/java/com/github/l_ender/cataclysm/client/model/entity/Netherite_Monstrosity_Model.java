package com.github.l_ender.cataclysm.client.model.entity;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.l_ender.cataclysm.client.animation.Netherite_Monstrosity_Animation;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;

public class Netherite_Monstrosity_Model extends SinglePartEntityModel<Netherite_Monstrosity_Entity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor

	private final ModelPart root;
	private final ModelPart roots;
	private final ModelPart lowerbody;
	private final ModelPart upperbody;
	private final ModelPart head;
	private final ModelPart horns;
	private final ModelPart jaw;
	private final ModelPart leftarmjoint;
	private final ModelPart leftarm;
	private final ModelPart leftarm2;
	private final ModelPart lefthand;
	private final ModelPart l_hand_blast_4;
	private final ModelPart l_hand_blast_3;
	private final ModelPart leftfinger1;
	private final ModelPart l_hand_blast_2;
	private final ModelPart leftfinger2;
	private final ModelPart l_hand_blast_1;
	private final ModelPart leftfinger3;
	private final ModelPart l_cannon;
	private final ModelPart l_core;
	private final ModelPart l_flame_2;
	private final ModelPart l_flame_1;
	private final ModelPart rightarmjoint;
	private final ModelPart rightarm;
	private final ModelPart rightarm2;
	private final ModelPart righthand;
	private final ModelPart r_hand_blast_4;
	private final ModelPart r_hand_blast_3;
	private final ModelPart rightfinger1;
	private final ModelPart r_hand_blast_2;
	private final ModelPart rightfinger2;
	private final ModelPart r_hand_blast_1;
	private final ModelPart rightfinger3;
	private final ModelPart r_cannon;
	private final ModelPart r_core;
	private final ModelPart r_flame_1;
	private final ModelPart r_flame_2;
	private final ModelPart rightleg;
	private final ModelPart leftleg;

	public Netherite_Monstrosity_Model(ModelPart root) {
		this.root = root;
		this.roots = this.root.getChild("roots");
		this.lowerbody = this.roots.getChild("lowerbody");
		this.upperbody = this.lowerbody.getChild("upperbody");
		this.head = this.upperbody.getChild("head");
		this.horns = this.head.getChild("horns");
		this.jaw = this.head.getChild("jaw");
		this.leftarmjoint = this.upperbody.getChild("leftarmjoint");
		this.leftarm = this.leftarmjoint.getChild("leftarm");
		this.leftarm2 = this.leftarm.getChild("leftarm2");
		this.lefthand = this.leftarm2.getChild("lefthand");
		this.l_hand_blast_4 = this.lefthand.getChild("l_hand_blast_4");
		this.l_hand_blast_3 = this.lefthand.getChild("l_hand_blast_3");
		this.leftfinger1 = this.l_hand_blast_3.getChild("leftfinger1");
		this.l_hand_blast_2 = this.lefthand.getChild("l_hand_blast_2");
		this.leftfinger2 = this.l_hand_blast_2.getChild("leftfinger2");
		this.l_hand_blast_1 = this.lefthand.getChild("l_hand_blast_1");
		this.leftfinger3 = this.l_hand_blast_1.getChild("leftfinger3");
		this.l_cannon = this.lefthand.getChild("l_cannon");
		this.l_core = this.lefthand.getChild("l_core");
		this.l_flame_2 = this.l_core.getChild("l_flame_2");
		this.l_flame_1 = this.l_core.getChild("l_flame_1");
		this.rightarmjoint = this.upperbody.getChild("rightarmjoint");
		this.rightarm = this.rightarmjoint.getChild("rightarm");
		this.rightarm2 = this.rightarm.getChild("rightarm2");
		this.righthand = this.rightarm2.getChild("righthand");
		this.r_hand_blast_4 = this.righthand.getChild("r_hand_blast_4");
		this.r_hand_blast_3 = this.righthand.getChild("r_hand_blast_3");
		this.rightfinger1 = this.r_hand_blast_3.getChild("rightfinger1");
		this.r_hand_blast_2 = this.righthand.getChild("r_hand_blast_2");
		this.rightfinger2 = this.r_hand_blast_2.getChild("rightfinger2");
		this.r_hand_blast_1 = this.righthand.getChild("r_hand_blast_1");
		this.rightfinger3 = this.r_hand_blast_1.getChild("rightfinger3");
		this.r_cannon = this.righthand.getChild("r_cannon");
		this.r_core = this.righthand.getChild("r_core");
		this.r_flame_1 = this.r_core.getChild("r_flame_1");
		this.r_flame_2 = this.r_core.getChild("r_flame_2");
		this.rightleg = this.roots.getChild("rightleg");
		this.leftleg = this.roots.getChild("leftleg");
	}

	public static TexturedModelData createBodyLayer() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData roots = partdefinition.addChild("roots", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData lowerbody = roots.addChild("lowerbody", ModelPartBuilder.create().uv(175, 193).cuboid(-14.0F, -11.0F, -10.5F, 28.0F, 11.0F, 21.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 2.0F));

		ModelPartData upperbody = lowerbody.addChild("upperbody", ModelPartBuilder.create().uv(0, 0).cuboid(-37.0F, -57.0F, -15.0F, 74.0F, 57.0F, 30.0F, new Dilation(0.0F))
				.uv(209, 226).cuboid(-14.0F, -50.0F, 15.0F, 28.0F, 16.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		ModelPartData head = upperbody.addChild("head", ModelPartBuilder.create().uv(0, 139).cuboid(-14.0F, -18.0F, -20.5F, 28.0F, 31.0F, 22.0F, new Dilation(0.0F))
				.uv(246, 112).cuboid(-34.0F, -12.5F, -16.0F, 20.0F, 13.0F, 13.0F, new Dilation(0.0F))
				.uv(246, 112).mirrored().cuboid(14.0F, -12.5F, -16.0F, 20.0F, 13.0F, 13.0F, new Dilation(0.0F)).mirrored(false)
				.uv(253, 184).cuboid(-34.0F, -27.5F, -16.0F, 8.0F, 15.0F, 13.0F, new Dilation(0.0F))
				.uv(169, 171).cuboid(26.0F, -15.5F, -16.0F, 8.0F, 3.0F, 13.0F, new Dilation(0.0F))
				.uv(12, 0).cuboid(-2.5F, -2.0F, -20.7F, 6.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(17, 5).cuboid(-14.25F, 1.5F, -20.7F, 4.0F, 4.0F, 1.0F, new Dilation(0.0F))
				.uv(17, 5).cuboid(10.25F, 1.5F, -20.7F, 4.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -33.0F, -16.5F));

		ModelPartData horns = head.addChild("horns", ModelPartBuilder.create(), ModelTransform.of(-4.5F, 47.0F, -3.5F, 1.0472F, 0.0F, 0.0F));

		ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create().uv(209, 2).cuboid(-13.5F, -10.0F, -21.9F, 27.0F, 16.0F, 21.0F, new Dilation(0.0F))
				.uv(305, 8).cuboid(-13.5F, 6.0F, -21.9F, 27.0F, 5.0F, 15.0F, new Dilation(0.0F))
				.uv(209, 40).cuboid(-13.5F, 3.0F, -21.9F, 27.0F, 0.0F, 21.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 11.0F, 1.5F, 0.1309F, 0.0F, 0.0F));

		ModelPartData leftarmjoint = upperbody.addChild("leftarmjoint", ModelPartBuilder.create(), ModelTransform.pivot(37.0F, -38.5F, -2.5F));

		ModelPartData leftarm = leftarmjoint.addChild("leftarm", ModelPartBuilder.create().uv(101, 163).cuboid(0.0F, -33.5F, -13.5F, 20.0F, 23.0F, 27.0F, new Dilation(0.0F))
				.uv(0, 88).cuboid(0.0F, -10.5F, -13.5F, 37.0F, 23.0F, 27.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData leftarm2 = leftarm.addChild("leftarm2", ModelPartBuilder.create().uv(132, 226).cuboid(-11.0F, -4.5F, -8.0F, 22.0F, 20.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(18.0F, 12.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData lefthand = leftarm2.addChild("lefthand", ModelPartBuilder.create().uv(136, 264).mirrored().cuboid(-12.0F, -5.0F, -12.0F, 24.0F, 5.0F, 24.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 17.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData righthand_r1 = lefthand.addChild("righthand_r1", ModelPartBuilder.create().uv(102, 260).mirrored().cuboid(-2.5F, -13.5F, 3.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
				.uv(74, 260).mirrored().cuboid(-19.5F, -13.5F, 3.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.2F)).mirrored(false)
				.uv(88, 260).mirrored().cuboid(-19.5F, -13.5F, 3.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
				.uv(61, 314).mirrored().cuboid(-16.5F, -4.5F, -2.0F, 14.0F, 3.0F, 14.0F, new Dilation(0.0F)).mirrored(false)
				.uv(60, 270).mirrored().cuboid(-16.5F, -13.5F, -2.0F, 14.0F, 9.0F, 14.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(5.0F, 13.5F, 9.5F, 0.0F, -1.5708F, 0.0F));

		ModelPartData lefthand_r1 = lefthand.addChild("lefthand_r1", ModelPartBuilder.create().uv(88, 260).cuboid(-103.0F, -3.0F, -10.5F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-110.0F, 3.0F, -8.5F, 0.0F, -3.1416F, 0.0F));

		ModelPartData righthand_r2 = lefthand.addChild("righthand_r2", ModelPartBuilder.create().uv(88, 260).mirrored().cuboid(-10.0F, -3.0F, -10.5F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 3.0F, -8.5F, 0.0F, 3.1416F, 0.0F));

		ModelPartData lefthand_r2 = lefthand.addChild("lefthand_r2", ModelPartBuilder.create().uv(74, 260).cuboid(-111.5F, -3.0F, -2.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.2F)), ModelTransform.of(-118.5F, 3.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		ModelPartData righthand_r3 = lefthand.addChild("righthand_r3", ModelPartBuilder.create().uv(74, 260).mirrored().cuboid(-10.0F, -3.0F, -2.5F, 3.0F, 6.0F, 4.0F, new Dilation(0.2F)).mirrored(false), ModelTransform.of(0.0F, 3.0F, -0.5F, 0.0F, 3.1416F, 0.0F));

		ModelPartData righthand_r4 = lefthand.addChild("righthand_r4", ModelPartBuilder.create().uv(74, 260).mirrored().cuboid(-18.5F, -3.0F, -2.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.2F)).mirrored(false), ModelTransform.of(0.0F, 3.0F, -8.5F, 0.0F, 1.5708F, 0.0F));

		ModelPartData l_hand_blast_4 = lefthand.addChild("l_hand_blast_4", ModelPartBuilder.create(), ModelTransform.pivot(-10.0F, 0.0F, 10.0F));

		ModelPartData lefthand_r3 = l_hand_blast_4.addChild("lefthand_r3", ModelPartBuilder.create().uv(0, 304).cuboid(-0.5F, -13.5F, -5.0F, 10.0F, 15.0F, 10.0F, new Dilation(0.0F))
				.uv(0, 329).cuboid(2.5F, 1.5F, -2.0F, 7.0F, 5.0F, 7.0F, new Dilation(0.0F))
				.uv(0, 269).cuboid(-5.5F, -13.5F, -10.0F, 15.0F, 20.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 13.5F, -0.5F, 0.0F, 1.5708F, 0.0F));

		ModelPartData l_hand_blast_3 = lefthand.addChild("l_hand_blast_3", ModelPartBuilder.create(), ModelTransform.pivot(10.0F, 0.0F, 10.0F));

		ModelPartData righthand_r5 = l_hand_blast_3.addChild("righthand_r5", ModelPartBuilder.create().uv(0, 304).mirrored().cuboid(-9.5F, -13.5F, -5.0F, 10.0F, 15.0F, 10.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 329).mirrored().cuboid(-9.5F, 1.5F, -2.0F, 7.0F, 5.0F, 7.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 269).mirrored().cuboid(-9.5F, -13.5F, -10.0F, 15.0F, 20.0F, 15.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-5.0F, 13.5F, -0.5F, 0.0F, -1.5708F, 0.0F));

		ModelPartData leftfinger1 = l_hand_blast_3.addChild("leftfinger1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -2.5F, -1.5F, 3.0F, 15.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 20.0F, -4.0F));

		ModelPartData l_hand_blast_2 = lefthand.addChild("l_hand_blast_2", ModelPartBuilder.create().uv(0, 269).mirrored().cuboid(-10.0F, 0.0F, -5.0F, 15.0F, 20.0F, 15.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 329).mirrored().cuboid(-10.0F, 15.0F, 3.0F, 7.0F, 5.0F, 7.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 304).mirrored().cuboid(-10.0F, 0.0F, 0.0F, 10.0F, 15.0F, 10.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(10.0F, 0.0F, -10.0F));

		ModelPartData leftfinger2 = l_hand_blast_2.addChild("leftfinger2", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -2.5F, -1.5F, 3.0F, 15.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 20.0F, 2.0F));

		ModelPartData l_hand_blast_1 = lefthand.addChild("l_hand_blast_1", ModelPartBuilder.create().uv(0, 269).cuboid(-5.0F, 0.0F, -5.0F, 15.0F, 20.0F, 15.0F, new Dilation(0.0F))
				.uv(0, 329).cuboid(3.0F, 15.0F, 3.0F, 7.0F, 5.0F, 7.0F, new Dilation(0.0F))
				.uv(0, 304).cuboid(0.0F, 0.0F, 0.0F, 10.0F, 15.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-10.0F, 0.0F, -10.0F));

		ModelPartData leftfinger3 = l_hand_blast_1.addChild("leftfinger3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 20.0F, 8.5F));

		ModelPartData leftfinger3_r1 = leftfinger3.addChild("leftfinger3_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -7.5F, -2.5F, 3.0F, 15.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 1.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData l_cannon = lefthand.addChild("l_cannon", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 13.75F, 0.0F));

		ModelPartData righthand_r6 = l_cannon.addChild("righthand_r6", ModelPartBuilder.create().uv(61, 294).mirrored().cuboid(-7.0F, 7.5F, -7.0F, 14.0F, 5.0F, 14.0F, new Dilation(0.0F)).mirrored(false)
				.uv(69, 331).mirrored().cuboid(-6.0F, 2.5F, -6.0F, 12.0F, 8.0F, 12.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -8.25F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData l_core = lefthand.addChild("l_core", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 13.0F, 0.0F));

		ModelPartData righthand_r7 = l_core.addChild("righthand_r7", ModelPartBuilder.create().uv(0, 341).mirrored().cuboid(-4.0F, 6.5F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(-0.5F)).mirrored(false)
				.uv(0, 357).mirrored().cuboid(-4.0F, 6.5F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.2F)).mirrored(false), ModelTransform.of(0.0F, -10.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData l_flame_2 = l_core.addChild("l_flame_2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData righthand_r8 = l_flame_2.addChild("righthand_r8", ModelPartBuilder.create().uv(-16, 373).mirrored().cuboid(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.0663F, -1.0163F, -2.2196F));

		ModelPartData l_flame_1 = l_core.addChild("l_flame_1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData righthand_r9 = l_flame_1.addChild("righthand_r9", ModelPartBuilder.create().uv(-16, 373).mirrored().cuboid(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, -1.1781F, 2.7489F));

		ModelPartData rightarmjoint = upperbody.addChild("rightarmjoint", ModelPartBuilder.create(), ModelTransform.pivot(-37.0F, -38.5F, -2.5F));

		ModelPartData rightarm = rightarmjoint.addChild("rightarm", ModelPartBuilder.create().uv(101, 163).mirrored().cuboid(-20.0F, -33.5F, -13.5F, 20.0F, 23.0F, 27.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 88).mirrored().cuboid(-37.0F, -10.5F, -13.5F, 37.0F, 23.0F, 27.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rightarm2 = rightarm.addChild("rightarm2", ModelPartBuilder.create().uv(132, 226).cuboid(-11.0F, -4.5F, -8.0F, 22.0F, 22.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(-19.0F, 12.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData righthand = rightarm2.addChild("righthand", ModelPartBuilder.create().uv(136, 264).cuboid(-12.0F, -5.0F, -12.0F, 24.0F, 5.0F, 24.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 17.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData lefthand_r4 = righthand.addChild("lefthand_r4", ModelPartBuilder.create().uv(102, 260).cuboid(-0.5F, -13.5F, 3.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F))
				.uv(74, 260).cuboid(16.5F, -13.5F, 3.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.2F))
				.uv(88, 260).cuboid(16.5F, -13.5F, 3.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F))
				.uv(61, 314).cuboid(2.5F, -4.5F, -2.0F, 14.0F, 3.0F, 14.0F, new Dilation(0.0F))
				.uv(60, 270).cuboid(2.5F, -13.5F, -2.0F, 14.0F, 9.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 13.5F, 9.5F, 0.0F, 1.5708F, 0.0F));

		ModelPartData righthand_r10 = righthand.addChild("righthand_r10", ModelPartBuilder.create().uv(88, 260).mirrored().cuboid(100.0F, -3.0F, -10.5F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(110.0F, 3.0F, -8.5F, 0.0F, 3.1416F, 0.0F));

		ModelPartData lefthand_r5 = righthand.addChild("lefthand_r5", ModelPartBuilder.create().uv(88, 260).cuboid(7.0F, -3.0F, -10.5F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, -8.5F, 0.0F, -3.1416F, 0.0F));

		ModelPartData righthand_r11 = righthand.addChild("righthand_r11", ModelPartBuilder.create().uv(74, 260).mirrored().cuboid(108.5F, -3.0F, -2.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.2F)).mirrored(false), ModelTransform.of(118.5F, 3.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData lefthand_r6 = righthand.addChild("lefthand_r6", ModelPartBuilder.create().uv(74, 260).cuboid(7.0F, -3.0F, -2.5F, 3.0F, 6.0F, 4.0F, new Dilation(0.2F)), ModelTransform.of(0.0F, 3.0F, -0.5F, 0.0F, -3.1416F, 0.0F));

		ModelPartData lefthand_r7 = righthand.addChild("lefthand_r7", ModelPartBuilder.create().uv(74, 260).cuboid(15.5F, -3.0F, -2.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.2F)), ModelTransform.of(0.0F, 3.0F, -8.5F, 0.0F, -1.5708F, 0.0F));

		ModelPartData r_hand_blast_4 = righthand.addChild("r_hand_blast_4", ModelPartBuilder.create(), ModelTransform.pivot(10.0F, 0.0F, 10.0F));

		ModelPartData righthand_r12 = r_hand_blast_4.addChild("righthand_r12", ModelPartBuilder.create().uv(0, 304).mirrored().cuboid(-9.5F, -13.5F, -5.0F, 10.0F, 15.0F, 10.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 329).mirrored().cuboid(-9.5F, 1.5F, -2.0F, 7.0F, 5.0F, 7.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 269).mirrored().cuboid(-9.5F, -13.5F, -10.0F, 15.0F, 20.0F, 15.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-5.0F, 13.5F, -0.5F, 0.0F, -1.5708F, 0.0F));

		ModelPartData r_hand_blast_3 = righthand.addChild("r_hand_blast_3", ModelPartBuilder.create(), ModelTransform.pivot(-10.0F, 0.0F, 10.0F));

		ModelPartData lefthand_r8 = r_hand_blast_3.addChild("lefthand_r8", ModelPartBuilder.create().uv(0, 304).cuboid(-0.5F, -13.5F, -5.0F, 10.0F, 15.0F, 10.0F, new Dilation(0.0F))
				.uv(0, 329).cuboid(2.5F, 1.5F, -2.0F, 7.0F, 5.0F, 7.0F, new Dilation(0.0F))
				.uv(0, 269).cuboid(-5.5F, -13.5F, -10.0F, 15.0F, 20.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 13.5F, -0.5F, 0.0F, 1.5708F, 0.0F));

		ModelPartData rightfinger1 = r_hand_blast_3.addChild("rightfinger1", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.5F, -2.5F, -1.5F, 3.0F, 15.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 20.0F, -4.0F));

		ModelPartData r_hand_blast_2 = righthand.addChild("r_hand_blast_2", ModelPartBuilder.create().uv(0, 269).cuboid(-5.0F, 0.0F, -5.0F, 15.0F, 20.0F, 15.0F, new Dilation(0.0F))
				.uv(0, 329).cuboid(3.0F, 15.0F, 3.0F, 7.0F, 5.0F, 7.0F, new Dilation(0.0F))
				.uv(0, 304).cuboid(0.0F, 0.0F, 0.0F, 10.0F, 15.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(-10.0F, 0.0F, -10.0F));

		ModelPartData rightfinger2 = r_hand_blast_2.addChild("rightfinger2", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.5F, -2.5F, -1.5F, 3.0F, 15.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 20.0F, 2.0F));

		ModelPartData r_hand_blast_1 = righthand.addChild("r_hand_blast_1", ModelPartBuilder.create().uv(0, 269).mirrored().cuboid(-10.0F, 0.0F, -5.0F, 15.0F, 20.0F, 15.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 329).mirrored().cuboid(-10.0F, 15.0F, 3.0F, 7.0F, 5.0F, 7.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 304).mirrored().cuboid(-10.0F, 0.0F, 0.0F, 10.0F, 15.0F, 10.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(10.0F, 0.0F, -10.0F));

		ModelPartData rightfinger3 = r_hand_blast_1.addChild("rightfinger3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 20.0F, 8.5F));

		ModelPartData rightfinger3_r1 = rightfinger3.addChild("rightfinger3_r1", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.5F, -7.5F, -2.5F, 3.0F, 15.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 5.0F, 1.0F, 0.0F, -3.1416F, 0.0F));

		ModelPartData r_cannon = righthand.addChild("r_cannon", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 13.75F, 0.0F));

		ModelPartData lefthand_r9 = r_cannon.addChild("lefthand_r9", ModelPartBuilder.create().uv(61, 294).cuboid(-7.0F, 7.5F, -7.0F, 14.0F, 5.0F, 14.0F, new Dilation(0.0F))
				.uv(69, 331).cuboid(-6.0F, 2.5F, -6.0F, 12.0F, 8.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -8.25F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData r_core = righthand.addChild("r_core", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 13.0F, 0.0F));

		ModelPartData lefthand_r10 = r_core.addChild("lefthand_r10", ModelPartBuilder.create().uv(0, 341).cuboid(-4.0F, 6.5F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
				.uv(0, 357).cuboid(-4.0F, 6.5F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.2F)), ModelTransform.of(0.0F, -10.5F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData r_flame_1 = r_core.addChild("r_flame_1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData lefthand_r11 = r_flame_1.addChild("lefthand_r11", ModelPartBuilder.create().uv(-16, 373).cuboid(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.0663F, 1.0163F, 2.2196F));

		ModelPartData r_flame_2 = r_core.addChild("r_flame_2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData lefthand_r12 = r_flame_2.addChild("lefthand_r12", ModelPartBuilder.create().uv(-16, 373).cuboid(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 1.1781F, -2.7489F));

		ModelPartData rightleg = roots.addChild("rightleg", ModelPartBuilder.create().uv(0, 193).cuboid(-19.0F, -2.0F, -7.5F, 24.0F, 29.0F, 19.0F, new Dilation(0.0F)), ModelTransform.of(-14.0F, -27.0F, 0.0F, 0.0F, 0.0873F, 0.0F));

		ModelPartData leftleg = roots.addChild("leftleg", ModelPartBuilder.create().uv(0, 193).mirrored().cuboid(-5.0F, -2.0F, -7.5F, 24.0F, 29.0F, 19.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(14.0F, -27.0F, 0.0F, 0.0F, -0.0873F, 0.0F));

		return TexturedModelData.of(meshdefinition, 512, 512);
	}



	@Override
	public void setAngles(Netherite_Monstrosity_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {


		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateHeadLookTarget(netHeadYaw, headPitch);

		if(!(entity.getAttackState() == 8 && entity.attackTicks > 19 && entity.attackTicks < 49)) {
			this.animateMovement(Netherite_Monstrosity_Animation.WALK, limbSwing, limbSwingAmount, 2.0F, 2.0F);
		}



		this.updateAnimation(entity.getAnimationState("idle"), Netherite_Monstrosity_Animation.IDLE, ageInTicks, 1.0F);

		this.updateAnimation(entity.getAnimationState("smash"), Netherite_Monstrosity_Animation.SMASH, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("sleep"), Netherite_Monstrosity_Animation.SLEEP, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("awake"), Netherite_Monstrosity_Animation.AWAKE, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("phase_two"), Netherite_Monstrosity_Animation.PHASE, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("death"), Netherite_Monstrosity_Animation.DEATH, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("fire"), Netherite_Monstrosity_Animation.FIRE, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("drain"), Netherite_Monstrosity_Animation.DRAIN, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("shoulder_check"), Netherite_Monstrosity_Animation.SHOULDER_CHECK, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("overpower"), Netherite_Monstrosity_Animation.OVERPOWER, ageInTicks, 1.0F);
		this.updateAnimation(entity.getAnimationState("flare_shot"), Netherite_Monstrosity_Animation.FLARE_SHOT, ageInTicks, 1.0F);
	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.pitch = xRot * ((float) Math.PI / 180F);
		this.head.yaw = yRot * ((float) Math.PI / 180F);
	}

	public ModelPart getPart() {
		return this.root;
	}

}