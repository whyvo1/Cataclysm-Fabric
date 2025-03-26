package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


public class Blazing_Bone_Entity extends ThrownItemEntity {
    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Blazing_Bone_Entity.class, TrackedDataHandlerRegistry.FLOAT);


    public Blazing_Bone_Entity(EntityType<? extends Blazing_Bone_Entity> type, World world) {
        super(type, world);
    }

    public Blazing_Bone_Entity(World worldIn,float damage, LivingEntity throwerIn) {
        super(ModEntities.BLAZING_BONE, throwerIn, worldIn);
        this.setDamage(damage);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DAMAGE, 0F);
    }

    public float getDamage() {
        return dataTracker.get(DAMAGE);
    }

    public void setDamage(float damage) {
        dataTracker.set(DAMAGE, damage);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        tag.putFloat("damage", this.getDamage());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
        this.setDamage(tag.getFloat("damage"));
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.BLAZING_BONE;
    }

//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }


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

    @Override
    public boolean hasNoGravity() {
        return false;
    }

    protected void onCollision(HitResult result) {
        super.onCollision(result);
        if (!this.getWorld().isClient) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }
    }

    @Environment(EnvType.CLIENT)
    public void handleStatus(byte id) {
        if (id == 3) {
            for(int i = 0; i < 8; ++i) {
                this.getWorld().addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, new ItemStack(ModItems.BLAZING_BONE)), this.getX(), this.getY(), this.getZ(), random.nextGaussian() * 0.2D, random.nextGaussian() * 0.2D, random.nextGaussian() * 0.2D);
            }
        }
    }
}
