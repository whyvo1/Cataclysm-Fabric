package com.github.l_ender.cataclysm.client.render.item.armor;

import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public abstract class ModArmorRenderer<M extends BipedEntityModel<LivingEntity>> implements ArmorRenderer {

    public M armorModel;

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, ItemStack stack, LivingEntity livingEntity, EquipmentSlot slot, int light, BipedEntityModel<LivingEntity> contextModel) {
        if (armorModel == null) {
            armorModel = this.getArmorModel();
        }
        contextModel.copyBipedStateTo(armorModel);
        this.setVisible(armorModel, slot);
//        this.doExtraTransform(matrices, vertexConsumers, stack, livingEntity, slot, light, contextModel);
        ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, armorModel, this.getTexture());
    }

    public abstract M getArmorModel();

    public abstract Identifier getTexture();

    protected void setVisible(BipedEntityModel<?> bipedModel, EquipmentSlot slot) {
        bipedModel.setVisible(false);
        switch (slot) {
            case HEAD:
                bipedModel.head.visible = true;
                bipedModel.hat.visible = true;
                break;
            case CHEST:
                bipedModel.body.visible = true;
                bipedModel.rightArm.visible = true;
                bipedModel.leftArm.visible = true;
                break;
            case LEGS:
                bipedModel.body.visible = true;
                bipedModel.rightLeg.visible = true;
                bipedModel.leftLeg.visible = true;
                break;
            case FEET:
                bipedModel.rightLeg.visible = true;
                bipedModel.leftLeg.visible = true;
        }
    }

}
