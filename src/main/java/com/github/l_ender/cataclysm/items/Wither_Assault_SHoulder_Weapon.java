package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.projectile.Wither_Howitzer_Entity;
import com.github.l_ender.cataclysm.entity.projectile.Wither_Missile_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModSounds;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;

public class Wither_Assault_SHoulder_Weapon extends Item {

    public Wither_Assault_SHoulder_Weapon(Settings group) {
        super(group);
    }


    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.BOW;
    }

    public int getMaxUseTime(ItemStack p_77626_1_) {
        return 72000;
    }

    public void onStoppedUsing(ItemStack p_43394_, World p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof PlayerEntity player) {
            int i = this.getMaxUseTime(p_43394_) - p_43397_;
            float f = getPowerForTime(i);
            if (!((double) f < 0.5D)) {
                p_43395_.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.ROCKET_LAUNCH, SoundCategory.PLAYERS,1.0F, 0.7F);
                if(p_43396_.isSneaking()) {
                    player.getItemCooldownManager().set(this, CMConfig.WASWHowitzerCooldown);
                    if (!p_43395_.isClient) {
                        Wither_Howitzer_Entity rocket = new Wither_Howitzer_Entity(ModEntities.WITHER_HOWITZER, p_43395_, player);
                        rocket.setRadius(3.5F);
                        rocket.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, f, 1.0F);
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
                        Wither_Missile_Entity rocket = new Wither_Missile_Entity(ModEntities.WITHER_MISSILE, player, x, p_43396_.getEyeY(), Z, d1, d2, d3,(float) CMConfig.WASWMissileDamage,p_43395_);
                        //ither_Missile_Entity rocket = new Wither_Missile_Entity(ModEntities.WITHER_MISSILE.get(), x, p_43396_.getEyeY(), Z, d1, d2, d3, p_43395_);
                        p_43395_.spawnEntity(rocket);
                    }
                }
            }
        }

    }

    public static float getPowerForTime(int p_40662_) {
        return Void_Assault_SHoulder_Weapon.getPowerForTime(p_40662_);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        player.setCurrentHand(hand);
        return TypedActionResult.consume(itemstack);
    }


//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
//    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.wither_assault_shoulder_weapon.desc").formatted(Formatting.DARK_GREEN));
        tooltip.add(Text.translatable("item.cataclysm.wither_assault_shoulder_weapon.desc2").formatted(Formatting.DARK_GREEN));
    }
}
