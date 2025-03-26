package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class Void_Scatter_Arrow_Entity extends PersistentProjectileEntity {

    public Void_Scatter_Arrow_Entity(EntityType type, World worldIn) {
        super(type, worldIn);
    }

    public Void_Scatter_Arrow_Entity(EntityType type, double x, double y, double z, World worldIn) {
        this(type, worldIn);
        this.setPosition(x, y, z);
    }

    public Void_Scatter_Arrow_Entity(World worldIn, LivingEntity shooter) {
        this(ModEntities.VOID_SCATTER_ARROW, shooter.getX(), shooter.getEyeY() - (double)0.1F, shooter.getZ(), worldIn);
        this.setOwner(shooter);
        if (shooter instanceof PlayerEntity) {
            this.pickupType = PickupPermission.ALLOWED;
        }
    }

//    public Void_Scatter_Arrow_Entity(PlayMessages.SpawnEntity spawnEntity, World world) {
//        this(ModEntities.VOID_SCATTER_ARROW, world);
//    }

//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(Items.ARROW);
    }


    @Override
    protected void onCollision(HitResult hit) {
        super.onCollision(hit);
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        if (this.getWorld().isClient){
            for (int l2 = 0; l2 < 8; ++l2) {
                this.getWorld().addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, new ItemStack(ModItems.VOID_SCATTER_ARROW)), x, y, z, random.nextGaussian() * 0.1D, random.nextDouble() * 0.15D, random.nextGaussian() * 0.1D);
            }
        }
        else {
            List<Vec3d> directions = getShootVectors(this.random,0);
            for (Vec3d vec : directions) {
                Entity target = null;
                Direction dir = Direction.UP;
                if (hit.getType() == HitResult.Type.ENTITY) {
                    target = ((EntityHitResult) hit).getEntity();
                } else if (hit.getType() == HitResult.Type.BLOCK) {
                    dir = ((BlockHitResult)hit).getSide();
                }
                vec = vec.multiply(0.35f);
                vec = this.mulPoseVector(vec,dir);
                Void_Shard_Entity shard = new Void_Shard_Entity(getWorld(), (LivingEntity) this.getOwner(),
                        x+vec.x,y+vec.y+0.25, vec.z+z, vec, target);
                getWorld().spawnEntity(shard);
            }

            this.playSound(SoundEvents.BLOCK_GLASS_BREAK, 1.1F, 0.8F);

        }
        this.discard();
    }

    public List<Vec3d> getShootVectors(Random random, float uncertainty){
        List<Vec3d> vectors = new ArrayList<>();
        float turnFraction = (1 + MathHelper.sqrt(5))/2;
        int numPoints = 17;
        double fullness = 0.8;
        for (int i = 1; i <= numPoints; i++){
            float dst = i / ((float)numPoints);
            //in degrees cause Mth sin are in deg
            float inclination = (random.nextFloat() - 0.5f) * uncertainty
                    + (float) (  Math.acos(1 - fullness * dst));
            float azimuth = (float) ((random.nextFloat() - 0.5f) * uncertainty
                    + (2f*Math.PI) * (random.nextFloat() + (turnFraction * i)));

            double x = Math.sin(inclination) * Math.cos(azimuth);
            double z = Math.sin(inclination) * Math.sin(azimuth);
            double y = Math.cos(inclination);

            Vec3d vec = new Vec3d(x, y, z);

            if(i==1){
                vec = vec.add(0, 1,0);
                vec = vec.multiply(0.5);
            }

            vectors.add(vec);
        }
        return vectors;
    }

    private Vec3d mulPoseVector(Vec3d v, Direction dir){
        return switch (dir) {
            case DOWN -> v.multiply(0d, -1d, 0d);
            case NORTH -> new Vec3d(v.z, v.x, -v.y);
            case SOUTH -> new Vec3d(v.z, v.x, v.y);
            case WEST -> new Vec3d(-v.y, v.z, v.x);
            case EAST -> new Vec3d(v.y, v.z, v.x);
            default -> v;
        };
    }
}
