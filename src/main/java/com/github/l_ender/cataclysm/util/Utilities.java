package com.github.l_ender.cataclysm.util;

import com.github.l_ender.cataclysm.init.ModTag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.network.packet.s2c.play.OverlayMessageS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

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

    public static boolean isEffectInTag(StatusEffect effect, TagKey<StatusEffect> tag) {
        RegistryEntry<StatusEffect> entry = Registries.STATUS_EFFECT.getEntry(effect);
        return entry != null && entry.isIn(tag);
    }

}
