package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.entity.projectile.Sandstorm_Projectile;
import com.github.l_ender.cataclysm.init.ModItems;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.item.TridentItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Ancient_Spear extends SwordItem implements ILeftClick,RangeTool {

    public Ancient_Spear(net.minecraft.item.Item.Settings group) {
        super(Tooltier.ANCIENT_METAL, group);

    }


    public static AttributeModifiersComponent createAttributes() {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 8.5D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, -2.6F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(BASE_ENTITY_INTERACTION_RANGE_ID, 1.5F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .build();
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
        return true;
    }

    @Override
    public void postDamageEntity(ItemStack p_345950_, LivingEntity p_345617_, LivingEntity p_345537_) {
        p_345950_.damage(1, p_345537_, EquipmentSlot.MAINHAND);
    }



    public boolean canRepair(ItemStack pickaxe, ItemStack stack) {
        return stack.isOf(ModItems.ANCIENT_METAL_INGOT);
    }


    public boolean onLeftClick(ItemStack stack, LivingEntity playerIn){
        if(stack.isOf(ModItems.ANCIENT_SPEAR) && (!(playerIn instanceof PlayerEntity) || isCharged((PlayerEntity)playerIn, stack))){
            return launchTornado(stack, playerIn);
        }
        return false;
    }

    public boolean launchTornado(ItemStack stack, LivingEntity playerIn) {
        World worldIn = playerIn.getWorld();
        if (!worldIn.isClient) {

            stack.damage(1, playerIn, EquipmentSlot.MAINHAND);

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
        return false;
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

    public float getMiningSpeed(ItemStack p_43288_, BlockState p_43289_) {
        if (p_43289_.isOf(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return p_43289_.isIn(BlockTags.SWORD_EFFICIENT) ? 1.5F : 1.0F;
        }
    }

//    @Override
//    public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ItemAbility itemAbility) {
//        return net.neoforged.neoforge.common.ItemAbilities.DEFAULT_TRIDENT_ACTIONS.contains(itemAbility);
//    }
 

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltips, TooltipType flags) {
        super.appendTooltip(stack, context, tooltips, flags);
        tooltips.add(Text.translatable("item.cataclysm.ancient_spear.desc").formatted(Formatting.DARK_GREEN));
    }
}