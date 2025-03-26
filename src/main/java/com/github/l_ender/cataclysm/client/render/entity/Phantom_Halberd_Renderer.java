package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Phantom_Halberd_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.entity.projectile.Phantom_Halberd_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Phantom_Halberd_Renderer extends EntityRenderer<Phantom_Halberd_Entity> {
    private static final Identifier PHANTOM_HALBERD = Cataclysm.modIdentifier("textures/entity/maledictus/phantom_halberd.png");
    private static final Identifier PHANTOM_HALBERD_DISCARD = Cataclysm.modIdentifier("textures/entity/maledictus/phantom_halberd_discard.png");
    private final Phantom_Halberd_Model model = new Phantom_Halberd_Model();
    private static final RenderLayer DECAL = RenderLayer.getEntityDecal(PHANTOM_HALBERD);
    private static final RenderLayer RENDER_TYPE = RenderLayer.getEntityCutoutNoCull(PHANTOM_HALBERD);
    public Phantom_Halberd_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(Phantom_Halberd_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {

        matrixStackIn.push();
        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F - entityIn.getYaw()));
        matrixStackIn.translate(0.0D, 1.0F, 0.0D);
        matrixStackIn.scale(-0.8F, -0.8F, 0.8F);
        VertexConsumer vertexConsumer = bufferIn.getBuffer(CMRenderTypes.getGhost(this.getTexture(entityIn)));
        model.setAngles(entityIn, 0, 0, entityIn.age + partialTicks, 0, 0);
        if (entityIn.lifeTicks > 0) {
            float f2 = (float)entityIn.lifeTicks / 70F;
            VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.DragonDeath(PHANTOM_HALBERD_DISCARD));
            this.model.render(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, f2);
            VertexConsumer vertexconsumer1 = bufferIn.getBuffer(DECAL);
            this.model.render(matrixStackIn, vertexconsumer1, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        } else {
            VertexConsumer vertexconsumer3 = bufferIn.getBuffer(RENDER_TYPE);
            this.model.render(matrixStackIn, vertexconsumer3, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        }

        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

    }
    protected int getBlockLight(Phantom_Halberd_Entity entityIn, BlockPos pos) {
        return 15;
    }

    /**
     * Returns the location of an entity's texture.
     */
    public Identifier getTexture(Phantom_Halberd_Entity entity) {
        return PHANTOM_HALBERD;
    }
}
