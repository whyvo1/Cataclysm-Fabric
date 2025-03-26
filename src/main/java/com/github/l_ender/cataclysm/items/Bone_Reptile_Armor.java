package com.github.l_ender.cataclysm.items;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;

public class Bone_Reptile_Armor extends ArmorItem {

    public Bone_Reptile_Armor(RegistryEntry<ArmorMaterial> material, Type slot, Settings properties) {
        super(material, slot, properties);

    }


//    @Override
//    public Identifier getArmorTexture(@NotNull ItemStack stack, @NotNull Entity entity, @NotNull EquipmentSlot slot, @NotNull ArmorMaterial.Layer layer, boolean isInnerModel) {
//        return Cataclysm.modIdentifier("textures/armor/bone_reptile_armor.png");
//    }

}