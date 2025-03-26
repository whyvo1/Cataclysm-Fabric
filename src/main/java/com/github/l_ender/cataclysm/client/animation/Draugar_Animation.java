package com.github.l_ender.cataclysm.client.animation;// Save this class in your mod and generate all required imports


import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;


public class Draugar_Animation {
	public static final Animation IDLE  = Animation.Builder.create(1.75F).looping()
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("maw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation WALK = Animation.Builder.create(1.0F).looping()
		.addBoneAnimation("r_arm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 10.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 10.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wind1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 360.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wind1", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.4F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.5F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.3F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.3F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0374F, -4.9238F, -0.8704F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(10.0845F, 7.3854F, 1.3096F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(10.0374F, -4.9238F, -0.8704F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, -25.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(22.5F, 0.0F, -25.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, -25.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 25.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 25.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 25.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("maw", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.build();

	public static final Animation ATTACK = Animation.Builder.create(0.8333F)
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 3.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -4.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(0.7977F, -15.1494F, -3.8531F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(31.4799F, 32.1499F, 19.6843F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(-179.6746F, -27.6632F, 19.0237F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-50.4324F, -0.9599F, 11.0691F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -2.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(-22.5F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-11.5762F, -38.0566F, 1.9515F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("maw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation ATTACK2 = Animation.Builder.create(0.8333F)
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 3.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -3.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -3.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 2.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(26.6064F, 19.4362F, 16.5732F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(26.7143F, -16.7525F, -11.8935F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(-107.4356F, 4.3113F, -60.6327F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(25.9377F, -16.7974F, -68.5151F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createTranslationalVector(1.0F, 0.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-75.6764F, 37.1326F, 22.9131F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(-4.8587F, -22.467F, -1.5514F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-10.7318F, 6.8622F, -0.9504F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -2.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("maw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	
	
	public static final Animation RELOAD = Animation.Builder.create(0.875F).looping()
		.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 17.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -17.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-38.4607F, 14.5864F, 22.6834F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-61.4199F, -24.9177F, -33.4574F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(-41.3892F, -49.9544F, -65.1261F), Transformation.Interpolations.CUBIC)
		))
		.build();

	public static final Animation SHOOT = Animation.Builder.create(0.875F).looping()
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.2083F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-92.5286F, 17.8637F, -0.5166F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-89.0672F, -29.6527F, -11.5537F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 17.5F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -17.5F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("maw", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.2917F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.build();
}