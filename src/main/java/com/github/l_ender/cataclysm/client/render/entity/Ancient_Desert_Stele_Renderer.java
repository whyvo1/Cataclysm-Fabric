package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Ancient_Desert_Stele_Model;
import com.github.l_ender.cataclysm.entity.projectile.Ancient_Desert_Stele_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Ancient_Desert_Stele_Renderer extends EntityRenderer<Ancient_Desert_Stele_Entity> {
    private static final Identifier ANCIENT_DESERT_STELE = Cataclysm.modIdentifier("textures/entity/ancient_desert_stele.png");
    private final Ancient_Desert_Stele_Model model = new Ancient_Desert_Stele_Model();

    public Ancient_Desert_Stele_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(Ancient_Desert_Stele_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F - entityIn.getYaw()));
        matrixStackIn.translate(0.0D, 1.5F, 0.0D);
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        VertexConsumer vertexconsumer = bufferIn.getBuffer(this.model.getLayer(this.getTexture(entityIn)));
        this.model.render(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public Identifier getTexture(Ancient_Desert_Stele_Entity entity) {
        return ANCIENT_DESERT_STELE;
    }
}
