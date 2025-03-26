package com.github.l_ender.cataclysm.effects;

import java.util.List;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.item.ItemStack;

public class EffectGhost_Sickness extends StatusEffect {

    public EffectGhost_Sickness() {
        super(StatusEffectCategory.HARMFUL, 0x945b31);
    }

    public void applyUpdateEffect(LivingEntity LivingEntityIn, int amplifier) {
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int k = 50 >> amplifier;
        if (k > 0) {
            return duration % k == 0;
        } else {
            return true;
        }
    }

    public List<ItemStack> getCurativeItems() {
        return List.of();
    }

}
