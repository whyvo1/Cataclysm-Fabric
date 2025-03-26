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
public class Bloom_Stone_Pauldrons_Model extends BipedEntityModel<LivingEntity> {

    public Bloom_Stone_Pauldrons_Model(ModelPart p_170677_) {
        super(p_170677_);


    }

    public static TexturedModelData createArmorLayer(Dilation deformation) {
        ModelData meshdefinition = BipedEntityModel.getModelData(deformation, 0.0F);
        ModelPartData partdefinition = meshdefinition.getRoot();
        ModelPartData body = partdefinition.getChild("body");
        ModelPartData rightArm = partdefinition.getChild("right_arm");
        ModelPartData leftArm = partdefinition.getChild("left_arm");

        rightArm.addChild("RightShoulder", ModelPartBuilder.create().uv(52, 76).cuboid(-5.5F, 0.5F, -2.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.5F)), ModelTransform.of(0.75F, -2.5F, 0.0F, 0.0F, 0.0F, -0.0873F));

        ModelPartData LeftShoulder = leftArm.addChild("LeftShoulder", ModelPartBuilder.create().uv(65, 25).cuboid(0.5F, 0.5F, -3.5F, 6.0F, 5.0F, 7.0F, new Dilation(0.5F))
                .uv(28, 65).cuboid(6.5F, 0.5F, 0.0F, 4.0F, 3.0F, 0.0F, new Dilation(0.0F))
                .uv(63, 87).cuboid(1.5F, -4.5F, -1.5F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -3.5F, 0.0F, 0.0F, 0.0F, 0.1309F));

        LeftShoulder.addChild("Amethyst", ModelPartBuilder.create().uv(22, 79).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.3054F));

        LeftShoulder.addChild("Amethyst2", ModelPartBuilder.create().uv(12, 83).cuboid(-1.1F, 0.0F, -2.5F, 2.0F, 4.0F, 5.0F, new Dilation(0.5F))
                .uv(0, 65).cuboid(1.3F, 0.7F, 0.0F, 3.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(4.3F, 5.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

        ModelPartData Chest = body.addChild("Chest", ModelPartBuilder.create().uv(65, 38).cuboid(-5.0F, -3.0F, -2.0F, 10.0F, 6.0F, 4.0F, new Dilation(0.5F))
                .uv(60, 60).cuboid(-6.0F, -4.0F, -2.0F, 12.0F, 10.0F, 5.0F, new Dilation(0.0F))
                .uv(73, 76).cuboid(-2.0F, -3.0F, 2.5F, 4.0F, 4.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 79).cuboid(-2.0F, -3.0F, 2.5F, 4.0F, 4.0F, 4.0F, new Dilation(0.2F))
                .uv(48, 87).cuboid(-1.5F, 2.0F, 2.5F, 3.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 4.0F, 0.1745F, 0.0F, 0.0F));


        Chest.addChild("Chest_lush", ModelPartBuilder.create().uv(31, 76).cuboid(-3.0F, 0.0F, -4.0F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -3.8F, -6.4F, 0.1309F, 0.0F, 0.0F));

        Chest.addChild("Chest2", ModelPartBuilder.create().uv(0, 65).cuboid(-5.0F, 0.5F, -8.0F, 10.0F, 6.0F, 7.0F, new Dilation(0.6F))
                .uv(65, 49).cuboid(-5.0F, 7.1F, -8.0F, 10.0F, 2.0F, 5.0F, new Dilation(0.0F))
                .uv(65, 0).cuboid(-4.0F, -3.9F, -6.0F, 8.0F, 4.0F, 8.0F, new Dilation(0.6F)), ModelTransform.of(0.0F, -3.9F, -1.4F, 0.1309F, 0.0F, 0.0F));

        ModelPartData Waist = body.addChild("Waist", ModelPartBuilder.create().uv(35, 65).cuboid(-4.0F, -0.3F, 0.0F, 8.0F, 6.0F, 4.0F, new Dilation(0.5F)), ModelTransform.of(0.0F, 5.0F, 2.3F, -0.1745F, 0.0F, 0.0F));

        Waist.addChild("Waist_Lush", ModelPartBuilder.create().uv(65, 13).cuboid(-5.0F, 0.0F, 0.0F, 10.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

        return TexturedModelData.of(meshdefinition, 128, 128);
    }

}
