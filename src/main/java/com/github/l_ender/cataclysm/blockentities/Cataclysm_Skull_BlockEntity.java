package com.github.l_ender.cataclysm.blockentities;

import com.github.l_ender.cataclysm.init.ModTileentites;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Cataclysm_Skull_BlockEntity extends BlockEntity {
    public static final String TAG_NOTE_BLOCK_SOUND = "note_block_sound";
    @Nullable
    private Identifier noteBlockSound;
    private int animationTickCount;
    private boolean isAnimating;

    public Cataclysm_Skull_BlockEntity(BlockPos p_155731_, BlockState p_155732_) {
        super(ModTileentites.CATACLYSM_SKULL, p_155731_, p_155732_);
    }


    protected void writeNbt(NbtCompound p_187518_, RegistryWrapper.WrapperLookup p_324418_) {
        super.writeNbt(p_187518_, p_324418_);
        if (this.noteBlockSound != null) {
            p_187518_.putString("note_block_sound", this.noteBlockSound.toString());
        }

    }


    protected void readNbt(NbtCompound p_155745_, RegistryWrapper.WrapperLookup p_323876_) {
        super.readNbt(p_155745_, p_323876_);
        if (p_155745_.contains("note_block_sound", 8)) {
            this.noteBlockSound = Identifier.tryParse(p_155745_.getString("note_block_sound"));
        }

    }

    public static void animation(World p_261710_, BlockPos p_262153_, BlockState p_262021_, Cataclysm_Skull_BlockEntity p_261594_) {
        if (p_261710_.isReceivingRedstonePower(p_262153_)) {
            p_261594_.isAnimating = true;
            ++p_261594_.animationTickCount;
        } else {
            p_261594_.isAnimating = false;
        }

    }

    public float getAnimation(float p_262053_) {
        return this.isAnimating ? (float)this.animationTickCount + p_262053_ : (float)this.animationTickCount;
    }

    @Nullable
    public Identifier getNoteBlockSound() {
        return this.noteBlockSound;
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

}
