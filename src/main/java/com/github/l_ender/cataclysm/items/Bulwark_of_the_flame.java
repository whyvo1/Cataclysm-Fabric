package com.github.l_ender.cataclysm.items;


import com.github.l_ender.cataclysm.capabilities.ChargeCapability;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModCapabilities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import java.util.List;

public class Bulwark_of_the_flame extends ShieldItem {
    public Bulwark_of_the_flame(net.minecraft.item.Item.Settings group) {
        super(group);
    }

//    @Override
//    public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ItemAbility itemAbility) {
//        return net.neoforged.neoforge.common.ItemAbilities.DEFAULT_SHIELD_ACTIONS.contains(itemAbility);
//    }

    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.BLOCK;
    }

    @Override
    public int getMaxUseTime(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World level, LivingEntity entityLiving, int timeLeft) {
        if(entityLiving.isSneaking()) {
            if(!entityLiving.isFallFlying()) {
                int i = this.getMaxUseTime(stack,entityLiving) - timeLeft;
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

                ChargeCapability charge = ModCapabilities.getOrCreate(entityLiving, ModCapabilities.CHARGE_CAPABILITY);
                charge.setCharge(true);
                charge.setTimer(t * 2);
                charge.seteffectiveChargeTime(t * 2);
                charge.setknockbackSpeedIndex(t * 2);
                charge.setdamagePerEffectiveCharge(0.6F);
                charge.setdx(f1 * 0.1F);
                charge.setdZ(f3 * 0.1F);

                if (!level.isClient) {
                    ((PlayerEntity) entityLiving).getItemCooldownManager().set(this, CMConfig.BulwarkOfTheFlameCooldown);
                }
            }
        }
    }

    public TypedActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack lvt_4_1_ = p_77659_2_.getStackInHand(p_77659_3_);
        p_77659_2_.setCurrentHand(p_77659_3_);
        return TypedActionResult.consume(lvt_4_1_);
    }

 

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltips, TooltipType flags) {
        tooltips.add(Text.translatable("item.cataclysm.bulwark_of_the_flame.desc").formatted(Formatting.DARK_GREEN));
        tooltips.add(Text.translatable("item.cataclysm.bulwark_of_the_flame2.desc").formatted(Formatting.DARK_GREEN));
    }
}