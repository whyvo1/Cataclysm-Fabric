package com.github.l_ender.cataclysm.mixin.accessor;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.Criterion;
import net.minecraft.util.Identifier;

//@Mixin(Criteria.class)
public interface CriteriaTriggersAccessor {
//    @Accessor("VALUES")
    static Map<Identifier, Criterion<?>> getValues() {
        throw new AssertionError();
    }
}