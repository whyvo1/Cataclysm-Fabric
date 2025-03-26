package com.github.l_ender.cataclysm.blocks;

import com.github.l_ender.cataclysm.blockentities.Cataclysm_Skull_BlockEntity;
import com.github.l_ender.cataclysm.init.ModBlocks;
import com.github.l_ender.cataclysm.init.ModTileentites;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.Equipment;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public abstract class Abstract_Cataclysm_Skull_Block extends BlockWithEntity implements Equipment {
    private final Cataclysm_Skull_Block.Type type;

    public Abstract_Cataclysm_Skull_Block(Cataclysm_Skull_Block.Type p_48745_, AbstractBlock.Settings p_48746_) {
        super(p_48746_);
        this.type = p_48745_;
    }

    public BlockEntity createBlockEntity(BlockPos p_151996_, BlockState p_151997_) {
        return new Cataclysm_Skull_BlockEntity(p_151996_, p_151997_);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World p_151992_, BlockState p_151993_, BlockEntityType<T> p_151994_) {
        if (p_151992_.isClient) {
            boolean flag = p_151993_.isOf(ModBlocks.APTRGANGR_HEAD) || p_151993_.isOf(ModBlocks.APTRGANGR_WALL_HEAD) || p_151993_.isOf(ModBlocks.KOBOLEDIATOR_SKULL) || p_151993_.isOf(ModBlocks.KOBOLEDIATOR_WALL_SKULL);
            if (flag) {
                return checkType(p_151994_, ModTileentites.CATACLYSM_SKULL, Cataclysm_Skull_BlockEntity::animation);
            }
        }

        return null;
    }

    public Cataclysm_Skull_Block.Type getType() {
        return this.type;
    }

    public boolean canPathfindThrough(BlockState p_48750_, BlockView p_48751_, BlockPos p_48752_, NavigationType p_48753_) {
        return false;
    }

    public EquipmentSlot getSlotType() {
        return EquipmentSlot.HEAD;
    }
}
