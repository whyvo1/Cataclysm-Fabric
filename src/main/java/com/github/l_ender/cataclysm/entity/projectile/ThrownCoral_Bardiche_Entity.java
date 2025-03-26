package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import org.jetbrains.annotations.Nullable;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
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
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ThrownCoral_Bardiche_Entity extends PersistentProjectileEntity {
    private static final TrackedData<Byte> ID_LOYALTY = DataTracker.registerData(ThrownCoral_Bardiche_Entity.class, TrackedDataHandlerRegistry.BYTE);
    private static final TrackedData<Boolean> ID_FOIL = DataTracker.registerData(ThrownCoral_Bardiche_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private ItemStack tridentItem = new ItemStack(ModItems.CORAL_BARDICHE);
    private boolean dealtDamage;
    public int clientSideReturnTridentTickCount;

    public ThrownCoral_Bardiche_Entity(EntityType<? extends ThrownCoral_Bardiche_Entity> p_37561_, World p_37562_) {
        super(p_37561_, p_37562_);
    }

    public ThrownCoral_Bardiche_Entity(World p_37569_, LivingEntity p_37570_, ItemStack p_37571_) {
        super(ModEntities.CORAL_BARDICHE, p_37570_, p_37569_);
        this.tridentItem = p_37571_.copy();
        this.dataTracker.set(ID_LOYALTY, (byte) EnchantmentHelper.getLoyalty(p_37571_));
        this.dataTracker.set(ID_FOIL, p_37571_.hasGlint());
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ID_LOYALTY, (byte)0);
        this.dataTracker.startTracking(ID_FOIL, false);
    }

    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        Entity entity = this.getOwner();
        int i = this.dataTracker.get(ID_LOYALTY);
        if (i > 0 && (this.dealtDamage || this.isNoClip()) && entity != null) {
            if (!this.isAcceptibleReturnOwner()) {
                if (!this.getWorld().isClient && this.pickupType == PickupPermission.ALLOWED) {
                    this.dropStack(this.asItemStack(), 0.1F);
                }

                this.discard();
            } else {
                this.setNoClip(true);
                Vec3d vec3 = entity.getEyePos().subtract(this.getPos());
                this.setPos(this.getX(), this.getY() + vec3.y * 0.015D * (double)i, this.getZ());
                if (this.getWorld().isClient) {
                    this.lastRenderY = this.getY();
                }

                double d0 = 0.05D * (double)i;
                this.setVelocity(this.getVelocity().multiply(0.95D).add(vec3.normalize().multiply(d0)));
                if (this.clientSideReturnTridentTickCount == 0) {
                    this.playSound(SoundEvents.ITEM_TRIDENT_RETURN, 10.0F, 1.0F);
                }

                ++this.clientSideReturnTridentTickCount;
            }
        }

        super.tick();
    }

    private boolean isAcceptibleReturnOwner() {
        Entity entity = this.getOwner();
        if (entity != null && entity.isAlive()) {
            return !(entity instanceof ServerPlayerEntity) || !entity.isSpectator();
        } else {
            return false;
        }
    }

    protected ItemStack asItemStack() {
        return this.tridentItem.copy();
    }

    public boolean isFoil() {
        return this.dataTracker.get(ID_FOIL);
    }

    @Nullable
    protected EntityHitResult getEntityCollision(Vec3d p_37575_, Vec3d p_37576_) {
        return this.dealtDamage ? null : super.getEntityCollision(p_37575_, p_37576_);
    }

    protected void onEntityHit(EntityHitResult p_37573_) {
        Entity entity = p_37573_.getEntity();
        float f = 10F;
        if (entity instanceof LivingEntity livingentity) {
            f += EnchantmentHelper.getAttackDamage(this.tridentItem, livingentity.getGroup());
        }

        Entity entity1 = this.getOwner();
        DamageSource damagesource = this.getDamageSources().trident(this, entity1 == null ? this : entity1);
        this.dealtDamage = true;
        SoundEvent soundevent = SoundEvents.ITEM_TRIDENT_HIT;
        if (entity.damage(damagesource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (entity instanceof LivingEntity livingentity1) {
                if (entity1 instanceof LivingEntity) {
                    EnchantmentHelper.onUserDamaged(livingentity1, entity1);
                    EnchantmentHelper.onTargetDamaged((LivingEntity)entity1, livingentity1);
                }

                this.onHit(livingentity1);
            }
        }

        this.setVelocity(this.getVelocity().multiply(-0.01D, -0.1D, -0.01D));
        float f1 = 1.0F;
        if (this.getWorld() instanceof ServerWorld && this.getWorld().isThundering() && this.isChanneling()) {
            BlockPos blockpos = entity.getBlockPos();
            if (this.getWorld().isSkyVisible(blockpos)) {
                LightningEntity lightningbolt = EntityType.LIGHTNING_BOLT.create(this.getWorld());
                lightningbolt.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(blockpos));
                lightningbolt.setChanneler(entity1 instanceof ServerPlayerEntity ? (ServerPlayerEntity)entity1 : null);
                this.getWorld().spawnEntity(lightningbolt);
                soundevent = SoundEvents.ITEM_TRIDENT_THUNDER;
                f1 = 5.0F;
            }
        }

        this.playSound(soundevent, f1, 1.0F);
    }

    public boolean isChanneling() {
        return EnchantmentHelper.hasChanneling(this.tridentItem);
    }

    protected boolean tryPickup(PlayerEntity p_150196_) {
        return super.tryPickup(p_150196_) || this.isNoClip() && this.isOwner(p_150196_) && p_150196_.getInventory().insertStack(this.asItemStack());
    }

    protected SoundEvent getHitSound() {
        return SoundEvents.ITEM_TRIDENT_HIT_GROUND;
    }

    public void onPlayerCollision(PlayerEntity p_37580_) {
        if (this.isOwner(p_37580_) || this.getOwner() == null) {
            super.onPlayerCollision(p_37580_);
        }

    }

    public void readCustomDataFromNbt(NbtCompound p_37578_) {
        super.readCustomDataFromNbt(p_37578_);
        if (p_37578_.contains("CoralBardiche", 10)) {
            this.tridentItem = ItemStack.fromNbt(p_37578_.getCompound("CoralBardiche"));
        }

        this.dealtDamage = p_37578_.getBoolean("DealtDamage");
        this.dataTracker.set(ID_LOYALTY, (byte)EnchantmentHelper.getLoyalty(this.tridentItem));
    }

    public void writeCustomDataToNbt(NbtCompound p_37582_) {
        super.writeCustomDataToNbt(p_37582_);
        p_37582_.put("CoralBardiche", this.tridentItem.writeNbt(new NbtCompound()));
        p_37582_.putBoolean("DealtDamage", this.dealtDamage);
    }

    public void age() {
        int i = this.dataTracker.get(ID_LOYALTY);
        if (this.pickupType != PickupPermission.ALLOWED || i <= 0) {
            super.age();
        }

    }

    protected float getDragInWater() {
        return 1.0F;
    }

    public boolean shouldRender(double p_37588_, double p_37589_, double p_37590_) {
        return true;
    }
}
