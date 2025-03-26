package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Wadjet_Model;
import com.github.l_ender.cataclysm.client.render.entity.Wadjet_Renderer;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Wadjet_Entity;
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
public class Wadjet_Layer extends FeatureRenderer<Wadjet_Entity, Wadjet_Model> {
    private static final Identifier LAYER_TEXTURES  = Cataclysm.modIdentifier("textures/entity/koboleton/wadjet_layer.png");

    public Wadjet_Layer(Wadjet_Renderer renderIn) {
        super(renderIn);

    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Wadjet_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.getAttackState() != 1 && entity.isAlive()) {
            RenderLayer eyes = RenderLayer.getEyes(LAYER_TEXTURES);
            VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
            this.getContextModel().render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV);
        }
    }
}


