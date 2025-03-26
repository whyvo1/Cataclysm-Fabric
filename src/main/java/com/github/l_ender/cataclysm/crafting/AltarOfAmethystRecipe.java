package com.github.l_ender.cataclysm.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class AltarOfAmethystRecipe implements Recipe<SingleStackRecipeInput> {
    protected final String group;
    private final Ingredient ingredients;
    private ItemStack result;
    private int time;

    public AltarOfAmethystRecipe(String p_249518_, Ingredient ingredients, ItemStack result, int time) {
        this.ingredients = ingredients;
        this.group = p_249518_;
        this.result = result;
        this.time = time;
    }


    public boolean matches(SingleStackRecipeInput p_344849_, World p_345973_) {
        return this.ingredients.test(p_344849_.item());
    }

    public ItemStack craft(SingleStackRecipeInput p_344838_, RegistryWrapper.WrapperLookup p_336115_) {
        return this.result.copy();
    }

    @Override
    public boolean fits(int p_43743_, int p_43744_) {
        return true;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> nonnulllist = DefaultedList.of();
        nonnulllist.add(this.ingredients);
        return nonnulllist;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup p_336110_) {
        return this.result;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    public int getTime() {
        return this.time;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }


    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    public static class Type implements RecipeType<AltarOfAmethystRecipe> {
        private Type() {}

        public static final Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<AltarOfAmethystRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        private static final MapCodec<AltarOfAmethystRecipe> CODEC = RecordCodecBuilder.mapCodec(
                p_340782_ -> p_340782_.group(
                                Codec.STRING.optionalFieldOf("group", "").forGetter(AltarOfAmethystRecipe::getGroup),
                                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredients").forGetter(p_300833_ -> p_300833_.ingredients),
                                ItemStack.CODEC.fieldOf("result").forGetter(p_300827_ -> p_300827_.result),
                                Codec.INT.fieldOf("time").orElse(200).forGetter(p_300834_ -> p_300834_.time)
                        )
                        .apply(p_340782_, AltarOfAmethystRecipe::new)
        );


        public static final PacketCodec<RegistryByteBuf, AltarOfAmethystRecipe> STREAM_CODEC = PacketCodec.ofStatic(
                AltarOfAmethystRecipe.Serializer::toNetwork, AltarOfAmethystRecipe.Serializer::fromNetwork
        );

        @Override
        public MapCodec<AltarOfAmethystRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, AltarOfAmethystRecipe> packetCodec() {
            return STREAM_CODEC;
        }

        private static AltarOfAmethystRecipe fromNetwork(RegistryByteBuf p_320375_) {
            String groupIn = p_320375_.readString();
            Ingredient ingredient1 = Ingredient.PACKET_CODEC.decode(p_320375_);
            ItemStack itemstack = ItemStack.PACKET_CODEC.decode(p_320375_);
            int i = p_320375_.readVarInt();
            return new AltarOfAmethystRecipe(groupIn,ingredient1, itemstack, i);
        }

        private static void toNetwork(RegistryByteBuf p_320743_, AltarOfAmethystRecipe p_319840_) {
            p_320743_.writeString(p_319840_.group);
            Ingredient.PACKET_CODEC.encode(p_320743_, p_319840_.ingredients);
            ItemStack.PACKET_CODEC.encode(p_320743_, p_319840_.result);
            p_320743_.writeVarInt(p_319840_.time);
        }
    }
}



