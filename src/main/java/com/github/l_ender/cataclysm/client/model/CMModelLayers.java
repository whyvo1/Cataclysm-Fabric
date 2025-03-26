package com.github.l_ender.cataclysm.client.model;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.armor.*;
import com.github.l_ender.cataclysm.client.model.block.AptrgangrHeadModel;
import com.github.l_ender.cataclysm.client.model.block.DraugrHeadModel;
import com.github.l_ender.cataclysm.client.model.block.KobolediatorHeadModel;
import com.github.l_ender.cataclysm.client.model.entity.*;
import com.github.l_ender.cataclysm.client.model.item.CuriosModel.Blazing_Grips_Model;
import com.github.l_ender.cataclysm.client.model.item.CuriosModel.Sandstorm_In_A_BottleModel;
import com.github.l_ender.cataclysm.client.model.item.CuriosModel.Sticky_Gloves_Model;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.render.entity.model.EntityModelLayer;

@Environment(EnvType.CLIENT)
public class CMModelLayers {

    public static final EntityModelLayer ELYTRA_ARMOR = createLocation("elytra_armor", "main");
    public static final EntityModelLayer MONSTROUS_HELM = createLocation("monstrous", "main");
    public static final EntityModelLayer IGNITIUM_ARMOR_MODEL = createLocation("ignitium_armor_model", "main");
    public static final EntityModelLayer IGNITIUM_ARMOR_MODEL_LEGS = createLocation("ignitium_armor_model_leg", "main");
    public static final EntityModelLayer CURSIUM_ARMOR_MODEL = createLocation("cursium_armor_model", "main");
    public static final EntityModelLayer CURSIUM_ARMOR_MODEL_LEGS = createLocation("cursium_armor_model_leg", "main");

    public static final EntityModelLayer BLOOM_STONE_PAULDRONS_MODEL = createLocation("bloom_stone_pauldrons_model", "main");
    public static final EntityModelLayer BONE_REPTILE_ARMOR_MODEL = createLocation("bone_reptile_armor_model", "main");
    public static final EntityModelLayer SANDSTORM_IN_A_BOTTLE_MODEL = createLocation("sandstorm_in_a_bottle_model", "main");
    public static final EntityModelLayer STICKY_GLOVES_MODEL = createLocation("sticky_gloves_model", "main");
    public static final EntityModelLayer STICKY_GLOVES_SLIM_MODEL = createLocation("sticky_gloves_slim_model", "main");
    public static final EntityModelLayer BLAZING_GRIPS_MODEL = createLocation("blazing_grips_model", "main");
    public static final EntityModelLayer BLAZING_GRIPS_SLIM_MODEL = createLocation("blazing_grips_slim_model", "main");
    public static final EntityModelLayer KOBOLEDIATOR_HEAD_MODEL = createLocation("kobolediator_head_model", "main");
    public static final EntityModelLayer APTRGANGR_HEAD_MODEL = createLocation("aptrgangr_head_model", "main");
    public static final EntityModelLayer DRAUGR_HEAD_MODEL = createLocation("draugr_head_model", "main");
    public static final EntityModelLayer IGNITED_BERSERKER_MODEL = createLocation("ignited_berserker_model", "main");
    public static final EntityModelLayer NETHERITE_MONSTROSITY_MODEL = createLocation("netherite_monstrosity_model", "main");
    public static final EntityModelLayer NETHERITE_MINISTROSITY_MODEL = createLocation("netherite_ministrosity_model", "main");
    public static final EntityModelLayer FLARE_BOMB_MODEL = createLocation("flare_bomb_model", "main");
    public static final EntityModelLayer ROYAL_DRAUGR_MODEL = createLocation("royal_draugr", "main");
    public static final EntityModelLayer DRAUGR_MODEL = createLocation("draugr", "main");
    public static final EntityModelLayer ELITE_DRAUGR_MODEL = createLocation("elite_draugr", "main");
    public static final EntityModelLayer ANCIENT_REMNANT_MODEL = createLocation("ancient_remnant_model", "main");
    public static final EntityModelLayer MALEDICTUS_MODEL = createLocation("maledictus_model", "main");
    public static final EntityModelLayer APTRGANGR_MODEL = createLocation("aptrgangr_model", "main");
    public static final EntityModelLayer KOBOLEDIATOR_MODEL = createLocation("kobolediator_model", "main");
    public static final EntityModelLayer PROWLER_MODEL = createLocation("prowler_model", "main");

    public static final EntityModelLayer LASER_BEAM_MODEL = createLocation("laser_beam_model", "main");


    public static void register() {
        registerModelsLayer(MONSTROUS_HELM, () -> MonstrousHelm_Model.createArmorLayer(new Dilation(0.3F)));
        registerModelsLayer(IGNITIUM_ARMOR_MODEL, () -> Ignitium_Armor_Model.createArmorLayer(new Dilation(0.6F)));
        registerModelsLayer(BLOOM_STONE_PAULDRONS_MODEL, () -> Bloom_Stone_Pauldrons_Model.createArmorLayer(new Dilation(0.5F)));
        registerModelsLayer(ELYTRA_ARMOR, () -> ignitium_Elytra_chestplate_Model.createArmorLayer(new Dilation(0.5F)));
        registerModelsLayer(IGNITIUM_ARMOR_MODEL_LEGS, () -> Ignitium_Armor_Model.createArmorLayer(new Dilation(0.2F)));
        registerModelsLayer(SANDSTORM_IN_A_BOTTLE_MODEL, () -> Sandstorm_In_A_BottleModel.createLayer(new Dilation(0.2F)));
        registerModelsLayer(BONE_REPTILE_ARMOR_MODEL, () -> Bone_Reptile_Armor_Model.createArmorLayer(new Dilation(1.0F)));
        registerModelsLayer(STICKY_GLOVES_MODEL, () -> Sticky_Gloves_Model.createLayer(false,new Dilation(0.2F)));
        registerModelsLayer(STICKY_GLOVES_SLIM_MODEL, () -> Sticky_Gloves_Model.createLayer(true,new Dilation(0.2F)));
        registerModelsLayer(BLAZING_GRIPS_MODEL, () -> Blazing_Grips_Model.createLayer(false,new Dilation(0.0F)));
        registerModelsLayer(BLAZING_GRIPS_SLIM_MODEL, () -> Blazing_Grips_Model.createLayer(true,new Dilation(0.0F)));
        registerModelsLayer(KOBOLEDIATOR_HEAD_MODEL, KobolediatorHeadModel::createHeadLayer);
        registerModelsLayer(APTRGANGR_HEAD_MODEL, AptrgangrHeadModel::createHeadLayer);
        registerModelsLayer(DRAUGR_HEAD_MODEL, DraugrHeadModel::createHeadLayer);
        registerModelsLayer(IGNITED_BERSERKER_MODEL, Ignited_Berserker_Model::createBodyLayer);
        registerModelsLayer(NETHERITE_MONSTROSITY_MODEL, Netherite_Monstrosity_Model::createBodyLayer);
        registerModelsLayer(NETHERITE_MINISTROSITY_MODEL, Netherite_Ministrosity_Model::createBodyLayer);
        registerModelsLayer(FLARE_BOMB_MODEL, Flare_Bomb_Model::createBodyLayer);
        registerModelsLayer(CURSIUM_ARMOR_MODEL, () -> Cursium_Armor_Model.createArmorLayer(new Dilation(0.5F)));
        registerModelsLayer(CURSIUM_ARMOR_MODEL_LEGS, () -> Cursium_Armor_Model.createArmorLayer(new Dilation(0.2F)));
        registerModelsLayer(ROYAL_DRAUGR_MODEL, Royal_Draugr_Model::createBodyLayer);
        registerModelsLayer(DRAUGR_MODEL, Draugr_Model::createBodyLayer);
        registerModelsLayer(ELITE_DRAUGR_MODEL, Elite_Draugr_Model::createBodyLayer);

        registerModelsLayer(ANCIENT_REMNANT_MODEL, Ancient_Remnant_Rework_Model::createBodyLayer);
        registerModelsLayer(MALEDICTUS_MODEL, Maledictus_Model::createBodyLayer);
        registerModelsLayer(APTRGANGR_MODEL, Aptrgangr_Model::createBodyLayer);
        registerModelsLayer(KOBOLEDIATOR_MODEL, Kobolediator_Model::createBodyLayer);
        registerModelsLayer(PROWLER_MODEL, The_Prowler_Model::createBodyLayer);
        registerModelsLayer(LASER_BEAM_MODEL, Laser_Beam_Model::createBodyLayer);
    }

    private static void registerModelsLayer(EntityModelLayer layer, EntityModelLayerRegistry.TexturedModelDataProvider modelData) {
        EntityModelLayerRegistry.registerModelLayer(layer, modelData);
    }

    private static EntityModelLayer createLocation(String model, String layer) {
        return new EntityModelLayer(Cataclysm.modIdentifier(model), layer);
    }
}
