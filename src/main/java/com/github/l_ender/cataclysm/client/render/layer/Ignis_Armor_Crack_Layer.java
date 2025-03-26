package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Ignis_Model;
import com.github.l_ender.cataclysm.client.render.entity.Ignis_Renderer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.google.common.collect.ImmutableMap;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.Map;


@Environment(EnvType.CLIENT)
public class Ignis_Armor_Crack_Layer extends FeatureRenderer<Ignis_Entity, Ignis_Model> {

    private static final Map<Ignis_Entity.Crackiness, Identifier> resourceLocations = ImmutableMap.of(
            Ignis_Entity.Crackiness.LOW, Cataclysm.modIdentifier("textures/entity/ignis/ignis_armor_crack1.png"),
            Ignis_Entity.Crackiness.MEDIUM, Cataclysm.modIdentifier("textures/entity/ignis/ignis_armor_crack2.png"),
            Ignis_Entity.Crackiness.HIGH, Cataclysm.modIdentifier("textures/entity/ignis/ignis_armor_crack3.png"));

    public Ignis_Armor_Crack_Layer(Ignis_Renderer renderIn) {
        super(renderIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Ignis_Entity ignis, float p_117152_, float p_117153_, float p_117154_, float p_117155_, float p_117156_, float p_117157_) {
        if (!ignis.isInvisible()) {
            if(ignis.getBossPhase() > 0){
                Ignis_Entity.Crackiness ignis$crackiness = ignis.getCrackiness();
                if (ignis$crackiness != Ignis_Entity.Crackiness.NONE) {
                    Identifier resourcelocation = resourceLocations.get(ignis$crackiness);
                    renderModel(this.getContextModel(), resourcelocation, matrixStackIn, bufferIn, packedLightIn, ignis, -1);
                }
            }
        }

    }
}