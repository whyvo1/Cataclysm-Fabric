package com.github.l_ender.cataclysm.mixin.accessor;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.structure.JigsawJunction;
import net.minecraft.world.gen.StructureWeightSampler;

//@Mixin(StructureWeightSampler.class)
public interface BeardifierAccessor {
//    @Accessor
    ObjectListIterator<StructureWeightSampler.Piece> getPieceIterator();

//    @Accessor
    ObjectListIterator<JigsawJunction> getJunctionIterator();
}
