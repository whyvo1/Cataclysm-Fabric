package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.The_Leviathan_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.client.render.entity.The_Leviathan_Renderer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
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
public class The_Leviathan_Layer extends FeatureRenderer<The_Leviathan_Entity, The_Leviathan_Model> {
    private static final Identifier LEVIATHAN_LAYER = Cataclysm.modIdentifier("textures/entity/leviathan/the_leviathan_layer.png");
    private static final Identifier BURNING_LEVIATHAN_LAYER = Cataclysm.modIdentifier("textures/entity/leviathan/the_burning_leviathan_layer.png");

    public The_Leviathan_Layer(The_Leviathan_Renderer renderIn) {
        super(renderIn);

    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, The_Leviathan_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        float alpha = entity.getMeltDown() ? 1 :entity.LayerBrightness;

        Identifier resourceLocation = entity.getMeltDown() ? BURNING_LEVIATHAN_LAYER : LEVIATHAN_LAYER;
        RenderLayer eyes = CMRenderTypes.CMEyes(resourceLocation);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
        this.getContextModel().render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV, alpha, alpha, alpha, 1.0f);

    }
}


