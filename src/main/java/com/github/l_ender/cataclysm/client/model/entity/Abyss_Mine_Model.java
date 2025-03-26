package com.github.l_ender.cataclysm.client.model.entity;


import com.github.l_ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.l_ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.l_ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.entity.Entity;

public class Abyss_Mine_Model extends AdvancedEntityModel<Entity> {
	public final AdvancedModelBox root;
	public final AdvancedModelBox glass;
	public final AdvancedModelBox glass2;

	public Abyss_Mine_Model() {
		texWidth = 32;
		texHeight = 32;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);

		glass = new AdvancedModelBox(this);
		glass.setRotationPoint(0.0F, 0.0F, 0.0F);
		glass.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);

		glass2 = new AdvancedModelBox(this);
		glass2.setRotationPoint(0.0F, 0.0F, 0.0F);
		glass2.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);


	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root,glass,glass2);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root,glass,glass2);
	}

	@Override
	public void setAngles(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.root.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.root.rotateAngleX = headPitch * ((float) Math.PI / 180F);
	}

}