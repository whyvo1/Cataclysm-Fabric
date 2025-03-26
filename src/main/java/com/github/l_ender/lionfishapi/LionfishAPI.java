package com.github.l_ender.lionfishapi;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LionfishAPI {
	public static final String MOD_ID = "lionfishapi";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Identifier PACKET_ANIMATION = Identifier.of(MOD_ID, "animation");

	public static void onInitialize() {

	}
}