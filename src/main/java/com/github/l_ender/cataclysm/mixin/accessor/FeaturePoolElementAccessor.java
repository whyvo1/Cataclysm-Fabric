package com.github.l_ender.cataclysm.mixin.accessor;

import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.pool.FeaturePoolElement;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

//@Mixin(FeaturePoolElement.class)
public interface FeaturePoolElementAccessor {
//    @Accessor
    RegistryEntry<PlacedFeature> getFeature();
}
