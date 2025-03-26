package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.capabilities.ChargeCapability;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModCapabilities;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModSounds;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;

public class Gauntlet_of_Bulwark extends SwordItem implements More_Tool_Attribute, ModShieldDisable, ModEnchantable {
    private final Multimap<EntityAttribute, EntityAttributeModifier> guantletAttributes;

    public Gauntlet_of_Bulwark(Settings group) {
        super(ToolMaterials.STONE, 0, 0.0F,  group);
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
        double radius = 4.5D;
        World world = livingEntityIn.getWorld();
        List<Entity> list = world.getOtherEntities(livingEntityIn, livingEntityIn.getBoundingBox().expand(radius));
        int c = this.getMaxUseTime(stack) - count;
        if (c == 20) {
            livingEntityIn.playSound(ModSounds.FLAME_BURST, 1.0F, 1.0f);
            for (Entity entity : list) {
                if (entity instanceof LivingEntity) {
                    if (entity instanceof PlayerEntity && ((PlayerEntity) entity).getAbilities().invulnerable) continue;
                    ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 40));
                    if (entity.isOnGround()) {
                        double d0 = entity.getX() - livingEntityIn.getX();
                        double d1 = entity.getZ() - livingEntityIn.getZ();
                        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                        float f = 1.5F;
                        entity.addVelocity(d0 / d2 * f, 0.1F, d1 / d2 * f);
                    }
                }

            }
            if (world.isClient) {
                for (int i = 0; i < 20; i++) {
                    final float velocity = 0.2F;
                    float yaw = i * ((float) (2 * StrictMath.PI) / 20);
                    float vy = world.getRandom().nextFloat() * 0.1F - 0.05f;
                    float vx = velocity * MathHelper.cos(yaw);
                    float vz = velocity * MathHelper.sin(yaw);
                    world.addParticle(ParticleTypes.FLAME, livingEntityIn.getX(), livingEntityIn.getY() + 1, livingEntityIn.getZ(), vx, vy, vz);

                }
            }
        }

    }

    @Override
    public void onStoppedUsing(ItemStack stack, World level, LivingEntity entityLiving, int timeLeft) {
        if(!entityLiving.isSneaking()) {
            if(!entityLiving.isFallFlying()) {
            int i = this.getMaxUseTime(stack) - timeLeft;
            int t = MathHelper.clamp(i, 1, 5);
            float f7 = entityLiving.getYaw();
            float f = entityLiving.getPitch();
            if (!(i < 20)) {
                float f1 = -MathHelper.sin(f7 * ((float) Math.PI / 180F)) * MathHelper.cos(f * ((float) Math.PI / 180F));
                float f2 = -MathHelper.sin(f * ((float) Math.PI / 180F));
                float f3 = MathHelper.cos(f7 * ((float) Math.PI / 180F)) * MathHelper.cos(f * ((float) Math.PI / 180F));
                float f4 = MathHelper.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
                float f5 = 3.0F * (t / 6.0F);
                f1 *= f5 / f4;
                f3 *= f5 / f4;
                entityLiving.addVelocity(f1, 0.0, f3);
                if (entityLiving.isOnGround()) {
                    float f6 = 1.1999999F;
                    entityLiving.move(MovementType.SELF, new Vec3d(0.0D, (double) f6 / 2, 0.0D));
                }

                ChargeCapability chargeCapability = ModCapabilities.getOrCreate(entityLiving, ModCapabilities.CHARGE_CAPABILITY);
                if (chargeCapability != null) {
                    chargeCapability.setCharge(true);
                    chargeCapability.setTimer(t * 2);
                    chargeCapability.seteffectiveChargeTime(t * 2);
                    chargeCapability.setknockbackSpeedIndex(t * 0.35F);
                    chargeCapability.setdamagePerEffectiveCharge(1.2F);
                    chargeCapability.setdx(f1 * 0.5F);
                    chargeCapability.setdZ(f3 * 0.5F);
                }

                if (!level.isClient) {
                    ((PlayerEntity) entityLiving).getItemCooldownManager().set(this, CMConfig.GauntletOfBulwarkCooldown);
                }
            }
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
        return enchantment.target == EnchantmentTarget.WEAPON && enchantment != Enchantments.SWEEPING;
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
        tooltip.add(Text.translatable("item.cataclysm.gauntlet_of_bulwark.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.gauntlet_of_bulwark.desc2").formatted(Formatting.DARK_GREEN));
    }
}