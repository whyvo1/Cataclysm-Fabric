package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.capabilities.HookCapability;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;


public class MessageHookFalling {
	private final int entityID;
	private final boolean hashook;

	public MessageHookFalling(int id, HookCapability cap) {
		this.entityID = id;
		this.hashook = cap.hasHook();
	}

	public MessageHookFalling(Entity entity, HookCapability cap) {
		this(entity.getId(), cap);
	}

	public MessageHookFalling(PacketByteBuf buf) {
		this.entityID = buf.readInt();
		this.hashook = buf.readBoolean();
	}

	public void encode(PacketByteBuf buf) {
		buf.writeInt(this.entityID);
		buf.writeBoolean(this.hashook);
	}

//	public static boolean handle(MessageHookFalling message, Supplier<NetworkEvent.Context> ctx) {
//		ctx.get().enqueueWork(() -> {
//			Entity entity = Minecraft.getInstance().level.getEntity(message.entityID);
//			if (entity instanceof LivingEntity) {
//				entity.getCapability(ModCapabilities.HOOK_CAPABILITY).ifPresent(cap -> {
//					cap.setHasHook(message.hashook);
//				});
//			}
//		});
//
//		ctx.get().setPacketHandled(true);
//		return true;
//	}

}
