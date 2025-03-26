package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Tidal_Hook_Model;
import com.github.l_ender.cataclysm.entity.projectile.Tidal_Hook_Entity;

import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;


public class Tidal_Hook_Renderer extends EntityRenderer<Tidal_Hook_Entity> {
	private final Tidal_Hook_Model model = new Tidal_Hook_Model();
	private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/entity/tidal_hook.png");
	private static final Identifier CHAIN_TEXTURE = Cataclysm.modIdentifier("textures/entity/tidal_hook_chain.png");
	private static final RenderLayer CHAIN_LAYER = RenderLayer.getEntitySmoothCutout(CHAIN_TEXTURE);

	public Tidal_Hook_Renderer(EntityRendererFactory.Context renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public void render(Tidal_Hook_Entity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider provider, int light) {
		matrices.push();
		matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw()) - 90.0F));
		matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch()) + 90.0F));

		VertexConsumer vertexConsumer = provider.getBuffer(this.model.getLayer(getTexture(entity)));
		model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
		matrices.pop();

		matrices.push();
		Entity fromEntity = entity.getOwner();

		float x = (float)MathHelper.lerp(tickDelta, entity.prevX, entity.getX());
		float y = (float)MathHelper.lerp(tickDelta, entity.prevY, entity.getY());
		float z = (float)MathHelper.lerp(tickDelta, entity.prevZ, entity.getZ());
		if(fromEntity != null) {
			Vec3d distVec = getPositionOfPriorMob(fromEntity, tickDelta).subtract(x, y, z);
			Vec3d from = distVec;
			renderChainCube(from, tickDelta, entity.age, matrices, provider, light);
		}

		matrices.pop();

	}



	private Vec3d getPositionOfPriorMob(Entity mob, float partialTicks){
		double d4 = MathHelper.lerp(partialTicks, mob.prevX, mob.getX());
		double d5 = MathHelper.lerp(partialTicks, mob.prevY, mob.getY());
		double d6 = MathHelper.lerp(partialTicks, mob.prevZ, mob.getZ());
		float f3 = 0;
		if(mob instanceof PlayerEntity){
			PlayerEntity player = (PlayerEntity) mob;
			float f = player.getHandSwingProgress(partialTicks);
			float f1 = MathHelper.sin(MathHelper.sqrt(f) * (float) Math.PI);
			float f2 = MathHelper.lerp(partialTicks, player.prevBodyYaw, player.bodyYaw) * ((float) Math.PI / 180F);
			int i = player.getMainArm() == Arm.RIGHT ? 1 : -1;
			ItemStack itemstack = player.getMainHandStack();
			if (!itemstack.isOf(ModItems.TIDAL_CLAWS)) {
				i = -i;
			}
			double d0 = MathHelper.sin(f2);
			double d1 = MathHelper.cos(f2);
			double d2 = (double) i * 0.35D;
			if ((this.dispatcher.gameOptions == null || this.dispatcher.gameOptions.getPerspective().isFirstPerson()) && player == MinecraftClient.getInstance().player) {
				double d7 = 960.0D / (double) this.dispatcher.gameOptions.getFov().getValue();
				Vec3d vec3 = this.dispatcher.camera.getProjection().getPosition((float) i * 0.6F, -1);
				vec3 = vec3.multiply(d7);
				vec3 = vec3.rotateY(f1 * 0.25F);
				vec3 = vec3.rotateX(-f1 * 0.35F);
				d4 = MathHelper.lerp(partialTicks, player.prevX, player.getX()) + vec3.x;
				d5 = MathHelper.lerp(partialTicks, player.prevY, player.getY()) + vec3.y;
				d6 = MathHelper.lerp(partialTicks, player.prevZ, player.getZ()) + vec3.z;
				f3 = player.getStandingEyeHeight() * 0.5F;
			} else {
				d4 = MathHelper.lerp(partialTicks, player.prevX, player.getX()) - d1 * d2 - d0 * 0.2D;
				d5 = player.prevY + (double) player.getStandingEyeHeight() + (player.getY() - player.prevY) * (double) partialTicks - 0.45D;
				d6 = MathHelper.lerp(partialTicks, player.prevZ, player.getZ()) - d0 * d2 + d1 * 0.2D;
				f3 = (player.isInSneakingPose() ? -0.1875F : 0.0F);
			}
		}

		return new Vec3d(d4, d5 + f3, d6);
	}

	public static void renderChainCube(Vec3d from, float tickDelta, int age, MatrixStack stack, VertexConsumerProvider provider, int light) {
		float lengthXY = MathHelper.sqrt((float) (from.x * from.x + from.z * from.z));
		float squaredLength = (float) (from.x * from.x + from.y * from.y + from.z * from.z);
		float length = MathHelper.sqrt(squaredLength);

		stack.push();
		stack.multiply(RotationAxis.POSITIVE_Y.rotation((float) (-Math.atan2(from.z, from.x)) - 1.5707964F));
		stack.multiply(RotationAxis.POSITIVE_X.rotation((float) (-Math.atan2(lengthXY, from.y)) - 1.5707964F));
		stack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(25));
		stack.push();
		stack.translate(0.015, -0.2, 0);

		VertexConsumer vertexConsumer = provider.getBuffer(CHAIN_LAYER);
		float vertX1 = 0F;
		float vertY1 = 0.25F;
		float vertX2 = MathHelper.sin(6.2831855F) * 0.125F;
		float vertY2 = MathHelper.cos(6.2831855F) * 0.125F;
		float minU = 0F;
		float maxU = 0.1875F;
		float minV = 0.0F - ((float) age + tickDelta) * 0.01F;
		float maxV = MathHelper.sqrt(squaredLength) / 8F - ((float) age + tickDelta) * 0.01F;
		MatrixStack.Entry entry = stack.peek();


		vertexConsumer.vertex(entry, vertX1, vertY1, 0F).color(0, 0, 0, 255).texture(minU, minV).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(entry, 0.0F, -1.0F, 0.0F);
		vertexConsumer.vertex(entry, vertX1, vertY1, length).color(255, 255, 255, 255).texture(minU, maxV).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(entry, 0.0F, -1.0F, 0.0F);
		vertexConsumer.vertex(entry, vertX2, vertY2, length).color(255, 255, 255, 255).texture(maxU, maxV).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(entry, 0.0F, -1.0F, 0.0F);
		vertexConsumer.vertex(entry, vertX2, vertY2, 0F).color(0, 0, 0, 255).texture(maxU, minV).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(entry, 0.0F, -1.0F, 0.0F);

		stack.pop();
		stack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90));
		stack.translate(-0.015, -0.2, 0);

		entry = stack.peek();
		vertexConsumer.vertex(entry, vertX1, vertY1, 0F).color(0, 0, 0, 255).texture(minU, minV).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(entry, 0.0F, -1.0F, 0.0F);
		vertexConsumer.vertex(entry, vertX1, vertY1, length).color(255, 255, 255, 255).texture(minU, maxV).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(entry, 0.0F, -1.0F, 0.0F);
		vertexConsumer.vertex(entry, vertX2, vertY2, length).color(255, 255, 255, 255).texture(maxU, maxV).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(entry, 0.0F, -1.0F, 0.0F);
		vertexConsumer.vertex(entry, vertX2, vertY2, 0F).color(0, 0, 0, 255).texture(maxU, minV).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(entry, 0.0F, -1.0F, 0.0F);

		stack.pop();
	}


	@Override
	public Identifier getTexture(Tidal_Hook_Entity entity) {
		return TEXTURE;
	}
}