package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.entity.partentity.Cm_Part_Entity;
import com.github.l_ender.cataclysm.entity.partentity.Partable;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

import org.jetbrains.annotations.Nullable;
import java.util.*;
import java.util.stream.Collectors;

public record MessageCMMultipart(int entityId, @Nullable Entity entity, @Nullable Map<Integer, PartDataHolder> data) implements CustomPayload {

    public static final Id<MessageCMMultipart> TYPE = new Id<>(Cataclysm.modIdentifier("update_multipart_entity"));
    public static final PacketCodec<RegistryByteBuf, MessageCMMultipart> STREAM_CODEC = CustomPayload.codecOf(MessageCMMultipart::write, MessageCMMultipart::new);

    public MessageCMMultipart(RegistryByteBuf buf) {
        this(buf.readVarInt(), null, new HashMap<>());
        int id;
        while ((id = buf.readVarInt()) > 0) {
            this.data.put(id, PartDataHolder.decode(buf));
        }
    }

    public MessageCMMultipart(Entity entity) {
        this(-1, entity, Arrays.stream(((Partable) entity).getParts()).collect(Collectors.toMap(Cm_Part_Entity::getId, Cm_Part_Entity::writeData)));
    }

    public void write(RegistryByteBuf buf) {
        if (this.entity == null)
            throw new IllegalStateException("Null Entity while encoding UpdateTFMultipartPacket");
        if (this.data == null)
            throw new IllegalStateException("Null Data while encoding UpdateTFMultipartPacket");
        buf.writeVarInt(this.entity.getId());
        this.data.forEach((id, data) -> {
            buf.writeVarInt(id);
            data.encode(buf);
        });
        buf.writeVarInt(-1);
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return TYPE;
    }

    public static void handle(MessageCMMultipart message, ServerPlayNetworking.Context context) {
        int eId = message.entity != null && message.entityId <= 0 ? message.entity.getId() : message.entityId; // Account for Singleplayer
        Entity ent = context.player().getWorld().getEntityById(eId);
        if (ent instanceof Partable partable) {
            Cm_Part_Entity<?>[] parts = partable.getParts();
            if (parts == null)
                return;
            Cm_Part_Entity<?>[] parts2 = parts.clone();
            for (Cm_Part_Entity<?> part : parts) {
                if (part instanceof Cm_Part_Entity<?> tfPart) {
                    if (message.data == null && message.entity != null) // Account for Singleplayer
                        Arrays.stream(parts2)
                                .filter(p -> p instanceof Cm_Part_Entity<?> && p.getId() == part.getId())
                                .map(p -> (Cm_Part_Entity<?>) p)
                                .findFirst().ifPresent(p -> tfPart.readData(p.writeData()));
                    else if (message.data != null) {
                        PartDataHolder data = message.data.get(tfPart.getId());
                        if (data != null)
                            tfPart.readData(data);
                    }
                }
            }
        }
    }

    public record PartDataHolder(double x, double y, double z,
                                 float yRot, float xRot,
                                 float width, float height,
                                 boolean fixed,
                                 @Nullable List<DataTracker.SerializedEntry<?>> data) {


        public void encode(RegistryByteBuf buffer) {
            buffer.writeDouble(this.x());
            buffer.writeDouble(this.y());
            buffer.writeDouble(this.z());
            buffer.writeFloat(this.yRot());
            buffer.writeFloat(this.xRot());
            buffer.writeFloat(this.width());
            buffer.writeFloat(this.height());
            buffer.writeBoolean(this.fixed());
            if (this.data() != null) {
                for (DataTracker.SerializedEntry<?> datavalue : this.data()) {
                    datavalue.write(buffer);
                }
            }
            buffer.writeByte(255);
        }

        static PartDataHolder decode(RegistryByteBuf buffer) {
            return new PartDataHolder(buffer.readDouble(), buffer.readDouble(), buffer.readDouble(),
                    buffer.readFloat(), buffer.readFloat(),
                    buffer.readFloat(), buffer.readFloat(),
                    buffer.readBoolean(),
                    unpack(buffer)
            );
        }

        private static List<DataTracker.SerializedEntry<?>> unpack(RegistryByteBuf buf) {
            List<DataTracker.SerializedEntry<?>> list = new ArrayList<>();

            int i;
            while ((i = buf.readUnsignedByte()) != 255) {
                list.add(DataTracker.SerializedEntry.fromBuf(buf, i));
            }

            return list;
        }

    }
}

