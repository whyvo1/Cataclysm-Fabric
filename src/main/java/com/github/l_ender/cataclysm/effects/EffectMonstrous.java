package com.github.l_ender.cataclysm.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectMonstrous extends StatusEffect {

    public EffectMonstrous() {
        super(StatusEffectCategory.BENEFICIAL, 0X865337);
        this.addAttributeModifier(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, "953533ED-0994-4421-9E4E-47557FA8EE2A", 0.5D, EntityAttributeModifier.Operation.ADDITION);
        this.addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "E6C06C84-8021-4296-A512-AFB0C98806CA", 3.0D, EntityAttributeModifier.Operation.ADDITION);
        this.addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "1F329CAC-F59E-41C1-A5E6-18A45A3237B8", 2.0D, EntityAttributeModifier.Operation.ADDITION);
    }

    public void applyUpdateEffect(LivingEntity LivingEntityIn, int amplifier) {
        if (LivingEntityIn.getHealth() < LivingEntityIn.getMaxHealth() * 1/2) {
            LivingEntityIn.heal(1.0F);
        }

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
