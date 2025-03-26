package com.github.l_ender.cataclysm.structures.jisaw.context;

import com.github.l_ender.cataclysm.structures.jisaw.PieceEntry;
import java.util.List;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

/**
 * Context class capable of holding various arguments used for jigsaw structure generation and modification.
 * A Builder class is provided for instantiation since various arguments will likely not be needed
 * when using this class.
 */
public class StructureContext {
    private final int pieceMinY;
    private final int pieceMaxY;
    private final int depth;
    private final BlockPos pos;
    private final BlockRotation rotation;
    private final StructureTemplateManager structureTemplateManager;
    private final List<PieceEntry> pieces;
    private final PieceEntry pieceEntry;
    private final Random random;

    private StructureContext(Builder builder) {
        this.pieceMinY = builder.pieceMinY;
        this.pieceMaxY = builder.pieceMaxY;
        this.depth = builder.depth;
        this.pos = builder.pos;
        this.structureTemplateManager = builder.structureTemplateManager;
        this.pieces = builder.pieces;
        this.pieceEntry = builder.pieceEntry;
        this.rotation = builder.rotation;
        this.random = builder.random;
    }

    public int pieceMinY() {
        return pieceMinY;
    }

    public int pieceMaxY() {
        return pieceMaxY;
    }

    public int depth() {
        return depth;
    }

    public BlockPos pos() {
        return pos;
    }

    public BlockRotation rotation() {
        return rotation;
    }

    public StructureTemplateManager structureTemplateManager() {
        return structureTemplateManager;
    }

    public List<PieceEntry> pieces() {
        return pieces;
    }

    public PieceEntry pieceEntry() {
        return this.pieceEntry;
    }

    public Random random() {
        return this.random;
    }

    public static class Builder {
        private int pieceMinY = 0;
        private int pieceMaxY = 0;
        private int depth = 0;
        private BlockPos pos = null;
        private BlockRotation rotation = null;
        private StructureTemplateManager structureTemplateManager = null;
        private List<PieceEntry> pieces = null;
        private PieceEntry pieceEntry = null;
        private Random random = null;

        public Builder() {
        }

        public Builder pieceMinY(int pieceMinY) {
            this.pieceMinY = pieceMinY;
            return this;
        }

        public Builder pieceMaxY(int pieceMaxY) {
            this.pieceMaxY = pieceMaxY;
            return this;
        }

        public Builder depth(int depth) {
            this.depth = depth;
            return this;
        }

        public Builder pos(BlockPos pos) {
            this.pos = pos;
            return this;
        }

        public Builder rotation(BlockRotation rotation) {
            this.rotation = rotation;
            return this;
        }

        public Builder structureTemplateManager(StructureTemplateManager structureTemplateManager) {
            this.structureTemplateManager = structureTemplateManager;
            return this;
        }

        public Builder pieces(List<PieceEntry> pieces) {
            this.pieces = pieces;
            return this;
        }

        public Builder pieceEntry(PieceEntry pieceEntry) {
            this.pieceEntry = pieceEntry;
            return this;
        }

        public Builder random(Random random) {
            this.random = random;
            return this;
        }

        public StructureContext build() {
            return new StructureContext(this);
        }
    }
}