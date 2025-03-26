package com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class Abyss_Blast_Portal_Entity extends Entity {
	private int warmupDelayTicks;
	private boolean sentSpikeEvent;
	private int lifeTicks =260;
	private int laserdurations = 160;
	private boolean clientSideAttackStarted;
	private LivingEntity caster;
	private UUID casterUuid;
	public float activateProgress;
	public float prevactivateProgress;
	private static final TrackedData<Boolean> ACTIVATE = DataTracker.registerData(Abyss_Blast_Portal_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
	private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Abyss_Blast_Portal_Entity.class, TrackedDataHandlerRegistry.FLOAT);
	private static final TrackedData<Float> HPDAMAGE = DataTracker.registerData(Abyss_Blast_Portal_Entity.class, TrackedDataHandlerRegistry.FLOAT);



	public Abyss_Blast_Portal_Entity(EntityType<? extends Entity> type, World level) {
		super(type, level);
	}

	public Abyss_Blast_Portal_Entity(World worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_,float damage,float hpdamage ,LivingEntity casterIn) {
		this(ModEntities.ABYSS_BLAST_PORTAL, worldIn);
		this.warmupDelayTicks = p_i47276_9_;

		this.setCaster(casterIn);
		this.setYaw(p_i47276_8_ * (180F / (float)Math.PI));
		this.setDamage(damage);
		this.setHpDamage(hpdamage);
		this.setPosition(x, y, z);
	}

//	@Override
//	public Packet<ClientPlayPacketListener> createSpawnPacket() {
//		return NetworkHooks.getEntitySpawningPacket(this);
//	}


	public void setCaster(@Nullable LivingEntity p_190549_1_) {
		this.caster = p_190549_1_;
		this.casterUuid = p_190549_1_ == null ? null : p_190549_1_.getUuid();
	}

	@Nullable
	public LivingEntity getCaster() {
		if (this.caster == null && this.casterUuid != null && this.getWorld() instanceof ServerWorld) {
			Entity entity = ((ServerWorld)this.getWorld()).getEntity(this.casterUuid);
			if (entity instanceof LivingEntity) {
				this.caster = (LivingEntity)entity;
			}
		}

		return this.caster;
	}

	public void tick() {
		super.tick();

		prevactivateProgress = activateProgress;

		if (isActivate() && this.activateProgress > 0F) {
			this.activateProgress--;
		}

		if (this.getWorld().isClient) {
			if (this.clientSideAttackStarted) {
				--this.lifeTicks;
				if (!isActivate() && this.activateProgress < 10F) {
					this.activateProgress++;
				}
				if (this.lifeTicks == 14) {
					this.setActivate(true);
				}
			}
		} else if (--this.warmupDelayTicks < 0) {
			if (this.warmupDelayTicks == -10) {
				if(isActivate()) {
					this.setActivate(false);
				}
			}
			if (this.warmupDelayTicks == -22) {
				if (caster != null) {
					Portal_Abyss_Blast_Entity DeathBeam1 = new Portal_Abyss_Blast_Entity(ModEntities.PORTAL_ABYSS_BLAST, this.getWorld(), this.getCaster(), this.getX(), this.getY(), this.getZ(), (float) ((this.getYaw() - 90) * Math.PI / 180), (float) (90 * Math.PI / 180), laserdurations, 90,this.getDamage(),this.getHpDamage());
					this.getWorld().spawnEntity(DeathBeam1);
				}else{
					Portal_Abyss_Blast_Entity DeathBeam2 = new Portal_Abyss_Blast_Entity(ModEntities.PORTAL_ABYSS_BLAST, this.getWorld(), this.getX(), this.getY(), this.getZ(), (float) ((this.getYaw() - 90) * Math.PI / 180), (float) (90 * Math.PI / 180), laserdurations,90,this.getDamage(),this.getHpDamage());
					this.getWorld().spawnEntity(DeathBeam2);
				}
			}


			if (!this.sentSpikeEvent) {
				this.getWorld().sendEntityStatus(this, (byte)4);
				this.clientSideAttackStarted = true;
				this.sentSpikeEvent = true;
			}

			if (--this.lifeTicks < 0) {
				this.discard();
			}
		}
	}

	@Override
	public boolean shouldRender(double p_36837_) {
		double d0 = this.getBoundingBox().getAverageSideLength() * 10.0D;
		if (Double.isNaN(d0)) {
			d0 = 4.0D;
		}

		d0 *= 64.0D;
		return p_36837_ < d0 * d0;
	}



	@Override
	protected void initDataTracker() {
		this.dataTracker.startTracking(ACTIVATE, Boolean.FALSE);
		this.dataTracker.startTracking(DAMAGE, 0F);
		this.dataTracker.startTracking(HPDAMAGE, 0F);
	}

	public float getDamage() {
		return dataTracker.get(DAMAGE);
	}

	public void setDamage(float damage) {
		dataTracker.set(DAMAGE, damage);
	}

	public float getHpDamage() {
		return dataTracker.get(HPDAMAGE);
	}

	public void setHpDamage(float damage) {
		dataTracker.set(HPDAMAGE, damage);
	}


	public boolean isActivate() {
		return this.dataTracker.get(ACTIVATE);
	}

	public void setActivate(boolean Activate) {
		this.dataTracker.set(ACTIVATE, Activate);
	}


	protected void readCustomDataFromNbt(NbtCompound compound) {
		this.warmupDelayTicks = compound.getInt("Warmup");
		if (compound.containsUuid("Owner")) {
			this.casterUuid = compound.getUuid("Owner");
		}
		this.setDamage(compound.getFloat("damage"));
		this.setHpDamage(compound.getFloat("Hpdamage"));
	}

	protected void writeCustomDataToNbt(NbtCompound compound) {
		compound.putInt("Warmup", this.warmupDelayTicks);
		if (this.casterUuid != null) {
			compound.putUuid("Owner", this.casterUuid);
		}
		compound.putFloat("damage", this.getDamage());
		compound.putFloat("Hpdamage", this.getHpDamage());
	}

	@Environment(EnvType.CLIENT)
	public void handleStatus(byte id) {
		super.handleStatus(id);
		if (id == 4) {
			this.clientSideAttackStarted = true;
		}

	}


	public PistonBehavior getPistonBehavior() {
		return PistonBehavior.IGNORE;
	}

}
