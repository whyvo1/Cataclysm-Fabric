package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.CataclysmClient;
import com.github.l_ender.cataclysm.items.ILeftClick;
import io.netty.buffer.Unpooled;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;

public class MessageSwingArm {

    public static final MessageSwingArm INSTANCE = new MessageSwingArm();

    private MessageSwingArm() {
    }


    public static MessageSwingArm read(PacketByteBuf buf) {
        return INSTANCE;
    }

    public void sendToServer() {
        CataclysmClient.sendToServer(Cataclysm.PACKET_SWING_ARM, new PacketByteBuf(Unpooled.buffer()));
    }

    public static void handle(MinecraftServer minecraftServer, ServerPlayerEntity serverPlayer, PacketByteBuf packet) {
        minecraftServer.execute(() -> {
            if (serverPlayer != null) {
                ItemStack leftItem = serverPlayer.getStackInHand(Hand.OFF_HAND);
                ItemStack rightItem = serverPlayer.getStackInHand(Hand.MAIN_HAND);
                if(leftItem.getItem() instanceof ILeftClick){
                    ((ILeftClick)leftItem.getItem()).onLeftClick(leftItem, serverPlayer);
                }
                if(rightItem.getItem() instanceof ILeftClick){
                    ((ILeftClick)rightItem.getItem()).onLeftClick(rightItem, serverPlayer);
                }
            }
        });
    }

//    public static class Handler {
//
//        public Handler() {
//        }
//
//        public static void handle(MessageSwingArm message, Supplier<NetworkEvent.Context> context) {
//            context.get().setPacketHandled(true);
//            context.get().enqueueWork(() -> {
//                Player player = context.get().getSender();
//                if (player != null) {
//                    ItemStack leftItem = player.getItemInHand(InteractionHand.OFF_HAND);
//                    ItemStack rightItem = player.getItemInHand(InteractionHand.MAIN_HAND);
//                    if(leftItem.getItem() instanceof ILeftClick){
//                        ((ILeftClick)leftItem.getItem()).onLeftClick(leftItem, player);
//                    }
//                    if(rightItem.getItem() instanceof ILeftClick){
//                        ((ILeftClick)rightItem.getItem()).onLeftClick(rightItem, player);
//                    }
//                }
//            });
//        }
//    }

}
