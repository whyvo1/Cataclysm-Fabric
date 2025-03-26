package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.client.particle.RingParticle;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModParticle;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;

public class The_Annihilator extends Item implements ModShieldDisable, ModEnchantable {
    private final Multimap<EntityAttribute, EntityAttributeModifier> annihilator;

    public The_Annihilator(Settings group) {
        super(group);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 6.5D, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -2.4F, EntityAttributeModifier.Operation.ADDITION));
        this.annihilator = builder.build();
    }


    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.SPEAR;
    }

    public int getMaxUseTime(ItemStack p_77626_1_) {
        return 72000;
    }

    public void onStoppedUsing(ItemStack p_43394_, World p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof PlayerEntity player) {
            int i = this.getMaxUseTime(p_43394_) - p_43397_;

            if (i >= 40) {
                yall(p_43395_,p_43396_);
                if (!p_43395_.isClient) {
                    player.getItemCooldownManager().set(this, 100);
                }
            }
        }
    }

    public void usageTick(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        int i = this.getMaxUseTime(stack) - count;
        if (i == 10) {
            masseffectParticle(worldIn,livingEntityIn,2.0F);
        }

        if (i == 20) {
            masseffectParticle(worldIn,livingEntityIn,3.5F);
        }

        if (i == 30) {
            masseffectParticle(worldIn,livingEntityIn,5F);
        }
        if (i == 40) {
            livingEntityIn.playSound(ModSounds.MALEDICTUS_SHORT_ROAR, 1.0F, 1.0f);
        }
    }

    private void yall(World world,LivingEntity caster) {
        double radius = 6.0D;
        ScreenShake_Entity.ScreenShake(world, caster.getPos(), 30, 0.1f, 0, 30);
        world.playSound(null, caster.getX(), caster.getY(), caster.getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.5f, 1F / (caster.getRandom().nextFloat() * 0.4F + 0.8F));
        List<Entity> list = world.getOtherEntities(caster, caster.getBoundingBox().expand(radius, radius, radius));
        for (Entity entity : list) {
            if (entity instanceof LivingEntity) {
                entity.damage(world.getDamageSources().mobAttack(caster), (float) caster.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * 2F);
            }
        }
        if (world.isClient) {
            world.addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 30, 0.337f, 0.925f, 0.8f, 1.0f, 85, false, RingParticle.EnumRingBehavior.GROW), caster.getX() , caster.getY() + 0.03f, caster.getZ(), 0, 0, 0);
        }
    }

    private void masseffectParticle(World world,LivingEntity caster,float radius) {
        if (world.isClient) {
            for (int j = 0; j < 70; ++j) {
                float angle = (float) (Math.random() * 2 * Math.PI);
                double distance = Math.sqrt(Math.random()) * radius;
                double extraX = caster.getX() + distance * MathHelper.cos(angle);
                double extraY = caster.getY() + 0.3F;
                double extraZ = caster.getZ() + distance * MathHelper.sin(angle);

                world.addParticle(ModParticle.PHANTOM_WING_FLAME, extraX, extraY, extraZ, 0.0D, world.random.nextGaussian() * 0.04D, 0.0D);
            }
        }
    }



    public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        ItemStack otherHand = hand == Hand.MAIN_HAND ? player.getStackInHand(Hand.OFF_HAND) : player.getStackInHand(Hand.MAIN_HAND);
        if (otherHand.isOf(ModItems.THE_ANNIHILATOR)) {
            player.setCurrentHand(hand);
            return TypedActionResult.consume(itemstack);
        } else {
            return TypedActionResult.fail(itemstack);
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
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment != Enchantments.SWEEPING && enchantment.target == EnchantmentTarget.WEAPON;
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? this.annihilator : super.getAttributeModifiers(equipmentSlot);
    }


//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
//    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.annihilator.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.annihilator2.desc").formatted(Formatting.DARK_GREEN));
    }
}