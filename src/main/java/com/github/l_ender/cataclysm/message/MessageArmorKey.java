package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.items.KeybindUsingArmor;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.math.MathHelper;

public record MessageArmorKey(int equipmentSlot, int playerId, int typ) implements CustomPayload {

    public static final Id<MessageArmorKey> TYPE = new Id<>(Cataclysm.modIdentifier("armor_key"));
    public static final PacketCodec<RegistryByteBuf, MessageArmorKey> STREAM_CODEC = CustomPayload.codecOf(MessageArmorKey::write, MessageArmorKey::new);

    public MessageArmorKey(PacketByteBuf buf) {
        this(buf.readVarInt(), buf.readVarInt(), buf.readVarInt());
    }

    public void write(PacketByteBuf buf) {
        buf.writeVarInt(this.equipmentSlot());
        buf.writeVarInt(this.playerId());
        buf.writeVarInt(this.typ());
    }

    @Override
    public Id<MessageArmorKey> getId() {
        return TYPE;
    }

    public static void handle(MessageArmorKey message, ServerPlayNetworking.Context context) {
        PlayerEntity player = context.player();
        EquipmentSlot equipmentSlot1 = EquipmentSlot.values()[MathHelper.clamp(message.equipmentSlot, 0, EquipmentSlot.values().length - 1)];

        ItemStack stack = player.getEquippedStack(equipmentSlot1);
        if (stack.getItem() instanceof KeybindUsingArmor armor) {
            armor.onKeyPacket(player, stack, message.typ);
        }

    }
}