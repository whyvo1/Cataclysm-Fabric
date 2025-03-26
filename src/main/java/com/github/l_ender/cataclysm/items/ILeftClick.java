package com.github.l_ender.cataclysm.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public interface ILeftClick {

    boolean onLeftClick(ItemStack stack, LivingEntity playerIn);
}
