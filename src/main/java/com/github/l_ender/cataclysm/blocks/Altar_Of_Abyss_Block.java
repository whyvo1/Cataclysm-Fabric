package com.github.l_ender.cataclysm.blocks;


import com.github.l_ender.cataclysm.blockentities.AltarOfAbyss_Block_Entity;
import com.github.l_ender.cataclysm.init.ModTileentites;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class Altar_Of_Abyss_Block extends BlockWithEntity implements Waterloggable {

    public static final MapCodec<Altar_Of_Abyss_Block> CODEC = createCodec(Altar_Of_Abyss_Block::new);

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final VoxelShape BASE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D);
    private static final VoxelShape MID = Block.createCuboidShape(2.0D, 3.0D, 2.0D, 14.0D, 8.0D, 14.0D);
    private static final VoxelShape TOP = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 11.0D, 16.0D);
    private static final VoxelShape AXIS_AABB = VoxelShapes.union(BASE,MID, TOP);

    @Override
    public MapCodec<Altar_Of_Abyss_Block> getCodec() {
        return CODEC;
    }

    public Altar_Of_Abyss_Block(AbstractBlock.Settings p_54257_) {
        super(p_54257_);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(WATERLOGGED, Boolean.FALSE));
    }

    public ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockHitResult hit) {
        ItemStack heldItem = player.getStackInHand(handIn);
        if (worldIn.getBlockEntity(pos) instanceof AltarOfAbyss_Block_Entity && (!player.isSneaking() && heldItem.getItem() != this.asItem())) {
            AltarOfAbyss_Block_Entity aof = (AltarOfAbyss_Block_Entity)worldIn.getBlockEntity(pos);
            ItemStack copy = heldItem.copy();
            copy.setCount(1);
            if(aof.getItem(0).isEmpty()){
                aof.placeItem(player,0, copy);
                if(!player.isCreative()){
                    heldItem.decrement(1);
                }
            }else{
                dropStack(worldIn, pos, aof.getItem(0).copy());
                aof.placeItem(player,0, ItemStack.EMPTY);
            }
            return ItemActionResult.SUCCESS;
        }

        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public BlockState getPlacementState(ItemPlacementContext p_48781_) {
        FluidState fluidstate = p_48781_.getWorld().getFluidState(p_48781_.getBlockPos());
        return this.getDefaultState().with(FACING, p_48781_.getHorizontalPlayerFacing().rotateYClockwise()).with(WATERLOGGED, fluidstate.getFluid() == Fluids.WATER);
    }

    public FluidState getFluidState(BlockState p_51581_) {
        return p_51581_.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(p_51581_);
    }

    public BlockState rotate(BlockState p_48811_, BlockRotation p_48812_) {
        return p_48811_.with(FACING, p_48812_.rotate(p_48811_.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> p_48814_) {
        p_48814_.add(FACING,WATERLOGGED);
    }

    public VoxelShape getOutlineShape(BlockState p_48816_, BlockView p_48817_, BlockPos p_48818_, ShapeContext p_48819_) {
        return AXIS_AABB;
    }

    public BlockState getStateForNeighborUpdate(BlockState p_51555_, Direction p_51556_, BlockState p_51557_, WorldAccess p_51558_, BlockPos p_51559_, BlockPos p_51560_) {
        if (p_51555_.get(WATERLOGGED)) {
            p_51558_.scheduleFluidTick(p_51559_, Fluids.WATER, Fluids.WATER.getTickRate(p_51558_));
        }
        return super.getStateForNeighborUpdate(p_51555_, p_51556_, p_51557_, p_51558_, p_51559_, p_51560_);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AltarOfAbyss_Block_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return validateTicker(p_152182_, ModTileentites.ALTAR_OF_ABYSS, AltarOfAbyss_Block_Entity::commonTick);
    }

}