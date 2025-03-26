package com.github.l_ender.cataclysm.capabilities;


import java.util.ArrayList;
import java.util.List;

public class CapabilityType<T extends Capability<C>, C> {
    private static int registered = 0;
    private static List<CapabilityType<?, ?>> types = new ArrayList<>();

    private final int id;
    private final CapabilityFactory<T, C> factory;

    private CapabilityType(int id, CapabilityFactory<T, C> factory) {
        this.id = id;
        this.factory = factory;
    }

    public T create(C c) {
        return this.factory.create(this, c);
    }

    public int getId() {
        return this.id;
    }

    public static <T extends Capability<C>, C> CapabilityType<T, C> register(CapabilityFactory<T, C> factory) {
        CapabilityType<T, C> type = new CapabilityType<>(registered, factory);
        types.add(type);
        registered++;
        return type;
    }

    public static CapabilityType<?, ?> getById(int id) {
        return types.get(id);
    }

    @FunctionalInterface
    public interface CapabilityFactory<M extends Capability<N>, N> {
        M create(CapabilityType<M, N> type, N n);
    }
}
