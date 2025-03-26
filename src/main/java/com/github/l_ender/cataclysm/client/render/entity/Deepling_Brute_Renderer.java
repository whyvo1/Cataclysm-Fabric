package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Deepling_Brute_Model;
import com.github.l_ender.cataclysm.client.render.layer.AbstractDeepling_Layer;
import com.github.l_ender.cataclysm.client.render.layer.LayerDeeplingBruteItem;
import com.github.l_ender.cataclysm.entity.Deepling.Deepling_Brute_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityPose;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Deepling_Brute_Renderer extends MobEntityRenderer<Deepling_Brute_Entity, Deepling_Brute_Model> {

    private static final Identifier SSAPBUG_TEXTURES = Cataclysm.modIdentifier("textures/entity/deepling/deepling_brute.png");
    private static final Identifier DEEPLING_LAYER_TEXTURES  = Cataclysm.modIdentifier("textures/entity/deepling/deepling_brute_layer.png");
    public Deepling_Brute_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Deepling_Brute_Model(), 0.7F);
        this.addFeature(new AbstractDeepling_Layer(this,DEEPLING_LAYER_TEXTURES));
        this.addFeature(new LayerDeeplingBruteItem(this, renderManagerIn.getHeldItemRenderer()));

    }
    @Override
    public Identifier getTexture(Deepling_Brute_Entity entity) {
        return SSAPBUG_TEXTURES;
    }

    @Override
    protected void scale(Deepling_Brute_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.125F, 1.125F, 1.125F);
    }



    @Override
    protected void setupTransforms(Deepling_Brute_Entity p_115317_, MatrixStack p_115318_, float p_115319_, float p_115320_, float p_115321_) {
        if (this.isShaking(p_115317_)) {
            p_115320_ += (float)(Math.cos((double)p_115317_.age * 3.25D) * Math.PI * (double)0.4F);
        }

        if (!p_115317_.isInPose(EntityPose.SLEEPING)) {
            p_115318_.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F - p_115320_));
        }

        if (p_115317_.deathTime > 0) {
            float f = ((float)p_115317_.deathTime + p_115321_ - 1.0F) / 20.0F * 1.6F;
            f = MathHelper.sqrt(f);
            if (f > 1.0F) {
                f = 1.0F;
            }

            p_115318_.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f * this.getLyingAngle(p_115317_)));
        } else if (p_115317_.isUsingRiptide()|| p_115317_.getSpinAttack()) {
            p_115318_.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90.0F - p_115317_.getPitch()));
            p_115318_.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(((float)p_115317_.age + p_115321_) * -75.0F));
        } else if (p_115317_.isInPose(EntityPose.SLEEPING)) {
            Direction direction = p_115317_.getSleepingDirection();
            float f1 = direction != null ? getYaw(direction) : p_115320_;
            p_115318_.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f1));
            p_115318_.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(this.getLyingAngle(p_115317_)));
            p_115318_.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(270.0F));
        } else if (shouldFlipUpsideDown(p_115317_)) {
            p_115318_.translate(0.0F, p_115317_.getHeight() + 0.1F, 0.0F);
            p_115318_.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180.0F));
        }

    }

    private static float getYaw(Direction p_115329_) {
        return switch (p_115329_) {
            case SOUTH -> 90.0F;
            case WEST -> 0.0F;
            case NORTH -> 270.0F;
            case EAST -> 180.0F;
            default -> 0.0F;
        };
    }
}