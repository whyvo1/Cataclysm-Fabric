package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Coral_Spear_Model;
import com.github.l_ender.cataclysm.entity.projectile.ThrownCoral_Spear_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


@Environment(EnvType.CLIENT)
public class Thrown_Coral_Spear_Renderer extends EntityRenderer<ThrownCoral_Spear_Entity> {

    private static final Identifier VOID_HOWITZER_TEXTURES = Cataclysm.modIdentifier("textures/entity/coral_spear.png");
    private final Coral_Spear_Model model = new Coral_Spear_Model();


    public Thrown_Coral_Spear_Renderer(Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public void render(ThrownCoral_Spear_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevYaw, entityIn.getYaw()) - 90.0F));
        matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevPitch, entityIn.getPitch()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getDirectItemGlintConsumer(bufferIn, this.model.getLayer(this.getTexture(entityIn)), false, entityIn.isFoil());
        this.model.render(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        
    }

    @Override
    public Identifier getTexture(ThrownCoral_Spear_Entity entity) {
        return VOID_HOWITZER_TEXTURES;
    }
}
