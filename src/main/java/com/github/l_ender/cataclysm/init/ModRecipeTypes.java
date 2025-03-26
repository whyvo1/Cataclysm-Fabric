package com.github.l_ender.cataclysm.init;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.crafting.AltarOfAmethystRecipe;
import com.github.l_ender.cataclysm.crafting.WeaponfusionRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;


public class ModRecipeTypes
{
	//	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Cataclysm.MODID);

	public static final RecipeType<WeaponfusionRecipe> WEAPON_FUSION = registerRecipe("weapon_fusion", WeaponfusionRecipe.Serializer.INSTANCE, WeaponfusionRecipe.Type.INSTANCE);

	public static final RecipeType<AltarOfAmethystRecipe> AMETHYST_BLESS = registerRecipe("amethyst_bless", AltarOfAmethystRecipe.Serializer.INSTANCE, AltarOfAmethystRecipe.Type.INSTANCE);

	public static <T extends Recipe<?>, V extends Recipe<?>> RecipeType<V> registerRecipe(String name, RecipeSerializer<T> serializer, RecipeType<V> type) {
		Registry.register(Registries.RECIPE_SERIALIZER, Cataclysm.modIdentifier(name), serializer);
		return Registry.register(Registries.RECIPE_TYPE, Cataclysm.modIdentifier(name), type);
	}

	public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
		return new RecipeType<>()
		{
			public String toString() {
				return Cataclysm.MOD_ID + ":" + identifier;
			}
		};
	}

	public static void log() {
		Cataclysm.LOGGER.info("Registering recipes for " + Cataclysm.MOD_ID);
	}
}
