package com.github.l_ender.cataclysm.mixin.accessor;

import net.minecraft.util.math.BlockBox;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

//@Mixin(BlockBox.class)
public interface BoundingBoxAccessor {

//    @Accessor("minX")
    void setMinX(int minX);

//    @Accessor("minY")
    void setMinY(int minY);

//    @Accessor("minZ")
    void setMinZ(int minZ);

//    @Accessor("maxX")
    void setMaxX(int maxX);

//    @Accessor("maxY")
    void setMaxY(int maxY);

//    @Accessor("maxZ")
    void setMaxZ(int maxZ);
}
