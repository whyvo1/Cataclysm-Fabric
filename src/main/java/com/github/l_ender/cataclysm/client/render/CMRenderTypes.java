package com.github.l_ender.cataclysm.client.render;

import com.github.l_ender.cataclysm.Cataclysm;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.function.BiFunction;
import java.util.function.Function;

@Environment(EnvType.CLIENT)
public class CMRenderTypes extends RenderLayer {
    public CMRenderTypes(String p_173178_, VertexFormat p_173179_, VertexFormat.DrawMode p_173180_, int p_173181_, boolean p_173182_, boolean p_173183_, Runnable p_173184_, Runnable p_173185_) {
        super(p_173178_, p_173179_, p_173180_, p_173181_, p_173182_, p_173183_, p_173184_, p_173185_);
    }

    protected static final Transparency GHOST_TRANSPARANCY = new Transparency("translucent_ghost_transparency", () -> {
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA);
    }, () -> {
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    });

    public static RenderLayer getBright(Identifier locationIn) {
        Texture renderstate$texturestate = new Texture(locationIn, false, false);
        return of("bright", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, VertexFormat.DrawMode.QUADS, 256, false, true, MultiPhaseParameters
                .builder()
                .texture(renderstate$texturestate)
                .program(ENTITY_TRANSLUCENT_CULL_PROGRAM)
                .transparency(NO_TRANSPARENCY)
                .cull(DISABLE_CULLING)
                .lightmap(ENABLE_LIGHTMAP)
                .overlay(ENABLE_OVERLAY_COLOR)
                .build(false));
    }

    public static RenderLayer getFlickering(Identifier p_228652_0_, float lightLevel) {
        Texture renderstate$texturestate = new Texture(p_228652_0_, false, false);
        return of("flickering", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, VertexFormat.DrawMode.QUADS, 256, false, true, MultiPhaseParameters
                .builder()
                .texture(renderstate$texturestate)
                .program(ENTITY_TRANSLUCENT_CULL_PROGRAM)
                .transparency(TRANSLUCENT_TRANSPARENCY)
                .cull(DISABLE_CULLING).lightmap(ENABLE_LIGHTMAP)
                .overlay(ENABLE_OVERLAY_COLOR)
                .build(false));
    }

    public static RenderLayer getfullBright(Identifier locationIn) {
        Texture renderstate$texturestate = new Texture(locationIn, false, false);
        return of("full_bright", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, VertexFormat.DrawMode.QUADS, 256, false, true, MultiPhaseParameters
                .builder()
                .texture(renderstate$texturestate)
                .program(ENTITY_TRANSLUCENT_CULL_PROGRAM)
                .transparency(TRANSLUCENT_TRANSPARENCY)
                .cull(DISABLE_CULLING)
                .lightmap(ENABLE_LIGHTMAP)
                .overlay(ENABLE_OVERLAY_COLOR)
                .build(false));
    }

    public static RenderLayer getGlowingEffect(Identifier locationIn) {
        Texture renderstate$texturestate = new Texture(locationIn, false, false);
        return of("glow_effect", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, VertexFormat.DrawMode.QUADS, 256, true, true, MultiPhaseParameters.builder()
                .texture(renderstate$texturestate)
                .program(BEACON_BEAM_PROGRAM)
                .transparency(TRANSLUCENT_TRANSPARENCY)
                .cull(DISABLE_CULLING).overlay(ENABLE_OVERLAY_COLOR)
                .writeMaskState(COLOR_MASK)
                .build(false));
    }

    public static RenderLayer getghost(Identifier texture) {
        MultiPhaseParameters renderState = MultiPhaseParameters.builder()
                .program(ENERGY_SWIRL_PROGRAM)
                .cull(DISABLE_CULLING)
                .texture(new Texture(texture, false, false))
                .transparency(TRANSLUCENT_TRANSPARENCY)
                .lightmap(ENABLE_LIGHTMAP)
                .overlay(ENABLE_OVERLAY_COLOR)
                .writeMaskState(ALL_MASK)
                .depthTest(LEQUAL_DEPTH_TEST)
                .layering(NO_LAYERING)
                .build(false);
        return of("ghost", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, VertexFormat.DrawMode.QUADS, 256, true, true, renderState);
    }


    public static RenderLayer getPulse() {
        MultiPhaseParameters renderState = MultiPhaseParameters.builder()
                .program(ENERGY_SWIRL_PROGRAM)
                .cull(DISABLE_CULLING)
                .texture(new Texture(Cataclysm.modIdentifier("textures/particle/em_pulse.png"), true, true))
                .transparency(TRANSLUCENT_TRANSPARENCY)
                .lightmap(ENABLE_LIGHTMAP)
                .overlay(ENABLE_OVERLAY_COLOR)
                .writeMaskState(COLOR_MASK)
                .depthTest(LEQUAL_DEPTH_TEST)
                .layering(VIEW_OFFSET_Z_LAYERING)
                .build(false);
        return of("em_pulse", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, VertexFormat.DrawMode.QUADS, 256, true, true, renderState);
    }


    public static RenderLayer getTrailEffect(Identifier locationIn) {
        Texture renderstate$texturestate = new Texture(locationIn, false, false);
        return of("trail_effect", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, VertexFormat.DrawMode.QUADS, 1536, true, true, MultiPhaseParameters.builder()
                .texture(renderstate$texturestate)
                .program(ITEM_ENTITY_TRANSLUCENT_CULL_PROGRAM)
                .transparency(TRANSLUCENT_TRANSPARENCY)
                .target(ITEM_ENTITY_TARGET)
                .cull(DISABLE_CULLING)
                .lightmap(ENABLE_LIGHTMAP)
                .overlay(ENABLE_OVERLAY_COLOR)
                .writeMaskState(RenderPhase.ALL_MASK)
                .build(true));
    }

    public static final Function<Identifier, RenderLayer> NEW_TRAIL_EFFECT = Util.memoize(
            p_286155_ -> {
                RenderLayer.MultiPhaseParameters rendertype$compositestate = RenderLayer.MultiPhaseParameters.builder()
                        .program(ITEM_ENTITY_TRANSLUCENT_CULL_PROGRAM)
                        .texture(new RenderPhase.Texture(p_286155_, false, false))
                        .transparency(TRANSLUCENT_TRANSPARENCY)
                        .target(ITEM_ENTITY_TARGET)
                        .lightmap(ENABLE_LIGHTMAP)
                        .cull(DISABLE_CULLING)
                        .overlay(ENABLE_OVERLAY_COLOR)
                        .writeMaskState(RenderPhase.ALL_MASK)
                        .build(true);
                return of("new_trail_effect", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, VertexFormat.DrawMode.QUADS, 1536, true, true, rendertype$compositestate);
            }
    );

    public static final Function<Identifier, RenderLayer> LIGHT_TRAIL_EFFECT = Util.memoize(
            p_286155_ -> {
                RenderLayer.MultiPhaseParameters rendertype$compositestate = RenderLayer.MultiPhaseParameters.builder()
                        .program(EYES_PROGRAM)
                        .texture(new RenderPhase.Texture(p_286155_, false, false))
                        .transparency(ADDITIVE_TRANSPARENCY)
                        .target(ITEM_ENTITY_TARGET)
                        .lightmap(ENABLE_LIGHTMAP)
                        .cull(DISABLE_CULLING)
                        .overlay(ENABLE_OVERLAY_COLOR)
                        .writeMaskState(RenderPhase.ALL_MASK)
                        .build(true);
                return of("light_trail_effect", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, VertexFormat.DrawMode.QUADS, 1536, true, true, rendertype$compositestate);
            }
    );


    public static RenderLayer CMEyes(Identifier locationIn) {
        Texture renderstateshard$texturestateshard = new Texture(locationIn, false, false);
        return of("cm_eyes", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, VertexFormat.DrawMode.QUADS, 1536, false, true, MultiPhaseParameters.builder()
                .program(EYES_PROGRAM)
                .texture(renderstateshard$texturestateshard)
                .transparency(ADDITIVE_TRANSPARENCY)
                .cull(DISABLE_CULLING)
                .writeMaskState(COLOR_MASK)
                .overlay(ENABLE_OVERLAY_COLOR).
                build(false));
    }


    public static final RenderLayer LIGHTNING = of(
            "lightning",
            VertexFormats.POSITION_COLOR,
            VertexFormat.DrawMode.QUADS,
            1536,
            false,
            true,
            RenderLayer.MultiPhaseParameters.builder()
                    .program(LIGHTNING_PROGRAM)
                    .writeMaskState(ALL_MASK)
                    .transparency(LIGHTNING_TRANSPARENCY)
                    .target(WEATHER_TARGET)
                    .build(false)
    );


    public static RenderLayer getGhost(Identifier texture) {
        MultiPhaseParameters renderState = MultiPhaseParameters.builder()
                .program(ENERGY_SWIRL_PROGRAM)
                .cull(DISABLE_CULLING)
                .texture(new Texture(texture, false, false))
                .transparency(TRANSLUCENT_TRANSPARENCY)
                .lightmap(ENABLE_LIGHTMAP)
                .overlay(ENABLE_OVERLAY_COLOR)
                .writeMaskState(ALL_MASK)
                .depthTest(LEQUAL_DEPTH_TEST)
                .layering(NO_LAYERING)
                .build(false);
        return of("ghost", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, VertexFormat.DrawMode.QUADS, 256, true, true, renderState);
    }

    public static RenderLayer DragonDeath(Identifier texture) {
        MultiPhaseParameters rendertype$compositestate = MultiPhaseParameters.builder().program(ENTITY_ALPHA_PROGRAM)
                .texture(new Texture(texture, false, false))
                .cull(DISABLE_CULLING)
                .build(true);
        return of("entity_alpha", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, VertexFormat.DrawMode.QUADS, 256,true,true, rendertype$compositestate);
    }

    public static RenderLayer getShockWave() {
        MultiPhaseParameters renderState = MultiPhaseParameters.builder()
                .program(ENERGY_SWIRL_PROGRAM)
                .cull(DISABLE_CULLING)
                .texture(new Texture(Cataclysm.modIdentifier("textures/particle/shock_wave.png"), true, true))
                .transparency(TRANSLUCENT_TRANSPARENCY)
                .lightmap(ENABLE_LIGHTMAP)
                .overlay(ENABLE_OVERLAY_COLOR)
                .writeMaskState(COLOR_MASK)
                .depthTest(LEQUAL_DEPTH_TEST)
                .layering(VIEW_OFFSET_Z_LAYERING)
                .build(false);
        return of("shock_wave", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL, VertexFormat.DrawMode.QUADS, 256, true, true, renderState);
    }

}
