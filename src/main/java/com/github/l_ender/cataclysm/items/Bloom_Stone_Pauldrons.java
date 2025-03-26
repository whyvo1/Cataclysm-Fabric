package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.projectile.Amethyst_Cluster_Projectile_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModKeybind;
import com.github.l_ender.cataclysm.message.MessageArmorKey;
import com.github.l_ender.cataclysm.util.NetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;


import java.util.List;

public class Bloom_Stone_Pauldrons extends ArmorItem implements KeybindUsingArmor {

    public Bloom_Stone_Pauldrons(RegistryEntry<ArmorMaterial> material, Type slot, Settings properties) {
        super(material, slot, properties);

    }

    

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltips, TooltipType flags) {
        tooltips.add(Text.translatable("item.cataclysm.bloom_stone_pauldrons.desc",ModKeybind.CHESTPLATE_KEY_ABILITY.getBoundKeyLocalizedText()).formatted(Formatting.DARK_GREEN));
    }

    public void inventoryTick(ItemStack stack, World level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        if (entity instanceof PlayerEntity living) {
            if (living.getEquippedStack(EquipmentSlot.CHEST).isOf(ModItems.BLOOM_STONE_PAULDRONS)) {
                if (level.isClient) {
                    if (ModKeybind.CHESTPLATE_KEY_ABILITY.isPressed()) {
                        NetworkHandler.sendToServer(new MessageArmorKey(EquipmentSlot.CHEST.ordinal(), living.getId(), 6));
                        onKeyPacket(living, stack,6);
                    }
                }

            }

        }
    }


    @Override
    public void onKeyPacket(PlayerEntity player, ItemStack itemStack,int Type) {
        if (Type == 6) {
            if (player != null && !player.getItemCooldownManager().isCoolingDown(ModItems.BLOOM_STONE_PAULDRONS)) {
                for (int i = 0; i < 8; i++) {
                    float throwAngle = i * MathHelper.PI / 4F;
                    double sx = player.getX() + (MathHelper.cos(throwAngle) * 1);
                    double sy = player.getY() + (player.getHeight() * 0.5D);
                    double sz = player.getZ() + (MathHelper.sin(throwAngle) * 1);

                    double vx = MathHelper.cos(throwAngle);
                    double vy = 0 + player.getRandom().nextFloat() * 0.3F;
                    double vz = MathHelper.sin(throwAngle);
                    double v3 = MathHelper.sqrt((float) (vx * vx + vz * vz));
                    Amethyst_Cluster_Projectile_Entity projectile = new Amethyst_Cluster_Projectile_Entity(ModEntities.AMETHYST_CLUSTER_PROJECTILE, player.getWorld(), player, (float)CMConfig.AmethystClusterdamage);

                    projectile.refreshPositionAndAngles(sx, sy, sz, i * 11.25F, player.getPitch());
                    float speed = 0.8F;
                    projectile.setVelocity(vx, vy + v3 * 0.20000000298023224D, vz, speed, 1.0F);
                    player.getWorld().spawnEntity(projectile);
                }
                player.getItemCooldownManager().set(ModItems.BLOOM_STONE_PAULDRONS, 240);
            }
        }

    }

//    @Override
//    public Identifier getArmorTexture(@NotNull ItemStack stack, @NotNull Entity entity, @NotNull EquipmentSlot slot, @NotNull ArmorMaterial.Layer layer, boolean isInnerModel) {
//        return Cataclysm.modIdentifier("textures/armor/bloom_stone_pauldrons.png");
//    }

}