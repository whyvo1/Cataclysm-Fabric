package com.github.l_ender.cataclysm.blockentities;

import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.init.ModTileentites;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Clearable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class AltarOfAbyss_Block_Entity extends BlockEntity implements Clearable {

    public int tickCount;
    private static final int NUM_SLOTS = 1;
    private DefaultedList<ItemStack> items = DefaultedList.ofSize(NUM_SLOTS, ItemStack.EMPTY);
    public boolean summoningthis = false;
    public int summoningticks = 0;
    private float chompProgress;
    private float prevChompProgress;
    private final Random rnd = Random.create();

    public AltarOfAbyss_Block_Entity(BlockPos pos, BlockState state) {
        super(ModTileentites.ALTAR_OF_ABYSS, pos, state);
    }

    public static void commonTick(World level, BlockPos pos, BlockState state, AltarOfAbyss_Block_Entity entity) {
        entity.tick();

    }

    public void tick() {
        tickCount++;
        summoningthis = false;
        prevChompProgress = chompProgress;
        if (!this.getItem(0).isEmpty()) {
            if(this.getItem(0).isOf(ModItems.ABYSSAL_SACRIFICE)){
                summoningthis = true;
                if(summoningticks == 1) {
                    ScreenShake_Entity.ScreenShake(this.world, Vec3d.ofCenter(this.getPos()), 20, 0.03f, 0, 150);
                    //   this.level.addFreshEntity(new Flame_Strike_Entity(this.level, this.getBlockPos().getX() + 0.5F, this.getBlockPos().getY(), this.getBlockPos().getZ() + 0.5F, 0, 0, 100, 0, 2.5F, false, null));
                }
                if(summoningticks > 118 && summoningticks < 121) {
                    Sphereparticle(3,3);
                }
                if(summoningticks > 121) {
                    this.items.set(0, ItemStack.EMPTY);
                    BlockBreaking(3, 6, 3);
                    The_Leviathan_Entity leviathan = ModEntities.THE_LEVIATHAN.create(world);
                    if (leviathan != null) {
                        leviathan.setPosition(this.getPos().getX() + 0.5F, this.getPos().getY() + 3, this.getPos().getZ() + 0.5F);
                        leviathan.setHomePos(this.getPos());
                        if (!world.isClient) {
                            world.spawnEntity(leviathan);
                        }
                    }
                }

            }
        }

        if(summoningthis && chompProgress < 30F){
            chompProgress++;
        }
        if(!summoningthis && chompProgress > 0F){
            chompProgress--;
        }

        if(!summoningthis){
            summoningticks = 0;
        }else{
            summoningticks++;
        }
    }

    public float getChompProgress(float partialTick){
        return prevChompProgress + (chompProgress - prevChompProgress) * partialTick;
    }

    private void BlockBreaking(int x, int y, int z) {
        //this.level.destroyBlock(this.getBlockPos(), false);
        int MthX = MathHelper.floor(this.getPos().getX());
        int MthY = MathHelper.floor(this.getPos().getY());
        int MthZ = MathHelper.floor(this.getPos().getZ());
        for (int k2 = -x; k2 <= x; ++k2) {
            for (int l2 = -z; l2 <= z; ++l2) {
                for (int j = 0; j <= y; ++j) {
                    int i3 = MthX + k2;
                    int k = MthY + j;
                    int l = MthZ + l2;
                    BlockPos blockpos = new BlockPos(i3, k, l);
                    BlockState block = this.world.getBlockState(blockpos);
                    if (block != Blocks.AIR.getDefaultState() && !block.isIn(ModTag.ALTAR_DESTROY_IMMUNE)) {
                        this.world.breakBlock(blockpos, false);
                    }

                }
            }
        }
    }


    private void Sphereparticle(float height, float size) {
        double d0 = this.getPos().getX() + 0.5F;
        double d1 = this.getPos().getY() + height;
        double d2 = this.getPos().getZ() + 0.5F;
        for (float i = -size; i <= size; ++i) {
            for (float j = -size; j <= size; ++j) {
                for (float k = -size; k <= size; ++k) {
                    double d3 = (double) j + (this.rnd.nextDouble() - this.rnd.nextDouble()) * 0.5D;
                    double d4 = (double) i + (this.rnd.nextDouble() - this.rnd.nextDouble()) * 0.5D;
                    double d5 = (double) k + (this.rnd.nextDouble() - this.rnd.nextDouble()) * 0.5D;
                    double d6 = (double) MathHelper.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + this.rnd.nextGaussian() * 0.05D;

                    this.world.addParticle(ParticleTypes.REVERSE_PORTAL, d0, d1, d2, d3 / d6, d4 / d6, d5 / d6);

                    if (i != -size && i != size && j != -size && j != size) {
                        k += size * 2 - 1;

                    }
                }
            }
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

    public void setItem(int index, ItemStack stack) {
        this.getItems().set(index, stack);
        if (!stack.isEmpty() && stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }
    }

    public void placeItem(@Nullable LivingEntity entity, int index, ItemStack stack) {
        this.getItems().set(index, stack);
        if (!stack.isEmpty() && stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }

        this.world.emitGameEvent(GameEvent.BLOCK_CHANGE, this.getPos(), GameEvent.Emitter.of(entity, this.getCachedState()));
        this.markUpdated();
    }


    public int getMaxStackSize() {
        return 1;
    }

    public void readNbt(NbtCompound p_155312_, RegistryWrapper.WrapperLookup p_324612_) {
        super.readNbt(p_155312_,p_324612_);
        this.items.clear();
        Inventories.readNbt(p_155312_, this.items, p_324612_);

    }

    protected void writeNbt(NbtCompound p_187486_, RegistryWrapper.WrapperLookup p_324612_) {
        super.writeNbt(p_187486_,p_324612_);
        Inventories.writeNbt(p_187486_, this.items, true, p_324612_);
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }



    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup p_324612_) {
        NbtCompound compoundtag = new NbtCompound();
        Inventories.writeNbt(compoundtag, this.items, true, p_324612_);
        return compoundtag;
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
    protected void readComponents(ComponentsAccess p_338534_) {
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
