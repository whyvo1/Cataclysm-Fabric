package com.github.l_ender.cataclysm.blockentities;

import com.github.l_ender.cataclysm.crafting.AltarOfAmethystRecipe;
import com.github.l_ender.cataclysm.init.ModRecipeTypes;
import com.github.l_ender.cataclysm.init.ModTileentites;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Clearable;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import java.util.Optional;

public class AltarOfAmethyst_Block_Entity extends BlockEntity implements Clearable  {
    private static final int NUM_SLOTS = 1;
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(NUM_SLOTS, ItemStack.EMPTY);
    public int tickCounts;

    private final int[] blessingProgress = new int[1];
    private final int[] cookingTime = new int[1];

    public boolean brightThisTick = false;
    private final RecipeManager.MatchGetter<SingleStackRecipeInput, AltarOfAmethystRecipe> quickCheck = RecipeManager.createCachedMatchGetter(ModRecipeTypes.AMETHYST_BLESS);
    public AltarOfAmethyst_Block_Entity(BlockPos p_155301_, BlockState p_155302_) {
        super(ModTileentites.ALTAR_OF_AMETHYST, p_155301_, p_155302_);
    }

    public static void cookTick(World p_155307_, BlockPos p_155308_, BlockState p_155309_, AltarOfAmethyst_Block_Entity p_155310_) {
        p_155310_.brightThisTick = false;
        p_155310_.tickCounts++;
        for (int i = 0; i < p_155310_.items.size(); i++) {
            ItemStack itemstack = p_155310_.items.get(i);
            if (!itemstack.isEmpty()) {
                p_155310_.brightThisTick  = true;
                p_155310_.blessingProgress[i]++;
                if (p_155310_.blessingProgress[i] >= p_155310_.cookingTime[i]) {
                    SingleStackRecipeInput singlerecipeinput = new SingleStackRecipeInput(itemstack);
                    ItemStack itemstack1 = p_155310_.quickCheck
                            .getFirstMatch(singlerecipeinput, p_155307_)
                            .map(p_344662_ -> p_344662_.value().craft(singlerecipeinput, p_155307_.getRegistryManager()))
                            .orElse(itemstack);
                    if (itemstack1.isItemEnabled(p_155307_.getEnabledFeatures())) {
                        ItemScatterer.spawn(p_155307_, p_155308_.getX(), p_155308_.getY(), p_155308_.getZ(), itemstack1);
                        p_155310_.items.set(i, ItemStack.EMPTY);
                        p_155307_.updateListeners(p_155308_, p_155309_, p_155309_, 3);
                        p_155307_.emitGameEvent(GameEvent.BLOCK_CHANGE, p_155308_, GameEvent.Emitter.of(p_155309_));
                    }
                }
            }
        }

        if (p_155310_.brightThisTick) {
            markDirty(p_155307_, p_155308_, p_155309_);
        }

    }

    public DefaultedList<ItemStack> getItems() {
        return this.items;
    }

    public int getContainerSize() {
        return this.items.size();
    }

    public ItemStack getItem(int index) {
        return this.items.get(index);
    }


    public int getMaxStackSize() {
        return 1;
    }

    public void placeItem(@Nullable LivingEntity entity, int index, ItemStack stack) {
        this.getItems().set(index, stack);
        if (!stack.isEmpty() && stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }

        this.world.emitGameEvent(GameEvent.BLOCK_CHANGE, this.getPos(), GameEvent.Emitter.of(entity, this.getCachedState()));
        this.markUpdated();
    }

    public void readNbt(NbtCompound p_155312_, RegistryWrapper.WrapperLookup p_324612_) {
        super.readNbt(p_155312_,p_324612_);
        this.items.clear();
        Inventories.readNbt(p_155312_, this.items, p_324612_);
        if (p_155312_.contains("blessingProgress", 11)) {
            int[] aint = p_155312_.getIntArray("blessingProgress");
            System.arraycopy(aint, 0, this.blessingProgress, 0, Math.min(this.cookingTime.length, aint.length));
        }

        if (p_155312_.contains("blessingTotalTimes", 11)) {
            int[] aint1 = p_155312_.getIntArray("blessingTotalTimes");
            System.arraycopy(aint1, 0, this.cookingTime, 0, Math.min(this.cookingTime.length, aint1.length));
        }

    }

    protected void writeNbt(NbtCompound p_187486_, RegistryWrapper.WrapperLookup p_324612_) {
        super.writeNbt(p_187486_,p_324612_);
        Inventories.writeNbt(p_187486_, this.items, true, p_324612_);
        p_187486_.putIntArray("blessingProgress", this.blessingProgress);
        p_187486_.putIntArray("blessingTotalTimes", this.cookingTime);
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup p_324612_) {
        NbtCompound compoundtag = new NbtCompound();
        Inventories.writeNbt(compoundtag, this.items, true, p_324612_);
        return compoundtag;
    }


    public Optional<RecipeEntry<AltarOfAmethystRecipe>> getCookableRecipe(ItemStack p_59052_) {
        return this.items.stream().noneMatch(ItemStack::isEmpty) ? Optional.empty() : this.quickCheck.getFirstMatch(new SingleStackRecipeInput(p_59052_), this.world);
    }


    public boolean placeFood(@Nullable LivingEntity p_347582_, ItemStack p_238286_, int p_238287_) {
        for (int i = 0; i < this.items.size(); i++) {
            ItemStack itemstack = this.items.get(i);
            if (itemstack.isEmpty()) {
                this.cookingTime[i] = p_238287_;
                this.blessingProgress[i] = 0;
                this.items.set(i, p_238286_.splitUnlessCreative(1, p_347582_));
                this.world.emitGameEvent(GameEvent.BLOCK_CHANGE, this.getPos(), GameEvent.Emitter.of(p_347582_, this.getCachedState()));
                this.markUpdated();
                return true;
            }
        }

        return false;
    }

    private void markUpdated() {
        this.markDirty();
        this.getWorld().updateListeners(this.getPos(), this.getCachedState(), this.getCachedState(), 3);
    }

    @Override
    public void clear() {
        this.items.clear();
    }

    public void dowse() {
        if (this.world != null) {
            this.markUpdated();
        }
    }

    @Override
    protected void readComponents(BlockEntity.ComponentsAccess p_338534_) {
        super.readComponents(p_338534_);
        p_338534_.getOrDefault(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT).copyTo(this.getItems());
    }

    @Override
    protected void addComponents(ComponentMap.Builder p_338620_) {
        super.addComponents(p_338620_);
        p_338620_.add(DataComponentTypes.CONTAINER, ContainerComponent.fromStacks(this.getItems()));
    }

    @Override
    public void removeFromCopiedStackNbt(NbtCompound p_332690_) {
        p_332690_.remove("Items");
    }


}
