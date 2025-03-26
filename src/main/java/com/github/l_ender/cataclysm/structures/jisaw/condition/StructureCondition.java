package com.github.l_ender.cataclysm.structures.jisaw.condition;


import com.github.l_ender.cataclysm.structures.jisaw.context.StructureContext;

/**
 * A serializable class used for checking specific parameters during world generation.
 * Can be used for jigsaw pieces as well as processors.
 */
public abstract class StructureCondition {
    abstract public StructureConditionType<?> type();
    abstract public boolean passes(StructureContext ctx);
}
