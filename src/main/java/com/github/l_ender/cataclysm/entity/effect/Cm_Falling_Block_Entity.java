package com.github.l_ender.cataclysm.entity.effect;

import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Cm_Falling_Block_Entity extends Entity {
    public int duration;
    protected static final TrackedData<BlockPos> DATA_START_POS = DataTracker.registerData(Cm_Falling_Block_Entity.class, TrackedDataHandlerRegistry.BLOCK_POS);
    private static final TrackedData<BlockState> BLOCK_STATE = DataTracker.registerData(Cm_Falling_Block_Entity.class, TrackedDataHandlerRegistry.BLOCK_STATE);

    public Cm_Falling_Block_Entity(EntityType<Cm_Falling_Block_Entity> type, World level) {
        super(type, level);
        this.duration = 20;
    }

    public Cm_Falling_Block_Entity(World p_31953_, double p_31954_, double p_31955_, double p_31956_, BlockState p_31957_, int duration) {
        this(ModEntities.CM_FALLING_BLOCK, p_31953_);
        this.setBlockState(p_31957_);
        this.setPosition(p_31954_, p_31955_ + (double)((1.0F - this.getHeight()) / 2.0F), p_31956_);
        this.setVelocity(Vec3d.ZERO);
        this.duration = duration;
        this.prevX = p_31954_;
        this.prevY = p_31955_;
        this.prevZ = p_31956_;
        this.setStartPos(this.getBlockPos());
    }


    public void setStartPos(BlockPos p_31960_) {
        this.dataTracker.set(DATA_START_POS, p_31960_);
    }

    public BlockPos getStartPos() {
        return this.dataTracker.get(DATA_START_POS);
    }

    protected void initDataTracker() {
        this.dataTracker.startTracking(DATA_START_POS, BlockPos.ORIGIN);
        this.dataTracker.startTracking(BLOCK_STATE, Blocks.AIR.getDefaultState());
    }

    public BlockState getBlockState() {
        return this.dataTracker.get(BLOCK_STATE);
    }

    public void setBlockState(BlockState p_270267_) {
        this.dataTracker.set(BLOCK_STATE, p_270267_);
    }

    public void tick() {
        if (!this.hasNoGravity()) {
            this.setVelocity(this.getVelocity().add(0.0D, -0.04D, 0.0D));
        }
        this.move(MovementType.SELF, this.getVelocity());
        this.setVelocity(this.getVelocity().multiply(0.98D));

        if (this.isOnGround() && age > duration) {
            discard();
        }
        if (age > 300) {
            discard();
        }

    }

    protected void writeCustomDataToNbt(NbtCompound p_31973_) {
        BlockState blockState = getBlockState();
        p_31973_.put("block_state", NbtHelper.fromBlockState(blockState));
        p_31973_.putInt("Time", this.duration);

    }

    protected void readCustomDataFromNbt(NbtCompound p_31964_) {
        this.setBlockState(NbtHelper.toBlockState(this.getWorld().createCommandRegistryWrapper(RegistryKeys.BLOCK), p_31964_.getCompound("block_state")));
        this.duration = p_31964_.getInt("Time");

    }

    public boolean doesRenderOnFire() {
        return false;
    }

//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return NetworkHooks.getEntitySpawningPacket(this);
//    }

}
