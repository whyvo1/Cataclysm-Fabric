package com.github.l_ender.cataclysm.blockentities;

import com.github.l_ender.cataclysm.init.ModTileentites;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Abyssal_Egg_Block_Entity extends BlockEntity {



    public int tickCount;

    public Abyssal_Egg_Block_Entity(BlockPos pos, BlockState state) {
        super(ModTileentites.ABYSSAL_EGG, pos, state);
    }

    public static void commonTick(World level, BlockPos pos, BlockState state, Abyssal_Egg_Block_Entity entity) {
        entity.tick();

    }

    public void tick() {
        tickCount++;

    }

}
