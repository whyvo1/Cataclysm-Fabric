package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.init.ModCapabilities;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.items.Tidal_Claws;
import com.github.l_ender.cataclysm.message.MessageHookFalling;
import com.github.l_ender.cataclysm.util.NetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonPart;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Tidal_Hook_Entity extends PersistentProjectileEntity {
	private static final TrackedData<Integer> HOOKED_ENTITY_ID = DataTracker.registerData(Tidal_Hook_Entity.class, TrackedDataHandlerRegistry.INTEGER);

	private double maxRange = 0D;
	private double maxSpeed = 0D;
	private boolean isPulling = false;
	private Entity hookedEntity;
	private ItemStack stack;

	public Tidal_Hook_Entity(EntityType<? extends Tidal_Hook_Entity> p_37561_, World p_37562_) {
		super(p_37561_, p_37562_);
		this.setNoGravity(true);
		this.setDamage(0);
	}

	public Tidal_Hook_Entity(World p_37569_, LivingEntity p_37570_, ItemStack p_37571_) {
		super(ModEntities.TIDAL_HOOK, p_37570_, p_37569_, p_37571_, null);
		this.setNoGravity(true);
		this.setDamage(0);

	}

	public Tidal_Hook_Entity(World p_338686_, double p_338771_, double p_338674_, double p_338477_, ItemStack p_338255_) {
		super(ModEntities.TIDAL_HOOK, p_338771_, p_338674_, p_338477_, p_338686_, p_338255_, p_338255_);
		this.setNoGravity(true);
		this.setDamage(0);
	}


	protected void initDataTracker(DataTracker.Builder p_326229_) {
		super.initDataTracker(p_326229_);
		p_326229_.add(HOOKED_ENTITY_ID, 0);
	}

	@Override
	public void tick() {
		super.tick();
		if(getOwner() instanceof PlayerEntity owner) {
			boolean flag = ModCapabilities.getOrCreate(owner, ModCapabilities.HOOK_CAPABILITY).hasHook();
			if (isPulling && age % 3 == 0) {
				getWorld().playSound(null, getOwner().getBlockPos(), ModSounds.TIDAL_HOOK_LOOP, SoundCategory.PLAYERS, 0.4F, 1F);
			}
			if (!getWorld().isClient) {
				if (owner.isDead() || !flag || owner.distanceTo(this) > maxRange || !(owner.getMainHandStack().getItem() instanceof Tidal_Claws || owner.getOffHandStack().getItem() instanceof Tidal_Claws))
					kill();
				if (this.hookedEntity != null) {
					if (this.hookedEntity.isRemoved()) {
						this.hookedEntity = null;
						discard();
					} else {
						this.refreshPositionAfterTeleport(this.hookedEntity.getX(), this.hookedEntity.getBodyY(0.8D), this.hookedEntity.getZ());
					}
				}

				if (owner.getMainHandStack() == stack || owner.getOffHandStack() == stack) {
					if (isPulling) {
						Entity target = owner;
						Entity origin = this;

						if (owner.isSneaking() && hookedEntity != null) {
							target = hookedEntity;
							origin = owner;
						}

						double brakeZone = (6D * (maxSpeed / 10));
						double pullSpeed = maxSpeed / 6D;
						Vec3d distance = origin.getPos().subtract(target.getPos().add(0, target.getHeight() / 2, 0));
						Vec3d motion = distance.normalize().multiply(distance.length() < brakeZone ? (pullSpeed * distance.length()) / brakeZone : pullSpeed);

						if (Math.abs(distance.y) < 0.1D)
							motion = new Vec3d(motion.x, 0, motion.z);
						if (new Vec3d(distance.x, 0, distance.z).length() < new Vec3d(target.getWidth() / 2, 0, target.getWidth() / 2).length() / 1.4)
							motion = new Vec3d(0, motion.y, 0);

						target.setVelocity(motion);
						target.velocityModified = true;

					}
				} else {
					kill();
				}
			}
		}
	}

	@Override
	public void kill() {
		if(!getWorld().isClient && getOwner() instanceof PlayerEntity owner) {
//			boolean flag = getOwner().getData(ModDataAttachments.HOOK_FALLING);
			NetworkHandler.sendToPlayersTrackingEntity(owner, new MessageHookFalling(owner.getId(), true));
//			PacketDistributor.sendToPlayersTrackingEntityAndSelf(owner, new MessageHookFalling(owner.getId(), true));
			owner.setNoGravity(false);


		}

		super.kill();
	}

	@Override
	public boolean shouldRender(double distance) {
		return true;
	}

	protected float getDragInWater() {
		return 1.0F;
	}

	@Override
	protected ItemStack asItemStack() {
		return ItemStack.EMPTY;
	}

	@Override
	protected ItemStack getDefaultItemStack() {
		return ItemStack.EMPTY;
	}

	@Override
	protected void onBlockHit(BlockHitResult blockHitResult) {
		super.onBlockHit(blockHitResult);
		isPulling = true;

		if(!getWorld().isClient && getOwner() instanceof PlayerEntity owner && hookedEntity == null) {
			owner.setNoGravity(true);
		}
	}

	public boolean canChangeDimensions() {
		return false;
	}

	protected SoundEvent getHitSound() {
		return ModSounds.TIDAL_HOOK_HIT;
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		if(!getWorld().isClient && getOwner() instanceof PlayerEntity owner && entityHitResult.getEntity() != owner) {
			if((entityHitResult.getEntity() instanceof LivingEntity || entityHitResult.getEntity() instanceof EnderDragonPart) && hookedEntity == null) {
				hookedEntity = entityHitResult.getEntity();
				this.getDataTracker().set(HOOKED_ENTITY_ID, hookedEntity.getId() + 1);
				isPulling = true;
			}
		}
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound tag) {
		super.readCustomDataFromNbt(tag);

		maxRange = tag.getDouble("maxRange");
		maxSpeed = tag.getDouble("maxSpeed");
		isPulling = tag.getBoolean("isPulling");
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound tag) {
		super.writeCustomDataToNbt(tag);
		tag.putDouble("maxRange", maxRange);
		tag.putDouble("maxSpeed", maxSpeed);
		tag.putBoolean("isPulling", isPulling);
	}

	public void setProperties(ItemStack stack, double maxRange, double maxVelocity, float pitch, float yaw, float roll, float modifierZ) {
		float f = 0.017453292F;
		float x = -MathHelper.sin(yaw * f) * MathHelper.cos(pitch * f);
		float y = -MathHelper.sin((pitch + roll) * f);
		float z = MathHelper.cos(yaw * f) * MathHelper.cos(pitch * f);
		this.setVelocity(x, y, z, modifierZ, 0);
		this.stack = stack;
		this.maxRange = maxRange;
		this.maxSpeed = maxVelocity;
	}
}
