package com.github.l_ender.lionfishapi.server.network;

import com.github.l_ender.lionfishapi.LionfishAPI;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;
import io.netty.buffer.Unpooled;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;

import java.util.function.Supplier;

public class AnimationMessage {
    private int entityID;
    private int index;

    public AnimationMessage(int entityID, int index) {
        this.entityID = entityID;
        this.index = index;
    }

    public AnimationMessage(PacketByteBuf buf) {
        this(buf.readVarInt(), buf.readVarInt());
    }

    public static void write(final AnimationMessage message, final PacketByteBuf buf) {
        buf.writeVarInt(message.entityID);
        buf.writeVarInt(message.index);
    }

    public void sendToClient(Entity tracked) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeVarInt(entityID);
        buf.writeVarInt(index);
        for(ServerPlayerEntity player : PlayerLookup.tracking(tracked)) {
            LionfishAPI.sendToPlayer(player, LionfishAPI.PACKET_ANIMATION, buf);
        }
    }

//    public static AnimationMessage read(final PacketByteBuf buf) {
//        final AnimationMessage message = new AnimationMessage();
//        message.entityID = buf.readVarInt();
//        message.index = buf.readVarInt();
//        return message;
//    }

    public static void handle(MinecraftClient client, PacketByteBuf buffer) {
        AnimationMessage message = new AnimationMessage(buffer);
        client.execute(() -> {
            IAnimatedEntity entity = (IAnimatedEntity) client.world.getEntityById(message.entityID);
            if (entity != null) {
                if (message.index == -1) {
                    entity.setAnimation(IAnimatedEntity.NO_ANIMATION);
                } else {
                    entity.setAnimation(entity.getAnimations()[message.index]);
                }
                entity.setAnimationTick(0);
            }
        });
    }

//    public static class Handler {
//        public Handler() {
//        }
//
//        public static void handle(AnimationMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
//            final NetworkEvent.Context context = contextSupplier.get();
//            context.enqueueWork(() -> {
//                IAnimatedEntity entity = (IAnimatedEntity) Minecraft.getInstance().level.getEntity(message.entityID);
//                if (entity != null) {
//                    if (message.index == -1) {
//                        entity.setAnimation(IAnimatedEntity.NO_ANIMATION);
//                    } else {
//                        entity.setAnimation(entity.getAnimations()[message.index]);
//                    }
//                    entity.setAnimationTick(0);
//                }
//            });
//            context.setPacketHandled(true);
//        }
//    }
}
