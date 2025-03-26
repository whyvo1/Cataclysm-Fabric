package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.entity.projectile.Void_Scatter_Arrow_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Void_Scatter_Arrow_Renderer extends ProjectileEntityRenderer<Void_Scatter_Arrow_Entity> {
    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/entity/void_scatter_arrow.png");

    public Void_Scatter_Arrow_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public Identifier getTexture(Void_Scatter_Arrow_Entity entity) {
        return TEXTURE;
    }
}
