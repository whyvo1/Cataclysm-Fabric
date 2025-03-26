package com.github.l_ender.cataclysm.mixin.Client;

import com.github.l_ender.cataclysm.client.event.ClientEvent;
import com.github.l_ender.cataclysm.init.ModEffect;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Shadow @Final private MinecraftClient client;

    @Unique
    private final Random random = new Random();
    @Unique
    private int lastHealth;
    @Unique
    private int displayHealth;
    @Unique
    private long lastHealthTime;
    @Unique
    private long healthBlinkTime;

    @Inject(method = "renderHealthBar", at = @At("HEAD"), cancellable = true)
    public void injectRenderHealthBar(DrawContext context, PlayerEntity player, int x, int y, int lines, int regeneratingHeartIndex, float maxHealth, int lastHealth, int health, int absorption, boolean blinking, CallbackInfo ci) {
        if(player != null && (player.hasStatusEffect(ModEffect.EFFECTABYSSAL_BURN) || player.hasStatusEffect(ModEffect.EFFECTABYSSAL_CURSE))) {
            InGameHud gui = client.inGameHud;
            if(gui == null) {
                return;
            }
//            gui.setupOverlayRenderState(true, false);
//            int width = scaledWidth;
//            int height = scaledHeight;
            int back = 25;
//            event.setCanceled(true);
            RenderSystem.setShaderTexture(0, ClientEvent.EFFECT_HEART);
            RenderSystem.enableBlend();
            int tickCount = gui.getTicks();
            boolean highlight = this.healthBlinkTime > (long) tickCount && (this.healthBlinkTime - (long) tickCount) / 3L % 2L == 1L;
            if (health < this.lastHealth && player.timeUntilRegen > 0) {
                this.lastHealthTime = Util.getMeasuringTimeMs();
                this.healthBlinkTime = tickCount + 20;
            } else if (health > this.lastHealth && player.timeUntilRegen > 0) {
                this.lastHealthTime = Util.getMeasuringTimeMs();
                this.healthBlinkTime = tickCount + 10;
            }

            if (Util.getMeasuringTimeMs() - this.lastHealthTime > 1000L) {
                this.lastHealth = health;
                this.displayHealth = health;
                this.lastHealthTime = Util.getMeasuringTimeMs();
            }

            this.lastHealth = health;
            int healthLast = this.displayHealth;
            int absorbtion = MathHelper.ceil(player.getAbsorptionAmount());
            int healthRows = MathHelper.ceil((maxHealth + (float) absorbtion) / 2.0F / 10.0F);
            int rowHeight = Math.max(10 - (healthRows - 2), 3);
            this.random.setSeed(tickCount * 312871L);
//            int left = width / 2 - 91;
//            int top = height - gui.leftHeight;
//            gui.leftHeight += healthRows * rowHeight;
//            if (rowHeight != 10) {
//                gui.leftHeight += 10 - rowHeight;
//            }

            int regen = -1;
            if (player.hasStatusEffect(StatusEffects.REGENERATION)) {
                regen = tickCount % MathHelper.ceil(maxHealth + 5.0F);
            }

            int TOP = player.getWorld().getLevelProperties().isHardcore() ? 9 : 0;
            int BACKGROUND = highlight ? back : 16;
            int margin = 34;
            float absorbtionRemaining = (float) absorbtion;

            for (int i = MathHelper.ceil((maxHealth + (float) absorbtion) / 2.0F) - 1; i >= 0; --i) {
                int row = MathHelper.ceil((float) (i + 1) / 10.0F) - 1;
                int p = x + i % 10 * 8;
                int q = y - row * rowHeight;
                if (health <= 4) {
                    q += this.random.nextInt(2);
                }

                if (i == regen) {
                    q -= 2;
                }

                context.drawTexture(ClientEvent.EFFECT_HEART, p, q, BACKGROUND, TOP, 9, 9);
                if (highlight) {
                    if (i * 2 + 1 < healthLast) {
                        context.drawTexture(ClientEvent.EFFECT_HEART, p, q, margin, TOP, 9, 9);
                    } else if (i * 2 + 1 == healthLast) {
                        context.drawTexture(ClientEvent.EFFECT_HEART, p, q, margin + 9, TOP, 9, 9);
                    }
                }

                if (absorbtionRemaining > 0.0F) {
                    if (absorbtionRemaining == (float) absorbtion && (float) absorbtion % 2.0F == 1.0F) {
                        context.drawTexture(ClientEvent.EFFECT_HEART, p, q, margin + 9, TOP, 9, 9);
                        --absorbtionRemaining;
                    } else {
                        context.drawTexture(ClientEvent.EFFECT_HEART, p, q, margin, TOP, 9, 9);
                        absorbtionRemaining -= 2.0F;
                    }
                } else if (i * 2 + 1 < health) {
                    context.drawTexture(ClientEvent.EFFECT_HEART, p, q, margin, TOP, 9, 9);
                } else if (i * 2 + 1 == health) {
                    context.drawTexture(ClientEvent.EFFECT_HEART, p, q, margin + 9, TOP, 9, 9);
                }
            }

            RenderSystem.disableBlend();
            RenderSystem.setShaderTexture(0, ClientEvent.EFFECT_HEART);

            ci.cancel();
        }
    }

}
