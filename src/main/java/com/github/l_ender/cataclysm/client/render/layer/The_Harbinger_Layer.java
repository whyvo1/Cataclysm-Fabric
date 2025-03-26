package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.The_Harbinger_Model;
import com.github.l_ender.cataclysm.client.render.entity.The_Harbinger_Renderer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
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
public class The_Harbinger_Layer extends FeatureRenderer<The_Harbinger_Entity, The_Harbinger_Model> {
    private static final Identifier HARBINGER_LAYER_TEXTURES  = Cataclysm.modIdentifier("textures/entity/harbinger/the_harbinger_layer.png");

    public The_Harbinger_Layer(The_Harbinger_Renderer renderIn) {
        super(renderIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, The_Harbinger_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 1.0F - entity.deactivateProgress / 40;
        RenderLayer eyes = RenderLayer.getEyes(HARBINGER_LAYER_TEXTURES);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
        this.getContextModel().render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV, f, f, f, f);

    }
}


