package com.github.l_ender.cataclysm.client.sound;

import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;

public abstract class ItemTickableSound extends MovingSoundInstance {

    protected final LivingEntity user;

    public ItemTickableSound(LivingEntity user, SoundEvent soundEvent) {
        super(soundEvent, SoundCategory.PLAYERS, SoundInstance.createRandom());
        this.user = user;
        this.attenuationType = AttenuationType.LINEAR;
        this.repeat = true;
        this.x = (float)this.user.getX();
        this.y = (float)this.user.getY();
        this.z = (float)this.user.getZ();
        this.repeatDelay = 0;
    }

    public boolean canPlay() {
        return !this.user.isSilent() && this.user.isUsingItem() && (isValidItem(this.user.getStackInHand(Hand.MAIN_HAND)) || isValidItem(this.user.getStackInHand(Hand.OFF_HAND)));
    }

    public void tick() {
        ItemStack itemStack = ItemStack.EMPTY;
        if(user.isUsingItem()){
            if(isValidItem(this.user.getStackInHand(Hand.MAIN_HAND))){
                itemStack = this.user.getStackInHand(Hand.MAIN_HAND);
            }
            if(isValidItem(this.user.getStackInHand(Hand.OFF_HAND))){
                itemStack = this.user.getStackInHand(Hand.OFF_HAND);
            }
        }
        if (this.user.isAlive() && !itemStack.isEmpty()) {
            this.x = (float)this.user.getX();
            this.y = (float)this.user.getY();
            this.z = (float)this.user.getZ();
            tickVolume(itemStack);
        } else {
            this.setDone();
        }
    }

    protected abstract void tickVolume(ItemStack itemStack);

    public abstract boolean isValidItem(ItemStack itemStack);

    public boolean shouldAlwaysPlay() {
        return true;
    }

    public boolean isSameEntity(LivingEntity user) {
        return this.user.isAlive() && this.user.getId() == user.getId();
    }
}
