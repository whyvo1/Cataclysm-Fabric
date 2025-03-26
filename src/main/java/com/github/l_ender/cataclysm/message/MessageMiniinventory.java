package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.gui.MinistrosityInventoryScreen;
import com.github.l_ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import com.github.l_ender.cataclysm.inventory.MinistrostiyMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;


public class MessageMiniinventory {
    private final int syncId;
    private final int size;
    private final int entityId;

    public MessageMiniinventory(int syncId, int size, int entityId) {
        this.syncId = syncId;
        this.size = size;
        this.entityId = entityId;
    }

    public MessageMiniinventory(PacketByteBuf buf) {
        this(buf.readVarInt(), buf.readVarInt(), buf.readVarInt());
    }
    
//    public static MessageMiniinventory read(PacketByteBuf buf) {
//        return new MessageMiniinventory(buf.readUnsignedByte(), buf.readVarInt(), buf.readInt());
//    }

//    public static void write(MessageMiniinventory message, PacketByteBuf buf) {
//        buf.writeByte(message.id);
//        buf.writeVarInt(message.size);
//        buf.writeInt(message.entityId);
//    }

    public void sendToClient(ServerPlayerEntity player) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeVarInt(syncId);
        buf.writeVarInt(size);
        buf.writeVarInt(entityId);
        Cataclysm.sendToPlayer(player, Cataclysm.PACKET_MINI_INVENTORY, buf);
    }

    
    public int getSize() {
        return this.size;
    }
    
    public int getEntityId() {
        return this.entityId;
    }

    public static void handle(MinecraftClient client, PacketByteBuf buffer) {
        MessageMiniinventory message = new MessageMiniinventory(buffer);
        client.execute(() -> {
            ClientPlayerEntity player = client.player;
            if (player != null) {
                Entity entity = player.getWorld().getEntityById(message.getEntityId());
                if (entity instanceof Netherite_Ministrosity_Entity guard) {
                    MinistrostiyMenu container = new MinistrostiyMenu(message.syncId, player.getInventory(), guard.miniInventory, guard);
                    player.currentScreenHandler = container;
                    client.setScreen(new MinistrosityInventoryScreen(container, player.getInventory(), guard));
                }
            }
        });
    }

//    public static class Handler {
//        public Handler() {
//        }
//
//        public static void handle(MessageMiniinventory msg, Supplier<NetworkEvent.Context> context) {
//            context.get().enqueueWork(() -> {
//                openInventory(msg);
//            });
//            context.get().setPacketHandled(true);
//        }
//
//
//        @Environment(EnvType.CLIENT)
//        public static void openInventory(MessageMiniinventory packet) {
//            PlayerEntity player = MinecraftClient.getInstance().player;
//            if (player != null) {
//                Entity entity = player.getWorld().getEntityById(packet.getEntityId());
//                if (entity instanceof Netherite_Ministrosity_Entity guard) {
//                    ClientPlayerEntity clientplayerentity = MinecraftClient.getInstance().player;
//                    MinistrostiyMenu container = new MinistrostiyMenu(packet.getId(), player.getInventory(), guard.miniInventory, guard);
//                    clientplayerentity.currentScreenHandler = container;
//                    MinecraftClient.getInstance().setScreen(new MinistrosityInventoryScreen(container, player.getInventory(), guard));
//                }
//            }
//        }
//    }
}