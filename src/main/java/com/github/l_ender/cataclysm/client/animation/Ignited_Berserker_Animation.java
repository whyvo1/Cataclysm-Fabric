package com.github.l_ender.cataclysm.client.animation;// Save this class in your mod and generate all required imports

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


@Environment(EnvType.CLIENT)
public class Ignited_Berserker_Animation {
	public static final Animation IDLE = Animation.Builder.create(1.5F).looping()
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.625F, AnimationHelper.createRotationalVector(-1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.76F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.4167F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(-3.87F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, -0.3F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, 0.71F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9583F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.build();

	public static final Animation WALK = Animation.Builder.create(1.5F).looping()
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.625F, AnimationHelper.createRotationalVector(-16.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.76F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.4167F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(-3.87F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, -0.3F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, 0.71F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9583F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("mid_root", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("mid_root", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 2.0F), Transformation.Interpolations.LINEAR)
		))
		.build();

	public static final Animation X_SLASH = Animation.Builder.create(2.5F)
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(-8.95F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-4.35F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(47.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(47.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(50.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.625F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 3.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 3.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, -4.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -6.0F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 4.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 7.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(9.9265F, -0.1125F, 0.589F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-22.5735F, -0.1125F, 0.589F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(-25.0735F, -0.1125F, 0.589F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(9.9265F, -0.1125F, 0.589F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(17.4265F, -0.1125F, 0.589F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.625F, AnimationHelper.createRotationalVector(22.4265F, -0.1125F, 0.589F), Transformation.Interpolations.LINEAR),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(12.4265F, -0.1125F, 0.589F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createRotationalVector(47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("edges", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_f_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(-68.6451F, 5.862F, -110.733F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(-72.7845F, -5.9493F, -116.558F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-75.8627F, -25.2264F, -122.7332F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-31.7864F, 13.4682F, -56.5656F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(74.4126F, -13.8007F, 44.1735F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(67.22F, -71.7923F, 60.1278F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(53.057F, -17.6319F, 65.4305F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(40.532F, -7.9557F, 56.0506F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(40.0221F, -4.6774F, 50.3455F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.625F, AnimationHelper.createRotationalVector(61.8319F, -77.2792F, 103.2867F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(78.7897F, -52.8222F, 97.7098F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_f_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createTranslationalVector(-4.0F, 20.0F, 6.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(-3.0F, 20.0F, 6.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(-3.0F, 20.0F, 6.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(1.93F, 17.63F, 3.26F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createTranslationalVector(4.0F, 1.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(4.0F, 9.0F, -11.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.25F, AnimationHelper.createTranslationalVector(4.0F, 16.0F, -8.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(3.0F, 17.0F, -11.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.625F, AnimationHelper.createTranslationalVector(0.0F, 15.0F, 4.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 29.0F, 10.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_f_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(-68.6451F, -5.862F, 110.733F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(-72.7845F, 5.9493F, 116.558F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-75.8627F, 25.2264F, 122.7332F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-31.7864F, -13.4682F, 56.5656F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(74.4126F, 13.8007F, -44.1735F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(67.22F, 71.7923F, -60.1278F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(53.057F, 17.6319F, -65.4305F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(40.532F, 7.9557F, -56.0506F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(40.0221F, 4.6774F, -50.3455F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.625F, AnimationHelper.createRotationalVector(61.8319F, 77.2792F, -103.2867F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(78.7897F, 52.8222F, -97.7098F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_f_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createTranslationalVector(4.0F, 20.0F, 6.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(3.0F, 20.0F, 6.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(3.0F, 20.0F, 6.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(-1.93F, 17.63F, 3.26F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createTranslationalVector(-4.0F, 1.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(-4.0F, 9.0F, -11.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.25F, AnimationHelper.createTranslationalVector(-4.0F, 16.0F, -8.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(-3.0F, 17.0F, -11.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.625F, AnimationHelper.createTranslationalVector(0.0F, 15.0F, 4.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 29.0F, 10.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_b_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-65.0067F, 22.5389F, 13.2179F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(-97.5067F, 22.5389F, 13.2179F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-66.962F, 39.9019F, 10.9575F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(-109.462F, 39.9019F, 10.9575F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(-140.7494F, 75.6805F, -25.5957F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createRotationalVector(-59.0601F, -12.8627F, -38.8675F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createRotationalVector(2.6471F, -29.6601F, -93.236F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7083F, AnimationHelper.createRotationalVector(58.7446F, 9.089F, -154.1614F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(56.6328F, 64.6631F, -187.5421F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-67.4197F, 77.8257F, -330.7041F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(-82.442F, 72.7817F, -352.1569F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-95.4399F, 35.8374F, -364.7647F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.1654F, 0.0F, -360.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_b_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 6.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(1.0F, 0.0F, 6.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(1.0F, 8.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(5.0F, -4.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createTranslationalVector(1.0F, 5.0F, -23.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(2.48F, 2.0F, -26.41F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createTranslationalVector(6.0F, 2.0F, -30.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createTranslationalVector(34.16F, 2.13F, -2.1F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.16F, 0.13F, -0.1F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_b_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-65.0067F, -22.5389F, -13.2179F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(-97.5067F, -22.5389F, -13.2179F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-66.962F, -39.9019F, -10.9575F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(-109.462F, -39.9019F, -10.9575F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(-140.7494F, -75.6805F, 25.5957F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createRotationalVector(-59.0601F, 12.8627F, 38.8675F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createRotationalVector(2.6471F, 29.6601F, 93.236F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7083F, AnimationHelper.createRotationalVector(58.7446F, -9.089F, 154.1614F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(56.6328F, -64.6631F, 187.5421F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-67.4197F, -77.8257F, 330.7041F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(-82.442F, -72.7817F, 352.1569F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-95.4399F, -35.8374F, 364.7647F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.1654F, 0.0F, 360.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_b_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 6.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(-1.0F, 0.0F, 6.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(-1.0F, 8.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(-5.0F, -4.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createTranslationalVector(-1.0F, 5.0F, -23.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(-2.48F, 2.0F, -26.41F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createTranslationalVector(-6.0F, 2.0F, -30.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createTranslationalVector(-34.16F, 2.13F, -2.1F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createTranslationalVector(-0.16F, 0.13F, -0.1F), Transformation.Interpolations.CUBIC)
		))
		.build();

	public static final Animation MIXER_START = Animation.Builder.create(1.5F)
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.625F, AnimationHelper.createRotationalVector(-1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.76F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.4167F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(-3.87F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(-40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, -0.3F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, 0.71F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9583F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(12.59F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("edges", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 90.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("edges", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("mid_root", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_f_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_b_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_b_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_f_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.build();

	public static final Animation MIXER_IDLE = Animation.Builder.create(0.75F).looping()
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, 0.76F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.2083F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.2917F, AnimationHelper.createTranslationalVector(0.0F, -0.3F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.3F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.4583F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("edges", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 90.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 450.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("edges", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("mid_root", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_f_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_b_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_b_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_f_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.build();

	public static final Animation MIXER_FINISH = Animation.Builder.create(2.0F)
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(-1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.76F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(-3.87F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0833F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.71F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(0.0F, -0.3F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(12.59F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5417F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("edges", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 90.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 585.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("edges", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("mid_root", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_f_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_b_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_b_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_f_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.build();

	public static final Animation X_BLADE_SHOT = Animation.Builder.create(2.25F)
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-8.34F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(-18.45F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(-18.45F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(25.15F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.76F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5417F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(15.99F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(-73.87F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(0.0F, -0.3F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, 0.71F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(16.47F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.2917F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(82.01F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-14.28F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(-27.83F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(-27.83F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.3333F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(33.07F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 2.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 2.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("edges", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(19.76F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(38.3F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(-62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(-45.05F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_f_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_f_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(8.0F, 0.0F, 8.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createTranslationalVector(8.0F, 0.0F, 8.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(-17.0F, 0.0F, -17.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7917F, AnimationHelper.createTranslationalVector(-22.0F, 0.0F, -22.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createTranslationalVector(4.0F, 0.0F, 4.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.125F, AnimationHelper.createTranslationalVector(5.63F, 0.0F, 5.63F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_b_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_b_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(8.0F, 0.0F, -8.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createTranslationalVector(8.0F, 0.0F, -8.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(-17.0F, 0.0F, 17.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7917F, AnimationHelper.createTranslationalVector(-22.0F, 0.0F, 22.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createTranslationalVector(4.0F, 0.0F, -4.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.125F, AnimationHelper.createTranslationalVector(5.63F, 0.0F, -5.62F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_b_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(-90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_b_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(-8.0F, 0.0F, -8.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createTranslationalVector(-8.0F, 0.0F, -8.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(17.0F, 0.0F, 17.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7917F, AnimationHelper.createTranslationalVector(22.0F, 0.0F, 22.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createTranslationalVector(-4.0F, 0.0F, -4.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.125F, AnimationHelper.createTranslationalVector(-5.62F, 0.0F, -5.62F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_f_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_f_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(-8.0F, 0.0F, 8.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createTranslationalVector(-8.0F, 0.0F, 8.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(17.0F, 0.0F, -17.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7917F, AnimationHelper.createTranslationalVector(22.0F, 0.0F, -22.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createTranslationalVector(-4.0F, 0.0F, 4.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.125F, AnimationHelper.createTranslationalVector(-5.62F, 0.0F, 5.63F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.build();

	public static final Animation SWORD_DANCE_LEFT = Animation.Builder.create(2.5F)
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(-0.7298F, 17.4987F, -0.2194F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-0.7298F, 17.4987F, -0.2194F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createRotationalVector(-0.3649F, -8.7503F, 0.0013F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.76F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5417F, AnimationHelper.createRotationalVector(8.9675F, -15.8784F, -14.5232F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7917F, AnimationHelper.createRotationalVector(8.9675F, -15.8784F, -14.5232F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(-3.87F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(0.0F, -0.3F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, 0.71F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createRotationalVector(32.18F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(3.4741F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.3333F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_f_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(-140.7494F, -75.6805F, 25.5957F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(-59.0601F, 12.8627F, 38.8675F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.1667F, AnimationHelper.createRotationalVector(2.6471F, 29.6601F, 93.236F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.2083F, AnimationHelper.createRotationalVector(58.7446F, -9.089F, 154.1614F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(56.6328F, -64.6631F, 187.5421F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-67.4197F, -77.8257F, 330.7041F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createRotationalVector(-82.442F, -72.7817F, 352.1569F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-95.4399F, -35.8374F, 364.7647F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.1654F, 0.0F, 360.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_f_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(-5.0F, -4.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createTranslationalVector(-1.0F, 5.0F, -23.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(-2.48F, 2.0F, -26.41F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createTranslationalVector(-6.0F, 2.0F, -30.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createTranslationalVector(-34.16F, 2.13F, -2.1F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createTranslationalVector(-0.16F, 0.13F, -0.1F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_b_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-140.7494F, 75.6805F, -25.5957F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(-59.0601F, -12.8627F, -38.8675F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9167F, AnimationHelper.createRotationalVector(2.6471F, -29.6601F, -93.236F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9583F, AnimationHelper.createRotationalVector(58.7446F, 9.089F, -154.1614F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(56.6328F, 64.6631F, -187.5421F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-67.4197F, 77.8257F, -330.7041F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(-82.442F, 72.7817F, -352.1569F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.2917F, AnimationHelper.createRotationalVector(-95.4399F, 35.8374F, -364.7647F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.1654F, 0.0F, -360.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_b_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(5.0F, -4.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createTranslationalVector(1.0F, 5.0F, -23.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(2.48F, 2.0F, -26.41F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(6.0F, 2.0F, -30.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createTranslationalVector(34.16F, 2.13F, -2.1F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(33.63F, 2.05F, -1.21F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.16F, 0.13F, -0.1F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_b_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(-140.7494F, -75.6805F, 25.5957F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createRotationalVector(-59.0601F, 12.8627F, 38.8675F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.4167F, AnimationHelper.createRotationalVector(2.6471F, 29.6601F, 93.236F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.4583F, AnimationHelper.createRotationalVector(58.7446F, -9.089F, 154.1614F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(56.6328F, -64.6631F, 187.5421F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5833F, AnimationHelper.createRotationalVector(-67.4197F, -77.8257F, 330.7041F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createRotationalVector(-82.442F, -72.7817F, 352.1569F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7917F, AnimationHelper.createRotationalVector(-95.4399F, -35.8374F, 364.7647F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.1654F, 0.0F, 360.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_b_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createTranslationalVector(-5.0F, -4.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createTranslationalVector(-1.0F, 5.0F, -23.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(-2.48F, 2.0F, -26.41F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(-6.0F, 2.0F, -30.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createTranslationalVector(-34.16F, 2.13F, -2.1F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createTranslationalVector(-0.16F, 0.13F, -0.1F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_f_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(-140.7494F, 75.6805F, -25.5957F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.625F, AnimationHelper.createRotationalVector(-59.0601F, -12.8627F, -38.8675F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.6667F, AnimationHelper.createRotationalVector(2.6471F, -29.6601F, -93.236F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7083F, AnimationHelper.createRotationalVector(58.7446F, 9.089F, -154.1614F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(56.6328F, 64.6631F, -187.5421F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-67.4197F, 77.8257F, -330.7041F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(-82.442F, 72.7817F, -352.1569F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-95.4399F, 35.8374F, -364.7647F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.1654F, 0.0F, -360.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_f_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(5.0F, -4.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.625F, AnimationHelper.createTranslationalVector(1.0F, 5.0F, -23.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(2.48F, 2.0F, -26.41F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(6.0F, 2.0F, -30.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createTranslationalVector(34.16F, 2.13F, -2.1F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(30.79F, 1.83F, -0.01F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createTranslationalVector(24.33F, 1.46F, 0.12F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(22.29F, 1.35F, 0.11F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.16F, 0.13F, -0.1F), Transformation.Interpolations.CUBIC)
		))
		.build();

	public static final Animation SWORD_DANCE_RIGHT = Animation.Builder.create(2.75F)
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(-0.7298F, 17.4987F, -0.2194F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-0.7298F, 17.4987F, -0.2194F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createRotationalVector(-0.3649F, -8.7503F, 0.0013F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.76F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5417F, AnimationHelper.createRotationalVector(8.9675F, -15.8784F, -14.5232F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7917F, AnimationHelper.createRotationalVector(8.9675F, -15.8784F, -14.5232F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(-3.87F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(0.0F, -0.3F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, 0.71F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createRotationalVector(32.18F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(3.4741F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.3333F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("rod", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_f_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(-140.7494F, -75.6805F, 25.5957F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createRotationalVector(-59.0601F, 12.8627F, 38.8675F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.4167F, AnimationHelper.createRotationalVector(2.6471F, 29.6601F, 93.236F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.4583F, AnimationHelper.createRotationalVector(58.7446F, -9.089F, 154.1614F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(56.6328F, -64.6631F, 187.5421F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5833F, AnimationHelper.createRotationalVector(-67.4197F, -77.8257F, 330.7041F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createRotationalVector(-82.442F, -72.7817F, 352.1569F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7917F, AnimationHelper.createRotationalVector(-95.4399F, -35.8374F, 364.7647F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.1654F, 0.0F, 360.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_f_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createTranslationalVector(-5.0F, -4.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createTranslationalVector(-1.0F, 5.0F, -23.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(-2.48F, 2.0F, -26.41F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(-6.0F, 2.0F, -30.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createTranslationalVector(-34.16F, 2.13F, -2.1F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createTranslationalVector(-0.16F, 0.13F, -0.1F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_b_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(-140.7494F, 75.6805F, -25.5957F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(-59.0601F, -12.8627F, -38.8675F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.1667F, AnimationHelper.createRotationalVector(2.6471F, -29.6601F, -93.236F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.2083F, AnimationHelper.createRotationalVector(58.7446F, 9.089F, -154.1614F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(56.6328F, 64.6631F, -187.5421F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-67.4197F, 77.8257F, -330.7041F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createRotationalVector(-82.442F, 72.7817F, -352.1569F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-95.4399F, 35.8374F, -364.7647F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.1654F, 0.0F, -360.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("right_b_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(5.0F, -4.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createTranslationalVector(1.0F, 5.0F, -23.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(2.48F, 2.0F, -26.41F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createTranslationalVector(6.0F, 2.0F, -30.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.375F, AnimationHelper.createTranslationalVector(34.16F, 2.13F, -2.1F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.16F, 0.13F, -0.1F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_b_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(-140.7494F, -75.6805F, 25.5957F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createRotationalVector(-59.0601F, 12.8627F, 38.8675F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createRotationalVector(2.6471F, 29.6601F, 93.236F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.7083F, AnimationHelper.createRotationalVector(58.7446F, -9.089F, 154.1614F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(56.6328F, -64.6631F, 187.5421F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-67.4197F, -77.8257F, 330.7041F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(-82.442F, -72.7817F, 352.1569F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-95.4399F, -35.8374F, 364.7647F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.1654F, 0.0F, 360.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_b_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(-5.0F, -4.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.625F, AnimationHelper.createTranslationalVector(-1.0F, 5.0F, -23.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(-2.48F, 2.0F, -26.41F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createTranslationalVector(-6.0F, 2.0F, -30.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createTranslationalVector(-34.16F, 2.13F, -2.1F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.75F, AnimationHelper.createTranslationalVector(-0.16F, 0.13F, -0.1F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_f_blade", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-140.7494F, 75.6805F, -25.5957F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(-59.0601F, -12.8627F, -38.8675F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9167F, AnimationHelper.createRotationalVector(2.6471F, -29.6601F, -93.236F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9583F, AnimationHelper.createRotationalVector(58.7446F, 9.089F, -154.1614F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(56.6328F, 64.6631F, -187.5421F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-67.4197F, 77.8257F, -330.7041F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(-82.442F, 72.7817F, -352.1569F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.2917F, AnimationHelper.createRotationalVector(-95.4399F, 35.8374F, -364.7647F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.1654F, 0.0F, -360.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("left_f_blade", new Transformation(Transformation.Targets.TRANSLATE, 
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(5.0F, -4.0F, -5.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createTranslationalVector(1.0F, 5.0F, -23.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(2.48F, 2.0F, -26.41F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(6.0F, 2.0F, -30.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createTranslationalVector(34.16F, 2.13F, -2.1F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.16F, 0.13F, -0.1F), Transformation.Interpolations.CUBIC)
		))
		.build();
}