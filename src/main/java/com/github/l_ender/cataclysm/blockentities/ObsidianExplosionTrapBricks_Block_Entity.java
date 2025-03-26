package com.github.l_ender.cataclysm.blockentities;

import com.github.l_ender.cataclysm.blocks.ObsidianExplosionTrapBricks;
import com.github.l_ender.cataclysm.init.ModTag;

import com.github.l_ender.cataclysm.init.ModTileentites;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ObsidianExplosionTrapBricks_Block_Entity extends BlockEntity {

    public int tickCount;


    public ObsidianExplosionTrapBricks_Block_Entity(BlockPos pos, BlockState state) {
        super(ModTileentites.OBSIDIAN_EXPLOSION_TRAP_BRICKS, pos, state);
    }

    public static void commonTick(World level, BlockPos pos, BlockState state, ObsidianExplosionTrapBricks_Block_Entity entity) {
        entity.tick();
    }

    public void tick() {
        boolean LIT = false;
        if(getCachedState().getBlock() instanceof ObsidianExplosionTrapBricks){
            LIT = getCachedState().get(ObsidianExplosionTrapBricks.LIT);
        }
        if(LIT){
            tickCount++;
            float x = this.getPos().getX() + 0.5F;
            float y = this.getPos().getY();
            float z = this.getPos().getZ() + 0.5F;
            float f = 5F;
            if (tickCount < 80) {
                for (LivingEntity inRange : world.getNonSpectatingEntities(LivingEntity.class, new Box((double) x - f, (double) y - f, (double) z - f, (double) x + f, (double) y + f, (double) z + f))) {
                    if (inRange instanceof PlayerEntity && ((PlayerEntity) inRange).getAbilities().invulnerable) continue;
                    if (inRange.getType().isIn(ModTag.TRAP_BLOCK_NOT_DETECTED)) continue;
                    Vec3d diff = inRange.getPos().subtract(Vec3d.ofCenter(getPos().add(0, 0, 0)));
                    diff = diff.normalize().multiply(0.06);
                    inRange.setVelocity(inRange.getVelocity().subtract(diff));
                }
                if (world.isClient) {
                    for (int i = 0; i < 3; ++i) {
                        int j = world.random.nextInt(2) * 2 - 1;
                        int k = world.random.nextInt(2) * 2 - 1;
                        double d0 = (double) pos.getX() + 0.5D + 0.25D * (double) j;
                        double d1 = (float) pos.getY() + world.random.nextFloat();
                        double d2 = (double) pos.getZ() + 0.5D + 0.25D * (double) k;
                        double d3 = world.random.nextFloat() * (float) j;
                        double d4 = ((double) world.random.nextFloat() - 0.5D) * 0.125D;
                        double d5 = world.random.nextFloat() * (float) k;
                        world.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
                    }
                }
            }
            if(tickCount == 80) {
                if (!world.isClient) {
                    world.createExplosion(null, x, y + 1, z, 3.0F, World.ExplosionSourceType.NONE);
                }
            }

        }else{
            tickCount=0;
        }
    }
}


