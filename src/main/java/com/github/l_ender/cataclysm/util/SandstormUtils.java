package com.github.l_ender.cataclysm.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;

public final class SandstormUtils {

	public static void toggleFlight(LivingEntity living, boolean flight) {
		if (!living.getWorld().isClient && living instanceof ServerPlayerEntity player) {
			boolean prevFlying = player.getAbilities().flying;
			boolean trueFlight = isCreativePlayer(living) || flight;
			player.getAbilities().allowFlying = trueFlight;
			player.getAbilities().flying = trueFlight;
			float defaultFlightSpeed = 0.05F;
			if (flight) {
				player.getAbilities().setFlySpeed(defaultFlightSpeed * 0.5F);
			} else {
				player.getAbilities().setFlySpeed(defaultFlightSpeed);
				if (!player.isSpectator()) {
					player.getAbilities().flying = false;
					if(!player.isCreative()){
						player.getAbilities().allowFlying = false;
					}
				}
			}
			if (prevFlying != flight) {
				player.sendAbilitiesUpdate();
			}
		}
	}

	private static boolean isCreativePlayer(LivingEntity living) {
		return living instanceof PlayerEntity player && player.isCreative();
	}
}
