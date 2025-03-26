package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.effect.Void_Vortex_Entity;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
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
import java.util.List;

public class Gauntlet_of_Maelstrom extends Item implements RangeTool, ModShieldDisable {


    public Gauntlet_of_Maelstrom(net.minecraft.item.Item.Settings group) {
        super(group);
    }

    public static AttributeModifiersComponent createAttributes() {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 10.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, -2.4F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(BASE_ENTITY_ARMOR_ID, 3F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(BASE_ENTITY_ARMOR_TOUGHNESS_ID, 3F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(BASE_ENTITY_KNOCKBACK_RESISTANCE_ID, 0.15F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .build();
    }

    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.BOW;
    }

    @Override
    public int getMaxUseTime(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public TypedActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack item = p_77659_2_.getStackInHand(p_77659_3_);
        Hand otherhand = p_77659_3_ == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND;

        ItemStack otheritem = p_77659_2_.getStackInHand(otherhand);

        if (otheritem.isIn(ConventionalItemTags.SHIELD_TOOLS) && !p_77659_2_.getItemCooldownManager().isCoolingDown(otheritem.getItem())) {
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
                    if (this.spawnVortex(startPos.getX() + 0.5, startPos.getY(), startPos.getZ() + 0.5, standingOnY, yawRadians, level, player)) {
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


    private boolean spawnVortex(double x, double y, double z, int lowestYCheck, float rotation, World world, PlayerEntity player) {
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
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType flags) {
        tooltip.add(Text.translatable("item.cataclysm.gauntlet_of_maelstrom.desc").formatted(Formatting.DARK_GREEN));
    }
}