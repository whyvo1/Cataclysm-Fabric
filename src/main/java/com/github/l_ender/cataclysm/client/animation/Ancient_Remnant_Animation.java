package com.github.l_ender.cataclysm.client.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class Ancient_Remnant_Animation {

        public static final Animation IDLE = Animation.Builder.create(3.0F).looping()
                .addBoneAnimation("right_finger", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_toe4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_toe5", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_toe6", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -1.4F, 5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 2.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0503F, 0.484F, 0.1111F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(1.63F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(2.94F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(6.67F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-15.28F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(30.06F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("legs", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-4.9727F, -0.0869F, -0.5112F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-4.9727F, 0.0869F, 0.5112F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation WALK = Animation.Builder.create(2.0F).looping()
                .addBoneAnimation("right_finger", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_toe4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.001F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_toe5", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.001F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_toe6", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.001F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_toe4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_toe5", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_toe6", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-0.16F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createTranslationalVector(0.0F, -3.69F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 2.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(9.9952F, -4.9952F, 0.0002F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(8.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(9.9905F, 4.9952F, -0.2187F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(8.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(9.9905F, -4.9952F, 0.2187F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-5.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-2.5F, -0.625F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-5.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-2.3438F, -0.2734F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-5.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(5.0F, -0.625F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.5845F, 7.3854F, 1.3096F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(12.5845F, -7.3854F, -1.3096F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(17.5845F, -0.9232F, -0.1637F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(12.5845F, 7.3854F, 1.3096F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(20.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(25.0F, -0.9375F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(20.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(24.6875F, -0.4102F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(20.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(7.83F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(7.83F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-3.26F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(-3.26F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("legs", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, -3.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(9.84F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(-8.59F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, -3.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, -3.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(8.59F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();
        
        public static final Animation RIGHT_BITE = Animation.Builder.create(3.5F)
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-2.8488F, 7.5937F, 2.1476F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-3.1797F, 8.5918F, 4.0965F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2917F, AnimationHelper.createRotationalVector(-6.1821F, 8.4515F, 5.0863F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-2.8267F, 2.5999F, 2.3961F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(42.2954F, -45.7259F, -24.6513F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(53.3793F, -54.174F, -39.0604F), Transformation.Interpolations.LINEAR),
                        new Keyframe(3.2083F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2917F, AnimationHelper.createTranslationalVector(0.0F, 1.02F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.37F, 3.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(-8.0F, 4.0F, 29.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(-8.0F, -4.0F, 29.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 31.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(3.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-17.5F, 17.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-22.5F, 17.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-21.1565F, 9.2346F, 5.7915F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(-20.9575F, 7.1511F, 7.1876F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, -1.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(5.0767F, -9.9616F, -0.8804F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(12.9096F, -22.4097F, -2.0675F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(13.1563F, -24.8453F, -2.6829F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(12.8472F, -12.0675F, -3.284F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(25.1253F, -31.2646F, -9.363F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(25.9295F, -33.4182F, -10.866F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(17.0563F, -1.253F, 1.5856F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(22.6344F, -15.7579F, -2.29F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(29.3988F, -30.1836F, -6.7735F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(30.0947F, -32.4064F, -8.1128F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(37.6754F, -14.9416F, -1.3378F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(33.0138F, -24.8984F, -2.3273F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(33.2928F, -27.3328F, -2.9608F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(5.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(5.1317F, 14.9708F, 0.6747F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(14.6255F, 2.8866F, -2.5683F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(17.1152F, -1.9517F, -3.83F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(17.1152F, -1.9517F, -3.83F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(5.1768F, 7.0288F, 2.1269F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(13.3325F, 13.6295F, 5.1256F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(15.14F, 21.9045F, 11.0286F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(13.042F, -11.6487F, -11.166F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(18.7946F, -15.5672F, -14.3621F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(18.7946F, -15.5672F, -14.3621F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-28.9838F, 24.2848F, -29.4983F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-8.5123F, 7.1311F, -10.7735F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(6.4877F, 7.1311F, -10.7735F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(4.0307F, -28.3143F, 1.9094F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(2.2988F, -35.2784F, 5.1896F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-28.8076F, -36.0924F, 8.3235F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-27.4912F, -31.4943F, 5.9588F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(30.0088F, -31.4943F, 5.9588F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(31.9559F, -35.5417F, 2.4358F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(31.9559F, -35.5417F, 2.4358F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-17.5F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-22.5F, -12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-15.7849F, -32.4137F, 2.0236F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-15.5389F, -42.4086F, 1.6202F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(-15.5389F, -42.4086F, 1.6202F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(75.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(87.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 3.89F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 15.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 27.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 27.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(25.09F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(8.5973F, -3.9236F, 7.5777F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(15.7935F, -12.0174F, 16.1064F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-6.2672F, -12.6584F, 27.0147F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(-6.2672F, -12.6584F, 27.0147F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(14.26F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(-62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(65.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(65.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("legs", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-28.2107F, 0.1247F, -5.804F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2917F, AnimationHelper.createRotationalVector(3.9489F, 0.2751F, -5.9957F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-24.1771F, 16.0216F, -9.8881F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-41.9957F, -12.7925F, 24.3747F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(-40.3868F, -7.9637F, 15.469F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(-19.9917F, -6.0791F, 6.2449F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 2.57F, -13.24F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2917F, AnimationHelper.createTranslationalVector(0.0F, 2.93F, -14.43F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, -13.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, -2.9F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -2.8F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, -3.95F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(36.11F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-21.67F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(-18.97F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-12.49F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(26.09F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-10.56F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(7.34F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(6.46F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.79F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-4.18F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(18.6774F, 0.0F, -0.6136F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(27.5F, 0.0F, -1.0288F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(20.7904F, 0.0F, -1.2499F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2917F, AnimationHelper.createRotationalVector(6.4255F, 0.0F, -1.4224F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 15.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(5.475F, 0.0F, 16.44F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 15.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(5.9375F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(5.2534F, 0.0F, 2.2387F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2917F, AnimationHelper.createRotationalVector(6.9837F, 0.0F, 3.467F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-36.6559F, -11.3133F, 44.1018F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-49.7637F, 5.5765F, 27.3535F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(-49.2592F, 15.1578F, 23.7945F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(-54.1336F, 11.3488F, 14.7959F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, -0.81F, -0.15F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2917F, AnimationHelper.createTranslationalVector(0.0F, -1.04F, -0.21F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createTranslationalVector(0.0F, 0.54F, 0.27F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.74F, 0.68F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.17F, 2.51F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 4.16F, 1.29F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-0.4167F, 0.0F, -2.2049F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-0.7407F, 0.0F, -3.9198F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(11.25F, 0.0F, -7.9688F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(27.2152F, 0.4666F, -9.4655F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(45.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(46.6146F, 0.338F, -6.9679F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(45.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(57.3991F, -0.0211F, -3.7833F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-1.7152F, -0.0158F, 0.0131F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-3.0492F, -0.0281F, 0.0234F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(-21.1902F, 0.4274F, -0.3548F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-29.8804F, 0.8549F, -0.7096F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-27.3804F, 0.8549F, -0.7096F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-21.4354F, 0.9083F, -0.754F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(-27.3804F, 0.8549F, -0.7096F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(-24.0617F, 0.4241F, -0.352F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(6.6468F, -3.7787F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(9.5313F, -2.8125F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2917F, AnimationHelper.createRotationalVector(10.3469F, -1.0189F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(9.294F, 0.2083F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(36.25F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation STOMP1 = Animation.Builder.create(2.5F)
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-7.5283F, -4.9571F, 0.6543F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-16.7659F, -7.1712F, -6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-16.7659F, -7.1712F, -6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-16.7659F, -7.1712F, -6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 7.98F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, -13.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(12.5845F, 7.3854F, 1.3099F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(12.6511F, -9.8465F, -1.7541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(12.8453F, -14.7668F, -2.6645F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(12.6511F, -9.8465F, -1.7541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(22.5283F, 4.9571F, 0.6543F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(22.564F, -7.4355F, -0.9845F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(23.4656F, -6.3883F, -8.4656F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.7083F, AnimationHelper.createRotationalVector(22.564F, -7.4355F, -0.9845F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(22.5071F, 2.4786F, 0.3265F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(10.1954F, 12.2331F, 3.0628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(10.1954F, 12.2331F, 3.0628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(9.6824F, 18.7622F, 6.5848F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(2.1824F, 18.7622F, 6.5848F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(7.7939F, -9.4297F, -2.3382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(7.7939F, -9.4297F, -2.3382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(8.2782F, -13.8435F, -4.7372F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(3.2782F, -13.8435F, -4.7372F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(7.5F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(7.5F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(10.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(15.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(10.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(10.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(17.5F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(12.5F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(7.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-2.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-2.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(7.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(2.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(12.9091F, 19.093F, -21.8124F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(23.3833F, 21.6324F, -16.3077F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-5.6651F, 4.4643F, -11.9382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(1.204F, 2.0076F, -8.4318F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -10.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-41.9695F, -11.3126F, -15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-49.4695F, -11.3126F, -15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-41.9695F, -11.3126F, -15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, -13.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(50.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(17.5426F, 0.6518F, 7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(17.5426F, 0.6518F, 7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(17.5426F, 0.6518F, 7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(5.0426F, 0.6518F, 7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -7.56F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("desert_necklace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(10.2649F, 8.88F, 14.8179F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(1.6107F, 9.8122F, 9.379F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-6.5031F, 8.8885F, 8.1639F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-3.1996F, 20.1106F, 9.1344F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-3.1996F, 20.1106F, 9.1344F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-15.2431F, 18.8432F, 8.3521F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.7917F, AnimationHelper.createRotationalVector(-8.1464F, 13.5682F, -1.9785F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.1667F, AnimationHelper.createRotationalVector(2.1234F, 5.1606F, 3.4343F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(21.92F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(2.4727F, 0.0F, 16.4986F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(28.57F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("legs", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation STOMP2 = Animation.Builder.create(2.5F)
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-7.5283F, 4.9571F, -0.6543F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-16.7659F, 7.1712F, 6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-16.7659F, 7.1712F, 6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-16.7659F, 7.1712F, 6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 7.98F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, -13.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(12.5845F, -7.3854F, -1.3099F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(12.6511F, 9.8465F, 1.7541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(12.8453F, 14.7668F, 2.6645F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(12.6511F, 9.8465F, 1.7541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(22.5283F, -4.9571F, -0.6543F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(22.564F, 7.4355F, 0.9845F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(23.4656F, 6.3883F, 8.4656F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.7083F, AnimationHelper.createRotationalVector(22.564F, 7.4355F, 0.9845F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(22.5071F, -2.4786F, -0.3265F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(10.1954F, -12.2331F, -3.0628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(10.1954F, -12.2331F, -3.0628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(9.6824F, -18.7622F, -6.5848F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(2.1824F, -18.7622F, -6.5848F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(7.7939F, 9.4297F, 2.3382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(7.7939F, 9.4297F, 2.3382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(8.2782F, 13.8435F, 4.7372F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(3.2782F, 13.8435F, 4.7372F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(7.5F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(7.5F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(10.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(15.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(10.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(10.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(17.5F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(12.5F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(7.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-2.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-2.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(7.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(2.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(5.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(15.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(20.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(2.4727F, 0.0F, -16.4986F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(17.5426F, -0.6518F, -7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(17.5426F, -0.6518F, -7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(17.5426F, -0.6518F, -7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(5.0426F, -0.6518F, -7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -7.56F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 10.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-41.9695F, 11.3126F, 15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-49.4695F, 11.3126F, 15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-41.9695F, 11.3126F, 15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -7.56F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, -13.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(50.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(10.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(10.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("desert_necklace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(10.2649F, -8.88F, -14.8179F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(1.6107F, -9.8122F, -9.379F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-6.5031F, -8.8885F, -8.1639F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-3.1996F, -20.1106F, -9.1344F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-3.1996F, -20.1106F, -9.1344F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-15.2431F, -18.8432F, -8.3521F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.7917F, AnimationHelper.createRotationalVector(-8.1464F, -13.5682F, 1.9785F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.1667F, AnimationHelper.createRotationalVector(2.1234F, -5.1606F, -3.4343F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(28.57F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(2.5F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(12.9091F, -19.093F, 21.8124F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(23.3833F, -21.6324F, 16.3077F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-5.6651F, -4.4643F, 11.9382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(1.204F, -2.0076F, 8.4318F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(21.92F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("legs", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation PHASE_ROAR = Animation.Builder.create(3.0F)
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(2.4155F, -7.3854F, 1.3099F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(2.1547F, -14.7668F, 2.6645F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(2.29F, -11.08F, 1.99F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(2.4155F, -7.3854F, 1.3099F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-15.2375F, 4.5573F, -5.9629F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-16.2926F, 0.5728F, 7.6048F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-16.3553F, 5.4281F, 6.4087F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(-42.7085F, 23.1786F, -13.4363F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-29.53F, 14.3F, -3.51F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-16.3553F, 5.4281F, 6.4087F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(10.5041F, 14.4774F, 3.9676F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-7.8177F, -27.4717F, 1.2998F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(11.1737F, 21.6934F, 6.1199F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(8.09F, 10.85F, 3.06F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(22.5175F, 2.3491F, 0.8556F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(5.684F, -42.2052F, 0.1099F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(22.5056F, 28.4801F, 9.8501F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(20.0F, 14.24F, 4.93F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(35.6469F, 14.0761F, 5.2362F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(27.4378F, -41.6574F, -2.5805F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(40.5614F, 27.5124F, 12.4589F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(39.03F, 13.76F, 6.23F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(15.0628F, -4.768F, -1.5072F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(15.0974F, 0.1574F, -2.3688F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(15.087F, 2.6201F, -2.799F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(15.09F, 1.39F, -2.58F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(15.0974F, 0.1574F, -2.3688F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-25.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(-25.5938F, -14.3822F, 3.5148F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-25.68F, 0.87F, -2.16F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-25.7732F, 16.1241F, -7.8299F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-15.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-39.3453F, -5.9981F, -2.622F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(-19.481F, -4.9975F, 2.0473F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-19.6F, 11.24F, 1.45F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-19.7248F, 27.4818F, 0.8465F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-33.0645F, -7.4345F, -29.1476F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-0.4908F, 32.6838F, -56.728F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(6.2553F, 27.7956F, -43.3911F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(-2.0308F, 33.4851F, -59.55F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-2.1098F, 27.8007F, -51.9609F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-30.9283F, 4.7505F, 157.9817F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-54.9102F, -24.7407F, 117.7316F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-88.0979F, -15.3589F, 148.1563F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-60.5979F, -15.3589F, 148.1563F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-33.0645F, 7.4345F, 29.1476F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-0.4908F, -32.6838F, 56.728F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(6.2553F, -27.7956F, 43.3911F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(-2.0308F, -33.4851F, 59.55F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-2.1098F, -27.8007F, 51.9609F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-31.9127F, -6.6773F, -148.1195F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-59.1278F, 22.2263F, -128.2881F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-88.7069F, 14.3658F, -150.5301F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-66.2069F, 14.3658F, -150.5301F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-6.5732F, -31.3661F, -9.0565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-6.5732F, -31.3661F, -9.0565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(-6.5732F, -31.3661F, -9.0565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-6.5732F, -31.3661F, -9.0565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-6.5732F, -31.3661F, -9.0565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(13.13F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-6.5732F, 31.3661F, 9.0565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-6.5732F, 31.3661F, 9.0565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(-6.5732F, 31.3661F, 9.0565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-6.5732F, 31.3661F, 9.0565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-6.5732F, 31.3661F, 9.0565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(13.13F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(100.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(73.39F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(102.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(24.66F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(102.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(47.54F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(107.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(78.33F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(102.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(47.54F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(107.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(33.33F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation AWAKEN = Animation.Builder.create(4.0F)
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -45.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -45.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, -47.42F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, -43.65F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createTranslationalVector(0.0F, -33.86F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-6.4758F, 20.1692F, 2.2951F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-6.4758F, 20.1692F, 2.2951F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-13.1559F, -19.5968F, 7.9904F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-20.8309F, 9.2793F, 1.0559F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.9167F, AnimationHelper.createRotationalVector(-33.1659F, 7.2681F, 0.8271F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(-41.9188F, 5.9761F, 0.68F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-5.0F, 52.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-5.0F, 52.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(18.4107F, 33.1106F, 14.8442F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(20.2455F, -34.8561F, -13.6227F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(11.0185F, 15.5556F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.7917F, AnimationHelper.createRotationalVector(12.679F, 4.2957F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(8.546F, 41.3676F, 20.1538F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(8.546F, 41.3676F, 20.1538F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(9.4001F, -22.973F, 9.5975F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(12.8496F, -24.86F, 4.752F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(15.0322F, 12.2571F, 5.9715F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5833F, AnimationHelper.createRotationalVector(16.2874F, 3.3848F, 1.649F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.5F, 45.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(12.5F, 45.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(17.8843F, -20.4214F, -2.5388F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(24.06F, -18.1537F, -4.9418F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(23.6301F, 7.7013F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(30.0751F, -4.9226F, -1.8645F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -25.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(5.0F, -25.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-4.1552F, -25.62F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, -25.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(-2.8345F, -13.7005F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.9167F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.9167F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(42.5F, -35.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4167F, AnimationHelper.createRotationalVector(41.5624F, -30.2189F, 1.7382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-26.1738F, 19.8148F, -29.2628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-7.5373F, 2.8387F, -21.8444F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0417F, AnimationHelper.createRotationalVector(52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.6667F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-12.5F, -30.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4167F, AnimationHelper.createRotationalVector(-22.1673F, -25.0408F, -0.7193F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(0.0F, 45.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-9.6673F, -25.0408F, -0.7193F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2917F, AnimationHelper.createRotationalVector(-29.6673F, -25.0408F, -0.7193F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.6667F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(7.1729F, -7.7558F, -75.5759F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(7.6388F, 7.4228F, -21.0878F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2917F, AnimationHelper.createRotationalVector(-3.3542F, -31.003F, -43.5907F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-20.281F, -35.3972F, -29.8364F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(4.0208F, -51.3068F, -45.5118F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(29.4205F, -20.7604F, -51.3288F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.6667F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5417F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(57.05F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createRotationalVector(49.55F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.9167F, AnimationHelper.createRotationalVector(57.05F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("desert_necklace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-10.1157F, 0.7521F, -17.4843F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(9.1559F, -5.854F, -1.2539F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-20.8441F, -5.854F, -1.2539F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2083F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.9167F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("chain3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-117.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(-117.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 20.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -15.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("chain4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-97.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("desert_eye", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 20.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -15.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-42.5F, 0.0F, -15.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-105.3824F, -13.3493F, 24.2666F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-100.656F, 15.3586F, -23.0941F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-64.5169F, -66.3205F, -12.4554F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-5.8825F, -37.6772F, -61.9902F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(36.6179F, 24.0228F, -4.8374F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.9167F, AnimationHelper.createRotationalVector(0.0F, -22.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(97.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(97.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(64.9125F, -29.2081F, 51.9839F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(68.3883F, -16.4296F, 29.2409F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(-6.3055F, 1.0268F, -1.8276F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-46.7546F, 1.7313F, 5.3121F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-67.2321F, -39.0137F, -16.3215F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-70.4086F, 11.9566F, 8.0189F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(-1.6827F, 6.6174F, 4.1786F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(14.1211F, 18.9143F, 27.0765F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(4.058F, 3.4045F, -8.3555F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-72.8191F, 19.9207F, -1.817F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-117.8191F, 19.9207F, -1.817F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-56.8724F, 19.6835F, 3.6164F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-56.8724F, 19.6835F, 3.6164F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(97.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(109.66F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(97.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(68.32F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0833F, AnimationHelper.createRotationalVector(36.14F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-50.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-31.17F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-23.18F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(40.94F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-3.95F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation SLEEP = Animation.Builder.create(0.0F)
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -45.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-6.4758F, 20.1692F, 2.2951F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-5.0F, 52.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(8.546F, 41.3676F, 20.1538F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.5F, 45.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -25.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(42.5F, -35.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-12.5F, -30.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(7.1729F, -7.7558F, -75.5759F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("desert_necklace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("chain3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-117.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("chain4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("desert_eye", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-105.3824F, -13.3493F, 24.2666F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-100.656F, 15.3586F, -23.0941F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-64.5169F, -66.3205F, -12.4554F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(97.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-72.8191F, 19.9207F, -1.817F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(97.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation DEATH = Animation.Builder.create(2.375F)
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-22.7836F, -9.3912F, 3.4515F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(24.1488F, 20.7045F, 9.0079F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(22.1449F, 20.03F, 21.285F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(34.5684F, 26.128F, 8.8967F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.5119F, -7.4997F, -0.0668F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.87F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-9.2276F, -7.404F, 1.1993F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(-33.6755F, -37.3347F, 83.7069F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createTranslationalVector(0.0F, -70.0F, 40.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-15.0F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(25.3045F, 5.1465F, 1.7346F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(27.358F, 18.3331F, 10.0758F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createTranslationalVector(2.0F, 9.0F, -13.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(-11.1392F, 2.0F, -17.3889F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-18.9718F, 2.0111F, 14.5637F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-30.9209F, -21.6046F, -2.0433F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(16.5401F, 18.4487F, -37.9634F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createTranslationalVector(-1.0F, -10.0F, -14.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("chain1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-44.09F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("chain2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("chain3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("chain4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("desert_eye", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(-7.5F, 87.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("desert_eye", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createTranslationalVector(-2.0F, 0.0F, -1.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-9.5858F, -37.158F, -46.0143F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-24.5858F, -37.158F, -46.0143F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-24.5858F, -37.158F, -46.0143F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-42.4589F, 18.2102F, -70.539F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(15.0F, -50.0F, 47.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-2.7911F, -16.5903F, 46.4724F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-22.6898F, 25.7151F, 32.5963F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-64.7211F, 13.9257F, 12.1626F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-64.7211F, 13.9257F, 12.1626F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(-93.7899F, 60.6178F, -13.6228F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, -58.0F, 39.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(85.4776F, -29.1725F, -37.5096F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-22.4232F, 13.6623F, 4.8741F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-22.4232F, 13.6623F, 4.8741F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation SAND_STORM_ROAR = Animation.Builder.create(3.0F)
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, -14.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createTranslationalVector(0.0F, -15.77F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, -11.9F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.9583F, AnimationHelper.createTranslationalVector(0.0F, -9.6F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2083F, AnimationHelper.createTranslationalVector(0.0F, -6.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(2.3489F, -9.8465F, 1.7541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0597F, 0.1053F, 0.5307F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-0.2076F, -6.5683F, 1.8677F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4167F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-17.1826F, -21.1026F, 6.9733F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-18.9058F, -33.1501F, 10.7307F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.7917F, AnimationHelper.createRotationalVector(-16.6904F, 15.2925F, -2.2327F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4167F, AnimationHelper.createRotationalVector(11.1737F, 21.6934F, 6.1199F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(10.3472F, 12.0674F, 3.2844F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(10.0547F, -4.8292F, -1.2973F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0833F, AnimationHelper.createRotationalVector(10.5041F, 14.4774F, 3.9676F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4167F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 27.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4167F, AnimationHelper.createRotationalVector(0.0F, 32.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(17.5F, 42.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(17.2487F, -34.9521F, -2.9782F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.6667F, AnimationHelper.createRotationalVector(16.9951F, 22.5149F, -0.9253F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-23.2109F, -13.8345F, 5.8546F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-23.2109F, 13.8345F, -5.8546F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(2.9179F, 25.3144F, 2.7043F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-32.9263F, -14.6365F, 3.3186F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-39.0315F, -15.217F, -3.2531F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(-31.367F, 7.4431F, -7.0079F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-4.201F, 3.9804F, -2.8831F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(43.8437F, 21.4056F, 7.1007F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(15.0628F, -4.768F, -1.5072F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(14.3119F, -21.99F, 1.7004F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(15.0894F, -2.3054F, -1.9387F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.9583F, AnimationHelper.createRotationalVector(14.9744F, 8.7771F, -3.8822F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4167F, AnimationHelper.createRotationalVector(20.08F, -4.8243F, -1.9407F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-25.2218F, -9.6956F, 1.7328F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2083F, AnimationHelper.createRotationalVector(-30.1853F, 9.0967F, -5.1429F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-26.129F, -19.0549F, 5.3733F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.9583F, AnimationHelper.createRotationalVector(-25.9168F, -8.4815F, 1.3944F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4167F, AnimationHelper.createRotationalVector(-26.3736F, 20.7902F, -9.7245F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 45.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-15.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(-19.7248F, 27.4818F, 0.8465F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-19.481F, -4.9975F, 2.0473F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.9583F, AnimationHelper.createRotationalVector(-19.6F, 11.24F, 1.45F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2083F, AnimationHelper.createRotationalVector(-19.7248F, 27.4818F, 0.8465F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(7.0519F, 8.1387F, 0.213F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.9583F, AnimationHelper.createRotationalVector(52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2083F, AnimationHelper.createRotationalVector(60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(12.9091F, 19.093F, -26.8124F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(14.9036F, 26.667F, -40.8821F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(23.4774F, 24.5937F, -35.5715F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2083F, AnimationHelper.createRotationalVector(19.2128F, -0.85F, -1.3685F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(16.192F, -2.3039F, 1.5949F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(-3.89F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2083F, AnimationHelper.createRotationalVector(-14.52F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(10.56F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(12.9091F, -19.093F, 26.8124F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(25.41F, -19.09F, 26.81F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(20.7054F, 1.0683F, 1.5134F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2083F, AnimationHelper.createRotationalVector(0.4829F, -6.0539F, 11.6932F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(3.8619F, -4.124F, 7.7131F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(34.72F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2083F, AnimationHelper.createRotationalVector(1.83F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(11.27F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-20.4533F, -10.5831F, -0.4213F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-34.705F, -24.4144F, 2.4781F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-34.705F, -24.4144F, 2.4781F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-64.0365F, 11.8491F, 9.2643F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-20.4533F, 10.5831F, 0.4213F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-34.705F, 24.4144F, -2.4781F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-34.705F, 24.4144F, -2.4781F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("desert_necklace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(-51.8247F, -7.9969F, -9.6387F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(32.6075F, 3.2114F, 3.8343F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-1.8998F, 0.0417F, 21.0541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(46.447F, 5.7087F, -11.0027F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.9583F, AnimationHelper.createRotationalVector(34.2157F, -24.5338F, 29.9081F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4167F, AnimationHelper.createRotationalVector(12.2117F, -11.3033F, 4.476F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.7917F, AnimationHelper.createRotationalVector(2.2117F, -11.3033F, 4.476F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation CHARGE_PREPARE = Animation.Builder.create(3.5F)
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, 2.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 3.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -7.2F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 3.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, -7.2F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 2.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(-12.5F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(-20.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(2.5283F, -4.9571F, -0.6543F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(2.5283F, 4.9571F, 0.6543F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(15.0462F, -4.8812F, -1.0848F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(15.0462F, 4.8812F, 1.0848F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(12.5845F, 7.3854F, 1.3096F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(12.5845F, 7.3854F, 1.3096F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(25.019F, -4.9809F, -0.4369F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(25.019F, 4.9809F, 0.4369F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(20.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(20.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(2.5024F, 2.4976F, 0.1091F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(2.5024F, -2.4976F, -0.1091F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(-10.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(-10.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(2.5193F, 2.3096F, 0.9572F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(2.5193F, -2.3096F, -0.9572F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(22.5F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(22.5F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-7.5038F, 0.1869F, 0.1625F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-10.0038F, 0.1869F, 0.1625F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-7.5038F, -0.1869F, -0.1625F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-10.0038F, -0.1869F, -0.1625F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(-15.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(-15.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(-19.9929F, -2.5024F, -0.1091F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(-19.9929F, -2.5024F, -0.1091F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(5.16F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-0.4096F, -22.4097F, 2.0675F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(5.16F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(-40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 6.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -6.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -6.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(47.4123F, 0.8977F, -0.8977F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(20.1276F, -1.9703F, 0.3842F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-44.9533F, 0.2918F, 0.3861F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 6.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, -4.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, -4.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(9.9905F, -4.9952F, 0.2187F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(9.9905F, 4.9952F, -0.2187F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(24.9929F, -0.0071F, 0.3268F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(24.9929F, -0.0071F, 0.3268F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(32.97F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(32.97F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(8.59F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(8.59F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(5.16F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-0.4096F, 22.4097F, -2.0675F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(5.16F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(32.97F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(32.97F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(8.59F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(8.59F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(34.9901F, -0.305F, -0.0932F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(47.4901F, 0.305F, 0.0932F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("desert_necklace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-17.4981F, 0.2469F, -0.1191F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-12.4995F, 0.143F, -0.0456F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-27.4983F, 0.3279F, -0.1899F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(-2.4978F, 0.3502F, -0.0311F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.7917F, AnimationHelper.createRotationalVector(-12.4971F, 0.22F, -0.0525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(-27.4935F, -0.087F, 0.0522F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.3333F, AnimationHelper.createRotationalVector(-39.3705F, -0.3177F, 0.206F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(-9.9946F, 0.0739F, -0.0637F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.9583F, AnimationHelper.createRotationalVector(-4.9947F, 0.0946F, -0.0901F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("legs", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation CHARGE = Animation.Builder.create(0.75F).looping()
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.0833F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, 2.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(24.9929F, -0.0071F, 0.3268F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(11.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(24.9929F, 0.0071F, -0.3268F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(11.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(24.9929F, -0.0071F, 0.3268F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createTranslationalVector(0.0F, 8.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, 8.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-20.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-8.1396F, -0.1329F, 2.3766F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(-25.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(-8.1396F, -0.1329F, 2.3766F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-20.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.5845F, 7.3854F, 1.3096F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(12.5845F, -7.3854F, -1.3096F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(12.5845F, 7.3854F, 1.3096F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(20.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(20.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(20.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-10.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(-10.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-10.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.0833F, AnimationHelper.createRotationalVector(14.86F, 1.7139F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(15.0F, -0.415F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(22.5F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(14.86F, -2.0061F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(15.0F, -0.415F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(22.5F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-15.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(-7.5F, -0.415F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(-15.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-7.5F, -0.415F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-15.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-19.9929F, -2.5024F, -0.1091F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(-19.9929F, 0.3128F, 0.0136F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(-19.9929F, 2.5024F, 0.1091F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-19.9929F, -0.3128F, -0.0136F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-19.9929F, -2.5024F, -0.1091F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("legs", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -6.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, -4.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -10.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -6.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(8.59F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(-42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, -4.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -10.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -6.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, -4.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(8.59F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.0833F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("desert_necklace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();


        public static final Animation CHARGE_STUN = Animation.Builder.create(6.0F)
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 2.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(24.9929F, -0.0071F, 0.3268F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(39.9929F, 0.0071F, -0.3268F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(42.4929F, 0.0071F, -0.3268F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(42.4929F, 0.0071F, -0.3268F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(42.4929F, 0.0071F, -0.3268F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-20.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(-12.4104F, -4.7331F, -1.4677F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-0.7193F, -20.3795F, 0.8013F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-35.8252F, 4.6095F, 1.5554F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-65.8252F, 4.6095F, 1.5554F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-65.8252F, 4.6095F, 1.5554F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.875F, AnimationHelper.createRotationalVector(-65.8252F, 4.6095F, 1.5554F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, -10.35F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(12.2338F, -3.191F, 2.2532F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-2.6983F, 14.2954F, 2.9468F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-2.6983F, 14.2954F, 2.9468F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.25F, AnimationHelper.createRotationalVector(-2.6983F, 14.2954F, 2.9468F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.5845F, 7.3854F, 1.3096F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(13.8452F, -19.6655F, -3.9496F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(16.8959F, -4.5403F, 1.8745F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(49.7573F, 44.5485F, 40.4017F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(49.7573F, 44.5485F, 40.4017F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(49.7573F, 44.5485F, 40.4017F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(20.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(20.2726F, -19.8938F, -2.4529F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(27.5763F, -12.4243F, -1.7491F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(38.3819F, 57.6012F, 21.0539F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(38.3819F, 57.6012F, 21.0539F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.9583F, AnimationHelper.createRotationalVector(38.3819F, 57.6012F, 21.0539F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-10.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-25.7201F, 14.0407F, -4.3384F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-34.9287F, 2.7335F, 1.0575F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(2.5713F, 2.7335F, 1.0575F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(2.5713F, 2.7335F, 1.0575F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(2.5713F, 2.7335F, 1.0575F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-19.9997F, -30.0F, -0.001F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-29.9997F, -30.0F, -0.001F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(6.34F, -2.8483F, -4.6046F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(6.34F, -2.8483F, -4.6046F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(6.34F, -2.8483F, -4.6046F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(17.3895F, -24.3979F, -0.8475F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(4.8895F, -24.3979F, -0.8475F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(37.4198F, -30.0335F, -9.5456F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(14.8095F, -12.0748F, -25.4045F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.9583F, AnimationHelper.createRotationalVector(5.279F, 26.3071F, -14.9211F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.3333F, AnimationHelper.createRotationalVector(3.3276F, -9.0824F, 3.3206F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.625F, AnimationHelper.createRotationalVector(-0.0687F, 14.6362F, -6.3216F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-15.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-24.5676F, -29.1015F, 5.4754F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-22.1765F, -7.7164F, -1.9553F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createRotationalVector(5.3235F, -7.7164F, -1.9553F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(4.4051F, -14.6928F, -3.3418F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.9583F, AnimationHelper.createRotationalVector(4.8932F, 26.8361F, 3.3884F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.3333F, AnimationHelper.createRotationalVector(4.5456F, -25.0482F, -5.1032F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.625F, AnimationHelper.createRotationalVector(3.7364F, 11.8678F, 0.5254F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-19.9929F, -2.5024F, -0.1091F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-13.7965F, -47.4356F, -2.7284F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-14.9346F, -12.4831F, -0.5548F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2917F, AnimationHelper.createRotationalVector(-16.401F, -45.7131F, -2.5737F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-13.7965F, -47.4356F, -2.7284F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2083F, AnimationHelper.createRotationalVector(-10.2001F, -32.028F, -7.2815F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-1.4731F, -21.9141F, -6.7839F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.9583F, AnimationHelper.createRotationalVector(-0.4535F, -1.6109F, -1.0525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.3333F, AnimationHelper.createRotationalVector(1.7153F, -21.2232F, -8.1512F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.625F, AnimationHelper.createRotationalVector(8.9355F, -1.1F, -0.2251F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(58.8026F, -16.5744F, -26.3424F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(24.3397F, 20.1913F, -10.2966F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(4.9348F, 17.8812F, -11.3088F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(30.285F, -2.7843F, -20.3395F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(30.285F, -2.7843F, -20.3395F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.9583F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.3333F, AnimationHelper.createRotationalVector(24.0674F, 0.9323F, 2.6473F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.625F, AnimationHelper.createRotationalVector(34.7247F, 1.5294F, 3.1394F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(7.5045F, -9.8456F, -28.4815F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-10.0156F, -15.3926F, -16.9963F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-52.5156F, -15.3926F, -16.9963F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-52.5156F, -15.3926F, -16.9963F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-21.9238F, -9.308F, 23.3067F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-14.4238F, -9.308F, 23.3067F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-14.4238F, -9.308F, 23.3067F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-67.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-67.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("legs", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-20.49F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-20.0528F, -6.8001F, -7.3493F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-20.0528F, -6.8001F, -7.3493F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-20.0528F, -6.8001F, -7.3493F), Transformation.Interpolations.CUBIC),
                        new Keyframe(6.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -6.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -6.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, 4.9952F, -6.2181F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 4.9952F, -6.2181F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createTranslationalVector(0.0F, 4.9952F, -6.2181F), Transformation.Interpolations.CUBIC),
                        new Keyframe(6.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(9.09F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(1.15F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(23.65F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(23.65F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(23.65F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(6.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(-19.06F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(6.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(20.0592F, 0.5409F, 12.4885F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(2.5592F, 0.5409F, 12.4885F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(2.5592F, 0.5409F, 12.4885F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(2.5592F, 0.5409F, 12.4885F), Transformation.Interpolations.CUBIC),
                        new Keyframe(6.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, -4.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(6.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-0.68F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(6.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(6.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(6.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.0833F, AnimationHelper.createTranslationalVector(0.0F, -3.5262F, 1.1145F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, -3.5262F, 1.1145F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.4798F, 10.9895F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, -3.3081F, 6.1097F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createTranslationalVector(0.0F, -6.3432F, -7.7307F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.3752F, -9.4081F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, -0.0548F, -9.0381F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -2.3438F, -7.9045F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, -11.3314F, -7.5074F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -11.3314F, -7.5074F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createTranslationalVector(0.0F, -11.3314F, -7.5074F), Transformation.Interpolations.CUBIC),
                        new Keyframe(6.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("desert_necklace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-0.4752F, -35.6327F, 58.6695F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(12.9308F, 12.6788F, -28.3874F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-12.6914F, 17.7562F, -40.231F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(6.4595F, 6.7094F, -42.0964F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2917F, AnimationHelper.createRotationalVector(-32.0814F, -65.8276F, 0.3552F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-54.5147F, -60.8332F, 19.7924F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-54.5147F, -60.8332F, 19.7924F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.75F, AnimationHelper.createRotationalVector(-10.038F, -0.4343F, 9.9907F), Transformation.Interpolations.CUBIC),
                        new Keyframe(6.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-11.05F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-33.55F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-33.55F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-33.55F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(6.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(6.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();



}
