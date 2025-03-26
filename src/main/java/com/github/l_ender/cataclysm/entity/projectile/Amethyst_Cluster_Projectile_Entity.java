package com.github.l_ender.cataclysm.entity.projectile;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class Amethyst_Cluster_Projectile_Entity extends ThrownEntity {

    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Amethyst_Cluster_Projectile_Entity.class, TrackedDataHandlerRegistry.FLOAT);



    public Amethyst_Cluster_Projectile_Entity(EntityType<Amethyst_Cluster_Projectile_Entity> type, World world) {
        super(type, world);
    }

    public Amethyst_Cluster_Projectile_Entity(EntityType<Amethyst_Cluster_Projectile_Entity> type, World world, LivingEntity thrower,float damage) {
        super(type, thrower, world);
        this.setDamage(damage);
    }



    @Override
    protected void onEntityHit(EntityHitResult result) {
        super.onEntityHit(result);
        Entity shooter = this.getOwner();
        Entity entity = result.getEntity();
        if (shooter instanceof LivingEntity) {
            if (!((entity == shooter) || (shooter.isTeammate(entity)))) {
                entity.damage(this.getDamageSources().mobProjectile(this, (LivingEntity) shooter), this.getDamage());
            }
        }else{
            entity.damage(this.getDamageSources().magic(),this.getDamage());
        }
    }

    protected void onCollision(HitResult result) {
        super.onCollision(result);
        if (!this.getWorld().isClient) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.playSound(SoundEvents.BLOCK_GLASS_BREAK, 1.1F, 0.8F);
            this.discard();
        }
    }

    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        p_326229_.add(DAMAGE, 0F);
    }

    public float getDamage() {
        return dataTracker.get(DAMAGE);
    }

    public void setDamage(float damage) {
        dataTracker.set(DAMAGE, damage);
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putFloat("damage", this.getDamage());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.setDamage(compound.getFloat("damage"));
    }

    @Override
    protected double getGravity() {
        return 0.03F;
    }
    
    

    @Environment(EnvType.CLIENT)
    public void handleStatus(byte id) {
        if (id == 3) {
            for(int i = 0; i < 20; ++i) {
                this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.AMETHYST_CLUSTER.getDefaultState()), this.getX(), this.getY(), this.getZ(), random.nextGaussian() * 0.2D, random.nextGaussian() * 0.2D, random.nextGaussian() * 0.2D);
            }
        }
    }
}