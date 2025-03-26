package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.event.ClientHooks;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Uuids;

import java.util.UUID;

/**
 * Packets to help sync the server's Aether boss bars with the client's.
 */
public abstract class MessageBossBar implements CustomPayload {
    protected final UUID bossEvent;
    protected final int rendertype;

    public MessageBossBar(UUID bossEvent, int rendertype) {
        this.bossEvent = bossEvent;
        this.rendertype = rendertype;
    }

    /**
     * Adds a boss bar for the client.
     */
    public static class Display extends MessageBossBar {
        public static final Id<Display> TYPE = new Id<>(Cataclysm.modIdentifier("add_custom_bossbar"));

        public static final PacketCodec<RegistryByteBuf, Display> STREAM_CODEC = PacketCodec.tuple(
            Uuids.PACKET_CODEC,
            Display::getBossEvent,
            PacketCodecs.INTEGER,
            Display::getRendertype,
            Display::new);

        public Display(UUID bossEvent, int rendertype) {
            super(bossEvent, rendertype);
        }

        @Override
        public Id<Display> getId() {
            return TYPE;
        }

        public static void execute(Display payload, ClientPlayNetworking.Context context) {
            ClientHooks.bossBarRenderTypes.put(payload.bossEvent, payload.rendertype);
        }
    }

    /**
     * Removes a boss bar for the client.
     */
    public static class Remove extends MessageBossBar {
        public static final Id<Remove> TYPE = new Id<>(Cataclysm.modIdentifier("remove_custom_bossbar"));

        public static final PacketCodec<RegistryByteBuf, Remove> STREAM_CODEC = PacketCodec.tuple(
            Uuids.PACKET_CODEC,
            Remove::getBossEvent,
            PacketCodecs.INTEGER,
            Remove::getRendertype,
            Remove::new);

        public Remove(UUID bossEvent, int entityID) {
            super(bossEvent, entityID);
        }

        @Override
        public Id<Remove> getId() {
            return TYPE;
        }

        public static void execute(Remove payload, ClientPlayNetworking.Context context) {
            ClientHooks.bossBarRenderTypes.remove(payload.bossEvent);
        }
    }

    public UUID getBossEvent() {
        return this.bossEvent;
    }

    public int getRendertype() {
        return this.rendertype;
    }
}
