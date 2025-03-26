package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.projectile.Wither_Howitzer_Entity;
import com.github.l_ender.cataclysm.entity.projectile.Wither_Missile_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import java.util.List;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Wither_Assault_SHoulder_Weapon extends Item {

    public Wither_Assault_SHoulder_Weapon(net.minecraft.item.Item.Settings group) {
        super(group);
    }


    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.BOW;
    }

    @Override
    public int getMaxUseTime(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public void onStoppedUsing(ItemStack p_43394_, World p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof PlayerEntity player) {
            int i = this.getMaxUseTime(p_43394_,p_43396_) - p_43397_;
            float f = getPowerForTime(i);
            if (!((double) f < 0.5D)) {
                p_43395_.playSound((PlayerEntity)null, player.getX(), player.getY(), player.getZ(), ModSounds.ROCKET_LAUNCH, SoundCategory.PLAYERS,1.0F, 0.7F);
                if(p_43396_.isSneaking()) {
                    player.getItemCooldownManager().set(this, CMConfig.WASWHowitzerCooldown);
                    if (!p_43395_.isClient) {
                        Wither_Howitzer_Entity rocket = new Wither_Howitzer_Entity(ModEntities.WITHER_HOWITZER, p_43395_, player);
                        rocket.setRadius(3.5F);
                        rocket.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, f * 1.0F, 1.0F);
                        p_43395_.spawnEntity(rocket);
                    }
                }else {
                    player.getItemCooldownManager().set(this, CMConfig.WASWMissileCooldown);
                    if (!p_43395_.isClient) {
                        float d7 = p_43396_.getYaw();
                        float d = p_43396_.getPitch();
                        float d1 = -MathHelper.sin(d7 * ((float) Math.PI / 180F)) * MathHelper.cos(d * ((float) Math.PI / 180F));
                        float d2 = -MathHelper.sin(d * ((float) Math.PI / 180F));
                        float d3 = MathHelper.cos(d7 * ((float) Math.PI / 180F)) * MathHelper.cos(d * ((float) Math.PI / 180F));
                        double theta = d7 * (Math.PI / 180);
                        theta += Math.PI / 2;
                        double vecX = Math.cos(theta);
                        double vecZ = Math.sin(theta);
                        double x = p_43396_.getX() + vecX;
                        double Z = p_43396_.getZ() + vecZ;
                        Vec3d vec3 = new Vec3d(d1, d2, d3);
                        Wither_Missile_Entity witherskull = new Wither_Missile_Entity(player, vec3.normalize(),p_43395_,(float) CMConfig.WASWMissileDamage);
                        witherskull.setPos(x, p_43396_.getEyeY(), Z);
                        p_43395_.spawnEntity(witherskull);



                    }
                }
            }
        }

    }

    public static float getPowerForTime(int p_40662_) {
        float f = (float)p_40662_ / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        player.setCurrentHand(hand);
        return TypedActionResult.consume(itemstack);
    }


 

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType flags) {
        tooltip.add(Text.translatable("item.cataclysm.wither_assault_shoulder_weapon.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.wither_assault_shoulder_weapon.desc2").formatted(Formatting.DARK_GREEN));
    }
}
