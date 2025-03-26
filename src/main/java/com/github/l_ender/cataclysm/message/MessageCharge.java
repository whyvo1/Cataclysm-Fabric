package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.capabilities.ChargeCapability;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;

public class MessageCharge {
	private final int entityID;
	private final boolean hasCharge;

	public MessageCharge(int id, ChargeCapability cap) {
		this.entityID = id;
		this.hasCharge = cap.isCharge();
	}

	public MessageCharge(Entity entity, ChargeCapability cap) {
		this(entity.getId(), cap);
	}

	public MessageCharge(PacketByteBuf buf) {
		this.entityID = buf.readInt();
		this.hasCharge = buf.readBoolean();
	}

	public void encode(PacketByteBuf buf) {
		buf.writeInt(this.entityID);
		buf.writeBoolean(this.hasCharge);
	}

	public static class Handler {

//		public static boolean onMessage(MessageCharge message, Supplier<NetworkEvent.Context> ctx) {
//			ctx.get().enqueueWork(() -> {
//				Entity entity = Minecraft.getInstance().level.getEntity(message.entityID);
//				if (entity instanceof LivingEntity) {
//					entity.getCapability(ModCapabilities.CHARGE_CAPABILITY).ifPresent(cap -> {
//						cap.setCharge(message.hasCharge);
//					});
//				}
//			});
//
//			ctx.get().setPacketHandled(true);
//			return true;
//		}
	}
}
