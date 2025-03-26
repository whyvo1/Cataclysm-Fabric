package com.github.l_ender.cataclysm.effects;


import com.github.l_ender.cataclysm.Cataclysm;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;

public class EffectBone_Fracture extends StatusEffect {

    private static final Identifier BONE_FRACTURE_SPEED = Cataclysm.modIdentifier("bone_fracture_speed");
    private static final Identifier BONE_FRACTURE_ATTACK_SPEED = Cataclysm.modIdentifier("bone_fracture_attack_speed");

    public EffectBone_Fracture() {
        super(StatusEffectCategory.HARMFUL, 0xadabad);
        this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, BONE_FRACTURE_SPEED, -0.02D, EntityAttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, BONE_FRACTURE_ATTACK_SPEED, -0.15D, EntityAttributeModifier.Operation.ADD_VALUE);
    }

    public boolean applyUpdateEffect(LivingEntity LivingEntityIn, int amplifier) {
        return true;
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration > 0;
    }

}
