package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;


public class Armortier {

 public static final RegistryEntry<ArmorMaterial> IGNITIUM = register("ignitium", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
     map.put(ArmorItem.Type.BOOTS, 6);
     map.put(ArmorItem.Type.LEGGINGS, 9);
     map.put(ArmorItem.Type.CHESTPLATE, 11);
     map.put(ArmorItem.Type.HELMET, 6);
     map.put(ArmorItem.Type.BODY, 15);
 }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.IGNITIUM_INGOT), List.of(new ArmorMaterial.Layer(Cataclysm.modIdentifier("ignitium"))), 4.0F, 0.15F);

 public static final RegistryEntry<ArmorMaterial> CURSIUM = register("cursium", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
     map.put(ArmorItem.Type.BOOTS, 5);
     map.put(ArmorItem.Type.LEGGINGS, 8);
     map.put(ArmorItem.Type.CHESTPLATE, 10);
     map.put(ArmorItem.Type.HELMET, 5);
     map.put(ArmorItem.Type.BODY, 13);
 }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.IGNITIUM_INGOT), List.of(new ArmorMaterial.Layer(Cataclysm.modIdentifier("cursium"))), 4.0F, 0.05F);

 public static final RegistryEntry<ArmorMaterial> CRAB = register("crab", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
     map.put(ArmorItem.Type.BOOTS, 4);
     map.put(ArmorItem.Type.LEGGINGS, 7);
     map.put(ArmorItem.Type.CHESTPLATE, 9);
     map.put(ArmorItem.Type.HELMET, 4);
     map.put(ArmorItem.Type.BODY, 13);
 }), 25, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.AMETHYST_CRAB_SHELL), List.of(new ArmorMaterial.Layer(Cataclysm.modIdentifier("crab"))), 2.0F, 0.1F);

 public static final RegistryEntry<ArmorMaterial> BONE_REPTILE = register("bone_reptile", Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
     map.put(ArmorItem.Type.BOOTS, 4);
     map.put(ArmorItem.Type.LEGGINGS, 7);
     map.put(ArmorItem.Type.CHESTPLATE, 11);
     map.put(ArmorItem.Type.HELMET, 6);
     map.put(ArmorItem.Type.BODY, 13);
 }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.ANCIENT_METAL_INGOT), List.of(new ArmorMaterial.Layer(Cataclysm.modIdentifier("bone_reptile"))), 2.5F, 0.1F);

    private static RegistryEntry<ArmorMaterial> register(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            Supplier<Ingredient> repairIngredient,
            List<ArmorMaterial.Layer> layers,
            float toughness,
            float knockbackResistance
    ) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);

        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap.put(type, defense.get(type));
        }

        return Registry.registerReference(
                Registries.ARMOR_MATERIAL,
                Identifier.ofVanilla(id),
                new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance)
        );
    }
}





