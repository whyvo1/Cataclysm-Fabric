package com.github.l_ender.cataclysm.event;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.config.CMConfig;
import com.github.l_ender.cataclysm.config.ConfigHolder;
import com.github.l_ender.cataclysm.init.*;
import com.github.l_ender.cataclysm.items.ILeftClick;
import com.github.l_ender.cataclysm.message.MessageParticle;
import com.github.l_ender.lionfishapi.server.event.StandOnFluidCallback;
import fuzs.forgeconfigapiport.api.config.v2.ModConfigEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.player.*;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.config.ModConfig;


//@Mod.EventBusSubscriber(modid = Cataclysm.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ServerEventHandler {


//    @SubscribeEvent
//    public void onLivingUpdateEvent(LivingEvent.LivingTickEvent event) {
//        HookCapability.IHookCapability hookCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.HOOK_CAPABILITY);
//        if (hookCapability != null) {
//            hookCapability.tick(event.getEntity());
//        }
//
//        ChargeCapability.IChargeCapability chargeCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.CHARGE_CAPABILITY);
//        if (chargeCapability != null) {
//            chargeCapability.tick(event.getEntity());
//        }
//        RenderRushCapability.IRenderRushCapability RushCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.RENDER_RUSH_CAPABILITY);
//        if (RushCapability != null) {
//            RushCapability.tick(event.getEntity());
//        }
//    }

    public static void registerListeners() {
        StandOnFluidCallback.EVENT.register(((entity, fluidState) -> {
            if(entity.getEquippedStack(EquipmentSlot.FEET).isOf(ModItems.IGNITIUM_BOOTS) &&
                    !entity.isSneaking() &&
                    fluidState.isIn(FluidTags.LAVA)) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        }));

//        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
//            if(player.hasStatusEffect(ModEffect.EFFECTSTUN) || player.hasStatusEffect(ModEffect.EFFECTGHOST_FORM)) {
//                return ActionResult.CONSUME;
//            }
//            if(!world.isClient()) {
//                ServerEventHandler.onAttack(player);
//            }
//            return ActionResult.PASS;
//        });
//
//        AttackEntityCallback.EVENT.register(((player, world, hand, entity, hitResult) -> {
//            if(player.hasStatusEffect(ModEffect.EFFECTSTUN) || player.hasStatusEffect(ModEffect.EFFECTGHOST_FORM)) {
//                return ActionResult.CONSUME;
//            }
//            if(!world.isClient()) {
//                ServerEventHandler.onAttack(player);
//            }
//            return ActionResult.PASS;
//        }));

        AttackCallback.EVENT.register(((player, world, type) -> {
            if(player.hasStatusEffect(ModEffect.EFFECTSTUN) || player.hasStatusEffect(ModEffect.EFFECTGHOST_FORM)) {
//                ServerEventHandler.onAttack(player);
                return ActionResult.FAIL;
            }
            if(ServerEventHandler.onAttack(player)) {
                return ActionResult.SUCCESS;
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

        // Rebake the configs when they change
        ModConfigEvents.loading(Cataclysm.MOD_ID).register(ServerEventHandler::onConfigLoad);
        ModConfigEvents.reloading(Cataclysm.MOD_ID).register(ServerEventHandler::onConfigLoad);
    }

    public static boolean onAttack(PlayerEntity player) {
        ItemStack leftItem = player.getOffHandStack();
        ItemStack rightItem = player.getMainHandStack();
        if(!player.hasStatusEffect(ModEffect.EFFECTSTUN)){
            if (rightItem.getItem() instanceof ILeftClick) {
                if(((ILeftClick) rightItem.getItem()).onLeftClick(rightItem, player)) {
                    return true;
                }
            }
            if (leftItem.getItem() instanceof ILeftClick) {
                if(((ILeftClick) leftItem.getItem()).onLeftClick(leftItem, player)) {
                    return true;
                }
            }
//            if (player.getWorld().isClient() && flag) {
//                MessageSwingArm.INSTANCE.sendToServer();
//            }
        }
        return false;
    }

    private static void onConfigLoad(ModConfig config) {
        if (config.getSpec() == ConfigHolder.COMMON_SPEC) {
            CMConfig.bake(config);
        }
//        BiomeConfig.init();
    }

    // DONE
//    @SubscribeEvent
//    public void StandOnFluidEventEvent(StandOnFluidEvent event) {
//        if (!event.getEntity().getItemBySlot(EquipmentSlot.FEET).isEmpty() && event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.IGNITIUM_BOOTS.get()) {
//            if (!event.getEntity().isShiftKeyDown() && (event.getFluidState().is(Fluids.LAVA) || event.getFluidState().is(Fluids.FLOWING_LAVA))) {
//                event.setCanceled(true);
//            }
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public void onLivingDamage(LivingHurtEvent event) {
//        LivingEntity target = event.getEntity();
//        if (!target.getWorld().isClient() && event.getSource().getDirectEntity() instanceof LivingEntity living) {
//            ItemStack weapon = living.getMainHandStack();
//
//            if (!weapon.isEmpty()) {
//                if ((weapon.isIn(ModItems.ZWEIENDER.get()))) {
//                    Vec3d lookDir = new Vec3d(target.getRotationVector().x, 0, target.getRotationVector().z).normalize();
//                    Vec3d vecBetween = new Vec3d(target.getX() - living.getX(), 0, target.getZ() - living.getZ()).normalize();
//                    double dot = lookDir.dotProduct(vecBetween);
//                    if (dot > 0.05) {
//                        event.setAmount(event.getAmount() * 2);
//                        target.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 0.75F, 0.5F);
//                    }
//                    // enchantment attack sparkles
//                }
//
//                if ((weapon.isIn(ModItems.FINAL_FRACTAL.get()))) {
//                    event.setAmount(event.getAmount() + target.getMaxHealth() * 0.03f);
//                }
//
//            }
//        }
//
//        if (event.getSource().getDirectEntity() instanceof LivingEntity living) {
//            List<SlotResult> slot = CuriosApi.getCuriosHelper().findCurios(living, stack -> stack.is(ModItems.BLAZING_GRIPS.get()));
//            if (!slot.isEmpty()) {
//                if (event.getEntity().getRandom().nextFloat() < 0.15F * slot.size()) {
//                    StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND.get(), 60, 0);
//                    target.addStatusEffect(effectinstance);
//                }
//            }
//        }
//
//    }

    //DONE
//    @SubscribeEvent
//    public void onPlayerAttack(AttackEntityEvent event) {
//        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
//            event.setCanceled(true);
//        }
//        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTGHOST_FORM.get())) {
//            event.setCanceled(true);
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public void BlockHeal(LivingHealEvent event) {
//        if (event.getEntity().hasEffect(ModEffect.EFFECTABYSSAL_FEAR.get())) {
//            event.setCanceled(true);
//        }
//    }

    // 8 DONE
//    @SubscribeEvent
//    public void onLivingJump(LivingEvent.LivingJumpEvent event) {
//        LivingEntity entity = event.getEntity();
//        if (entity.getStatusEffect(ModEffect.EFFECTSTUN.get()) != null){
//            entity.setVelocity(entity.getVelocity().getX(), 0.0D, entity.getVelocity().getZ());
//        }
//    }
//
//    @SubscribeEvent
//    public void onPlayerLeftClick(PlayerInteractEvent.LeftClickBlock event) {
//        PlayerEntity player = event.getEntity();
//        if (event.isCancelable() && player.hasStatusEffect(ModEffect.EFFECTSTUN.get())) {
//            event.setCanceled(true);
//        }
//    }
//
//    @SubscribeEvent
//    public void onUseItem(LivingEntityUseItemEvent event) {
//        LivingEntity living = event.getEntity();
//        if (event.isCancelable() && living.hasStatusEffect(ModEffect.EFFECTSTUN.get())) {
//            event.setCanceled(true);
//        }
//        if (event.isCancelable() && living.hasStatusEffect(ModEffect.EFFECTGHOST_FORM.get())) {
//            event.setCanceled(true);
//        }
//    }
//
//    @SubscribeEvent
//    public void onPlaceBlock(BlockEvent.EntityPlaceEvent event) {
//        Entity entity = event.getEntity();
//        if (entity instanceof LivingEntity) {
//            LivingEntity living = (LivingEntity) entity;
//            if (event.isCancelable() && living.hasStatusEffect(ModEffect.EFFECTSTUN.get())) {
//                event.setCanceled(true);
//            }
//        }
//    }
//
     // DONE
//    @SubscribeEvent
//    public void KnockbackEvent(LivingKnockBackEvent event) {
//        LivingEntity living = event.getEntity();
//        if(living instanceof Royal_Draugr_Entity royalDraugr){
//            if(royalDraugr.isDraugrBlocking()){
//                event.setCanceled(true);
//            }
//        }
//    }
//
//
//    @SubscribeEvent
//    public void onFillBucket(FillBucketEvent event) {
//        LivingEntity living = event.getEntity();
//        if (living != null) {
//            if (event.isCancelable() && living.hasStatusEffect(ModEffect.EFFECTSTUN.get())) {
//                event.setCanceled(true);
//            }
//        }
//    }
//
//    @SubscribeEvent
//    public void onBreakBlock(BlockEvent.BreakEvent event) {
//        if (event.isCancelable() && event.getPlayer().hasEffect(ModEffect.EFFECTSTUN.get())) {
//            event.setCanceled(true);
//        }
//    }
//
//    @SubscribeEvent
//    public void onPlayerInteract(PlayerInteractEvent.RightClickEmpty event) {
//        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
//            event.setCanceled(true);
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public void onPlayerInteract(PlayerInteractEvent.LeftClickEmpty event) {
//        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
//            event.setCanceled(true);
//        }
//        boolean flag = false;
//        ItemStack leftItem = event.getEntity().getOffhandItem();
//        ItemStack rightItem = event.getEntity().getMainHandItem();
//        if(!event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())){
//            if (leftItem.getItem() instanceof ILeftClick) {
//                ((ILeftClick) leftItem.getItem()).onLeftClick(leftItem, event.getEntity());
//                flag = true;
//            }
//            if (rightItem.getItem() instanceof ILeftClick) {
//                ((ILeftClick) rightItem.getItem()).onLeftClick(rightItem, event.getEntity());
//                flag = true;
//            }
//            if (event.getLevel().isClientSide && flag) {
//                Cataclysm.sendMSGToServer(MessageSwingArm.INSTANCE);
//            }
//        }
//    }

    // 3 DONE
//    @SubscribeEvent
//    public void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
//        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
//            event.setCanceled(true);
//        }
//    }
//
//    @SubscribeEvent
//    public void onPlayerInteract(PlayerInteractEvent.RightClickBlock event) {
//        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
//            event.setCanceled(true);
//        }
//    }
//
//    @SubscribeEvent
//    public void onPlayerInteract(PlayerInteractEvent.LeftClickBlock event) {
//        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
//            event.setCanceled(true);
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public void onLivingSetTargetEvent(LivingChangeTargetEvent event) {
//        if (event.getNewTarget() != null && event.getEntity() instanceof MobEntity mob) {
//            if (mob.getType().isIn(ModTag.LAVA_MONSTER) && event.getEntity().getLastHurtByMob() != event.getNewTarget()) {
//                if (event.getNewTarget().getItemBySlot(EquipmentSlot.HEAD).is(ModItems.IGNITIUM_HELMET.get())) {
//                    event.setCanceled(true);
//                    return;
//                }
//            }
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public void onLivingDamage(LivingDamageEvent event) {
//        LivingEntity entity = event.getEntity();
//        if (entity.getHealth() <= event.getAmount() && entity.hasStatusEffect(ModEffect.EFFECTSTUN.get())) {
//            entity.removeStatusEffect(ModEffect.EFFECTSTUN.get());
//        }
//        if (!event.getEntity().getItemBySlot(EquipmentSlot.LEGS).isEmpty() && event.getSource() != null && event.getSource().getEntity() != null) {
//            if(event.getEntity().getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.IGNITIUM_LEGGINGS.get()){
//                Entity attacker = event.getSource().getEntity();
//                if (attacker instanceof LivingEntity && attacker != event.getEntity()) {
//                    if (event.getEntity().getRandom().nextFloat() < 0.5F) {
//                        StatusEffectInstance effectinstance1 = ((LivingEntity) attacker).getStatusEffect(ModEffect.EFFECTBLAZING_BRAND.get());
//                        int i = 1;
//                        if (effectinstance1 != null) {
//                            i += effectinstance1.getAmplifier();
//                            ((LivingEntity) attacker).removeStatusEffectInternal(ModEffect.EFFECTBLAZING_BRAND.get());
//                        } else {
//                            --i;
//                        }
//
//                        i = MathHelper.clamp(i, 0, 4);
//                        StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND.get(), 100, i, false, false, true);
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
//    public void onShieldDamage(ShieldBlockEvent event) {
//        DamageSource source = event.getDamageSource();
//
//        LivingEntity entity = event.getEntity();
//        Item item = entity.getActiveItem().getItem();
//        Entity directEntity = source.getSource();
//        if (source.isOf(CMDamageTypes.MALEDICTIO_SAGITTA)) {
//            event.setShieldTakesDamage(false);
//        }
//
//
//        ParryCapability.IParryCapability ParryCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.PARRY_CAPABILITY);
//
//        if(item == ModItems.BULWARK_OF_THE_FLAME.get()) {
//            if (ParryCapability != null) {
//                if (ParryCapability.getParryFrame() < 15) {
//                    if (directEntity instanceof LivingEntity livingEntity) {
//                        livingEntity.setOnFireFor(3);
//                        livingEntity.playSound(SoundEvents.BLOCK_ANVIL_LAND, 0.8f, 1.3F);
//                        StatusEffectInstance effectinstance = new StatusEffectInstance(ModEffect.EFFECTBLAZING_BRAND.get(), 100, 0);
//                        livingEntity.takeKnockback(0.5F, entity.getX() - livingEntity.getX(), entity.getZ() - livingEntity.getZ());
//                        livingEntity.addStatusEffect(effectinstance);
//                    }
//                }
//            }
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public void DeathEvent(LivingDeathEvent event) {
//        DamageSource source = event.getSource();
//        if (!event.getEntity().level().isClientSide) {
//            if (!source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
//                if(tryCursiumPlateRebirth(event.getEntity())){
//                    event.setCanceled(true);
//                }
//            }
//        }
//    }

    private static boolean tryCursiumPlateRebirth(LivingEntity living) {
        ItemStack chestplate = living.getEquippedStack(EquipmentSlot.CHEST);
        if (!living.getWorld().isClient() && chestplate.getItem() == ModItems.CURSIUM_CHESTPLATE && !living.hasStatusEffect(ModEffect.EFFECTGHOST_SICKNESS) && !living.hasStatusEffect(ModEffect.EFFECTGHOST_FORM)) {
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
            for (ServerPlayerEntity serverplayer : PlayerLookup.tracking(living)) {
//                if (serverplayer.squaredDistanceTo(Vec3d.ofCenter(living.getBlockPos())) < 1024.0D) {
                particlePacket.sendToClient(serverplayer);
            }
            return true;
        }
        return false;
    }


    // DONE
//    @SubscribeEvent
//    public void onLivingAttack(LivingAttackEvent event) {
//        if (event.getEntity().hasEffect(ModEffect.EFFECTGHOST_FORM.get())) {
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
//    public void onLivingAttack(CriticalHitEvent event) {
//        ItemStack weapon = event.getEntity().getMainHandItem();
//        if (!weapon.isEmpty() && event.getTarget() instanceof LivingEntity livingEntity) {
//            if (weapon.getItem() == ModItems.THE_ANNIHILATOR.get()) {
//                //if(event.isVanillaCritical()){
//                    event.setDamageModifier(2.25F);
//               // }
//
//            }
//            if (weapon.getItem() == ModItems.THE_IMMOLATOR.get()) {
//                if(livingEntity.hasStatusEffect(ModEffect.EFFECTBLAZING_BRAND.get())){
//                    event.setResult(Event.Result.ALLOW);
//                }
//                event.setDamageModifier(2.0F);
//            }
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public void onLivingFall(LivingFallEvent event) {
//        if (!event.getEntity().getItemBySlot(EquipmentSlot.FEET).isEmpty() && event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.CURSIUM_BOOTS.get()) {
//            event.setDistance(event.getDistance() * 0.3F);
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public void onPlayerInteract(PlayerInteractEvent.RightClickItem event) {
//        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
//            event.setCanceled(true);
//        }
//    }


    // DONE
//    @SubscribeEvent
//    public void onStartUsing(LivingEntityUseItemEvent.Start event) {
//        Item item = event.getItem().getItem();
//        if (item == ModItems.BULWARK_OF_THE_FLAME.get() && event.getEntity() instanceof PlayerEntity player && player.handSwingProgress == 0 && !player.getItemCooldownManager().isCoolingDown(item)) {
//            ParryCapability.IParryCapability ParryCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.PARRY_CAPABILITY);
//            if (ParryCapability != null) {
//                ParryCapability.setParryFrame(0);
//            }
//        }
//    }


    // DONE
//    @SubscribeEvent
//    public void onUseTick(LivingEntityUseItemEvent.Tick event) {
//        Item item = event.getItem().getItem();
//        if (item == ModItems.BULWARK_OF_THE_FLAME.get() && event.getEntity() instanceof PlayerEntity player) {
//            ParryCapability.IParryCapability ParryCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.PARRY_CAPABILITY);
//            if (ParryCapability != null) {
//                ParryCapability.setParryFrame(ParryCapability.getParryFrame() + 1);
//            }
//
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public void onStopUsing(LivingEntityUseItemEvent.Stop event) {
//        Item item = event.getItem().getItem();
//        if (item == ModItems.BULWARK_OF_THE_FLAME.get() && event.getEntity() instanceof PlayerEntity) {
//            ParryCapability.IParryCapability ParryCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.PARRY_CAPABILITY);
//            if (ParryCapability != null) {
//                ParryCapability.setParryFrame(0);
//            }
//        }
//    }

}


