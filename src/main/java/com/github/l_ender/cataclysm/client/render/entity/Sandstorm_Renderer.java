package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Sandstorm_Model;
import com.github.l_ender.cataclysm.entity.effect.Sandstorm_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class Sandstorm_Renderer extends EntityRenderer<Sandstorm_Entity> {
    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/entity/ancient_remnant/sandstorm.png");
    private final Sandstorm_Model model = new Sandstorm_Model();

    public Sandstorm_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(Sandstorm_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.translate(0.0D, 3F, 0.0D);
        matrixStackIn.scale(-2.0F, -2.0F, 2.0F);
        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevYaw, entityIn.getYaw()) - 90.0F));
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderLayer.getEntityTranslucent(TEXTURE));
        model.setAngles(entityIn, 0, 0, entityIn.age + partialTicks, 0, 0);
        this.model.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.DEFAULT_UV);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public Identifier getTexture(Sandstorm_Entity entity) {
        return TEXTURE;
    }
}
