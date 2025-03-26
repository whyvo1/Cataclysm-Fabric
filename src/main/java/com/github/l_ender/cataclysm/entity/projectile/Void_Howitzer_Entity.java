package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public class Void_Howitzer_Entity extends ThrownEntity {


    public Void_Howitzer_Entity(EntityType<Void_Howitzer_Entity> type, World world) {
        super(type, world);
    }

    public Void_Howitzer_Entity(EntityType<Void_Howitzer_Entity> type, World world, LivingEntity thrower) {
        super(type, thrower, world);
    }

    @Override
    protected void initDataTracker() {

    }


    protected void onEntityHit(EntityHitResult p_37626_) {
        super.onEntityHit(p_37626_);
        if (!this.getWorld().isClient) {
            Entity entity = p_37626_.getEntity();
            Entity entity1 = this.getOwner();
            boolean flag;
            if (entity1 instanceof LivingEntity livingentity) {
                flag = entity.damage(this.getDamageSources().indirectMagic(this, livingentity), 8.0F);
                if (flag) {
                    if (entity.isAlive()) {
                        this.applyDamageEffects(livingentity, entity);
                    } else {
                        livingentity.heal(5.0F);
                    }
                }
            } else {
               entity.damage(this.getDamageSources().magic(), 5.0F);
            }
        }
    }

    protected void onCollision(HitResult p_37628_) {
        super.onCollision(p_37628_);
        if (!this.getWorld().isClient) {
            int standingOnY = MathHelper.floor(this.getY()) - 3;
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 3.0F, false, World.ExplosionSourceType.NONE);
            for (int k = 0; k < 6; ++k) {
                float f2 = (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 5F);
                this.spawnFangs(this.getX() + (double) MathHelper.cos(f2) * 2.5D, this.getZ() + (double) MathHelper.sin(f2) * 2.5D, standingOnY, this.getY() + 1, f2, 0);
            }
            for (int k = 0; k < 11; ++k) {
                float f3 = (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                this.spawnFangs(this.getX() + (double) MathHelper.cos(f3) * 3.5D, this.getZ() + (double) MathHelper.sin(f3) * 3.5D, standingOnY, this.getY() + 1, f3, 2);
            }
            for (int k = 0; k < 14; ++k) {
                float f4 = (float) k * (float) Math.PI * 2.0F / 14.0F + ((float) Math.PI * 2F / 20F);
                this.spawnFangs(this.getX() + (double) MathHelper.cos(f4) * 4.5D, this.getZ() + (double) MathHelper.sin(f4) * 4.5D, standingOnY, this.getY() + 1, f4, 4);
            }
            for (int k = 0; k < 19; ++k) {
                float f5 = (float) k * (float) Math.PI * 2.0F / 19.0F + ((float) Math.PI * 2F / 25F);
                this.spawnFangs(this.getX() + (double) MathHelper.cos(f5) * 5.5D, this.getZ() + (double) MathHelper.sin(f5) * 5.5D, standingOnY, this.getY() + 1, f5, 6);
            }
            for (int k = 0; k < 26; ++k) {
                float f5 = (float) k * (float) Math.PI * 2.0F / 26.0F + ((float) Math.PI * 2F / 35F);
                this.spawnFangs(this.getX() + (double) MathHelper.cos(f5) * 6.5D, this.getZ() + (double) MathHelper.sin(f5) * 6.5D, standingOnY, this.getY() + 1, f5, 8);
            }

            ScreenShake_Entity.ScreenShake(getWorld(), this.getPos(), 40, 0.3f, 0, 20);
            this.discard();
        }
    }

    protected void spawnFangs(double x, double z, double minY, double maxY, float rotation, int delay) {
        BlockPos blockpos = BlockPos.ofFloored(x, maxY, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.down();
            BlockState blockstate = this.getWorld().getBlockState(blockpos1);
            if (blockstate.isSideSolidFullSquare(this.getWorld(), blockpos1, Direction.UP)) {
                if (!this.getWorld().isAir(blockpos)) {
                    BlockState blockstate1 = this.getWorld().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.getWorld(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.getMax(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.down();
        } while(blockpos.getY() >= MathHelper.floor(minY) - 1);

        if (flag) {
            LivingEntity entity1 = (LivingEntity) this.getOwner();
            this.getWorld().spawnEntity(new Void_Rune_Entity(this.getWorld(), x, (double)blockpos.getY() + d0, z, rotation, delay, (float) CMConfig.Voidrunedamage, entity1));
        }
    }


    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);

    }


    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient) {
            Vec3d vec3 = this.getVelocity();
            getWorld().addParticle(ParticleTypes.REVERSE_PORTAL, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0, 0, 0);
            getWorld().addParticle(ParticleTypes.SMOKE, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0, 0, 0);
        }

    }


    @Override
    protected float getGravity() {
        return 0.03F;
    }

//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }
}
