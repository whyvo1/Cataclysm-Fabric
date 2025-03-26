package com.github.l_ender.cataclysm.effects;

import com.github.l_ender.cataclysm.Cataclysm;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;

public class EffectMonstrous extends StatusEffect {

    private static final Identifier MONSTROUS_KNOCKBACK = Cataclysm.modIdentifier("monstrous_knockback");
    private static final Identifier MONSTROUS_ARMOR = Cataclysm.modIdentifier("monstrous_armor");
    private static final Identifier MONSTROUS_ARMOR_TOUGHNESS = Cataclysm.modIdentifier("monstrous_armor_toughness");

    public EffectMonstrous() {
        super(StatusEffectCategory.BENEFICIAL, 0X865337);
        this.addAttributeModifier(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, MONSTROUS_KNOCKBACK, 0.5D, EntityAttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(EntityAttributes.GENERIC_ARMOR, MONSTROUS_ARMOR, 3.0D, EntityAttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, MONSTROUS_ARMOR_TOUGHNESS, 2.0D, EntityAttributeModifier.Operation.ADD_VALUE);
    }

    public boolean applyUpdateEffect(LivingEntity LivingEntityIn, int amplifier) {
        if (LivingEntityIn.getHealth() < LivingEntityIn.getMaxHealth() * 1/2) {
            LivingEntityIn.heal(1.0F);
        }

        return true;
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
