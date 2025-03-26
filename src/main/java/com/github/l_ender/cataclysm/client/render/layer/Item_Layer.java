package com.github.l_ender.cataclysm.client.render.layer;

import com.github.l_ender.cataclysm.client.render.RenderUtils;
import com.github.l_ender.lionfishapi.client.model.tools.AdvancedModelBox;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class Item_Layer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {
    private AdvancedModelBox AdvancedModelBox;
    private ItemStack itemstack;
    private ModelTransformationMode transformType;

    public Item_Layer(FeatureRendererContext<T, M> renderer, AdvancedModelBox AdvancedModelBox, ItemStack itemstack, ModelTransformationMode transformType) {
        super(renderer);
        this.itemstack = itemstack;
        this.AdvancedModelBox = AdvancedModelBox;
        this.transformType = transformType;
    }

    @Override
    public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!AdvancedModelBox.showModel) return;
        matrixStackIn.push();
        RenderUtils.matrixStackFromCitadelModel(matrixStackIn, getAdvancedModelBox());
        MinecraftClient.getInstance().getEntityRenderDispatcher().getHeldItemRenderer().renderItem(entitylivingbaseIn, getItemstack(), transformType, false, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.pop();
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
