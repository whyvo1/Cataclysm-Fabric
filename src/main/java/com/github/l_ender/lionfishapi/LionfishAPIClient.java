package com.github.l_ender.lionfishapi;

import com.github.l_ender.lionfishapi.server.network.AnimationMessage;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class LionfishAPIClient {

    public static void onInitializeClient() {
        registerNetworkReceiver(LionfishAPI.PACKET_ANIMATION, AnimationMessage::handle);
    }

    public static void registerNetworkReceiver(Identifier resourceLocation, S2CPacketCallback packetCallback) {
        ClientPlayNetworking.registerGlobalReceiver(resourceLocation, (client, handler, buf, sender) -> packetCallback.packetCallback(client, buf));
    }

    public static void sendToServer(Identifier id, PacketByteBuf packet) {
        ClientPlayNetworking.send(id, packet);
    }

    @FunctionalInterface
    public interface S2CPacketCallback {
        void packetCallback(MinecraftClient client, PacketByteBuf packet);
    }
}
