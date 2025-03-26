package com.github.l_ender.cataclysm.blockentities;

import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.github.l_ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModItems;
import com.github.l_ender.cataclysm.init.ModTag;
import com.github.l_ender.cataclysm.init.ModTileentites;
import com.github.l_ender.cataclysm.message.MessageUpdateblockentity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class AltarOfAbyss_Block_Entity extends LockableContainerBlockEntity {

    public int tickCount;
    private static final int NUM_SLOTS = 1;
    private DefaultedList<ItemStack> stacks = DefaultedList.ofSize(NUM_SLOTS, ItemStack.EMPTY);
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
        if (!this.getStack(0).isEmpty()) {
            if(this.getStack(0).getItem() == ModItems.ABYSSAL_SACRIFICE){
                summoningthis = true;
                if(summoningticks == 1) {
                    if (this.world != null) {
                        ScreenShake_Entity.ScreenShake(this.world, Vec3d.ofCenter(this.getPos()), 20, 0.03f, 0, 150);
                    }
                    //   this.level.addFreshEntity(new Flame_Strike_Entity(this.level, this.getBlockPos().getX() + 0.5F, this.getBlockPos().getY(), this.getBlockPos().getZ() + 0.5F, 0, 0, 100, 0, 2.5F, false, null));
                }
                if(summoningticks > 118 && summoningticks < 121) {
                    Sphereparticle(3,3);
                }
                if(summoningticks > 121) {
                    this.setStack(0, ItemStack.EMPTY);
                    BlockBreaking(3, 6, 3);
                    The_Leviathan_Entity leviathan = ModEntities.THE_LEVIATHAN.create(world);
                    if (leviathan != null) {
                        leviathan.setPosition(this.getPos().getX() + 0.5F, this.getPos().getY() + 3, this.getPos().getZ() + 0.5F);
                        leviathan.setHomePos(this.getPos());
                        if (world != null && !world.isClient) {
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
                    BlockState block = null;
                    if (this.world != null) {
                        block = this.world.getBlockState(blockpos);
                    }
                    if (block != null && block != Blocks.AIR.getDefaultState() && !block.isIn(ModTag.ALTAR_DESTROY_IMMUNE)) {
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

                    if (this.world != null) {
                        this.world.addParticle(ParticleTypes.REVERSE_PORTAL, d0, d1, d2, d3 / d6, d4 / d6, d5 / d6);
                    }

                    if (i != -size && i != size && j != -size && j != size) {
                        k += size * 2 - 1;

                    }
                }
            }
        }
    }

    @Override
    public int size() {
        return this.stacks.size();
    }

    @Override
    public ItemStack getStack(int index) {
        return this.stacks.get(index);
    }

    @Override
    public ItemStack removeStack(int index, int count) {
        if (!this.stacks.get(index).isEmpty()) {
            ItemStack itemstack;

            if (this.stacks.get(index).getCount() <= count) {
                itemstack = this.stacks.get(index);
                this.stacks.set(index, ItemStack.EMPTY);
            } else {
                itemstack = this.stacks.get(index).split(count);

                if (this.stacks.get(index).isEmpty()) {
                    this.stacks.set(index, ItemStack.EMPTY);
                }

            }
            return itemstack;
        } else {
            return ItemStack.EMPTY;
        }
    }

    @Override
    public void setStack(int index, ItemStack stack) {
        boolean flag = !stack.isEmpty() && ItemStack.canCombine(stack, this.stacks.get(index));
        this.stacks.set(index, stack);
        if (!stack.isEmpty() && stack.getCount() > this.getMaxCountPerStack()) {
            stack.setCount(this.getMaxCountPerStack());
        }
        this.writeNbt(this.toInitialChunkDataNbt());
        if (world != null && !world.isClient) {
            new MessageUpdateblockentity(this.getPos().asLong(), stacks.get(0)).sendToClient(this);
        }
    }

    @Override
    public void readNbt(NbtCompound compound) {
        super.readNbt(compound);
        this.stacks = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        this.summoningthis = compound.getBoolean("Summoningthis");
        Inventories.readNbt(compound, this.stacks);
    }

    @Override
    public void writeNbt(NbtCompound compound) {
        super.writeNbt(compound);
        Inventories.writeNbt(compound, this.stacks);
        compound.putBoolean("Summoningthis", this.summoningthis);
    }

    @Override
    public void onOpen(PlayerEntity player) {
    }

    @Override
    public void onClose(PlayerEntity player) {
    }



    @Override
    public int getMaxCountPerStack() {
        return 1;
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void clear() {
        this.stacks.clear();
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public boolean isValid(int index, ItemStack stack) {
        return true;
    }

    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

//    @Override
//    public void onDataPacket(ClientConnection net, BlockEntityUpdateS2CPacket packet) {
//        if (packet != null && packet.getNbt() != null) {
//            this.stacks = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
//            Inventories.readNbt(packet.getNbt(), this.stacks);
//        }
//    }

    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }

    @Override
    public ItemStack removeStack(int index) {
        ItemStack lvt_2_1_ = this.stacks.get(index);
        if (lvt_2_1_.isEmpty()) {
            return ItemStack.EMPTY;
        } else {
            this.stacks.set(index, ItemStack.EMPTY);
            return lvt_2_1_;
        }
    }

    @Override
    public Text getDisplayName() {
        return getContainerName();
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("block.cataclysm.altar_of_abyss");
    }

    @Override
    protected ScreenHandler createScreenHandler(int id, PlayerInventory player) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < this.size(); i++) {
            if (!this.getStack(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
