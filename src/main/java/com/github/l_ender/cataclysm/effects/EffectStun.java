package com.github.l_ender.cataclysm.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectStun extends StatusEffect {

    public EffectStun() {
        super(StatusEffectCategory.HARMFUL, 0xFF8C00);
        this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "57F1BADC-F545-4D89-B218-751C2FF8053D", -0.5D, EntityAttributeModifier.Operation.ADDITION);

    }

    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration > 0;
    }

}
