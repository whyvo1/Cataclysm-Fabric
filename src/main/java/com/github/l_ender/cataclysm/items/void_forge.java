package com.github.l_ender.cataclysm.items;


import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.entity.projectile.Void_Rune_Entity;
import com.github.l_ender.cataclysm.init.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import java.util.List;

public class void_forge extends PickaxeItem implements ModDamageable, ModShieldDisable {
    public void_forge(ToolMaterial toolMaterial, net.minecraft.item.Item.Settings props) {

        super(toolMaterial, props);
    }

    @Override
    public boolean postHit(ItemStack heldItemStack, LivingEntity target, LivingEntity attacker) {
        if (!target.getWorld().isClient) {
            target.playSound(ModSounds.HAMMERTIME, 0.5F, 0.5F);
            target.takeKnockback( 1F, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
        }
        return true;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ItemStack stack = context.getStack();
        PlayerEntity player = context.getPlayer();
        int standingOnY = MathHelper.floor(player.getY()) - 3;
        World world = context.getWorld();
        if (player.getMainHandStack() == stack) {
            Vec3d looking = player.getRotationVector();
            double headY = player.getY() + 1.0D;
            Vec3d[] all = new Vec3d[]{looking, looking.rotateY(0.3f), looking.rotateY(-0.3f), looking.rotateY(0.6f), looking.rotateY(-0.6f), looking.rotateY(0.9f), looking.rotateY(-0.9f)};
            world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.EXPLOSION, SoundCategory.PLAYERS, 1.5f, 1F / (player.getRandom().nextFloat() * 0.4F + 0.8F));
            ScreenShake_Entity.ScreenShake(world, player.getPos(), 30, 0.1f, 0, 30);
            for (Vec3d vector3d : all) {
                float f = (float) MathHelper.atan2(vector3d.z, vector3d.x);
                player.getItemCooldownManager().set(this, CMConfig.VoidForgeCooldown);
                for (int i = 0; i < 5; i++) {
                    double d2 = 1.75D * (double) (i + 1);
                    int j = 1 * i;
                    this.spawnFangs(player.getX() + (double) MathHelper.cos(f) * d2, headY, player.getZ() + (double) MathHelper.sin(f) * d2, standingOnY, f, j, world, player);
                }
            }

            return ActionResult.SUCCESS;
        }
        return super.useOnBlock(context);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean canDisableShield(ItemStack stack, LivingEntity attacker) {
        return true;
    }

    @Override
    public boolean canRepair(ItemStack itemStack, ItemStack itemStackMaterial) {
        return false;
    }

    @Override
    public int getEnchantability() {
        return 16;
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
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType flags) {
        tooltip.add(Text.translatable("item.cataclysm.void_forge.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.void_forge.desc2").formatted(Formatting.DARK_GREEN));
    }
}







