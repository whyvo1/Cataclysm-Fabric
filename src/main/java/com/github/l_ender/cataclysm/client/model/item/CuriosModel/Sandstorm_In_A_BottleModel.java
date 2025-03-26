package com.github.l_ender.cataclysm.client.model.item.CuriosModel;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

public class Sandstorm_In_A_BottleModel extends BipedEntityModel<LivingEntity> {
    public Sandstorm_In_A_BottleModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData createLayer(Dilation deformation) {
        ModelData meshDefinition = BipedEntityModel.getModelData(deformation, 0.0F);
        ModelPartData partDefinition = meshDefinition.getRoot();
        ModelPartData body = partDefinition.getChild("body");

        ModelPartData root = body.addChild("root", ModelPartBuilder.create().uv(65, 10).cuboid(-4.0F, -1.0F, -2.0F, 8.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(63, 16).cuboid(-1.0F, 1.0F, -2.0F, 2.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 9.0F, 0.0F));

        root.addChild("bottle", ModelPartBuilder.create().uv(75, 24).mirrored().cuboid(-1.5F, -0.5F, -1.45F, 3.0F, 1.0F, 3.0F, new Dilation(0.1F)).mirrored(false)
                .uv(63, 24).mirrored().cuboid(-1.5F, -1.0F, -1.45F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
                .uv(71, 33).mirrored().cuboid(-1.5F, 4.0F, -1.45F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
                .uv(63, 35).mirrored().cuboid(-1.0F, 0.7F, -1.05F, 2.0F, 3.0F, 2.0F, new Dilation(0.2F)).mirrored(false)
                .uv(63, 32).mirrored().cuboid(-1.0F, -2.0F, -1.05F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.5F, 0.0F, 3.55F, 0.0F, 0.0F, 0.0436F));

        root.addChild("bottle2", ModelPartBuilder.create().uv(75, 24).cuboid(-1.5F, -0.5F, -1.45F, 3.0F, 1.0F, 3.0F, new Dilation(0.1F))
                .uv(63, 24).cuboid(-1.5F, -1.0F, -1.45F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F))
                .uv(63, 35).cuboid(-1.0F, 0.7F, -1.05F, 2.0F, 3.0F, 2.0F, new Dilation(0.2F))
                .uv(63, 32).cuboid(-1.0F, -2.0F, -1.05F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(83, 33).cuboid(-1.5F, 4.0F, -1.45F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, 0.0F, 3.55F, 0.0F, 0.0F, -0.0436F));

        root.addChild("belt", ModelPartBuilder.create().uv(63, 19).cuboid(-0.9412F, -2.0F, -0.1341F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.0F, -2.0F, 0.0F, -0.2618F, 0.0F));
        return TexturedModelData.of(meshDefinition, 128, 128);

    }

    @Override
    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of();
    }

    @Override
    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of(this.body);
    }
}
