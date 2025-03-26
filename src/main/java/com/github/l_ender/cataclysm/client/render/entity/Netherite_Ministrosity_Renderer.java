package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.model.entity.Netherite_Ministrosity_Model;
import com.github.l_ender.cataclysm.client.render.layer.Netherite_Ministrosity_Layer;
import com.github.l_ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Netherite_Ministrosity_Renderer extends MobEntityRenderer<Netherite_Ministrosity_Entity, Netherite_Ministrosity_Model> {

    private static final Identifier NETHER_MONSTROSITY_TEXTURES = Cataclysm.modIdentifier("textures/entity/monstrosity/netherite_ministrosity.png");

    public Netherite_Ministrosity_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Netherite_Ministrosity_Model(renderManagerIn.getPart(CMModelLayers.NETHERITE_MINISTROSITY_MODEL)), 0.5F);
        this.addFeature(new Netherite_Ministrosity_Layer(this));

    }
    @Override
    public Identifier getTexture(Netherite_Ministrosity_Entity entity) {
        return NETHER_MONSTROSITY_TEXTURES;
    }


    @Override
    protected void scale(Netherite_Ministrosity_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1F, 1F, 1F);
    }


}
