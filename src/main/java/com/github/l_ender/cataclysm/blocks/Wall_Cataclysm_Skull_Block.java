package com.github.l_ender.cataclysm.blocks;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import java.util.Map;

public class Wall_Cataclysm_Skull_Block extends Abstract_Cataclysm_Skull_Block {
    public static final MapCodec<Wall_Cataclysm_Skull_Block> CODEC = RecordCodecBuilder.mapCodec(
            p_308848_ -> p_308848_.group(Cataclysm_Skull_Block.Type.CODEC.fieldOf("kind").forGetter(Abstract_Cataclysm_Skull_Block::getType), createSettingsCodec())
                    .apply(p_308848_, Wall_Cataclysm_Skull_Block::new)
    );
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final Map<Direction, VoxelShape> AABBS = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(4.0D, 4.0D, 8.0D, 12.0D, 12.0D, 16.0D), Direction.SOUTH, Block.createCuboidShape(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 8.0D), Direction.EAST, Block.createCuboidShape(0.0D, 4.0D, 4.0D, 8.0D, 12.0D, 12.0D), Direction.WEST, Block.createCuboidShape(8.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D)));

    public Wall_Cataclysm_Skull_Block(Cataclysm_Skull_Block.Type p_58101_, Settings p_58102_) {
        super(p_58101_, p_58102_);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    public String getTranslationKey() {
        return this.asItem().getTranslationKey();
    }

    public VoxelShape getOutlineShape(BlockState p_58114_, BlockView p_58115_, BlockPos p_58116_, ShapeContext p_58117_) {
        return AABBS.get(p_58114_.get(FACING));
    }

    public BlockState getPlacementState(ItemPlacementContext p_58104_) {
        BlockState blockstate = this.getDefaultState();
        BlockView blockgetter = p_58104_.getWorld();
        BlockPos blockpos = p_58104_.getBlockPos();
        Direction[] adirection = p_58104_.getPlacementDirections();

        for(Direction direction : adirection) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction1 = direction.getOpposite();
                blockstate = blockstate.with(FACING, direction1);
                if (!blockgetter.getBlockState(blockpos.offset(direction)).canReplace(p_58104_)) {
                    return blockstate;
                }
            }
        }

        return null;
    }

    
    public BlockState rotate(BlockState p_58109_, BlockRotation p_58110_) {
        return p_58109_.with(FACING, p_58110_.rotate(p_58109_.get(FACING)));
    }

    public BlockState mirror(BlockState p_58106_, BlockMirror p_58107_) {
        return p_58106_.rotate(p_58107_.getRotation(p_58106_.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> p_58112_) {
        p_58112_.add(FACING);
    }
    
    @Override
    public MapCodec<? extends Wall_Cataclysm_Skull_Block> getCodec() {
        return CODEC;
    }

}
