package com.github.l_ender.cataclysm.client.animation;// Save this class in your mod and generate all required imports

import com.github.l_ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationChannel;
import com.github.l_ender.lionfishapi.client.model.AdvancedAnimations.AdvancedAnimationDefinition;
import com.github.l_ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframe;
import com.github.l_ender.lionfishapi.client.model.AdvancedAnimations.AdvancedKeyframeAnimations;


public class Axe_blade_Animation {
	public static final AdvancedAnimationDefinition IDLE = AdvancedAnimationDefinition.Builder.withLength(0.5F).looping()
			.addAnimation("blade", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.posVec(0.2762F, 0.0F, 0.0F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("blade", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0102F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("vfx", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE,
					new AdvancedKeyframe(0.0F, AdvancedKeyframeAnimations.scaleVec(1.0F, 1.0F, 1.2628F), AdvancedAnimationChannel.Interpolations.LINEAR)
			))
			.build();
}