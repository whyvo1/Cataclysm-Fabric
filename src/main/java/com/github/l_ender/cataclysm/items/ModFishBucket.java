package com.github.l_ender.cataclysm.items;

import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.Nullable;
import net.minecraft.entity.Bucketable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import java.util.List;
import java.util.function.Supplier;

public class ModFishBucket extends EntityBucketItem {

    public ModFishBucket(EntityType<?> fishType, Fluid fluid, Settings builder) {
        super(fishType, fluid, SoundEvents.ITEM_BUCKET_EMPTY_FISH, builder.maxCount(1));
    }
    
//    @Override
//    public void onEmptied(@Nullable PlayerEntity player, World level, ItemStack stack, BlockPos pos) {
//        if (level instanceof ServerWorld) {
//            this.spawnFish((ServerWorld)level, stack, pos);
//            level.emitGameEvent(player, GameEvent.ENTITY_PLACE, pos);
//        }
//    }
//
//    private void spawnFish(ServerWorld serverLevel, ItemStack stack, BlockPos pos) {
//        Entity entity = getFishType().spawn(serverLevel, stack, (PlayerEntity)null, pos, SpawnReason.BUCKET, true, false);
//        if (entity instanceof Bucketable) {
//            Bucketable bucketable = (Bucketable)entity;
//            bucketable.copyDataFromNbt(stack.getOrCreateNbt());
//            bucketable.setFromBucket(true);
//        }
//    }
}
