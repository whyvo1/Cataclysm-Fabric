package com.github.l_ender.cataclysm.client.render;


import com.github.l_ender.lionfishapi.client.model.tools.AdvancedModelBox;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.impl.client.rendering.EntityModelLayerImpl;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector4f;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class RenderUtils {
    public static void matrixStackFromCitadelModel(MatrixStack matrixStack, AdvancedModelBox AdvancedModelBox) {
        AdvancedModelBox parent = AdvancedModelBox.getParent();
        if (parent != null) matrixStackFromCitadelModel(matrixStack, parent);
        AdvancedModelBox.translateAndRotate(matrixStack);
    }

    public static Vec3d matrixStackFromCitadelModel(Entity entity, float entityYaw, AdvancedModelBox modelRenderer) {
        MatrixStack matrixStack = new MatrixStack();
        matrixStack.translate(entity.getX(), entity.getY(), entity.getZ());
        matrixStack.multiply((new Quaternionf()).rotationY((-entityYaw + 180) * ((float)Math.PI / 180F)));
        matrixStack.scale(-1, -1, 1);
        matrixStack.translate(0, -1.5f, 0);
        RenderUtils.matrixStackFromCitadelModel(matrixStack, modelRenderer);
        MatrixStack.Entry matrixEntry = matrixStack.peek();
        Matrix4f matrix4f = matrixEntry.getPositionMatrix();
        Vector4f vec = new Vector4f(0, 0, 0, 1);
        vec.mul(matrix4f);
        return new Vec3d(vec.x(), vec.y(), vec.z());
    }

    public static ModelPart getModelPartFromLayer(EntityModelLayer layer) {
        EntityModelLayerRegistry.TexturedModelDataProvider provider = EntityModelLayerImpl.PROVIDERS.get(layer);
        if(provider == null) {
            throw new IllegalArgumentException("No model for layer " + layer);
        }
        else {
            return provider.createModelData().createModel();
        }
    }

}
