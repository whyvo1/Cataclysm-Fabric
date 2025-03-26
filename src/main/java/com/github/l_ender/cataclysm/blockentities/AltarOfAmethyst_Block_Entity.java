package com.github.l_ender.cataclysm.blockentities;

import com.github.l_ender.cataclysm.crafting.AltarOfAmethystRecipe;
import com.github.l_ender.cataclysm.init.ModRecipeTypes;
import com.github.l_ender.cataclysm.init.ModTileentites;
import com.github.l_ender.cataclysm.message.MessageUpdateblockentity;
import java.util.Optional;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Clearable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AltarOfAmethyst_Block_Entity extends BlockEntity implements Clearable {
    private static final int NUM_SLOTS = 1;
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(NUM_SLOTS, ItemStack.EMPTY);
    public int blessingProgress;
    public int tickCounts;
    public boolean brightThisTick = false;
    private final RecipeManager.MatchGetter<Inventory, AltarOfAmethystRecipe> quickCheck = RecipeManager.createCachedMatchGetter(ModRecipeTypes.AMETHYST_BLESS);

    public AltarOfAmethyst_Block_Entity(BlockPos p_155301_, BlockState p_155302_) {
        super(ModTileentites.ALTAR_OF_AMETHYST, p_155301_, p_155302_);
    }

    public static void cookTick(World p_155307_, BlockPos p_155308_, BlockState p_155309_, AltarOfAmethyst_Block_Entity p_155310_) {
        p_155310_.brightThisTick = false;
        p_155310_.tickCounts++;
        ItemStack itemstack = p_155310_.items.get(0);
        if (!itemstack.isEmpty()) {
            Inventory container = new SimpleInventory(itemstack);
            Optional<AltarOfAmethystRecipe> ingredient = p_155310_.quickCheck.getFirstMatch(container, p_155307_);
            ItemStack finale = ingredient.map((p_270054_) -> p_270054_.getResult().copy()).orElse(itemstack);
            if(ingredient.isPresent()){
                p_155310_.brightThisTick = true;
                if(p_155310_.blessingProgress >= ingredient.get().getTime()) {
                    ItemStack current = p_155310_.getItem(0).copy();
                    current.decrement(1);
                    if(!current.isEmpty()){
                        ItemEntity itemEntity = new ItemEntity(p_155307_, p_155308_.getX() + 0.5F, p_155308_.getY() + 0.5F, p_155308_.getZ() + 0.5F, current);
                        if(!p_155307_.isClient){
                            p_155307_.spawnEntity(itemEntity);
                        }
                    }
                    p_155310_.setItem(0, finale);
                }
            }

        }

        if(!p_155310_.brightThisTick){
            p_155310_.blessingProgress = 0;
        }else{
            p_155310_.blessingProgress++;
        }

    }
    
    public int getContainerSize() {
        return this.items.size();
    }

    public ItemStack getItem(int index) {
        return this.items.get(index);
    }

    public void setItem(int index, ItemStack stack) {
        this.items.set(index, stack);
        if (!stack.isEmpty() && stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }
        this.writeNbt(this.toInitialChunkDataNbt());
        if (world != null && !world.isClient) {
            new MessageUpdateblockentity(this.getPos().asLong(), items.get(0)).sendToClient(this);
        }
    }

    public int getMaxStackSize() {
        return 1;
    }
    

    public DefaultedList<ItemStack> getItems() {
        return this.items;
    }

    public void readNbt(NbtCompound p_155312_) {
        super.readNbt(p_155312_);

        this.items.clear();
        Inventories.readNbt(p_155312_, this.items);
        if (p_155312_.contains("blessingProgress", 11)) {
            this.blessingProgress = p_155312_.getInt("blessingProgress");
        }

    }

    protected void writeNbt(NbtCompound p_187486_) {
        super.writeNbt(p_187486_);
        Inventories.writeNbt(p_187486_, this.items, true);
        p_187486_.putInt("blessingProgress", this.blessingProgress);
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public NbtCompound toInitialChunkDataNbt() {
        NbtCompound compoundtag = new NbtCompound();
        Inventories.writeNbt(compoundtag, this.items, true);
        return compoundtag;
    }

    public Optional<AltarOfAmethystRecipe> getCookableRecipe(ItemStack p_59052_) {
        return this.items.stream().noneMatch(ItemStack::isEmpty) ? Optional.empty() : this.quickCheck.getFirstMatch(new SimpleInventory(p_59052_), this.world);
    }

    @Override
    public void clear() {
        this.items.clear();
    }
}
