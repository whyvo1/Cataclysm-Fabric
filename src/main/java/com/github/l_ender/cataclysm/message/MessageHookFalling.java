package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.init.ModCapabilities;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public record MessageHookFalling(int entityID, boolean falling) implements CustomPayload {

	public static final Id<MessageHookFalling> TYPE = new Id<>(Cataclysm.modIdentifier("hook_falling_attachment"));
	public static final PacketCodec<RegistryByteBuf, MessageHookFalling> STREAM_CODEC = CustomPayload.codecOf(MessageHookFalling::write, MessageHookFalling::new);

	public MessageHookFalling(PacketByteBuf buf) {
		this(buf.readVarInt(), buf.readBoolean());
	}

	public void write(PacketByteBuf buf) {
		buf.writeVarInt(this.entityID());
		buf.writeBoolean(this.falling());
	}

	@Override
	public Id<? extends CustomPayload> getId() {
		return TYPE;
	}

	public static void handle(MessageHookFalling message, ClientPlayNetworking.Context context) {
		Entity entity = context.player().getWorld().getEntityById(message.entityID());
		if (entity instanceof LivingEntity entity1) {
			ModCapabilities.getOrCreate(entity1, ModCapabilities.HOOK_CAPABILITY).setHasHook(message.falling());
		}
	}
}