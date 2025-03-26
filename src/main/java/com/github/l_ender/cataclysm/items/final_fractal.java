package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.util.CustomTabBehavior;
import org.jetbrains.annotations.Nullable;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import java.util.List;

public class final_fractal extends SwordItem implements CustomTabBehavior {

    public final_fractal(ModItemTier toolMaterial, Settings props) {
        super(toolMaterial, 3, -2.4f, props);
    }
    
    @Override
    public boolean canRepair(ItemStack itemStack, ItemStack itemStackMaterial) {
        return false;
    }

//    @Override
//    public void setDamage(ItemStack stack, int damage){
//        super.setDamage(stack, 0);
//    }

    @Override
    public boolean isDamageable() {
        return false;
    }

//    @Override
//    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
//        return enchantment.target != EnchantmentTarget.BREAKABLE && enchantment.target == EnchantmentTarget.WEAPON;
//    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.final_fractal.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.wip.desc").formatted(Formatting.DARK_GREEN));
    }

    @Override
    public void fillItemCategory(ItemGroup.Entries contents) {

    }
}




