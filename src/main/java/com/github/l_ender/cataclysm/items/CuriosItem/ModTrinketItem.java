package com.github.l_ender.cataclysm.items.CuriosItem;

import dev.emi.trinkets.api.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.NotNull;

public abstract class ModTrinketItem extends TrinketItem {
    public ModTrinketItem(Settings properties) {
        super(properties);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (equipItem(user, stack)) {
            SoundInfo soundInfo = this.getEquipSound();
            if(soundInfo != null) {
                user.emitGameEvent(GameEvent.EQUIP);
                user.playSound(soundInfo.sound, soundInfo.volume, soundInfo.pitch);
            }
            return TypedActionResult.success(stack, world.isClient());
        }
        return super.use(world, user, hand);
    }

    public abstract SoundInfo getEquipSound();

    public record SoundInfo(@NotNull SoundEvent sound, float volume, float pitch) {}
}