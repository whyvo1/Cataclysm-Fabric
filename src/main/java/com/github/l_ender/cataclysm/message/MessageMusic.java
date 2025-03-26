package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.sound.BossMusicPlayer;
import com.github.l_ender.cataclysm.entity.etc.Animation_Monsters;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public record MessageMusic(int entityID, boolean play) implements CustomPayload {

	public static final Id<MessageMusic> TYPE = new Id<>(Cataclysm.modIdentifier("music"));
	public static final PacketCodec<RegistryByteBuf, MessageMusic> STREAM_CODEC = CustomPayload.codecOf(MessageMusic::write, MessageMusic::new);

	public MessageMusic(PacketByteBuf buf) {
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

	public static void handle(MessageMusic message, ClientPlayNetworking.Context context) {
		Entity entity = context.player().getWorld().getEntityById(message.entityID);
		if (entity instanceof Animation_Monsters am) {
			if(message.play){
				BossMusicPlayer.playBossMusic(am);
			}else{
				BossMusicPlayer.stopBossMusic(am);
			}
		}
	}
}