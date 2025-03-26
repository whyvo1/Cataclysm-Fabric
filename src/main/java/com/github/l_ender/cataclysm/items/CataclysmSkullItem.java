package com.github.l_ender.cataclysm.items;

import com.github.l_ender.cataclysm.Cataclysm;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Equipment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class CataclysmSkullItem extends VerticallyAttachableBlockItem implements Equipment {

	public CataclysmSkullItem(Block floorBlock, Block wallBlock, Settings properties) {
		super(floorBlock, wallBlock, properties, Direction.DOWN);
	}

	@Override
	public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
		return this.equipAndSwap(this, level, player, hand);
	}

	@Override
	public EquipmentSlot getSlotType() {
		return EquipmentSlot.HEAD;
	}


}