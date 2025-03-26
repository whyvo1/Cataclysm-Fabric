package com.github.l_ender.cataclysm.client.gui;

import com.github.l_ender.cataclysm.inventory.WeaponfusionMenu;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.ForgingScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GUIWeponfusion extends ForgingScreen<WeaponfusionMenu> {
    private static final Identifier SMITHING_LOCATION = new Identifier("cataclysm:textures/gui/fusion.png");

    public GUIWeponfusion(WeaponfusionMenu p_99290_, PlayerInventory p_99291_, Text p_99292_) {
        super(p_99290_, p_99291_, p_99292_, SMITHING_LOCATION);
        this.titleX = 66;
        this.titleY = 18;
    }

    protected void drawInvalidRecipeArrow(DrawContext p_282905_, int p_283237_, int p_282237_) {
        if ((this.handler.getSlot(0).hasStack() || this.handler.getSlot(1).hasStack()) && !this.handler.getSlot(this.handler.getResultSlotIndex()).hasStack()) {
            p_282905_.drawTexture(SMITHING_LOCATION, p_283237_ + 99, p_282237_ + 45, this.backgroundWidth, 0, 28, 21);
        }

    }

}
