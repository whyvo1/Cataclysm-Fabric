package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.sound.MeatShredderSound;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public record MessageMeatShredder(int entityID, boolean play) implements CustomPayload {

	public static final Id<MessageMeatShredder> TYPE = new Id<>(Cataclysm.modIdentifier("meatshredder_sound"));
	public static final PacketCodec<RegistryByteBuf, MessageMeatShredder> STREAM_CODEC = CustomPayload.codecOf(MessageMeatShredder::write, MessageMeatShredder::new);

	public MessageMeatShredder(PacketByteBuf buf) {
		this(buf.readVarInt(), buf.readBoolean());
	}

	public void write(PacketByteBuf buf) {
		buf.writeVarInt(this.entityID());
		buf.writeBoolean(this.play());
	}

	@Override
	public Id<? extends CustomPayload> getId() {
		return TYPE;
	}

	public static void handle(MessageMeatShredder message, ClientPlayNetworking.Context context) {
		Entity entity = context.player().getWorld().getEntityById(message.entityID());
		if (entity instanceof LivingEntity living) {
			MinecraftClient.getInstance().getSoundManager().playNextTick(new MeatShredderSound(living));
		}
	}
}