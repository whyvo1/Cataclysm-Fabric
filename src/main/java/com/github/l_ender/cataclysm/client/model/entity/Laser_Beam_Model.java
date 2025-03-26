package com.github.l_ender.cataclysm.client.model.entity;


import com.github.l_ender.cataclysm.entity.projectile.Laser_Beam_Entity;
import net.minecraft.client.model.*;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;

public class Laser_Beam_Model extends SinglePartEntityModel<Laser_Beam_Entity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor

	private final ModelPart root;

	public Laser_Beam_Model(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static TexturedModelData createBodyLayer() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData root = partdefinition.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.5F, 0.0F));

		ModelPartData cube_r1 = root.addChild("cube_r1", ModelPartBuilder.create().uv(0, -16).cuboid(0.0F, -1.5F, -8.0F, 0.0F, 3.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData cube_r2 = root.addChild("cube_r2", ModelPartBuilder.create().uv(0, -16).cuboid(0.0F, -1.5F, -8.0F, 0.0F, 3.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		return TexturedModelData.of(meshdefinition, 32, 32);
	}

	@Override
	public void setAngles(Laser_Beam_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}


	public void setAngles(float yRot, float xRot) {
		this.root.yaw = yRot * ((float)Math.PI / 180F);
		this.root.pitch = xRot * ((float)Math.PI / 180F);
	}

	@Override
	public ModelPart getPart() {
		return this.root;
	}

}