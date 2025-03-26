package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Amethyst_Crab_Model;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Amethyst_Crab_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Amethyst_Crab_Renderer extends MobEntityRenderer<Amethyst_Crab_Entity, Amethyst_Crab_Model> {

    private static final Identifier TEXTURES = Cataclysm.modIdentifier("textures/entity/amethyst_crab.png");
    private static final Identifier KRABS_TEXTURES = Cataclysm.modIdentifier("textures/entity/mr_amethyst_krabs.png");

    public Amethyst_Crab_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Amethyst_Crab_Model(), 1.5F);

    }
    @Override
    public Identifier getTexture(Amethyst_Crab_Entity entity) {
        return entity.isKrusty() ? KRABS_TEXTURES : TEXTURES;
    }

    @Override
    protected void scale(Amethyst_Crab_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1F, 1F, 1F);
    }

    @Override
    protected float getLyingAngle(Amethyst_Crab_Entity entity) {
        return 0;
    }

}

