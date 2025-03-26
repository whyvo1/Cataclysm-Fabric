package com.github.l_ender.cataclysm.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.github.fabricators_of_create.porting_lib.attributes.PortingLibAttributes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;

import java.util.UUID;

public class Athame extends SwordItem {
    private final Multimap<EntityAttribute, EntityAttributeModifier> incineratorAttributes;

    public Athame(Settings group) {
        super(ToolMaterials.STONE, 3, 0, group);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 4.0D, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -1.8F, EntityAttributeModifier.Operation.ADDITION));
        builder.put(PortingLibAttributes.ENTITY_REACH, new EntityAttributeModifier(UUID.fromString("F0A24AD4-7D3B-4890-A3E6-CDFF88DA7975"), "Tool modifier", -1.0F, EntityAttributeModifier.Operation.ADDITION));
        this.incineratorAttributes = builder.build();
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? this.incineratorAttributes : super.getAttributeModifiers(equipmentSlot);
    }


    public boolean canRepair(ItemStack pickaxe, ItemStack stack) {
        return stack.isOf(Items.PRISMARINE_SHARD);
    }
}