package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Endermaptera_Model;
import com.github.l_ender.cataclysm.client.render.layer.LayerGenericGlowing;

import com.github.l_ender.cataclysm.entity.AnimationMonster.Endermaptera_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityPose;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Endermaptera_Renderer extends MobEntityRenderer<Endermaptera_Entity, Endermaptera_Model> {

    private static final Identifier SSAPBUG_TEXTURES = Cataclysm.modIdentifier("textures/entity/ender_ssap_bug.png");
    private static final Identifier SSAPBUG_LAYER_TEXTURES = Cataclysm.modIdentifier("textures/entity/ender_ssap_bug_layer.png");

    public Endermaptera_Renderer(Context renderManagerIn) {
        super(renderManagerIn, new Endermaptera_Model(), 0.7F);
        this.addFeature(new LayerGenericGlowing(this, SSAPBUG_LAYER_TEXTURES));

    }
    @Override
    public Identifier getTexture(Endermaptera_Entity entity) {
        return SSAPBUG_TEXTURES;
    }

    @Override
    protected void scale(Endermaptera_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }

    protected void setupTransforms(Endermaptera_Entity entityLiving, MatrixStack matrixStackIn, float p_115319_, float rotationYaw, float p_115321_, float p_320045_) {
        if (this.isShaking(entityLiving)) {
            rotationYaw += (float)(Math.cos((double)entityLiving.age * 3.25D) * Math.PI * (double)0.4F);
        }
        float trans = 0.5F;
        EntityPose pose = entityLiving.getPose();
        if (pose != EntityPose.SLEEPING) {
            float progresso = 1F - (entityLiving.prevAttachChangeProgress + (entityLiving.attachChangeProgress - entityLiving.prevAttachChangeProgress) * p_115321_);

            if(entityLiving.getAttachmentFacing() == Direction.DOWN){
                matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees (180.0F - rotationYaw));
                matrixStackIn.translate(0.0D, trans, 0.0D);
                if(entityLiving.prevY < entityLiving.getY()){
                    matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90 * (1 - progresso)));
                }else{
                    matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90 * (1 - progresso)));
                }
                matrixStackIn.translate(0.0D, -trans, 0.0D);

            }else if(entityLiving.getAttachmentFacing() == Direction.UP){
                matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees (180.0F - rotationYaw));
                matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
                matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
                matrixStackIn.translate(0.0D, -trans, 0.0D);

            }else{
                matrixStackIn.translate(0.0D, trans, 0.0D);
                switch (entityLiving.getAttachmentFacing()){
                    case NORTH:
                        matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F * progresso));
                        matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(0));
                        break;
                    case SOUTH:
                        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
                        matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F * progresso ));
                        break;
                    case WEST:
                        matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
                        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90F - 90.0F * progresso));
                        matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-90.0F));
                        break;
                    case EAST:
                        matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F ));
                        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F * progresso - 90F));
                        matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
                        break;
                }
                if(entityLiving.getVelocity().y <= -0.001F){
                    matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-180.0F));
                }
                matrixStackIn.translate(0.0D, -trans, 0.0D);
            }
        }

        if (entityLiving.deathTime > 0) {
            float f = ((float)entityLiving.deathTime + p_115321_ - 1.0F) / 20.0F * 1.6F;
            f = MathHelper.sqrt(f);
            if (f > 1.0F) {
                f = 1.0F;
            }

            matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f * this.getLyingAngle(entityLiving)));
        } else if (entityLiving.isUsingRiptide()) {
            matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90.0F - entityLiving.getPitch()));
            matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(((float)entityLiving.age + p_115321_) * -75.0F));
        } else if (pose == EntityPose.SLEEPING) {

        } else if (entityLiving.hasCustomName() ) {
            String s = Formatting.strip(entityLiving.getName().getString());
            if (("Dinnerbone".equals(s) || "Grumm".equals(s))) {
                matrixStackIn.translate(0.0D, entityLiving.getHeight() + 0.1F, 0.0D);
                matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180.0F));
            }
        }
    }

}