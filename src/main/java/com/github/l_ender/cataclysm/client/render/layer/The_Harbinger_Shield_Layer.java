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
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class The_Harbinger_Shield_Layer extends FeatureRenderer<The_Harbinger_Entity, The_Harbinger_Model> {

    private static final Identifier HARBINGER_LAYER_TEXTURES  = Cataclysm.modIdentifier("textures/entity/harbinger/the_harbinger_shield_layer.png");


    public The_Harbinger_Shield_Layer(The_Harbinger_Renderer rendererTheHarbinger) {
        super(rendererTheHarbinger);
    }

    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, The_Harbinger_Entity harbinger, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = (float) harbinger.age + partialTicks;
        if(harbinger.shouldRenderOverlay()) {
            matrixStackIn.push();
            matrixStackIn.scale(1.02f,1.02f,1.02f);
            EntityModel<The_Harbinger_Entity> entitymodel = this.getContextModel();
            entitymodel.animateModel(harbinger, limbSwing, limbSwingAmount, partialTicks);
            this.getContextModel().copyStateTo(entitymodel);
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderLayer.getEnergySwirl(this.getTextureLocation(), this.xOffset(f), f * 0.01F));
            entitymodel.setAngles(harbinger, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            entitymodel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.DEFAULT_UV,-8355712);
            matrixStackIn.pop();
        }
    }

    protected float xOffset(float p_117702_) {
        return MathHelper.cos(p_117702_ * 0.02F) * 2F;
    }

    protected Identifier getTextureLocation() {
        return HARBINGER_LAYER_TEXTURES;
    }

}


