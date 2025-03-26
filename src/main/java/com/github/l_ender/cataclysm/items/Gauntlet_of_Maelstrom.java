package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.effect.Void_Vortex_Entity;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;

public class Gauntlet_of_Maelstrom extends Item implements More_Tool_Attribute, ModShieldDisable, ModEnchantable {
    private final Multimap<EntityAttribute, EntityAttributeModifier> guantletAttributes;

    public Gauntlet_of_Maelstrom(Settings group) {
        super(group);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 10.0D, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -2.4F, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(BASE_ARMOR_ID, "Tool modifier", 3.0F, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(BASE_ARMOR_TOUGHNESS_ID, "Tool modifier", 3F, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(BASE_KNOCKBACK_RESISTANCE_ID, "Tool modifier", 0.15F, EntityAttributeModifier.Operation.ADDITION));
        this.guantletAttributes = builder.build();
    }


    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.BOW;
    }

    public int getMaxUseTime(ItemStack p_77626_1_) {
        return 72000;
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
    public void onStoppedUsing(ItemStack stack, World level, LivingEntity entityLiving, int timeLeft) {

        if (entityLiving instanceof PlayerEntity player) {
            int standingOnY = MathHelper.floor(entityLiving.getY()) - 10;
            boolean hasSucceeded = false;
            float yawRadians = (float) (Math.toRadians(90 + player.getYaw()));
            HitResult result = player.raycast(32D, 1.0F, true);
            if (result.getType() == HitResult.Type.BLOCK) {
                if (!level.isClient) {
                    BlockPos startPos = ((BlockHitResult) result).getBlockPos();
                    if (this.spawnVortex(startPos.getX() + 0.5, startPos.getY(), startPos.getZ() + 0.5, standingOnY, yawRadians, level, entityLiving)) {
                        hasSucceeded = true;
                    }

                    if (hasSucceeded) {
                        player.getItemCooldownManager().set(this, CMConfig.GauntletOfMaelstromCooldown);
                        player.incrementStat(Stats.USED.getOrCreateStat(this));
                    }
                }
            }
        }

    }


    private boolean spawnVortex(double x, double y, double z, int lowestYCheck, float rotation, World world, LivingEntity player) {
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
            world.spawnEntity(new Void_Vortex_Entity(world, x, (double)blockpos.getY() + d0, z, rotation, player,150));
            return true;
        }
        return false;
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
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.target == EnchantmentTarget.WEAPON && enchantment != Enchantments.SWEEPING;
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? this.guantletAttributes : super.getAttributeModifiers(equipmentSlot);
    }

//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
//    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.gauntlet_of_maelstrom.desc").formatted(Formatting.DARK_GREEN));
    }
}