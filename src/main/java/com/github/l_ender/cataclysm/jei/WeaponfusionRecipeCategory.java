package com.github.l_ender.cataclysm.jei;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.crafting.WeaponfusionRecipe;
import com.github.l_ender.cataclysm.init.ModBlocks;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class WeaponfusionRecipeCategory implements IRecipeCategory<WeaponfusionRecipe> {
    private final IDrawable background;
    private final IDrawable icon;
    private static final Identifier TEXTURE = Cataclysm.modIdentifier("textures/gui/fusion.png");

    public WeaponfusionRecipeCategory(IGuiHelper guiHelper) {
        background = guiHelper.createDrawable(TEXTURE,26, 46, 125, 18);
        icon = guiHelper.createDrawableItemStack(new ItemStack(ModBlocks.MECHANICAL_FUSION_ANVIL));
    }

    @Override
    public @NotNull RecipeType<WeaponfusionRecipe> getRecipeType() {
        return LEnderCataclysmJEIPlugin.WEAPON_FUSION;
    }

    @Override
    public @NotNull Text getTitle() {
        return ModBlocks.MECHANICAL_FUSION_ANVIL.getName();
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
    public void setRecipe(IRecipeLayoutBuilder builder, WeaponfusionRecipe recipe, IFocusGroup focuses) {

        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1)
                .addIngredients(recipe.getbaseIngredient());

        builder.addSlot(RecipeIngredientRole.INPUT, 50, 1)
                .addIngredients(recipe.getAdditionIngredient());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 1)
                .addItemStack(recipe.getResult(DynamicRegistryManager.EMPTY));
    }

    @Override
    public boolean isHandled(WeaponfusionRecipe recipe) {
        return !recipe.isIgnoredInRecipeBook();
    }

    @Override
    public void draw(WeaponfusionRecipe recipe, IRecipeSlotsView recipeSlotsView, DrawContext guiGraphics, double mouseX, double mouseY) {
        this.background.draw(guiGraphics);
    }
}
