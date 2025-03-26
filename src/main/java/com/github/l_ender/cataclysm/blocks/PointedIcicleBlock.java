package com.github.l_ender.cataclysm.blocks;

import com.github.l_ender.cataclysm.init.ModBlocks;
import com.google.common.annotations.VisibleForTesting;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LandingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.enums.Thickness;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PointedIcicleBlock extends Block implements LandingBlock, Waterloggable {
    public static final DirectionProperty TIP_DIRECTION = Properties.VERTICAL_DIRECTION;
    public static final EnumProperty<Thickness> THICKNESS = Properties.THICKNESS;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private static final int MAX_SEARCH_LENGTH_WHEN_CHECKING_DRIP_TYPE = 11;
    private static final int DELAY_BEFORE_FALLING = 2;
    private static final float DRIP_PROBABILITY_PER_ANIMATE_TICK = 0.02F;
    private static final float DRIP_PROBABILITY_PER_ANIMATE_TICK_IF_UNDER_LIQUID_SOURCE = 0.12F;
    private static final int MAX_SEARCH_LENGTH_BETWEEN_STALACTITE_TIP_AND_CAULDRON = 11;
    private static final float WATER_TRANSFER_PROBABILITY_PER_RANDOM_TICK = 0.17578125F;
    private static final float LAVA_TRANSFER_PROBABILITY_PER_RANDOM_TICK = 0.05859375F;
    private static final double MIN_TRIDENT_VELOCITY_TO_BREAK_DRIPSTONE = 0.6D;
    private static final float STALACTITE_DAMAGE_PER_FALL_DISTANCE_AND_SIZE = 1.0F;
    private static final int STALACTITE_MAX_DAMAGE = 40;
    private static final int MAX_STALACTITE_HEIGHT_FOR_DAMAGE_CALCULATION = 6;
    private static final float STALAGMITE_FALL_DISTANCE_OFFSET = 2.0F;
    private static final int STALAGMITE_FALL_DAMAGE_MODIFIER = 2;
    private static final float AVERAGE_DAYS_PER_GROWTH = 5.0F;
    private static final float GROWTH_PROBABILITY_PER_RANDOM_TICK = 0.011377778F;
    private static final int MAX_GROWTH_LENGTH = 7;
    private static final int MAX_STALAGMITE_SEARCH_RANGE_WHEN_GROWING = 10;
    private static final float STALACTITE_DRIP_START_PIXEL = 0.6875F;
    private static final VoxelShape TIP_MERGE_SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    private static final VoxelShape TIP_SHAPE_UP = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D);
    private static final VoxelShape TIP_SHAPE_DOWN = Block.createCuboidShape(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    private static final VoxelShape FRUSTUM_SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    private static final VoxelShape MIDDLE_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    private static final VoxelShape BASE_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    private static final float MAX_HORIZONTAL_OFFSET = 0.125F;
    private static final VoxelShape REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK = Block.createCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);

    public PointedIcicleBlock(Settings p_154025_) {
        super(p_154025_);
        this.setDefaultState(this.stateManager.getDefaultState().with(TIP_DIRECTION, Direction.UP).with(THICKNESS, Thickness.TIP).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> p_154157_) {
        p_154157_.add(TIP_DIRECTION, THICKNESS, WATERLOGGED);
    }

    public boolean canPlaceAt(BlockState p_154137_, WorldView p_154138_, BlockPos p_154139_) {
        return isValidPointedIciclePlacement(p_154138_, p_154139_, p_154137_.get(TIP_DIRECTION));
    }

    public BlockState getStateForNeighborUpdate(BlockState p_154147_, Direction p_154148_, BlockState p_154149_, WorldAccess p_154150_, BlockPos p_154151_, BlockPos p_154152_) {
        if (p_154147_.get(WATERLOGGED)) {
            p_154150_.scheduleFluidTick(p_154151_, Fluids.WATER, Fluids.WATER.getTickRate(p_154150_));
        }

        if (p_154148_ != Direction.UP && p_154148_ != Direction.DOWN) {
            return p_154147_;
        } else {
            Direction direction = p_154147_.get(TIP_DIRECTION);
            if (direction == Direction.DOWN && p_154150_.getBlockTickScheduler().isQueued(p_154151_, this)) {
                return p_154147_;
            } else if (p_154148_ == direction.getOpposite() && !this.canPlaceAt(p_154147_, p_154150_, p_154151_)) {
                if (direction == Direction.DOWN) {
                    p_154150_.scheduleBlockTick(p_154151_, this, 2);
                } else {
                    p_154150_.scheduleBlockTick(p_154151_, this, 1);
                }

                return p_154147_;
            } else {
                boolean flag = p_154147_.get(THICKNESS) == Thickness.TIP_MERGE;
                Thickness dripstonethickness = calculateDripstoneThickness(p_154150_, p_154151_, direction, flag);
                return p_154147_.with(THICKNESS, dripstonethickness);
            }
        }
    }

    public void onProjectileHit(World p_154042_, BlockState p_154043_, BlockHitResult p_154044_, ProjectileEntity p_154045_) {
        BlockPos blockpos = p_154044_.getBlockPos();
        if (!p_154042_.isClient && p_154045_.canModifyAt(p_154042_, blockpos) && p_154045_ instanceof TridentEntity && p_154045_.getVelocity().length() > 0.6D) {
            p_154042_.breakBlock(blockpos, true);
        }

    }

    public void onLandedUpon(World p_154047_, BlockState p_154048_, BlockPos p_154049_, Entity p_154050_, float p_154051_) {
        if (p_154048_.get(TIP_DIRECTION) == Direction.UP && p_154048_.get(THICKNESS) == Thickness.TIP) {
            p_154050_.handleFallDamage(p_154051_ + 2.0F, 2.0F, p_154047_.getDamageSources().stalagmite());
        } else {
            super.onLandedUpon(p_154047_, p_154048_, p_154049_, p_154050_, p_154051_);
        }

    }

    public void scheduledTick(BlockState p_221865_, ServerWorld p_221866_, BlockPos p_221867_, Random p_221868_) {
        if (isStalagmite(p_221865_) && !this.canPlaceAt(p_221865_, p_221866_, p_221867_)) {
            p_221866_.breakBlock(p_221867_, true);
        } else {
            spawnFallingStalactite(p_221865_, p_221866_, p_221867_);
        }

    }

    public void randomTick(BlockState p_221883_, ServerWorld p_221884_, BlockPos p_221885_, Random p_221886_) {
        if (p_221886_.nextFloat() < 0.011377778F && isStalactiteStartPos(p_221883_, p_221884_, p_221885_)) {
            growStalactiteOrStalagmiteIfPossible(p_221883_, p_221884_, p_221885_, p_221886_);
        }

    }


    @Nullable
    public BlockState getPlacementState(ItemPlacementContext p_154040_) {
        WorldAccess levelaccessor = p_154040_.getWorld();
        BlockPos blockpos = p_154040_.getBlockPos();
        Direction direction = p_154040_.getVerticalPlayerLookDirection().getOpposite();
        Direction direction1 = calculateTipDirection(levelaccessor, blockpos, direction);
        if (direction1 == null) {
            return null;
        } else {
            boolean flag = !p_154040_.shouldCancelInteraction();
            Thickness dripstonethickness = calculateDripstoneThickness(levelaccessor, blockpos, direction1, flag);
            return dripstonethickness == null ? null : this.getDefaultState().with(TIP_DIRECTION, direction1).with(THICKNESS, dripstonethickness).with(WATERLOGGED, Boolean.valueOf(levelaccessor.getFluidState(blockpos).getFluid() == Fluids.WATER));
        }
    }

    public FluidState getFluidState(BlockState p_154235_) {
        return p_154235_.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(p_154235_);
    }

    public VoxelShape getCullingShape(BlockState p_154170_, BlockView p_154171_, BlockPos p_154172_) {
        return VoxelShapes.empty();
    }

    public VoxelShape getOutlineShape(BlockState p_154117_, BlockView p_154118_, BlockPos p_154119_, ShapeContext p_154120_) {
        Thickness dripstonethickness = p_154117_.get(THICKNESS);
        VoxelShape voxelshape;
        if (dripstonethickness == Thickness.TIP_MERGE) {
            voxelshape = TIP_MERGE_SHAPE;
        } else if (dripstonethickness == Thickness.TIP) {
            if (p_154117_.get(TIP_DIRECTION) == Direction.DOWN) {
                voxelshape = TIP_SHAPE_DOWN;
            } else {
                voxelshape = TIP_SHAPE_UP;
            }
        } else if (dripstonethickness == Thickness.FRUSTUM) {
            voxelshape = FRUSTUM_SHAPE;
        } else if (dripstonethickness == Thickness.MIDDLE) {
            voxelshape = MIDDLE_SHAPE;
        } else {
            voxelshape = BASE_SHAPE;
        }

        Vec3d vec3 = p_154117_.getModelOffset(p_154118_, p_154119_);
        return voxelshape.offset(vec3.x, 0.0D, vec3.z);
    }

    public boolean isShapeFullCube(BlockState p_181235_, BlockView p_181236_, BlockPos p_181237_) {
        return false;
    }

    public float getMaxHorizontalModelOffset() {
        return 0.125F;
    }

    public void onDestroyedOnLanding(World p_154059_, BlockPos p_154060_, FallingBlockEntity p_154061_) {
        if (!p_154061_.isSilent()) {
            p_154059_.syncWorldEvent(1045, p_154060_, 0);
        }

    }

    public DamageSource getDamageSource(Entity p_254432_) {
        return p_254432_.getDamageSources().fallingStalactite(p_254432_);
    }

    private static void spawnFallingStalactite(BlockState p_154098_, ServerWorld p_154099_, BlockPos p_154100_) {
        BlockPos.Mutable blockpos$mutableblockpos = p_154100_.mutableCopy();

        for(BlockState blockstate = p_154098_; isStalactite(blockstate); blockstate = p_154099_.getBlockState(blockpos$mutableblockpos)) {
            FallingBlockEntity fallingblockentity = FallingBlockEntity.spawnFromBlock(p_154099_, blockpos$mutableblockpos, blockstate);
            if (isTip(blockstate, true)) {
                int i = Math.max(1 + p_154100_.getY() - blockpos$mutableblockpos.getY(), 6);
                float f = 1.0F * (float)i;
                fallingblockentity.setHurtEntities(f, 40);
                break;
            }

            blockpos$mutableblockpos.move(Direction.DOWN);
        }

    }

    @VisibleForTesting
    public static void growStalactiteOrStalagmiteIfPossible(BlockState p_221888_, ServerWorld p_221889_, BlockPos p_221890_, Random p_221891_) {
        BlockState blockstate = p_221889_.getBlockState(p_221890_.up(1));
        if (canGrow(blockstate)) {
            BlockPos blockpos = findTip(p_221888_, p_221889_, p_221890_, 7, false);
            if (blockpos != null) {
                BlockState blockstate2 = p_221889_.getBlockState(blockpos);
                if (canDrip(blockstate2) && canTipGrow(blockstate2, p_221889_, blockpos)) {
                    if (p_221891_.nextBoolean()) {
                        grow(p_221889_, blockpos, Direction.DOWN);
                    } else {
                        growStalagmiteBelow(p_221889_, blockpos);
                    }

                }
            }
        }
    }

    private static void growStalagmiteBelow(ServerWorld p_154033_, BlockPos p_154034_) {
        BlockPos.Mutable blockpos$mutableblockpos = p_154034_.mutableCopy();

        for(int i = 0; i < 10; ++i) {
            blockpos$mutableblockpos.move(Direction.DOWN);
            BlockState blockstate = p_154033_.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.getFluidState().isEmpty()) {
                return;
            }

            if (isUnmergedTipWithDirection(blockstate, Direction.UP) && canTipGrow(blockstate, p_154033_, blockpos$mutableblockpos)) {
                grow(p_154033_, blockpos$mutableblockpos, Direction.UP);
                return;
            }

            if (isValidPointedIciclePlacement(p_154033_, blockpos$mutableblockpos, Direction.UP) && !p_154033_.isWater(blockpos$mutableblockpos.down())) {
                grow(p_154033_, blockpos$mutableblockpos.down(), Direction.UP);
                return;
            }

            if (!canDripThrough(p_154033_, blockpos$mutableblockpos, blockstate)) {
                return;
            }
        }

    }

    private static void grow(ServerWorld p_154036_, BlockPos p_154037_, Direction p_154038_) {
        BlockPos blockpos = p_154037_.offset(p_154038_);
        BlockState blockstate = p_154036_.getBlockState(blockpos);
        if (isUnmergedTipWithDirection(blockstate, p_154038_.getOpposite())) {
            createMergedTips(blockstate, p_154036_, blockpos);
        } else if (blockstate.isAir() || blockstate.isOf(Blocks.WATER)) {
            createDripstone(p_154036_, blockpos, p_154038_, Thickness.TIP);
        }

    }

    private static void createDripstone(WorldAccess p_154088_, BlockPos p_154089_, Direction p_154090_, Thickness p_154091_) {
        BlockState blockstate = ModBlocks.POINTED_ICICLE.getDefaultState().with(TIP_DIRECTION, p_154090_).with(THICKNESS, p_154091_).with(WATERLOGGED, p_154088_.getFluidState(p_154089_).getFluid() == Fluids.WATER);
        p_154088_.setBlockState(p_154089_, blockstate, 3);
    }

    private static void createMergedTips(BlockState p_154231_, WorldAccess p_154232_, BlockPos p_154233_) {
        BlockPos blockpos;
        BlockPos blockpos1;
        if (p_154231_.get(TIP_DIRECTION) == Direction.UP) {
            blockpos1 = p_154233_;
            blockpos = p_154233_.up();
        } else {
            blockpos = p_154233_;
            blockpos1 = p_154233_.down();
        }

        createDripstone(p_154232_, blockpos, Direction.DOWN, Thickness.TIP_MERGE);
        createDripstone(p_154232_, blockpos1, Direction.UP, Thickness.TIP_MERGE);
    }


    @Nullable
    private static BlockPos findTip(BlockState p_154131_, WorldAccess p_154132_, BlockPos p_154133_, int p_154134_, boolean p_154135_) {
        if (isTip(p_154131_, p_154135_)) {
            return p_154133_;
        } else {
            Direction direction = p_154131_.get(TIP_DIRECTION);
            BiPredicate<BlockPos, BlockState> bipredicate = (p_202023_, p_202024_) -> {
                return p_202024_.isOf(ModBlocks.POINTED_ICICLE) && p_202024_.get(TIP_DIRECTION) == direction;
            };
            return findBlockVertical(p_154132_, p_154133_, direction.getDirection(), bipredicate, (p_154168_) -> {
                return isTip(p_154168_, p_154135_);
            }, p_154134_).orElse((BlockPos)null);
        }
    }

    @Nullable
    private static Direction calculateTipDirection(WorldView p_154191_, BlockPos p_154192_, Direction p_154193_) {
        Direction direction;
        if (isValidPointedIciclePlacement(p_154191_, p_154192_, p_154193_)) {
            direction = p_154193_;
        } else {
            if (!isValidPointedIciclePlacement(p_154191_, p_154192_, p_154193_.getOpposite())) {
                return null;
            }

            direction = p_154193_.getOpposite();
        }

        return direction;
    }

    private static Thickness calculateDripstoneThickness(WorldView p_154093_, BlockPos p_154094_, Direction p_154095_, boolean p_154096_) {
        Direction direction = p_154095_.getOpposite();
        BlockState blockstate = p_154093_.getBlockState(p_154094_.offset(p_154095_));
        if (isPointedDripstoneWithDirection(blockstate, direction)) {
            return !p_154096_ && blockstate.get(THICKNESS) != Thickness.TIP_MERGE ? Thickness.TIP : Thickness.TIP_MERGE;
        } else if (!isPointedDripstoneWithDirection(blockstate, p_154095_)) {
            return Thickness.TIP;
        } else {
            Thickness dripstonethickness = blockstate.get(THICKNESS);
            if (dripstonethickness != Thickness.TIP && dripstonethickness != Thickness.TIP_MERGE) {
                BlockState blockstate1 = p_154093_.getBlockState(p_154094_.offset(direction));
                return !isPointedDripstoneWithDirection(blockstate1, p_154095_) ? Thickness.BASE : Thickness.MIDDLE;
            } else {
                return Thickness.FRUSTUM;
            }
        }
    }

    public static boolean canDrip(BlockState p_154239_) {
        return isStalactite(p_154239_) && p_154239_.get(THICKNESS) == Thickness.TIP && !p_154239_.get(WATERLOGGED);
    }

    private static boolean canTipGrow(BlockState p_154195_, ServerWorld p_154196_, BlockPos p_154197_) {
        Direction direction = p_154195_.get(TIP_DIRECTION);
        BlockPos blockpos = p_154197_.offset(direction);
        BlockState blockstate = p_154196_.getBlockState(blockpos);
        if (!blockstate.getFluidState().isEmpty()) {
            return false;
        } else {
            return blockstate.isAir() ? true : isUnmergedTipWithDirection(blockstate, direction.getOpposite());
        }
    }

    private static Optional<BlockPos> findRootBlock(World p_154067_, BlockPos p_154068_, BlockState p_154069_, int p_154070_) {
        Direction direction = p_154069_.get(TIP_DIRECTION);
        BiPredicate<BlockPos, BlockState> bipredicate = (p_202015_, p_202016_) -> {
            return p_202016_.isOf(ModBlocks.POINTED_ICICLE) && p_202016_.get(TIP_DIRECTION) == direction;
        };
        return findBlockVertical(p_154067_, p_154068_, direction.getOpposite().getDirection(), bipredicate, (p_154245_) -> {
            return !p_154245_.isOf(ModBlocks.POINTED_ICICLE);
        }, p_154070_);
    }

    private static boolean isValidPointedIciclePlacement(WorldView p_154222_, BlockPos p_154223_, Direction p_154224_) {
        BlockPos blockpos = p_154223_.offset(p_154224_.getOpposite());
        BlockState blockstate = p_154222_.getBlockState(blockpos);
        return blockstate.isSideSolidFullSquare(p_154222_, blockpos, p_154224_) || isPointedDripstoneWithDirection(blockstate, p_154224_);
    }

    private static boolean isTip(BlockState p_154154_, boolean p_154155_) {
        if (!p_154154_.isOf(ModBlocks.POINTED_ICICLE)) {
            return false;
        } else {
            Thickness dripstonethickness = p_154154_.get(THICKNESS);
            return dripstonethickness == Thickness.TIP || p_154155_ && dripstonethickness == Thickness.TIP_MERGE;
        }
    }

    private static boolean isUnmergedTipWithDirection(BlockState p_154144_, Direction p_154145_) {
        return isTip(p_154144_, false) && p_154144_.get(TIP_DIRECTION) == p_154145_;
    }

    private static boolean isStalactite(BlockState p_154241_) {
        return isPointedDripstoneWithDirection(p_154241_, Direction.DOWN);
    }

    private static boolean isStalagmite(BlockState p_154243_) {
        return isPointedDripstoneWithDirection(p_154243_, Direction.UP);
    }

    private static boolean isStalactiteStartPos(BlockState p_154204_, WorldView p_154205_, BlockPos p_154206_) {
        return isStalactite(p_154204_) && !p_154205_.getBlockState(p_154206_.up()).isOf(ModBlocks.POINTED_ICICLE);
    }

    public boolean isPathfindable(BlockState p_154112_, BlockView p_154113_, BlockPos p_154114_, NavigationType p_154115_) {
        return false;
    }

    private static boolean isPointedDripstoneWithDirection(BlockState p_154208_, Direction p_154209_) {
        return p_154208_.isOf(ModBlocks.POINTED_ICICLE) && p_154208_.get(TIP_DIRECTION) == p_154209_;
    }


    private static boolean canGrow(BlockState p_154141_) {
        return p_154141_.isIn(BlockTags.ICE);
    }

    private static Optional<BlockPos> findBlockVertical(WorldAccess p_202007_, BlockPos p_202008_, Direction.AxisDirection p_202009_, BiPredicate<BlockPos, BlockState> p_202010_, Predicate<BlockState> p_202011_, int p_202012_) {
        Direction direction = Direction.get(p_202009_, Direction.Axis.Y);
        BlockPos.Mutable blockpos$mutableblockpos = p_202008_.mutableCopy();

        for(int i = 1; i < p_202012_; ++i) {
            blockpos$mutableblockpos.move(direction);
            BlockState blockstate = p_202007_.getBlockState(blockpos$mutableblockpos);
            if (p_202011_.test(blockstate)) {
                return Optional.of(blockpos$mutableblockpos.toImmutable());
            }

            if (p_202007_.isOutOfHeightLimit(blockpos$mutableblockpos.getY()) || !p_202010_.test(blockpos$mutableblockpos, blockstate)) {
                return Optional.empty();
            }
        }

        return Optional.empty();
    }

    private static boolean canDripThrough(BlockView p_202018_, BlockPos p_202019_, BlockState p_202020_) {
        if (p_202020_.isAir()) {
            return true;
        } else if (p_202020_.isOpaqueFullCube(p_202018_, p_202019_)) {
            return false;
        } else if (!p_202020_.getFluidState().isEmpty()) {
            return false;
        } else {
            VoxelShape voxelshape = p_202020_.getCollisionShape(p_202018_, p_202019_);
            return !VoxelShapes.matchesAnywhere(REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK, voxelshape, BooleanBiFunction.AND);
        }
    }
}