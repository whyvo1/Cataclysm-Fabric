package com.github.l_ender.cataclysm.mixin;

import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.MixinUtils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.BasaltColumnsFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(BasaltColumnsFeature.class)
public class NoBasaltColumnsInStructuresMixin {

    @Inject(
            method = "canPlaceAt",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private static void cataclysm_noBasaltColumnsInStructures(WorldAccess levelAccessor, int seaLevel, BlockPos.Mutable mutableBlockPos, CallbackInfoReturnable<Boolean> cir) {
        if(!(levelAccessor instanceof ChunkRegion worldGenRegion)) {
            return;
        }

        if (MixinUtils.isPositionInTaggedStructure(worldGenRegion, mutableBlockPos, ModTag.BLOCKED_BASALT)) {
            cir.setReturnValue(false);
        }

    }
}
