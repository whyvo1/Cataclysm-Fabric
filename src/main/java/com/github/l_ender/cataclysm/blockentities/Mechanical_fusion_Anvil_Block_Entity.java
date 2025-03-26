package com.github.l_ender.cataclysm.blockentities;


import com.github.l_ender.cataclysm.init.ModTileentites;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Mechanical_fusion_Anvil_Block_Entity extends BlockEntity {



    public int tickCount;

    public Mechanical_fusion_Anvil_Block_Entity(BlockPos pos, BlockState state) {
        super(ModTileentites.MECHANICAL_FUSION_ANVIL, pos, state);
    }

    public static void commonTick(World level, BlockPos pos, BlockState state, Mechanical_fusion_Anvil_Block_Entity entity) {
        entity.tick();

    }

    public void tick() {
        tickCount++;

    }

}
