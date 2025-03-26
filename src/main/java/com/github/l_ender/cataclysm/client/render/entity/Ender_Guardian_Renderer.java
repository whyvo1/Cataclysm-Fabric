package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Ender_Guardian_Model;
import com.github.l_ender.cataclysm.client.render.layer.Ender_Guardian_Layer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Guardian_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Ender_Guardian_Renderer extends MobEntityRenderer<Ender_Guardian_Entity, Ender_Guardian_Model> {

    private static final Identifier ENDER_GUARDIAN_TEXTURES = Cataclysm.modIdentifier("textures/entity/ender_guardian.png");

    public Ender_Guardian_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Ender_Guardian_Model(), 1.5F);
        this.addFeature(new Ender_Guardian_Layer(this));

    }
    @Override
    public Identifier getTexture(Ender_Guardian_Entity entity) {
        return ENDER_GUARDIAN_TEXTURES;
    }

    @Override
    protected void scale(Ender_Guardian_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1F, 1F, 1F);
    }

    @Override
    protected float getLyingAngle(Ender_Guardian_Entity entity) {
        return 0;
    }

}

