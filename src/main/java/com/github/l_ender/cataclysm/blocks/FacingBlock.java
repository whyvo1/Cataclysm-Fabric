package com.github.l_ender.cataclysm.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.Direction;

public class FacingBlock extends HorizontalFacingBlock {
    public static final MapCodec<FacingBlock> CODEC = createCodec(FacingBlock::new);
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;


    @Override
    public MapCodec<FacingBlock> getCodec() {
        return CODEC;
    }

    public FacingBlock(Settings p_49046_) {
        super(p_49046_);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> p_49088_) {
        p_49088_.add(FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }
}
