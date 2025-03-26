package com.github.l_ender.cataclysm.Attachment;

import com.github.l_ender.cataclysm.entity.effect.Wall_Watcher_Entity;
import java.util.List;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;

public class ChargeAttachment {

	private boolean charge;
	public int Timer;
	public int effectiveChargeTime;
	public  float dx;
	public float dz;
	public float damagePerEffectiveCharge;
	public float knockbackSpeedIndex;

	public void tick(LivingEntity entity) {
		if(isCharge()) {
			if (!entity.getWorld().isClient()) {
				int temp = getTimer();
				setTimer(temp - 1);
				//Deal with rocket punch is valid
				if (temp > 0) {
					//Slightly enlarge player's hitbox
					Box collideBox = entity.getBoundingBox().expand(0.75f, 0.75f, 0.75f);

					//Collision Detection
					List<LivingEntity> checks = entity.getWorld().getNonSpectatingEntities(LivingEntity.class, collideBox);
					checks.remove(entity);

					//If any mob is detected
					if (!checks.isEmpty()) {
						// spawn an watchEntity to simulate rocket punch effect
						Wall_Watcher_Entity watchEntity = new Wall_Watcher_Entity(entity.getWorld(), entity.getBlockPos(), temp, effectiveChargeTime,
								knockbackSpeedIndex, damagePerEffectiveCharge, dx, dz,
								entity);

						List<LivingEntity> impact = entity.getWorld().getNonSpectatingEntities(LivingEntity.class, entity.getBoundingBox().expand(3.5f, 0.75f, 3.5f));
						impact.remove(entity);

						for (LivingEntity target : impact) {
							// Deal damage
							if (!target.isTeammate(entity)) {
								boolean flag = target.damage(entity.getDamageSources().mobProjectile(entity, entity), damagePerEffectiveCharge * effectiveChargeTime);
								watchEntity.watch(target);
								if (flag) {
									target.playSound(SoundEvents.BLOCK_ANVIL_LAND, 1.5f, 0.8F);
								}

							}
						}
						entity.getWorld().spawnEntity(watchEntity);

						// Player stop moving and clear pocket punch status
						entity.setVelocity(0, 0, 0);
						entity.velocityModified = true;
						setCharge(false);
					}
				}
				if (entity.horizontalCollision || temp == 0) {
					setCharge(false);
				}
			}
		}
	}
	
	public void setCharge(boolean charge) {
		this.charge = charge;
	}

	
	public boolean isCharge() {
		return this.charge;
	}


	
	public void setdamagePerEffectiveCharge(float damage) {
		this.damagePerEffectiveCharge = damage;
	}

	
	public float getdamagePerEffectiveCharge() {
		return this.damagePerEffectiveCharge;
	}

	
	public void setknockbackSpeedIndex(float knockback) {
		this.knockbackSpeedIndex = knockback;
	}

	
	public float getknockbackSpeedIndex() {
		return knockbackSpeedIndex;
	}

	
	public void seteffectiveChargeTime(int chargetime) {
		this.effectiveChargeTime = chargetime;
	}

	
	public int geteffectiveChargeTime() {
		return this.effectiveChargeTime;
	}

	
	public void setdx(float dx) {
		this.dx = dx;
	}

	
	public float getdx() {
		return this.dx ;
	}

	
	public void setdZ(float dz) {
		this.dz = dz;
	}

	
	public float getdZ() {
		return this.dz ;
	}


	
	public void setTimer(int timer) {
		this.Timer = timer;
	}

	
	public int getTimer() {
		return Timer;
	}
}
