package com.github.l_ender.cataclysm.items.Components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;

public record CursedBowComponent(int UseTime, int PrevUseTime) {
	public static final CursedBowComponent EMPTY = new CursedBowComponent(0, 0);


	public static final Codec<CursedBowComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(
		Codec.INT.optionalFieldOf("UseTime", 0).forGetter(CursedBowComponent::UseTime),
		Codec.INT.optionalFieldOf("PrevUseTime", 0).forGetter(CursedBowComponent::PrevUseTime)
	).apply(instance, CursedBowComponent::new));

	public static final PacketCodec<RegistryByteBuf, CursedBowComponent> STREAM_CODEC = PacketCodec.tuple(
		PacketCodecs.INTEGER, CursedBowComponent::UseTime,
		PacketCodecs.INTEGER, CursedBowComponent::PrevUseTime,
			CursedBowComponent::new);

	public CursedBowComponent tryAddDose(int use,int prevUseTime) {
		return new CursedBowComponent(use, prevUseTime);
	}

}
