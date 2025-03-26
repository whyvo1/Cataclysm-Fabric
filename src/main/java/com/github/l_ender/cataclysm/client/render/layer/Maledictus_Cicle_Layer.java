package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Maledictus_Model;
import com.github.l_ender.cataclysm.client.render.entity.Maledictus_Renderer;
import com.github.l_ender.cataclysm.client.render.etc.LightningBoltData;
import com.github.l_ender.cataclysm.client.render.etc.LightningRender;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static net.minecraft.client.render.OverlayTexture.DEFAULT_UV;

@Environment(EnvType.CLIENT)
public class Maledictus_Cicle_Layer extends FeatureRenderer<Maledictus_Entity, Maledictus_Model> {
    protected final EntityRenderDispatcher entityRenderDispatcher;

    private Map<UUID, LightningRender> lightningRenderMap = new HashMap<>();
    private final Random rnd = Random.create();
    public Maledictus_Cicle_Layer(Maledictus_Renderer renderIn, EntityRendererFactory.Context context) {
        super(renderIn);
        entityRenderDispatcher = context.getRenderDispatcher();
    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Maledictus_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        rendercicle(matrixStackIn,bufferIn,packedLightIn,entity ,true);
        rendercicle(matrixStackIn,bufferIn,packedLightIn,entity ,false);
        renderLightning(matrixStackIn,bufferIn,entity,partialTicks ,true);
        renderLightning(matrixStackIn,bufferIn,entity,partialTicks ,false);
    }


    private void rendercicle(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Maledictus_Entity entity, boolean right){
        Quaternionf camera = this.entityRenderDispatcher.getRotation();
        matrixStackIn.push();
        matrixStackIn.push();

        Vec3d offset = new Vec3d(0, 0.0F, 0F);
        Vec3d ridePos = getRiderPosition(offset,right);
        matrixStackIn.translate(ridePos.x, ridePos.y, ridePos.z);
        matrixStackIn.multiply(camera);
        matrixStackIn.translate(0.0F, -0.1F, 0.0F);
        matrixStackIn.scale(0.9F, 0.9F, 0.9F);
        MatrixStack.Entry posestack$pose = matrixStackIn.peek();
        Matrix4f matrix4f = posestack$pose.getPositionMatrix();
        Matrix3f matrix3f = posestack$pose.getNormalMatrix();
        VertexConsumer portalStatic = bufferIn.getBuffer(RenderLayer.getEntityTranslucent(Cataclysm.modIdentifier( "textures/particle/ring_1.png"),true));
        matrixStackIn.translate(0.0F, 0.1F, 0.0F);
        if (entity.attackTicks > 1 ) {
            if (entity.getAttackState() == 1) {
                if (entity.attackTicks <= 50) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.95f, 0.5215f, 0.1333F);
                }
            }
            if (entity.getAttackState() == 2) {
                if (entity.attackTicks <= 50) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.09f, 0.42f, 0.35F);
                }
            }
            if (entity.getAttackState() == 3) {
                if (entity.attackTicks >= 15 && entity.attackTicks <= 65) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.09f, 0.42f, 0.35F);
                }
            }
            if (entity.getAttackState() == 7) {
                if (entity.attackTicks <= 50) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }
            if (entity.getAttackState() == 8) {
                if (entity.attackTicks <= 50) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }
            if (entity.getAttackState() == 12 || entity.getAttackState() == 13 || entity.getAttackState() == 14 || entity.getAttackState() == 11) {
                if (entity.attackTicks <= 50) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }
            if (entity.getAttackState() == 15 || entity.getAttackState() == 16) {
                if (entity.attackTicks <= 50) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }
            if (entity.getAttackState() == 18) {
                if (entity.attackTicks <= 21) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.09f, 0.42f, 0.35F);
                }
                if (entity.attackTicks >= 25 && entity.attackTicks <= 34) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.95f, 0.5215f, 0.1333F);
                }
            }
            if (entity.getAttackState() == 19) {
                if (entity.attackTicks <= 10) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.09f, 0.42f, 0.35F);
                }
                if (entity.attackTicks >= 13 && entity.attackTicks <= 20) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.95f, 0.5215f, 0.1333F);
                }
            }
            if (entity.getAttackState() == 21) {
                if (entity.attackTicks <= 10) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
                if (entity.attackTicks >= 13 && entity.attackTicks <= 20) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }
            if (entity.getAttackState() == 22 || entity.getAttackState() == 23) {
                if (entity.attackTicks <= 21) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.95f, 0.5215f, 0.1333F);
                }
            }
            if (entity.getAttackState() == 24) {
                if (entity.attackTicks <= 50) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }
            if (entity.getAttackState() == 27) {
                if (entity.attackTicks <= 44) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.95f, 0.5215f, 0.1333F);
                }
            }
            if (entity.getAttackState() == 28) {
                if (entity.attackTicks <= 26) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }
            if (entity.getAttackState() == 29) {
                if (entity.attackTicks <= 26) {
                    drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }

        }

        matrixStackIn.pop();
        matrixStackIn.pop();
    }


    private void renderLightning(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, Maledictus_Entity entity,float partialtick, boolean right){
        matrixStackIn.push();
        Vec3d offset = new Vec3d(0, 0.0F, 0F);
        Vec3d ridePos = getRiderPosition(offset,right);
        matrixStackIn.translate(ridePos.x, ridePos.y, ridePos.z);
        if (entity.attackTicks > 1 ) {
            if (entity.getAttackState() == 1) {
                if (entity.attackTicks <= 50) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.95f, 0.5215f, 0.1333F, partialtick);
                }
            }
            if (entity.getAttackState() == 2) {
                if (entity.attackTicks <= 50) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.09f, 0.42f, 0.35F, partialtick);
                }
            }
            if (entity.getAttackState() == 3) {
                if (entity.attackTicks >= 15 && entity.attackTicks <= 65) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.09f, 0.42f, 0.35F, partialtick);
                }
            }
            if (entity.getAttackState() == 7) {
                if (entity.attackTicks <= 50) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }
            if (entity.getAttackState() == 8) {
                if (entity.attackTicks <= 50) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }
            if (entity.getAttackState() == 12 || entity.getAttackState() == 13 || entity.getAttackState() == 14 || entity.getAttackState() == 11) {
                if (entity.attackTicks <= 50) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }
            if (entity.getAttackState() == 15 || entity.getAttackState() == 16) {
                if (entity.attackTicks <= 50) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }
            if (entity.getAttackState() == 18) {

                if (entity.attackTicks <= 21) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.09f, 0.42f, 0.35F, partialtick);
                }
                if (entity.attackTicks >= 25 && entity.attackTicks <= 34) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.95f, 0.5215f, 0.1333F, partialtick);
                }

            }
            if (entity.getAttackState() == 19) {
                if (entity.attackTicks <= 10) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.95f, 0.5215f, 0.1333F, partialtick);
                }
                if (entity.attackTicks >= 13 && entity.attackTicks <= 20) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.95f, 0.5215f, 0.1333F, partialtick);
                }
            }

            if (entity.getAttackState() == 21) {
                if (entity.attackTicks <= 10) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
                if (entity.attackTicks >= 13 && entity.attackTicks <= 20) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }

            if (entity.getAttackState() == 22 || entity.getAttackState() == 23) {
                if (entity.attackTicks <= 21) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.95f, 0.5215f, 0.1333F, partialtick);
                }
            }
            if (entity.getAttackState() == 24) {
                if (entity.attackTicks <= 50) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }
            if (entity.getAttackState() == 27) {
                if (entity.attackTicks <= 44) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.95f, 0.5215f, 0.1333F, partialtick);
                }
            }
            if (entity.getAttackState() == 28) {
                if (entity.attackTicks <= 26) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }
            if (entity.getAttackState() == 29) {
                if (entity.attackTicks <= 26) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }
        }

        matrixStackIn.pop();
    }


    private void drawLightning(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, Maledictus_Entity entity, float r, float g, float b, float partialTicks){

        matrixStackIn.push();


        double x = (rnd.nextFloat() - 0.25F);
        double y = (rnd.nextFloat() - 0.25F);
        double z = (rnd.nextFloat() - 0.25F);

        LightningBoltData.BoltRenderInfo blueBoltData = new LightningBoltData.BoltRenderInfo(0.5F, 0.1F, 0.5F, 0.85F, new Vector4f(r, g, b, 0.8F), 0.1F);

        LightningBoltData bolt1 = new LightningBoltData(blueBoltData, Vec3d.ZERO, new Vec3d(x, y, z), 8)
                .size(0.1F)
                .lifespan(1)
                .spawn(LightningBoltData.SpawnFunction.CONSECUTIVE);
        LightningRender lightningRender = getLightingRender(entity.getUuid());
        lightningRender.update(entity, bolt1, partialTicks);

        lightningRender.render(partialTicks, matrixStackIn, bufferIn);
        matrixStackIn.pop();

        if (!entity.isAlive() && lightningRenderMap.containsKey(entity.getUuid())) {
            lightningRenderMap.remove(entity.getUuid());
        }

    }


    private LightningRender getLightingRender(UUID uuid) {
        if (lightningRenderMap.get(uuid) == null) {
            lightningRenderMap.put(uuid, new LightningRender());
        }
        return lightningRenderMap.get(uuid);
    }


    private void drawCircle(VertexConsumer vertex,Matrix4f matrix4f, Matrix3f matrix3f, int packedLightIn, float r,float g,float b) {

        cirlceVertex(vertex, matrix4f, matrix3f, packedLightIn, 0.0F, 0, 0, 1, 1.0F,r,g,b);
        cirlceVertex(vertex, matrix4f, matrix3f, packedLightIn, 1.0F, 0, 1, 1, 1.0F,r,g,b);
        cirlceVertex(vertex, matrix4f, matrix3f, packedLightIn, 1.0F, 1, 1, 0, 1.0F,r,g,b);
        cirlceVertex(vertex, matrix4f, matrix3f, packedLightIn, 0.0F, 1, 0, 0, 1.0F,r,g,b);
    }

    private static void cirlceVertex(VertexConsumer vertex, Matrix4f mat4f, Matrix3f mat3f, int p_114093_, float p_114094_, int p_114095_, int p_114096_, int p_114097_, float alpha, float r,float g,float b) {
        vertex.vertex(mat4f, p_114094_ - 0.5F, (float)p_114095_ - 0.25F, 0.0F).color(r, g, b,  alpha).texture((float)p_114096_, (float)p_114097_).overlay(DEFAULT_UV).light(240).normal(mat3f, 0.0F, -1.0F, 0.0F).next();
    }


    public Vec3d getRiderPosition(Vec3d offsetIn,boolean right) {
        MatrixStack translationStack = new MatrixStack();
        translationStack.push();
        this.getContextModel().translateToHand(translationStack,right);
        Vector4f armOffsetVec = new Vector4f((float) offsetIn.x, (float) offsetIn.y, (float) offsetIn.z, 1.0F);
        armOffsetVec.mul(translationStack.peek().getPositionMatrix());
        Vec3d vec3 = new Vec3d(armOffsetVec.x(), armOffsetVec.y(), armOffsetVec.z());
        translationStack.pop();
        return vec3;
    }

}


