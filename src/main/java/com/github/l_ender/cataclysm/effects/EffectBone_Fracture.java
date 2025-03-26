package com.github.l_ender.cataclysm.effects;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectBone_Fracture extends StatusEffect {

    public EffectBone_Fracture() {
        super(StatusEffectCategory.HARMFUL, 0xadabad);
        this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "AEB87FD5-A4E9-4BA8-A52C-38BBE582D491", -0.02D, EntityAttributeModifier.Operation.ADDITION);
        this.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "804053B1-7703-4E67-AB0E-FC53D5A2CE10", -0.15D, EntityAttributeModifier.Operation.ADDITION);
    }

    public void applyUpdateEffect(LivingEntity LivingEntityIn, int amplifier) {

    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration > 0;
    }

}
