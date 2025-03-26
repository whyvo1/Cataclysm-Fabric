package com.github.l_ender.cataclysm.effects;

import com.github.l_ender.cataclysm.init.ModEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;

public class EffectBlessing_Of_Amethyst extends StatusEffect {

    public EffectBlessing_Of_Amethyst() {
        super(StatusEffectCategory.BENEFICIAL, 0xfecbe6);
    }

    public void applyUpdateEffect(LivingEntity LivingEntityIn, int amplifier) {
        if(LivingEntityIn.hasStatusEffect(ModEffect.EFFECTABYSSAL_BURN)){
            LivingEntityIn.removeStatusEffect(ModEffect.EFFECTABYSSAL_BURN);
        }
        if(LivingEntityIn.hasStatusEffect(ModEffect.EFFECTABYSSAL_FEAR)){
            LivingEntityIn.removeStatusEffect(ModEffect.EFFECTABYSSAL_FEAR);
        }
        if(LivingEntityIn.hasStatusEffect(StatusEffects.DARKNESS)){
            LivingEntityIn.removeStatusEffect(StatusEffects.DARKNESS);
        }
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration > 0;
    }

}
