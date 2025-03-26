package com.github.l_ender.lionfishapi.server.network;

import com.github.l_ender.lionfishapi.LionfishAPI;
import com.github.l_ender.lionfishapi.server.animation.IAnimatedEntity;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;


public record AnimationMessage(int entityID, int index) implements CustomPayload {

    public static final Id<AnimationMessage> TYPE = new Id<>(Identifier.of(LionfishAPI.MOD_ID, "render_attachment"));
    public static final PacketCodec<RegistryByteBuf, AnimationMessage> STREAM_CODEC = CustomPayload.codecOf(AnimationMessage::write, AnimationMessage::new);


    public AnimationMessage(PacketByteBuf buf) {
        this(buf.readVarInt(), buf.readVarInt());
    }

    public void write(final PacketByteBuf buf) {
        buf.writeVarInt(this.entityID);
        buf.writeVarInt(this.index);
    }

    public static void handle(AnimationMessage message, ClientPlayNetworking.Context context) {
        ClientWorld world = MinecraftClient.getInstance().world;
        if(world == null) return;
        IAnimatedEntity entity = (IAnimatedEntity) MinecraftClient.getInstance().world.getEntityById(message.entityID);
        if (entity != null) {
            if (message.index == -1) {
                entity.setAnimation(IAnimatedEntity.NO_ANIMATION);
            } else {
                entity.setAnimation(entity.getAnimations()[message.index]);
            }
            entity.setAnimationTick(0);
        }
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return TYPE;
    }
}
