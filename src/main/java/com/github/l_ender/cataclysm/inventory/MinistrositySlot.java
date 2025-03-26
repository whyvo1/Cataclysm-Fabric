package com.github.l_ender.cataclysm.inventory;

import com.github.l_ender.cataclysm.init.ModTag;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class MinistrositySlot extends Slot {
    public MinistrositySlot(Inventory p_40223_, int p_40224_, int p_40225_, int p_40226_) {
        super(p_40223_, p_40224_, p_40225_, p_40226_);
    }


    public boolean canInsert(ItemStack stack) {
        return !stack.isIn(ModTag.MINISTROSITY_BLACKLIST);
    }
}
