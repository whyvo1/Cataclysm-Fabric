package com.github.l_ender.cataclysm.client.render.blockentity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.block.Altar_of_Fire_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory.Context;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import com.github.l_ender.cataclysm.blockentities.AltarOfFire_Block_Entity;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class RendererAltar_of_Fire<T extends AltarOfFire_Block_Entity> implements BlockEntityRenderer<T> {

    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/block/altar_of_fire/altar_of_fire.png");
    private static final Identifier[] TEXTURE_FIRE_PROGRESS = new Identifier[8];
    public static final Identifier FLAME_STRIKE = Cataclysm.modIdentifier("textures/entity/flame_strike_sigil.png");
    private static final Altar_of_Fire_Model MODEL = new Altar_of_Fire_Model();

    public RendererAltar_of_Fire(Context rendererDispatcherIn) {
        for(int i = 0; i < 8; i++){
            TEXTURE_FIRE_PROGRESS[i] = Cataclysm.modIdentifier("textures/block/altar_of_fire/altarfire_" + i + ".png");
        }
    }

    @Override
    public void render(T tileEntityIn, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int combinedLightIn, int combinedOverlayIn) {
        float f2 = (float) tileEntityIn.tickCount + partialTicks;
        matrixStackIn.push();
        matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        matrixStackIn.scale(1.0F, -1.0F, -1.0F);
        MODEL.animate(tileEntityIn, partialTicks);
        MODEL.render(matrixStackIn, bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(TEXTURE)), combinedLightIn, combinedOverlayIn, 1, 1F, 1, 1);
        MODEL.render(matrixStackIn, bufferIn.getBuffer(CMRenderTypes.getGlowingEffect(getIdleTexture((int) ((f2 * 0.5F) % 7)))), 210, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        matrixStackIn.pop();
        renderItem(tileEntityIn, partialTicks,matrixStackIn,bufferIn,combinedLightIn);
        renderSigil(tileEntityIn,partialTicks,matrixStackIn,bufferIn);
    }

    private Identifier getIdleTexture(int age) {
        return TEXTURE_FIRE_PROGRESS[MathHelper.clamp(age, 0, 7)];
    }

    public void renderItem(T tileEntityIn, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int combinedLightIn) {
        ItemStack stack = tileEntityIn.getStack(0);
        float f2 = (float) tileEntityIn.tickCount + partialTicks;
        if (!stack.isEmpty()) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 1.0F, 0.5F);

            matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f2));
            BakedModel ibakedmodel = MinecraftClient.getInstance().getItemRenderer().getModel(stack, tileEntityIn.getWorld(), null, 0);
            boolean flag = ibakedmodel.hasDepth();
            if (!flag) {
                matrixStackIn.translate(0.0F, 0.0F, 0.0F);
            }
            MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformationMode.GROUND, false, matrixStackIn, bufferIn, combinedLightIn, OverlayTexture.DEFAULT_UV, ibakedmodel);
            matrixStackIn.pop();
        }
    }

    public void renderSigil(T tileEntityIn, float delta, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn) {
        if(tileEntityIn.summoningthis) {
            float f2 = (float) tileEntityIn.tickCount + delta;
            float f3 = MathHelper.clamp(tileEntityIn.summoningticks, 0, 25);
            matrixStackIn.push();
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getGlowingEffect(FLAME_STRIKE));
            matrixStackIn.translate(0.5D, 0.001D, 0.5D);
            matrixStackIn.scale(f3 * 0.1f, f3 * 0.1f, f3 * 0.1f);
            matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F + f2));
            MatrixStack.Entry lvt_19_1_ = matrixStackIn.peek();
            Matrix4f lvt_20_1_ = lvt_19_1_.getPositionMatrix();
            Matrix3f lvt_21_1_ = lvt_19_1_.getNormalMatrix();
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
            matrixStackIn.pop();
        }
    }

    public void drawVertex(Matrix4f p_229039_1_, Matrix3f p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.vertex(p_229039_1_, (float) p_229039_4_, (float) p_229039_5_, (float) p_229039_6_).color(255, 255, 255, 255).texture(p_229039_7_, p_229039_8_).overlay(OverlayTexture.DEFAULT_UV).light(p_229039_12_).normal(p_229039_2_, (float) p_229039_9_, (float) p_229039_11_, (float) p_229039_10_).next();
    }
}


