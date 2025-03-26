package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.util.CustomTabBehavior;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;

public class BlockItemInventoryOnly extends BlockItem implements CustomTabBehavior {

    public BlockItemInventoryOnly(Block p_40565_, net.minecraft.item.Item.Settings p_40566_) {
        super(p_40565_,p_40566_);
    }

    @Override
    public void fillItemCategory(ItemGroup.Entries contents) {

    }
}
