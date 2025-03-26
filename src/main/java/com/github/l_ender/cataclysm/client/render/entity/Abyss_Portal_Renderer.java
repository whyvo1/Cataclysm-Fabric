package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Portal_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class Abyss_Portal_Renderer extends EntityRenderer<Abyss_Portal_Entity> {
    private static final Identifier TEXTURE_0 = Cataclysm.modIdentifier("textures/entity/leviathan/portal/abyss_portal_idle_0.png");
    private static final Identifier TEXTURE_1 = Cataclysm.modIdentifier("textures/entity/leviathan/portal/abyss_portal_idle_1.png");
    private static final Identifier TEXTURE_2 = Cataclysm.modIdentifier("textures/entity/leviathan/portal/abyss_portal_idle_2.png");
    private static final Identifier TEXTURE_3 = Cataclysm.modIdentifier("textures/entity/leviathan/portal/abyss_portal_idle_3.png");
    private static final Identifier[] TEXTURE_PROGRESS =  new Identifier[8];

    private static final Identifier[] TEXTURE_IDLE =  new Identifier[4];

    public Abyss_Portal_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn);
        for(int i = 0; i < 8; i++){
            TEXTURE_PROGRESS[i] = Cataclysm.modIdentifier("textures/entity/leviathan/portal/abyss_portal_grow_" + i + ".png");
        }
        for(int i = 0; i < 4; i++){
            TEXTURE_IDLE[i] = Cataclysm.modIdentifier("textures/entity/leviathan/portal/abyss_portal_idle_" + i + ".png");
        }

    }

    public void render(Abyss_Portal_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.translate(0f, 0.01f, 0f);
        matrixStackIn.scale(4F, 4F, 4F);
        renderPortal(entityIn, matrixStackIn, bufferIn, false);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    private void renderPortal(Abyss_Portal_Entity entityIn, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, boolean shattered){
        Identifier tex;
        if(entityIn.getLifespan() < 20){
            tex = getGrowingTexture((int) ((entityIn.getLifespan() * 0.5F) % 20));
        }else if(entityIn.age < 20){
            tex = getGrowingTexture((int) ((entityIn.age * 0.5F) % 20));
        }else{
            tex = getIdleTexture((int) ((entityIn.age * 0.35F) % 3));
        }
        VertexConsumer ivertexbuilder =  bufferIn.getBuffer(CMRenderTypes.getfullBright(tex));
        renderArc(matrixStackIn, ivertexbuilder);
    }
    private void renderArc(MatrixStack matrixStackIn, VertexConsumer ivertexbuilder) {
        matrixStackIn.push();
        MatrixStack.Entry lvt_19_1_ = matrixStackIn.peek();
        this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
        this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
        this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
        this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
        matrixStackIn.pop();
    }
    @Override
    public Identifier getTexture(Abyss_Portal_Entity entity) {
        return TEXTURE_0;
    }


    public void drawVertex(MatrixStack.Entry p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.vertex(p_229039_2_, (float) p_229039_4_, (float) p_229039_5_, (float) p_229039_6_).color(255, 255, 255, 255).texture(p_229039_7_, p_229039_8_).overlay(OverlayTexture.DEFAULT_UV).light(p_229039_12_).normal(p_229039_2_, (float) p_229039_9_, (float) p_229039_11_, (float) p_229039_10_);
    }

    public Identifier getIdleTexture(int age) {
        return TEXTURE_IDLE[MathHelper.clamp(age, 0, 3)];
    }


    public Identifier getGrowingTexture(int age) {
        return TEXTURE_PROGRESS[MathHelper.clamp(age, 0, 7)];
    }
}
