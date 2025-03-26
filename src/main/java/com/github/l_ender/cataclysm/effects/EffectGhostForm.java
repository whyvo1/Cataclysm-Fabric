package com.github.l_ender.cataclysm.effects;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.init.ModEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.Identifier;

public class EffectGhostForm extends StatusEffect {

    private int lastDuration = -1;
    private static final Identifier GHOST_SPEED = Cataclysm.modIdentifier("ghost_speed");

    public EffectGhostForm() {
        super(StatusEffectCategory.BENEFICIAL, 0x39d2b2);
        this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, GHOST_SPEED, 0.4D, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

    public boolean applyUpdateEffect(LivingEntity LivingEntityIn, int amplifier) {
        if (lastDuration == 1) {
            LivingEntityIn.addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTGHOST_SICKNESS, 7200, 0,false,false,true));
        }
        return true;
    }



    @Override
    public boolean canApplyUpdateEffect(int duration, int p_295734_) {
        lastDuration = duration;
        return duration > 0;
    }

}
