package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.init.ModItems;
import java.util.function.Supplier;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum ModItemTier implements ToolMaterial {

    TOOL_WITHERITE(5, 6666, 11.F, 7, 12, () -> ModItems.WITHERITE_INGOT),
    TOOL_ENDERITE(5, 6666, 11.0F, 7, 12, () -> ModItems.ENDERITE_INGOT);

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Item> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability, Supplier<Item> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = damage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMiningLevel() {
        return harvestLevel;
    }

    @Override
    public int getDurability() {
        return maxUses;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(repairMaterial.get());
    }

}