package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Netherite_Ministrosity_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.client.render.entity.Netherite_Ministrosity_Renderer;
import com.github.l_ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;


public class Netherite_Ministrosity_Layer extends FeatureRenderer<Netherite_Ministrosity_Entity, Netherite_Ministrosity_Model> {
    private static final Identifier NETHERITE_MONSTRISITY_LAYER_TEXTURES  = Cataclysm.modIdentifier("textures/entity/monstrosity/netherite_ministrosity_layer.png");

    public Netherite_Ministrosity_Layer(Netherite_Ministrosity_Renderer renderIn) {
        super(renderIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Netherite_Ministrosity_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {


        RenderLayer eyes = CMRenderTypes.CMEyes(NETHERITE_MONSTRISITY_LAYER_TEXTURES);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);

        float strength = 0.5F + MathHelper.clamp(((float) Math.cos((entity.LayerTicks + partialTicks) * 0.1F)) - 0.25F, -0.25F, 0.5F);

        if(!entity.getIsAwaken()){
            strength = 0F;
        }

        strength += MathHelper.lerp(partialTicks, entity.oLayerBrightness, entity.LayerBrightness) * 1 * MathHelper.PI;
        strength = MathHelper.clamp(strength, 0.25f, 1.0F);
        int i = ColorHelper.Argb.getArgb((int) (255 * strength), (int) (255 * strength), (int) (255 * strength), 255);
        this.getContextModel().render(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.DEFAULT_UV, i);


    }
}


