package com.github.l_ender.cataclysm.crafting;

import com.google.gson.JsonObject;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.world.World;

public class AltarOfAmethystRecipe implements Recipe<Inventory> {
    private final Ingredient ingredients;
    private ItemStack result;
    private int time;
    private final Identifier id;

    public AltarOfAmethystRecipe(Identifier p_44523_,Ingredient ingredients, ItemStack result, int time) {
        this.id = p_44523_;
        this.ingredients = ingredients;
        this.result = result;
        this.time = time;
    }

    public ItemStack getResult() {
        return result;
    }

    @Override
    public boolean matches(Inventory p_44002_, World p_44003_) {
        return this.ingredients.test(p_44002_.getStack(0));
    }

    @Override
    public ItemStack craft(Inventory p_44001_, DynamicRegistryManager p_267165_) {
        return this.result.copy();
    }

    @Override
    public boolean fits(int p_43999_, int p_44000_) {
        return true;
    }

    public Ingredient getbaseIngredient() {
        return this.ingredients;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager p_267052_) {
        return this.result;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    public RecipeSerializer<AltarOfAmethystRecipe> getSerializer() {
        return Serializer.INSTANCE;
    }

    public RecipeType<AltarOfAmethystRecipe> getType() {
        return Type.INSTANCE;
    }

    public int getTime() {
        return time;
    }

    public static class Type implements RecipeType<AltarOfAmethystRecipe> {
        private Type() {}

        public static final Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<AltarOfAmethystRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        public AltarOfAmethystRecipe read(Identifier p_44562_, JsonObject p_44563_) {
            Ingredient ingredient = Ingredient.fromJson(JsonHelper.getObject(p_44563_, "ingredients"));
            ItemStack itemstack = ShapedRecipe.outputFromJson(JsonHelper.getObject(p_44563_, "result"));
            int i = JsonHelper.getInt(p_44563_, "time", 200);
            return new AltarOfAmethystRecipe(p_44562_, ingredient, itemstack, i);
        }

        public AltarOfAmethystRecipe read(Identifier p_44565_, PacketByteBuf p_44566_) {
            Ingredient ingredient = Ingredient.fromPacket(p_44566_);
            ItemStack itemstack = p_44566_.readItemStack();
            int i = p_44566_.readVarInt();
            return new AltarOfAmethystRecipe(p_44565_, ingredient, itemstack, i);
        }

        public void write(PacketByteBuf p_44553_, AltarOfAmethystRecipe p_44554_) {
            p_44554_.ingredients.write(p_44553_);
            p_44553_.writeItemStack(p_44554_.result);
            p_44553_.writeVarInt(p_44554_.time);
        }


    }
}
