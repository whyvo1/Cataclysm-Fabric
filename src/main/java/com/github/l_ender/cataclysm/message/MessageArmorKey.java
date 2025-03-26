package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.CataclysmClient;
import com.github.l_ender.cataclysm.items.KeybindUsingArmor;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.MathHelper;

public class MessageArmorKey {

    public int equipmentSlot;
//    public int playerId;
    public int type;

    public MessageArmorKey(int equipmentSlot, int type) {
        this.equipmentSlot = equipmentSlot;
//        this.playerId = playerId;
        this.type = type;
    }


    public MessageArmorKey(PacketByteBuf buf) {
        this(buf.readInt(), buf.readInt());
    }

//    public static MessageArmorKey read(PacketByteBuf buf) {
//        return new MessageArmorKey(buf.readInt(), buf.readInt(), buf.readInt());
//    }

    public static void write(MessageArmorKey message, PacketByteBuf buf) {
        buf.writeInt(message.equipmentSlot);
        buf.writeInt(message.type);
    }

    public void sendToServer() {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(equipmentSlot);
        buf.writeInt(type);
        CataclysmClient.sendToServer(Cataclysm.PACKET_ARMOR_KEY, buf);
    }

//    public static void handle(MessageArmorKey message, Supplier<NetworkEvent.Context> context) {
//        context.get().enqueueWork(() -> {
//            PlayerEntity player = context.get().getSender();
//            if(player != null){
//                EquipmentSlot equipmentSlot1 = EquipmentSlot.values()[MathHelper.clamp(message.equipmentSlot, 0, EquipmentSlot.values().length - 1)];
//
//                ItemStack stack = player.getEquippedStack(equipmentSlot1);
//                if(stack.getItem() instanceof KeybindUsingArmor armor){
//                    armor.onKeyPacket(player, stack, message.type);
//                }
//
//
//            }
//        });
//        context.get().setPacketHandled(true);
//    }

    public static void handle(MinecraftServer minecraftServer, ServerPlayerEntity serverPlayer, PacketByteBuf packet) {
        MessageArmorKey message = new MessageArmorKey(packet);
        minecraftServer.execute(() -> {
            if(serverPlayer != null){
                EquipmentSlot equipmentSlot1 = EquipmentSlot.values()[MathHelper.clamp(message.equipmentSlot, 0, EquipmentSlot.values().length - 1)];

                ItemStack stack = serverPlayer.getEquippedStack(equipmentSlot1);
                if(stack.getItem() instanceof KeybindUsingArmor armor){
                    armor.onKeyPacket(serverPlayer, stack, message.type);
                }
            }
        });
    }
}