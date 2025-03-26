package com.github.l_ender.cataclysm.crafting;

import com.github.l_ender.cataclysm.init.ModBlocks;
import com.github.l_ender.cataclysm.init.ModRecipeTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;

public interface WeaponfusionRecipeInterface extends Recipe<WeaponfusionRecipeInput> {
    @Override
    RecipeType<?> getType();

    @Override
    default boolean fits(int p_44528_, int p_44529_) {
        return p_44528_ * p_44529_ >= 2;
    }


    @Override
    ItemStack createIcon();


    boolean isBaseIngredient(ItemStack pStack);

    boolean isAdditionIngredient(ItemStack pStack);

}
