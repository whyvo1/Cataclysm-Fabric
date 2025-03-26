package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.entity.partentity.Cm_Part_Entity;
import com.github.l_ender.cataclysm.entity.partentity.Partable;
import io.netty.buffer.Unpooled;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class MessageCMMultipart {

    private int id;
    private Entity entity;
    private int len;
    private List<PartDataHolder> data = new ArrayList<>();

    public MessageCMMultipart(PacketByteBuf buf) {
        this.id = buf.readVarInt();
        this.len = buf.readVarInt();
        for (int i = 0; i < len; i++) {
            if (buf.readBoolean()) {
                data.add(PartDataHolder.decode(buf));
            }
        }
    }

    public MessageCMMultipart(Entity entity) {
        this.entity = entity;
    }

    public void sendToClient(ServerPlayerEntity player) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(this.entity.getId());
        if(this.entity instanceof Partable partable) {
            Cm_Part_Entity<?>[] parts = partable.getParts();
            // We assume the client and server part arrays are identical, else everything will crash and burn. Don't even bother handling it.
            if (parts != null) {
                buf.writeInt(parts.length);
                for (Cm_Part_Entity<?> part : parts) {
                    buf.writeBoolean(true);
                    part.writeData().encode(buf);
                }
            } else {
                buf.writeVarInt(0);
            }
        } else {
            buf.writeVarInt(0);
        }
        Cataclysm.sendToPlayer(player, Cataclysm.PACKET_CM_MULTIPART, buf);
    }

    public static void handle(MinecraftClient client, PacketByteBuf buffer) {
        MessageCMMultipart message = new MessageCMMultipart(buffer);
        client.execute(() -> {
            World world = client.world;
            if (world == null)
                return;
            Entity ent = world.getEntityById(message.id);
            if (ent instanceof Partable partable) {
                Cm_Part_Entity<?>[] parts = partable.getParts();
                if (parts == null)
                    return;
                int index = 0;
                for (Cm_Part_Entity<?> part : parts) {
                    part.readData(message.data.get(index));
                    index++;
                }
            }
        });
    }

//    public static class Handler {
//
//        @SuppressWarnings("Convert2Lambda")
//        public static boolean onMessage(MessageCMMultipart message, Supplier<NetworkEvent.Context> ctx) {
//            ctx.get().enqueueWork(new Runnable() {
//                @Override
//                public void run() {
//                    World world = MinecraftClient.getInstance().world;
//                    if (world == null)
//                        return;
//                    Entity ent = world.getEntityById(message.id);
//                    if (ent != null && ent.isMultipartEntity()) {
//                        PartEntity<?>[] parts = ent.getParts();
//                        if (parts == null)
//                            return;
//                        int index = 0;
//                        for (PartEntity<?> part : parts) {
//                            if (part instanceof Cm_Part_Entity<?> tfPart) {
//                                tfPart.readData(message.data.get(index));
//                                index++;
//                            }
//                        }
//                    }
//                }
//            });
//            ctx.get().setPacketHandled(true);
//            return true;
//        }
//    }

    public record PartDataHolder(double x,
                                 double y,
                                 double z,
                                 float yRot,
                                 float xRot,
                                 float width,
                                 float height,
                                 boolean fixed,
                                 boolean dirty,
                                 List<DataTracker.SerializedEntry<?>> data) {


        public void encode(PacketByteBuf buffer) {
            buffer.writeDouble(x);
            buffer.writeDouble(y);
            buffer.writeDouble(z);
            buffer.writeFloat(yRot);
            buffer.writeFloat(xRot);
            buffer.writeFloat(width);
            buffer.writeFloat(height);
            buffer.writeBoolean(fixed);
            buffer.writeBoolean(dirty);
            if (this.dirty) {
                for(DataTracker.SerializedEntry<?> datavalue : this.data) {
                    datavalue.write(buffer);
                }

                buffer.writeByte(255);
            }
        }

        static PartDataHolder decode(PacketByteBuf buffer) {
            boolean dirty;
            return new PartDataHolder(
                    buffer.readDouble(),
                    buffer.readDouble(),
                    buffer.readDouble(),
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readBoolean(),
                    dirty = buffer.readBoolean(),
                    dirty ? unpack(buffer) : null
            );
        }


        private static List<DataTracker.SerializedEntry<?>> unpack(PacketByteBuf buf) {
            List<DataTracker.SerializedEntry<?>> list = new ArrayList<>();

            int i;
            while((i = buf.readUnsignedByte()) != 255) {
                list.add(DataTracker.SerializedEntry.fromBuf(buf, i));
            }

            return list;
        }

    }
}

