package com.github.l_ender.cataclysm.message;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.capabilities.ChargeCapability;
import com.github.l_ender.cataclysm.init.ModCapabilities;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.world.World;

public record MessageCharge(int entityID, boolean falling,int timer,int chargetime,float knockback,float damageper,float x,float z) implements CustomPayload {

    public static final Id<MessageCharge> TYPE = new Id<>(Cataclysm.modIdentifier("charge_attachment"));
    public static final PacketCodec<RegistryByteBuf, MessageCharge> STREAM_CODEC = CustomPayload.codecOf(MessageCharge::write, MessageCharge::new);

    public MessageCharge(PacketByteBuf buf) {
        this(buf.readVarInt(), buf.readBoolean(),buf.readVarInt(),buf.readVarInt(),buf.readFloat(),buf.readFloat(),buf.readFloat(),buf.readFloat());
    }

    public void write(PacketByteBuf buf) {
        buf.writeVarInt(this.entityID());
        buf.writeBoolean(this.falling());
        buf.writeVarInt(this.timer());
        buf.writeVarInt(this.chargetime());
        buf.writeFloat(this.knockback());
        buf.writeFloat(this.damageper());
        buf.writeFloat(this.x());
        buf.writeFloat(this.z());
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return TYPE;
    }

    public static void handle(MessageCharge message, ServerPlayNetworking.Context context) {
        World level = context.player().getWorld();
        Entity entity = level.getEntityById(message.entityID());
        if (entity instanceof PlayerEntity player) {
            ChargeCapability attachment = ModCapabilities.getOrCreate(player, ModCapabilities.CHARGE_CAPABILITY);
            attachment.setCharge(message.falling());
            attachment.setTimer(message.timer());
            attachment.seteffectiveChargeTime(message.chargetime());
            attachment.setknockbackSpeedIndex(message.knockback());
            attachment.setdamagePerEffectiveCharge(message.damageper());
            attachment.setdx(message.x());
            attachment.setdZ(message.z());
        }
    }
}
