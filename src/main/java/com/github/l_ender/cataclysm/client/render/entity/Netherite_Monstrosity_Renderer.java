package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Old_Netherite_Monstrosity_Model;
import com.github.l_ender.cataclysm.client.render.layer.Old_Netherite_Monstrosity_Layer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Old_Netherite_Monstrosity_Entity;
import com.github.l_ender.cataclysm.entity.partentity.Old_Netherite_Monstrosity_Part;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Netherite_Monstrosity_Renderer extends MobEntityRenderer<Old_Netherite_Monstrosity_Entity, Old_Netherite_Monstrosity_Model> {

    private static final Identifier NETHER_MONSTROSITY_TEXTURES = Cataclysm.modIdentifier("textures/entity/netherite_monstrosity.png");

    public Netherite_Monstrosity_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Old_Netherite_Monstrosity_Model(), 2.5F);
        this.addFeature(new Old_Netherite_Monstrosity_Layer(this));

    }
    @Override
    public Identifier getTexture(Old_Netherite_Monstrosity_Entity entity) {
        return NETHER_MONSTROSITY_TEXTURES;
    }

    public boolean shouldRender(Old_Netherite_Monstrosity_Entity livingEntityIn, Frustum camera, double camX, double camY, double camZ) {
        if (super.shouldRender(livingEntityIn, camera, camX, camY, camZ)) {
            return true;
        } else {
            for(Old_Netherite_Monstrosity_Part part : livingEntityIn.monstrosityParts){
                if(camera.isVisible(part.getBoundingBox())){
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    protected void scale(Old_Netherite_Monstrosity_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1F, 1F, 1F);
    }

    @Override
    protected float getLyingAngle(Old_Netherite_Monstrosity_Entity entity) {
        return 0;
    }

}
