package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.model.entity.Laser_Beam_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.entity.projectile.Laser_Beam_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class Laser_Beam_Renderer extends EntityRenderer<Laser_Beam_Entity> {

    private static final Identifier TEXTURE_RED = Cataclysm.modIdentifier("textures/entity/harbinger/laser_beam.png");
    private static final RenderLayer RENDER_TYPE_RED = CMRenderTypes.CMEyes(TEXTURE_RED);
    public Laser_Beam_Model model;

    public Laser_Beam_Renderer(EntityRendererFactory.Context mgr) {
        super(mgr);
        this.model = new Laser_Beam_Model(mgr.getPart(CMModelLayers.LASER_BEAM_MODEL));
    }

    @Override
    public void render(Laser_Beam_Entity entity, float entityYaw, float partialTicks, MatrixStack poseStack, VertexConsumerProvider buffer, int packedLight) {
        poseStack.push();
        poseStack.scale(-1.0F, -1.0F, 1.0F);
        float f = MathHelper.lerpAngleDegrees(partialTicks, entity.prevYaw, entity.getYaw());
        float f1 = MathHelper.lerp(partialTicks, entity.prevPitch, entity.getPitch());
        this.model.setAngles(f, f1);
        VertexConsumer vertexconsumer = buffer.getBuffer(RENDER_TYPE_RED);
        //  this.model.setupAnim(f, f1);
        this.model.render(poseStack, vertexconsumer, packedLight, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.pop();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public Identifier getTexture(Laser_Beam_Entity entity) {
        return TEXTURE_RED;
    }
}
