package com.github.l_ender.cataclysm.items.CuriosItem;

import com.github.l_ender.cataclysm.init.ModKeybind;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import java.util.List;

public class Sandstorm_In_A_Bottle extends ModTrinketItem {
    private static final SoundInfo SOUND_INFO = new SoundInfo(SoundEvents.ITEM_BOTTLE_FILL_DRAGONBREATH, 1.0F, 1.0F);

    public Sandstorm_In_A_Bottle(net.minecraft.item.Item.Settings group) {
        super(group);

    }

    @Override
    public SoundInfo getEquipSound(ItemStack stack) {
        return SOUND_INFO;
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltips, TooltipType flags) {
        tooltips.add(Text.translatable("item.cataclysm.sandstorm_in_a_bottle.desc",ModKeybind.KEY_ABILITY.getBoundKeyLocalizedText()).formatted(Formatting.DARK_GREEN));
    }

}
