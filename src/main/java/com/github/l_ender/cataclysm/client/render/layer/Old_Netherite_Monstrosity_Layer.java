package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.client.model.entity.Old_Netherite_Monstrosity_Model;
import com.github.l_ender.cataclysm.client.render.entity.Netherite_Monstrosity_Renderer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Old_Netherite_Monstrosity_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Old_Netherite_Monstrosity_Layer extends FeatureRenderer<Old_Netherite_Monstrosity_Entity, Old_Netherite_Monstrosity_Model> {
    private static final Identifier NETHERITE_MONSTRISITY_LAYER_TEXTURES  = new Identifier("cataclysm:textures/entity/netherite_monstrosity_layer.png");

    public Old_Netherite_Monstrosity_Layer(Netherite_Monstrosity_Renderer renderIn) {
        super(renderIn);

    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Old_Netherite_Monstrosity_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        float f = 1.0F - entity.deactivateProgress / 40;
        f = (float) (f - MathHelper.clamp((float) entity.deathTime / 100, 0, 1.0));
        RenderLayer eyes = RenderLayer.getEyes(NETHERITE_MONSTRISITY_LAYER_TEXTURES);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
        this.getContextModel().render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV, f, f, f, f);

    }
}


