package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import io.netty.buffer.Unpooled;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;
import java.util.List;

public class MessageParticle {
	private final List<QueuedParticle> queuedParticles = new ArrayList<>();

	public MessageParticle() {
	}

	public MessageParticle(PacketByteBuf buf) {
		int size = buf.readInt();
		for (int i = 0; i < size; i++) {
			ParticleType<?> type = Registries.PARTICLE_TYPE.get(buf.readVarInt());
			if (type == null) {
				break; // Fail silently and end execution entirely. Due to Type serialization we now have completely unknown data in the pipeline without any way to safely read it all
			}
			this.queuedParticles.add(new QueuedParticle(readParticle(type, buf), buf.readBoolean(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble()));
		}
	}

	private <T extends ParticleEffect> T readParticle(ParticleType<T> particleType, PacketByteBuf buf) {
		return particleType.getParametersFactory().read(particleType, buf);
	}

	public void sendToClient(ServerPlayerEntity player) {
		PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
		buf.writeInt(this.queuedParticles.size());
		for (QueuedParticle queuedParticle : this.queuedParticles) {
			int d = Registries.PARTICLE_TYPE.getRawId(queuedParticle.particleOptions.getType());
			buf.writeVarInt(d);
			queuedParticle.particleOptions.write(buf);
			buf.writeBoolean(queuedParticle.b);
			buf.writeDouble(queuedParticle.x);
			buf.writeDouble(queuedParticle.y);
			buf.writeDouble(queuedParticle.z);
			buf.writeDouble(queuedParticle.x2);
			buf.writeDouble(queuedParticle.y2);
			buf.writeDouble(queuedParticle.z2);
		}
		Cataclysm.sendToPlayer(player, Cataclysm.PACKET_PARTICLE, buf);
	}

	public void queueParticle(ParticleEffect particleOptions, boolean b, double x, double y, double z, double x2, double y2, double z2) {
		this.queuedParticles.add(new QueuedParticle(particleOptions, b, x, y, z, x2, y2, z2));
	}

	public void queueParticle(ParticleEffect particleOptions, boolean b, Vec3d xyz, Vec3d xyz2) {
		this.queuedParticles.add(new QueuedParticle(particleOptions, b, xyz.x, xyz.y, xyz.z, xyz2.x, xyz2.y, xyz2.z));
	}

	private record QueuedParticle(ParticleEffect particleOptions, boolean b, double x, double y, double z, double x2, double y2, double z2) {

        public ParticleEffect particleOptions() {
			return this.particleOptions;
		}

		public boolean b() {
			return this.b;
		}

		public double x() {
			return this.x;
		}

		public double y() {
			return this.y;
		}

		public double z() {
			return this.z;
		}

		public double x2() {
			return this.x2;
		}

		public double y2() {
			return this.y2;
		}

		public double z2() {
			return this.z2;
		}
	}

	public static void handle(MinecraftClient client, PacketByteBuf buffer) {
		MessageParticle message = new MessageParticle(buffer);
		client.execute(() -> {
			ClientWorld level = client.world;
			if (level != null) {

				for (QueuedParticle queuedParticle : message.queuedParticles) {
					level.addParticle(queuedParticle.particleOptions, queuedParticle.b, queuedParticle.x, queuedParticle.y, queuedParticle.z, queuedParticle.x2, queuedParticle.y2, queuedParticle.z2);
				}
			}
		});
	}

//	public static class Handler {
//		public Handler() {
//		}
//		public static boolean onMessage(MessageParticle message, Supplier<NetworkEvent.Context> ctx) {
//			ctx.get().enqueueWork(() -> {
//				ClientLevel level = Minecraft.getInstance().level;
//				if (level != null) {
//
//					for (QueuedParticle queuedParticle : message.queuedParticles) {
//						level.addParticle(queuedParticle.particleOptions, queuedParticle.b, queuedParticle.x, queuedParticle.y, queuedParticle.z, queuedParticle.x2, queuedParticle.y2, queuedParticle.z2);
//					}
//				}
//			});
//			ctx.get().setPacketHandled(true);
//			return true;
//		}
//	}
}
