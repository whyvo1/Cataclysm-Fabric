package com.github.l_ender.cataclysm.Attachment;

import com.github.l_ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.projectile.Phantom_Halberd_Entity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public class RenderRushAttachment {

	private boolean charge;
	public int Timer;
	public float damage;

	public void tick(LivingEntity entity) {
		if(isRush()) {
			int standingOnY = MathHelper.floor(entity.getY()) - 3;
			double headY = entity.getY() + 2.0D;
			float yawRadians = (float) (Math.toRadians(90 + entity.getYaw()));
			int temp = getTimer();

			setTimer(temp - 1);
			//Deal with rocket punch is valid
			if (temp > 0) {
				double yaw = Math.toRadians(entity.getYaw() + 90);
				double xExpand = 3 * Math.cos(yaw);
				double zExpand = 3 * Math.sin(yaw);
				Box attackRange = entity.getBoundingBox().stretch(xExpand, 0, zExpand);
				for (LivingEntity target : entity.getWorld().getNonSpectatingEntities(LivingEntity.class, attackRange)) {
					if (!target.isTeammate(entity) && target != entity) {
						target.damage(entity.getDamageSources().mobAttack(entity), getdamage());

					}
				}


				if(temp % 2 ==0){
					this.spawnFangs(entity.getX(), headY, entity.getZ(), standingOnY, yawRadians, 1, entity.getWorld(), entity);
					double x = entity.getX();
					double y = entity.getY() + entity.getHeight() / 2;
					double z = entity.getZ();
					float yaw2 = (float) Math.toRadians(-entity.getYaw());
					float yaw3 = (float) Math.toRadians(-entity.getYaw() + 180);
					entity.getWorld().addParticle(new RingParticleOptions(yaw2, 0, 20, 86, 236, 204, 1.0f, 30f, false, 2), x, y, z, 0, 0, 0);

					entity.getWorld().addParticle(new RingParticleOptions(yaw3, 0, 20, 86, 236, 204, 1.0f, 30f, false, 2), x, y, z, 0, 0, 0);
				}
			}

			if (temp == 0) {
				setRush(false);

			}
		}
	}


	private void spawnFangs(double x, double y, double z, int lowestYCheck, float yRot, int warmupDelayTicks, World world, LivingEntity player) {
		BlockPos blockpos = BlockPos.ofFloored(x, y, z);
		boolean flag = false;
		double d0 = 0.0D;

		do {
			BlockPos blockpos1 = blockpos.down();
			BlockState blockstate = world.getBlockState(blockpos1);
			if (blockstate.isSideSolidFullSquare(world, blockpos1, Direction.UP)) {
				if (!world.isAir(blockpos)) {
					BlockState blockstate1 = world.getBlockState(blockpos);
					VoxelShape voxelshape = blockstate1.getCollisionShape(world, blockpos);
					if (!voxelshape.isEmpty()) {
						d0 = voxelshape.getMax(Direction.Axis.Y);
					}
				}

				flag = true;
				break;
			}

			blockpos = blockpos.down();
		} while (blockpos.getY() >= lowestYCheck);

		if (flag) {
			world.spawnEntity(new Phantom_Halberd_Entity(world, x, (double) blockpos.getY() + d0, z, yRot, warmupDelayTicks, player,(float) CMConfig.PhantomHalberddamage));
		}
	}

	
	public void setRush(boolean charge) {
		this.charge = charge;
	}

	
	public boolean isRush() {
		return this.charge;
	}


	
	public void setdamage(float damage) {
		this.damage = damage;
	}

	
	public float getdamage() {
		return this.damage;
	}




	
	public void setTimer(int timer) {
		this.Timer = timer;
	}

	
	public int getTimer() {
		return Timer;
	}
}
