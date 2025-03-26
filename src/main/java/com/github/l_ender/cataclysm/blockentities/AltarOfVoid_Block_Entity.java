package com.github.l_ender.cataclysm.blockentities;

import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Guardian_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModTileentites;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;


public class AltarOfVoid_Block_Entity extends BlockEntity {

    protected static final int SHORT_RANGE = 6;

    protected boolean spawnedBoss = false;

    public AltarOfVoid_Block_Entity(BlockPos pos, BlockState state) {
        super(ModTileentites.ALTAR_OF_VOID, pos, state);
    }

    public static void commonTick(World level, BlockPos pos, BlockState state, AltarOfVoid_Block_Entity entity) {
        entity.tick(level,pos,state,entity);
    }

    public boolean anyPlayerInRange() {
        if (world != null) {
            return world.isPlayerInRange(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, getRange());
        }
        return false;
    }

    public void tick(World level, BlockPos pos, BlockState state, AltarOfVoid_Block_Entity te) {
        if (spawnedBoss || !anyPlayerInRange()) {
            return;
        }
        if (!level.isClient) {
            if (level.getDifficulty() != Difficulty.PEACEFUL) {
                if (spawnMyBoss((ServerWorld)level)) {
                    level.breakBlock(pos, false);
                    spawnedBoss = true;
                }
            }
        }
    }

    protected boolean spawnMyBoss(ServerWorldAccess world) {

        Ender_Guardian_Entity enderGuardian = ModEntities.ENDER_GUARDIAN.create(world.toServerWorld());

        if (enderGuardian != null) {
            enderGuardian.refreshPositionAndAngles(pos, world.toServerWorld().random.nextFloat() * 360F, 0.0F);
            enderGuardian.initialize(world, world.getLocalDifficulty(pos), SpawnReason.SPAWNER, null, null);

            enderGuardian.setHomePos(this.getPos());
            enderGuardian.setPositionTarget(pos, 46);

            // spawn it
            return world.spawnEntity(enderGuardian);
        }
        return false;

    }



    protected int getRange() {
        return SHORT_RANGE;
    }

}
