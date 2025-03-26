package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Axe_Blade_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.entity.projectile.Axe_Blade_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Axe_Blade_Renderer extends EntityRenderer<Axe_Blade_Entity>
{
    private static final Identifier[] TEXTURE_PROGRESS = new Identifier[5];

    public Axe_Blade_Model model;

    public Axe_Blade_Renderer(EntityRendererFactory.Context manager)
    {
        super(manager);
        this.model = new Axe_Blade_Model();
        for(int i = 0; i < 5; i++){
            TEXTURE_PROGRESS[i] = Cataclysm.modIdentifier("textures/entity/draugar/axe_blade_" + i + ".png");
        }
    }

    @Override
    protected int getBlockLight(Axe_Blade_Entity entity, BlockPos pos)
    {
        return 15;
    }

    @Override
    public void render(Axe_Blade_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        matrixStackIn.translate(0, 0F, 0);
        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(entityIn.getYaw() + 180));
        VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getGhost(this.getTexture(entityIn)));
        model.setAngles(entityIn, 0, 0, entityIn.age + partialTicks, 0, 0);
        float hide = ((float) entityIn.getTransparency() / 80);
        float alpha = (1F - hide) ;
        this.model.render(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, MathHelper.clamp(alpha, 0, 1));
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public Identifier getTexture(Axe_Blade_Entity entity)
    {
        return getGrowingTexture(entity,(int) ((entity.age * 0.5F) % 4));
    }

    public Identifier getGrowingTexture(Axe_Blade_Entity entity, int age) {
        return  TEXTURE_PROGRESS[MathHelper.clamp(age, 0, 4)];
    }

}
