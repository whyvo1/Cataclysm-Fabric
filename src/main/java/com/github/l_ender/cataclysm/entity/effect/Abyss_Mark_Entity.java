package com.github.l_ender.cataclysm.entity.effect;

import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Blast_Portal_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.server.ServerConfigHandler;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import java.util.Optional;
import java.util.UUID;

public class Abyss_Mark_Entity extends Entity {

    @Nullable
    private Entity finalTarget;
    @Nullable
    private UUID targetId;

    private static final TrackedData<Optional<UUID>> CREATOR_ID = DataTracker.registerData(Abyss_Mark_Entity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);

    protected static final TrackedData<Integer> LIFESPAN = DataTracker.registerData(Abyss_Mark_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Float> DAMAGE = DataTracker.registerData(Abyss_Mark_Entity.class, TrackedDataHandlerRegistry.FLOAT);
    private static final TrackedData<Float> HPDAMAGE = DataTracker.registerData(Abyss_Mark_Entity.class, TrackedDataHandlerRegistry.FLOAT);



    public Abyss_Mark_Entity(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    public Abyss_Mark_Entity(World worldIn, double x, double y, double z, int lifespan,float damage,float hpdamage, UUID casterIn, LivingEntity finalTarget) {
        this(ModEntities.ABYSS_MARK, worldIn);
        this.setCreatorEntityUUID(casterIn);
        this.setLifespan(lifespan);
        this.setDamage(damage);
        this.setHpDamage(hpdamage);
        this.finalTarget = finalTarget;
        this.setPosition(x, y, z);
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket(EntityTrackerEntry entity) {
        return new EntitySpawnS2CPacket(this,entity);
    }

    public void tick() {
        super.tick();
        updateMotion();
        Entity owner = getCreatorEntity();
        if (owner != null && !owner.isAlive()) discard();

        this.setLifespan(this.getLifespan() - 1);

        if (!this.getWorld().isClient) {
            if (this.finalTarget == null && this.targetId != null) {
                this.finalTarget = ((ServerWorld) this.getWorld()).getEntity(this.targetId);
                if (this.finalTarget == null) {
                    this.targetId = null;
                }
            }
        }

        if (this.getLifespan() <= 0) {
            if (owner != null){
                this.getWorld().spawnEntity(new Abyss_Blast_Portal_Entity(this.getWorld(), this.getX(),  this.getY(),  this.getZ(), this.getYaw(), 0, this.getDamage(),this.getHpDamage(), (LivingEntity) owner));
            }
            this.remove(RemovalReason.DISCARDED);
        }
    }

    public int getLifespan() {
        return this.dataTracker.get(LIFESPAN);
    }

    public void setLifespan(int i) {
        this.dataTracker.set(LIFESPAN, i);
    }


    public UUID getCreatorEntityUUID() {
        return this.dataTracker.get(CREATOR_ID).orElse(null);
    }

    public void setCreatorEntityUUID(UUID id) {
        this.dataTracker.set(CREATOR_ID, Optional.ofNullable(id));
    }

    public Entity getCreatorEntity() {
        UUID uuid = getCreatorEntityUUID();
        if(uuid != null && !this.getWorld().isClient){
            return ((ServerWorld) getWorld()).getEntity(uuid);
        }
        return null;
    }

    private void updateMotion() {

        Vec3d vec3 = this.getVelocity();
        double h0 = this.getX() + vec3.x;
        double h1 = this.getY() + vec3.y;
        double h2 = this.getZ() + vec3.z;

        if(finalTarget !=null && this.finalTarget.isAlive() || (this.finalTarget instanceof PlayerEntity && !this.finalTarget.isSpectator())) {
            double dx = finalTarget.getX() - this.getX();
            double dz = finalTarget.getZ() - this.getZ();

            double p0 = Math.min(finalTarget.getY(), this.getY() - 50);
            double p1 = Math.max(finalTarget.getY() , this.getY());
            BlockPos blockpos = BlockPos.ofFloored(finalTarget.getX(), p1, finalTarget.getZ());
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
                    break;
                }

                blockpos = blockpos.down();
            } while (blockpos.getY() >= MathHelper.floor(p0) - 1);

            this.setPosition(h0,(double) blockpos.getY() + d0,h2);
            this.setVelocity(vec3.add(dx, 0, dz).multiply(0.05));
        }
    }

    @Override
    protected void initDataTracker(DataTracker.Builder p_326229_) {
        p_326229_.add(CREATOR_ID, Optional.empty());
        p_326229_.add(LIFESPAN, 300);
        p_326229_.add(DAMAGE, 0F);
        p_326229_.add(HPDAMAGE, 0F);
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

    protected void readCustomDataFromNbt(NbtCompound compound) {
        this.setLifespan(compound.getInt("Lifespan"));
        UUID uuid;
        if (compound.containsUuid("Owner")) {
            uuid = compound.getUuid("Owner");
        } else {
            String s = compound.getString("Owner");
            uuid = ServerConfigHandler.getPlayerUuidByName(this.getServer(), s);
        }
        if (compound.containsUuid("Target")) {
            this.targetId = compound.getUuid("Target");
        }
        if (uuid != null) {
            try {
                this.setCreatorEntityUUID(uuid);} catch (Throwable ignored) {

            }
        }
        this.setDamage(compound.getFloat("damage"));
        this.setHpDamage(compound.getFloat("Hpdamage"));
    }

    protected void writeCustomDataToNbt(NbtCompound compound) {
        compound.putInt("Lifespan", getLifespan());
       if (this.getCreatorEntityUUID() != null) {
           compound.putUuid("Owner", this.getCreatorEntityUUID());
        }
        if (this.finalTarget != null) {
            compound.putUuid("Target", this.finalTarget.getUuid());
        }
        compound.putFloat("damage", this.getDamage());
        compound.putFloat("Hpdamage", this.getHpDamage());
    }
}
