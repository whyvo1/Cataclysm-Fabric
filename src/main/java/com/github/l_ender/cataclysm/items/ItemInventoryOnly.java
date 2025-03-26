package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.util.CustomTabBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemInventoryOnly extends Item implements CustomTabBehavior {

    public ItemInventoryOnly(Settings properties) {
        super(properties);
    }

    @Override
    public void fillItemCategory(ItemGroup.Entries contents) {

    }
}
