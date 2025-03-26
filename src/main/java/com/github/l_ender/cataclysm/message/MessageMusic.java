package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.sound.BossMusicPlayer;
import com.github.l_ender.cataclysm.entity.etc.Animation_Monsters;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;


public class MessageMusic {
	private final int entityID;
	private final boolean play;

	public MessageMusic(int entityID, boolean play) {
		this.entityID = entityID;
		this.play = play;
	}

	public MessageMusic(PacketByteBuf buf) {
		this(buf.readVarInt(), buf.readBoolean());
	}


//	public static MessageMusic read(PacketByteBuf buf) {
//		return new MessageMusic(buf.readInt(), buf.readBoolean());
//	}

//	public static void write(MessageMusic message, PacketByteBuf buf) {
//		buf.writeVarInt(message.entityID);
//		buf.writeBoolean(message.play);
//	}

	public void sendToClient(Entity tracked) {
		PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
		buf.writeVarInt(entityID);
		buf.writeBoolean(play);
		for(ServerPlayerEntity player : PlayerLookup.tracking(tracked)) {
			Cataclysm.sendToPlayer(player, Cataclysm.PACKET_MUSIC, buf);
		}
	}


	public static void handle(MinecraftClient client, PacketByteBuf buffer) {
		MessageMusic message = new MessageMusic(buffer);
		client.execute(() -> {
			if(client.world == null) {
				return;
			}
			Entity entity = client.world.getEntityById(message.entityID);
			if (entity instanceof Animation_Monsters am) {
				if(message.play){
					BossMusicPlayer.playBossMusic(am);
				}else{
					BossMusicPlayer.stopBossMusic(am);
				}
			}
		});
	}


//	public static class Handler {
//		public Handler() {
//		}
//		public static boolean onMessage(MessageMusic message, Supplier<NetworkEvent.Context> ctx) {
//			ctx.get().enqueueWork(() -> {
//				Entity entity = Minecraft.getInstance().level.getEntity(message.entityID);
//				if (entity instanceof Animation_Monsters am) {
//					if(message.play){
//						BossMusicPlayer.playBossMusic(am);
//					}else{
//						BossMusicPlayer.stopBossMusic(am);
//					}
//				}
//			});
//			ctx.get().setPacketHandled(true);
//			return true;
//		}
//	}
}
