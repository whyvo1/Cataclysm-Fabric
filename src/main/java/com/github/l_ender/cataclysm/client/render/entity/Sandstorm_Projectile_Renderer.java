package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Sandstorm_Projectile_Model;
import com.github.l_ender.cataclysm.entity.projectile.Sandstorm_Projectile;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Sandstorm_Projectile_Renderer extends EntityRenderer<Sandstorm_Projectile>
{
	private static final Identifier SANDSTORM = Cataclysm.modIdentifier("textures/entity/koboleton/sandstorm.png");

	public Sandstorm_Projectile_Model model;

	public Sandstorm_Projectile_Renderer(EntityRendererFactory.Context manager) {
		super(manager);
		this.model = new Sandstorm_Projectile_Model();
	}

	@Override
	public void render(Sandstorm_Projectile entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
		matrixStackIn.push();
		matrixStackIn.scale(-0.5F, -0.5F, 0.5F);
		matrixStackIn.translate(0F, -1.5F, 0F);
		float f = MathHelper.lerpAngleDegrees(partialTicks, entityIn.prevYaw, entityIn.getYaw());
		float f1 = MathHelper.lerp(partialTicks, entityIn.prevPitch, entityIn.getPitch());
		VertexConsumer vertexconsumer = bufferIn.getBuffer(this.model.getLayer(this.getTexture(entityIn)));
		this.model.setAngles(entityIn, 0.0F, 0.0F,entityIn.age + partialTicks, f, f1);
		this.model.render(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStackIn.pop();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public Identifier getTexture(Sandstorm_Projectile entity)
	{
		return SANDSTORM;
	}
}