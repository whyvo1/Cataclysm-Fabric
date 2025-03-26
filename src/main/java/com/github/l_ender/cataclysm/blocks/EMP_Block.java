package com.github.l_ender.cataclysm.blocks;

import com.github.l_ender.cataclysm.client.particle.LightningParticle;

import com.github.l_ender.cataclysm.init.ModTileentites;
import com.github.l_ender.cataclysm.blockentities.EMP_Block_Entity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EMP_Block extends BlockWithEntity {
    public static final DirectionProperty TIP_DIRECTION = Properties.VERTICAL_DIRECTION;
    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final BooleanProperty OVERLOAD = BooleanProperty.of("overload");

    public EMP_Block() {
        super(Settings.create()
                .nonOpaque()
                .luminance((block) -> 7)
                .dropsNothing()
                .emissiveLighting((block, world, pos) -> true)
                .strength(-1.0F, 3600000.0F)
                .sounds(BlockSoundGroup.METAL));
        this.setDefaultState(this.stateManager.getDefaultState().with(TIP_DIRECTION, Direction.UP).with(POWERED, false).with(OVERLOAD, false));
    }


    public void neighborUpdate(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if(!worldIn.isClient){
            this.updateState(state, worldIn, pos, blockIn);
        }
    }

    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if(!worldIn.isClient){
            this.updateState(state, worldIn, pos, state.getBlock());
        }
    }

    public void updateState(BlockState state, World worldIn, BlockPos pos, Block blockIn) {
        boolean flag = state.get(POWERED);
        boolean flag1 = worldIn.isReceivingRedstonePower(pos);

        if (flag1 != flag) {
            worldIn.setBlockState(pos, state.with(POWERED, flag1), 3);
            worldIn.updateNeighborsAlways(pos.down(), this);
        }
    }

    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(TIP_DIRECTION, context.getVerticalPlayerLookDirection().getOpposite()).with(POWERED, context.getWorld().isReceivingRedstonePower(context.getBlockPos())).with(OVERLOAD, false);
    }


    public void randomDisplayTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        Direction direction = Direction.random(rand);
        double d0 = 0.5625D;
        double d = (rand.nextFloat() - 0.5F);
        if (direction != Direction.UP) {
            BlockPos blockpos = pos.offset(direction);
            BlockState blockstate = worldIn.getBlockState(blockpos);
            if (!stateIn.isOpaque() || !blockstate.isSideSolidFullSquare(worldIn, blockpos, direction.getOpposite())) {
                Direction.Axis direction$axis = direction.getAxis();
                double d1 = direction$axis == Direction.Axis.X ? 0.5D + d0 * (double)direction.getOffsetX() : (double)rand.nextFloat();
                double d3 = direction$axis == Direction.Axis.Z ? 0.5D + d0 * (double)direction.getOffsetZ() : (double)rand.nextFloat();
                if (stateIn.get(OVERLOAD)) {
                    for (int i1 = 0; i1 < 20; i1++) {
                        worldIn.addParticle(DustParticleEffect.DEFAULT, (double) pos.getX() + d1, (double) pos.getY() + 0.75D, (double) pos.getZ() + d3, 0, 0, 0);
                    }
                }else{
                    worldIn.addParticle((new LightningParticle.OrbData(255, 51,  0)), (double) pos.getX() + 0.5D, (double) pos.getY() + 0.75D, (double) pos.getZ() + 0.5D, d * 2.0D, d, d * 2.0D);
                }
            }
        }
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new EMP_Block_Entity(pos, state);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TIP_DIRECTION,POWERED,OVERLOAD);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return checkType(p_152182_, ModTileentites.EMP, EMP_Block_Entity::commonTick);
    }
}
