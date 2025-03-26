package com.github.l_ender.cataclysm.mixin.Client;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.ClientProxy;
import com.github.l_ender.cataclysm.client.event.ClientEvent;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.client.render.etc.LavaVisionFluidRenderer;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.FluidRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    @Shadow @Final private MinecraftClient client;

    @Inject(method = "renderEntity", at = @At("HEAD"), cancellable = true)
    public void injectRenderEntity(Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, CallbackInfo ci) {
        if(entity instanceof LivingEntity livingEntity) {
            boolean usingIncinerator = livingEntity.isUsingItem() && (livingEntity.getActiveItem().isOf(ModItems.THE_INCINERATOR));
            boolean usingImmolator = livingEntity.isUsingItem() && livingEntity.getActiveItem().isOf(ModItems.THE_IMMOLATOR);
            if(usingIncinerator){
                int i = livingEntity.getItemUseTime();
                float f2 = (float) livingEntity.age + client.getTickDelta();
                float f3 = MathHelper.clamp(i, 1, 60);
                matrices.push();
                VertexConsumer ivertexbuilder = ItemRenderer.getArmorGlintConsumer(vertexConsumers, CMRenderTypes.getGlowingEffect(ClientEvent.FLAME_STRIKE),false, true);
                matrices.translate(0.0D, 0.001, 0.0D);
                matrices.scale(f3 * 0.05f, f3 * 0.05f, f3 * 0.05f);
                matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180.0F));
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F + f2));
                MatrixStack.Entry lvt_19_1_ = matrices.peek();
                Matrix4f lvt_20_1_ = lvt_19_1_.getPositionMatrix();
                Matrix3f lvt_21_1_ = lvt_19_1_.getNormalMatrix();
                this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
                this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
                this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
                this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
                matrices.pop();
            }

            if(usingImmolator){
                int i = livingEntity.getItemUseTime();
                float f2 = (float) livingEntity.age + client.getTickDelta();
                float f3 = MathHelper.clamp(i, 1, 45);
                matrices.push();
                VertexConsumer ivertexbuilder = ItemRenderer.getArmorGlintConsumer(vertexConsumers,CMRenderTypes.getGlowingEffect(ClientEvent.NORMAL_FLAME_STRIKE),false, true);
                matrices.translate(0.0D, 0.001, 0.0D);
                matrices.scale(f3 * 0.05f, f3 * 0.05f, f3 * 0.05f);
                matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180.0F));
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F + f2));
                MatrixStack.Entry lvt_19_1_ = matrices.peek();
                Matrix4f lvt_20_1_ = lvt_19_1_.getPositionMatrix();
                Matrix3f lvt_21_1_ = lvt_19_1_.getNormalMatrix();
                this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
                this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
                this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
                this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
                matrices.pop();
            }
        }


        if (ClientProxy.blockedEntityRenders.contains(entity.getUuid())) {
            if (!Cataclysm.PROXY.isFirstPersonPlayer(entity)) {
                ci.cancel();
            }
            ClientProxy.blockedEntityRenders.remove(entity.getUuid());
        }
    }

    @Unique
    public void drawVertex(Matrix4f matrix4f, Matrix3f matrix3f, VertexConsumer consumer, int x, int y, int z, float u, float v, int nx, int nz, int ny, int light) {
        consumer.vertex(matrix4f, (float) x, (float) y, (float) z).color(255, 255, 255, 255).texture(u, v).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(matrix3f, (float) nx, (float) ny, (float) nz).next();
    }

    @Unique
    private boolean previousLavaVision = false;
    @Unique
    private FluidRenderer previousFluidRenderer;

    @Inject(method = "renderSky(Lnet/minecraft/client/util/math/MatrixStack;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V", at = @At("RETURN"))
    public void injectRenderSky(MatrixStack matrices, Matrix4f projectionMatrix, float tickDelta, Camera camera, boolean thickFog, Runnable fogCallback, CallbackInfo ci) {
        if (!CMConfig.shadersCompat) {
            ItemStack itemstack = MinecraftClient.getInstance().player.getInventory().getArmorStack(3);
            if (itemstack.isOf(ModItems.IGNITIUM_HELMET)) {
                if (!previousLavaVision) {
                    previousFluidRenderer = MinecraftClient.getInstance().getBlockRenderManager().fluidRenderer;
                    MinecraftClient.getInstance().getBlockRenderManager().fluidRenderer = new LavaVisionFluidRenderer();
                    updateAllChunks();
                }
            } else {
                if (previousLavaVision) {
                    if (previousFluidRenderer != null) {
                        MinecraftClient.getInstance().getBlockRenderManager().fluidRenderer = previousFluidRenderer;
                    }
                    updateAllChunks();
                }
            }
            previousLavaVision = itemstack.isOf(ModItems.IGNITIUM_HELMET);
        }
    }

    @Unique
    public void updateAllChunks() {
        if (MinecraftClient.getInstance().worldRenderer.chunks != null) {
            int length = MinecraftClient.getInstance().worldRenderer.chunks.chunks.length;
            for (int i = 0; i < length; i++) {
                MinecraftClient.getInstance().worldRenderer.chunks.chunks[i].needsRebuild = true;
            }
        }
    }

}
