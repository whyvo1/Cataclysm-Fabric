package com.github.l_ender.cataclysm.effects;


import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectCurse_Of_Desert extends StatusEffect {

    public EffectCurse_Of_Desert() {
        super(StatusEffectCategory.HARMFUL, 0xfff2cb);
    }


    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration > 0;
    }
}
