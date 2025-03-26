package com.github.l_ender.cataclysm.items;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

public interface ModEnchantable {
    boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment);
}
