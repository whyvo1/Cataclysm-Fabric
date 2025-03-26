package com.github.l_ender.cataclysm.items;

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
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import java.util.List;

public class Gauntlet_of_Guard extends Item implements RangeTool, ModShieldDisable {

    public Gauntlet_of_Guard(net.minecraft.item.Item.Settings group) {
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

    public void usageTick(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        double radius = 11.0D;
        World world = livingEntityIn.getWorld();
        List<LivingEntity> list = world.getNonSpectatingEntities(LivingEntity.class, livingEntityIn.getBoundingBox().expand(radius));
        for (LivingEntity entity : list) {
            if (entity instanceof PlayerEntity && ((PlayerEntity) entity).getAbilities().invulnerable) continue;
            Vec3d diff = entity.getPos().subtract(livingEntityIn.getPos().add(0,0,0));
            diff = diff.normalize().multiply(0.1);
            entity.setVelocity(entity.getVelocity().subtract(diff));

        }

        if (world.isClient) {
            for (int i = 0; i < 3; ++i) {
                int j = world.random.nextInt(2) * 2 - 1;
                int k = world.random.nextInt(2) * 2 - 1;
                double d0 = livingEntityIn.getX() + 0.25D * (double) j;
                double d1 = (float) livingEntityIn.getY() + world.random.nextFloat();
                double d2 = livingEntityIn.getZ() + 0.25D * (double) k;
                double d3 = world.random.nextFloat() * (float) j;
                double d4 = ((double) world.random.nextFloat() - 0.5D) * 0.125D;
                double d5 = world.random.nextFloat() * (float) k;
                world.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
            }
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
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltips, TooltipType flags) {
        super.appendTooltip(stack, context, tooltips, flags);
        tooltips.add(Text.translatable("item.cataclysm.gauntlet_of_guard.desc").formatted(Formatting.DARK_GREEN));
    }

}