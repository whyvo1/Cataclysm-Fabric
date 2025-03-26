package com.github.l_ender.cataclysm.blocks;


import com.github.l_ender.cataclysm.blockentities.Cursed_tombstone_Entity;
import com.github.l_ender.cataclysm.init.ModTileentites;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.BlockMirror;
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
import org.jetbrains.annotations.Nullable;

public class Cursed_Tombstone_Block extends BlockWithEntity {
    public static final MapCodec<Cursed_Tombstone_Block> CODEC = createCodec(Cursed_Tombstone_Block::new);
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty LIT = Properties.LIT;
    public static final BooleanProperty POWERED = Properties.POWERED;
    private static final VoxelShape X_BASE = Block.createCuboidShape(5.0D, 0.0D, 0.0D, 11.0D, 2.0D, 16.0D);
    private static final VoxelShape Z_BASE = Block.createCuboidShape(0.0D, 0.0D, 5.0D, 16.0D, 2.0D, 11.0D);

    private static final VoxelShape X_MID = Block.createCuboidShape(6.0D, 2.0D, 1.0D, 10.0D, 24.0D, 15.0D);
    private static final VoxelShape Z_MID = Block.createCuboidShape(1.0D, 2.0D, 6.0D, 15.0D, 24.0D, 10.0D);

    private static final VoxelShape X_AXIS_AABB = VoxelShapes.union(X_BASE, X_MID);
    private static final VoxelShape Z_AXIS_AABB = VoxelShapes.union(Z_BASE, Z_MID);

    @Override
    public MapCodec<Cursed_Tombstone_Block> getCodec() {
        return CODEC;
    }

    public Cursed_Tombstone_Block(AbstractBlock.Settings p_54257_) {
        super(p_54257_);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(LIT, Boolean.FALSE).with(POWERED, Boolean.FALSE));
    }


    public BlockState getPlacementState(ItemPlacementContext p_48689_) {
        return this.getDefaultState().with(FACING, p_48689_.getHorizontalPlayerFacing().getOpposite());
    }


    public BlockState rotate(BlockState state, BlockRotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.get(FACING)));
    }

    @Override
    protected ItemActionResult onUseWithItem(
            ItemStack p_316383_, BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand p_316216_, BlockHitResult p_316827_) {
        if (state.get(POWERED)) {
            if (!state.get(LIT)) {
                state = state.with(LIT, Boolean.TRUE);
                worldIn.setBlockState(pos, state, 10);
                return ItemActionResult.SUCCESS;
            }
        }else{
            player.sendMessage(Text.translatable("block.cataclysm.cursed_tombstone.message"), true);
            return ItemActionResult.FAIL;
        }
        return ItemActionResult.FAIL;
    }


    protected void appendProperties(StateManager.Builder<Block, BlockState> p_48814_) {
        p_48814_.add(FACING,LIT,POWERED);
    }

    public VoxelShape getOutlineShape(BlockState p_48816_, BlockView p_48817_, BlockPos p_48818_, ShapeContext p_48819_) {
        Direction direction = p_48816_.get(FACING);
        return direction.getAxis() == Direction.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new Cursed_tombstone_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return validateTicker(p_152182_, ModTileentites.CURSED_TOMBSTONE, Cursed_tombstone_Entity::commonTick);
    }

}