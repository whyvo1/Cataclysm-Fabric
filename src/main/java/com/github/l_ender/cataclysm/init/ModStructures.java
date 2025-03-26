package com.github.l_ender.cataclysm.init;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.structures.*;
import com.github.l_ender.cataclysm.structures.jisaw.CataclysmJigsawStructure;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;

public class ModStructures {

//    public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE_DEF_REG = DeferredRegister.create(RegistryKeys.STRUCTURE_PIECE, Cataclysm.MODID);
//    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPE_DEF_REG = DeferredRegister.create(RegistryKeys.STRUCTURE_TYPE, Cataclysm.MODID);

    public static final StructureType<RuinedCitadelStructure> RUINED_CITADEL = registerStructureType("ruined_citadel", () ->
            RuinedCitadelStructure.CODEC);
    public static final StructureType<Burning_Arena_Structure> BURNING_ARENA = registerStructureType("burning_arena", () ->
            Burning_Arena_Structure.CODEC);

    public static final StructureType<Sunken_City_Structure> SUNKEN_CITY = registerStructureType("sunken_city", () ->
            Sunken_City_Structure.CODEC);

    public static final StructureType<Cursed_Pyramid_Structure> CURSED_PYRAMID = registerStructureType("cursed_pyramid", () ->
            Cursed_Pyramid_Structure.CODEC);


    public static final StructureType<CataclysmJigsawStructure> CATACLYSM_JIGSAW = registerStructureType("cataclysm_jigsaw", () ->
            CataclysmJigsawStructure.CODEC);

    private static <T extends Structure> StructureType<T> registerStructureType(String name, StructureType<T> structureType) {
        return Registry.register(Registries.STRUCTURE_TYPE, Cataclysm.modIdentifier(name), structureType);
    }

    public static final StructurePieceType RCP = registerStructurePieceType("ruined_citadel", RuinedCitadelStructure.Piece::new);
    public static final StructurePieceType BAP = registerStructurePieceType("burning_arena", Burning_Arena_Structure.Piece::new);
    public static final StructurePieceType SCP = registerStructurePieceType("sunken_city", Sunken_City_Structure.Piece::new);
    public static final StructurePieceType CPD = registerStructurePieceType("cursed_pyramid", Cursed_Pyramid_Structure.Piece::new);

    private static StructurePieceType registerStructurePieceType(String name, StructurePieceType structurePiece) {
        return Registry.register(Registries.STRUCTURE_PIECE, Cataclysm.modIdentifier(name), structurePiece);
    }

    public static final RegistryKey<Structure> SOUL_BLACK_SMITH_KEY = RegistryKey.of(RegistryKeys.STRUCTURE, Cataclysm.modIdentifier("soul_black_smith"));
    public static final RegistryKey<Structure> RUINED_CITADEL_KEY = RegistryKey.of(RegistryKeys.STRUCTURE, Cataclysm.modIdentifier("ruined_citadel"));
    public static final RegistryKey<Structure> BURNING_ARENA_KEY = RegistryKey.of(RegistryKeys.STRUCTURE, Cataclysm.modIdentifier("burning_arena"));
    public static final RegistryKey<Structure> ANCIENT_FACTORY_KEY = RegistryKey.of(RegistryKeys.STRUCTURE, Cataclysm.modIdentifier("ancient_factory"));
    public static final RegistryKey<Structure> CURSED_PYRAMID_KEY = RegistryKey.of(RegistryKeys.STRUCTURE, Cataclysm.modIdentifier("cursed_pyramid"));

    public static void log() {
        Cataclysm.LOGGER.info("Registering structures for " + Cataclysm.MOD_ID);
    }
}
