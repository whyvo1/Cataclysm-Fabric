package com.github.l_ender.cataclysm.items;

import net.minecraft.block.Block;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;

public class CMBlockItem extends BlockItem {

    public CMBlockItem(Block block, Item.Settings settings) {
        super(block, settings);
    }

    public void onItemEntityDestroyed(ItemEntity p_150700_) {
        if (this.getBlock() instanceof ShulkerBoxBlock) {
            ItemStack itemstack = p_150700_.getStack();
            NbtCompound compoundtag = getBlockEntityNbt(itemstack);
            if (compoundtag != null && compoundtag.contains("Items", 9)) {
                NbtList listtag = compoundtag.getList("Items", 10);
                ItemUsage.spawnItemContents(p_150700_, listtag.stream().map(NbtCompound.class::cast).map(ItemStack::fromNbt));
            }
        }
    }

}
