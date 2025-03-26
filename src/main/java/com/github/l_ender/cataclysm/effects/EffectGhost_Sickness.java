package com.github.l_ender.cataclysm.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectGhost_Sickness extends StatusEffect {

    public EffectGhost_Sickness() {
        super(StatusEffectCategory.HARMFUL, 0x945b31);
    }

    public boolean applyUpdateEffect(LivingEntity LivingEntityIn, int amplifier) {
        return true;
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int k = 50 >> amplifier;
        if (k > 0) {
            return duration % k == 0;
        } else {
            return true;
        }
    }

//    public Set<EffectCure> getCures() {
//        return null;
//    }

}
