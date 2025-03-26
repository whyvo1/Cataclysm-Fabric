package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.items.ILeftClick;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Hand;

public record MessageSwingArm(Hand hand) implements CustomPayload {
    public static final Id<MessageSwingArm> TYPE = new Id<>(Cataclysm.modIdentifier("swing_arm"));
    public static final PacketCodec<RegistryByteBuf, MessageSwingArm> STREAM_CODEC = CustomPayload.codecOf(MessageSwingArm::write, MessageSwingArm::new);

    public MessageSwingArm(PacketByteBuf buf) {
        this(buf.readBoolean() ? Hand.MAIN_HAND : Hand.OFF_HAND);
    }

    public void write(PacketByteBuf buf) {
        buf.writeBoolean(this.hand() == Hand.MAIN_HAND);
    }
    @Override
    public Id<? extends CustomPayload> getId() {
        return TYPE;
    }

    public static void handle(MessageSwingArm message, ServerPlayNetworking.Context context) {
        PlayerEntity player = context.player();
        ItemStack leftItem = player.getStackInHand(message.hand);
        if(leftItem.getItem() instanceof ILeftClick leftClick){
            leftClick.onLeftClick(leftItem, player);
        }
    }
}
