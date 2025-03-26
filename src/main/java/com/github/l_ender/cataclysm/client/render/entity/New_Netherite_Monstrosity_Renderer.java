package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.model.entity.Netherite_Monstrosity_Model;
import com.github.l_ender.cataclysm.client.render.layer.Netherite_Monstrosity_Flare;
import com.github.l_ender.cataclysm.client.render.layer.Netherite_Monstrosity_Layer;
import com.github.l_ender.cataclysm.client.render.layer.Netherite_Monstrosity_Layer2;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Part;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


@Environment(EnvType.CLIENT)
public class New_Netherite_Monstrosity_Renderer extends MobEntityRenderer<Netherite_Monstrosity_Entity, Netherite_Monstrosity_Model> {

    private static final Identifier NETHER_MONSTROSITY_TEXTURES = Cataclysm.modIdentifier("textures/entity/monstrosity/netherite_monstrosity.png");

    public New_Netherite_Monstrosity_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Netherite_Monstrosity_Model(renderManagerIn.getPart(CMModelLayers.NETHERITE_MONSTROSITY_MODEL)), 2.5F);
        this.addFeature(new Netherite_Monstrosity_Layer(this));
        this.addFeature(new Netherite_Monstrosity_Layer2(this));
        this.addFeature(new Netherite_Monstrosity_Flare(this));
    }
    @Override
    public Identifier getTexture(Netherite_Monstrosity_Entity entity) {
        return NETHER_MONSTROSITY_TEXTURES;
    }

    public boolean shouldRender(Netherite_Monstrosity_Entity livingEntityIn, Frustum camera, double camX, double camY, double camZ) {
        if (super.shouldRender(livingEntityIn, camera, camX, camY, camZ)) {
            return true;
        } else {
            for(Netherite_Monstrosity_Part part : livingEntityIn.monstrosityParts){
                if(camera.isVisible(part.getBoundingBox())){
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    protected void scale(Netherite_Monstrosity_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1F, 1F, 1F);
    }

    @Override
    protected float getLyingAngle(Netherite_Monstrosity_Entity entity) {
        return 0;
    }

}
