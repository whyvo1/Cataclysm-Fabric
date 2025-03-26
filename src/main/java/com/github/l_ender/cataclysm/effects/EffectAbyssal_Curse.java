package com.github.l_ender.cataclysm.effects;


import com.github.l_ender.cataclysm.util.CMDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectAbyssal_Curse extends StatusEffect {

    public EffectAbyssal_Curse() {
        super(StatusEffectCategory.HARMFUL, 0x8a3eff);
    }

    public void applyUpdateEffect(LivingEntity LivingEntityIn, int amplifier) {
        LivingEntityIn.damage(LivingEntityIn.getDamageSources().create(CMDamageTypes.ABYSSAL_BURN), 1.0F);

    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int k = 50 >> amplifier;
        if (k > 0) {
            return duration % k == 0;
        } else {
            return true;
        }
    }

}
