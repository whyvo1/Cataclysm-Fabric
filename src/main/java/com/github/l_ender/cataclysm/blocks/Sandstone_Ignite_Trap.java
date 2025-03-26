package com.github.l_ender.cataclysm.blocks;

import com.github.l_ender.cataclysm.blockentities.SandstoneIgniteTrap_Block_Entity;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTileentites;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Sandstone_Ignite_Trap extends BlockWithEntity {
    public static final BooleanProperty LIT = Properties.LIT;

    public Sandstone_Ignite_Trap(Settings properties) {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(LIT, Boolean.FALSE));
    }

    public boolean hasRandomTicks(BlockState state) {
        return state.get(LIT);
    }

    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (state.get(LIT)) {
            worldIn.setBlockState(pos, state.with(LIT, Boolean.FALSE), 3);
        }

    }

    public void onSteppedOn(World worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        activate(worldIn.getBlockState(pos), worldIn, pos, entityIn);
        super.onSteppedOn(worldIn, pos, state, entityIn);
    }



    public BlockRenderType getRenderType(BlockState p_149645_1_) {
        return BlockRenderType.MODEL;
    }

    public static boolean shouldTrigger(Entity entity) {
        return SandStoneTrapBlock.shouldTrigger(entity);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    private static void activate(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!state.get(LIT) && shouldTrigger(entity)) {
            world.setBlockState(pos, state.with(LIT, Boolean.TRUE), 3);
            world.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, ModSounds.FLAME_TRAP, SoundCategory.BLOCKS, 1.0F + world.random.nextFloat(), world.random.nextFloat() * 0.7F + 0.3F, false);
        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SandstoneIgniteTrap_Block_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return checkType(p_152182_, ModTileentites.SANDSTONE_IGNITE_TRAP, SandstoneIgniteTrap_Block_Entity::commonTick);
    }




}
