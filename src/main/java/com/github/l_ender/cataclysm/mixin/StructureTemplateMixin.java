package com.github.l_ender.cataclysm.mixin;

import com.github.l_ender.cataclysm.init.ModStructureProcessor;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StructureTemplate.class)
public class StructureTemplateMixin {

    @Inject(
            method = "place",
            at = @At(value = "HEAD")
    )
    private void repurposedstructures_preventAutoWaterlogging(ServerWorldAccess serverLevelAccessor, BlockPos blockPos1,
                                                              BlockPos blockPos2, StructurePlacementData structurePlaceSettings,
                                                              Random random, int flag, CallbackInfoReturnable<Boolean> cir) {

        if(structurePlaceSettings.getProcessors().stream().anyMatch(processor ->
                processor.getType() == ModStructureProcessor.WATER_LOGGING_FIX_PROCESSOR)) {
            structurePlaceSettings.setPlaceFluids(false);
        }
    }
}