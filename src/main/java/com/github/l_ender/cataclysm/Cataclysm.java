package com.github.l_ender.cataclysm;

import com.github.l_ender.cataclysm.client.gui.CustomBossBarStyles;
import com.github.l_ender.cataclysm.config.ConfigHolder;
import com.github.l_ender.cataclysm.event.ServerEventHandler;
import com.github.l_ender.cataclysm.init.*;
import com.github.l_ender.cataclysm.message.*;
import com.github.l_ender.cataclysm.util.NetworkHandler;
import com.github.l_ender.cataclysm.world.CMWorldRegistry;
import com.github.l_ender.lionfishapi.LionfishAPI;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cataclysm implements ModInitializer {
	public static final String MOD_ID = "cataclysm";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static CommonProxy PROXY = new CommonProxy();

	@Override
	public void onInitialize() {
		registerNetworkReceivers();

		ServerEventHandler.registerListeners();

		LionfishAPI.onInitialize();

		ConfigHolder.registerConfigs();

		ModDataComponents.log();

		ModItems.log();
		ModGroup.log();

		ModBlocks.log();
		ModTileentites.log();

		ModEntities.log();
		ModEntities.initializeEntityTypes();

		ModSounds.log();

		ModEffect.log();

		ModParticle.log();

		ModJigsaw.log();
		ModStructurePlacementType.log();
		ModStructures.log();

		ModRecipeTypes.log();

		ModMenu.log();

		ModCapabilities.log();

		CustomBossBarStyles.log();

		CMWorldRegistry.addBiomeSpawns();
	}

	public static Identifier modIdentifier(String name) {
		return Identifier.of(MOD_ID, name);
	}

	private static void registerNetworkReceivers() {
		NetworkHandler.registerServerNetworkReceiver(MessageArmorKey.TYPE, MessageArmorKey.STREAM_CODEC, MessageArmorKey::handle);
		NetworkHandler.registerServerNetworkReceiver(MessageAttackMiss.TYPE, MessageAttackMiss.STREAM_CODEC, MessageAttackMiss::handle);
		NetworkHandler.registerServerNetworkReceiver(MessageCharge.TYPE, MessageCharge.STREAM_CODEC, MessageCharge::handle);
		NetworkHandler.registerServerNetworkReceiver(MessageCMMultipart.TYPE, MessageCMMultipart.STREAM_CODEC, MessageCMMultipart::handle);
		NetworkHandler.registerServerNetworkReceiver(MessageSwingArm.TYPE, MessageSwingArm.STREAM_CODEC, MessageSwingArm::handle);
	}
}