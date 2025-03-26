package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class Ignitium_Elytra_ChestPlate extends ArmorItem implements ModDamageable {

    public Ignitium_Elytra_ChestPlate(net.minecraft.item.Item.Settings props, RegistryEntry<ArmorMaterial> material) {
        super(material, Type.CHESTPLATE, props);
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


    public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        return this.equipAndSwap(this, level, player, hand);
    }

    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return true;
    }


    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        if (!entity.getWorld().isClient) {
            int nextFlightTick = flightTicks + 1;
            if (nextFlightTick % 10 == 0) {
                entity.emitGameEvent(GameEvent.ELYTRA_GLIDE);
            }
        }

        return true;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return !CMConfig.Armor_Infinity_Durability;
    }

//    @Override
//    public Identifier getArmorTexture(@Nonnull ItemStack stack, @Nonnull Entity entity, @Nonnull EquipmentSlot slot, @Nonnull ArmorMaterial.Layer layer, boolean isInnerModel) {
//        return Cataclysm.modIdentifier("textures/armor/ignitium_elytra_chestplate.png");
//    }


}
