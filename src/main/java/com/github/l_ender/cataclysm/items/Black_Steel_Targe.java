package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.registry.tag.ItemTags;


public class Black_Steel_Targe extends ShieldItem {

	public Black_Steel_Targe(Settings properties) {
		super(properties);
	}


	@Override
	public boolean canRepair(ItemStack toRepair, ItemStack repair) {
		return repair.isOf(ModItems.BLACK_STEEL_INGOT) || !repair.isIn(ItemTags.PLANKS) && super.canRepair(toRepair, repair);
	}


//	@Override
//	public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ItemAbility itemAbility) {
//		return net.neoforged.neoforge.common.ItemAbilities.DEFAULT_SHIELD_ACTIONS.contains(itemAbility);
//	}

	
}