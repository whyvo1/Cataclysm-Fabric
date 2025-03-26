package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import io.netty.buffer.Unpooled;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.UUID;

public class MessageUpdateBossBar {

    private UUID bossBar;
    private int renderType;

    public MessageUpdateBossBar(UUID bossBar, int renderType) {
        this.bossBar = bossBar;
        this.renderType = renderType;
    }

    public MessageUpdateBossBar(PacketByteBuf buf) {
        this(buf.readUuid(), buf.readVarInt());
    }

    public void sendToClient(ServerPlayerEntity player) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeUuid(bossBar);
        buf.writeVarInt(renderType);
        Cataclysm.sendToPlayer(player, Cataclysm.PACKET_UPDATE_BOSS_BAR, buf);
    }

//    public static MessageUpdateBossBar read(PacketByteBuf buf) {
//        return new MessageUpdateBossBar(buf.readUuid(), buf.readInt());
//    }

//    public static void write(MessageUpdateBossBar message, PacketByteBuf buf) {
//        buf.writeUuid(message.bossBar);
//        buf.writeInt(message.renderType);
//    }


//    public static void handle(MessageUpdateBossBar message, Supplier<NetworkEvent.Context> context) {
//        context.get().setPacketHandled(true);
//        PlayerEntity playerSided = context.get().getSender();
//        if (context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT) {
//            playerSided = Cataclysm.PROXY.getClientSidePlayer();
//        }
//        if(message.renderType == -1){
//            Cataclysm.PROXY.removeBossBarRender(message.bossBar);
//        }else{
//            Cataclysm.PROXY.setBossBarRender(message.bossBar, message.renderType);
//        }
//    }

    public static void handle(MinecraftClient client, PacketByteBuf buffer) {
        MessageUpdateBossBar message = new MessageUpdateBossBar(buffer);
        client.execute(() -> {
            PlayerEntity playerSided = client.player;
            if(message.renderType == -1){
                Cataclysm.PROXY.removeBossBarRender(message.bossBar);
            }else{
                Cataclysm.PROXY.setBossBarRender(message.bossBar, message.renderType);
            }
        });
    }
}
