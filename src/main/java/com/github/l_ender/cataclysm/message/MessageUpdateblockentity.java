package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.blockentities.AltarOfAbyss_Block_Entity;
import com.github.l_ender.cataclysm.blockentities.AltarOfAmethyst_Block_Entity;
import com.github.l_ender.cataclysm.blockentities.AltarOfFire_Block_Entity;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;


public class MessageUpdateblockentity {

    public long blockPos;
    public ItemStack heldStack;

    public MessageUpdateblockentity(long blockPos, ItemStack heldStack) {
        this.blockPos = blockPos;
        this.heldStack = heldStack;

    }

    public MessageUpdateblockentity(PacketByteBuf buf) {
        this(buf.readLong(), buf.readItemStack());
    }

    public void sendToClient(BlockEntity tracked) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeLong(this.blockPos);
        buf.writeItemStack(this.heldStack);
        for(ServerPlayerEntity player : PlayerLookup.tracking(tracked)) {
            Cataclysm.sendToPlayer(player, Cataclysm.PACKET_UPDATE_BLOCK_ENTITY, buf);
        }
    }

//    public static void writeItemStack(ByteBuf to, ItemStack stack) {
//        PacketByteBuf pb = new PacketByteBuf(to);
//        pb.writeItemStack(stack);
//    }
//
//    /**
//     * Read an {@link ItemStack} from the byte buffer provided. It uses the minecraft encoding.
//     *
//     * @param from The buffer to read from
//     * @return The itemstack read
//     */
//    public static ItemStack readItemStack(ByteBuf from) {
//        PacketByteBuf pb = new PacketByteBuf(from);
//        try {
//            return pb.readItemStack();
//        } catch (Exception e) {
//            // Unpossible?
//            throw new RuntimeException(e);
//        }
//    }

    public static void handle(MinecraftClient client, PacketByteBuf buffer) {
        MessageUpdateblockentity message = new MessageUpdateblockentity(buffer);
        client.execute(() -> {
            PlayerEntity player = client.player;
//            if(context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT){
//                player = Cataclysm.PROXY.getClientSidePlayer();
//            }
            if (player != null) {
                if (player.getWorld() != null) {
                    BlockPos pos = BlockPos.fromLong(message.blockPos);
                    if (player.getWorld().getBlockEntity(pos) != null) {
                        if (player.getWorld().getBlockEntity(pos) instanceof AltarOfFire_Block_Entity podium) {
                            podium.setStack(0, message.heldStack);
                        }
                        if (player.getWorld().getBlockEntity(pos) instanceof AltarOfAmethyst_Block_Entity podium) {
                            podium.setItem(0, message.heldStack);
                        }
                        if (player.getWorld().getBlockEntity(pos) instanceof AltarOfAbyss_Block_Entity podium) {
                            podium.setStack(0, message.heldStack);
                        }
                    }
                }
            }
        });
    }

//    public static class Handler {
//        public Handler() {
//        }
//
//        public static void handle(MessageUpdateblockentity message, Supplier<NetworkEvent.Context> context) {
//            context.get().setPacketHandled(true);
//            PlayerEntity player = context.get().getSender();
//            if(context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT){
//                player = Cataclysm.PROXY.getClientSidePlayer();
//            }
//            if (player != null) {
//                if (player.getWorld() != null) {
//                    BlockPos pos = BlockPos.fromLong(message.blockPos);
//                    if (player.getWorld().getBlockEntity(pos) != null) {
//                        if (player.getWorld().getBlockEntity(pos) instanceof AltarOfFire_Block_Entity) {
//                            AltarOfFire_Block_Entity podium = (AltarOfFire_Block_Entity) player.getWorld().getBlockEntity(pos);
//                            podium.setStack(0, message.heldStack);
//                        }
//                        if (player.getWorld().getBlockEntity(pos) instanceof AltarOfAmethyst_Block_Entity) {
//                            AltarOfAmethyst_Block_Entity podium = (AltarOfAmethyst_Block_Entity) player.getWorld().getBlockEntity(pos);
//                            podium.setItem(0, message.heldStack);
//                        }
//                        if (player.getWorld().getBlockEntity(pos) instanceof AltarOfAbyss_Block_Entity) {
//                            AltarOfAbyss_Block_Entity podium = (AltarOfAbyss_Block_Entity) player.getWorld().getBlockEntity(pos);
//                            podium.setStack(0, message.heldStack);
//                        }
//                    }
//                }
//            }
//        }
//    }

}