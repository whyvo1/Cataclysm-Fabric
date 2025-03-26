package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.The_Baby_Leviathan_Model;
import com.github.l_ender.cataclysm.entity.Pet.The_Baby_Leviathan_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class The_Baby_Leviathan_Renderer extends MobEntityRenderer<The_Baby_Leviathan_Entity, The_Baby_Leviathan_Model> {

    private static final Identifier BABY_LEVIATHAN_TEXTURES = Cataclysm.modIdentifier("textures/entity/leviathan/the_baby_leviathan.png");

    public The_Baby_Leviathan_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new The_Baby_Leviathan_Model(), 0.25F);
    }
    @Override
    public Identifier getTexture(The_Baby_Leviathan_Entity entity) {
        return BABY_LEVIATHAN_TEXTURES;
    }

    @Override
    protected void scale(The_Baby_Leviathan_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1F, 1F, 1F);
    }

}

