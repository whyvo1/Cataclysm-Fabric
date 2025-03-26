package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.entity.projectile.Void_Scatter_Arrow_Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Void_Scatter_Arrow_Item extends ArrowItem {
    public Void_Scatter_Arrow_Item(Settings group) {
        super(group);
    }

    public PersistentProjectileEntity createArrow(World level, ItemStack itemStack, LivingEntity livingEntity) {
        return new Void_Scatter_Arrow_Entity(level, livingEntity);
    }

}
