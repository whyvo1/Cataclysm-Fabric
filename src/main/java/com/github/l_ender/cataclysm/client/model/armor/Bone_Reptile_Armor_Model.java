package com.github.l_ender.cataclysm.client.model.armor;


import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.LivingEntity;

@Environment(EnvType.CLIENT)
public class Bone_Reptile_Armor_Model extends BipedEntityModel<LivingEntity> {

    public Bone_Reptile_Armor_Model(ModelPart p_170677_) {
        super(p_170677_);


    }

    public static TexturedModelData createArmorLayer(Dilation deformation) {
        ModelData meshdefinition = BipedEntityModel.getModelData(deformation, 0.0F);
        ModelPartData partdefinition = meshdefinition.getRoot();
        ModelPartData head = partdefinition.getChild("head");
        ModelPartData body = partdefinition.getChild("body");
        ModelPartData rightArm = partdefinition.getChild("right_arm");
        ModelPartData leftArm = partdefinition.getChild("left_arm");

        head.addChild("Helmet_r1", ModelPartBuilder.create().uv(0, 32).cuboid(-4.0F, -1.5F, -4.0F, 4.0F, 3.0F, 4.0F, new Dilation(1.0F)), ModelTransform.of(2.0F, -6.4224F, -5.7783F, 0.0873F, 0.0F, 0.0F));

        head.addChild("Helmet_r2", ModelPartBuilder.create().uv(20, 36).mirrored().cuboid(-3.9F, 1.0F, -6.2F, 3.0F, 4.0F, 5.0F, new Dilation(1.0F)).mirrored(false), ModelTransform.of(4.9F, -5.0F, 0.2F, 0.2618F, -0.3054F, 0.0F));

        head.addChild("Helmet_r3", ModelPartBuilder.create().uv(20, 36).cuboid(0.9F, 1.0F, -6.2F, 3.0F, 4.0F, 5.0F, new Dilation(1.0F)), ModelTransform.of(-4.9F, -5.0F, 0.2F, 0.2618F, 0.3054F, 0.0F));

        head.addChild("Helmet_r4", ModelPartBuilder.create().uv(0, 45).cuboid(-4.5F, -2.4F, -4.0F, 9.0F, 2.0F, 8.0F, new Dilation(1.0F)), ModelTransform.of(0.0F, -7.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

        head.addChild("left_horn", ModelPartBuilder.create().uv(0, 39).mirrored().cuboid(-3.0F, -3.3F, -2.0F, 3.0F, 5.0F, 1.0F, new Dilation(1.0F)).mirrored(false)
                .uv(8, 40).mirrored().cuboid(-3.0F, -3.3F, 1.0F, 3.0F, 2.0F, 3.0F, new Dilation(1.0F)).mirrored(false), ModelTransform.pivot(-6.0F, -8.0F, 5.0F));

        head.addChild("right_horn", ModelPartBuilder.create().uv(0, 39).cuboid(0.0F, -3.3F, -2.0F, 3.0F, 5.0F, 1.0F, new Dilation(1.0F))
                .uv(8, 40).cuboid(0.0F, -3.3F, 1.0F, 3.0F, 2.0F, 3.0F, new Dilation(1.0F)), ModelTransform.pivot(6.0F, -8.0F, 5.0F));

        head.addChild("mid_horn", ModelPartBuilder.create().uv(53, 111).cuboid(-2.5F, -1.7F, -6.0F, 5.0F, 4.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -9.8F, 4.4F, 0.5236F, 0.0F, 0.0F));

        body.addChild("body_bone", ModelPartBuilder.create().uv(0, 108).cuboid(-6.0F, 0.0F, -1.85F, 10.0F, 14.0F, 6.0F, new Dilation(0.45F))
                .uv(0, 87).cuboid(-2.0F, 0.0F, 5.0F, 2.0F, 14.0F, 1.0F, new Dilation(0.5F))
                .uv(32, 92).cuboid(-1.0F, 0.0F, 6.5F, 0.0F, 14.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -1.0F, -1.0F));

        rightArm.addChild("right_shoulder", ModelPartBuilder.create().uv(0, 95).cuboid(-8.0F, -4.0F, -4.0F, 9.0F, 6.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 78).cuboid(-8.0F, -6.0F, -4.0F, 6.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.5F));

        rightArm.addChild("right_fist", ModelPartBuilder.create().uv(44, 105).cuboid(-5.5F, -2.0F, -3.0F, 3.0F, 6.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 6.0F, -0.5F));

        leftArm.addChild("left_shoulder", ModelPartBuilder.create().uv(0, 95).mirrored().cuboid(-1.0F, -4.0F, -4.0F, 9.0F, 6.0F, 7.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 78).mirrored().cuboid(2.0F, -6.0F, -4.0F, 6.0F, 2.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.5F));

        leftArm.addChild("left_fist", ModelPartBuilder.create().uv(44, 105).mirrored().cuboid(2.5F, -2.0F, -3.0F, 3.0F, 6.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-3.0F, 6.0F, -0.5F));

        return TexturedModelData.of(meshdefinition, 128, 128);
    }

}
