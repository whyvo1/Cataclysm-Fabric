package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.model.entity.Ancient_Remnant_Rework_Model;
import com.github.l_ender.cataclysm.client.render.layer.Ancient_Remnant_Layer;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Ancient_Remnant_Rework_Renderer extends MobEntityRenderer<Ancient_Remnant_Entity, Ancient_Remnant_Rework_Model> {
    private static final Identifier REMNANT_TEXTURES = Cataclysm.modIdentifier("textures/entity/ancient_remnant/ancient_remnant.png");
    private final Random rnd = Random.create();

    public Ancient_Remnant_Rework_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Ancient_Remnant_Rework_Model(renderManagerIn.getPart(CMModelLayers.ANCIENT_REMNANT_MODEL)), 1.5F);
        this.addFeature(new Ancient_Remnant_Layer(this));
    }

    @Override
    public Identifier getTexture(Ancient_Remnant_Entity entity) {
        return REMNANT_TEXTURES;
    }


    @Override
    protected float getLyingAngle(Ancient_Remnant_Entity entity) {
        return 0;
    }

}

