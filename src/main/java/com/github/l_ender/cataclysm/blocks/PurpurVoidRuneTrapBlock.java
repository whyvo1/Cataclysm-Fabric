package com.github.l_ender.cataclysm.blocks;

import com.github.l_ender.cataclysm.entity.projectile.Void_Rune_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PurpurVoidRuneTrapBlock extends TrapBlock {
    //The code and texture were brought from savage and ravage. Thx abnormal
    public PurpurVoidRuneTrapBlock(Settings properties) {
        super(properties);
    }

    /**
     * Called when the given entity walks on this Block
     */

    public void onSteppedOn(World worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        activate(worldIn.getBlockState(pos), worldIn, pos, entityIn);
        super.onSteppedOn(worldIn, pos, state, entityIn);
    }

    private static void activate(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!state.get(LIT) && shouldTrigger(entity)) {
            Void_Rune_Entity voidrune = ModEntities.VOID_RUNE.create(world);
            if (voidrune != null) {
                voidrune.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0.0F, 0.0F);
                world.spawnEntity(voidrune);
            }
            ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 50,3));
            world.setBlockState(pos, state.with(LIT, Boolean.TRUE), 3);
        }
    }
}
