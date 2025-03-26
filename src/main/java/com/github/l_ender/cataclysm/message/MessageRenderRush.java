package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.capabilities.RenderRushCapability;
import com.github.l_ender.cataclysm.init.ModCapabilities;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.world.World;


public record MessageRenderRush(int entityID, boolean falling,int timer,float damage) implements CustomPayload {

	public static final Id<MessageRenderRush> TYPE = new Id<>(Cataclysm.modIdentifier("render_attachment"));
	public static final PacketCodec<RegistryByteBuf, MessageRenderRush> STREAM_CODEC = CustomPayload.codecOf(MessageRenderRush::write, MessageRenderRush::new);

	public MessageRenderRush(PacketByteBuf buf) {
		this(buf.readVarInt(), buf.readBoolean(),buf.readVarInt(),buf.readFloat());
	}

	public void write(PacketByteBuf buf) {
		buf.writeVarInt(this.entityID());
		buf.writeBoolean(this.falling());
		buf.writeVarInt(this.timer());
		buf.writeFloat(this.damage());
	}

	@Override
	public Id<? extends CustomPayload> getId() {
		return TYPE;
	}

	public static void handle(MessageRenderRush message, ClientPlayNetworking.Context context) {
		World level = context.player().getWorld();
		Entity entity = level.getEntityById(message.entityID());
		if (entity instanceof PlayerEntity player) {
			RenderRushCapability attachment = ModCapabilities.getOrCreate(player, ModCapabilities.RENDER_RUSH_CAPABILITY);
			attachment.setRush(message.falling());
			attachment.setTimer(message.timer());
			attachment.setdamage(message.damage());
		}
	}
}


