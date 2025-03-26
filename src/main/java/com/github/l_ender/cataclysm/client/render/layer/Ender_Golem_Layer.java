package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.client.model.entity.Ender_Golem_Model;
import com.github.l_ender.cataclysm.client.render.entity.Ender_Golem_Renderer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Golem_Entity;
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
public class Ender_Golem_Layer extends FeatureRenderer<Ender_Golem_Entity, Ender_Golem_Model> {
    private static final Identifier ENDER_GOLEM_LAYER_TEXTURES  = new Identifier("cataclysm:textures/entity/ender_golem_layer.png");

    public Ender_Golem_Layer(Ender_Golem_Renderer renderIn) {
        super(renderIn);

    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Ender_Golem_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if ( entity.deathTime <= 45) {
            //need rework
            float f = 1.0F - entity.deactivateProgress / 30;
            RenderLayer eyes = RenderLayer.getEyes(ENDER_GOLEM_LAYER_TEXTURES);
            VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
            this.getContextModel().render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV, f, f, f, f);
        }
    }
}


