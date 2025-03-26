package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Ancient_Remnant_Model;
import com.github.l_ender.cataclysm.client.render.layer.Ancient_Ancient_Remnant_Layer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ancient_Ancient_Remnant_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Ancient_Remnant_Renderer extends MobEntityRenderer<Ancient_Ancient_Remnant_Entity, Ancient_Remnant_Model> {
    private static final Identifier REMNANT_TEXTURES = Cataclysm.modIdentifier("textures/entity/ancient_remnant/ancient_remnant.png");
    private final Random rnd = Random.create();

    public Ancient_Remnant_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Ancient_Remnant_Model(), 1.5F);
        this.addFeature(new Ancient_Ancient_Remnant_Layer(this));
    }


    public Vec3d getRenderOffset(Ancient_Ancient_Remnant_Entity entityIn, float partialTicks) {
        if (entityIn.getAnimation() == Ancient_Ancient_Remnant_Entity.REMNANT_DEATH){
            if(entityIn.getAnimationTick() <= 52 && entityIn.getAnimationTick() >= 43 || entityIn.getAnimationTick() <= 73 && entityIn.getAnimationTick() >= 43) {
                double d0 = 0.04D;
                return new Vec3d(this.rnd.nextGaussian() * d0, 0.0D, this.rnd.nextGaussian() * d0);
            }
        }
        return super.getPositionOffset(entityIn, partialTicks);
    }

    @Override
    public Identifier getTexture(Ancient_Ancient_Remnant_Entity entity) {
        return REMNANT_TEXTURES;
    }


    @Override
    protected float getLyingAngle(Ancient_Ancient_Remnant_Entity entity) {
        return 0;
    }

}

