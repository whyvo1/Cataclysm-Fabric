package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Cursed_Sandstorm_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.entity.projectile.Cursed_Sandstorm_Entity;
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
public class Cursed_Sandstorm_Renderer extends EntityRenderer<Cursed_Sandstorm_Entity>
{
	private static final Identifier SANDSTORM = Cataclysm.modIdentifier("textures/entity/cursed_sandstorm.png");

	public Cursed_Sandstorm_Model model;

	public Cursed_Sandstorm_Renderer(EntityRendererFactory.Context manager) {
		super(manager);
		this.model = new Cursed_Sandstorm_Model();
	}

	@Override
	public void render(Cursed_Sandstorm_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
		matrixStackIn.push();
		matrixStackIn.scale(-0.5F, -0.5F, 0.5F);
		matrixStackIn.translate(0F, -1.5F, 0F);
		float f = MathHelper.lerpAngleDegrees(partialTicks, entityIn.prevYaw, entityIn.getYaw());
		float f1 = MathHelper.lerp(partialTicks, entityIn.prevPitch, entityIn.getPitch());
		VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getGhost(this.getTexture(entityIn)));
		this.model.setAngles(entityIn, 0.0F, 0.0F,entityIn.age + partialTicks, f, f1);
		this.model.render(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 0.6f);
		matrixStackIn.pop();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public Identifier getTexture(Cursed_Sandstorm_Entity entity)
	{
		return SANDSTORM;
	}
}