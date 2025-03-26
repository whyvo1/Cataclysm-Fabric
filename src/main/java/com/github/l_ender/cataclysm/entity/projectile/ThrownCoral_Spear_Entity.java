package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import org.jetbrains.annotations.Nullable;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ThrownCoral_Spear_Entity extends PersistentProjectileEntity {
    private static final TrackedData<Byte> ID_LOYALTY = DataTracker.registerData(ThrownCoral_Spear_Entity.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Boolean> ID_FOIL = DataTracker.registerData(ThrownCoral_Spear_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private boolean dealtDamage;
    public int clientSideReturnTridentTickCount;

    public ThrownCoral_Spear_Entity(EntityType<? extends ThrownCoral_Spear_Entity> p_37561_, World p_37562_) {
        super(p_37561_, p_37562_);
    }

    public ThrownCoral_Spear_Entity(World p_37569_, LivingEntity p_37570_, ItemStack p_37571_) {
        super(ModEntities.CORAL_SPEAR, p_37570_, p_37569_, p_37571_, null);
        this.dataTracker.set(ID_LOYALTY, this.getLoyaltyFromItem(p_37571_));
        this.dataTracker.set(ID_FOIL, p_37571_.hasGlint());
    }

    public ThrownCoral_Spear_Entity(World p_338686_, double p_338771_, double p_338674_, double p_338477_, ItemStack p_338255_) {
        super(ModEntities.CORAL_SPEAR, p_338771_, p_338674_, p_338477_, p_338686_, p_338255_, p_338255_);
        this.dataTracker.set(ID_LOYALTY, this.getLoyaltyFromItem(p_338255_));
        this.dataTracker.set(ID_FOIL, p_338255_.hasGlint());
    }



    protected void initDataTracker(DataTracker.Builder p_326229_) {
        super.initDataTracker(p_326229_);
        p_326229_.add(ID_LOYALTY, (byte)0);
        p_326229_.add(ID_FOIL, false);
    }

    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        Entity entity = this.getOwner();
        int i = this.dataTracker.get(ID_LOYALTY);
        if (i > 0 && (this.dealtDamage || this.isNoClip()) && entity != null) {
            if (!this.isAcceptibleReturnOwner()) {
                if (!this.getWorld().isClient && this.pickupType == PersistentProjectileEntity.PickupPermission.ALLOWED) {
                    this.dropStack(this.asItemStack(), 0.1F);
                }

                this.discard();
            } else {
                this.setNoClip(true);
                Vec3d vec3 = entity.getEyePos().subtract(this.getPos());
                this.setPos(this.getX(), this.getY() + vec3.y * 0.015 * (double)i, this.getZ());
                if (this.getWorld().isClient) {
                    this.lastRenderY = this.getY();
                }

                double d0 = 0.05 * (double)i;
                this.setVelocity(this.getVelocity().multiply(0.95).add(vec3.normalize().multiply(d0)));
                if (this.clientSideReturnTridentTickCount == 0) {
                    this.playSound(SoundEvents.ITEM_TRIDENT_RETURN, 10.0F, 1.0F);
                }

                this.clientSideReturnTridentTickCount++;
            }
        }

        super.tick();
    }

    private boolean isAcceptibleReturnOwner() {
        Entity entity = this.getOwner();
        return entity != null && entity.isAlive() && (!(entity instanceof ServerPlayerEntity) || !entity.isSpectator());
    }

    public boolean isFoil() {
        return this.dataTracker.get(ID_FOIL);
    }

    @Nullable
    protected EntityHitResult getEntityCollision(Vec3d p_37575_, Vec3d p_37576_) {
        return this.dealtDamage ? null : super.getEntityCollision(p_37575_, p_37576_);
    }

    @Override
    protected void onEntityHit(EntityHitResult p_37573_) {
        Entity entity = p_37573_.getEntity();
        float f = 6.5F;
        Entity entity1 = this.getOwner();
        DamageSource damagesource = this.getDamageSources().trident(this, entity1 == null ? this : entity1);
        if (this.getWorld() instanceof ServerWorld serverlevel) {
            f = EnchantmentHelper.getDamage(serverlevel, this.getWeaponStack(), entity, damagesource, f);
        }

        this.dealtDamage = true;
        if (entity.damage(damagesource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (this.getWorld() instanceof ServerWorld serverlevel1) {
                EnchantmentHelper.onTargetDamaged(serverlevel1, entity, damagesource, this.getWeaponStack());
            }

            if (entity instanceof LivingEntity livingentity) {
                this.knockback(livingentity, damagesource);
                this.onHit(livingentity);
            }
        }

        this.setVelocity(this.getVelocity().multiply(-0.01, -0.1, -0.01));
        this.playSound(SoundEvents.ITEM_TRIDENT_HIT, 1.0F, 1.0F);
    }


    @Override
    protected void onBlockHitEnchantmentEffects(ServerWorld p_344953_, BlockHitResult p_346320_, ItemStack p_344999_) {
        Vec3d vec3 = p_346320_.getBlockPos().clampToWithin(p_346320_.getPos());
        EnchantmentHelper.onHitBlock(
                p_344953_,
                p_344999_,
                this.getOwner() instanceof LivingEntity livingentity ? livingentity : null,
                this,
                null,
                vec3,
                p_344953_.getBlockState(p_346320_.getBlockPos()),
                p_348680_ -> this.kill()
        );
    }

    @Override
    public ItemStack getWeaponStack() {
        return this.getItemStack();
    }

    @Override
    protected boolean tryPickup(PlayerEntity p_150196_) {
        return super.tryPickup(p_150196_) || this.isNoClip() && this.isOwner(p_150196_) && p_150196_.getInventory().insertStack(this.asItemStack());
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.CORAL_SPEAR);
    }

    @Override
    protected SoundEvent getHitSound() {
        return SoundEvents.ITEM_TRIDENT_HIT_GROUND;
    }

    @Override
    public void onPlayerCollision(PlayerEntity p_37580_) {
        if (this.isOwner(p_37580_) || this.getOwner() == null) {
            super.onPlayerCollision(p_37580_);
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound p_37578_) {
        super.readCustomDataFromNbt(p_37578_);
        this.dealtDamage = p_37578_.getBoolean("DealtDamage");
        this.dataTracker.set(ID_LOYALTY, this.getLoyaltyFromItem(this.getItemStack()));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound p_37582_) {
        super.writeCustomDataToNbt(p_37582_);
        p_37582_.putBoolean("DealtDamage", this.dealtDamage);
    }

    private byte getLoyaltyFromItem(ItemStack p_345571_) {
        return this.getWorld() instanceof ServerWorld serverlevel
                ? (byte) MathHelper.clamp(EnchantmentHelper.getTridentReturnAcceleration(serverlevel, p_345571_, this), 0, 127)
                : 0;
    }

    @Override
    public void age() {
        int i = this.dataTracker.get(ID_LOYALTY);
        if (this.pickupType != PersistentProjectileEntity.PickupPermission.ALLOWED || i <= 0) {
            super.age();
        }
    }

    @Override
    protected float getDragInWater() {
        return 0.99F;
    }

    @Override
    public boolean shouldRender(double p_37588_, double p_37589_, double p_37590_) {
        return true;
    }
}
