package com.github.l_ender.cataclysm.client.render.item;

import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.model.armor.*;
import com.github.l_ender.cataclysm.client.render.RenderUtils;
import com.github.l_ender.cataclysm.client.render.item.armor.*;
import com.github.l_ender.cataclysm.init.ModItems;
import com.google.common.base.Suppliers;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class CustomArmorRenderProperties {

    private static boolean init;
    public static final Supplier<CustomArmorRenderProperties> INSTANCE = Suppliers.memoize(CustomArmorRenderProperties::new);

    public static Ignitium_Elytra_chestplate_Model ELYTRA_ARMOR;
    public static MonstrousHelm_Model MONSTROUS_HELM_MODEL;
    public static Ignitium_Armor_Model IGNITIUM_ARMOR_MODEL;
    public static Ignitium_Armor_Model IGNITIUM_ARMOR_MODEL_LEGS;
    public static Bloom_Stone_Pauldrons_Model BLOOM_STONE_PAULDRONS_MODEL;
    public static Bone_Reptile_Armor_Model BONE_REPTILE_ARMOR_MODEL;

    public static Cursium_Armor_Model CURSIUM_ARMOR_MODEL;
    public static Cursium_Armor_Model CURSIUM_ARMOR_MODEL_LEGS;


    public static void initializeModels() {
        init = true;
        MONSTROUS_HELM_MODEL = new MonstrousHelm_Model(RenderUtils.getModelPartFromLayer(CMModelLayers.MONSTROUS_HELM));
        IGNITIUM_ARMOR_MODEL = new Ignitium_Armor_Model(RenderUtils.getModelPartFromLayer(CMModelLayers.IGNITIUM_ARMOR_MODEL));
        ELYTRA_ARMOR = new Ignitium_Elytra_chestplate_Model(RenderUtils.getModelPartFromLayer(CMModelLayers.ELYTRA_ARMOR));
        IGNITIUM_ARMOR_MODEL_LEGS = new Ignitium_Armor_Model(RenderUtils.getModelPartFromLayer(CMModelLayers.IGNITIUM_ARMOR_MODEL_LEGS));
        BLOOM_STONE_PAULDRONS_MODEL = new Bloom_Stone_Pauldrons_Model(RenderUtils.getModelPartFromLayer(CMModelLayers.BLOOM_STONE_PAULDRONS_MODEL));
        BONE_REPTILE_ARMOR_MODEL = new Bone_Reptile_Armor_Model(RenderUtils.getModelPartFromLayer(CMModelLayers.BONE_REPTILE_ARMOR_MODEL));
        CURSIUM_ARMOR_MODEL = new Cursium_Armor_Model(RenderUtils.getModelPartFromLayer(CMModelLayers.CURSIUM_ARMOR_MODEL));
        CURSIUM_ARMOR_MODEL_LEGS = new Cursium_Armor_Model(RenderUtils.getModelPartFromLayer(CMModelLayers.CURSIUM_ARMOR_MODEL_LEGS));

    }

    public static void registerArmorRenderers() {
        ArmorRenderer.register(MonstrousHelmRenderer.INSTANCE, ModItems.MONSTROUS_HELM);
        ArmorRenderer.register(IgnitiumArmorRenderer.INSTANCE, ModItems.IGNITIUM_HELMET, ModItems.IGNITIUM_CHESTPLATE, ModItems.IGNITIUM_BOOTS);
        ArmorRenderer.register(IgnitiumArmorLegsRenderer.INSTANCE, ModItems.IGNITIUM_LEGGINGS);
        ArmorRenderer.register(IgnitiumElytraChestplateRenderer.INSTANCE, ModItems.IGNITIUM_ELYTRA_CHESTPLATE);
        ArmorRenderer.register(BloomStonePauldronsRenderer.INSTANCE, ModItems.BLOOM_STONE_PAULDRONS);
        ArmorRenderer.register(BoneReptileArmorRenderer.INSTANCE, ModItems.BONE_REPTILE_HELMET, ModItems.BONE_REPTILE_CHESTPLATE);
        ArmorRenderer.register(CursiumArmorRenderer.INSTANCE, ModItems.CURSIUM_HELMET, ModItems.CURSIUM_CHESTPLATE, ModItems.CURSIUM_BOOTS);
        ArmorRenderer.register(CursiumArmorLegsRenderer.INSTANCE, ModItems.CURSIUM_LEGGINGS);
    }

    public BipedEntityModel<?> getHumanoidArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, BipedEntityModel<?> _default) {
        if(!init){
            initializeModels();
        }

        if(itemStack.getItem() == ModItems.MONSTROUS_HELM){
            return MONSTROUS_HELM_MODEL;
        }

        if(itemStack.getItem() == ModItems.IGNITIUM_HELMET){
            return IGNITIUM_ARMOR_MODEL;
        }

        if(itemStack.getItem() == ModItems.IGNITIUM_CHESTPLATE){
            return IGNITIUM_ARMOR_MODEL;
        }

        if(itemStack.getItem() == ModItems.IGNITIUM_LEGGINGS){
            return IGNITIUM_ARMOR_MODEL_LEGS;
        }

        if(itemStack.getItem() == ModItems.IGNITIUM_BOOTS){
            return IGNITIUM_ARMOR_MODEL;
        }

        if(itemStack.getItem() == ModItems.CURSIUM_HELMET){
            return CURSIUM_ARMOR_MODEL;
        }

        if(itemStack.getItem() == ModItems.CURSIUM_CHESTPLATE){
            return CURSIUM_ARMOR_MODEL;
        }

        if(itemStack.getItem() == ModItems.CURSIUM_LEGGINGS){
            return CURSIUM_ARMOR_MODEL_LEGS;
        }

        if(itemStack.getItem() == ModItems.CURSIUM_BOOTS){
            return CURSIUM_ARMOR_MODEL;
        }


        if(itemStack.getItem() == ModItems.BLOOM_STONE_PAULDRONS){
            return BLOOM_STONE_PAULDRONS_MODEL;
        }

        if(itemStack.getItem() == ModItems.BONE_REPTILE_HELMET){
            return BONE_REPTILE_ARMOR_MODEL;
        }

        if(itemStack.getItem() == ModItems.BONE_REPTILE_CHESTPLATE){
            return BONE_REPTILE_ARMOR_MODEL;
        }

        if(itemStack.getItem() == ModItems.IGNITIUM_ELYTRA_CHESTPLATE){
            return ELYTRA_ARMOR.withAnimations(entityLiving);
        }
        return _default;
    }
}
