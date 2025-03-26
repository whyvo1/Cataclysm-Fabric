package com.github.l_ender.cataclysm.blocks;

import com.github.l_ender.cataclysm.blockentities.Door_Of_Seal_BlockEntity;
import com.github.l_ender.cataclysm.init.ModBlocks;
import com.github.l_ender.cataclysm.init.ModTileentites;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class Door_of_Seal_Block extends BlockWithEntity {
    public static final MapCodec<Door_of_Seal_Block> CODEC = createCodec(Door_of_Seal_Block::new);
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty OPEN = Properties.OPEN;
    public static final BooleanProperty LIT = Properties.LIT;

    private static final VoxelShape CLOSED_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    @Override
    public MapCodec<Door_of_Seal_Block> getCodec() {
        return CODEC;
    }

    public Door_of_Seal_Block(AbstractBlock.Settings p_54257_) {
        super(p_54257_);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(LIT, Boolean.FALSE).with(OPEN, Boolean.FALSE));
    }


    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> p_49751_) {
        p_49751_.add(FACING,OPEN,LIT);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new Door_Of_Seal_BlockEntity(pos, state);
    }


    @Override
    protected ItemActionResult onUseWithItem(ItemStack p_316383_, BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand p_316216_, BlockHitResult p_316827_) {
        return this.onHit(worldIn,state, p_316827_, player, true)  ? ItemActionResult.success(worldIn.isClient) : ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

    }

    public boolean onHit(World p_49702_,BlockState blockState, BlockHitResult p_49704_, @Nullable PlayerEntity p_49705_, boolean p_49706_) {
        BlockPos blockpos = p_49704_.getBlockPos();
        if (p_49706_) {
            this.attemptToRing(p_49705_, p_49702_,blockState, blockpos);
            return true;
        } else {
            return false;
        }
    }
    


    public boolean attemptToRing(@Nullable Entity p_152189_, World p_152190_,BlockState blockState, BlockPos p_152191_) {
        BlockEntity blockentity = p_152190_.getBlockEntity(p_152191_);
        if (!p_152190_.isClient && blockentity instanceof Door_Of_Seal_BlockEntity && !blockState.get(LIT)) {
            ((Door_Of_Seal_BlockEntity)blockentity).onHit(p_152190_);
            p_152190_.setBlockState(p_152191_, blockState.with(LIT, Boolean.TRUE), 3);
          //  p_152190_.playSound((Player)null, p_152191_, ModSounds.MALEDICTUS_SHORT_ROAR.get(), SoundSource.BLOCKS, 2.0F, 1.0F);
            p_152190_.emitGameEvent(p_152189_, GameEvent.BLOCK_CHANGE, p_152191_);
            return true;
        } else {
            return false;
        }
    }



    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World p_152194_, BlockState p_152195_, BlockEntityType<T> p_152196_) {
        return validateTicker(p_152196_, ModTileentites.DOOR_OF_SEAL, Door_Of_Seal_BlockEntity::tick);
    }


    public VoxelShape getOutlineShape(BlockState p_49755_, BlockView p_49756_, BlockPos p_49757_, ShapeContext p_49758_) {
        return CLOSED_SHAPE;
    }

    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    public VoxelShape getCameraCollisionShape(BlockState p_48735_, BlockView p_48736_, BlockPos p_48737_, ShapeContext p_48738_) {
        return VoxelShapes.empty();
    }


    public VoxelShape getSidesShape(BlockState p_253862_, BlockView p_254569_, BlockPos p_254197_) {
        if (p_253862_.get(OPEN)) {
            return VoxelShapes.empty();
        } else {
            return CLOSED_SHAPE;
        }
    }

    public VoxelShape getCollisionShape(BlockState p_53396_, BlockView p_53397_, BlockPos p_53398_, ShapeContext p_53399_) {
        if (p_53396_.get(OPEN)) {
            return VoxelShapes.empty();
        } else {
            return CLOSED_SHAPE;
        }
    }

    public VoxelShape getCullingShape(BlockState p_53401_, BlockView p_53402_, BlockPos p_53403_) {
        return VoxelShapes.empty();
    }


    protected boolean canPathfindThrough(BlockState p_51023_, NavigationType p_51026_) {
        return false;
    }

    private boolean doesGongFitInDirection(BlockPos pos, Direction direction, World level) {
        for (int i = 0; i <= 7; i++) {
            BlockPos abovePos = pos.up(i);
            BlockPos blockpos1 = abovePos.offset(direction.rotateYClockwise());
            BlockPos blockpos2 = abovePos;
            BlockPos blockpos3 = abovePos.offset(direction.rotateYCounterclockwise());
            BlockPos blockpos4 = abovePos.offset(direction.rotateYClockwise(),2);
            BlockPos blockpos5 = abovePos.offset(direction.rotateYCounterclockwise(),2);
            BlockPos[] toBreakPoses = {blockpos1, blockpos2, blockpos3,blockpos4,blockpos5};
            for (BlockPos toBreakPos : toBreakPoses) {
                BlockState blockstate = level.getBlockState(toBreakPos);
                if (!blockstate.isReplaceable()) return false;
            }
        }
        return true;
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction direction = context.getSide();
        BlockPos blockpos = context.getBlockPos();
        Direction.Axis direction$axis = direction.getAxis();
        if (direction$axis == Direction.Axis.Y) {
            Direction dir = context.getHorizontalPlayerFacing();
            BlockState blockstate = this.getDefaultState().with(FACING, dir);
            if (blockstate.canPlaceAt(context.getWorld(), blockpos) && doesGongFitInDirection(blockpos, dir, context.getWorld())) {
                return blockstate;
            }
        } else {
            Direction dir = direction.getOpposite();
            BlockState blockstate1 = this.getDefaultState().with(FACING, dir);
            if (blockstate1.canPlaceAt(context.getWorld(), context.getBlockPos()) && doesGongFitInDirection(context.getBlockPos(), dir, context.getWorld())) {
                return blockstate1;
            }
        }

        return null;
    }

    public void onPlaced(World level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack itemStack) {
        super.onPlaced(level, pos, state, entity, itemStack);
        if (!level.isClient) {
            for (int i = 0; i < 8; i++) {
                BlockPos abovePos = pos.up(i);

                BlockPos blockpos1 = abovePos.offset(state.get(FACING).rotateYClockwise());
                BlockPos blockpos2 = abovePos;
                BlockPos blockpos3 = abovePos.offset(state.get(FACING).rotateYCounterclockwise());
                BlockPos blockpos4 = abovePos.offset(state.get(FACING).rotateYClockwise(),2);
                BlockPos blockpos5 = abovePos.offset(state.get(FACING).rotateYCounterclockwise(),2);


                BlockState defaultGongPart = ModBlocks.DOOR_OF_SEAL_PART.getDefaultState();
                level.setBlockState(blockpos1, defaultGongPart.with(FACING, state.get(FACING)).with(Door_Of_Seal_Part_Block.PART, Door_Of_Seal_Part.SIDE_LEFT).with(Door_Of_Seal_Part_Block.Y_OFFSET, i), 3);
                level.setBlockState(blockpos3, defaultGongPart.with(FACING, state.get(FACING)).with(Door_Of_Seal_Part_Block.PART, Door_Of_Seal_Part.SIDE_RIGHT).with(Door_Of_Seal_Part_Block.Y_OFFSET, i), 3);
                level.setBlockState(blockpos4, defaultGongPart.with(FACING, state.get(FACING)).with(Door_Of_Seal_Part_Block.PART, Door_Of_Seal_Part.END_LEFT).with(Door_Of_Seal_Part_Block.Y_OFFSET, i), 3);
                level.setBlockState(blockpos5, defaultGongPart.with(FACING, state.get(FACING)).with(Door_Of_Seal_Part_Block.PART, Door_Of_Seal_Part.END_RIGHT).with(Door_Of_Seal_Part_Block.Y_OFFSET, i), 3);
                if (blockpos2 != pos) {
                    level.setBlockState(blockpos2, defaultGongPart.with(FACING, state.get(FACING)).with(Door_Of_Seal_Part_Block.PART, Door_Of_Seal_Part.CENTER).with(Door_Of_Seal_Part_Block.Y_OFFSET, i), 3);
                }
                level.updateNeighbors(abovePos, Blocks.AIR);
                state.updateNeighbors(level, abovePos, 3);
            }
        }

    }
    @Override
    public BlockState onBreak(World level, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!level.isClient && player.isCreative()) {
            for (int i = 0; i <= 7; i++) {
                BlockPos abovePos = pos.up(i);
                BlockPos blockpos1 = abovePos.offset(state.get(FACING).rotateYClockwise());
                BlockPos blockpos2 = abovePos;
                BlockPos blockpos3 = abovePos.offset(state.get(FACING).rotateYCounterclockwise());
                BlockPos blockpos4 = abovePos.offset(state.get(FACING).rotateYClockwise(),2);
                BlockPos blockpos5 = abovePos.offset(state.get(FACING).rotateYCounterclockwise(),2);
                BlockPos[] toBreakPoses = {blockpos1, blockpos2, blockpos3,blockpos4,blockpos5};
                for (BlockPos toBreakPos : toBreakPoses) {
                    BlockState blockstate = level.getBlockState(toBreakPos);
                    if (blockstate.isOf(ModBlocks.DOOR_OF_SEAL_PART)) {
                        level.setBlockState(toBreakPos, Blocks.AIR.getDefaultState(), 35);
                        level.syncWorldEvent(player, 2001, toBreakPos, Block.getRawIdFromState(blockstate));
                    }
                }
            }
        }

        return super.onBreak(level, pos, state, player);
    }

    public enum Door_Of_Seal_Part implements StringIdentifiable {
        SIDE_LEFT("side_left"),
        SIDE_RIGHT("side_right"),
        END_LEFT("end_left"),
        END_RIGHT("end_right"),
        CENTER("center");

        private final String name;

        Door_Of_Seal_Part(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }

        public String asString() {
            return this.name;
        }
    }

    public static class Door_Of_Seal_Part_Block extends HorizontalFacingBlock {

        public static final MapCodec<Door_Of_Seal_Part_Block> CODEC = createCodec(Door_Of_Seal_Part_Block::new);

        public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
        public static final BooleanProperty OPEN = Properties.OPEN;
        public static final EnumProperty<Door_Of_Seal_Part> PART = EnumProperty.of("door_part", Door_Of_Seal_Part.class);
        public static final IntProperty Y_OFFSET = IntProperty.of("y_offset", 0, 7);

        @Override
        public MapCodec<Door_Of_Seal_Part_Block> getCodec() {
            return CODEC;
        }

        public Door_Of_Seal_Part_Block(AbstractBlock.Settings p_54257_) {
            super(p_54257_);
            this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(OPEN, Boolean.FALSE).with(PART, Door_Of_Seal_Part.CENTER).with(Y_OFFSET, 0));
        }

        protected void appendProperties(StateManager.Builder<Block, BlockState> p_49751_) {
            p_49751_.add(FACING,OPEN, PART, Y_OFFSET);
        }


        @Override
        protected ItemActionResult onUseWithItem(ItemStack p_316383_, BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand p_316216_, BlockHitResult p_316827_) {
            BlockPos basePos = getBasePos(state, pos);
            BlockState baseState = worldIn.getBlockState(basePos);
            if (baseState.isOf(ModBlocks.DOOR_OF_SEAL)) {
                BlockHitResult baseHitResult = new BlockHitResult(p_316827_.getPos().add(basePos.getX() - pos.getX(), basePos.getY() - pos.getY(), basePos.getZ() - pos.getZ()), p_316827_.getSide(), basePos, p_316827_.isInsideBlock());
                return baseState.onUseWithItem(p_316383_, worldIn, player, p_316216_, baseHitResult);
            }
            return super.onUseWithItem(p_316383_,state, worldIn, pos, player, p_316216_, p_316827_);
        }


        private BlockPos getBasePos(BlockState state, BlockPos pos) {
            BlockPos toReturn = pos.down(state.get(Y_OFFSET));
            if (state.get(PART) == Door_Of_Seal_Part.SIDE_LEFT) {
                toReturn = toReturn.offset(state.get(FACING).rotateYCounterclockwise());
            }
            else if (state.get(PART) == Door_Of_Seal_Part.SIDE_RIGHT) {
                toReturn = toReturn.offset(state.get(FACING).rotateYClockwise());
            }
            if (state.get(PART) == Door_Of_Seal_Part.END_LEFT) {
                toReturn = toReturn.offset(state.get(FACING).rotateYCounterclockwise(),2);
            }
            else if (state.get(PART) == Door_Of_Seal_Part.END_RIGHT) {
                toReturn = toReturn.offset(state.get(FACING).rotateYClockwise(),2);
            }
            return toReturn;
        }

        @Override
        public BlockState onBreak(World level, BlockPos pos, BlockState state, PlayerEntity player) {
            BlockPos basePos = getBasePos(state, pos);
            BlockState baseState = level.getBlockState(basePos);
            if (baseState.isOf(ModBlocks.DOOR_OF_SEAL)) {
                level.setBlockState(basePos, Blocks.AIR.getDefaultState(), 35);
                level.syncWorldEvent(player, 2001, basePos, Block.getRawIdFromState(state));
            }

            return super.onBreak(level, pos, state, player);
        }

        public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState state1, WorldAccess level, BlockPos pos, BlockPos pos1) {
            BlockPos basePos = getBasePos(state, pos);
            BlockState baseState = level.getBlockState(basePos);
            if (!baseState.isOf(ModBlocks.DOOR_OF_SEAL)) {
                return Blocks.AIR.getDefaultState();
            }
            return super.getStateForNeighborUpdate(state, direction, state1, level, pos, pos1);
        }


        protected boolean canPathfindThrough(BlockState p_51023_, NavigationType p_51026_) {
            return false;
        }


        public VoxelShape getOutlineShape(BlockState p_49755_, BlockView p_49756_, BlockPos p_49757_, ShapeContext p_49758_) {
            return CLOSED_SHAPE;
        }

        public BlockRenderType getRenderType(BlockState blockState) {
            return BlockRenderType.MODEL;
        }


        public VoxelShape getSidesShape(BlockState p_253862_, BlockView p_254569_, BlockPos p_254197_) {
            if (p_253862_.get(OPEN)) {
                return VoxelShapes.empty();
            } else {
                return CLOSED_SHAPE;
            }
        }

        public VoxelShape getCollisionShape(BlockState p_53396_, BlockView p_53397_, BlockPos p_53398_, ShapeContext p_53399_) {
            if (p_53396_.get(OPEN)) {
                return VoxelShapes.empty();
            } else {
                return CLOSED_SHAPE;
            }
        }

        public VoxelShape getCullingShape(BlockState p_53401_, BlockView p_53402_, BlockPos p_53403_) {
            return VoxelShapes.empty();
        }

        @Override
        public Item asItem() {
            return ModBlocks.DOOR_OF_SEAL.asItem();
        }
    }
}
