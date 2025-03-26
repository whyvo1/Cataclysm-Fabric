package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


import org.jetbrains.annotations.Nullable;


public class Void_Shard_Entity extends ThrownItemEntity {

    private BlockState lastState;

    private Entity ignoreEntity = null;

    public Void_Shard_Entity(EntityType<? extends Void_Shard_Entity> type, World world) {
        super(type, world);
    }

    public Void_Shard_Entity(EntityType type, World worldIn, LivingEntity throwerIn) {
        super(type, throwerIn, worldIn);

    }

    public Void_Shard_Entity(World worldIn, LivingEntity throwerIn, double x, double y, double z, Vec3d movement, @Nullable Entity ignore) {
        super(ModEntities.VOID_SHARD, x, y, z, worldIn);
        this.setOwner(throwerIn);
        this.setVelocity(movement);
        this.ignoreEntity = ignore;
    }




    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        if (this.lastState != null) {
            tag.put("inBlockState", NbtHelper.fromBlockState(this.lastState));
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
        if (tag.contains("inBlockState", 10)) {
            tag.put("inBlockState", NbtHelper.fromBlockState(this.lastState));
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.VOID_SHARD;
    }

    

    @Override
    protected void onBlockHit(BlockHitResult hit) {
        this.lastState = this.getWorld().getBlockState(hit.getBlockPos());
        super.onBlockHit(hit);
        Vec3d Vec3 = hit.getPos().subtract(this.getX(), this.getY(), this.getZ());
        this.setVelocity(Vec3);
        Vec3d Vec31 = Vec3.normalize().multiply(getFinalGravity());
        this.setPos(this.getX() - Vec31.x, this.getY() - Vec31.y, this.getZ() - Vec31.z);
    }

    @Override
    protected void onEntityHit(EntityHitResult result) {
        super.onEntityHit(result);
        Entity shooter = this.getOwner();
        Entity entity = result.getEntity();
        float i = 1.5f;
        if (shooter == null) {
            entity.damage(this.getDamageSources().magic(), i);
            entity.timeUntilRegen = 0;
        }else {
            if (!((entity == shooter) ||(shooter.isTeammate(entity)))) {
                entity.damage(this.getDamageSources().indirectMagic(this, this.getOwner()), i);
                entity.timeUntilRegen = 0;
            }
        }

    }

    public void setVelocity(Entity p_234612_1_, float p_234612_2_, float p_234612_3_, float p_234612_4_, float p_234612_5_, float p_234612_6_) {
        float f = (float) (-Math.sin(p_234612_3_ * ((float) Math.PI / 180F)) * Math.cos(p_234612_2_ * ((float) Math.PI / 180F)));
        float f1 = (float) -Math.sin((p_234612_2_ + p_234612_4_) * ((float) Math.PI / 180F));
        float f2 = (float) (Math.cos(p_234612_3_ * ((float) Math.PI / 180F)) * Math.cos(p_234612_2_ * ((float) Math.PI / 180F)));
        this.setVelocity(f, f1, f2, p_234612_5_, p_234612_6_);
        Vec3d Vec3 = p_234612_1_.getVelocity();
        this.setVelocity(this.getVelocity().add(Vec3.x, p_234612_1_.isOnGround() ? 0.0D : Vec3.y, Vec3.z));
    }

    @Override
    protected boolean canHit(Entity entity) {
        if(entity == ignoreEntity) return false;
        return super.canHit(entity);
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
                this.getWorld().addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, new ItemStack(ModItems.VOID_SHARD)), this.getX(), this.getY(), this.getZ(), random.nextGaussian() * 0.1D, random.nextGaussian() * 0.1D, random.nextGaussian() * 0.1D);
            }
        }
    }
}
