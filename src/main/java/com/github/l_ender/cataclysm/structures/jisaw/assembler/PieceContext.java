package com.github.l_ender.cataclysm.structures.jisaw.assembler;

import com.github.l_ender.cataclysm.structures.jisaw.PieceEntry;
import com.github.l_ender.cataclysm.util.BoxOctree;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.util.math.BlockPos;
import org.apache.commons.lang3.mutable.MutableObject;

public class PieceContext {
    public ObjectArrayList<Pair<StructurePoolElement, Integer>> candidatePoolElements;
    public StructureTemplate.StructureBlockInfo jigsawBlock;
    public BlockPos jigsawBlockTargetPos;
    public int pieceMinY;
    public BlockPos jigsawBlockPos;
    public MutableObject<BoxOctree> boxOctree;
    public PieceEntry pieceEntry;
    public int depth;

    public PieceContext(ObjectArrayList<Pair<StructurePoolElement, Integer>> candidatePoolElements,
                        StructureTemplate.StructureBlockInfo jigsawBlock,
                        BlockPos jigsawBlockTargetPos,
                        int pieceMinY,
                        BlockPos jigsawBlockPos,
                        MutableObject<BoxOctree> boxOctree,
                        PieceEntry pieceEntry,
                        int depth) {
        this.candidatePoolElements = candidatePoolElements;
        this.jigsawBlock = jigsawBlock;
        this.jigsawBlockTargetPos = jigsawBlockTargetPos;
        this.pieceMinY = pieceMinY;
        this.jigsawBlockPos = jigsawBlockPos;
        this.boxOctree = boxOctree;
        this.pieceEntry = pieceEntry;
        this.depth = depth;
    }

    public PieceContext copy() {
        return new PieceContext(candidatePoolElements, jigsawBlock, jigsawBlockTargetPos,
                pieceMinY, jigsawBlockPos, boxOctree, pieceEntry, depth);
    }
}
