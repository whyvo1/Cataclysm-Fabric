package com.github.l_ender.lionfishapi.client.model.AdvancedAnimations;

import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.apache.commons.compress.utils.Lists;

import java.util.List;
import java.util.Map;

@Environment(value= EnvType.CLIENT)
public record AdvancedAnimationDefinition(float lengthInSeconds, boolean looping, Map<String, List<AdvancedAnimationChannel>> boneAnimations) {
    @Environment(value= EnvType.CLIENT)
    public static class Builder {
        private final float length;
        private final Map<String, List<AdvancedAnimationChannel>> animationByBone = Maps.newHashMap();
        private boolean looping;

        public static Builder withLength(float p_232276_) {
            return new Builder(p_232276_);
        }

        private Builder(float p_232273_) {
            this.length = p_232273_;
        }

        public Builder looping() {
            this.looping = true;
            return this;
        }

        public Builder addAnimation(String p_232280_, AdvancedAnimationChannel p_232281_) {
            this.animationByBone.computeIfAbsent(p_232280_, (p_232278_) -> {
                return Lists.newArrayList();
            }).add(p_232281_);
            return this;
        }

        public AdvancedAnimationDefinition build() {
            return new AdvancedAnimationDefinition(this.length, this.looping, this.animationByBone);
        }
    }
}
