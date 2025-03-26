package com.github.l_ender.cataclysm.blocks;

import com.github.l_ender.cataclysm.init.ModTag;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class SandStoneTrapBlock extends Block {
    public static final BooleanProperty LIT = Properties.LIT;


    public SandStoneTrapBlock(Settings properties) {
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
        super.onSteppedOn(worldIn, pos, state, entityIn);
    }

    @Environment(value= EnvType.CLIENT)
    public void randomDisplayTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
    }


    public static boolean shouldTrigger(Entity entity) {
        if(entity instanceof LivingEntity) {
            if (!entity.getType().isIn(ModTag.SANDSTONE_TRAP_NOT_DETECTED)) {
                if (entity instanceof PlayerEntity) {
                    return !((PlayerEntity) entity).isCreative() && !entity.isSpectator();
                } else return !(entity instanceof ArmorStandEntity);
            }
        }
        return false;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }
}
