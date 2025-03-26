package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.Cataclysm;
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
import net.minecraft.util.math.ColorHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Ender_Golem_Layer extends FeatureRenderer<Ender_Golem_Entity, Ender_Golem_Model> {
    private static final Identifier ENDER_GOLEM_LAYER_TEXTURES  = Cataclysm.modIdentifier("textures/entity/ender_golem_layer.png");

    public Ender_Golem_Layer(Ender_Golem_Renderer renderIn) {
        super(renderIn);

    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Ender_Golem_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if ( entity.deathTime <= 45) {
            //need rework
            int f = (int) (255 - entity.deactivateProgress * 255 / 30);
            RenderLayer eyes = RenderLayer.getEyes(ENDER_GOLEM_LAYER_TEXTURES);
            VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);

            int i = ColorHelper.Argb.getArgb(f, f,f);

            this.getContextModel().render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV, i);
        }
    }
}


