package com.github.l_ender.cataclysm.effects;

import com.github.l_ender.cataclysm.init.ModEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

public class EffectGhostForm extends StatusEffect {

    private int lastDuration = -1;

    public EffectGhostForm() {
        super(StatusEffectCategory.BENEFICIAL, 0x39d2b2);
        this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "FBF4116E-056E-4420-865B-C098705DDAB2", 0.4D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    public void applyUpdateEffect(LivingEntity LivingEntityIn, int amplifier) {
        if (lastDuration == 1) {
            LivingEntityIn.addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTGHOST_SICKNESS, 7200, 0,false,false,true));
        }
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        lastDuration = duration;
        return duration > 0;
    }

}
