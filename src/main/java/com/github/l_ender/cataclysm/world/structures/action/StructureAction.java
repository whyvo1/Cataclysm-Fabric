package com.github.l_ender.cataclysm.world.structures.action;


import com.github.l_ender.cataclysm.structures.jisaw.PieceEntry;
import com.github.l_ender.cataclysm.structures.jisaw.context.StructureContext;

/**
 * A serializable class used for modifying pieces of Jigsaw structures during world generation.
 */
public abstract class StructureAction {
    abstract public StructureActionType<?> type();
    abstract public void apply(StructureContext ctx, PieceEntry targetPieceEntry);
}
