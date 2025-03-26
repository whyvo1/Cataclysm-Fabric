package com.github.l_ender.cataclysm.items.CuriosItem;

import net.minecraft.sound.SoundEvent;
import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import java.util.List;

public class Sticky_Gloves extends ModTrinketItem {
    private static final SoundInfo SOUND_INFO = new SoundInfo(SoundEvents.ENTITY_SLIME_SQUISH, 1.0F, 1.0F);

    public Sticky_Gloves(Settings group) {
        super(group);
    }

    @Override
    public SoundInfo getEquipSound() {
        return SOUND_INFO;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.sticky_gloves.desc").formatted(Formatting.DARK_GREEN));
    }

}
