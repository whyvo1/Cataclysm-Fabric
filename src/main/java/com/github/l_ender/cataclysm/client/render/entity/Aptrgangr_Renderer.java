package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.model.entity.Aptrgangr_Model;
import com.github.l_ender.cataclysm.client.render.layer.*;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Aptrgangr_Renderer extends MobEntityRenderer<Aptrgangr_Entity, Aptrgangr_Model> {
    private final Random rnd = Random.create();
    private static final Identifier APTRGANGR_TEXTURES = Cataclysm.modIdentifier("textures/entity/draugar/aptrgangr.png");

    public Aptrgangr_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Aptrgangr_Model(renderManagerIn.getPart(CMModelLayers.APTRGANGR_MODEL)), 1.25F);
        this.addFeature(new AptrgangrRiderLayer(this));
        this.addFeature(new Aptrgangr_Layer(this));

    }
    public Vec3d getRenderOffset(Aptrgangr_Entity entityIn, float partialTicks) {
        if (entityIn.getAttackState() == 4) {
            double d0 = 0.01D;
            return new Vec3d(this.rnd.nextGaussian() * d0, this.rnd.nextGaussian() * d0, this.rnd.nextGaussian() * d0);
        } else {
            return super.getPositionOffset(entityIn, partialTicks);
        }
    }

    @Override
    public Identifier getTexture(Aptrgangr_Entity entity) {
        return APTRGANGR_TEXTURES;
    }

    @Override
    protected float getLyingAngle(Aptrgangr_Entity entity) {
        return 0;
    }

    @Override
    protected void scale(Aptrgangr_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.35F, 1.35F, 1.35F);
    }
}

