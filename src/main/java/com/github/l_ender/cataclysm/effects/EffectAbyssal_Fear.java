package com.github.l_ender.cataclysm.effects;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectAbyssal_Fear extends StatusEffect {

    public EffectAbyssal_Fear() {
        super(StatusEffectCategory.HARMFUL, 0x741aff);
    }

    public boolean applyUpdateEffect(LivingEntity LivingEntityIn, int amplifier) {

        return true;
    }


    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration > 0;
    }

}
