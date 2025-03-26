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
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

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

    public static final EntityModelLayer ROYAL_DRAUGR_MODEL = createLocation("royal_draugr_model", "main");
    public static final EntityModelLayer DRAUGR_MODEL = createLocation("draugr_model", "main");
    public static final EntityModelLayer ELITE_DRAUGR_MODEL = createLocation("elite_draugr_model", "main");

    public static final EntityModelLayer ANCIENT_REMNANT_MODEL = createLocation("ancient_remnant_model", "main");
    public static final EntityModelLayer MALEDICTUS_MODEL = createLocation("maledictus_model", "main");
    public static final EntityModelLayer APTRGANGR_MODEL = createLocation("aptrgangr_model", "main");
    public static final EntityModelLayer KOBOLEDIATOR_MODEL = createLocation("kobolediator_model", "main");
    public static final EntityModelLayer PROWLER_MODEL = createLocation("prowler_model", "main");
    public static final EntityModelLayer LASER_BEAM_MODEL = createLocation("laser_beam", "main");

    public static void register() {
        EntityModelLayerRegistry.registerModelLayer(MONSTROUS_HELM, () -> MonstrousHelm_Model.createArmorLayer(new Dilation(0.3F)));
        EntityModelLayerRegistry.registerModelLayer(IGNITIUM_ARMOR_MODEL, () -> Ignitium_Armor_Model.createArmorLayer(new Dilation(0.6F)));
        EntityModelLayerRegistry.registerModelLayer(BLOOM_STONE_PAULDRONS_MODEL, () -> Bloom_Stone_Pauldrons_Model.createArmorLayer(new Dilation(0.5F)));
        EntityModelLayerRegistry.registerModelLayer(ELYTRA_ARMOR, () -> Ignitium_Elytra_chestplate_Model.createArmorLayer(new Dilation(0.5F)));
        EntityModelLayerRegistry.registerModelLayer(IGNITIUM_ARMOR_MODEL_LEGS, () -> Ignitium_Armor_Model.createArmorLayer(new Dilation(0.2F)));
        EntityModelLayerRegistry.registerModelLayer(SANDSTORM_IN_A_BOTTLE_MODEL, () -> Sandstorm_In_A_BottleModel.createLayer(new Dilation(0.2F)));
        EntityModelLayerRegistry.registerModelLayer(BONE_REPTILE_ARMOR_MODEL, () -> Bone_Reptile_Armor_Model.createArmorLayer(new Dilation(1.0F)));
        EntityModelLayerRegistry.registerModelLayer(STICKY_GLOVES_MODEL, () -> Sticky_Gloves_Model.createLayer(false,new Dilation(0.2F)));
        EntityModelLayerRegistry.registerModelLayer(STICKY_GLOVES_SLIM_MODEL, () -> Sticky_Gloves_Model.createLayer(true,new Dilation(0.2F)));
        EntityModelLayerRegistry.registerModelLayer(BLAZING_GRIPS_MODEL, () -> Blazing_Grips_Model.createLayer(false,new Dilation(0.0F)));
        EntityModelLayerRegistry.registerModelLayer(BLAZING_GRIPS_SLIM_MODEL, () -> Blazing_Grips_Model.createLayer(true,new Dilation(0.0F)));
        EntityModelLayerRegistry.registerModelLayer(KOBOLEDIATOR_HEAD_MODEL, KobolediatorHeadModel::createHeadLayer);
        EntityModelLayerRegistry.registerModelLayer(APTRGANGR_HEAD_MODEL, AptrgangrHeadModel::createHeadLayer);
        EntityModelLayerRegistry.registerModelLayer(DRAUGR_HEAD_MODEL, DraugrHeadModel::createHeadLayer);
        EntityModelLayerRegistry.registerModelLayer(IGNITED_BERSERKER_MODEL, Ignited_Berserker_Model::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(NETHERITE_MONSTROSITY_MODEL, Netherite_Monstrosity_Model::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(NETHERITE_MINISTROSITY_MODEL, Netherite_Ministrosity_Model::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(FLARE_BOMB_MODEL, Flare_Bomb_Model::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CURSIUM_ARMOR_MODEL, () -> Cursium_Armor_Model.createArmorLayer(new Dilation(0.5F)));
        EntityModelLayerRegistry.registerModelLayer(CURSIUM_ARMOR_MODEL_LEGS, () -> Cursium_Armor_Model.createArmorLayer(new Dilation(0.2F)));
        EntityModelLayerRegistry.registerModelLayer(ROYAL_DRAUGR_MODEL, Royal_Draugr_Model::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(DRAUGR_MODEL, Draugr_Model::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ELITE_DRAUGR_MODEL, Elite_Draugr_Model::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(ANCIENT_REMNANT_MODEL, Ancient_Remnant_Rework_Model::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(MALEDICTUS_MODEL, Maledictus_Model::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(APTRGANGR_MODEL, Aptrgangr_Model::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(KOBOLEDIATOR_MODEL, Kobolediator_Model::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(PROWLER_MODEL, The_Prowler_Model::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(LASER_BEAM_MODEL, Laser_Beam_Model::createBodyLayer);
    }

    private static EntityModelLayer createLocation(String model, String layer) {
        return new EntityModelLayer(Cataclysm.modIdentifier(model), layer);
    }

}
