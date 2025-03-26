package com.github.l_ender.cataclysm.effects;


import com.github.l_ender.cataclysm.Cataclysm;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;

public class EffectBlazing_Brand extends StatusEffect {

    private static final Identifier ARMOR_DOWN_ID = Cataclysm.modIdentifier("blazing_brand_armor");
    private static final Identifier ARMOR_TOUGHNESS_DOWN_ID = Cataclysm.modIdentifier("blazing_brand_armor_toughness");
    public EffectBlazing_Brand() {
        super(StatusEffectCategory.HARMFUL, 0xDC143C);
        this.addAttributeModifier(EntityAttributes.GENERIC_ARMOR, ARMOR_DOWN_ID, -0.2D, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, ARMOR_TOUGHNESS_DOWN_ID, -0.2D, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

    public boolean applyUpdateEffect(LivingEntity LivingEntityIn, int amplifier) {

        return true;
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration > 0;
    }

}
