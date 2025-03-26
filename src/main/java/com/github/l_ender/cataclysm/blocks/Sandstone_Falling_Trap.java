package com.github.l_ender.cataclysm.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.LandingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Sandstone_Falling_Trap extends SandStoneTrapBlock implements LandingBlock {

    public Sandstone_Falling_Trap(Settings properties) {
        super(properties);

    }

    public void onSteppedOn(World worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        activate(worldIn.getBlockState(pos), worldIn, pos, entityIn);
        super.onSteppedOn(worldIn, pos, state, entityIn);
    }

    private void activate(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!state.get(LIT) && shouldTrigger(entity)) {
            if (isFree(world.getBlockState(pos.down())) && pos.getY() >= world.getBottomY()) {
                FallingBlockEntity fallingblockentity = FallingBlockEntity.spawnFromBlock(world, pos, state);
                this.falling(fallingblockentity);
            }
        }
    }

    public static boolean isFree(BlockState p_53242_) {
        return p_53242_.isAir() || p_53242_.isIn(BlockTags.FIRE) || p_53242_.isLiquid() || p_53242_.isReplaceable();
    }

    protected void falling(FallingBlockEntity p_53206_) {
    }
}
