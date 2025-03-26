package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


import java.util.ArrayList;
import java.util.List;

public class MessageParticle implements CustomPayload {

	public static final Id<MessageParticle> TYPE = new Id<>(Cataclysm.modIdentifier("particle_queue"));
	public static final PacketCodec<RegistryByteBuf, MessageParticle> STREAM_CODEC = CustomPayload.codecOf(MessageParticle::write, MessageParticle::new);

	private final List<QueuedParticle> queuedParticles = new ArrayList<>();

	public MessageParticle() {
	}

	public MessageParticle(RegistryByteBuf buf) {
		int size = buf.readVarInt();
		for (int i = 0; i < size; i++) {
			ParticleType<?> type = Registries.PARTICLE_TYPE.get(buf.readVarInt());
			if (type == null)
				break; // Fail silently and end execution entirely. Due to Type serialization we now have completely unknown data in the pipeline without any way to safely read it all
			this.queuedParticles.add(new QueuedParticle(ParticleTypes.PACKET_CODEC.decode(buf), buf.readBoolean(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble()));
		}
	}

	public void write(RegistryByteBuf buf) {
		buf.writeVarInt(this.queuedParticles.size());
		for (QueuedParticle queuedParticle : this.queuedParticles) {
			int d = Registries.PARTICLE_TYPE.getRawId(queuedParticle.particleOptions.getType());
			buf.writeVarInt(d);
			ParticleTypes.PACKET_CODEC.encode(buf, queuedParticle.particleOptions);
			buf.writeBoolean(queuedParticle.b);
			buf.writeDouble(queuedParticle.x);
			buf.writeDouble(queuedParticle.y);
			buf.writeDouble(queuedParticle.z);
			buf.writeDouble(queuedParticle.x2);
			buf.writeDouble(queuedParticle.y2);
			buf.writeDouble(queuedParticle.z2);
		}
	}

	@Override
	public Id<? extends CustomPayload> getId() {
		return TYPE;
	}

	public void queueParticle(ParticleEffect particleOptions, boolean b, double x, double y, double z, double x2, double y2, double z2) {
		this.queuedParticles.add(new QueuedParticle(particleOptions, b, x, y, z, x2, y2, z2));
	}

	public void queueParticle(ParticleEffect particleOptions, boolean b, Vec3d xyz, Vec3d xyz2) {
		this.queuedParticles.add(new QueuedParticle(particleOptions, b, xyz.x, xyz.y, xyz.z, xyz2.x, xyz2.y, xyz2.z));
	}

	private record QueuedParticle(ParticleEffect particleOptions, boolean b, double x, double y, double z, double x2,
								  double y2, double z2) {
	}

	public static void handle(MessageParticle message, ClientPlayNetworking.Context context) {
		World world = context.player().getWorld();
		for (QueuedParticle queuedParticle : message.queuedParticles) {
			world.addParticle(queuedParticle.particleOptions, queuedParticle.b, queuedParticle.x, queuedParticle.y, queuedParticle.z, queuedParticle.x2, queuedParticle.y2, queuedParticle.z2);
		}
	}
}

