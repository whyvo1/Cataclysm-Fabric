package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Ender_Golem_Model;
import com.github.l_ender.cataclysm.client.render.layer.Ender_Golem_Layer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Golem_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Ender_Golem_Renderer extends MobEntityRenderer<Ender_Golem_Entity, Ender_Golem_Model> {

    private static final Identifier ENDER_GOLEM_TEXTURES = Cataclysm.modIdentifier("textures/entity/ender_golem.png");

    public Ender_Golem_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Ender_Golem_Model(), 1.5F);
        this.addFeature(new Ender_Golem_Layer(this));

    }
    @Override
    public Identifier getTexture(Ender_Golem_Entity entity) {
        return ENDER_GOLEM_TEXTURES;
    }

    @Override
    protected void scale(Ender_Golem_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1F, 1F, 1F);
    }

    @Override
    protected float getLyingAngle(Ender_Golem_Entity entity) {
        return 0;
    }

}

