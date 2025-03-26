package com.github.l_ender.cataclysm.client.event;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.PlayerSandstorm_Model;
import net.minecraft.client.render.block.FluidRenderer;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.Random;

@Environment(EnvType.CLIENT)
public class ClientEvent {
    public static final Identifier FLAME_STRIKE = Cataclysm.modIdentifier("textures/entity/soul_flame_strike_sigil.png");
    public static final Identifier NORMAL_FLAME_STRIKE = Cataclysm.modIdentifier("textures/entity/flame_strike_sigil.png");
    private boolean previousLavaVision = false;
    private FluidRenderer previousFluidRenderer;
    private static final Identifier SANDSTORM_ICON = Cataclysm.modIdentifier("textures/gui/sandstorm_icons.png");
    public static final Identifier EFFECT_HEART = Cataclysm.modIdentifier("textures/gui/effect_heart.png");
    private static final Identifier SANDSTORM_TEXTURE = Cataclysm.modIdentifier("textures/entity/ancient_remnant/sandstorm.png");
    private static final PlayerSandstorm_Model SANDSTORM_MODEL = new PlayerSandstorm_Model();
    private final Random random = new Random();
    private int lastHealth;
    private int displayHealth;
    private long lastHealthTime;
    private long healthBlinkTime;

    // DONE
//    @SubscribeEvent
//    public void onCameraSetup(ViewportEvent.ComputeCameraAngles event) {
//        PlayerEntity player = MinecraftClient.getInstance().player;
//        float delta = MinecraftClient.getInstance().getTickDelta();
//        float ticksExistedDelta = player.age + delta;
//        if (CMConfig.ScreenShake && !MinecraftClient.getInstance().isPaused()) {
//            if (player != null) {
//                float shakeAmplitude = 0;
//                for (ScreenShake_Entity ScreenShake : player.getWorld().getNonSpectatingEntities(ScreenShake_Entity.class, player.getBoundingBox().expand(20, 20, 20))) {
//                    if (ScreenShake.distanceTo(player) < ScreenShake.getRadius()) {
//                        shakeAmplitude += ScreenShake.getShakeAmount(player, delta);
//                    }
//                }
//                if (shakeAmplitude > 1.0f) shakeAmplitude = 1.0f;
//                event.setPitch((float) (event.getPitch() + shakeAmplitude * Math.cos(ticksExistedDelta * 3 + 2) * 25));
//                event.setYaw((float) (event.getYaw() + shakeAmplitude * Math.cos(ticksExistedDelta * 5 + 1) * 25));
//                event.setRoll((float) (event.getRoll() + shakeAmplitude * Math.cos(ticksExistedDelta * 4) * 25));
//            }
//
//            if (MinecraftClient.getInstance().player.getStatusEffect(ModEffect.EFFECTSTUN.get()) != null) {
//                StatusEffectInstance effectinstance1 = MinecraftClient.getInstance().player.getStatusEffect(ModEffect.EFFECTSTUN.get());
//                float shakeAmplitude = (float) ((1 + effectinstance1.getAmplifier()) * 0.01);
//                event.setPitch((float) (event.getPitch() + shakeAmplitude * Math.cos(ticksExistedDelta * 3 + 2) * 25));
//                event.setYaw((float) (event.getYaw() + shakeAmplitude * Math.cos(ticksExistedDelta * 5 + 1) * 25));
//                event.setRoll((float) (event.getRoll() + shakeAmplitude * Math.cos(ticksExistedDelta * 4) * 25));
//            }
//        }
//
//        Entity cameraEntity = MinecraftClient.getInstance().getCameraEntity();
//        if (cameraEntity != null && cameraEntity.hasVehicle() && cameraEntity.getVehicle() instanceof Maledictus_Entity && event.getCamera().isDetached()) {
//            event.getCamera().move(-event.getCamera().getMaxZoom(6F), 0, 0);
//        }
//
//        if (cameraEntity != null && cameraEntity.hasVehicle() && cameraEntity.getVehicle() instanceof Aptrgangr_Entity && event.getCamera().isDetached()) {
//            event.getCamera().move(-event.getCamera().getMaxZoom(3F), 0, 0);
//        }
//
//    }

    // DONE
//    @SubscribeEvent
//    @Environment(EnvType.CLIENT)
//    public void onFogDensity(ViewportEvent.RenderFog event) {
//        CameraSubmersionType fogType = event.getCamera().getFluidInCamera();
//        ItemStack itemstack = MinecraftClient.getInstance().player.getInventory().getArmorStack(3);
//        if (itemstack.isIn(ModItems.IGNITIUM_HELMET.get()) && fogType == CameraSubmersionType.LAVA) {
//            RenderSystem.setShaderFogStart(-8.0F);
//            RenderSystem.setShaderFogEnd(50.0F);
//        }

//    }

    // DONE
//    @SubscribeEvent
//    public void MovementInput(MovementInputUpdateEvent event) {
//        PlayerEntity player = MinecraftClient.getInstance().player;
//        if (player != null) {
//            if (player.hasStatusEffect(ModEffect.EFFECTCURSE_OF_DESERT.get())) {
//                if (MinecraftClient.getInstance().options.backKey.isPressed()) {
//                    event.getInput().forwardImpulse += 2F;
//                }
//                if (MinecraftClient.getInstance().options.leftKey.isPressed()) {
//                    event.getInput().leftImpulse -= 2F;
//                }
//                if (MinecraftClient.getInstance().options.rightKey.isPressed()) {
//                    event.getInput().leftImpulse += 2F;
//                }
//                if (MinecraftClient.getInstance().options.forwardKey.isPressed()) {
//                    event.getInput().forwardImpulse -= 2F;
//                }
//            }
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public void onPreRenderHUD(RenderGuiOverlayEvent.Pre event) {
//        PlayerEntity player = MinecraftClient.getInstance().player;
//        if (player != null) {
//            MinecraftClient mc = MinecraftClient.getInstance();
//            ForgeGui gui = (ForgeGui)mc.inGameHud;
//            if (player.hasVehicle()) {
//                if (player.getVehicle() instanceof The_Leviathan_Tongue_Entity || player.getVehicle() instanceof IHoldEntity) {
//                    if (event.getOverlay().id().equals(VanillaGuiOverlay.HELMET.id())) {
//                        MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.translatable("entity.cataclysm.you_cant_escape"), false);
//                    }
//                }
//            }
//            if (event.getOverlay() == VanillaGuiOverlay.PLAYER_HEALTH.type() && !mc.options.hudHidden && gui.shouldDrawSurvivalElements()) {
//                if (player.hasStatusEffect(ModEffect.EFFECTABYSSAL_BURN.get()) || player.hasStatusEffect(ModEffect.EFFECTABYSSAL_CURSE.get())) {
//                    CustomHealth(event, 25);
//                }
//            }
//        }
//    }

    // DONE
//    @SubscribeEvent
//    public void onPostRenderHUD(RenderGuiOverlayEvent.Post event) {
//        PlayerEntity player = MinecraftClient.getInstance().player;
//    }


    // DONE
//    @SubscribeEvent
//    @Environment(EnvType.CLIENT)
//    public void onPreRenderEntity(RenderLivingEvent.Pre event) {
//        LivingEntity player = (LivingEntity) event.getEntity();
//        boolean usingIncinerator = player.isUsingItem() && (player.getActiveItem().isIn(ModItems.THE_INCINERATOR.get()));
//        boolean usingImmolator = player.isUsingItem() && player.getActiveItem().isIn(ModItems.THE_IMMOLATOR.get());
//        if(usingIncinerator){
//            int i = player.getItemUseTime();
//            float f2 = (float) player.age + event.getPartialTick();
//            MatrixStack matrixStackIn = event.getPoseStack();
//            float f3 = MathHelper.clamp(i, 1, 60);
//            matrixStackIn.push();
//            VertexConsumer ivertexbuilder = ItemRenderer.getArmorGlintConsumer(event.getMultiBufferSource(),CMRenderTypes.getGlowingEffect(FLAME_STRIKE),false, true);
//            matrixStackIn.translate(0.0D, 0.001, 0.0D);
//            matrixStackIn.scale(f3 * 0.05f, f3 * 0.05f, f3 * 0.05f);
//            matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180.0F));
//            matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F + f2));
//            MatrixStack.Entry lvt_19_1_ = matrixStackIn.peek();
//            Matrix4f lvt_20_1_ = lvt_19_1_.getPositionMatrix();
//            Matrix3f lvt_21_1_ = lvt_19_1_.getNormalMatrix();
//            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
//            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
//            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
//            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
//            matrixStackIn.pop();
//        }
//
//        if(usingImmolator){
//            int i = player.getItemUseTime();
//            float f2 = (float) player.age + event.getPartialTick();
//            MatrixStack matrixStackIn = event.getPoseStack();
//            float f3 = MathHelper.clamp(i, 1, 45);
//            matrixStackIn.push();
//            VertexConsumer ivertexbuilder = ItemRenderer.getArmorGlintConsumer(event.getMultiBufferSource(),CMRenderTypes.getGlowingEffect(NORMAL_FLAME_STRIKE),false, true);
//            matrixStackIn.translate(0.0D, 0.001, 0.0D);
//            matrixStackIn.scale(f3 * 0.05f, f3 * 0.05f, f3 * 0.05f);
//            matrixStackIn.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180.0F));
//            matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F + f2));
//            MatrixStack.Entry lvt_19_1_ = matrixStackIn.peek();
//            Matrix4f lvt_20_1_ = lvt_19_1_.getPositionMatrix();
//            Matrix3f lvt_21_1_ = lvt_19_1_.getNormalMatrix();
//            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
//            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
//            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
//            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
//            matrixStackIn.pop();
//        }
//
//        if (ClientProxy.blockedEntityRenders.contains(event.getEntity().getUUID())) {
//            if (!Cataclysm.PROXY.isFirstPersonPlayer(event.getEntity())) {
//                MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Post(event.getEntity(), event.getRenderer(), event.getPartialTick(), event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight()));
//                event.setCanceled(true);
//            }
//            ClientProxy.blockedEntityRenders.remove(event.getEntity().getUUID());
//        }

//    }



//    public void drawVertex(Matrix4f p_229039_1_, Matrix3f p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
//        p_229039_3_.vertex(p_229039_1_, (float) p_229039_4_, (float) p_229039_5_, (float) p_229039_6_).color(255, 255, 255, 255).texture(p_229039_7_, p_229039_8_).overlay(OverlayTexture.DEFAULT_UV).light(p_229039_12_).normal(p_229039_2_, (float) p_229039_9_, (float) p_229039_11_, (float) p_229039_10_).next();
//    }

    // DONE
//    @SubscribeEvent
//    public void clientTick(TickEvent.ClientTickEvent event) {
//        if (event.phase == TickEvent.Phase.START) {
//            CMItemstackRenderer.incrementTick();
//        }

//    }

//    public void updateAllChunks() {
//        if (MinecraftClient.getInstance().worldRenderer.chunks != null) {
//            int length = MinecraftClient.getInstance().worldRenderer.chunks.chunks.length;
//            for (int i = 0; i < length; i++) {
//                MinecraftClient.getInstance().worldRenderer.chunks.chunks[i].needsRebuild = true;
//            }
//        }
//    }

    // DONE
//    @SubscribeEvent
//    @Environment(EnvType.CLIENT)
//    public void onRenderWorldLastEvent(RenderLevelStageEvent event) {
//        if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_SKY) {
//            if (!CMConfig.shadersCompat) {
//                ItemStack itemstack = MinecraftClient.getInstance().player.getInventory().getArmorStack(3);
//                if (itemstack.isIn(ModItems.IGNITIUM_HELMET.get())) {
//                    if (!previousLavaVision) {
//                        previousFluidRenderer = MinecraftClient.getInstance().getBlockRenderManager().fluidRenderer;
//                        MinecraftClient.getInstance().getBlockRenderManager().fluidRenderer = new LavaVisionFluidRenderer();
//                        updateAllChunks();
//                    }
//                } else {
//                    if (previousLavaVision) {
//                        if (previousFluidRenderer != null) {
//                            MinecraftClient.getInstance().getBlockRenderManager().fluidRenderer = previousFluidRenderer;
//                        }
//                        updateAllChunks();
//                    }
//                }
//                previousLavaVision = itemstack.isOf(ModItems.IGNITIUM_HELMET);
//            }
//        }
//    }

    // DONE
//    @SubscribeEvent
//    @Environment(EnvType.CLIENT)
//    public void onGetFluidRenderType(EventGetFluidRenderType event) {
//        if (MinecraftClient.getInstance().player.getInventory().getArmorStack(3).isIn(ModItems.IGNITIUM_HELMET.get()) && (event.getFluidState().is(Fluids.LAVA) || event.getFluidState().is(Fluids.FLOWING_LAVA))) {
//            event.setRenderType(RenderLayer.getTranslucent());
//            event.setResult(Event.Result.ALLOW);
//        }
//    }

    // DONE
//    @SubscribeEvent
//    @Environment(EnvType.CLIENT)
//    public void onPoseHand(EventPosePlayerHand event) {
//        LivingEntity player = (LivingEntity) event.getEntityIn();
//        if (player.getStackInHand(Hand.OFF_HAND).isIn(ModItems.THE_ANNIHILATOR.get()) && player.getStackInHand(Hand.MAIN_HAND).isIn(ModItems.THE_ANNIHILATOR.get()) && player.isUsingItem()){
//            if (player.getMainArm() == Arm.LEFT) {
//                event.getModel().rightArm.pitch = event.getModel().rightArm.pitch * 0.5F - 3.1415927F;
//                event.getModel().rightArm.yaw = 0.0F;
//            } else {
//                event.getModel().leftArm.pitch = event.getModel().leftArm.pitch * 0.5F - 3.1415927F;
//                event.getModel().leftArm.yaw = 0.0F;
//            }
//        }
//        if (player.getStackInHand(Hand.OFF_HAND).isIn(ModItems.THE_IMMOLATOR.get()) && player.getStackInHand(Hand.MAIN_HAND).isIn(ModItems.THE_IMMOLATOR.get()) && player.isUsingItem()){
//            if (player.getMainArm() == Arm.LEFT) {
//                event.getModel().rightArm.pitch = event.getModel().rightArm.pitch * 0.5F - 3.1415927F;
//                event.getModel().rightArm.yaw = 0.0F;
//            } else {
//                event.getModel().leftArm.pitch = event.getModel().leftArm.pitch * 0.5F - 3.1415927F;
//                event.getModel().leftArm.yaw = 0.0F;
//            }
//        }
//    }

    // DONE
//    @SubscribeEvent
//    @Environment(EnvType.CLIENT)
//    public void onRenderArm(RenderArmEvent event) {
//        Hand hand = event.getArm() == event.getPlayer().getMainArm() ? Hand.MAIN_HAND : Hand.OFF_HAND;
//        CuriosApi.getCuriosHelper().getCuriosHandler(event.getPlayer()).ifPresent(handler -> {
//            ICurioStacksHandler stacksHandler = handler.getCurios().get(SlotTypePreset.HANDS.getIdentifier());
//            if (stacksHandler != null) {
//                IDynamicStackHandler stacks = stacksHandler.getStacks();
//                IDynamicStackHandler cosmeticStacks = stacksHandler.getCosmeticStacks();
//
//                for (int slot = hand == InteractionHand.MAIN_HAND ? 0 : 1; slot < stacks.getSlots(); slot += 2) {
//                    ItemStack stack = cosmeticStacks.getStackInSlot(slot);
//                    if (stack.isEmpty() && stacksHandler.getRenders().get(slot)) {
//                        stack = stacks.getStackInSlot(slot);
//                    }
//
//                    Blazing_Grips_Renderer gripsrenderer = Blazing_Grips_Renderer.getGloveRenderer(stack);
//                    if (gripsrenderer != null) {
//                        gripsrenderer.renderFirstPersonArm(event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight(), event.getPlayer(), event.getArm(), stack.hasFoil());
//                    }
//                    RendererSticky_Gloves stickyrenderer = RendererSticky_Gloves.getGloveRenderer(stack);
//                    if (stickyrenderer != null) {
//                        stickyrenderer.renderFirstPersonArm(event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight(), event.getPlayer(), event.getArm(), stack.hasFoil());
//                    }
//                }
//            }
//        });
//    }


//    private void CustomHealth(RenderGuiOverlayEvent.Pre event,int back){
//        PlayerEntity player = MinecraftClient.getInstance().player;
//        MinecraftClient mc = MinecraftClient.getInstance();
//        ForgeGui gui = (ForgeGui)mc.inGameHud;
//        DrawContext stack = event.getGuiGraphics();
//        gui.setupOverlayRenderState(true, false);
//        int width = event.getWindow().getGuiScaledWidth();
//        int height = event.getWindow().getGuiScaledHeight();
//        event.setCanceled(true);
//        RenderSystem.setShaderTexture(0, EFFECT_HEART);
//        RenderSystem.enableBlend();
//        int health = MathHelper.ceil(player.getHealth());
//        int tickCount = gui.getGuiTicks();
//        boolean highlight = this.healthBlinkTime > (long) tickCount && (this.healthBlinkTime - (long) tickCount) / 3L % 2L == 1L;
//        if (health < this.lastHealth && player.timeUntilRegen > 0) {
//            this.lastHealthTime = Util.getMeasuringTimeMs();
//            this.healthBlinkTime = (long) (tickCount + 20);
//        } else if (health > this.lastHealth && player.timeUntilRegen > 0) {
//            this.lastHealthTime = Util.getMeasuringTimeMs();
//            this.healthBlinkTime = (long) (tickCount + 10);
//        }
//
//        if (Util.getMeasuringTimeMs() - this.lastHealthTime > 1000L) {
//            this.lastHealth = health;
//            this.displayHealth = health;
//            this.lastHealthTime = Util.getMeasuringTimeMs();
//        }
//
//        this.lastHealth = health;
//        int healthLast = this.displayHealth;
//        EntityAttributeInstance maxHealth = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
//        float healthMax = (float) maxHealth.getValue();
//        int absorbtion = MathHelper.ceil(player.getAbsorptionAmount());
//        int healthRows = MathHelper.ceil((healthMax + (float) absorbtion) / 2.0F / 10.0F);
//        int rowHeight = Math.max(10 - (healthRows - 2), 3);
//        this.random.setSeed((long) (tickCount * 312871L));
//        int left = width / 2 - 91;
//        int top = height - gui.leftHeight;
//        gui.leftHeight += healthRows * rowHeight;
//        if (rowHeight != 10) {
//            gui.leftHeight += 10 - rowHeight;
//        }
//
//        int regen = -1;
//        if (player.hasStatusEffect(StatusEffects.REGENERATION)) {
//            regen = tickCount % MathHelper.ceil(healthMax + 5.0F);
//        }
//
//        int TOP = player.getWorld().getLevelProperties().isHardcore() ? 9 : 0;
//        int BACKGROUND = highlight ? back : 16;
//        int margin = 34;
//        float absorbtionRemaining = (float) absorbtion;
//
//        for (int i = MathHelper.ceil((healthMax + (float) absorbtion) / 2.0F) - 1; i >= 0; --i) {
//            int row = MathHelper.ceil((float) (i + 1) / 10.0F) - 1;
//            int x = left + i % 10 * 8;
//            int y = top - row * rowHeight;
//            if (health <= 4) {
//                y += this.random.nextInt(2);
//            }
//
//            if (i == regen) {
//                y -= 2;
//            }
//
//            stack.drawTexture(EFFECT_HEART, x, y, BACKGROUND, TOP, 9, 9);
//            if (highlight) {
//                if (i * 2 + 1 < healthLast) {
//                    stack.drawTexture(EFFECT_HEART, x, y, margin, TOP, 9, 9);
//                } else if (i * 2 + 1 == healthLast) {
//                    stack.drawTexture(EFFECT_HEART, x, y, margin + 9, TOP, 9, 9);
//                }
//            }
//
//            if (absorbtionRemaining > 0.0F) {
//                if (absorbtionRemaining == (float) absorbtion && (float) absorbtion % 2.0F == 1.0F) {
//                    stack.drawTexture(EFFECT_HEART, x, y, margin + 9, TOP, 9, 9);
//                    --absorbtionRemaining;
//                } else {
//                    stack.drawTexture(EFFECT_HEART, x, y, margin, TOP, 9, 9);
//                    absorbtionRemaining -= 2.0F;
//                }
//            } else if (i * 2 + 1 < health) {
//                stack.drawTexture(EFFECT_HEART, x, y, margin, TOP, 9, 9);
//            } else if (i * 2 + 1 == health) {
//                stack.drawTexture(EFFECT_HEART, x, y, margin + 9, TOP, 9, 9);
//            }
//        }
//
//        RenderSystem.disableBlend();
//        RenderSystem.setShaderTexture(0, EFFECT_HEART);
//    }

    /**
    private void renderSandstormOverlay(RenderGuiOverlayEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        Minecraft mc = Minecraft.getInstance();
        ForgeGui gui = (ForgeGui) mc.gui;
        GuiGraphics stack = event.getGuiGraphics();
        gui.setupOverlayRenderState(true, false);
        int width = event.getWindow().getGuiScaledWidth();
        int height = event.getWindow().getGuiScaledHeight();
        if ((minecraft.getCameraEntity() instanceof LivingEntity player)) {
            Gone_With_SandstormCapability.IGone_With_SandstormCapability SandstormCapability = ModCapabilities.getCapability(player, ModCapabilities.GONE_WITH_SANDSTORM_CAPABILITY);
            if (SandstormCapability != null) {
                int left = width / 2 + 91;
                int top = height - gui.rightHeight;

                int flytime = Math.abs(SandstormCapability.getSandstormTimer());
                int maxProgressTime = CMConfig.Sandstorm_In_A_Bottle_Timer;

                if (flytime == 0) {
                    return;
                }

                float progress = 1 - flytime / (float) maxProgressTime;

                int full = Mth.ceil((progress - 2D / maxProgressTime) * 10);
                int partial = Mth.ceil(progress * 10) - full;

                for (int i = 0; i < full + partial; ++i) {
                    stack.blit(SANDSTORM_ICON, left - i * 8 - 9, top, -90, (i < full ? 0 : 9), 0, 9, 9, 32, 16);
                }
                gui.rightHeight += 10;

                RenderSystem.disableBlend();
            }
        }
    }
     */

    // DONE
//    @SubscribeEvent(priority = EventPriority.HIGHEST)
//    public void renderBossOverlay(CustomizeGuiOverlayEvent.BossEventProgress event){
//        if(CMConfig.custombossbar) {
//            if (ClientProxy.bossBarRenderTypes.containsKey(event.getBossEvent().getId())) {
//                int renderTypeFor = ClientProxy.bossBarRenderTypes.get(event.getBossEvent().getId());
//
//                CustomBossBar customBossBar = CustomBossBar.customBossBars.getOrDefault(renderTypeFor, null);
//                if (customBossBar == null) return;
//
//                event.setCanceled(true);
//                customBossBar.renderBossBar(event);
//            }
//        }
//    }
}
