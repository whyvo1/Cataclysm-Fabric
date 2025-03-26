package com.github.l_ender.cataclysm.structures.jisaw.condition;

import com.github.l_ender.cataclysm.structures.jisaw.context.StructureContext;
import com.mojang.serialization.MapCodec;


/**
 * Condition that always passes.
 */
public class AlwaysTrueCondition  extends StructureCondition {
    public static final StructureCondition ALWAYS_TRUE = new AlwaysTrueCondition();
    private static final AlwaysTrueCondition INSTANCE = new AlwaysTrueCondition();
    public static final MapCodec<AlwaysTrueCondition> CODEC = MapCodec.unit(() -> INSTANCE);

    public AlwaysTrueCondition() {
    }

    @Override
    public StructureConditionType<?> type() {
        return StructureConditionType.ALWAYS_TRUE;
    }

    @Override
    public boolean passes(StructureContext ctx) {
        return true;
    }
}
