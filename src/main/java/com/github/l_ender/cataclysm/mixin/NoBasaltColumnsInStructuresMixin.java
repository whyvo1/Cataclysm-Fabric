package com.github.l_ender.cataclysm.mixin;

import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.MixinUtil;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.feature.BasaltColumnsFeature;
import net.minecraft.world.gen.structure.Structure;
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
        if(!(levelAccessor instanceof ChunkRegion)) {
            return;
        }

        ChunkSectionPos sectionPos = ChunkSectionPos.from(mutableBlockPos);
        if (!levelAccessor.getChunk(sectionPos.getSectionX(), sectionPos.getSectionZ()).getStatus().isAtLeast(ChunkStatus.STRUCTURE_REFERENCES)) {
            return;
        }

        Registry<Structure> configuredStructureFeatureRegistry = levelAccessor.getRegistryManager().get(RegistryKeys.STRUCTURE);
        StructureAccessor structureManager = ((ChunkRegion) levelAccessor).structureAccessor;
        for (RegistryEntry<Structure> configuredStructureFeature : configuredStructureFeatureRegistry.getOrCreateEntryList(ModTag.BLOCKED_BASALT)) {
            if (MixinUtil.getStructureAt(structureManager, mutableBlockPos,  configuredStructureFeature.value()).hasChildren()) {
                cir.setReturnValue(false);
                return;
            }
        }
    }
}
