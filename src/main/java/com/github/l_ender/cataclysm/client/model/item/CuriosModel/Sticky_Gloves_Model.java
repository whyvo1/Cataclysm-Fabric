package com.github.l_ender.cataclysm.client.model.item.CuriosModel;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Arm;

public class Sticky_Gloves_Model extends BipedEntityModel<LivingEntity> {
    public Sticky_Gloves_Model(ModelPart root) {
        super(root);
    }

    public static TexturedModelData createLayer(boolean slim,Dilation deformation) {
        ModelData meshDefinition = BipedEntityModel.getModelData(deformation, 0.0F);
        ModelPartData partDefinition = meshDefinition.getRoot();
        ModelPartData rightArm = partDefinition.getChild("right_arm");
        ModelPartData leftArm = partDefinition.getChild("left_arm");

        float slimornot = slim ? 1.0F : 0.0f;

        rightArm.addChild("right_glove", ModelPartBuilder.create().uv(63, 11).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(75, 23).cuboid(-3.0F, 7.0F, -2.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.2F)), ModelTransform.pivot(slimornot, 0.0F, 0.0F));

         leftArm.addChild("left_glove", ModelPartBuilder.create().uv(63, 11).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
                 .uv(75, 23).mirrored().cuboid(-1.0F, 7.0F, -2.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.2F)).mirrored(false), ModelTransform.pivot(-slimornot, 0.0F, 0.0F));

        return TexturedModelData.of(meshDefinition, 128, 128);

    }

    public void renderArm(Arm handSide, MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay) {
        getArm(handSide).visible = true;
        getArm(handSide.getOpposite()).visible = false;
        render(matrixStack, buffer, packedLight, packedOverlay);
    }

    @Override
    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of();
    }

    @Override
    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of(leftArm, rightArm);
    }
}
