package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.capabilities.ParryCapability;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;


public class MessageParryFrame {
	private final int entityID;
	private final int frame;

	public MessageParryFrame(int id, ParryCapability cap) {
		this.entityID = id;
		this.frame = cap.getParryFrame();
	}

	public MessageParryFrame(Entity entity, ParryCapability cap) {
		this(entity.getId(), cap);
	}

	public MessageParryFrame(PacketByteBuf buf) {
		this.entityID = buf.readInt();
		this.frame = buf.readInt();
	}

	public void encode(PacketByteBuf buf) {
		buf.writeInt(this.entityID);
		buf.writeInt(this.frame);
	}

//	public static class Handler {
//
//		public static boolean onMessage(MessageParryFrame message, Supplier<NetworkEvent.Context> ctx) {
//			ctx.get().enqueueWork(() -> {
//				Entity entity = Minecraft.getInstance().level.getEntity(message.entityID);
//				if (entity instanceof LivingEntity) {
//					entity.getCapability(ModCapabilities.PARRY_CAPABILITY).ifPresent(cap -> {
//						cap.setParryFrame(message.frame);
//					});
//				}
//			});
//
//			ctx.get().setPacketHandled(true);
//			return true;
//		}
//	}
}
