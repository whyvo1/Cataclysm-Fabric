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
public class Ignitium_Armor_Model extends BipedEntityModel<LivingEntity> {

    public Ignitium_Armor_Model(ModelPart p_170677_) {
        super(p_170677_);


    }

    public static TexturedModelData createArmorLayer(Dilation deformation) {
        ModelData meshdefinition = BipedEntityModel.getModelData(deformation, 0.0F);
        ModelPartData partdefinition = meshdefinition.getRoot();
        ModelPartData head = partdefinition.getChild("head");
        ModelPartData body = partdefinition.getChild("body");
        ModelPartData rightArm = partdefinition.getChild("right_arm");
        ModelPartData leftArm = partdefinition.getChild("left_arm");

        head.addChild("right_helmet", ModelPartBuilder.create()
                .uv(0, 35)
                .cuboid(0.0F, -1.5F, -4.0F, 0.0F, 3.0F, 6.0F,
                        new Dilation(0.0F)), ModelTransform
                .of(-4.75F, 0.3F, -4.75F, 0.0F, -0.829F, 0.0F));

        head.addChild("left_helmet", ModelPartBuilder.create()
                .uv(0, 35)
                        .cuboid(0.0F, -1.5F, -4.0F, 0.0F, 3.0F, 6.0F,
                                new Dilation(0.0F))
                        .mirrored(false), ModelTransform
                .of(4.75F, 0.3F, -4.75F, 0.0F, 0.829F, 0.0F));

        head.addChild("headplate", ModelPartBuilder.create()
                .uv(48, 34)
                .cuboid(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 1.0F,
                        new Dilation(0.0F)), ModelTransform
                .of(0.0F, -5.5F, -4.25F, -0.2618F, 0.0F, 0.0F));

        ModelPartData right_horn = head.addChild("right_horn", ModelPartBuilder.create()
                .uv(54, 43)
                .cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F,
                        new Dilation(0.0F)).mirrored(false), ModelTransform
                .of(-3.6F, -6.5F, -3.6F, 0.3927F, 0.2182F, -0.1309F));

        ModelPartData right_horn2 = right_horn.addChild("right_horn2", ModelPartBuilder.create()
                .uv(13, 41)
                .cuboid(-0.5F, -7.0F, 0.0F, 1.0F, 7.0F, 2.0F,
                        new Dilation(0.0F)).mirrored(false), ModelTransform
                .of(0.0F, -5.0F, -1.0F, -1.3526F, 0.0F, 0.0F));

        right_horn2.addChild("right_horn3", ModelPartBuilder.create()
                .uv(53, 37)
                .cuboid(-0.5F, 0.0F, -4.0F, 1.0F, 1.0F, 4.0F,
                        new Dilation(-0.01F))
                .mirrored(false), ModelTransform
                .of(0.0F, -7.0F, 2.0F, -0.5236F, 0.0F, 0.0F));

        ModelPartData left_horn = head.addChild("left_horn", ModelPartBuilder.create()
                .uv(54, 43)
                .cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F,
                        new Dilation(0.0F)), ModelTransform
                .of(3.6F, -6.5F, -3.6F, 0.3927F, -0.2182F, 0.1309F));

        ModelPartData left_horn2 = left_horn.addChild("left_horn2", ModelPartBuilder.create()
                .uv(13, 41)
                .cuboid(-0.5F, -7.0F, 0.0F, 1.0F, 7.0F, 2.0F,
                        new Dilation(0.0F)), ModelTransform
                .of(0.0F, -5.0F, -1.0F, -1.3526F, 0.0F, 0.0F));

        left_horn2.addChild("left_horn3", ModelPartBuilder.create()
                .uv(53, 37)
                .cuboid(-0.5F, 0.0F, -4.0F, 1.0F, 1.0F, 4.0F,
                        new Dilation(-0.01F)), ModelTransform
                .of(0.0F, -7.0F, 2.0F, -0.5236F, 0.0F, 0.0F));

        body.addChild("outer_body", ModelPartBuilder.create()
                .uv(30, 47)
                .cuboid(-4.5F, 1.0F, -2.5F, 9.0F, 12.0F, 5.0F,
                        new Dilation(0.4F)), ModelTransform
                .pivot(0.0F, -1.0F, 0.0F));

        body.addChild("inner_body", ModelPartBuilder.create()
                .uv(0, 51)
                .cuboid(-4.0F, -6.0F, -2.0F, 8.0F, 9.0F, 4.0F,
                        new Dilation(0.5F)), ModelTransform
                .pivot(0.0F, 11.0F, 0.0F));

        ModelPartData left_shoulderpad = leftArm.addChild("left_shoulderpad", ModelPartBuilder.create()
                .uv(30, 33)
                .cuboid(-6.0F, -7.0F, -3.0F, 5.0F, 7.0F, 6.0F,
                        new Dilation(0.3F)), ModelTransform
                .pivot(5.0F, 4.0F, 0.0F));

        ModelPartData left_spike = left_shoulderpad.addChild("left_spike", ModelPartBuilder.create()
                .uv(21, 43)
                .cuboid(-1.0F, -3.5F, 0.0F, 4.0F, 7.0F, 0.0F,
                        new Dilation(0.0F)), ModelTransform
                .of(-1.0F, -8.5F, 0.0F, 0.0F, 0.0F, 0.6109F));

        left_spike.addChild("left_side_spike", ModelPartBuilder.create()
                .uv(30, 47)
                .cuboid(0.5F, -3.5F, -0.5F, 2.0F, 4.0F, 0.0F,
                        new Dilation(0.0F)), ModelTransform
                .of(2.5F, 3.0F, 0.5F, 0.0F, 0.0F, 0.829F));

        ModelPartData right_shoulderpad = rightArm.addChild("right_shoulderpad", ModelPartBuilder.create()
                .uv(30, 33)
                .mirrored()
                .cuboid(0.0F, -7.0F, -3.0F, 5.0F, 7.0F, 6.0F,
                        new Dilation(0.3F)).mirrored(false), ModelTransform
                .pivot(-4.0F, 4.0F, 0.0F));

        ModelPartData right_spike = right_shoulderpad.addChild("right_spike", ModelPartBuilder.create()
                .uv(21, 43)
                .mirrored()
                .cuboid(-3.0F, -3.5F, 0.0F, 4.0F, 7.0F, 0.0F,
                        new Dilation(0.0F)).mirrored(false), ModelTransform
                .of(0.0F, -8.5F, 0.0F, 0.0F, 0.0F, -0.6109F));

        right_spike.addChild("right_side_spike", ModelPartBuilder.create()
                .uv(30, 47)
                .mirrored()
                .cuboid(-2.5F, -3.5F, -0.5F, 2.0F, 4.0F, 0.0F,
                        new Dilation(0.0F)).mirrored(false), ModelTransform
                .of(-2.5F, 3.0F, 0.5F, 0.0F, 0.0F, -0.829F));

        return TexturedModelData.of(meshdefinition, 64, 64);
    }

}
