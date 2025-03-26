package com.github.l_ender.cataclysm.effects;


import com.github.l_ender.cataclysm.util.CMDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectAbyssal_Curse extends StatusEffect {

    public EffectAbyssal_Curse() {
        super(StatusEffectCategory.HARMFUL, 0x8a3eff);
    }

    public boolean applyUpdateEffect(LivingEntity LivingEntityIn, int amplifier) {
        LivingEntityIn.damage(LivingEntityIn.getDamageSources().create(CMDamageTypes.ABYSSAL_BURN), 1.0F);
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int p_295629_, int p_295734_) {
        int i = 40 >> p_295734_;
        return i <= 0 || p_295629_ % i == 0;
    }
}
