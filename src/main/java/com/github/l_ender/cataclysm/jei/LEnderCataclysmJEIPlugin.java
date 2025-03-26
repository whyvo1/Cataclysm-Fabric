package com.github.l_ender.cataclysm.jei;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.crafting.AltarOfAmethystRecipe;
import com.github.l_ender.cataclysm.crafting.WeaponfusionRecipe;
import com.github.l_ender.cataclysm.init.ModBlocks;
import com.github.l_ender.cataclysm.init.ModMenu;
import com.github.l_ender.cataclysm.inventory.WeaponfusionMenu;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

@JeiPlugin
public class LEnderCataclysmJEIPlugin implements IModPlugin {
    public static final Identifier MOD = Cataclysm.modIdentifier("jei_plugin");

    public static final RecipeType<WeaponfusionRecipe> WEAPON_FUSION = new RecipeType<>(Cataclysm.modIdentifier("weapon_infusion"), WeaponfusionRecipe.class);

    public static final RecipeType<AltarOfAmethystRecipe> ALTAR_OF_AMETHYST_RECIPE_RECIPE_TYPE = new RecipeType<>(Cataclysm.modIdentifier("altar_of_amethyst"), AltarOfAmethystRecipe.class);

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new WeaponfusionRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
        registry.addRecipeCategories(new AltarOfAmethystRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
    }

    public Identifier getPluginUid() {
        return MOD;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        CMRecipes modRecipes = new CMRecipes();
        registration.addRecipes(WEAPON_FUSION, modRecipes.getWeaponfusionRecipes());
        registration.addRecipes(ALTAR_OF_AMETHYST_RECIPE_RECIPE_TYPE, modRecipes.getAmethystBlessRecipes());
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(WeaponfusionMenu.class, ModMenu.WEAPON_FUSION, WEAPON_FUSION, 0, 6, 9, 36);

    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MECHANICAL_FUSION_ANVIL), WEAPON_FUSION);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ALTAR_OF_AMETHYST), ALTAR_OF_AMETHYST_RECIPE_RECIPE_TYPE);

    }
}
