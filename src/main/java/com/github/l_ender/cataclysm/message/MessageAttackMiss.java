package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.event.AttackCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.hit.HitResult;

public record MessageAttackMiss(HitResult.Type type) implements CustomPayload {

    public static final Id<MessageAttackMiss> TYPE = new Id<>(Cataclysm.modIdentifier("attack_miss"));
    public static final PacketCodec<RegistryByteBuf, MessageAttackMiss> STREAM_CODEC = CustomPayload.codecOf(MessageAttackMiss::write, MessageAttackMiss::new);

    public MessageAttackMiss(PacketByteBuf packet) {
        this(packet.readEnumConstant(HitResult.Type.class));
    }

    public void write(PacketByteBuf packet) {
        packet.writeEnumConstant(type);
    }

    @Override
    public Id<MessageAttackMiss> getId() {
        return TYPE;
    }

    public static void handle(MessageAttackMiss message, ServerPlayNetworking.Context context) {
        AttackCallback.EVENT.invoker().interact(context.player(), context.player().getWorld(), message.type);
    }
}
