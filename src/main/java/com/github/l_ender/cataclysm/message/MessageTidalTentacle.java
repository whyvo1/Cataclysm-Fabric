package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.capabilities.TidalTentacleCapability;
import com.github.l_ender.cataclysm.init.ModCapabilities;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.world.World;


public record MessageTidalTentacle(int entityID, boolean tentacle) implements CustomPayload {

	public static final Id<MessageTidalTentacle> TYPE = new Id<>(Cataclysm.modIdentifier("tentacle_attachment"));
	public static final PacketCodec<RegistryByteBuf, MessageTidalTentacle> STREAM_CODEC = CustomPayload.codecOf(MessageTidalTentacle::write, MessageTidalTentacle::new);

	public MessageTidalTentacle(PacketByteBuf buf) {
		this(buf.readVarInt(), buf.readBoolean());
	}

	public void write(PacketByteBuf buf) {
		buf.writeVarInt(this.entityID());
		buf.writeBoolean(this.tentacle());

	}

	@Override
	public Id<? extends CustomPayload> getId() {
		return TYPE;
	}

	public static void handle(MessageTidalTentacle message, ClientPlayNetworking.Context ctx) {
		World level = ctx.player().getWorld();
		Entity entity = level.getEntityById(message.entityID());
		if (entity instanceof PlayerEntity player) {
			TidalTentacleCapability attachment = ModCapabilities.getOrCreate(player, ModCapabilities.TIDAL_TENTACLE_CAPABILITY);
			attachment.setHasTentacle(message.tentacle());
			attachment.setLastTentacleID(message.entityID());
		}
	}
}
