package com.github.l_ender.cataclysm.mixin.Client;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.blocks.Abstract_Cataclysm_Skull_Block;
import com.github.l_ender.cataclysm.blocks.Cataclysm_Skull_Block;
import com.github.l_ender.cataclysm.client.model.block.Cataclysm_Skull_Model_Base;
import com.github.l_ender.cataclysm.client.render.blockentity.Cataclysm_Skull_Block_Renderer;
import com.google.common.collect.Maps;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LimbAnimator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

@Mixin(HeadFeatureRenderer.class)
public abstract class CustomHeadLayerMixin extends FeatureRenderer implements ModelWithHead {
    @Unique
    private final Map<Cataclysm_Skull_Block.Type, Cataclysm_Skull_Model_Base> new1_20Modding$skullModels = Cataclysm_Skull_Block_Renderer.createSkullRenderers();

    @Unique
    private final Map<Cataclysm_Skull_Block.Type, Identifier> SKIN_BY_TYPE = Util.make(Maps.newHashMap(), (p_261388_) -> {
        p_261388_.put(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, Cataclysm.modIdentifier("textures/entity/koboleton/kobolediator.png"));
    });

    public CustomHeadLayerMixin(FeatureRendererContext p_117346_) {
        super(p_117346_);
    }

    @Inject(
            method = {"render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V"},
            at = @At(value = "HEAD")
    )
    private void cm_headlayer(MatrixStack p_116731_, VertexConsumerProvider p_116732_, int p_116733_, LivingEntity livingEntity, float p_116735_, float p_116736_, float p_116737_, float p_116738_, float p_116739_, float p_116740_, CallbackInfo ci) {
        ItemStack itemstack = livingEntity.getEquippedStack(EquipmentSlot.HEAD);
        if (!itemstack.isEmpty()) {
            Item item = itemstack.getItem();
            p_116731_.push();
            boolean flag = livingEntity instanceof VillagerEntity || livingEntity instanceof ZombieVillagerEntity;
            if (item instanceof BlockItem && ((BlockItem)item).getBlock() instanceof Abstract_Cataclysm_Skull_Block) {
                float f2 = 1.1875F;
                p_116731_.scale(1.1875F, -1.1875F, -1.1875F);
                if (flag) {
                    p_116731_.translate(0.0F, 0.0625F, 0.0F);
                }

                p_116731_.translate(-0.5D, 0.0D, -0.5D);
                Cataclysm_Skull_Block.Type skullblock$type = ((Abstract_Cataclysm_Skull_Block)((BlockItem)item).getBlock()).getType();
                Cataclysm_Skull_Model_Base skullmodelbase = this.new1_20Modding$skullModels.get(skullblock$type);
                Identifier resourcelocation = SKIN_BY_TYPE.get(skullblock$type);
                RenderLayer rendertype = RenderLayer.getEntityCutoutNoCullZOffset(resourcelocation);
                Entity entity = livingEntity.getVehicle();
                LimbAnimator walkanimationstate;
                if (entity instanceof LivingEntity) {
                    LivingEntity livingentity = (LivingEntity)entity;
                    walkanimationstate = livingentity.limbAnimator;
                } else {
                    walkanimationstate = livingEntity.limbAnimator;
                }

                float f3 = walkanimationstate.getPos(p_116737_);
                Cataclysm_Skull_Block_Renderer.renderSkull(null, 180.0F, f3, p_116731_, p_116732_, p_116733_, skullmodelbase, rendertype);
            }
            p_116731_.pop();
        }
    }
}
