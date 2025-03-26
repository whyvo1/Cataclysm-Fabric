package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Ignited_Revenant_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.client.render.layer.Revenant_Layer;

import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Ignited_Revenant_Renderer extends MobEntityRenderer<Ignited_Revenant_Entity, Ignited_Revenant_Model> {

    private static final Identifier IGNITED_REVENANT_TEXTURES = Cataclysm.modIdentifier("textures/entity/revenant_body.png");
    private static final Identifier IGNITED_REVENANT_LAYER_TEXTURES = Cataclysm.modIdentifier("textures/entity/revenant_layer.png");
    private final Random rnd = Random.create();

    public Ignited_Revenant_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Ignited_Revenant_Model(), 0.5F);
        this.addFeature(new Ignited_Revenant_GlowLayer(this));
        this.addFeature(new Revenant_Layer(this));

    }
    @Override
    public Identifier getTexture(Ignited_Revenant_Entity entity) {
        return IGNITED_REVENANT_TEXTURES;
    }

    @Override
    protected void scale(Ignited_Revenant_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.1F, 1.1F, 1.1F);
    }

    public Vec3d getRenderOffset(Ignited_Revenant_Entity entityIn, float partialTicks) {
        if (entityIn.getAnimation() == Ignited_Revenant_Entity.ASH_BREATH_ATTACK && entityIn.getAnimationTick() >= 28 && entityIn.getAnimationTick() <= 43) {
            double d0 = 0.02D;
            return new Vec3d(this.rnd.nextGaussian() * d0, 0.0D, this.rnd.nextGaussian() * d0);
        } else {
            return super.getPositionOffset(entityIn, partialTicks);
        }
    }

    static class Ignited_Revenant_GlowLayer extends FeatureRenderer<Ignited_Revenant_Entity, Ignited_Revenant_Model> {
        public Ignited_Revenant_GlowLayer(Ignited_Revenant_Renderer p_i50928_1_) {
            super(p_i50928_1_);
        }

        public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Ignited_Revenant_Entity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getFlickering(IGNITED_REVENANT_LAYER_TEXTURES, 0));
            float alpha = 0.5F + (MathHelper.cos(ageInTicks * 0.2F) + 1F) * 0.2F;
            int i = ColorHelper.Argb.getArgb(MathHelper.floor(alpha * 255.0F), 255, 255, 255);
            this.getContextModel().render(matrixStackIn, ivertexbuilder, 240, LivingEntityRenderer.getOverlay(entitylivingbaseIn, 0.0F), i);
        }
    }

}
