package com.github.l_ender.cataclysm.items;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ModernRemantBucket extends EntityBucketItem {

    public ModernRemantBucket(EntityType<?> fishTypeIn, Fluid fluid, net.minecraft.item.Item.Settings builder) {
        super(fishTypeIn,  fluid, SoundEvents.ITEM_BUCKET_EMPTY_FISH, builder.maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand interactionHand) {
        ItemStack itemStack = player.getStackInHand(interactionHand);
        BlockHitResult blockHitResult = raycast(level, player, RaycastContext.FluidHandling.NONE);
        if (blockHitResult.getType() == HitResult.Type.MISS) {
            return TypedActionResult.pass(itemStack);
        } else if (blockHitResult.getType() != HitResult.Type.BLOCK) {
            return TypedActionResult.pass(itemStack);
        } else {
            BlockPos blockPos = blockHitResult.getBlockPos();
            if (level.canPlayerModifyAt(player, blockPos)) {
                onEmptied(player, level, itemStack, blockPos);
                if (player instanceof ServerPlayerEntity) {
                    Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity) player, blockPos, itemStack);
                }
                // TODO: Try make bucket with no nbt make villager type the same as biome spawned in
                player.incrementStat(Stats.USED.getOrCreateStat(this));
                return TypedActionResult.success(getEmptiedStack(itemStack, player), level.isClient());
            } else {
                return TypedActionResult.fail(itemStack);
            }
        }
    }

    @Override
    public boolean placeFluid(@Nullable PlayerEntity player, World level, BlockPos blockPos, @Nullable BlockHitResult blockHitResult) {
        BlockState blockstate = level.getBlockState(blockPos);
        if (blockstate.isAir() || blockstate.canBucketPlace(Fluids.EMPTY)) {
            this.playEmptyingSound(player, level, blockPos);
            return true;
        } else {
            return false;
        }
    }

}
