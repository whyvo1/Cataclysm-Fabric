package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.sound.SandstormSound;
import com.github.l_ender.cataclysm.entity.effect.Sandstorm_Entity;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public record MessageSandstormSound(int entityID, boolean play) implements CustomPayload {

	public static final Id<MessageSandstormSound> TYPE = new Id<>(Cataclysm.modIdentifier("sandstorm_sound"));
	public static final PacketCodec<RegistryByteBuf, MessageSandstormSound> STREAM_CODEC = CustomPayload.codecOf(MessageSandstormSound::write, MessageSandstormSound::new);

	public MessageSandstormSound(PacketByteBuf buf) {
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

	public static void handle(MessageSandstormSound message, ClientPlayNetworking.Context ctx) {
		Entity entity = ctx.player().getWorld().getEntityById(message.entityID());
		if (entity instanceof Sandstorm_Entity living) {
			MinecraftClient.getInstance().getSoundManager().playNextTick(new SandstormSound(living));
		}
	}
}