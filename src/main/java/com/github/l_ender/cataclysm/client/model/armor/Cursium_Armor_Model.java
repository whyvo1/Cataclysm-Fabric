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
public class Cursium_Armor_Model extends BipedEntityModel<LivingEntity> {

    public Cursium_Armor_Model(ModelPart p_170677_) {
        super(p_170677_);


    }

    public static TexturedModelData createArmorLayer(Dilation deformation) {
        ModelData meshdefinition = BipedEntityModel.getModelData(deformation, 0.0F);
        ModelPartData partdefinition = meshdefinition.getRoot();
        ModelPartData head = partdefinition.getChild("head");
        ModelPartData body = partdefinition.getChild("body");
        ModelPartData rightArm = partdefinition.getChild("right_arm");
        ModelPartData leftArm = partdefinition.getChild("left_arm");
        ModelPartData rightLeg = partdefinition.getChild("right_leg");
        ModelPartData leftLeg = partdefinition.getChild("left_leg");

        ModelPartData RightCustomArm = rightArm.addChild("RightCustomArm", ModelPartBuilder.create().uv(22, 89).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.525F))
                .uv(22, 105).cuboid(-3.6F, 3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.6F)), ModelTransform.pivot(0.0F, 2.0F, 0.0F));

        ModelPartData right_shoulder = RightCustomArm.addChild("right_shoulder", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, 2.0F, 0.0F));


        ModelPartData rib = body.addChild("rib", ModelPartBuilder.create().uv(100, 0).cuboid(-4.0F, -2.0F, -3.0F, 8.0F, 12.0F, 6.0F, new Dilation(0.6F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData chestplate_r1 = right_shoulder.addChild("chestplate_r1", ModelPartBuilder.create().uv(0, 92).cuboid(-2.5F, -6.0F, -2.5F, 5.0F, 12.0F, 5.0F, new Dilation(0.55F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        ModelPartData LeftCustomArm = leftArm.addChild("LeftCustomArm", ModelPartBuilder.create().uv(22, 89).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.525F)).mirrored(false)
                .uv(22, 105).mirrored().cuboid(-0.4F, 3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.6F)).mirrored(false), ModelTransform.pivot(0.0F, 2.0F, 0.0F));

        ModelPartData left_shoulder = LeftCustomArm.addChild("left_shoulder", ModelPartBuilder.create(), ModelTransform.pivot(2.5F, 2.0F, 0.0F));

        ModelPartData chestplate_r2 = left_shoulder.addChild("chestplate_r2", ModelPartBuilder.create().uv(0, 92).mirrored().cuboid(-2.5F, -6.0F, -2.5F, 5.0F, 12.0F, 5.0F, new Dilation(0.55F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));


        ModelPartData right_leggings_plate = rightLeg.addChild("right_leggings_plate", ModelPartBuilder.create().uv(62, 108).cuboid(-5.8F, -12.0F, -2.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.8F)), ModelTransform.of(1.9F, 11.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        ModelPartData right_boots_leggings = rightLeg.addChild("right_boots_leggings", ModelPartBuilder.create().uv(80, 115).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));


        ModelPartData left_leggings_plate = leftLeg.addChild("left_leggings_plate", ModelPartBuilder.create().uv(62, 108).mirrored().cuboid(2.8F, -12.0F, -2.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.8F)).mirrored(false), ModelTransform.of(-1.9F, 11.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        ModelPartData left_boots_leggings = leftLeg.addChild("left_boots_leggings", ModelPartBuilder.create().uv(80, 115).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.25F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));


        ModelPartData right_horn = head.addChild("right_horn", ModelPartBuilder.create(), ModelTransform.of(-6.2F, -10.0F, 0.0F, -0.2618F, 0.0F, -0.6545F));

        ModelPartData cube_r1 = right_horn.addChild("cube_r1", ModelPartBuilder.create().uv(97, 122).cuboid(-5.811F, -19.4301F, 0.1321F, 12.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 118).cuboid(-9.811F, -17.4301F, 0.1321F, 5.0F, 10.0F, 0.0F, new Dilation(0.0F))
                .uv(18, 115).cuboid(-4.811F, -17.4301F, -1.8679F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 12.0F, 2.0F, 0.1309F, 0.0F, -0.3054F));

        ModelPartData cube_r2 = right_horn.addChild("cube_r2", ModelPartBuilder.create().uv(1, 110).cuboid(-0.811F, -17.4301F, -1.3679F, 7.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(5.0196F, 12.0622F, 1.5043F, 0.1309F, 0.0F, -0.3054F));

        ModelPartData left_horn = head.addChild("left_horn", ModelPartBuilder.create(), ModelTransform.of(6.2F, -10.0F, 0.0F, -0.2618F, 0.0F, 0.6545F));

        ModelPartData cube_r3 = left_horn.addChild("cube_r3", ModelPartBuilder.create().uv(97, 122).mirrored().cuboid(-6.189F, -19.4301F, 0.1321F, 12.0F, 6.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 118).mirrored().cuboid(4.811F, -17.4301F, 0.1321F, 5.0F, 10.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(18, 115).mirrored().cuboid(0.811F, -17.4301F, -1.8679F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-5.0F, 12.0F, 2.0F, 0.1309F, 0.0F, 0.3054F));

        ModelPartData cube_r4 = left_horn.addChild("cube_r4", ModelPartBuilder.create().uv(1, 110).mirrored().cuboid(-6.189F, -17.4301F, -1.3679F, 7.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-5.0196F, 12.0622F, 1.5043F, 0.1309F, 0.0F, 0.3054F));

        return TexturedModelData.of(meshdefinition, 128, 128);
    }

}
