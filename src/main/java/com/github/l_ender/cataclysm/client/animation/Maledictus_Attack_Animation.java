package com.github.l_ender.cataclysm.client.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;


public class Maledictus_Attack_Animation {

    public static final Animation SPIN_SLASHES = Animation.Builder.create(3.375F)
            .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-55.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-27.3601F, -11.2409F, -0.6685F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createRotationalVector(13.7806F, 13.0646F, 12.0248F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2917F, AnimationHelper.createRotationalVector(17.9237F, 11.6059F, 9.4214F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-25.1087F, -16.1024F, 7.3535F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.7083F, AnimationHelper.createRotationalVector(13.7806F, -13.0646F, -12.0248F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createRotationalVector(-25.5611F, 2.4294F, -17.3926F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2917F, AnimationHelper.createRotationalVector(-48.1393F, 3.0149F, -13.5827F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 40.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 47.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-17.2299F, -43.7154F, 6.7609F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-13.2626F, -45.9977F, 11.3193F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.625F, AnimationHelper.createRotationalVector(-14.861F, -46.7868F, 11.5336F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.875F, AnimationHelper.createRotationalVector(18.4209F, -36.6955F, 1.523F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0417F, AnimationHelper.createRotationalVector(16.5F, -60.4096F, -4.6042F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2083F, AnimationHelper.createRotationalVector(26.7609F, -58.9937F, -6.5632F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.7083F, AnimationHelper.createRotationalVector(27.4753F, -43.5101F, -1.3367F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(54.1485F, 58.5236F, 72.6627F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(92.8031F, 35.8795F, 113.2354F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(118.8811F, 30.6357F, 156.1087F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-63.7006F, -8.2574F, -13.2431F), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.625F, AnimationHelper.createRotationalVector(-68.7112F, -30.4912F, -25.0118F), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.875F, AnimationHelper.createRotationalVector(-107.9845F, 77.3689F, -45.6422F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-49.8082F, -65.6055F, -11.8729F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-56.9454F, -58.8864F, 25.3604F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, -45.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.625F, AnimationHelper.createRotationalVector(0.0F, -45.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9583F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-123.1352F, 76.8516F, -48.3026F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-167.012F, 72.1834F, -94.1085F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-119.3331F, 35.9391F, -103.9076F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0833F, AnimationHelper.createRotationalVector(3.0135F, 35.0138F, -63.456F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.2917F, AnimationHelper.createRotationalVector(31.6426F, 0.9346F, -31.27F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(57.0986F, -56.926F, -118.212F), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.625F, AnimationHelper.createRotationalVector(37.7216F, -69.7726F, -113.3639F), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.9583F, AnimationHelper.createRotationalVector(57.3648F, -34.6103F, -64.3733F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2083F, AnimationHelper.createRotationalVector(92.3648F, -34.6103F, -64.3733F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.625F, AnimationHelper.createRotationalVector(91.7135F, -25.134F, -81.4721F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.625F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.875F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-1.867F, 27.3866F, 2.5978F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-2.2587F, 17.4313F, 1.5741F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-2.4571F, -7.4713F, -0.6574F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.625F, AnimationHelper.createRotationalVector(-2.3246F, -14.9416F, -1.3378F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9583F, AnimationHelper.createRotationalVector(8.72F, -29.7082F, -3.8653F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2083F, AnimationHelper.createRotationalVector(25.1632F, -49.6553F, -17.6214F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.7083F, AnimationHelper.createRotationalVector(7.4385F, -10.4402F, -4.7908F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 37.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createRotationalVector(0.0F, 85.37F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 97.07F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 7.41F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, -8.04F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.75F, AnimationHelper.createRotationalVector(-4.3045F, -45.4622F, 10.8707F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("left_wing2", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -67.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createRotationalVector(0.0F, -43.66F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -17.86F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, -1.3F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, -115.02F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, -90.36F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createRotationalVector(0.0F, 48.86F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -4.38F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, -41.98F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.1F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, -28.15F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("right_wing2", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 40.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createRotationalVector(0.0F, 60.22F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 75.33F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 73.89F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 20.26F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("berserker", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 42.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(5.0F, 42.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(0.0F, -35.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, -132.5F, 0.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.625F, AnimationHelper.createRotationalVector(0.0F, -132.5F, 0.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, -340.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2083F, AnimationHelper.createRotationalVector(0.0F, -370.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, -360.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("berserker", new Transformation(Transformation.Targets.TRANSLATE,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, -2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.625F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, -2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, -2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0833F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, -2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2917F, AnimationHelper.createTranslationalVector(0.0F, -4.13F, -1.53F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.7083F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createRotationalVector(30.6538F, -0.0029F, -1.6857F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2917F, AnimationHelper.createRotationalVector(27.48F, -0.0024F, -1.4147F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2917F, AnimationHelper.createRotationalVector(47.3161F, 1.7467F, 3.3076F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(8.0754F, 24.8858F, 1.7846F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(8.4474F, 29.834F, 2.5933F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(7.4306F, -9.8141F, -2.9057F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(5.1484F, 36.8127F, 8.2754F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.625F, AnimationHelper.createRotationalVector(3.0065F, 6.4952F, 5.7016F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.875F, AnimationHelper.createRotationalVector(11.5693F, -44.8252F, -2.4366F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2083F, AnimationHelper.createRotationalVector(20.1175F, -53.2065F, -6.182F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.7083F, AnimationHelper.createRotationalVector(7.8172F, -41.9097F, 3.6781F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(7.5F, -17.5F, 7.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(18.3697F, -0.358F, -17.8432F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.875F, AnimationHelper.createRotationalVector(38.7334F, 70.8131F, 28.8568F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createRotationalVector(16.3405F, 17.501F, -2.7402F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("right_mace", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(90.2461F, 79.4086F, 44.7539F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.25F, AnimationHelper.createRotationalVector(104.6359F, 61.2067F, 34.8086F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.625F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.875F, AnimationHelper.createRotationalVector(27.5F, 52.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createRotationalVector(62.6452F, 30.4553F, 1.206F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9583F, AnimationHelper.createRotationalVector(72.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2083F, AnimationHelper.createRotationalVector(35.1767F, -29.784F, -19.2953F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -15.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("left_mace", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0833F, AnimationHelper.createRotationalVector(54.7086F, -1.4597F, -6.5141F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(37.6056F, -3.9649F, -3.0487F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(75.0479F, -30.661F, -27.0585F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.625F, AnimationHelper.createRotationalVector(24.6068F, -17.1687F, -19.8613F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.7083F, AnimationHelper.createRotationalVector(86.0631F, -16.121F, -19.5254F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.7917F, AnimationHelper.createRotationalVector(75.8558F, -16.8052F, -20.0638F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9583F, AnimationHelper.createRotationalVector(92.1068F, -17.1687F, -19.8613F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2083F, AnimationHelper.createRotationalVector(124.6068F, -17.1687F, -19.8613F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .build();

        public static final Animation COMBO_FIRST = Animation.Builder.create(1.3333F)
                .addBoneAnimation("berserker", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-2.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-15.0F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, -22.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-7.816F, -26.6824F, 3.1145F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-7.816F, -26.6824F, 3.1145F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("berserker", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -6.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, -6.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -6.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createTranslationalVector(0.0F, -11.0F, -3.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, -11.0F, -3.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-48.0645F, 7.4965F, 6.8998F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-48.0645F, 7.4965F, 6.8998F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-88.0645F, 7.4965F, 6.8998F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-90.5645F, 7.4965F, 6.8998F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-90.5645F, 7.4965F, 6.8998F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(47.396F, -1.41F, 0.1972F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(57.396F, -1.41F, 0.1972F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(49.896F, -1.41F, 0.1972F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(82.396F, -1.41F, 0.1972F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(84.896F, -1.41F, 0.1972F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(84.896F, -1.41F, 0.1972F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(18.8912F, 8.4214F, -26.4849F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-13.5684F, -15.0141F, -35.6115F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-13.5684F, -15.0141F, -35.6115F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(15.3934F, 11.9515F, -8.3173F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(12.8934F, 11.9515F, -8.3173F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(12.8934F, 11.9515F, -8.3173F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(65.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(67.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(67.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 27.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(7.5F, -50.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(23.7827F, -56.9644F, -4.6971F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(8.0924F, -59.7427F, 13.6851F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(16.2246F, -38.1084F, 5.3984F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(24.5601F, -40.3899F, 4.0781F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(24.5601F, -40.3899F, 4.0781F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-5.2963F, 27.4699F, -0.7346F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-11.6016F, 41.2369F, -12.382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-5.0201F, 8.8922F, -8.7974F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(4.9208F, -1.0707F, -9.6612F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(4.661F, -1.908F, 0.3071F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(13.5118F, -23.012F, -14.7919F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(19.2804F, -27.743F, -16.5836F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(19.2804F, -27.743F, -16.5836F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(12.8947F, 23.6832F, 8.5673F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(41.7745F, 21.5369F, 36.8571F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-105.1668F, 37.2485F, 4.4338F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-200.1337F, 58.3556F, -42.9235F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-160.1337F, 58.3556F, -42.9235F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-67.6118F, 45.8556F, -42.8982F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-77.2965F, 49.0534F, -54.7185F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-77.2965F, 49.0534F, -54.7185F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_mace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(5.4925F, -3.8711F, 9.4351F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-39.5075F, -3.8711F, 9.4351F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(5.4925F, -3.8711F, 9.4351F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(7.9925F, -3.8711F, 9.4351F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(7.9925F, -3.8711F, 9.4351F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-81.8677F, 65.4096F, 31.1685F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-76.3126F, 25.4917F, 53.1238F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-75.6338F, -28.8101F, 25.4371F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-59.9265F, -53.0106F, 4.9724F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-23.0547F, -23.3258F, -53.8303F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(10.7429F, -19.7239F, -84.4303F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(14.1661F, -17.1521F, -92.2628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(14.1661F, -17.1521F, -92.2628F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(5.0F, 65.0F, -17.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(2.7581F, 40.0509F, -20.2581F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_mace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(92.5F, 20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(145.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(121.1136F, -47.9366F, 50.8895F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(113.2412F, -51.3742F, 61.2021F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(113.2412F, -51.3742F, 61.2021F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-2.4571F, -7.4713F, -0.6574F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-2.0904F, 22.4097F, 2.0675F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.2508F, 49.7409F, 5.9299F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.2508F, 49.7409F, 5.9299F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(11.9937F, 44.4225F, 8.456F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(19.8332F, 40.0234F, 5.2439F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(19.8332F, 40.0234F, 5.2439F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-0.5351F, 29.9929F, 31.6504F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(-26.606F, 24.0983F, -2.1641F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-35.0658F, 34.7544F, -12.8558F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-11.3993F, 53.742F, 14.5592F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-51.2594F, 45.1678F, -27.0871F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_wing2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -52.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, -37.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -52.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, -32.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -35.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -40.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(16.8538F, -13.1881F, -17.342F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_wing2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 38.43F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, 112.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 55.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 30.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 35.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation COMBO_FIRST_END = Animation.Builder.create(0.6667F)
                .addBoneAnimation("berserker", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("berserker", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -11.0F, -3.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createTranslationalVector(0.0F, -11.0F, -3.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-90.5645F, 7.4965F, 6.8998F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-90.5645F, 7.4965F, 6.8998F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(84.896F, -1.41F, 0.1972F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(84.896F, -1.41F, 0.1972F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.8934F, 11.9515F, -8.3173F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(12.8934F, 11.9515F, -8.3173F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(67.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(67.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(24.5601F, -40.3899F, 4.0781F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(24.5601F, -40.3899F, 4.0781F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(19.2804F, -27.743F, -16.5836F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(19.2804F, -27.743F, -16.5836F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-77.2965F, 49.0534F, -54.7185F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-77.2965F, 49.0534F, -54.7185F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_mace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(7.9925F, -3.8711F, 9.4351F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(7.9925F, -3.8711F, 9.4351F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(14.1661F, -17.1521F, -92.2628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(14.1661F, -17.1521F, -92.2628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_mace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(113.2412F, -51.3742F, 61.2021F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(113.2412F, -51.3742F, 61.2021F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(19.8332F, 40.0234F, 5.2439F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(19.8332F, 40.0234F, 5.2439F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-51.2594F, 45.1678F, -27.0871F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-51.2594F, 45.1678F, -27.0871F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_wing2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -32.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, -32.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_wing2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 35.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 35.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation COMBO_SECOND = Animation.Builder.create(2.25F)
                .addBoneAnimation("berserker", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-2.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-15.0F, -35.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-7.816F, 26.6824F, -3.1145F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-7.816F, 26.6824F, -3.1145F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("berserker", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -11.0F, -3.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -6.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, -6.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -6.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createTranslationalVector(0.0F, -11.0F, -3.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, -11.0F, -3.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-90.5645F, 7.4965F, 6.8998F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(18.8912F, -8.4214F, 26.4849F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-13.5684F, 15.0141F, 35.6115F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-13.5684F, 15.0141F, 35.6115F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(15.3934F, -11.9515F, 8.3173F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(12.8934F, -11.9515F, 8.3173F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(12.8934F, -11.9515F, 8.3173F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(84.896F, -1.41F, 0.1972F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(49.896F, -1.41F, 0.1972F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(65.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(67.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(67.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.8934F, 11.9515F, -8.3173F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-48.0645F, -7.4965F, -6.8998F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-48.0645F, -7.4965F, -6.8998F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-88.0645F, -7.4965F, -6.8998F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-90.5645F, -7.4965F, -6.8998F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-90.5645F, -7.4965F, -6.8998F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(67.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(47.396F, 1.41F, -0.1972F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(57.396F, 1.41F, -0.1972F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(49.896F, 1.41F, -0.1972F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(62.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(82.396F, 1.41F, -0.1972F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(84.896F, 1.41F, -0.1972F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(84.896F, 1.41F, -0.1972F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(24.5601F, -40.3899F, 4.0781F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -27.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(7.5F, 50.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(23.7827F, 56.9644F, 4.6971F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(8.0924F, 59.7427F, -13.6851F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(16.2246F, 38.1084F, -5.3984F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(24.5601F, 40.3899F, -4.0781F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(24.5601F, 40.3899F, -4.0781F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(19.2804F, -27.743F, -16.5836F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-5.2963F, -27.4699F, 0.7346F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-11.6016F, -41.2369F, 12.382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-5.0201F, -8.8922F, 8.7974F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(4.9208F, 1.0707F, 9.6612F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(4.661F, 1.908F, -0.3071F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(13.5118F, 23.012F, 14.7919F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(19.2804F, 27.743F, 16.5836F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(19.2804F, 27.743F, 16.5836F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-77.2965F, 49.0534F, -54.7185F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-81.8677F, -65.4096F, -31.1685F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-76.3126F, -25.4917F, -53.1238F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-75.6338F, 28.8101F, -25.4371F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-59.9265F, 53.0106F, -4.9724F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-23.0547F, 23.3258F, 53.8303F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(10.7429F, 19.7239F, 84.4303F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(14.1661F, 17.1521F, 92.2628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(14.1661F, 17.1521F, 92.2628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(5.0F, -65.0F, 17.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(2.7581F, -40.0509F, 20.2581F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_mace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(7.9925F, -3.8711F, 9.4351F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(92.5F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(5.4925F, -3.8711F, 9.4351F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-39.5075F, -3.8711F, 9.4351F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(145.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(121.1136F, 47.9366F, -50.8895F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(113.2412F, 51.3742F, -61.2021F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(113.2412F, 51.3742F, -61.2021F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(14.1661F, -17.1521F, -92.2628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(12.8947F, -23.6832F, -8.5673F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(41.7745F, -21.5369F, -36.8571F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-105.1668F, -37.2485F, -4.4338F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-200.1337F, -58.3556F, 42.9235F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-160.1337F, -58.3556F, 42.9235F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-67.6118F, -45.8556F, 42.8982F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-77.2965F, -49.0534F, 54.7185F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-77.2965F, -49.0534F, 54.7185F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(2.7581F, 40.0509F, -20.2581F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_mace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(113.2412F, -51.3742F, 61.2021F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(92.5F, 20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(5.4925F, 3.8711F, -9.4351F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-39.5075F, 3.8711F, -9.4351F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(145.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(5.4925F, 3.8711F, -9.4351F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(7.9925F, 3.8711F, -9.4351F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(7.9925F, 3.8711F, -9.4351F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(19.8332F, 40.0234F, 5.2439F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-2.4571F, 7.4713F, 0.6574F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-2.0904F, -22.4097F, -2.0675F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.2508F, -49.7409F, -5.9299F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.2508F, -49.7409F, -5.9299F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(11.9937F, -44.4225F, -8.456F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(19.8332F, -40.0234F, -5.2439F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(19.8332F, -40.0234F, -5.2439F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-51.2594F, 45.1678F, -27.0871F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 35.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, 30.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 40.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(16.8538F, 13.1881F, 17.342F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_wing2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -32.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -38.43F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, -112.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -55.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0F, -35.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(-0.5351F, -29.9929F, -31.6504F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(-26.606F, -24.0983F, 2.1641F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-35.0658F, -34.7544F, 12.8558F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-11.3993F, -53.742F, -14.5592F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-51.2594F, -45.1678F, 27.0871F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_wing2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 35.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 52.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, 37.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 52.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0F, 32.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();



        public static final Animation UPPERCUT_RIGHT = Animation.Builder.create(3.0F)
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-2.546F, 4.9971F, 12.3222F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-10.046F, 4.9971F, 12.3222F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-35.046F, 4.9971F, 12.3222F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-48.3727F, 16.5066F, 22.8208F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-101.2423F, -8.7081F, 9.4666F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-116.2423F, -8.7081F, 9.4666F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-93.7423F, -8.7081F, 9.4666F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-96.2423F, -8.7081F, 9.4666F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-96.2423F, -8.7081F, 9.4666F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-13.363F, -23.2831F, -19.5113F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-9.7615F, -24.2389F, -25.5981F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-5.2173F, 6.26F, 6.5729F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-7.7173F, 6.26F, 6.5729F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(18.7982F, 4.8598F, -5.9404F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(8.7982F, 4.8598F, -5.9404F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-22.7605F, 4.9064F, 7.2979F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-17.7605F, 4.9064F, 7.2979F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-17.7605F, 4.9064F, 7.2979F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 25.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-2.5F, 32.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-9.7431F, -19.9612F, 2.11F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-19.1461F, -31.8424F, 6.4413F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-17.0462F, -40.5201F, 3.4486F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-24.5462F, -40.5201F, 3.4486F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(3.3306F, 15.9013F, -18.5191F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(5.8306F, 15.9013F, -18.5191F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(5.8306F, 15.9013F, -18.5191F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(55.0F, 0.0F, 47.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(65.0F, 0.0F, 47.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(67.5F, 0.0F, 47.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-154.8512F, 52.8687F, -10.0425F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-162.3512F, 52.8687F, -10.0425F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(-146.2872F, -4.0686F, -15.6979F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-127.9445F, -28.0422F, -18.0791F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-122.9445F, -28.0422F, -18.0791F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-122.9445F, -28.0422F, -18.0791F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(-71.5454F, -15.6118F, -12.7417F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(15.65F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(-38.15F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(9.19F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(16.2738F, 43.7995F, -18.9744F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(13.5571F, 50.5619F, -15.3344F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(23.3174F, -26.0528F, -40.5167F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(36.8322F, -19.0543F, -52.4952F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(36.8322F, -19.0543F, -52.4952F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(36.8322F, -19.0543F, -52.4952F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(41.8322F, -19.0543F, -52.4952F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(41.8322F, -19.0543F, -52.4952F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(5.5544F, 0.0591F, -20.6729F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(30.7428F, 34.1624F, -8.1206F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-2.0904F, -22.4097F, -2.0675F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(4.2673F, -42.3005F, -4.5662F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(1.7467F, -20.1632F, 0.2029F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(4.5939F, 43.9504F, 11.8732F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(12.0939F, 43.9504F, 11.8732F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-15.5126F, 15.1844F, 1.8678F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-33.3929F, 5.7347F, -9.393F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-33.3929F, 5.7347F, -9.393F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 62.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, 86.62F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-17.3589F, 42.2003F, -7.5391F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(-12.7744F, 22.8399F, -2.7932F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(-6.4978F, -16.721F, 2.6817F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_wing2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, -57.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, -66.69F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -15.67F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, -31.9F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, -56.68F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, -20.18F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(67.4455F, -57.5033F, -78.0484F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(100.104F, -53.6436F, -111.058F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(38.8655F, -29.2877F, -42.038F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_wing2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 25.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, 32.15F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 79.56F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 53.29F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 119.9F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("berserker", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-2.5F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-2.7554F, -24.9722F, 1.2731F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-2.7554F, -24.9722F, 1.2731F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(27.4569F, 0.0478F, -0.4586F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(27.4569F, 0.0478F, -0.4586F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(27.4569F, 0.0478F, -0.4586F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("berserker", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createTranslationalVector(-1.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(-0.39F, -1.71F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, -3.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, -6.0F, -3.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -7.2F, -3.6F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createTranslationalVector(0.0F, -7.2F, -3.6F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(75.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(62.584F, 0.3393F, 0.5387F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(62.584F, 0.3393F, 0.5387F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(50.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(50.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-5.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-6.35F, 22.1953F, -3.8581F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-8.667F, -17.5851F, 0.419F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-14.4971F, -34.769F, 18.328F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-20.8013F, -39.4637F, 20.4874F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-28.6783F, -36.4674F, 29.2144F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(36.5597F, -23.6663F, 4.2462F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(41.5597F, -23.6663F, 4.2462F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(41.5597F, -23.6663F, 4.2462F), Transformation.Interpolations.LINEAR),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_mace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(71.8716F, 2.871F, -2.3881F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(102.1028F, 3.0836F, -2.565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(9.3716F, 2.871F, -2.3881F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-0.6284F, 2.871F, -2.3881F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(12.7975F, 2.871F, -2.3881F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(66.8716F, 2.871F, -2.3881F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(49.3716F, 2.871F, -2.3881F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(56.8716F, 2.871F, -2.3881F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(48.3353F, 1.2726F, -1.0586F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -10.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -10.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -10.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_mace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(23.6491F, 10.7195F, 8.1887F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-4.4F, 30.6689F, 6.6584F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-13.4733F, 40.4269F, 3.9623F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-13.4733F, 40.4269F, 3.9623F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-16.238F, 40.0449F, 3.4609F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-16.238F, 40.0449F, 3.4609F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(5.559F, 7.3687F, 0.374F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation UPPERCUT_LEFT = Animation.Builder.create(3.0F)
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-13.363F, 23.2831F, 19.5113F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-9.7615F, 24.2389F, 25.5981F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-5.2173F, -6.26F, -6.5729F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-7.7173F, -6.26F, -6.5729F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(18.7982F, -4.8598F, 5.9404F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(8.7982F, -4.8598F, 5.9404F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-22.7605F, -4.9064F, -7.2979F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-17.7605F, -4.9064F, -7.2979F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-17.7605F, -4.9064F, -7.2979F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-2.546F, -4.9971F, -12.3222F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-10.046F, -4.9971F, -12.3222F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-35.046F, -4.9971F, -12.3222F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-48.3727F, -16.5066F, -22.8208F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-101.2423F, 8.7081F, -9.4666F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-116.2423F, 8.7081F, -9.4666F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-93.7423F, 8.7081F, -9.4666F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-96.2423F, 8.7081F, -9.4666F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-96.2423F, 8.7081F, -9.4666F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, -25.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-2.5F, -32.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-9.7431F, 19.9612F, -2.11F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-19.1461F, 31.8424F, -6.4413F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-17.0462F, 40.5201F, -3.4486F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-24.5462F, 40.5201F, -3.4486F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(3.3306F, -15.9013F, 18.5191F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(5.8306F, -15.9013F, 18.5191F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(5.8306F, -15.9013F, 18.5191F), Transformation.Interpolations.LINEAR),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_shoulder", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(16.2738F, -43.7995F, 18.9744F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(13.5571F, -50.5619F, 15.3344F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(67.5F, 0.0F, 47.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(23.3174F, 26.0528F, 40.5167F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(36.8322F, 19.0543F, 52.4952F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(36.8322F, 19.0543F, 52.4952F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(-146.2872F, -4.0686F, -15.6979F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(36.8322F, 19.0543F, 52.4952F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(41.8322F, 19.0543F, 52.4952F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(41.8322F, 19.0543F, 52.4952F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(5.5544F, -0.0591F, 20.6729F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(15.65F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(-38.15F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(30.7428F, -34.1624F, 8.1206F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("bow", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("bow", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("halberd", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_shoulder", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(55.0F, 0.0F, -47.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(65.0F, 0.0F, -47.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(67.5F, 0.0F, -47.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(23.3174F, -26.0528F, -40.5167F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-154.8512F, -52.8687F, 10.0425F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-162.3512F, -52.8687F, 10.0425F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(-146.2872F, 4.0686F, 15.6979F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-127.9445F, 28.0422F, 18.0791F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-122.9445F, 28.0422F, 18.0791F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-122.9445F, 28.0422F, 18.0791F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(-71.5454F, 15.6118F, 12.7417F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(15.65F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(-38.15F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(9.19F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-2.0904F, 22.4097F, 2.0675F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(4.2673F, 42.3005F, 4.5662F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(1.7467F, 20.1632F, -0.2029F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(4.5939F, -43.9504F, -11.8732F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(12.0939F, -43.9504F, -11.8732F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-15.5126F, -15.1844F, -1.8678F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-33.3929F, -5.7347F, 9.393F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-33.3929F, -5.7347F, 9.393F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, -12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, 20.18F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(67.4455F, 57.5033F, 78.0484F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(100.104F, 53.6436F, 111.058F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(38.8655F, 29.2877F, 42.038F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_wing2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, -25.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, -32.15F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -79.56F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, -53.29F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, -119.9F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, -62.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, -86.62F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-17.3589F, -42.2003F, 7.5391F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(-12.7744F, -22.8399F, 2.7932F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(-6.4978F, 16.721F, -2.6817F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_wing2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 57.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, 66.69F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 15.67F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 31.9F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 56.68F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("berserker", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-2.5F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-2.7554F, 24.9722F, -1.2731F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-2.7554F, 24.9722F, -1.2731F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(27.4569F, -0.0478F, 0.4586F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(27.4569F, -0.0478F, 0.4586F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(27.4569F, -0.0478F, 0.4586F), Transformation.Interpolations.LINEAR),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("berserker", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createTranslationalVector(1.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.39F, -1.71F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, -3.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, -6.0F, -3.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -7.2F, -3.6F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createTranslationalVector(0.0F, -7.2F, -3.6F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(50.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(50.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(75.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(57.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(62.584F, -0.3393F, -0.5387F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(62.584F, -0.3393F, -0.5387F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(-5.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-6.35F, -22.1953F, 3.8581F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-8.667F, 17.5851F, -0.419F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-14.4971F, 34.769F, -18.328F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-20.8013F, 39.4637F, -20.4874F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-28.6783F, 36.4674F, -29.2144F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(36.5597F, 23.6663F, -4.2462F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(41.5597F, 23.6663F, -4.2462F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(41.5597F, 23.6663F, -4.2462F), Transformation.Interpolations.LINEAR),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 10.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 10.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 10.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_mace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(71.8716F, 2.871F, -2.3881F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(102.1028F, 3.0836F, -2.565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(23.6491F, -10.7195F, -8.1887F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-4.4F, -30.6689F, -6.6584F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-13.4733F, -40.4269F, -3.9623F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(12.7975F, 2.871F, -2.3881F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-13.4733F, -40.4269F, -3.9623F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-16.238F, -40.0449F, -3.4609F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-16.238F, -40.0449F, -3.4609F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(5.559F, -7.3687F, -0.374F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -10.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -10.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -10.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_mace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(71.8716F, -2.871F, 2.3881F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(102.1028F, -3.0836F, 2.565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(23.6491F, 10.7195F, 8.1887F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(9.3716F, -2.871F, 2.3881F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-0.6284F, -2.871F, 2.3881F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(12.7975F, -2.871F, 2.3881F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(66.8716F, -2.871F, 2.3881F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(49.3716F, -2.871F, 2.3881F), Transformation.Interpolations.LINEAR),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(56.8716F, -2.871F, 2.3881F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(48.3353F, -1.2726F, 1.0586F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
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
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(85.8666F, -3.1301F, 72.0988F), Transformation.Interpolations.CUBIC),
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
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("bow", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("bow", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_mace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_mace", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("halberd", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(5.0F, -17.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-13.1017F, -19.9991F, -1.7761F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(17.5351F, 9.2901F, -8.3709F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("halberd", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(6.2624F, -1.9924F, -19.8618F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(4.0684F, 3.3694F, -13.3011F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createTranslationalVector(-0.6666F, -3.1098F, -10.5474F), Transformation.Interpolations.CUBIC),
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
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(-69.0163F, 77.425F, 29.6888F), Transformation.Interpolations.CUBIC),
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
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(13.96F, 3.5333F, 44.8908F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_mace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_mace", new Transformation(Transformation.Targets.SCALE,
                        new Keyframe(0.0F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createScalingVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
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
        
}
