package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Void_Howitzer_Model;
import com.github.l_ender.cataclysm.entity.projectile.Void_Howitzer_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


@Environment(EnvType.CLIENT)
public class Void_Howitzer_Renderer extends EntityRenderer<Void_Howitzer_Entity> {

    private static final Identifier VOID_HOWITZER_TEXTURES = Cataclysm.modIdentifier("textures/entity/void_howitzer.png");
    private final Void_Howitzer_Model model = new Void_Howitzer_Model();


    public Void_Howitzer_Renderer(Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public void render(Void_Howitzer_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.scale(1.5F, 1.5F, 1.5F);
        matrixStackIn.translate(0.0D, 0.25F, 0.0D);
        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevYaw, entityIn.getYaw()) - 180.0F));
        matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevPitch, entityIn.getPitch())));
        VertexConsumer VertexConsumer = bufferIn.getBuffer(RenderLayer.getEntityTranslucent(this.getTexture(entityIn)));
        this.model.render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        
    }

    protected int getBlockLight(Void_Howitzer_Entity entityIn, BlockPos pos) {
        return 15;
    }

    @Override
    public Identifier getTexture(Void_Howitzer_Entity entity) {
        return VOID_HOWITZER_TEXTURES;
    }
}
