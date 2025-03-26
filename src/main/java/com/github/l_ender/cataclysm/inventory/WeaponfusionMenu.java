package com.github.l_ender.cataclysm.inventory;

import com.github.l_ender.cataclysm.crafting.WeaponfusionRecipe;
import com.github.l_ender.cataclysm.init.ModBlocks;
import com.github.l_ender.cataclysm.init.ModMenu;
import com.github.l_ender.cataclysm.init.ModRecipeTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ForgingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.ForgingSlotsManager;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class WeaponfusionMenu extends ForgingScreenHandler {
    private final World level;
    @Nullable
    private WeaponfusionRecipe selectedRecipe;
    private final List<WeaponfusionRecipe> recipes;

    public WeaponfusionMenu(int p_40245_, PlayerInventory p_40246_) {
        this(p_40245_, p_40246_, ScreenHandlerContext.EMPTY);
    }

    public WeaponfusionMenu(int p_40248_, PlayerInventory p_40249_, ScreenHandlerContext p_40250_) {
        super(ModMenu.WEAPON_FUSION, p_40248_, p_40249_, p_40250_);
        this.level = p_40249_.player.getWorld();
        this.recipes = this.level.getRecipeManager().listAllOfType(ModRecipeTypes.WEAPON_FUSION);
    }

    protected ForgingSlotsManager getForgingSlotsManager() {
        return ForgingSlotsManager.create()
                .input(0, 27, 47, (p_266883_) -> true)
                .input(1, 76, 47, (p_267323_) -> true)
                .output(2, 134, 47).build();
    }

    protected boolean canUse(BlockState p_266887_) {
        return p_266887_.isOf(ModBlocks.MECHANICAL_FUSION_ANVIL);
    }

    protected boolean canTakeOutput(PlayerEntity p_267240_, boolean p_266679_) {
        return this.selectedRecipe != null && this.selectedRecipe.matches(this.input, this.level);
    }

    protected void onTakeOutput(PlayerEntity p_267006_, ItemStack p_266731_) {
        p_266731_.onCraft(p_267006_.getWorld(), p_267006_, p_266731_.getCount());
        this.output.unlockLastRecipe(p_267006_, this.getRelevantItems());
        this.shrinkStackInSlot(0);
        this.shrinkStackInSlot(1);
        this.context.run((p_267191_, p_267098_) -> p_267191_.syncWorldEvent(1044, p_267098_, 0));

    }

    private List<ItemStack> getRelevantItems() {
        return List.of(this.input.getStack(0), this.input.getStack(1), this.input.getStack(2));
    }

    private void shrinkStackInSlot(int p_267273_) {
        ItemStack itemstack = this.input.getStack(p_267273_);
        itemstack.decrement(1);
        this.input.setStack(p_267273_, itemstack);
    }

    public void updateResult() {
        List<WeaponfusionRecipe> list = this.level.getRecipeManager().getAllMatches(ModRecipeTypes.WEAPON_FUSION, this.input, this.level)
                .stream()
                .filter((p_267116_) -> p_267116_ instanceof WeaponfusionRecipe)
                .toList();
        if (list.isEmpty()) {
            this.output.setStack(0, ItemStack.EMPTY);
        } else {
            WeaponfusionRecipe legacyupgraderecipe = list.get(0);
            ItemStack itemstack = legacyupgraderecipe.craft(this.input, this.level.getRegistryManager());
            if (itemstack.isItemEnabled(this.level.getEnabledFeatures())) {
                this.selectedRecipe = legacyupgraderecipe;
                this.output.setLastRecipe(legacyupgraderecipe);
                this.output.setStack(0, itemstack);
            }
        }

    }

    public int getSlotFor(ItemStack p_267241_) {
        return this.shouldQuickMoveToAdditionalSlot(p_267241_) ? 1 : 0;
    }

    protected boolean shouldQuickMoveToAdditionalSlot(ItemStack p_267176_) {
        return this.recipes.stream().anyMatch((p_267065_) -> p_267065_.isAdditionIngredient(p_267176_));
    }

    public boolean canInsertIntoSlot(ItemStack p_266810_, Slot p_267252_) {
        return p_267252_.inventory != this.output && super.canInsertIntoSlot(p_266810_, p_267252_);
    }
}
