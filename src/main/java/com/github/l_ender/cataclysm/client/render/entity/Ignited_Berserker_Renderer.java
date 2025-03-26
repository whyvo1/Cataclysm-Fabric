package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.model.entity.Ignited_Berserker_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Ignited_Berserker_Entity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Ignited_Berserker_Renderer extends MobEntityRenderer<Ignited_Berserker_Entity, Ignited_Berserker_Model<Ignited_Berserker_Entity>> {

    private static final Identifier BERSERKER_TEXTURES = Cataclysm.modIdentifier("textures/entity/ignited_berserker.png");
    private static final Identifier BERSERKER_LAYER_TEXTURES = Cataclysm.modIdentifier("textures/entity/ignited_berserker_layer.png");

    public Ignited_Berserker_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Ignited_Berserker_Model<>(renderManagerIn.getPart(CMModelLayers.IGNITED_BERSERKER_MODEL)), 0.5F);
        this.addFeature(new Ignited_Berserker_GlowLayer(this));
    }
    @Override
    public Identifier getTexture(Ignited_Berserker_Entity entity) {
        return BERSERKER_TEXTURES;
    }

    @Override
    protected void scale(Ignited_Berserker_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.05F, 1.05F, 1.05F);
    }

    static class Ignited_Berserker_GlowLayer extends FeatureRenderer<Ignited_Berserker_Entity, Ignited_Berserker_Model<Ignited_Berserker_Entity>> {
        public Ignited_Berserker_GlowLayer(Ignited_Berserker_Renderer p_i50928_1_) {
            super(p_i50928_1_);
        }

        public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Ignited_Berserker_Entity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getFlickering(BERSERKER_LAYER_TEXTURES, 0));
            float alpha = 0.5F + (MathHelper.cos(ageInTicks * 0.2F) + 1F) * 0.2F;
            int i = ColorHelper.Argb.getArgb(MathHelper.floor(alpha * 255.0F), 255, 255, 255);
            this.getContextModel().render(matrixStackIn, ivertexbuilder, 240, LivingEntityRenderer.getOverlay(entitylivingbaseIn, 0.0F),  i);

        }
    }

}

