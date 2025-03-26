package com.github.l_ender.cataclysm.mixin.accessor;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;
import net.minecraft.structure.pool.ListPoolElement;
import net.minecraft.structure.pool.StructurePoolElement;

//@Mixin(ListPoolElement.class)
public interface ListPoolElementAccessor {
//    @Accessor
    List<StructurePoolElement> getElements();
}
