package com.github.l_ender.cataclysm.client.animation;// Save this class in your mod and generate all required imports

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

/**
 * Made with Blockbench 4.9.4
 * Exported for Minecraft version 1.19 or later with Mojang mappings
 * @author kor
 */
public class Maledictus_Halberd_Animation {
	public static final Animation DASH1 = Animation.Builder.create(3.2083F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -80.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, -80.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(39.49F, -30.0211F, -3.3502F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(39.49F, -30.0211F, -3.3502F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.3333F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createTranslationalVector(0.0F, -9.8F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createTranslationalVector(0.0F, -8.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-102.5449F, 27.0444F, -5.6387F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-73.4256F, 29.0273F, 8.6748F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(127.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(77.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-122.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-122.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-130.8445F, -24.4895F, 19.3396F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-73.4256F, -29.0273F, -8.6748F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(115.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(115.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(115.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(77.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(36.3391F, -24.9417F, -17.2344F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(36.3391F, -24.9417F, -17.2344F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-12.6652F, -27.0478F, 11.2431F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-12.6652F, -27.0478F, 11.2431F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-14.0876F, 4.6917F, 38.977F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-1.9758F, -15.8383F, -13.6272F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-5.04F, -24.919F, -2.6789F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-1.5215F, -25.349F, -10.951F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5833F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-54.1335F, -21.9426F, 19.0958F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-54.1335F, -21.9426F, 19.0958F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-35.9757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-35.9757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-35.9757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(7.4728F, 10.5827F, 45.1845F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(7.4728F, 10.5827F, 45.1845F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(15.2544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(15.2544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(7.7544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-12.6338F, 10.3405F, 100.1577F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.9583F, AnimationHelper.createRotationalVector(-12.6338F, 10.3405F, 100.1577F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-51.7705F, 18.3606F, -64.0712F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-51.7705F, 18.3606F, -64.0712F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5417F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-6.3612F, -35.6298F, 25.7174F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(6.7567F, -1.8724F, 18.7358F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-6.9288F, -31.0735F, 37.9939F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(0.0F, 5.76F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, -27.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, -6.82F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -32.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 36.17F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, -43.81F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(0.0F, 30.95F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, -45.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 9.7F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -37.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 6.35F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 30.52F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(0.0F, 4.6F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 27.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, -3.95F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 40.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, -31.45F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 55.42F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(0.0F, -20.9F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 45.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, -2.79F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, -90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(0.0F, -90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-43.1606F, 0.9033F, -0.9972F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-43.1606F, 0.9033F, -0.9972F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.49F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.49F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("berserker", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("berserker", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("legs", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation DASH1_NO_BACK_STEP = Animation.Builder.create(2.7083F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -80.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, -80.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(39.49F, -30.0211F, -3.3502F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(39.49F, -30.0211F, -3.3502F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(39.49F, -30.0211F, -3.3502F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-122.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-122.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-122.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(115.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(115.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(115.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(36.3391F, -24.9417F, -17.2344F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(36.3391F, -24.9417F, -17.2344F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-12.6652F, -27.0478F, 11.2431F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-12.6652F, -27.0478F, 11.2431F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-12.6652F, -27.0478F, 11.2431F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-4.1648F, -12.296F, 7.3275F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-14.0876F, 4.6917F, 38.977F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-1.9758F, -15.8383F, -13.6272F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-5.04F, -24.919F, -2.6789F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-1.5215F, -25.349F, -10.951F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-1.4259F, -15.3523F, -11.225F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-1.3184F, 9.9136F, -7.6144F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-54.1335F, -21.9426F, 19.0958F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-54.1335F, -21.9426F, 19.0958F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-35.9757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-38.4319F, -32.4734F, 29.6409F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-8.4757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(7.4728F, 10.5827F, 45.1845F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(7.4728F, 10.5827F, 45.1845F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(15.2544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(15.2544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(15.2544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(10.2544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(2.6623F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-51.7705F, 18.3606F, -64.0712F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-51.7705F, 18.3606F, -64.0712F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(2.5602F, -5.8701F, 3.9499F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-6.3612F, -35.6298F, 25.7174F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(6.7567F, -1.8724F, 18.7358F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-6.9288F, -31.0735F, 37.9939F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(0.0F, 1.17F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -32.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 36.17F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, -43.81F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2917F, AnimationHelper.createRotationalVector(0.0F, -33.44F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -37.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 6.35F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 30.52F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(0.0F, -5.06F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 40.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, -31.45F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 55.42F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 29.64F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, -90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-43.1606F, 0.9033F, -0.9972F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-43.1606F, 0.9033F, -0.9972F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(0.0F, 180.83F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.49F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.49F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createTranslationalVector(1.3391F, -0.1988F, -3.0254F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("berserker", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("berserker", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(-0.0354F, -0.271F, -0.4149F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createTranslationalVector(0.0158F, -0.9956F, 0.1869F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("legs", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation DASH2 = Animation.Builder.create(2.75F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -80.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, -80.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(39.49F, -30.0211F, -3.3502F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(39.49F, -30.0211F, -3.3502F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -9.8F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2917F, AnimationHelper.createTranslationalVector(0.0F, -8.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-102.5449F, 27.0444F, -5.6387F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(-73.4256F, 29.0273F, 8.6748F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(127.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(77.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-122.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-122.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-130.8445F, -24.4895F, 19.3396F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(-73.4256F, -29.0273F, -8.6748F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(115.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(115.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(115.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(77.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(36.3391F, -24.9417F, -17.2344F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(36.3391F, -24.9417F, -17.2344F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-12.6652F, -27.0478F, 11.2431F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-12.6652F, -27.0478F, 11.2431F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-14.0876F, 4.6917F, 38.977F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-1.9758F, -15.8383F, -13.6272F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-5.04F, -24.919F, -2.6789F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-1.5215F, -25.349F, -10.951F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-54.1335F, -21.9426F, 19.0958F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-54.1335F, -21.9426F, 19.0958F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-35.9757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-35.9757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-35.9757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(-35.9757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(7.4728F, 10.5827F, 45.1845F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(7.4728F, 10.5827F, 45.1845F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(15.2544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(15.2544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(7.7544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(-12.6338F, 10.3405F, 100.1577F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(-12.6338F, 10.3405F, 100.1577F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-51.7705F, 18.3606F, -64.0712F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-51.7705F, 18.3606F, -64.0712F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -37.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -1.15F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -34.13F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 5.76F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, -27.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4167F, AnimationHelper.createRotationalVector(0.0F, -6.82F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -32.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 36.17F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -43.81F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 30.95F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(0.0F, -45.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4167F, AnimationHelper.createRotationalVector(0.0F, 9.7F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -37.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 6.35F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 30.52F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 4.6F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 27.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4167F, AnimationHelper.createRotationalVector(0.0F, -3.95F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 40.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -31.45F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 55.42F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, -20.9F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(0.0F, 45.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4167F, AnimationHelper.createRotationalVector(0.0F, -2.79F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, -90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, -90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-43.1606F, 0.9033F, -0.9972F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-43.1606F, 0.9033F, -0.9972F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.2917F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.49F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.49F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation DASH2_NO_BACK_STEP = Animation.Builder.create(2.0F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -80.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, -80.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(39.49F, -30.0211F, -3.3502F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(39.49F, -30.0211F, -3.3502F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-122.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-122.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(115.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(115.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(36.3391F, -24.9417F, -17.2344F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(36.3391F, -24.9417F, -17.2344F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-12.6652F, -27.0478F, 11.2431F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-12.6652F, -27.0478F, 11.2431F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-4.1648F, -12.296F, 7.3275F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-14.0876F, 4.6917F, 38.977F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-1.9758F, -15.8383F, -13.6272F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-5.04F, -24.919F, -2.6789F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-1.4259F, -15.3523F, -11.225F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-1.3184F, 9.9136F, -7.6144F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-54.1335F, -21.9426F, 19.0958F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-54.1335F, -21.9426F, 19.0958F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-35.9757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-38.4319F, -32.4734F, 29.6409F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-8.4757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(7.4728F, 10.5827F, 45.1845F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(7.4728F, 10.5827F, 45.1845F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(15.2544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(15.2544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(10.2544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(2.6623F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-51.7705F, 18.3606F, -64.0712F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-51.7705F, 18.3606F, -64.0712F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(2.5602F, -5.8701F, 3.9499F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -37.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -1.15F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -34.13F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 1.17F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -32.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 36.17F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -43.81F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, -33.44F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -37.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 6.35F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 30.52F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, -5.06F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 40.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -31.45F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 55.42F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createRotationalVector(0.0F, 29.64F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, -90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-43.1606F, 0.9033F, -0.9972F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-43.1606F, 0.9033F, -0.9972F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 180.83F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.49F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.49F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createTranslationalVector(1.3391F, -0.1988F, -3.0254F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("berserker", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createTranslationalVector(-0.0354F, -0.271F, -0.4149F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0158F, -0.9956F, 0.1869F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();


	public static final Animation DASH3 = Animation.Builder.create(2.875F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -80.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, -80.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(39.49F, -30.0211F, -3.3502F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(39.49F, -30.0211F, -3.3502F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(39.49F, -30.0211F, -3.3502F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createTranslationalVector(0.0F, -9.8F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4167F, AnimationHelper.createTranslationalVector(0.0F, -8.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-102.5449F, 27.0444F, -5.6387F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(-73.4256F, 29.0273F, 8.6748F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(127.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(77.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-122.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-122.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-130.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-130.8445F, -24.4895F, 19.3396F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(-73.4256F, -29.0273F, -8.6748F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(115.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(115.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(112.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(115.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(77.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(36.3391F, -24.9417F, -17.2344F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(36.3391F, -24.9417F, -17.2344F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-12.6652F, -27.0478F, 11.2431F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-12.6652F, -27.0478F, 11.2431F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-12.6652F, -27.0478F, 11.2431F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-14.0876F, 4.6917F, 38.977F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-1.9758F, -15.8383F, -13.6272F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-5.04F, -24.919F, -2.6789F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-1.5215F, -25.349F, -10.951F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-1.5215F, -25.349F, -10.951F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-54.1335F, -21.9426F, 19.0958F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-54.1335F, -21.9426F, 19.0958F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-35.9757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-35.9757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-35.9757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-35.9757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(-35.9757F, 4.8845F, 8.8604F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(7.4728F, 10.5827F, 45.1845F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(7.4728F, 10.5827F, 45.1845F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(15.2544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(15.2544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(15.2544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(7.7544F, 6.1199F, 102.8671F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(-12.6338F, 10.3405F, 100.1577F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(-12.6338F, 10.3405F, 100.1577F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(-19.8377F, 9.1247F, 9.1711F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-51.7705F, 18.3606F, -64.0712F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-51.7705F, 18.3606F, -64.0712F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(-50.564F, 4.3775F, -45.2867F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-27.5F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-5.1732F, -36.2224F, 20.6125F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(8.5966F, -2.4511F, 24.0319F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-6.5468F, -31.4117F, 35.4876F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 5.76F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createRotationalVector(0.0F, -27.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5417F, AnimationHelper.createRotationalVector(0.0F, -6.82F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -32.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 36.17F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -43.81F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 30.95F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(0.0F, -45.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5417F, AnimationHelper.createRotationalVector(0.0F, 9.7F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -37.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 6.35F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 30.52F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 4.6F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.375F, AnimationHelper.createRotationalVector(0.0F, 27.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5417F, AnimationHelper.createRotationalVector(0.0F, -3.95F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 40.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -31.45F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 55.42F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, -20.9F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(0.0F, 45.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5417F, AnimationHelper.createRotationalVector(0.0F, -2.79F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, -90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, -90.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-43.1606F, 0.9033F, -0.9972F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-43.1606F, 0.9033F, -0.9972F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(-19.2299F, 17.5391F, -19.3617F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.9583F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.4167F, AnimationHelper.createRotationalVector(0.0F, 180.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.49F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.49F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.4167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -14.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("berserker", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("berserker", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("legs", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation HALBERD_SLASH = Animation.Builder.create(2.5F)
			.addBoneAnimation("berserker", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -17.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-2.5F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-0.2031F, -22.4751F, 1.1431F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(-0.1942F, -14.9751F, 1.1157F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-0.1892F, -7.4752F, 1.0901F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-0.1878F, -2.4752F, 1.0736F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("berserker", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createTranslationalVector(-0.9021F, -0.61F, 2.8312F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(-0.0015F, -0.7992F, -0.0349F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(-0.1935F, -5.4184F, -4.4609F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createTranslationalVector(-0.1935F, -5.4184F, -4.4609F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(18.0087F, -0.7854F, 2.4273F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-121.9913F, -0.7854F, 2.4273F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-69.4913F, -0.7854F, 2.4273F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(-69.4913F, -0.7854F, 2.4273F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-70.8867F, 4.1698F, -3.9259F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-70.8867F, 4.1698F, -3.9259F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(110.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(1.3998F, 4.7632F, 1.1226F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(19.4681F, 6.4528F, -3.6176F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(27.3456F, 8.779F, -8.0599F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(22.3456F, 8.779F, -8.0599F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(22.3456F, 8.779F, -8.0599F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-5.0F, -12.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-6.0719F, 11.9253F, -7.2525F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-8.8853F, 28.639F, -14.9571F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-8.8853F, 28.639F, -14.9571F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-2.5F, -17.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-5.1307F, -24.9925F, 0.3599F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-7.3716F, 17.3602F, -3.2693F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(1.1472F, 35.381F, 9.3934F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(1.1472F, 35.381F, 9.3934F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-55.6013F, -60.9823F, 46.1946F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-71.3341F, -15.8054F, 23.2107F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(24.1296F, -33.553F, 52.0026F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(45.7246F, -14.2956F, 76.141F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(87.363F, -4.9813F, 97.0754F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(85.8666F, -3.1301F, 72.0988F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(98.3666F, -3.1301F, 72.0988F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-22.73F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(17.27F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(19.82F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(5.0F, -17.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-13.1017F, -19.9991F, -1.7761F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(17.5351F, 9.2901F, -8.3709F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(21.8338F, 7.1525F, -5.1062F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createTranslationalVector(6.2624F, -1.9924F, -19.8618F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(4.0684F, 3.3694F, -13.3011F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createTranslationalVector(-2.0762F, -7.2761F, -22.7807F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createTranslationalVector(-1.5808F, -9.3411F, -17.8466F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-7.2849F, -30.3706F, -22.3529F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-145.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-74.6133F, 39.775F, 6.5053F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-53.489F, 56.8548F, 9.8263F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(-71.9623F, 75.1981F, 26.5312F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-69.0163F, 77.425F, 29.6888F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-69.0163F, 77.425F, 29.6888F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(-2.9593F, -0.8626F, -2.5492F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-107.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0F, AnimationHelper.createRotationalVector(-36.4651F, -0.2253F, -2.77F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0417F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(13.5295F, 3.0414F, 37.3946F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(13.96F, 3.5333F, 44.8908F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(13.96F, 3.5333F, 44.8908F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.2901F, 24.3187F, 7.7901F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.9167F, AnimationHelper.createRotationalVector(5.2901F, 24.3187F, 7.7901F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.125F, AnimationHelper.createRotationalVector(4.2501F, -2.0753F, -0.5331F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 79.6F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 90.06F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 55.68F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -45.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, -46.38F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, -19.82F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, -18.25F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -27.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 22.21F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, -2.23F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 15.48F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 35.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 47.19F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 31.22F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 79.3F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation RADAGON = Animation.Builder.create(3.625F)
			.addBoneAnimation("berserker", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(3.8352F, -10.4866F, -5.2979F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(13.1437F, -21.6792F, -7.6773F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(13.1437F, -21.6792F, -7.6773F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, -17.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-2.5F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-0.2031F, -22.4751F, 1.1431F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(-0.1942F, -14.9751F, 1.1157F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-0.1892F, -7.4752F, 1.0901F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(-0.1878F, -2.4752F, 1.0736F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("berserker", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 17.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 17.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, -11.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -11.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(-0.9021F, -0.61F, 2.8312F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createTranslationalVector(-0.0015F, -0.7992F, -0.0349F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createTranslationalVector(-0.1935F, -5.4184F, -4.4609F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createTranslationalVector(-0.1935F, -5.4184F, -4.4609F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-100.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-100.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-117.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-112.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(18.0087F, -0.7854F, 2.4273F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-121.9913F, -0.7854F, 2.4273F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-69.4913F, -0.7854F, 2.4273F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(-69.4913F, -0.7854F, 2.4273F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-70.8867F, 4.1698F, -3.9259F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(-70.8867F, 4.1698F, -3.9259F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(105.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(105.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(107.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(105.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(110.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(1.3998F, 4.7632F, 1.1226F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(19.4681F, 6.4528F, -3.6176F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(27.3456F, 8.779F, -8.0599F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(22.3456F, 8.779F, -8.0599F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(22.3456F, 8.779F, -8.0599F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 32.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(17.5F, -22.5F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(17.2091F, -20.1138F, 0.8004F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-5.0F, -12.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-6.0719F, 11.9253F, -7.2525F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-8.8853F, 28.639F, -14.9571F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(-8.8853F, 28.639F, -14.9571F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(5.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(5.4937F, 24.9181F, 1.8836F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(6.2706F, 37.353F, 3.3773F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(17.5239F, 7.4904F, 0.2197F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(15.0239F, 7.4904F, 0.2197F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-2.5F, -17.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-5.1307F, -24.9925F, 0.3599F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-7.3716F, 17.3602F, -3.2693F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(1.1472F, 35.381F, 9.3934F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(1.1472F, 35.381F, 9.3934F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(41.2163F, -34.0195F, 83.9835F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(66.1826F, 4.0179F, 147.4347F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(78.6826F, 4.0179F, 147.4347F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(21.4312F, -24.5232F, 103.9893F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(26.4312F, -24.5232F, 103.9893F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-55.6013F, -60.9823F, 46.1946F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-71.3341F, -15.8054F, 23.2107F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(24.1296F, -33.553F, 52.0026F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(45.7246F, -14.2956F, 76.141F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(87.363F, -4.9813F, 97.0754F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(85.8666F, -3.1301F, 72.0988F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(98.3666F, -3.1301F, 72.0988F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-22.73F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(17.27F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(19.82F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("bow", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("bow", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_mace", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_mace", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(5.0F, -17.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-13.1017F, -19.9991F, -1.7761F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(17.5351F, 9.2901F, -8.3709F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createRotationalVector(21.8338F, 7.1525F, -5.1062F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createTranslationalVector(6.2624F, -1.9924F, -19.8618F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createTranslationalVector(4.0684F, 3.3694F, -13.3011F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createTranslationalVector(-2.0762F, -7.2761F, -22.7807F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.875F, AnimationHelper.createTranslationalVector(-1.5808F, -9.3411F, -17.8466F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(15.0F, 0.0F, -15.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-12.7721F, 27.3965F, -17.4226F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-29.7928F, 54.7448F, -20.9667F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-62.7721F, 27.3965F, -17.4226F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-7.2849F, -30.3706F, -22.3529F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-145.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(-74.6133F, 39.775F, 6.5053F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-53.489F, 56.8548F, 9.8263F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(-71.9623F, 75.1981F, 26.5312F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-69.0163F, 77.425F, 29.6888F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(-69.0163F, 77.425F, 29.6888F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createTranslationalVector(-2.9593F, -0.8626F, -2.5492F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(-60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(-107.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.125F, AnimationHelper.createRotationalVector(-36.4651F, -0.2253F, -2.77F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.1667F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(13.5295F, 3.0414F, 37.3946F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(13.96F, 3.5333F, 44.8908F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.2083F, AnimationHelper.createRotationalVector(13.96F, 3.5333F, 44.8908F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_mace", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_mace", new Transformation(Transformation.Targets.SCALE,
					new Keyframe(0.0F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-2.3246F, -14.9416F, -1.3378F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-0.1213F, -47.2626F, -5.4333F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(14.8787F, -47.2626F, -5.4333F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(29.5224F, 23.2083F, -6.1313F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(32.0224F, 23.2083F, -6.1313F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.2901F, 24.3187F, 7.7901F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0417F, AnimationHelper.createRotationalVector(5.2901F, 24.3187F, 7.7901F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(4.2501F, -2.0753F, -0.5331F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 49.79F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, -49.75F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -69.98F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-27.719F, 7.7033F, 10.3442F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-20.9476F, 23.4966F, -1.3266F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(0.0F, 79.6F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, 90.06F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.125F, AnimationHelper.createRotationalVector(0.0F, 55.68F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, -39.95F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, -74.68F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -85.8F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, -91.82F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, -57.39F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, -45.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(0.0F, -46.38F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, -19.82F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.125F, AnimationHelper.createRotationalVector(0.0F, -18.25F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, -53.54F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, -25.26F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 5.55F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(6.2161F, -24.6478F, -18.4273F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(3.1108F, -18.4505F, -10.1164F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, -27.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(0.0F, 22.21F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, -2.23F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.125F, AnimationHelper.createRotationalVector(0.0F, 15.48F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 26.24F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 64.94F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 71.15F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 29.69F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 63.79F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 35.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.2083F, AnimationHelper.createRotationalVector(0.0F, 47.19F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, 31.22F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.125F, AnimationHelper.createRotationalVector(0.0F, 79.3F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation FLYING_HALBERD_SMASH_1 = Animation.Builder.create(5.0F)
			.addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -5.6F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -6.6F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-41.946F, 12.4879F, 2.5606F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-49.446F, 12.4879F, 2.5606F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(-40.696F, 12.4879F, 2.5606F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-76.946F, 12.4879F, 2.5606F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-79.446F, 12.4879F, 2.5606F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-79.446F, 12.4879F, 2.5606F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(-100.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(-100.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(92.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(100.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(61.25F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(102.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(105.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(105.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(105.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(105.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-64.446F, -12.4879F, -2.5606F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-71.946F, -12.4879F, -2.5606F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(-120.973F, -11.244F, -1.2803F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-5.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-2.5F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-2.5F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(67.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(75.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(133.75F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 17.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0F, AnimationHelper.createRotationalVector(-5.7686F, 29.8742F, -2.8807F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-5.7686F, 29.8742F, -2.8807F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-5.7686F, 29.8742F, -2.8807F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(6.2706F, 37.353F, 3.3773F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(6.2706F, 37.353F, 3.3773F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createRotationalVector(8.2651F, 24.7716F, 13.483F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-12.7001F, 34.6292F, 11.5422F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-4.1835F, -20.2281F, 15.7069F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(68.6826F, 4.0179F, 147.4347F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(68.6826F, 4.0179F, 147.4347F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(78.6826F, 4.0179F, 147.4347F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(78.6826F, 4.0179F, 147.4347F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-94.53F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-56.28F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createRotationalVector(8.2651F, -24.7716F, -13.483F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-12.7001F, -34.6292F, -11.5422F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-4.1835F, 20.2281F, -15.7069F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(7.2999F, -34.6292F, -11.5422F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(8.8654F, -21.2558F, -13.2878F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(8.8654F, -21.2558F, -13.2878F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(-29.7928F, 54.7448F, -20.9667F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(-29.7928F, 54.7448F, -20.9667F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-94.53F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(-60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(-60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5F, AnimationHelper.createRotationalVector(47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-18.0468F, -44.5119F, 7.4366F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-18.0468F, -44.5119F, 7.4366F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(14.8787F, -47.2626F, -5.4333F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(14.8787F, -47.2626F, -5.4333F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-1.352F, 27.4727F, -3.2656F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-1.1338F, 14.9756F, -2.9187F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-1.1338F, 14.9756F, -2.9187F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-6.8871F, -35.7432F, -9.0988F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(-3.2748F, -12.669F, -6.3345F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-3.3117F, -10.1761F, -6.5267F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-3.3117F, -10.1761F, -6.5267F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, -69.98F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(0.0F, -69.98F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 25.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createRotationalVector(0.0F, -142.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, -85.8F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(0.0F, -85.8F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-1.352F, -27.4727F, 3.2656F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-1.1338F, -14.9756F, 2.9187F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(-1.1338F, -14.9756F, 2.9187F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-6.8871F, 35.7432F, 9.0988F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.9167F, AnimationHelper.createRotationalVector(-6.7987F, -34.6137F, 12.1878F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-8.0516F, -39.5597F, 13.6395F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-8.0516F, -39.5597F, 13.6395F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, 5.55F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(0.0F, 5.55F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, -25.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(0.0F, 30.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 30.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.625F, AnimationHelper.createRotationalVector(0.0F, 145.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, 71.15F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(0.0F, 71.15F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("berserker", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(3.8352F, -10.4866F, -5.2979F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(3.8352F, -10.4866F, -5.2979F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("berserker", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, 32.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(0.0F, 32.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(12.04F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(12.04F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.0833F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.4583F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.625F, AnimationHelper.createRotationalVector(12.04F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(4.5F, AnimationHelper.createRotationalVector(12.04F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(5.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

	public static final Animation FLYING_HALBERD_SMASH_2 = Animation.Builder.create(3.75F)
			.addBoneAnimation("berserker", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(3.8352F, -10.4866F, -5.2979F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(13.1437F, -21.6792F, -7.6773F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(13.1437F, -21.6792F, -7.6773F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(13.1437F, -21.6792F, -7.6773F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-15.584F, 2.8156F, -5.6136F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(13.1437F, -21.6792F, -7.6773F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(13.1437F, -21.6792F, -7.6773F), Transformation.Interpolations.LINEAR),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(13.1437F, -21.6792F, -7.6773F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("berserker", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createTranslationalVector(0.0F, -11.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -11.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, -9.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, -9.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createTranslationalVector(0.0F, -11.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, -11.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, -11.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-100.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(-117.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-112.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-102.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-63.9671F, 19.693F, -3.8027F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-117.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(-112.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(-112.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(105.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(107.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(105.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(95.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(50.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(107.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(105.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(105.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 32.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(17.5F, -22.5F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(17.2091F, -20.1138F, 0.8004F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(7.2091F, -20.1138F, 0.8004F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-1.219F, 44.5218F, 2.5331F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(17.5F, -22.5F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(17.2091F, -20.1138F, 0.8004F), Transformation.Interpolations.LINEAR),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(17.2091F, -20.1138F, 0.8004F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(6.2706F, 37.353F, 3.3773F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(17.5239F, 7.4904F, 0.2197F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(15.0239F, 7.4904F, 0.2197F), Transformation.Interpolations.LINEAR),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(2.5239F, 7.4904F, 0.2197F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(5.4937F, 24.9181F, 1.8836F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-2.5673F, 45.3497F, 4.4856F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(17.5239F, 7.4904F, 0.2197F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(15.0239F, 7.4904F, 0.2197F), Transformation.Interpolations.LINEAR),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(15.0239F, 7.4904F, 0.2197F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(3.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(78.6826F, 4.0179F, 147.4347F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(21.4312F, -24.5232F, 103.9893F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(26.4312F, -24.5232F, 103.9893F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(8.9312F, -24.5232F, 103.9893F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(3.824F, -37.068F, 104.115F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(66.1826F, 4.0179F, 147.4347F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(91.1826F, 4.0179F, 147.4347F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(21.4312F, -24.5232F, 103.9893F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(26.4312F, -24.5232F, 103.9893F), Transformation.Interpolations.LINEAR),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(26.4312F, -24.5232F, 103.9893F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.04F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("halberd", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-29.7928F, 54.7448F, -20.9667F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(-62.7721F, 27.3965F, -17.4226F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-41.5423F, 37.0394F, -14.4998F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-12.7721F, 27.3965F, -17.4226F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-30.8855F, 57.0501F, -22.4261F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-62.7721F, 27.3965F, -17.4226F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(3.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.04F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(-60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(-72.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(14.8787F, -47.2626F, -5.4333F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(29.5224F, 23.2083F, -6.1313F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5F, AnimationHelper.createRotationalVector(32.0224F, 23.2083F, -6.1313F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.1667F, AnimationHelper.createRotationalVector(0.9808F, 24.5968F, 3.2397F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-0.1213F, -47.2626F, -5.4333F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(14.8787F, -47.2626F, -5.4333F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(29.5224F, 23.2083F, -6.1313F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.25F, AnimationHelper.createRotationalVector(32.0224F, 23.2083F, -6.1313F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0F, AnimationHelper.createRotationalVector(32.0224F, 23.2083F, -6.1313F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -69.98F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(-27.719F, 7.7033F, 10.3442F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-20.9476F, 23.4966F, -1.3266F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createRotationalVector(0.0F, -49.75F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, -69.98F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-27.719F, 7.7033F, 10.3442F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.3333F, AnimationHelper.createRotationalVector(-20.9476F, 23.4966F, -1.3266F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0833F, AnimationHelper.createRotationalVector(-20.9476F, 23.4966F, -1.3266F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("left_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -85.8F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(0.0F, -91.82F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, -57.39F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createRotationalVector(0.0F, -74.68F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, -85.8F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, -91.82F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.3333F, AnimationHelper.createRotationalVector(0.0F, -57.39F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0833F, AnimationHelper.createRotationalVector(0.0F, -57.39F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 5.55F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(6.2161F, -24.6478F, -18.4273F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createRotationalVector(3.1108F, -18.4505F, -10.1164F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createRotationalVector(0.0F, -25.26F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 5.55F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(6.2161F, -24.6478F, -18.4273F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.3333F, AnimationHelper.createRotationalVector(3.1108F, -18.4505F, -10.1164F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0833F, AnimationHelper.createRotationalVector(3.1108F, -18.4505F, -10.1164F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.addBoneAnimation("right_wing2", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 71.15F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.0833F, AnimationHelper.createRotationalVector(0.0F, 29.69F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 63.79F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.5417F, AnimationHelper.createRotationalVector(0.0F, 64.94F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 71.15F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 29.69F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(2.3333F, AnimationHelper.createRotationalVector(0.0F, 63.79F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.0833F, AnimationHelper.createRotationalVector(0.0F, 63.79F, 0.0F), Transformation.Interpolations.CUBIC),
					new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
			))
			.build();

}
