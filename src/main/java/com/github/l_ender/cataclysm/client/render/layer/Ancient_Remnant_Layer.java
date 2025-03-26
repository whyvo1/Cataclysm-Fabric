package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Ancient_Remnant_Rework_Model;
import com.github.l_ender.cataclysm.client.render.entity.Ancient_Remnant_Rework_Renderer;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Ancient_Remnant_Layer extends FeatureRenderer<Ancient_Remnant_Entity, Ancient_Remnant_Rework_Model> {
    private static final Identifier LAYER_TEXTURES  = Cataclysm.modIdentifier("textures/entity/ancient_remnant/ancient_remnant_layer.png");

    public Ancient_Remnant_Layer(Ancient_Remnant_Rework_Renderer renderIn) {
        super(renderIn);

    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Ancient_Remnant_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.getIsPower() && entity.isAlive()) {
            RenderLayer eyes = RenderLayer.getEyes(LAYER_TEXTURES);
            VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
            this.getContextModel().render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}


