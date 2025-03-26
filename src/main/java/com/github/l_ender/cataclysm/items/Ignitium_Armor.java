package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;

public class Ignitium_Armor extends ArmorItem {

    public Ignitium_Armor(Armortier material, ArmorItem.Type slot, Settings properties) {
        super(material, slot, properties);

    }
    
//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getArmorRenderProperties());
//    }


//    @Override
//    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
//        return Cataclysm.MOD_ID + ":textures/armor/ignitium_armor" + (slot == EquipmentSlot.LEGS ? "_legs.png" : ".png");
//    }

//    @Override
//    public void setDamage(ItemStack stack, int damage) {
//        if(CMConfig.Armor_Infinity_Durability) {
//            super.setDamage(stack, 0);
//        }else{
//            super.setDamage(stack, damage);
//        }
//    }

    @Override
    public boolean isDamageable() {
        return !CMConfig.Armor_Infinity_Durability;
    }

    public boolean canRepair(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.isOf(ModItems.IGNITIUM_INGOT);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        if (this.type == Type.HELMET) {
            tooltip.add(Text.translatable("item.cataclysm.ignitium_helmet.desc").formatted(Formatting.DARK_GREEN));
        }
        if (this.type == Type.CHESTPLATE) {
            tooltip.add(Text.translatable("item.cataclysm.ignitium_chestplate.desc").formatted(Formatting.DARK_GREEN));
        }
        if (this.type == Type.LEGGINGS) {
            tooltip.add(Text.translatable("item.cataclysm.ignitium_leggings.desc").formatted(Formatting.DARK_GREEN));
        }
        if (this.type ==  Type.BOOTS) {
            tooltip.add(Text.translatable("item.cataclysm.ignitium_boots.desc").formatted(Formatting.DARK_GREEN));
        }
    }

}