package com.github.l_ender.cataclysm.crafting;

import com.github.l_ender.cataclysm.init.ModBlocks;
import com.google.gson.JsonObject;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
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
import java.util.stream.Stream;

public class WeaponfusionRecipe implements Recipe<Inventory> {
    final Ingredient base;
    final Ingredient addition;
    final ItemStack result;
    private final Identifier id;

    public WeaponfusionRecipe(Identifier p_44523_, Ingredient p_44524_, Ingredient p_44525_, ItemStack p_44526_) {
        this.id = p_44523_;
        this.base = p_44524_;
        this.addition = p_44525_;
        this.result = p_44526_;
    }

    public boolean matches(Inventory p_44533_, World p_44534_) {
        return this.base.test(p_44533_.getStack(0)) && this.addition.test(p_44533_.getStack(1));
    }



    public ItemStack craft(Inventory p_44531_, DynamicRegistryManager p_267165_) {
        ItemStack itemstack = this.result.copy();
        NbtCompound compoundtag = p_44531_.getStack(0).getNbt();
        if (compoundtag != null) {
            itemstack.setNbt(compoundtag.copy());
        }

        return itemstack;
    }

    public boolean fits(int p_44528_, int p_44529_) {
        return p_44528_ * p_44529_ >= 2;
    }

    public ItemStack getOutput(DynamicRegistryManager p_267052_) {
        return this.result;
    }

    public Ingredient getbaseIngredient() {
        return this.base;
    }

    public Ingredient getAdditionIngredient() {
        return this.addition;
    }


    public boolean isAdditionIngredient(ItemStack p_44536_) {
        return this.addition.test(p_44536_);
    }

    public ItemStack createIcon() {
        return new ItemStack(ModBlocks.MECHANICAL_FUSION_ANVIL);
    }

    public Identifier getId() {
        return this.id;
    }

    public RecipeSerializer<WeaponfusionRecipe> getSerializer() {
        return Serializer.INSTANCE;
    }

    public RecipeType<WeaponfusionRecipe> getType() {
        return Type.INSTANCE;
    }

    public boolean isEmpty() {
        return Stream.of(this.base, this.addition).anyMatch((ingredient) -> ingredient.getMatchingStacks().length == 0);
    }

    public static class Type implements RecipeType<WeaponfusionRecipe> {
        private Type() {}

        public static final Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<WeaponfusionRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        public WeaponfusionRecipe read(Identifier p_44562_, JsonObject p_44563_) {
            Ingredient ingredient = Ingredient.fromJson(JsonHelper.getObject(p_44563_, "base"));
            Ingredient ingredient1 = Ingredient.fromJson(JsonHelper.getObject(p_44563_, "addition"));
            ItemStack itemstack = ShapedRecipe.outputFromJson(JsonHelper.getObject(p_44563_, "result"));
            return new WeaponfusionRecipe(p_44562_, ingredient, ingredient1, itemstack);
        }

        public WeaponfusionRecipe read(Identifier p_44565_, PacketByteBuf p_44566_) {
            Ingredient ingredient = Ingredient.fromPacket(p_44566_);
            Ingredient ingredient1 = Ingredient.fromPacket(p_44566_);
            ItemStack itemstack = p_44566_.readItemStack();
            return new WeaponfusionRecipe(p_44565_, ingredient, ingredient1, itemstack);
        }

        public void write(PacketByteBuf p_44553_, WeaponfusionRecipe p_44554_) {
            p_44554_.base.write(p_44553_);
            p_44554_.addition.write(p_44553_);
            p_44553_.writeItemStack(p_44554_.result);
        }
    }
}
