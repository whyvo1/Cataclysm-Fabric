package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModKeybind;
import com.github.l_ender.cataclysm.message.MessageArmorKey;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;

public class Cursium_Armor extends ArmorItem implements KeybindUsingArmor {

    public Cursium_Armor(Armortier material, Type slot, Settings properties) {
        super(material, slot, properties);

    }
    
//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getArmorRenderProperties());
//    }

//    @Override
//    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
//        return Cataclysm.MOD_ID + ":textures/armor/cursium_armor" + (slot == EquipmentSlot.LEGS ? "_legs.png" : ".png");
//    }

//    @Override
//    public void setDamage(ItemStack stack, int damage) {
//        if(CMConfig.Armor_Infinity_Durability) {
//            super.setDamage(stack, 0);
//        }else{
//            super.setDamage(stack, damage);
//        }
//    }

    @Override
    public boolean isDamageable() {
        return !CMConfig.Armor_Infinity_Durability;
    }

    public boolean canRepair(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.isOf(ModItems.IGNITIUM_INGOT);
    }

    public void inventoryTick(ItemStack stack, World level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        if(!level.isClient()) return;
        if (entity instanceof PlayerEntity living) {
            if (living.getEquippedStack(EquipmentSlot.HEAD).getItem() == ModItems.CURSIUM_HELMET) {
                if (Cataclysm.PROXY.getClientSidePlayer() == entity && Cataclysm.PROXY.isKeyDown(5)) {
                    new MessageArmorKey(EquipmentSlot.HEAD.ordinal(), 5).sendToServer();
                    onKeyPacket(living, stack,5);
                }


            }
            if (living.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.CURSIUM_BOOTS) {
                if (Cataclysm.PROXY.getClientSidePlayer() == entity && Cataclysm.PROXY.isKeyDown(7)) {
                    new MessageArmorKey(EquipmentSlot.FEET.ordinal(), 7).sendToServer();
                    onKeyPacket(living, stack,7);
                }
            }
        }
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
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

}