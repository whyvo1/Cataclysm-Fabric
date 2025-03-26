package com.github.l_ender.cataclysm.init;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.world.structures.placements.CataclysmRandomSpread;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.chunk.placement.StructurePlacement;
import net.minecraft.world.gen.chunk.placement.StructurePlacementType;


public final class ModStructurePlacementType {
//    public static final DeferredRegister<StructurePlacementType<?>> STRUCTURE_PLACEMENT_TYPE = DeferredRegister.create(RegistryKeys.STRUCTURE_PLACEMENT, Cataclysm.MODID);

    public static final StructurePlacementType<CataclysmRandomSpread> CATACLYSM_RANDOM_SPREAD = registerStructurePlacement("cataclysm_random_spread", () -> CataclysmRandomSpread.CODEC);

    private static <T extends StructurePlacement> StructurePlacementType<T> registerStructurePlacement(String name, StructurePlacementType<T> structurePlacement) {
        return Registry.register(Registries.STRUCTURE_PLACEMENT, Cataclysm.modIdentifier(name), structurePlacement);
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering structure placement for " + com.github.l_ender.cataclysm.Cataclysm.MOD_ID);
    }
}
