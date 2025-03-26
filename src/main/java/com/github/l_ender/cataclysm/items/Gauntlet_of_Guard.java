package com.github.l_ender.cataclysm.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;

public class Gauntlet_of_Guard extends Item implements More_Tool_Attribute, ModShieldDisable, ModEnchantable{
    private final Multimap<EntityAttribute, EntityAttributeModifier> guantletAttributes;

    public Gauntlet_of_Guard(Settings group) {
        super(group);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 10.0D, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -2.4F, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(BASE_ARMOR_ID, "Tool modifier", 3.0F, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(BASE_ARMOR_TOUGHNESS_ID, "Tool modifier", 3F, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(BASE_KNOCKBACK_RESISTANCE_ID, "Tool modifier", 0.15F, EntityAttributeModifier.Operation.ADDITION));
        this.guantletAttributes = builder.build();
    }


    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.BOW;
    }

    public int getMaxUseTime(ItemStack p_77626_1_) {
        return 72000;
    }


    public TypedActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack item = p_77659_2_.getStackInHand(p_77659_3_);
        Hand otherhand = p_77659_3_ == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND;
        ItemStack otheritem = p_77659_2_.getStackInHand(otherhand);
        if (otheritem.isIn(ConventionalItemTags.SHIELDS) && !p_77659_2_.getItemCooldownManager().isCoolingDown(otheritem.getItem())) {
            return TypedActionResult.fail(item);
        }else{
            p_77659_2_.setCurrentHand(p_77659_3_);
            return TypedActionResult.consume(item);
        }
    }

    public void usageTick(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        double radius = 11.0D;
        World world = livingEntityIn.getWorld();
        List<LivingEntity> list = world.getNonSpectatingEntities(LivingEntity.class, livingEntityIn.getBoundingBox().expand(radius));
        for (LivingEntity entity : list) {
            if (entity instanceof PlayerEntity && ((PlayerEntity) entity).getAbilities().invulnerable) continue;
            Vec3d diff = entity.getPos().subtract(livingEntityIn.getPos().add(0,0,0));
            diff = diff.normalize().multiply(0.1);
            entity.setVelocity(entity.getVelocity().subtract(diff));

        }

        if (world.isClient) {
            for (int i = 0; i < 3; ++i) {
                int j = world.random.nextInt(2) * 2 - 1;
                int k = world.random.nextInt(2) * 2 - 1;
                double d0 = livingEntityIn.getX() + 0.25D * (double) j;
                double d1 = (float) livingEntityIn.getY() + world.random.nextFloat();
                double d2 = livingEntityIn.getZ() + 0.25D * (double) k;
                double d3 = world.random.nextFloat() * (float) j;
                double d4 = ((double) world.random.nextFloat() - 0.5D) * 0.125D;
                double d5 = world.random.nextFloat() * (float) k;
                world.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
            }
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
        return enchantment.target != EnchantmentTarget.BREAKABLE && enchantment.target == EnchantmentTarget.WEAPON && enchantment != Enchantments.SWEEPING;
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? this.guantletAttributes : super.getAttributeModifiers(equipmentSlot);
    }

//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
//    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.gauntlet_of_guard.desc").formatted(Formatting.DARK_GREEN));
    }
}