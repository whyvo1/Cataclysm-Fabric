package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.effect.Flame_Strike_Entity;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModSounds;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public class The_Immolator extends Item implements ModShieldDisable {


    public The_Immolator(Settings properties) {
        super(properties);

    }


    public static AttributeModifiersComponent createAttributes() {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 6.5D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, -2.4F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .build();
    }


    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.SPEAR;
    }

    @Override
    public int getMaxUseTime(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public void onStoppedUsing(ItemStack p_43394_, World p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof PlayerEntity player) {
            int i = this.getMaxUseTime(p_43394_,p_43396_) - p_43397_;
            boolean hasSucceeded = false;
            double headY = player.getY() + 1.0D;
            int standingOnY = MathHelper.floor(player.getY()) - 2;
            if (i >= 45) {
                float f1 = (float) Math.cos(Math.toRadians(p_43396_.getYaw() + 90));
                float f2 = (float) Math.sin(Math.toRadians(p_43396_.getYaw() + 90));
                float f0 = (float) MathHelper.atan2(f1, f2);
                if (this.spawnFlameStrike(player.getX(), player.getZ(), standingOnY, headY, f0, 45, 0, 0, p_43395_, 2.5F, player)) {
                    hasSucceeded = true;
                }

                if (hasSucceeded) {
                    if (!p_43395_.isClient) {
                        player.getItemCooldownManager().set(this, CMConfig.ImmolatorCooldown);
                    }
                    ScreenShake_Entity.ScreenShake(p_43395_, player.getPos(), 30, 0.15f, 0, 30);
                    p_43395_.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.EXPLOSION, SoundCategory.PLAYERS, 1.5f, 1F / (player.getRandom().nextFloat() * 0.4F + 0.8F));

                }
            }
        }
    }

    public void usageTick(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        int i = this.getMaxUseTime(stack,livingEntityIn) - count;
        if (i == 10) {
            masseffectParticle(worldIn,livingEntityIn,2.0F);
        }

        if (i == 20) {
            masseffectParticle(worldIn,livingEntityIn,3.5F);
        }

        if (i == 30) {
            masseffectParticle(worldIn,livingEntityIn,5F);
        }
        if (i == 45) {
            livingEntityIn.playSound(ModSounds.MALEDICTUS_SHORT_ROAR, 1.0F, 1.0f);
        }
    }

    private void yall(World world,LivingEntity caster) {
        double radius = 6.0D;
        ScreenShake_Entity.ScreenShake(world, caster.getPos(), 30, 0.1f, 0, 30);
        world.playSound(null, caster.getX(), caster.getY(), caster.getZ(), ModSounds.EXPLOSION, SoundCategory.PLAYERS, 1.5f, 1F / (caster.getRandom().nextFloat() * 0.4F + 0.8F));
        List<Entity> list = world.getOtherEntities(caster, caster.getBoundingBox().expand(radius, radius, radius));
        for (Entity entity : list) {
            if (entity instanceof LivingEntity) {
                entity.damage(world.getDamageSources().mobAttack(caster), (float) caster.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * 2F);
            }
        }


    }


    private boolean spawnFlameStrike(double x, double z, double minY, double maxY, float rotation, int duration, int wait, int delay, World world, float radius, LivingEntity player) {
        BlockPos blockpos = BlockPos.ofFloored(x, maxY, z);
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
        } while (blockpos.getY() >= minY);

        if (flag) {
            world.spawnEntity(new Flame_Strike_Entity(world, x, (double) blockpos.getY() + d0, z, rotation, duration, wait, delay, radius,6F,2F, false, player));
            return true;
        }
        return false;
    }

    
    private void masseffectParticle(World world,LivingEntity caster,float radius) {
        if (world.isClient) {
            for (int j = 0; j < 70; ++j) {
                float angle = (float) (Math.random() * 2 * Math.PI);
                double distance = Math.sqrt(Math.random()) * radius;
                double extraX = caster.getX() + distance * MathHelper.cos(angle);
                double extraY = caster.getY() + 0.3F;
                double extraZ = caster.getZ() + distance * MathHelper.sin(angle);

                world.addParticle(ParticleTypes.FLAME, extraX, extraY, extraZ, 0.0D, world.random.nextGaussian() * 0.04D, 0.0D);
            }
        }
    }



    public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        ItemStack otherHand = hand == Hand.MAIN_HAND ? player.getStackInHand(Hand.OFF_HAND) : player.getStackInHand(Hand.MAIN_HAND);
        if (otherHand.isOf(ModItems.THE_IMMOLATOR)) {
            player.setCurrentHand(hand);
            return TypedActionResult.consume(itemstack);
        } else {
            return TypedActionResult.fail(itemstack);
        }
    }

    @Override
    public boolean canDisableShield(ItemStack stack, LivingEntity attacker) {
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantability() {
        return 16;
    }

    public boolean canMine(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        return !player.isCreative();
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType flags) {
        tooltip.add(Text.translatable("item.cataclysm.annihilator.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.immolator.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.immolator2.desc").formatted(Formatting.DARK_GREEN));
    }
}