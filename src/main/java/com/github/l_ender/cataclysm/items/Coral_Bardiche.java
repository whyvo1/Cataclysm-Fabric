package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.entity.projectile.ThrownCoral_Bardiche_Entity;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import java.util.List;

public class Coral_Bardiche extends TridentItem implements ProjectileItem,RangeTool {

    public Coral_Bardiche(net.minecraft.item.Item.Settings p_43381_) {
        super(p_43381_);

    }

    public static AttributeModifiersComponent createAttributes() {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 9.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, -3.2F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, new EntityAttributeModifier(BASE_ENTITY_INTERACTION_RANGE_ID, 1.5F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .build();
    }

    public static ToolComponent createToolProperties() {
        return new ToolComponent(List.of(), 1.0F, 2);
    }

    @Override
    public boolean canMine(BlockState p_43409_, World p_43410_, BlockPos p_43411_, PlayerEntity p_43412_) {
        return !p_43412_.isCreative();
    }

    public UseAction getUseAction(ItemStack p_43417_) {
        return UseAction.SPEAR;
    }

    @Override
    public int getMaxUseTime(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }


    @Override
    public void onStoppedUsing(ItemStack p_43394_, World p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof PlayerEntity player) {
            int i = this.getMaxUseTime(p_43394_, p_43396_) - p_43397_;
            if (i >= 10) {
                float f = EnchantmentHelper.getTridentSpinAttackStrength(p_43394_, player);
                if (!(f > 0.0F) || player.isTouchingWaterOrRain()) {
                    if (!isTooDamagedToUse(p_43394_)) {
                        RegistryEntry<SoundEvent> holder = EnchantmentHelper.getEffect(p_43394_, EnchantmentEffectComponentTypes.TRIDENT_SOUND)
                                .orElse(SoundEvents.ITEM_TRIDENT_THROW);
                        if (!p_43395_.isClient) {
                            p_43394_.damage(1, player, LivingEntity.getSlotForHand(p_43396_.getActiveHand()));
                            if (f == 0.0F) {
                                ThrownCoral_Bardiche_Entity throwntrident = new ThrownCoral_Bardiche_Entity(p_43395_, player, p_43394_);
                                throwntrident.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 2.5F, 1.0F);
                                if (player.isInCreativeMode()) {
                                    throwntrident.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                                }

                                p_43395_.spawnEntity(throwntrident);
                                p_43395_.playSoundFromEntity(null, throwntrident, holder.value(), SoundCategory.PLAYERS, 1.0F, 1.0F);
                                if (!player.isInCreativeMode()) {
                                    player.getInventory().removeOne(p_43394_);
                                }
                            }
                        }

                        player.incrementStat(Stats.USED.getOrCreateStat(this));
                        if (f > 0.0F) {
                            float f7 = player.getYaw();
                            float f1 = player.getPitch();
                            float f2 = -MathHelper.sin(f7 * (float) (Math.PI / 180.0)) * MathHelper.cos(f1 * (float) (Math.PI / 180.0));
                            float f3 = -MathHelper.sin(f1 * (float) (Math.PI / 180.0));
                            float f4 = MathHelper.cos(f7 * (float) (Math.PI / 180.0)) * MathHelper.cos(f1 * (float) (Math.PI / 180.0));
                            float f5 = MathHelper.sqrt(f2 * f2 + f3 * f3 + f4 * f4);
                            f2 *= f / f5;
                            f3 *= f / f5;
                            f4 *= f / f5;
                            player.addVelocity(f2, f3, f4);
                            player.useRiptide(20, 8.0F, p_43394_);
                            if (player.isOnGround()) {
                                float f6 = 1.1999999F;
                                player.move(MovementType.SELF, new Vec3d(0.0, 1.1999999F, 0.0));
                            }

                            p_43395_.playSoundFromEntity(null, player, holder.value(), SoundCategory.PLAYERS, 1.0F, 1.0F);
                        }
                    }
                }
            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World p_43405_, PlayerEntity p_43406_, Hand p_43407_) {
        ItemStack itemstack = p_43406_.getStackInHand(p_43407_);
        Hand otherhand = p_43407_ == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND;
        ItemStack otheritem = p_43406_.getStackInHand(otherhand);
        if (otheritem.isIn(ConventionalItemTags.SHIELD_TOOLS) && !p_43406_.getItemCooldownManager().isCoolingDown(otheritem.getItem())) {
            return TypedActionResult.fail(itemstack);
        }else if (isTooDamagedToUse(itemstack)) {
            return TypedActionResult.fail(itemstack);
        } else if (EnchantmentHelper.getTridentSpinAttackStrength(itemstack, p_43406_) > 0.0F && !p_43406_.isTouchingWaterOrRain()) {
            return TypedActionResult.fail(itemstack);
        } else {
            p_43406_.setCurrentHand(p_43407_);
            return TypedActionResult.consume(itemstack);
        }
    }



    private static boolean isTooDamagedToUse(ItemStack p_353073_) {
        return p_353073_.getDamage() >= p_353073_.getMaxDamage() - 1;
    }

    @Override
    public boolean postHit(ItemStack p_43390_, LivingEntity p_43391_, LivingEntity p_43392_) {
        return true;
    }

    @Override
    public void postDamageEntity(ItemStack p_345950_, LivingEntity p_345617_, LivingEntity p_345537_) {
        p_345950_.damage(1, p_345537_, EquipmentSlot.MAINHAND);
    }

    @Override
    public int getEnchantability() {
        return 1;
    }

    @Override
    public ProjectileEntity createEntity(World p_338505_, Position p_338277_, ItemStack p_338353_, Direction p_338220_) {
        ThrownCoral_Bardiche_Entity throwntrident = new ThrownCoral_Bardiche_Entity(p_338505_, p_338277_.getX(), p_338277_.getY(), p_338277_.getZ(), p_338353_.copyWithCount(1));
        throwntrident.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
        return throwntrident;
    }

//    @Override
//    public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ItemAbility itemAbility) {
//        return net.neoforged.neoforge.common.ItemAbilities.DEFAULT_TRIDENT_ACTIONS.contains(itemAbility);
//    }
}
