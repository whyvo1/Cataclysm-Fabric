package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.client.model.entity.The_Harbinger_Model;
import com.github.l_ender.cataclysm.client.render.RenderUtils;
import com.github.l_ender.cataclysm.client.render.entity.The_Harbinger_Renderer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.github.l_ender.lionfishapi.client.model.tools.AdvancedModelBox;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class The_Harbinger_Item_Layer extends FeatureRenderer<The_Harbinger_Entity, The_Harbinger_Model> {
    private AdvancedModelBox AdvancedModelBox;
    private ItemStack itemstack;
    private ModelTransformationMode transformType;

    public The_Harbinger_Item_Layer(The_Harbinger_Renderer renderIn, AdvancedModelBox AdvancedModelBox, ItemStack itemstack, ModelTransformationMode transformType) {
        super(renderIn);
        this.itemstack = itemstack;
        this.AdvancedModelBox = AdvancedModelBox;
        this.transformType = transformType;
    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, The_Harbinger_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.getIsAct()) {
            matrixStackIn.push();
            RenderUtils.matrixStackFromCitadelModel(matrixStackIn, getAdvancedModelBox());
            matrixStackIn.translate(-0.0125F, 0.0F, 0.0F);
            MinecraftClient.getInstance().getEntityRenderDispatcher().getHeldItemRenderer().renderItem(entity, getItemstack(), transformType, false, matrixStackIn, bufferIn, packedLightIn);
            matrixStackIn.pop();
        }
    }

    public ItemStack getItemstack() {
        return itemstack;
    }

    public void setItemstack(ItemStack itemstack) {
        this.itemstack = itemstack;
    }

    public AdvancedModelBox getAdvancedModelBox() {
        return AdvancedModelBox;
    }

    public void setAdvancedModelBox(AdvancedModelBox AdvancedModelBox) {
        this.AdvancedModelBox = AdvancedModelBox;
    }
}
