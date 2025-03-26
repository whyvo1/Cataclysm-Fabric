package com.github.l_ender.cataclysm.items;

import org.jetbrains.annotations.Nullable;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class Blessed_Amethyst_Crab_Meat extends Item {
    public Blessed_Amethyst_Crab_Meat(Item.Settings p_41170_) {
        super(p_41170_);
    }

    public boolean hasGlint(ItemStack p_41172_) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.blessed_amethyst_crab_meat.desc").formatted(Formatting.DARK_GREEN));
    }

}