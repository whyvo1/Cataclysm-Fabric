package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.projectile.Void_Howitzer_Entity;
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
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;
import java.util.List;

public class Void_Assault_SHoulder_Weapon extends Item {

    public Void_Assault_SHoulder_Weapon(Settings group) {
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
                player.getItemCooldownManager().set(this, CMConfig.VASWCooldown);
                if (!p_43395_.isClient) {
                    Void_Howitzer_Entity rocket = new Void_Howitzer_Entity(ModEntities.VOID_HOWITZER, p_43395_, player);
                    rocket.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, f, 1.0F);
                    p_43395_.spawnEntity(rocket);
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

//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
//    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        tooltip.add(Text.translatable("item.cataclysm.void_assault_shoulder_weapon.desc").formatted(Formatting.DARK_GREEN));
    }
}
