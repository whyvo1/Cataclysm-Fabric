package com.github.l_ender.cataclysm.effects;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectBlazing_Brand extends StatusEffect {

    public EffectBlazing_Brand() {
        super(StatusEffectCategory.HARMFUL, 0xDC143C);
        this.addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "68078724-8653-42D5-A245-9D14A1F54685", -0.2D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        this.addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "B237E76D-15E8-4513-A735-55BB25C33603", -0.2D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    public void applyUpdateEffect(LivingEntity LivingEntityIn, int amplifier) {

    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration > 0;
    }

}
