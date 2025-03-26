package com.github.l_ender.cataclysm.util;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.OverlayMessageS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Utilities {



    public static Hand getHandPossiblyHolding(LivingEntity entity, Predicate<Item> itemPredicate) {
        return itemPredicate.test(entity.getMainHandStack().getItem()) ? Hand.MAIN_HAND : Hand.OFF_HAND;
    }

    public static void trySendOverlayMessage(Entity entity, Text message) {
        if(entity instanceof ServerPlayerEntity player) {
            player.networkHandler.sendPacket(new OverlayMessageS2CPacket(message));
        }
    }

    public static void damageItemStack(ItemStack itemStack, int amount, ServerWorld world, @Nullable LivingEntity entity, Consumer<Item> breakCallback) {
        if (itemStack.isDamageable()) {
            if (amount > 0) {
                amount = EnchantmentHelper.getItemDamage(world, itemStack, amount);
                if (amount <= 0) {
                    return;
                }
            }

            if (entity instanceof ServerPlayerEntity player && amount != 0) {
                Criteria.ITEM_DURABILITY_CHANGED.trigger(player, itemStack, itemStack.getDamage() + amount);
            }

            int i = itemStack.getDamage() + amount;
            itemStack.setDamage(i);
            if (i >= itemStack.getMaxDamage()) {
                Item item = itemStack.getItem();
                itemStack.decrement(1);
                breakCallback.accept(item);
            }
        }
    }

}
