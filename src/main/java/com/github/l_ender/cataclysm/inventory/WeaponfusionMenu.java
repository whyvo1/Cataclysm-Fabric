package com.github.l_ender.cataclysm.inventory;

import com.github.l_ender.cataclysm.crafting.WeaponfusionRecipe;
import com.github.l_ender.cataclysm.crafting.WeaponfusionRecipeInput;
import com.github.l_ender.cataclysm.init.ModBlocks;
import com.github.l_ender.cataclysm.init.ModMenu;
import com.github.l_ender.cataclysm.init.ModRecipeTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.ForgingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.ForgingSlotsManager;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.OptionalInt;

public class WeaponfusionMenu extends ForgingScreenHandler {
    private final World level;
    @Nullable
    private RecipeEntry<WeaponfusionRecipe> selectedRecipe;
    private final List<RecipeEntry<WeaponfusionRecipe>> recipes;

    public WeaponfusionMenu(int pContainerId, PlayerInventory pPlayerInventory) {
        this(pContainerId, pPlayerInventory, ScreenHandlerContext.EMPTY);
    }

    public WeaponfusionMenu(int pContainerId, PlayerInventory pPlayerInventory, ScreenHandlerContext pAccess) {
        super(ModMenu.WEAPON_FUSION, pContainerId, pPlayerInventory, pAccess);
        this.level = pPlayerInventory.player.getWorld();
        this.recipes = this.level.getRecipeManager().listAllOfType(ModRecipeTypes.WEAPON_FUSION);
    }

    @Override
    protected ForgingSlotsManager getForgingSlotsManager() {
        return ForgingSlotsManager.create()
                .input(0, 27, 47, p_286208_ -> this.recipes.stream().anyMatch(p_300802_ -> p_300802_.value().isBaseIngredient(p_286208_)))
                .input(1, 76, 47, p_286207_ -> this.recipes.stream().anyMatch(p_300798_ -> p_300798_.value().isAdditionIngredient(p_286207_)))
                .output(2, 134, 47)
                .build();
    }



    @Override
    protected boolean canUse(BlockState pState) {
        return pState.isOf(ModBlocks.MECHANICAL_FUSION_ANVIL);
    }

    @Override
    protected boolean canTakeOutput(PlayerEntity pPlayer, boolean pHasStack) {
        return this.selectedRecipe != null && this.selectedRecipe.value().matches(this.createRecipeInput(), this.level);
    }

    @Override
    protected void onTakeOutput(PlayerEntity pPlayer, ItemStack pStack) {
        pStack.onCraftByPlayer(pPlayer.getWorld(), pPlayer, pStack.getCount());
        this.output.unlockLastRecipe(pPlayer, this.getRelevantItems());
        this.shrinkStackInSlot(0);
        this.shrinkStackInSlot(1);
        this.shrinkStackInSlot(2);
        this.context.run((p_40263_, p_40264_) -> p_40263_.syncWorldEvent(1044, p_40264_, 0));
    }

    private List<ItemStack> getRelevantItems() {
        return List.of(this.input.getStack(0), this.input.getStack(1), this.input.getStack(2));
    }

    private WeaponfusionRecipeInput createRecipeInput() {
        return new WeaponfusionRecipeInput(this.input.getStack(0), this.input.getStack(1));
    }



    private void shrinkStackInSlot(int pIndex) {
        ItemStack itemstack = this.input.getStack(pIndex);
        if (!itemstack.isEmpty()) {
            itemstack.decrement(1);
            this.input.setStack(pIndex, itemstack);
        }
    }

    @Override
    public void updateResult() {
        WeaponfusionRecipeInput smithingrecipeinput = this.createRecipeInput();
        List<RecipeEntry<WeaponfusionRecipe>> list = this.level.getRecipeManager().getAllMatches(ModRecipeTypes.WEAPON_FUSION, smithingrecipeinput, this.level);
        if (list.isEmpty()) {
            this.output.setStack(0, ItemStack.EMPTY);
        } else {
            RecipeEntry<WeaponfusionRecipe> recipeholder = list.getFirst();
            ItemStack itemstack = recipeholder.value().craft(smithingrecipeinput, this.level.getRegistryManager());
            if (itemstack.isItemEnabled(this.level.getEnabledFeatures())) {
                this.selectedRecipe = recipeholder;
                this.output.setLastRecipe(recipeholder);
                this.output.setStack(0, itemstack);
            }
        }
    }

    @Override
    public int getSlotFor(ItemStack pStack) {
        return this.findSlotToQuickMoveTo(pStack).orElse(0);
    }

    private static OptionalInt findSlotMatchingIngredient(WeaponfusionRecipe p_266790_, ItemStack p_266818_) {
        if (p_266790_.isBaseIngredient(p_266818_)) {
            return OptionalInt.of(0);
        } else {
            return p_266790_.isAdditionIngredient(p_266818_) ? OptionalInt.of(1) : OptionalInt.empty();
        }
    }
    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in is null for the initial slot that was double-clicked.
     */
    @Override
    public boolean canInsertIntoSlot(ItemStack pStack, Slot pSlot) {
        return pSlot.inventory != this.output && super.canInsertIntoSlot(pStack, pSlot);
    }

    @Override
    public boolean isValidIngredient(ItemStack pStack) {
        return this.findSlotToQuickMoveTo(pStack).isPresent();
    }

    private OptionalInt findSlotToQuickMoveTo(ItemStack pStack) {
        return this.recipes
                .stream()
                .flatMapToInt(p_300800_ -> findSlotMatchingIngredient(p_300800_.value(), pStack).stream())
                .filter(p_294045_ -> !this.getSlot(p_294045_).hasStack())
                .findFirst();
    }
}
