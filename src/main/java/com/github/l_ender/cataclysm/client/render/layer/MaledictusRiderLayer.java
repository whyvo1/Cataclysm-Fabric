package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.client.event.ClientHooks;
import com.github.l_ender.cataclysm.client.model.entity.Maledictus_Model;
import com.github.l_ender.cataclysm.client.render.entity.Maledictus_Renderer;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.crash.CrashReportSection;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector4f;

public class MaledictusRiderLayer extends FeatureRenderer<Maledictus_Entity, Maledictus_Model> {

    public MaledictusRiderLayer(Maledictus_Renderer render) {
        super(render);
    }

    public void render(MatrixStack poseStack, VertexConsumerProvider bufferIn, int packedLightIn, Maledictus_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        float bodyYaw = entity.prevBodyYaw + (entity.bodyYaw - entity.prevBodyYaw) * partialTicks;
        if (entity.hasPassengers()) {
            Vec3d offset = new Vec3d(0, 0.0F, 0F);
            Vec3d ridePos = getRiderPosition(offset);
            for (Entity passenger : entity.getPassengerList()) {
                if (passenger == MinecraftClient.getInstance().player && MinecraftClient.getInstance().options.getPerspective().isFirstPerson()) {
                    continue;
                }
                ClientHooks.releaseRenderingEntity(passenger.getUuid());
                poseStack.push();
                poseStack.translate(ridePos.x, ridePos.y - 0.65F + passenger.getHeight(), ridePos.z);
                poseStack.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(180F));
                poseStack.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(360 - bodyYaw));
                renderPassenger(passenger, 0, 0, 0, 0, partialTicks, poseStack, bufferIn, packedLightIn);
                poseStack.pop();
               ClientHooks.blockRenderingEntity(passenger.getUuid());
            }

        }
    }




    public Vec3d getRiderPosition(Vec3d offsetIn) {
        MatrixStack translationStack = new MatrixStack();
        translationStack.push();
        this.getContextModel().translateToHand(translationStack,true);
        Vector4f armOffsetVec = new Vector4f((float) offsetIn.x, (float) offsetIn.y, (float) offsetIn.z, 1.0F);
        armOffsetVec.mul(translationStack.peek().getPositionMatrix());
        Vec3d vec3 = new Vec3d(armOffsetVec.x(), armOffsetVec.y(), armOffsetVec.z());
        translationStack.pop();
        return vec3;
    }


    public static <E extends Entity> void renderPassenger(E entityIn, double x, double y, double z, float yaw, float partialTicks, MatrixStack matrixStack, VertexConsumerProvider bufferIn, int packedLight) {
        EntityRenderer<? super E> render = null;
        EntityRenderDispatcher manager = MinecraftClient.getInstance().getEntityRenderDispatcher();
        try {
            render = manager.getRenderer(entityIn);

            if (render != null) {
                try {
                    render.render(entityIn, yaw, partialTicks, matrixStack, bufferIn, packedLight);
                } catch (Throwable throwable1) {
                    throw new CrashException(CrashReport.create(throwable1, "Rendering entity in world"));
                }
            }
        } catch (Throwable throwable3) {
            CrashReport crashreport = CrashReport.create(throwable3, "Rendering entity in world");
            CrashReportSection crashreportcategory = crashreport.addElement("Entity being rendered");
            entityIn.populateCrashReport(crashreportcategory);
            CrashReportSection crashreportcategory1 = crashreport.addElement("Renderer details");
            crashreportcategory1.add("Assigned renderer", render);
            crashreportcategory1.add("Rotation", yaw);
            crashreportcategory1.add("Delta", partialTicks);
            throw new CrashException(crashreport);
        }
    }

}
