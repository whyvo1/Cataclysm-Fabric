package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.model.entity.Flare_Bomb_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.entity.projectile.Flare_Bomb_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.joml.Quaternionf;


@Environment(EnvType.CLIENT)
public class Flare_Bomb_Renderer extends EntityRenderer<Flare_Bomb_Entity> {

    private static final Identifier OUTER_TEXTURES = Cataclysm.modIdentifier("textures/entity/monstrosity/flare_bomb_outer.png");

    private static final Identifier INNER_TEXTURES = Cataclysm.modIdentifier("textures/entity/monstrosity/flare_bomb_inner.png");

    private final Flare_Bomb_Model model;

    public Flare_Bomb_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn);
        model = new Flare_Bomb_Model(renderManagerIn.getPart(CMModelLayers.FLARE_BOMB_MODEL));
    }


    @Override
    public void render(Flare_Bomb_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.multiply((new Quaternionf()).setAngleAxis(entityYaw * ((float)Math.PI / 180F), 0, -1.0F, 0));
        VertexConsumer VertexConsumer = bufferIn.getBuffer(CMRenderTypes.CMEyes(this.getTexture(entityIn)));
        model.setAngles(entityIn, 0, 0, entityIn.age + partialTicks, 0, 0);
        model.render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(CMRenderTypes.CMEyes(OUTER_TEXTURES));
        model.render(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.DEFAULT_UV, 1, 1, 1, 0.4F);
        matrixStackIn.pop();
    }

    protected int getBlockLight(Flare_Bomb_Entity entityIn, BlockPos pos) {
        return 15;
    }

    @Override
    public Identifier getTexture(Flare_Bomb_Entity entity) {
        return INNER_TEXTURES;
    }
}
