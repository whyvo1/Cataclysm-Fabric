package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.entity.projectile.ThrownCoral_Spear_Entity;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Vanishable;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Coral_Spear extends Item implements Vanishable, ModEnchantable {
    public static final int THROW_THRESHOLD_TIME = 10;
    public static final float BASE_DAMAGE = 8.0F;
    public static final float SHOOT_POWER = 2.5F;
    private final Multimap<EntityAttribute, EntityAttributeModifier> defaultModifiers;

    public Coral_Spear(Settings p_43381_) {
        super(p_43381_);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 5.5D, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -2.9F, EntityAttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    public boolean canMine(BlockState p_43409_, World p_43410_, BlockPos p_43411_, PlayerEntity p_43412_) {
        return !p_43412_.isCreative();
    }

    public UseAction getUseAction(ItemStack p_43417_) {
        return UseAction.SPEAR;
    }

    public int getMaxUseTime(ItemStack p_43419_) {
        return 72000;
    }

    public void onStoppedUsing(ItemStack p_43394_, World p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof PlayerEntity player) {
            int i = this.getMaxUseTime(p_43394_) - p_43397_;
            if (i >= 10) {
                int j = EnchantmentHelper.getRiptide(p_43394_);
                if (j <= 0 || player.isTouchingWaterOrRain()) {
                    if (!p_43395_.isClient) {
                        p_43394_.damage(1, player, (p_43388_) -> {
                            p_43388_.sendToolBreakStatus(p_43396_.getActiveHand());
                        });
                        if (j == 0) {
                            ThrownCoral_Spear_Entity throwntrident = new ThrownCoral_Spear_Entity(p_43395_, player, p_43394_);
                            throwntrident.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, (2.5F + (float)j * 0.5F) * 1.25F, 1.0F);
                            if (player.getAbilities().creativeMode) {
                                throwntrident.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                            }

                            p_43395_.spawnEntity(throwntrident);
                            p_43395_.playSoundFromEntity(null, throwntrident, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
                            if (!player.getAbilities().creativeMode) {
                                player.getInventory().removeOne(p_43394_);
                            }
                        }
                    }

                    player.incrementStat(Stats.USED.getOrCreateStat(this));
                    if (j > 0) {
                        float f7 = player.getYaw();
                        float f = player.getPitch();
                        float f1 = -MathHelper.sin(f7 * ((float)Math.PI / 180F)) * MathHelper.cos(f * ((float)Math.PI / 180F));
                        float f2 = -MathHelper.sin(f * ((float)Math.PI / 180F));
                        float f3 = MathHelper.cos(f7 * ((float)Math.PI / 180F)) * MathHelper.cos(f * ((float)Math.PI / 180F));
                        float f4 = MathHelper.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
                        float f5 = 3.0F * ((1.0F + (float)j) / 4.0F);
                        f1 *= f5 / f4;
                        f2 *= f5 / f4;
                        f3 *= f5 / f4;
                        player.addVelocity(f1, f2, f3);
                        player.useRiptide(20);
                        if (player.isOnGround()) {
                            float f6 = 1.1999999F;
                            player.move(MovementType.SELF, new Vec3d(0.0D, 1.1999999F, 0.0D));
                        }

                        SoundEvent soundevent;
                        if (j >= 3) {
                            soundevent = SoundEvents.ITEM_TRIDENT_RIPTIDE_3;
                        } else if (j == 2) {
                            soundevent = SoundEvents.ITEM_TRIDENT_RIPTIDE_2;
                        } else {
                            soundevent = SoundEvents.ITEM_TRIDENT_RIPTIDE_1;
                        }

                        p_43395_.playSoundFromEntity(null, player, soundevent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    }

                }
            }
        }
    }

    public TypedActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack item = p_77659_2_.getStackInHand(p_77659_3_);
        Hand otherhand = p_77659_3_ == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND;
        ItemStack otheritem = p_77659_2_.getStackInHand(otherhand);
        if (otheritem.isIn(ConventionalItemTags.SHIELDS) && !p_77659_2_.getItemCooldownManager().isCoolingDown(otheritem.getItem())) {
            return TypedActionResult.fail(item);
        }else if (item.getDamage() >= item.getMaxDamage() - 1) {
            return TypedActionResult.fail(item);
        } else if (EnchantmentHelper.getRiptide(item) > 0 && !p_77659_2_.isTouchingWaterOrRain()) {
            return TypedActionResult.fail(item);
        }else{
            p_77659_2_.setCurrentHand(p_77659_3_);
            return TypedActionResult.consume(item);
        }
    }


    public boolean postHit(ItemStack p_43390_, LivingEntity p_43391_, LivingEntity p_43392_) {
        p_43390_.damage(1, p_43392_, (p_43414_) -> {
            p_43414_.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.target == EnchantmentTarget.BREAKABLE || enchantment.target == EnchantmentTarget.TRIDENT;
    }

    public boolean postMine(ItemStack p_43399_, World p_43400_, BlockState p_43401_, BlockPos p_43402_, LivingEntity p_43403_) {
        if ((double)p_43401_.getHardness(p_43400_, p_43402_) != 0.0D) {
            p_43399_.damage(2, p_43403_, (p_43385_) -> {
                p_43385_.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
//    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot p_43383_) {
        return p_43383_ == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getAttributeModifiers(p_43383_);
    }

    public int getEnchantability() {
        return 1;
    }
}
