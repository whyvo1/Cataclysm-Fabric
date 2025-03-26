package com.github.l_ender.cataclysm.crafting;

import com.github.l_ender.cataclysm.init.ModBlocks;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.stream.Stream;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public class WeaponfusionRecipe implements WeaponfusionRecipeInterface {
    final Ingredient base;
    final Ingredient addition;
    final ItemStack result;


    public WeaponfusionRecipe(Ingredient p_44524_, Ingredient p_44525_, ItemStack p_44526_) {
        this.base = p_44524_;
        this.addition = p_44525_;
        this.result = p_44526_;
    }

    public boolean matches(WeaponfusionRecipeInput pInput, World pLevel) {
        return this.base.test(pInput.base()) && this.addition.test(pInput.addition());
    }

    public ItemStack craft(WeaponfusionRecipeInput p_345093_, RegistryWrapper.WrapperLookup p_345488_) {
        ItemStack itemstack = p_345093_.base().copyComponentsToNewStack(this.result.getItem(), this.result.getCount());
        itemstack.applyUnvalidatedChanges(this.result.getComponentChanges());
        return itemstack;
    }


    public ItemStack getResult(RegistryWrapper.WrapperLookup p_335712_) {
        return this.result;
    }

    @Override
    public boolean isBaseIngredient(ItemStack p_267276_) {
        return this.base.test(p_267276_);
    }

    public Ingredient getbaseIngredient() {
        return this.base;
    }

    public Ingredient getAdditionIngredient() {
        return this.addition;
    }

    @Override
    public boolean isAdditionIngredient(ItemStack p_267260_) {
        return this.addition.test(p_267260_);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<WeaponfusionRecipe> getType() {
        return Type.INSTANCE;
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModBlocks.MECHANICAL_FUSION_ANVIL);
    }

    @Override
    public boolean isEmpty() {
        return Stream.of(this.base, this.addition).anyMatch((ingredient) -> ingredient.getMatchingStacks().length == 0);
    }

    public static class Type implements RecipeType<WeaponfusionRecipe> {
        private Type() {}

        public static final Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<WeaponfusionRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        private static final MapCodec<WeaponfusionRecipe> CODEC = RecordCodecBuilder.mapCodec(
                p_340782_ -> p_340782_.group(
                                Ingredient.ALLOW_EMPTY_CODEC.fieldOf("base").forGetter(p_300938_ -> p_300938_.base),
                                Ingredient.ALLOW_EMPTY_CODEC.fieldOf("addition").forGetter(p_301153_ -> p_301153_.addition),
                                ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(p_300935_ -> p_300935_.result)
                        )
                        .apply(p_340782_, WeaponfusionRecipe::new)
        );
        public static final PacketCodec<RegistryByteBuf, WeaponfusionRecipe> STREAM_CODEC = PacketCodec.ofStatic(
                Serializer::toNetwork, Serializer::fromNetwork
        );

        @Override
        public MapCodec<WeaponfusionRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, WeaponfusionRecipe> packetCodec() {
            return STREAM_CODEC;
        }

        private static WeaponfusionRecipe fromNetwork(RegistryByteBuf p_320375_) {
            Ingredient ingredient1 = Ingredient.PACKET_CODEC.decode(p_320375_);
            Ingredient ingredient2 = Ingredient.PACKET_CODEC.decode(p_320375_);
            ItemStack itemstack = ItemStack.PACKET_CODEC.decode(p_320375_);
            return new WeaponfusionRecipe(ingredient1, ingredient2, itemstack);
        }

        private static void toNetwork(RegistryByteBuf p_320743_, WeaponfusionRecipe p_319840_) {
            Ingredient.PACKET_CODEC.encode(p_320743_, p_319840_.base);
            Ingredient.PACKET_CODEC.encode(p_320743_, p_319840_.addition);
            ItemStack.PACKET_CODEC.encode(p_320743_, p_319840_.result);
        }
    }

}
