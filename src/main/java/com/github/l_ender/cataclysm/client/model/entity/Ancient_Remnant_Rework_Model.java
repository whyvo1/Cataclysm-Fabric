package com.github.l_ender.cataclysm.client.model.entity;


import com.github.l_ender.cataclysm.client.animation.Ancient_Remnant_Animation;
import com.github.l_ender.cataclysm.client.animation.Ancient_Remnant_Power_Animation;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.github.l_ender.lionfishapi.server.animation.LegSolver;
import net.minecraft.client.MinecraftClient;
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

public class Ancient_Remnant_Rework_Model extends SinglePartEntityModel<Ancient_Remnant_Entity> {

	private final ModelPart root;
	private final ModelPart roots;
	private final ModelPart mid_pivot;
	private final ModelPart pelvis;
	private final ModelPart left_long_bone;
	private final ModelPart right_long_bone;
	private final ModelPart spine_sail2;
	private final ModelPart left_bone;
	private final ModelPart right_bone;
	private final ModelPart left_big_bone;
	private final ModelPart right_big_bone;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart tail3;
	private final ModelPart tail4;
	private final ModelPart spine1;
	private final ModelPart spine2;
	private final ModelPart spine_sail1;
	private final ModelPart right_shoulder;
	private final ModelPart left_shoulder;
	private final ModelPart neck1;
	private final ModelPart neck2;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart crown;
	private final ModelPart under_crown;
	private final ModelPart right_crown1;
	private final ModelPart right_crown2;
	private final ModelPart left_crown;
	private final ModelPart left_crown2;
	private final ModelPart snake;
	private final ModelPart upper_crown;
	private final ModelPart desert_necklace;
	private final ModelPart chain1;
	private final ModelPart chain2;
	private final ModelPart chain3;
	private final ModelPart chain4;
	private final ModelPart chain5;
	private final ModelPart desert_eye;
	private final ModelPart eye;
	private final ModelPart left_arm;
	private final ModelPart left_front_arm;
	private final ModelPart left_hand;
	private final ModelPart left_finger3;
	private final ModelPart left_finger1;
	private final ModelPart left_finger2;
	private final ModelPart right_arm;
	private final ModelPart right_front_arm;
	private final ModelPart right_hand;
	private final ModelPart right_finger1;
	private final ModelPart right_finger2;
	private final ModelPart right_finger3;
	private final ModelPart spine_deco;
	private final ModelPart legs;
	private final ModelPart left_leg;
	private final ModelPart left_deco1;
	private final ModelPart left_front_leg;
	private final ModelPart left_ankel_joint;
	private final ModelPart left_mini_bone;
	private final ModelPart left_deco2;
	private final ModelPart left_deco3;
	private final ModelPart left_ankel;
	private final ModelPart left_foot;
	private final ModelPart left_toe;
	private final ModelPart left_toe2;
	private final ModelPart left_toe3;
	private final ModelPart right_leg;
	private final ModelPart right_deco1;
	private final ModelPart right_front_leg;
	private final ModelPart right_ankel_joint;
	private final ModelPart right_mini_bone;
	private final ModelPart right_deco2;
	private final ModelPart right_deco3;
	private final ModelPart right_ankel;
	private final ModelPart right_foot;
	private final ModelPart right_toe;
	private final ModelPart right_toe2;
	private final ModelPart right_toe3;

	public Ancient_Remnant_Rework_Model(ModelPart root) {
		this.root = root;
		this.roots = this.root.getChild("roots");
		this.mid_pivot = this.roots.getChild("mid_pivot");
		this.pelvis = this.mid_pivot.getChild("pelvis");
		this.left_long_bone = this.pelvis.getChild("left_long_bone");
		this.right_long_bone = this.pelvis.getChild("right_long_bone");
		this.spine_sail2 = this.pelvis.getChild("spine_sail2");
		this.left_bone = this.pelvis.getChild("left_bone");
		this.right_bone = this.pelvis.getChild("right_bone");
		this.left_big_bone = this.pelvis.getChild("left_big_bone");
		this.right_big_bone = this.pelvis.getChild("right_big_bone");
		this.tail1 = this.pelvis.getChild("tail1");
		this.tail2 = this.tail1.getChild("tail2");
		this.tail3 = this.tail2.getChild("tail3");
		this.tail4 = this.tail3.getChild("tail4");
		this.spine1 = this.pelvis.getChild("spine1");
		this.spine2 = this.spine1.getChild("spine2");
		this.spine_sail1 = this.spine2.getChild("spine_sail1");
		this.right_shoulder = this.spine2.getChild("right_shoulder");
		this.left_shoulder = this.spine2.getChild("left_shoulder");
		this.neck1 = this.spine2.getChild("neck1");
		this.neck2 = this.neck1.getChild("neck2");
		this.head = this.neck2.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.crown = this.head.getChild("crown");
		this.under_crown = this.crown.getChild("under_crown");
		this.right_crown1 = this.under_crown.getChild("right_crown1");
		this.right_crown2 = this.right_crown1.getChild("right_crown2");
		this.left_crown = this.under_crown.getChild("left_crown");
		this.left_crown2 = this.left_crown.getChild("left_crown2");
		this.snake = this.crown.getChild("snake");
		this.upper_crown = this.crown.getChild("upper_crown");
		this.desert_necklace = this.neck2.getChild("desert_necklace");
		this.chain1 = this.desert_necklace.getChild("chain1");
		this.chain2 = this.chain1.getChild("chain2");
		this.chain3 = this.chain2.getChild("chain3");
		this.chain4 = this.chain3.getChild("chain4");
		this.chain5 = this.chain4.getChild("chain5");
		this.desert_eye = this.chain5.getChild("desert_eye");
		this.eye = this.desert_eye.getChild("eye");
		this.left_arm = this.spine2.getChild("left_arm");
		this.left_front_arm = this.left_arm.getChild("left_front_arm");
		this.left_hand = this.left_front_arm.getChild("left_hand");
		this.left_finger3 = this.left_hand.getChild("left_finger3");
		this.left_finger1 = this.left_hand.getChild("left_finger1");
		this.left_finger2 = this.left_hand.getChild("left_finger2");
		this.right_arm = this.spine2.getChild("right_arm");
		this.right_front_arm = this.right_arm.getChild("right_front_arm");
		this.right_hand = this.right_front_arm.getChild("right_hand");
		this.right_finger1 = this.right_hand.getChild("right_finger1");
		this.right_finger2 = this.right_hand.getChild("right_finger2");
		this.right_finger3 = this.right_hand.getChild("right_finger3");
		this.spine_deco = this.spine2.getChild("spine_deco");
		this.legs = this.mid_pivot.getChild("legs");
		this.left_leg = this.legs.getChild("left_leg");
		this.left_deco1 = this.left_leg.getChild("left_deco1");
		this.left_front_leg = this.left_leg.getChild("left_front_leg");
		this.left_ankel_joint = this.left_front_leg.getChild("left_ankel_joint");
		this.left_mini_bone = this.left_ankel_joint.getChild("left_mini_bone");
		this.left_deco2 = this.left_ankel_joint.getChild("left_deco2");
		this.left_deco3 = this.left_ankel_joint.getChild("left_deco3");
		this.left_ankel = this.left_ankel_joint.getChild("left_ankel");
		this.left_foot = this.left_ankel_joint.getChild("left_foot");
		this.left_toe = this.left_foot.getChild("left_toe");
		this.left_toe2 = this.left_foot.getChild("left_toe2");
		this.left_toe3 = this.left_foot.getChild("left_toe3");
		this.right_leg = this.legs.getChild("right_leg");
		this.right_deco1 = this.right_leg.getChild("right_deco1");
		this.right_front_leg = this.right_leg.getChild("right_front_leg");
		this.right_ankel_joint = this.right_front_leg.getChild("right_ankel_joint");
		this.right_mini_bone = this.right_ankel_joint.getChild("right_mini_bone");
		this.right_deco2 = this.right_ankel_joint.getChild("right_deco2");
		this.right_deco3 = this.right_ankel_joint.getChild("right_deco3");
		this.right_ankel = this.right_ankel_joint.getChild("right_ankel");
		this.right_foot = this.right_ankel_joint.getChild("right_foot");
		this.right_toe = this.right_foot.getChild("right_toe");
		this.right_toe2 = this.right_foot.getChild("right_toe2");
		this.right_toe3 = this.right_foot.getChild("right_toe3");
	}

	public static TexturedModelData createBodyLayer() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData roots = partdefinition.addChild("roots", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData mid_pivot = roots.addChild("mid_pivot", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -69.0F, -10.0F));

		ModelPartData pelvis = mid_pivot.addChild("pelvis", ModelPartBuilder.create().uv(111, 42).cuboid(-5.0F, -4.2211F, -9.2432F, 10.0F, 12.0F, 24.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 2.0F, -0.2182F, 0.0F, 0.0F));

		ModelPartData left_long_bone = pelvis.addChild("left_long_bone", ModelPartBuilder.create().uv(50, 0).cuboid(0.0F, -4.0F, 6.0F, 5.0F, 28.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(6.5F, -0.2211F, -8.2432F, -0.4185F, 0.1274F, 0.2783F));

		ModelPartData right_long_bone = pelvis.addChild("right_long_bone", ModelPartBuilder.create().uv(50, 0).mirrored().cuboid(-5.0F, -4.0F, 6.0F, 5.0F, 28.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-6.5F, -0.2211F, -8.2432F, -0.4185F, -0.1274F, -0.2783F));

		ModelPartData spine_sail2 = pelvis.addChild("spine_sail2", ModelPartBuilder.create().uv(65, 50).cuboid(0.0F, -28.916F, -25.98F, 0.0F, 30.0F, 32.0F, new Dilation(0.01F)), ModelTransform.of(0.0F, -0.2211F, 12.7568F, 0.1745F, 0.0F, 0.0F));

		ModelPartData left_bone = pelvis.addChild("left_bone", ModelPartBuilder.create().uv(194, 215).cuboid(1.0F, 3.0F, 0.0F, 7.0F, 33.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, -0.2211F, -8.2432F, 0.7811F, -0.0924F, 0.0928F));

		ModelPartData right_bone = pelvis.addChild("right_bone", ModelPartBuilder.create().uv(194, 215).mirrored().cuboid(-8.0F, 3.0F, 0.0F, 7.0F, 33.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.5F, -0.2211F, -8.2432F, 0.7811F, 0.0924F, -0.0928F));

		ModelPartData left_big_bone = pelvis.addChild("left_big_bone", ModelPartBuilder.create().uv(112, 124).cuboid(1.0F, -2.0F, -1.0F, 9.0F, 14.0F, 27.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2211F, -8.2432F, 0.3186F, 0.1451F, -0.413F));

		ModelPartData right_big_bone = pelvis.addChild("right_big_bone", ModelPartBuilder.create().uv(112, 124).mirrored().cuboid(-10.0F, -2.0F, -1.0F, 9.0F, 14.0F, 27.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -0.2211F, -8.2432F, 0.3186F, -0.1451F, 0.413F));

		ModelPartData tail1 = pelvis.addChild("tail1", ModelPartBuilder.create().uv(98, 81).cuboid(-4.0F, -5.916F, 1.02F, 8.0F, 10.0F, 32.0F, new Dilation(0.0F))
		.uv(47, 117).cuboid(0.0F, -24.916F, -0.98F, 0.0F, 19.0F, 32.0F, new Dilation(0.0F))
		.uv(114, 197).cuboid(0.0F, 4.084F, 6.02F, 0.0F, 6.0F, 25.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.7789F, 10.7568F, 0.0436F, 0.0F, 0.0F));

		ModelPartData tail2 = tail1.addChild("tail2", ModelPartBuilder.create().uv(0, 109).cuboid(-3.5F, -3.7067F, -0.3098F, 7.0F, 7.0F, 32.0F, new Dilation(0.0F))
		.uv(148, 47).cuboid(0.0F, 3.2933F, -0.3098F, 0.0F, 4.0F, 32.0F, new Dilation(0.0F))
		.uv(0, 149).cuboid(0.0F, -6.7067F, -0.3098F, 0.0F, 3.0F, 32.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.8F, 32.0F, 0.0873F, 0.0F, 0.0F));

		ModelPartData tail3 = tail2.addChild("tail3", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -2.7686F, -0.1825F, 6.0F, 6.0F, 37.0F, new Dilation(0.0F))
		.uv(156, 13).cuboid(0.0F, -6.7686F, -0.1825F, 0.0F, 4.0F, 29.0F, new Dilation(0.0F))
		.uv(28, 198).cuboid(0.0F, 3.2314F, -0.1825F, 0.0F, 4.0F, 25.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.5762F, 31.5254F, -0.0436F, 0.0F, 0.0F));

		ModelPartData tail4 = tail3.addChild("tail4", ModelPartBuilder.create().uv(50, 7).cuboid(-3.0F, -2.8005F, 0.2055F, 5.0F, 5.0F, 37.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 1.3649F, 34.6065F, -0.2618F, 0.0F, 0.0F));

		ModelPartData spine1 = pelvis.addChild("spine1", ModelPartBuilder.create().uv(162, 143).cuboid(-4.5F, -5.0F, -19.0F, 9.0F, 8.0F, 23.0F, new Dilation(0.0F))
		.uv(0, 185).cuboid(3.0F, -3.0F, -19.0F, 11.0F, 18.0F, 15.0F, new Dilation(0.0F))
		.uv(145, 175).cuboid(-14.0F, -3.0F, -19.0F, 11.0F, 18.0F, 15.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 5.0F, -5.0F));

		ModelPartData spine2 = spine1.addChild("spine2", ModelPartBuilder.create().uv(158, 101).cuboid(-4.5F, -5.0F, -23.0F, 9.0F, 8.0F, 23.0F, new Dilation(0.0F))
		.uv(200, 73).cuboid(3.0F, -3.0F, -18.0F, 10.0F, 16.0F, 15.0F, new Dilation(0.0F))
		.uv(88, 190).cuboid(-13.0F, -3.0F, -18.0F, 10.0F, 16.0F, 15.0F, new Dilation(0.0F))
		.uv(128, 229).cuboid(1.8F, -7.1199F, -17.5887F, 4.0F, 5.0F, 13.0F, new Dilation(0.0F))
		.uv(93, 229).cuboid(-5.8F, -7.1199F, -17.5887F, 4.0F, 5.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -19.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData spine_sail1 = spine2.addChild("spine_sail1", ModelPartBuilder.create().uv(0, 44).cuboid(0.0F, -18.916F, -52.98F, 0.0F, 32.0F, 32.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.2211F, 36.7568F, -0.0436F, 0.0F, 0.0F));

		ModelPartData right_shoulder = spine2.addChild("right_shoulder", ModelPartBuilder.create().uv(176, 187).mirrored().cuboid(-23.0F, -3.0F, -17.0F, 5.0F, 5.0F, 22.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.5314F, -0.5844F, -0.3136F));

		ModelPartData left_shoulder = spine2.addChild("left_shoulder", ModelPartBuilder.create().uv(176, 187).cuboid(18.0F, -3.0F, -17.0F, 5.0F, 5.0F, 22.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.5314F, 0.5844F, 0.3136F));

		ModelPartData neck1 = spine2.addChild("neck1", ModelPartBuilder.create().uv(204, 137).cuboid(-3.5F, -4.0937F, -15.5774F, 8.0F, 9.0F, 16.0F, new Dilation(0.0F))
		.uv(186, 0).cuboid(-3.5F, -4.0937F, -17.5774F, 8.0F, 18.0F, 16.0F, new Dilation(0.7F))
		.uv(235, 0).cuboid(0.5F, -10.0937F, -15.5774F, 0.0F, 6.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -1.0F, -20.0F, -0.4363F, 0.0F, 0.0F));

		ModelPartData neck2 = neck1.addChild("neck2", ModelPartBuilder.create().uv(217, 35).cuboid(-3.0F, -4.0038F, -10.0872F, 7.0F, 8.0F, 13.0F, new Dilation(0.0F))
		.uv(33, 157).cuboid(0.5F, -10.0038F, -10.0872F, 0.0F, 6.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.0937F, -17.5774F, 0.0873F, 0.0F, 0.0F));

		ModelPartData head = neck2.addChild("head", ModelPartBuilder.create().uv(80, 124).cuboid(-6.0F, -10.0F, -14.0F, 13.0F, 10.0F, 14.0F, new Dilation(0.0F))
		.uv(209, 175).cuboid(-6.0F, -9.0F, -14.0F, 13.0F, 2.0F, 14.0F, new Dilation(0.5F))
		.uv(44, 169).cuboid(-3.5F, -7.0F, -35.0F, 8.0F, 7.0F, 21.0F, new Dilation(0.0F))
		.uv(0, 222).cuboid(-3.5F, -7.0F, -20.0F, 8.0F, 32.0F, 6.0F, new Dilation(0.5F))
		.uv(33, 50).cuboid(-3.5F, 0.0F, -35.0F, 8.0F, 4.0F, 21.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, -8.0F, 0.3054F, 0.0F, 0.0F));

		ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create().uv(29, 228).cuboid(-4.0F, -2.0F, -6.0F, 9.0F, 7.0F, 11.0F, new Dilation(0.0F))
		.uv(181, 47).cuboid(-3.0F, 0.0F, -27.0F, 7.0F, 4.0F, 21.0F, new Dilation(0.0F))
		.uv(216, 198).cuboid(-3.0F, 4.0F, -27.0F, 7.0F, 2.0F, 17.0F, new Dilation(0.0F))
		.uv(202, 112).cuboid(-2.5F, -3.0F, -27.0F, 6.0F, 3.0F, 21.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, -7.0F));

		ModelPartData crown = head.addChild("crown", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData under_crown = crown.addChild("under_crown", ModelPartBuilder.create().uv(223, 218).cuboid(-7.5F, 0.0F, -4.0F, 15.0F, 17.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -7.9063F, 1.5774F, -0.3054F, 0.0F, 0.0F));

		ModelPartData right_crown1 = under_crown.addChild("right_crown1", ModelPartBuilder.create().uv(13, 149).cuboid(-5.0F, -2.0F, 0.0F, 6.0F, 8.0F, 3.0F, new Dilation(0.0F))
		.uv(23, 0).cuboid(-5.0F, -4.0F, 1.5F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(29, 19).cuboid(1.0F, 0.0F, 1.5F, 2.0F, 6.0F, 0.0F, new Dilation(0.0F))
		.uv(158, 133).cuboid(-5.0F, 6.0F, 0.0F, 9.0F, 9.0F, 3.0F, new Dilation(0.0F))
		.uv(80, 113).cuboid(-5.0F, 15.0F, 0.0F, 5.0F, 4.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.0F, 15.0F, 1.5F, 2.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(12.5F, 2.0F, -7.0F));

		ModelPartData right_crown2 = right_crown1.addChild("right_crown2", ModelPartBuilder.create().uv(84, 50).cuboid(-1.5F, 0.0F, -3.0F, 3.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.5F, 19.0F, 3.0F, -0.2618F, 0.0F, 0.0F));

		ModelPartData left_crown = under_crown.addChild("left_crown", ModelPartBuilder.create().uv(13, 149).mirrored().cuboid(-1.0F, -2.0F, 0.0F, 6.0F, 8.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
		.uv(23, 0).mirrored().cuboid(1.0F, -4.0F, 1.5F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
		.uv(29, 19).mirrored().cuboid(-3.0F, 0.0F, 1.5F, 2.0F, 6.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
		.uv(158, 133).mirrored().cuboid(-4.0F, 6.0F, 0.0F, 9.0F, 9.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
		.uv(80, 113).mirrored().cuboid(0.0F, 15.0F, 0.0F, 5.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 0).mirrored().cuboid(-2.0F, 15.0F, 1.5F, 2.0F, 3.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-12.5F, 2.0F, -7.0F));

		ModelPartData left_crown2 = left_crown.addChild("left_crown2", ModelPartBuilder.create().uv(84, 50).mirrored().cuboid(-1.5F, 0.0F, -3.0F, 3.0F, 7.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.5F, 19.0F, 3.0F, -0.2618F, 0.0F, 0.0F));

		ModelPartData snake = crown.addChild("snake", ModelPartBuilder.create().uv(172, 84).cuboid(0.0F, -83.0937F, -99.5774F, 0.0F, 7.0F, 9.0F, new Dilation(0.0F))
		.uv(29, 10).mirrored().cuboid(-4.5F, -81.5937F, -93.5774F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
		.uv(29, 10).cuboid(1.5F, -81.5937F, -93.5774F, 3.0F, 8.0F, 0.0F, new Dilation(0.0F))
		.uv(26, 32).cuboid(1.0F, -80.0937F, -96.5774F, 1.0F, 1.0F, 3.0F, new Dilation(0.5F))
		.uv(71, 50).cuboid(-1.0F, -81.0937F, -94.5774F, 2.0F, 8.0F, 2.0F, new Dilation(0.5F))
		.uv(29, 26).cuboid(-1.5F, -77.5937F, -100.0774F, 3.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(26, 32).cuboid(-2.0F, -80.0937F, -96.5774F, 1.0F, 1.0F, 3.0F, new Dilation(0.5F))
		.uv(98, 0).cuboid(-1.0F, -81.0937F, -99.5774F, 2.0F, 3.0F, 4.0F, new Dilation(0.5F)), ModelTransform.pivot(0.5F, 66.0937F, 77.5774F));

		ModelPartData upper_crown = crown.addChild("upper_crown", ModelPartBuilder.create().uv(95, 166).cuboid(-7.0F, -6.0F, -17.0F, 15.0F, 6.0F, 17.0F, new Dilation(0.01F)), ModelTransform.of(0.0F, -7.9063F, 1.5774F, -0.1309F, 0.0F, 0.0F));

		ModelPartData desert_necklace = neck2.addChild("desert_necklace", ModelPartBuilder.create().uv(82, 169).cuboid(-4.0F, 0.0F, -1.5F, 8.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -4.9063F, -0.9226F, 0.2182F, 0.0F, 0.0F));

		ModelPartData chain1 = desert_necklace.addChild("chain1", ModelPartBuilder.create().uv(147, 104).cuboid(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.0F, 0.0F));

		ModelPartData chain2 = chain1.addChild("chain2", ModelPartBuilder.create().uv(147, 104).cuboid(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 5.0F, 0.0F));

		ModelPartData chain3 = chain2.addChild("chain3", ModelPartBuilder.create().uv(147, 104).cuboid(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 5.0F, 0.0F));

		ModelPartData chain4 = chain3.addChild("chain4", ModelPartBuilder.create().uv(147, 104).cuboid(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 5.0F, 0.0F));

		ModelPartData chain5 = chain4.addChild("chain5", ModelPartBuilder.create().uv(147, 104).cuboid(-4.0F, 0.0F, -1.5F, 8.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 5.0F, 0.0F));

		ModelPartData desert_eye = chain5.addChild("desert_eye", ModelPartBuilder.create().uv(167, 0).mirrored().cuboid(-12.0F, -7.1811F, 0.2836F, 11.0F, 11.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
		.uv(167, 0).cuboid(1.0F, -7.1811F, 0.2836F, 11.0F, 11.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.7811F, -0.2836F));

		ModelPartData eye = desert_eye.addChild("eye", ModelPartBuilder.create().uv(98, 50).cuboid(-5.0F, -5.0F, -1.0F, 10.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.7811F, 0.2836F, 0.0F, 0.0F, 0.7854F));

		ModelPartData left_arm = spine2.addChild("left_arm", ModelPartBuilder.create().uv(47, 109).cuboid(-6.0F, -4.0637F, -3.0436F, 6.0F, 20.0F, 5.0F, new Dilation(0.0F))
		.uv(0, 109).cuboid(-6.0F, -4.0637F, -3.0436F, 6.0F, 20.0F, 5.0F, new Dilation(0.5F)), ModelTransform.of(13.2F, 10.0F, -17.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData left_front_arm = left_arm.addChild("left_front_arm", ModelPartBuilder.create().uv(156, 47).cuboid(-3.0F, -0.1465F, -2.2077F, 6.0F, 11.0F, 5.0F, new Dilation(0.0F))
		.uv(0, 169).cuboid(-3.0F, 2.8535F, -2.2077F, 6.0F, 5.0F, 5.0F, new Dilation(0.5F)), ModelTransform.of(-4.0F, 15.2977F, -1.9036F, -0.829F, 0.0F, 0.0F));

		ModelPartData left_hand = left_front_arm.addChild("left_hand", ModelPartBuilder.create(), ModelTransform.of(1.0F, 10.1551F, -0.5133F, 1.6144F, 0.0F, 0.0F));

		ModelPartData left_finger3 = left_hand.addChild("left_finger3", ModelPartBuilder.create().uv(0, 149).cuboid(-0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0049F, 0.3079F, -0.7216F, -0.2324F, 0.2F));

		ModelPartData left_finger1 = left_hand.addChild("left_finger1", ModelPartBuilder.create().uv(147, 84).cuboid(0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 0.0049F, 0.3079F, -0.7216F, 0.2324F, -0.2F));

		ModelPartData left_finger2 = left_hand.addChild("left_finger2", ModelPartBuilder.create().uv(0, 149).cuboid(-0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0049F, 0.3079F, -0.7258F, 0.0F, 0.0F));

		ModelPartData right_arm = spine2.addChild("right_arm", ModelPartBuilder.create().uv(47, 109).mirrored().cuboid(0.0F, -4.0637F, -3.0436F, 6.0F, 20.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-13.2F, 10.0F, -17.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData right_front_arm = right_arm.addChild("right_front_arm", ModelPartBuilder.create().uv(156, 47).mirrored().cuboid(-3.0F, -0.1465F, -2.2077F, 6.0F, 11.0F, 5.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 169).mirrored().cuboid(-3.0F, 2.8535F, -2.2077F, 6.0F, 5.0F, 5.0F, new Dilation(0.5F)).mirrored(false), ModelTransform.of(4.0F, 15.2977F, -1.9036F, -0.829F, 0.0F, 0.0F));

		ModelPartData right_hand = right_front_arm.addChild("right_hand", ModelPartBuilder.create(), ModelTransform.of(-1.0F, 10.1551F, -0.5133F, 1.6144F, 0.0F, 0.0F));

		ModelPartData right_finger1 = right_hand.addChild("right_finger1", ModelPartBuilder.create().uv(0, 149).mirrored().cuboid(0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.0F, 0.0049F, 0.3079F, -0.7216F, 0.2324F, -0.2F));

		ModelPartData right_finger2 = right_hand.addChild("right_finger2", ModelPartBuilder.create().uv(0, 149).mirrored().cuboid(0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.0F, 0.0049F, 0.3079F, -0.7258F, 0.0F, 0.0F));

		ModelPartData right_finger3 = right_hand.addChild("right_finger3", ModelPartBuilder.create().uv(147, 84).mirrored().cuboid(-0.2215F, -3.2106F, -9.8849F, 0.0F, 7.0F, 12.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.0F, 0.0049F, 0.3079F, -0.7216F, -0.2324F, 0.2F));

		ModelPartData spine_deco = spine2.addChild("spine_deco", ModelPartBuilder.create().uv(98, 0).cuboid(-13.2F, 0.0F, -16.5F, 26.0F, 25.0F, 16.0F, new Dilation(0.5F)), ModelTransform.of(0.0F, -7.3F, -6.7F, -0.1309F, 0.0F, 0.0F));

		ModelPartData legs = mid_pivot.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 4.0F, 7.0F));

		ModelPartData left_leg = legs.addChild("left_leg", ModelPartBuilder.create().uv(165, 215).cuboid(-6.0F, -2.0261F, -4.1809F, 8.0F, 34.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(15.0F, 0.0F, 6.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData left_deco1 = left_leg.addChild("left_deco1", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -8.0F, 1.0F, 8.0F, 28.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 10.9739F, -8.1809F, 0.0959F, -0.4349F, -0.0329F));

		ModelPartData left_front_leg = left_leg.addChild("left_front_leg", ModelPartBuilder.create().uv(0, 44).cuboid(-5.0F, -2.5649F, -1.6913F, 8.0F, 24.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 32.9739F, -2.1809F, 1.0908F, 0.0F, 0.0F));

		ModelPartData left_ankel_joint = left_front_leg.addChild("left_ankel_joint", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 20.6148F, 1.661F));

		ModelPartData left_mini_bone = left_ankel_joint.addChild("left_mini_bone", ModelPartBuilder.create().uv(29, 0).cuboid(0.0209F, -3.1113F, 0.0913F, 0.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 11.0F, -6.0F, -0.3928F, -0.0035F, 0.0001F));

		ModelPartData left_deco2 = left_ankel_joint.addChild("left_deco2", ModelPartBuilder.create().uv(61, 210).cuboid(-2.0F, -2.7487F, 0.1981F, 4.0F, 6.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.0F, -4.9602F, 0.5236F, 0.0F, 0.0F));

		ModelPartData left_deco3 = left_ankel_joint.addChild("left_deco3", ModelPartBuilder.create().uv(33, 45).cuboid(-0.2F, -11.7017F, -4.0722F, 4.0F, 13.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 9.0F, -7.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData left_ankel = left_ankel_joint.addChild("left_ankel", ModelPartBuilder.create().uv(54, 198).cuboid(-3.0F, -0.2489F, -2.0393F, 6.0F, 15.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		ModelPartData left_foot = left_ankel_joint.addChild("left_foot", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.0F, -8.0F));

		ModelPartData left_toe = left_foot.addChild("left_toe", ModelPartBuilder.create().uv(71, 50).cuboid(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.8218F, -0.2377F, -0.6981F, 0.0F, 0.0F));

		ModelPartData left_toe2 = left_foot.addChild("left_toe2", ModelPartBuilder.create().uv(71, 50).cuboid(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -1.8218F, -0.2377F, -0.7216F, 0.2324F, -0.2F));

		ModelPartData left_toe3 = left_foot.addChild("left_toe3", ModelPartBuilder.create().uv(71, 50).cuboid(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -1.8218F, -0.2377F, -0.7216F, -0.2324F, 0.2F));

		ModelPartData right_leg = legs.addChild("right_leg", ModelPartBuilder.create().uv(165, 215).mirrored().cuboid(-2.0F, -2.0261F, -4.1809F, 8.0F, 34.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-15.0F, 0.0F, 6.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData right_deco1 = right_leg.addChild("right_deco1", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-5.0F, -8.0F, 1.0F, 8.0F, 28.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.0F, 10.9739F, -8.1809F, 0.0959F, 0.4349F, 0.0329F));

		ModelPartData right_front_leg = right_leg.addChild("right_front_leg", ModelPartBuilder.create().uv(0, 44).mirrored().cuboid(-3.0F, -2.5649F, -1.6913F, 8.0F, 24.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.0F, 32.9739F, -2.1809F, 1.0908F, 0.0F, 0.0F));

		ModelPartData right_ankel_joint = right_front_leg.addChild("right_ankel_joint", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 20.6148F, 1.661F));

		ModelPartData right_mini_bone = right_ankel_joint.addChild("right_mini_bone", ModelPartBuilder.create().uv(29, 0).mirrored().cuboid(-0.0209F, -3.1113F, 0.0913F, 0.0F, 6.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.0F, 11.0F, -6.0F, -0.3928F, 0.0035F, -0.0001F));

		ModelPartData right_deco2 = right_ankel_joint.addChild("right_deco2", ModelPartBuilder.create().uv(61, 210).mirrored().cuboid(-2.0F, -2.7487F, 0.1981F, 4.0F, 6.0F, 18.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 6.0F, -4.9602F, 0.5236F, 0.0F, 0.0F));

		ModelPartData right_deco3 = right_ankel_joint.addChild("right_deco3", ModelPartBuilder.create().uv(33, 45).mirrored().cuboid(-3.8F, -11.7017F, -4.0722F, 4.0F, 13.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.0F, 9.0F, -7.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData right_ankel = right_ankel_joint.addChild("right_ankel", ModelPartBuilder.create().uv(54, 198).mirrored().cuboid(-3.0F, -0.2489F, -2.0393F, 6.0F, 15.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -1.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		ModelPartData right_foot = right_ankel_joint.addChild("right_foot", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.0F, -8.0F));

		ModelPartData right_toe = right_foot.addChild("right_toe", ModelPartBuilder.create().uv(71, 50).mirrored().cuboid(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -1.8218F, -0.2377F, -0.6981F, 0.0F, 0.0F));

		ModelPartData right_toe2 = right_foot.addChild("right_toe2", ModelPartBuilder.create().uv(71, 50).mirrored().cuboid(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.0F, -1.8218F, -0.2377F, -0.7216F, -0.2324F, 0.2F));

		ModelPartData right_toe3 = right_foot.addChild("right_toe3", ModelPartBuilder.create().uv(71, 50).mirrored().cuboid(0.0F, 0.2465F, -9.1823F, 0.0F, 7.0F, 12.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.0F, -1.8218F, -0.2377F, -0.7216F, 0.2324F, -0.2F));

		return TexturedModelData.of(meshdefinition, 512, 512);
	}

	@Override
	public void setAngles(Ancient_Remnant_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.animateHeadLookTarget(netHeadYaw, headPitch);

		if(entityIn.getAttackState() != 10 && entityIn.getAttackState() != 11 && entityIn.getAttackState() != 12 && !entityIn.isSleep()) {
			this.animateMovement(Ancient_Remnant_Animation.WALK, limbSwing, limbSwingAmount, 1.0F, 4.0F);
		}


		this.updateAnimation(entityIn.getAnimationState("idle"), Ancient_Remnant_Animation.IDLE, ageInTicks, entityIn.getNecklace() ? 1.0f : 0.15F);
		this.updateAnimation(entityIn.getAnimationState("death"), Ancient_Remnant_Animation.DEATH, ageInTicks, 1.0F);
		this.updateAnimation(entityIn.getAnimationState("right_bite"), Ancient_Remnant_Animation.RIGHT_BITE, ageInTicks, 1.0F);
		this.updateAnimation(entityIn.getAnimationState("sandstorm_roar"), Ancient_Remnant_Animation.SAND_STORM_ROAR, ageInTicks, 1.0F);
		this.updateAnimation(entityIn.getAnimationState("phase_roar"), Ancient_Remnant_Animation.PHASE_ROAR, ageInTicks, 1.0F);
		this.updateAnimation(entityIn.getAnimationState("charge"), Ancient_Remnant_Animation.CHARGE, ageInTicks, 1.0F);
		this.updateAnimation(entityIn.getAnimationState("sleep"), Ancient_Remnant_Animation.SLEEP, ageInTicks, 1.0F);
		this.updateAnimation(entityIn.getAnimationState("awaken"), Ancient_Remnant_Animation.AWAKEN, ageInTicks, 1.0F);
		this.updateAnimation(entityIn.getAnimationState("left_double_stomp"), Ancient_Remnant_Power_Animation.DOUBLE_STOMP2, ageInTicks, 1.0F);
		this.updateAnimation(entityIn.getAnimationState("right_double_stomp"), Ancient_Remnant_Power_Animation.DOUBLE_STOMP1, ageInTicks, 1.0F);
		this.updateAnimation(entityIn.getAnimationState("ground_tail"), Ancient_Remnant_Power_Animation.GROUND_TAIL, ageInTicks, 1.0F);

		this.updateAnimation(entityIn.getAnimationState("tail_swing"), Ancient_Remnant_Power_Animation.TAIL_SWING, ageInTicks, 1.0F);
		this.updateAnimation(entityIn.getAnimationState("monolith"), Ancient_Remnant_Power_Animation.MONOLITH, ageInTicks, 1.0F);

		this.updateAnimation(entityIn.getAnimationState("right_stomp"), Ancient_Remnant_Animation.STOMP1, ageInTicks, 1.0F);
		this.updateAnimation(entityIn.getAnimationState("left_stomp"), Ancient_Remnant_Animation.STOMP2, ageInTicks, 1.0F);
		this.updateAnimation(entityIn.getAnimationState("charge_prepare"), Ancient_Remnant_Animation.CHARGE_PREPARE, ageInTicks, 1.0F);
		this.updateAnimation(entityIn.getAnimationState("charge_stun"), Ancient_Remnant_Animation.CHARGE_STUN, ageInTicks, 1.0F);
		float partialTick = MinecraftClient.getInstance().getTickDelta();

		if (!entityIn.isSleep()) {
			articulateLegs(entityIn.legSolver, partialTick);
		}

		desert_necklace.visible = entityIn.getNecklace();

	}

	private void animateHeadLookTarget(float yRot, float xRot) {
		this.head.pitch += xRot * ((float) Math.PI / 180F);
		this.head.yaw = yRot * ((float) Math.PI / 180F);
	}


	private void articulateLegs(LegSolver legs, float partialTick) {
		float heightBackLeft = legs.legs[0].getHeight(partialTick);
		float heightBackRight = legs.legs[1].getHeight(partialTick);
		float max = (1F - smin(1F - heightBackLeft, 1F - heightBackRight, 0.1F)) * 0.8F;
		roots.pivotY += max * 16;
		right_leg.pivotY += (heightBackRight - max) * 16;
		left_leg.pivotY += (heightBackLeft - max) * 16;
	}

	private static float smin(float a, float b, float k) {
		float h = Math.max(k - Math.abs(a - b), 0.0F) / k;
		return Math.min(a, b) - h * h * k * (1.0F / 4.0F);
	}

	public ModelPart getPart() {
		return this.root;
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}