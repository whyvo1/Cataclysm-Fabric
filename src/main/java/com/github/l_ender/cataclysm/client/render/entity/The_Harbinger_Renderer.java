package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.The_Harbinger_Model;
import com.github.l_ender.cataclysm.client.render.layer.The_Harbinger_Item_Layer;
import com.github.l_ender.cataclysm.client.render.layer.The_Harbinger_Layer;
import com.github.l_ender.cataclysm.client.render.layer.The_Harbinger_Shield_Layer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.Matrix4f;

@Environment(EnvType.CLIENT)
public class The_Harbinger_Renderer extends MobEntityRenderer<The_Harbinger_Entity, The_Harbinger_Model> {

    private static final Identifier HARBINGER_TEXTURES = Cataclysm.modIdentifier("textures/entity/harbinger/the_harbinger.png");
    private final Random rnd = Random.create();
    private static final float HALF_SQRT_3 = (float)(Math.sqrt(3.0D) / 2.0D);

    public The_Harbinger_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new The_Harbinger_Model(), 1.0F);
        this.addFeature(new The_Harbinger_Layer(this));
        this.addFeature(new The_Harbinger_Shield_Layer(this));
        this.addFeature(new The_Harbinger_Item_Layer(this, getModel().nether_star, Items.NETHER_STAR.getDefaultStack(), ModelTransformationMode.GROUND));
    }

    @Override
    public Identifier getTexture(The_Harbinger_Entity entity) {
        return HARBINGER_TEXTURES;
    }


    public Vec3d getRenderOffset(The_Harbinger_Entity entityIn, float partialTicks) {
        if (entityIn.getAnimation() == The_Harbinger_Entity.DEATHLASER_ANIMATION && entityIn.getAnimationTick() >= 27 && entityIn.getAnimationTick() <= 48
                || entityIn.getAnimation() == The_Harbinger_Entity.DEATH_ANIMATION
                || entityIn.getAnimation() == The_Harbinger_Entity.STUN_ANIAMATION && entityIn.getAnimationTick() <= 90 ) {
            double d0 = 0.05D;
            return new Vec3d(this.rnd.nextGaussian() * d0, 0.0D, this.rnd.nextGaussian() * d0);
        } else {
            return super.getPositionOffset(entityIn, partialTicks);
        }
    }

    @Override
    public void render(The_Harbinger_Entity entity, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        matrixStackIn.push();
        if (entity.deathTime > 0) {
            float f5 = ((float)entity.deathTime + partialTicks) / 144;
            float f7 = Math.min(f5 > 0.8F ? (f5 - 0.8F) / 0.2F : 0.0F, 1.0F);
            Random randomsource = Random.create(432L);
            VertexConsumer vertexconsumer2 = bufferIn.getBuffer(RenderLayer.getLightning());
            matrixStackIn.push();
            matrixStackIn.translate(0.0D, 1.8D, 0.0D);

            for(int i = 0; (float)i < (f5 + f5 * f5) / 2.0F * 30.0F; ++i) {
                matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(randomsource.nextFloat() * 360.0F));
                matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(randomsource.nextFloat() * 360.0F));
                matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(randomsource.nextFloat() * 360.0F));
                matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(randomsource.nextFloat() * 360.0F));
                matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(randomsource.nextFloat() * 360.0F));
                matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(randomsource.nextFloat() * 360.0F + f5 * 90.0F));
                float f3 = randomsource.nextFloat() * 5.0F + 5F + f7 * 10.0F;
                float f4 = randomsource.nextFloat() * 0.5F + 1F + f7 * 2.0F;
                Matrix4f matrix4f = matrixStackIn.peek().getPositionMatrix();
                int j = (int)(255.0F * (1.0F - f7));
                vertex01(vertexconsumer2, matrix4f, j);
                vertex2(vertexconsumer2, matrix4f, f3, f4);
                vertex3(vertexconsumer2, matrix4f, f3, f4);
                vertex01(vertexconsumer2, matrix4f, j);
                vertex3(vertexconsumer2, matrix4f, f3, f4);
                vertex4(vertexconsumer2, matrix4f, f3, f4);
                vertex01(vertexconsumer2, matrix4f, j);
                vertex4(vertexconsumer2, matrix4f, f3, f4);
                vertex2(vertexconsumer2, matrix4f, f3, f4);
            }

            matrixStackIn.pop();
        }

        matrixStackIn.pop();
        
        super.render(entity, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        
    }


    private static void vertex01(VertexConsumer p_114220_, Matrix4f p_114221_, int p_114222_) {
        p_114220_.vertex(p_114221_, 0.0F, 0.0F, 0.0F).color(255, 51, 0, p_114222_);
    }

    private static void vertex2(VertexConsumer p_114215_, Matrix4f p_114216_, float p_114217_, float p_114218_) {
        p_114215_.vertex(p_114216_, -HALF_SQRT_3 * p_114218_, p_114217_, -0.5F * p_114218_).color(255, 51, 0, 0);
    }

    private static void vertex3(VertexConsumer p_114224_, Matrix4f p_114225_, float p_114226_, float p_114227_) {
        p_114224_.vertex(p_114225_, HALF_SQRT_3 * p_114227_, p_114226_, -0.5F * p_114227_).color(255, 51, 0, 0);
    }

    private static void vertex4(VertexConsumer p_114229_, Matrix4f p_114230_, float p_114231_, float p_114232_) {
        p_114229_.vertex(p_114230_, 0.0F, p_114231_, 1.0F * p_114232_).color(255, 51, 0, 0);
    }

    protected void scale(The_Harbinger_Entity entityIn, MatrixStack p_116440_, float p_116441_) {
        float f = 2.0F;
        p_116440_.scale(f, f, f);
    }

    protected int getBlockLight(The_Harbinger_Entity entityIn, BlockPos pos) {
        return 15;
    }

    @Override
    protected float getLyingAngle(The_Harbinger_Entity entity) {
        return 0;
    }

}