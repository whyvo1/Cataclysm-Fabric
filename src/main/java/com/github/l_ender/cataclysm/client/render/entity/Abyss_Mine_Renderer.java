package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Abyss_Mine_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Mine_Entity;
import net.minecraft.client.render.OverlayTexture;
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
import org.joml.Quaternionf;

@Environment(EnvType.CLIENT)
public class Abyss_Mine_Renderer extends EntityRenderer<Abyss_Mine_Entity>
{
	private static final Identifier ABYSS_MINE_TEXTURE = Cataclysm.modIdentifier("textures/entity/leviathan/abyss_mine.png");
	private static final float SIN_45 = (float)Math.sin((Math.PI / 4D));
	public Abyss_Mine_Model model;

	public Abyss_Mine_Renderer(EntityRendererFactory.Context manager)
	{
		super(manager);
		this.model = new Abyss_Mine_Model();
	}
	
	@Override
	protected int getBlockLight(Abyss_Mine_Entity entity, BlockPos pos)
	{
		return 15;
	}

	public void render(Abyss_Mine_Entity p_114162_, float p_114163_, float p_114164_, MatrixStack p_114165_, VertexConsumerProvider p_114166_, int p_114167_) {
		p_114165_.push();
		float f1 = ((float)p_114162_.time + p_114164_) * 3.0F;

		float activateProgress = p_114162_.prevactivateProgress + (p_114162_.activateProgress - p_114162_.prevactivateProgress) * p_114164_;

		float d = activateProgress * 0.0875F;
		float e = activateProgress * 0.2F;
		VertexConsumer vertexconsumer = p_114166_.getBuffer(CMRenderTypes.getfullBright(ABYSS_MINE_TEXTURE));
		p_114165_.push();
		p_114165_.scale(e, e, e);
		p_114165_.translate(0.0D, -0.5D, 0.0D);
		int i = OverlayTexture.DEFAULT_UV;
		p_114165_.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f1));
		p_114165_.translate(0.0D, 0.75D, 0.0D);
		p_114165_.multiply((new Quaternionf()).setAngleAxis(((float)Math.PI / 3F), SIN_45, 0.0F, SIN_45));
		this.model.glass.render(p_114165_, vertexconsumer, p_114167_, i);
		float f2 = 0.875F;
		p_114165_.scale(d, d, d);
		p_114165_.multiply((new Quaternionf()).setAngleAxis(((float)Math.PI / 3F), SIN_45, 0.0F, SIN_45));
		p_114165_.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f1));
		this.model.glass2.render(p_114165_, vertexconsumer, p_114167_, i);
		p_114165_.scale(d, d, d);
		p_114165_.multiply((new Quaternionf()).setAngleAxis(((float)Math.PI / 3F), SIN_45, 0.0F, SIN_45));
		p_114165_.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f1));
		this.model.root.render(p_114165_, vertexconsumer, p_114167_, i);
		p_114165_.pop();
		p_114165_.pop();

		super.render(p_114162_, p_114163_, p_114164_, p_114165_, p_114166_, p_114167_);
	}

	@Override
	public Identifier getTexture(Abyss_Mine_Entity entity)
	{
		return ABYSS_MINE_TEXTURE;
	}

}