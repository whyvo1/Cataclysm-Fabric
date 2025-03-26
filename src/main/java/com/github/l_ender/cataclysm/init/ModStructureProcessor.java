package com.github.l_ender.cataclysm.init;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.world.structures.Processor.WaterLoggingFixProcessor;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorType;

public final class ModStructureProcessor {

//    public static final DeferredRegister<StructureProcessorType<?>> STRUCTURE_PROCESSOR = DeferredRegister.create(RegistryKeys.STRUCTURE_PROCESSOR, Cataclysm.MODID);

    public static final StructureProcessorType<WaterLoggingFixProcessor> WATER_LOGGING_FIX_PROCESSOR = registerStructureProcessorType("water_logging_fix_processor", () -> WaterLoggingFixProcessor.CODEC);

    private static <T extends StructureProcessor> StructureProcessorType<T> registerStructureProcessorType(String name, StructureProcessorType<T> structureProcessorType) {
        return Registry.register(Registries.STRUCTURE_PROCESSOR, Cataclysm.modIdentifier(name), structureProcessorType);
    }

    public static void log() {
        Cataclysm.LOGGER.info("Registering structure processors for " + Cataclysm.MOD_ID);
    }
}
