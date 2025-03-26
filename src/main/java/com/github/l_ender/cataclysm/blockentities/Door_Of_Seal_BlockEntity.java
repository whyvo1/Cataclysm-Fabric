package com.github.l_ender.cataclysm.blockentities;

import com.github.l_ender.cataclysm.blocks.Door_of_Seal_Block;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.init.ModBlocks;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.github.l_ender.cataclysm.init.ModTileentites;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Door_Of_Seal_BlockEntity extends BlockEntity {
    public int Animaitonticks;
    public int tickCount;
    public int animation = 0;
    public Direction facing;
    public AnimationState openingAnimationState = new AnimationState();
    public AnimationState openAnimationState = new AnimationState();

    public Door_Of_Seal_BlockEntity(BlockPos pos, BlockState state) {
        super(ModTileentites.DOOR_OF_SEAL, pos, state);
        facing = state.get(Properties.HORIZONTAL_FACING);
    }

    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "opening" -> openingAnimationState;
            case "open" -> openAnimationState;
            default -> new AnimationState();
        };
    }

    public boolean onSyncedBlockEvent(int p_58837_, int p_58838_) {
        if (p_58837_ == 1) {
            this.openingAnimationState.start(this.tickCount);
            return true;
        } else {
            return super.onSyncedBlockEvent(p_58837_, p_58838_);
        }
    }


    public static void tick(World level, BlockPos pos, BlockState blockState, Door_Of_Seal_BlockEntity entity) {
        entity.tickCount++;
        if(blockState.getBlock() instanceof Door_of_Seal_Block) {
            if (blockState.get(Door_of_Seal_Block.LIT)) {
                ++entity.Animaitonticks;

                    if (!blockState.get(Door_of_Seal_Block.OPEN)) {
                        if (entity.Animaitonticks == 1) {
                            ScreenShake_Entity.ScreenShake(level, Vec3d.ofCenter(pos), 20, 0.05f, 0, 120);
                        }

                        if (entity.Animaitonticks == 28) {
                            level.playSound((PlayerEntity)null, pos, ModSounds.DOOR_OF_SEAL_OPEN, SoundCategory.BLOCKS, 4F, level.random.nextFloat() * 0.2F + 1.0F);

                            float x = pos.getX() + 0.5F;
                            float y = pos.getY();
                            float z = pos.getZ() + 0.5F;
                            if (!level.isClient) {
                                level.createExplosion(null, x, y + 1, z, 2.0F, World.ExplosionSourceType.TRIGGER);
                            }
                        }
                        if (entity.Animaitonticks >= 145) {
                            if (!level.isClient) {
                                level.setBlockState(pos, blockState.with(Door_of_Seal_Block.OPEN, Boolean.TRUE), 2);
                                for (int i = 0; i <= 7; i++) {
                                    BlockPos abovePos = pos.up(i);
                                    BlockPos blockpos1 = abovePos.offset(blockState.get(Door_of_Seal_Block.FACING).rotateYClockwise());
                                    BlockPos blockpos2 = abovePos;
                                    BlockPos blockpos3 = abovePos.offset(blockState.get(Door_of_Seal_Block.FACING).rotateYCounterclockwise());
                                    BlockPos blockpos4 = abovePos.offset(blockState.get(Door_of_Seal_Block.FACING).rotateYClockwise(), 2);
                                    BlockPos blockpos5 = abovePos.offset(blockState.get(Door_of_Seal_Block.FACING).rotateYCounterclockwise(), 2);
                                    BlockPos[] toBreakPoses = {blockpos1, blockpos2, blockpos3, blockpos4, blockpos5};
                                    for (BlockPos toBreakPos : toBreakPoses) {
                                        BlockState blockstate = level.getBlockState(toBreakPos);
                                        if (blockstate.isOf(ModBlocks.DOOR_OF_SEAL_PART)) {
                                            level.setBlockState(toBreakPos, blockstate.with(Door_of_Seal_Block.Door_Of_Seal_Part_Block.OPEN, Boolean.TRUE), 2);
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        entity.Animaitonticks = 0;
                        if (level.isClient) {
                            entity.openingAnimationState.stop();
                            entity.openAnimationState.startIfNotRunning(entity.tickCount);
                        }
                    }

            }
        }
    }

    public void onHit(World level) {
        BlockPos blockpos = this.getPos();
        BlockState state = this.getCachedState();
        if (!state.get(Door_of_Seal_Block.LIT)) {
            level.setBlockState(blockpos, state.with(Door_of_Seal_Block.LIT, Boolean.TRUE), 2);
            this.world.addSyncedBlockEvent(blockpos, this.getCachedState().getBlock(), 1, 0);
        }
    }

    @Override
    protected void readNbt(NbtCompound p_155745_, RegistryWrapper.WrapperLookup p_323876_) {
        super.readNbt(p_155745_, p_323876_);
        this.Animaitonticks = p_155745_.getInt("animationTicks");

    }

    @Override
    protected void writeNbt(NbtCompound p_187518_, RegistryWrapper.WrapperLookup p_324418_) {
        super.writeNbt(p_187518_, p_324418_);
        p_187518_.putInt("animationTicks", this.Animaitonticks);
    }

}
