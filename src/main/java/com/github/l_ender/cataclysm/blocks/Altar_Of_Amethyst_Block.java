package com.github.l_ender.cataclysm.blocks;


import com.github.l_ender.cataclysm.crafting.AltarOfAmethystRecipe;
import com.github.l_ender.cataclysm.init.ModTileentites;
import com.github.l_ender.cataclysm.blockentities.AltarOfAmethyst_Block_Entity;
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
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
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
import java.util.Optional;

public class Altar_Of_Amethyst_Block extends BlockWithEntity {
    public static final MapCodec<Altar_Of_Amethyst_Block> CODEC = createCodec(Altar_Of_Amethyst_Block::new);
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final VoxelShape BASE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D);
    private static final VoxelShape MID = Block.createCuboidShape(2.0D, 3.0D, 2.0D, 14.0D, 13.0D, 14.0D);
    private static final VoxelShape TOP = Block.createCuboidShape(0.0D, 13.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape AXIS_AABB = VoxelShapes.union(BASE,MID, TOP);

    @Override
    public MapCodec<Altar_Of_Amethyst_Block> getCodec() {
        return CODEC;
    }

    public Altar_Of_Amethyst_Block(AbstractBlock.Settings p_54257_) {
        super(p_54257_);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    public BlockState getPlacementState(ItemPlacementContext p_48781_) {
        return this.getDefaultState().with(FACING, p_48781_.getHorizontalPlayerFacing().rotateYClockwise());
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack p_316347_, BlockState p_51274_, World p_51275_, BlockPos p_51276_, PlayerEntity p_51277_, Hand p_51278_, BlockHitResult p_51279_) {
        if (p_51275_.getBlockEntity(p_51276_) instanceof AltarOfAmethyst_Block_Entity campfireblockentity) {
            ItemStack itemstack = p_51277_.getStackInHand(p_51278_);
            Optional<RecipeEntry<AltarOfAmethystRecipe>> optional = campfireblockentity.getCookableRecipe(itemstack);
            if (optional.isPresent()) {
                if (campfireblockentity.placeFood(p_51277_, itemstack, optional.get().value().getTime())) {
                    p_51277_.incrementStat(Stats.INTERACT_WITH_CAMPFIRE);
                    return ItemActionResult.SUCCESS;
                }

                return ItemActionResult.CONSUME;
            }
        }

        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }



    public BlockState rotate(BlockState p_48811_, BlockRotation p_48812_) {
        return p_48811_.with(FACING, p_48812_.rotate(p_48811_.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> p_48814_) {
        p_48814_.add(FACING);
    }

    public VoxelShape getOutlineShape(BlockState p_48816_, BlockView p_48817_, BlockPos p_48818_, ShapeContext p_48819_) {
        return AXIS_AABB;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AltarOfAmethyst_Block_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return validateTicker(p_152182_, ModTileentites.ALTAR_OF_AMETHYST, AltarOfAmethyst_Block_Entity::cookTick);
    }

}