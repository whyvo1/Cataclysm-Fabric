package com.github.l_ender.cataclysm.event;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.config.ConfigHolder;
import com.github.l_ender.cataclysm.init.*;
import com.github.l_ender.cataclysm.items.ILeftClick;
import com.github.l_ender.cataclysm.message.MessageParticle;
import com.github.l_ender.cataclysm.util.NetworkHandler;
import com.github.l_ender.lionfishapi.server.event.StandOnFluidCallback;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeModConfigEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.MathHelper;
import net.neoforged.fml.config.ModConfig;


public class ServerEventHandler {

    public static void registerListeners() {
        StandOnFluidCallback.EVENT.register(((entity, fluidState) -> {
            if(entity.getEquippedStack(EquipmentSlot.FEET).isOf(ModItems.IGNITIUM_BOOTS) &&
                    !entity.isSneaking() &&
                    fluidState.isIn(FluidTags.LAVA)) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        }));

        AttackCallback.EVENT.register(((player, world, type) -> {
            if(player.hasStatusEffect(ModEffect.EFFECTSTUN) || player.hasStatusEffect(ModEffect.EFFECTGHOST_FORM)) {
//                ServerEventHandler.onAttack(player);
                return ActionResult.FAIL;
            }
            if(type == HitResult.Type.MISS) {
                return ServerEventHandler.onAttackEmpty(player);
            }
            return ActionResult.PASS;
        }));

        UseBlockCallback.EVENT.register(((player, world, hand, entity) -> {
            if(player.hasStatusEffect(ModEffect.EFFECTSTUN) || player.hasStatusEffect(ModEffect.EFFECTGHOST_FORM)) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        }));

        UseEntityCallback.EVENT.register(((player, world, hand, entity, hitResult) -> {
            if(player.hasStatusEffect(ModEffect.EFFECTSTUN) || player.hasStatusEffect(ModEffect.EFFECTGHOST_FORM)) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        }));

        UseItemCallback.EVENT.register(((player, world, hand) -> {
            if(player.hasStatusEffect(ModEffect.EFFECTSTUN) || player.hasStatusEffect(ModEffect.EFFECTGHOST_FORM)) {
                return TypedActionResult.fail(player.getStackInHand(hand));
            }
            return TypedActionResult.pass(player.getStackInHand(hand));
        }));

        ServerLivingEntityEvents.ALLOW_DEATH.register(((entity, damageSource, damageAmount) -> {
            if (damageSource != null && !damageSource.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                return !tryCursiumPlateRebirth(entity);
            }
            return true;
        }));
        NeoForgeModConfigEvents.loading(Cataclysm.MOD_ID).register(ServerEventHandler::onConfigLoad);
        NeoForgeModConfigEvents.reloading(Cataclysm.MOD_ID).register(ServerEventHandler::onConfigLoad);
    }

    public static ActionResult onAttackEmpty(PlayerEntity player) {
        ItemStack leftItem = player.getOffHandStack();
        ItemStack rightItem = player.getMainHandStack();
        if(!player.hasStatusEffect(ModEffect.EFFECTSTUN)){
            if (rightItem.getItem() instanceof ILeftClick) {
                ((ILeftClick) rightItem.getItem()).onLeftClick(rightItem, player);
                return ActionResult.SUCCESS;
            }
            if (leftItem.getItem() instanceof ILeftClick) {
                ((ILeftClick) leftItem.getItem()).onLeftClick(leftItem, player);
                return ActionResult.SUCCESS;
            }
//            if (player.getWorld().isClient() && flag) {
//                MessageSwingArm.INSTANCE.sendToServer();
//            }
        }
        return ActionResult.PASS;
    }

    private static void onConfigLoad(ModConfig config) {
        if (config.getSpec() == ConfigHolder.COMMON_SPEC) {
            CMConfig.bake(config);
        }
    }



    // DONE
//    @SubscribeEvent
//    public static void onLivingUpdateEvent(PlayerTickEvent.Post event) {
//        event.getEntity().getData(ModDataAttachments.CHARGE_ATTACHMENT).tick(event.getEntity());
//
//        event.getEntity().getData(ModDataAttachments.RENDER_RUSH_ATTACHMENT).tick(event.getEntity());
//
//
//        if (event.getEntity().getData(ModDataAttachments.HOOK_FALLING)) {
//            event.getEntity().setIgnoreFallDamageFromCurrentImpulse(true);
//            event.getEntity().currentImpulseImpactPos = event.getEntity().position();
//
//        }
//    }


//    @SubscribeEvent
//    public static void StandOnFluidEventEvent(StandOnFluidEvent event) {
//        if (!event.getEntity().getItemBySlot(EquipmentSlot.FEET).isEmpty() && event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.IGNITIUM_BOOTS.get()) {
//            if (!event.getEntity().isShiftKeyDown() && (event.getFluidState().is(Fluids.LAVA) || event.getFluidState().is(Fluids.FLOWING_LAVA))) {
//                event.setCanceled(true);
//            }
//        }
//    }


    // DONE
//    @SubscribeEvent
//    public static void onPlayerAttack(AttackEntityEvent event) {
//        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
//            event.setCanceled(true);
//        }
//        if (event.getEntity().hasEffect(ModEffect.EFFECTGHOST_FORM)) {
//            event.setCanceled(true);
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public static void BlockHeal(LivingHealEvent event) {
//        if (event.getEntity().hasEffect(ModEffect.EFFECTABYSSAL_FEAR)) {
//            event.setCanceled(true);
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public static void onLivingJump(LivingEvent.LivingJumpEvent event) {
//        LivingEntity entity = event.getEntity();
//        if (entity.getStatusEffect(ModEffect.EFFECTSTUN) != null){
//            entity.setVelocity(entity.getVelocity().getX(), 0.0D, entity.getVelocity().getZ());
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public static void onPlayerLeftClick(PlayerInteractEvent.LeftClickBlock event) {
//        PlayerEntity player = event.getEntity();
//        if ( player.hasStatusEffect(ModEffect.EFFECTSTUN)) {
//            event.setCanceled(true);
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public static void onUseItem(LivingEntityUseItemEvent event) {
//        LivingEntity living = event.getEntity();
//        if (living.hasStatusEffect(ModEffect.EFFECTSTUN)) {
//            event.setDuration(0);
//        }
//        if (living.hasStatusEffect(ModEffect.EFFECTGHOST_FORM)) {
//            event.setDuration(0);
//        }
//    }

//    @SubscribeEvent
//    public static void onPlaceBlock(BlockEvent.EntityPlaceEvent event) {
//        Entity entity = event.getEntity();
//        if (entity instanceof LivingEntity) {
//            LivingEntity living = (LivingEntity) entity;
//            if (living.hasStatusEffect(ModEffect.EFFECTSTUN)) {
//                event.setCanceled(true);
//            }
//        }
//    }


    // DONE
//    @SubscribeEvent
//    public static void KnockbackEvent(LivingKnockBackEvent event) {
//        LivingEntity living = event.getEntity();
//        if(living instanceof Royal_Draugr_Entity royalDraugr){
//            if(royalDraugr.isDraugrBlocking()){
//                event.setCanceled(true);
//            }
//        }
//    }



    // DONE
//    @SubscribeEvent
//    public static void onBreakBlock(BlockEvent.BreakEvent event) {
//        if (event.getPlayer().hasEffect(ModEffect.EFFECTSTUN)) {
//            event.setCanceled(true);
//        }
//    }

//    @SubscribeEvent
//    public static void onPlayerInteract1(PlayerInteractEvent.RightClickEmpty event) {
//
//    }

    // DONE
//    @SubscribeEvent
//    public static void onPlayerInteract2(PlayerInteractEvent.LeftClickEmpty event) {
//        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
//        //    event.setCanceled(true);
//        }
//
//        boolean flag = false;
//        ItemStack leftItem = event.getEntity().getOffhandItem();
//        ItemStack rightItem = event.getEntity().getMainHandItem();
//        if(!event.getEntity().hasEffect(ModEffect.EFFECTSTUN)){
//            if (leftItem.getItem() instanceof ILeftClick) {
//                ((ILeftClick) leftItem.getItem()).onLeftClick(leftItem, event.getEntity());
//                flag = true;
//            }
//            if (rightItem.getItem() instanceof ILeftClick) {
//                ((ILeftClick) rightItem.getItem()).onLeftClick(rightItem, event.getEntity());
//                flag = true;
//            }
//            if (event.getLevel().isClientSide && flag) {
//
//                PacketDistributor.sendToServer(new MessageSwingArm(Hand.MAIN_HAND));
//            }
//        }
//
//    }

    // DONE
//    @SubscribeEvent
//    public static void onPlayerInteract3(PlayerInteractEvent.EntityInteract event) {
//        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
//            event.setCanceled(true);
//        }
//    }
//
//    @SubscribeEvent
//    public static void onPlayerInteract4(PlayerInteractEvent.RightClickBlock event) {
//        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
//            event.setCanceled(true);
//        }
//    }
//
//    @SubscribeEvent
//    public static void onPlayerInteract5(PlayerInteractEvent.LeftClickBlock event) {
//        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
//            event.setCanceled(true);
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public static void onLivingSetTargetEvent(LivingChangeTargetEvent event) {
//        if (event.getNewAboutToBeSetTarget() != null && event.getEntity() instanceof MobEntity mob) {
//            if (mob.getType().isIn(ModTag.LAVA_MONSTER) && event.getEntity().getLastHurtByMob() != event.getNewAboutToBeSetTarget()) {
//                if (event.getNewAboutToBeSetTarget().getItemBySlot(EquipmentSlot.HEAD).is(ModItems.IGNITIUM_HELMET.get())) {
//                    event.setCanceled(true);
//                    return;
//                }
//            }
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public static void onLivingDamage(LivingDamageEvent.Pre event) {
//        LivingEntity entity = event.getEntity();
//        if (entity.getHealth() <= event.getNewDamage() && entity.hasStatusEffect(ModEffect.EFFECTSTUN)) {
//            entity.removeStatusEffect(ModEffect.EFFECTSTUN);
//        }
//        if (event.getSource().getDirectEntity() instanceof LivingEntity living) {
//            List<SlotResult> slot = CuriosApi.getCuriosHelper().findCurios(living, stack -> stack.is(ModItems.BLAZING_GRIPS.get()));
//            if (!slot.isEmpty()) {
//                if (event.getEntity().getRandom().nextFloat() < 0.15F * slot.size()) {
//                    StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 60, 0);
//                    entity.addStatusEffect(effectinstance);
//                }
//            }
//        }
//
//        if (!event.getEntity().getItemBySlot(EquipmentSlot.LEGS).isEmpty() && event.getSource() != null && event.getSource().getEntity() != null) {
//            if(event.getEntity().getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.IGNITIUM_LEGGINGS.get()){
//                Entity attacker = event.getSource().getEntity();
//                if (attacker instanceof LivingEntity && attacker != event.getEntity()) {
//                    if (event.getEntity().getRandom().nextFloat() < 0.5F) {
//                        StatusEffectInstance effectinstance1 = ((LivingEntity) attacker).getStatusEffect(ModEffect.EFFECTBLAZING_BRAND);
//                        int i = 1;
//                        if (effectinstance1 != null) {
//                            i += effectinstance1.getAmplifier();
//                            ((LivingEntity) attacker).removeStatusEffectInternal(ModEffect.EFFECTBLAZING_BRAND);
//                        } else {
//                            --i;
//                        }
//
//                        i = MathHelper.clamp(i, 0, 2);
//                        StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 100, i, false, false, true);
//                        ((LivingEntity) attacker).addStatusEffect(effectinstance);
//
//                        if (!attacker.isOnFire()) {
//                            attacker.setOnFireFor(5);
//                        }
//                    }
//                }
//            }
//        }
//    }


    // DONE
//    @SubscribeEvent
//    public static void onShieldDamage(LivingShieldBlockEvent event) {
//        DamageSource source = event.getDamageSource();
//        LivingEntity entity = event.getEntity();
//        Item item = entity.getActiveItem().getItem();
//        Entity directEntity = source.getSource();
//        if (source.isOf(CMDamageTypes.MALEDICTIO_SAGITTA)) {
//            event.setShieldDamage(0);
//        }
//        ParryAttachment charge = entity.getData(ModDataAttachments.PARRY_ATTACHMENT);
//        if(item == ModItems.BULWARK_OF_THE_FLAME.get()) {
//            if(event.getBlocked()) {
//                if (charge.getParryFrame() < 15) {
//                    if (directEntity instanceof LivingEntity livingEntity) {
//                        livingEntity.setOnFireFor(3);
//                        livingEntity.playSound(SoundEvents.BLOCK_ANVIL_LAND, 0.8f, 1.3F);
//                        StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 100, 0);
//                        livingEntity.takeKnockback(0.5F, entity.getX() - livingEntity.getX(), entity.getZ() - livingEntity.getZ());
//                        livingEntity.addStatusEffect(effectinstance);
//                    }
//
//                }
//            }
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public static void DeathEvent(LivingDeathEvent event) {
//        DamageSource source = event.getSource();
//
//        if (!source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
//            if(tryCursiumPlateRebirth(event.getEntity())){
//                event.setCanceled(true);
//            }
//
//        }
//    }

    private static boolean tryCursiumPlateRebirth(LivingEntity living) {
        ItemStack chestplate = living.getEquippedStack(EquipmentSlot.CHEST);
        if (!living.getWorld().isClient && chestplate.getItem() == ModItems.CURSIUM_CHESTPLATE && !living.hasStatusEffect(ModEffect.EFFECTGHOST_SICKNESS) && !living.hasStatusEffect(ModEffect.EFFECTGHOST_FORM)) {
            living.setHealth(5.0F);
            living.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0));
            living.addStatusEffect(new StatusEffectInstance(ModEffect.EFFECTGHOST_FORM, 100, 0));
            double d0 = living.getX();
            double d1 = living.getY() + 0.3F;
            double d2 = living.getZ();
            float size = 3.0F;
            MessageParticle particlePacket = new MessageParticle();
            for (float i = -size; i <= size; ++i) {
                for (float j = -size; j <= size; ++j) {
                    for (float k = -size; k <= size; ++k) {
                        double d3 = (double) j + (living.getRandom().nextDouble() - living.getRandom().nextDouble()) * 0.5D;
                        double d4 = (double) i + (living.getRandom().nextDouble() - living.getRandom().nextDouble()) * 0.5D;
                        double d5 = (double) k + (living.getRandom().nextDouble() - living.getRandom().nextDouble()) * 0.5D;
                        double d6 = (double) MathHelper.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + living.getRandom().nextGaussian() * 0.05D;
                        particlePacket.queueParticle(ModParticle.CURSED_FLAME,false, d0 , d1, d2, d3 / d6, d4 / d6, d5 / d6);
                        if (i != -size && i != size && j != -size && j != size) {
                            k += size * 2 - 1;
                        }
                    }
                }
            }
//            PacketDistributor.sendToPlayersTrackingEntity(serverplayer, particlePacket);
            NetworkHandler.sendToPlayersTrackingEntity(living, particlePacket);
            return true;
        }
        return false;
    }


    // DONE
//    @SubscribeEvent
//    public static void onLivingAttack(LivingIncomingDamageEvent event) {
//        if (event.getEntity().hasEffect(ModEffect.EFFECTGHOST_FORM)) {
//            if (!event.getSource().is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
//                event.setCanceled(true);
//            }
//        }
//        if (!event.getEntity().getItemBySlot(EquipmentSlot.LEGS).isEmpty() && event.getEntity().getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.CURSIUM_LEGGINGS.get()) {
//            if (event.getSource().is(DamageTypeTags.IS_PROJECTILE)) {
//                if (event.getEntity().getRandom().nextFloat() < 0.15F) {
//                    event.setCanceled(true);
//                }
//            } else if (!event.getSource().is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
//                if (event.getEntity().getRandom().nextFloat() < 0.08F) {
//                    event.setCanceled(true);
//                }
//            }
//        }
//    }


    // DONE
//    @SubscribeEvent
//    public static void onCriticalAttack(CriticalHitEvent event) {
//        ItemStack weapon = event.getEntity().getMainHandItem();
//        if (!weapon.isEmpty() && event.getTarget() instanceof LivingEntity livingEntity) {
//            if (weapon.getItem() == ModItems.THE_ANNIHILATOR.get()) {
//                //if(event.isVanillaCritical()){
//                    event.setDamageMultiplier(2.25F);
//               // }
//
//            }
//            if (weapon.getItem() == ModItems.THE_IMMOLATOR.get()) {
//                if(livingEntity.hasStatusEffect(ModEffect.EFFECTBLAZING_BRAND)){
//                    event.setCriticalHit(true);
//                }
//                event.setDamageMultiplier(2.0F);
//            }
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public static void onLivingFall(LivingFallEvent event) {
//        if (!event.getEntity().getItemBySlot(EquipmentSlot.FEET).isEmpty() && event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.CURSIUM_BOOTS.get()) {
//            event.setDistance(event.getDistance() * 0.3F);
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public static void onPlayerInteract(PlayerInteractEvent.RightClickItem event) {
//        if ( event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
//            event.setCanceled(true);
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public static void onStartUsing(LivingEntityUseItemEvent.Start event) {
//        Item item = event.getItem().getItem();
//        if (item == ModItems.BULWARK_OF_THE_FLAME.get() && event.getEntity() instanceof PlayerEntity player && !player.getItemCooldownManager().isCoolingDown(item)) {
//            ParryAttachment charge = player.getData(ModDataAttachments.PARRY_ATTACHMENT);
//            charge.setParryFrame(0);
//
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public static void onUseTick(LivingEntityUseItemEvent.Tick event) {
//        Item item = event.getItem().getItem();
//        if (item == ModItems.BULWARK_OF_THE_FLAME.get() && event.getEntity() instanceof PlayerEntity player) {
//            ParryAttachment charge = player.getData(ModDataAttachments.PARRY_ATTACHMENT);
//            charge.setParryFrame(charge.getParryFrame() + 1);
//
//        }
//    }


    // DONE
//    @SubscribeEvent
//    public static void onStopUsing(LivingEntityUseItemEvent.Stop event) {
//        Item item = event.getItem().getItem();
//        if (item == ModItems.BULWARK_OF_THE_FLAME.get() && event.getEntity() instanceof PlayerEntity player) {
//            ParryAttachment charge = player.getData(ModDataAttachments.PARRY_ATTACHMENT);
//            charge.setParryFrame(0);
//        }
//    }

}


