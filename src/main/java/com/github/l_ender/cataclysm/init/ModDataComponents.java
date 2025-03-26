package com.github.l_ender.cataclysm.init;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.items.Components.CursedBowComponent;
import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.function.UnaryOperator;

public class ModDataComponents {
//	public static final DeferredRegister<ComponentType<?>> COMPONENTS = DeferredRegister.create(RegistryKeys.DATA_COMPONENT_TYPE,Cataclysm.MODID);

	public static final ComponentType<Boolean> LASER_GATLING =
			registerComponentType("laser_gatling", builder -> builder.codec(Codec.BOOL).packetCodec(PacketCodecs.BOOL));

	public static final ComponentType<CursedBowComponent> CURSED_BOW = registerComponentType("cursed_bow", builder -> builder.codec(CursedBowComponent.CODEC).packetCodec(CursedBowComponent.STREAM_CODEC));


	private static <T> ComponentType<T> registerComponentType(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
		return Registry.register(Registries.DATA_COMPONENT_TYPE, Cataclysm.modIdentifier(name), builderOperator.apply(ComponentType.builder()).build());
	}

	public static void log() {
		Cataclysm.LOGGER.info("Registering data component types for " + Cataclysm.MOD_ID);
	}

//	private static @NotNull <T> DeferredHolder<ComponentType<?>, ComponentType<T>> register(String name, final Codec<T> codec) {
//		return register2(name, codec, null);
//	}
//
//	private static @NotNull <T> DeferredHolder<ComponentType<?>, ComponentType<T>> register2(String name, final Codec<T> codec, @Nullable final PacketCodec<? super RegistryByteBuf, T> streamCodec) {
//		if (streamCodec == null) {
//			return COMPONENTS.register(name, () -> DataComponentType.<T>builder().persistent(codec).build());
//		} else {
//			return COMPONENTS.register(name, () -> DataComponentType.<T>builder().persistent(codec).networkSynchronized(streamCodec).build());
//		}
//	}
}
