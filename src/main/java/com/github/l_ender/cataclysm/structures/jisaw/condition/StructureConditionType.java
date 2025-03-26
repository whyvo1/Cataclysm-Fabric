package com.github.l_ender.cataclysm.structures.jisaw.condition;

import com.github.l_ender.cataclysm.Cataclysm;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.util.Identifier;

/**
 * Specifies the type of a specific {@link StructureCondition}.
 * This class also serves as the registration hub for StructureConditions and their corresponding types.
 */
public interface StructureConditionType<C extends StructureCondition> {
    /* Utility maps for codecs. Simulates the approach vanilla registries use. */
    Map<Identifier, StructureConditionType<?>> CONDITION_TYPES_BY_NAME = new HashMap<>();
    Map<StructureConditionType<?>, Identifier> NAME_BY_CONDITION_TYPES = new HashMap<>();

    /* Codecs */
    Codec<StructureConditionType<?>> CONDITION_TYPE_CODEC = Identifier.CODEC
            .flatXmap(
                    resourceLocation -> Optional.ofNullable(CONDITION_TYPES_BY_NAME.get(resourceLocation))
                            .map(DataResult::success)
                            .orElseGet(() -> DataResult.error(() -> "Unknown condition type: " + resourceLocation)),
                    conditionType -> Optional.of(NAME_BY_CONDITION_TYPES.get(conditionType))
                            .map(DataResult::success)
                            .orElseGet(() -> DataResult.error(() -> "No ID found for condition type " + conditionType + ". Is it registered?")));

    Codec<StructureCondition> CONDITION_CODEC = StructureConditionType.CONDITION_TYPE_CODEC
            .dispatch("type", StructureCondition::type, StructureConditionType::codec);

    /* Types. Add any new types here! */
    StructureConditionType<AlwaysTrueCondition> ALWAYS_TRUE = register("always_true", AlwaysTrueCondition.CODEC);


    /**
     * Utility method for registering StructureConditionTypes.
     */
    static <C extends StructureCondition> StructureConditionType<C> register(Identifier resourceLocation, Codec<C> codec) {
        StructureConditionType<C> conditionType = () -> codec;
        CONDITION_TYPES_BY_NAME.put(resourceLocation, conditionType);
        NAME_BY_CONDITION_TYPES.put(conditionType, resourceLocation);
        return conditionType;
    }

    /**
     * Private utility method for registering StructureConditionTypes native to YUNG's API.
     */
    private static <C extends StructureCondition> StructureConditionType<C> register(String id, Codec<C> codec) {
        return register(Cataclysm.modIdentifier(id), codec);
    }

    /**
     * Supplies the codec for the {@link StructureCondition} corresponding to this StructureConditionType.
     */
    Codec<C> codec();
}
