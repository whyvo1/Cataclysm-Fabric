package com.github.l_ender.lionfishapi.client.util;

import com.github.l_ender.lionfishapi.client.model.tools.AdvancedModelBox;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector4f;

public class LFRenderUtils {

    public static void matrixStackFromModel(MatrixStack matrixStack, AdvancedModelBox AdvancedModelBox) {
        AdvancedModelBox parent = AdvancedModelBox.getParent();
        if (parent != null) matrixStackFromModel(matrixStack, parent);
        AdvancedModelBox.translateAndRotate(matrixStack);
    }

    public static Vec3d matrixStackFromModel(Entity entity, float entityYaw, AdvancedModelBox modelRenderer) {
        MatrixStack matrixStack = new MatrixStack();
        matrixStack.translate(entity.getX(), entity.getY(), entity.getZ());
        matrixStack.multiply((new Quaternionf()).rotationY((-entityYaw + 180) * ((float)Math.PI / 180F)));
        matrixStack.scale(-1, -1, 1);
        matrixStack.translate(0, -1.5f, 0);
        LFRenderUtils.matrixStackFromModel(matrixStack, modelRenderer);
        MatrixStack.Entry matrixEntry = matrixStack.peek();
        Matrix4f matrix4f = matrixEntry.getPositionMatrix();
        Vector4f vec = new Vector4f(0, 0, 0, 1);
        vec.mul(matrix4f);
        return new Vec3d(vec.x(), vec.y(), vec.z());
    }

}
