package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Ignited_Revenant_Model;
import com.github.l_ender.cataclysm.client.render.entity.Ignited_Revenant_Renderer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
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
public class Revenant_Layer extends FeatureRenderer<Ignited_Revenant_Entity, Ignited_Revenant_Model> {

    private final Ignited_Revenant_Model model = new Ignited_Revenant_Model();

    private static final Identifier REVENANT_SHIELD = Cataclysm.modIdentifier("textures/entity/revenant_shield.png");


    public Revenant_Layer(Ignited_Revenant_Renderer renderIgnis) {
        super(renderIgnis);
    }

    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Ignited_Revenant_Entity revenant, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getContextModel().copyStateTo(this.model);
        this.model.setAngles(revenant, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        VertexConsumer lvt_13_1_ = bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(REVENANT_SHIELD));
        this.model.render(matrixStackIn, lvt_13_1_, packedLightIn, OverlayTexture.DEFAULT_UV);
    }
}