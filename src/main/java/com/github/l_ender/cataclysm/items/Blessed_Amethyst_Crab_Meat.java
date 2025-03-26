package com.github.l_ender.cataclysm.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import java.util.List;

public class Blessed_Amethyst_Crab_Meat extends Item {
    public Blessed_Amethyst_Crab_Meat(net.minecraft.item.Item.Settings p_41170_) {
        super(p_41170_);
    }

    public boolean hasGlint(ItemStack p_41172_) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltips, TooltipType flags) {
        tooltips.add(Text.translatable("item.cataclysm.blessed_amethyst_crab_meat.desc").formatted(Formatting.DARK_GREEN));
    }

}