package com.github.l_ender.cataclysm.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

public class FacingPillarBlock extends Block {
    public static final BooleanProperty TOP = BooleanProperty.of("top");
    public static final DirectionProperty FACING = Properties.FACING;


    public FacingPillarBlock(Settings p_49046_) {
        super(p_49046_);
        this.setDefaultState(this.getDefaultState().with(TOP, Boolean.TRUE).with(FACING, Direction.UP));
    }


    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState state1, WorldAccess levelAccessor, BlockPos blockPos, BlockPos blockPos1) {
        BlockState pillar = super.getStateForNeighborUpdate(state, direction, state1, levelAccessor, blockPos, blockPos1);
        if (levelAccessor.getBlockState(blockPos.offset(state.get(FACING))).getBlock() instanceof FacingPillarBlock) {
            pillar = pillar.with(TOP, false);
        } else {
            pillar = pillar.with(TOP, true);
        }
        return pillar;
    }



    public BlockState rotate(BlockState p_49085_, BlockRotation p_49086_) {
        return p_49085_.with(FACING, p_49086_.rotate(p_49085_.get(FACING)));
    }

    public BlockState mirror(BlockState p_49082_, BlockMirror p_49083_) {
        return p_49082_.rotate(p_49083_.getRotation(p_49082_.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> p_49088_) {
        p_49088_.add(TOP,FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext context) {
        WorldAccess levelaccessor = context.getWorld();
        BlockPos blockpos = context.getBlockPos();
        BlockState above = levelaccessor.getBlockState(blockpos.offset(context.getPlayerLookDirection().getOpposite()));
        return this.getDefaultState().with(TOP, !(above.getBlock() instanceof FacingPillarBlock)).with(FACING, context.getPlayerLookDirection().getOpposite());
    }
}
