package com.github.l_ender.cataclysm.blocks;

import com.github.l_ender.cataclysm.entity.projectile.Poison_Dart_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class Sandstone_Poison_Dart_Trap extends Block {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty LIT = Properties.LIT;

    public Sandstone_Poison_Dart_Trap(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(LIT, Boolean.FALSE));

    }

    public static Vec3d getDispensePosition(BlockPos coords, Direction dir) {
        double d0 = coords.getX() + 0.5D + 0.7D * (double) dir.getOffsetX();
        double d1 = coords.getY() + 0.15D + 0.7D * (double) dir.getOffsetY();
        double d2 = coords.getZ() + 0.5D + 0.7D * (double) dir.getOffsetZ();
        return new Vec3d(d0, d1, d2);
    }

    public void neighborUpdate(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        tickGustmaker(state, worldIn, pos, false);
    }

    public void scheduledTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        tickGustmaker(state, worldIn, pos, true);
    }

    public void tickGustmaker(BlockState state, World worldIn, BlockPos pos, boolean tickOff) {
        boolean flag = worldIn.isReceivingRedstonePower(pos) || worldIn.isReceivingRedstonePower(pos.down()) || worldIn.isReceivingRedstonePower(pos.up());
        boolean flag1 = state.get(LIT);
        if (flag && !flag1) {
            if (worldIn.canSetBlock(pos)) {
                Vec3d dispensePosition = getDispensePosition(pos, state.get(FACING));
                Direction direction = state.get(FACING);
                Poison_Dart_Entity dart = new Poison_Dart_Entity(ModEntities.POISON_DART,dispensePosition.x, (float) dispensePosition.y +0.25F, (float) dispensePosition.z,worldIn);
                dart.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
                dart.setVelocity(direction.getOffsetX(), (float)direction.getOffsetY() + 0.1F, direction.getOffsetZ(), 2.5f, 1.0f);
                worldIn.spawnEntity(dart);
            }
            worldIn.setBlockState(pos, state.with(LIT, Boolean.TRUE), 2);
            worldIn.scheduleBlockTick(pos, this, 20);
        } else if (flag1) {
            if (tickOff) {
                worldIn.scheduleBlockTick(pos, this, 20);
                worldIn.setBlockState(pos, state.with(LIT, Boolean.FALSE), 2);
            }
        }
    }

    public BlockState getPlacementState(ItemPlacementContext p_48689_) {
        return this.getDefaultState().with(FACING, p_48689_.getHorizontalPlayerFacing().getOpposite());
    }

    public BlockState rotate(BlockState state, BlockRotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }
}
