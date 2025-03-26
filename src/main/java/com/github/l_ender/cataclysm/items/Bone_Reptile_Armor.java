package com.github.l_ender.cataclysm.items;

import net.minecraft.item.ArmorItem;

public class Bone_Reptile_Armor extends ArmorItem {

    public Bone_Reptile_Armor(Armortier material, Type slot, Settings properties) {
        super(material, slot, properties);

    }
    
//    @Override
//    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getArmorRenderProperties());
//    }

//    @Override
//    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
//        return Cataclysm.MOD_ID + ":textures/armor/bone_reptile_armor.png";
//    }

}