package com.github.l_ender.cataclysm.items;


import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.entity.effect.Sandstorm_Entity;
import com.github.l_ender.cataclysm.init.ModKeybind;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class Sandstorm_In_A_Bottle extends Item {

	public Sandstorm_In_A_Bottle(Settings properties) {
		super(properties);
	}

	@NotNull
	@Override
	public TypedActionResult<ItemStack> use(World level, PlayerEntity player, @NotNull Hand hand) {
		ItemStack stack = player.getStackInHand(hand);
		if (!level.isClient()) {
			for (int i = 0; i < 2; i++) {
				float angle = i * MathHelper.PI;
				double sx = player.getX() + (MathHelper.cos(angle) * 6);
				double sy = player.getY();
				double sz = player.getZ() + (MathHelper.sin(angle) * 6);
				Sandstorm_Entity projectile = new Sandstorm_Entity(player.getWorld(), sx,sy,sz,200,angle,player.getUuid());
				player.getWorld().spawnEntity(projectile);
			}

		}

		if (!level.isClient) {
			player.getItemCooldownManager().set(this,  CMConfig.SandstormInABottleCOOLDOWN);

		}

		return TypedActionResult.success(stack);
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return false;
	}

//	@Override
//	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
//		return false;
//	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World worldIn, List<Text> tooltip, TooltipContext flagIn) {
		tooltip.add(Text.translatable("item.cataclysm.sandstorm_in_a_bottle.desc", ModKeybind.KEY_ABILITY.getBoundKeyLocalizedText()).formatted(Formatting.DARK_GREEN));
	}
}