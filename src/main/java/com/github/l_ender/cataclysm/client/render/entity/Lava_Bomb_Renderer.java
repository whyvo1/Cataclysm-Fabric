package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Lava_Bomb_Model;
import com.github.l_ender.cataclysm.entity.projectile.Lava_Bomb_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Quaternionf;


@Environment(EnvType.CLIENT)
public class Lava_Bomb_Renderer extends EntityRenderer<Lava_Bomb_Entity> {

    private static final Identifier FIRE_BOMB_TEXTURES = Cataclysm.modIdentifier("textures/entity/fire_bomb.png");
    private final Lava_Bomb_Model model = new Lava_Bomb_Model();


    public Lava_Bomb_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public void render(Lava_Bomb_Entity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.multiply((new Quaternionf()).setAngleAxis(entityYaw * ((float)Math.PI / 180F), 0, -1.0F, 0));
        matrixStackIn.translate(0.0D, 0.25F, 0.0D);
        float scale = entityIn.isOnGround() ? 0F : 1F;
        matrixStackIn.scale(scale,scale,scale);
        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevYaw, entityIn.getYaw()) - 180.0F));
        matrixStackIn.multiply(RotationAxis.POSITIVE_X.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevPitch, entityIn.getPitch())));
        VertexConsumer VertexConsumer = bufferIn.getBuffer(RenderLayer.getEntityTranslucent(this.getTexture(entityIn)));
        model.setAngles(entityIn, 0, 0, entityIn.age + partialTicks, 0, 0);
        model.render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV);
        matrixStackIn.pop();
    }

    protected int getBlockLight(Lava_Bomb_Entity entityIn, BlockPos pos) {
        return 15;
    }

    @Override
    public Identifier getTexture(Lava_Bomb_Entity entity) {
        return FIRE_BOMB_TEXTURES;
    }
}
