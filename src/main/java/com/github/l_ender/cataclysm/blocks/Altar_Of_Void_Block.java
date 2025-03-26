package com.github.l_ender.cataclysm.blocks;

import com.github.l_ender.cataclysm.init.ModTileentites;
import com.github.l_ender.cataclysm.blockentities.AltarOfVoid_Block_Entity;
import com.mojang.serialization.MapCodec;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Altar_Of_Void_Block extends BlockWithEntity {
    public static final MapCodec<Altar_Of_Void_Block> CODEC = createCodec(Altar_Of_Void_Block::new);
    private static final VoxelShape BASE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 4.0D, 15.0D);
    private static final VoxelShape MID = Block.createCuboidShape(2.0D, 4.0D, 2.0D, 14.0D, 10.0D, 14.0D);
    private static final VoxelShape TOP = Block.createCuboidShape(0.0D, 10.0D, 0.0D, 16.0D, 14.0D, 16.0D);
    private static final VoxelShape AXIS_AABB = VoxelShapes.union(BASE,MID, TOP);

    @Override
    public MapCodec<Altar_Of_Void_Block> getCodec() {
        return CODEC;
    }


    public Altar_Of_Void_Block(AbstractBlock.Settings p_54257_) {
        super(p_54257_);

    }

    public VoxelShape getOutlineShape(BlockState p_48816_, BlockView p_48817_, BlockPos p_48818_, ShapeContext p_48819_) {
        return AXIS_AABB;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AltarOfVoid_Block_Entity(pos, state);
    }


    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return validateTicker(p_152182_, ModTileentites.ALTAR_OF_VOID, AltarOfVoid_Block_Entity::commonTick);
    }
}