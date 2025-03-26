package com.github.l_ender.cataclysm.client.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class Ancient_Remnant_Power_Animation {

        public static final Animation GROUND_TAIL = Animation.Builder.create(5.5F)
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 247.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2083F, AnimationHelper.createRotationalVector(0.0F, 247.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 142.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 247.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, 247.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 142.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.7083F, AnimationHelper.createRotationalVector(0.0F, 45.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0417F, AnimationHelper.createRotationalVector(0.0F, 45.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.2083F, AnimationHelper.createRotationalVector(0.0F, 200.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(0.0F, 240.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 360.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, -15.0F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, -21.0F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2083F, AnimationHelper.createTranslationalVector(0.0F, -22.5F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -16.06F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, -19.5F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, -13.5F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -15.0F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, -21.0F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, -22.5F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.6667F, AnimationHelper.createTranslationalVector(0.0F, -16.06F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.7083F, AnimationHelper.createTranslationalVector(0.0F, -15.66F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createTranslationalVector(0.0F, -19.5F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createTranslationalVector(0.0F, -19.49F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, -15.0F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createTranslationalVector(0.0F, -15.0F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.7083F, AnimationHelper.createTranslationalVector(0.0F, -19.0F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0417F, AnimationHelper.createTranslationalVector(0.0F, -22.0F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.125F, AnimationHelper.createTranslationalVector(0.0F, -15.0F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.2083F, AnimationHelper.createTranslationalVector(0.0F, -22.0F, 14.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-1.0305F, 11.3731F, -4.9792F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(11.1401F, 15.9523F, -13.4129F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2917F, AnimationHelper.createRotationalVector(-5.1182F, 17.4805F, -0.4565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(-1.0305F, 11.3731F, -4.9792F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(11.1401F, 15.9523F, -13.4129F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.7083F, AnimationHelper.createRotationalVector(-5.1182F, 17.4805F, -0.4565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.75F, AnimationHelper.createRotationalVector(-1.0305F, -11.3731F, 4.9792F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0F, AnimationHelper.createRotationalVector(11.1401F, -15.9523F, 13.4129F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.1667F, AnimationHelper.createRotationalVector(-5.1182F, -17.4805F, 0.4565F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-5.2095F, 18.3667F, -10.7395F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2083F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0833F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4167F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(20.0374F, 4.9239F, 0.8702F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createRotationalVector(22.5428F, 25.56F, 10.2267F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-22.93F, -14.1819F, 6.8405F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(20.0374F, 4.9239F, 0.8702F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5833F, AnimationHelper.createRotationalVector(22.5428F, 25.56F, 10.2267F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(-22.93F, -14.1819F, 6.8405F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.125F, AnimationHelper.createRotationalVector(20.0374F, -4.9239F, -0.8702F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5833F, AnimationHelper.createRotationalVector(20.0374F, -4.9239F, -0.8702F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0417F, AnimationHelper.createRotationalVector(22.5428F, -25.56F, -10.2267F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.2083F, AnimationHelper.createRotationalVector(-23.9777F, -35.5828F, -1.7249F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.3333F, AnimationHelper.createRotationalVector(-12.0373F, 1.8281F, -7.6985F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-26.2347F, 50.6623F, -15.6994F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(13.5485F, -19.0375F, -6.2467F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(15.0628F, 4.768F, 1.5072F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createRotationalVector(15.6436F, 14.1465F, 5.0296F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-7.7319F, 27.2458F, 0.4592F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.9167F, AnimationHelper.createRotationalVector(13.5485F, -19.0375F, -6.2467F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2083F, AnimationHelper.createRotationalVector(15.0628F, 4.768F, 1.5072F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5833F, AnimationHelper.createRotationalVector(15.6436F, 14.1465F, 5.0296F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(-7.7319F, 27.2458F, 0.4592F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.9167F, AnimationHelper.createRotationalVector(13.5485F, 19.0375F, 6.2467F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.375F, AnimationHelper.createRotationalVector(13.5485F, 19.0375F, 6.2467F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.6667F, AnimationHelper.createRotationalVector(15.8864F, -16.4842F, -5.9486F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0417F, AnimationHelper.createRotationalVector(15.6436F, -14.1465F, -5.0296F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.2083F, AnimationHelper.createRotationalVector(-7.7319F, -27.2458F, -0.4592F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.625F, AnimationHelper.createRotationalVector(-7.5881F, 20.2088F, -2.6036F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(25.4901F, -11.5347F, -4.8497F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(32.5193F, 2.3096F, 0.9573F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createRotationalVector(33.3796F, 13.0966F, 7.3407F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(26.2878F, 18.42F, 7.9301F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(25.4901F, -11.5347F, -4.8497F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.3333F, AnimationHelper.createRotationalVector(32.5193F, 2.3096F, 0.9573F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5833F, AnimationHelper.createRotationalVector(33.3796F, 13.0966F, 7.3407F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(26.2878F, 18.42F, 7.9301F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(25.4901F, 11.5347F, 4.8497F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(25.4901F, 11.5347F, 4.8497F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.7917F, AnimationHelper.createRotationalVector(34.5255F, -19.4973F, -11.4161F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0417F, AnimationHelper.createRotationalVector(33.3796F, -13.0966F, -7.3407F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.2083F, AnimationHelper.createRotationalVector(26.2878F, -18.42F, -7.9301F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.7083F, AnimationHelper.createRotationalVector(26.6488F, 20.7045F, 9.0079F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(40.7693F, -13.5663F, -6.4607F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(40.0209F, -2.2656F, -1.0571F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createRotationalVector(40.1891F, 6.7938F, 3.1846F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(30.1886F, 34.2258F, 8.1276F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(40.7693F, -13.5663F, -6.4607F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4167F, AnimationHelper.createRotationalVector(40.0209F, -2.2656F, -1.0571F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5833F, AnimationHelper.createRotationalVector(40.1891F, 6.7938F, 3.1846F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(30.1886F, 34.2258F, 8.1276F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(40.7693F, 13.5663F, 6.4607F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(40.7693F, 13.5663F, 6.4607F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.875F, AnimationHelper.createRotationalVector(47.3122F, -37.7555F, -21.1693F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0417F, AnimationHelper.createRotationalVector(40.1891F, -6.7938F, -3.1846F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.2083F, AnimationHelper.createRotationalVector(30.1886F, -34.2258F, -8.1276F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.75F, AnimationHelper.createRotationalVector(27.7963F, 12.0238F, 3.263F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, -22.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(0.0F, -12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, -22.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.3333F, AnimationHelper.createRotationalVector(0.0F, -12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.7917F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-2.5428F, 22.4976F, -0.118F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, -45.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.1667F, AnimationHelper.createRotationalVector(0.0F, -30.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(0.0F, -45.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.1667F, AnimationHelper.createRotationalVector(0.0F, 30.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.625F, AnimationHelper.createRotationalVector(0.0F, 30.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 45.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(0.0F, 55.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, -42.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, -47.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, -42.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(0.0F, -47.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.7083F, AnimationHelper.createRotationalVector(0.0F, 42.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 47.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(0.0F, 30.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, -35.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, -40.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(0.0F, -35.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(0.0F, -40.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.75F, AnimationHelper.createRotationalVector(0.0F, 35.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 40.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(1.8897F, -20.9171F, -5.1053F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(2.6168F, -25.6234F, -6.9442F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(1.8897F, -20.9171F, -5.1053F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(2.6168F, -25.6234F, -6.9442F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.8333F, AnimationHelper.createRotationalVector(1.8897F, 20.9171F, 5.1053F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0F, AnimationHelper.createRotationalVector(2.6168F, 25.6234F, 6.9442F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(-6.6965F, 9.0817F, 0.9327F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4167F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.875F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2083F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0833F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.2083F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 2.78F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 4.41F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2083F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createTranslationalVector(0.0F, 2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, 2.78F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4167F, AnimationHelper.createTranslationalVector(0.0F, 4.41F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.7083F, AnimationHelper.createTranslationalVector(0.0F, 2.78F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.875F, AnimationHelper.createTranslationalVector(0.0F, 4.41F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0833F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.2083F, AnimationHelper.createTranslationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.1667F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2083F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0833F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.2083F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2083F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(24.6349F, 4.3966F, 0.9631F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(24.6349F, 4.3966F, 0.9631F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(24.6349F, 4.3966F, 0.9631F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(24.6349F, 4.3966F, 0.9631F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0833F, AnimationHelper.createRotationalVector(24.6349F, 4.3966F, 0.9631F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.2083F, AnimationHelper.createRotationalVector(-40.3651F, 4.3966F, 0.9631F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2083F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0833F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.2083F, AnimationHelper.createRotationalVector(-47.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2083F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createTranslationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.7083F, AnimationHelper.createTranslationalVector(0.0F, 2.78F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.875F, AnimationHelper.createTranslationalVector(0.0F, 4.41F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0833F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.2083F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2083F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0833F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.2083F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.1667F, AnimationHelper.createRotationalVector(24.6349F, -4.3966F, -0.9631F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(24.6349F, -4.3966F, -0.9631F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2083F, AnimationHelper.createRotationalVector(24.6349F, -4.3966F, -0.9631F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-40.3651F, -4.3966F, -0.9631F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(24.6349F, -4.3966F, -0.9631F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(24.6349F, -4.3966F, -0.9631F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(24.6349F, -4.3966F, -0.9631F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(-40.3651F, -4.3966F, -0.9631F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.0833F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.2083F, AnimationHelper.createRotationalVector(24.6349F, -4.3966F, -0.9631F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 2.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 2.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("desert_necklace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -15.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(-7.8003F, 1.7088F, -34.9298F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-20.3003F, 1.7088F, -34.9298F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(5.4777F, 21.5095F, 21.8922F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-3.2305F, 26.2805F, 0.6187F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(-0.8492F, 25.3718F, 6.0815F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -15.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.7917F, AnimationHelper.createRotationalVector(-7.8003F, 1.7088F, -34.9298F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-20.3003F, 1.7088F, -34.9298F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2083F, AnimationHelper.createRotationalVector(5.4777F, 21.5095F, 21.8922F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4167F, AnimationHelper.createRotationalVector(-3.2305F, 26.2805F, 0.6187F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.7917F, AnimationHelper.createRotationalVector(-0.8492F, 25.3718F, 6.0815F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(-20.3003F, -1.7088F, 34.9298F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(-20.3003F, -1.7088F, 34.9298F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.6667F, AnimationHelper.createRotationalVector(5.4777F, -21.5095F, -21.8922F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.875F, AnimationHelper.createRotationalVector(-3.2305F, -26.2805F, -0.6187F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.25F, AnimationHelper.createRotationalVector(-0.8492F, -25.3718F, -6.0815F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.5417F, AnimationHelper.createRotationalVector(9.0079F, -10.1846F, -40.083F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.7917F, AnimationHelper.createRotationalVector(-8.8245F, -14.9212F, 33.1423F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.0F, AnimationHelper.createRotationalVector(-3.8376F, -8.8859F, 7.4653F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.1667F, AnimationHelper.createRotationalVector(2.1303F, -6.6663F, 8.3062F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-22.4409F, -0.5405F, -12.4885F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-27.4905F, 0.2177F, 4.9953F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-22.4409F, -0.5405F, -12.4885F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.3333F, AnimationHelper.createRotationalVector(-27.4905F, 0.2177F, 4.9953F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.7917F, AnimationHelper.createRotationalVector(-40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.4167F, AnimationHelper.createRotationalVector(-45.1769F, 6.5026F, 13.5465F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.3333F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.7917F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.3333F, AnimationHelper.createRotationalVector(-40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(-22.4409F, 0.5405F, 12.4885F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(-22.4409F, 0.5405F, 12.4885F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.7917F, AnimationHelper.createRotationalVector(-27.4905F, -0.2177F, -4.9953F), Transformation.Interpolations.CUBIC),
                        new Keyframe(4.4167F, AnimationHelper.createRotationalVector(-35.0554F, 14.5443F, 30.0126F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.3333F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.4583F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.7917F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("legs", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(5.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();


        public static final Animation DOUBLE_STOMP1 = Animation.Builder.create(3.2917F)
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-7.5283F, 4.9571F, -0.6543F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-16.7659F, 7.1712F, 6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-16.7659F, 7.1712F, 6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-16.7659F, 7.1712F, 6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(-16.7659F, 7.1712F, 6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(-16.7659F, 7.1712F, 6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-16.7659F, 7.1712F, 6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 7.98F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, -13.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createTranslationalVector(0.0F, 7.98F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createTranslationalVector(0.0F, -13.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, 20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5833F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(12.5845F, -7.3854F, -1.3099F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(12.6511F, 9.8465F, 1.7541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(12.8453F, 14.7668F, 2.6645F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(12.6511F, 9.8465F, 1.7541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(12.5845F, -7.3854F, -1.3099F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(12.6511F, 9.8465F, 1.7541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(12.8453F, 14.7668F, 2.6645F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.7083F, AnimationHelper.createRotationalVector(12.6511F, 9.8465F, 1.7541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(22.5283F, -4.9571F, -0.6543F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(22.564F, 7.4355F, 0.9845F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(23.4656F, 6.3883F, 8.4656F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.7083F, AnimationHelper.createRotationalVector(22.564F, 7.4355F, 0.9845F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(22.5071F, -2.4786F, -0.3265F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.9583F, AnimationHelper.createRotationalVector(22.5283F, -4.9571F, -0.6543F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(22.564F, 7.4355F, 0.9845F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(23.4656F, 6.3883F, 8.4656F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.8333F, AnimationHelper.createRotationalVector(22.564F, 7.4355F, 0.9845F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(10.1954F, -12.2331F, -3.0628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(10.1954F, -12.2331F, -3.0628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(9.6824F, -18.7622F, -6.5848F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(2.1824F, -18.7622F, -6.5848F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(10.1954F, -12.2331F, -3.0628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(10.1954F, -12.2331F, -3.0628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(9.6824F, -18.7622F, -6.5848F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(2.1824F, -18.7622F, -6.5848F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(7.7939F, 9.4297F, 2.3382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(7.7939F, 9.4297F, 2.3382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(8.2782F, 13.8435F, 4.7372F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(3.2782F, 13.8435F, 4.7372F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.9583F, AnimationHelper.createRotationalVector(7.7939F, 9.4297F, 2.3382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2083F, AnimationHelper.createRotationalVector(7.7939F, 9.4297F, 2.3382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(8.2782F, 13.8435F, 4.7372F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(3.2782F, 13.8435F, 4.7372F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(7.5F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(7.5F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(10.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(15.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(7.5F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(7.5F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(10.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(15.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(10.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(10.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(17.5F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(12.5F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.9583F, AnimationHelper.createRotationalVector(10.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2083F, AnimationHelper.createRotationalVector(10.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(17.5F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(12.5F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(7.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-2.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-2.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(7.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(2.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(7.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-2.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(-2.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(7.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.7083F, AnimationHelper.createRotationalVector(2.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.7083F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.7917F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(5.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(15.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(20.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(5.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0833F, AnimationHelper.createRotationalVector(15.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(20.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(2.4727F, 0.0F, -16.4986F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(17.5426F, -0.6518F, -7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(17.5426F, -0.6518F, -7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(17.5426F, -0.6518F, -7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(5.0426F, -0.6518F, -7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(17.5426F, -0.6518F, -7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(17.5426F, -0.6518F, -7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(17.5426F, -0.6518F, -7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(5.0426F, -0.6518F, -7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -7.56F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createTranslationalVector(0.0F, -7.56F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 10.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-41.9695F, 11.3126F, 15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-49.4695F, 11.3126F, 15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-41.9695F, 11.3126F, 15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(-41.9695F, 11.3126F, 15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(-49.4695F, 11.3126F, 15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-41.9695F, 11.3126F, 15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -7.56F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, -13.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createTranslationalVector(0.0F, -7.56F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, -13.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(50.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(50.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(10.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(10.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(10.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(15.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(10.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
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
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(-6.5031F, -8.8885F, -8.1639F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(-3.1996F, -20.1106F, -9.1344F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-3.1996F, -20.1106F, -9.1344F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-15.2431F, -18.8432F, -8.3521F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.9167F, AnimationHelper.createRotationalVector(-8.1464F, -13.5682F, 1.9785F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0833F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(28.57F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(2.5F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(12.9091F, -19.093F, 21.8124F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(23.3833F, -21.6324F, 16.3077F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-5.6651F, -4.4643F, 11.9382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(2.5F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0833F, AnimationHelper.createRotationalVector(12.9091F, -19.093F, 21.8124F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(23.3833F, -21.6324F, 16.3077F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-5.6651F, -4.4643F, 11.9382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(1.204F, -2.0076F, 8.4318F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(21.92F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("legs", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation DOUBLE_STOMP2 = Animation.Builder.create(3.2917F)
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-7.5283F, -4.9571F, 0.6543F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-16.7659F, -7.1712F, -6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-16.7659F, -7.1712F, -6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-16.7659F, -7.1712F, -6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(-16.7659F, -7.1712F, -6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(-16.7659F, -7.1712F, -6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-16.7659F, -7.1712F, -6.5523F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 7.98F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, -13.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createTranslationalVector(0.0F, 7.98F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createTranslationalVector(0.0F, -13.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5833F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.75F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(12.5845F, 7.3854F, 1.3099F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(12.6511F, -9.8465F, -1.7541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(12.8453F, -14.7668F, -2.6645F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(12.6511F, -9.8465F, -1.7541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(12.5845F, 7.3854F, 1.3099F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(12.6511F, -9.8465F, -1.7541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(12.8453F, -14.7668F, -2.6645F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.7083F, AnimationHelper.createRotationalVector(12.6511F, -9.8465F, -1.7541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(22.5283F, 4.9571F, 0.6543F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(22.564F, -7.4355F, -0.9845F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(23.4656F, -6.3883F, -8.4656F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.7083F, AnimationHelper.createRotationalVector(22.564F, -7.4355F, -0.9845F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(22.5071F, 2.4786F, 0.3265F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.9583F, AnimationHelper.createRotationalVector(22.5283F, 4.9571F, 0.6543F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(22.564F, -7.4355F, -0.9845F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(23.4656F, -6.3883F, -8.4656F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.8333F, AnimationHelper.createRotationalVector(22.564F, -7.4355F, -0.9845F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(10.1954F, 12.2331F, 3.0628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(10.1954F, 12.2331F, 3.0628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(9.6824F, 18.7622F, 6.5848F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(2.1824F, 18.7622F, 6.5848F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(10.1954F, 12.2331F, 3.0628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(10.1954F, 12.2331F, 3.0628F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(9.6824F, 18.7622F, 6.5848F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(2.1824F, 18.7622F, 6.5848F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(7.7939F, -9.4297F, -2.3382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(7.7939F, -9.4297F, -2.3382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(8.2782F, -13.8435F, -4.7372F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(3.2782F, -13.8435F, -4.7372F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.9583F, AnimationHelper.createRotationalVector(7.7939F, -9.4297F, -2.3382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2083F, AnimationHelper.createRotationalVector(7.7939F, -9.4297F, -2.3382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(8.2782F, -13.8435F, -4.7372F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(3.2782F, -13.8435F, -4.7372F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(7.5F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(7.5F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(10.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(15.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(7.5F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(7.5F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(10.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(15.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(10.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(10.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(17.5F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(12.5F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.9583F, AnimationHelper.createRotationalVector(10.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2083F, AnimationHelper.createRotationalVector(10.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(17.5F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(12.5F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(7.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-2.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-2.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(7.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(2.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(7.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-2.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(-2.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(7.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.7083F, AnimationHelper.createRotationalVector(2.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7083F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5833F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.6667F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.7083F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.7917F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(12.9091F, 19.093F, -21.8124F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(23.3833F, 21.6324F, -16.3077F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-5.6651F, 4.4643F, -11.9382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0833F, AnimationHelper.createRotationalVector(12.9091F, 19.093F, -21.8124F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(23.3833F, 21.6324F, -16.3077F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-5.6651F, 4.4643F, -11.9382F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(1.204F, 2.0076F, -8.4318F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -10.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-41.9695F, -11.3126F, -15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-49.4695F, -11.3126F, -15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-41.9695F, -11.3126F, -15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(-41.9695F, -11.3126F, -15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(-49.4695F, -11.3126F, -15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-41.9695F, -11.3126F, -15.3525F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -7.56F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, -13.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createTranslationalVector(0.0F, -7.56F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, -13.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(50.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(50.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(17.5426F, 0.6518F, 7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(17.5426F, 0.6518F, 7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(17.5426F, 0.6518F, 7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(5.0426F, 0.6518F, 7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(17.5426F, 0.6518F, 7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(17.5426F, 0.6518F, 7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(17.5426F, 0.6518F, 7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(5.0426F, 0.6518F, 7.4718F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -7.56F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createTranslationalVector(0.0F, -7.56F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(42.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(0.0F, 10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
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
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(-6.5031F, 8.8885F, 8.1639F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(-3.1996F, 20.1106F, 9.1344F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-3.1996F, 20.1106F, 9.1344F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-15.2431F, 18.8432F, 8.3521F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.9167F, AnimationHelper.createRotationalVector(-8.1464F, 13.5682F, -1.9785F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0833F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(21.92F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0833F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(2.4727F, 0.0F, 16.4986F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.625F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0833F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.375F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5417F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(28.57F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_hand", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("legs", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_finger3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation TAIL_SWING = Animation.Builder.create(2.875F)
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("roots", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -1.4F, 5.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 50.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-5.0F, -100.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(-5.0F, -200.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(-5.0F, -250.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, -360.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createTranslationalVector(-2.0F, -17.0F, 10.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createTranslationalVector(-2.0F, 5.0F, 10.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createTranslationalVector(-2.0F, -8.0F, 10.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createTranslationalVector(-2.0F, -15.0F, 10.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createTranslationalVector(-1.31F, -8.33F, 6.54F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-22.5F, 40.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-35.6958F, -17.8843F, 24.9374F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(-23.035F, -47.1836F, -10.5322F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(-8.035F, -47.1836F, -10.5322F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 30.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(-15.0F, -32.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(-18.0749F, -49.6579F, 4.6258F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(13.3054F, 22.1398F, 4.1148F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(27.5353F, 8.2986F, 6.6938F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(10.6111F, -14.3644F, -3.9456F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(12.3028F, -36.5991F, -7.8029F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(23.4424F, 27.2451F, 3.8871F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(27.1227F, 2.1184F, 2.4098F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(21.1431F, -27.1617F, -4.3679F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(21.4556F, -32.1316F, -4.9989F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(2.3695F, -7.5112F, 0.5456F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(2.3693F, 7.4761F, 1.164F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(2.2784F, 12.8294F, 11.3182F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, -12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 40.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(7.4509F, -14.6011F, -13.5701F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(6.5965F, -0.9402F, -7.3016F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(16.5965F, -0.9402F, -7.3016F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(20.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("desert_necklace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4167F, AnimationHelper.createRotationalVector(-2.5F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-7.5189F, -0.4354F, -2.5189F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-14.859F, 0.9847F, 29.9512F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-30.0542F, -0.1033F, 4.9738F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.7917F, AnimationHelper.createRotationalVector(-8.1277F, -8.0971F, -21.4293F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createRotationalVector(-4.7925F, -8.9086F, 21.5589F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -10.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(17.5F, 0.0F, -10.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(5.8405F, -7.8983F, 3.246F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -2.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 17.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(21.1509F, 11.7219F, 4.4137F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-14.1811F, -22.7877F, -21.299F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -32.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(-27.5F, 0.0F, -32.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-37.5073F, 0.0F, -21.2646F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 6.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, -0.42F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, 4.69F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(34.3071F, -16.8853F, 4.6658F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(29.3071F, -16.8853F, 4.6658F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(44.3071F, -16.8853F, 4.6658F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(45.0886F, -11.048F, 3.0528F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(-9.5459F, 2.9932F, 17.25F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(3.7389F, 1.3381F, 7.7116F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-29.9672F, 22.8842F, 6.7808F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(-19.3161F, -8.4082F, -9.2829F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(-37.4515F, 9.0826F, -7.19F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-23.5139F, 18.2563F, 5.8876F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -12.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(2.5F, 0.0F, -12.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(2.4149F, -0.6469F, 2.4864F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();




        public static final Animation MONOLITH = Animation.Builder.create(3.5F)
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -27.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("mid_pivot", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, -14.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.7083F, AnimationHelper.createTranslationalVector(0.0F, -15.77F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -11.9F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.3333F, AnimationHelper.createTranslationalVector(0.0F, -9.6F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, -6.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-22.6511F, 9.8465F, -1.7541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-14.9403F, -0.1053F, -0.5307F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.6667F, AnimationHelper.createRotationalVector(-20.2076F, 6.5683F, -1.8677F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-11.5292F, -1.1058F, -3.2816F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(-3.9058F, 33.1501F, -10.7307F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-2.5082F, 4.238F, -3.0406F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-7.3071F, -32.7396F, 3.7302F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(11.1737F, -21.6934F, -6.1199F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(10.3472F, -12.0674F, -3.2844F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(10.0547F, 4.8292F, 1.2973F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.4583F, AnimationHelper.createRotationalVector(10.5041F, -14.4774F, -3.9676F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail3", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(0.0F, -27.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.7917F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.1667F, AnimationHelper.createRotationalVector(0.0F, -19.08F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.7083F, AnimationHelper.createRotationalVector(0.0F, -22.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail4", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, -32.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(17.5F, -42.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(17.2487F, 34.9521F, 2.9782F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.125F, AnimationHelper.createRotationalVector(16.9951F, -22.5149F, 0.9253F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(15.5041F, -14.4775F, -3.9671F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-30.7109F, 13.8345F, -5.8546F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-23.2109F, -13.8345F, 5.8546F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.7083F, AnimationHelper.createRotationalVector(-4.5821F, -25.3144F, -2.7043F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("spine2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(15.1027F, -4.0939F, -2.8729F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0833F, AnimationHelper.createRotationalVector(-32.9263F, 14.6365F, -3.3186F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createRotationalVector(-49.0315F, 15.217F, 3.2531F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.25F, AnimationHelper.createRotationalVector(-38.867F, -7.4431F, 7.0079F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(-4.201F, -3.9804F, 2.8831F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck1", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(52.9225F, -28.0827F, -10.8652F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(15.0628F, 4.768F, 1.5072F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(14.3119F, 21.99F, -1.7004F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(15.0894F, 2.3054F, 1.9387F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.3333F, AnimationHelper.createRotationalVector(14.9083F, 10.9216F, 0.4063F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.8333F, AnimationHelper.createRotationalVector(20.08F, 4.8243F, 1.9407F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("neck2", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -27.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.125F, AnimationHelper.createRotationalVector(-25.2218F, 9.6956F, -1.7328F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(-30.1853F, -9.0967F, 5.1429F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-26.129F, 19.0549F, -5.3733F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.3333F, AnimationHelper.createRotationalVector(-25.9168F, 8.4815F, -1.3944F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.8333F, AnimationHelper.createRotationalVector(-25.5938F, 14.3822F, -3.5148F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(7.5F, -45.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.375F, AnimationHelper.createRotationalVector(-15.0F, -10.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-19.7248F, -27.4818F, -0.8465F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-19.481F, 4.9975F, -2.0473F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.3333F, AnimationHelper.createRotationalVector(-19.6F, -11.24F, -1.45F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(-19.7248F, -27.4818F, -0.8465F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.2083F, AnimationHelper.createRotationalVector(7.0519F, -8.1387F, -0.213F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2083F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.3333F, AnimationHelper.createRotationalVector(52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(60.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(12.9091F, 19.093F, -26.8124F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(25.41F, 19.09F, -26.81F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(20.7054F, -1.0683F, -1.5134F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.4829F, 6.0539F, -11.6932F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(3.8619F, 4.124F, -7.7131F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(34.72F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(1.83F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(11.27F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(12.9091F, -19.093F, 26.8124F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(14.9036F, -26.667F, 40.8821F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(23.4774F, -24.5937F, 35.5715F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(19.2128F, 0.85F, 1.3685F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(16.192F, 2.3039F, -1.5949F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_arm", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.125F, AnimationHelper.createRotationalVector(-3.89F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.625F, AnimationHelper.createRotationalVector(-14.52F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(10.56F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-64.0365F, -11.8491F, -9.2643F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-20.4533F, -10.5831F, -0.4213F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-34.705F, -24.4144F, 2.4781F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-34.705F, -24.4144F, 2.4781F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(52.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(-20.4533F, 10.5831F, 0.4213F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-34.705F, 24.4144F, -2.4781F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(-34.705F, 24.4144F, -2.4781F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.875F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(35.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("desert_necklace", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.375F, AnimationHelper.createRotationalVector(-51.8247F, 7.9969F, 9.6387F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-17.6164F, 9.2054F, 43.5366F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(32.6075F, -3.2114F, -3.8343F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.2917F, AnimationHelper.createRotationalVector(-1.8998F, -0.0417F, -21.0541F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5417F, AnimationHelper.createRotationalVector(45.5876F, -3.0358F, -6.3416F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.875F, AnimationHelper.createRotationalVector(61.447F, -5.7087F, 11.0027F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.3333F, AnimationHelper.createRotationalVector(56.1971F, 5.5344F, -12.9842F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.8333F, AnimationHelper.createRotationalVector(34.7117F, 11.3033F, -4.476F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.25F, AnimationHelper.createRotationalVector(2.2117F, 11.3033F, -4.476F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ankel_joint", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_foot", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();
}
