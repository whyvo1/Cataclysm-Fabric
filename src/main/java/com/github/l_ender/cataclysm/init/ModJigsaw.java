package com.github.l_ender.cataclysm.init;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.structures.jisaw.element.CataclysmJigsawSinglePoolElement;
import com.mojang.serialization.Codec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePoolElementType;

public class ModJigsaw {
    public static StructurePoolElementType<CataclysmJigsawSinglePoolElement> CATACLYSM_ELEMENT = register("cataclysm_element", CataclysmJigsawSinglePoolElement.CODEC);

    private static <P extends StructurePoolElement> StructurePoolElementType<P> register(String name, Codec<P> codec) {
        return Registry.register(Registries.STRUCTURE_POOL_ELEMENT, Cataclysm.modIdentifier(name), () -> codec);
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering structure pool elements for " + Cataclysm.MOD_ID);
    }
}
