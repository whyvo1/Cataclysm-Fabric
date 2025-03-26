package com.github.l_ender.cataclysm.client.animation;// Save this class in your mod and generate all required imports

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

/**
 * Made with Blockbench 4.10.4
 * Exported for Minecraft version 1.19 or later with Mojang mappings
 * @author kor
 */
public class Aptrgangr_Animation {
	public static final Animation IDLE = Animation.Builder.create(2.0F).looping()
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.2965F, 2.1578F, 1.2968F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation WALK = Animation.Builder.create(1.3333F).looping()
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 4.3F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -2.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 4.3F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.4F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 4.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, -1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.5F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0374F, -4.9238F, -0.8704F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(10.0845F, 7.3854F, 1.3096F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(10.0374F, -4.9238F, -0.8704F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.0041F, 14.4775F, 3.9671F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(15.9153F, -19.291F, -5.3815F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(12.0041F, 14.4775F, 3.9671F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-15.1226F, -9.45F, 4.1278F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-13.1168F, 14.0812F, -2.9543F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-15.1226F, -9.45F, 4.1278F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(-0.6F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.6F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-43.4907F, 11.0007F, -22.7608F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(21.4345F, -9.9736F, -30.9513F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-43.4907F, 11.0007F, -22.7608F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-65.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-65.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation DEATH = Animation.Builder.create(3.0F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.25F, AnimationHelper.createRotationalVector(-11.9409F, -5.7358F, -11.125F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(-0.4987F, -2.479F, 3.5571F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-0.4987F, -2.479F, 3.5571F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, -3.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, -1.5F, -6.25F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -7.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -7.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.554F, 12.4879F, 2.5606F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, -4.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, -4.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.25F, AnimationHelper.createRotationalVector(-7.4718F, 0.6518F, -10.0426F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(20.493F, 9.1955F, 3.8222F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(20.4344F, 13.6784F, 5.3916F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(20.4344F, 13.6784F, 5.3916F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("neck", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.25F, AnimationHelper.createRotationalVector(-24.1105F, -20.0261F, -14.1293F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createRotationalVector(7.3959F, -9.8375F, 3.3015F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(8.126F, -10.5179F, -6.7929F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(8.126F, -10.5179F, -6.7929F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(22.4491F, -7.544F, 13.238F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(22.4491F, -7.544F, 13.238F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, -1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createTranslationalVector(0.0F, -0.87F, -1.94F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9583F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(-62.4776F, -2.2174F, -1.1549F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(-62.4776F, -2.2174F, -1.1549F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.25F, AnimationHelper.createRotationalVector(7.9753F, -19.8217F, -32.7199F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, -30.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, -30.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(-17.25F, 2.9932F, -20.4541F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_arm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.25F, AnimationHelper.createTranslationalVector(2.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createTranslationalVector(1.0F, -3.0F, -3.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(-25.2403F, 41.43F, 3.1944F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(-25.2403F, 41.43F, 3.1944F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.25F, AnimationHelper.createRotationalVector(-8.4268F, 25.4967F, 28.4835F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(40.1099F, -20.7731F, 9.4233F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(40.1099F, -20.7731F, 9.4233F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 2.0F, -7.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -8.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -8.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createRotationalVector(97.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(97.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createRotationalVector(9.8857F, -5.075F, 63.3706F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(9.8857F, -5.075F, 63.3706F), Transformation.Interpolations.CUBIC)
			))
			.build();


	public static final Animation SWING_RIGHT = Animation.Builder.create(2.0F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, -27.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -27.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(0.0F, 25.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 25.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(22.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-2.6073F, 1.5952F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(-1.0F, 0.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(-1.11F, 4.0F, -2.57F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(-1.0F, 0.0F, -3.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(32.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(1.0F, 0.0F, -2.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 3.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(54.7946F, -23.6208F, -51.4774F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createRotationalVector(54.7946F, -23.6208F, -51.4774F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-25.3211F, 49.2748F, -1.0169F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-25.3211F, 49.2748F, -1.0169F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(-46.7718F, 49.5558F, -33.4863F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-31.1525F, -39.2716F, 18.7857F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-11.1871F, -23.2945F, 4.6011F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(39.8537F, 16.6993F, -18.2012F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(14.3461F, -0.3984F, -44.4513F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createRotationalVector(33.1452F, -5.8107F, -22.5712F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-46.11F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(-39.0759F, -20.475F, 37.2799F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-42.0277F, -14.9519F, 66.9226F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(106.6862F, -34.15F, 31.4058F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createTranslationalVector(4.0F, 0.0F, -7.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createTranslationalVector(4.0F, 0.0F, -7.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(4.0F, 0.0F, -7.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(66.5685F, -19.9035F, 19.3763F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(66.5685F, -19.9035F, 19.3763F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(100.1065F, 9.4277F, 24.4539F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(57.738F, 5.9438F, 4.5822F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("cloth2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("cloth", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe_head", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createScalingVector(1.0F, 2.3F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.2083F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation SMASH = Animation.Builder.create(2.0F)
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-42.9129F, 2.927F, 7.3122F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-2.5F, 17.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 17.5F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-174.8084F, -16.0539F, -17.2016F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createRotationalVector(-83.2559F, 35.7722F, -6.3006F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-83.2559F, 35.7722F, -6.3006F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_arm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(-2.0F, 2.0F, -6.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -9.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -9.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.7917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-23.1898F, -3.0467F, 34.6336F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-18.4281F, 1.7305F, 3.0857F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-37.8109F, -12.4789F, 15.1625F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(19.2454F, -40.5325F, -47.1598F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createRotationalVector(36.7454F, -40.5325F, -47.1598F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(3.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -6.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -6.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(92.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createRotationalVector(82.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -1.8F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, -7.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.9167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(-2.6117F, 1.2469F, -1.5185F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(32.0017F, 3.2211F, -3.9227F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(32.0017F, 3.2211F, -3.9227F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -3.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 3.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 3.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createRotationalVector(36.1331F, -18.6925F, -3.6544F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.2917F, AnimationHelper.createRotationalVector(36.1331F, -18.6925F, -3.6544F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.6103F, -2.5857F, 39.5006F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.6103F, -2.5857F, 39.5006F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe_head", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createScalingVector(1.0F, 2.1F, 0.7F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation RUSH_START = Animation.Builder.create(1.1667F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -4.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(30.334F, 10.0559F, 1.3451F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(30.334F, 10.0559F, 1.3451F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(6.6711F, 49.2917F, -15.5697F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(6.6711F, 49.2917F, -15.5697F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-21.8845F, -34.3504F, 24.8068F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-31.8845F, -34.3504F, 24.8068F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-86.1823F, 29.601F, -4.9712F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-86.1823F, 29.601F, -4.9712F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_arm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-98.8297F, 61.5119F, -86.3006F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-98.8297F, 61.5119F, -86.3006F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(29.4316F, -0.9657F, -7.2943F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(29.4316F, -0.9657F, -7.2943F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(42.2339F, 11.0311F, -28.0756F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(42.2339F, 11.0311F, -28.0756F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 86.42F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 86.42F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation RUSHING = Animation.Builder.create(1.0F).looping()
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(30.334F, 10.0559F, 1.3451F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(30.334F, 10.0559F, 1.3451F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(6.6711F, 49.2917F, -15.5697F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(9.505F, 48.8322F, -11.8189F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(6.6711F, 49.2917F, -15.5697F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-21.8845F, -34.3504F, 24.8068F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-23.1335F, -36.1181F, 26.9713F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-21.8845F, -34.3504F, 24.8068F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-86.1823F, 29.601F, -4.9712F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-86.2711F, 27.1064F, -5.1581F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-86.1823F, 29.601F, -4.9712F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_arm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-98.8297F, 61.5119F, -86.3006F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-98.8297F, 61.5119F, -86.3006F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(29.4316F, -0.9657F, -7.2943F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(29.883F, 0.2905F, -5.0862F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(29.4316F, -0.9657F, -7.2943F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(42.2339F, 11.0311F, -28.0756F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(39.7339F, 11.0311F, -28.0756F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(42.2339F, 11.0311F, -28.0756F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 86.42F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 86.42F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation RUSH_END = Animation.Builder.create(1.125F)
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4167F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2083F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, -4.42F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -6.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -6.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(30.334F, 10.0559F, 1.3451F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-17.8981F, -11.9128F, 3.814F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-17.8981F, -11.9128F, 3.814F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(6.6711F, 49.2917F, -15.5697F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-38.3132F, -30.3611F, 7.7457F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-38.3132F, -30.3611F, 7.7457F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-21.8845F, -34.3504F, 24.8068F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(-20.2799F, -0.9967F, -3.3981F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-20.2799F, -0.9967F, -3.3981F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-86.1823F, 29.601F, -4.9712F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4167F, AnimationHelper.createRotationalVector(23.7877F, -0.4615F, -45.4199F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(23.7877F, -0.4615F, -45.4199F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_arm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-98.8297F, 61.5119F, -86.3006F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(29.4316F, -0.9657F, -7.2943F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.125F, AnimationHelper.createRotationalVector(106.6849F, -22.5518F, 19.9839F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-13.478F, -4.0948F, 5.0443F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(42.2339F, 11.0311F, -28.0756F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.1667F, AnimationHelper.createRotationalVector(75.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 86.42F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("neck", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe_head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2083F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe_head", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.125F, AnimationHelper.createScalingVector(1.0F, 2.3F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4167F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation RUSH_HIT = Animation.Builder.create(0.875F)
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, -5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(30.334F, 10.0559F, 1.3451F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-14.666F, 10.0559F, 1.3451F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(6.6711F, 49.2917F, -15.5697F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-28.5614F, 22.0295F, -20.1233F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("chest", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-21.8845F, -34.3504F, 24.8068F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-21.8845F, -34.3504F, 24.8068F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-86.1823F, 29.601F, -4.9712F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-6.8681F, -11.3623F, -48.2997F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_arm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-98.8297F, 61.5119F, -86.3006F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-94.7017F, 26.7197F, -80.6439F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(29.4316F, -0.9657F, -7.2943F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(48.4182F, 18.173F, 42.6509F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(42.2339F, 11.0311F, -28.0756F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 86.42F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("neck", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe_head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("axe_head", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

}