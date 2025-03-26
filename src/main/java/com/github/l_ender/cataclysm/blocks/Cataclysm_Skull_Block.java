package com.github.l_ender.cataclysm.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;


public class Cataclysm_Skull_Block extends Abstract_Cataclysm_Skull_Block {
    public static final int MAX = RotationPropertyHelper.getMax();
    private static final int ROTATIONS = MAX + 1;
    public static final IntProperty ROTATION = Properties.ROTATION;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);

    public Cataclysm_Skull_Block(Cataclysm_Skull_Block.Type p_56318_, AbstractBlock.Settings p_56319_) {
        super(p_56318_, p_56319_);
        this.setDefaultState(this.stateManager.getDefaultState().with(ROTATION, 0));
    }

    public VoxelShape getOutlineShape(BlockState p_56331_, BlockView p_56332_, BlockPos p_56333_, ShapeContext p_56334_) {
        return SHAPE;
    }

    public VoxelShape getCullingShape(BlockState p_56336_, BlockView p_56337_, BlockPos p_56338_) {
        return VoxelShapes.empty();
    }

    public BlockState getPlacementState(ItemPlacementContext p_56321_) {
        return this.getDefaultState().with(ROTATION, RotationPropertyHelper.fromYaw(p_56321_.getPlayerYaw()));
    }

    public BlockState rotate(BlockState p_56326_, BlockRotation p_56327_) {
        return p_56326_.with(ROTATION, p_56327_.rotate(p_56326_.get(ROTATION), ROTATIONS));
    }

    public BlockState mirror(BlockState p_56323_, BlockMirror p_56324_) {
        return p_56323_.with(ROTATION, p_56324_.mirror(p_56323_.get(ROTATION), ROTATIONS));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> p_56329_) {
        p_56329_.add(ROTATION);
    }

    public interface Type {
    }

    public enum Types implements Cataclysm_Skull_Block.Type {
        KOBOLEDIATOR,
        APTRGANGR,
        DRAUGR
    }
}
