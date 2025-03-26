package com.github.l_ender.lionfishapi.client.model.AdvancedAnimations;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.Vector3f;

@Environment(value= EnvType.CLIENT)
public record AdvancedKeyframe(float timestamp, Vector3f target, AdvancedAnimationChannel.Interpolation interpolation) {
}
