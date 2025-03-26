package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModItems;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;

import org.jetbrains.annotations.Nullable;

public class Ignitium_Elytra_ChestPlate extends ArmorItem implements FabricElytraItem {

    public Ignitium_Elytra_ChestPlate(Settings props, Armortier mat) {
        super(mat, Type.CHESTPLATE, props);
    }

//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getArmorRenderProperties());
//    }

    @Override
    public boolean isDamageable() {
        return CMConfig.Armor_Infinity_Durability;
    }

    public boolean canRepair(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.isOf(ModItems.IGNITIUM_INGOT);
    }

//    @Override
//    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
//        return true;
//    }
//
//    @Override
//    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
//        return ElytraItem.isUsable(stack);
//    }

    @Override
    public boolean useCustomElytra(LivingEntity entity, ItemStack chestStack, boolean tickElytra) {
        if(tickElytra) {
            this.doVanillaElytraTick(entity, chestStack);
        }
        return true;
    }

    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.CHEST;
    }

//    @Nullable
//    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
//        return Cataclysm.MOD_ID + ":textures/armor/ignitium_elytra_chestplate.png";
//    }

}
