package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.entity.effect.Void_Vortex_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Void_Vortex_Renderer extends EntityRenderer<Void_Vortex_Entity> {
    private static final Identifier TEXTURE_1 = Cataclysm.modIdentifier("textures/entity/void_vortex/void_vortex_idle1.png");
    private static final Identifier TEXTURE_2 = Cataclysm.modIdentifier("textures/entity/void_vortex/void_vortex_idle2.png");
    private static final Identifier TEXTURE_3 = Cataclysm.modIdentifier("textures/entity/void_vortex/void_vortex_idle3.png");
    private static final Identifier TEXTURE_4 = Cataclysm.modIdentifier("textures/entity/void_vortex/void_vortex_idle4.png");
    private static final Identifier[] TEXTURE_PROGRESS = new Identifier[4];


    public Void_Vortex_Renderer(EntityRendererFactory.Context mgr) {
        super(mgr);
        for(int i = 0; i < 4; i++) {
            TEXTURE_PROGRESS[i] = Cataclysm.modIdentifier("textures/entity/void_vortex/void_vortex_grow_" + i + ".png");
        }
    }

    public void render(Void_Vortex_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.translate(0.0D, 0.001D, 0.0D);
        Identifier tex;
        if(entityIn.getLifespan() < 16){
            tex = getGrowingTexture((int) ((entityIn.getLifespan() * 0.5F) % 20));
        }else if(entityIn.age < 16){
            tex = getGrowingTexture((int) ((entityIn.age * 0.5F) % 20));
        }else{
            tex = getIdleTexture(entityIn.age % 9);
        }
        matrixStackIn.scale(3, 3, 3);
        renderArc(matrixStackIn, bufferIn, tex);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    private void renderArc(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, Identifier res) {
        matrixStackIn.push();
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getfullBright(res));
        MatrixStack.Entry lvt_19_1_ = matrixStackIn.peek();
        this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
        this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
        this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
        this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
        matrixStackIn.pop();
    }

    @Override
    public Identifier getTexture(Void_Vortex_Entity entity) {
        return TEXTURE_1;
    }


    public void drawVertex(MatrixStack.Entry p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.vertex(p_229039_2_, (float) p_229039_4_, (float) p_229039_5_, (float) p_229039_6_).color(255, 255, 255, 255).texture(p_229039_7_, p_229039_8_).overlay(OverlayTexture.DEFAULT_UV).light(p_229039_12_).normal(p_229039_2_, (float) p_229039_9_, (float) p_229039_11_, (float) p_229039_10_);
    }

    public Identifier getIdleTexture(int age) {
        if (age < 3) {
            return TEXTURE_1;
        } else if (age < 6) {
            return TEXTURE_2;
        } else if (age < 10) {
            return TEXTURE_3;
        } else {
            return TEXTURE_4;
        }
    }

    public Identifier getGrowingTexture(int age) {
        return TEXTURE_PROGRESS[MathHelper.clamp(age/2, 0, 3)];
    }
}
