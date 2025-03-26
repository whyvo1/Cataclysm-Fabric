package com.github.l_ender.cataclysm.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public interface ModShieldDisable {
    boolean canDisableShield(ItemStack stack, LivingEntity attacker);
}
