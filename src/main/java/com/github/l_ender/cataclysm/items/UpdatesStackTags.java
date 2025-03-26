package com.github.l_ender.cataclysm.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public interface UpdatesStackTags {

    default void updateTagFromServer(Entity holder, ItemStack stack, NbtCompound tag){
        stack.setNbt(tag);
    }
}
