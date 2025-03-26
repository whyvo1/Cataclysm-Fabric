package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Ender_Guardian_Bullet_Entity extends ExplosiveProjectileEntity {
    //Projectile goes to a point over a set duration, then activates and accelerates in a given straight line
    private double dirX, dirY, dirZ;
    private double startX, startY, startZ;
    private int timer;
    private boolean fired;

    public Ender_Guardian_Bullet_Entity(EntityType<? extends Ender_Guardian_Bullet_Entity> type, World world) {
        super(type, world);
    }

    public Ender_Guardian_Bullet_Entity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(ModEntities.ENDER_GUARDIAN_BULLET, shooter, accelX, accelY, accelZ, worldIn);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Override
    protected void onEntityHit(EntityHitResult result) {
        super.onEntityHit(result);
        if (!getWorld().isClient && fired) {
            Entity entity = result.getEntity();
            Entity Shooter = this.getOwner();
            LivingEntity livingentity = Shooter instanceof LivingEntity ? (LivingEntity)Shooter : null;
            boolean flag = entity.damage(getDamageSources().mobProjectile(this, livingentity), 6.0F);
            if (flag) {
                this.applyDamageEffects(livingentity, entity);
                if (entity instanceof LivingEntity) {
                    ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 100));
                }
            }
        }
    }

    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);
        if(fired) {
            ((ServerWorld) this.getWorld()).spawnParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 2, 0.2D, 0.2D, 0.2D, 0.0D);
            this.playSound(SoundEvents.ENTITY_SHULKER_BULLET_HIT, 1.0F, 1.0F);
        }
    }


    protected void onCollision(HitResult result) {
        super.onCollision(result);
        if(fired) {
            this.discard();
        }
    }

    public void setUp(int delay, double dirX, double dirY, double dirZ, double startX, double startY, double startZ) {
        fired = false;
        timer = delay;
        this.dirX = dirX;
        this.dirY = dirY;
        this.dirZ = dirZ;
        this.startX = startX;
        this.startY = startY;
        this.startZ = startZ;
    }

    public void setUpTowards(int delay, double startX, double startY, double startZ, double endX, double endY, double endZ, double speed) {
        Vec3d vec = new Vec3d(endX - startX, endY - startY, endZ - startZ).normalize().multiply(speed);
        setUp(delay, vec.x, vec.y, vec.z, startX, startY, startZ);
    }

    public void tick() {
        if (!this.getWorld().isClient) {
            timer--;
            if (timer <= 0) {
                if (fired) discard();
                else {
                    fired = true;
                    setVelocity(new Vec3d(0, 0, 0));
                    timer = 30;
                }
            }
            Vec3d DeltaMovement = getVelocity();
            double d0 = getX();
            double d1 = getY();
            double d2 = getZ();

            if (fired) {
                if (DeltaMovement.lengthSquared() <= 16) setVelocity(DeltaMovement.add(dirX * 0.1, dirY * 0.1, dirZ * 0.1));
            } else {
                setVelocity(new Vec3d(startX - d0, startY - d1, startZ - d2).multiply(1.0 / timer));
            }
        }

        // Started from copy of the above tick
        Entity shooter = this.getOwner();
        if (getWorld().isClient || (shooter == null || !shooter.isRemoved()) && getWorld().isChunkLoaded(this.getBlockPos())) {
            HitResult HitResult = ProjectileUtil.getCollision(this, this::canHit);
            if (HitResult.getType() != net.minecraft.util.hit.HitResult.Type.MISS) {
                onCollision(HitResult);
            }

            checkBlockCollision();
            Vec3d Vec3 = getVelocity();
            double d0 = getX() + Vec3.x;
            double d1 = getY() + Vec3.y;
            double d2 = getZ() + Vec3.z;
            ProjectileUtil.setRotationFromVelocity(this, 0.2F);
            this.getWorld().addParticle(ParticleTypes.END_ROD, this.getX() - Vec3.x, this.getY() - Vec3.y + 0.15D, this.getZ() - Vec3.z, 0.0D, 0.0D, 0.0D);
            setPosition(d0, d1, d2);
        } else {
            discard();
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putDouble("DX", dirX);
        compound.putDouble("DY", dirY);
        compound.putDouble("DZ", dirZ);
        compound.putDouble("SX", startX);
        compound.putDouble("SY", startY);
        compound.putDouble("SZ", startZ);
        compound.putInt("Timer", timer);
        compound.putBoolean("Fired", fired);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        dirX = compound.getDouble("DX");
        dirY = compound.getDouble("DY");
        dirZ = compound.getDouble("DZ");
        startX = compound.getDouble("SX");
        startY = compound.getDouble("SY");
        startZ = compound.getDouble("SZ");
        timer = compound.getInt("Timer");
        fired = compound.getBoolean("Fired");
    }

    @Override
    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public boolean damage(DamageSource source, float amount)
    {
        if(!this.getWorld().isClient && fired)
        {
            this.playSound(SoundEvents.ENTITY_SHULKER_BULLET_HURT, 1.0F, 1.0F);
            ((ServerWorld)this.getWorld()).spawnParticles(ParticleTypes.CRIT, this.getX(), this.getY(), this.getZ(), 15, 0.2D, 0.2D, 0.2D, 0.0D);
            this.discard();
        }

        return true;
    }


//    @NotNull
//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }

}
