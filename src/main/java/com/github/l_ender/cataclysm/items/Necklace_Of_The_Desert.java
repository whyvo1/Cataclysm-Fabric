package com.github.l_ender.cataclysm.items;

import org.jetbrains.annotations.Nullable;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import java.util.List;

public class Necklace_Of_The_Desert extends Item {

    public Necklace_Of_The_Desert(Settings group) {
        super(group);

    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.necklace_of_the_desert.desc").formatted(Formatting.DARK_GREEN));
    }
}

