package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Nameless_Sorcerer_Model;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Nameless_Sorcerer_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Nameless_Sorcerer_Renderer extends MobEntityRenderer<Nameless_Sorcerer_Entity, Nameless_Sorcerer_Model> {

    private static final Identifier NAMELESS_SORCERER_TEXTURES = Cataclysm.modIdentifier("textures/entity/nameless_sorcerer.png");

    public Nameless_Sorcerer_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Nameless_Sorcerer_Model(), 0.5F);

    }
    @Override
    public Identifier getTexture(Nameless_Sorcerer_Entity entity) {
        return NAMELESS_SORCERER_TEXTURES;
    }

    @Override
    protected void scale(Nameless_Sorcerer_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.9375F, 0.9375F, 0.9375F);
    }

}
