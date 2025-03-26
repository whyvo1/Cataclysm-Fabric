package com.github.l_ender.cataclysm.mixin;

import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.MixinUtils;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.gen.feature.DeltaFeatureConfig;
import net.minecraft.world.gen.feature.UnderwaterMagmaFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(UnderwaterMagmaFeature.class)
public class NoMagmaBlockInStructuresMixin {

    @Inject(
            method = "generate",
            cancellable = true,
            at = @At(value = "HEAD")
    )
    private void cataclysm_noMagmablockInStructures(FeatureContext<DeltaFeatureConfig> context, CallbackInfoReturnable<Boolean> cir) {
        if(!(context.getWorld() instanceof ChunkRegion worldGenRegion)) {
            return;
        }

        if (MixinUtils.isPositionInTaggedStructure(worldGenRegion, context.getOrigin(), ModTag.BLOCKED_MAGMA_BLOCK)) {
            cir.setReturnValue(false);
        }

    }
}
