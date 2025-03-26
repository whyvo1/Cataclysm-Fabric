package com.github.l_ender.cataclysm.mixin;

import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.MixinUtils;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(OreFeature.class)
public class NoOreInStructuresMixin {

    @Inject(
            method = "generate",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void cataclysm_noOreInStructures(FeatureContext<OreFeatureConfig> context, CallbackInfoReturnable<Boolean> cir) {
        if(!(context.getWorld() instanceof ChunkRegion worldGenRegion)) {
            return;
        }

        if (MixinUtils.isPositionInTaggedStructure(worldGenRegion, context.getOrigin(), ModTag.BLOCKED_ORE)) {
            cir.setReturnValue(false);
        }
    }
}
