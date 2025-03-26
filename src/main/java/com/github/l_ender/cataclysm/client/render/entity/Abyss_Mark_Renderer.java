package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.entity.effect.Abyss_Mark_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Abyss_Mark_Renderer extends EntityRenderer<Abyss_Mark_Entity> {
    public static final Identifier ABYSS_MARK1 = Cataclysm.modIdentifier("textures/entity/deepling/deepling_warlock_mark1.png");
    public static final Identifier ABYSS_MARK2 = Cataclysm.modIdentifier("textures/entity/deepling/deepling_warlock_mark2.png");
    public Abyss_Mark_Renderer(EntityRendererFactory.Context mgr) {
        super(mgr);
    }

    @Override
    public Identifier getTexture(Abyss_Mark_Entity entity) {
        float f = entity.getLifespan();

        return f > -1 && f / 5 % 2 == 0 ? ABYSS_MARK2 : ABYSS_MARK1;
    }

    @Override
    public void render(Abyss_Mark_Entity flameStrike, float entityYaw, float delta, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        matrixStackIn.push();
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getGlowingEffect(this.getTexture(flameStrike)));
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
        matrixStackIn.translate(0.0D, 0.001D, 0.0D);
        MatrixStack.Entry lvt_19_1_ = matrixStackIn.peek();
        this.drawVertex( lvt_19_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
        this.drawVertex( lvt_19_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
        this.drawVertex( lvt_19_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
        this.drawVertex( lvt_19_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
        matrixStackIn.pop();
        super.render(flameStrike, entityYaw, delta, matrixStackIn, bufferIn, packedLightIn);
    }


    public void drawVertex(MatrixStack.Entry p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.vertex(p_229039_2_, (float) p_229039_4_, (float) p_229039_5_, (float) p_229039_6_).color(255, 255, 255, 255).texture(p_229039_7_, p_229039_8_).overlay(OverlayTexture.DEFAULT_UV).light(p_229039_12_).normal(p_229039_2_, (float) p_229039_9_, (float) p_229039_11_, (float) p_229039_10_);
    }
}
