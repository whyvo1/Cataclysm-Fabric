package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModTag;
import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;


public enum Tooltier implements ToolMaterial {
    ANCIENT_METAL(ModTag.INCORRECT_FOR_ANCIENT_METAL_TOOL, 750, 8.0F, 2.0F, 25, () -> Ingredient.ofItems(ModItems.ANCIENT_METAL_INGOT)),
    BLACK_STEEL(ModTag.INCORRECT_FOR_BLACK_STEEL_TOOL, 750, 8.0F, 2.0F, 25, () -> Ingredient.ofItems(ModItems.BLACK_STEEL_INGOT)),
    MONSTROSITY(ModTag.INCORRECT_FOR_MONSTROSITY_TOOL, 2800, 9.0F, 4.0F, 25, () -> Ingredient.ofItems(ModItems.MONSTROUS_HORN));

//    public static final ToolMaterial ANCIENT_METAL = new
//            SimpleTier(BlockTags.of(prefix("needs_ancient_metal_tool")), 750, 8.0F, 2.0F, 25, () -> Ingredient.of(ModItems.ANCIENT_METAL_INGOT.get()));
//
//    public static final ToolMaterial BLACK_STEEL = new
//            SimpleTier(BlockTags.of(prefix("needs_black_steel_tool")), 750, 8.0F, 2.0F, 25, () -> Ingredient.of(ModItems.BLACK_STEEL_INGOT.get()));
//
//    public static final ToolMaterial MONSTROSITY = new
//            SimpleTier(BlockTags.of(prefix("needs_monstrosity_tool")), 2800, 9.0F, 4.0F, 25, () -> Ingredient.of(ModItems.MONSTROUS_HORN.get()));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    Tooltier(
            final TagKey<Block> inverseTag,
            final int itemDurability,
            final float miningSpeed,
            final float attackDamage,
            final int enchantability,
            final Supplier<Ingredient> repairIngredient
    ) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}



