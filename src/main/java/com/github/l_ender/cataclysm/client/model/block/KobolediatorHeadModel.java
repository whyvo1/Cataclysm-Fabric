package com.github.l_ender.cataclysm.client.model.block;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class KobolediatorHeadModel extends Cataclysm_Skull_Model_Base {
    private final ModelPart head;
    private final ModelPart jaw;

    public KobolediatorHeadModel(ModelPart p_171097_) {
        this.head = p_171097_.getChild("head");
        this.jaw = this.head.getChild("jaw");
    }

    public static TexturedModelData createHeadLayer() {
        ModelData meshdefinition = new ModelData();
        ModelPartData partdefinition = meshdefinition.getRoot();

        ModelPartData head = partdefinition.addChild("head", ModelPartBuilder.create().uv(24, 119).cuboid(-5.0F, -9.0F, -6.0513F, 10.0F, 7.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.0F, 0.0F));

        ModelPartData head_cube1 = head.addChild("head_cube1", ModelPartBuilder.create().uv(36, 100).cuboid(0.8F, -5.0F, -8.0F, 6.0F, 6.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.7831F, -8.0F, 1.9487F, 0.1616F, 0.1866F, -0.0568F));

        ModelPartData head_cube2 = head.addChild("head_cube2", ModelPartBuilder.create().uv(62, 38).cuboid(1.0F, -6.0F, -12.0F, 6.0F, 6.0F, 28.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -9.0F, 1.9487F, 0.48F, 0.0F, 0.0F));

        ModelPartData head_cube3 = head.addChild("head_cube3", ModelPartBuilder.create().uv(125, 113).cuboid(-6.8F, -5.0F, -8.0F, 6.0F, 6.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(-0.7832F, -8.0F, 1.9487F, 0.1616F, -0.1866F, 0.0568F));

        ModelPartData head_cube4 = head.addChild("head_cube4", ModelPartBuilder.create().uv(102, 49).cuboid(-3.0F, -34.0F, -23.0F, 9.0F, 7.0F, 10.0F, new Dilation(-0.01F)), ModelTransform.of(-1.5F, 24.0F, 8.9487F, 0.0436F, 0.0F, 0.0F));

        ModelPartData right_horn = head.addChild("right_horn", ModelPartBuilder.create().uv(148, 105).cuboid(-9.2168F, -9.0F, 4.0513F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F))
                .uv(148, 40).cuboid(-9.2168F, -9.0F, -1.9487F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
                .uv(129, 0).cuboid(-9.2168F, -3.0F, -1.9487F, 12.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.7832F, -11.0F, 0.9487F));

        ModelPartData left_horn = head.addChild("left_horn", ModelPartBuilder.create().uv(148, 52).cuboid(4.2168F, -9.0F, 4.0513F, 5.0F, 5.0F, 6.0F, new Dilation(0.0F))
                .uv(96, 146).cuboid(3.2168F, -9.0F, -1.9487F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
                .uv(123, 93).cuboid(-2.7832F, -3.0F, -1.9487F, 12.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(2.7831F, -11.0F, 0.9487F));

        ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create().uv(102, 29).cuboid(-2.7168F, -4.0F, -12.0F, 7.0F, 4.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.7832F, 0.0F, -2.0513F));

        return TexturedModelData.of(meshdefinition, 256, 256);
    }


    public KobolediatorHeadModel withAnimations(LivingEntity entity){
        float partialTick = MinecraftClient.getInstance().getTickDelta();
        float limbSwingAmount = entity.limbAnimator.getSpeed(partialTick);
        float limbSwing = entity.limbAnimator.getPos() + partialTick;
        setAngles(entity.age + partialTick, 0, 0);
        return  this;
    }

    public void setAngles(float p_104188_, float p_104189_, float p_104190_) {
        this.jaw.pitch = (float)(Math.sin((double)(p_104188_ * (float)Math.PI * 0.2F)) + 1.0D) * 0.2F;
        this.head.yaw = p_104189_ * ((float)Math.PI / 180F);
        this.head.pitch = p_104190_ * ((float)Math.PI / 180F);
    }

    public void render(MatrixStack p_104192_, VertexConsumer p_104193_, int p_104194_, int p_104195_, float p_104196_, float p_104197_, float p_104198_, float p_104199_) {
        p_104192_.push();
        p_104192_.translate(0.0F, -0.374375F, 0.0F);
        p_104192_.scale(0.75F, 0.75F, 0.75F);
        this.head.render(p_104192_, p_104193_, p_104194_, p_104195_, p_104196_, p_104197_, p_104198_, p_104199_);
        p_104192_.pop();
    }


}
