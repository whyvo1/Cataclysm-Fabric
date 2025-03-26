package com.github.l_ender.cataclysm.blocks;

import com.github.l_ender.cataclysm.init.ModTileentites;
import com.github.l_ender.cataclysm.blockentities.ObsidianExplosionTrapBricks_Block_Entity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ObsidianExplosionTrapBricks extends BlockWithEntity {
    public static final BooleanProperty LIT = Properties.LIT;

    public ObsidianExplosionTrapBricks(Settings properties) {
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

    public void randomDisplayTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (stateIn.get(LIT)) {
            spawnParticles(worldIn, pos);
        }

    }

    public BlockRenderType getRenderType(BlockState p_149645_1_) {
        return BlockRenderType.MODEL;
    }

    private static void spawnParticles(World world, BlockPos worldIn) {
        double d0 = 0.5625D;
        Random random = world.random;

        for(Direction direction : Direction.values()) {
            BlockPos blockpos = worldIn.offset(direction);
            if (!world.getBlockState(blockpos).isOpaqueFullCube(world, blockpos)) {
                Direction.Axis direction$axis = direction.getAxis();
                double d1 = direction$axis == Direction.Axis.X ? 0.5D + d0 * (double)direction.getOffsetX() : (double)random.nextFloat();
                double d2 = direction$axis == Direction.Axis.Y ? 0.5D + d0 * (double)direction.getOffsetY() : (double)random.nextFloat();
                double d3 = direction$axis == Direction.Axis.Z ? 0.5D + d0 * (double)direction.getOffsetZ() : (double)random.nextFloat();
                world.addParticle(ParticleTypes.REVERSE_PORTAL, (double)worldIn.getX() + d1, (double)worldIn.getY() + d2, (double)worldIn.getZ() + d3, 0.0D, 0.0D, 0.0D);
            }
        }


    }

    public static boolean shouldTrigger(Entity entity) {
        return TrapBlock.shouldTrigger(entity);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    private static void activate(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!state.get(LIT) && shouldTrigger(entity)) {
            world.setBlockState(pos, state.with(LIT, Boolean.TRUE), 3);
        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ObsidianExplosionTrapBricks_Block_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return checkType(p_152182_, ModTileentites.OBSIDIAN_EXPLOSION_TRAP_BRICKS, ObsidianExplosionTrapBricks_Block_Entity::commonTick);
    }

}