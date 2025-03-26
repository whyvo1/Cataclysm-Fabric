package com.github.l_ender.cataclysm.items;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Bucketable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class ModFishBucket extends EntityBucketItem {
    private final EntityType<?> type;
    public ModFishBucket(EntityType<?> fishTypeIn, Fluid fluid, net.minecraft.item.Item.Settings builder) {
        super(fishTypeIn,  fluid, SoundEvents.ITEM_BUCKET_EMPTY_FISH, builder.maxCount(1));
        this.type = fishTypeIn;
    }
    
    @Override
    public void onEmptied(@Nullable PlayerEntity player, World level, ItemStack stack, BlockPos pos) {
        if (level instanceof ServerWorld) {
            this.spawnEntity((ServerWorld)level, stack, pos);
            level.emitGameEvent(player, GameEvent.ENTITY_PLACE, pos);
        }
    }

    private void spawnEntity(ServerWorld p_151142_, ItemStack p_151143_, BlockPos p_151144_) {
        if (this.type.spawnFromItemStack(p_151142_, p_151143_, null, p_151144_, SpawnReason.BUCKET, true, false) instanceof Bucketable bucketable) {
            NbtComponent customdata = p_151143_.getOrDefault(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT);
            bucketable.copyDataFromNbt(customdata.copyNbt());
            bucketable.setFromBucket(true);
        }
    }

}
