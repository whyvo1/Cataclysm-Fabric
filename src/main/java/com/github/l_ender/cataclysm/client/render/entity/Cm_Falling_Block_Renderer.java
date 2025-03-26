package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


@Environment(EnvType.CLIENT)
public class Cm_Falling_Block_Renderer extends EntityRenderer<Cm_Falling_Block_Entity> {
    private final BlockRenderManager dispatcher;

    public Cm_Falling_Block_Renderer(EntityRendererFactory.Context p_174112_) {
        super(p_174112_);
        this.dispatcher = p_174112_.getBlockRenderManager();
    }

    public void render(Cm_Falling_Block_Entity p_114634_, float p_114635_, float p_114636_, MatrixStack p_114637_, VertexConsumerProvider p_114638_, int p_114639_) {
        BlockState blockstate = p_114634_.getBlockState();
        if (blockstate.getRenderType() == BlockRenderType.MODEL) {
            World level = p_114634_.getWorld();
            if (blockstate != level.getBlockState(p_114634_.getBlockPos()) && blockstate.getRenderType() != BlockRenderType.INVISIBLE) {
                p_114637_.push();
                BlockPos blockpos = BlockPos.ofFloored(p_114634_.getX(), p_114634_.getBoundingBox().maxY, p_114634_.getZ());
                p_114637_.translate(-0.5, 0.0, -0.5);
                BakedModel model = this.dispatcher.getModel(blockstate);
//                Iterator var11 = model.getRenderTypes(blockstate, Random.create(blockstate.getRenderingSeed(p_114634_.getStartPos())), ModelData.EMPTY).iterator();

//                while(var11.hasNext()) {
//                    RenderLayer renderType = (RenderLayer)var11.next();
                this.dispatcher.getModelRenderer().render(
                        level,
                        this.dispatcher.getModel(blockstate),
                        blockstate,
                        blockpos,
                        p_114637_,
                        p_114638_.getBuffer(RenderLayers.getMovingBlockLayer(blockstate)),
                        false,
                        Random.create(),
                        blockstate.getRenderingSeed(p_114634_.getStartPos()),
                        OverlayTexture.DEFAULT_UV);
//                        ModelData.EMPTY,
//                        renderType);
//                }

                p_114637_.pop();
                super.render(p_114634_, p_114635_, p_114636_, p_114637_, p_114638_, p_114639_);
            }
        }

    }

    public Identifier getTexture(Cm_Falling_Block_Entity p_114632_) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
    }
}
