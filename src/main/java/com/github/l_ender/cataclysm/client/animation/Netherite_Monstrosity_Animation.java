package com.github.l_ender.cataclysm.client.animation;// Save this class in your mod and generate all required imports

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Netherite_Monstrosity_Animation {
	public static final Animation IDLE = Animation.Builder.create(2.25F).looping()
		.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.1667F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9583F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.1667F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.build();

	public static final Animation WALK = Animation.Builder.create(2.2083F).looping()
		.addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("lowerbody", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("lowerbody", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(-0.329F, 7.4928F, 4.9785F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.2083F, AnimationHelper.createRotationalVector(0.0F, -5.0F, -5.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(11.847F, 7.0494F, -8.7386F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(7.4366F, -0.9762F, 7.4366F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.2083F, AnimationHelper.createRotationalVector(11.847F, 7.0494F, -8.7386F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.9167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9167F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.2083F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.2083F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.2083F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-5.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5417F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.2083F, AnimationHelper.createRotationalVector(-5.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, -10.4F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 4.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, -10.5F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(-5.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.2083F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 6.3F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 9.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.5F, 0.0F, -13.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 6.3F), Transformation.Interpolations.CUBIC)
		))
		.build();

	public static final Animation SMASH = Animation.Builder.create(2.875F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, -12.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.2917F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lowerbody", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-22.5131F, -4.6691F, -7.7096F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(2.4621F, -0.434F, 9.9907F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-142.448F, -31.7449F, -3.357F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-111.3411F, 9.9509F, -9.0921F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-111.3411F, 9.9509F, -9.0921F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 15.0F, -12.4F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -20.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -18.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -18.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-14.5182F, 4.7511F, 11.5752F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-14.5182F, 4.7511F, 11.5752F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lefthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftfinger1", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftfinger2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftfinger3", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-142.5206F, 26.4438F, -1.9855F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-111.3411F, -9.9509F, 9.0921F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-111.3411F, -9.9509F, 9.0921F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 15.0F, -12.4F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -20.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -18.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -18.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-14.5182F, -4.7511F, -11.5752F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-14.5182F, -4.7511F, -11.5752F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("righthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightfinger1", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, -32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, -32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightfinger2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(12.5F, 0.0F, -32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(12.5F, 0.0F, -32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightfinger3", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 17.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -8.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 7.07F, -11.85F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, -19.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, -19.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, -12.0F, 5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, -12.0F, 5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();


	public static final Animation SLEEP = Animation.Builder.create(0.0F).looping()
			.addBoneAnimation("lowerbody", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-90.0F, 37.5F, -90.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(13.0F, 0.0F, -7.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lefthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-90.0F, -37.5F, 90.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-13.0F, 0.0F, -7.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("righthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -7.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -6.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation AWAKE = Animation.Builder.create(2.0F)
			.addBoneAnimation("lowerbody", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.1667F, AnimationHelper.createRotationalVector(40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-90.0F, 37.5F, -90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-90.0F, 32.5F, -90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-90.0F, 37.5F, -90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(13.0F, 0.0F, -7.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(13.0F, -3.0F, -10.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(13.0F, 0.0F, -7.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lefthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lefthand", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 8.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, 8.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-90.0F, -37.5F, 90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-90.0F, -32.5F, 90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-90.0F, -37.5F, 90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-13.0F, 0.0F, -7.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(-13.0F, -3.0F, -10.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(-13.0F, 0.0F, -7.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("righthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("righthand", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 8.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, 8.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -7.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -7.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -6.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -6.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.1667F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation PHASE = Animation.Builder.create(2.6667F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, -12.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lowerbody", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.2083F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-22.5131F, -4.6691F, -7.7096F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-47.6463F, -15.2879F, 16.9096F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-66.946F, 17.1391F, -16.4022F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-65.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, 2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, 9.01F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, 2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(2.4621F, -0.434F, 9.9907F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(54.0188F, 9.8466F, 17.4952F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(34.121F, -4.5529F, -7.5438F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createRotationalVector(31.9476F, 10.8012F, 6.2734F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-142.448F, -31.7449F, -3.357F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-53.2072F, 24.2886F, 1.4437F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-53.2072F, 24.2886F, 1.4437F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-111.3411F, 9.9509F, -9.0921F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 15.0F, -12.4F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(0.0F, -9.0F, -20.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, -9.0F, -20.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -18.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-51.4145F, 18.6346F, -9.7203F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-14.5182F, 4.7511F, 11.5752F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lefthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftfinger1", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftfinger2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftfinger3", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-142.5206F, 26.4438F, -1.9855F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-47.926F, -23.3339F, -2.7127F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-47.926F, -23.3339F, -2.7127F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-111.3411F, -9.9509F, 9.0921F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 15.0F, -12.4F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(7.0F, 0.0F, -26.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(7.0F, 0.0F, -26.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -18.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-50.722F, -17.3307F, 7.4776F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-14.5182F, -4.7511F, -11.5752F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("righthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightfinger1", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, -32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, -32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightfinger2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(12.5F, 0.0F, -32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(12.5F, 0.0F, -32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightfinger3", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 32.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 17.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -8.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 7.07F, -11.85F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, -19.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, -19.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(0.0F, -12.0F, 5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, -12.0F, 5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation FIRE = Animation.Builder.create(2.1667F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lowerbody", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(90.0F, -57.5F, -90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(90.0F, -57.5F, -90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(90.0F, -42.5F, -90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(90.0F, -42.5F, -90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(90.0F, -57.5F, -90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(14.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(14.0F, -14.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(14.0F, -20.0F, 7.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(14.0F, -14.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lefthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lefthand", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 9.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, 6.74F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, 6.74F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(90.0F, 57.5F, 90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(90.0F, 57.5F, 90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(90.0F, 42.5F, 90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(90.0F, 42.5F, 90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(90.0F, 57.5F, 90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(-14.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(-14.0F, -14.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(-14.0F, -21.0F, 7.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(-14.0F, -14.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("righthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("righthand", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, 7.38F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, 7.38F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.2083F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.2083F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation SHOULDER_CHECK = Animation.Builder.create(3.5F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, -27.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(28.4032F, -39.8557F, -22.9098F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(28.4032F, -39.8557F, -22.9098F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createRotationalVector(49.0085F, -46.3034F, -44.1462F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createRotationalVector(49.0085F, -46.3034F, -44.1462F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9167F, AnimationHelper.createRotationalVector(53.5827F, -49.0814F, -50.3268F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createRotationalVector(-24.0065F, 38.3962F, -7.3262F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-24.0065F, 38.3962F, -7.3262F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createRotationalVector(-24.0065F, 38.3962F, -7.3262F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(-36.5065F, 38.3962F, -7.3262F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(-6.11F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9583F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4167F, AnimationHelper.createRotationalVector(-6.11F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createRotationalVector(26.331F, -11.1448F, -48.5787F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(26.331F, -11.1448F, -48.5787F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createRotationalVector(26.331F, -11.1448F, -48.5787F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createRotationalVector(26.331F, -11.1448F, -48.5787F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(1.2246F, 3.7662F, -46.9397F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createRotationalVector(-60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createRotationalVector(-50.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-16.7549F, -31.4118F, 46.1789F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-16.7549F, -31.4118F, 46.1789F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createRotationalVector(-23.7805F, -38.3299F, 49.7147F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createRotationalVector(10.2463F, 25.2711F, 50.6947F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.1667F, AnimationHelper.createTranslationalVector(0.0F, -0.54F, 10.92F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-77.5F, 0.0F, 35.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createRotationalVector(-92.5F, 0.0F, 35.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-5.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-5.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-5.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createRotationalVector(-5.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, -10.4F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 4.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, -1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, -10.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 4.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, -1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, -10.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 4.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, -1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, -10.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-5.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(-5.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(-5.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 6.3F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 9.5F, -1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.5F, 0.0F, -13.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 6.3F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, 9.5F, -1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.5F, 0.0F, -13.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 6.3F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 9.5F, -1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.5F, 0.0F, -13.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 6.3F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();


	public static final Animation OVERPOWER  = Animation.Builder.create(3.75F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5833F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2917F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, -8.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5417F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-24.113F, 5.1752F, 11.3939F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-42.6415F, -8.2478F, -2.5673F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(-42.6415F, -8.2478F, -2.5673F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(8.7664F, 0.8233F, -7.4549F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-1.2336F, 0.8233F, -7.4549F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.3333F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(12.4F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-140.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(-140.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, -33.0F, 3.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, -32.18F, 10.05F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 18.0F, -27.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, 18.0F, -27.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(-42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(-62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(-62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(12.4F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-140.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(-140.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, -33.0F, 3.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, -31.18F, 10.05F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 18.0F, -27.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, 18.0F, -27.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(-42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(-62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(-62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 9.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 9.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, -8.68F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -13.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -13.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();




	public static final Animation DRAIN = Animation.Builder.create(2.9583F)
			.addBoneAnimation("lowerbody", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.2083F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.2083F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, 90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-90.0F, 60.0F, -90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(-90.0F, 60.0F, -90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(6.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(6.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(8.0F, -20.0F, -25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(8.0F, -20.0F, -25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm2", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 6.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(0.0F, 6.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lefthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lefthand", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, 6.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, -90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-90.0F, -60.0F, 90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(-90.0F, -60.0F, 90.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(-6.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(-6.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(-8.0F, -20.0F, -25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(-8.0F, -20.0F, -25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm2", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 6.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(0.0F, 6.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("righthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("righthand", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, 6.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();


	public static final Animation DEATH = Animation.Builder.create(2.5F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, -1.17F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, -18.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createTranslationalVector(0.0F, -17.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.1667F, AnimationHelper.createRotationalVector(8.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-7.5095F, 4.9952F, -0.2187F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-9.7127F, -1.8627F, 0.3718F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-7.5095F, 4.9952F, -0.2187F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(23.7256F, -9.869F, -5.5144F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7917F, AnimationHelper.createRotationalVector(23.7256F, -9.869F, -5.5144F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2083F, AnimationHelper.createRotationalVector(-5.85F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(24.9011F, -2.6841F, 4.22F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(28.3882F, -3.2722F, -13.7069F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.2083F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5833F, AnimationHelper.createRotationalVector(23.7348F, 13.7408F, -3.2204F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(1.1069F, -12.4517F, -5.1208F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(2.7471F, -12.1991F, -12.7936F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createRotationalVector(3.7757F, -44.6505F, -14.8681F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createRotationalVector(3.7757F, -44.6505F, -14.8681F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, -21.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, -14.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-51.02F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lefthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftfinger1", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createRotationalVector(15.0F, 0.0F, -25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(15.0F, 0.0F, -25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftfinger2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, -27.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, -27.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createRotationalVector(42.2835F, 10.8512F, 30.5305F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftfinger3", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createRotationalVector(56.7259F, -18.5362F, 13.8987F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(1.1069F, 12.4517F, 5.1208F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(2.7471F, 12.1991F, 12.7936F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createRotationalVector(3.4887F, 39.6605F, 14.4409F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createRotationalVector(3.4887F, 39.6605F, 14.4409F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, -21.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, -17.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-53.8F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("righthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightfinger1", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightfinger2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createRotationalVector(48.4599F, -15.026F, -22.5679F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightfinger3", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createRotationalVector(40.7307F, 13.3598F, -15.0213F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-90.0F, 22.5F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-60.0F, -6.25F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-90.0F, -12.5F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();


	public static final Animation FLARE_SHOT = Animation.Builder.create(3.0F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lowerbody", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 4.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("upperbody", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(28.627F, 15.4697F, 8.2834F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(28.627F, 15.4697F, 8.2834F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7917F, AnimationHelper.createRotationalVector(28.627F, 15.4697F, 8.2834F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(27.5358F, 7.0841F, 2.7225F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(28.627F, 15.4697F, 8.2834F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7083F, AnimationHelper.createRotationalVector(-23.2433F, -10.7008F, -11.6839F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(-23.2433F, -10.7008F, -11.6839F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(27.4106F, -2.3064F, 4.4375F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-89.333F, -14.5264F, -16.6989F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-89.333F, -14.5264F, -16.6989F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-96.8523F, -4.527F, -16.5828F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(-89.333F, -14.5264F, -16.6989F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 9.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-7.4864F, -0.6469F, -2.4149F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-7.4864F, -0.6469F, -2.4149F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(-7.4864F, -0.6469F, -2.4149F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lefthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("lefthand", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_hand_blast_4", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createRotationalVector(36.9776F, -5.2483F, 36.3608F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_hand_blast_3", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(25.0F, 0.0F, -25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(25.0F, 0.0F, -25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createRotationalVector(36.8383F, 7.5713F, -34.9753F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftfinger1", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-46.7368F, -24.3683F, 43.7546F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-46.7368F, -24.3683F, 43.7546F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_hand_blast_2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, -25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, -25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-36.9776F, -5.2483F, -36.3608F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftfinger2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(34.2368F, 24.3683F, 43.7546F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(34.2368F, 24.3683F, 43.7546F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_hand_blast_1", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 25.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-36.9776F, 5.2483F, 36.3608F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftfinger3", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(30.0F, 0.0F, -62.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(30.0F, 0.0F, -62.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_cannon", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(0.0F, -14.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_cannon", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.125F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.25F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_core", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(1440.0F, 1440.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_core", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("l_core", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createScalingVector(3.0F, 3.0F, 3.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7917F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(15.2207F, 9.6559F, 15.113F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createRotationalVector(21.2006F, 23.222F, 30.5946F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(21.2006F, 23.222F, 30.5946F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightarm2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-0.5373F, 16.404F, 23.0456F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("righthand", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-23.1277F, 19.6834F, -3.6171F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(-23.1277F, 19.6834F, -3.6171F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightfinger1", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7917F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 30.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightfinger2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7917F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 30.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightfinger3", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -30.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(15.5041F, 14.4775F, 3.9671F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createRotationalVector(15.5041F, 14.4775F, 3.9671F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("rightleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 9.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 9.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("leftleg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 6.0F, -17.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -17.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -17.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-0.04F, -0.38F, -0.07F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(-0.04F, -0.38F, -0.07F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.0833F, AnimationHelper.createTranslationalVector(-0.04F, -0.33F, 1.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.96F, -0.28F, 0.83F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(-0.24F, -0.23F, 0.66F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.2083F, AnimationHelper.createTranslationalVector(-0.19F, -0.18F, -0.51F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.25F, AnimationHelper.createTranslationalVector(-0.14F, -0.14F, 0.66F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.2917F, AnimationHelper.createTranslationalVector(0.9F, -0.1F, 0.33F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(-0.05F, -0.05F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(1.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(-0.07F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(-0.06F, 0.0F, 1.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.5F, AnimationHelper.createTranslationalVector(-0.06F, 0.0F, -0.08F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.5417F, AnimationHelper.createTranslationalVector(-1.05F, 0.0F, -0.07F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.5833F, AnimationHelper.createTranslationalVector(-0.95F, 0.0F, -1.06F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.625F, AnimationHelper.createTranslationalVector(-0.85F, 0.0F, 0.05F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.24F, 0.0F, 0.04F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(-1.79F, 0.0F, 0.04F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(-1.62F, -0.07F, 11.02F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createTranslationalVector(-1.79F, 0.0F, 0.04F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createTranslationalVector(-0.04F, -0.38F, -0.07F), Transformation.Interpolations.CUBIC)
			))
			.build();

}