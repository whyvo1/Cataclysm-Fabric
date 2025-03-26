package com.github.l_ender.cataclysm.mixin;

import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.util.MixinUtil;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.feature.MultifaceGrowthFeature;
import net.minecraft.world.gen.feature.MultifaceGrowthFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(MultifaceGrowthFeature.class)
public class NoMultifaceGrowthFeatureInStructuresMixin {

    @Inject(
            method = {"generate(Lnet/minecraft/world/gen/feature/util/FeatureContext;)Z"},
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void cataclysm_noOreInStructures(FeatureContext<MultifaceGrowthFeatureConfig> context, CallbackInfoReturnable<Boolean> cir) {
        if(!(context.getWorld() instanceof ChunkRegion)) {
            return;
        }

        ChunkSectionPos sectionPos = ChunkSectionPos.from(context.getOrigin());
        if (context.getWorld().getChunk(sectionPos.getSectionX(), sectionPos.getSectionZ(), ChunkStatus.STRUCTURE_REFERENCES, false) == null) {
            return;
        }

        Registry<Structure> configuredStructureFeatureRegistry = context.getWorld().getRegistryManager().get(RegistryKeys.STRUCTURE);
        StructureAccessor structureManager = ((ChunkRegion)context.getWorld()).structureAccessor;
        for (RegistryEntry<Structure> configuredStructureFeature : configuredStructureFeatureRegistry.getOrCreateEntryList(ModTag.BLOCKED_MULTIFACE)) {
            if (MixinUtil.getStructureAt(structureManager, context.getOrigin(),  configuredStructureFeature.value()).hasChildren()) {
                cir.setReturnValue(false);
                return;
            }
        }
    }
}
