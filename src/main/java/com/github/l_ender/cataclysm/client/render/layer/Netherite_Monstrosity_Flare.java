package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Netherite_Monstrosity_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.client.render.entity.New_Netherite_Monstrosity_Renderer;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
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
public class Netherite_Monstrosity_Flare extends FeatureRenderer<Netherite_Monstrosity_Entity, Netherite_Monstrosity_Model> {
    private static final Identifier NETHERITE_MONSTRISITY_OUTER = Cataclysm.modIdentifier("textures/entity/monstrosity/netherite_monstrosity_flare_outer.png");

    public Netherite_Monstrosity_Flare(New_Netherite_Monstrosity_Renderer renderIn) {
        super(renderIn);

    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Netherite_Monstrosity_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderLayer eyes2 = CMRenderTypes.CMEyes(NETHERITE_MONSTRISITY_OUTER);
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(eyes2);

        this.getContextModel().render(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.DEFAULT_UV, 1, 1, 1, 0.4F);
    }
}


