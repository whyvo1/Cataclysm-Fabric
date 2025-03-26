package com.github.l_ender.cataclysm.capabilities;

import net.minecraft.nbt.NbtCompound;

public abstract class Capability<T> {
    private boolean discarded = false;

    private final CapabilityType<? extends Capability<T>, T> type;

    public Capability(CapabilityType<? extends Capability<T>, T> type) {
        this.type = type;
    }

    public abstract NbtCompound serializeNBT();

    public abstract void deserializeNBT(NbtCompound nbt);

    public abstract String getName();

    public CapabilityType<? extends Capability<T>, T> getType() {
        return type;
    }

    public int getId() {
        return this.type.getId();
    }

    public void tick() {
    }

    public final void discard() {
        this.discarded = true;
    }

    public boolean isDiscarded() {
        return this.discarded;
    }
}
