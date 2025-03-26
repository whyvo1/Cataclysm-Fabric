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
public class MonstrousHelm_Model extends BipedEntityModel<LivingEntity> {
    public ModelPart helmet;

    public MonstrousHelm_Model(ModelPart p_170677_) {
        super(p_170677_);
        this.helmet = p_170677_.getChild("head").getChild("helmet");

    }

    public static TexturedModelData createArmorLayer(Dilation deformation) {
        ModelData meshdefinition = BipedEntityModel.getModelData(deformation, 0.0F);
        ModelPartData partdefinition = meshdefinition.getRoot();
        ModelPartData head = partdefinition.getChild("head");

        ModelPartData helmet = head.addChild("helmet", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.6F)), ModelTransform.pivot(0.0F, 1.0F, 0.0F));
        helmet.addChild("lefthorn", ModelPartBuilder.create().uv(0, 28).cuboid(4.0F, -6.0F, -3.0F, 2.0F, 3.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 16).cuboid(6.0F, -9.0F, -3.0F, 3.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        helmet.addChild("righthorn", ModelPartBuilder.create().uv(0, 28).mirrored().cuboid(-6.0F, -6.0F, -3.0F, 2.0F, 3.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 16).mirrored().cuboid(-9.0F, -9.0F, -3.0F, 3.0F, 6.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        return TexturedModelData.of(meshdefinition, 64, 64);
    }

}
