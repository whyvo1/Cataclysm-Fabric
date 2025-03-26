package com.github.l_ender.cataclysm.client.model.item;


import com.github.l_ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.l_ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.l_ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.entity.Entity;

public class The_Annihilator_Model extends AdvancedEntityModel<Entity> {
	private final AdvancedModelBox root;

	public The_Annihilator_Model() {
		texWidth = 128;
		texHeight = 128;

		root = new AdvancedModelBox(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);
		root.setTextureOffset(0, 42).addBox(-1.0F, -19.0F, -1.0F, 2.0F, 19.0F, 2.0F, 0.0F, false);
		root.setTextureOffset(39, 23).addBox(-1.5F, -33.0F, -1.5F, 3.0F, 16.0F, 3.0F, 0.0F, false);
		root.setTextureOffset(0, 0).addBox(0.0F, -41.0F, -9.5F, 0.0F, 22.0F, 19.0F, 0.0F, false);
		root.setTextureOffset(39, 0).addBox(-9.5F, -41.0F, 0.0F, 19.0F, 22.0F, 0.0F, 0.0F, false);
		this.updateDefaultPose();
	}


	public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
		AdvancedModelBox.rotateAngleX = x;
		AdvancedModelBox.rotateAngleY = y;
		AdvancedModelBox.rotateAngleZ = z;
	}

	@Override
	public void setAngles(Entity entity, float pullAmount, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetToDefaultPose();

	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {
		return ImmutableList.of(root);
	}

	@Override
	public Iterable<BasicModelPart> parts() {
		return ImmutableList.of(root);
	}
}