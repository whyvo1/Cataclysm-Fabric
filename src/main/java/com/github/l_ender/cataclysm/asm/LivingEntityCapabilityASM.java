package com.github.l_ender.cataclysm.asm;

import com.github.l_ender.cataclysm.capabilities.Capability;
import com.github.l_ender.cataclysm.capabilities.CapabilityType;

public interface LivingEntityCapabilityASM {
    default <T extends Capability<?>> T cataclysm$getCapability(CapabilityType<T, ?> type) {
        return null;
    }

    default <T> void cataclysm$addCapability(Capability<T> capability) {}
}
