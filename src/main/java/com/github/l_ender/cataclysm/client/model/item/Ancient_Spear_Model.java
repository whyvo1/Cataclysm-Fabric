package com.github.l_ender.cataclysm.client.model.item;// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.github.l_ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.l_ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.l_ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.entity.Entity;

public class Ancient_Spear_Model extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;

	public Ancient_Spear_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		root.setTextureOffset(33, 0).addBox(-1.0F, -60.0F, -1.0F, 2.0F, 60.0F, 2.0F, 0.0F, false);
		root.setTextureOffset(0, 0).addBox(0.0F, -80.0F, -8.0F, 0.0F, 37.0F, 16.0F, 0.0F, false);
		root.setTextureOffset(42, 0).addBox(-8.0F, -80.0F, 0.0F, 16.0F, 37.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	

	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(
				root
		);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}