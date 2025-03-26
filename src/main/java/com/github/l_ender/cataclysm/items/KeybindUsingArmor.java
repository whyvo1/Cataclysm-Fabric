package com.github.l_ender.cataclysm.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public interface KeybindUsingArmor {
    void onKeyPacket(PlayerEntity keyPresser, ItemStack itemStack, int type);
}
