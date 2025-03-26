package com.github.l_ender.cataclysm.client.gui;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import com.github.l_ender.cataclysm.inventory.MinistrostiyMenu;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class MinistrosityInventoryScreen extends HandledScreen<MinistrostiyMenu> {
    private static final Identifier HORSE_INVENTORY_LOCATION = Cataclysm.modIdentifier("textures/gui/ministrosity2.png");
    private final Netherite_Ministrosity_Entity mini;
    private float xMouse;
    private float yMouse;

    public MinistrosityInventoryScreen(MinistrostiyMenu p_98817_, PlayerInventory p_98818_, Netherite_Ministrosity_Entity p_98819_) {
        super(p_98817_, p_98818_, p_98819_.getDisplayName());
        this.mini = p_98819_;
    }


    protected void drawBackground(DrawContext p_282553_, float p_282998_, int p_282929_, int p_283133_) {
        int i = (this.width - this.backgroundWidth) / 2;
        int j = (this.height - this.backgroundHeight) / 2;
        p_282553_.drawTexture(HORSE_INVENTORY_LOCATION, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);

            p_282553_.drawTexture(HORSE_INVENTORY_LOCATION, i + 70, j + 17, 0, this.backgroundHeight, mini.getInventoryColumns() * 18, 54);
            InventoryScreen.drawEntity(p_282553_, i + 35, j + 62, 40, (float)(i + 35) - this.xMouse, (float)(j + 75 - 50) - this.yMouse, mini);

    }

    public void render(DrawContext p_281697_, int p_282103_, int p_283529_, float p_283079_) {
        this.renderBackground(p_281697_);
        this.xMouse = (float)p_282103_;
        this.yMouse = (float)p_283529_;
        super.render(p_281697_, p_282103_, p_283529_, p_283079_);
        this.drawMouseoverTooltip(p_281697_, p_282103_, p_283529_);
    }
}