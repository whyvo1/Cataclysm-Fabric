package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class Poison_Dart_Entity extends PersistentProjectileEntity {

    public Poison_Dart_Entity(EntityType type, World worldIn) {
        super(type, worldIn);
    }

    public Poison_Dart_Entity(EntityType type, double x, double y, double z, World worldIn) {
        this(type, worldIn);
        this.setPosition(x, y, z);
    }

    public Poison_Dart_Entity(World worldIn, LivingEntity shooter) {
        this(ModEntities.POISON_DART, shooter.getX(), shooter.getEyeY() - (double)0.1F, shooter.getZ(), worldIn);
        this.setOwner(shooter);
        if (shooter instanceof PlayerEntity) {
            this.pickupType = PickupPermission.ALLOWED;
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);
        this.discard();
    }

    protected void onHit(LivingEntity p_36873_) {
        super.onHit(p_36873_);
        Entity entity = this.getEffectCause();
        p_36873_.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1), entity);

    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return ItemStack.EMPTY;
    }

}
