package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Ignis_Fireball_Model;
import com.github.l_ender.cataclysm.entity.projectile.Ignis_Abyss_Fireball_Entity;
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
public class Ignis_Abyss_Fireball_Renderer extends EntityRenderer<Ignis_Abyss_Fireball_Entity>
{
	private static final Identifier IGNIS_FIRE_BALL = Cataclysm.modIdentifier("textures/entity/ignis_fireball_abyss.png");

	public Ignis_Fireball_Model model;

	public Ignis_Abyss_Fireball_Renderer(EntityRendererFactory.Context manager)
	{
		super(manager);
		this.model = new Ignis_Fireball_Model();
	}
	
	@Override
	protected int getBlockLight(Ignis_Abyss_Fireball_Entity entity, BlockPos pos)
	{
		return 15;
	}

	@Override
	public void render(Ignis_Abyss_Fireball_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn)
	{
		matrixStackIn.push();
		float f = rotLerp(entityIn.prevYaw, entityIn.getYaw(), partialTicks);
		float f1 = MathHelper.lerp(partialTicks, entityIn.prevPitch, entityIn.getPitch());
		float f2 = (float) entityIn.age + partialTicks;
		matrixStackIn.translate(0.0D, 0.3F, 0.0D);
		matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.sin(f2 * 0.1F) * 180.0F));
		matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(MathHelper.cos(f2 * 0.1F) * 180.0F));
		matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.sin(f2 * 0.15F) * 360.0F));
		this.model.setAngles(entityIn, 0.0F, 0.0F, 0.0F, f, f1);
		VertexConsumer VertexConsumer = bufferIn.getBuffer(this.model.getLayer(getTexture(entityIn)));
		this.model.render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStackIn.pop();

		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public Identifier getTexture(Ignis_Abyss_Fireball_Entity entity)
	{
		return  IGNIS_FIRE_BALL;
	}

	
	/**
	 * A helper method to do some Math Magic
	 */
	private float rotLerp(float prevRotation, float rotation, float partialTicks)
	{
		float f;
		for(f = rotation - prevRotation; f < -180.0F; f += 360.0F)
		{
		}

		while(f >= 180.0F)
		{
			f -= 360.0F;
		}

		return prevRotation + partialTicks * f;
	}
}