package com.github.l_ender.cataclysm.blocks;



import com.github.l_ender.cataclysm.init.ModTileentites;
import com.github.l_ender.cataclysm.inventory.WeaponfusionMenu;
import com.github.l_ender.cataclysm.blockentities.Mechanical_fusion_Anvil_Block_Entity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Mechanical_fusion_Anvil extends BlockWithEntity {
    private static final Text CONTAINER_TITLE = Text.translatable("cataclysm.container.weapon_fusion");
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final VoxelShape BASE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D);
    private static final VoxelShape X_LEG1 = Block.createCuboidShape(3.0D, 4.0D, 4.0D, 13.0D, 5.0D, 12.0D);
    private static final VoxelShape X_LEG2 = Block.createCuboidShape(4.0D, 5.0D, 6.0D, 12.0D, 10.0D, 10.0D);
    private static final VoxelShape X_TOP = Block.createCuboidShape(0.0D, 10.0D, 3.0D, 16.0D, 16.0D, 13.0D);
    private static final VoxelShape Z_LEG1 = Block.createCuboidShape(4.0D, 4.0D, 3.0D, 12.0D, 5.0D, 13.0D);
    private static final VoxelShape Z_LEG2 = Block.createCuboidShape(6.0D, 5.0D, 4.0D, 10.0D, 10.0D, 12.0D);
    private static final VoxelShape Z_TOP = Block.createCuboidShape(3.0D, 10.0D, 0.0D, 13.0D, 16.0D, 16.0D);
    private static final VoxelShape X_AXIS_AABB = VoxelShapes.union(BASE, X_LEG1, X_LEG2, X_TOP);
    private static final VoxelShape Z_AXIS_AABB = VoxelShapes.union(BASE, Z_LEG1, Z_LEG2, Z_TOP);

    public Mechanical_fusion_Anvil() {
        super(Settings.create().mapColor(MapColor.IRON_GRAY)
                .strength(50.0F, 1200.0F)
                .requiresTool()
                .sounds(BlockSoundGroup.ANVIL));
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    public BlockState getPlacementState(ItemPlacementContext p_48781_) {
        return this.getDefaultState().with(FACING, p_48781_.getHorizontalPlayerFacing().rotateYClockwise());
    }

    public ActionResult onUse(BlockState p_56428_, World p_56429_, BlockPos p_56430_, PlayerEntity p_56431_, Hand p_56432_, BlockHitResult p_56433_) {
        if (p_56429_.isClient) {
            return ActionResult.SUCCESS;
        } else {
            p_56431_.openHandledScreen(p_56428_.createScreenHandlerFactory(p_56429_, p_56430_));
            p_56431_.incrementStat(Stats.INTERACT_WITH_SMITHING_TABLE);
            return ActionResult.CONSUME;
        }
    }

    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World level, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((i, inv, player) -> new WeaponfusionMenu(i, inv, ScreenHandlerContext.create(level, pos)), CONTAINER_TITLE);
    }


    public VoxelShape getOutlineShape(BlockState p_48816_, BlockView p_48817_, BlockPos p_48818_, ShapeContext p_48819_) {
        Direction direction = p_48816_.get(FACING);
        return direction.getAxis() == Direction.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
    }

    public BlockState rotate(BlockState p_48811_, BlockRotation p_48812_) {
        return p_48811_.with(FACING, p_48812_.rotate(p_48811_.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> p_48814_) {
        p_48814_.add(FACING);
    }

    public boolean canPathfindThrough(BlockState p_48799_, BlockView p_48800_, BlockPos p_48801_, NavigationType p_48802_) {
        return false;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new Mechanical_fusion_Anvil_Block_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return checkType(p_152182_, ModTileentites.MECHANICAL_FUSION_ANVIL, Mechanical_fusion_Anvil_Block_Entity::commonTick);
    }
}
