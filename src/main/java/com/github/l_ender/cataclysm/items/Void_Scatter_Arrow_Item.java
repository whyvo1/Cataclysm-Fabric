package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.entity.projectile.Void_Scatter_Arrow_Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

public class Void_Scatter_Arrow_Item extends ArrowItem {
    public Void_Scatter_Arrow_Item(net.minecraft.item.Item.Settings group) {
        super(group);
    }

    @Override
    public PersistentProjectileEntity createArrow(World p_43237_, ItemStack p_43238_, LivingEntity p_43239_, @org.jetbrains.annotations.Nullable ItemStack p_345773_) {
        return new Void_Scatter_Arrow_Entity(p_43237_, p_43239_, p_43238_.copyWithCount(1), p_345773_);
    }

    @Override
    public ProjectileEntity createEntity(World p_338332_, Position p_338313_, ItemStack p_338304_, Direction p_338842_) {
        Void_Scatter_Arrow_Entity spectralarrow = new Void_Scatter_Arrow_Entity(p_338332_, p_338313_.getX(), p_338313_.getY(), p_338313_.getZ(), p_338304_.copyWithCount(1), null);
        spectralarrow.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
        return spectralarrow;
    }
}
