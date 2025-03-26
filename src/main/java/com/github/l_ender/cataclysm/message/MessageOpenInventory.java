package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.gui.MinistrosityInventoryScreen;
import com.github.l_ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import com.github.l_ender.cataclysm.inventory.MinistrostiyMenu;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


public record MessageOpenInventory(int id, int size, int entityId) implements CustomPayload {
    public static final Id<MessageOpenInventory> TYPE = new Id<>(Cataclysm.modIdentifier("open_inventory"));

    public static final PacketCodec<RegistryByteBuf, MessageOpenInventory> STREAM_CODEC = PacketCodec.tuple(
            PacketCodecs.VAR_INT, MessageOpenInventory::id,
            PacketCodecs.VAR_INT, MessageOpenInventory::size,
            PacketCodecs.VAR_INT, MessageOpenInventory::entityId,
            MessageOpenInventory::new
    );

    public static void handle(MessageOpenInventory payload, ClientPlayNetworking.Context context) {
        openGuardInventory(payload);
    }

    @Environment(EnvType.CLIENT)
    public static void openGuardInventory(MessageOpenInventory packet) {

        PlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null) {
            Entity entity = player.getWorld().getEntityById(packet.entityId());
            if (entity instanceof Netherite_Ministrosity_Entity guard) {
                ClientPlayerEntity clientplayerentity = MinecraftClient.getInstance().player;
                int i = guard.getInventoryColumns();
                MinistrostiyMenu container = new MinistrostiyMenu(packet.id(), player.getInventory(), guard.miniInventory, guard);
                clientplayerentity.currentScreenHandler = container;
                MinecraftClient.getInstance().setScreen(new MinistrosityInventoryScreen(container, player.getInventory(), guard,i));
            }
        }

    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return TYPE;
    }
}