package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.CataclysmClient;
import com.github.l_ender.cataclysm.event.AttackCallback;
import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.HitResult;

public class MessageAttackMiss {
    public final HitResult.Type type;

    public MessageAttackMiss(HitResult.Type type) {
        this.type = type;
    }

    public MessageAttackMiss(PacketByteBuf packet) {
        this(packet.readEnumConstant(HitResult.Type.class));
    }

    public void sendToServer() {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeEnumConstant(this.type);
        CataclysmClient.sendToServer(Cataclysm.PACKET_ATTACK_MISS, buf);
    }

    public static void handle(MinecraftServer minecraftServer, ServerPlayerEntity serverPlayer, PacketByteBuf packet) {
        MessageAttackMiss message = new MessageAttackMiss(packet);
        minecraftServer.execute(() -> {
            AttackCallback.EVENT.invoker().interact(serverPlayer, serverPlayer.getWorld(), message.type);
        });
    }
}
