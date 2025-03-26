package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;


 public enum Armortier implements ArmorMaterial {
     IGNITIUM(new int[] {6, 11, 9, 6}, 4.0f, 45, 15, 0.15f, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE , ModItems.IGNITIUM_INGOT),
     CURSIUM(new int[] {5, 10, 8, 5}, 4.0f, 45, 15, 0.05f, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE , ModItems.CURSIUM_INGOT),
     CRAB(new int[] {3, 8, 6, 3}, 2.0f, 30, 25, 0.1f, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE , ModItems.AMETHYST_CRAB_SHELL),
     BONE_REPTILE(new int[] {6, 11, 7, 4}, 3f, 35, 15, 0.2f, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE , ModItems.ANCIENT_METAL_INGOT);



     private static final int[] DURABILITY_ARRAY = new int[] {11, 16, 15, 13};
     private final int durability, enchantability;
     private final int[] dmgReduction; // helm[0], chest[1], leggings[2], boots[3]
     private final float toughness, knockbackResistance;
     private final SoundEvent sound;
     private final Item repairMaterial;

     Armortier(int[] dmgReduction, float toughness, int durability, int enchantability, float knockbackResistance, SoundEvent sound, Item repairMaterial)
     {
         this.durability = durability;
         this.dmgReduction = dmgReduction;
         this.enchantability = enchantability;
         this.toughness = toughness;
         this.knockbackResistance = knockbackResistance;
         this.sound = sound;
         this.repairMaterial = repairMaterial;
     }

     @Override
     public int getDurability(ArmorItem.Type type) {
         return DURABILITY_ARRAY[type.ordinal()] * this.durability;
     }

     @Override
     public int getProtection(ArmorItem.Type type) {
         return this.dmgReduction[type.ordinal()];
     }

     @Override
     public int getEnchantability()
     {
         return enchantability;
     }

     @Override
     public SoundEvent getEquipSound()
     {
         return sound;
     }

     @Override
     public Ingredient getRepairIngredient()
     {
         return Ingredient.ofItems(repairMaterial);
     }

     @Override
     public String getName()
     {
         return toString().toLowerCase();
     }

     @Override
     public float getToughness()
     {
         return toughness;
     }

     @Override
     public float getKnockbackResistance()
     {
         return knockbackResistance;
     }

 }



