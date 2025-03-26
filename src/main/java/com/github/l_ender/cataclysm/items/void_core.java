package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.projectile.Void_Rune_Entity;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import java.util.List;

public class void_core extends Item {

    public void_core(Settings group) {
        super(group);

    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        int standingOnY = MathHelper.floor(player.getY()) - 1;
        double headY = player.getY() + 1.0D;
        float yawRadians = (float) (Math.toRadians(90 + player.getYaw()));
        boolean hasSucceeded = false;
        if (player.getPitch() > 70) {
            for (int i = 0; i < 5; i++) {
                float mulPosedYaw = yawRadians + (float) i * (float) Math.PI * 0.4F;
                if (this.spawnFangs(player.getX() + (double) MathHelper.cos(mulPosedYaw) * 1.5D, headY, player.getZ() + (double) MathHelper.sin(mulPosedYaw) * 1.5D, standingOnY, mulPosedYaw, 0, world, player))
                    hasSucceeded = true;

            }
            for (int k = 0; k < 8; k++) {
                float mulPosedYaw = yawRadians + (float) k * (float) Math.PI * 2.0F / 8.0F + 1.2566371F;
                if (this.spawnFangs(player.getX() + (double) MathHelper.cos(mulPosedYaw) * 2.5D, headY, player.getZ() + (double) MathHelper.sin(mulPosedYaw) * 2.5D, standingOnY, mulPosedYaw, 3, world, player))
                    hasSucceeded = true;

            }
        } else {
            for (int l = 0; l < 10; l++) {
                double d2 = 1.25D * (double) (l + 1);
                if(this.spawnFangs(player.getX() + (double) MathHelper.cos(yawRadians) * d2, headY, player.getZ() + (double) MathHelper.sin(yawRadians) * d2, standingOnY, yawRadians, l, world, player))
                    hasSucceeded = true;

            }
        }
        ItemStack stack = player.getStackInHand(hand);
        if (hasSucceeded) {
            player.getItemCooldownManager().set(this, CMConfig.VoidCoreCooldown);
            return TypedActionResult.success(stack);
        }
        return TypedActionResult.pass(stack);
    }

    private boolean spawnFangs(double x, double y, double z, int lowestYCheck, float yRot, int warmupDelayTicks, World world, PlayerEntity player) {
        BlockPos blockpos = BlockPos.ofFloored(x, y, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.down();
            BlockState blockstate = world.getBlockState(blockpos1);
            if (blockstate.isSideSolidFullSquare(world, blockpos1, Direction.UP)) {
                if (!world.isAir(blockpos)) {
                    BlockState blockstate1 = world.getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(world, blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.getMax(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.down();
        } while (blockpos.getY() >= lowestYCheck);

        if (flag) {
            world.spawnEntity(new Void_Rune_Entity(world, x, (double) blockpos.getY() + d0, z, yRot, warmupDelayTicks,(float) CMConfig.Voidrunedamage, player));
            return true;
        }
        return false;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.void_core.desc").formatted(Formatting.DARK_GREEN));
    }
}

