package com.github.l_ender.cataclysm.inventory;

import com.github.l_ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class MinistrostiyMenu extends ScreenHandler {
    private final Inventory horseContainer;
    private final Netherite_Ministrosity_Entity horse;

    public MinistrostiyMenu(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(15), null);
    }

    public MinistrostiyMenu(int p_39656_, PlayerInventory p_39657_, Inventory p_39658_, final Netherite_Ministrosity_Entity p_39659_) {
        super(null, p_39656_);
        this.horseContainer = p_39658_;
        this.horse = p_39659_;
        p_39658_.onOpen(p_39657_.player);

        for(int k = 0; k < 3; ++k) {
            for(int l = 0; l < p_39659_.getInventoryColumns(); ++l) {
                this.addSlot(new MinistrositySlot(p_39658_, 2 + l + k * p_39659_.getInventoryColumns(), 71 + l * 18, 18 + k * 18));
            }
        }


        for(int i1 = 0; i1 < 3; ++i1) {
            for(int k1 = 0; k1 < 9; ++k1) {
                this.addSlot(new Slot(p_39657_, k1 + i1 * 9 + 9, 8 + k1 * 18, 102 + i1 * 18 - 18));
            }
        }

        for(int j1 = 0; j1 < 9; ++j1) {
            this.addSlot(new Slot(p_39657_, j1, 8 + j1 * 18, 142));
        }

    }



    public boolean canUse(PlayerEntity p_39661_) {
        return !this.horse.hasInventoryChanged(this.horseContainer) && this.horseContainer.canPlayerUse(p_39661_) && this.horse.isAlive() && this.horse.distanceTo(p_39661_) < 8.0F;
    }


    public ItemStack quickMove(PlayerEntity p_40199_, int p_40200_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_40200_);
        if (slot.hasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (p_40200_ < this.horseContainer.size()) {
                if (!this.insertItem(itemstack1, this.horseContainer.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemstack1, 0, this.horseContainer.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return itemstack;
    }

    public boolean mayPlace(ItemStack p_40231_) {
        return true;
    }

    public void onClosed(PlayerEntity p_39663_) {
        super.onClosed(p_39663_);
        this.horseContainer.onClose(p_39663_);
        if (horse != null) horse.setAttackState(5);

    }
}
