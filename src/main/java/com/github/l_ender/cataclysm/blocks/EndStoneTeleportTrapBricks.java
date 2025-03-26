package com.github.l_ender.cataclysm.blocks;


import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EndStoneTeleportTrapBricks extends TrapBlock {

    public EndStoneTeleportTrapBricks(Settings properties) {
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
            double d0 = entity.getX() + (entity.getWorld().random.nextDouble() - 0.5D) * 16.0D;
            double d1 = entity.getY();
            double d2 = entity.getZ() + (entity.getWorld().random.nextDouble() - 0.5D) * 16.0D;
            ((LivingEntity)entity).teleport(d0, d1, d2,false);

            ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 25));
            world.setBlockState(pos, state.with(LIT, Boolean.TRUE), 3);
            world.playSound(null, pos, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }

}
