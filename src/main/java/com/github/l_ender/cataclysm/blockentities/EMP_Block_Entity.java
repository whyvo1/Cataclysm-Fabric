package com.github.l_ender.cataclysm.blockentities;

import com.github.l_ender.cataclysm.blocks.EMP_Block;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.init.ModParticle;
import com.github.l_ender.cataclysm.init.ModSounds;

import com.github.l_ender.cataclysm.init.ModTileentites;
import com.github.l_ender.cataclysm.util.CMDamageTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EMP_Block_Entity extends BlockEntity {

    private float chompProgress;
    private float prevChompProgress;
    public int ticksExisted;

    public EMP_Block_Entity(BlockPos pos, BlockState state) {
        super(ModTileentites.EMP, pos, state);
    }

    public static void commonTick(World level, BlockPos pos, BlockState state, EMP_Block_Entity entity) {
        entity.tick();

    }

    public void tick() {
        prevChompProgress = chompProgress;
        BlockState state = getCachedState();
        boolean powered = false;
        boolean overload = false;
        if(state.getBlock() instanceof EMP_Block){
            powered = state.get(EMP_Block.POWERED);
            overload = state.get(EMP_Block.OVERLOAD);
        }

        if(powered && chompProgress < 15F){
            chompProgress++;
        }
        if(!powered && chompProgress > 0F){
            chompProgress--;
        }
        float x = this.getPos().getX() + 0.5F;
        float y = this.getPos().getY() + 0.5f;
        float z = this.getPos().getZ() + 0.5F;

        if(!overload && chompProgress == 15F ){
            if (world != null) {
                world.addParticle(ModParticle.EM_PULSE, x, y, z, 0, 0, 0);
                ScreenShake_Entity.ScreenShake(this.world, Vec3d.ofCenter(this.getPos()), 20, 0.01f, 0, 20);
                world.playSound(null, this.getPos(), ModSounds.EMP_ACTIVATED, SoundCategory.BLOCKS, 4F, world.random.nextFloat() * 0.2F + 1.0F);
                world.setBlockState(this.getPos(), state.with(EMP_Block.OVERLOAD, true));
                Box screamBox = new Box(this.getPos().getX() - 5f, this.getPos().getY() - 5F, this.getPos().getZ() - 5, this.getPos().getX() + 5, this.getPos().getY() + 5F, this.getPos().getZ() + 5F);
                for(LivingEntity entity : world.getNonSpectatingEntities(LivingEntity.class, screamBox)){
                   entity.damage(CMDamageTypes.getDamageSource(world, CMDamageTypes.EMP), 3 + entity.getRandom().nextInt(3));

                }
            }
        }
        ticksExisted++;
    }

    public float getChompProgress(float partialTick){
        return prevChompProgress + (chompProgress - prevChompProgress) * partialTick;
    }

}
