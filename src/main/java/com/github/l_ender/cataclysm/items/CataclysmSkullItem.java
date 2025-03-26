package com.github.l_ender.cataclysm.items;

import dev.emi.trinkets.api.Trinket;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Equipment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class CataclysmSkullItem extends VerticallyAttachableBlockItem implements Trinket, Equipment {

	public CataclysmSkullItem(Block floorBlock, Block wallBlock, Settings properties) {
		super(floorBlock, wallBlock, properties, Direction.DOWN);
	}

	@Override
	public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getStackInHand(hand);
		EquipmentSlot equipmentslot = MobEntity.getPreferredEquipmentSlot(itemstack);
		ItemStack itemstack1 = player.getEquippedStack(equipmentslot);
		if (itemstack1.isEmpty()) {
			player.equipStack(equipmentslot, itemstack.split(1));
			if (!level.isClient()) {
				player.incrementStat(Stats.USED.getOrCreateStat(this));
			}

			return TypedActionResult.success(itemstack, level.isClient());
		} else {
			return TypedActionResult.fail(itemstack);
		}
	}

//	@Override
//	public boolean canEquip(ItemStack stack, EquipmentSlot slot, Entity entity) {
//		return slot == EquipmentSlot.HEAD;
//	}

//	@Override
//	@Nullable
//	public EquipmentSlot getEquipmentSlot(ItemStack stack) {
//		return EquipmentSlot.HEAD;
//	}


//	@Override
//	public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
//		consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getISTERProperties());
//	}

	@Override
	public EquipmentSlot getSlotType() {
		return EquipmentSlot.HEAD;
	}
}