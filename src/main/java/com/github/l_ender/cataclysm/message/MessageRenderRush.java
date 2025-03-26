package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.capabilities.RenderRushCapability;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;


public class MessageRenderRush {
	private final int entityID;
	private final boolean hasRush;

	public MessageRenderRush(int id, RenderRushCapability cap) {
		this.entityID = id;
		this.hasRush = cap.isRush();
	}

	public MessageRenderRush(Entity entity, RenderRushCapability cap) {
		this(entity.getId(), cap);
	}

	public MessageRenderRush(PacketByteBuf buf) {
		this.entityID = buf.readInt();
		this.hasRush = buf.readBoolean();
	}

	public void encode(PacketByteBuf buf) {
		buf.writeInt(this.entityID);
		buf.writeBoolean(this.hasRush);
	}

//	public static class Handler {
//
//		public static boolean onMessage(MessageRenderRush message, Supplier<NetworkEvent.Context> ctx) {
//			ctx.get().enqueueWork(() -> {
//				Entity entity = Minecraft.getInstance().level.getEntity(message.entityID);
//				if (entity instanceof LivingEntity) {
//					entity.getCapability(ModCapabilities.RENDER_RUSH_CAPABILITY).ifPresent(cap -> {
//						cap.setRush(message.hasRush);
//					});
//				}
//			});
//
//			ctx.get().setPacketHandled(true);
//			return true;
//		}
//	}
}
