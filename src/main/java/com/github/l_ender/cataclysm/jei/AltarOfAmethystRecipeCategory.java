package com.github.l_ender.cataclysm.jei;

import com.github.l_ender.cataclysm.crafting.AltarOfAmethystRecipe;
import com.github.l_ender.cataclysm.init.ModBlocks;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.library.util.RecipeUtil;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

public class AltarOfAmethystRecipeCategory implements IRecipeCategory<AltarOfAmethystRecipe> {
    private final IDrawable background;
    private final IDrawable icon;

    public AltarOfAmethystRecipeCategory(IGuiHelper guiHelper) {
        background = new AltarOfAmethystDrawable();
        icon = guiHelper.createDrawableItemStack(new ItemStack(ModBlocks.ALTAR_OF_AMETHYST));
    }

    @Override
    public @NotNull RecipeType<AltarOfAmethystRecipe> getRecipeType() {
        return LEnderCataclysmJEIPlugin.ALTAR_OF_AMETHYST_RECIPE_RECIPE_TYPE;
    }

    @Override
    public @NotNull Text getTitle() {
        return ModBlocks.ALTAR_OF_AMETHYST.getName().append(Text.literal(" ")).append(Text.translatable("cataclysm.gui.altar_of_amethyst_blessing"));
    }

    @Override
    public int getWidth() {
        return this.background.getWidth();
    }

    @Override
    public int getHeight() {
        return this.background.getHeight();
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, AltarOfAmethystRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 21, 23).addIngredients(recipe.getIngredients().getFirst());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 94, 23).addItemStack(RecipeUtil.getResultItem(recipe));
    }

    @Override
    public boolean isHandled(AltarOfAmethystRecipe recipe) {
        return true;
    }

    @Override
    public void draw(AltarOfAmethystRecipe recipe, IRecipeSlotsView recipeSlotsView, DrawContext guiGraphics, double mouseX, double mouseY) {
        this.background.draw(guiGraphics);
    }
}

