package com.github.l_ender.cataclysm.client.model.block;// Made with Blockbench 4.10.4

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class AptrgangrHeadModel extends Cataclysm_Skull_Model_Base {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart head;
	private final ModelPart helmet;
	private final ModelPart jaw;

	public AptrgangrHeadModel(ModelPart root) {
		this.head = root.getChild("head");
		this.helmet = this.head.getChild("helmet");
		this.jaw = this.head.getChild("jaw");
	}

	public static TexturedModelData createHeadLayer() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData head = partdefinition.addChild("head", ModelPartBuilder.create().uv(0, 111).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 9.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.0F, 0.0F));

		ModelPartData helmet = head.addChild("helmet", ModelPartBuilder.create().uv(32, 113).cuboid(-4.0F, -2.0F, -3.5F, 8.0F, 6.0F, 8.0F, new Dilation(0.5F))
				.uv(102, 110).cuboid(-1.5F, -2.8F, -4.3F, 3.0F, 8.0F, 10.0F, new Dilation(0.0F))
				.uv(64, 120).mirrored().cuboid(-5.5F, -2.0F, -1.5F, 1.0F, 4.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
				.uv(116, 20).cuboid(-10.5F, -3.5F, 0.5F, 5.0F, 5.0F, 0.0F, new Dilation(0.0F))
				.uv(64, 120).cuboid(4.5F, -2.0F, -1.5F, 1.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(116, 0).cuboid(4.5F, -9.5F, 0.5F, 6.0F, 11.0F, 0.0F, new Dilation(0.0F))
				.uv(88, 98).cuboid(-5.0F, 3.2F, -4.3F, 10.0F, 2.0F, 10.0F, new Dilation(0.001F))
				.uv(62, 91).cuboid(-4.0F, 5.0F, -3.5F, 8.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, -0.5F));

		ModelPartData head_r1 = helmet.addChild("head_r1", ModelPartBuilder.create().uv(28, 104).mirrored().cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.4F, 3.5F, -3.8F, 0.0F, 0.0F, -0.7854F));

		ModelPartData head_r2 = helmet.addChild("head_r2", ModelPartBuilder.create().uv(42, 111).mirrored().cuboid(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
				.uv(44, 106).mirrored().cuboid(0.0F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
				.uv(43, 109).mirrored().cuboid(-1.0F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
				.uv(29, 115).mirrored().cuboid(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.4F, 3.5F, -4.1F, 0.0F, 0.0F, -0.2618F));

		ModelPartData head_r3 = helmet.addChild("head_r3", ModelPartBuilder.create().uv(43, 108).cuboid(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(32, 104).cuboid(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.4F, 3.5F, -4.1F, 0.0F, 0.0F, 0.2618F));

		ModelPartData head_r4 = helmet.addChild("head_r4", ModelPartBuilder.create().uv(25, 108).mirrored().cuboid(-0.5F, -1.5F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 4.8F, -4.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData head_r5 = helmet.addChild("head_r5", ModelPartBuilder.create().uv(31, 108).mirrored().cuboid(-0.5F, -1.5F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 6.2F, -4.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData head_r6 = helmet.addChild("head_r6", ModelPartBuilder.create().uv(30, 111).mirrored().cuboid(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 1.7F, -3.9F, 0.0F, 0.0F, -0.7854F));

		ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create().uv(34, 26).cuboid(-3.0F, 0.0F, -2.5F, 6.0F, 8.0F, 3.0F, new Dilation(0.0F))
				.uv(48, 0).cuboid(3.0F, 3.0F, 0.0F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
				.uv(48, 5).cuboid(3.0F, -2.0F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F))
				.uv(48, 5).mirrored().cuboid(-5.0F, -2.0F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
				.uv(48, 0).mirrored().cuboid(-9.0F, 3.0F, 0.0F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
				.uv(84, 1).cuboid(3.0F, 8.0F, -2.5F, 5.0F, 4.0F, 3.0F, new Dilation(0.0F))
				.uv(84, 1).mirrored().cuboid(-8.0F, 8.0F, -2.5F, 5.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
				.uv(52, 33).cuboid(-3.0F, 0.0F, 0.5F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, -1.5F));

		ModelPartData head_r7 = jaw.addChild("head_r7", ModelPartBuilder.create().uv(92, 12).cuboid(-3.0F, 0.0F, 0.0F, 6.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 8.0F, -2.5F, -0.3491F, 0.0F, 0.0F));

		return TexturedModelData.of(meshdefinition, 256, 256);
	}

	public void setAngles(float p_104188_, float p_104189_, float p_104190_) {
		this.jaw.pivotY = -3.0F + MathHelper.sin(p_104188_ * 0.5F - 2) * 2f;
		this.head.yaw = p_104189_ * ((float)Math.PI / 180F);
		this.head.pitch = p_104190_ * ((float)Math.PI / 180F);
	}

	public void render(MatrixStack p_104192_, VertexConsumer p_104193_, int p_104194_, int p_104195_, float p_104196_, float p_104197_, float p_104198_, float p_104199_) {
		p_104192_.push();
		p_104192_.translate(0.0F, -0.49916F, 0.0F);
		p_104192_.scale(1.0F, 1.0F, 1.0F);
		this.head.render(p_104192_, p_104193_, p_104194_, p_104195_, p_104196_, p_104197_, p_104198_, p_104199_);
		p_104192_.pop();
	}
}