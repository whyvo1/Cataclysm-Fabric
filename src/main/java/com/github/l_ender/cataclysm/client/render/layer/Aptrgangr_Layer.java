package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Aptrgangr_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.client.render.entity.Aptrgangr_Renderer;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
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
public class Aptrgangr_Layer extends FeatureRenderer<Aptrgangr_Entity, Aptrgangr_Model> {
    private static final Identifier LAYER = Cataclysm.modIdentifier("textures/entity/draugar/aptrgangr_layer.png");

    public Aptrgangr_Layer(Aptrgangr_Renderer renderIn) {
        super(renderIn);
    }

    public Identifier getLayerTextureLocation() {
        return LAYER;
    }
    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Aptrgangr_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            //need rework
        float f = 1.0F - entity.deathTime / (float) entity.deathtimer();
        RenderLayer eyes = CMRenderTypes.CMEyes(this.getLayerTextureLocation());
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
        this.getContextModel().render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV, f, f, f, 1.0F);

    }
}


