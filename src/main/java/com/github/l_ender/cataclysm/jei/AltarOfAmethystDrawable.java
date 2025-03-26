package com.github.l_ender.cataclysm.jei;
import com.github.l_ender.cataclysm.Cataclysm;
import mezz.jei.api.gui.drawable.IDrawable;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

public class AltarOfAmethystDrawable implements IDrawable {

    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/gui/altar_of_amethyst_jei.png");
    @Override
    public int getWidth() {
        return 125;
    }

    @Override
    public int getHeight() {
        return 59;
    }

    @Override
    public void draw(DrawContext guiGraphics, int xOffset, int yOffset) {
        int i = xOffset;
        int j = yOffset;
        guiGraphics.drawTexture(TEXTURE, i, j, 0, 0, 125, 59, 256, 256);
    }
}
