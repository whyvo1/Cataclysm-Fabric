package com.github.l_ender.cataclysm.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class ModTickableArmorItem extends ArmorItem {

    public ModTickableArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    abstract void onArmorTick(ItemStack stack, World world, PlayerEntity player);

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity instanceof PlayerEntity player) {
            if(player.getInventory().getArmorStack(this.type.getEquipmentSlot().getEntitySlotId()) == stack) {
                this.onArmorTick(stack, world, player);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
