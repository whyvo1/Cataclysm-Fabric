package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;


public enum Tooltier implements ToolMaterial {

//    private static Identifier prefix(String name) {
//        return new Identifier(Cataclysm.MOD_ID, name.toLowerCase(Locale.ROOT));
//    }

//    public static final ToolMaterial ANCIENT_METAL = TierSortingRegistry.registerTier(
//            new ForgeTier(3, 750, 8F, 2, 25,
//                    BlockTags.of(prefix("needs_ancient_metal_tool")), () -> Ingredient.of(ModItems.ANCIENT_METAL_INGOT.get())),
//            prefix("ancient_metal"), List.of(ToolMaterials.IRON), List.of(ToolMaterials.DIAMOND));
//
//    public static final ToolMaterial BLACK_STEEL = TierSortingRegistry.registerTier(
//            new ForgeTier(3, 750, 8F, 2, 25,
//                    BlockTags.of(prefix("needs_black_steel_tool")), () -> Ingredient.of(ModItems.BLACK_STEEL_INGOT.get())),
//            prefix("black_steel"), List.of(ToolMaterials.IRON), List.of(ToolMaterials.DIAMOND));
//
//    public static final ToolMaterial MONSTROSITY = TierSortingRegistry.registerTier(
//            new ForgeTier(4, 2800, 9F, 4, 25,
//                    BlockTags.of(prefix("needs_monstrosity_tool")), () -> Ingredient.of(ModItems.MONSTROUS_HORN.get())),
//            prefix("monstrosity"), List.of(ToolMaterials.NETHERITE), List.of());

    ANCIENT_METAL(3, 750, 2, 8F, 25, () -> Ingredient.ofItems(ModItems.ANCIENT_METAL_INGOT)),
    BLACK_STEEL(3, 750, 2, 8F, 25, () -> Ingredient.ofItems(ModItems.BLACK_STEEL_INGOT)),
    MONSTROSITY(4, 2800, 4, 9F, 25, () -> Ingredient.ofItems(ModItems.MONSTROUS_HORN));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    Tooltier(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
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
    public int getMiningLevel() {
        return this.miningLevel;
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



