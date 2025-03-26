package com.github.l_ender.lionfishapi;

import com.github.l_ender.lionfishapi.server.network.AnimationMessage;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class LionfishAPIClient {

    public static void onInitializeClient() {
        PayloadTypeRegistry.playS2C().register(AnimationMessage.TYPE, AnimationMessage.STREAM_CODEC);
        ClientPlayNetworking.registerGlobalReceiver(AnimationMessage.TYPE, AnimationMessage::handle);
    }
}
