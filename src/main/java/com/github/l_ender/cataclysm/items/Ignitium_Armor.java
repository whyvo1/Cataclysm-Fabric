package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import java.util.List;

public class Ignitium_Armor extends ArmorItem implements ModDamageable {

    public Ignitium_Armor(RegistryEntry<ArmorMaterial> material, Type slot, Settings properties) {
        super(material, slot, properties);

    }

//    @Override
//    public void setDamage(ItemStack stack, int damage) {
//        if(CMConfig.Armor_Infinity_Durability) {
//            super.setDamage(stack, 0);
//        }else{
//            super.setDamage(stack, damage);
//        }
//    }


    public boolean canRepair(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.isOf(ModItems.IGNITIUM_INGOT);
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltips, TooltipType flags) {
        if (this.type == Type.HELMET) {
            tooltips.add(Text.translatable("item.cataclysm.ignitium_helmet.desc").formatted(Formatting.DARK_GREEN));
        }
        if (this.type == Type.CHESTPLATE) {
            tooltips.add(Text.translatable("item.cataclysm.ignitium_chestplate.desc").formatted(Formatting.DARK_GREEN));
        }
        if (this.type == Type.LEGGINGS) {
            tooltips.add(Text.translatable("item.cataclysm.ignitium_leggings.desc").formatted(Formatting.DARK_GREEN));
        }
        if (this.type ==  Type.BOOTS) {
            tooltips.add(Text.translatable("item.cataclysm.ignitium_boots.desc").formatted(Formatting.DARK_GREEN));
        }
    }

//    @Override
//    public Identifier getArmorTexture(@Nonnull ItemStack stack, @Nonnull Entity entity, @Nonnull EquipmentSlot slot, @Nonnull ArmorMaterial.Layer layer, boolean isInnerModel) {
//        return Identifier.of(Cataclysm.MODID , "textures/armor/ignitium_armor" + (slot == EquipmentSlot.LEGS ? "_legs.png" : ".png"));
//    }


    @Override
    public boolean isDamageable(ItemStack stack) {
        return !CMConfig.Armor_Infinity_Durability;
    }
}