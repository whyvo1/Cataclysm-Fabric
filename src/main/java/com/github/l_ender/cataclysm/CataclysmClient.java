package com.github.l_ender.cataclysm;

import com.github.l_ender.cataclysm.client.gui.CustomBossBarStyles;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.render.BlockRenderLayer;
import com.github.l_ender.cataclysm.client.render.CMItemstackRenderer;
import com.github.l_ender.cataclysm.client.render.item.CMItemRenderProperties;
import com.github.l_ender.cataclysm.client.render.item.CustomArmorRenderProperties;
import com.github.l_ender.cataclysm.init.*;
import com.github.l_ender.cataclysm.message.*;
import com.github.l_ender.cataclysm.util.NetworkHandler;
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
        registerNetworkReceivers();

        Cataclysm.PROXY = new ClientProxy();

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
        ModKeybind.log();

        CMModelLayers.register();
        BlockRenderLayer.putAllLayers();

        CustomArmorRenderProperties.initializeModels();
        CustomArmorRenderProperties.registerArmorRenderers();
        CMItemRenderProperties.registerItemRenderers();

        CustomBossBarStyles.log();

        Cataclysm.PROXY.clientInit();
    }

    private static void registerNetworkReceivers() {
        NetworkHandler.registerClientNetworkReceiver(MessageBossBar.Display.TYPE, MessageBossBar.Display.STREAM_CODEC, MessageBossBar.Display::execute);
        NetworkHandler.registerClientNetworkReceiver(MessageBossBar.Remove.TYPE, MessageBossBar.Remove.STREAM_CODEC, MessageBossBar.Remove::execute);
        NetworkHandler.registerClientNetworkReceiver(MessageHookFalling.TYPE, MessageHookFalling.STREAM_CODEC, MessageHookFalling::handle);
        NetworkHandler.registerClientNetworkReceiver(MessageMeatShredder.TYPE, MessageMeatShredder.STREAM_CODEC, MessageMeatShredder::handle);
        NetworkHandler.registerClientNetworkReceiver(MessageMusic.TYPE, MessageMusic.STREAM_CODEC, MessageMusic::handle);
        NetworkHandler.registerClientNetworkReceiver(MessageOpenInventory.TYPE, MessageOpenInventory.STREAM_CODEC, MessageOpenInventory::handle);
        NetworkHandler.registerClientNetworkReceiver(MessageParticle.TYPE, MessageParticle.STREAM_CODEC, MessageParticle::handle);
        NetworkHandler.registerClientNetworkReceiver(MessageRenderRush.TYPE, MessageRenderRush.STREAM_CODEC, MessageRenderRush::handle);
        NetworkHandler.registerClientNetworkReceiver(MessageSandstormSound.TYPE, MessageSandstormSound.STREAM_CODEC, MessageSandstormSound::handle);
        NetworkHandler.registerClientNetworkReceiver(MessageTidalTentacle.TYPE, MessageTidalTentacle.STREAM_CODEC, MessageTidalTentacle::handle);
    }
}
