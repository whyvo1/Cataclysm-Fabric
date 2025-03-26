package com.github.l_ender.cataclysm.items.CuriosItem;

import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import java.util.List;

public class Blazing_Grips extends ModTrinketItem {
    private static final SoundInfo SOUND_INFO = new SoundInfo(SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE.value(), 1.0F, 1.0F);

    public Blazing_Grips(net.minecraft.item.Item.Settings group) {
        super(group);

    }

    @Override
    public SoundInfo getEquipSound(ItemStack stack) {
        return SOUND_INFO;
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltips, TooltipType flags) {
        tooltips.add(Text.translatable("item.cataclysm.blazing_grips.desc").formatted(Formatting.DARK_GREEN));
    }

}
