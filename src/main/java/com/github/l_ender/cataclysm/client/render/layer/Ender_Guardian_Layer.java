package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Ender_Guardian_Model;
import com.github.l_ender.cataclysm.client.render.entity.Ender_Guardian_Renderer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Guardian_Entity;
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
public class Ender_Guardian_Layer extends FeatureRenderer<Ender_Guardian_Entity, Ender_Guardian_Model> {
    private static final Identifier ENDER_GUARDIAN_LAYER_TEXTURES  = Cataclysm.modIdentifier("textures/entity/ender_guardian_layer.png");

    public Ender_Guardian_Layer(Ender_Guardian_Renderer renderIn) {
        super(renderIn);

    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Ender_Guardian_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.deathTime < 100) {
            //need rework
            RenderLayer eyes = RenderLayer.getEyes(ENDER_GUARDIAN_LAYER_TEXTURES);
            VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
            this.getContextModel().render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV);
        }
    }
}


