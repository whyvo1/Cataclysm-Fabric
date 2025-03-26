package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Abyss_Blast_Portal_Model;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Blast_Portal_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;

public class Abyss_Blast_Portal_Renderer extends EntityRenderer<Abyss_Blast_Portal_Entity> {

	private static final Identifier PORTAL = Cataclysm.modIdentifier("textures/entity/leviathan/portal/abyss_blast_portal.png");
	public Abyss_Blast_Portal_Model model;

	public Abyss_Blast_Portal_Renderer(EntityRendererFactory.Context manager)
	{
		super(manager);
		this.model = new Abyss_Blast_Portal_Model();
	}

	@Override
	protected int getBlockLight(Abyss_Blast_Portal_Entity entity, BlockPos pos)
	{
		return 15;
	}

	@Override
	public void render(Abyss_Blast_Portal_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
		matrixStackIn.push();
		float activateProgress = entityIn.prevactivateProgress + (entityIn.activateProgress - entityIn.prevactivateProgress) * partialTicks;

		float d = activateProgress * 0.15F;

		matrixStackIn.scale(-d, -d, d);
		matrixStackIn.translate(0f, -1.5F, 0F);
		matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F - entityIn.getYaw()));
		VertexConsumer vertexconsumer = bufferIn.getBuffer(this.model.getLayer(this.getTexture(entityIn)));
		this.model.setAngles(entityIn, 0.0F, 0.0F, entityIn.age + partialTicks, 0, 0);
		this.model.render(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStackIn.pop();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public Identifier getTexture(Abyss_Blast_Portal_Entity entity)
	{
		return PORTAL;
	}
}
