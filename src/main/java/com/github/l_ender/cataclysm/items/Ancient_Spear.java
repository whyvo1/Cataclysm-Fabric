package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.entity.projectile.Sandstorm_Projectile;
import com.github.l_ender.cataclysm.init.ModItems;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.github.fabricators_of_create.porting_lib.attributes.PortingLibAttributes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Ancient_Spear extends SwordItem implements ILeftClick, Vanishable, More_Tool_Attribute {
    private final Multimap<EntityAttribute, EntityAttributeModifier> incineratorAttributes;

    public Ancient_Spear(Settings group) {
        super(Tooltier.ANCIENT_METAL, 0, 0.0F, group);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 8.5D, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -2.6F, EntityAttributeModifier.Operation.ADDITION));
        builder.put(PortingLibAttributes.ENTITY_REACH, new EntityAttributeModifier(BASE_ENTITY_INTERACTION_RANGE_ID, "Tool modifier", 1.5F, EntityAttributeModifier.Operation.ADDITION));

        this.incineratorAttributes = builder.build();
    }

    private boolean isCharged(PlayerEntity player, ItemStack stack){
        return player.getAttackCooldownProgress(0.5F) > 0.9F;
    }

    public boolean postHit(ItemStack stack, LivingEntity entity, LivingEntity player) {
        if(player instanceof PlayerEntity player1) {
            if(isCharged(player1, stack)) {
                launchTornado(stack, player);
            }
        }
        stack.damage(1, player, (p_43414_) -> p_43414_.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));

        return true;
    }


    public boolean canRepair(ItemStack pickaxe, ItemStack stack) {
        return stack.isOf(ModItems.ANCIENT_METAL_INGOT);
    }

    public boolean postMine(ItemStack p_43399_, World p_43400_, BlockState p_43401_, BlockPos p_43402_, LivingEntity p_43403_) {
        if ((double)p_43401_.getHardness(p_43400_, p_43402_) != 0.0D) {
            p_43399_.damage(2, p_43403_, (p_43385_) -> p_43385_.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }

        return true;
    }

    public boolean onLeftClick(ItemStack stack, LivingEntity playerIn){
        if(stack.isOf(ModItems.ANCIENT_SPEAR) && playerIn.getStackInHand(Hand.MAIN_HAND).isOf(ModItems.ANCIENT_SPEAR) && (!(playerIn instanceof PlayerEntity) || isCharged((PlayerEntity)playerIn, stack))){
            return launchTornado(stack, playerIn);
        }
        return false;
    }

    public boolean launchTornado(ItemStack stack, LivingEntity playerIn) {
        World worldIn = playerIn.getWorld();
        if (!worldIn.isClient) {
            stack.damage(1, playerIn, (p_43388_) -> p_43388_.sendToolBreakStatus(playerIn.getActiveHand()));
            float d7 = playerIn.getYaw();
            float d = playerIn.getPitch();
            float d1 = -MathHelper.sin(d7 * ((float) Math.PI / 180F)) * MathHelper.cos(d * ((float) Math.PI / 180F));
            float d2 = -MathHelper.sin(d * ((float) Math.PI / 180F));
            float d3 = MathHelper.cos(d7 * ((float) Math.PI / 180F)) * MathHelper.cos(d * ((float) Math.PI / 180F));
            double theta = d7 * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            double x = playerIn.getX() + vecX;
            double Z = playerIn.getZ() + vecZ;
            Sandstorm_Projectile largefireball = new Sandstorm_Projectile(playerIn, d1, d2, d3, playerIn.getWorld(),6);
            largefireball.setState(1);
            largefireball.setPosition(x, playerIn.getEyeY() - 0.5D, Z);
            worldIn.spawnEntity(largefireball);

            return true;
        }
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

    public float getMiningSpeedMultiplier(ItemStack p_43288_, BlockState p_43289_) {
        if (p_43289_.isOf(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return p_43289_.isIn(BlockTags.SWORD_EFFICIENT) ? 1.5F : 1.0F;
        }
    }

//    public boolean isSuitableFor(BlockState p_43298_) {
//        return p_43298_.isOf(Blocks.COBWEB);
//    }


//    @Override
//    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
//        return super.canApplyAtEnchantingTable(stack, enchantment) || enchantment.target == EnchantmentTarget.WEAPON;
//    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? this.incineratorAttributes : super.getAttributeModifiers(equipmentSlot);
    }

//    @Override
//    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
//        return net.minecraftforge.common.ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
//    }

//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
//    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.ancient_spear.desc").formatted(Formatting.DARK_GREEN));
    }
}