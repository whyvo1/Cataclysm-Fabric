package com.github.l_ender.cataclysm.entity.projectile;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Part;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalFluidTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Lava_Bomb_Entity extends ThrownEntity {

    private static final TrackedData<Boolean> ON_GROUND = DataTracker.registerData(Lava_Bomb_Entity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Integer> LAVA_TIME = DataTracker.registerData(Lava_Bomb_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> MAX_LAVA_TIME = DataTracker.registerData(Lava_Bomb_Entity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<BlockPos> LAVA_POS = DataTracker.registerData(Lava_Bomb_Entity.class, TrackedDataHandlerRegistry.BLOCK_POS);

    public Lava_Bomb_Entity(EntityType<Lava_Bomb_Entity> type, World world) {
        super(type, world);
    }

    public Lava_Bomb_Entity(EntityType<Lava_Bomb_Entity> type, World world, LivingEntity thrower) {
        super(type, thrower, world);
    }


    protected void initDataTracker() {
        this.dataTracker.startTracking(ON_GROUND, false);
        this.dataTracker.startTracking(LAVA_TIME, 0);
        this.dataTracker.startTracking(MAX_LAVA_TIME, 200);
        this.dataTracker.startTracking(LAVA_POS, BlockPos.ORIGIN);
    }

    @Override
    protected void onCollision(HitResult ray) {
        HitResult.Type raytraceresult$type = ray.getType();
        if (raytraceresult$type == HitResult.Type.ENTITY) {
            this.onEntityHit((EntityHitResult) ray);
        } else if (raytraceresult$type == HitResult.Type.BLOCK) {
            this.onBlockHit((BlockHitResult) ray);
        }
    }

    protected void onEntityHit(EntityHitResult result) {
        super.onEntityHit(result);
        Entity shooter = this.getOwner();
        if (!this.isOnGround() && !this.getWorld().isClient && !(result.getEntity() instanceof Lava_Bomb_Entity || result.getEntity() instanceof Netherite_Monstrosity_Part || result.getEntity() instanceof Netherite_Monstrosity_Entity)) {
            this.playSound(SoundEvents.ENTITY_GENERIC_BURN, 1.5f, 0.75f);
            this.getWorld().createExplosion(shooter, this.getX(), this.getY(), this.getZ(), CMConfig.Lavabombradius, World.ExplosionSourceType.NONE);
            this.doTerrainEffects();
            this.setOnGround(true);
        }
    }

    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);
        if (!this.getWorld().isClient() && !this.isOnGround()) {
            this.playSound(SoundEvents.ENTITY_GENERIC_BURN, 1.5f, 0.75f);
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), CMConfig.Lavabombradius, World.ExplosionSourceType.NONE);
            this.doTerrainEffects();
            this.setOnGround(true);
        }
    }


    protected void doTerrainEffects() {
        BlockPos landed = this.getBlockPos();
        while (landed.getY() < getWorld().getTopY() && (!getWorld().getBlockState(landed).isAir() || !getWorld().getBlockState(landed).getFluidState().isEmpty() && !getWorld().getBlockState(landed).getFluidState().isIn(ConventionalFluidTags.LAVA))) {
            landed = landed.up();
        }
        setLavaPos(landed);
        if (getWorld().getBlockState(this.getLavaPos()).isAir()) {
            BlockState fluid = Blocks.LAVA.getDefaultState();
            getWorld().setBlockState(this.getLavaPos(), fluid);
        }

    }

    @Override
    public void tick() {
        super.tick();
        if(this.isOnGround()) {
            this.setLavaTime(this.getLavaTime() + 1);
            this.setVelocity(Vec3d.ZERO);
            if (!this.getWorld().isClient) {
                if (this.getLavaTime() >= this.getMaxLavaTime() && this.getLavaPos() != BlockPos.ORIGIN) {
                    this.discard();
                }
            }
        }else{
            makeTrail();
        }

    }

    public void remove(RemovalReason reason) {
        super.remove(reason);
        if (!this.getWorld().isClient) {
            if (this.getLavaPos() != BlockPos.ORIGIN) {
                if (getWorld().getFluidState(this.getLavaPos()).isIn(ConventionalFluidTags.LAVA)) {
                    getWorld().setBlockState(this.getLavaPos(), Blocks.AIR.getDefaultState());
                }
            }
        }

    }

    protected void makeTrail() {
        if (this.getWorld().isClient){
            for (int i = 0; i < 5; i++) {
                double dx = getX() + 1.5F * (random.nextFloat() - 0.5F);
                double dy = getY() + 1.5F * (random.nextFloat() - 0.5F);
                double dz = getZ() + 1.5F * (random.nextFloat() - 0.5F);

                getWorld().addParticle(ParticleTypes.FLAME, dx, dy, dz, -getVelocity().getX(), -getVelocity().getY(), -getVelocity().getZ());
            }
        }
    }


    public void setLavaPos(BlockPos p_31960_) {
        this.dataTracker.set(LAVA_POS, p_31960_);
    }

    public BlockPos getLavaPos() {
        return this.dataTracker.get(LAVA_POS);
    }

    public boolean getGround() {
        return this.dataTracker.get(ON_GROUND);
    }

    public void setGround(boolean weapon) {
        this.dataTracker.set(ON_GROUND, weapon);
    }


    public int getLavaTime() {
        return this.dataTracker.get(LAVA_TIME);
    }

    public void setLavaTime(int time) {
        this.dataTracker.set(LAVA_TIME, time);
    }

    public int getMaxLavaTime() {
        return this.dataTracker.get(MAX_LAVA_TIME);
    }

    public void setMaxLavaTime(int time) {
        this.dataTracker.set(MAX_LAVA_TIME, time);
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.setGround(compound.getBoolean("bomb_ground"));
        this.setLavaTime(compound.getInt("lava_time"));
        this.setMaxLavaTime(compound.getInt("max_lava_time"));

        int i = compound.getInt("LavaPosX");
        int j = compound.getInt("LavaPosY");
        int k = compound.getInt("LavaPosZ");
        this.setLavaPos(new BlockPos(i, j, k));
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);

        compound.putInt("LavaPosX", this.getLavaPos().getX());
        compound.putInt("LavaPosY", this.getLavaPos().getY());
        compound.putInt("LavaPosZ", this.getLavaPos().getZ());
        compound.putInt("lava_time", this.getLavaTime());
        compound.putInt("max_lava_time", this.getMaxLavaTime());
        compound.putBoolean("bomb_ground", this.getGround());
    }

    public float getBrightnessAtEyes() {
        return 1.0F;
    }

    @Override
    protected float getGravity() {
        return this.isOnGround() ? 0F : 0.025F;
    }

//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }
}