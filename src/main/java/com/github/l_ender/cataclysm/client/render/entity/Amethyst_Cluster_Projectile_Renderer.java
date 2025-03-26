package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Amethyst_Cluster_Projectile_Model;
import com.github.l_ender.cataclysm.entity.projectile.Amethyst_Cluster_Projectile_Entity;
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
public class Amethyst_Cluster_Projectile_Renderer extends EntityRenderer<Amethyst_Cluster_Projectile_Entity> {

    private static final Identifier WITHER_HOWITZER_TEXTURES = Cataclysm.modIdentifier("textures/entity/amethyst_cluster_projectile.png");
    private final Amethyst_Cluster_Projectile_Model model = new Amethyst_Cluster_Projectile_Model();


    public Amethyst_Cluster_Projectile_Renderer(Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public void render(Amethyst_Cluster_Projectile_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevYaw, entityIn.getYaw()) - 90.0F));
        matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevPitch, entityIn.getPitch()) + 90.0F));
        VertexConsumer VertexConsumer = bufferIn.getBuffer(RenderLayer.getEntityTranslucent(this.getTexture(entityIn)));
        this.model.render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        
    }

    protected int getBlockLight(Amethyst_Cluster_Projectile_Entity entityIn, BlockPos pos) {
        return 15;
    }

    @Override
    public Identifier getTexture(Amethyst_Cluster_Projectile_Entity entity) {
        return WITHER_HOWITZER_TEXTURES;
    }
}
