package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.client.model.entity.Ignis_Model;
import com.github.l_ender.cataclysm.client.render.entity.Ignis_Renderer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;
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
public class Ignis_Shield_Layer extends FeatureRenderer<Ignis_Entity, Ignis_Model> {

    private final Ignis_Model model = new Ignis_Model();

    private static final Identifier IGNIS_SHIELD = new Identifier("cataclysm:textures/entity/ignis/ignis_shield.png");

    private static final Identifier IGNIS_SOUL_SHIELD = new Identifier("cataclysm:textures/entity/ignis/ignis_soul_shield.png");

    private static final Identifier IGNIS_SHIELD_CRACK1 = new Identifier("cataclysm:textures/entity/ignis/ignis_shield_crack1.png");

    private static final Identifier IGNIS_SHIELD_CRACK2 = new Identifier("cataclysm:textures/entity/ignis/ignis_shield_crack2.png");

    private static final Identifier IGNIS_SHIELD_CRACK3 = new Identifier("cataclysm:textures/entity/ignis/ignis_shield_crack3.png");

    public Ignis_Shield_Layer(Ignis_Renderer renderIgnis) {
        super(renderIgnis);
    }

    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Ignis_Entity ignis, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        Identifier lvt_12_3_;
        if (ignis.getBossPhase() < 1) {
            lvt_12_3_ = IGNIS_SHIELD;
        } else {
            lvt_12_3_ = IGNIS_SOUL_SHIELD;
        }
        this.getContextModel().copyStateTo(this.model);
        this.model.setAngles(ignis, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        VertexConsumer lvt_13_1_ = bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(lvt_12_3_));
        this.model.render(matrixStackIn, lvt_13_1_, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        if (ignis.getShieldDurability() > 0) {
            VertexConsumer lvt_13_2_ =
                    ignis.getShieldDurability() >= 3 ? bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(IGNIS_SHIELD_CRACK3))
                            : ignis.getShieldDurability() == 2 ? bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(IGNIS_SHIELD_CRACK2))
                            : bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(IGNIS_SHIELD_CRACK1));
            this.model.render(matrixStackIn, lvt_13_2_, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        }



    }
}