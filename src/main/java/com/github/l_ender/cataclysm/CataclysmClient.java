package com.github.l_ender.cataclysm;

import com.github.l_ender.cataclysm.client.gui.CustomBossBarStyles;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.render.BlockRenderLayer;
import com.github.l_ender.cataclysm.client.render.CMItemstackRenderer;
import com.github.l_ender.cataclysm.client.render.item.CMItemRenderProperties;
import com.github.l_ender.cataclysm.client.render.item.CustomArmorRenderProperties;
import com.github.l_ender.cataclysm.init.*;
import com.github.l_ender.cataclysm.message.*;
import com.github.l_ender.lionfishapi.LionfishAPIClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class CataclysmClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        Cataclysm.PROXY = new ClientProxy();

        registerNetworkReceiver(Cataclysm.PACKET_MINI_INVENTORY, MessageMiniinventory::handle);
        registerNetworkReceiver(Cataclysm.PACKET_MUSIC, MessageMusic::handle);
        registerNetworkReceiver(Cataclysm.PACKET_PARTICLE, MessageParticle::handle);
        registerNetworkReceiver(Cataclysm.PACKET_UPDATE_BLOCK_ENTITY, MessageUpdateblockentity::handle);
        registerNetworkReceiver(Cataclysm.PACKET_UPDATE_BOSS_BAR, MessageUpdateBossBar::handle);
        registerNetworkReceiver(Cataclysm.PACKET_CM_MULTIPART, MessageCMMultipart::handle);
        ClientTickEvents.START_CLIENT_TICK.register(minecraftClient -> CMItemstackRenderer.incrementTick());

        LionfishAPIClient.onInitializeClient();

        ModItems.log();
        ModGroup.log();

        ModBlocks.log();
        ModTileentites.log();
        ModEntities.log();
        ModSounds.log();
        ModEffect.log();
        ModParticle.log();
        ModMenu.log();
        ModMenu.registerClient();

        CMModelLayers.register();
        BlockRenderLayer.putAllLayers();

        CustomArmorRenderProperties.initializeModels();
        CustomArmorRenderProperties.registerArmorRenderers();
        CMItemRenderProperties.registerItemRenderers();

        CustomBossBarStyles.log();

        Cataclysm.PROXY.clientInit();
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
