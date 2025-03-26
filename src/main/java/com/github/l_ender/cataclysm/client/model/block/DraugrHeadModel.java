package com.github.l_ender.cataclysm.client.model.block;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class DraugrHeadModel extends Cataclysm_Skull_Model_Base {
    private final ModelPart head;
    private final ModelPart maw;

    public DraugrHeadModel(ModelPart p_171097_) {
        this.head = p_171097_.getChild("head");
        this.maw = this.head.getChild("maw");
    }

    public static TexturedModelData createHeadLayer() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();

        ModelPartData head = partdefinition.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(92, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.2F))
                .uv(0, 32).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F))
                .uv(58, 36).cuboid(0.0F, -16.0F, 0.0F, 10.0F, 11.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 55).mirrored().cuboid(-10.0F, -13.0F, 0.0F, 6.0F, 8.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 5.0F, 0.0F));

        ModelPartData maw = head.addChild("maw", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.5F, -1.0F, -0.0873F, 0.0F, 0.2182F));

        ModelPartData body_r1 = maw.addChild("body_r1", ModelPartBuilder.create().uv(32, 6).cuboid(-3.0F, 0.0F, -4.0F, 6.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

        return TexturedModelData.of(meshdefinition, 128, 64);
    }

    public void setAngles(float p_104188_, float p_104189_, float p_104190_) {
        this.head.yaw = p_104189_ * ((float)Math.PI / 180F);
        this.head.pitch = p_104190_ * ((float)Math.PI / 180F);
    }
    @Override
    public void render(MatrixStack p_104192_, VertexConsumer p_104193_, int p_104194_, int p_104195_, int p_350947_) {
        p_104192_.push();
        p_104192_.translate(0.0F, -0.374375F, 0.0F);
        p_104192_.scale(1.0F, 1.0F, 1.0F);
        this.head.render(p_104192_, p_104193_, p_104194_, p_104195_, p_350947_);
        p_104192_.pop();
    }


}
