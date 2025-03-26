package com.github.l_ender.cataclysm.client.sound;

import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class MeatShredderSound extends ItemTickableSound {

    public MeatShredderSound(LivingEntity user) {
        super(user, ModSounds.SHREDDER_LOOP);
    }

    public void tickVolume(ItemStack itemStack) {
        this.volume = 0.4f;
        this.pitch = 1.0f;
    }

    @Override
    public boolean isValidItem(ItemStack itemStack) {
        return itemStack.isOf(ModItems.MEAT_SHREDDER);
    }
}
