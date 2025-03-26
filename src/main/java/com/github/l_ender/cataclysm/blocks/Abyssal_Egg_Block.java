package com.github.l_ender.cataclysm.blocks;

import com.github.l_ender.cataclysm.blockentities.Abyssal_Egg_Block_Entity;
import com.github.l_ender.cataclysm.entity.Pet.The_Baby_Leviathan_Entity;
import com.github.l_ender.cataclysm.init.ModEntities;
import com.github.l_ender.cataclysm.init.ModTileentites;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.MapColor;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class Abyssal_Egg_Block extends BlockWithEntity implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final int MAX_HATCH_LEVEL = 2;
    public static final IntProperty HATCH = Properties.HATCH;
    private static final int REGULAR_HATCH_TIME_TICKS = 12000;
    private static final int RANDOM_HATCH_OFFSET_TICKS = 300;
    private static final VoxelShape SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    public Abyssal_Egg_Block() {
        super(Settings.create()
                .nonOpaque()
                .luminance((block) -> 1)
                .pistonBehavior(PistonBehavior.DESTROY)
                .mapColor(MapColor.BLACK)
                .emissiveLighting((block, world, pos) -> true)
                .strength(3.0F, 9.0F)
                .sounds(BlockSoundGroup.METAL));
        this.setDefaultState(this.stateManager.getDefaultState().with(HATCH, 0).with(WATERLOGGED, Boolean.FALSE));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> p_277441_) {
        p_277441_.add(HATCH,WATERLOGGED);
    }

    public VoxelShape getOutlineShape(BlockState p_277872_, BlockView p_278090_, BlockPos p_277364_, ShapeContext p_278016_) {
        return SHAPE;
    }

    public FluidState getFluidState(BlockState p_51581_) {
        return p_51581_.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(p_51581_);
    }

    public BlockState getPlacementState(ItemPlacementContext p_48781_) {
        FluidState fluidstate = p_48781_.getWorld().getFluidState(p_48781_.getBlockPos());
        return this.getDefaultState().with(WATERLOGGED, fluidstate.getFluid() == Fluids.WATER);
    }

    public BlockState getStateForNeighborUpdate(BlockState p_51555_, Direction p_51556_, BlockState p_51557_, WorldAccess p_51558_, BlockPos p_51559_, BlockPos p_51560_) {
        if (p_51555_.get(WATERLOGGED)) {
            p_51558_.scheduleFluidTick(p_51559_, Fluids.WATER, Fluids.WATER.getTickRate(p_51558_));
        }
        return super.getStateForNeighborUpdate(p_51555_, p_51556_, p_51557_, p_51558_, p_51559_, p_51560_);
    }

    public int getHatchLevel(BlockState p_279125_) {
        return p_279125_.get(HATCH);
    }

    private boolean isReadyToHatch(BlockState p_278021_) {
        return this.getHatchLevel(p_278021_) == 2;
    }

    public void scheduledTick(BlockState p_277841_, ServerWorld p_277739_, BlockPos p_277692_, Random p_277973_) {
        if (!this.isReadyToHatch(p_277841_)) {
            p_277739_.playSound(null, p_277692_, SoundEvents.ENTITY_TURTLE_EGG_CRACK, SoundCategory.BLOCKS, 0.7F, 0.9F + p_277973_.nextFloat() * 0.2F);
            p_277739_.setBlockState(p_277692_, p_277841_.with(HATCH, this.getHatchLevel(p_277841_) + 1), 2);
        } else {
            p_277739_.playSound(null, p_277692_, SoundEvents.ENTITY_TURTLE_EGG_HATCH, SoundCategory.BLOCKS, 0.7F, 0.9F + p_277973_.nextFloat() * 0.2F);
            p_277739_.breakBlock(p_277692_, false);
            The_Baby_Leviathan_Entity levia = ModEntities.THE_BABY_LEVIATHAN.create(p_277739_);
            if (levia != null) {
                levia.refreshPositionAndAngles((double)p_277692_.getX() + 0.5D, (double)p_277692_.getY() + 0.5D, (double)p_277692_.getZ() + 0.5D, MathHelper.wrapDegrees(p_277739_.random.nextFloat() * 360.0F), 0.0F);
                p_277739_.spawnEntity(levia);
            }

        }
    }

    public void onBlockAdded(BlockState p_277964_, World p_277827_, BlockPos p_277526_, BlockState p_277618_, boolean p_277819_) {
        int j = REGULAR_HATCH_TIME_TICKS / 3;
        p_277827_.emitGameEvent(GameEvent.BLOCK_PLACE, p_277526_, GameEvent.Emitter.of(p_277964_));
        p_277827_.scheduleBlockTick(p_277526_, this, j + p_277827_.random.nextInt(RANDOM_HATCH_OFFSET_TICKS));
    }

    public boolean canPathfindThrough(BlockState p_279414_, BlockView p_279243_, BlockPos p_279294_, NavigationType p_279299_) {
        return false;
    }


    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new Abyssal_Egg_Block_Entity(pos, state);
    }


    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return checkType(p_152182_, ModTileentites.ABYSSAL_EGG, Abyssal_Egg_Block_Entity::commonTick);
    }
}