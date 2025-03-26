package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
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



public class Lionfish_Spike_Entity extends ThrownItemEntity {


    public Lionfish_Spike_Entity(EntityType<? extends Lionfish_Spike_Entity> type, World world) {
        super(type, world);
    }

    public Lionfish_Spike_Entity(World worldIn, LivingEntity throwerIn) {
        super(ModEntities.LIONFISH_SPIKE, throwerIn, worldIn);
    }


    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.LIONFISH_SPIKE;
    }

    @Override
    protected void onEntityHit(EntityHitResult result) {
        super.onEntityHit(result);
        Entity shooter = this.getOwner();
        Entity entity = result.getEntity();
        float i = (float) CMConfig.BlazingBonedamage;
        if (shooter instanceof LivingEntity) {
            if (!((entity == shooter) || (shooter.isTeammate(entity)))) {
                if(entity.damage(this.getDamageSources().mobProjectile(this, (LivingEntity) shooter), i)) {
                    if (entity instanceof LivingEntity) {
                        ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60, 0), this);
                    }
                }
            }
        }else{
            entity.damage(this.getDamageSources().mobProjectile(this, null), i);
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
                this.getWorld().addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, new ItemStack(ModItems.LIONFISH_SPIKE)), this.getX(), this.getY(), this.getZ(), random.nextGaussian() * 0.2D, random.nextGaussian() * 0.2D, random.nextGaussian() * 0.2D);
            }
        }
    }

}
