package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModEffect;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;

public class Monstrous_Helm extends ModTickableArmorItem {

    public Monstrous_Helm(ArmorMaterials material, ArmorItem.Type slot, Settings properties) {
        super(material, slot, properties);

    }

//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getArmorRenderProperties());
//    }


//    @Override
//    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
//        return Cataclysm.MOD_ID + ":textures/armor/monstrous_helm.png";
//    }

    @Override
    public boolean isDamageable() {
        return CMConfig.Armor_Infinity_Durability;
    }

    public boolean canRepair(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.isOf(Items.NETHERITE_INGOT);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        boolean berserk = player.getMaxHealth() * 1 / 2 >= player.getHealth();
        double radius = 4.0D;
        List<Entity> list = world.getOtherEntities(player, player.getBoundingBox().expand(radius));
        if(berserk && !(player.getItemCooldownManager().isCoolingDown(this))) {
           // player.playSound(SoundEvents.ENTITY_RAVAGER_ROAR, 0.75F, 0.5F);
            for (Entity entity : list) {
                if (entity instanceof LivingEntity) {
                    entity.damage(world.getDamageSources().mobAttack(player), (float) player.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)* 1/2);
                    double d0 = entity.getX() - player.getX();
                    double d1 = entity.getZ() - player.getZ();
                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                    entity.addVelocity(d0 / d2 * 1.5 , 0.15D, d1 / d2 * 1.5);
                }
            }
           // world.explode(player, player.getX() + xx, player.getY() + (double) player.getEyeHeight(), player.getZ() + zz, 1.5F, Level.ExplosionInteraction.NONE);
            player.getItemCooldownManager().set(this, 350);
            player.addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTMONSTROUS, 200, 0, false, true));
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.monstrous_helm.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.monstrous_helm2.desc").formatted(Formatting.DARK_GREEN));
    }
}