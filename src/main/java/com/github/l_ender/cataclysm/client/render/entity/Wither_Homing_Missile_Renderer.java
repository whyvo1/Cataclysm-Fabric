package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Wither_Homing_Missile_Model;
import com.github.l_ender.cataclysm.entity.projectile.Wither_Homing_Missile_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Wither_Homing_Missile_Renderer extends EntityRenderer<Wither_Homing_Missile_Entity>
{
    private static final Identifier WITHER_MISSILE = Cataclysm.modIdentifier("textures/entity/harbinger/wither_homing_missile.png");

    public Wither_Homing_Missile_Model model;

    public Wither_Homing_Missile_Renderer(EntityRendererFactory.Context manager)
    {
        super(manager);
        this.model = new Wither_Homing_Missile_Model();
    }

    @Override
    protected int getBlockLight(Wither_Homing_Missile_Entity entity, BlockPos pos)
    {
        return 15;
    }

    @Override
    public void render(Wither_Homing_Missile_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.scale(-1.5F, -1.5F, 1.5F);
        matrixStackIn.translate(0F, 0.04F, 0F);
        float f = MathHelper.lerpAngleDegrees(partialTicks, entityIn.prevYaw, entityIn.getYaw());
        float f1 = MathHelper.lerp(partialTicks, entityIn.prevPitch, entityIn.getPitch());
        VertexConsumer vertexconsumer = bufferIn.getBuffer(this.model.getLayer(this.getTexture(entityIn)));
        this.model.setAngles(entityIn, 0.0F, 0.0F, 0.0F, f, f1);
        this.model.render(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.DEFAULT_UV);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public Identifier getTexture(Wither_Homing_Missile_Entity entity)
    {
        return WITHER_MISSILE;
    }
}
