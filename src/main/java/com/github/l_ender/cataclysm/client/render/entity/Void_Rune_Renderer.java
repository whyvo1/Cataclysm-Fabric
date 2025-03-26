package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Void_Rune_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.entity.projectile.Void_Rune_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.Random;

@Environment(EnvType.CLIENT)
public class Void_Rune_Renderer extends EntityRenderer<Void_Rune_Entity> {
    private static final Identifier VOID_RUNE = Cataclysm.modIdentifier("textures/entity/void_rune.png");
    private final Void_Rune_Model model = new Void_Rune_Model();
    private final Random rnd = new Random();

    public Void_Rune_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(Void_Rune_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {

        matrixStackIn.push();
        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F - entityIn.getYaw()));
        matrixStackIn.translate(0.0D, 3F, 0.0D);
        matrixStackIn.scale(-2.0F, -2.0F, 2.0F);
        VertexConsumer vertexConsumer = bufferIn.getBuffer(CMRenderTypes.getBright(this.getTexture(entityIn)));
        model.setAngles(entityIn, 0, 0, entityIn.age + partialTicks, 0, 0);
        this.model.render(matrixStackIn, vertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

    }

    public Vec3d getRenderOffset(Void_Rune_Entity entityIn, float partialTicks) {
        if (entityIn.activateProgress == 10) {
            return super.getPositionOffset(entityIn, partialTicks);
        } else {
            double d0 = 0.02D;
            return new Vec3d(this.rnd.nextGaussian() * d0, 0.0D, this.rnd.nextGaussian() * d0);
        }
    }

    protected int getBlockLight(Void_Rune_Entity entityIn, BlockPos pos) {
        return 15;
    }

    /**
     * Returns the location of an entity's texture.
     */
    public Identifier getTexture(Void_Rune_Entity entity) {
        return VOID_RUNE;
    }
}
