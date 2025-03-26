package com.github.l_ender.cataclysm.client.render.blockentity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.blockentities.Cataclysm_Skull_BlockEntity;
import com.github.l_ender.cataclysm.blocks.Abstract_Cataclysm_Skull_Block;
import com.github.l_ender.cataclysm.blocks.Cataclysm_Skull_Block;
import com.github.l_ender.cataclysm.blocks.Wall_Cataclysm_Skull_Block;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.model.block.AptrgangrHeadModel;
import com.github.l_ender.cataclysm.client.model.block.Cataclysm_Skull_Model_Base;
import com.github.l_ender.cataclysm.client.model.block.DraugrHeadModel;
import com.github.l_ender.cataclysm.client.model.block.KobolediatorHeadModel;
import com.github.l_ender.cataclysm.client.render.RenderUtils;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationPropertyHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class Cataclysm_Skull_Block_Renderer<T extends Cataclysm_Skull_BlockEntity> implements BlockEntityRenderer<T> {
    private final Map<Cataclysm_Skull_Block.Type, Cataclysm_Skull_Model_Base> modelByType;
    public static final Map<Cataclysm_Skull_Block.Type, Identifier> SKIN_BY_TYPE = Util.make(Maps.newHashMap(), (p_261388_) -> {
        p_261388_.put(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, Cataclysm.modIdentifier("textures/entity/koboleton/kobolediator.png"));
        p_261388_.put(Cataclysm_Skull_Block.Types.APTRGANGR, Cataclysm.modIdentifier("textures/entity/draugar/aptrgangr.png"));
        p_261388_.put(Cataclysm_Skull_Block.Types.DRAUGR, Cataclysm.modIdentifier("textures/entity/draugar/draugr.png"));
    });

    public static Map<Cataclysm_Skull_Block.Type, Cataclysm_Skull_Model_Base> createSkullRenderers() {
        ImmutableMap.Builder<Cataclysm_Skull_Block.Type, Cataclysm_Skull_Model_Base> builder = ImmutableMap.builder();
        builder.put(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, new KobolediatorHeadModel(RenderUtils.getModelPartFromLayer(CMModelLayers.KOBOLEDIATOR_HEAD_MODEL)));
        builder.put(Cataclysm_Skull_Block.Types.APTRGANGR, new AptrgangrHeadModel(RenderUtils.getModelPartFromLayer(CMModelLayers.APTRGANGR_HEAD_MODEL)));
        builder.put(Cataclysm_Skull_Block.Types.DRAUGR, new DraugrHeadModel(RenderUtils.getModelPartFromLayer(CMModelLayers.DRAUGR_HEAD_MODEL)));
        return builder.build();
    }

    public Cataclysm_Skull_Block_Renderer(BlockEntityRendererFactory.Context rendererDispatcherIn) {
        this.modelByType = createSkullRenderers();
    }

    public void render(Cataclysm_Skull_BlockEntity p_112534_, float p_112535_, MatrixStack p_112536_, VertexConsumerProvider p_112537_, int p_112538_, int p_112539_) {
        float f = p_112534_.getAnimation(p_112535_);
        BlockState blockstate = p_112534_.getCachedState();
        boolean flag = blockstate.getBlock() instanceof Wall_Cataclysm_Skull_Block;
        Direction direction = flag ? blockstate.get(Wall_Cataclysm_Skull_Block.FACING) : null;
        int i = flag ? RotationPropertyHelper.fromDirection(direction.getOpposite()) : blockstate.get(Cataclysm_Skull_Block.ROTATION);
        float f1 = RotationPropertyHelper.toDegrees(i);
        Cataclysm_Skull_Block.Type Cataclysm_Skull_Block$type = ((Abstract_Cataclysm_Skull_Block)blockstate.getBlock()).getType();
        Cataclysm_Skull_Model_Base Cataclysm_Skull_Model_Base = this.modelByType.get(Cataclysm_Skull_Block$type);

        Identifier resourcelocation = SKIN_BY_TYPE.get(Cataclysm_Skull_Block$type);
        RenderLayer rendertype = RenderLayer.getEntityCutoutNoCullZOffset(resourcelocation);
        renderSkull(direction, f1, f, p_112536_, p_112537_, p_112538_, Cataclysm_Skull_Model_Base, rendertype);
    }

    public static void renderSkull(
            @Nullable Direction p_173664_,
            float p_173665_,
            float p_173666_,
            MatrixStack p_173667_,
            VertexConsumerProvider p_173668_,
            int p_173669_,
            Cataclysm_Skull_Model_Base p_173670_,
            RenderLayer p_173671_
    ) {
        p_173667_.push();
        if (p_173664_ == null) {
            p_173667_.translate(0.5F, 0.0F, 0.5F);
        } else {
            float f = 0.25F;
            p_173667_.translate(0.5F - (float)p_173664_.getOffsetX() * 0.25F, 0.25F, 0.5F - (float)p_173664_.getOffsetZ() * 0.25F);
        }

        p_173667_.scale(-1.0F, -1.0F, 1.0F);
        VertexConsumer vertexconsumer = p_173668_.getBuffer(p_173671_);
        p_173670_.setAngles(p_173666_, p_173665_, 0.0F);
        p_173670_.render(p_173667_, vertexconsumer, p_173669_, OverlayTexture.DEFAULT_UV);
        p_173667_.pop();
    }
}
