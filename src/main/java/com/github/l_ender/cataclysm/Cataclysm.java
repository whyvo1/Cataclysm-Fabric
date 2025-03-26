package com.github.l_ender.cataclysm;

import com.github.l_ender.cataclysm.client.gui.CustomBossBarStyles;
import com.github.l_ender.cataclysm.config.ConfigHolder;
import com.github.l_ender.cataclysm.event.ServerEventHandler;
import com.github.l_ender.cataclysm.init.*;
import com.github.l_ender.cataclysm.message.MessageArmorKey;
import com.github.l_ender.cataclysm.message.MessageAttackMiss;
import com.github.l_ender.cataclysm.message.MessageSwingArm;
import com.github.l_ender.cataclysm.world.CMWorldRegistry;
import com.github.l_ender.lionfishapi.LionfishAPI;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cataclysm implements ModInitializer {
	public static final String MOD_ID = "cataclysm";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier PACKET_ARMOR_KEY = modIdentifier("armor_key");
	public static Identifier PACKET_MINI_INVENTORY = modIdentifier("mini_inventory");
	public static Identifier PACKET_MUSIC = modIdentifier("music");
	public static Identifier PACKET_PARTICLE = modIdentifier("particle");
	public static Identifier PACKET_SWING_ARM = modIdentifier("swing_arm");
	public static Identifier PACKET_UPDATE_BLOCK_ENTITY = modIdentifier("update_block_entity");
	public static Identifier PACKET_UPDATE_BOSS_BAR = modIdentifier("update_message_update");
	public static Identifier PACKET_CM_MULTIPART = modIdentifier("cm_multipart");
	public static Identifier PACKET_ATTACK_MISS = modIdentifier("attack_miss");

	public static CommonProxy PROXY = new CommonProxy();

	@Override
	public void onInitialize() {
		registerNetworkReceiver(PACKET_ARMOR_KEY, MessageArmorKey::handle);
		registerNetworkReceiver(PACKET_SWING_ARM, MessageSwingArm::handle);
		registerNetworkReceiver(PACKET_ATTACK_MISS, MessageAttackMiss::handle);

		ServerEventHandler.registerListeners();

		LionfishAPI.onInitialize();

		ConfigHolder.registerConfigs();

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
		ModStructureProcessor.log();
		ModStructurePlacementType.log();
		ModStructures.log();
		Modfeatures.log();

		ModRecipeTypes.log();

		ModMenu.log();

		ModCapabilities.log();

		CustomBossBarStyles.log();

		CMWorldRegistry.addBiomeSpawns();
		CMWorldRegistry.modifyStructure();
	}

	public static Identifier modIdentifier(String name) {
		return new Identifier(MOD_ID, name);
	}

//	public static <MSG> void sendMSGToServer(MSG message) {
//		NETWORK_WRAPPER.sendToServer(message);
//	}

//	public static <MSG> void sendMSGToAll(MSG message) {
//		for (ServerPlayerEntity player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()) {
//			sendNonLocal(message, player);
//		}
//	}

//	public static <MSG> void sendNonLocal(MSG msg, ServerPlayerEntity player) {
//		NETWORK_WRAPPER.sendTo(msg, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
//	}

	public static void registerNetworkReceiver(Identifier resourceLocation, C2SPacketCallback packetCallback) {
		ServerPlayNetworking.registerGlobalReceiver(resourceLocation, (server, player, handler, buf, sender) -> packetCallback.packetCallback(server, player, buf));
	}

	public static void sendToPlayer(ServerPlayerEntity player, Identifier id, PacketByteBuf packet) {
		ServerPlayNetworking.send(player, id, packet);
	}

	@FunctionalInterface
	public interface C2SPacketCallback {
		void packetCallback(MinecraftServer server, ServerPlayerEntity player, PacketByteBuf packet);
	}
}