package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.capabilities.TidalTentacleCapability;
import net.minecraft.network.PacketByteBuf;


public class MessageTidalTentacle {
	private final int entityID;
	private final boolean hasTentacle;

	public MessageTidalTentacle(int id, TidalTentacleCapability cap) {
		this.entityID = id;
		this.hasTentacle = cap.hasTentacle();
	}


	public MessageTidalTentacle(PacketByteBuf buf) {
		this.entityID = buf.readInt();
		this.hasTentacle = buf.readBoolean();
	}

	public void encode(PacketByteBuf buf) {
		buf.writeInt(this.entityID);
		buf.writeBoolean(this.hasTentacle);
	}

//	public static class Handler {
//
//		public static boolean onMessage(MessageTidalTentacle message, Supplier<NetworkEvent.Context> ctx) {
//			ctx.get().enqueueWork(() -> {
//				Entity entity = Minecraft.getInstance().level.getEntity(message.entityID);
//				if (entity instanceof LivingEntity) {
//					entity.getCapability(ModCapabilities.TENTACLE_CAPABILITY).ifPresent(cap -> {
//						cap.setHasTentacle(message.hasTentacle);
//					});
//				}
//			});
//
//			ctx.get().setPacketHandled(true);
//			return true;
//		}
//	}
}
