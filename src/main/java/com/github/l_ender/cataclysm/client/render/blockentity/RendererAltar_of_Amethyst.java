package com.github.l_ender.cataclysm.client.render.blockentity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.blockentities.AltarOfAmethyst_Block_Entity;
import com.github.l_ender.cataclysm.blocks.Altar_Of_Amethyst_Block;
import com.github.l_ender.cataclysm.client.model.block.Altar_of_Amethyst_Model;
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
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;

public class RendererAltar_of_Amethyst<T extends AltarOfAmethyst_Block_Entity> implements BlockEntityRenderer<T> {

    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/block/altar_of_amethyst.png");
    public static final Identifier BEAM_LOCATION = Identifier.ofVanilla("textures/entity/beacon_beam.png");
    private static final Altar_of_Amethyst_Model MODEL = new Altar_of_Amethyst_Model();

    public RendererAltar_of_Amethyst(Context rendererDispatcherIn) {
    }

    public boolean shouldRenderOffScreen(AltarOfAmethyst_Block_Entity p_112138_) {
        return true;
    }

    public int getRenderDistance() {
        return 256;
    }

    public boolean shouldRender(AltarOfAmethyst_Block_Entity p_173531_, Vec3d p_173532_) {
        return Vec3d.ofCenter(p_173531_.getPos()).multiply(1.0D, 0.0D, 1.0D).isInRange(p_173532_.multiply(1.0D, 0.0D, 1.0D), this.getRenderDistance());
    }

    @Override
    public void render(T tileEntityIn, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();
        Direction dir = tileEntityIn.getCachedState().get(Altar_Of_Amethyst_Block.FACING);
        if(dir == Direction.NORTH){
            matrixStackIn.translate(0.5, 1.5F, 0.5F);
        }else if(dir == Direction.EAST){
            matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        }else if(dir == Direction.SOUTH){
            matrixStackIn.translate(0.5, 1.5F, 0.5F);
        }else if(dir == Direction.WEST){
            matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        }
        matrixStackIn.multiply(dir.getOpposite().getRotationQuaternion());
        matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
        matrixStackIn.push();
        MODEL.render(matrixStackIn, bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(TEXTURE)), combinedLightIn, combinedOverlayIn);
        matrixStackIn.pop();
        matrixStackIn.pop();
        renderItem(tileEntityIn, partialTicks,matrixStackIn,bufferIn,combinedLightIn);
    }

    public void renderItem(T tileEntityIn, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int combinedLightIn) {
        ItemStack stack = tileEntityIn.getItem(0);
        float f2 = (float) tileEntityIn.tickCounts + partialTicks;
        if (!stack.isEmpty()) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 1.15F, 0.5F);

            matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f2));
            BakedModel ibakedmodel = MinecraftClient.getInstance().getItemRenderer().getModel(stack, tileEntityIn.getWorld(), null, 0);
            boolean flag = ibakedmodel.hasDepth();
            if (!flag) {
                matrixStackIn.translate(0.0F, 0.0F, 0.0F);
            }

            MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformationMode.GROUND, false, matrixStackIn, bufferIn, combinedLightIn, OverlayTexture.DEFAULT_UV, ibakedmodel);
            matrixStackIn.pop();

            if(tileEntityIn.brightThisTick && tileEntityIn.getWorld() != null){
                long i = tileEntityIn.getWorld().getTime();
                int j = 0;

                for(int k = 0; k < 6; ++k) {
                    renderBeaconBeam(matrixStackIn, bufferIn, partialTicks, i, j, 10);
                }
            }

        }
    }


    private static void renderBeaconBeam(MatrixStack p_112177_, VertexConsumerProvider p_112178_, float p_112179_, long p_112180_, int p_112181_, int p_112182_) {
        renderBeaconBeam(p_112177_, p_112178_, BEAM_LOCATION, p_112179_, 1.0F, p_112180_, p_112181_, p_112182_, 0.2F, 0.25F);
    }

    public static void renderBeaconBeam(MatrixStack p_112185_, VertexConsumerProvider p_112186_, Identifier p_112187_, float p_112188_, float p_112189_, long p_112190_, int p_112191_, int p_112192_, float p_112194_, float p_112195_) {
        int i = p_112191_ + p_112192_;
        p_112185_.push();
        p_112185_.translate(0.5D, 0.0D, 0.5D);
        float f = (float)Math.floorMod(p_112190_, 40) + p_112188_;
        float f1 = p_112192_ < 0 ? f : -f;
        float f2 = MathHelper.fractionalPart(f1 * 0.2F - (float)MathHelper.floor(f1 * 0.1F));

        p_112185_.push();
        p_112185_.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f * 2.25F - 45.0F));
        float f6 = 0.0F;
        float f8 = 0.0F;
        float f9 = -p_112194_;
        float f10 = 0.0F;
        float f11 = 0.0F;
        float f12 = -p_112194_;
        float f13 = 0.0F;
        float f14 = 1.0F;
        float f15 = -1.0F + f2;
        float f16 = (float)p_112192_ * p_112189_ * (0.5F / p_112194_) + f15;
        renderPart(p_112185_, p_112186_.getBuffer(RenderLayer.getBeaconBeam(p_112187_, false)), 1, 52, 25, 1.0F, p_112191_, i, 0.0F, p_112194_, p_112194_, 0.0F, f9, 0.0F, 0.0F, f12, 0.0F, 1.0F, f16, f15);
        p_112185_.pop();
        f6 = -p_112195_;
        float f7 = -p_112195_;
        f8 = -p_112195_;
        f9 = -p_112195_;
        f13 = 0.0F;
        f14 = 1.0F;
        f15 = -1.0F + f2;
        f16 = (float)p_112192_ * p_112189_ + f15;
        renderPart(p_112185_, p_112186_.getBuffer(RenderLayer.getBeaconBeam(p_112187_, true)), 1, 52, 25, 0.125F, p_112191_, i, f6, f7, p_112195_, f8, f9, p_112195_, p_112195_, p_112195_, 0.0F, 1.0F, f16, f15);
        p_112185_.pop();
    }

    private static void renderPart(MatrixStack p_112156_, VertexConsumer p_112157_, float p_112158_, float p_112159_, float p_112160_, float p_112161_, int p_112162_, int p_112163_, float p_112164_, float p_112165_, float p_112166_, float p_112167_, float p_112168_, float p_112169_, float p_112170_, float p_112171_, float p_112172_, float p_112173_, float p_112174_, float p_112175_) {
        MatrixStack.Entry posestack$pose = p_112156_.peek();
        renderQuad(posestack$pose, p_112157_, p_112158_, p_112159_, p_112160_, p_112161_, p_112162_, p_112163_, p_112164_, p_112165_, p_112166_, p_112167_, p_112172_, p_112173_, p_112174_, p_112175_);
        renderQuad(posestack$pose, p_112157_, p_112158_, p_112159_, p_112160_, p_112161_, p_112162_, p_112163_, p_112170_, p_112171_, p_112168_, p_112169_, p_112172_, p_112173_, p_112174_, p_112175_);
        renderQuad(posestack$pose, p_112157_, p_112158_, p_112159_, p_112160_, p_112161_, p_112162_, p_112163_, p_112166_, p_112167_, p_112170_, p_112171_, p_112172_, p_112173_, p_112174_, p_112175_);
        renderQuad(posestack$pose, p_112157_, p_112158_, p_112159_, p_112160_, p_112161_, p_112162_, p_112163_, p_112168_, p_112169_, p_112164_, p_112165_, p_112172_, p_112173_, p_112174_, p_112175_);
    }

    private static void renderQuad(MatrixStack.Entry p_324380_, VertexConsumer p_112122_, float p_112123_, float p_112124_, float p_112125_, float p_112126_, int p_112127_, int p_112128_, float p_112129_, float p_112130_, float p_112131_, float p_112132_, float p_112133_, float p_112134_, float p_112135_, float p_112136_) {
        addVertex(p_324380_, p_112122_, p_112123_, p_112124_, p_112125_, p_112126_, p_112128_, p_112129_, p_112130_, p_112134_, p_112135_);
        addVertex(p_324380_, p_112122_, p_112123_, p_112124_, p_112125_, p_112126_, p_112127_, p_112129_, p_112130_, p_112134_, p_112136_);
        addVertex(p_324380_, p_112122_, p_112123_, p_112124_, p_112125_, p_112126_, p_112127_, p_112131_, p_112132_, p_112133_, p_112136_);
        addVertex(p_324380_, p_112122_, p_112123_, p_112124_, p_112125_, p_112126_, p_112128_, p_112131_, p_112132_, p_112133_, p_112135_);
    }

    private static void addVertex(MatrixStack.Entry p_324380_, VertexConsumer p_253894_, float p_253871_, float p_253841_, float p_254568_, float p_254361_, int p_254357_, float p_254451_, float p_254240_, float p_254117_, float p_253698_) {
        p_253894_.vertex(p_324380_, p_254451_, (float)p_254357_, p_254240_).color(p_253871_, p_253841_, p_254568_, p_254361_).texture(p_254117_, p_253698_).overlay(OverlayTexture.DEFAULT_UV).light(15728880).normal(p_324380_, 0.0F, 1.0F, 0.0F);
    }


}


