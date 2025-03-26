package com.github.l_ender.cataclysm.client.model.entity;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.l_ender.cataclysm.entity.projectile.Flare_Bomb_Entity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.util.math.Vec3d;

public class Flare_Bomb_Model extends SinglePartEntityModel<Flare_Bomb_Entity> {


	private final ModelPart root;
	private final ModelPart outer;
	private final ModelPart inner;
	public Flare_Bomb_Model(ModelPart root) {
		this.root = root.getChild("root");
		this.outer = this.root.getChild("outer");
		this.inner = this.root.getChild("inner");
	}


	public static TexturedModelData createBodyLayer() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData root = partdefinition.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 4.0F, 0.0F));

		ModelPartData outer = root.addChild("outer", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData inner = root.addChild("inner", ModelPartBuilder.create().uv(0, 33).cuboid(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		return TexturedModelData.of(meshdefinition, 64, 64);
	}


	@Override
	public void setAngles(Flare_Bomb_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float delta = ageInTicks - entity.age;
		Vec3d prevV = new Vec3d(entity.prevDeltaMovementX, entity.prevDeltaMovementY, entity.prevDeltaMovementZ);
		Vec3d dv = prevV.add(entity.getVelocity().subtract(prevV).multiply(delta));
		double d = Math.sqrt(dv.x * dv.x + dv.y * dv.y + dv.z * dv.z);
		if (d != 0) {
			double a = dv.y / d;
			a = Math.max(-10, Math.min(1, a));
			float pitch = -(float) Math.asin(a);
			root.pitch = pitch + (float)Math.PI / 2f;

		}
		this.inner.yaw = ageInTicks * 20 * ((float)Math.PI / 180F);
		this.inner.pitch = ageInTicks * 20  * ((float)Math.PI / 180F);
		this.inner.roll = ageInTicks  * 20  * ((float)Math.PI / 180F);

		this.outer.yaw = ageInTicks * -10 * ((float)Math.PI / 180F);
		this.outer.pitch = ageInTicks * -10  * ((float)Math.PI / 180F);
		this.outer.roll = ageInTicks  * -10  * ((float)Math.PI / 180F);


	}

	@Override
	public ModelPart getPart() {
		return this.root;
	}


}