package com.github.l_ender.cataclysm.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;

public class MeltingNetherrack extends Block {
    public static final IntProperty AGE = Properties.AGE_3;

    public MeltingNetherrack(Settings properties) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }

    public void randomTick(BlockState p_221238_, ServerWorld p_221239_, BlockPos p_221240_, Random p_221241_) {
        this.scheduledTick(p_221238_, p_221239_, p_221240_, p_221241_);
    }

    public void scheduledTick(BlockState blockState, ServerWorld serverLevel, BlockPos blockPos, Random randomSource) {
        if (((randomSource.nextInt(3) == 0 && this.slightlyMelt(blockState, serverLevel, blockPos)))) {
            serverLevel.scheduleBlockTick(blockPos, this, MathHelper.nextInt(randomSource, 20, 40));
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    private boolean slightlyMelt(BlockState blockState, ServerWorld level, BlockPos blockPos) {
        final int MAX_AGE_BEFORE_LAVA = 3;
        int i = blockState.get(AGE);
        if (i < MAX_AGE_BEFORE_LAVA) {
            level.setBlockState(blockPos, blockState.with(AGE, i + 1), 2);
            return false;
        } else {
            this.melt(blockState, level, blockPos);
            return true;
        }
    }

    private void melt(BlockState blockState, ServerWorld level, BlockPos blockPos) {
        level.setBlockState(blockPos, Blocks.LAVA.getDefaultState());
    }
    public ItemStack getPickStack(BlockView p_53570_, BlockPos p_53571_, BlockState p_53572_) {
        return ItemStack.EMPTY;
    }
}
