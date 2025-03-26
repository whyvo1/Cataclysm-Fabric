package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.capabilities.ChargeCapability;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModCapabilities;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.github.l_ender.cataclysm.init.ModSounds;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
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
import java.util.List;

public class Gauntlet_of_Bulwark extends Item implements RangeTool, ModShieldDisable {


    public Gauntlet_of_Bulwark(net.minecraft.item.Item.Settings group) {
        super(group);

    }


    public static AttributeModifiersComponent createAttributes() {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 10.0D, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, -2.4F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(BASE_ENTITY_ARMOR_ID, 3F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(BASE_ENTITY_ARMOR_TOUGHNESS_ID, 3F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(BASE_ENTITY_KNOCKBACK_RESISTANCE_ID, 0.15F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND
                )
                .build();
    }

    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.BOW;
    }

    @Override
    public int getMaxUseTime(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }


    public TypedActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack item = p_77659_2_.getStackInHand(p_77659_3_);
        Hand otherhand = p_77659_3_ == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND;

        ItemStack otheritem = p_77659_2_.getStackInHand(otherhand);

        if (otheritem.isIn(ConventionalItemTags.SHIELD_TOOLS) && !p_77659_2_.getItemCooldownManager().isCoolingDown(otheritem.getItem())) {
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
        int c = this.getMaxUseTime(stack,livingEntityIn) - count;
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
            int i = this.getMaxUseTime(stack,entityLiving) - timeLeft;
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
                entityLiving.addVelocity((double) f1, (double) 0, (double) f3);
                if (entityLiving.isOnGround()) {
                    float f6 = 1.1999999F;
                    entityLiving.move(MovementType.SELF, new Vec3d(0.0D, (double) f6 / 2, 0.0D));
                }

                ChargeCapability charge = ModCapabilities.getOrCreate(entityLiving, ModCapabilities.CHARGE_CAPABILITY);
                charge.setCharge(true);
                charge.setTimer(t * 2);
                charge.seteffectiveChargeTime(t * 2);
                charge.setknockbackSpeedIndex(t * 0.35F);
                charge.setdamagePerEffectiveCharge(1.2F);
                charge.setdx(f1 * 0.5F);
                charge.setdZ(f3 * 0.5F);

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
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltips, TooltipType flags) {
        tooltips.add(Text.translatable("item.cataclysm.gauntlet_of_bulwark.desc").formatted(Formatting.DARK_GREEN));
        tooltips.add(Text.translatable("item.cataclysm.gauntlet_of_bulwark.desc2").formatted(Formatting.DARK_GREEN));
    }
}