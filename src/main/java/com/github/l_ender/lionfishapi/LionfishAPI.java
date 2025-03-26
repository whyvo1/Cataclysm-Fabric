package com.github.l_ender.lionfishapi;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LionfishAPI {
	public static final String MOD_ID = "lionfishapi";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Identifier PACKET_ANIMATION = new Identifier(MOD_ID, "animation");

	public static void onInitialize() {

	}

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