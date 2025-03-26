package com.github.l_ender.cataclysm.util;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.network.ServerPlayerEntity;

public class NetworkHandler {

    public static <V extends CustomPayload> void registerClientNetworkReceiver(
            CustomPayload.Id<V> id,
            PacketCodec<RegistryByteBuf, V> codec,
            ClientPlayNetworking.PlayPayloadHandler<V> handler
    ) {
        PayloadTypeRegistry.playS2C().register(id, codec);
        ClientPlayNetworking.registerGlobalReceiver(id, handler);
    }

    public static <V extends CustomPayload> void sendToServer(V payload) {
        ClientPlayNetworking.send(payload);
    }

    public static <V extends CustomPayload> void registerServerNetworkReceiver(
            CustomPayload.Id<V> id,
            PacketCodec<RegistryByteBuf, V> codec,
            ServerPlayNetworking.PlayPayloadHandler<V> handler
    ) {
        PayloadTypeRegistry.playC2S().register(id, codec);
        ServerPlayNetworking.registerGlobalReceiver(id, handler);
    }

    public static <V extends CustomPayload> void sendToPlayer(ServerPlayerEntity player, V payload) {
        ServerPlayNetworking.send(player, payload);
    }

    public static <V extends CustomPayload> void sendToPlayersTrackingEntity(Entity tracked, V payload) {
        for(ServerPlayerEntity player : PlayerLookup.tracking(tracked)) {
            ServerPlayNetworking.send(player, payload);
        }
    }
}
