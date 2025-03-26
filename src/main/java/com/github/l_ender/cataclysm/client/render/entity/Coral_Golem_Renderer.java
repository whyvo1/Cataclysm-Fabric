package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Coral_Golem_Model;
import com.github.l_ender.cataclysm.entity.Deepling.Coral_Golem_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Coral_Golem_Renderer extends MobEntityRenderer<Coral_Golem_Entity, Coral_Golem_Model> {

    private static final Identifier CORALSSUS_TEXTURES = Cataclysm.modIdentifier("textures/entity/deepling/coral_golem.png");

    public Coral_Golem_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Coral_Golem_Model(), 1.5F);

    }
    @Override
    public Identifier getTexture(Coral_Golem_Entity entity) {
        return CORALSSUS_TEXTURES;
    }

    @Override
    protected void scale(Coral_Golem_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.75F, 1.75F, 1.75F);
    }
}

