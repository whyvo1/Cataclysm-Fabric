package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.effect.Flame_Strike_Entity;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.github.fabricators_of_create.porting_lib.attributes.PortingLibAttributes;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
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

import org.jetbrains.annotations.Nullable;
import java.util.List;

public class The_Incinerator extends SwordItem implements More_Tool_Attribute, ModShieldDisable {
    private final Multimap<EntityAttribute, EntityAttributeModifier> incineratorAttributes;

    public The_Incinerator(Settings group) {
        super(ToolMaterials.STONE, 0, 0.0F, group);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 13.0D, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -2.7F, EntityAttributeModifier.Operation.ADDITION));
        builder.put(PortingLibAttributes.ENTITY_REACH, new EntityAttributeModifier(BASE_ENTITY_INTERACTION_RANGE_ID, "Tool modifier", 2.0F, EntityAttributeModifier.Operation.ADDITION));
        this.incineratorAttributes = builder.build();
    }


    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.BOW;
    }

    public int getMaxUseTime(ItemStack p_77626_1_) {
        return 72000;
    }

    public void onStoppedUsing(ItemStack p_43394_, World p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof PlayerEntity player) {
            int i = this.getMaxUseTime(p_43394_) - p_43397_;
            double headY = player.getY() + 1.0D;
            int standingOnY = MathHelper.floor(player.getY()) - 2;
            float yawRadians = (float) (Math.toRadians(90 + player.getYaw()));
            boolean hasSucceeded = false;
            if (i >= 60) {
                for (int l = 0; l < 10; l++) {
                    double d2 = 2.25D * (double) (l + 1);
                    int j2 = (int) (1.5F * l);
                    if (this.spawnFlameStrike(player.getX() + (double) MathHelper.cos(yawRadians) * d2, player.getZ() + (double) MathHelper.sin(yawRadians) * d2, standingOnY, headY, yawRadians, 40, j2, j2, p_43395_, 1, player)) {
                        hasSucceeded = true;
                    }
                }
                if (hasSucceeded) {
                    if (!p_43395_.isClient) {
                        player.getItemCooldownManager().set(this, CMConfig.TheIncineratorCooldown);
                    }
                    ScreenShake_Entity.ScreenShake(p_43395_, player.getPos(), 30, 0.15f, 0, 30);
                    player.playSound(ModSounds.SWORD_STOMP, 1.0F, 1.0f);
                }
            }
        }
    }

    public void usageTick(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        int i = this.getMaxUseTime(stack) - count;
        if (i == 60) {
            livingEntityIn.playSound(ModSounds.FLAME_BURST, 1.0F, 1.0f);
        }
    }

    public TypedActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack item = p_77659_2_.getStackInHand(p_77659_3_);
        Hand otherhand = p_77659_3_ == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND;

        ItemStack otheritem = p_77659_2_.getStackInHand(otherhand);

        if (otheritem.isIn(ConventionalItemTags.SHIELDS) && !p_77659_2_.getItemCooldownManager().isCoolingDown(otheritem.getItem())) {
            return TypedActionResult.fail(item);
        }else{
            p_77659_2_.setCurrentHand(p_77659_3_);
            return TypedActionResult.consume(item);
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

//    public boolean canMine(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
//        return !player.isCreative();
//    }
//
//    public float getMiningSpeedMultiplier(ItemStack p_43288_, BlockState p_43289_) {
//        if (p_43289_.isOf(Blocks.COBWEB)) {
//            return 15.0F;
//        } else {
//            return p_43289_.isIn(BlockTags.SWORD_EFFICIENT) ? 1.5F : 1.0F;
//        }
//    }
//
//    public boolean isSuitableFor(BlockState p_43298_) {
//        return p_43298_.isOf(Blocks.COBWEB);
//    }

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

//    @Override
//    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
//        return enchantment.target == EnchantmentTarget.WEAPON;
//    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? this.incineratorAttributes : super.getAttributeModifiers(equipmentSlot);
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    //    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
//    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.incinerator.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.incinerator2.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.incinerator3.desc").formatted(Formatting.DARK_GREEN));
    }
}