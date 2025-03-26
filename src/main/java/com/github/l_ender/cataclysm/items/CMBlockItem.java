package com.github.l_ender.cataclysm.items;

import net.minecraft.block.Block;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class CMBlockItem extends BlockItem {

    public CMBlockItem(Block block, Item.Settings settings) {
        super(block, settings);
    }

    public void onItemEntityDestroyed(ItemEntity p_150700_) {
        super.onItemEntityDestroyed(p_150700_);
    }

}
