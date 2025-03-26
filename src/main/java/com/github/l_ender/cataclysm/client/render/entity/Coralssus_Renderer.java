package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Coralssus_Model;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.Coralssus_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Coralssus_Renderer extends MobEntityRenderer<Coralssus_Entity, Coralssus_Model> {

    private static final Identifier FIRE_TEXTURE = Cataclysm.modIdentifier("textures/entity/deepling/coralssus_fire.png");
    private static final Identifier HORN_TEXTURE = Cataclysm.modIdentifier("textures/entity/deepling/coralssus_horn.png");
    private static final Identifier TUBE_TEXTURE = Cataclysm.modIdentifier("textures/entity/deepling/coralssus_tube.png");
    private static final Identifier SPONGE_TEXTURE = Cataclysm.modIdentifier("textures/entity/deepling/coralssus_sponge_horn.png");


    public Coralssus_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Coralssus_Model(), 1.7F);

    }
    @Override
    public Identifier getTexture(Coralssus_Entity entity) {
        if (entity.isSponge()) {
            return SPONGE_TEXTURE;
        } else {
            Identifier resourcelocation = switch (entity.getVariant()) {
                case FIRE -> FIRE_TEXTURE;
                case HORN -> HORN_TEXTURE;
                case TUBE -> TUBE_TEXTURE;
                default -> throw new IncompatibleClassChangeError();
            };

            return resourcelocation;
        }
    }

    @Override
    protected float getLyingAngle(Coralssus_Entity entity) {
        return 0;
    }

    @Override
    protected void scale(Coralssus_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.35F, 1.35F, 1.35F);
    }
}

