package com.github.l_ender.cataclysm.client.render;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.blocks.Abstract_Cataclysm_Skull_Block;
import com.github.l_ender.cataclysm.blocks.Cataclysm_Skull_Block;
import com.github.l_ender.cataclysm.client.model.block.*;
import com.github.l_ender.cataclysm.client.model.entity.Coral_Bardiche_Model;
import com.github.l_ender.cataclysm.client.model.entity.Coral_Spear_Model;
import com.github.l_ender.cataclysm.client.model.item.*;
import com.github.l_ender.cataclysm.client.render.blockentity.Cataclysm_Skull_Block_Renderer;
import com.github.l_ender.cataclysm.init.ModBlocks;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.items.Cursed_bow;
import com.github.l_ender.cataclysm.items.Laser_Gatling;
import com.github.l_ender.cataclysm.items.Wrath_of_the_desert;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class CMItemstackRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {

    public static int ticksExisted = 0;
    private final MinecraftClient client;

    private static final Bulwark_of_the_flame_Model BULWARK_OF_THE_FLAME_MODEL = new Bulwark_of_the_flame_Model();
    private static final Black_Steel_Targe_Model BLACK_STEEL_TARGE_MODEL = new Black_Steel_Targe_Model();
    private static final EMP_Model EMP_MODEL = new EMP_Model();
    private static final Mechanical_Anvil_Model MF_MODEL = new Mechanical_Anvil_Model();
    private static final Gauntlet_of_Guard_Model GAUNTLET_OF_GUARD_MODEL = new Gauntlet_of_Guard_Model();
    private static final Gauntlet_of_Bulwark_Model GAUNTLET_OF_BULWARK_MODEL = new Gauntlet_of_Bulwark_Model();
    private static final Gauntlet_of_Maelstrom_Model GAUNTLET_OF_MAELSTROM_MODEL = new Gauntlet_of_Maelstrom_Model();
    private static final Incinerator_Model THE_INCINERATOR_MODEL = new Incinerator_Model();
    private static final Coral_Spear_Model CORAL_SPEAR_MODEL = new Coral_Spear_Model();
    private static final Coral_Bardiche_Model CORAL_BARDICHE_MODEL = new Coral_Bardiche_Model();
    private static final Altar_of_Fire_Model ALTAR_OF_FIRE_MODEL = new Altar_of_Fire_Model();
    private static final Altar_of_Void_Model ALTAR_OF_VOID_MODEL = new Altar_of_Void_Model();
    private static final Altar_of_Amethyst_Model ALTAR_OF_AMETHYST_MODEL = new Altar_of_Amethyst_Model();
    private static final Altar_of_Abyss_Model ALTAR_OF_ABYSS_MODEL = new Altar_of_Abyss_Model();
    private static final Abyssal_Egg_Model ABYSSAL_MODEL = new Abyssal_Egg_Model();
    private static final Wither_Assault_SHoulder_Weapon_Model WASW_MODEL = new Wither_Assault_SHoulder_Weapon_Model();
    private static final Void_Forge_Model VOID_FORGE_MODEL = new Void_Forge_Model();
    private static final Tidal_Claws_Model TIDAL_CLAWS_MODEL = new Tidal_Claws_Model();
    private static final Meat_Shredder_Model MEAT_SHREDDER_MODEL = new Meat_Shredder_Model();
    private static final Laser_Gatling_Model LASER_GATLING_MODEL = new Laser_Gatling_Model();
    private static final Ancient_Spear_Model ANCIENT_SPEAR_MODEL = new Ancient_Spear_Model();
    private static final Cursed_Bow_Model CURSED_BOW_MODEL = new Cursed_Bow_Model();
    private static final Wrath_of_Desert_Model WRATH_OF_DESERT_MODEL = new Wrath_of_Desert_Model();
    private static final The_Annihilator_Model THE_ANNIHILATOR = new The_Annihilator_Model();
    private static final The_Immolator_Model THE_IMMOLATOR_MODEL = new The_Immolator_Model();
    private static final Soul_render_Model SOUL_RENDER = new Soul_render_Model();

    private static final Identifier CURSED_BOW_TEXTURE = Cataclysm.modIdentifier("textures/item/cursed_bow.png");
    private static final Identifier CURSED_BOW_GHOST_TEXTURE = Cataclysm.modIdentifier("textures/item/cursed_bow_ghost.png");

    private static final Identifier WRATH_OF_DESERT_TEXTURE = Cataclysm.modIdentifier("textures/item/wrath_of_desert.png");
    private static final Identifier WRATH_OF_DESERT_GHOST_TEXTURE = Cataclysm.modIdentifier("textures/item/wrath_of_desert_ghost.png");

    private static final Identifier SOUL_RENDER_TEXTURE = Cataclysm.modIdentifier("textures/item/soul_render.png");
    private static final Identifier SOUL_RENDER_GHOST_TEXTURE = Cataclysm.modIdentifier("textures/item/soul_render_ghost.png");
    private static final Identifier THE_ANNIHILATOR_TEXTURE = Cataclysm.modIdentifier("textures/item/the_annihilator.png");
    private static final Identifier THE_ANNIHILATOR_GHOST_TEXTURE = Cataclysm.modIdentifier("textures/item/the_annihilator_ghost.png");

    private static final Identifier THE_IMMOLATOR_TEXTURE = Cataclysm.modIdentifier("textures/item/the_immolator.png");
    private static final Identifier THE_IMMOLATOR_GHOST_TEXTURE = Cataclysm.modIdentifier("textures/item/the_immolator_ghost.png");


    private static final Identifier BULWARK_OF_THE_FLAME_TEXTURE = Cataclysm.modIdentifier("textures/item/bulwark_of_the_flame.png");
    private static final Identifier BLACK_STEEL_TARGE_TEXTURE = Cataclysm.modIdentifier("textures/item/black_steel_targe.png");
    private static final Identifier GAUNTLET_OF_GUARD_TEXTURE = Cataclysm.modIdentifier("textures/item/gauntlet_of_guard.png");
    private static final Identifier GAUNTLET_OF_MAELSTROM_TEXTURE = Cataclysm.modIdentifier("textures/item/gauntlet_of_maelstrom.png");

    private static final Identifier GAUNTLET_OF_BULWARK_TEXTURE = Cataclysm.modIdentifier("textures/item/gauntlet_of_bulwark.png");
    private static final Identifier GAUNTLET_OF_GUARD_LAYER_TEXTURE = Cataclysm.modIdentifier("textures/item/gauntlet_of_guard_layer.png");
    private static final Identifier GAUNTLET_OF_BULWARK_LAYER_TEXTURE = Cataclysm.modIdentifier("textures/item/gauntlet_of_bulwark_layer.png");
    private static final Identifier GAUNTLET_OF_MAELSTROM_LAYER_TEXTURE = Cataclysm.modIdentifier("textures/item/gauntlet_of_maelstrom_layer.png");

    private static final Identifier THE_INCINERATOR_TEXTURE = Cataclysm.modIdentifier("textures/item/the_incinerator.png");
    private static final Identifier VOID_FORGE_TEXTURE = Cataclysm.modIdentifier("textures/item/void_forge.png");
    private static final Identifier VOID_FORGE_LAYER_TEXTURE = Cataclysm.modIdentifier("textures/item/void_forge_layer.png");
    private static final Identifier TIDAL_CLAWS_TEXTURE = Cataclysm.modIdentifier("textures/item/tidal_claws.png");
    private static final Identifier MEAT_SHREDDER_TEXTURE = Cataclysm.modIdentifier("textures/item/meat_shredder.png");
    private static final Identifier MEAT_SHREDDER_LAYER_TEXTURE = Cataclysm.modIdentifier("textures/item/meat_shredder_layer.png");
    private static final Identifier LASER_GATLING_TEXTURE = Cataclysm.modIdentifier("textures/item/laser_gatling.png");
    private static final Identifier LASER_GATLING_LAYER_TEXTURE = Cataclysm.modIdentifier("textures/item/laser_gatling_layer.png");
    private static final Identifier ALTAR_OF_FIRE_TEXTURE = Cataclysm.modIdentifier("textures/block/altar_of_fire/altar_of_fire.png");
    private static final Identifier ALTAR_OF_VOID_TEXTURE = Cataclysm.modIdentifier("textures/block/altar_of_void.png");
    private static final Identifier ALTAR_OF_AMETHYST_TEXTURE = Cataclysm.modIdentifier("textures/block/altar_of_amethyst.png");
    private static final Identifier ALTAR_OF_ABYSS_TEXTURE = Cataclysm.modIdentifier("textures/block/altar_of_abyss.png");
    private static final Identifier ABYSSAL_EGG_TEXTURE = Cataclysm.modIdentifier("textures/block/abyssal_egg.png");
    private static final Identifier ABYSSAL_EGG_LAYER_TEXTURE = Cataclysm.modIdentifier("textures/block/abyssal_egg_layer.png");
    private static final Identifier MIF_TEXTURE = Cataclysm.modIdentifier("textures/block/mechanical_fusion_anvil.png");
    private static final Identifier WASW_TEXTURE = Cataclysm.modIdentifier("textures/item/wither_assualt_shoulder_weapon.png");
    private static final Identifier WASW_LAYER_TEXTURE = Cataclysm.modIdentifier("textures/item/wither_assualt_shoulder_weapon_layer.png");
    private static final Identifier VASW_TEXTURE = Cataclysm.modIdentifier("textures/item/void_assualt_shoulder_weapon.png");
    private static final Identifier VASW_LAYER_TEXTURE = Cataclysm.modIdentifier("textures/item/void_assualt_shoulder_weapon_layer.png");
    private static final Identifier EMP_TEXTURE = Cataclysm.modIdentifier("textures/block/emp.png");
    private static final Identifier[] TEXTURE_FIRE_PROGRESS = new Identifier[8];
    private static final Identifier CORAL_SPEAR_TEXTURE = Cataclysm.modIdentifier("textures/entity/coral_spear.png");
    private static final Identifier CORAL_BARDICHE_TEXTURE = Cataclysm.modIdentifier("textures/entity/coral_bardiche.png");
    private static final Identifier ANCIENT_SPEAR_TEXTURE = Cataclysm.modIdentifier("textures/item/ancient_spear.png");

    private Map<Cataclysm_Skull_Block.Type, Cataclysm_Skull_Model_Base> skullModels = Cataclysm_Skull_Block_Renderer.createSkullRenderers();

    public static final Map<Cataclysm_Skull_Block.Type, Identifier> SKIN_BY_TYPE = Util.make(Maps.newHashMap(), (p_261388_) -> {
        p_261388_.put(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, Cataclysm.modIdentifier("textures/entity/koboleton/kobolediator.png"));
        p_261388_.put(Cataclysm_Skull_Block.Types.APTRGANGR, Cataclysm.modIdentifier("textures/entity/draugar/aptrgangr.png"));
        p_261388_.put(Cataclysm_Skull_Block.Types.DRAUGR, Cataclysm.modIdentifier("textures/entity/draugar/draugr.png"));
    });

    public CMItemstackRenderer() {
//        super(MinecraftClient.getInstance().getBlockEntityRenderDispatcher(), MinecraftClient.getInstance().getEntityModelLoader());
        for(int i = 0; i < 8; i++){
            TEXTURE_FIRE_PROGRESS[i] = Cataclysm.modIdentifier("textures/block/altar_of_fire/altarfire_" + i + ".png");
        }
        this.client = MinecraftClient.getInstance();
    }

//    @Override
//    public void reload(ResourceManager manager) {
//        this.skullModels = Cataclysm_Skull_Block_Renderer.createSkullRenderers(MinecraftClient.getInstance().getEntityModelLoader());
//
//        Cataclysm.LOGGER.debug("Reloaded ItemStackRenderer!");
//    }

    public static void incrementTick() {
        ticksExisted++;
    }

    @Override
    public void render(ItemStack itemStackIn, ModelTransformationMode transformType, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int combinedLightIn, int combinedOverlayIn) {
//        boolean left = transformType == ModelTransformationMode.THIRD_PERSON_LEFT_HAND || transformType == ModelTransformationMode.FIRST_PERSON_LEFT_HAND;
        ClientPlayerEntity player = client.player;
        float partialTick = client.getTickDelta();
        int tick;
        if(player == null || client.isPaused()){
            tick = ticksExisted;
        }else{
            tick = player.age;
        }
        Item item = itemStackIn.getItem();
        if (item instanceof BlockItem blockItem) {
            Block block = blockItem.getBlock();
            if (block instanceof Abstract_Cataclysm_Skull_Block) {
                Cataclysm_Skull_Block.Type skullblock$type = ((Abstract_Cataclysm_Skull_Block) block).getType();
                Cataclysm_Skull_Model_Base skullmodelbase = this.skullModels.get(skullblock$type);
                Identifier resourcelocation = SKIN_BY_TYPE.get(skullblock$type);
                RenderLayer rendertype = RenderLayer.getEntityCutoutNoCullZOffset(resourcelocation);
                Cataclysm_Skull_Block_Renderer.renderSkull(null, 180.0F, 0.0F, matrixStackIn, bufferIn, combinedLightIn, skullmodelbase, rendertype);
            }
        }

        if (itemStackIn.getItem() == ModItems.BULWARK_OF_THE_FLAME) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getArmorCutoutNoCull(BULWARK_OF_THE_FLAME_TEXTURE), false, itemStackIn.hasGlint());
            BULWARK_OF_THE_FLAME_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
        if (itemStackIn.getItem() == ModItems.BLACK_STEEL_TARGE) {
            matrixStackIn.push();
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getArmorCutoutNoCull(BLACK_STEEL_TARGE_TEXTURE), false, itemStackIn.hasGlint());
            BLACK_STEEL_TARGE_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
        if (itemStackIn.getItem() == ModItems.GAUNTLET_OF_GUARD) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getEntityCutoutNoCull(GAUNTLET_OF_GUARD_TEXTURE), false, itemStackIn.hasGlint());
            GAUNTLET_OF_GUARD_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorGlintConsumer(bufferIn, CMRenderTypes.getEyes(GAUNTLET_OF_GUARD_LAYER_TEXTURE), false, itemStackIn.hasGlint());
            GAUNTLET_OF_GUARD_MODEL.render(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
        if (itemStackIn.getItem() == ModItems.GAUNTLET_OF_BULWARK) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getEntityCutoutNoCull(GAUNTLET_OF_BULWARK_TEXTURE), false, itemStackIn.hasGlint());
            GAUNTLET_OF_BULWARK_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorGlintConsumer(bufferIn, CMRenderTypes.getEyes(GAUNTLET_OF_BULWARK_LAYER_TEXTURE), false, itemStackIn.hasGlint());
            GAUNTLET_OF_BULWARK_MODEL.render(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
        if (itemStackIn.getItem() == ModItems.GAUNTLET_OF_MAELSTROM) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getEntityCutoutNoCull(GAUNTLET_OF_MAELSTROM_TEXTURE), false, itemStackIn.hasGlint());
            GAUNTLET_OF_MAELSTROM_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorGlintConsumer(bufferIn, CMRenderTypes.getEyes(GAUNTLET_OF_MAELSTROM_LAYER_TEXTURE), false, itemStackIn.hasGlint());
            GAUNTLET_OF_MAELSTROM_MODEL.render(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }

        if (itemStackIn.getItem() == ModItems.THE_INCINERATOR) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getArmorCutoutNoCull(THE_INCINERATOR_TEXTURE), false, itemStackIn.hasGlint());
            THE_INCINERATOR_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
        if (itemStackIn.getItem() == ModItems.WITHER_ASSULT_SHOULDER_WEAPON) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getEntityCutoutNoCull(WASW_TEXTURE), false, itemStackIn.hasGlint());
            WASW_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorGlintConsumer(bufferIn, CMRenderTypes.getEyes(WASW_LAYER_TEXTURE), false, itemStackIn.hasGlint());
            WASW_MODEL.render(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
        if (itemStackIn.getItem() == ModItems.VOID_ASSULT_SHOULDER_WEAPON) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getEntityCutoutNoCull(VASW_TEXTURE), false, itemStackIn.hasGlint());
            WASW_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorGlintConsumer(bufferIn, CMRenderTypes.getEyes(VASW_LAYER_TEXTURE), false, itemStackIn.hasGlint());
            WASW_MODEL.render(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }

        if (itemStackIn.getItem() == ModItems.CORAL_SPEAR) {
            matrixStackIn.push();
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getArmorCutoutNoCull(CORAL_SPEAR_TEXTURE), false, itemStackIn.hasGlint());
            CORAL_SPEAR_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }

        if (itemStackIn.getItem() == ModItems.CORAL_BARDICHE) {
            matrixStackIn.push();
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getArmorCutoutNoCull(CORAL_BARDICHE_TEXTURE), false, itemStackIn.hasGlint());
            CORAL_BARDICHE_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }

        if (itemStackIn.getItem() == ModItems.VOID_FORGE) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getEntityCutoutNoCull(VOID_FORGE_TEXTURE), false, itemStackIn.hasGlint());
            VOID_FORGE_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorGlintConsumer(bufferIn, CMRenderTypes.getEyes(VOID_FORGE_LAYER_TEXTURE), false, itemStackIn.hasGlint());
            VOID_FORGE_MODEL.render(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);

            matrixStackIn.pop();
        }
        if (itemStackIn.getItem() == ModItems.TIDAL_CLAWS) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getArmorCutoutNoCull(TIDAL_CLAWS_TEXTURE), false, itemStackIn.hasGlint());
            TIDAL_CLAWS_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }

        if (itemStackIn.getItem() == ModItems.MEAT_SHREDDER) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getEntityCutoutNoCull(MEAT_SHREDDER_TEXTURE), false, itemStackIn.hasGlint());
            MEAT_SHREDDER_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorGlintConsumer(bufferIn, CMRenderTypes.CMEyes(MEAT_SHREDDER_LAYER_TEXTURE), false, itemStackIn.hasGlint());
            MEAT_SHREDDER_MODEL.render(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            MEAT_SHREDDER_MODEL.animateStack(itemStackIn);
            matrixStackIn.pop();
        }
        if (itemStackIn.getItem() == ModItems.LASER_GATLING) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getEntityCutoutNoCull(LASER_GATLING_TEXTURE), false, itemStackIn.hasGlint());
            float ageInTicks = player == null ? 0F : player.age + partialTick;
            float openAmount = player != null && Laser_Gatling.isCharged(itemStackIn) ? player.age + partialTick : 0;

            LASER_GATLING_MODEL.setAngles(null, openAmount, 0, ageInTicks, 0, 0);
            LASER_GATLING_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorGlintConsumer(bufferIn, CMRenderTypes.getEyes(LASER_GATLING_LAYER_TEXTURE), false, itemStackIn.hasGlint());
            LASER_GATLING_MODEL.render(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);

            matrixStackIn.pop();
        }
        if (itemStackIn.getItem() == ModItems.ANCIENT_SPEAR) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getArmorCutoutNoCull(ANCIENT_SPEAR_TEXTURE), false, itemStackIn.hasGlint());
            ANCIENT_SPEAR_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }

        if (itemStackIn.isOf(ModItems.CURSED_BOW)) {
            float ageInTicks = player == null ? 0F : player.age + partialTick;
            float pullAmount = Cursed_bow.getPullingAmount(itemStackIn, partialTick);

            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5f, 0.5f);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            CURSED_BOW_MODEL.setAngles(null, pullAmount, ageInTicks,  0, 0, 0);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getArmorCutoutNoCull(CURSED_BOW_TEXTURE), false, itemStackIn.hasGlint());
            CURSED_BOW_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorGlintConsumer(bufferIn, CMRenderTypes.getghost(CURSED_BOW_GHOST_TEXTURE), false, itemStackIn.hasGlint());
            CURSED_BOW_MODEL.render(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);

            matrixStackIn.pop();
        }

        if (itemStackIn.isOf(ModItems.WRATH_OF_THE_DESERT)) {
            float ageInTicks = player == null ? 0F : player.age + partialTick;
            float pullAmount = Wrath_of_the_desert.getPullingAmount(itemStackIn, partialTick);

            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5f, 0.5f);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            WRATH_OF_DESERT_MODEL.setAngles(null, pullAmount, ageInTicks,  ageInTicks, 0, 0);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getArmorCutoutNoCull(WRATH_OF_DESERT_TEXTURE), false, itemStackIn.hasGlint());
            WRATH_OF_DESERT_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorGlintConsumer(bufferIn, CMRenderTypes.getghost(WRATH_OF_DESERT_GHOST_TEXTURE), false, itemStackIn.hasGlint());
            WRATH_OF_DESERT_MODEL.render(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }


        if (itemStackIn.isOf(ModItems.SOUL_RENDER)) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5f, 0.5f);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getArmorCutoutNoCull(SOUL_RENDER_TEXTURE), false, itemStackIn.hasGlint());
            SOUL_RENDER.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorGlintConsumer(bufferIn, CMRenderTypes.getghost(SOUL_RENDER_GHOST_TEXTURE), false, itemStackIn.hasGlint());
            SOUL_RENDER.render(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }

        if (itemStackIn.isOf(ModItems.THE_ANNIHILATOR)) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5f, 0.5f);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getArmorCutoutNoCull(THE_ANNIHILATOR_TEXTURE), false, itemStackIn.hasGlint());
            THE_ANNIHILATOR.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorGlintConsumer(bufferIn, CMRenderTypes.getghost(THE_ANNIHILATOR_GHOST_TEXTURE), false, itemStackIn.hasGlint());
            THE_ANNIHILATOR.render(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
        if (itemStackIn.isOf(ModItems.THE_IMMOLATOR)) {
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 0.5f, 0.5f);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorGlintConsumer(bufferIn, RenderLayer.getArmorCutoutNoCull(THE_IMMOLATOR_TEXTURE), false, itemStackIn.hasGlint());
            THE_IMMOLATOR_MODEL.render(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            VertexConsumer vertexconsumer2 = ItemRenderer.getArmorGlintConsumer(bufferIn, CMRenderTypes.getghost(THE_IMMOLATOR_GHOST_TEXTURE), false, itemStackIn.hasGlint());
            THE_IMMOLATOR_MODEL.render(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }

        if(itemStackIn.getItem() == ModBlocks.ALTAR_OF_FIRE.asItem()){
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 1.50F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            ALTAR_OF_FIRE_MODEL.resetToDefaultPose();
            ALTAR_OF_FIRE_MODEL.render(matrixStackIn, bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(ALTAR_OF_FIRE_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            ALTAR_OF_FIRE_MODEL.render(matrixStackIn, bufferIn.getBuffer(CMRenderTypes.getGlowingEffect(getIdleTexture((int) ((tick * 0.5F) % 7)))), 210, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
            matrixStackIn.pop();
        }
        if(itemStackIn.getItem() == ModBlocks.ALTAR_OF_VOID.asItem()){
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 1.50F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            ALTAR_OF_VOID_MODEL.resetToDefaultPose();
            ALTAR_OF_VOID_MODEL.render(matrixStackIn, bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(ALTAR_OF_VOID_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
        if(itemStackIn.getItem() == ModBlocks.ALTAR_OF_AMETHYST.asItem()){
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 1.50F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            ALTAR_OF_AMETHYST_MODEL.resetToDefaultPose();
            ALTAR_OF_AMETHYST_MODEL.render(matrixStackIn, bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(ALTAR_OF_AMETHYST_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
        if(itemStackIn.getItem() == ModBlocks.ALTAR_OF_ABYSS.asItem()){
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 1.50F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            ALTAR_OF_ABYSS_MODEL.resetToDefaultPose();
            ALTAR_OF_ABYSS_MODEL.render(matrixStackIn, bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(ALTAR_OF_ABYSS_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
        if(itemStackIn.getItem() == ModBlocks.EMP.asItem()){
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 1.50F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            EMP_MODEL.resetToDefaultPose();
            EMP_MODEL.render(matrixStackIn, bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(EMP_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
        if(itemStackIn.getItem() == ModBlocks.MECHANICAL_FUSION_ANVIL.asItem()){
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 1.50F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            MF_MODEL.resetToDefaultPose();
            MF_MODEL.render(matrixStackIn, bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(MIF_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
        if(itemStackIn.getItem() == ModBlocks.ABYSSAL_EGG.asItem()){
            matrixStackIn.push();
            matrixStackIn.translate(0.5F, 1.50F, 0.5F);
            matrixStackIn.scale(1.0F, -1.0F, -1.0F);
            ABYSSAL_MODEL.resetToDefaultPose();
            ABYSSAL_MODEL.render(matrixStackIn, bufferIn.getBuffer(RenderLayer.getEntityCutoutNoCull(ABYSSAL_EGG_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            ABYSSAL_MODEL.render(matrixStackIn, bufferIn.getBuffer(CMRenderTypes.getghost(ABYSSAL_EGG_LAYER_TEXTURE)), combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
    }

    private void renderMapHand(MatrixStack poseStack, VertexConsumerProvider bufferSource, int i, Arm humanoidArm) {
        RenderSystem.setShaderTexture(0, client.player.getSkinTexture());
        PlayerEntityRenderer playerrenderer = (PlayerEntityRenderer)client.getEntityRenderDispatcher().<AbstractClientPlayerEntity>getRenderer(MinecraftClient.getInstance().player);
        poseStack.push();
        float f = humanoidArm == Arm.RIGHT ? 1.0F : -1.0F;
        poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(92.0F));
        poseStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(45.0F));
        poseStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f * -41.0F));
        poseStack.translate(f * 0.3F, -1.1F, 0.45F);
        if (humanoidArm == Arm.RIGHT) {
            playerrenderer.renderRightArm(poseStack, bufferSource, i, client.player);
        } else {
            playerrenderer.renderLeftArm(poseStack, bufferSource, i, client.player);
        }

        poseStack.pop();
    }


    private Identifier getIdleTexture(int age) {
        return TEXTURE_FIRE_PROGRESS[MathHelper.clamp(age, 0, 7)];
    }

}
