package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.The_Prowler_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.client.render.entity.The_Prowler_Renderer;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.The_Prowler_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LimbAnimator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class The_Prowler_Layer extends FeatureRenderer<The_Prowler_Entity, The_Prowler_Model> {
    private static final Identifier PROWLER_LAYER_TEXTURES = Cataclysm.modIdentifier("textures/entity/factory/the_prowler_layer.png");

    private static final Identifier[] TEXTURE_PROGRESS = new Identifier[4];

    public The_Prowler_Layer(The_Prowler_Renderer renderIn) {
        super(renderIn);
        for(int i = 0; i < 4; i++){
            TEXTURE_PROGRESS[i] = Cataclysm.modIdentifier("textures/entity/factory/the_prowler_layer_" + i + ".png");
        }
    }

    public Identifier getTextureLocation(The_Prowler_Entity entity) {
        LimbAnimator walkanimationstate = entity.limbAnimator;
        int f3 = (int) walkanimationstate.getPos(entity.age);
        return getGrowingTexture(entity, (int) ((f3 * 0.5F) % 4));
    }

    public Identifier getGrowingTexture(The_Prowler_Entity entity, int age) {
        return TEXTURE_PROGRESS[MathHelper.clamp(age, 0, 4)];
    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, The_Prowler_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            //need rework
        int f = 255 - entity.deathTime * 255 /  entity.deathtimer();
        RenderLayer eyes = CMRenderTypes.CMEyes(this.getTextureLocation(entity));
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);

        int i = ColorHelper.Argb.getArgb(255, f, f, f);

        this.getContextModel().render(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.DEFAULT_UV, i);
    }
}


