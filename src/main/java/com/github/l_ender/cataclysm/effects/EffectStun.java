package com.github.l_ender.cataclysm.effects;

import com.github.l_ender.cataclysm.Cataclysm;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;

public class EffectStun extends StatusEffect {

    private static final Identifier STUN_SPEED = Cataclysm.modIdentifier("stun_speed");

    public EffectStun() {
        super(StatusEffectCategory.HARMFUL, 0xFF8C00);
        this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, STUN_SPEED, -0.5D, EntityAttributeModifier.Operation.ADD_VALUE);

    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        return true;
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration > 0;
    }

}
