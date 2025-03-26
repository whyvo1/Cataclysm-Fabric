package com.github.l_ender.cataclysm.structures.jisaw;


import com.github.l_ender.cataclysm.structures.jisaw.assembler.PieceContext;
import com.github.l_ender.cataclysm.structures.jisaw.element.CataclysmJigsawSinglePoolElement;
import com.github.l_ender.cataclysm.util.BoxOctree;
import org.apache.commons.lang3.mutable.MutableObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.structure.JigsawJunction;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;

public class PieceEntry {
    private PoolStructurePiece piece;
    private final MutableObject<BoxOctree> boxOctree;
    private final Box pieceAabb;
    private final int depth;
    private final List<PieceEntry> childEntries = new ArrayList<>();
    private final PieceEntry parentEntry;
    private final PieceContext sourcePieceContext;
    private final JigsawJunction parentJunction;
    private boolean delayGeneration = false;

    public PieceEntry(PoolStructurePiece piece, MutableObject<BoxOctree> boxOctree, Box pieceAabb, int depth,
                      PieceEntry parentEntry, PieceContext sourcePieceContext, JigsawJunction parentJunction) {
        this.piece = piece;
        this.boxOctree = boxOctree;
        this.pieceAabb = pieceAabb;
        this.depth = depth;
        this.parentEntry = parentEntry;
        this.sourcePieceContext = sourcePieceContext;
        this.parentJunction = parentJunction;
    }

    public void addChildEntry(PieceEntry childEntry) {
        this.childEntries.add(childEntry);
    }

    public boolean hasChildren() {
        return !this.childEntries.isEmpty();
    }

    public PoolStructurePiece getPiece() {
        return piece;
    }

    public void setPiece(PoolStructurePiece newPiece) {
        this.piece = newPiece;
    }

    public MutableObject<BoxOctree> getBoxOctree() {
        return boxOctree;
    }

    public int getDepth() {
        return depth;
    }

    public PieceEntry getParentEntry() {
        return parentEntry;
    }

    public PieceContext getSourcePieceContext() {
        return sourcePieceContext;
    }

    public Box getPieceAabb() {
        return pieceAabb;
    }

    public JigsawJunction getParentJunction() {
        return parentJunction;
    }

    public Optional<Identifier> getDeadendPool() {
        if (this.piece.getPoolElement() instanceof CataclysmJigsawSinglePoolElement yungSingleElement) {
            return yungSingleElement.getDeadendPool();
        }
        return Optional.empty();
    }

    public void setDelayGeneration(boolean delayGeneration) {
        this.delayGeneration = delayGeneration;
    }

    public boolean isDelayGeneration() {
        return this.delayGeneration;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (PieceEntry) obj;
        return Objects.equals(this.piece, that.piece) &&
                Objects.equals(this.boxOctree, that.boxOctree) &&
                this.depth == that.depth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(piece, boxOctree, depth);
    }

    @Override
    public String toString() {
        return "PieceEntry[" +
                "piece=" + piece + ", " +
                "boxOctree=" + boxOctree + ", " +
                "depth=" + depth + ']';
    }
}
