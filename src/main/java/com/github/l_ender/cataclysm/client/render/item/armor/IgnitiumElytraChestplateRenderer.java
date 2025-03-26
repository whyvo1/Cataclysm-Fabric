package com.github.l_ender.cataclysm.client.render.item.armor;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.armor.Ignitium_Elytra_chestplate_Model;
import com.github.l_ender.cataclysm.client.render.item.CustomArmorRenderProperties;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class IgnitiumElytraChestplateRenderer extends ModArmorRenderer<Ignitium_Elytra_chestplate_Model> {
    public static final IgnitiumElytraChestplateRenderer INSTANCE = new IgnitiumElytraChestplateRenderer();

    private final static Identifier TEXTURE = Cataclysm.modIdentifier("textures/armor/ignitium_elytra_chestplate.png");

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, ItemStack stack, LivingEntity livingEntity, EquipmentSlot slot, int light, BipedEntityModel<LivingEntity> contextModel) {
        if (armorModel == null) {
            armorModel = this.getArmorModel();
        }
        contextModel.copyBipedStateTo(armorModel);
        armorModel.withAnimations(livingEntity);
//        armorModel.setPartVisible(slot);
//        this.doExtraTransform(matrices, vertexConsumers, stack, livingEntity, slot, light, contextModel);
        ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, armorModel, this.getTexture());
    }

    @Override
    public Ignitium_Elytra_chestplate_Model getArmorModel() {
        return CustomArmorRenderProperties.ELYTRA_ARMOR;
    }

    @Override
    public Identifier getTexture() {
        return TEXTURE;
    }
}
