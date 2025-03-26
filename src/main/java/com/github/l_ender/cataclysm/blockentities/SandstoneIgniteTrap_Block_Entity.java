package com.github.l_ender.cataclysm.blockentities;

import com.github.l_ender.cataclysm.blocks.Sandstone_Ignite_Trap;
import com.github.l_ender.cataclysm.init.ModParticle;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.init.ModTileentites;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class SandstoneIgniteTrap_Block_Entity extends BlockEntity {

    public int tickCount;
    private final Random random = Random.create();

    public SandstoneIgniteTrap_Block_Entity(BlockPos pos, BlockState state) {
        super(ModTileentites.SANDSTONE_IGNITE_TRAP, pos, state);
    }

    public static void commonTick(World level, BlockPos pos, BlockState state, SandstoneIgniteTrap_Block_Entity entity) {
        entity.tick(level, pos);
    }

    public void tick(World level, BlockPos pos) {
        boolean LIT = false;
        if(getCachedState().getBlock() instanceof Sandstone_Ignite_Trap){
            LIT = getCachedState().get(Sandstone_Ignite_Trap.LIT);
        }
        if(LIT){
            tickCount++;
            double x = pos.getX();
            double y = pos.up().getY();
            double z = pos.getZ();
            if (level.isClient()) {
                level.addParticle(ModParticle.TRAP_FLAME, x + 0.5F, y , z + 0.5F, 0.0D, 0.5D, 0.0D);

            }else {
                if (tickCount % 5 == 0) {

                    List<LivingEntity> entitiesInRange = level.getNonSpectatingEntities(LivingEntity.class, new Box(pos.add(-1, 0, -1), pos.add(1, 6, 1)));

                    for (LivingEntity entity : entitiesInRange) {
                        if (!entity.getType().isIn(ModTag.TEAM_ANCIENT_REMNANT)) {
                            if (!entity.isFireImmune()) {
                                entity.damage(entity.getWorld().getDamageSources().inFire(), 5);
                                entity.setOnFireFor(5);
                            }
                        }
                    }
                }

            }
        }else{
            tickCount=0;
        }
    }
}


