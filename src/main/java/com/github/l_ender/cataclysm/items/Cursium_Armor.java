package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModKeybind;
import com.github.l_ender.cataclysm.message.MessageArmorKey;
import com.github.l_ender.cataclysm.util.NetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


import java.util.List;

public class Cursium_Armor extends ArmorItem implements KeybindUsingArmor, ModDamageable {

    public Cursium_Armor(RegistryEntry<ArmorMaterial> material, Type slot, Settings properties) {
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

    public boolean canRepair(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.isOf(ModItems.IGNITIUM_INGOT);
    }

    public void inventoryTick(ItemStack stack, World level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        if (entity instanceof PlayerEntity living) {
            if (living.getEquippedStack(EquipmentSlot.HEAD).isOf(ModItems.CURSIUM_HELMET)) {
                if (level.isClient) {
                    if (ModKeybind.HELMET_KEY_ABILITY.isPressed()) {
                        NetworkHandler.sendToServer(new MessageArmorKey(EquipmentSlot.HEAD.ordinal(), living.getId(), 5));
                        onKeyPacket(living, stack,5);
                    }
                }

            }
            if (living.getEquippedStack(EquipmentSlot.FEET).isOf(ModItems.CURSIUM_BOOTS)) {
                if (level.isClient) {
                    if (ModKeybind.BOOTS_KEY_ABILITY.isPressed()) {
                        NetworkHandler.sendToServer(new MessageArmorKey(EquipmentSlot.HEAD.ordinal(), living.getId(), 7));
                        onKeyPacket(living, stack,7);
                    }
                }

            }

        }
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType flags) {
        if (this.type == Type.HELMET) {
            tooltip.add(Text.translatable("item.cataclysm.cursium_helmet.desc").formatted(Formatting.DARK_GREEN));
            tooltip.add(Text.translatable("item.cataclysm.cursium_helmet.desc2", ModKeybind.HELMET_KEY_ABILITY.getBoundKeyLocalizedText()).formatted(Formatting.DARK_GREEN));
        }
        if (this.type == Type.CHESTPLATE) {
            tooltip.add(Text.translatable("item.cataclysm.cursium_chestplate.desc").formatted(Formatting.DARK_GREEN));
            tooltip.add(Text.translatable("item.cataclysm.cursium_chestplate.desc2").formatted(Formatting.DARK_GREEN));
            tooltip.add(Text.translatable("item.cataclysm.cursium_chestplate.desc3").formatted(Formatting.DARK_GREEN));
        }
        if (this.type == Type.LEGGINGS) {
            tooltip.add(Text.translatable("item.cataclysm.cursium_leggings.desc").formatted(Formatting.DARK_GREEN));
            tooltip.add(Text.translatable("item.cataclysm.cursium_leggings.desc2").formatted(Formatting.DARK_GREEN));
        }
        if (this.type ==  Type.BOOTS) {
            tooltip.add(Text.translatable("item.cataclysm.cursium_boots.desc").formatted(Formatting.DARK_GREEN));
            tooltip.add(Text.translatable("item.cataclysm.cursium_boots.desc2",ModKeybind.BOOTS_KEY_ABILITY.getBoundKeyLocalizedText()).formatted(Formatting.DARK_GREEN));
        }
    }

    @Override
    public void onKeyPacket(PlayerEntity player, ItemStack itemStack, int Type) {
        if (Type == 5) {
            if (player != null && !player.getItemCooldownManager().isCoolingDown(ModItems.CURSIUM_HELMET)) {
                boolean flag = false;
                List<Entity> list = player.getWorld().getOtherEntities(player, player.getBoundingBox().expand(24.0D));
                for (Entity entity : list) {
                    if (entity instanceof LivingEntity living) {
                        flag = true;
                        living.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 160));

                    }

                    if (flag) {
                        player.getItemCooldownManager().set(ModItems.CURSIUM_HELMET, 200);
                    }
                }
            }
        }
        if (Type == 7) {
            if (player != null && player.isOnGround() && !player.getItemCooldownManager().isCoolingDown(ModItems.CURSIUM_BOOTS)) {
                float speed = -1.8f;
                float dodgeYaw = (float) Math.toRadians(player.getYaw() + 90);
                Vec3d m = player.getVelocity().add(speed * Math.cos(dodgeYaw), 0, speed * Math.sin(dodgeYaw));
                player.setVelocity(m.x, 0.4, m.z);
                player.getItemCooldownManager().set(ModItems.CURSIUM_BOOTS, 200);
            }
        }
    }

//    @Override
//    public Identifier getArmorTexture(@Nonnull ItemStack stack, @Nonnull Entity entity, @Nonnull EquipmentSlot slot, @Nonnull ArmorMaterial.Layer layer, boolean isInnerModel) {
//        return Identifier.of(Cataclysm.MODID , "textures/armor/cursium_armor" + (slot == EquipmentSlot.LEGS ? "_legs.png" : ".png"));
//    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return !CMConfig.Armor_Infinity_Durability;
    }
}