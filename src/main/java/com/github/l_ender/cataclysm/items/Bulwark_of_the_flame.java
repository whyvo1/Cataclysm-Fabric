package com.github.l_ender.cataclysm.items;


import com.github.l_ender.cataclysm.capabilities.ChargeCapability;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModCapabilities;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;

public class Bulwark_of_the_flame extends ShieldItem {
    public Bulwark_of_the_flame(Settings group) {
        super(group);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World level, LivingEntity entityLiving, int timeLeft) {
        if(entityLiving.isSneaking()) {
            if(!entityLiving.isFallFlying()) {
                int i = this.getMaxUseTime(stack) - timeLeft;
                int t = MathHelper.clamp(i, 1, 4);
                float f7 = entityLiving.getYaw();
                float f = entityLiving.getPitch();

                float f1 = -MathHelper.sin(f7 * ((float) Math.PI / 180F)) * MathHelper.cos(f * ((float) Math.PI / 180F));
                float f2 = -MathHelper.sin(f * ((float) Math.PI / 180F));
                float f3 = MathHelper.cos(f7 * ((float) Math.PI / 180F)) * MathHelper.cos(f * ((float) Math.PI / 180F));
                float f4 = MathHelper.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
                float f5 = 3.0F * (t / 6.0F);
                f1 *= f5 / f4;
                f3 *= f5 / f4;
                entityLiving.addVelocity(f1, 0, f3);
                if (entityLiving.isOnGround()) {
                    float f6 = 1.1999999F;
                    entityLiving.move(MovementType.SELF, new Vec3d(0.0D, (double) f6 / 2, 0.0D));
                }
                ChargeCapability chargeCapability = ModCapabilities.getOrCreate(entityLiving, ModCapabilities.CHARGE_CAPABILITY);
                if (chargeCapability != null) {
                    chargeCapability.setCharge(true);
                    chargeCapability.setTimer(t * 2);
                    chargeCapability.seteffectiveChargeTime(t * 2);
                    chargeCapability.setknockbackSpeedIndex(t * 2);
                    chargeCapability.setdamagePerEffectiveCharge(0.6F);
                    chargeCapability.setdx(f1 * 0.1F);
                    chargeCapability.setdZ(f3 * 0.1F);
                }
                if (!level.isClient) {
                    ((PlayerEntity) entityLiving).getItemCooldownManager().set(this, CMConfig.BulwarkOfTheFlameCooldown);
                }
            }
        }
    }

//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
//    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.bulwark_of_the_flame.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.bulwark_of_the_flame2.desc").formatted(Formatting.DARK_GREEN));
    }
}