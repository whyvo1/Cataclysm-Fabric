package com.github.l_ender.cataclysm.jei;

import com.github.l_ender.cataclysm.crafting.AltarOfAmethystRecipe;
import com.github.l_ender.cataclysm.crafting.WeaponfusionRecipe;
import com.github.l_ender.cataclysm.init.ModRecipeTypes;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;

public class CMRecipes
{
	private final RecipeManager recipeManager;

	public CMRecipes() {
		MinecraftClient minecraft = MinecraftClient.getInstance();
		ClientWorld level = minecraft.world;

		if (level != null) {
			this.recipeManager = level.getRecipeManager();
		} else {
			throw new NullPointerException("minecraft world must not be null.");
		}
	}

	public List<WeaponfusionRecipe> getWeaponfusionRecipes() {
		return recipeManager.listAllOfType(ModRecipeTypes.WEAPON_FUSION).stream().map(RecipeEntry::value).toList();
	}

	public List<AltarOfAmethystRecipe> getAmethystBlessRecipes() {
		return recipeManager.listAllOfType(ModRecipeTypes.AMETHYST_BLESS).stream().map(RecipeEntry::value).toList();
	}

}
