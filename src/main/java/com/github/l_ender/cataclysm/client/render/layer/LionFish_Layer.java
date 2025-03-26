package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Lionfish_Model;
import com.github.l_ender.cataclysm.client.render.CMRenderTypes;
import com.github.l_ender.cataclysm.client.render.entity.Lionfish_Renderer;
import com.github.l_ender.cataclysm.entity.Deepling.Lionfish_Entity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class LionFish_Layer extends FeatureRenderer<Lionfish_Entity, Lionfish_Model> {
	private static final Identifier LION_LAYER_TEXTURES  = Cataclysm.modIdentifier("textures/entity/deepling/lionfish_layer.png");

    public LionFish_Layer(Lionfish_Renderer renderIn) {
		super(renderIn);

	}

	@Override
	public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, Lionfish_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch)
	{
		RenderLayer eyes = CMRenderTypes.CMEyes(LION_LAYER_TEXTURES);
		VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);

		float strength = 0.5F + MathHelper.clamp(((float) Math.cos((entity.LayerTicks + partialTicks) * 0.1F)) - 0.5F, -0.5F, 0.5F);

		strength += MathHelper.lerp(partialTicks, entity.oLayerBrightness, entity.LayerBrightness) * 1 * MathHelper.PI;
		strength = MathHelper.clamp(strength, 0.1f, 1) * 255;

		int i = ColorHelper.Argb.getArgb(255, (int) strength, (int) strength, (int) strength);

		this.getContextModel().render(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.DEFAULT_UV, i);
	}


}