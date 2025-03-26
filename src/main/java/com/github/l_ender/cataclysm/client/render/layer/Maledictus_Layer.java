package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.client.model.entity.Maledictus_Model;
import com.github.l_ender.cataclysm.client.render.entity.Maledictus_Renderer;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Maledictus_Layer extends FeatureRenderer<Maledictus_Entity, Maledictus_Model> {
    private static final Identifier LAYER_TEXTURES  = new Identifier("cataclysm:textures/entity/maledictus/maledictus_armor.png");

    public Maledictus_Layer(Maledictus_Renderer renderIn) {
        super(renderIn);

    }

    public Identifier getLayerTextureLocation() {
        return LAYER_TEXTURES;
    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Maledictus_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderLayer ghost = RenderLayer.getEntityCutoutNoCull(this.getLayerTextureLocation());
        VertexConsumer VertexConsumer = bufferIn.getBuffer(ghost);
        this.getContextModel().render(matrixStackIn, VertexConsumer, packedLightIn, LivingEntityRenderer.getOverlay(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
    }
}


