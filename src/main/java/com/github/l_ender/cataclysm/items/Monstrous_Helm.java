package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class Monstrous_Helm extends ArmorItem implements ModDamageable {

    public Monstrous_Helm(RegistryEntry<ArmorMaterial> material, Type slot, Settings properties) {
        super(material, slot, properties);

    }

//    @Override
//    public void setDamage(ItemStack stack, int damage) {
//        if(CMConfig.Armor_Infinity_Durability) {
//            super.setDamage(stack, 0);
//        }else{
//            super.setDamage(stack, damage);
//        }
//    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return !CMConfig.Armor_Infinity_Durability;
    }

    public boolean canRepair(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.isOf(Items.NETHERITE_INGOT);
    }

    public void inventoryTick(ItemStack stack, World level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        if (entity instanceof PlayerEntity player) {
            if (player.getEquippedStack(EquipmentSlot.HEAD).isOf(ModItems.MONSTROUS_HELM)) {
                boolean berserk = player.getMaxHealth() * 1 / 2 >= player.getHealth();
                double radius = 4.0D;
                List<Entity> list = level.getOtherEntities(player, player.getBoundingBox().expand(radius));
                if(berserk && !(player.getItemCooldownManager().isCoolingDown(this))) {
                    for (Entity entitys : list) {
                        if (entitys instanceof LivingEntity) {
                            entitys.damage(level.getDamageSources().mobAttack(player), (float) player.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)* 1/2);
                            double d0 = entitys.getX() - player.getX();
                            double d1 = entitys.getZ() - player.getZ();
                            double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                            entitys.addVelocity(d0 / d2 * 1.5 , 0.15D, d1 / d2 * 1.5);
                        }
                    }
                    player.getItemCooldownManager().set(this, 350);
                    player.addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTMONSTROUS, 200, 0, false, true));
                }

            }

        }
    }

//    @Override
//    public Identifier getArmorTexture(@Nonnull ItemStack stack, @Nonnull Entity entity, @Nonnull EquipmentSlot slot, @Nonnull ArmorMaterial.Layer layer, boolean isInnerModel) {
//        return Cataclysm.modIdentifier("textures/armor/monstrous_helm.png");
//    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltips, TooltipType flags) {
        tooltips.add(Text.translatable("item.cataclysm.monstrous_helm.desc").formatted(Formatting.DARK_GREEN));
        tooltips.add(Text.translatable("item.cataclysm.monstrous_helm2.desc").formatted(Formatting.DARK_GREEN));
    }

}