package com.github.l_ender.cataclysm.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import java.util.List;

public class Necklace_Of_The_Desert extends Item {

    public Necklace_Of_The_Desert(net.minecraft.item.Item.Settings group) {
        super(group);

    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType flags) {
        tooltip.add(Text.translatable("item.cataclysm.necklace_of_the_desert.desc").formatted(Formatting.DARK_GREEN));
    }
}

